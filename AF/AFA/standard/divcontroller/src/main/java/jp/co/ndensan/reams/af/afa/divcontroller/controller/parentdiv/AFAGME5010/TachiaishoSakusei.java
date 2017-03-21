/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TachiaininHikitsugishoParam;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.business.tachiaishosakusei.TachiaishoSakuseiResult;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.AFAGME5010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.TachiaishoSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010.TachiaishoSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010.TachiaishoSakuseiValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.divcontroller.viewbox.tachiaishosakusei.TachiaishoSakuseiParameter;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE507.TachiaininHikitsugishoService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGME5010 立会人引継書 TachiaishoSakuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public class TachiaishoSakusei {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString メッセージ_無投票選挙 = new RString("無投票選挙です。");
    private static final RString メッセージ_立会人引継情報 = new RString("立会人引継情報");
    private static final RString 処理区分_更新 = new RString("更新");
    private static final RString 処理区分_削除 = new RString("削除");
    private static final RString 処理区分_新規 = new RString("新規");
    private static final RString 処理区分_引継情報検索 = new RString("引継情報検索");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onLoad(TachiaishoSakuseiDiv div) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGME5010TransitionEventName.メニューへ戻る).respond();
        }
        div.getCcdShohonNameList().initialize();
        if (0 >= div.getCcdShohonNameList().getShohonListSize() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                    .replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        TachiaishoSakuseiHandler handler = getHandler(div);
        handler.set期日前投票日();
        handler.set選挙名ドロップダウンリスト();
        handler.set期日前投票所ドロップダウンリスト();
        handler.set画面制御_立会人引継書作成条件_初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onChange_ddlShohon(TachiaishoSakuseiDiv div) {
        TachiaishoSakuseiHandler handler = getHandler(div);
        div.getCcdShohonNameList().changeDdlShohon();
        handler.set選挙名ドロップダウンリスト();
        return ResponseData.of(div).respond();
    }

    /**
     * 引継情報を検索ボタンclick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onClick_btnSearch(TachiaishoSakuseiDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        TachiaishoSakuseiValidationHandler validationHandler = TachiaishoSakuseiValidationHandler.of(div);
        ValidationMessageControlPairs validationMessageControlPairs = validationHandler.validate();
        if (validationMessageControlPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        TachiaishoSakuseiHandler handler = getHandler(div);
        if (handler.is無投票選挙フラグ() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(AfWarningMessages.処理の続行確認.getMessage()
                    .replace(メッセージ_無投票選挙.toString())).respond();
        }
        handler.set画面制御_立会人引継書作成条件_引継情報検索ボタン押下();
        ArrayList<TachiaininHikitsugi> 立会人引継情報リスト = (ArrayList<TachiaininHikitsugi>) handler.set投票立会人情報();
        ViewStateHolder.put(TachiaishoSakuseiParameter.立会人引継情報, 立会人引継情報リスト);
        ViewStateHolder.put(TachiaishoSakuseiParameter.処理区分, 処理区分_引継情報検索);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタンclick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onSelectByModifyButton_dgTachiaishoTachiainin(TachiaishoSakuseiDiv div) {
        TachiaishoSakuseiHandler handler = getHandler(div);
        ArrayList<TachiaininHikitsugi> 投票用紙再交付者情報リスト = (ArrayList<TachiaininHikitsugi>) handler.set引継内容詳細();
        ViewStateHolder.put(TachiaishoSakuseiParameter.投票用紙再交付者情報, 投票用紙再交付者情報リスト);
        handler.set画面制御_投票立会人情報_修正ボタン押下();
        ViewStateHolder.put(TachiaishoSakuseiParameter.処理区分, 処理区分_更新);
        ViewStateHolder.put(TachiaishoSakuseiParameter.投票用紙再交付者, handler.edit投票用紙再交付者());
        ViewStateHolder.put(TachiaishoSakuseiParameter.決定書または裁決書により投票をした者, handler.edit決定書または裁決書により投票をした者());
        ViewStateHolder.put(TachiaishoSakuseiParameter.立会人引継情報インデックス, div.getDgTachiaishoTachiainin().getClickedRowId());
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンclick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onSelectByDeleteButton_dgTachiaishoTachiainin(TachiaishoSakuseiDiv div) {
        TachiaishoSakuseiHandler handler = getHandler(div);
        ArrayList<TachiaininHikitsugi> 投票用紙再交付者情報リスト = (ArrayList<TachiaininHikitsugi>) handler.set引継内容詳細();
        ViewStateHolder.put(TachiaishoSakuseiParameter.投票用紙再交付者情報, 投票用紙再交付者情報リスト);
        handler.set画面制御_投票立会人情報_削除ボタン押下();
        ViewStateHolder.put(TachiaishoSakuseiParameter.処理区分, 処理区分_削除);
        ViewStateHolder.put(TachiaishoSakuseiParameter.立会人引継情報インデックス, div.getDgTachiaishoTachiainin().getClickedRowId());
        return ResponseData.of(div).respond();
    }

    /**
     * 新規追加ボタンclick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onClick_btnAddNew(TachiaishoSakuseiDiv div) {
        TachiaishoSakuseiHandler handler = getHandler(div);
        handler.set引継内容詳細_新規追加();
        handler.set画面制御_投票立会人情報_新規追加ボタン押下();
        ViewStateHolder.put(TachiaishoSakuseiParameter.処理区分, 処理区分_新規);
        return ResponseData.of(div).respond();
    }

    /**
     * 異常ラジオボタンonChange時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onChange_radIjoAriFlag(TachiaishoSakuseiDiv div) {
        getHandler(div).set画面制御_投票立会人情報_異常ラジオボタン選択変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンonClick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onClick_btnUpdate(TachiaishoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(AfQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        TachiaishoSakuseiHandler handler = getHandler(div);
        TachiaishoSakuseiValidationHandler validation = TachiaishoSakuseiValidationHandler.of(div);
        ValidationMessageControlPairs validationMessage = validation.validate_引継内容詳細();
        if (validationMessage.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        save対象情報登録(handler, div);
        handler.set画面制御_立会人引継書作成条件_初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンonClick時のイベントメソッドです。
     *
     * @param div TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onClick_btnSearchResult(TachiaishoSakuseiDiv div) {
        TachiaishoSakuseiHandler sakuseiHandler = getHandler(div);
        boolean 確認要 = false;
        if (処理区分_新規.equals(ViewStateHolder.get(TachiaishoSakuseiParameter.処理区分, RString.class))) {
            確認要 = sakuseiHandler.is引継内容詳細情報が入力された();
        }
        if (処理区分_更新.equals(ViewStateHolder.get(TachiaishoSakuseiParameter.処理区分, RString.class))) {
            ArrayList<TachiaishoSakuseiResult> 再交付者
                    = (ArrayList<TachiaishoSakuseiResult>) ViewStateHolder.get(TachiaishoSakuseiParameter.投票用紙再交付者, ArrayList.class);
            ArrayList<TachiaishoSakuseiResult> 決定書裁決書
                    = (ArrayList<TachiaishoSakuseiResult>) ViewStateHolder.get(TachiaishoSakuseiParameter.決定書または裁決書により投票をした者, ArrayList.class);
            確認要 = sakuseiHandler.is引継内容詳細情報が修正された(再交付者, 決定書裁決書);
        }
        if (確認要 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(AfQuestionMessages.保存確認_投票録
                    .getReplacedMessage(ButtonSelectPattern.YesNo, メッセージ_立会人引継情報.toString())).respond();
        }
        boolean 情報登録 = false;
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            情報登録 = true;
        }
        if (情報登録) {
            TachiaishoSakuseiValidationHandler validate = TachiaishoSakuseiValidationHandler.of(div);
            ValidationMessageControlPairs validationMessageControlPair = validate.validate_引継内容詳細();
            if (validationMessageControlPair.existsError()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPair).respond();
            }
            save対象情報登録(sakuseiHandler, div);
        }
        sakuseiHandler.set画面制御_立会人引継書作成条件_引継情報検索ボタン押下();
        ArrayList<TachiaininHikitsugi> 立会人引継情報リスト = (ArrayList<TachiaininHikitsugi>) sakuseiHandler.set投票立会人情報();
        ViewStateHolder.put(TachiaishoSakuseiParameter.立会人引継情報, 立会人引継情報リスト);
        ViewStateHolder.put(TachiaishoSakuseiParameter.処理区分, 処理区分_引継情報検索);
        return ResponseData.of(div).respond();
    }

    private void save対象情報登録(TachiaishoSakuseiHandler handler, TachiaishoSakuseiDiv div) {
        RString 処理区分 = ViewStateHolder.get(TachiaishoSakuseiParameter.処理区分, RString.class);
        TachiaininHikitsugi 立会人引継情報 = null;
        ArrayList<TachiaininHikitsugi> 投票用紙再交付者情報リスト = null;
        if (!処理区分_新規.equals(処理区分)) {
            ArrayList<TachiaininHikitsugi> 立会人引継情報リスト
                    = (ArrayList<TachiaininHikitsugi>) ViewStateHolder.get(TachiaishoSakuseiParameter.立会人引継情報, ArrayList.class);
            int index = ViewStateHolder.get(TachiaishoSakuseiParameter.立会人引継情報インデックス, Integer.class);
            立会人引継情報 = 立会人引継情報リスト.get(index);
            投票用紙再交付者情報リスト = (ArrayList<TachiaininHikitsugi>) ViewStateHolder.get(TachiaishoSakuseiParameter.投票用紙再交付者情報, ArrayList.class);
        }
        handler.save対象情報登録(処理区分, 立会人引継情報, 投票用紙再交付者情報リスト);
        List<TachiaininHikitsugishoParam> targets = new ArrayList<>();
        TachiaininHikitsugishoParam param = new TachiaininHikitsugishoParam(
                div.getTxtTachiaiTimeRange().getFromValue(),
                div.getTxtTachiaiTimeRange().getToValue(),
                0 == div.getRadIjoAriFlag().getSelectedIndex(),
                1 == div.getRadIjoAriFlag().getSelectedIndex(),
                div.getTxtIjoNaiyo().getValue(),
                div.getDdlShisetsu().getSelectedValue(),
                handler.get投票用紙再交付者情報(),
                handler.get決定書または裁決書により投票をした者情報(),
                handler.get不在者投票の用紙及び封筒を返還して投票した者情報(),
                handler.get点字により投票をした者情報(),
                handler.get代理投票をした者情報(),
                handler.get投票拒否の決定をした者情報()
        );
        targets.add(param);
        TachiaininHikitsugishoService service = new TachiaininHikitsugishoService();
        service.print(targets);
    }

    /**
     * 「再検索する」ボタンonClick時のイベントメソッドです。
     *
     * @param span TachiaishoSakuseiDiv
     * @return ResponseData<TachiaishoSakuseiDiv>
     */
    public ResponseData<TachiaishoSakuseiDiv> onClick_btnReSearch(TachiaishoSakuseiDiv span) {
        TachiaishoSakuseiHandler sakuseiHandler = getHandler(span);
        boolean 操作実施確認要 = false;
        if (処理区分_新規.equals(ViewStateHolder.get(TachiaishoSakuseiParameter.処理区分, RString.class))) {
            操作実施確認要 = sakuseiHandler.is引継内容詳細情報が入力された();
        }
        if (処理区分_更新.equals(ViewStateHolder.get(TachiaishoSakuseiParameter.処理区分, RString.class))) {
            ArrayList<TachiaishoSakuseiResult> 投票用紙再交付者
                    = (ArrayList<TachiaishoSakuseiResult>) ViewStateHolder.get(TachiaishoSakuseiParameter.投票用紙再交付者, ArrayList.class);
            ArrayList<TachiaishoSakuseiResult> 決定書または裁決書により投票をした者
                    = (ArrayList<TachiaishoSakuseiResult>) ViewStateHolder.get(TachiaishoSakuseiParameter.決定書または裁決書により投票をした者, ArrayList.class);
            操作実施確認要 = sakuseiHandler.is引継内容詳細情報が修正された(投票用紙再交付者, 決定書または裁決書により投票をした者);
        }
        if (操作実施確認要 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(span).addMessage(AfQuestionMessages.保存確認_投票録
                    .getReplacedMessage(ButtonSelectPattern.YesNo, メッセージ_立会人引継情報.toString())).respond();
        } else if (!ResponseHolder.isReRequest()) {
            span.getCcdShohonNameList().initialize();
            if (0 >= span.getCcdShohonNameList().getShohonListSize()) {
                return ResponseData.of(span).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(抄本件数エラー_処理可能な.toString())).respond();
            }
            sakuseiHandler.set期日前投票日();
            sakuseiHandler.set選挙名ドロップダウンリスト();
            sakuseiHandler.set期日前投票所ドロップダウンリスト();
        }
        boolean 対象情報登録 = false;
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            対象情報登録 = true;
        }
        if (対象情報登録) {
            TachiaishoSakuseiValidationHandler validationHandler = TachiaishoSakuseiValidationHandler.of(span);
            ValidationMessageControlPairs validationMessageControlPairs = validationHandler.validate_引継内容詳細();
            if (validationMessageControlPairs.existsError()) {
                return ResponseData.of(span).addValidationMessages(validationMessageControlPairs).respond();
            }
            save対象情報登録(sakuseiHandler, span);
        }

        sakuseiHandler.set画面制御_立会人引継書作成条件_初期状態();
        return ResponseData.of(span).respond();
    }

    private TachiaishoSakuseiHandler getHandler(TachiaishoSakuseiDiv div) {
        return TachiaishoSakuseiHandler.of(div);
    }
}
