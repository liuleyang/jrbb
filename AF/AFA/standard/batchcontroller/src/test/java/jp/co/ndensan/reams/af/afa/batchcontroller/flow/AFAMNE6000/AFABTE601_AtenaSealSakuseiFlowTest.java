/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE6000;

import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestBatchBase;
import jp.co.ndensan.reams.af.afa.testhelper.AfaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * 宛名シール作成のバッチflowテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class AFABTE601_AtenaSealSakuseiFlowTest extends AfaTestBatchBase {

    private static BatchFlowTestHelper flowHelper;
    private static AFABTE6010BatchParameter Parameter;

    /**
     * BeforeClass
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        AfaTestDacBase.setUpClass();
        flowHelper = new BatchFlowTestHelper();
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.AFA選挙本体);

        Parameter = new AFABTE6010BatchParameter();
        Parameter.set起動画面ID(new RString("AFAGME6010"));
        Parameter.set抄本番号(new RString("32"));
        Parameter.set抄本名(new RString("南魚沼市長選挙"));
        Parameter.set住所条件(new RString("投票区"));
        //Parameter.set住所一覧リスト();
        Parameter.set対象選挙(RString.EMPTY);
        Parameter.set選挙レベル(RString.EMPTY);
        Parameter.set対象選挙名称(RString.EMPTY);
        //Parameter.set 対象期間FROM();
        //Parameter.set 対象期間TO();
        Parameter.set施設種別(RString.EMPTY);
        Parameter.set施設種別名称(RString.EMPTY);
        Parameter.set施設コードFROM(RString.EMPTY);
        Parameter.set施設名称FROM(RString.EMPTY);
        Parameter.set施設コードTO(RString.EMPTY);
        Parameter.set施設名称TO(RString.EMPTY);
        Parameter.set四隅項目コード_右上隅(new RString("00"));
        Parameter.set四隅項目_右上隅(new RString("印字しない"));
        Parameter.set住所コード(new RString("1"));
        Parameter.set住所コード名称(new RString("住所 番地 方書"));
        Parameter.set住所表示(new RString("住所 番地 方書"));
        Parameter.set宛名コード(new RString("1"));
        Parameter.set宛名コード名称(new RString("大字○○１２３番地△△アパート"));
        Parameter.set名称_上段(RString.EMPTY);
        Parameter.set名称_下段(new RString("名字　本人氏名"));
        Parameter.set世帯主敬称コード(new RString("0"));
        Parameter.set世帯主敬称(new RString("印字しない"));
        Parameter.set本人敬称コード(new RString("1"));
        Parameter.set本人敬称(new RString("様"));
        Parameter.set四隅項目コード_左下隅(new RString("00"));
        Parameter.set四隅項目_左下隅(new RString("印字しない"));
        Parameter.set四隅項目コード_右下隅(new RString("00"));
        Parameter.set四隅項目_右下隅(new RString("印字しない"));
        Parameter.set住所の前に市町村名を付加(new RString("0"));
        Parameter.set世帯主のみ印刷対象とする有無(false);
        Parameter.set開始印字位置番号(new RString("1"));

    }

    @Test
    public void AFABTE601_AtenaSealSakuseiFlowはSuccessとなる() throws Exception {
        BatchExitStatus result = flowHelper.executeFlow(new RString("AFABTE601_AtenaSealSakuseiFlow"), new RString("施設宛名シール"),
                AFABTE601_AtenaSealSakuseiFlow.class, Parameter);
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
}
