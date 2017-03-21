/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNA1010;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.definition.batchprm.teijitouroku.AFABTA101BatchParameter;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestBatchBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.powermock.api.mockito.PowerMockito.when;

public class AFABTA101_TeijiTourokuFlowTest extends AfaTestBatchBase {

    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        flowHelper = new BatchFlowTestHelper();
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);
    }

    @Test
    public void AFABTA101_TeijiTourokuFlowはFailとなる() throws Exception {
        AFABTA101BatchParameter parameter = setParameter();

        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTA101_TeijiTourokuFlow"), new RString("AFABTA101_TeijiTourokuFlow"),
                AFABTA101_TeijiTourokuFlow.class, parameter);
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

    private AFABTA101BatchParameter setParameter() {
        ArrayList<FlexibleDate> dateLst = new ArrayList<>();
        dateLst.add(new FlexibleDate(2014, 12, 26));
        dateLst.add(new FlexibleDate(2015, 01, 06));
        FlexibleDate a = new FlexibleDate("000001");
        FlexibleDate.EMPTY.wareki().toDateString();
        RString b = a.seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
        AFABTA101BatchParameter parameter = new AFABTA101BatchParameter();
        parameter.set処理種別(new RString("1"));
        parameter.set抄本名(new RString("平30.01　定時登録test"));
        parameter.set処理モード(new RString("1"));
        parameter.set基準日(new FlexibleDate(2015, 10, 01));
        parameter.set登録日(new FlexibleDate(2018, 01, 02));
        parameter.set転出期限日(new FlexibleDate(2017, 10, 01));
        parameter.set転入期限日(new FlexibleDate(2017, 9, 01));
        parameter.set年齢期限日(new FlexibleDate(2018, 01, 01));
        parameter.set投票日(new FlexibleDate(2015, 10, 01));

        parameter.set選挙人名簿抄本出力有無(Boolean.TRUE);

        parameter.set永久選挙人名簿出力有無(Boolean.FALSE);
        parameter.set出力条件(new RString("0"));
        parameter.set識別コード(new RString("000000000000010"));
        parameter.set指定日(dateLst);
        parameter.set異動事由(new RString("2"));

        parameter.set選挙人名簿索引簿出力有無(Boolean.FALSE);

        parameter.set登録者数リスト出力有無(Boolean.FALSE);
        parameter.set時点(new FlexibleDate(2016, 01, 01));
        parameter.set不在者投票資格者分作成有無(Boolean.FALSE);
        parameter.set不在資格対象者名簿作成有無(Boolean.FALSE);

        parameter.set有榷者数調べ出力有無(Boolean.FALSE);

        parameter.set二重登録通知出力有無(Boolean.FALSE);
        parameter.set発行日(new FlexibleDate(2016, 01, 01));
        parameter.set発行番号の第(new RString("選　号　外"));
        parameter.set発行番号の番号(new RString("番号"));
        parameter.set発行番号の号(new RString("号"));
        parameter.set送付先宛名シール作成有無(Boolean.FALSE);
        parameter.set二重登録通知一覧表作成有無(Boolean.FALSE);

        parameter.set登録者名簿出力有無(Boolean.FALSE);
        parameter.set縦覧用作成有無_登録者(Boolean.FALSE);
        parameter.set新規登録者宛名シール作成有無(Boolean.FALSE);

        parameter.set帰化対象者名簿出力有無(Boolean.FALSE);
        parameter.set帰化期間(dateLst);
        parameter.set転入期間(dateLst);

        parameter.set抹消者名簿出力有無(Boolean.TRUE);
        parameter.set縦覧用作成有無_抹消者(Boolean.TRUE);

        parameter.set居住要件抹消者名簿出力有無(Boolean.FALSE);
        parameter.set表示者名簿出力有無(Boolean.FALSE);
        parameter.set表示消除者名簿出力有無(Boolean.TRUE);

        parameter.set規定年齢前名簿出力有無(Boolean.FALSE);
        parameter.set規定年齢前シール作成有無(Boolean.FALSE);

        parameter.set規定年齢未到達者名簿出力有無(Boolean.FALSE);
        parameter.set再転入者名簿出力有無(Boolean.FALSE);
        parameter.set訂正者名簿出力有無(Boolean.FALSE);
        parameter.set転出者名簿出力有無(Boolean.TRUE);
        parameter.set登録停止者名簿出力有無(Boolean.FALSE);
        parameter.set在外選挙人名簿抄本出力有無(Boolean.FALSE);
        parameter.set在外投票資格者名簿出力有無(Boolean.FALSE);
        return parameter;
    }
}
