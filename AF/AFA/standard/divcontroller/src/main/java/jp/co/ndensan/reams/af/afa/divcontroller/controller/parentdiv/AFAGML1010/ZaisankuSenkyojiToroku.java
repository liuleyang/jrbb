/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGML1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojizaisanku.AFABTL101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ZaisankuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.dgZaisankuJusho_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.dgZaisankuTohyoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuValidatorHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.zaisankusenkyojitoroku.ZaisankuSenkyojiTorokuManager;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.choiki.ChoikiItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGML1010 財産区議会議員選挙時登録 <br />
 * ZaisankuSenkyojiTorokuDivに対応するコントローラです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiToroku {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onLoad(ZaisankuSenkyojiTorokuDiv div) {

        getHandler(div).get画面情報(new Code(SenkyoShurui.財産区議会議員選挙.getCode()));
        return ResponseData.of(div).respond();
    }

    /**
     * 新規処理と再処理のイベントメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onChange_radShori(ZaisankuSenkyojiTorokuDiv div) {

        RString ラジオ区分 = div.getZaisankuMeiboKoshinKijun().getRadShori().getSelectedKey();
        if (ZaisankuSenkyojiTorokuEnum.新規処理.getValue().equals(ラジオ区分)) {
            get初期化制御(div);
            getHandler(div).get画面情報(new Code(SenkyoShurui.財産区議会議員選挙.getCode()));
        } else {
            if (!ResponseHolder.isReRequest() && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getZaisankuMeiboKoshinKijun().getRadShori().setSelectedKey(ZaisankuSenkyojiTorokuEnum.新規処理.getValue());
                get初期化制御(div);
                getHandler(div).get画面情報(new Code(SenkyoShurui.財産区議会議員選挙.getCode()));
            }

            ViewState.setメニューID(ResponseHolder.getMenuID());
            div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().initialize(SenkyoShurui.財産区議会議員選挙);
            if (div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(ZaisankuSenkyojiTorokuEnum.抄本なしチェック.getValue().toString())).respond();
            } else {
                div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().setDisabled(Boolean.FALSE);
                div.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().setIsOpen(Boolean.TRUE);
                getHandler(div).set再処理画面情報(new ShohonNo(
                        div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().getSelectedShohonNo()));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウン変更のイベントメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onChange_ccdShohonNameList(ZaisankuSenkyojiTorokuDiv div) {

        div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().changeDdlShohon();
        getHandler(div).set再処理画面情報(new ShohonNo(
                div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().getSelectedShohonNo()));
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者住所条件のチェックボックスの変更イベントメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onChange_CheckBoxTohyoku(ZaisankuSenkyojiTorokuDiv div) {

        div.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().getDgZaisankuJusho().getDataSource().clear();
        div.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().setIsOpen(Boolean.TRUE);
        ZaisankuSenkyojiTorokuManager manager = new ZaisankuSenkyojiTorokuManager();
        List<ChoikiItem> 住所情報 = manager.get住所情報();
        List<dgZaisankuJusho_Row> jushoRowList2 = new ArrayList();
        List<dgZaisankuTohyoku_Row> rowList = div.getZaisankuJushoJoken().getDgZaisankuTohyoku().getSelectedItems();
        if (!rowList.isEmpty()) {
            for (dgZaisankuTohyoku_Row row : rowList) {
                List<dgZaisankuJusho_Row> jushoRowList1 = getHandler(div)
                        .get画面住所情報(住所情報, new TohyokuCode(row.getTxtTohyokuCode()));
                jushoRowList2.addAll(jushoRowList1);
            }
        } else {
            jushoRowList2 = getHandler(div).get画面住所情報(manager.get住所情報(), new TohyokuCode(RString.EMPTY));
        }
        div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho().setDataSource(jushoRowList2);

        return ResponseData.of(div).respond();
    }

    /**
     * 詳細指定パネルのクリックイベントメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onOpen_btnShosaiShiteki(ZaisankuSenkyojiTorokuDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param div ZaisankuSenkyojiTorokuDiv
     * @return ResponseData<ZaisankuSenkyojiTorokuDiv>
     */
    public ResponseData<ZaisankuSenkyojiTorokuDiv> onClick_btnBatchCheck(ZaisankuSenkyojiTorokuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = getValidatorHandler(div).validate();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }

            controlPairs = getValidatorHandler(div).validate1();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyojiTorokuDiv
     * @return ResponseData<AFABTL101BatchParameter>
     */
    public ResponseData<AFABTL101BatchParameter> onClick_btnExecute(ZaisankuSenkyojiTorokuDiv mainPanel) {

        return ResponseData.of(getHandler(mainPanel).setバッチパラメータ()).respond();
    }

    private void get初期化制御(ZaisankuSenkyojiTorokuDiv div) {
        getHandler(div).clearKijunPanel();
        getHandler(div).clearDataGridTohyoku();
        getHandler(div).clearDataGridJusho();
        div.getZaisankuJushoJoken().getDgZaisankuTohyoku().getDataSource().clear();
        div.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().getDgZaisankuJusho().getDataSource().clear();
        div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().getDdlShohonItem().setDisabled(Boolean.TRUE);
        div.getZaisankuMeiboKoshinKijun().getCcdShohonNameList().clear();
        div.getZaisankuJushoJoken().getZaisankuJushoJokenShosai().setIsOpen(Boolean.FALSE);
    }

    private ZaisankuSenkyojiTorokuHandler getHandler(ZaisankuSenkyojiTorokuDiv div) {
        return new ZaisankuSenkyojiTorokuHandler(div);
    }

    private ZaisankuSenkyojiTorokuValidatorHandler getValidatorHandler(ZaisankuSenkyojiTorokuDiv div) {
        return new ZaisankuSenkyojiTorokuValidatorHandler(div);
    }
}
