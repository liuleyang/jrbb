/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFABTK104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuAtenaSea12ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuAtenaSea21ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuHyojishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuMasshoshaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuMasshoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuMeiboShohonJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuMeiboShohonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuShikkenshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuTeiseishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuTorokushaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuTorokushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103.KaikuTorokushasuListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104.CreatTempMeiboProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104.KaikuSenkyoShikakuUpdateProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104.KaikuSenkyoUpdateProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104.KaikuSenkyoninMeiboInsertProcess;
import jp.co.ndensan.reams.af.afa.business.core.SenkyojiZaisankuReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibosaishinkakaiku.AFABTK104BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.SenkyojiKaikuEdit;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区選挙人名簿最新化
 *
 * @reamsid_L AF-0480-020 lis
 */
public class AFABTK104_MeiboSaishinkaKaikuFlow extends BatchFlowBase<AFABTK104BatchParameter> {

    private RString 帳票ID;
    private List<IOutputOrder> 帳票出力順;
    private Association association;
    private final List<ShohonNo> 抄本番号List = new ArrayList<>();
    private RString 宛名シール面数;

    private AFABTK103SelectProcessParameter processParameter;

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoSearchKeyAll;

    private static final RString ページコント = new RString("pageCount");

    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private static final String 選挙資格の更新STR = "選挙資格の更新";
    private static final String 海区名簿更新日の更新STR = "海区名簿更新日の更新";
    private static final String 選挙人名簿抄本帳票の出力STR = "選挙人名簿抄本帳票の出力";
    private static final String 登録者数リスト帳票の出力STR = "登録者数リスト帳票の出力";
    private static final String 登録者名簿帳票の出力STR = "登録者名簿帳票の出力";
    private static final String 抹消者名簿帳票の出力STR = "抹消者名簿帳票の出力";
    private static final String 失権者名簿帳票の出力STR = "失権者名簿帳票の出力";
    private static final String 表示者名簿帳票の出力STR = "表示者名簿帳票の出力";
    private static final String 訂正者名簿帳票の出力STR = "訂正者名簿帳票の出力";
    private static final String 新規登録者宛名シール12面作成STR = "新規登録者宛名シール12面作成";
    private static final String 新規登録者宛名シール21面作成STR = "新規登録者宛名シール21面作成";
    private static final String 選挙人名簿抄本縦覧帳票の出力STR = "選挙人名簿抄本縦覧帳票の出力";
    private static final String 登録者名簿縦覧帳票の出力STR = "登録者名簿縦覧帳票の出力";
    private static final String 抹消者名簿帳票縦覧の出力STR = "抹消者名簿帳票縦覧の出力";

    private static final String 選挙人名簿一時テーブルSTR = "選挙人名簿一時テーブル";
    private static final String 選挙人名簿インサートSTR = "選挙人名簿インサート";

    @Override
    protected void prepareConfigData() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(getParameter().get基準日());
        shikibetsuTaishoPSMSearchKey = build.build();
        build.setデータ取得区分(DataShutokuKubun.全履歴);
        shikibetsuTaishoSearchKeyAll = build.build();
        processParameter = getParameter().toAFABTK104SelectProcessParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoSearchKeyAll);
        processParameter.set画面区分(MeiboKaikuEdited.海区漁業調整委員会委員選挙人名簿最新化.getValue());
        宛名シール面数 = BusinessConfig.get(
                ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);

    }

    @Override
    protected void defineFlow() {
        executeStep(選挙人名簿一時テーブルSTR);
        executeStep(選挙資格の更新STR);
        選挙人名簿インサート();
        executeStep(海区名簿更新日の更新STR);
        選挙人名簿抄本帳票の出力();
        選挙人名簿抄本縦覧帳票の出力();
        登録者数リスト帳票の出力();
        登録者名簿帳票の出力();
        登録者名簿縦覧帳票の出力();
        新規登録者宛名シール作成();
        抹消者名簿帳票の出力();
        抹消者名簿帳票縦覧の出力();
        失権者名簿帳票の出力();
        表示者名簿帳票の出力();
        訂正者名簿帳票の出力();
        バッチ出力条件リスト出力();
    }

    @Step(選挙人名簿一時テーブルSTR)
    IBatchFlowCommand executCreatTempMeibo() {
        return loopBatch(CreatTempMeiboProcess.class).arguments(processParameter).define();
    }

    @Step(選挙資格の更新STR)
    IBatchFlowCommand executKaikuSenkyoShikakuUpdate() {
        return loopBatch(KaikuSenkyoShikakuUpdateProcess.class).arguments(processParameter).define();
    }

    @Step(選挙人名簿インサートSTR)
    IBatchFlowCommand executKaikuSenkyoninMeiboInsert() {
        processParameter.setTable(getResult(RString.class,
                new RString(選挙人名簿一時テーブルSTR), CreatTempMeiboProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(KaikuSenkyoninMeiboInsertProcess.class).arguments(processParameter).define();
    }

    @Step(海区名簿更新日の更新STR)
    IBatchFlowCommand executKaikuSenkyoUpdate() {
        return loopBatch(KaikuSenkyoUpdateProcess.class).arguments(processParameter).define();
    }

    @Step(選挙人名簿抄本帳票の出力STR)
    IBatchFlowCommand executKaikuMeiboShohon() {
        return loopBatch(KaikuMeiboShohonReportProcess.class).arguments(processParameter).define();
    }

    @Step(選挙人名簿抄本縦覧帳票の出力STR)
    IBatchFlowCommand executKaikuMeiboShohonJuran() {
        return loopBatch(KaikuMeiboShohonJuranReportProcess.class).arguments(processParameter).define();
    }

    @Step(登録者数リスト帳票の出力STR)
    IBatchFlowCommand executKaikuTorokushasuList() {
        return loopBatch(KaikuTorokushasuListReportProcess.class).arguments(processParameter).define();
    }

    @Step(登録者名簿帳票の出力STR)
    IBatchFlowCommand executKaikuTorokushaMeibo() {
        return loopBatch(KaikuTorokushaMeiboReportProcess.class).arguments(processParameter).define();
    }

    @Step(登録者名簿縦覧帳票の出力STR)
    IBatchFlowCommand executKaikuTorokushaMeiboJuran() {
        return loopBatch(KaikuTorokushaMeiboJuranReportProcess.class).arguments(processParameter).define();
    }

    @Step(新規登録者宛名シール12面作成STR)
    IBatchFlowCommand executKaikuAtenaSea12() {
        return loopBatch(KaikuAtenaSea12ReportProcess.class).arguments(processParameter).define();
    }

    @Step(新規登録者宛名シール21面作成STR)
    IBatchFlowCommand executKaikuAtenaSea21() {
        return loopBatch(KaikuAtenaSea21ReportProcess.class).arguments(processParameter).define();
    }

    @Step(抹消者名簿帳票の出力STR)
    IBatchFlowCommand executKaikuMasshoshaMeibo() {
        return loopBatch(KaikuMasshoshaMeiboReportProcess.class).arguments(processParameter).define();
    }

    @Step(抹消者名簿帳票縦覧の出力STR)
    IBatchFlowCommand executKaikuMasshoshaMeiboJuran() {
        return loopBatch(KaikuMasshoshaMeiboJuranReportProcess.class).arguments(processParameter).define();
    }

    @Step(失権者名簿帳票の出力STR)
    IBatchFlowCommand executKaikuShikkenshaMeibo() {
        return loopBatch(KaikuShikkenshaMeiboReportProcess.class).arguments(processParameter).define();
    }

    @Step(表示者名簿帳票の出力STR)
    IBatchFlowCommand executKaikuHyojishaMeibo() {
        return loopBatch(KaikuHyojishaMeiboReportProcess.class).arguments(processParameter).define();
    }

    @Step(訂正者名簿帳票の出力STR)
    IBatchFlowCommand executKaikuTeiseishaMeibo() {
        return loopBatch(KaikuTeiseishaMeiboReportProcess.class).arguments(processParameter).define();
    }

    private void 選挙人名簿インサート() {
        if (processParameter.get識別コードList() != null
                && !processParameter.get識別コードList().isEmpty()) {
            executeStep(選挙人名簿インサートSTR);
        }
    }

    private void 選挙人名簿抄本帳票の出力() {
        if (getParameter().is選挙人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set集計項目IDリスト(get集計項目ID(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(選挙人名簿抄本帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 選挙人名簿抄本帳票の出力STR, ページコント),
                    ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本));
        }

    }

    private void 選挙人名簿抄本縦覧帳票の出力() {
        if (getParameter().is選挙人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set集計項目IDリスト(get集計項目ID(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(選挙人名簿抄本縦覧帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 選挙人名簿抄本縦覧帳票の出力STR, ページコント),
                    ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧));
        }
    }

    private void 登録者数リスト帳票の出力() {
        if (getParameter().is登録者数リスト出力有無()) {
            帳票ID = ReportIdKeys.AFAPRA103_登録者数リスト海区選挙.value();
            processParameter.set出力順(getソート順(帳票ID).substring(KaikuNumberEdit.固定数_9.getKey()));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(登録者数リスト帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 登録者数リスト帳票の出力STR, ページコント),
                    ReportIdKeys.AFAPRA103_登録者数リスト海区選挙));
        }
    }

    private void 登録者名簿帳票の出力() {
        if (getParameter().is登録者名簿出力有無()) {
            帳票ID = ReportIdKeys.新規登録者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(登録者名簿帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 登録者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.新規登録者名簿海区));
        }
    }

    private void 登録者名簿縦覧帳票の出力() {
        if (getParameter().is登録者名簿出力有無()) {
            帳票ID = ReportIdKeys.新規登録者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(登録者名簿縦覧帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 登録者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.新規登録者名簿海区));
        }
    }

    private void 抹消者名簿帳票の出力() {
        if (getParameter().is抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.抹消者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(抹消者名簿帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 抹消者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.抹消者名簿海区));
        }
    }

    private void 抹消者名簿帳票縦覧の出力() {
        if (getParameter().is抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.抹消者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(抹消者名簿帳票縦覧の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 抹消者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.抹消者名簿海区));
        }
    }

    private void 失権者名簿帳票の出力() {
        if (getParameter().is失権者名簿出力有無()) {
            帳票ID = ReportIdKeys.失権者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(失権者名簿帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 失権者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.失権者名簿海区));
        }
    }

    private void 表示者名簿帳票の出力() {
        if (getParameter().is表示者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(表示者名簿帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 表示者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.表示者名簿海区));
        }
    }

    private void 訂正者名簿帳票の出力() {
        if (getParameter().is訂正者名簿出力有無()) {
            帳票ID = ReportIdKeys.訂正者名簿海区.value();
            processParameter.set出力順(getソート順(帳票ID));
            processParameter.set改頁項目IDリスト(get改頁項目(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(訂正者名簿帳票の出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 訂正者名簿帳票の出力STR, ページコント),
                    ReportIdKeys.訂正者名簿海区));
        }
    }

    private void 新規登録者宛名シール作成() {
        if (getParameter().is新規登録者宛名シール作成有無() && 宛名シール面数.equals(MeiboKaikuEdited.面数_12.getKey())) {
            帳票ID = ReportIdKeys.新規登録者宛名シール.value();
            processParameter.set出力順(getソート順(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(新規登録者宛名シール12面作成STR);

        } else if (getParameter().is新規登録者宛名シール作成有無() && 宛名シール面数.equals(MeiboKaikuEdited.面数_21.getKey())) {
            帳票ID = ReportIdKeys.新規登録者宛名シール.value();
            processParameter.set出力順(getソート順(帳票ID));
            抄本番号List.add(processParameter.get抄本番号());
            processParameter.set抄本番号List(抄本番号List);
            executeStep(新規登録者宛名シール21面作成STR);
        }
    }

    private void バッチ出力条件リスト出力() {
        for (ReportOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数, ReportIdKeys reportId) {
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csv出力有無 = SenkyojiKaikuEdit.CSV出力有無_あり;
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件 = get出力条件リスト();

        return new ReportOutputJokenhyoItem(reportId.value(), 地方公共団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, csv出力有無, csvファイル名, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_抄本名.concat(getParameter().get抄本名()));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_基準日.concat(getParameter().get基準日().toString()));

        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_名簿確定日.concat(getParameter().get名簿確定日().toString()));

        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_年齢到達日.concat(getParameter().get年齢到達日().toString()));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_最新化時点日.concat(getParameter().get最新化時点日().toString()));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_投票日.concat(getParameter().get投票日().toString()));

        if (getParameter().is最新化有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_最新化有無.concat(new RString("true")));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_最新化有無.concat(new RString("false")));
        }

        if (getParameter().is名簿並び替え有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_名簿並び替え有無.concat(new RString("true")));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_名簿並び替え有無.concat(new RString("false")));
        }

        if (getParameter().is選挙人名簿抄本出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_選挙人名簿抄本.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_選挙人名簿抄本.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is登録者数リスト出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_登録者数リスト.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_登録者数リスト.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }
        if (!getParameter().get時点().isEmpty()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_時点日.concat(getParameter().get時点().toString()));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_時点日.concat(getParameter().get基準日().toString()));
        }

        if (getParameter().is登録者名簿出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_登録者名簿.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_登録者名簿.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is抹消者名簿出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_抹消者名簿.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_抹消者名簿.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is新規登録者宛名シール作成有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_新規登録者宛名シールも作成する.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_新規登録者宛名シールも作成する.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is失権者名簿出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_失権者名簿.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_失権者名簿.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is表示者名簿出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_表示者名簿.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_表示者名簿.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        if (getParameter().is訂正者名簿出力有無()) {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_訂正者名簿.concat(SenkyojiKaikuEdit.出力内容_出力));
        } else {
            出力条件リスト.add(SenkyojiKaikuEdit.出力条件_訂正者名簿.concat(SenkyojiKaikuEdit.出力内容_出力しない));
        }

        return 出力条件リスト;
    }

    private List<RString> get集計項目ID(RString 帳票ID) {
        List<RString> 集計項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is集計項目()) {
                    集計項目IDリスト.add(setSortItem.get項目名());

                }
            }
            return 集計項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(SenkyojiZaisankuReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private List<RString> get改頁項目(RString 帳票ID) {
        List<RString> 改頁項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (帳票出力順 != null && !帳票出力順.isEmpty()) {

            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is改頁項目()) {
                    改頁項目IDリスト.add(setSortItem.get項目ID());
                }
            }
            return 改頁項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

}
