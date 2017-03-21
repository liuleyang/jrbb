/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboSakuseiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 準備データです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class CreateMeiboTableProcess extends BatchProcessBase<MeiboSakuseiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select宛名識別対象");

    private AFABTK101SelectProcessParameter processParameter;

    private MeiboSakuseiKaikuMybatisParameter mybatisParameter;

    private RString コンフィグの選挙資格到達年齢;

    private FlexibleDate 出年月日;
    private OutputParameter<RString> outTempAFABTK101;

    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempAFABTK101");
    }

    private static final RString TEMP_TABLE_NAME = new RString("TempAFABTK101");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {

        コンフィグの選挙資格到達年齢 = BusinessConfig.get(
                ConfigKeysAFA.選挙資格到達年齢_海区選挙, SubGyomuCode.AFA選挙本体);
        mybatisParameter = processParameter.toMeiboSakuseiKaikuMybatisParameter();
        出年月日 = processParameter.get年齢到達日().minusYear(Integer.valueOf(コンフィグの選挙資格到達年齢.toString()));
        mybatisParameter.set年度(new RYear(processParameter.get基準日().minusYear(1).getYear().toDateString()));
        mybatisParameter.set出年月日(出年月日);
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        mybatisParameter.set処理種別(processParameter.get処理種別());
    }

    @Override
    protected void beforeExecute() {
        outTempAFABTK101 = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, AFABTK101tempTblEntity.class);
    }

    @Override
    protected void process(MeiboSakuseiKaikuEntity entity) {
        tempDbWriter.insert(create一時テーブル(entity));

    }

    @Override
    protected void afterExecute() {
        outTempAFABTK101.setValue(TEMP_TABLE_NAME);
    }

    private AFABTK101tempTblEntity create一時テーブル(MeiboSakuseiKaikuEntity entity) {
        AFABTK101tempTblEntity tempTable = new AFABTK101tempTblEntity();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = entity.getUaFt200Entity();

        insertPSMdataTotempTable(tempTable, uaFt200Entity);

        tempTable.setTohyokuCodeAdd(getTohyokuCode(entity));
        tempTable.setSatsu(getSatsu(entity));
        tempTable.setGroupCode(getGroupCode(entity));
        tempTable.setSeq(entity.getAfT112SenkyoninMeibEntity().getSeq());
        tempTable.setShohonName(entity.getAfT100Entity().getShohonName());
        tempTable.setSenkyoNo(entity.getAfT111SenkyoEntity().getSenkyoNo());

        copyKaikuSenkyoFuzuiDataToTempTbl(entity, tempTable);

        return tempTable;

    }

    private RString getGroupCode(MeiboSakuseiKaikuEntity meiboEntity) {
        if (meiboEntity.getAfT112SenkyoninMeibEntity() != null) {
            return meiboEntity.getAfT112SenkyoninMeibEntity().getGroupCode();
        } else {
            return new RString("0");
        }
    }

    private RString getTohyokuCode(MeiboSakuseiKaikuEntity meiboEntity) {
        if (meiboEntity.getAfT113Entity() != null) {
            return meiboEntity.getAfT113Entity().getTohyokuCode();
        }

        return RString.EMPTY;
    }

    private RString getSatsu(MeiboSakuseiKaikuEntity entity) {
        if (entity.getAfT112SenkyoninMeibEntity() != null) {
            return entity.getAfT112SenkyoninMeibEntity().getSatsu();
        } else {
            return new RString("00");
        }
    }

    private void insertPSMdataTotempTable(AFABTK101tempTblEntity tempTable, UaFt200FindShikibetsuTaishoEntity uaFt200Entity) {
        tempTable.setShikibetsuCode(uaFt200Entity.getShikibetsuCode());
        tempTable.setGenLasdecCode(uaFt200Entity.getGenLasdecCode());
        tempTable.setKyuLasdecCode(uaFt200Entity.getKyuLasdecCode());
        tempTable.setKyuLasdecCodeRenban(uaFt200Entity.getKyuLasdecCodeRenban());
        tempTable.setGyomuCode(uaFt200Entity.getGyomuCode());
        tempTable.setRirekiNo(uaFt200Entity.getRirekiNo());
        tempTable.setCurrentFlag(uaFt200Entity.getCurrentFlag());
        tempTable.setJuminJotaiCode(uaFt200Entity.getJuminShubetsuCode());
        tempTable.setKojinNo(uaFt200Entity.getKojinNo());
        tempTable.setHojinNo(uaFt200Entity.getHojinNo());
        tempTable.setShoriYMD(uaFt200Entity.getShoriYMD());
        tempTable.setIdoJiyuCode(uaFt200Entity.getIdoJiyuCode());
        tempTable.setIdoYMD(uaFt200Entity.getIdoYMD());
        tempTable.setTodokedeJiyuCode(uaFt200Entity.getTodokedeJiyuCode());
        tempTable.setTodokedeYMD(uaFt200Entity.getTodokedeYMD());
        tempTable.setIdoRiyuCode(uaFt200Entity.getIdoRiyuCode());
        tempTable.setMeisho(uaFt200Entity.getMeisho());
        tempTable.setKanaMeisho(uaFt200Entity.getKanaMeisho());
        tempTable.setKannaiKangaiKubun(uaFt200Entity.getKannaiKangaiKubun());
        tempTable.setYubinNo(uaFt200Entity.getYubinNo());

        tempTable.setChoikiCode(uaFt200Entity.getChoikiCode());
        tempTable.setZenkokuJushoCode(uaFt200Entity.getZenkokuJushoCode());
        tempTable.setJusho(uaFt200Entity.getJusho());
        tempTable.setBanchiCode1(uaFt200Entity.getBanchiCode1());
        tempTable.setBanchiCode2(uaFt200Entity.getBanchiCode2());
        tempTable.setBanchiCode3(uaFt200Entity.getBanchiCode3());
        tempTable.setBanchiCode4(uaFt200Entity.getBanchiCode4());
        tempTable.setBanchi(uaFt200Entity.getBanchi());

        tempTable.setKatagaki(uaFt200Entity.getKatagaki());

        tempTable.setKatagakiInjiFlag(uaFt200Entity.getKatagakiInjiFlag());

        tempTable.setGyoseikuCode(uaFt200Entity.getGyoseikuCode());

        tempTable.setGyoseikuName(uaFt200Entity.getGyoseikuName());

        tempTable.setChikuCode1(uaFt200Entity.getChikuCode1());
        tempTable.setChikuCode2(uaFt200Entity.getChikuCode2());
        tempTable.setChikuCode3(uaFt200Entity.getChikuCode3());

        tempTable.setChikuName1(uaFt200Entity.getChikuName1());
        tempTable.setChikuName2(uaFt200Entity.getChikuName2());
        tempTable.setChikuName3(uaFt200Entity.getChikuName3());

        tempTable.setShogakkokuCode(uaFt200Entity.getShogakkokuCode());
        tempTable.setShogakkokuName(uaFt200Entity.getShogakkokuName());

        tempTable.setChugakkokuCode(uaFt200Entity.getChugakkokuCode());

        tempTable.setChugakkokuName(uaFt200Entity.getChugakkokuName());

        tempTable.setTohyokuCode(uaFt200Entity.getTohyokuCode());
        tempTable.setTohyokuName(uaFt200Entity.getTohyokuName());
        tempTable.setJuminJotaiCode(uaFt200Entity.getJuminJotaiCode());
        tempTable.setSetaiCode(uaFt200Entity.getSetaiCode());
        tempTable.setSeinengappiYMD(uaFt200Entity.getSeinengappiYMD());
        tempTable.setSeinengappiFushoKubun(uaFt200Entity.getSeinengappiFushoKubun());
        tempTable.setSeibetsuCode(uaFt200Entity.getSeibetsuCode());

        tempTable.setTsuzukigaraCode(uaFt200Entity.getTsuzukigaraCode());
        tempTable.setTsuzukigara(uaFt200Entity.getTsuzukigara());

        tempTable.setKazokuNo(uaFt200Entity.getKazokuNo());

        tempTable.setJuminhyoHyojijun(uaFt200Entity.getJuminhyoHyojijun());

        tempTable.setKikaYMD(uaFt200Entity.getKikaYMD());

        tempTable.setKanjiShimei(uaFt200Entity.getKanjiShimei());

        tempTable.setKanaShimei(uaFt200Entity.getKanaShimei());

        tempTable.setHonsekiZenkokuJushoCode(uaFt200Entity.getHonsekiZenkokuJushoCode());
        tempTable.setHonsekiChoikiCode(uaFt200Entity.getHonsekiChoikiCode());

        tempTable.setHonsekiJusho(uaFt200Entity.getHonsekiJusho());

        tempTable.setHonsekiBanchi(uaFt200Entity.getHonsekiBanchi());

        tempTable.setHittosha(uaFt200Entity.getHittosha());

        tempTable.setGaikokujinShimei(uaFt200Entity.getGaikokujinShimei());
        tempTable.setGaikokujinHeikimei(uaFt200Entity.getGaikokujinHeikimei());
        tempTable.setGaikokujinKanaShimei(uaFt200Entity.getGaikokujinKanaShimei());

        tempTable.setTsushomei(uaFt200Entity.getTsushomei());

        tempTable.setShimeiRiyoKubun(uaFt200Entity.getShimeiRiyoKubun());
        tempTable.setKanaTsushomei(uaFt200Entity.getKanaTsushomei());

        tempTable.setKatakanaHyoki(uaFt200Entity.getKatakanaHyoki());
        tempTable.setKokusekiChiikiCode(uaFt200Entity.getKokusekiChiikiCode());

        tempTable.setZairyuShikakuCode(uaFt200Entity.getZairyuShikakuCode());
        tempTable.setZairyuKikanCode(uaFt200Entity.getZairyuKikanCode());
        tempTable.setZairyuKikantoManryoYMD(uaFt200Entity.getZairyuKikantoManryoYMD());

        tempTable.setZairyuCardtoNo(uaFt200Entity.getZairyuCardtoNo());
        tempTable.setZairyuCardtoYukoYMD(uaFt200Entity.getZairyuCardtoYukoYMD());
        tempTable.setDai30Jono45niKiteisuruKubun(uaFt200Entity.getDai30Jono45niKiteisuruKubun());

        tempTable.setSetainushiShikibetsuCode(uaFt200Entity.getSetainushiShikibetsuCode());
        tempTable.setSetainushiMei(uaFt200Entity.getSetainushiMei());
        tempTable.setHojinKeitaiCode(uaFt200Entity.getHojinKeitaiCode());
        tempTable.setHojinKeitaiMeisho(uaFt200Entity.getHojinKeitaiMeisho());
        tempTable.setHojinKeitaiRyakusho(uaFt200Entity.getHojinKeitaiRyakusho());

        tempTable.setHojinMeishoHenshuKubun(uaFt200Entity.getHojinMeishoHenshuKubun());
        tempTable.setHojinKeitaiRyakushoKubun(uaFt200Entity.getHojinKeitaiRyakushoKubun());
        tempTable.setHojinMeisho(uaFt200Entity.getHojinMeisho());
        tempTable.setHojinKanaMeisho(uaFt200Entity.getHojinKanaMeisho());
        tempTable.setHojinShitenMeisho(uaFt200Entity.getHojinShitenMeisho());

        tempTable.setHojinShitenKanaMeisho(uaFt200Entity.getHojinShitenKanaMeisho());
        tempTable.setDaihyoshaShikibetsuCode(uaFt200Entity.getDaihyoshaShikibetsuCode());
        tempTable.setDaihyoshaJuminShubetsu(uaFt200Entity.getDaihyoshaJuminShubetsu());
        tempTable.setDaihyoshaShimei(uaFt200Entity.getDaihyoshaShimei());
        tempTable.setDaihyoshaKanaShimei(uaFt200Entity.getDaihyoshaKanaShimei());
        tempTable.setDaihyoshaNihonjinShimei(uaFt200Entity.getDaihyoshaNihonjinShimei());
        tempTable.setDaihyoshaNihonjinKanaShimei(uaFt200Entity.getDaihyoshaNihonjinKanaShimei());
        tempTable.setDaihyoshaGaikokujinShimei(uaFt200Entity.getDaihyoshaGaikokujinShimei());
        tempTable.setDaihyoshaGaikokujinHeikimei(uaFt200Entity.getDaihyoshaGaikokujinHeikimei());
        tempTable.setDaihyoshaGaikokujinKanaShimei(uaFt200Entity.getDaihyoshaGaikokujinKanaShimei());
        tempTable.setDaihyoshaTsushomei(uaFt200Entity.getDaihyoshaTsushomei());
        tempTable.setDaihyoshaShimeiRiyoKubun(uaFt200Entity.getDaihyoshaShimeiRiyoKubun());
        tempTable.setDaihyoshaKanaTsushomei(uaFt200Entity.getDaihyoshaKanaTsushomei());
        tempTable.setDaihyoshaKannaiKangaiKubun(uaFt200Entity.getDaihyoshaKannaiKangaiKubun());
        tempTable.setDaihyoshaYubinNo(uaFt200Entity.getDaihyoshaYubinNo());
        tempTable.setDaihyoshaChoikiCode(uaFt200Entity.getDaihyoshaChoikiCode());
        tempTable.setDaihyoshaZenkokuJushoCode(uaFt200Entity.getDaihyoshaZenkokuJushoCode());
        tempTable.setDaihyoshaJusho(uaFt200Entity.getDaihyoshaJusho());
        tempTable.setDaihyoshaBanchiCode1(uaFt200Entity.getDaihyoshaBanchiCode1());
        tempTable.setDaihyoshaBanchiCode2(uaFt200Entity.getDaihyoshaBanchiCode2());
        tempTable.setDaihyoshaBanchiCode3(uaFt200Entity.getDaihyoshaBanchiCode3());
        tempTable.setDaihyoshaBanchiCode4(uaFt200Entity.getDaihyoshaBanchiCode4());
        tempTable.setDaihyoshaBanchi(uaFt200Entity.getDaihyoshaBanchi());
        tempTable.setDaihyoshaKatagaki(uaFt200Entity.getDaihyoshaKatagaki());
        tempTable.setNinkachiendantaiTorokuShikakuKubun(uaFt200Entity.getNinkachiendantaiTorokuShikakuKubun());
        tempTable.setNinkachiendantaiNinkaYMD(uaFt200Entity.getNinkachiendantaiNinkaYMD());
        tempTable.setKojinHojinKBN(uaFt200Entity.getKojinHojinKBN());

        copyPsmDataToTempTbl(uaFt200Entity, tempTable);

    }

    private void copyPsmDataToTempTbl(UaFt200FindShikibetsuTaishoEntity fromData, AFABTK101tempTblEntity toData) {

        toData.setKyoyushaMeisho(fromData.getKyoyushaMeisho());
        toData.setKyoyushaKanaMeisho(fromData.getKyoyushaKanaMeisho());
        toData.setTorokuJiyuCode(fromData.getTorokuJiyuCode());
        toData.setTorokuIdoYMD(fromData.getTorokuIdoYMD());
        toData.setTorokuTodokedeYMD(fromData.getTorokuTodokedeYMD());
        toData.setJuteiJiyuCode(fromData.getJuteiJiyuCode());
        toData.setJuteiIdoYMD(fromData.getJuteiIdoYMD());
        toData.setJuteiTodokedeYMD(fromData.getJuteiTodokedeYMD());
        toData.setShojoJiyuCode(fromData.getShojoJiyuCode());
        toData.setShojoIdoYMD(fromData.getShojoIdoYMD());
        toData.setShojoTodokedeYMD(fromData.getShojoTodokedeYMD());
        toData.setAimaiShojobiMongon(fromData.getAimaiShojobiMongon());
        toData.setJutonaiYubinNo(fromData.getJutonaiYubinNo());
        toData.setJutonaiChoikiCode(fromData.getJutonaiChoikiCode());
        toData.setJutonaiJusho(fromData.getJutonaiJusho());
        toData.setJutonaiBanchiCode1(fromData.getJutonaiBanchiCode1());
        toData.setJutonaiBanchiCode2(fromData.getJutonaiBanchiCode2());
        toData.setJutonaiBanchiCode3(fromData.getJutonaiBanchiCode3());
        toData.setJutonaiBanchiCode4(fromData.getJutonaiBanchiCode4());
        toData.setJutonaiBanchi(fromData.getJutonaiBanchi());
        toData.setJutonaiKatagaki(fromData.getJutonaiKatagaki());
        toData.setJutonaiKatagakiInjiFlag(fromData.getJutonaiKatagakiInjiFlag());
        toData.setTennyumaeYubinNo(fromData.getTennyumaeYubinNo());
        toData.setTennyumaeZenkokuJushoCode(fromData.getTennyumaeZenkokuJushoCode());
        toData.setTennyumaeJusho(fromData.getTennyumaeJusho());
        toData.setTennyumaeBanchi(fromData.getTennyumaeBanchi());
        toData.setTennyumaeKatagaki(fromData.getTennyumaeKatagaki());
        toData.setTennyumaeSetainushimei(fromData.getTennyumaeSetainushimei());
        toData.setTennyumaeKyusei(fromData.getTennyumaeKyusei());
        toData.setSaishuJutochiYubinNo(fromData.getSaishuJutochiYubinNo());
        toData.setSaishuJutochiZenkokuJushoCode(fromData.getSaishuJutochiZenkokuJushoCode());
        toData.setSaishuJutochiJusho(fromData.getSaishuJutochiJusho());
        toData.setSaishuJutochiBanchi(fromData.getSaishuJutochiBanchi());
        toData.setSaishuJutochiKatagaki(fromData.getSaishuJutochiKatagaki());
        toData.setSaishuJutochiSetainushimei(fromData.getSaishuJutochiSetainushimei());
        toData.setTenshutsuYoteiIdoYMD(fromData.getTenshutsuYoteiIdoYMD());
        toData.setTenshutsuYoteiYubinNo(fromData.getTenshutsuYoteiYubinNo());
        toData.setTenshutsuYoteiZenkokuJushoCode(fromData.getTenshutsuYoteiZenkokuJushoCode());
        toData.setTenshutsuYoteiJusho(fromData.getTenshutsuYoteiJusho());
        toData.setTenshutsuYoteiBanchi(fromData.getTenshutsuYoteiBanchi());
        toData.setTenshutsuYoteiKatagaki(fromData.getTenshutsuYoteiKatagaki());
        toData.setTenshutsuYoteiSetainushimei(fromData.getTenshutsuYoteiSetainushimei());
        toData.setTenshutsuKakuteiIdoYMD(fromData.getTenshutsuKakuteiIdoYMD());
        toData.setTenshutsuKakuteiTsuchiYMD(fromData.getTenshutsuKakuteiTsuchiYMD());
        toData.setTenshutsuKakuteiYubinNo(fromData.getTenshutsuKakuteiYubinNo());
        toData.setTenshutsuKakuteiZenkokuJushoCode(fromData.getTenshutsuKakuteiZenkokuJushoCode());
        toData.setTenshutsuKakuteiJusho(fromData.getTenshutsuKakuteiJusho());
        toData.setTenshutsuKakuteiBanchi(fromData.getTenshutsuKakuteiBanchi());
        toData.setTenshutsuKakuteiKatagaki(fromData.getTenshutsuKakuteiKatagaki());
        toData.setTenshutsuKakuteiSetainushimei(fromData.getTenshutsuKakuteiSetainushimei());
        toData.setJuminhyoUtsushiHakkoSeigyoKubun(fromData.getJuminhyoUtsushiHakkoSeigyoKubun());
        toData.setRenrakusaki1(fromData.getRenrakusaki1());
        toData.setRenrakusakiKubun1(fromData.getRenrakusakiKubun1());
        toData.setRenrakusaki2(fromData.getRenrakusaki2());
        toData.setRenrakusakiKubun2(fromData.getRenrakusakiKubun2());
        toData.setRenrakusaki3(fromData.getRenrakusaki3());
        toData.setKensakuRenrakusaki3(fromData.getKensakuRenrakusaki3());
        toData.setRenrakusakiKubun3(fromData.getRenrakusakiKubun3());
        toData.setMailAddress(fromData.getMailAddress());
        toData.setBiko(fromData.getBiko());
        toData.setJutogaiKanriUpdateCount(fromData.getJutogaiKanriUpdateCount());
        toData.setJutogaiKanriTorokuNo(fromData.getJutogaiKanriTorokuNo());
        toData.setJutogaiKojinKihonUpdateCount(fromData.getJutogaiKojinKihonUpdateCount());
        toData.setJutogaiKojinKihonTorokuNo(fromData.getJutogaiKojinKihonTorokuNo());
        toData.setJutogaiNihonjinUpdateCount(fromData.getJutogaiNihonjinUpdateCount());
        toData.setJutogaiNihonjinTorokuNo(fromData.getJutogaiNihonjinTorokuNo());
        toData.setJutogaiGaikokujinUpdateCount(fromData.getJutogaiGaikokujinUpdateCount());
        toData.setJutogaiGaikokujinTorokuNo(fromData.getJutogaiGaikokujinTorokuNo());
        toData.setHojinUpdateCount(fromData.getHojinUpdateCount());
        toData.setHojinTorokuNo(fromData.getHojinTorokuNo());
        toData.setKyoyushaUpdateCount(fromData.getKyoyushaUpdateCount());
        toData.setKyoyushaTorokuNo(fromData.getKyoyushaTorokuNo());
        toData.setShimeiSearchTorokuNo(fromData.getShimeiSearchTorokuNo());
        toData.setYusenShimeiUpdateCount(fromData.getYusenShimeiUpdateCount());
        toData.setYusenShimeiTimestamp(fromData.getYusenShimeiTimestamp());
    }

    private void copyKaikuSenkyoFuzuiDataToTempTbl(MeiboSakuseiKaikuEntity fromData, AFABTK101tempTblEntity toData) {
        toData.setShikibetsuCodehaiku(fromData.getAfT133KaikuSenkyoFuzui().getShikibetsuCode());
        toData.setGyogyoshaNo(fromData.getAfT133KaikuSenkyoFuzui().getGyogyoshaNo());
        toData.setKumiaiCode(fromData.getAfT133KaikuSenkyoFuzui().getKumiaiCode());
        toData.setNissuGyogyosha(fromData.getAfT133KaikuSenkyoFuzui().getNissuGyogyosha());
        toData.setNissuJujisha(fromData.getAfT133KaikuSenkyoFuzui().getNissuJujisha());
        toData.setGyogyoShurui(fromData.getAfT133KaikuSenkyoFuzui().getGyogyoShurui());
        toData.setGyosenShubetsu(fromData.getAfT133KaikuSenkyoFuzui().getGyosenShubetsu());
        toData.setSenmei(fromData.getAfT133KaikuSenkyoFuzui().getSenmei());
        toData.setTorokuNo(fromData.getAfT133KaikuSenkyoFuzui().getTorokuNo());
        copySenkyoShikakuDataToTempTbl(fromData, toData);

    }

    private void copySenkyoShikakuDataToTempTbl(MeiboSakuseiKaikuEntity fromData, AFABTK101tempTblEntity toData) {
        toData.setKakuSeq(fromData.getAfT113Entity().getSeq());
        toData.setShikakuKubun(fromData.getAfT113Entity().getShikakuKubun());
        toData.setSenkyoTohyokuCode(fromData.getAfT113Entity().getTohyokuCode());
        toData.setSenkyoShikakuKubun(fromData.getAfT113Entity().getShikakuKubun());
        toData.setSenkyoTorokuJiyuCode(fromData.getAfT113Entity().getTorokuJiyuCode());
        toData.setKiteiNenreiTotatsuYMD(fromData.getAfT100Entity().getKiteiNenreiTotatsuYMD());
        copySubSenkyoShikakuDataToTempTbl(fromData, toData);
    }

    private void copySubSenkyoShikakuDataToTempTbl(MeiboSakuseiKaikuEntity fromData, AFABTK101tempTblEntity toData) {
        if (fromData.getSubAfT113Entity() != null) {
            toData.setSubTorokuTeishiYMD(fromData.getSubAfT113Entity().getTorokuTeishiYMD());
            toData.setSubTorokuTeishiJiyuCode(fromData.getSubAfT113Entity().getTorokuTeishiJiyuCode());
            toData.setSubHyojiYMD(fromData.getSubAfT113Entity().getHyojiYMD());
            toData.setSubHyojiJiyuCode(fromData.getSubAfT113Entity().getHyojiJiyuCode());
            toData.setSubKeikiShuryoYMD(fromData.getSubAfT113Entity().getKeikiShuryoYMD());
            toData.setSubNikeimochiFlag(fromData.getSubAfT113Entity().getNikeimochiFlag());
        }

    }

}
