/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.dgKokuminTohyojiNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010.KokuminTohyojiTorokuHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【View】KokuminTohyojiTorokuDiv内の <br />
 * KokuminTohyojiNyuryokuDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTohyojiNyuryoku {

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div KokuminTohyojiNyuryokuDiv
     * @param shohonNo RString
     */
    public static void setData(KokuminTohyojiTorokuDiv div, RString shohonNo) {

        div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource().clear();

        if (shohonNo.isEmpty()) {
            div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku().getDataSource().add(createEmptyRow());
        } else {
            KokuminTohyojiTorokuHandler.of(div).createSenkyoDataSource(shohonNo);
        }
    }

    /**
     * 行追加ボタンクリック時のイベントメソッドです。
     *
     * @param div KokuminTohyojiNyuryokuDiv
     * @return ResponseData<KokuminTohyojiNyuryokuDiv>
     */
    public ResponseData<KokuminTohyojiNyuryokuDiv> onClick_btnAddRowSenkyo(KokuminTohyojiNyuryokuDiv div) {

        div.getDgKokuminTohyojiNyuryoku().getDataSource().add(createEmptyRow());

        return ResponseData.of(div).respond();
    }

    /**
     * グリッド内の削除ボタンクリック時のイベントメソッドです。
     *
     * @param div KokuminTohyojiNyuryokuDiv
     * @return ResponseData<KokuminTohyojiNyuryokuDiv>
     */
    public ResponseData<KokuminTohyojiNyuryokuDiv> onClick_dgKokuminTohyojiNyuryoku_btnDelete(KokuminTohyojiNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        div.getDgKokuminTohyojiNyuryoku().getDataSource().remove(div.getDgKokuminTohyojiNyuryoku().getClickedRowId());

        return ResponseData.of(div).respond();
    }

    private static dgKokuminTohyojiNyuryoku_Row createEmptyRow() {
        dgKokuminTohyojiNyuryoku_Row row = new dgKokuminTohyojiNyuryoku_Row();

        row.setBtnDelete(new Button());
        row.setTxtNo(RString.EMPTY);
        row.setTxtKaiseianName(new TextBox());
        row.setTxtRyakusho(new TextBox());

        return row;
    }

}
