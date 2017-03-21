/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010.TeijiTorokuValidationMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010.SenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010.SenkyojiTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010.SenkyojiTorokuValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMB1010　選挙　選挙時登録画面 <br />
 * SenkyojiTorokuDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiToroku {

    private static final RString 画面タイトル_シミュレーション = new RString("【シミュレーション】選挙時登録");
    private static final RString KARI_MENU_ID = new RString("AFAMNB4010");

    private final RString 新規処理 = new RString("新規処理");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel SenkyojiTorokuDiv
     * @return ResponseData<SenkyojiTorokuDiv>
     */
    public ResponseData<SenkyojiTorokuDiv> onLoad(SenkyojiTorokuDiv mainPanel) {
        getHandler(mainPanel).onLoad();
        if (ResponseHolder.getMenuID().equals(KARI_MENU_ID)) {
            return ResponseData.of(mainPanel).rootTitle(画面タイトル_シミュレーション).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<SenkyojiTorokuDiv> onClick_radShori(SenkyojiTorokuDiv div) {
        div.getCcdSenkyojiMeiboSakuseiKijun().clickRadShori();
        if (!div.getCcdSenkyojiMeiboSakuseiKijun().getRadShori().getSelectedValue().equals(新規処理)
                && div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().getShohonListSize() == 0 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace("再処理可能な")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getCcdSenkyojiMeiboSakuseiKijun().set処理種類(new RString("1"));
            div.getCcdSenkyojiMeiboSakuseiKijun().clickRadShori();
        }

        this.getHandler(div).onClick_btnSetChohyoYmd();
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンのイベントメソッドです。
     *
     * @param div TeijiTorokuDiv
     * @return ResponseData<TeijiTorokuDiv>
     */
    public ResponseData<SenkyojiTorokuDiv> onChange_ddlShohon(SenkyojiTorokuDiv div) {
        div.getCcdSenkyojiMeiboSakuseiKijun().clearData();
        div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().changeDdlShohon();
        div.getCcdSenkyojiMeiboSakuseiKijun().setSelected抄本項目By選挙時登録();
        this.getHandler(div).onClick_btnSetChohyoYmd();
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票条件設定ボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SenkyojiTorokuDiv
     * @return ResponseData<SenkyojiTorokuDiv>
     */
    public ResponseData<SenkyojiTorokuDiv> onClick_btnSetChohyoYmd(SenkyojiTorokuDiv mainPanel) {
        ValidationMessageControlPairs controlPairs = new SenkyojiTorokuValidationHandler(mainPanel).validate(new RString("帳票の条件を設定する"));

        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlPairs).respond();
        }
        RDate 基準日 = mainPanel.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
        RDate 投票日 = mainPanel.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
        if (null == 基準日) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.基準日必須項目を入力, mainPanel.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD()));
            return ResponseData.of(mainPanel).addValidationMessages(pairs).respond();
        } else if (null == 投票日) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日必須項目を入力, mainPanel.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD()));
            return ResponseData.of(mainPanel).addValidationMessages(pairs).respond();
        } else if (!(投票日.compareTo(基準日) > 0)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日と基準日の関係性チェック, mainPanel.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD()));
            return ResponseData.of(mainPanel).addValidationMessages(pairs).respond();
        }
        getHandler(mainPanel).onClick_btnSetChohyoYmd();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel SenkyojiTorokuDiv
     * @return ResponseData<SenkyojiTorokuDiv>
     */
    public ResponseData<AFABTB101BatchParameter> onClick_btnExecute(SenkyojiTorokuDiv mainPanel) {

        AFABTB101BatchParameter paramter = getHandler(mainPanel).onClick_btnExecute();
        return ResponseData.of(paramter).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param div SenkyojiTorokuDiv
     * @return ResponseData<SenkyojiTorokuDiv>
     */
    public ResponseData<SenkyojiTorokuDiv> onClick_btnBatchCheck(SenkyojiTorokuDiv div) {
        RDate 基準日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD().getValue();
        RDate 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
        if (null == 基準日) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else if (null == 投票日) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日必須項目を入力, div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else if (!(投票日.compareTo(基準日) > 0)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(TeijiTorokuValidationMessage.投票日と基準日の関係性チェック, div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!ResponseHolder.isWarningIgnoredRequest() && !ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate(new RString("実行"));
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            ViewStateHolder.put(ViewStateKeys.年齢期限日と投票日の関係性チェック済み, Boolean.FALSE);
            ViewStateHolder.put(ViewStateKeys.同じ抄本チェック済み, Boolean.FALSE);
            ViewStateHolder.put(ViewStateKeys.定時登録実行有無確認済み, Boolean.FALSE);

            ViewStateHolder.put(ViewStateKeys.選挙バッチ実行確認済み, Boolean.FALSE);
        }
        if (getHandler(div).年齢期限日と投票日の関係性チェック()
                && !ViewStateHolder.get(ViewStateKeys.年齢期限日と投票日の関係性チェック済み, Boolean.class)) {
            ViewStateHolder.put(ViewStateKeys.年齢期限日と投票日の関係性チェック済み, Boolean.TRUE);
            return ResponseData.of(div).addMessage(AfWarningMessages.年齢期限日確認.getMessage().replace("投票日")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (!getHandler(div).同じ抄本チェック() && !ViewStateHolder.get(ViewStateKeys.同じ抄本チェック済み, Boolean.class)) {
            ViewStateHolder.put(ViewStateKeys.同じ抄本チェック済み, Boolean.TRUE);
            return ResponseData.of(div).addMessage(AfWarningMessages.同一投票日抄本確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (getHandler(div).定時登録実行有無確認()
                && !ViewStateHolder.get(ViewStateKeys.定時登録実行有無確認済み, Boolean.class)) {
            ViewStateHolder.put(ViewStateKeys.定時登録実行有無確認済み, Boolean.TRUE);
            return ResponseData.of(div).addMessage(AfWarningMessages.定時登録実行有無確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (!ViewStateHolder.get(ViewStateKeys.選挙バッチ実行確認済み, Boolean.class)) {
            ViewStateHolder.put(ViewStateKeys.選挙バッチ実行確認済み, Boolean.TRUE);
            return ResponseData.of(div).addMessage(AfWarningMessages.選挙バッチ実行確認_排他あり.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private SenkyojiTorokuHandler getHandler(SenkyojiTorokuDiv div) {
        return new SenkyojiTorokuHandler(div);
    }

    private SenkyojiTorokuValidationHandler getValidationHandler(SenkyojiTorokuDiv div) {
        return new SenkyojiTorokuValidationHandler(div);
    }

}
