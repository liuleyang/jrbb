/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1050;

import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibosaishinkakokumin.AFABTG105BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.KEY_0;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.処理可能な;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050.AFAGMG1050TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.kokuminshohonselect.KokuminShohonSelectManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0390-010 jihb
 */
public class KokuminNewMeiboSaishinka {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KokuminNewMeiboSaishinkaDiv
     * @return ResponseData<KokuminNewMeiboSaishinkaDiv>
     */
    public ResponseData<KokuminNewMeiboSaishinkaDiv> onLoad(KokuminNewMeiboSaishinkaDiv mainPanel) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMG1050TransitionEventName.メニューへ戻る).respond();
        }
        boolean is国民投票抄本選択共有子DIV正常に初期化する = mainPanel.getKokuminNewShohonSelect().getCcdKokuminShohonSelect().initialize();
        if (!is国民投票抄本選択共有子DIV正常に初期化する) {
            return ResponseData.of(mainPanel).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.getKey().toString())).respond();
        }
        mainPanel.getKokuminNewShohonSelect().getCcdKokuminShohonSelect().getDgKokuminShohon().getDataSource();
        mainPanel.getKokuminNewJoken().getTxtSaishinkaYMD().setValue(RDate.getNowDate());
        mainPanel.getKokuminNewJoken().getRadSort().setSelectedKey(KEY_0.getKey());
        mainPanel.getCcdKokuminNewSakuseiChohyo().initialize();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param mainPanel KokuminNewMeiboSaishinkaDiv
     * @return ResponseData<KokuminNewMeiboSaishinkaDiv>
     */
    public ResponseData<KokuminNewMeiboSaishinkaDiv> onClick_btnBatchCheck(KokuminNewMeiboSaishinkaDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(mainPanel).validate抄本();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        ShohonNo 抄本番号 = new ShohonNo(mainPanel.getKokuminNewShohonSelect()
                .getCcdKokuminShohonSelect().getDgKokuminShohon().getClickedItem().getTxtShohonNo());
        KokuminShohonSelectManager manager = KokuminShohonSelectManager.createInstance();
        boolean is投票状況存在 = manager.is投票状況存在(抄本番号);
        ViewStateHolder.put(ViewStateKeys.is投票状況存在, is投票状況存在);
        controlErrorPairs = getValidationHandler(mainPanel).validate投票状況存在();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        controlErrorPairs = mainPanel.getCcdKokuminNewSakuseiChohyo().validate時点日();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KokuminNewMeiboSaishinkaDiv
     * @return ResponseData<KokuminNewMeiboSaishinkaDiv>
     */
    public ResponseData<AFABTG105BatchParameter> onClick_setBatchParameter(KokuminNewMeiboSaishinkaDiv mainPanel) {
        ShohonSearchResult 対象抄本情報 = ViewStateHolder.get(ViewStateKeys.対象抄本情報, ShohonSearchResult.class);
        FlexibleDate 抹消日 = new FlexibleDate(mainPanel.getKokuminNewShohonSelect().getCcdKokuminShohonSelect().getHdnMasshoYMD());
        return ResponseData.of(getHandler(mainPanel).set画面入力内容(対象抄本情報, 抹消日)).respond();
    }

    private static KokuminNewMeiboSaishinkaHandler getHandler(KokuminNewMeiboSaishinkaDiv mainPanel) {
        return new KokuminNewMeiboSaishinkaHandler(mainPanel);
    }

    private static KokuminNewMeiboSaishinkaValidationHandler getValidationHandler(KokuminNewMeiboSaishinkaDiv mainPanel) {
        return new KokuminNewMeiboSaishinkaValidationHandler(mainPanel);
    }

}
