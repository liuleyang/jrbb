/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGM01000;

import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGM01000.ProcessCompleteDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGM01000.ProcessCompleteHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGM01000　処理完了メッセージ <br />
 * ProcesssCompleteDivに対応するコントローラです。
 *
 */
public class ProcessComplete {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel ProcessCompleteDiv
     * @return ResponseData<ProcessCompleteDiv>
     */
    public ResponseData<ProcessCompleteDiv> onLoad(ProcessCompleteDiv mainPanel) {

        KanryoKakuninParameter kanryoKakuninParam
                = ViewStateHolder.get(ViewStateKeys.完了確認, KanryoKakuninParameter.class);
        ProcessCompleteHandler handler = getHandler(mainPanel);
        handler.set完了メッセージ(kanryoKakuninParam);

        return ResponseData.of(mainPanel).respond();
    }

    private ProcessCompleteHandler getHandler(ProcessCompleteDiv div) {
        return new ProcessCompleteHandler(div);
    }
}
