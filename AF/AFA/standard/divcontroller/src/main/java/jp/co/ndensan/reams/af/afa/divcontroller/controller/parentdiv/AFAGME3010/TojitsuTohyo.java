/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME3010;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuOnlinePcKanri;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.ITohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.dgTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.AFAGME3010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010.TojitsuTohyoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo.TojitsuTohyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.NotificationMessage;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 当日投票コントローラです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyo {

    private static final RString 画面タイトル_シミュレーション = new RString("【シミュレーション】当日投票");
    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString 改行 = new RString("<br>");
    private static final RString 一 = new RString("1");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onLoad(TojitsuTohyoDiv mainPanel) {
        TojitsuTohyoHandler handler = getHandler(mainPanel);
        ViewState.setメニューID(ResponseHolder.getMenuID());
        handler.initialClear();
        if (!ResponseHolder.isReRequest()) {
            TojitsuKojinJoho.initialize(mainPanel.getTojitsuKojinJoho());
            if (mainPanel.getTojitsuKojinJoho().getCcdShohonNameList().getShohonListSize() == 0) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }
            List<TojitsuOnlinePcKanri> 投票区状況 = TojitsuTohyoManager.createInstance().get投票区コード(
                    new Code(mainPanel.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui().getCode()),
                    ControlDataHolder.getClientId());
            if (null == 投票区状況 || 投票区状況.isEmpty()) {
                return ResponseData.of(mainPanel).addMessage(AfInformationMessages.当日投票端末確認.getMessage()).respond();
            } else {
                mainPanel.getTojitsuTohyoJokyo().setTxtHdnTohyokuCode(投票区状況.get(0).get投票区コード());
            }
            ViewState.set抄本番号(mainPanel.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
            getHandler(mainPanel).onload();
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGME3010TransitionEventName.メニューへ戻る).respond();
        }
        return setFocusToBarCode(mainPanel);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onBlur_txtBarCode(TojitsuTohyoDiv div) {
        return onClick_btnBarCode(div);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onClick_btnBarCode(TojitsuTohyoDiv div) {

        return onClickBtnBarCode(div, false);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @param useDialog boolean
     * @return ResponseData<TojitsuTohyoDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 20 LINES
    //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 20 LINES
    private ResponseData<TojitsuTohyoDiv> onClickBtnBarCode(TojitsuTohyoDiv div, boolean useingDialog) {
        TojitsuKojinJohoDiv kojinJoho = div.getTojitsuKojinJoho();
        if (!ResponseHolder.isReRequest()) {

            if (!useingDialog) {
                if (is入場券バーコード空白(div)) {
                    return ResponseData.of(div).respond();
                }
                ValidationMessageControlPairs controlPairs = kojinJoho.getCcdTojitsuBarCode().validateバーコード();
                if (controlPairs.existsError()) {
                    return ResponseData.of(div).addValidationMessages(controlPairs).respond();
                }
                ShikibetsuCode shikibetsuCode = div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getShikibetsuCodeNyujoken();
                div.getTojitsuKojinJoho().setTxtHdnShikibetsuCode(shikibetsuCode.getColumnValue());
            }

            Message mesg = getHandler(div).チェックBarCode(useingDialog);
            if (mesg != null) {
                return ResponseData.of(div).addMessage(mesg).respond();
            }
        } else if (ResponseHolder.getMessageCode().equals(new RString(AfQuestionMessages.投票受付判断.getMessage().getCode()))
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).チェックBarCodeOK();
        }
        if (div.getTojitsuKojinJoho().getTxtHdnSenkyoninFlag().equals(一)) {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(true);

        } else {
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    private boolean is入場券バーコード空白(TojitsuTohyoDiv div) {
        TojitsuKojinJohoDiv kojinJoho = div.getTojitsuKojinJoho();
        return null == kojinJoho.getCcdTojitsuBarCode().getBarCode()
                || kojinJoho.getCcdTojitsuBarCode().getBarCode().isEmpty();
    }

    /**
     * 選挙人検索ボタン（簡易版）のダイアログオープン前イベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onBeforeOpenDialog_btnSearch(TojitsuTohyoDiv div) {

        return toClear(div, AfQuestionMessages.画面クリア.getMessage(ButtonSelectPattern.OKCancel), true);
    }

    /**
     * 選挙人検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onOkClose_btnSearchSimple(TojitsuTohyoDiv div) {
        ITohyoJokyoNyuryokuDiv tohyoJokyo = div.getCcdTojitsuSenkyoninTohyoJokyo();
        TojitsuKojinJohoDiv kojinJoho = div.getTojitsuKojinJoho();

        if (null == kojinJoho.getTxtHdnShikibetsuCode() || kojinJoho.getTxtHdnShikibetsuCode().isEmpty()) {
            tohyoJokyo.setReadOnlyMode(Boolean.TRUE);
            tohyoJokyo.clearData();

        } else {
            TojitsuKojinJoho.checkShikibetsuCode(kojinJoho);
            // 取得した識別コードから、バーコード文字列を組み立てて、onBlurを呼ぶ
            div.getTojitsuKojinJoho().getCcdTojitsuBarCode().setBarCodeForNyujoken(
                    kojinJoho.getCcdShohonNameList().getSelectedShohonNo(),
                    new ShikibetsuCode(kojinJoho.getTxtHdnShikibetsuCode()));
            return onClickBtnBarCode(div, true);

        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onChange_ccdShohonNameList(TojitsuTohyoDiv div) {

        TojitsuTohyoHandler handler = getHandler(div);
        handler.clear(true, false);
        div.getTojitsuKojinJoho().getCcdShohonNameList().changeDdlShohon();
        div.getTojitsuKojinJoho().getCcdShohonNameList().selectedShohon(
                div.getTojitsuKojinJoho().getCcdShohonNameList().getSelectedShohonNo());
        div.getTojitsuTohyoJokyo().setTxtHdnSenkyoShurui(div.getTojitsuKojinJoho()
                .getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        div.getTojitsuTohyoJokyo().setTxtHdnShohonNo(div.getTojitsuKojinJoho()
                .getCcdShohonNameList().getSelectedShohonNo());
        handler.loadTohyoShukei();
        return ResponseData.of(div).respond();

    }

    /**
     * 更新確認ダイアログで、はいボタンをクリック時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onYesForSave(TojitsuTohyoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 受付ボタンクリック時のイベントメソッドです。（更新処理・クリア処理）
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onClick_btnUpdate(TojitsuTohyoDiv div) {
        ValidationMessageControlPairs validationMessage = getChildValidateHandler(div).validate(new RString("グリッドチェック"));
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        TohyoJokyo selectedTohyoJokyo = div.getCcdTojitsuSenkyoninTohyoJokyo().getTohyoKubun();
        List<dgTohyoJokyo_Row> selectedLists = div.getCcdTojitsuSenkyoninTohyoJokyo().getDgTohyoJokyo().getSelectedItems();

        if (!ResponseHolder.isReRequest()) {

            switch (selectedTohyoJokyo) {
                case 棄権:
                case 取消:
                    validationMessage = new ValidationMessageControlPairs();
                    break;
                case 受付拒否:
                    validationMessage = getChildValidateHandler(div).validate(new RString("受付拒否"));
                    break;
                default:
                    validationMessage = getChildValidateHandler(div).validate(new RString("投票"));
            }
            if (validationMessage.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessage).respond();
            }

            QuestionMessage 固定メッセージ = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());

            WarningMessage 複数選択メッセージ = グリッドの複数選択チェック(selectedLists);
            Message middleメッセージ = null;
            switch (selectedTohyoJokyo) {
                case 棄権:
                    RString replacess = new RString("<br>識別コード：").concat(div.getTojitsuKojinJoho().getTxtHdnShikibetsuCode())
                            .concat("<br>氏名：").concat(div.getTojitsuKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()
                                    .getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get名称().getName().value());
                    middleメッセージ = new QuestionMessage(
                            AfInformationMessages.棄権入力確認.getMessage().getCode(),
                            AfInformationMessages.棄権入力確認.getMessage().replace(replacess.toString()).evaluate());
                    break;
                case 取消:
                    for (dgTohyoJokyo_Row row : selectedLists) {
                        if (TohyoJokyo.棄権.toRString().equals(row.getTxtTohyoJokyo())) {
                            middleメッセージ = new WarningMessage(AfInformationMessages.棄権状態の取消.getMessage().getCode(),
                                    AfInformationMessages.棄権状態の取消.getMessage().evaluate());
                            break;
                        }
                    }
                    break;
                default:
            }
            RStringBuilder メッセージbuilder = new RStringBuilder(固定メッセージ.evaluate());
            Message msgCodeMsg = 固定メッセージ;

            if (middleメッセージ != null) {
                メッセージbuilder.insert(0, 改行);
                メッセージbuilder.insert(0, middleメッセージ.evaluate());
            }

            if (複数選択メッセージ != null) {
                メッセージbuilder.insert(0, 改行);
                メッセージbuilder.insert(0, 複数選択メッセージ.evaluate());
            }

            Message finalメッセージ;
            finalメッセージ = new QuestionMessage(
                    msgCodeMsg.getCode(),
                    メッセージbuilder.toString(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(finalメッセージ).respond();
        } else if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).updateData(selectedLists);
            getHandler(div).clear(true, false);
            Message メッセージ = AfInformationMessages.処理完了.getMessage();
            メッセージ = new NotificationMessage(メッセージ.getCode(), メッセージ.evaluate());
            return ResponseData.of(div).focusId(div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getSelectControlIdForBarCode())
                    .addMessage(メッセージ).respond();
        }
        return ResponseData.of(div).respond();

    }

    private WarningMessage グリッドの複数選択チェック(List<dgTohyoJokyo_Row> selectedLists) {
        Set<RString> グリッド状態 = new HashSet<>();
        for (dgTohyoJokyo_Row row : selectedLists) {
            グリッド状態.add(row.getTxtTohyoJokyo());
        }
        if (!グリッド状態.isEmpty() && グリッド状態.size() > 1) {
            return new WarningMessage(AfInformationMessages.別状態同時選択.getMessage().getCode(),
                    AfInformationMessages.別状態同時選択.getMessage().evaluate());
        }
        return null;
    }

    /**
     * 初期表示に戻るボタンクリック時のイベントメソッドです。
     *
     * @param div TojitsuTohyoDiv
     * @return ResponseData<TojitsuTohyoDiv>
     */
    public ResponseData<TojitsuTohyoDiv> onClick_btnClear(TojitsuTohyoDiv div) {

        return toClear(div, UrQuestionMessages.入力内容の破棄.getMessage(), false);
    }

    /**
     * 初期表示に戻るボタンクリック時のイベントメソッドです。
     *
     */
    private ResponseData<TojitsuTohyoDiv> toClear(TojitsuTohyoDiv div, Message message, boolean skip当日投票) {

        TojitsuTohyoHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            if (handler.isChanged(skip当日投票)) {
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).focusId(div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getSelectControlIdForBarCode()).respond();

        } else if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            handler.clear(true, skip当日投票);
            div.getTojitsuKojinJoho().getDdlSenkyoName().setDisabled(false);
            return ResponseData.of(div).focusId(div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getSelectControlIdForBarCode()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<TojitsuTohyoDiv> setFocusToBarCode(TojitsuTohyoDiv div) {
        if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNE7020_当日投票.menuId())) {
            return ResponseData.of(div).focusId(div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getSelectControlIdForBarCode())
                    .rootTitle(画面タイトル_シミュレーション).respond();
        }
        return ResponseData.of(div)
                .focusId(div.getTojitsuKojinJoho().getCcdTojitsuBarCode().getSelectControlIdForBarCode()).respond();
    }

    private static TojitsuTohyoHandler getHandler(TojitsuTohyoDiv div) {
        return new TojitsuTohyoHandler(div);
    }

    private static TohyoJokyoNyuryokuValidationHandler getChildValidateHandler(TojitsuTohyoDiv div) {
        return new TohyoJokyoNyuryokuValidationHandler((TohyoJokyoNyuryokuDiv) div.getCcdTojitsuSenkyoninTohyoJokyo());
    }
}
