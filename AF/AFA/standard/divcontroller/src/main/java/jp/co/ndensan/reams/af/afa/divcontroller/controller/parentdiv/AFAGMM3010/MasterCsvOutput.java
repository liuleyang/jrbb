/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM3010;

import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput.MasterCsvOutputEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010.MasterCsvOutputDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010.MasterCsvOutputHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010.MasterCsvOutputValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.mastercsvoutput.MasterCsvOutputManager;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMM3010　各種マスタデータ出力 <br />
 * MasterCsvOutputDivに対応するコントローラです。
 *
 * @reamsid_L AF-0670-010 lis
 */
public class MasterCsvOutput {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onLoad(MasterCsvOutputDiv div) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameListHojosha().initialize();
        div.getCcdSenkyoShuruiTohyoku().applyOptionCodeMaster().load(AFACodeShubetsu.選挙資格種類.getCodeShubetsu());
        div.getCcdSenkyoShuruiSenkyoku().applyOptionCodeMaster().load(AFACodeShubetsu.選挙資格種類.getCodeShubetsu());
        div.getCcdShisetsuShubetsu().applyOptionCodeMaster().load(AFACodeShubetsu.施設種別.getCodeShubetsu());
        return ResponseData.of(div).respond();
    }

    /**
     * 投票区クリック時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onClick_Tohyoku(MasterCsvOutputDiv div) {
        if (div.getChkTohyoku().isAllSelected()) {
            div.getCcdSenkyoShuruiTohyoku().setDisabled(false);
            div.getCcdSenkyoShuruiTohyoku().setState(CodeInputDiv.State.入力);
        } else {
            div.getCcdSenkyoShuruiTohyoku().setDisabled(true);
            div.getCcdSenkyoShuruiTohyoku().setState(CodeInputDiv.State.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選挙区クリック時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onClick_Senkyoku(MasterCsvOutputDiv div) {
        if (div.getChkSenkyoku().isAllSelected()) {
            div.getCcdSenkyoShuruiSenkyoku().setDisabled(false);
            div.getCcdSenkyoShuruiSenkyoku().setState(CodeInputDiv.State.入力);
        } else {
            div.getCcdSenkyoShuruiSenkyoku().setDisabled(true);
            div.getCcdSenkyoShuruiSenkyoku().setState(CodeInputDiv.State.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設クリック時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onClick_Shisetsu(MasterCsvOutputDiv div) {
        if (div.getChkShisetsu().isAllSelected()) {
            div.getCcdShisetsuShubetsu().setDisabled(false);
            div.getCcdShisetsuShubetsu().setState(CodeInputDiv.State.入力);
        } else {
            div.getCcdShisetsuShubetsu().setDisabled(true);
            div.getCcdShisetsuShubetsu().setState(CodeInputDiv.State.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 補助者クリック時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onClick_Hojosha(MasterCsvOutputDiv div) {
        if (div.getChkHojosha().isAllSelected()) {
            div.getCcdShohonNameListHojosha().setReadOnlyMode(false);
        } else {
            div.getCcdShohonNameListHojosha().setReadOnlyMode(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onChange_ddlShohon(MasterCsvOutputDiv div) {
        div.getCcdShohonNameListHojosha().changeDdlShohon();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時の実行です。
     *
     * @param div MasterCsvOutputDiv
     * @return ResponseData<MasterCsvOutputDiv>
     */
    public ResponseData<MasterCsvOutputDiv> onClick_Execute(MasterCsvOutputDiv div) {
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        MasterCsvOutputHandler handler = getHandler();
        MasterCsvOutputManager manger = MasterCsvOutputManager.createInstance();
        if (div.getChkTohyoku().isAllSelected()) {
            if (MasterCsvOutputEnum.ZERO.getCode().equals(div.getCcdSenkyoShuruiTohyoku().getCode())) {
                handler.ur投票区ファイル書込み(manger.get投票区UR情報(div.getCcdSenkyoShuruiTohyoku().getCode()));
            } else {
                handler.af投票区ファイル書込み(manger.get投票区AF情報(div.getCcdSenkyoShuruiTohyoku().getCode()));
            }
        }

        if (div.getChkTohyojo().isAllSelected()) {
            handler.投票所ファイル書込み(manger.get投票所());
        }

        if (div.getChkSenkyoku().isAllSelected()) {
            if (div.getCcdSenkyoShuruiSenkyoku().isコード入力済み()) {
                handler.選挙区ファイル書込み(manger.get選挙区(div.getCcdSenkyoShuruiSenkyoku().getCode()));
            } else {
                handler.選挙区ファイル書込み(manger.get選挙区());
            }
        }

        if (div.getChkShisetsu().isAllSelected()) {
            if (div.getCcdShisetsuShubetsu().isコード入力済み()) {
                handler.施設ファイル書込み(manger.get施設(div.getCcdShisetsuShubetsu().getHdnTxtCode()));
            } else {
                handler.施設ファイル書込み(manger.get施設());
            }
        }

        if (div.getChkHojosha().isAllSelected()) {
            if (null != div.getCcdShohonNameListHojosha().getSelectedShohonNo()
                    && !div.getCcdShohonNameListHojosha().getSelectedShohonNo().isEmpty()) {
                handler.補助者ファイル書込み(manger.get補助者(new ShohonNo(div.getCcdShohonNameListHojosha().getSelectedShohonNo())));
            } else {
                handler.補助者ファイル書込み(manger.get補助者());
            }
        }

        if (div.getChkKumiai().isAllSelected()) {
            handler.組合ファイル書込み(manger.get組合());
        }

        if (div.getChkRyojikan().isAllSelected()) {
            handler.領事官ファイル書込み(manger.get領事館());
        }

        if (div.getChkCode().isAllSelected()) {
            handler.コードファイル書込み(manger.getコード());
        }

        if (div.getChkConfig().isAllSelected()) {
            handler.コンフィグファイル書込み(manger.getコンフィグ());
        }

        return ResponseData.of(div).respond();
    }

    private MasterCsvOutputHandler getHandler() {
        return new MasterCsvOutputHandler();
    }

    private MasterCsvOutputValidationHandler getValidatorHandler(MasterCsvOutputDiv div) {
        return MasterCsvOutputValidationHandler.of(div);
    }
}
