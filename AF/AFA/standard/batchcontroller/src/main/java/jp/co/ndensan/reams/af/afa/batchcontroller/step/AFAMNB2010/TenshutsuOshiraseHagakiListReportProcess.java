/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiListParam;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJokyoJoho;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA112.TenshutsuOshiraseHagakiListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAShokeitanniTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuryokuShuryohiEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRA112.TenshutsuOshiraseHagakiListPrintEditor;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）の転出者お知らせハガキ作成対象者一覧表のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class TenshutsuOshiraseHagakiListReportProcess extends BatchProcessBase<NyujokenKobetsuJouhou> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private AfaMapperProvider mapperProvider;
    private ShikakuHantei shikakuhantei;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private OutputParameter<RString> outTempTableName;
    private static final RString TEMP_TABLE_NYUJOKENMAISUHYO = new RString("AFAPRB212_NyujokenMaisuhyo");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectSenkyoninMeiciJyohouTempTable");
    @BatchWriter
    private BatchReportWriter<NijuTorokuTsuchishoListSource> batchReportWriter;
    private ReportSourceWriter<NijuTorokuTsuchishoListSource> reportSourceWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter nyujokenMaisuhyoDbWriter;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷世帯数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷枚数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_人数リスト;
    
    /**
     * 地図情報イメージファイル取得。
     *
     */
    public static final RString IMAGE_FOLDER_PATH;

    static {
        IMAGE_FOLDER_PATH = new RString("imageFolderPath");
    }
    private OutputParameter<List<RString>> imageFolderPath;
    /**
     * 送付先情報_temp取得。
     *
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
    }
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Decimal> nyujokenReportIndex;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }
    OutputParameter<Integer> pageCount;
    private Map<RString, Set<SetaiCode>> 入場券印刷枚数表_印刷世帯数;
    private RString 入場券印刷枚数表集計単位;
    private int flag;
    private RString 地区の分類１;
    private RString 地区の分類２;
    private RString 地区の分類３;
    private Decimal 男性の計;
    private Decimal 女性の計;

    @Override
    protected void initialize() {
        shikakuhantei = new ShikakuHantei();
        outTempTableName = new OutputParameter<>();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable(parameter.getTable());
        mybatisParameter.setGroupKubun(parameter.getGroupKubun());
        mybatisParameter.set出力順(parameter.getOrder順());
        pageCount = new OutputParameter<>();
        nyujokenReportIndex = new OutputParameter<>();
        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity 転出者お知らせハガキ一覧 = finder.get抄本情報(parameter.get抄本番号());
        if (転出者お知らせハガキ一覧 != null) {
            parameter.set年齢到達期限日(転出者お知らせハガキ一覧.getKiteiNenreiTotatsuYMD());
        } else {
            parameter.set年齢到達期限日(FlexibleDate.EMPTY);
        }
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日 = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日 != null) {
            parameter.set前回基準日(前回基準日.get前回基準日());
        } else {
            parameter.set前回基準日(FlexibleDate.EMPTY);
        }
        NyujokenKobetsuJouhou 選挙 = mapper.select選挙の転入期限日(mybatisParameter);
        if (選挙 != null) {
            parameter.set転入期限日(選挙.get転入期限日());
            parameter.set転出日From(選挙.get転出期限日());
        } else {
            parameter.set転入期限日(FlexibleDate.EMPTY);
            parameter.set転出日From(FlexibleDate.EMPTY);
        }
        入場券印刷枚数表集計単位 = BusinessConfig.get(ConfigKeysAFA.入場券_印刷枚数表_集計単位, SubGyomuCode.AFA選挙本体);
        地区の分類１ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        地区の分類２ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        地区の分類３ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        入場券印刷枚数表_印刷世帯数 = new HashMap<>();
        入場券印刷枚数表_印刷枚数リスト = new HashMap<>();
        入場券印刷枚数表_人数リスト = new HashMap<>();
        入場券印刷枚数表_印刷世帯数リスト = new HashMap<>();
        男性の計 = Decimal.ZERO;
        女性の計 = Decimal.ZERO;
        imageFolderPath = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        nyujokenMaisuhyoDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NYUJOKENMAISUHYO, AFABTB201NyujokenMaisuhyoEntity.class);
    }

    @Override
    protected void process(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        get入場券_印刷枚数表_印刷世帯数(転出者お知らせハガキ一覧);
        get入場券_印刷枚数表_人数(転出者お知らせハガキ一覧);
        get表示者分対象情報(転出者お知らせハガキ一覧);
        if (flag == 2) {
            TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
            帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());

            TenshutsuOshiraseHagakiListParam param = new TenshutsuOshiraseHagakiListParam();
            param.set帳票共通ヘッダー(帳票共通ヘッダー);
            param.set抄本名(parameter.get抄本名());
            get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ一覧);
            param.set投票所入場券情報(edit投票所入場券情報(転出者お知らせハガキ一覧));
            param.set合計Flag(Boolean.FALSE);
            param = new TenshutsuOshiraseHagakiListPrintEditor().print転出者お知らせハガキ作成対象者一覧表(param);
            TenshutsuOshiraseHagakiListReport report = new TenshutsuOshiraseHagakiListReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (男性の計.compareTo(Decimal.ZERO) != 0 || 女性の計.compareTo(Decimal.ZERO) != 0) {
            TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
            帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());
            TenshutsuOshiraseHagakiListParam paramter = new TenshutsuOshiraseHagakiListParam();
            paramter.set帳票共通ヘッダー(帳票共通ヘッダー);
            paramter.set抄本名(parameter.get抄本名());
            RStringBuilder 集計 = new RStringBuilder();
            集計.append("** 転出者はがき作成対象者 **［男").append(男性の計)
                    .append("人］［女").append(女性の計).append("人］" + "［計")
                    .append(男性の計.add(女性の計)).append("人］");
            paramter.set合計出力内容(集計.toRString());
            paramter.set合計Flag(Boolean.TRUE);
            TenshutsuOshiraseHagakiListReport report = new TenshutsuOshiraseHagakiListReport(paramter);
            report.writeBy(reportSourceWriter);
            outTempTableName.setValue(TEMP_TABLE_NYUJOKENMAISUHYO);
        }
        for (RString key : 入場券印刷枚数表_印刷世帯数.keySet()) {
            入場券印刷枚数表_印刷世帯数リスト.put(key, 入場券印刷枚数表_印刷世帯数.get(key).size());
            AFABTB201NyujokenMaisuhyoEntity 転出者お知らせハガキ一覧情報 = new AFABTB201NyujokenMaisuhyoEntity();
            転出者お知らせハガキ一覧情報.setShuukeiTanni(入場券印刷枚数表集計単位);
            転出者お知らせハガキ一覧情報.setShuukeiCode(key);
            転出者お知らせハガキ一覧情報.setShutsuRyokuTaishou(parameter.getGroupKubun());
            転出者お知らせハガキ一覧情報.setBunjiKireKunbun(Boolean.FALSE);
            転出者お知らせハガキ一覧情報.setShuukeiName(get集計コード名称());
            転出者お知らせハガキ一覧情報.setShuukeiSetaisuSuji(new Decimal(入場券印刷枚数表_印刷世帯数.get(key).size()));
            転出者お知らせハガキ一覧情報.setShuukeiNinSuji(new Decimal(入場券印刷枚数表_人数リスト.get(key)));
            転出者お知らせハガキ一覧情報.setShuukeiMeisuSuji(new Decimal(入場券印刷枚数表_印刷枚数リスト.get(key)));
            nyujokenMaisuhyoDbWriter.insert(転出者お知らせハガキ一覧情報);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
        RString コピー元パースチェックリスト = batchReportWriter.getImageFolderPath();

        List<RString> イメージファイルパース = new ArrayList<>();

        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            イメージファイルパース.add(コピー元パースチェックリスト);
        }
        imageFolderPath.setValue(イメージファイルパース);
        Decimal 入場券発行固有連番 = batchReportWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番);
    }

    private TohyoJokyoJoho edit投票所入場券情報(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        TohyoJokyoJoho tohyoJokyoJoho = new TohyoJokyoJoho();
        tohyoJokyoJoho.set投票区コード(転出者お知らせハガキ一覧.get投票区コード());
        tohyoJokyoJoho.set名称(転出者お知らせハガキ一覧.get名称());
        tohyoJokyoJoho.set行(new RString(転出者お知らせハガキ一覧.get行()));
        tohyoJokyoJoho.set頁(new RString(転出者お知らせハガキ一覧.get頁()));
        tohyoJokyoJoho.set住民種別コード(転出者お知らせハガキ一覧.get住民種別コード());
        tohyoJokyoJoho.set性別コード(転出者お知らせハガキ一覧.get性別コード());
        if (転出者お知らせハガキ一覧.get生年月日() == null) {
            tohyoJokyoJoho.set生年月日(null);
        } else {
            tohyoJokyoJoho.set生年月日(new RDate(転出者お知らせハガキ一覧.get生年月日().toString()));
        }

        tohyoJokyoJoho.set住所(転出者お知らせハガキ一覧.get住所());
        tohyoJokyoJoho.set方書(転出者お知らせハガキ一覧.get方書() == null ? RString.EMPTY : 転出者お知らせハガキ一覧.get方書().getColumnValue());
        tohyoJokyoJoho.set番地(転出者お知らせハガキ一覧.get番地() == null ? RString.EMPTY : 転出者お知らせハガキ一覧.get番地().getColumnValue());
        if (転出者お知らせハガキ一覧.get登録届出年月日() == null) {
            tohyoJokyoJoho.set登録届出年月日(null);
        } else {
            tohyoJokyoJoho.set登録届出年月日(new RDate(転出者お知らせハガキ一覧.get登録届出年月日().toString()));
        }

        tohyoJokyoJoho.set識別コード(転出者お知らせハガキ一覧.get識別コード());
        return tohyoJokyoJoho;
    }

    private void get表示者分対象情報(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        RString 表示者用入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.入場券_表示者用入場券出力区分_出力しない.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            if (is表示者(転出者お知らせハガキ一覧)
                    && 表示者分対象_抽出終了日判定(転出者お知らせハガキ一覧)) {
                flag = 2;
            }
            if (is抹消者(転出者お知らせハガキ一覧)
                    && is二重登録抹消(転出者お知らせハガキ一覧)) {
                flag = 2;
            }
        }
    }

    private boolean is表示者(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        mybatisParameter.set識別コード(転出者お知らせハガキ一覧.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is表示者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日(), parameter.get投票日(), parameter.get前回基準日(),
                SenkyoShurui.toValue(parameter.get選挙種類()));
    }

    private boolean is抹消者(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        mybatisParameter.set識別コード(転出者お知らせハガキ一覧.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is抹消者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日());
    }

    private boolean 表示者分対象_抽出終了日判定(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(転出者お知らせハガキ一覧);
        boolean isBlank = Boolean.TRUE;
        if (!FlexibleDate.EMPTY.equals(parameter.get転出日From())
                && FlexibleDate.EMPTY.equals(parameter.get転出日To())) {
            isBlank = parameter.get転出日From().isBeforeOrEquals(転出日)
                    && !parameter.get転出日To().isBefore(転出日);
        }
        if (ShutsuryokuShuryohiEnum.投票日を含めない.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日().minusDay(1)) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日()) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().minusDay(1).toDateString())) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().toDateString())) && isBlank;
        }
        return Boolean.FALSE;

    }

    private FlexibleDate get転出日(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        FlexibleDate 転出日 = FlexibleDate.EMPTY;
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        if (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = 転出者お知らせハガキ一覧.get消除届出年月日();
        } else if (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = 転出者お知らせハガキ一覧.get消除異動年月日();
        }
        return 転出日;
    }

    private boolean is二重登録抹消(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        AfT113SenkyoShikakuEntity 選挙資格 = finder.get選挙資格情報(parameter.get選挙種類(), 転出者お知らせハガキ一覧.get識別コード());
        if (選挙資格 != null && MasshoJiyuCodeEnum.二重登録抹消.getCode().equals(選挙資格.getMasshoJiyuCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void get入場券_印刷枚数表_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷世帯数(転出者お知らせハガキ一覧);

        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷世帯数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷世帯数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷世帯数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷世帯数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷世帯数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷世帯数(転出者お知らせハガキ一覧);
        }
    }

    private void get投票区コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ一覧.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get投票所コード())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get投票区コード()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get投票区コード(), 同一世帯コード);
        }
    }

    private void get住所コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get町域コード().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get町域コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get行政区コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get行政区コード().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get行政区コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード1_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get地区コード１().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get地区コード１().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード2_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get地区コード２().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get地区コード２().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード3_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get地区コード３().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get地区コード３().getColumnValue(), 同一世帯コード);
        }
    }

    private void get郵便番号_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ一覧.get郵便番号().getColumnValue()).add(転出者お知らせハガキ一覧.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ一覧.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ一覧.get郵便番号().getColumnValue(), 同一世帯コード);
        }
    }

    private void get入場券_印刷枚数表_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_人数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_人数(転出者お知らせハガキ一覧);
        }
    }

    private void get投票区コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ一覧.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get投票所コード())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get投票区コード(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get投票区コード(), 1);
        }
    }

    private void get住所コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get町域コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ一覧.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ一覧.get郵便番号().getColumnValue(), 1);
        }
    }

    private void get入場券_印刷枚数表_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷枚数(転出者お知らせハガキ一覧);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷枚数(転出者お知らせハガキ一覧);
        }
    }

    private void get投票区コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ一覧.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get投票所コード())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get投票区コード(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get投票区コード(), 1);
        }
    }

    private void get住所コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get町域コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ一覧) {
        if (転出者お知らせハガキ一覧.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ一覧.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ一覧.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ一覧.get郵便番号().getColumnValue(), 1);
        }
    }

    private RString get集計コード名称() {
        RString 集計コード名称 = RString.EMPTY;
        if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_投票区コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_投票区コード.getValue();
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_住所コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_住所コード.getValue();
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_行政区コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_行政区コード.getValue();
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類１;
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類２;
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類３;
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_郵便番号.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_郵便番号.getValue();
        }
        return 集計コード名称;
    }
}
