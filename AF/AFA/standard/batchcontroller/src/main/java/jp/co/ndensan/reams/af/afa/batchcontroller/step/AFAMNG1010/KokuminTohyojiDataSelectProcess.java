/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国民投票時登録_データ取得用のプロセスクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
public class KokuminTohyojiDataSelectProcess extends BatchProcessBase<UaFt200FindShikibetsuTaishoEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;
    private ShikakuHantei shikakuhantei;
    private OutputParameter<RString> outTempTableName;

    /**
     * 国民投票時登録_temp取得。
     *
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
    }
    private static final RString TEMP_TABLE_NAME = new RString("TempUaFt200FindShikibetsuTaisho");
    private static final RString データ取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectKokuminTohyojiDataList");
    private static final RString 居住区分コード = new RString("2240");
    private static final RString 居住区分毎 = new RString("1");
    private static final RString 資格区分毎 = new RString("2");
    private static final RString 住民種別_日本人 = new RString("1");
    private static final RString 住民状態_住民 = new RString("1");
    private static final RString 性別 = new RString("1");
    private static final RString DEFAULTVALUE = new RString("0");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        shikakuhantei = new ShikakuHantei();
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, null);
    }

    @Override
    protected void beforeExecute() {
        outTempTableName = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, AFABTA101tempTblEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(データ取得, mybatisparameter);
    }

    @Override
    protected void process(UaFt200FindShikibetsuTaishoEntity entity) {

        if (entity != null) {
            insert(entity);
        }
    }

    @Override
    protected void afterExecute() {
        outTempTableName.setValue(TEMP_TABLE_NAME);
    }

    private void insert(UaFt200FindShikibetsuTaishoEntity entity) {
        AFABTA101tempTblEntity tempTblInsertEntity = new AFABTA101tempTblEntity();
        psmDataToTempTbl(entity, tempTblInsertEntity);

        tempTblInsertEntity.setTohyokuCodeAdd(getTohyokuCode(entity));
        tempTblInsertEntity.setSatsu(getSatsu(entity));
        tempTblInsertEntity.setGroupCode(getGroupCode(entity));
        tempDbWriter.insert(tempTblInsertEntity);
    }

    private RString getGroupCode(UaFt200FindShikibetsuTaishoEntity entity) {
        RString 抄本_グループコード = BusinessConfig.get(ConfigKeysAFA.抄本_グループコード, SubGyomuCode.AFA選挙本体);
        if (居住区分毎.equals(抄本_グループコード)) {
            if (住民種別_日本人.equals(entity.getJuminShubetsuCode()) && 住民状態_住民.equals(entity.getJuminJotaiCode())) {
                return CodeMaster.getCode(SubGyomuCode.AFA選挙本体,
                        new CodeShubetsu(居住区分コード)).get(0).getコード().value();
            } else {
                return CodeMaster.getCode(SubGyomuCode.AFA選挙本体,
                        new CodeShubetsu(居住区分コード)).get(1).getコード().value();
            }
        } else if (資格区分毎.equals(抄本_グループコード)) {
            return get選挙資格区分(entity);
        } else {
            return DEFAULTVALUE;
        }
    }

    private RString get選挙資格区分(UaFt200FindShikibetsuTaishoEntity entity) {
        if (is1号資格者(entity)) {
            return SennkyoSikakuKubun.有権者_1号資格.value();
        } else if (is2号資格者(entity)) {
            return SennkyoSikakuKubun.有権者_2号資格.value();
        }
        return DEFAULTVALUE;
    }

    private boolean is1号資格者(UaFt200FindShikibetsuTaishoEntity entity) {
        return shikakuhantei.is1号資格者(entity, parameter.get基準日(), parameter.get年齢到達日());
    }

    private boolean is2号資格者(UaFt200FindShikibetsuTaishoEntity entity) {
        return shikakuhantei.is2号資格者(entity, parameter.get基準日(), parameter.get年齢到達日());
    }

    private RString getTohyokuCode(UaFt200FindShikibetsuTaishoEntity entity) {
        return null == entity ? RString.EMPTY : getCodeToRString(entity.getTohyokuCode());
    }

    private RString getCodeToRString(TohyokuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private RString getSatsu(UaFt200FindShikibetsuTaishoEntity entity) {
        if (性別.equals(BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体))) {
            RString seibetsuCode = entity.getSeibetsuCode();
            return RString.isNullOrEmpty(seibetsuCode) ? DEFAULTVALUE : seibetsuCode;
        } else {
            return DEFAULTVALUE;
        }
    }

    private void psmDataToTempTbl(UaFt200FindShikibetsuTaishoEntity fromData, AFABTA101tempTblEntity toData) {
        toData.setShikibetsuCode(fromData.getShikibetsuCode());
        toData.setGenLasdecCode(fromData.getGenLasdecCode());
        toData.setKyuLasdecCode(fromData.getKyuLasdecCode());
        toData.setKyuLasdecCodeRenban(fromData.getKyuLasdecCodeRenban());
        toData.setGyomuCode(fromData.getGyomuCode());
        toData.setRirekiNo(fromData.getRirekiNo());
        toData.setCurrentFlag(fromData.getCurrentFlag());
        toData.setJuminShubetsuCode(fromData.getJuminShubetsuCode());
        toData.setKojinNo(fromData.getKojinNo());
        toData.setHojinNo(fromData.getHojinNo());
        toData.setShoriYMD(fromData.getShoriYMD());
        toData.setIdoJiyuCode(fromData.getIdoJiyuCode());
        toData.setIdoYMD(fromData.getIdoYMD());
        toData.setTodokedeJiyuCode(fromData.getTodokedeJiyuCode());
        toData.setTodokedeYMD(fromData.getTodokedeYMD());
        toData.setIdoRiyuCode(fromData.getIdoRiyuCode());
        toData.setMeisho(fromData.getMeisho());
        toData.setKanaMeisho(fromData.getKanaMeisho());
        toData.setKannaiKangaiKubun(fromData.getKannaiKangaiKubun());
        toData.setYubinNo(fromData.getYubinNo());
        toData.setChoikiCode(fromData.getChoikiCode());
        toData.setZenkokuJushoCode(fromData.getZenkokuJushoCode());
        toData.setJusho(fromData.getJusho());
        toData.setBanchiCode1(fromData.getBanchiCode1());
        toData.setBanchiCode2(fromData.getBanchiCode2());
        toData.setBanchiCode3(fromData.getBanchiCode3());
        toData.setBanchiCode4(fromData.getBanchiCode4());
        toData.setBanchi(fromData.getBanchi());
        toData.setKatagaki(fromData.getKatagaki());
        toData.setKatagakiInjiFlag(fromData.getKatagakiInjiFlag());
        toData.setGyoseikuCode(fromData.getGyoseikuCode());
        toData.setGyoseikuName(fromData.getGyoseikuName());
        toData.setChikuCode1(fromData.getChikuCode1());
        toData.setChikuName1(fromData.getChikuName1());
        toData.setChikuCode2(fromData.getChikuCode2());
        toData.setChikuName2(fromData.getChikuName2());
        toData.setChikuCode3(fromData.getChikuCode3());
        toData.setChikuName3(fromData.getChikuName3());
        toData.setShogakkokuCode(fromData.getShogakkokuCode());
        toData.setShogakkokuName(fromData.getShogakkokuName());
        toData.setChugakkokuCode(fromData.getChugakkokuCode());
        toData.setChugakkokuName(fromData.getChugakkokuName());
        toData.setTohyokuCode(fromData.getTohyokuCode());
        toData.setTohyokuName(fromData.getTohyokuName());
        toData.setJuminJotaiCode(fromData.getJuminJotaiCode());
        toData.setSetaiCode(fromData.getSetaiCode());
        toData.setSeinengappiYMD(fromData.getSeinengappiYMD());
        toData.setSeinengappiFushoKubun(fromData.getSeinengappiFushoKubun());
        toData.setSeibetsuCode(fromData.getSeibetsuCode());
        toData.setTsuzukigaraCode(fromData.getTsuzukigaraCode());
        toData.setTsuzukigara(fromData.getTsuzukigara());
        toData.setKazokuNo(fromData.getKazokuNo());
        toData.setJuminhyoHyojijun(fromData.getJuminhyoHyojijun());
        toData.setKikaYMD(fromData.getKikaYMD());
        toData.setKanjiShimei(fromData.getKanjiShimei());
        toData.setKanaShimei(fromData.getKanaShimei());
        toData.setHonsekiZenkokuJushoCode(fromData.getHonsekiZenkokuJushoCode());
        toData.setHonsekiChoikiCode(fromData.getHonsekiChoikiCode());
        toData.setHonsekiJusho(fromData.getHonsekiJusho());
        toData.setHonsekiBanchi(fromData.getHonsekiBanchi());
        toData.setHittosha(fromData.getHittosha());
        toData.setGaikokujinShimei(fromData.getGaikokujinShimei());
        toData.setGaikokujinHeikimei(fromData.getGaikokujinHeikimei());
        toData.setGaikokujinKanaShimei(fromData.getGaikokujinKanaShimei());
        toData.setTsushomei(fromData.getTsushomei());
        toData.setShimeiRiyoKubun(fromData.getShimeiRiyoKubun());
        toData.setKanaTsushomei(fromData.getKanaTsushomei());
        toData.setKatakanaHyoki(fromData.getKatakanaHyoki());
        toData.setKokusekiChiikiCode(fromData.getKokusekiChiikiCode());
        toData.setZairyuShikakuCode(fromData.getZairyuShikakuCode());
        toData.setZairyuKikanCode(fromData.getZairyuKikanCode());
        toData.setZairyuKikantoManryoYMD(fromData.getZairyuKikantoManryoYMD());
        toData.setZairyuCardtoNo(fromData.getZairyuCardtoNo());
        toData.setZairyuCardtoYukoYMD(fromData.getZairyuCardtoYukoYMD());
        toData.setDai30Jono45niKiteisuruKubun(fromData.getDai30Jono45niKiteisuruKubun());
        toData.setSetainushiShikibetsuCode(fromData.getSetainushiShikibetsuCode());
        toData.setSetainushiMei(fromData.getSetainushiMei());
        toData.setHojinKeitaiCode(fromData.getHojinKeitaiCode());
        toData.setHojinKeitaiMeisho(fromData.getHojinKeitaiMeisho());
        toData.setHojinKeitaiRyakusho(fromData.getHojinKeitaiRyakusho());
        toData.setHojinMeishoHenshuKubun(fromData.getHojinMeishoHenshuKubun());
        toData.setHojinKeitaiRyakushoKubun(fromData.getHojinKeitaiRyakushoKubun());
        toData.setHojinMeisho(fromData.getHojinMeisho());
        toData.setHojinKanaMeisho(fromData.getHojinKanaMeisho());
        toData.setHojinShitenMeisho(fromData.getHojinShitenMeisho());
        toData.setHojinShitenKanaMeisho(fromData.getHojinShitenKanaMeisho());
        toData.setDaihyoshaShikibetsuCode(fromData.getDaihyoshaShikibetsuCode());
        toData.setDaihyoshaJuminShubetsu(fromData.getDaihyoshaJuminShubetsu());
        toData.setDaihyoshaShimei(fromData.getDaihyoshaShimei());
        toData.setDaihyoshaKanaShimei(fromData.getDaihyoshaKanaShimei());
        toData.setDaihyoshaNihonjinShimei(fromData.getDaihyoshaNihonjinShimei());
        toData.setDaihyoshaNihonjinKanaShimei(fromData.getDaihyoshaNihonjinKanaShimei());
        toData.setDaihyoshaGaikokujinShimei(fromData.getDaihyoshaGaikokujinShimei());
        toData.setDaihyoshaGaikokujinHeikimei(fromData.getDaihyoshaGaikokujinHeikimei());
        toData.setDaihyoshaGaikokujinKanaShimei(fromData.getDaihyoshaGaikokujinKanaShimei());
        toData.setDaihyoshaTsushomei(fromData.getDaihyoshaTsushomei());
        toData.setDaihyoshaShimeiRiyoKubun(fromData.getDaihyoshaShimeiRiyoKubun());
        toData.setDaihyoshaKanaTsushomei(fromData.getDaihyoshaKanaTsushomei());
        toData.setDaihyoshaKannaiKangaiKubun(fromData.getDaihyoshaKannaiKangaiKubun());
        toData.setDaihyoshaYubinNo(fromData.getDaihyoshaYubinNo());
        toData.setDaihyoshaChoikiCode(fromData.getDaihyoshaChoikiCode());
        toData.setDaihyoshaZenkokuJushoCode(fromData.getDaihyoshaZenkokuJushoCode());
        toData.setDaihyoshaJusho(fromData.getDaihyoshaJusho());
        toData.setDaihyoshaBanchiCode1(fromData.getDaihyoshaBanchiCode1());
        toData.setDaihyoshaBanchiCode2(fromData.getDaihyoshaBanchiCode2());
        toData.setDaihyoshaBanchiCode3(fromData.getDaihyoshaBanchiCode3());
        toData.setDaihyoshaBanchiCode4(fromData.getDaihyoshaBanchiCode4());
        toData.setDaihyoshaBanchi(fromData.getDaihyoshaBanchi());
        toData.setDaihyoshaKatagaki(fromData.getDaihyoshaKatagaki());
        toData.setNinkachiendantaiTorokuShikakuKubun(fromData.getNinkachiendantaiTorokuShikakuKubun());
        toData.setNinkachiendantaiNinkaYMD(fromData.getNinkachiendantaiNinkaYMD());
        toData.setKojinHojinKBN(fromData.getKojinHojinKBN());
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
        copyPsmDataToTempTbl(fromData, toData);
    }

    private void copyPsmDataToTempTbl(UaFt200FindShikibetsuTaishoEntity fromData, AFABTA101tempTblEntity toData) {
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
        toData.setKensakuRenrakusaki1(fromData.getKensakuRenrakusaki1());
        toData.setRenrakusakiKubun1(fromData.getRenrakusakiKubun1());
        toData.setRenrakusaki2(fromData.getRenrakusaki2());
        toData.setKensakuRenrakusaki2(fromData.getKensakuRenrakusaki2());
        toData.setRenrakusakiKubun2(fromData.getRenrakusakiKubun2());
        toData.setRenrakusaki3(fromData.getRenrakusaki3());
        toData.setKensakuRenrakusaki3(fromData.getKensakuRenrakusaki3());
        toData.setRenrakusakiKubun3(fromData.getRenrakusakiKubun3());
        toData.setMailAddress(fromData.getMailAddress());
        toData.setBiko(fromData.getBiko());
        toData.setJutogaiKanriUpdateCount(fromData.getJutogaiKanriUpdateCount());
        toData.setJutogaiKanriTorokuNo(getTorokuNo(fromData.getJutogaiKanriTorokuNo()));
        toData.setJutogaiKojinKihonUpdateCount(fromData.getJutogaiKojinKihonUpdateCount());
        toData.setJutogaiKojinKihonTorokuNo(getTorokuNo(fromData.getJutogaiKojinKihonTorokuNo()));
        toData.setJutogaiNihonjinUpdateCount(fromData.getJutogaiNihonjinUpdateCount());
        toData.setJutogaiNihonjinTorokuNo(getTorokuNo(fromData.getJutogaiNihonjinTorokuNo()));
        toData.setJutogaiGaikokujinUpdateCount(fromData.getJutogaiGaikokujinUpdateCount());
        toData.setJutogaiGaikokujinTorokuNo(getTorokuNo(fromData.getJutogaiGaikokujinTorokuNo()));
        toData.setHojinUpdateCount(fromData.getHojinUpdateCount());
        toData.setHojinTorokuNo(getTorokuNo(fromData.getHojinTorokuNo()));
        toData.setKyoyushaUpdateCount(fromData.getKyoyushaUpdateCount());
        toData.setKyoyushaTorokuNo(getTorokuNo(fromData.getKyoyushaTorokuNo()));
        toData.setShimeiSearchTorokuNo(getTorokuNo(fromData.getShimeiSearchTorokuNo()));
        toData.setYusenShimeiUpdateCount(fromData.getYusenShimeiUpdateCount());
        toData.setYusenShimeiTimestamp(fromData.getYusenShimeiTimestamp());
    }

    private Integer getTorokuNo(TorokuNo torokuNo) {

        if (torokuNo == null) {
            return 0;
        }
        Integer torokuNoInteger = torokuNo.getColumnValue();
        if (torokuNoInteger == null) {
            return 0;
        }
        return torokuNoInteger;
    }
}
