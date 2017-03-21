/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNA1030;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintteiji.AFABTA103BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
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
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * 定時登録再発行の単体テスト用クラス。
 *
 * @reamsid_L AF-0020-020 gaoya
 */
public class AFABTA103_RePrintTeijiFlowTest extends AfaTestBatchBase {

    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        flowHelper = new BatchFlowTestHelper();
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);
    }

    @Test
    public void AFABTA103_RePrintTeijiFlowはSuccessとなる() throws Exception {
        AFABTA103BatchParameter parameter = setParameter();

        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTA103_RePrintTeijiFlow"), new RString("AFABTA103_RePrintTeijiFlow"),
                AFABTA103_RePrintTeijiFlow.class, parameter);
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

    private AFABTA103BatchParameter setParameter() {
        ArrayList<FlexibleDate> dateLst = new ArrayList<>();
        dateLst.add(new FlexibleDate(2014, 12, 26));
        dateLst.add(new FlexibleDate(2015, 01, 06));
        FlexibleDate a = new FlexibleDate("000001");
        FlexibleDate.EMPTY.wareki().toDateString();
        RString b = a.seireki().separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
        AFABTA103BatchParameter parameter = new AFABTA103BatchParameter();
        parameter.set抄本番号(new RString(new ShohonNo(652).toString()));
        parameter.set抄本名(new RString("平29.10　定時登録"));
        parameter.set基準日(new FlexibleDate(2017, 10, 1));
        parameter.set登録日(new FlexibleDate(2017, 10, 2));
        parameter.set転出期限日(new FlexibleDate(2017, 6, 01));
        parameter.set転入期限日(new FlexibleDate(2017, 7, 01));
        parameter.set年齢期限日(new FlexibleDate(1996, 10, 1));
        parameter.set処理日(new FlexibleDate(2016, 7, 19));

        parameter.set選挙人名簿抄本出力有無(Boolean.TRUE);

        parameter.set永久選挙人名簿出力有無(Boolean.TRUE);
        parameter.set出力条件(new RString("1"));
        parameter.set識別コード(new RString("000000000000010"));
        parameter.set指定日(dateLst);
        parameter.set異動事由(new RString("2"));

        parameter.set選挙人名簿索引簿出力有無(Boolean.TRUE);

        parameter.set登録者数リスト出力有無(Boolean.TRUE);
        parameter.set時点(new FlexibleDate(2016, 01, 01));
        parameter.set不在者投票資格者分作成有無(Boolean.TRUE);
        parameter.set不在資格対象者名簿作成有無(Boolean.TRUE);

        parameter.set有榷者数調べ出力有無(Boolean.TRUE);

        parameter.set二重登録通知出力有無(Boolean.TRUE);
        parameter.set発行日(new FlexibleDate(2016, 01, 01));
        parameter.set発行番号の第(new RString("選　号　外"));
        parameter.set発行番号の番号(new RString("番号"));
        parameter.set発行番号の号(new RString("号"));
        parameter.set送付先宛名シール作成有無(Boolean.TRUE);
        parameter.set二重登録通知一覧表作成有無(Boolean.TRUE);

        parameter.set登録者名簿出力有無(Boolean.TRUE);
        parameter.set縦覧用作成有無_登録者(Boolean.TRUE);
        parameter.set新規登録者宛名シール作成有無(Boolean.TRUE);

        parameter.set帰化対象者名簿出力有無(Boolean.TRUE);
        ArrayList<FlexibleDate> dateLst1 = new ArrayList<>();
        dateLst1.add(new FlexibleDate(2014, 12, 26));
        dateLst1.add(new FlexibleDate(2015, 01, 06));
        parameter.set帰化期間(dateLst1);
        parameter.set転入期間(dateLst);

        parameter.set抹消者名簿出力有無(Boolean.TRUE);
        parameter.set縦覧用作成有無_抹消者(Boolean.TRUE);

        parameter.set居住要件抹消者名簿出力有無(Boolean.TRUE);
        parameter.set表示者名簿出力有無(Boolean.TRUE);
        parameter.set表示消除者名簿出力有無(Boolean.TRUE);

        parameter.set規定年齢前名簿出力有無(Boolean.TRUE);
        parameter.set規定年齢前シール作成有無(Boolean.TRUE);

        parameter.set規定年齢未到達者名簿出力有無(Boolean.TRUE);
        parameter.set再転入者名簿出力有無(Boolean.TRUE);
        parameter.set訂正者名簿出力有無(Boolean.TRUE);
        parameter.set転出者名簿出力有無(Boolean.TRUE);
        parameter.set登録停止者名簿出力有無(Boolean.TRUE);
        parameter.set在外選挙人名簿抄本出力有無(Boolean.TRUE);
        parameter.set在外投票資格者名簿出力有無(Boolean.TRUE);
        return parameter;
    }
}
