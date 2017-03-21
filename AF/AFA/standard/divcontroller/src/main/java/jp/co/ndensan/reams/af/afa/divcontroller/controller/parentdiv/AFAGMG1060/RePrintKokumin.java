/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintkokumin.AFABTG106BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MessageHikisuuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.AFAGMG1060TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.RePrintKokuminDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060.RePrintKokuminHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060.RePrintKokuminValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国民投票帳票再発行のクラス
 *
 * @reamsid_L AF-0400-010 guancy
 */
public class RePrintKokumin {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel RePrintKokuminDiv
     * @return ResponseData<RePrintKokuminDiv>
     */
    public ResponseData<RePrintKokuminDiv> onLoad(RePrintKokuminDiv mainPanel) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMG1060TransitionEventName.メニューへ戻る).respond();
        }
        boolean is正常に初期化する = mainPanel.getRePrintKokuminShohonSelect().getDgRePrintKokuminShohonSelect().initialize();
        if (!is正常に初期化する) {
            return ResponseData.of(mainPanel).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(MessageHikisuuEnum.抄本件数エラー_処理可能な.getValue())).respond();
        }
        mainPanel.getRePrintKokuminShohonSelect().getDgRePrintKokuminShohonSelect().getDgKokuminShohon().getDataSource();
        mainPanel.getRePrintKokuminParam().getCcdRePrintKokuminSakuseiChohy().initialize();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param mainPanel RePrintKokuminDiv
     * @return ResponseData<RePrintKokuminDiv>
     */
    public ResponseData<RePrintKokuminDiv> onClick_btnBatchCheck(RePrintKokuminDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(mainPanel).validate();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KokuminNewMeiboSaishinkaDiv
     * @return ResponseData<AFABTG106BatchParameter>
     */
    public ResponseData<AFABTG106BatchParameter> onClick_setBatchParameter(RePrintKokuminDiv mainPanel) {
        ShohonSearchResult 対象抄本情報 = ViewStateHolder.get(ViewStateKeys.対象抄本情報, ShohonSearchResult.class);
        FlexibleDate 抹消日 = new FlexibleDate(mainPanel.getRePrintKokuminShohonSelect().getDgRePrintKokuminShohonSelect().getHdnMasshoYMD());
        RString 抄本番号 = mainPanel.getRePrintKokuminShohonSelect().getDgRePrintKokuminShohonSelect().getDgKokuminShohon().getActiveRow().getTxtShohonNo();
        SenkyoManager manager = SenkyoManager.createInstance();
        Senkyo 抄本 = manager.get選挙(new ShohonNo(抄本番号), new SenkyoNo(SenkyojiZaisankuRStringEnum.選挙番号_1.getKey()));
        return ResponseData.of(
                getHandler(mainPanel).set画面入力内容(
                        対象抄本情報,
                        抹消日,
                        抄本
                )).respond();
    }

    private static RePrintKokuminHandler getHandler(RePrintKokuminDiv mainPanel) {
        return new RePrintKokuminHandler(mainPanel);
    }

    private static RePrintKokuminValidationHandler getValidationHandler(RePrintKokuminDiv mainPanel) {
        return new RePrintKokuminValidationHandler(mainPanel);
    }

}
