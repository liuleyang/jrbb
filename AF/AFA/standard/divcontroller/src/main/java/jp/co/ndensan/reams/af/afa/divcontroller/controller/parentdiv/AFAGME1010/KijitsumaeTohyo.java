/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1010;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialogModel;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.dgTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.AFAGME1010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1010.KijitsumaeTohyoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;

/**
 * AFAGME1010　投票受付　期日前投票 <br />
 * KijitsumaeTohyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyo {

    private static final RString 画面タイトル_シミュレーション = new RString("【シミュレーション】期日前投票");
    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString 改行 = new RString("<br>");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onLoad(KijitsumaeTohyoDiv mainPanel) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        ViewStateHolder.put(ViewStateKeys.本庁支所区分, false);
        if (!ResponseHolder.isReRequest()) {
            KijitsumaeKojinJoho.initialize(mainPanel.getKijitsumaeKojinJoho());
            if (mainPanel.getKijitsumaeKojinJoho().getCcdShohonNameList().getShohonListSize() == 0) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();

            }
            getHandler(mainPanel).onload();
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGME1010TransitionEventName.メニューに戻る).respond();
        }
        return createResponseWithSetFocusToBarCode(mainPanel);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onChange_txtBarCode(KijitsumaeTohyoDiv div) {
        return onClick_btnBarCode(div);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 20 LINES
    //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 20 LINES
    public ResponseData<KijitsumaeTohyoDiv> onClick_btnBarCode(KijitsumaeTohyoDiv div) {

        return onClickBtnBarCode(div, false);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @param useDialog boolean
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 20 LINES
    //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 20 LINES
    private ResponseData<KijitsumaeTohyoDiv> onClickBtnBarCode(KijitsumaeTohyoDiv div, boolean useDialog) {
        KijitsumaeKojinJohoDiv kojinJoho = div.getKijitsumaeKojinJoho();
        if (!ResponseHolder.isReRequest()) {

            if (!useDialog) {
                if (kojinJoho.getCcdKijitsumaeBarCode().getBarCode().isEmpty()) {
                    return ResponseData.of(div).respond();
                }

                ValidationMessageControlPairs pairs = kojinJoho.getCcdKijitsumaeBarCode().validateバーコード();
                if (pairs.existsError()) {
                    return ResponseData.of(div).addValidationMessages(pairs).respond();
                }
                ShikibetsuCode shikibetsuCode = div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getShikibetsuCodeNyujoken();
                div.getKijitsumaeKojinJoho().setTxtHdnShikibetsuCode(shikibetsuCode.getColumnValue());

            }

            Message message = getHandler(div).checkForOnClickBtnBarCode(useDialog);
            if (message != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else if (ResponseHolder.getMessageCode().equals(new RString(AfQuestionMessages.投票受付判断.getMessage().getCode()))
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).checkForOnClickBtnBarCodeOK();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 選挙人検索ボタン（簡易版）のダイアログオープン前イベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onBeforeOpenDialog_btnSearch(KijitsumaeTohyoDiv div) {
        SearchSimpleJuminModel model = new SearchSimpleJuminModel();
        model.set抄本番号(new ShohonNo(div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo()));
        model.set選挙種類(div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedSenkyoShurui());
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(model));
        return toClear(div, AfQuestionMessages.画面クリア.getMessage(ButtonSelectPattern.OKCancel), true);
    }

    /**
     * 選挙人検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onOkClose_btnSearchSimple(KijitsumaeTohyoDiv div) {
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        ((AtenaShokaiSimpleDiv) div.getKijitsumaeKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()).setHdnTxtShikibetsuCode(model.get識別コードリスト().get(0).value());
        div.getKijitsumaeKojinJoho().setTxtHdnShikibetsuCode(model.get識別コードリスト().get(0).value());
        if (model.get選挙資格リスト() != null) {
            div.getKijitsumaeKojinJoho().getTxtSenkyoShikaku().setValue(model.get選挙資格リスト().get(0));
        }
        ShikibetsuCode 識別コード = model.get識別コードリスト().get(0);
        ShohonNo 抄本番号 = model.get抄本番号();
        if (識別コード == null || 抄本番号 == null) {
            return ResponseData.of(div).respond();
        }
        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
        RString tanmatsuID = ControlDataHolder.getClientId();
        List<jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo> 投票状況情報List = manager.get投票状況情報(抄本番号, 識別コード,
                tanmatsuID);
        KijitsumaeSenkyoShikaku 投票資格情報 = manager.get投票資格情報(抄本番号, 識別コード, tanmatsuID);
        if (投票資格情報 == null) {
            KijitsumaeKojinJoho.set読込個人情報(div.getKijitsumaeKojinJoho());
            return ResponseData.of(div).respond();
        }
        Message message = getHandler(div).checkOnColse(識別コード, 投票状況情報List, 投票資格情報);
        if (message != null && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        RString 投票区コード;
        KijitsumaeKojinJoho.set読込個人情報(div.getKijitsumaeKojinJoho());
        if (model.get投票区コードリスト() != null) {
            投票区コード = model.get投票区コードリスト().get(0).value();
        } else {
            投票区コード = div.getKijitsumaeKojinJoho().getCcdTohyokuCode().get投票区コード();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getTohyoHandler(div).initializeDg(new RString(抄本番号.toString()), 識別コード, 投票区コード, 投票状況情報List, 投票資格情報);
            div.getCcdKijitsumaeSenkyoninTohyoJokyo().setReadOnlyMode(Boolean.FALSE);
            ((TohyoJokyoNyuryokuDiv) div.getCcdKijitsumaeSenkyoninTohyoJokyo()).getChkKariTohyo().setDisabled(Boolean.FALSE);
            getHandler(div).selectedFlag();
            return ResponseData.of(div).respond();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            getTohyoHandler(div).initializeDg(new RString(抄本番号.toString()), 識別コード, 投票区コード, 投票状況情報List, 投票資格情報);
            return ResponseData.of(div).respond();
        }
//        
//        if (kojinJoho.getTxtHdnShikibetsuCode().isEmpty()) {
//            tohyoJokyo.setReadOnlyMode(Boolean.TRUE);
//            tohyoJokyo.clearData();
//
//        } else {
//            KijitsumaeKojinJoho.checkShikibetsuCode(kojinJoho);
//
//            // 取得した識別コードから、バーコード文字列を組み立てて、onBlurを呼ぶ
//            div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().setBarCodeForNyujoken(
//                    kojinJoho.getCcdShohonNameList().getSelectedShohonNo(),
//                    new ShikibetsuCode(kojinJoho.getTxtHdnShikibetsuCode()));
//            return onClickBtnBarCode(div, true);
//        }
        getTohyoHandler(div).initializeDg(new RString(抄本番号.toString()), 識別コード, 投票区コード, 投票状況情報List, 投票資格情報);
        div.getCcdKijitsumaeSenkyoninTohyoJokyo().setReadOnlyMode(Boolean.FALSE);
        ((TohyoJokyoNyuryokuDiv) div.getCcdKijitsumaeSenkyoninTohyoJokyo()).getChkKariTohyo().setDisabled(Boolean.FALSE);
        ((AtenaShokaiSimpleDiv) div.getKijitsumaeKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()).setMode_BtnSetaiDisplay(AtenaShokaiSimpleDiv.BtnSetaiDisplay.表示しない);
        ((AtenaShokaiSimpleDiv) div.getKijitsumaeKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()).getMode_BtnSetaiDisplay();
        getHandler(div).selectedFlag();

        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onChange_ccdShohonNameList(KijitsumaeTohyoDiv div) {

        KijitsumaeTohyoHandler handler = getHandler(div);
        div.getKijitsumaeKojinJoho().getCcdShohonNameList().changeDdlShohon();
        if (!ResponseHolder.isReRequest()) {

            handler.checkForOnChangeCcdShohonNameList();
            if (handler.hasChanged(false)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            handler.clear(true, false);
            return createResponseWithSetFocusToBarCode(div);
        } else if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            handler.clear(true, false);
            return createResponseWithSetFocusToBarCode(div);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 更新確認ダイアログで、はいボタンをクリック時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onYesForSave(KijitsumaeTohyoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 受付ボタンクリック時のイベントメソッドです。（更新処理・クリア処理）
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 100 LINES
    public ResponseData<KijitsumaeTohyoDiv> onClick_btnUpdate(KijitsumaeTohyoDiv div) {
        ValidationMessageControlPairs pairs = getChildValidateHandler(div).validate(new RString("グリッドチェック"));
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        TohyoJokyo selectedJokyo = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getTohyoKubun();
        List<dgTohyoJokyo_Row> selectedItems = div.getCcdKijitsumaeSenkyoninTohyoJokyo().getDgTohyoJokyo().getSelectedItems();

        if (!ResponseHolder.isReRequest()) {

            switch (selectedJokyo) {
                case 棄権:
                case 取消:
                    pairs = new ValidationMessageControlPairs();
                    break;
                case 受付拒否:
                    pairs = getChildValidateHandler(div).validate(new RString("受付拒否"));
                    break;
                default:
                    // 投票
                    pairs = getChildValidateHandler(div).validate(new RString("投票"));
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            QuestionMessage 固定メッセージ = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());

            WarningMessage 複数選択Message = getグリッドの複数選択チェック(selectedItems);
            Message middleMessage = null;
            switch (selectedJokyo) {
                case 棄権:
                    RString replaces = new RString("<br>識別コード：").concat(div.getKijitsumaeKojinJoho().getTxtHdnShikibetsuCode())
                            .concat("<br>氏名：").concat(div.getKijitsumaeKojinJoho().getCcdKojinJoho().getCcdKojinJohoUR()
                                    .getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get名称().getName().value());
                    middleMessage = new QuestionMessage(
                            AfInformationMessages.棄権入力確認.getMessage().getCode(),
                            AfInformationMessages.棄権入力確認.getMessage().replace(replaces.toString()).evaluate());
                    break;
                case 取消:
                    for (dgTohyoJokyo_Row row : selectedItems) {
                        //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
                        if (TohyoJokyo.棄権.toRString().equals(row.getTxtTohyoJokyo())) {
                            middleMessage = new WarningMessage(AfInformationMessages.棄権状態の取消.getMessage().getCode(),
                                    AfInformationMessages.棄権状態の取消.getMessage().evaluate());
                            break;
                        }
                    }
                    break;
                default:
                // 投票
            }
            RStringBuilder msgBuilder = new RStringBuilder(固定メッセージ.evaluate());
            Message msgCodeMsg = 固定メッセージ;

            if (middleMessage != null) {
                msgBuilder.insert(0, 改行);
                msgBuilder.insert(0, middleMessage.evaluate());
            }

            if (複数選択Message != null) {
                msgBuilder.insert(0, 改行);
                msgBuilder.insert(0, 複数選択Message.evaluate());
            }

            Message finalMsg;
            finalMsg = new QuestionMessage(
                    msgCodeMsg.getCode(),
                    msgBuilder.toString(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(finalMsg).respond();
        } else if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div)
                    .updateData(selectedItems);

            if (AFAConfigKeysValue.期日前_ラベルシール印刷確認画面表示有無_表示しない.isEqual(ConfigKeysAFA.期日前_ラベルシール印刷確認画面表示有無)
                    || (AFAConfigKeysValue.宣誓書_期日前_使用有無_使用しない.isEqual(ConfigKeysAFA.宣誓書_期日前_使用有無)
                    && AFAConfigKeysValue.ラベルシール_宣誓書用_期日前_使用有無_使用しない.isEqual(ConfigKeysAFA.ラベルシール_宣誓書用_期日前_使用有無)
                    && AFAConfigKeysValue.ラベルシール_入場券用_期日前_使用有無_使用しない.isEqual(ConfigKeysAFA.ラベルシール_入場券用_期日前_使用有無)
                    && AFAConfigKeysValue.ラベルシール_抄本用_期日前_使用有無_使用しない.isEqual(ConfigKeysAFA.ラベルシール_抄本用_期日前_使用有無))) {
                getHandler(div).clear(true, false);
                Message msg = AfInformationMessages.処理完了.getMessage();
                msg = new NotificationMessage(msg.getCode(), msg.evaluate());
                div.getHiddenPrintButtonDialogFlg().setText(new RString("close"));
                return ResponseData.of(div).focusId(div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getSelectControlIdForBarCode())
                        .addMessage(msg).respond();
            } else {
                div.getHiddenPrintButtonDialogFlg().setText(new RString("open"));
                return onClick_PrintButtonDialog(div);
            }
        }
        div.getHiddenPrintButtonDialogFlg().setText(new RString("close"));
        return ResponseData.of(div).respond();

    }

    private WarningMessage getグリッドの複数選択チェック(List<dgTohyoJokyo_Row> selectedItems) {
        Set<RString> 状態 = new HashSet<>();
        for (dgTohyoJokyo_Row row : selectedItems) {
            状態.add(row.getTxtTohyoJokyo());
        }
        if (!状態.isEmpty() && 状態.size() > 1) {
            return new WarningMessage(AfInformationMessages.別状態同時選択.getMessage().getCode(),
                    AfInformationMessages.別状態同時選択.getMessage().evaluate());
        }
        return null;
    }

    /**
     * 初期表示に戻るボタンクリック時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onClick_btnClear(KijitsumaeTohyoDiv div) {

        return toClear(div, UrQuestionMessages.入力内容の破棄.getMessage(), false);
    }

    /**
     * 初期表示に戻るボタンクリック時のイベントメソッドです。
     *
     */
    private ResponseData<KijitsumaeTohyoDiv> toClear(KijitsumaeTohyoDiv div, Message message, boolean skip期日前期間中) {

        KijitsumaeTohyoHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            if (handler.hasChanged(skip期日前期間中)) {
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).focusId(div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getSelectControlIdForBarCode()).respond();

        } else if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            handler.clear(true, skip期日前期間中);
            return ResponseData.of(div).focusId(div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getSelectControlIdForBarCode()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票出力のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    private ResponseData<KijitsumaeTohyoDiv> onClick_PrintButtonDialog(KijitsumaeTohyoDiv div) {
        RString shohonNo = div.getKijitsumaeKojinJoho().getCcdShohonNameList().getSelectedShohonNo();

        LabelSealSelectDialogModel model = new LabelSealSelectDialogModel();
        model.setKijitsumaeFuzaishaKubun(KijitsumaeFuzaishaKubun.期日前投票);
        model.setShohonNo(new ShohonNo(shohonNo));
        model.setShoriTaishoJohoList(getHandler(div).get帳票データ(true));
        div.setLabelSealSelectDialogModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票Dialog閉じる後のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onOkColse_PrintButtonDialog(KijitsumaeTohyoDiv div) {

        KijitsumaeTohyoHandler handler = getHandler(div);
        handler.clear(true, false);
        return onLoad(div);
    }

    /**
     * 帳票Dialog閉じる後のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     * @return ResponseData<KijitsumaeTohyoDiv>
     */
    public ResponseData<KijitsumaeTohyoDiv> onNgColse_PrintButtonDialog(KijitsumaeTohyoDiv div) {

        if (!RString.isNullOrEmpty(div.getLabelSealSelectDialogModel())) {
            div.setLabelSealSelectDialogModel(RString.EMPTY);
            return onOkColse_PrintButtonDialog(div);
        }

        return ResponseData.of(div).respond();
    }

    private ResponseData<KijitsumaeTohyoDiv> createResponseWithSetFocusToBarCode(KijitsumaeTohyoDiv div) {
        if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNE7010_期日前投票.menuId())) {
            return ResponseData.of(div).focusId(div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getSelectControlIdForBarCode())
                    .rootTitle(画面タイトル_シミュレーション).respond();
        }
        return ResponseData.of(div)
                .focusId(div.getKijitsumaeKojinJoho().getCcdKijitsumaeBarCode().getSelectControlIdForBarCode()).respond();
    }

    private static KijitsumaeTohyoHandler getHandler(KijitsumaeTohyoDiv div) {
        return new KijitsumaeTohyoHandler(div);
    }

    private static TohyoJokyoNyuryokuValidationHandler getChildValidateHandler(KijitsumaeTohyoDiv div) {
        return new TohyoJokyoNyuryokuValidationHandler((TohyoJokyoNyuryokuDiv) div.getCcdKijitsumaeSenkyoninTohyoJokyo());
    }

    private static TohyoJokyoNyuryokuHandler getTohyoHandler(KijitsumaeTohyoDiv div) {
        return new TohyoJokyoNyuryokuHandler((TohyoJokyoNyuryokuDiv) div.getCcdKijitsumaeSenkyoninTohyoJokyo());
    }
}
