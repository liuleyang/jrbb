/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.TohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialogModel;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.AFAGME2010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.dgFuzaishaTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010.FuzaishaTohyoErrorMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010.FuzaishaTohyoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010.FuzaishaTohyoJokyoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010.FuzaishaTohyoValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.NotificationMessage;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGME2010 投票受付　不在者投票 <br />
 * FuzaishaTohyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public class FuzaishaTohyo {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString 使用しない = new RString("0");
    private static final RString 追加メッセージ_0 = new RString("抄本：");
    private static final RString 追加メッセージ_1 = new RString("　に、識別コード：");
    private static final RString 追加メッセージ_2 = new RString("　の住民が存在しません。");

    /**
     * dialogの次数
     */
    private enum DaialogNo {

        /**
         * ダイアログ
         */
        ダイアログ(new RString("ダイアログ"));

        private final RString key;

        DaialogNo(RString key) {
            this.key = key;
        }

        RString getKey() {
            return this.key;
        }
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onLoad(FuzaishaTohyoDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME2010TransitionEventName.メニューへ戻る).respond();
        }
        if (!getHandler(div).initialize()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        
        RString menuID = ResponseHolder.getMenuID();
        RString title = RString.EMPTY;
        
        if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2010_不在者投票用紙請求.menuId())) {
            title = new RString("不在者投票用紙請求");
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId())) {
            title = new RString("不在者投票用紙交付");
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId())) {
            title = new RString("不在者投票用紙受理");
        }
        
        return ResponseData.of(div).rootTitle(title).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onChange_ccdShohonNameList(FuzaishaTohyoDiv div) {
        getHandler(div).changeShohonName();
        return getResponseData(div);
    }

    /**
     * 選挙人を選択するボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_btnFuzaishaSearch(FuzaishaTohyoDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate(FuzaishaTohyoHandler.GamenButton.選挙人を選択する);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        getHandler(div).setSenkyoninData();

        return getResponseData(div);
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onBlur_txtBarCode(FuzaishaTohyoDiv div) {
        FuzaishaTohyoHandler handler = getHandler(div);
        IBarCodeNyuryokuDiv barCode = div.getFuzaishaSenkyoninSearch().getCcdFuzaishaBarCode();
        if (!ResponseHolder.isReRequest()) {
            if (barCode.getBarCode().isNullOrEmpty()) {
                return getResponseData(div);
            }
            RString 抄本番号 = div.getFuzaishaJohoSearch().getCcdShohonNameList().getSelectedShohonNo();
            RString 識別コード = barCode.getShikibetsuCodeJuri().getColumnValue();

            ValidationMessageControlPairs controlPairs = barCode.validateバーコード();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            div.getFuzaishaSenkyoninSearch().setTxtHdnShikibetsuCodeList(識別コード);
            controlPairs = getValidationHandler(div).validate(FuzaishaTohyoHandler.GamenButton.入場券バーコード);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            List<SenkyoninSearchResult> 選挙情報リスト = handler.get選挙情報リスト();
            if (null == 選挙情報リスト || 選挙情報リスト.isEmpty()) {
                controlPairs.add(getValidationHandler(div).validateカスタマイズチェック(new FuzaishaTohyoErrorMessage(get選挙人Msg(抄本番号, 識別コード))));
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            controlPairs = getValidationHandler(div).validate各種チェック(選挙情報リスト, get投票年月日(div));
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            IValidationMessages messages = getValidationHandler(div).validate確認チェック(選挙情報リスト, get投票年月日(div));
            if (null != messages && messages.getSize() > 0) {
                for (IValidationMessage message : messages.getList()) {
                    return ResponseData.of(div).addMessage(message.getMessage()).respond();
                }
            }

        }

        if (!ResponseHolder.isReRequest()
                || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.addSenkyoninData(handler.get選挙人リスト());
            barCode.clearData();
            return ResponseData.of(div).focusId(barCode.getTxtBarCode().getSelectControlID()).respond();
        }

        return getResponseData(div);
    }

    /**
     * 選挙人検索ボタンのダイアログイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onBeforeDialog_btnSearchSenkyonin(FuzaishaTohyoDiv div) {
        SearchSimpleJuminModel model = new SearchSimpleJuminModel();
        model.set抄本番号(new ShohonNo(div.getFuzaishaJohoSearch().getCcdShohonNameList().getSelectedShohonNo()));
        model.set選挙種類(div.getFuzaishaJohoSearch().getCcdShohonNameList().getSelectedSenkyoShurui());
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(model));

        return getResponseData(div);
    }

    /**
     * 選挙人検索ボタンの確定クローズイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onOkClose_btnSearchSenkyonin(FuzaishaTohyoDiv div) {
        FuzaishaTohyoHandler handler = getHandler(div);
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        if (!ResponseHolder.isReRequest()) {
            List<ShikibetsuCode> 識別コードリスト = model.get識別コードリスト();
            if (null == 識別コードリスト || 識別コードリスト.isEmpty()) {
                return getResponseData(div);
            }

            RString 抄本番号 = div.getFuzaishaJohoSearch().getCcdShohonNameList().getSelectedShohonNo();
            RString 識別コード = get識別コードリスト(識別コードリスト);
            div.getFuzaishaSenkyoninSearch().setTxtHdnShikibetsuCodeList(識別コード);

            ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate(FuzaishaTohyoHandler.GamenButton.選挙人を検索する);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            List<SenkyoninSearchResult> 選挙情報リスト = handler.get選挙情報リスト();
            if (null == 選挙情報リスト || 選挙情報リスト.isEmpty()) {
                controlPairs.add(getValidationHandler(div).validateカスタマイズチェック(new FuzaishaTohyoErrorMessage(get選挙人Msg(抄本番号, 識別コード))));
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            controlPairs = getValidationHandler(div).validate各種チェック(選挙情報リスト, get投票年月日(div));
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            IValidationMessages messages = getValidationHandler(div).validate確認チェック(選挙情報リスト, get投票年月日(div));
            if (null != messages && messages.getSize() > 0) {
                for (IValidationMessage message : messages.getList()) {
                    return ResponseData.of(div).addMessage(message.getMessage()).respond();
                }
            }
        }

        if (!ResponseHolder.isReRequest()
                || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.addSenkyoninData(handler.get選挙人リスト());
        }

        return getResponseData(div);
    }

    /**
     * グリッド内の削除ボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_dgFuzaishaSenkyoninSearch_btnDelete(FuzaishaTohyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).deleteSenkyoninData();
        }

        return getResponseData(div);
    }

    /**
     * 「投票情報を入力する」ボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_btnFuzaishaInput(FuzaishaTohyoDiv div) {
        FuzaishaTohyoHandler handler = getHandler(div);

        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate(FuzaishaTohyoHandler.GamenButton.投票情報を入力する);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        List<TohyoJokyoSearchResult> 投票情報リスト = handler.get投票情報リスト();
        if (null == 投票情報リスト || 投票情報リスト.isEmpty()) {
            handler.clearSenkyonin();
            controlPairs = new ValidationMessageControlPairs();
            Message errorMsg = UrErrorMessages.該当データなし.getMessage();
            controlPairs.add(getValidationHandler(div).validateカスタマイズチェック(new FuzaishaTohyoErrorMessage(errorMsg)));
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        putViewStateHolder(投票情報リスト);
        handler.setTohyouData(投票情報リスト);
        return getResponseData(div);
    }

    /**
     * 投票状況ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_radFuzaishaTohyoJokyo(FuzaishaTohyoDiv div) {
        getHandler(div).changeRadTohyoJokyo();
        return getResponseData(div);
    }

    /**
     * 共通ボタンエリア：投票を受け付けるボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_btnExecute(FuzaishaTohyoDiv div) {
        QuestionMessage questionMessage;
        WarningMessage warningMessage;
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate(FuzaishaTohyoHandler.GamenButton.投票を受け付ける);
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            ViewStateHolder.put(DaialogNo.ダイアログ, 1);
            if (is更新状態同じ(div)) {
                questionMessage = new QuestionMessage(
                        UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(questionMessage).respond();
            } else {
                warningMessage = new WarningMessage(
                        AfWarningMessages.不在者投票_上書き保存の確認.getMessage().getCode(),
                        AfWarningMessages.不在者投票_上書き保存の確認.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(warningMessage).respond();
            }
        }

        if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            div.getHiddenPrintButtonDialogFlg().setText(new RString("close"));
            return getResponseData(div);
        }

        int daialogNo = ViewStateHolder.get(DaialogNo.ダイアログ, Integer.class);
        if (daialogNo == 1) {
            List<TohyoJokyo> 投票状況リスト = ViewStateHolder.get(FuzaishaTohyoJokyoHandler.TohyoJokyoSaveKeyEnum.投票状況保存用Key, ArrayList.class);
            getHandler(div).save(投票状況リスト);

            if (is印刷有無(div)) {
                div.getHiddenPrintButtonDialogFlg().setText(new RString("open"));
                return onClick_PrintButtonDialog(div);
            } else {
                div.getHiddenPrintButtonDialogFlg().setText(new RString("close"));
                getHandler(div).clear();
                return ResponseData.of(div).addMessage((Message) new NotificationMessage(
                        UrInformationMessages.保存終了.getMessage().getCode(), UrInformationMessages.保存終了.getMessage().evaluate())).respond();
            }
        }
        div.getHiddenPrintButtonDialogFlg().setText(new RString("close"));
        return getResponseData(div);
    }

    /**
     * 初期表示に戻るボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_btnReturnShohon(FuzaishaTohyoDiv div) {
        if (!ResponseHolder.isReRequest() && (getHandler(div).isSenkyoninChange() || getHandler(div).isTohyoJokyoChange())) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }

        if (!ResponseHolder.isReRequest() || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).clear();
        }
        return getResponseData(div);
    }

    /**
     * 選挙人選択に戻るボタンクリック時のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onClick_btnReturnSenkyonin(FuzaishaTohyoDiv div) {
        if (!ResponseHolder.isReRequest() && getHandler(div).isTohyoJokyoChange()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }

        if (!ResponseHolder.isReRequest() || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).clearSenkyonin();
        }

        return ResponseData.of(div).focusId(div.getFuzaishaSenkyoninSearch().getCcdFuzaishaBarCode().getSelectControlIdForBarCode()).respond();
    }

    /**
     * 帳票Dialog閉じる後のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    public ResponseData<FuzaishaTohyoDiv> onOkColse_PrintButtonDialog(FuzaishaTohyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).forwardWithEventName(AFAGME2010TransitionEventName.投票を受け付ける).respond();
    }

    /**
     * 帳票出力のイベントメソッドです。
     *
     * @param div FuzaishaTohyoDiv
     * @return ResponseData<FuzaishaTohyoDiv>
     */
    private ResponseData<FuzaishaTohyoDiv> onClick_PrintButtonDialog(FuzaishaTohyoDiv div) {
        LabelSealSelectDialogModel model = getHandler(div).get帳票データ();
        div.setLabelSealSelectDialogModel(DataPassingConverter.serialize(model));
        return getResponseData(div);
    }

    private ResponseData<FuzaishaTohyoDiv> getResponseData(FuzaishaTohyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private FuzaishaTohyoHandler getHandler(FuzaishaTohyoDiv div) {
        return new FuzaishaTohyoHandler(div);
    }

    private FuzaishaTohyoValidationHandler getValidationHandler(FuzaishaTohyoDiv div) {
        return new FuzaishaTohyoValidationHandler(div);
    }

    private RString get識別コードリスト(List<ShikibetsuCode> targetList) {
        if (null == targetList || targetList.isEmpty()) {
            return RString.EMPTY;
        }
        RString result = RString.EMPTY;
        for (ShikibetsuCode target : targetList) {
            result = result.concat(target.getColumnValue()).concat(RString.HALF_SPACE);
        }
        return result.substring(0, result.length() - 1);
    }

    private boolean is更新状態同じ(FuzaishaTohyoDiv div) {
        RString 状態;
        List<RString> 状態リスト = new ArrayList<>();
        for (dgFuzaishaTohyoJokyo_Row row : div.getFuzaishaTohyoJokyo().getDgFuzaishaTohyoJokyo().getSelectedItems()) {
            状態 = row.getTxtTohyoJokyo();
            if (!状態リスト.contains(状態)) {
                状態リスト.add(状態);
            }
        }
        return 状態リスト.size() == 1;
    }

    private void putViewStateHolder(List<TohyoJokyoSearchResult> 投票情報リスト) {
        ArrayList<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> holderList = new ArrayList<>();
        for (TohyoJokyoSearchResult 投票状況 : 投票情報リスト) {
            if (投票状況.has投票状況()) {
                holderList.add(new jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo(
                        投票状況.getEntity().get投票状況Entity()));
            } else {
                holderList.add(new jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo(
                        投票状況.get抄本番号(), 投票状況.get識別コード(), new SenkyoNo(投票状況.get選挙番号())));
            }
        }
        ViewStateHolder.put(FuzaishaTohyoJokyoHandler.TohyoJokyoSaveKeyEnum.投票状況保存用Key, holderList);
    }

    private boolean is印刷有無(FuzaishaTohyoDiv div) {
        if (!ResponseHolder.getMenuID().equals(AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId())) {
            return false;
        }

        RString 宣誓書用不在使用有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_不在_使用有無, SubGyomuCode.AFA選挙本体);
        RString 封筒用不在使用有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_不在_使用有無, SubGyomuCode.AFA選挙本体);
        RString 抄本用不在使用有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_不在_使用有無, SubGyomuCode.AFA選挙本体);
        RString 入場券用不在使用有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_不在_使用有無, SubGyomuCode.AFA選挙本体);
        RString 宣誓書使用有無 = BusinessConfig.get(ConfigKeysAFA.宣誓書_不在_使用有無, SubGyomuCode.AFA選挙本体);
        boolean 証明書発行 = div.getFuzaishaTohyoJokyo().getFuzaishaKofuJoho().getChkShomeishoHakko().isAllSelected();

        return !宣誓書用不在使用有無.equals(使用しない)
                || !封筒用不在使用有無.equals(使用しない)
                || !抄本用不在使用有無.equals(使用しない)
                || !入場券用不在使用有無.equals(使用しない)
                || !宣誓書使用有無.equals(使用しない)
                || 証明書発行;
    }

    private FlexibleDate get投票年月日(FuzaishaTohyoDiv div) {
        RDate 投票年月日 = div.getFuzaishaJohoSearch().getCcdShohonNameList().getSelectedTohyoYMD();
        return null == 投票年月日 ? FlexibleDate.getNowDate() : new FlexibleDate(投票年月日.toDateString());
    }

    private Message get選挙人Msg(RString 抄本番号, RString 識別コード) {
        Message errorMsg;
        if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId())) {
            errorMsg = AfErrorMessages.選挙資格なし.getMessage().replace(new RString("洋上投票の").toString());
        } else {
            errorMsg = UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                    .replace(追加メッセージ_0.concat(抄本番号).concat(追加メッセージ_1).concat(識別コード).concat(追加メッセージ_2).toString());
        }
        return errorMsg;
    }
}
