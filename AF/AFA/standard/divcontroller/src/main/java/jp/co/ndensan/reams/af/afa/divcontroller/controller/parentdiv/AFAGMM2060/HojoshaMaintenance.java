/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2060;

import jp.co.ndensan.reams.af.afa.business.core.HojoshaMaintenanceInfo;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.AFAGMM2060TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.HojoshaMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060.HojoshaMaintenanceHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenance {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");

    /**
     * 初期化イベントです
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onLoad(HojoshaMaintenanceDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGMM2060TransitionEventName.メニューへ戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            ViewState.setメニューID(ResponseHolder.getMenuID());
            div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            div.getCcdShohonNameList().initialize();
            if (div.getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(抄本件数エラー_処理可能な.toString())).respond();
            }
            RDate 投票年月日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
            RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
            HojoshaMaintenanceHandler.of(div).set補助者選択初期化(抄本番号, 投票年月日);
            div.getHojoshaInput().setVisible(Boolean.FALSE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onChange_ccdShohonNameList(HojoshaMaintenanceDiv div) {
        div.getCcdShohonNameList().changeDdlShohon();
        RDate 投票年月日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        HojoshaMaintenanceHandler.of(div).set補助者選択初期化(抄本番号, 投票年月日);
        return ResponseData.of(div).respond();
    }

    /**
     * 補助者追加するボタンのイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onClick_bntAddHojosha(HojoshaMaintenanceDiv div) {
        div.getHojoshaSelect().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getTxtShikibetsuCode().setDomain(ShikibetsuCode.EMPTY);
        div.getHojoshaInput().getBtnSearchJumin().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getTxtShikibetsuCode().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getTxtName().setDomain(AtenaMeisho.EMPTY);
        div.getHojoshaInput().getTxtName().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getCcdTohyojoCode().initialize(RString.EMPTY);
        div.getHojoshaInput().getCcdTohyojoCode().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getBtnStop().setText(SenkyokuRStringEnum.コードの追加をやめる.getKey());
        div.getHojoshaInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを追加する.getKey());
        div.getHojoshaInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        return ResponseData.of(div).respond();
    }

    /**
     * 補助者修正するボタンのイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onClick_bntModifyHojosha(HojoshaMaintenanceDiv div) {
        div.getHojoshaSelect().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getTxtShikibetsuCode().setDomain(new ShikibetsuCode(div.getDgHojoshaList().getActiveRow().getTxtCode()));
        div.getHojoshaInput().getTxtShikibetsuCode().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getBtnSearchJumin().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getTxtName().setDomain(new AtenaMeisho(div.getDgHojoshaList().getActiveRow().getTxtName()));
        div.getHojoshaInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getTxtName().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getCcdTohyojoCode().initialize(div.getDgHojoshaList().getActiveRow().getTxtTohyojoCode());
        div.getHojoshaInput().getCcdTohyojoCode().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getBtnStop().setText(SenkyokuRStringEnum.コードの修正をやめる.getKey());
        div.getHojoshaInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを保存する.getKey());
        div.getHojoshaInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        return ResponseData.of(div).respond();
    }

    /**
     * 補助者削除するボタンのイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onClick_bntDeleteHojosha(HojoshaMaintenanceDiv div) {
        div.getHojoshaInput().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getTxtShikibetsuCode().setDomain(new ShikibetsuCode(div.getDgHojoshaList().getActiveRow().getTxtCode()));
        div.getHojoshaInput().getTxtShikibetsuCode().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getBtnSearchJumin().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getTxtName().setDomain(new AtenaMeisho(div.getDgHojoshaList().getActiveRow().getTxtName()));
        div.getHojoshaInput().getTxtName().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getTxtName().setVisible(Boolean.TRUE);
        div.getHojoshaInput().getCcdTohyojoCode().initialize(div.getDgHojoshaList().getActiveRow().getTxtTohyojoCode());
        div.getHojoshaInput().getCcdTohyojoCode().setDisabled(Boolean.TRUE);
        div.getHojoshaInput().getBtnStop().setText(SenkyokuRStringEnum.コードの削除をやめる.getKey());
        div.getHojoshaInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを削除する.getKey());
        div.getHojoshaInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getHojoshaInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getHojoshaSelect().setDisabled(Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 住民検索ボタンを選択時のイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onBeforeOpenDialog_btnSearchJumin(HojoshaMaintenanceDiv div) {
        SenkyoShurui 選挙種類 = div.getCcdShohonNameList().getSelectedSenkyoShurui();
        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        SearchSimpleJuminModel model = new SearchSimpleJuminModel();
        model.set選挙種類(選挙種類);
        model.set抄本番号(new ShohonNo(抄本番号));
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 住民検索ダイアログを関じイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onOKClose_btnSearchJumin(HojoshaMaintenanceDiv div) {
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        div.getHojoshaInput().getTxtShikibetsuCode().setDomain(model.get識別コードリスト().get(0));
        return ResponseData.of(div).respond();
    }

    /**
     * 追加/保存/削除するボタンのイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onClick_bntConfirmHojosha(HojoshaMaintenanceDiv div) {
        ResponseData<HojoshaMaintenanceDiv> response = new ResponseData<>();

        if (SenkyokuRStringEnum.コードを追加する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            response = bntAddConfirmHojosha(div);
        }
        if (SenkyokuRStringEnum.コードを保存する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            response = bntUpdateConfirmHojosha(div);
        }
        if (SenkyokuRStringEnum.コードを削除する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            response = bntDeleteConfirmHojosha(div);
        }
        return response;
    }

    /**
     * 追加/修正/削除やめるボタンのイベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    public ResponseData<HojoshaMaintenanceDiv> onClick_bntStopHojosha(HojoshaMaintenanceDiv div) {
        ResponseData<HojoshaMaintenanceDiv> response = new ResponseData<>();
        if (SenkyokuRStringEnum.コードを追加する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            RString 識別コード = div.getHojoshaInput().getTxtShikibetsuCode().getDomain().getColumnValue();
            RString 投票所コード = div.getHojoshaInput().getCcdTohyojoCode().getTxtTohyojoCode().getValue();
            if (識別コード.isEmpty() && 投票所コード.isEmpty()) {
                HojoshaMaintenanceHandler.of(div).set画面初期化();
            } else {
                response = edit入力内容の破棄(div);
            }
        }
        if (SenkyokuRStringEnum.コードを保存する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            HojoshaMaintenanceInfo 投票補助者info = Base64Serializer.deSerialize(div.getDgHojoshaList().getClickedItem().getHidMotoData().toString(), HojoshaMaintenanceInfo.class);
            RString 識別コード = div.getHojoshaInput().getTxtShikibetsuCode().getDomain().getColumnValue();
            RString 投票所コード = div.getHojoshaInput().getCcdTohyojoCode().getTxtTohyojoCode().getValue();
            if (識別コード.equals(投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().getShikibetsuCode().getColumnValue())
                    && 投票所コード.equals(投票補助者info.getHojoshaMaintenanceEntity().get投票所情報().getTohyojoCode())) {
                HojoshaMaintenanceHandler.of(div).set画面初期化();
            } else {
                response = edit入力内容の破棄(div);
            }
        }
        if (SenkyokuRStringEnum.コードを削除する.getKey().equals(div.getHojoshaInput().getBtnAddNew().getText())) {
            HojoshaMaintenanceHandler.of(div).set画面初期化();
        }
        response.data = div;
        return response;
    }

    /**
     * 追加ボタンの確認イベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    private ResponseData<HojoshaMaintenanceDiv> bntAddConfirmHojosha(HojoshaMaintenanceDiv div) {
        RString 抄本番号 = div.getHojoshaSelect().getCcdShohonNameList().getSelectedShohonNo();
        RString 識別コード = div.getHojoshaInput().getTxtShikibetsuCode().getDomain().getColumnValue();
        RString 投票所コード = div.getHojoshaInput().getCcdTohyojoCode().getTxtTohyojoCode().getValue();
        RDate 投票年月日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
        if (HojoshaMaintenanceHandler.of(div).get補助者重複チェック(抄本番号, 識別コード)) {
            return HojoshaMaintenanceHandler.of(div).checkコード重複チェック();
        }
        if (HojoshaMaintenanceHandler.of(div).get宛名PSM存在チェック(識別コード, 投票年月日)) {
            return HojoshaMaintenanceHandler.of(div).checkコード存在チェック();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HojoshaMaintenanceHandler.of(div).insert補助者(抄本番号, 識別コード, 投票所コード);
            HojoshaMaintenanceHandler.of(div).out保存アクセスログ出力(new ShikibetsuCode(識別コード));
            HojoshaMaintenanceHandler.of(div).set画面初期化();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンの確認イベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    private ResponseData<HojoshaMaintenanceDiv> bntUpdateConfirmHojosha(HojoshaMaintenanceDiv div) {
        HojoshaMaintenanceInfo 投票補助者info = Base64Serializer.deSerialize(div.getDgHojoshaList().getClickedItem().getHidMotoData().toString(), HojoshaMaintenanceInfo.class);
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setShohonNo(new ShohonNo(div.getHojoshaSelect().getCcdShohonNameList().getSelectedShohonNo()));
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setShikibetsuCode(div.getHojoshaInput().getTxtShikibetsuCode().getDomain());
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setTohyojoCode(div.getHojoshaInput().getCcdTohyojoCode().getTxtTohyojoCode().getValue());
        ShikibetsuCode 識別コード = div.getHojoshaInput().getTxtShikibetsuCode().getDomain();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HojoshaMaintenanceHandler.of(div).update補助者(投票補助者info);
            HojoshaMaintenanceHandler.of(div).out保存アクセスログ出力(識別コード);
            HojoshaMaintenanceHandler.of(div).set画面初期化();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンの確認イベントメソッドです。
     *
     * @param div HojoshaMaintenanceDiv
     * @return HojoshaMaintenanceDiv
     */
    private ResponseData<HojoshaMaintenanceDiv> bntDeleteConfirmHojosha(HojoshaMaintenanceDiv div) {
        HojoshaMaintenanceInfo 投票補助者info = Base64Serializer.deSerialize(div.getDgHojoshaList().getClickedItem().getHidMotoData().toString(), HojoshaMaintenanceInfo.class);
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setShohonNo(new ShohonNo(div.getHojoshaSelect().getCcdShohonNameList().getSelectedShohonNo()));
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setShikibetsuCode(div.getHojoshaInput().getTxtShikibetsuCode().getDomain());
        ShikibetsuCode 識別コード = div.getHojoshaInput().getTxtShikibetsuCode().getDomain();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HojoshaMaintenanceHandler.of(div).delete補助者(投票補助者info);
            HojoshaMaintenanceHandler.of(div).out保存アクセスログ出力(識別コード);
            HojoshaMaintenanceHandler.of(div).set画面初期化();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<HojoshaMaintenanceDiv> edit入力内容の破棄(HojoshaMaintenanceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HojoshaMaintenanceHandler.of(div).set画面初期化();
        }
        return ResponseData.of(div).respond();
    }

}
