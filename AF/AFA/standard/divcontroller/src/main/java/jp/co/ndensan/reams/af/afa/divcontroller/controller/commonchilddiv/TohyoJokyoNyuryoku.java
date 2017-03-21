/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】TohyoJokyoNyuryokuDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class TohyoJokyoNyuryoku {

    /**
     * 投票状況ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div TohyoJokyoNyuryokuDiv
     * @return ResponseData<TohyoJokyoNyuryokuDiv>
     */
    public ResponseData<TohyoJokyoNyuryokuDiv> onClick_radTohyoJokyo(TohyoJokyoNyuryokuDiv div) {
        TohyoJokyoNyuryokuHandler handler = createHandlerOf(div);
        handler.changeRadTohyoJokyo(new ShikibetsuCode(div.getTxtHdnShikibetsuCode()));

        return ResponseData.of(div).respond();
    }

    private TohyoJokyoNyuryokuHandler createHandlerOf(TohyoJokyoNyuryokuDiv div) {
        return new TohyoJokyoNyuryokuHandler(div);
    }
}
