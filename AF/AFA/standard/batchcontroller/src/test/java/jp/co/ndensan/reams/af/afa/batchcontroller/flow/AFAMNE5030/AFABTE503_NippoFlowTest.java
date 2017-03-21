package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE5030;

import jp.co.ndensan.reams.af.afa.definition.batchprm.nippo.AFABTE503BatchParameter;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 投票日前日関連帳票のバッチ単体テスト用クラス。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class AFABTE503_NippoFlowTest extends AfaTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        flowHelper = new BatchFlowTestHelper();
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);
    }

    @Test
    public void AFABTE503_NippoFlowはFailとなる() throws Exception {
        AFABTE503BatchParameter parameter = setParameter();

        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTE503_NippoFlow"), new RString("AFABTE503_NippoFlow"),
                AFABTE503_NippoFlow.class, parameter);
        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.AFA選挙本体.toString(), "test", new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "testFlowId");
        when(flowContext.getExecutionSubGyomuCode()).thenReturn(executionSubGyomuCode);
        controlData.setFlowContext(flowContext);
        _ControlDataHolder.setControlData(controlData);
    }

    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;
    }

    private AFABTE503BatchParameter setParameter() {
        AFABTE503BatchParameter batchparameter = new AFABTE503BatchParameter();
        batchparameter.set抄本番号(new RString(18));
        batchparameter.set無投票選挙も出力する(Boolean.FALSE);
        batchparameter.set期日前投票日報(Boolean.FALSE);
        batchparameter.set期日前投票施設コードFrom(RString.EMPTY);
        batchparameter.set期日前投票施設コードTo(RString.EMPTY);
        batchparameter.set期日前投票投票日From(FlexibleDate.EMPTY);
        batchparameter.set期日前投票投票日To(FlexibleDate.EMPTY);
        batchparameter.set不在者投票日報(Boolean.TRUE);
        batchparameter.set不在者交付日報(Boolean.FALSE);
        batchparameter.set不在者交付日From(FlexibleDate.EMPTY);
        batchparameter.set不在者交付日To(FlexibleDate.EMPTY);
        batchparameter.set不在者受理日報(Boolean.TRUE);
        batchparameter.set不在者受理日From(new FlexibleDate("20121005"));
        batchparameter.set不在者受理日To(new FlexibleDate("20121011"));
        batchparameter.set期日前投票者一覧表(Boolean.TRUE);
        batchparameter.set期日前投票者一覧表投票区From(new RString("01"));
        batchparameter.set期日前投票者一覧表投票区To(new RString("03"));
        batchparameter.set期日前投票者一覧表施設コードFrom(new RString("0001"));
        batchparameter.set期日前投票者一覧表施設コードTo(new RString("0011"));
        batchparameter.set期日前投票者一覧表期日前投票日From(new FlexibleDate("20121205"));
        batchparameter.set期日前投票者一覧表期日前投票日To(new FlexibleDate("20121230"));
        batchparameter.set期日前投票者一覧表投票時刻From(new RTime(new RString("000000")));
        batchparameter.set期日前投票者一覧表投票時刻To(new RTime(new RString("235959")));
        batchparameter.set期日前投票者一覧表代理投票のみ(Boolean.TRUE);
        batchparameter.set期日前投票者一覧表点字投票のみ(Boolean.TRUE);
        batchparameter.set期日前投票者一覧表棄権のみ(Boolean.TRUE);
        batchparameter.set期日前投票者一覧表受付拒否のみ(Boolean.TRUE);
        batchparameter.set期日前投票者一覧表仮投票のみ(Boolean.TRUE);
        batchparameter.set不在者投票者一覧表(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表投票区From(RString.EMPTY);
        batchparameter.set不在者投票者一覧表投票区To(RString.EMPTY);
        batchparameter.set不在者投票者一覧表施設コードFrom(RString.EMPTY);
        batchparameter.set不在者投票者一覧表施設コードTo(RString.EMPTY);
        batchparameter.set不在者投票者一覧表交付日From(FlexibleDate.EMPTY);
        batchparameter.set不在者投票者一覧表交付日To(FlexibleDate.EMPTY);
        batchparameter.set不在者投票者一覧表受理日From(FlexibleDate.EMPTY);
        batchparameter.set不在者投票者一覧表受理日To(FlexibleDate.EMPTY);
        batchparameter.set不在者投票者一覧表受理時刻From(RTime.now());
        batchparameter.set不在者投票者一覧表受理時刻To(RTime.now());
        batchparameter.set不在者投票者一覧表請求のみ(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表未着者のみ(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表代理投票のみ(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表点字投票のみ(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表返還のみ(Boolean.FALSE);
        batchparameter.set不在者投票者一覧表棄権のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表(Boolean.FALSE);
        batchparameter.set投票者一覧表混在(Boolean.FALSE);
        batchparameter.set投票者一覧表投票区From(RString.EMPTY);
        batchparameter.set投票者一覧表投票区To(RString.EMPTY);
        batchparameter.set投票者一覧表施設コードFrom(RString.EMPTY);
        batchparameter.set投票者一覧表施設コードTo(RString.EMPTY);
        batchparameter.set投票者一覧表期日前投票(Boolean.FALSE);
        batchparameter.set投票者一覧表投票事由(RString.EMPTY);
        batchparameter.set投票者一覧表期日前投票日From(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表期日前投票日To(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表投票時刻From(RTime.now());
        batchparameter.set投票者一覧表投票時刻To(RTime.now());
        batchparameter.set投票者一覧表期日前代理投票のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表期日前点字投票のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表期日前棄権のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表期日前受付拒否のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表期日前仮投票のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者投票(Boolean.FALSE);
        batchparameter.set投票者一覧表交付日From(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表交付日To(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表受理日From(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表受理日To(FlexibleDate.EMPTY);
        batchparameter.set投票者一覧表受理時刻From(RTime.now());
        batchparameter.set投票者一覧表受理時刻To(RTime.now());
        batchparameter.set投票者一覧表請求のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者未着者のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者代理投票のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者点字投票のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者返還のみ(Boolean.FALSE);
        batchparameter.set投票者一覧表不在者棄権のみ(Boolean.FALSE);
        batchparameter.set投票事由調書(Boolean.FALSE);
        batchparameter.set投票事由調書期日前投票(Boolean.FALSE);
        batchparameter.set投票事由調書期日前投票日From(FlexibleDate.EMPTY);
        batchparameter.set投票事由調書期日前投票日To(FlexibleDate.EMPTY);
        batchparameter.set投票事由調書不在者投票(Boolean.FALSE);
        batchparameter.set投票事由調書受理日From(FlexibleDate.EMPTY);
        batchparameter.set投票事由調書受理日To(FlexibleDate.EMPTY);
        batchparameter.set投票集計整理表(Boolean.TRUE);
        batchparameter.set投票集計整理表投票区From(new RString("01"));
        batchparameter.set投票集計整理表投票区To(new RString("06"));
        batchparameter.set投票集計整理表受理日(new FlexibleDate("20160601"));
//        batchparameter.set抄本番号(new ShohonNo(726));
//        List<SenkyoNo> 選挙番号リスト = Arrays.asList(new SenkyoNo(1), new SenkyoNo(3));
//        batchparameter.set選挙番号リスト(選挙番号リスト);
//        batchparameter.set無投票選挙出力有無(Boolean.FALSE);
//        batchparameter.set投票集計表出力有無(Boolean.FALSE);
//        batchparameter.set代理投票集計表出力有無(Boolean.FALSE);
//        batchparameter.set代理投票集計表期日前投票有無(Boolean.FALSE);
//        batchparameter.set代理投票集計表不在者投票有無(Boolean.FALSE);
//        batchparameter.set年代別投票状況調べ出力有無(Boolean.FALSE);
//        batchparameter.set時間別投票状況表出力有無(Boolean.FALSE);
//        batchparameter.set期日前受理状況一覧表出力有無(Boolean.TRUE);
//        batchparameter.set施設交付一覧表出力有無(Boolean.FALSE);
//        batchparameter.set事務処理簿出力有無(Boolean.FALSE);
//        batchparameter.set事務処理簿不在者投票有無(Boolean.FALSE);
//        batchparameter.set事務処理簿期日前投票有無(Boolean.FALSE);
//        batchparameter.set不在者投票出力有無(Boolean.FALSE);
//        batchparameter.set不在者投票用紙調書出力有無(Boolean.FALSE);
//        batchparameter.set不在者投票管理者調書出力有無(Boolean.FALSE);
//        batchparameter.set登録者数リスト出力有無(Boolean.FALSE);
//        batchparameter.set登録者数リスト作成有無(Boolean.FALSE);
//        batchparameter.set有権者数調べ出力有無(Boolean.FALSE);
//        batchparameter.set選挙人名簿抄本出力有無(Boolean.FALSE);
//        batchparameter.set送致書出力有無(Boolean.FALSE);
//        batchparameter.set期日前受理状況一覧表受理日from(FlexibleDate.EMPTY);
//        batchparameter.set期日前受理状況一覧表受理日to(FlexibleDate.EMPTY);
//        AFABTG101BatchParameter parameter = new AFABTG101BatchParameter();
//        ArrayList<RString> 選挙Noリスト = new ArrayList<>();
//        選挙Noリスト.add(0, new RString("1"));
//        選挙Noリスト.add(1, new RString("2"));
//        選挙Noリスト.add(2, new RString("3"));
//        ArrayList<RString> 選挙名リスト = new ArrayList<>();
//        選挙名リスト.add(0, new RString("選挙"));
//        選挙名リスト.add(1, new RString("選挙"));
//        選挙名リスト.add(2, new RString("選挙"));
//        ArrayList<RString> 選挙略称リスト = new ArrayList<>();
//        選挙略称リスト.add(0, new RString("選挙"));
//        選挙略称リスト.add(1, new RString("選挙"));
//        選挙略称リスト.add(2, new RString("選挙"));
//        parameter.set選挙番号リスト(選挙Noリスト);
//        parameter.set選挙略称リスト(選挙略称リスト);
//        parameter.set選挙名称リスト(選挙名リスト);
//        parameter.set基準日(new FlexibleDate("20150919"));
//        parameter.set年齢到達日(new FlexibleDate("20150919"));
//        parameter.set抄本番号(new RString("2"));
//        parameter.set発行日_国外転入者調査票(new FlexibleDate("20160920"));
//        parameter.set特定期限日(new FlexibleDate("20200519"));
//        parameter.set特定期間開始日(new FlexibleDate("20150519"));
//        parameter.set発行番号の番号_国外転入者調査票(new RString(" "));
//        parameter.set発行番号の号_国外転入者調査票(new RString(" "));
//        parameter.set発行番号の第_国外転入者調査票(new RString(" "));
//        parameter.set未登録者抹消通知一覧出力有無(false);
//        parameter.set国内転入者調査一覧表出力有無(true);
//        parameter.set国外転入者調査一覧表出力有無(false);
//        parameter.set補正登録者名簿出力有無(false);
//        parameter.set国内転入者調査票出力有無(true);
//        parameter.set国外転入者調査票出力有無(true);
//        parameter.set国外転入者調査一覧表出力有無(true);
//        parameter.set未登録者抹消通知一覧出力有無(true);
//        parameter.set未登録者抹消通知出力有無(true);
//        parameter.set訂正者名簿出力有無(true);
//        parameter.set投票人名簿登録者数リスト出力有無(true);
//        parameter.set時点日(FlexibleDate.MAX);
//        parameter.set不在者投票資格者分出力有無(true);
//        parameter.set投票人名簿抄本出力有無(true);
        return batchparameter;
    }
}
