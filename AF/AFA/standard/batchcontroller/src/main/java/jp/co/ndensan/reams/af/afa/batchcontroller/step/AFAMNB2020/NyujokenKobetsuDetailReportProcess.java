/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.NyujokenIkkatsu;
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenHagakiParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenSealerParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenHakkouMeishoWithCheckListParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenNyujyokkenParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenNyujyokkenWithCheckListParam;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenkobetsu.NyujokenKobetsuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB201.Nyujoken3tsuoriReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB202.NyujokenHagakiReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB203.NyujokenSealerReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB204.NyujokenPostexReport;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.SenkyoninIrain;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.processprm.nyujokenikkatsu.AFABTB202SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.SofusakiJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB201.Nyujoken3tsuoriPrintEditor;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB202.NyujokenHagakiPrintEditor;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB203.NyujokenSealerPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB204.NyujokenPostexPrintService;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 入場券発行（個別）のバッチ処理クラスです。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class NyujokenKobetsuDetailReportProcess extends SimpleBatchProcessBase {

    private AFABTB202SelectProcessParameter selectProcessParameter;

    @BatchWriter
    private IBatchReportWriterWithCheckList<Nyujoken3tsuoriSource> batchReportWCLWriter;
    private ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWCLWriter;
    @BatchWriter
    private BatchReportWriter<Nyujoken3tsuoriSource> batchReportWriter;
    private ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWriter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NyujokenHagakiSource> nyujokenHagakiWCLBatchWriter;
    private ReportSourceWriter<NyujokenHagakiSource> nyujokenHagakiWCLSourceWriter;
    @BatchWriter
    private BatchReportWriter<NyujokenHagakiSource> nyujokenHagakiBatchWriter;
    private ReportSourceWriter<NyujokenHagakiSource> nyujokenHagakiSourceWriter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NyujokenSealerSource> nyujokenSealerWCLBatchWriter;
    private ReportSourceWriter<NyujokenSealerSource> nyujokenSealerWCLSourceWriter;
    @BatchWriter
    private BatchReportWriter<NyujokenSealerSource> nyujokenSealerBatchWriter;
    private ReportSourceWriter<NyujokenSealerSource> nyujokenSealerSourceWriter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NyujokenPostexSource> nyujokenPostexWCLBatchWriter;
    private ReportSourceWriter<NyujokenPostexSource> nyujokenPostexWCLSourceWriter;
    @BatchWriter
    private BatchReportWriter<NyujokenPostexSource> nyujokenPostexBatchWriter;
    private ReportSourceWriter<NyujokenPostexSource> nyujokenPostexSourceWriter;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;
    private Association 地方公共団体情報;
    private RString コピー元パース = RString.EMPTY;
    private RString コピー元パースチェックリスト = RString.EMPTY;
    private List<RString> 改ページキーリスト = new ArrayList<>();

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    @Override
    protected void process() {
        改ページキーリスト = selectProcessParameter.get改頁項目IDリスト();
        pageCount = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        NyujokenIkkatsu nyujokenIkkatsu = NyujokenIkkatsu.createInstance();
        List<NyujokenKobetsuJouhou> 選挙人情報リスト = nyujokenIkkatsu.getAllSenkyoninJoho(
                selectProcessParameter.get抄本番号(),
                selectProcessParameter.get選挙種類(),
                selectProcessParameter.getOrder順(), selectProcessParameter.get投票日());
        List<NyujokenKobetsuJouhou> 選挙人一覧リスト = new ArrayList<>();
        for (SenkyoninIrain senkyoninIrain : selectProcessParameter.get選挙人一覧リスト()) {
            NyujokenKobetsuJouhou nyujokenKobetsuJouhou = new NyujokenKobetsuJouhou();
            nyujokenKobetsuJouhou.set識別コード(senkyoninIrain.get識別コード());
            nyujokenKobetsuJouhou.set世帯コード(senkyoninIrain.get世帯コード());
            選挙人一覧リスト.add(nyujokenKobetsuJouhou);
        }
        List<NyujokenKobetsuJouhou> 選挙人個別情報リスト = nyujokenIkkatsu.getSenkyoninJoho(選挙人情報リスト, 選挙人一覧リスト);
        //TODO  出力対象：QA#92018,2016.07.28再提出
        List<SofusakiJouhou> 送付先情報リスト = nyujokenIkkatsu.getSofusakiJoho(選挙人個別情報リスト, SennkyoSikakuKubun.有権者.value());
        List<NyujokenKobetsuJouhou> 世帯情報リスト = nyujokenIkkatsu.getSetaiJoho(選挙人情報リスト, 選挙人一覧リスト);

        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報 = new ArrayList<>();
        List<Nyujoken3tsuoriParam> 投票所入場券情報 = new ArrayList<>();
        RString 印刷タイプ = selectProcessParameter.get印刷タイプ();
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        if ((AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(印刷タイプ)
                || AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(印刷タイプ))
                && selectProcessParameter.get対象者を個々に作成する有無()) {
            入場券_選挙人個別情報
                    = editor.edit入場券_選挙人個別情報_対象者を作成する有(選挙人個別情報リスト, 送付先情報リスト);
            投票所入場券情報
                    = editor.edit入場券For個票3つ折とはがき4つ切(入場券_選挙人個別情報, selectProcessParameter, 地方公共団体情報);
        } else if ((AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(印刷タイプ)
                || AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(印刷タイプ))
                && selectProcessParameter.get対象者の世帯で作成する有無()) {
            入場券_選挙人個別情報
                    = editor.edit入場券_選挙人個別情報_対象者を作成する有(世帯情報リスト, 送付先情報リスト);
            投票所入場券情報
                    = editor.edit入場券For個票3つ折とはがき4つ切(入場券_選挙人個別情報, selectProcessParameter, 地方公共団体情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getKey().equals(印刷タイプ)
                || AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getKey().equals(印刷タイプ)) {
            入場券_選挙人個別情報 = editor.edit入場券_選挙人個別情報_対象者を作成する有(選挙人個別情報リスト, 送付先情報リスト);
        }
        帳票出力(入場券_選挙人個別情報, 投票所入場券情報);
        地図情報のイメージファイルのコピー();
    }

    private void 帳票出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報, List<Nyujoken3tsuoriParam> 投票所入場券情報) {
        RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        RString 文字切れ入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力しない.configKeyValue().equals(文字切れ入場券出力区分)) {
            入場券_文字切れ入場券出力区分_別出力しない(入場券_選挙人個別情報,
                    投票所入場券情報,
                    入場券_印刷タイプ);
        } else if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力する.configKeyValue().equals(文字切れ入場券出力区分)) {
            入場券_文字切れ入場券出力区分_別出力(入場券_選挙人個別情報, 入場券_印刷タイプ);
        }
    }

    private void 入場券_文字切れ入場券出力区分_別出力しない(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報,
            List<Nyujoken3tsuoriParam> 投票所入場券情報,
            RString 入場券_印刷タイプ) {
        if (AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_個票3つ折_別出力しない(投票所入場券情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_はがき4つ切り_別出力しない(投票所入場券情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_シーラー_別出力しない(入場券_選挙人個別情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_ポステックス_別出力しない(入場券_選挙人個別情報);
        }
    }

    private void 入場券_文字切れ入場券出力区分_別出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報,
            RString 入場券_印刷タイプ) {
        if (AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_個票3つ折_別出力(入場券_選挙人個別情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_はがき4つ切り_別出力(入場券_選挙人個別情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_シーラー_別出力(入場券_選挙人個別情報);
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getKey().equals(入場券_印刷タイプ)) {
            帳票出力_ポステックス_別出力(入場券_選挙人個別情報);
        }
    }

    private void 帳票出力_個票3つ折_別出力しない(List<Nyujoken3tsuoriParam> 投票所入場券情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        List<Nyujoken3tsuoriParam> 入場券_個票3つ折
                = editor.edit入場券_個票3つ折(投票所入場券情報, selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
        if (入場券_個票3つ折 == null || 入場券_個票3つ折.isEmpty()) {
            コピー元パース = RString.EMPTY;
            pageCount.setValue(0);
        } else {
            batchReportWCLWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value(),
                    batchReportWCLWriter);
            reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);
            reportSourceWCLWriter.pageCount().value();
            Nyujoken3tsuoriPrintEditor print = new Nyujoken3tsuoriPrintEditor();
            List<Nyujoken3tsuoriParam> printData = print.printFor投票所入場券_個票3つ折り(入場券_個票3つ折, 地方公共団体情報);
            for (Nyujoken3tsuoriParam nyujoken3tsuoriParam : printData) {
                Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(nyujoken3tsuoriParam);
                report.writeBy(reportSourceWCLWriter);
            }
            pageCount.setValue(batchReportWCLWriter.getPageCount());
            コピー元パース = batchReportWCLWriter.getImageFolderPath();
            batchReportWCLWriter.close();
        }
    }

    private void 帳票出力_はがき4つ切り_別出力しない(List<Nyujoken3tsuoriParam> 投票所入場券情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        List<NyujokenHagakiParam> 入場券_はがき4つ切り
                = editor.edit入場券_はがき4つ切り(投票所入場券情報, selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
        if (入場券_はがき4つ切り == null || 入場券_はがき4つ切り.isEmpty()) {
            コピー元パース = RString.EMPTY;
            pageCount.setValue(0);
        } else {
            nyujokenHagakiWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value(),
                    nyujokenHagakiWCLBatchWriter);
            nyujokenHagakiWCLSourceWriter = new ReportSourceWriter<>(nyujokenHagakiWCLBatchWriter);
            nyujokenHagakiWCLSourceWriter.pageCount().value();
            NyujokenHagakiPrintEditor printEditor = new NyujokenHagakiPrintEditor();
            List<NyujokenHagakiParam> printData = printEditor.printFor投票所入場券_はがき4つ切(入場券_はがき4つ切り, 地方公共団体情報);
            for (NyujokenHagakiParam nyujokenHagakiParam : printData) {
                NyujokenHagakiReport report = new NyujokenHagakiReport(nyujokenHagakiParam);
                report.writeBy(nyujokenHagakiWCLSourceWriter);
            }
            pageCount.setValue(nyujokenHagakiWCLBatchWriter.getPageCount());
            コピー元パース = nyujokenHagakiWCLBatchWriter.getImageFolderPath();
            nyujokenHagakiWCLBatchWriter.close();
        }
    }

    private void 帳票出力_シーラー_別出力しない(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報new
                = editor.edit入場券Forシーラーとポステックス(入場券_選挙人個別情報, 改ページキーリスト);
        NyujokenSealerPrintService printService = new NyujokenSealerPrintService();
        List<NyujokenSealerParam> 入場券_シーラー
                = editor.edit入場券_シーラー(入場券_選挙人個別情報new, selectProcessParameter, 地方公共団体情報);
        if (入場券_シーラー == null || 入場券_シーラー.isEmpty()) {
            コピー元パース = RString.EMPTY;
            pageCount.setValue(0);
        } else {
            nyujokenSealerWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value(),
                    nyujokenSealerWCLBatchWriter);
            nyujokenSealerWCLSourceWriter = new ReportSourceWriter<>(nyujokenSealerWCLBatchWriter);
            nyujokenSealerWCLSourceWriter.pageCount().value();
            for (NyujokenSealerParam nyujokenSealerParam : printService.printシーラー(入場券_シーラー)) {
                NyujokenSealerReport report = new NyujokenSealerReport(nyujokenSealerParam);
                report.writeBy(nyujokenSealerWCLSourceWriter);
            }
            pageCount.setValue(nyujokenSealerWCLBatchWriter.getPageCount());
            コピー元パース = nyujokenSealerWCLBatchWriter.getImageFolderPath();
            nyujokenSealerWCLBatchWriter.close();
        }

    }

    private void 帳票出力_ポステックス_別出力しない(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報new
                = editor.edit入場券Forシーラーとポステックス(入場券_選挙人個別情報, 改ページキーリスト);
        NyujokenPostexPrintService printService = new NyujokenPostexPrintService();
        List<NyujokenPostexParam> 入場券_ポステックス
                = editor.edit入場券_ポステックス(入場券_選挙人個別情報new, selectProcessParameter, 地方公共団体情報);
        if (入場券_ポステックス == null || 入場券_ポステックス.isEmpty()) {
            コピー元パース = RString.EMPTY;
            pageCount.setValue(0);
        } else {
            nyujokenPostexWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value(),
                    nyujokenPostexWCLBatchWriter);
            nyujokenPostexWCLSourceWriter = new ReportSourceWriter<>(nyujokenPostexWCLBatchWriter);
            nyujokenPostexWCLSourceWriter.pageCount().value();
            for (NyujokenPostexParam nyujokenPostexParam : printService.printポステックス(入場券_ポステックス)) {
                NyujokenPostexReport report = new NyujokenPostexReport(nyujokenPostexParam);
                report.writeBy(nyujokenPostexWCLSourceWriter);
            }
            pageCount.setValue(nyujokenPostexWCLBatchWriter.getPageCount());
            コピー元パース = nyujokenPostexWCLBatchWriter.getImageFolderPath();
            nyujokenPostexWCLBatchWriter.close();
        }

    }

    private void 帳票出力_個票3つ折_別出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        NyujoukenNyujyokkenWithCheckListParam param
                = editor.check入場券For個票3つ折(入場券_選挙人個別情報,
                        selectProcessParameter, 地方公共団体情報);
        List<Nyujoken3tsuoriParam> 投票所入場券情報リスト = param.get投票所入場券情報リスト();
        int count = 0;
        Nyujoken3tsuoriPrintEditor print = new Nyujoken3tsuoriPrintEditor();
        if (投票所入場券情報リスト == null || 投票所入場券情報リスト.isEmpty()) {
            コピー元パース = RString.EMPTY;
        } else {
            List<Nyujoken3tsuoriParam> 入場券_個票3つ折
                    = editor.edit入場券_個票3つ折(投票所入場券情報リスト,
                            selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value()).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            reportSourceWriter.pageCount().value();
            List<Nyujoken3tsuoriParam> printData = print.printFor投票所入場券_個票3つ折り(入場券_個票3つ折, 地方公共団体情報);
            for (Nyujoken3tsuoriParam nyujoken3tsuoriParam : printData) {
                Nyujoken3tsuoriReport report = new Nyujoken3tsuoriReport(nyujoken3tsuoriParam);
                report.writeBy(reportSourceWriter);
            }
            count = count + batchReportWriter.getPageCount();
            コピー元パース = batchReportWriter.getImageFolderPath();
            batchReportWriter.close();
        }
        List<Nyujoken3tsuoriParam> 投票所入場券情報チェックリスト = param.get投票所入場券情報チェックリスト();
        if (投票所入場券情報チェックリスト == null || 投票所入場券情報チェックリスト.isEmpty()) {
            コピー元パースチェックリスト = RString.EMPTY;
        } else {
            List<Nyujoken3tsuoriParam> 入場券_個票3つ折チェックリスト
                    = editor.edit入場券_個票3つ折(投票所入場券情報チェックリスト,
                            selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
            batchReportWCLWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value(),
                    batchReportWCLWriter);
            reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);
            reportSourceWCLWriter.pageCount().value();
            List<Nyujoken3tsuoriParam> printData = print.printFor投票所入場券_個票3つ折り(入場券_個票3つ折チェックリスト, 地方公共団体情報);
            for (Nyujoken3tsuoriParam nyujoken3tsuoriParam : printData) {
                Nyujoken3tsuoriReport reportWithCheckList = new Nyujoken3tsuoriReport(nyujoken3tsuoriParam);
                reportWithCheckList.writeBy(reportSourceWCLWriter);
            }
            count = count + batchReportWCLWriter.getPageCount();
            コピー元パースチェックリスト = batchReportWCLWriter.getImageFolderPath();
            batchReportWCLWriter.close();
        }
        pageCount.setValue(count);
    }

    private void 帳票出力_はがき4つ切り_別出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        NyujokenHagakiPrintEditor printEditor = new NyujokenHagakiPrintEditor();
        NyujoukenNyujyokkenWithCheckListParam param
                = editor.check入場券Forはがき4つ切(入場券_選挙人個別情報,
                        selectProcessParameter, 地方公共団体情報);
        int count = 0;
        List<Nyujoken3tsuoriParam> 投票所入場券情報リスト = param.get投票所入場券情報リスト();
        if (投票所入場券情報リスト == null || 投票所入場券情報リスト.isEmpty()) {
            コピー元パース = RString.EMPTY;
        } else {
            nyujokenHagakiBatchWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value()).create();
            nyujokenHagakiSourceWriter = new ReportSourceWriter<>(nyujokenHagakiBatchWriter);
            nyujokenHagakiSourceWriter.pageCount().value();
            List<NyujokenHagakiParam> 入場券_はがき4つ切り
                    = editor.edit入場券_はがき4つ切り(投票所入場券情報リスト,
                            selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
            List<NyujokenHagakiParam> paramData = printEditor.printFor投票所入場券_はがき4つ切(入場券_はがき4つ切り, 地方公共団体情報);
            for (NyujokenHagakiParam nyujokenHagakiParam : paramData) {
                NyujokenHagakiReport report = new NyujokenHagakiReport(nyujokenHagakiParam);
                report.writeBy(nyujokenHagakiSourceWriter);
            }
            count = count + nyujokenHagakiBatchWriter.getPageCount();
            コピー元パース = nyujokenHagakiBatchWriter.getImageFolderPath();
            nyujokenHagakiBatchWriter.close();

        }
        List<Nyujoken3tsuoriParam> 投票所入場券情報チェックリスト = param.get投票所入場券情報チェックリスト();
        if (投票所入場券情報チェックリスト == null || 投票所入場券情報チェックリスト.isEmpty()) {
            コピー元パースチェックリスト = RString.EMPTY;
        } else {
            nyujokenHagakiWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value(),
                    nyujokenHagakiWCLBatchWriter);
            nyujokenHagakiWCLSourceWriter = new ReportSourceWriter<>(nyujokenHagakiWCLBatchWriter);
            nyujokenHagakiWCLSourceWriter.pageCount().value();
            List<NyujokenHagakiParam> 入場券チェックリスト_はがき4つ切り
                    = editor.edit入場券_はがき4つ切り(投票所入場券情報チェックリスト,
                            selectProcessParameter, 地方公共団体情報, 改ページキーリスト);
            List<NyujokenHagakiParam> paramData = printEditor.printFor投票所入場券_はがき4つ切(入場券チェックリスト_はがき4つ切り, 地方公共団体情報);
            for (NyujokenHagakiParam nyujokenHagakiParam : paramData) {
                NyujokenHagakiReport reportWithCheckList = new NyujokenHagakiReport(nyujokenHagakiParam);
                reportWithCheckList.writeBy(nyujokenHagakiWCLSourceWriter);
            }
            count = count + nyujokenHagakiWCLBatchWriter.getPageCount();
            コピー元パースチェックリスト = nyujokenHagakiWCLBatchWriter.getImageFolderPath();
            nyujokenHagakiWCLBatchWriter.close();
        }
        pageCount.setValue(count);

    }

    private void 帳票出力_シーラー_別出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        NyujokenSealerPrintService printService = new NyujokenSealerPrintService();
        NyujoukenHakkouMeishoWithCheckListParam param = editor.check入場券Forシーラー(入場券_選挙人個別情報);
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報new
                = editor.edit入場券Forシーラーとポステックス(param.get投票所入場券情報リスト(), 改ページキーリスト);
        int count = 0;
        if (入場券_選挙人個別情報new == null || 入場券_選挙人個別情報new.isEmpty()) {
            コピー元パース = RString.EMPTY;
        } else {
            nyujokenSealerBatchWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value()).create();
            nyujokenSealerSourceWriter = new ReportSourceWriter<>(nyujokenSealerBatchWriter);
            nyujokenSealerSourceWriter.pageCount().value();
            List<NyujokenSealerParam> 入場券_シーラー
                    = editor.edit入場券_シーラー(入場券_選挙人個別情報new,
                            selectProcessParameter, 地方公共団体情報);

            List<NyujokenSealerParam> printData = printService.printシーラー(入場券_シーラー);
            for (NyujokenSealerParam nyujokenSealerParam : printData) {
                NyujokenSealerReport report = new NyujokenSealerReport(nyujokenSealerParam);
                report.writeBy(nyujokenSealerSourceWriter);
            }
            count = count + nyujokenSealerBatchWriter.getPageCount();
            コピー元パース = nyujokenSealerBatchWriter.getImageFolderPath();
            nyujokenSealerBatchWriter.close();
        }
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報チェックリスト
                = editor.edit入場券Forシーラーとポステックス(param.get投票所入場券情報チェックリスト(), 改ページキーリスト);
        if (入場券_選挙人個別情報チェックリスト == null || 入場券_選挙人個別情報チェックリスト.isEmpty()) {
            コピー元パース = RString.EMPTY;
        } else {
            nyujokenSealerWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value(),
                    nyujokenSealerWCLBatchWriter);
            nyujokenSealerWCLSourceWriter = new ReportSourceWriter<>(nyujokenSealerWCLBatchWriter);
            nyujokenSealerWCLSourceWriter.pageCount().value();
            List<NyujokenSealerParam> 入場券_シーラーチェックリスト
                    = editor.edit入場券_シーラー(入場券_選挙人個別情報チェックリスト,
                            selectProcessParameter, 地方公共団体情報);
            List<NyujokenSealerParam> printData = printService.printシーラー(入場券_シーラーチェックリスト);
            for (NyujokenSealerParam nyujokenSealerParam : printData) {
                NyujokenSealerReport reportWithCheckList = new NyujokenSealerReport(nyujokenSealerParam);
                reportWithCheckList.writeBy(nyujokenSealerWCLSourceWriter);
            }
            count = count + nyujokenSealerWCLBatchWriter.getPageCount();
            コピー元パースチェックリスト = nyujokenSealerWCLBatchWriter.getImageFolderPath();
            nyujokenSealerWCLBatchWriter.close();
        }
        pageCount.setValue(count);

    }

    private void 帳票出力_ポステックス_別出力(List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報) {
        NyujokenKobetsuEditor editor = new NyujokenKobetsuEditor();
        NyujokenPostexPrintService printService = new NyujokenPostexPrintService();
        NyujoukenHakkouMeishoWithCheckListParam param = editor.check入場券Forポステックス(入場券_選挙人個別情報);
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報new
                = editor.edit入場券Forシーラーとポステックス(param.get投票所入場券情報リスト(), 改ページキーリスト);
        int count = 0;
        if (入場券_選挙人個別情報new == null || 入場券_選挙人個別情報new.isEmpty()) {
            コピー元パース = RString.EMPTY;
        } else {
            nyujokenPostexBatchWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value()).create();
            nyujokenPostexSourceWriter = new ReportSourceWriter<>(nyujokenPostexBatchWriter);
            nyujokenPostexSourceWriter.pageCount().value();
            List<NyujokenPostexParam> 入場券_シーラー
                    = editor.edit入場券_ポステックス(入場券_選挙人個別情報new,
                            selectProcessParameter, 地方公共団体情報);
            List<NyujokenPostexParam> printData = printService.printポステックス(入場券_シーラー);
            for (NyujokenPostexParam nyujokenPostexParam : printData) {
                NyujokenPostexReport report = new NyujokenPostexReport(nyujokenPostexParam);
                report.writeBy(nyujokenPostexSourceWriter);
            }
            count = count + nyujokenPostexBatchWriter.getPageCount();
            コピー元パース = nyujokenPostexBatchWriter.getImageFolderPath();
            nyujokenPostexBatchWriter.close();
        }
        List<NyujoukenNyujyokkenParam> 入場券_選挙人個別情報チェックリスト
                = editor.edit入場券Forシーラーとポステックス(param.get投票所入場券情報チェックリスト(), 改ページキーリスト);
        if (入場券_選挙人個別情報チェックリスト == null || 入場券_選挙人個別情報チェックリスト.isEmpty()) {
            コピー元パースチェックリスト = RString.EMPTY;
        } else {
            nyujokenPostexWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(
                    ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value(),
                    nyujokenPostexWCLBatchWriter);
            nyujokenPostexWCLSourceWriter = new ReportSourceWriter<>(nyujokenPostexWCLBatchWriter);
            nyujokenPostexWCLSourceWriter.pageCount().value();
            List<NyujokenPostexParam> 入場券_シーラーチェックリスト
                    = editor.edit入場券_ポステックス(入場券_選挙人個別情報チェックリスト,
                            selectProcessParameter, 地方公共団体情報);
            List<NyujokenPostexParam> printData = printService.printポステックス(入場券_シーラーチェックリスト);
            for (NyujokenPostexParam nyujokenPostexParam : printData) {
                NyujokenPostexReport reportWithCheckList = new NyujokenPostexReport(nyujokenPostexParam);
                reportWithCheckList.writeBy(nyujokenPostexWCLSourceWriter);
            }
            count = count + nyujokenPostexWCLBatchWriter.getPageCount();
            コピー元パースチェックリスト = nyujokenPostexWCLBatchWriter.getImageFolderPath();
            nyujokenPostexWCLBatchWriter.close();
        }
        pageCount.setValue(count);

    }

    private void 地図情報のイメージファイルのコピー() {
        RString 地図印字フラッグ = BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.印字有無_印字する.configKeyValue().equals(地図印字フラッグ)) {
            return;
        }
        RString コピー先パース = BusinessConfig.get(ConfigKeysAFA.入場券_地図格納フォルダ, SubGyomuCode.AFA選挙本体);
        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            if (Directory.exists(コピー元パースチェックリスト) && Directory.exists(コピー先パース)) {
                Directory.copy(コピー先パース, コピー元パースチェックリスト);
            } else if (Directory.exists(コピー元パースチェックリスト) && !Directory.exists(コピー先パース)) {
                コピー先パース = Directory.createDirectories(コピー先パース);
                Directory.copy(コピー先パース, コピー元パースチェックリスト);
            }
        }
        if (!RString.isNullOrEmpty(コピー元パース)) {
            if (Directory.exists(コピー元パース) && Directory.exists(コピー先パース)) {
                Directory.copy(コピー先パース, コピー元パース);
            } else if (Directory.exists(コピー元パース) && !Directory.exists(コピー先パース)) {
                コピー先パース = Directory.createDirectories(コピー先パース);
                Directory.copy(コピー先パース, コピー元パース);
            }
        }

    }
    //TODO  出力対象：QA#92018,2016.07.28再提出
//    private void is有権者() {
//        ShikakuJohoManger manager = ShikakuJohoManger.createInstance();
//        FindShikibetsuTaishoResult 宛名識別対象 = manager.get宛名識別対象(selectProcessParameter.get選挙人一覧リスト().get(0).get識別コード());
//        SenkyoManager manager1 = SenkyoManager.createInstance();
//        Senkyo 選挙 = manager1.get選挙(selectProcessParameter.get抄本番号(),
//                new SenkyoNo(selectProcessParameter.get選挙リスト().get(0).get選挙番号()));
//        FlexibleDate 転入期限日 = 選挙.get転入期限年月日();
//        ShohonManager manager3 = ShohonManager.createInstance();
//        Shohon shohon = manager3.get抄本(selectProcessParameter.get抄本番号());
//        FlexibleDate 規定年齢到達年月日 = shohon.get規定年齢到達年月日();
//    }

}
