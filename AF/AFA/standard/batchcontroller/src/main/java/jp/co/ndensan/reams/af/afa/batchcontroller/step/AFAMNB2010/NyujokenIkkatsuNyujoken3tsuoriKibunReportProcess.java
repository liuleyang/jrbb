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
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.business.core.SoufusakiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu.NyujokenIkkatsuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB201.Nyujoken3tsuoriReport;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAShokeitanniTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB201.Nyujoken3tsuoriPrintEditor;
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
 * 入場券発行（一括）の投票所入場券（個票3つ折）のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuNyujoken3tsuoriKibunReportProcess extends BatchKeyBreakBase<AFABTB201MeiciJyohouSoufusakiEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private OutputParameter<RString> outTempTableName;

    private static final int ページ最大件数 = 3;
    private static final int 改ページ_個票3つ折り = 3;
    private static final RString TEMP_TABLE_NYUJOKENMAISUHYO = new RString("AFAPRB212_NyujokenMaisuhyo");
    private List<RString> 改ページキーリスト = new ArrayList<>();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectMeiciJyohouSoufusakiTempTable");
    @BatchWriter
    private IBatchReportWriterWithCheckList<Nyujoken3tsuoriSource> batchReportWCLWriter;
    private ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWCLWriter;
    @BatchWriter
    private BatchReportWriter<Nyujoken3tsuoriSource> batchReportWriter;
    private ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter nyujokenMaisuhyoDbWriter;
    /**
     * 送付先情報_temp取得。
     *
     */

    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
    }
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
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }
    private static Map<RString, Integer> 入場券印刷枚数表_印刷世帯数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷枚数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_人数リスト;

    OutputParameter<Integer> pageCount;
    OutputParameter<Decimal> nyujokenReportIndex;
    private Map<RString, Set<SetaiCode>> 入場券印刷枚数表_印刷世帯数;
    private int itemCount;
    private int mojiKireItemCount;
    private Nyujoken3tsuoriParam param;
    private Nyujoken3tsuoriParam mojiKireParam;
    private boolean is改ページ;
    private boolean is文字切れ改ページ;
    private Association 地方公共団体情報;
    private RString 入場券印刷枚数表集計単位;
    private RString 地区の分類１;
    private RString 地区の分類２;
    private RString 地区の分類３;
    private AFABTB201MeiciJyohouSoufusakiEntity 文字切れない情報;
    private AFABTB201MeiciJyohouSoufusakiEntity 文字切れ情報;
    private NyujoukenGamenModel 選挙共通情報;
    
    @Override
    protected void initialize() {
        outTempTableName = new OutputParameter<>();
        入場券印刷枚数表集計単位 = BusinessConfig.get(ConfigKeysAFA.入場券_印刷枚数表_集計単位, SubGyomuCode.AFA選挙本体);
        地区の分類１ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        地区の分類２ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        地区の分類３ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        is改ページ = Boolean.FALSE;
        is文字切れ改ページ = Boolean.FALSE;
        入場券印刷枚数表_印刷世帯数 = new HashMap<>();
        入場券印刷枚数表_印刷枚数リスト = new HashMap<>();
        入場券印刷枚数表_人数リスト = new HashMap<>();
        入場券印刷枚数表_印刷世帯数リスト = new HashMap<>();
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
        param = new Nyujoken3tsuoriParam(
                選挙共通情報,
                null,
                null,
                null, null,
                null,
                null,
                null, null,
                null, null, null, null);
        param.set地方公共団体情報(地方公共団体情報);
        mojiKireParam = new Nyujoken3tsuoriParam(
                選挙共通情報,
                null,
                null,
                null, null,
                null,
                null,
                null, null,
                null, null, null, null);
        mojiKireParam.set地方公共団体情報(地方公共団体情報);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWCLWriter = NyujokenIkkatsu.mojiCutListOut(parameter.get帳票ID(), batchReportWCLWriter);
        reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        nyujokenMaisuhyoDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NYUJOKENMAISUHYO, AFABTB201NyujokenMaisuhyoEntity.class);

    }

    @Override
    protected void keyBreakProcess(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        NyujokenIkkatsuEditor nyujokenIkkatsuEditor = new NyujokenIkkatsuEditor();
        boolean is文字切れ = nyujokenIkkatsuEditor.check文字切れFor個票3つ折(個票3つ折別出力情報);
        if (is文字切れ) {
            if (is改ページ(改ページキーリスト, 文字切れ情報, 個票3つ折別出力情報)) {
                is文字切れ改ページ = Boolean.TRUE;
            } else {
                is文字切れ改ページ = Boolean.FALSE;
            }

        } else {
            if (is改ページ(改ページキーリスト, 文字切れない情報, 個票3つ折別出力情報)) {
                is改ページ = Boolean.TRUE;
            } else {
                is改ページ = Boolean.FALSE;
            }
        }

    }

    @Override
    protected void usualProcess(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        NyujokenIkkatsuEditor nyujokenIkkatsuEditor = new NyujokenIkkatsuEditor();
        boolean is文字切れ = nyujokenIkkatsuEditor.check文字切れFor個票3つ折(個票3つ折別出力情報);
        get入場券_印刷枚数表_印刷世帯数(個票3つ折別出力情報);
        get入場券_印刷枚数表_人数(個票3つ折別出力情報);
        if (is文字切れ) {
            edit文字切れ入場券(個票3つ折別出力情報);
            文字切れ情報 = 個票3つ折別出力情報;
        } else {
            edit入場券(個票3つ折別出力情報);
            文字切れない情報 = 個票3つ折別出力情報;
        }

    }

    private void edit文字切れ入場券(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        Nyujoken3tsuoriPrintEditor editor = new Nyujoken3tsuoriPrintEditor();
        if (is文字切れ改ページ) {
            Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(mojiKireParam);
            report.writeBy(reportSourceWCLWriter);
            mojiKireParam = new Nyujoken3tsuoriParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            mojiKireParam.set明細情報1(edit明細情報(個票3つ折別出力情報));
            mojiKireParam.set地方公共団体情報(地方公共団体情報);
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
            送付先情報1.set整理番号(1);
            mojiKireParam.set送付先情報1(送付先情報1);
            mojiKireParam = editor.set送付先情報1と明細情報1_個票3つ折り(mojiKireParam, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
            mojiKireItemCount = 1;
        } else {
            if (mojiKireItemCount == 0) {
                mojiKireParam.set明細情報1(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報1.set整理番号(1);
                mojiKireParam.set送付先情報1(送付先情報1);
                mojiKireParam = editor.set送付先情報1と明細情報1_個票3つ折り(mojiKireParam, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                mojiKireParam.set地方公共団体情報(地方公共団体情報);
                mojiKireItemCount++;
            } else if (mojiKireItemCount == 1) {
                mojiKireParam.set明細情報2(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報2 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報2.set整理番号(2);
                mojiKireParam.set送付先情報2(送付先情報2);
                mojiKireParam = editor.set送付先情報2と明細情報2_個票3つ折り(mojiKireParam, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                mojiKireParam.set地方公共団体情報(地方公共団体情報);
                mojiKireItemCount++;
            } else if (mojiKireItemCount == 2) {
                mojiKireParam.set明細情報3(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報3 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報3.set整理番号(改ページ_個票3つ折り);
                mojiKireParam.set送付先情報3(送付先情報3);
                mojiKireParam = editor.set送付先情報3と明細情報3_個票3つ折り(mojiKireParam, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                mojiKireParam.set地方公共団体情報(地方公共団体情報);
                mojiKireItemCount++;
            } else if (mojiKireItemCount == ページ最大件数) {
                Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(mojiKireParam);
                report.writeBy(reportSourceWCLWriter);
                mojiKireParam = new Nyujoken3tsuoriParam(
                        選挙共通情報,
                        null,
                        null,
                        null, null,
                        null,
                        null,
                        null, null,
                        null, null, null, null);
                mojiKireParam.set明細情報1(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報1.set整理番号(1);
                mojiKireParam.set送付先情報1(送付先情報1);
                mojiKireParam = editor.set送付先情報1と明細情報1_個票3つ折り(mojiKireParam, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                mojiKireParam.set地方公共団体情報(地方公共団体情報);
                mojiKireItemCount = 1;
            }
        }
    }

    private void edit入場券(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
        Nyujoken3tsuoriPrintEditor editor = new Nyujoken3tsuoriPrintEditor();
        if (is改ページ) {
            Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(param);
            report.writeBy(reportSourceWriter);
            param = new Nyujoken3tsuoriParam(
                    選挙共通情報,
                    null,
                    null,
                    null, null,
                    null,
                    null,
                    null, null,
                    null, null, null, null);
            param.set明細情報1(edit明細情報(個票3つ折別出力情報));
            param.set地方公共団体情報(地方公共団体情報);
            SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
            送付先情報1.set整理番号(1);
            param.set送付先情報1(送付先情報1);
            param = editor.set送付先情報1と明細情報1_個票3つ折り(param, nyujoken3tsuori);
            get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
            itemCount = 1;
        } else {
            if (itemCount == 0) {
                param.set明細情報1(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報1.set整理番号(1);
                param.set送付先情報1(送付先情報1);
                param = editor.set送付先情報1と明細情報1_個票3つ折り(param, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                param.set地方公共団体情報(地方公共団体情報);
                itemCount++;
            } else if (itemCount == 1) {
                param.set明細情報2(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報2 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報2.set整理番号(2);
                param.set送付先情報2(送付先情報2);
                param = editor.set送付先情報2と明細情報2_個票3つ折り(param, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                param.set地方公共団体情報(地方公共団体情報);
                itemCount++;
            } else if (itemCount == 2) {
                param.set明細情報3(edit明細情報(個票3つ折別出力情報));
                SoufusakiJouhou 送付先情報3 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報3.set整理番号(改ページ_個票3つ折り);
                param.set送付先情報3(送付先情報3);
                param = editor.set送付先情報3と明細情報3_個票3つ折り(param, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                param.set地方公共団体情報(地方公共団体情報);
                itemCount++;
            } else if (itemCount == ページ最大件数) {
                Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(param);
                report.writeBy(reportSourceWriter);
                param = new Nyujoken3tsuoriParam(
                        選挙共通情報,
                        null,
                        null,
                        null, null,
                        null,
                        null,
                        null, null,
                        null, null, null, null);
                param.set明細情報1(edit明細情報(個票3つ折別出力情報));
                param.set地方公共団体情報(地方公共団体情報);
                SoufusakiJouhou 送付先情報1 = changeEntityToSoufusakiJouhou(個票3つ折別出力情報);
                送付先情報1.set整理番号(1);
                param.set送付先情報1(送付先情報1);
                param = editor.set送付先情報1と明細情報1_個票3つ折り(param, nyujoken3tsuori);
                get入場券_印刷枚数表_印刷枚数(個票3つ折別出力情報);
                itemCount = 1;
            }
        }
    }

    private SoufusakiJouhou changeEntityToSoufusakiJouhou(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntiy) {
        SoufusakiJouhou 個票3つ折り_送付先情報 = new SoufusakiJouhou();
        個票3つ折り_送付先情報.set世帯主名(soufusakiJouhouEntiy.get送付先世帯主名());
        個票3つ折り_送付先情報.set送付先世帯コード(soufusakiJouhouEntiy.get送付先世帯コード());
        個票3つ折り_送付先情報.set送付先住所(soufusakiJouhouEntiy.get送付先住所());
        個票3つ折り_送付先情報.set送付先名簿_行(soufusakiJouhouEntiy.get送付先名簿_行());
        個票3つ折り_送付先情報.set送付先名簿_頁(soufusakiJouhouEntiy.get送付先名簿_頁());
        個票3つ折り_送付先情報.set送付先地区コード1(soufusakiJouhouEntiy.get送付先地区コード1());
        個票3つ折り_送付先情報.set送付先地区名1(soufusakiJouhouEntiy.get送付先地区名1());
        個票3つ折り_送付先情報.set送付先宛名(soufusakiJouhouEntiy.get送付先宛名());
        個票3つ折り_送付先情報.set送付先投票区コード(soufusakiJouhouEntiy.get送付先投票区コード());
        個票3つ折り_送付先情報.set送付先方書(soufusakiJouhouEntiy.get送付先方書());
        個票3つ折り_送付先情報.set送付先番地(soufusakiJouhouEntiy.get送付先番地());
        個票3つ折り_送付先情報.set送付先行政区コード(soufusakiJouhouEntiy.get送付先行政区コード());
        個票3つ折り_送付先情報.set送付先行政区名(soufusakiJouhouEntiy.get送付先行政区名());
        個票3つ折り_送付先情報.set送付先郵便番号(soufusakiJouhouEntiy.get送付先郵便番号());
        return 個票3つ折り_送付先情報;
    }

    @Override
    protected void afterExecute() {
        if (mojiKireParam.get明細情報1() != null) {
            Nyujoken3tsuoriReport mojiKirereport = new Nyujoken3tsuoriReport(mojiKireParam);
            mojiKirereport.writeBy(reportSourceWCLWriter);
        }
        if (param.get明細情報1() != null) {
            Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(param);
            report.writeBy(reportSourceWriter);
        }
        for (RString key : 入場券印刷枚数表_印刷世帯数.keySet()) {
            入場券印刷枚数表_印刷世帯数リスト.put(key, 入場券印刷枚数表_印刷世帯数.get(key).size());
            AFABTB201NyujokenMaisuhyoEntity tempTblInsertEntity = new AFABTB201NyujokenMaisuhyoEntity();
            tempTblInsertEntity.setShuukeiTanni(入場券印刷枚数表集計単位);
            tempTblInsertEntity.setShuukeiCode(key);
            tempTblInsertEntity.setShutsuRyokuTaishou(parameter.getGroupKubun());
            tempTblInsertEntity.setBunjiKireKunbun(Boolean.FALSE);
            tempTblInsertEntity.setShuukeiName(get集計コード名称());
            tempTblInsertEntity.setShuukeiSetaisuSuji(new Decimal(入場券印刷枚数表_印刷世帯数.get(key).size()));
            tempTblInsertEntity.setShuukeiNinSuji(new Decimal(入場券印刷枚数表_人数リスト.get(key)));
            tempTblInsertEntity.setShuukeiMeisuSuji(new Decimal(入場券印刷枚数表_印刷枚数リスト.get(key)));
            nyujokenMaisuhyoDbWriter.insert(tempTblInsertEntity);
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

    private MeisaiJouhou edit明細情報(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        MeisaiJouhou 明細情報 = new MeisaiJouhou();
        明細情報.setカナ名称(個票3つ折別出力情報.getカナ名称());
        明細情報.set世帯コード(個票3つ折別出力情報.get世帯コード());
        明細情報.set世帯主名(個票3つ折別出力情報.get世帯主名());
        明細情報.set住民種別コード(個票3つ折別出力情報.get住民種別コード());
        明細情報.set住登内住所(
                個票3つ折別出力情報.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(個票3つ折別出力情報.get住所()));
        if (個票3つ折別出力情報.get全国住所コード() == null) {
            明細情報.set住登内町域コード(個票3つ折別出力情報.get全国住所コード().getColumnValue());
        } else {
            明細情報.set住登内町域コード(RString.EMPTY);
        }
        明細情報.set住登内番地(個票3つ折別出力情報.get番地());
        if (個票3つ折別出力情報.get地区コード１() == null) {
            明細情報.set地区コード1(個票3つ折別出力情報.get地区コード１().getColumnValue());
        } else {
            明細情報.set地区コード1(RString.EMPTY);
        }
        if (個票3つ折別出力情報.get地区コード２() == null) {
            明細情報.set地区コード2(個票3つ折別出力情報.get地区コード２().getColumnValue());
        } else {
            明細情報.set地区コード2(RString.EMPTY);
        }
        if (個票3つ折別出力情報.get地区コード３() == null) {
            明細情報.set地区コード3(個票3つ折別出力情報.get地区コード３().getColumnValue());
        } else {
            明細情報.set地区コード3(RString.EMPTY);
        }
        明細情報.set地区名1(個票3つ折別出力情報.get地区名１());
        明細情報.set地区名2(個票3つ折別出力情報.get地区名２());
        明細情報.set地区名3(個票3つ折別出力情報.get地区名３());
        明細情報.set性別コード(個票3つ折別出力情報.get性別コード());
        明細情報.set投票区コード(個票3つ折別出力情報.get投票区コード());
        明細情報.set投票区名(個票3つ折別出力情報.get投票区名());
        明細情報.set投票所名(個票3つ折別出力情報.get投票所名());
        if (個票3つ折別出力情報.get投票所の住所() == null) {
            明細情報.set投票所＿住所(個票3つ折別出力情報.get投票所の住所().getColumnValue());
        } else {
            明細情報.set投票所＿住所(RString.EMPTY);
        }
        明細情報.set続柄コード(個票3つ折別出力情報.get続柄コード().getColumnValue());
        明細情報.set生年月日(changeFlexibleDateToRDate(個票3つ折別出力情報.get生年月日()));

        明細情報.set投票開始時刻(個票3つ折別出力情報.get投票開始時刻());
        明細情報.set投票終了時刻(個票3つ折別出力情報.get投票終了時刻());
        if (個票3つ折別出力情報.get行政区コード() == null) {
            明細情報.set行政区コード(個票3つ折別出力情報.get行政区コード().getColumnValue());
        } else {
            明細情報.set行政区コード(RString.EMPTY);
        }
        明細情報.set行政区名(個票3つ折別出力情報.get行政区名());
        明細情報.set名称(個票3つ折別出力情報.get名称());
        明細情報.set頁(個票3つ折別出力情報.get頁());
        明細情報.set行(個票3つ折別出力情報.get行());
        明細情報.set識別コード(個票3つ折別出力情報.get識別コード());
        明細情報.set住民票表示順(個票3つ折別出力情報.get住民票表示順());
        return 明細情報;
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param 個票3つ折別出力情報引数 AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報(AFABTB201SelectProcessParameter 個票3つ折別出力情報引数,
            Association 地方公共団体情報) {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        nyujoukenGamenModel.set抄本番号(new RString(個票3つ折別出力情報引数.get抄本番号().getColumnValue()));
        nyujoukenGamenModel.set抄本名(個票3つ折別出力情報引数.get抄本名());
        nyujoukenGamenModel.set入場券名称1(個票3つ折別出力情報引数.get入場券名1());
        nyujoukenGamenModel.set入場券名称2(個票3つ折別出力情報引数.get入場券名2());
        nyujoukenGamenModel.set入場券名称3(個票3つ折別出力情報引数.get入場券名3());
        nyujoukenGamenModel.setサンプル文字(個票3つ折別出力情報引数.getサンプル文字());
        FlexibleDate 投票日 = 個票3つ折別出力情報引数.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(個票3つ折別出力情報引数.get投票日().toString()));
        List<SenkyomeishouParam> 選挙名称リスト = new ArrayList<>();
        if (個票3つ折別出力情報引数.get選挙リスト() != null
                && !個票3つ折別出力情報引数.get選挙リスト().isEmpty()) {
            for (Senkyomeishou senkyomeishou : 個票3つ折別出力情報引数.get選挙リスト()) {
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

    private void get入場券_印刷枚数表_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷世帯数(個票3つ折別出力情報);

        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷世帯数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷世帯数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷世帯数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷世帯数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷世帯数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷世帯数(個票3つ折別出力情報);
        }
    }

    private void get投票区コード_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (RString.isNullOrEmpty(個票3つ折別出力情報.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get投票所コード())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get投票区コード()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get投票区コード(), 同一世帯コード);
        }
    }

    private void get住所コード_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get町域コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get町域コード().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get町域コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get行政区コード_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get行政区コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get行政区コード().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get行政区コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード1_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード１() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get地区コード１().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get地区コード１().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード2_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード２() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get地区コード２().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get地区コード２().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード3_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード３() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get地区コード３().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get地区コード３().getColumnValue(), 同一世帯コード);
        }
    }

    private void get郵便番号_印刷世帯数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get郵便番号() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(個票3つ折別出力情報.get郵便番号().getColumnValue()).add(個票3つ折別出力情報.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(個票3つ折別出力情報.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(個票3つ折別出力情報.get郵便番号().getColumnValue(), 同一世帯コード);
        }
    }

    private void get入場券_印刷枚数表_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_人数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_人数(個票3つ折別出力情報);
        }
    }

    private void get投票区コード_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (RString.isNullOrEmpty(個票3つ折別出力情報.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get投票所コード())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get投票区コード(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get投票区コード(), 1);
        }
    }

    private void get住所コード_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get町域コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get町域コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get行政区コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード１() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード２() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード３() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_人数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get郵便番号() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(個票3つ折別出力情報.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(個票3つ折別出力情報.get郵便番号().getColumnValue(), 1);
        }
    }

    private void get入場券_印刷枚数表_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷枚数(個票3つ折別出力情報);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷枚数(個票3つ折別出力情報);
        }
    }

    private void get投票区コード_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (RString.isNullOrEmpty(個票3つ折別出力情報.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get投票所コード())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get投票区コード(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get投票区コード(), 1);
        }
    }

    private void get住所コード_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get町域コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get町域コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get行政区コード() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード１() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード２() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get地区コード３() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_印刷枚数(AFABTB201MeiciJyohouSoufusakiEntity 個票3つ折別出力情報) {
        if (個票3つ折別出力情報.get郵便番号() == null
                || RString.isNullOrEmpty(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(個票3つ折別出力情報.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(個票3つ折別出力情報.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(個票3つ折別出力情報.get郵便番号().getColumnValue(), 1);
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
