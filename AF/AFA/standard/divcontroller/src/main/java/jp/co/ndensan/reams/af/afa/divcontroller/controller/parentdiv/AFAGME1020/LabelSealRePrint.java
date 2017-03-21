/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.AFAGME1020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.LabelSealRePrintDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.dgLabelSealRePrintTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020.LabelSealRePrintHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020.LabelSealRePrintValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.labelsealreprint.LabelSealRePrintManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGME1020 ラベルシール再印刷
 *
 * @reamsid_L AF-0620-014 jihb
 */
public class LabelSealRePrint {

    private static final RString 画面起動チェック_処理可能な = new RString("処理可能な");
    private static final RString 位置指定区分の表示有無 = new RString("FALSE");
    private static final RString 位置指定区分 = new RString("2");
    private static final RString 印字開始位置 = new RString("1");
    private static final RString ZERO = new RString("0");

    /**
     * 初期化イベントです。
     *
     * @param div LabelSealRePrintDiv
     * @return LabelSealRePrintDiv
     */
    public ResponseData<LabelSealRePrintDiv> onLoad(LabelSealRePrintDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGME1020TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ViewState.setメニューID(ResponseHolder.getMenuID());
            div.getLabelSealSakuseiTaisho().getCcdShohonNameList().initialize();
            div.getLabelSealSakuseiTaisho().getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);

            if (div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(画面起動チェック_処理可能な.toString())).respond();
            }

            if (AFAMenuId.AFAMNE1020_ラベルシール再印刷.menuId().equals(ResponseHolder.getMenuID())) {
                div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().initialize(KijitsumaeFuzaishaKubun.期日前投票,
                        new ShohonNo(div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedShohonNo()));
                div.getLabelSealSakuseiTaisho().getCcdShisetsuCode().setDisplayNone(true);
                div.getLabelSealSakuseiTaisho().getBtnShisetsuSearch().setDisplayNone(true);
            } else if (AFAMenuId.AFAMNE2060_ラベルシール再印刷.menuId().equals(ResponseHolder.getMenuID())) {
                div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().initialize(KijitsumaeFuzaishaKubun.不在者投票,
                        new ShohonNo(div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedShohonNo()));
                div.getLabelSealSakuseiTaisho().getCcdShisetsuCode().initialize();
            }

            if (div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().is全てのチェックボックス非表示()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(画面起動チェック_処理可能な.toString())).respond();
            }

            if (ZERO.equals(BusinessConfig.get(ConfigKeysAFA.ラベルシール_ラベルプリンタ使用有無, SubGyomuCode.AFA選挙本体))) {
                div.getLabelSealSakuseiTaisho().getCcdSealPosition().initialize();
                RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
                div.getLabelSealSakuseiTaisho().getCcdSealPosition().load(位置指定区分の表示有無, 位置指定区分, new ArrayList<RString>(),
                        印字開始位置, 宛名シール_面数);
            } else {
                div.getLabelSealSakuseiTaisho().getCcdSealPosition().setDisplayNone(Boolean.TRUE);
            }

            div.getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha().getDataSource().clear();

        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「抄本」のonChangeイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<LabelSealRePrintDiv> onChange_ccdShohonNameList(LabelSealRePrintDiv div) {
        div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho()
                .getCcdShohonNameList().changeDdlShohon();
        ShohonNo 抄本番号 = new ShohonNo(div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho()
                .getCcdShohonNameList().getSelectedShohonNo());
        RString menuId = ResponseHolder.getMenuID();
        if (AFAMenuId.AFAMNE1010_期日前投票.menuId().equals(menuId)) {
            div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().initialize(KijitsumaeFuzaishaKubun.期日前投票, 抄本番号);
        } else {
            div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().initialize(KijitsumaeFuzaishaKubun.不在者投票, 抄本番号);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「一括交付者を検索する」ボタンのonClickイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<LabelSealRePrintDiv> onClick_btnShisetsuSearch(LabelSealRePrintDiv div) {

        ValidationMessageControlPairs controlPairs = LabelSealRePrintValidationHandler.of(div).validate();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        LabelSealRePrintManager manager = LabelSealRePrintManager.createInstance();
        RString 抄本番号 = div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedShohonNo();
        RString 施設コード = div.getLabelSealSakuseiTaisho().getCcdShisetsuCode().get施設コード();

        List<dgLabelSealRePrintTaishosha_Row> rowlist = new ArrayList();
        getHandler(div).get一覧データ(
                manager.get一括交付者データ(new ShohonNo(抄本番号), 施設コード), rowlist);
        div.getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha().setDataSource(rowlist);

        return ResponseData.of(div).respond();
    }

    /**
     * 選挙人を検索するボタン押下時BeforeOpenDialogのイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<LabelSealRePrintDiv> onBeforeOpenDialog_btnSearchSimple(LabelSealRePrintDiv div) {

        SearchSimpleJuminModel searchSimpleJuminModel = new SearchSimpleJuminModel();
        searchSimpleJuminModel.set抄本番号(new ShohonNo(div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedShohonNo()));
        searchSimpleJuminModel.set選挙種類(div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedSenkyoShurui());
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(searchSimpleJuminModel));

        return ResponseData.of(div).respond();
    }

    /**
     * 選挙人を検索するボタン押下時OkCloseのイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<LabelSealRePrintDiv> onOkClose_btnSearchSimple(LabelSealRePrintDiv div) {

        LabelSealRePrintManager manager = LabelSealRePrintManager.createInstance();
        RString 抄本番号 = div.getLabelSealSakuseiTaisho().getCcdShohonNameList().getSelectedShohonNo();
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(
                div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);

        List<ShikibetsuCode> 識別コードリスト = model.get識別コードリスト();

        List<dgLabelSealRePrintTaishosha_Row> rowlist = div.getLabelSealSakuseiTaisho()
                .getDgLabelSealRePrintTaishosha().getDataSource();
        getHandler(div).get一覧データ(
                manager.get選挙人データ(new ShohonNo(抄本番号), 識別コードリスト), rowlist);
        div.getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha().setDataSource(rowlist);

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのonClickイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<LabelSealRePrintDiv> onClick_btnBatchExecute(LabelSealRePrintDiv div) {

        List<dgLabelSealRePrintTaishosha_Row> dgLabelList = div.getLabelSealSakuseiTaisho().getDgLabelSealRePrintTaishosha().getSelectedItems();
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        for (dgLabelSealRePrintTaishosha_Row dgLabel : dgLabelList) {
            識別コードリスト.add(new ShikibetsuCode(dgLabel.getTxtShikibetsuCode()));
        }

        LabelSealRePrintManager manager = LabelSealRePrintManager.createInstance();

        ShohonNo 抄本番号 = new ShohonNo(div.getLabelSealRePrintParam().getLabelSealSakuseiTaisho()
                .getCcdShohonNameList().getSelectedShohonNo());
        RString menuId = ResponseHolder.getMenuID();

        if (AFAMenuId.AFAMNE1010_期日前投票.menuId().equals(menuId)) {
            getHandler(div).print(manager.get帳票データ(抄本番号, 識別コードリスト), KijitsumaeFuzaishaKubun.期日前投票.value());
        } else {
            getHandler(div).print(manager.get帳票データ(抄本番号, 識別コードリスト), KijitsumaeFuzaishaKubun.不在者投票.value());
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのonClickイベントメソッドです。
     *
     * @param div LabelSealRePrintDiv
     * @return ResponseData<LabelSealRePrintDiv>
     */
    public ResponseData<LabelSealRePrintDiv> validate_btnBatchExecute(LabelSealRePrintDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = LabelSealRePrintValidationHandler.of(div).validate2();
            controlPairs.add(div.getLabelSealSakuseiTaisho().getCcdLabelSealPrintTaisho().validate());
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    private LabelSealRePrintHandler getHandler(LabelSealRePrintDiv div) {
        return new LabelSealRePrintHandler(div);
    }

}
