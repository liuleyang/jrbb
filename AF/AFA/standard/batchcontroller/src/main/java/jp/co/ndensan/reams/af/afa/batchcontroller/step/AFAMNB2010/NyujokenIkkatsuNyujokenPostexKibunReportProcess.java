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
import jp.co.ndensan.reams.af.afa.batchcontroller.common.NyujokenIkkatsu;
import jp.co.ndensan.reams.af.afa.business.core.MeisaiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.business.core.SoufusakiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu.NyujokenIkkatsuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB204.NyujokenPostexReport;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAShokeitanniTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB204.NyujokenPostexPrintEditor;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（一括）の投票所入場券（ポステックス）のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuNyujokenPostexKibunReportProcess extends BatchKeyBreakBase<AFABTB201MeiciJyohouSoufusakiEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private OutputParameter<RString> outTempTableName;

    private static final int ページ件数_THREE = 3;
    private static final int ページ件数_FOUR = 4;
    private static final int ページ件数_FIVE = 5;
    private static final int ページ件数_SIX = 6;
    private static final RString TEMP_TABLE_NYUJOKENMAISUHYO = new RString("AFAPRB212_NyujokenMaisuhyo");
    private List<RString> 改ページキーリスト = new ArrayList<>();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectMeiciJyohouSoufusakiTempTable");
    @BatchWriter
    private IBatchReportWriterWithCheckList<NyujokenPostexSource> batchReportWCLWriter;
    private ReportSourceWriter<NyujokenPostexSource> reportSourceWCLWriter;
    @BatchWriter
    private BatchReportWriter<NyujokenPostexSource> batchReportWriter;
    private ReportSourceWriter<NyujokenPostexSource> reportSourceWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter nyujokenMaisuhyoDbWriter;
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
    OutputParameter<Decimal> nyujokenReportIndex;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    private static Map<RString, Set<SetaiCode>> 入場券印刷枚数表_印刷世帯数;
    private static Map<RString, Integer> 入場券印刷枚数表_人数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷枚数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷世帯数リスト;

    OutputParameter<Integer> pageCount;
    private int itemCount;
    private int mojiKireItemCount;
    private NyujokenPostexParam param;
    private NyujokenPostexParam mojiKireParam;
    private boolean is改ページ;
    private boolean is文字切れ改ページ;
    private boolean isHasChange;
    private boolean isMojiKireHasChange;
    private Association 地方公共団体情報;
    private RString 入場券印刷枚数表集計単位;
    private RString 地区の分類１;
    private RString 地区の分類２;
    private RString 地区の分類３;
    private int 印字人数;
    private AFABTB201MeiciJyohouSoufusakiEntity 文字切れない情報;
    private AFABTB201MeiciJyohouSoufusakiEntity 文字切れ情報;
    private NyujoukenGamenModel 選挙共通情報;
    private ICounter counter;

    @Override
    protected void initialize() {
        is改ページ = Boolean.FALSE;
        is文字切れ改ページ = Boolean.FALSE;
        isHasChange = Boolean.FALSE;
        isMojiKireHasChange = Boolean.FALSE;
        改ページキーリスト = parameter.get改頁項目IDリスト();
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable(parameter.getTable());
        mybatisParameter.setTable1(parameter.getSoufusakiJouhoutable());
        mybatisParameter.setGroupKubun(parameter.getGroupKubun());
        itemCount = 0;
        mojiKireItemCount = 0;
        pageCount = new OutputParameter<>();
        nyujokenReportIndex = new OutputParameter<>();

        imageFolderPath = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        選挙共通情報 = get選挙共通情報(parameter, 地方公共団体情報);
        param = new NyujokenPostexParam(
                選挙共通情報,
                null,
                null,
                null, null,
                null,
                null,
                null, null,
                null, null, null, null);
        param.set地方公共団体情報(地方公共団体情報);
        mojiKireParam = new NyujokenPostexParam(
                選挙共通情報,
                null,
                null,
                null, null,
                null,
                null,
                null, null,
                null, null, null, null);
        mojiKireParam.set地方公共団体情報(地方公共団体情報);
        outTempTableName = new OutputParameter<>();
        RString 世帯印字人数 = BusinessConfig.get(ConfigKeysAFA.入場券_世帯印字人数, SubGyomuCode.AFA選挙本体);
        印字人数 = RString.isNullOrEmpty(世帯印字人数) ? 0 : Integer.parseInt(世帯印字人数.toString());
        入場券印刷枚数表集計単位 = BusinessConfig.get(ConfigKeysAFA.入場券_印刷枚数表_集計単位, SubGyomuCode.AFA選挙本体);
        地区の分類１ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        地区の分類２ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        地区の分類３ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        入場券印刷枚数表_印刷世帯数 = new HashMap<>();
        入場券印刷枚数表_印刷枚数リスト = new HashMap<>();
        入場券印刷枚数表_人数リスト = new HashMap<>();
        入場券印刷枚数表_印刷世帯数リスト = new HashMap<>();
        counter = CounterFactory.createInstance(入場券印刷枚数表集計単位);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWCLWriter = NyujokenIkkatsu.mojiCutListOut(
                ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value(),
                batchReportWCLWriter);
        reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        nyujokenMaisuhyoDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NYUJOKENMAISUHYO, AFABTB201NyujokenMaisuhyoEntity.class);
    }

    @Override
    protected void keyBreakProcess(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        NyujokenIkkatsuEditor nyujokenIkkatsuEditor = new NyujokenIkkatsuEditor();
        boolean is文字切れ = nyujokenIkkatsuEditor.check文字切れForポステックス(ポステックス別出力情報);
        if (is文字切れ) {
            if (is改ページ(改ページキーリスト, 文字切れ情報, ポステックス別出力情報)) {
                is文字切れ改ページ = Boolean.TRUE;
            } else {
                is文字切れ改ページ = Boolean.FALSE;
            }
            if (文字切れ情報 == null
                    || ポステックス別出力情報.get世帯コード().equals(文字切れ情報.get世帯コード())) {
                isMojiKireHasChange = Boolean.FALSE;
            } else {
                isMojiKireHasChange = Boolean.TRUE;
            }

        } else {
            if (is改ページ(改ページキーリスト, 文字切れない情報, ポステックス別出力情報)) {
                is改ページ = Boolean.TRUE;
            } else {
                is改ページ = Boolean.FALSE;
            }
            if (文字切れない情報 == null
                    || ポステックス別出力情報.get世帯コード().equals(文字切れない情報.get世帯コード())) {
                isHasChange = Boolean.FALSE;
            } else {
                isHasChange = Boolean.TRUE;
            }
        }

    }

    @Override
    protected void usualProcess(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        get入場券_印刷枚数表_印刷世帯数(ポステックス別出力情報);
        get入場券_印刷枚数表_人数(ポステックス別出力情報);
        NyujokenIkkatsuEditor nyujokenIkkatsuEditor = new NyujokenIkkatsuEditor();
        boolean is文字切れ = nyujokenIkkatsuEditor.check文字切れForポステックス(ポステックス別出力情報);
        if (is文字切れ) {
            edit文字切れ入場券(ポステックス別出力情報);
            文字切れ情報 = ポステックス別出力情報;
        } else {
            edit入場券(ポステックス別出力情報);
            文字切れない情報 = ポステックス別出力情報;
        }

    }

    private void edit文字切れ入場券(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        NyujokenPostexPrintEditor editor = new NyujokenPostexPrintEditor();
        if (is文字切れ改ページ || isMojiKireHasChange) {
            NyujokenPostexReport report = new NyujokenPostexReport(mojiKireParam);
            report.writeBy(reportSourceWCLWriter);
            mojiKireParam = new NyujokenPostexParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            mojiKireParam.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            mojiKireParam.set送付先情報1(送付先情報1);
            mojiKireParam = editor.set送付先情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            mojiKireParam = editor.set明細情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            mojiKireItemCount = 1;
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
        } else {
            edit文字切れ送付先情報と明細情報(nyujoken3tsuori, editor, ポステックス別出力情報);
        }
    }

    private void edit入場券(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        NyujokenPostexPrintEditor editor = new NyujokenPostexPrintEditor();
        if (is改ページ || isHasChange) {
            NyujokenPostexReport report = new NyujokenPostexReport(param);
            report.writeBy(reportSourceWriter);
            param = new NyujokenPostexParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            param.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            param.set送付先情報1(送付先情報1);
            param = editor.set送付先情報1_ポステックス(param, nyujoken3tsuori);
            param = editor.set明細情報1_ポステックス(param, nyujoken3tsuori);
            itemCount = 1;
            param.set地方公共団体情報(地方公共団体情報);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
        } else {
            edit送付先情報と明細情報(nyujoken3tsuori, editor, ポステックス別出力情報);
        }
    }

    @Override
    protected void afterExecute() {
        if (mojiKireParam.get明細情報1() != null) {
            NyujokenPostexReport mojiKireReport = new NyujokenPostexReport(mojiKireParam);
            mojiKireReport.writeBy(reportSourceWCLWriter);
        }
        if (param.get明細情報1() != null) {
            NyujokenPostexReport report = new NyujokenPostexReport(param);
            report.writeBy(reportSourceWriter);
        }
        for (RString key : 入場券印刷枚数表_印刷世帯数.keySet()) {
            入場券印刷枚数表_印刷世帯数リスト.put(key, 入場券印刷枚数表_印刷世帯数.get(key).size());
            AFABTB201NyujokenMaisuhyoEntity ポステックス別出力情報 = new AFABTB201NyujokenMaisuhyoEntity();
            ポステックス別出力情報.setShuukeiTanni(入場券印刷枚数表集計単位);
            ポステックス別出力情報.setShuukeiCode(key);
            ポステックス別出力情報.setShutsuRyokuTaishou(parameter.getGroupKubun());
            ポステックス別出力情報.setBunjiKireKunbun(Boolean.FALSE);
            ポステックス別出力情報.setShuukeiName(get集計コード名称());
            ポステックス別出力情報.setShuukeiSetaisuSuji(new Decimal(入場券印刷枚数表_印刷世帯数.get(key).size()));
            ポステックス別出力情報.setShuukeiNinSuji(new Decimal(入場券印刷枚数表_人数リスト.get(key)));
            ポステックス別出力情報.setShuukeiMeisuSuji(new Decimal(入場券印刷枚数表_印刷枚数リスト.get(key)));
            nyujokenMaisuhyoDbWriter.insert(ポステックス別出力情報);
        }
        pageCount.setValue(batchReportWCLWriter.getPageCount() + batchReportWriter.getPageCount());
        RString コピー元パース = batchReportWriter.getImageFolderPath();
        RString コピー元パースチェックリスト = batchReportWCLWriter.getImageFolderPath();

        List<RString> イメージファイルパース = new ArrayList<>();
        if (!RString.isNullOrEmpty(コピー元パース)) {
            イメージファイルパース.add(コピー元パース);
        }
        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            イメージファイルパース.add(コピー元パースチェックリスト);
        }
        imageFolderPath.setValue(イメージファイルパース);
        Decimal 入場券発行固有連番 = batchReportWriter.getReportIndex().getReportIndex();
        Decimal 入場券発行固有連番_チェック = batchReportWCLWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番.compareTo(入場券発行固有連番_チェック) > 0
                ? 入場券発行固有連番 : 入場券発行固有連番_チェック);
        outTempTableName.setValue(TEMP_TABLE_NYUJOKENMAISUHYO);
    }

    private void edit文字切れ送付先情報と明細情報(
            Nyujoken3tsuori nyujoken3tsuori,
            NyujokenPostexPrintEditor editor,
            AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        if (mojiKireItemCount == 0 && 印字人数 > 0) {
            mojiKireParam.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            mojiKireParam.set送付先情報1(送付先情報1);
            mojiKireParam = editor.set送付先情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            mojiKireParam = editor.set明細情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == 1 && 印字人数 > 1) {
            mojiKireParam.set明細情報2(edit明細情報(ポステックス別出力情報));
            mojiKireParam = editor.set明細情報2_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == 2 && 印字人数 > 2) {
            mojiKireParam.set明細情報3(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報3 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報3.set整理番号(ページ件数_THREE);
            mojiKireParam = editor.set明細情報3_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == ページ件数_THREE && 印字人数 > ページ件数_THREE) {
            mojiKireParam.set明細情報4(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報4 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報4.set整理番号(ページ件数_FOUR);
            mojiKireParam = editor.set明細情報4_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == ページ件数_FOUR && 印字人数 > 0) {
            mojiKireParam.set明細情報5(edit明細情報(ポステックス別出力情報));
            mojiKireParam = editor.set明細情報5_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == ページ件数_FIVE && 印字人数 > 1) {
            mojiKireParam.set明細情報6(edit明細情報(ポステックス別出力情報));
            mojiKireParam = editor.set明細情報6_ポステックス(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            mojiKireItemCount++;
        } else if (mojiKireItemCount == ページ件数_SIX) {
            NyujokenPostexReport report = new NyujokenPostexReport(mojiKireParam);
            report.writeBy(reportSourceWCLWriter);
            mojiKireParam = new NyujokenPostexParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            mojiKireParam.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            mojiKireParam.set送付先情報1(送付先情報1);
            mojiKireParam = editor.set送付先情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            mojiKireParam = editor.set明細情報1_ポステックス(mojiKireParam, nyujoken3tsuori);
            mojiKireItemCount = 1;
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
        }
    }

    private void edit送付先情報と明細情報(
            Nyujoken3tsuori nyujoken3tsuori,
            NyujokenPostexPrintEditor editor,
            AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        if (itemCount == 0 && 印字人数 > 0) {
            param.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            param.set送付先情報1(送付先情報1);
            param = editor.set送付先情報1_ポステックス(param, nyujoken3tsuori);
            param = editor.set明細情報1_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            param.set地方公共団体情報(地方公共団体情報);
            itemCount++;
        } else if (itemCount == 1 && 印字人数 > 1) {
            param.set明細情報2(edit明細情報(ポステックス別出力情報));
            param = editor.set明細情報2_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            param.set地方公共団体情報(地方公共団体情報);
            itemCount++;
        } else if (itemCount == 2 && 印字人数 > 2) {
            param.set明細情報3(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報3 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報3.set整理番号(ページ件数_THREE);
            param = editor.set明細情報3_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            param.set地方公共団体情報(地方公共団体情報);
            itemCount++;
        } else if (itemCount == ページ件数_THREE && 印字人数 > ページ件数_THREE) {
            param.set明細情報4(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報4 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報4.set整理番号(ページ件数_FOUR);
            param = editor.set明細情報4_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            param.set地方公共団体情報(地方公共団体情報);
            itemCount++;
        } else if (itemCount == ページ件数_FOUR && 印字人数 > 0) {
            param.set明細情報5(edit明細情報(ポステックス別出力情報));
            param = editor.set明細情報5_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            itemCount++;
            param.set地方公共団体情報(地方公共団体情報);
        } else if (itemCount == ページ件数_FIVE && 印字人数 > 1) {
            param.set明細情報6(edit明細情報(ポステックス別出力情報));
            param = editor.set明細情報6_ポステックス(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
            itemCount++;
            param.set地方公共団体情報(地方公共団体情報);
        } else if (itemCount == ページ件数_SIX) {
            NyujokenPostexReport report = new NyujokenPostexReport(param);
            report.writeBy(reportSourceWriter);
            param = new NyujokenPostexParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            param.set明細情報1(edit明細情報(ポステックス別出力情報));
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(ポステックス別出力情報);
            送付先情報1.set整理番号(1);
            param.set送付先情報1(送付先情報1);
            param = editor.set送付先情報1_ポステックス(param, nyujoken3tsuori);
            param = editor.set明細情報1_ポステックス(param, nyujoken3tsuori);
            itemCount = 1;
            param.set地方公共団体情報(地方公共団体情報);
            get入場券_印刷枚数表_印刷枚数(ポステックス別出力情報);
        }
    }

    private SoufusakiJouhou changeEntityToSoufusakiJouhou(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntiy) {
        SoufusakiJouhou ポステックス_送付先情報 = new SoufusakiJouhou();
        ポステックス_送付先情報.set世帯主名(soufusakiJouhouEntiy.get送付先世帯主名());
        ポステックス_送付先情報.set送付先世帯コード(soufusakiJouhouEntiy.get送付先世帯コード());
        ポステックス_送付先情報.set送付先住所(soufusakiJouhouEntiy.get送付先住所());
        ポステックス_送付先情報.set送付先名簿_行(soufusakiJouhouEntiy.get送付先名簿_行());
        ポステックス_送付先情報.set送付先名簿_頁(soufusakiJouhouEntiy.get送付先名簿_頁());
        ポステックス_送付先情報.set送付先地区コード1(soufusakiJouhouEntiy.get送付先地区コード1());
        ポステックス_送付先情報.set送付先地区名1(soufusakiJouhouEntiy.get送付先地区名1());
        ポステックス_送付先情報.set送付先宛名(soufusakiJouhouEntiy.get送付先宛名());
        ポステックス_送付先情報.set送付先投票区コード(soufusakiJouhouEntiy.get送付先投票区コード());
        ポステックス_送付先情報.set送付先方書(soufusakiJouhouEntiy.get送付先方書());
        ポステックス_送付先情報.set送付先番地(soufusakiJouhouEntiy.get送付先番地());
        ポステックス_送付先情報.set送付先行政区コード(soufusakiJouhouEntiy.get送付先行政区コード());
        ポステックス_送付先情報.set送付先行政区名(soufusakiJouhouEntiy.get送付先行政区名());
        ポステックス_送付先情報.set送付先郵便番号(soufusakiJouhouEntiy.get送付先郵便番号());
        return ポステックス_送付先情報;
    }

    private MeisaiJouhou edit明細情報(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        MeisaiJouhou 明細情報 = new MeisaiJouhou();
        明細情報.setカナ名称(ポステックス別出力情報.getカナ名称());
        明細情報.set世帯コード(ポステックス別出力情報.get世帯コード());
        明細情報.set世帯主名(ポステックス別出力情報.get世帯主名());
        明細情報.set住民種別コード(ポステックス別出力情報.get住民種別コード());
        明細情報.set住登内住所(
                ポステックス別出力情報.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(ポステックス別出力情報.get住所()));
        if (ポステックス別出力情報.get全国住所コード() == null) {
            明細情報.set住登内町域コード(ポステックス別出力情報.get全国住所コード().getColumnValue());
        } else {
            明細情報.set住登内町域コード(RString.EMPTY);
        }
        明細情報.set住登内番地(ポステックス別出力情報.get番地());
        if (ポステックス別出力情報.get地区コード１() == null) {
            明細情報.set地区コード1(ポステックス別出力情報.get地区コード１().getColumnValue());
        } else {
            明細情報.set地区コード1(RString.EMPTY);
        }
        if (ポステックス別出力情報.get地区コード２() == null) {
            明細情報.set地区コード2(ポステックス別出力情報.get地区コード２().getColumnValue());
        } else {
            明細情報.set地区コード2(RString.EMPTY);
        }
        if (ポステックス別出力情報.get地区コード３() == null) {
            明細情報.set地区コード3(ポステックス別出力情報.get地区コード３().getColumnValue());
        } else {
            明細情報.set地区コード3(RString.EMPTY);
        }
        明細情報.set地区名1(ポステックス別出力情報.get地区名１());
        明細情報.set地区名2(ポステックス別出力情報.get地区名２());
        明細情報.set地区名3(ポステックス別出力情報.get地区名３());
        明細情報.set性別コード(ポステックス別出力情報.get性別コード());
        明細情報.set投票区コード(ポステックス別出力情報.get投票区コード());
        明細情報.set投票区名(ポステックス別出力情報.get投票区名());
        明細情報.set投票所名(ポステックス別出力情報.get投票所名());
        if (ポステックス別出力情報.get投票所の住所() == null) {
            明細情報.set投票所＿住所(ポステックス別出力情報.get投票所の住所().getColumnValue());
        } else {
            明細情報.set投票所＿住所(RString.EMPTY);
        }
        明細情報.set続柄コード(ポステックス別出力情報.get続柄コード().getColumnValue());
        明細情報.set生年月日(changeFlexibleDateToRDate(ポステックス別出力情報.get生年月日()));

        明細情報.set投票開始時刻(ポステックス別出力情報.get投票開始時刻());
        明細情報.set投票終了時刻(ポステックス別出力情報.get投票終了時刻());
        if (ポステックス別出力情報.get行政区コード() == null) {
            明細情報.set行政区コード(ポステックス別出力情報.get行政区コード().getColumnValue());
        } else {
            明細情報.set行政区コード(RString.EMPTY);
        }
        明細情報.set行政区名(ポステックス別出力情報.get行政区名());
        明細情報.set名称(ポステックス別出力情報.get名称());
        明細情報.set頁(ポステックス別出力情報.get頁());
        明細情報.set行(ポステックス別出力情報.get行());
        明細情報.set識別コード(ポステックス別出力情報.get識別コード());
        明細情報.set住民票表示順(ポステックス別出力情報.get住民票表示順());
        return 明細情報;
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param ポステックス別出力情報引数 AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報(AFABTB201SelectProcessParameter ポステックス別出力情報引数,
            Association 地方公共団体情報) {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        nyujoukenGamenModel.set抄本番号(new RString(ポステックス別出力情報引数.get抄本番号().getColumnValue()));
        nyujoukenGamenModel.set抄本名(ポステックス別出力情報引数.get抄本名());
        nyujoukenGamenModel.set入場券名称1(ポステックス別出力情報引数.get入場券名1());
        nyujoukenGamenModel.set入場券名称2(ポステックス別出力情報引数.get入場券名2());
        nyujoukenGamenModel.set入場券名称3(ポステックス別出力情報引数.get入場券名3());
        nyujoukenGamenModel.setサンプル文字(ポステックス別出力情報引数.getサンプル文字());
        FlexibleDate 投票日 = ポステックス別出力情報引数.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(ポステックス別出力情報引数.get投票日().toString()));
        List<SenkyomeishouParam> 選挙名称リスト = new ArrayList<>();
        if (ポステックス別出力情報引数.get選挙リスト() != null
                && !ポステックス別出力情報引数.get選挙リスト().isEmpty()) {
            for (Senkyomeishou senkyomeishou : ポステックス別出力情報引数.get選挙リスト()) {
                SenkyomeishouParam senkyomeishouParam = new SenkyomeishouParam();
                senkyomeishouParam.set選挙名称(senkyomeishou.get選挙名称());
                senkyomeishouParam.set選挙略称(senkyomeishou.get選挙略称());
                選挙名称リスト.add(senkyomeishouParam);
            }
            nyujoukenGamenModel.set選挙名称(選挙名称リスト);
        }
        nyujoukenGamenModel.set告示年月日(RDate.MAX);
        nyujoukenGamenModel.set地方公共団体情報(地方公共団体情報);
        return nyujoukenGamenModel;
    }

    private RDate changeFlexibleDateToRDate(FlexibleDate flexibleDate) {
        if (flexibleDate != null && !flexibleDate.isEmpty() && flexibleDate.isValid()) {
            return new RDate(flexibleDate.toString());
        } else {
            return null;
        }
    }

    private boolean is改ページ(List<RString> 改ページキーリスト,
            AFABTB201MeiciJyohouSoufusakiEntity before明細情報,
            AFABTB201MeiciJyohouSoufusakiEntity after明細情報) {
        if (改ページキーリスト == null || 改ページキーリスト.isEmpty()) {
            return Boolean.FALSE;
        }
        if (before明細情報 == null) {
            return Boolean.FALSE;
        }
        RString 投票区コードBefore = before明細情報.get投票区コード();
        RString 投票区コードAfter = after明細情報.get投票区コード();
        Boolean is改ページFlag = is改ページ_投票区コード(改ページキーリスト, 投票区コードBefore, 投票区コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        RString 行政区コードBefore = before明細情報.get行政区コード() == null
                ? RString.EMPTY : before明細情報.get行政区コード().getColumnValue();
        RString 行政区コードAfter = after明細情報.get行政区コード() == null
                ? RString.EMPTY : after明細情報.get行政区コード().getColumnValue();
        is改ページFlag = is改ページ_行政区コード(改ページキーリスト, 行政区コードBefore, 行政区コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        AtenaMeisho カナ世帯主名Before = before明細情報.get世帯主名();
        AtenaMeisho カナ世帯主名After = after明細情報.get世帯主名();
        is改ページFlag = is改ページ_カナ世帯主名(改ページキーリスト, カナ世帯主名Before, カナ世帯主名After);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        SetaiCode 世帯コードBefore = before明細情報.get世帯コード();
        SetaiCode 世帯コードAfter = after明細情報.get世帯コード();
        is改ページFlag = is改ページ_世帯コード(改ページキーリスト, 世帯コードBefore, 世帯コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        int 住基表示順Before = before明細情報.get住民票表示順();
        int 住基表示順After = after明細情報.get住民票表示順();
        is改ページFlag = is改ページ_住基表示順(改ページキーリスト, 住基表示順Before, 住基表示順After);
        return is改ページFlag;
    }

    private boolean is改ページ_投票区コード(List<RString> 改ページキーリスト,
            RString 投票区コードBefore,
            RString 投票区コードAfter) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.投票区コード.get項目ID())) {
            if (RString.isNullOrEmpty(投票区コードBefore) && RString.isNullOrEmpty(投票区コードAfter)) {
                is改ページFlag = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(投票区コードBefore)
                    && !RString.isNullOrEmpty(投票区コードAfter)
                    && 投票区コードBefore.equals(投票区コードAfter)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_行政区コード(List<RString> 改ページキーリスト,
            RString before行政区コード,
            RString after行政区コード) {
        Boolean is改ページFlag = Boolean.FALSE;

        if (改ページキーリスト.contains(ReportOutputType.行政区コード.get項目ID())) {
            if (RString.isNullOrEmpty(before行政区コード) && RString.isNullOrEmpty(after行政区コード)) {
                is改ページFlag = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(before行政区コード)
                    && !RString.isNullOrEmpty(after行政区コード)
                    && before行政区コード.equals(after行政区コード)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_カナ世帯主名(List<RString> 改ページキーリスト,
            AtenaMeisho beforeカナ世帯主名,
            AtenaMeisho afterカナ世帯主名) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.カナ世帯主名.get項目ID())) {
            if (beforeカナ世帯主名 == null && afterカナ世帯主名 == null) {
                is改ページFlag = Boolean.FALSE;
            } else if (beforeカナ世帯主名 != null
                    && afterカナ世帯主名 != null
                    && beforeカナ世帯主名.equals(afterカナ世帯主名)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_世帯コード(List<RString> 改ページキーリスト,
            SetaiCode before世帯コード,
            SetaiCode after世帯コード) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.世帯コード.get項目ID())) {

            if (before世帯コード == null && after世帯コード == null) {
                is改ページFlag = Boolean.FALSE;
            } else if (before世帯コード != null
                    && after世帯コード != null
                    && before世帯コード.equals(after世帯コード)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_住基表示順(List<RString> 改ページキーリスト,
            int before住基表示順,
            int after住基表示順) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.住民票表示順.get項目ID())) {
            if (before住基表示順 == after住基表示順) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private void get入場券_印刷枚数表_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        counter.countSetai(ポステックス別出力情報);
    }

    private void get入場券_印刷枚数表_人数(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        counter.countNinzu(ポステックス別出力情報);
    }

    private void get入場券_印刷枚数表_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
        counter.countMaisu(ポステックス別出力情報);
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


    private static class CounterFactory {

        private static ICounter createInstance(RString 入場券印刷枚数表集計単位) {
            if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
                return new ＴohyojoCodeCounter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
                return new JushoCodeCounter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
                return new GyoseikuCodeCounter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
                return new ChikuCode_1_Counter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
                return new ChikuCode_2_Counter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
                return new ChikuCode_3_Counter();
            } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
                return new YubinNoCounter();
            }
            return null;
        }
    }

    private interface ICounter {

        void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報);

        void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報);

        void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報);
    }

    private static class ＴohyojoCodeCounter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (RString.isNullOrEmpty(ポステックス別出力情報.get投票区コード())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get投票所コード())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get投票区コード()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get投票区コード(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
             if (ポステックス別出力情報.get町域コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get町域コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get町域コード().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get町域コード().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get町域コード().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (RString.isNullOrEmpty(ポステックス別出力情報.get投票区コード())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get投票所コード())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get投票区コード(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get投票区コード()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get投票区コード(), 1);
            }
        }
    }

    private static class JushoCodeCounter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get町域コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get町域コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get町域コード().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get町域コード().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get町域コード().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get町域コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get町域コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get町域コード().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get町域コード().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get町域コード().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get町域コード().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get町域コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get町域コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get町域コード().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get町域コード().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get町域コード().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get町域コード().getColumnValue(), 1);
            }
        }
    }

    private static class GyoseikuCodeCounter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get行政区コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get行政区コード().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get行政区コード().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get行政区コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get行政区コード().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get行政区コード().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get行政区コード().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get行政区コード() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get行政区コード().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get行政区コード().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get行政区コード().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get行政区コード().getColumnValue(), 1);
            }
        }
    }

    private static class ChikuCode_1_Counter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
             if (ポステックス別出力情報.get地区コード１() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get地区コード１().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get地区コード１().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード１() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード１().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get地区コード１().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード１().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード１() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get地区コード１().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード１().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get地区コード１().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード１().getColumnValue(), 1);
            }
        }
    }

    private static class ChikuCode_2_Counter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード２() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get地区コード２().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get地区コード２().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード２() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード２().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get地区コード２().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード２().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード２() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get地区コード２().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード２().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get地区コード２().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード２().getColumnValue(), 1);
            }
        }
    }

    private static class ChikuCode_3_Counter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード３() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get地区コード３().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get地区コード３().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード３() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード３().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get地区コード３().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get地区コード３().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get地区コード３() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get地区コード３().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード３().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get地区コード３().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get地区コード３().getColumnValue(), 1);
            }
        }
    }

    private static class YubinNoCounter implements ICounter {

        @Override
        public void countSetai(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get郵便番号() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷世帯数.containsKey(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                入場券印刷枚数表_印刷世帯数.get(ポステックス別出力情報.get郵便番号().getColumnValue()).add(ポステックス別出力情報.get世帯コード());
            } else {
                Set<SetaiCode> 同一世帯コード = new HashSet<>();
                同一世帯コード.add(ポステックス別出力情報.get世帯コード());
                入場券印刷枚数表_印刷世帯数.put(ポステックス別出力情報.get郵便番号().getColumnValue(), 同一世帯コード);
            }
        }

        @Override
        public void countMaisu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get郵便番号() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_印刷枚数リスト.containsKey(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get郵便番号().getColumnValue(),
                        入場券印刷枚数表_印刷枚数リスト.get(ポステックス別出力情報.get郵便番号().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_印刷枚数リスト.put(ポステックス別出力情報.get郵便番号().getColumnValue(), 1);
            }
        }

        @Override
        public void countNinzu(AFABTB201MeiciJyohouSoufusakiEntity ポステックス別出力情報) {
            if (ポステックス別出力情報.get郵便番号() == null
                    || RString.isNullOrEmpty(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                return;
            }
            if (入場券印刷枚数表_人数リスト.containsKey(ポステックス別出力情報.get郵便番号().getColumnValue())) {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get郵便番号().getColumnValue(),
                        入場券印刷枚数表_人数リスト.get(ポステックス別出力情報.get郵便番号().getColumnValue()) + 1);
            } else {
                入場券印刷枚数表_人数リスト.put(ポステックス別出力情報.get郵便番号().getColumnValue(), 1);
            }
        }
    }
}
