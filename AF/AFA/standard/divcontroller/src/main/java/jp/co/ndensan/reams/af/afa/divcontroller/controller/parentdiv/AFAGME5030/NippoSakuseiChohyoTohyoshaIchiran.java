/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoTohyoshaIchiranDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoTohyoshaIchiranDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoTohyoshaIchiran {

    private NippoSakuseiChohyoTohyoshaIchiran() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoTohyoshaIchiranDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoTohyoshaIchiranDiv div, SenkyoShurui senkyoShurui) {

        div.getCcdTohyoshaIchiranTohyokuCode().initialize(senkyoShurui);
        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            div.getCcdTohyoJiyu().initialize(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), Boolean.TRUE);
        } else {
            div.getCcdTohyoJiyu().initialize(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), Boolean.TRUE);
        }
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoTohyoshaIchiranDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoTohyoshaIchiranDiv div) {
        div.getChkKonzaiPrint().setSelectedItems(div.getChkKonzaiPrint().getDataSource());
        div.getCcdTohyoshaIchiranTohyokuCode().clearData();
        div.getCcdTohyoshaIchiranShisetsuCode().clearData();

        div.getChkTohyoshaIchiranKijitsumae().getSelectedItems().clear();
        div.getCcdTohyoJiyu().initialize(Code.EMPTY);
        div.getTxtTohyoshaIchiranTohyoYMD().clearFromValue();
        div.getTxtTohyoshaIchiranTohyoYMD().clearToValue();
        div.getTxtTohyoshaIchiranTohyoTime().clearFromValue();
        div.getTxtTohyoshaIchiranTohyoTime().clearToValue();
        div.getChkTohyoshaIchiranKijitsumaeTaisho().getSelectedItems().clear();

        div.getChkTohyoshaIchiranFuzaisha().getSelectedItems().clear();
        div.getTxtTohyoshaIchiranKofuYMD().clearFromValue();
        div.getTxtTohyoshaIchiranKofuYMD().clearToValue();
        div.getTxtTohyoshaIchiranJuriYMD().clearFromValue();
        div.getTxtTohyoshaIchiranJuriYMD().clearToValue();
        div.getTxtTohyoshaIchiranJuriTime().clearFromValue();
        div.getTxtTohyoshaIchiranJuriTime().clearToValue();
        div.getChkTohyoshaIchiranFuzaishaTaisho().getSelectedItems().clear();

    }

}
