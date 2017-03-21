///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNB1010;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101BatchParameter;
//import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
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
// * @author LDNS 李双双
// */
//public class AFABTB101_SenkyojiTourokuFlowTest extends AfaTestBatchBase {
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
//    public void AFABTA101_TeijiTourokuFlowはSuccessとなる() throws Exception {
//        AFABTB101BatchParameter parameter = setParameter();
//
//        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTB101_SenkyojiTourokuFlow"), new RString("AFABTB101_SenkyojiTourokuFlow"),
//                AFABTB101_SenkyojiTourokuFlow.class, parameter);
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
//    private AFABTB101BatchParameter setParameter() {
//        FlexibleDate[] dateLst = new FlexibleDate[2];
//        dateLst[0] = new FlexibleDate(2014, 12, 26);
//        dateLst[1] = new FlexibleDate(2015, 01, 06);
//        FlexibleDate a = new FlexibleDate("000001");
//        FlexibleDate.EMPTY.wareki().toDateString();
//        RString b = a.seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
//        AFABTB101BatchParameter parameter = new AFABTB101BatchParameter();
//        parameter.set登録モード(new RString("1"));
//        parameter.set抄本名(new RString("抄本名"));
//        parameter.setメニューID(new RString("AFAMNB1010"));
//        List<AFABTB101Senkyoichiran> 選択一覧リスト = new ArrayList<>();
//        AFABTB101Senkyoichiran 選挙一覧 = new AFABTB101Senkyoichiran();
//        選挙一覧.setKijunYMD(new FlexibleDate(2016, 01, 01));
//        選挙一覧.setMeiboTorokuYMD(new FlexibleDate(2016, 01, 01));
//        選挙一覧.setTenshutsuKigenYMD(new FlexibleDate(2015, 9, 01));
//        選挙一覧.setTennyuKigenYMD(new FlexibleDate(2015, 10, 01));
//        選択一覧リスト.add(選挙一覧);
//        parameter.set選択一覧リスト(選択一覧リスト);
//        parameter.set年齢期限日(new FlexibleDate(2016, 01, 02));
//        parameter.set投票日(new FlexibleDate(2015, 9, 1));
//
//        parameter.set選挙人名簿抄本出力有無(Boolean.FALSE);
//
//        parameter.set永久選挙人名簿出力有無(Boolean.FALSE);
//        parameter.set出力条件(new RString("1"));
//        parameter.set識別コード(new RString("000000000000010"));
//        parameter.set指定日(dateLst);
//        parameter.set異動事由(new RString("2"));
//
//        parameter.set選挙人名簿索引簿出力有無(Boolean.FALSE);
//
//        parameter.set登録者数リスト出力有無(Boolean.FALSE);
//        parameter.set時点(new FlexibleDate(2016, 01, 01));
//        parameter.set不在者投票資格者分作成有無(Boolean.FALSE);
//        parameter.set不在資格対象者名簿作成有無(Boolean.FALSE);
//
//        parameter.set有榷者数調べ出力有無(Boolean.FALSE);
//
//        parameter.set二重登録通知出力有無(Boolean.FALSE);
//        parameter.set発行日(new FlexibleDate(2016, 01, 01));
//        parameter.set発行番号の第(new RString("選　号　外"));
//        parameter.set発行番号の番号(new RString("番号"));
//        parameter.set発行番号の号(new RString("号"));
//        parameter.set送付先宛名シール作成有無(Boolean.FALSE);
//        parameter.set二重登録通知一覧表作成有無(Boolean.FALSE);
//
//        parameter.set発行番号の第_調査票(new RString("選　号　外"));
//        parameter.set発行番号の番号_調査票(new RString("番号"));
//        parameter.set発行番号の号_調査票(new RString("号"));
//        parameter.set発行日_調査票(new FlexibleDate(2016, 01, 01));
//        parameter.set二重登録調査票有無(Boolean.FALSE);
//        parameter.set登録者名簿出力有無(Boolean.FALSE);
//        parameter.set縦覧用作成有無_登録者(Boolean.FALSE);
//        parameter.set新規登録者宛名シール作成有無(Boolean.FALSE);
//
//        parameter.set帰化対象者名簿出力有無(Boolean.FALSE);
//        parameter.set帰化期間(dateLst);
//        parameter.set転入期間(dateLst);
//
//        parameter.set転出期間_調査票(dateLst);
//        parameter.set送付先宛名シール作成有無_調査票(Boolean.FALSE);
//        parameter.set二重調査票一覧表作成有無_調査票(Boolean.FALSE);
//
//        parameter.set抹消者名簿出力有無(Boolean.FALSE);
//        parameter.set縦覧用作成有無_抹消者(Boolean.FALSE);
//        parameter.set居住要件抹消者名簿出力有無(Boolean.FALSE);
//
//        parameter.set抹消予定者名簿出力有無(Boolean.FALSE);
//        parameter.set失権者名簿出力有無(Boolean.FALSE);
//        parameter.set表示者名簿出力有無(Boolean.FALSE);
//        parameter.set表示消除者名簿出力有無(Boolean.FALSE);
//        parameter.set表示消除予定者名簿出力有無(Boolean.FALSE);
//        parameter.set規定年齢未到達者名簿出力有無(Boolean.FALSE);
//        parameter.set再転入者名簿出力有無(Boolean.FALSE);
//        parameter.set訂正者名簿出力有無(Boolean.FALSE);
//        parameter.set転出者名簿出力有無(Boolean.FALSE);
//
//        parameter.set登録停止者名簿出力有無(Boolean.FALSE);
//        parameter.set在外選挙人名簿抄本出力有無(Boolean.FALSE);
//        parameter.set在外投票資格者名簿出力有無(Boolean.FALSE);
//        parameter.set在外投票管理票出力有無(Boolean.FALSE);
//        return parameter;
//    }
//}
