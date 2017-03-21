//package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE5040;
//
//import java.util.Arrays;
//import java.util.List;
//import jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAGME5040.AFABTE504_ZenjitsuPrintFlow;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.zenjitsuprint.AFABTE504BatchParameter;
//import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
//import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
//import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
//import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
//import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
//import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//import jp.co.ndensan.reams.uz.uza.core._ControlData;
//import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
//import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
//import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
//import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
//import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.when;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *投票日前日関連帳票のバッチ単体テスト用クラス。
// * @reamsid_L AF-0280-020 lit
// */
//public class AFABTE504_ZenjitsuPrintFlowTest extends AfaTestDacBase {
//
//    private static DbTestHelper dbHelper;
//    private static BatchFlowTestHelper flowHelper;
//
//    @BeforeClass
//    public static void setUpClass() {
//        dbHelper = new DbTestHelper();
//        flowHelper = new BatchFlowTestHelper();
//        AfaTestDacBase.setUpClassInternal();
//    }
//
//    @Test
//    public void バッチ実施結果は_StatusSuccess() {
//        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);
//        AFABTE504BatchParameter batchparameter = new AFABTE504BatchParameter();
//        batchparameter.set抄本番号(new ShohonNo(620));
//        List<SenkyoNo> 選挙番号リスト = Arrays.asList(new SenkyoNo(620), new SenkyoNo(621));
//        batchparameter.set選挙番号リスト(選挙番号リスト);
//        batchparameter.set無投票選挙出力有無(Boolean.TRUE);
//        batchparameter.set投票集計表出力有無(Boolean.TRUE);
//        batchparameter.set投票集計表投票区from(new RString("0001"));
//        batchparameter.set投票集計表投票区to(new RString("0003"));
//        batchparameter.set投票集計表受理日from(new FlexibleDate(new RString("20140505")));
//        batchparameter.set投票集計表受理日to(new FlexibleDate(new RString("20160606")));
//
//        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTE504_ZenjitsuPrintFlow"),
//                new RString("tggdh65"),
//                AFABTE504_ZenjitsuPrintFlow.class,
//                batchparameter);
//        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
//
//    }
//
//    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
//        _ControlData controlData = new _ControlData(SubGyomuCode.AFA選挙本体.toString(), "test", new ReamsDonyuDantaiCode("209009"));
//        FlowContext flowContext = createFlowContext("testFlowInstanceId", "testFlowId");
//        when(flowContext.getExecutionSubGyomuCode()).thenReturn(executionSubGyomuCode);
//        controlData.setFlowContext(flowContext);
//        _ControlDataHolder.setControlData(controlData);
//    }
//
//    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
//        FlowContext flowContext = Mockito.mock(FlowContext.class);
//        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
//        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
//
//        return flowContext;
//    }
//}
