/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE5050;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050.AFABTE505BatchShutsuryokuJokenhyoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050.JikanbetsuTohyoshaReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050.NendaibetsuTohyoritsuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050.NenreibetsuTohyoritsuReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.NenreiNendaiReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.definition.batchprm.tohyokekkaprint.AFABTE505BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505BatchPrintProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.SortOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.Order;

/**
 * 投票結果集計表バッチ処理クラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class AFABTE505_TohyoKekkaShukeihyoFlow extends BatchFlowBase<AFABTE505BatchParameter> {

    private static final String 年齢別投票率集計表 = "年齢別投票率集計表";
    private static final String 年代別投票率集計表 = "年代別投票率集計表";
    private static final String 時間別投票者集計表 = "時間別投票者集計表";
    private static final String バッチ出力条件表 = "バッチ出力条件表";

    private static final RString ページコント = new RString("pageCount");

    private ShikibetsuTaishoSearchKeyBuilder key;
    private AFABTE505BatchPrintProcessParameter batchPrintProcessParameter;

    @Override
    protected void prepareConfigData() {
        key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        batchPrintProcessParameter = getParameter().toAFABTE505BatchPrintProcessParameter();
    }

    @Override
    protected void defineFlow() {
        年齢別投票率集計表帳票出力();
        年代別投票率集計表帳票出力();
        時間別投票者集計表帳票出力();

        executeStep(バッチ出力条件表);
    }

    private void 年齢別投票率集計表帳票出力() {
        if (getParameter().get年齢別集計表出力有無()) {
            executeStep(年齢別投票率集計表);
            batchPrintProcessParameter.set年齢別投票率集計表出力数(getResult(Integer.class, new RString(年齢別投票率集計表), ページコント));
        }
    }

    private void 年代別投票率集計表帳票出力() {
        if (getParameter().get年代別集計表出力有無()) {
            executeStep(年代別投票率集計表);
            batchPrintProcessParameter.set年代別投票率集計表出力数(getResult(Integer.class, new RString(年代別投票率集計表), ページコント));
        }
    }

    private void 時間別投票者集計表帳票出力() {
        if (getParameter().get時間別集計表出力有無()) {
            executeStep(時間別投票者集計表);
            batchPrintProcessParameter.set時間別投票者集計表出力数(getResult(Integer.class, new RString(時間別投票者集計表), ページコント));
        }
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ReportOutputTypeWithMaster.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private RString get出力順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(NenreiNendaiReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private Order get昇順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null == 帳票出力順 || 帳票出力順.isEmpty()) {
            return Order.ASC;
        }
        List<ISetSortItem> 設定項目リスト = 帳票出力順.get(0).get設定項目リスト();

        for (ISetSortItem 設定項目 : 設定項目リスト) {
            if (ReportOutputType.生年月日.get項目ID().equals(設定項目.get項目ID())) {
                return 設定項目.get昇降順().equals(SortOrder.ASCENDING) ? Order.ASC : Order.DESC;
            }
        }
        return Order.ASC;
    }

    @Step(年齢別投票率集計表)
    IBatchFlowCommand get年齢別投票率集計表帳票出力() {
        return loopBatch(NenreibetsuTohyoritsuReportProcess.class).arguments(getParameter()
                .to年齢別投票集計表ProcessParameter(
                        key.getPSM検索キー(),
                        get出力順(ReportIdKeys.年齢別投票率集計表.value()),
                        get昇順(ReportIdKeys.年齢別投票率集計表.value()))).define();
    }

    @Step(年代別投票率集計表)
    IBatchFlowCommand get年代別投票状況調べ帳票出力() {
        return loopBatch(NendaibetsuTohyoritsuReportProcess.class).arguments(getParameter()
                .to年代別投票集計表ProcessParameter(
                        key.getPSM検索キー(),
                        get出力順(ReportIdKeys.年代別投票率集計表.value()),
                        get昇順(ReportIdKeys.年代別投票率集計表.value()))).define();
    }

    @Step(時間別投票者集計表)
    IBatchFlowCommand get時間別投票状況表合計帳票出力() {
        return loopBatch(JikanbetsuTohyoshaReportProcess.class).arguments(getParameter()
                .to時間別投票集計表ProcessParameter(
                        key.getPSM検索キー(),
                        getソート順(ReportIdKeys.時間別投票者集計表.value()))).define();
    }

    @Step(バッチ出力条件表)
    IBatchFlowCommand getバッチ出力条件表() {
        batchPrintProcessParameter.set抄本番号(new ShohonNo(getParameter().get抄本番号()));
        batchPrintProcessParameter.setジョブ番号(this.getJobId());
        return simpleBatch(AFABTE505BatchShutsuryokuJokenhyoProcess.class).arguments(batchPrintProcessParameter).define();
    }

}
