package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.TorokushasuListFuzaiShikakuDataEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103tempTorokushasuListFuzaiShikakuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 登録者数リスト（不在者投票資格者分）一時テーブル作成のクラスです。
 *
 * @reamsid_L AF-0030-031 liss
 */
public class TorokushasuListFuzaiShikakuDataSelectProcess extends BatchProcessBase<TorokushasuListFuzaiShikakuDataEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private IAssociation association;
    private OutputParameter<SenkyoShurui> outSenkyoShurui;
    private RString 帳票出力順;
    private static final RString 出力順_住所コード = new RString("投票区コード ＞ 住所コード");
    private static final RString 出力順_行政区コード = new RString("投票区コード ＞ 行政区コード");
    private static final RString 出力順_地区コード1 = new RString("投票区コード ＞ 地区コード１");
    private static final RString 出力順_地区コード2 = new RString("投票区コード ＞ 地区コード２");
    private static final RString 出力順_地区コード3 = new RString("投票区コード ＞ 地区コード３");

    /**
     * 出力EUCファイルのパスです。
     */
    public static final RString OUT_EUC_FILE_PATH;
    /**
     * 選挙種類です。
     */
    public static final RString OUT_SENKYO_SHURUI;

    static {
        OUT_EUC_FILE_PATH = new RString("outEucFilePath");
        OUT_SENKYO_SHURUI = new RString("outSenkyoShurui");
    }
    private ShikakuHantei 資格判定;
    private static final RString データ取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFAPRB103tempTorokushasuListFuzaiMapper."
                    + "selectTorokushasuListFuzaiShikaku");
    private EucEntityId eucEntityId;
    private RString csvFileName;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<AFAPRA103tempTorokushasuListFuzaiShikakuEntity> csvWriter;
    private FileSpoolManager manager;

    private OutputParameter<RString> outEucFilePath;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        mybatisparameter.set地方公共団体コード(association.get地方公共団体コード().value());
        mybatisparameter.set地方公共団体コード連番(association.getLasdecCodeRenban_());
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.不在者投票資格者分.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目().trim();
        資格判定 = new ShikakuHantei();
        eucEntityId = AFAEucEntityId.登録者数リスト不在者投票資格者分.getEucEntityId();
        csvFileName = AFAEucEntityId.登録者数リスト不在者投票資格者分.getFileNameWithDateString();
        outEucFilePath = new OutputParameter<>();
    }

    @Override
    protected void beforeExecute() {
        outSenkyoShurui = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
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

        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME,
                AFAPRA103tempTorokushasuListFuzaiShikakuEntity.class);
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
    protected void process(TorokushasuListFuzaiShikakuDataEntity entity) {
        if (entity != null) {
            AFAPRA103tempTorokushasuListFuzaiShikakuEntity tmpTbl = create一時テーブル(entity);
            if (tmpTbl != null) {
                csvWriter.writeLine(tmpTbl);
            }
        }
    }

    @Override
    protected void afterExecute() {
        tempDbWriter.getDeleteCount();
    }

    private AFAPRA103tempTorokushasuListFuzaiShikakuEntity create一時テーブル(TorokushasuListFuzaiShikakuDataEntity entity) {
        AFAPRA103tempTorokushasuListFuzaiShikakuEntity tempEntity = new AFAPRA103tempTorokushasuListFuzaiShikakuEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.getUaft200();
        IKojin 宛名PSM = ShikibetsuTaishoFactory.createKojin(宛名);
        AfT100ShohonEntity 抄本 = entity.getAfT100Shohon();
        AfT111SenkyoEntity 選挙 = entity.getAfT111Senkyo();
        SenkyoShurui senkyoShurui = SenkyoShurui.toValue(抄本.getSenkyoShurui().value());
        parameter.setSenkyoShurui(senkyoShurui);
        outSenkyoShurui.setValue(senkyoShurui);

        tempEntity.setShikibetsuCode(宛名PSM.get識別コード());
        tempEntity.setOrderCode(getOrderCode(宛名PSM));
        tempEntity.setSeibetsuCode(宛名PSM.to個人().get性別().getCode());
        tempEntity.setTohyokuCode(entity.getAfT112SenkyoninMeibo().getTohyokuCode());
        tempEntity.setTohyokuMeisho(RString.EMPTY);
        if (SenkyoShurui.国政選挙_地方選挙.equals(senkyoShurui)) {
            if (null != entity.getUrV0159()) {
                tempEntity.setTohyokuMeisho(entity.getUrV0159().getName());
            }
        } else {
            if (null != entity.getAfT501()) {
                tempEntity.setTohyokuMeisho(entity.getAfT501().getTohyokuName());
            }
        }
        tempEntity.setSenkyoNo(選挙.getSenkyoNo());
        tempEntity.setSenkyoName(選挙.getSenkyoName());
        tempEntity.setKijunYMD(選挙.getKijunYMD());
        tempEntity.setTohyoYMD(SenkyoShurui.定時登録.equals(senkyoShurui) ? null : 抄本.getTohyoYMD());
        // うち県内転出者
        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(宛名);
        tempEntity.setKenaiTenshutsushaKubun(資格判定.is都道府県内転出者(senkyoninTohyoJokyoEntity));
        // 有権者
        tempEntity.setUkeshaKubun(資格判定.is有権者(宛名,
                選挙.getTennyuKigenYMD(),
                parameter.getNenreiKigenbi(),
                選挙.getKijunYMD(),
                senkyoShurui,
                entity.getAfT113SenkyoShikaku()));
        // 表示者
        tempEntity.setHyojishaKubun(資格判定.is表示者(宛名,
                選挙.getTenshutsuKigenYMD(),
                parameter.getNenreiKigenbi(),
                選挙.getKijunYMD(),
                parameter.get前回基準日(),
                senkyoShurui));
        // 公民権停止者
        tempEntity.setKominkenTeshishaKubun(資格判定.is公民権停止者(宛名,
                entity.getAfT113SenkyoShikaku(),
                parameter.getNenreiKigenbi(),
                選挙.getKijunYMD()));

        tempEntity.setTohyoshikakuShurui(entity.getAfT114().getTohyoShikakuShurui());
        if (資格判定.has郵便投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), Arrays.asList(entity.getAfT114()))
                || 資格判定.has洋上投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), Arrays.asList(entity.getAfT114()))
                || 資格判定.has南極投票資格(宛名PSM.get識別コード(), parameter.getKijunbi(), Arrays.asList(entity.getAfT114()))) {
            return tempEntity;
        }

        return null;
    }

    private RString getOrderCode(IKojin 宛名PSM) {
        if (出力順_住所コード.equals(帳票出力順)) {
            return 宛名PSM.get住登内住所().get町域コード().value()
                    .concat(宛名PSM.get住登内住所().get住所());
        } else if (出力順_行政区コード.equals(帳票出力順)) {
            return 宛名PSM.get行政区画().getGyoseiku().getコード().value()
                    .concat(宛名PSM.get行政区画().getGyoseiku().get名称());
        } else if (出力順_地区コード1.equals(帳票出力順)) {
            return 宛名PSM.get行政区画().getChiku1().getコード().value()
                    .concat(宛名PSM.get行政区画().getChiku1().get名称());
        } else if (出力順_地区コード2.equals(帳票出力順)) {
            return 宛名PSM.get行政区画().getChiku2().getコード().value()
                    .concat(宛名PSM.get行政区画().getChiku2().get名称());
        } else if (出力順_地区コード3.equals(帳票出力順)) {
            return 宛名PSM.get行政区画().getChiku3().getコード().value()
                    .concat(宛名PSM.get行政区画().getChiku3().get名称());
        } else {
            return 宛名PSM.get行政区画().getGyoseiku().getコード().value()
                    .concat(宛名PSM.get行政区画().getGyoseiku().get名称());
        }
    }
}
