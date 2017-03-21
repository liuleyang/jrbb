/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.teijitouroku.AFABTA101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShoriModel;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010.TeijiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010.TeijiTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010.TeijiTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.teijitouroku.TeijiTourokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMA1010　選挙　定時登録画面<br />
 * TeijiTorokuDivに対するコントローラです。
 *
 */
public class TeijiToroku {

    private final RString シミュレーション = new RString("AFAMNA2010");
    private final TeijiTourokuFinder finder = TeijiTourokuFinder.createInstance();
    private final RString menuID = ResponseHolder.getMenuID();
    private final RString 新規処理 = new RString("新規処理");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<TeijiTorokuDiv> onLoad(TeijiTorokuDiv div) {
        this.getHandler(div).onLoad();
        if (シミュレーション.equals(menuID)) {
            return ResponseData.of(div).rootTitle(new RString("【シミュレーション】定時登録")).respond();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「帳票の条件を設定する」ボタンのイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<TeijiTorokuDiv> onClick_btnSetChohyoYmd(TeijiTorokuDiv div) {
        ValidationMessageControlPairs controlPairs = new TeijiTorokuValidationHandler(div).validate必須項目(false, true);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        this.getHandler(div).onClick_btnSetChohyoYmd();
        return ResponseData.of(div).respond();
    }

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<TeijiTorokuDiv> onClick_radShori(TeijiTorokuDiv div) {
        div.getCcdTeijiMeiboSakuseiKijun().clickRadShori();
        if (!div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(新規処理)
                && div.getCcdTeijiMeiboSakuseiKijun().getCcdShohonNameList().getShohonListSize() == 0 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace("再処理可能な")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getCcdTeijiMeiboSakuseiKijun().set処理種類(new RString("1"));
            div.getCcdTeijiMeiboSakuseiKijun().clickRadShori();
        }
        this.getHandler(div).onClick_btnSetChohyoYmd();
        return ResponseData.of(div).clearValidateMessage().respond();
    }

    /**
     * 抄本ドロップダウンのイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<TeijiTorokuDiv> onChange_ddlShohon(TeijiTorokuDiv div) {
        div.getCcdTeijiMeiboSakuseiKijun().clearData();
        div.getCcdTeijiMeiboSakuseiKijun().getCcdShohonNameList().changeDdlShohon();
        div.getCcdTeijiMeiboSakuseiKijun().setSelected抄本項目By定時登録();
        this.getHandler(div).onClick_btnSetChohyoYmd();
        return ResponseData.of(div).respond();

    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<AFABTA101BatchParameter> onClick_btnExecute(TeijiTorokuDiv div) {
        div.setHdn質問フラグ(RString.EMPTY);
        TeijiTourokuCyohyoSeitei seitei = finder.cyouhyouJyoukenSet(
                getHandler(div).getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue()),
                getHandler(div).getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue()));
        RString shoriModel;
        if (シミュレーション.equals(menuID)) {
            shoriModel = ShoriModel.シミュレーション.code();
        } else {
            shoriModel = ShoriModel.通常処理.code();
        }
        AFABTA101BatchParameter paramter = this.getHandler(div).onClick_btnExecute(seitei, shoriModel);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<TeijiTorokuDiv> onClick_btnBatchCheck(TeijiTorokuDiv div) {
        ValidationMessageControlPairs controlPairs1 = new TeijiTorokuValidationHandler(div).validate必須項目(true, true);
        controlPairs1.add(div.getCcdTeijiSakuseiChohyo().get入力チェック());
        if (controlPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs1).respond();
        }
        if (!ResponseHolder.isWarningIgnoredRequest()) {
            ValidationMessageControlPairs controlPairs = new TeijiTorokuValidationHandler(div).validate必須項目(true, false);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest() && RString.isNullOrEmpty(div.getHdn質問フラグ())) {
            div.setHdn質問フラグ(new RString("1"));
            return ResponseData.of(div).addMessage(AfWarningMessages.選挙バッチ実行確認_排他あり.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.setHdn質問フラグ(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    private TeijiTorokuHandler getHandler(TeijiTorokuDiv div) {
        return new TeijiTorokuHandler(div);
    }

}
