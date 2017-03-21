/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuListEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙時登録_データ取得用のプロセスクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuDataSelectProcess extends BatchProcessBase<TeijiTourokuListEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private ShikakuHantei shikakuhantei;
    private ShikakuHantei.ShikakuHanteiWithInfo shikakuHanteiWithInfo;

    private TeijiTourokuListEntity lastEntity;
    private List<SenkyoninTohyoJokyoEntity> senkyoEntityList;

    /**
     * 選挙時登録_temp取得。
     *
     */
    public static final RString OUT_EUC_FILE_PATH;

    static {
        OUT_EUC_FILE_PATH = new RString("outEucFilePath");
    }
    private static final RString データ取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectSenkyoNinTouhyouJyohouList");
    private static final RString 居住区分コード = new RString("2240");
    private static final RString 居住区分毎 = new RString("1");
    private static final RString 資格区分毎 = new RString("2");
    private static final RString 住民種別_日本人 = new RString("1");
    private static final RString 住民状態_住民 = new RString("1");
    private static final RString 性別 = new RString("1");
    private static final RString DEFAULT_SATSU = new RString("00");

    private EucEntityId eucEntityId;
    private RString csvFileName;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<AFABTA101tempTblEntity> csvWriter;
    private FileSpoolManager manager;

    private OutputParameter<RString> outEucFilePath;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        lastEntity = null;
        senkyoEntityList = null;
        shikakuhantei = new ShikakuHantei();
        eucEntityId = AFAEucEntityId.定時登録データ取得.getEucEntityId();
        csvFileName = AFAEucEntityId.定時登録データ取得.getFileNameWithDateString();
        outEucFilePath = new OutputParameter<>();

    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, eucEntityId, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, csvFileName);
        outEucFilePath.setValue(eucFilePath);
        deleteFile();

        this.csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString())
                .setEncode(Encode.UTF_8)
                .setNewLine(NewLine.CRLF)
                .build();

        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(AFABTA101tempTblEntity.TEMP_TABLE_NAME, AFABTA101tempTblEntity.class);
    }

    private boolean deleteFile() {
        RString filePath = Path.combinePath(manager.getEucOutputDirectry(), csvFileName);
        File file = new File(filePath.toString());
        if (file.isFile()) {
            return file.delete();
        }
        return true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(データ取得, mybatisparameter);
    }

    @Override
    protected void process(TeijiTourokuListEntity entity) {

        List<SenkyoninTohyoJokyoEntity> senkyoninTohyoJokyoEntitys = getSenkyoEntityList(entity);

        if (senkyoninTohyoJokyoEntitys != null) {
            insert(senkyoninTohyoJokyoEntitys);
        }
        lastEntity = entity;
    }

    private List<SenkyoninTohyoJokyoEntity> getSenkyoEntityList(TeijiTourokuListEntity entity) {
        if (lastEntity == null) {
            senkyoEntityList = new ArrayList<>();
            senkyoEntityList.add(entity.toSenkyoninTohyoJokyoEntity());
        } else if (!lastEntity.getShikibetsuCode().equals(entity.getShikibetsuCode())) {
            List<SenkyoninTohyoJokyoEntity> rslt = senkyoEntityList;
            senkyoEntityList = new ArrayList<>();
            senkyoEntityList.add(entity.toSenkyoninTohyoJokyoEntity());
            return rslt;
        } else if (!lastEntity.getShohonNo().equals(entity.getShohonNo())) {
            senkyoEntityList.add(entity.toSenkyoninTohyoJokyoEntity());
        } else {
            senkyoEntityList.get(senkyoEntityList.size() - 1).addSenkyo(entity.getAfT111Senkyo());
        }
        return null;
    }

    @Override
    protected void afterExecute() {
        if (lastEntity != null) {
            insert(senkyoEntityList);
        }
        tempDbWriter.getDeleteCount();
    }

    private void insert(List<SenkyoninTohyoJokyoEntity> senkyoninTohyoJokyoEntitys) {
        UaFt200FindShikibetsuTaishoEntity uaft200 = senkyoninTohyoJokyoEntitys.get(0).getAtenaPSMEntity();
        AFABTA101tempTblEntity tempTblInsertEntity = new AFABTA101tempTblEntity();
        psmDataToTempTbl(uaft200, tempTblInsertEntity);

        shikakuHanteiWithInfo = new ShikakuHantei.ShikakuHanteiWithInfo(senkyoninTohyoJokyoEntitys);
        tempTblInsertEntity.setTohyokuCodeAdd(getTohyokuCode(senkyoninTohyoJokyoEntitys, uaft200));
        tempTblInsertEntity.setSatsu(getSatsu(uaft200));
        tempTblInsertEntity.setGroupCode(getGroupCode(senkyoninTohyoJokyoEntitys.get(0), uaft200));

        csvWriter.writeLine(tempTblInsertEntity);
    }

    private RString getGroupCode(SenkyoninTohyoJokyoEntity senkyoEntity, UaFt200FindShikibetsuTaishoEntity entity) {
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
            return get選挙資格区分(senkyoEntity);
        } else {
            return new RString("0");
        }
    }

    private RString get選挙資格区分(SenkyoninTohyoJokyoEntity senkyoEntity) {
        if (is有権者(senkyoEntity)) {
            return SennkyoSikakuKubun.有権者.value();
        } else if (is表示者(senkyoEntity)) {
            return SennkyoSikakuKubun.表示者.value();
        } else if (is公民権停止者(senkyoEntity)) {
            return SennkyoSikakuKubun.公民権停止.value();
        } else if (is抹消者(senkyoEntity)) {
            return SennkyoSikakuKubun.抹消者.value();
        }
        return new RString("0");
    }

    private boolean is有権者(SenkyoninTohyoJokyoEntity senkyoEntity) {
        return shikakuhantei.is有権者(senkyoEntity.getAtenaPSMEntity(),
                parameter.getTennyuKigenbi(), parameter.getNenreiKigenbi(), parameter.getTouhyobi(),
                SenkyoShurui.国政選挙_地方選挙, senkyoEntity.getSenkyoShikakuEntity());
    }

    private boolean is表示者(SenkyoninTohyoJokyoEntity senkyoEntity) {
        return shikakuhantei.is表示者(senkyoEntity.getAtenaPSMEntity(),
                parameter.getTenshutuKigenbi(), parameter.getNenreiKigenbi(),
                parameter.getTouhyobi(), parameter.get前回基準日(),
                SenkyoShurui.国政選挙_地方選挙);
    }

    private boolean is公民権停止者(SenkyoninTohyoJokyoEntity senkyoEntity) {
        return shikakuhantei.is公民権停止者(senkyoEntity.getAtenaPSMEntity(),
                senkyoEntity.getSenkyoShikakuEntity(),
                parameter.getNenreiKigenbi(), parameter.getKijunbi());
    }

    private boolean is抹消者(SenkyoninTohyoJokyoEntity senkyoEntity) {
        return shikakuhantei.is抹消者(senkyoEntity.getAtenaPSMEntity(),
                parameter.getTenshutuKigenbi(), parameter.getNenreiKigenbi());
    }

    private RString getTohyokuCode(List<SenkyoninTohyoJokyoEntity> senkyoEntityList, UaFt200FindShikibetsuTaishoEntity entity) {
        for (SenkyoninTohyoJokyoEntity senkyoEntity : senkyoEntityList) {
            if (null != entity && null != entity.getShikibetsuCode() && null != senkyoEntity.getSenkyoShikakuEntity()) {
                return shikakuHanteiWithInfo.get投票区(entity.getShikibetsuCode());
            }
        }
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
            return RString.isNullOrEmpty(seibetsuCode) ? DEFAULT_SATSU : seibetsuCode;
        } else {
            return DEFAULT_SATSU;
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
        toData.setYusenShimeiTimestamp(RDateTime.now());
        toData.setLastUpdateTimestamp(RDateTime.now());
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
