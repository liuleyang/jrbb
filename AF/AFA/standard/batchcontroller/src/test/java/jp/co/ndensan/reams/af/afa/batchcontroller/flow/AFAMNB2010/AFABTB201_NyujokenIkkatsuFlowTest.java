///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNB2010;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.AFABTB201BatchParameter;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
//import jp.co.ndensan.reams.af.afa.testhelper.AfaTestBatchBase;
//import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
//import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
//import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//import jp.co.ndensan.reams.uz.uza.core._ControlData;
//import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
//import jp.co.ndensan.reams.uz.uza.lang.FillType;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.lang.Separator;
//import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
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
///**
// *
// * @author
// */
//public class AFABTB201_NyujokenIkkatsuFlowTest extends AfaTestBatchBase {
//
//    private static BatchFlowTestHelper flowHelper;
//
//    @BeforeClass
//    public static void setUp() {
//        flowHelper = new BatchFlowTestHelper();
//        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);
//    }
//
//    @Test
//    public void AFABTB201_NyujokenIkkatsuFlowはSuccessとなる() throws Exception {
//        AFABTB201BatchParameter parameter = setParameter();
//
//        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTB201_NyujokenIkkatsuFlow"), new RString("AFABTB201_NyujokenIkkatsuFlow"),
//                AFABTB201_NyujokenIkkatsuFlow.class, parameter);
//        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
//    }
//
//    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
//        _ControlData controlData = new _ControlData(SubGyomuCode.AFA選挙本体.toString(), "test", new ReamsDonyuDantaiCode("209007"));
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
//        return flowContext;
//    }
//
//    private AFABTB201BatchParameter setParameter() {
//        FlexibleDate a = new FlexibleDate("000001");
//        FlexibleDate.EMPTY.wareki().toDateString();
//        RString b = a.seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
//        AFABTB201BatchParameter parameter = new AFABTB201BatchParameter();
//        parameter.set抄本番号(new RString("22"));
//        parameter.set選挙種類(new RString("1"));
//        parameter.set抄本名(new RString("長野県議会議員一般選挙"));
//        parameter.set投票日(new FlexibleDate(2016, 10, 12));
//        List<Senkyomeishou> 選挙リスト;
//        選挙リスト = new ArrayList<>();
//        Senkyomeishou 選挙 = new Senkyomeishou();
//        選挙.set選挙番号(new RString("22"));
//        選挙.set選挙名称(new RString("選挙名称"));
//        選挙.set選挙略称(new RString("選挙略称"));
//        選挙リスト.add(選挙);
//        parameter.set選挙リスト(選挙リスト);
//        parameter.set入場券名1(new RString(""));
//        parameter.set入場券名2(new RString(""));
//        parameter.set入場券名3(new RString(""));
//        parameter.set住民分有無(Boolean.TRUE);
//        parameter.set転出者分有無(Boolean.FALSE);
//        List<TohyokuJyohou> 投票区リスト;
//        投票区リスト = new ArrayList<>();
//        TohyokuJyohou 投票区 = new TohyokuJyohou();
//        投票区.set投票区コード(new RString("01"));
//        投票区.set投票区名(new RString("投票区名"));
//        投票区リスト.add(投票区);
//        parameter.set投票区リスト(投票区リスト);
//        parameter.set印刷タイプ(new RString("3"));
//        parameter.set世帯印字人数(new RString("6"));
//        parameter.set抽出対象世帯人数有無(Boolean.TRUE);
//        parameter.set抽出対象世帯人数(new RString("4"));
//        parameter.set転出日From(new FlexibleDate(2016, 5, 26));
//        parameter.set転出日To(new FlexibleDate(2016, 10, 11));
//        parameter.set二重登録抹消者分も含める有無(Boolean.FALSE);
//        parameter.set宛名シールも発行する有無(Boolean.TRUE);
//        parameter.setサンプル文字(new RString(" "));
//
//        return parameter;
//    }
//}
