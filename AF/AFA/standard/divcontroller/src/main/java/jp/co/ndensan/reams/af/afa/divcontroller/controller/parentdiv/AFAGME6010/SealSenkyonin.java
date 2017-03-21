/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME6010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.JushoIchiranMeisai;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.dgJushoJokenList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010.AFAGME6010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010.SealSenkyoninDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6010.SealSenkyoninValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME6010 選挙人宛名シール
 *
 * @reamsid_L AF-0620-012 liuj
 */
public class SealSenkyonin {

    private static final RString 位置指定区分の表示有無 = new RString("FALSE");
    private static final RString 位置指定区分 = new RString("2");
    private static final RString 印字開始位置 = new RString("1");
    private static final RString メニュー_ID = new RString("AFAMNE6010");
    private static final RString 選挙人宛名シール = new RString("AFAGME6010");
    private static final RString 画面起動チェック_処理可能な = new RString("処理可能な");

    /**
     * 初期化イベントです。
     *
     * @param div SealSenkyoninDiv
     * @return SealSenkyoninDiv
     */
    public ResponseData<SealSenkyoninDiv> onLoad(SealSenkyoninDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGME6010TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ViewState.setメニューID(メニュー_ID);
            div.getCcdShohonNameList().initialize();
            if (div.getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(画面起動チェック_処理可能な.toString())).respond();
            }
            div.getCcdJushoJokenSelect().initialize(new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()),
                    new Code(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode().toString()));
            div.getCcdSealLayout().initialize();

            div.getCcdSealPosition().initialize();
            RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
            div.getCcdSealPosition().load(位置指定区分の表示有無, 位置指定区分, new ArrayList<RString>(),
                    印字開始位置, 宛名シール_面数);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SealSenkyoninDiv
     * @return ResponseData<SealSenkyoninDiv>
     */
    public ResponseData<SealSenkyoninDiv> onChange_ccdShohonNameList(SealSenkyoninDiv div) {
        div.getCcdShohonNameList().changeDdlShohon();
        RString 抄本番号 = div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey();
        div.getCcdJushoJokenSelect().setShohonNoValue(抄本番号);
        div.getCcdJushoJokenSelect().initialize(new Code(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode()));
        div.getCcdJushoJokenSelect().onChange_radJushoJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * グリッド選択時のイベントメソッドです。
     *
     * @param div SealSenkyoninDiv
     * @return ResponseData<SealSenkyoninDiv>
     */
    public ResponseData<SealSenkyoninDiv> onBeforeOpenDialog_btnBatchExecute(SealSenkyoninDiv div) {
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        controlErrorPairs.add(div.getCcdJushoJokenSelect().gridContextCheck());
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private SealSenkyoninValidationHandler getValidatorHandler(SealSenkyoninDiv div) {
        return SealSenkyoninValidationHandler.of(div);
    }

    /**
     * 実行する時バッチパラメータ設定
     *
     * @param div SealSenkyoninDiv
     * @return AFABTE6010BatchParameter
     */
    public ResponseData<AFABTE6010BatchParameter> setBatchParameter(SealSenkyoninDiv div) {
        AFABTE6010BatchParameter param = new AFABTE6010BatchParameter();
        RString 住所表示1 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho1().getText());
        RString 住所表示2 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho2().getText());
        RString 住所表示3 = changeNullToEmpty(div.getCcdSealLayout().getTxtJusho3().getText());
        RString 開始印字位置番号 = ((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue();
        param.set住所コード(div.getCcdSealLayout().getDdlJusho().getSelectedKey());
        param.set住所コード名称(div.getCcdSealLayout().getDdlJusho().getSelectedValue());
        param.set住所表示(住所表示1.concat(住所表示2).concat(住所表示3));
        param.set起動画面ID(選挙人宛名シール);
        param.set抄本番号(div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey());
        param.set抄本名(div.getCcdShohonNameList().getSelectedShohonName());
        param.set住所条件(div.getCcdJushoJokenSelect().getRadJushoJoken().getSelectedValue());
        List<dgJushoJokenList_Row> list = div.getCcdJushoJokenSelect().getDgJushoJokenList().getSelectedItems();
        List<JushoIchiranMeisai> 住所一覧リスト = new ArrayList<>();
        JushoIchiranMeisai jushoMeisai = new JushoIchiranMeisai();
        if (!list.isEmpty()) {
            for (dgJushoJokenList_Row row : list) {
                jushoMeisai.setコード(row.getTxtJushoJokenCode());
                jushoMeisai.set名称(row.getTxtJushoJokenName());
                住所一覧リスト.add(jushoMeisai);
            }
        }
        param.set住所一覧リスト(住所一覧リスト);
        param.set世帯主敬称コード(div.getCcdSealLayout().getDdlKeisho1().getSelectedKey());
        param.set世帯主敬称(div.getCcdSealLayout().getDdlKeisho1().getSelectedValue());
        param.set四隅項目コード_右上隅(div.getCcdSealLayout().getDdlRightUp().getSelectedKey());
        param.set名称_上段(div.getCcdSealLayout().getTxtAtena1().getText());
        param.set名称_下段(div.getCcdSealLayout().getTxtAtena2().getText());
        param.set宛名コード(div.getCcdSealLayout().getDdlAtena().getSelectedKey());
        param.set宛名コード名称(div.getCcdSealLayout().getDdlAtena().getSelectedValue());
        param.set本人敬称コード(div.getCcdSealLayout().getDdlKeisho2().getSelectedKey());
        param.set本人敬称(div.getCcdSealLayout().getDdlKeisho2().getSelectedValue());
        param.set住所の前に市町村名を付加(div.getRadJusho().getSelectedKey());
        param.set世帯主のみ印刷対象とする有無(!div.getChkSetainushi().getSelectedKeys().isEmpty());
        param.set開始印字位置番号(開始印字位置番号);
        param.set四隅項目コード_左下隅(div.getCcdSealLayout().getDdlLeftDown().getSelectedKey());
        param.set四隅項目_左下隅(div.getCcdSealLayout().getDdlLeftDown().getSelectedValue());
        param.set四隅項目コード_右下隅(div.getCcdSealLayout().getDdlRightDown().getSelectedKey());
        param.set四隅項目_右下隅(div.getCcdSealLayout().getDdlRightDown().getSelectedValue());
        param.set四隅項目_右上隅(div.getCcdSealLayout().getDdlRightUp().getSelectedValue());

        return ResponseData.of(param).respond();

    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

}
