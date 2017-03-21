/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.io.File;
import java.util.Arrays;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_住所コード;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード1;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード2;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_地区コード3;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShohonShutsuryokuConfigValues.出力範囲指示_行政区コード;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.TohyoJokyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TenshutsuTennyuYmdEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.YukenshasuListDataEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104tempYukenshasuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 有権者数調べ一時テーブル作成のクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public class CreateYukenshasuListTableProcess extends BatchProcessBase<YukenshasuListDataEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;
    private RString 出力範囲指示;
    private static final int 月_4ヶ = 4;
    private ShikakuHantei shikakuHantei;

    private boolean is定時転出期限日判定基準基準日4ヶ月;
    private boolean is定時転出期限日判定基準基準日4ヶ月Add1日;
    private boolean is定時転出期限日判定基準基準日4ヶ月Minus1日;

    /**
     * 出力EUCファイルのパスです。
     */
    public static final RString OUT_EUC_FILE_PATH;

    static {
        OUT_EUC_FILE_PATH = new RString("outEucFilePath");
    }

    private static final RString データ取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectYukensyaKazuShirabeList");
    private EucEntityId eucEntityId;
    private RString csvFileName;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<AFAPRA104tempYukenshasuEntity> csvWriter;
    private FileSpoolManager manager;

    private OutputParameter<RString> outEucFilePath;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {

        RString teijiTensyutu = BusinessConfig.get(ConfigKeysAFA.定時_転出期限日判定基準, SubGyomuCode.AFA選挙本体);
        is定時転出期限日判定基準基準日4ヶ月 = AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月.isEqual(teijiTensyutu);
        is定時転出期限日判定基準基準日4ヶ月Add1日 = AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月.isEqual(teijiTensyutu);
        is定時転出期限日判定基準基準日4ヶ月Minus1日 = AFAConfigKeysValue.定時_転出期限日判定基準_基準日_4ヶ月.isEqual(teijiTensyutu);

        出力範囲指示 = BusinessConfig.get(ConfigKeysAFA.抄本_出力範囲指示, SubGyomuCode.AFA選挙本体);
        parameter.setSort(getソート順());
        mybatisparameter = parameter.toBatchMybatisParameter();
        shikakuHantei = new ShikakuHantei();
        eucEntityId = AFAEucEntityId.有権者数調べ.getEucEntityId();
        csvFileName = AFAEucEntityId.有権者数調べ.getFileNameWithDateString();
        outEucFilePath = new OutputParameter<>();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        mybatisparameter.set登録年月日検索基準(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体));
        mybatisparameter.set消除年月日検索基準(BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体));
        return new BatchDbReader(データ取得, mybatisparameter);
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

        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(AFAPRA104tempYukenshasuEntity.TEMP_TABLE_NAME, AFAPRA104tempYukenshasuEntity.class);
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
    protected void process(YukenshasuListDataEntity entity) {
        if (entity != null) {
            csvWriter.writeLine(create一時テーブル(entity));
        }
    }

    @Override
    protected void afterExecute() {
        tempDbWriter.getDeleteCount();
    }

    private AFAPRA104tempYukenshasuEntity create一時テーブル(YukenshasuListDataEntity entity) {
        AFAPRA104tempYukenshasuEntity tempEntity = new AFAPRA104tempYukenshasuEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = entity.getUaft200();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(宛名PSM);
        AfT111SenkyoEntity senkyo = entity.getAfT111Senkyo();
        AfT201TohyoJokyoEntity tohyoJokyo = entity.getAft201();
        AfT112SenkyoninMeiboEntity senkyoninMeibo = entity.getAfT112SenkyoninMeibo();
        AfT100ShohonEntity shohon = entity.getAfT100Shohon();
        SenkyoShurui senkyoShurui = SenkyoShurui.toValue(shohon.getSenkyoShurui().value());

        tempEntity.set識別コード(kojin.get識別コード());
        tempEntity.set性別(kojin.get性別().getCode());
        tempEntity.set選挙番号(senkyo.getSenkyoNo());
        tempEntity.set投票区コード(senkyoninMeibo.getTohyokuCode());

        tempEntity.set投票区名称(RString.EMPTY);
        if (SenkyoShurui.国政選挙_地方選挙.equals(senkyoShurui)) {
            if (null != entity.getUrV0159()) {
                tempEntity.set投票区名称(entity.getUrV0159().getName());
            }
        } else {
            if (null != entity.getAfT501()) {
                tempEntity.set投票区名称(entity.getAfT501().getTohyokuName());
            }
        }

        set地区と地区コード(tempEntity, 宛名PSM);
        tempEntity.set名簿基準年月日(senkyo.getKijunYMD());
        tempEntity.set投票年月日(shohon.getTohyoYMD());
        tempEntity.set選挙種類(shohon.getSenkyoShurui().getColumnValue());

        SenkyoninTohyoJokyoEntity senkyoEntity = new SenkyoninTohyoJokyoEntity();

        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(shohon);
        senkyoJohoEntity.setSenkyoEntity(Arrays.asList(entity.getAfT111Senkyo()));
        senkyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);

        senkyoEntity.setSenkyoninMeiboEntity(senkyoninMeibo);
        senkyoEntity.setSenkyoShikakuEntity(entity.getAfT113SenkyoShikaku());
        senkyoEntity.setTohyoJokyoEntityList(Arrays.asList(entity.getAft201()));
        senkyoEntity.setAtenaPSMEntity(宛名PSM);

        FlexibleDate kijunbi = senkyo.getKijunYMD();
        FlexibleDate touhyobi = shohon.getTohyoYMD();

        tempEntity.set登録者区分(shikakuHantei.is名簿登録者(senkyoEntity, parameter.get前回基準日()));
        tempEntity.set追加登録者区分(shikakuHantei.is新規登録者(senkyoEntity, kijunbi, parameter.get前回基準日()));
        tempEntity.set死亡区分(shikakuHantei.is死亡抹消者(senkyoEntity, parameter.get前回基準日()));
        tempEntity.set四ヶ月抹消区分(shikakuHantei.is職権消除4ヶ月抹消者_期間指定(senkyoEntity, get前回転出期限日(parameter.get前回基準日()),
                touhyobi)
                || shikakuHantei.is転出4ヶ月抹消者_期間指定(senkyoEntity, get前回転出期限日(parameter.get前回基準日()), touhyobi));
        tempEntity.set当日四ヶ月抹消区分(shikakuHantei.is職権消除4ヶ月抹消者_日付指定(senkyoEntity, kijunbi)
                || shikakuHantei.is転出4ヶ月抹消者_日付指定(senkyoEntity, kijunbi));
        tempEntity.set誤載区分(shikakuHantei.is誤載抹消者(senkyoEntity));
        tempEntity.set国籍喪失区分(shikakuHantei.is国籍喪失者(senkyoEntity, kijunbi));
        TenshutsuTennyuYmdEntity 転出転入日 = entity.getTenshutsuTennyuYmdEntity();
        tempEntity.setその他抹消区分((転出転入日 != null && shikakuHantei.is居住要件抹消者(転出転入日.get転出転入日(), kijunbi))
                || shikakuHantei.is基準日前異動抹消者(senkyoEntity, kijunbi)
                || shikakuHantei.isその他抹消者(senkyoEntity, kijunbi));
        tempEntity.set法11条関連区分(shikakuHantei.is法11条関連者(senkyoEntity));
        tempEntity.set二重登録区分(shikakuHantei.is二重登録者(senkyoEntity, kijunbi));
        tempEntity.set抹消者総区分(shikakuHantei.is抹消者(宛名PSM, senkyo.getTenshutsuKigenYMD(),
                senkyoEntity.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD()));
        tempEntity.set失権失格者区分(shikakuHantei.is失権失格者(senkyoEntity, kijunbi));
        tempEntity.set選挙期日登録者区分(shikakuHantei.is選挙期日登録者(senkyoEntity, touhyobi));
        tempEntity.setN内転出者区分(shikakuHantei.is都道府県内転出者(senkyoEntity));
        tempEntity.setN外転出者区分(shikakuHantei.is都道府県外転出者(senkyoEntity));
        tempEntity.set国外転出者区分(shikakuHantei.is国外転出者(senkyoEntity));
        tempEntity.set職権削除者区分(shikakuHantei.is職権消除者(senkyoEntity));

        if (tohyoJokyo == null) {
            tempEntity.set加算有権者_抹消者区分(false);
            tempEntity.set加算有権者_抹消者区分(false);
            tempEntity.set加算有権者_抹消者区分(false);
            tempEntity.set加算有権者_抹消者区分(false);
        } else {
            TohyoJokyoJohoEntity tohyoJokyoJoho = new TohyoJokyoJohoEntity(tohyoJokyo);
            tempEntity.set加算有権者_抹消者区分(shikakuHantei.is加算有権者_抹消(senkyoEntity, tohyoJokyoJoho));
            tempEntity.set加算有権者_失権者区分(shikakuHantei.is加算有権者_失権(senkyoEntity, tohyoJokyoJoho));
            tempEntity.set加算有権者_計区分(shikakuHantei.is加算有権者(senkyoEntity, tohyoJokyoJoho));
            tempEntity.set当日有権者区分(shikakuHantei.is当日有権者(senkyoEntity, tohyoJokyoJoho, parameter.get前回基準日()));
        }

        return tempEntity;
    }

    private void set地区と地区コード(AFAPRA104tempYukenshasuEntity entity, UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        if (出力範囲指示_住所コード.getKey().equals(出力範囲指示)) {
            ChoikiCode 住登内町域コード = 宛名PSM.getJutonaiChoikiCode();
            if (null != 住登内町域コード) {
                entity.set地区コード(住登内町域コード.value());
            }
            entity.set地区名称(宛名PSM.getJutonaiJusho());
        } else if (出力範囲指示_行政区コード.getKey().equals(出力範囲指示)) {
            GyoseikuCode 行政区コード = 宛名PSM.getGyoseikuCode();
            if (null != 行政区コード) {
                entity.set地区コード(行政区コード.value());
            }
            entity.set地区名称(宛名PSM.getGyoseikuName());
        } else if (出力範囲指示_地区コード1.getKey().equals(出力範囲指示)) {
            ChikuCode 地区コード1 = 宛名PSM.getChikuCode1();
            if (null != 地区コード1) {
                entity.set地区コード(地区コード1.value());
            }
            entity.set地区名称(宛名PSM.getChikuName1());

        } else if (出力範囲指示_地区コード2.getKey().equals(出力範囲指示)) {
            ChikuCode 地区コード2 = 宛名PSM.getChikuCode1();
            if (null != 地区コード2) {
                entity.set地区コード(地区コード2.value());
            }
            entity.set地区名称(宛名PSM.getChikuName2());
        } else if (出力範囲指示_地区コード3.getKey().equals(出力範囲指示)) {
            ChikuCode 地区コード3 = 宛名PSM.getChikuCode3();
            if (null != 地区コード3) {
                entity.set地区コード(地区コード3.value());
            }
            entity.set地区名称(宛名PSM.getChikuName3());
        } else {
            ChoikiCode 住登内町域コード = 宛名PSM.getJutonaiChoikiCode();
            if (null != 住登内町域コード) {
                entity.set地区コード(住登内町域コード.value());
            }
            entity.set地区名称(宛名PSM.getJutonaiJusho());
        }
    }

    private FlexibleDate get前回転出期限日(FlexibleDate 前回基準日) {
        if (前回基準日 != null && !前回基準日.isEmpty()) {
            if (is定時転出期限日判定基準基準日4ヶ月) {
                return 前回基準日.minusMonth(月_4ヶ);
            } else if (is定時転出期限日判定基準基準日4ヶ月Add1日) {
                return 前回基準日.minusMonth(月_4ヶ).plusDay(1);
            } else if (is定時転出期限日判定基準基準日4ヶ月Minus1日) {
                return 前回基準日.minusMonth(月_4ヶ).minusDay(1);
            }
        }
        return FlexibleDate.MIN;
    }

    private RString getソート順() {
        for (ShohonShutsuryokuConfigValues config : ShohonShutsuryokuConfigValues.values()) {
            if (config.getKey().equals(出力範囲指示)) {
                return config.get出力順();
            }
        }
        return ShohonShutsuryokuConfigValues.出力範囲指示_住所コード.get出力順();
    }

}
