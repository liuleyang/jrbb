package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMH1020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MessageHikisuuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyushaTorokuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.AFAGMH1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.SeikyushaSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.dgSeikyushaSelectSeikyuIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020.SeikyushaSelectHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020.SeikyushaSelectValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 請求代表者選択
 *
 * @reamsid_L AF-0140-020 wangh
 */
public class SeikyushaSelect {

    /**
     * 初期化イベントです。
     *
     * @param div SeikyushaSelectDiv
     * @return SeikyushaSelectDiv
     */
    public ResponseData<SeikyushaSelectDiv> onLoad(SeikyushaSelectDiv div) {

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMH1020TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {

            ViewState.setメニューID(ResponseHolder.getMenuID());
            div.getSeikyushaSelectShohon().getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            div.getSeikyushaSelectShohon().getCcdShohonNameList().initialize(SenkyoShurui.定時登録, Boolean.TRUE);
            RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
            int shohonListSize = div.getCcdShohonNameList().getShohonListSize();
            if (shohonListSize > 0
                    && shohon過去 != null) {
                div.getCcdShohonNameList().selectedShohon(shohon過去);
            } else {
                return ResponseData.of(div).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(MessageHikisuuEnum.抄本件数エラー_処理可能な.getValue())).respond();
            }

            SeikyushaSelectHandler handler = new SeikyushaSelectHandler();
            List<dgSeikyushaSelectSeikyuIchiran_Row> rowList = handler.get一覧データ();
            div.getSeikyushaSelectSeikyuIchiran().getDgSeikyushaSelectSeikyuIchiran().setDataSource(rowList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 直接請求一覧グリッドの選択イベントメソッドです。
     *
     * @param div SeikyushaSelectDiv
     * @return ResponseData<SeikyushaSelectDiv>
     */
    public ResponseData<SeikyushaSelectDiv> onClick_SelectButton(SeikyushaSelectDiv div) {

        dgSeikyushaSelectSeikyuIchiran_Row row = div.getSeikyushaSelectSeikyuIchiran().getDgSeikyushaSelectSeikyuIchiran().getClickedItem();
        RString 署名簿作成 = row.getTxtShomeiboSakusei();
        RString 抄本番号 = row.getTxtHdnShohonNo();
        div.setHdnTeishutsuKigenYMD(row.getTxtTeishutsuKigenYMD().getValue().toDateString());
        div.setHdnSeikyuNo(row.getTxtSeikyuNo());
        div.setHdnSeikyuMei(row.getTxtSeikyuName());
        if (SeikyushaTorokuEnum.署名簿作成.getValue().equals(署名簿作成)) {
            if (null != 抄本番号) {
                div.getCcdShohonNameList().getDdlShohonItem().setSelectedKey(抄本番号);
                div.getCcdShohonNameList().getDdlShohonItem().setDisabled(true);
            }
        } else {
            div.getCcdShohonNameList().getDdlShohonItem().setDisabled(false);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SeikyushaSelectDiv
     * @return ResponseData<SeikyushaSelectDiv>
     */
    public ResponseData<SeikyushaSelectDiv> onChange_ddlShohon(SeikyushaSelectDiv div) {

        div.getCcdShohonNameList().changeDdlShohon();
        return ResponseData.of(div).respond();
    }

    /**
     * 「署名簿を作成する」ボタンイベントメソッドです。
     *
     * @param div SeikyushaSelectDiv
     * @return ResponseData<SeikyushaSelectDiv>
     */
    public ResponseData<SeikyushaSelectDiv> onClick_BTNSakusei(SeikyushaSelectDiv div) {

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = SeikyushaSelectValidationHandler.of(div).validate();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        div.getCcdShohonNameList().changeDdlShohon();
        ViewStateHolder.put(ViewStateKeys.直接請求番号, div.getHdnSeikyuNo());
        ViewStateHolder.put(ViewStateKeys.請求名, div.getHdnSeikyuMei());
        ViewStateHolder.put(ViewStateKeys.抄本番号, div.getCcdShohonNameList().getSelectedShohonNo());
        ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, div.getCcdShohonNameList().getSelectedSenkyoShurui());
        return ResponseData.of(div).forwardWithEventName(AFAGMH1020TransitionEventName.作成).respond();
    }

}
