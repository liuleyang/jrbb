/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5060;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuKanri;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResult;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResultList;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060.MaisuKanriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5060.MaisuKanriHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGME5060 投票用紙枚数管理 <br />
 * MaisuKanriDivに対応するコントローラです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class MaisuKanri {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div MaisuKanriDiv
     * @return ResponseData<MaisuKanriDiv>
     */
    public ResponseData<MaisuKanriDiv> onLoad(MaisuKanriDiv div) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().initialize();
        int size = div.getCcdShohonNameList().getShohonListSize();
        if (size == 0) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace("処理可能な")).respond();
        } else {
            MaisuKanriHandler.of(div).画面_選挙グリッド(div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * TODO QA266確認中<br>
     * 選挙選択グリッド内変更イベントメソッドです。
     *
     * @param div MaisuKanriDiv
     * @return ResponseData<MaisuKanriDiv>
     */
    public ResponseData<MaisuKanriDiv> onChange_Senkyo(MaisuKanriDiv div) {

        MaisuKanriHandler handler = MaisuKanriHandler.of(div);
        handler.画面_選挙グリッド(div.getCcdShohonNameList().getSelectedShohonNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 選挙選択グリッド内の選択ボタンのイベントメソッドです。 <br>
     * OR 選挙選択グリッドの行をクリック <br>
     * OR 選挙選択グリッドの行をダブルクリック
     *
     * @param div MaisuKanriDiv
     * @return ResponseData<MaisuKanriDiv>
     */
    public ResponseData<MaisuKanriDiv> onClick_Senkyo(MaisuKanriDiv div) {

        div.getMaisuInput().setDisplayNone(false);
        div.getMaisuInput().getDgMaisuInput().getDataSource().clear();
        MaisuKanriHandler.of(div).画面_投票用紙枚数入力エリア初期化();

        return ResponseData.of(div).respond();
    }

    /**
     * 入力をやめるボタンのイベントメソッドです。
     *
     * @param div MaisuKanriDiv
     * @return ResponseData<MaisuKanriDiv>
     */
    public ResponseData<MaisuKanriDiv> onClick_btnStop(MaisuKanriDiv div) {
        TohyoYoshiMaisuKanri tohyoYoshi = ViewStateHolder.get(ViewStateKeys.投票用紙枚数管理, TohyoYoshiMaisuKanri.class);

        if (!ResponseHolder.isReRequest()) {
            List<TohyoYoshiMaisuSearchResult> tempTohyoYo = MaisuKanriHandler.of(div).投票用紙枚数入力エリアEntity化();
            Boolean flg = MaisuKanriHandler.of(div).対象比較(tempTohyoYo, tohyoYoshi.getEntities());
            if (!flg) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            } else {
                this.onLoad(div);
            }
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            this.onLoad(div);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタンのイベントメソッドです。
     *
     * @param div MaisuKanriDiv
     * @return ResponseData<MaisuKanriDiv>
     */
    public ResponseData<MaisuKanriDiv> onClick_btnUpdate(MaisuKanriDiv div) {
        TohyoYoshiMaisuSearchResultList 投票情報 = Base64Serializer.deSerialize(div.getHidMaisuKanriMoto().toString(), TohyoYoshiMaisuSearchResultList.class);

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            MaisuKanriHandler.of(div).save投票用紙枚数管理(投票情報);
            MaisuKanriHandler.of(div).画面_選挙グリッド(div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey());
        }
        return ResponseData.of(div).respond();
    }

}
