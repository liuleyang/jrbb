/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE5030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.FuzaihsaNippoJuriReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.FuzaihsaNippoKofuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.FuzaishaTohyoshaListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.KijitsumaeNippoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.KijitsumaeTohyoshaListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.ShukeiSeirihyoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.TohyoJiyuChoshoFuzaihsaReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.TohyoJiyuChoshoKijitsumaeReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.TohyoshaListSenkyoAllReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.TohyoshaListSenkyoFuzaihsaReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030.TohyoshaListSenkyoKijitsumaeReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nippo.AFABTE503BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日報バッチ処理クラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class AFABTE503_NippoFlow extends BatchFlowBase<AFABTE503BatchParameter> {

    private static final String 期日前投票日報帳票 = "期日前投票日報帳票";
    private static final String 不在者投票交付日報帳票 = "不在者投票交付日報帳票";
    private static final String 不在者投票受理日報帳票 = "不在者投票受理日報帳票";
    private static final String 期日前投票者一覧表帳票 = "期日前投票者一覧表帳票";
    private static final String 不在者投票者一覧表帳票 = "不在者投票者一覧表帳票";
    private static final String 投票者一覧全表帳票 = "投票者一覧全表帳票";
    private static final String 投票者一覧期日前表帳票 = "投票者一覧期日前表帳票";
    private static final String 投票者一覧不在者表帳票 = "投票者一覧不在者表帳票";
    private static final String 期日前投票の事由に関する調書帳票 = "期日前投票の事由に関する調書帳票";
    private static final String 不在者投票の事由に関する調書帳票 = "不在者投票の事由に関する調書帳票";
    private static final String 投票集計整理表帳票 = "投票集計整理表帳票";

    private static final RString 不在者投票日報_交付日報 = new RString("不在者投票日報　交付日報");
    private static final RString 不在者投票日報_受理日報 = new RString("不在者投票日報　受理日報");

    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】　");
    private static final RString 出力条件_無投票選挙有無 = new RString("【無投票選挙も出力する】　");
    private static final RString 出力条件_施設コード = new RString("【施設コード】　");
    private static final RString 出力条件_受理日 = new RString("【受理日】　");
    private static final RString 出力条件_交付日 = new RString("【交付日】　");
    private static final RString 出力条件_投票日 = new RString("【投票日】　");
    private static final RString 出力条件_投票区 = new RString("【投票区】　");
    private static final RString 出力条件_期日前投票日 = new RString("【期日前投票日】 ");
    private static final RString 出力条件_代理投票のみ = new RString("【代理投票のみ】 ");
    private static final RString 出力条件_点字投票のみ = new RString("【点字投票のみ】 ");
    private static final RString 出力条件_棄権のみ = new RString("【棄権のみ】 ");
    private static final RString 出力条件_受付拒否のみ = new RString("【受付拒否のみ】 ");
    private static final RString 出力条件_仮投票のみ = new RString("【仮投票のみ】 ");
    private static final RString 出力条件_請求のみ = new RString("【請求のみ】 ");
    private static final RString 出力条件_未着者のみ = new RString("【未着者のみ】 ");
    private static final RString 出力条件_返還のみ = new RString("【返還のみ】 ");
    private static final RString 出力条件_投票事由 = new RString("【投票事由】 ");
    private static final RString 出力条件_投票時刻 = new RString("【投票時刻】 ");
    private static final RString 出力条件_受理時刻 = new RString("【受理時刻】 ");

    private static final RString 投票状況 = new RString("【投票状況】　");
    private static final RString 投票状況_交付 = new RString("交付");
    private static final RString 投票状況_受理 = new RString("受理");
    private static final RString 投票状況_期日前 = new RString("期日前");
    private static final RString 選挙NO = new RString("senkyoNo");
    private static final RString 波形 = new RString("～");
    private static final RString 二重引用符 = new RString("\"");
    private static final RString OR = new RString("　OR　");

    private static final RString ページコント = new RString("pageCount");

    private ShikibetsuTaishoSearchKeyBuilder key;
    private Association association;
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    @Override
    protected void prepareConfigData() {
        key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        association = AssociationFinderFactory.createInstance().getAssociation();

    }

    @Override
    protected void defineFlow() {
        if (getParameter().get期日前投票日報()) {
            期日前投票日報帳票出力();
        }
        if (getParameter().get不在者投票日報()) {
            if (getParameter().get不在者交付日報()) {
                不在者投票交付日報帳票出力();
            }
            if (getParameter().get不在者受理日報()) {
                不在者投票受理日報帳票出力();
            }
        }
        if (getParameter().get期日前投票者一覧表()) {
            期日前投票者一覧表帳票出力();
        }
        if (getParameter().get不在者投票者一覧表()) {
            不在者投票者一覧表帳票出力();
        }
        if (getParameter().get投票者一覧表()) {
            if (getParameter().get投票者一覧表混在()) {
                投票者一覧期日前不在者投票者一覧表帳票出力();
            }
            if (getParameter().get投票者一覧表期日前投票()) {
                投票者一覧期日前投票者一覧表帳票出力();
            }
            if (getParameter().get投票者一覧表不在者投票()) {
                投票者一覧不在者投票者一覧表帳票出力();
            }
        }
        if (getParameter().get投票事由調書()) {
            if (getParameter().get投票事由調書期日前投票()) {
                期日前投票の事由に関する調書帳票出力();
            }
            if (getParameter().get投票事由調書不在者投票()) {
                不在者投票の事由に関する調書帳票出力();
            }
        }
        if (getParameter().get投票集計整理表()) {
            投票集計整理表帳票出力();
        }
        バッチ出力条件リスト出力();
    }

    private void 期日前投票日報帳票出力() {
        executeStep(期日前投票日報帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(期日前投票日報帳票), ページコント),
                ReportIdKeys.AFAPRE500_期日前投票日報, 期日前投票日報帳票));
    }

    private void 不在者投票交付日報帳票出力() {
        executeStep(不在者投票交付日報帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(不在者投票交付日報帳票), ページコント),
                ReportIdKeys.AFAPRE501_不在者投票日報, 不在者投票交付日報帳票));
    }

    private void 不在者投票受理日報帳票出力() {
        executeStep(不在者投票受理日報帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(不在者投票受理日報帳票), ページコント),
                ReportIdKeys.AFAPRE501_不在者投票日報, 不在者投票受理日報帳票));
    }

    private void 期日前投票者一覧表帳票出力() {
        executeStep(期日前投票者一覧表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(期日前投票者一覧表帳票), ページコント),
                ReportIdKeys.AFAPRE502_期日前投票者一覧表, 期日前投票者一覧表帳票));
    }

    private void 不在者投票者一覧表帳票出力() {
        executeStep(不在者投票者一覧表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(不在者投票者一覧表帳票), ページコント),
                ReportIdKeys.AFAPRE502_不在者投票者一覧表, 不在者投票者一覧表帳票));
    }

    private void 投票者一覧期日前不在者投票者一覧表帳票出力() {
        executeStep(投票者一覧全表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(投票者一覧全表帳票), ページコント),
                ReportIdKeys.AFAPRE503_投票者一覧表, 投票者一覧全表帳票));
    }

    private void 投票者一覧期日前投票者一覧表帳票出力() {
        executeStep(投票者一覧期日前表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(投票者一覧期日前表帳票), ページコント),
                ReportIdKeys.AFAPRE503_投票者一覧表, 投票者一覧期日前表帳票));
    }

    private void 投票者一覧不在者投票者一覧表帳票出力() {
        executeStep(投票者一覧不在者表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(投票者一覧不在者表帳票), ページコント),
                ReportIdKeys.AFAPRE503_投票者一覧表, 投票者一覧不在者表帳票));
    }

    private void 期日前投票の事由に関する調書帳票出力() {
        executeStep(期日前投票の事由に関する調書帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(期日前投票の事由に関する調書帳票), ページコント),
                ReportIdKeys.AFAPRE504_投票事由調書, 期日前投票の事由に関する調書帳票));
    }

    private void 不在者投票の事由に関する調書帳票出力() {
        executeStep(不在者投票の事由に関する調書帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(不在者投票の事由に関する調書帳票), ページコント),
                ReportIdKeys.AFAPRE504_投票事由調書, 不在者投票の事由に関する調書帳票));
    }

    private void 投票集計整理表帳票出力() {
        executeStep(投票集計整理表帳票);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, new RString(投票集計整理表帳票), ページコント),
                ReportIdKeys.AFAPRE505_集計整理表, 投票集計整理表帳票));
    }

    @Step(期日前投票日報帳票)
    IBatchFlowCommand
            get期日前投票日報帳票出力() {
        return loopBatch(KijitsumaeNippoReportProcess.class).arguments(getParameter()
                .to期日前投票日報ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(ReportIdKeys.AFAPRE500_期日前投票日報.value()),
                        get改頁リスト固定(ReportIdKeys.AFAPRE500_期日前投票日報.value()))).define();
    }

    @Step(不在者投票交付日報帳票)
    IBatchFlowCommand
            get不在者投票交付日報帳票出力() {
        return loopBatch(FuzaihsaNippoKofuReportProcess.class
        ).arguments(getParameter()
                .to不在者投票交付日報ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(不在者投票日報_交付日報),
                        get改頁リスト固定(不在者投票日報_交付日報))).define();
    }

    @Step(不在者投票受理日報帳票)
    IBatchFlowCommand
            get不在者投票受理日報帳票出力() {
        return loopBatch(FuzaihsaNippoJuriReportProcess.class
        ).arguments(getParameter()
                .to不在者投票受理日報ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(不在者投票日報_受理日報),
                        get改頁リスト固定(不在者投票日報_受理日報))).define();
    }

    @Step(期日前投票者一覧表帳票)
    IBatchFlowCommand
            get期日前投票者一覧表帳票出力() {
        return loopBatch(KijitsumaeTohyoshaListReportProcess.class
        ).arguments(getParameter()
                .to期日前投票者一覧表ProcessParameter(key.getPSM検索キー(),
                        getソート順(ReportIdKeys.AFAPRE502_期日前投票者一覧表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE502_期日前投票者一覧表.value()),
                        association.get地方公共団体コード().getColumnValue(), association.get連番())).define();
    }

    @Step(不在者投票者一覧表帳票)
    IBatchFlowCommand
            get不在者投票者一覧表帳票出力() {
        return loopBatch(FuzaishaTohyoshaListReportProcess.class
        ).arguments(getParameter()
                .to不在者投票者一覧表ProcessParameter(key.getPSM検索キー(),
                        getソート順(ReportIdKeys.AFAPRE502_不在者投票者一覧表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE502_不在者投票者一覧表.value()),
                        association.get地方公共団体コード().getColumnValue(), association.get連番())).define();
    }

    @Step(投票者一覧全表帳票)
    IBatchFlowCommand get投票者一覧期日前不在者投票者一覧表帳票出力() {
        return loopBatch(TohyoshaListSenkyoAllReportProcess.class
        ).arguments(getParameter()
                .to投票者一覧期日前不在者投票者一覧表ProcessParameter(key.getPSM検索キー(),
                        getソート順(ReportIdKeys.AFAPRE503_投票者一覧表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE503_投票者一覧表.value()))).define();
    }

    @Step(投票者一覧期日前表帳票)
    IBatchFlowCommand
            get投票者一覧期日前投票者一覧表帳票出力() {
        return loopBatch(TohyoshaListSenkyoKijitsumaeReportProcess.class
        ).arguments(getParameter()
                .to投票者一覧期日前投票者一覧表ProcessParameter(key.getPSM検索キー(),
                        getソート順(ReportIdKeys.AFAPRE503_投票者一覧表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE503_投票者一覧表.value()))).define();
    }

    @Step(投票者一覧不在者表帳票)
    IBatchFlowCommand
            get投票者一覧不在者投票者一覧表帳票出力() {
        return loopBatch(TohyoshaListSenkyoFuzaihsaReportProcess.class
        ).arguments(getParameter()
                .to投票者一覧不在者投票者一覧表ProcessParameter(key.getPSM検索キー(),
                        getソート順(ReportIdKeys.AFAPRE503_投票者一覧表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE503_投票者一覧表.value()))).define();
    }

    @Step(期日前投票の事由に関する調書帳票)
    IBatchFlowCommand
            get期日前投票の事由に関する調書帳票出力() {
        return loopBatch(TohyoJiyuChoshoKijitsumaeReportProcess.class).arguments(getParameter()
                .to期日前投票の事由に関する調書ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(ReportIdKeys.AFAPRE504_投票事由調書.value()),
                        get改頁リスト固定(ReportIdKeys.AFAPRE504_投票事由調書.value()))).define();
    }

    @Step(不在者投票の事由に関する調書帳票)
    IBatchFlowCommand
            get不在者投票の事由に関する調書帳票出力() {
        return loopBatch(TohyoJiyuChoshoFuzaihsaReportProcess.class).arguments(getParameter()
                .to不在者投票の事由に関する調書ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(ReportIdKeys.AFAPRE504_投票事由調書.value()),
                        get改頁リスト固定(ReportIdKeys.AFAPRE504_投票事由調書.value()))).define();
    }

    @Step(投票集計整理表帳票)
    IBatchFlowCommand
            get投票集計整理表帳票出力() {
        return loopBatch(ShukeiSeirihyoReportProcess.class
        ).arguments(getParameter()
                .to投票集計整理表ProcessParameter(key.getPSM検索キー(),
                        getソート順固定(ReportIdKeys.AFAPRE505_集計整理表.value()),
                        get改頁リスト(ReportIdKeys.AFAPRE505_集計整理表.value()))).define();
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        RString sortJun;
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            sortJun = MyBatisOrderByClauseCreator.create(ReportOutputTypeWithMaster.class, 帳票出力順.get(0));
        } else {
            sortJun = RString.EMPTY;
        }
//        if (sortJun.contains("\"AfT201TohyoJokyo\"")) {
//            sortJun = sortJun.replace("\"AfT201TohyoJokyo\".\"", "master.\"afT201TohyoJokyo_");
//        }
//        if (sortJun.contains("\"AfT112SenkyoninMeibo\"")) {
//            sortJun = sortJun.replace("\"AfT112SenkyoninMeibo\".\"", "master.\"afT112SenkyoninMeibo_");
//        }

        return sortJun;
    }

    private List<RString> get改頁リスト(RString 帳票ID) {
        List<RString> 改頁項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is改頁項目()) {
                    改頁項目IDリスト.add(setSortItem.getDB項目名());
                }
            }
            return 改頁項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private RString getソート順固定(RString 帳票ID) {
        RString orderBy = new RString("Order By ");
        if (ReportIdKeys.AFAPRE500_期日前投票日報.value().equals(帳票ID)) {
            orderBy = orderBy.concat(new RString("master.\"afT201TohyoJokyo_senkyoNo\","))
                    .concat(new RString("master.\"afT201TohyoJokyo_shisetsuCode\",master.\"afT201TohyoJokyo_juriYMD\""));
        } else if (不在者投票日報_交付日報.equals(帳票ID)) {
            orderBy = orderBy.concat(new RString("master.\"afT201TohyoJokyo_senkyoNo\",master.\"afT201TohyoJokyo_kofuYMD\""));
        } else if (不在者投票日報_受理日報.equals(帳票ID)) {
            orderBy = orderBy.concat(new RString("master.\"afT201TohyoJokyo_senkyoNo\",master.\"afT201TohyoJokyo_juriYMD\""));
        } else if (ReportIdKeys.AFAPRE504_投票事由調書.value().equals(帳票ID)) {
            orderBy = orderBy.concat(new RString("\"AfT201TohyoJokyo\".\"senkyoNo\",\"AfT112SenkyoninMeibo\".\"tohyokuCode\" "));
        } else if (ReportIdKeys.AFAPRE505_集計整理表.value().equals(帳票ID)) {
            orderBy = orderBy.concat(new RString("master.\"afT201TohyoJokyo_senkyoNo\",master.\"afT112SenkyoninMeibo_tohyokuCode\""));
        }
        return orderBy;
    }

    private List<RString> get改頁リスト固定(RString 帳票ID) {
        List<RString> 改頁リスト = new ArrayList<>();
        if (ReportIdKeys.AFAPRE500_期日前投票日報.value().equals(帳票ID)) {
            改頁リスト.add(選挙NO);
            改頁リスト.add(new RString("shisetsuCode"));
        } else if (不在者投票日報_交付日報.equals(帳票ID) || 不在者投票日報_受理日報.equals(帳票ID)) {
            改頁リスト.add(選挙NO);
        } else if (ReportIdKeys.AFAPRE504_投票事由調書.value().equals(帳票ID)) {
            改頁リスト.add(選挙NO);
        } else if (ReportIdKeys.AFAPRE505_集計整理表.value().equals(帳票ID)) {
            改頁リスト.add(選挙NO);
        }
        return 改頁リスト;
    }

    private void バッチ出力条件リスト出力() {
        ReportOutputJokenhyoFactory.createInstance(reportOutputJokenhyoItems).print();
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数, ReportIdKeys reportId,
            String 帳票パターン) {
        RString 帳票ID = reportId.value();
        RString 市町村コード = association.getLasdecCode_().code市町村RString();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csv出力有無 = new RString("あり");
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件 = get出力条件リスト(reportId, 帳票パターン);

        return new ReportOutputJokenhyoItem(帳票ID, 市町村コード, 市町村名, ジョブ番号,
                帳票名, ページ数, csv出力有無, csvファイル名, 出力条件);
    }

    private List<RString> get出力条件リスト(ReportIdKeys reportId, String 帳票パターン) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_抄本番号.concat(getParameter().get抄本番号()));
        出力条件リスト.add(出力条件_無投票選挙有無.concat(getParameter().get無投票選挙も出力する().toString()));
        if (reportId.equals(ReportIdKeys.AFAPRE500_期日前投票日報)) {
            出力条件リスト.add(出力条件_施設コード.concat(edit文字列(getParameter().get期日前投票施設コードFrom()).concat(波形)
                    .concat(edit文字列(getParameter().get期日前投票施設コードTo()))));
            出力条件リスト.add(出力条件_投票日.concat(edit日付(getParameter().get期日前投票投票日From())).concat(波形)
                    .concat(edit日付(getParameter().get期日前投票投票日To())));
            出力条件リスト.add(投票状況.concat(投票状況_期日前));

        } else if (reportId.equals(ReportIdKeys.AFAPRE501_不在者投票日報)) {
            switch (帳票パターン) {
                case 不在者投票交付日報帳票:
                    出力条件リスト.add(出力条件_投票日.concat(edit日付(getParameter().get不在者交付日From())).concat(波形)
                            .concat(edit日付(getParameter().get不在者交付日To())));
                    出力条件リスト.add(投票状況.concat(投票状況_交付));
                    break;
                case 不在者投票受理日報帳票:
                    出力条件リスト.add(出力条件_投票日.concat(edit日付(getParameter().get不在者受理日From())).concat(波形)
                            .concat(edit日付(getParameter().get不在者受理日To())));
                    出力条件リスト.add(投票状況.concat(投票状況_受理));
                    break;
                default:
            }

        } else if (reportId.equals(ReportIdKeys.AFAPRE502_期日前投票者一覧表)) {
            set出力条件リストAFAPRE502_期日前投票者一覧表(出力条件リスト);
        } else if (reportId.equals(ReportIdKeys.AFAPRE502_不在者投票者一覧表)) {
            set出力条件リストAFAPRE502_不在者投票者一覧表(出力条件リスト);

        } else if (reportId.equals(ReportIdKeys.AFAPRE503_投票者一覧表)) {
            switch (帳票パターン) {
                case 投票者一覧全表帳票:
                    出力条件リスト.add(出力条件_投票区.concat(getParameter().get投票者一覧表投票区From()).concat(波形)
                            .concat(getParameter().get投票者一覧表投票区To()));
                    出力条件リスト.add(出力条件_施設コード.concat(edit文字列(getParameter().get投票者一覧表施設コードFrom())).concat(波形)
                            .concat(edit文字列(getParameter().get投票者一覧表施設コードTo())));
                    出力条件リスト.add(投票状況.concat(二重引用符).concat(投票状況_期日前).concat(二重引用符).concat(OR)
                            .concat(二重引用符).concat(投票状況_交付).concat(二重引用符).concat(OR).concat(二重引用符)
                            .concat(投票状況_受理).concat(二重引用符));
                    break;
                case 投票者一覧期日前表帳票:
                    set出力条件リスト投票者一覧期日前表帳票(出力条件リスト);
                    break;
                case 投票者一覧不在者表帳票:
                    set出力条件リスト投票者一覧不在者表帳票(出力条件リスト);
                    break;
                default:
            }

        } else if (reportId.equals(ReportIdKeys.AFAPRE504_投票事由調書)) {
            switch (帳票パターン) {
                case 期日前投票の事由に関する調書帳票:
                    出力条件リスト.add(出力条件_期日前投票日.concat(edit日付(getParameter().get投票事由調書期日前投票日From())).concat(波形)
                            .concat(edit日付(getParameter().get投票事由調書期日前投票日To())));
                    出力条件リスト.add(投票状況.concat(投票状況_期日前));
                    break;
                case 不在者投票の事由に関する調書帳票:
                    出力条件リスト.add(出力条件_受理日.concat(edit日付(getParameter().get投票事由調書受理日From())).concat(波形)
                            .concat(edit日付(getParameter().get投票事由調書受理日To())));
                    出力条件リスト.add(投票状況.concat(二重引用符).concat(投票状況_交付).concat(二重引用符).concat(OR)
                            .concat(二重引用符).concat(投票状況_受理).concat(二重引用符));
                    break;
                default:
            }
        } else if (reportId.equals(ReportIdKeys.AFAPRE505_集計整理表)) {
            出力条件リスト.add(出力条件_投票区.concat(getParameter().get投票集計整理表投票区From()).concat(波形)
                    .concat(getParameter().get投票集計整理表投票区To().toString()));
            出力条件リスト.add(出力条件_受理日.concat(edit日付(getParameter().get投票集計整理表受理日())));
        }
        return 出力条件リスト;
    }

    private void set出力条件リストAFAPRE502_期日前投票者一覧表(List<RString> 出力条件リスト) {
        RString 投票時刻From = RString.EMPTY;
        RString 投票時刻To = RString.EMPTY;
        if (null != getParameter().get期日前投票者一覧表投票時刻From()) {
            投票時刻From = new RString(getParameter().get期日前投票者一覧表投票時刻From().toString());
        }
        if (null != getParameter().get期日前投票者一覧表投票時刻To()) {
            投票時刻To = new RString(getParameter().get期日前投票者一覧表投票時刻To().toString());
        }
        出力条件リスト.add(出力条件_投票区.concat(getParameter().get期日前投票者一覧表投票区From()).concat(波形)
                .concat(getParameter().get期日前投票者一覧表投票区To()));
        出力条件リスト.add(出力条件_施設コード.concat(edit文字列(getParameter().get期日前投票者一覧表施設コードFrom())).concat(波形)
                .concat(edit文字列(getParameter().get期日前投票者一覧表施設コードTo())));
        出力条件リスト.add(出力条件_期日前投票日.concat(edit日付(getParameter().get期日前投票者一覧表期日前投票日From())).concat(波形)
                .concat(edit日付(getParameter().get期日前投票者一覧表期日前投票日To())));
        出力条件リスト.add(出力条件_投票時刻.concat(投票時刻From).concat(波形)
                .concat(投票時刻To));
        出力条件リスト.add(出力条件_代理投票のみ.concat(getParameter().get期日前投票者一覧表代理投票のみ().toString()));
        出力条件リスト.add(出力条件_点字投票のみ.concat(getParameter().get期日前投票者一覧表点字投票のみ().toString()));
        出力条件リスト.add(出力条件_棄権のみ.concat(getParameter().get期日前投票者一覧表棄権のみ().toString()));
        出力条件リスト.add(出力条件_受付拒否のみ.concat(getParameter().get期日前投票者一覧表受付拒否のみ().toString()));
        出力条件リスト.add(出力条件_仮投票のみ.concat(getParameter().get期日前投票者一覧表仮投票のみ().toString()));
        出力条件リスト.add(投票状況.concat(投票状況_期日前));
    }

    private void set出力条件リストAFAPRE502_不在者投票者一覧表(List<RString> 出力条件リスト) {
        RString 受理時刻From = RString.EMPTY;
        RString 受理時刻To = RString.EMPTY;
        if (null != getParameter().get不在者投票者一覧表受理時刻From()) {
            受理時刻From = new RString(getParameter().get不在者投票者一覧表受理時刻From().toString());
        }
        if (null != getParameter().get不在者投票者一覧表受理時刻To()) {
            受理時刻To = new RString(getParameter().get不在者投票者一覧表受理時刻To().toString());
        }
        出力条件リスト.add(出力条件_投票区.concat(getParameter().get不在者投票者一覧表投票区From()).concat(波形)
                .concat(getParameter().get不在者投票者一覧表投票区To()));
        出力条件リスト.add(出力条件_施設コード.concat(edit文字列(getParameter().get不在者投票者一覧表施設コードFrom())).concat(波形)
                .concat(edit文字列(getParameter().get不在者投票者一覧表施設コードTo())));
        出力条件リスト.add(出力条件_交付日.concat(edit日付(getParameter().get不在者投票者一覧表交付日From())).concat(波形)
                .concat(edit日付(getParameter().get不在者投票者一覧表交付日To())));
        出力条件リスト.add(出力条件_受理日.concat(edit日付(getParameter().get不在者投票者一覧表受理日From())).concat(波形)
                .concat(edit日付(getParameter().get不在者投票者一覧表受理日To())));
        出力条件リスト.add(出力条件_受理時刻.concat(受理時刻From).concat(波形)
                .concat(受理時刻To));
        出力条件リスト.add(出力条件_請求のみ.concat(getParameter().get不在者投票者一覧表請求のみ().toString()));
        出力条件リスト.add(出力条件_未着者のみ.concat(getParameter().get不在者投票者一覧表未着者のみ().toString()));
        出力条件リスト.add(出力条件_代理投票のみ.concat(getParameter().get不在者投票者一覧表代理投票のみ().toString()));
        出力条件リスト.add(出力条件_点字投票のみ.concat(getParameter().get不在者投票者一覧表点字投票のみ().toString()));
        出力条件リスト.add(出力条件_返還のみ.concat(getParameter().get不在者投票者一覧表返還のみ().toString()));
        出力条件リスト.add(出力条件_棄権のみ.concat(getParameter().get不在者投票者一覧表棄権のみ().toString()));
        出力条件リスト.add(投票状況.concat(二重引用符).concat(投票状況_交付).concat(二重引用符).concat(OR)
                .concat(二重引用符).concat(投票状況_受理).concat(二重引用符));
    }

    private void set出力条件リスト投票者一覧期日前表帳票(List<RString> 出力条件リスト) {
        RString 投票時刻From = RString.EMPTY;
        RString 投票時刻To = RString.EMPTY;
        if (null != getParameter().get投票者一覧表期日前投票日From()) {
            投票時刻From = new RString(getParameter().get投票者一覧表期日前投票日From().toString());
        }
        if (null != getParameter().get投票者一覧表期日前投票日To()) {
            投票時刻To = new RString(getParameter().get投票者一覧表期日前投票日To().toString());
        }
        出力条件リスト.add(出力条件_投票事由.concat(getParameter().get投票者一覧表投票事由()));
        出力条件リスト.add(出力条件_期日前投票日.concat(edit日付(getParameter().get投票者一覧表期日前投票日From())).concat(波形)
                .concat(edit日付(getParameter().get投票者一覧表期日前投票日To())));
        出力条件リスト.add(出力条件_投票時刻.concat(投票時刻From).concat(波形)
                .concat(投票時刻To));
        出力条件リスト.add(出力条件_代理投票のみ.concat(getParameter().get投票者一覧表期日前代理投票のみ().toString()));
        出力条件リスト.add(出力条件_点字投票のみ.concat(getParameter().get投票者一覧表期日前点字投票のみ().toString()));
        出力条件リスト.add(出力条件_棄権のみ.concat(getParameter().get投票者一覧表期日前棄権のみ().toString()));
        出力条件リスト.add(出力条件_受付拒否のみ.concat(getParameter().get投票者一覧表期日前受付拒否のみ().toString()));
        出力条件リスト.add(出力条件_仮投票のみ.concat(getParameter().get投票者一覧表期日前仮投票のみ().toString()));
        出力条件リスト.add(投票状況.concat(投票状況_期日前));
    }

    private void set出力条件リスト投票者一覧不在者表帳票(List<RString> 出力条件リスト) {
        RString 受理時刻From = RString.EMPTY;
        RString 受理時刻To = RString.EMPTY;
        if (null != getParameter().get投票者一覧表受理時刻From()) {
            受理時刻From = new RString(getParameter().get投票者一覧表受理時刻From().toString());
        }
        if (null != getParameter().get投票者一覧表受理時刻To()) {
            受理時刻To = new RString(getParameter().get投票者一覧表受理時刻To().toString());
        }
        出力条件リスト.add(出力条件_交付日.concat(edit日付(getParameter().get投票者一覧表交付日From())).concat(波形)
                .concat(edit日付(getParameter().get投票者一覧表交付日To())));
        出力条件リスト.add(出力条件_受理日.concat(edit日付(getParameter().get投票者一覧表受理日From())).concat(波形)
                .concat(edit日付(getParameter().get投票者一覧表受理日To())));
        出力条件リスト.add(出力条件_受理時刻.concat(受理時刻From).concat(波形)
                .concat(受理時刻To));
        出力条件リスト.add(出力条件_請求のみ.concat(getParameter().get投票者一覧表請求のみ().toString()));
        出力条件リスト.add(出力条件_未着者のみ.concat(getParameter().get投票者一覧表不在者未着者のみ().toString()));
        出力条件リスト.add(出力条件_代理投票のみ.concat(getParameter().get投票者一覧表不在者代理投票のみ().toString()));
        出力条件リスト.add(出力条件_点字投票のみ.concat(getParameter().get投票者一覧表不在者点字投票のみ().toString()));
        出力条件リスト.add(出力条件_返還のみ.concat(getParameter().get投票者一覧表不在者返還のみ().toString()));
        出力条件リスト.add(出力条件_棄権のみ.concat(getParameter().get投票者一覧表不在者棄権のみ().toString()));
        出力条件リスト.add(投票状況.concat(二重引用符).concat(投票状況_交付).concat(二重引用符).concat(OR)
                .concat(二重引用符).concat(投票状況_受理).concat(二重引用符));
    }

    private RString edit日付(FlexibleDate 日付) {
        if (null != 日付) {
            return new RString(日付.toString());
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit文字列(RString 文字列) {
        if (null != 文字列) {
            return 文字列;
        } else {
            return RString.EMPTY;
        }
    }
}
