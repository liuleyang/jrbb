/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD2010;

import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.ShokaiShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】ShohonShokaiDiv内の <br />
 * ShokaiShikakuJohoDivに対応するハンドラーです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0230-010 qiuxy
 */
public final class ShokaiShikakuJohoHandler {

    private ShokaiShikakuJohoHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ShokaiShikakuJohoDiv
     * @param senkyoShurui RString
     * @param メニューID RString
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     */
    public static void onLoad(ShokaiShikakuJohoDiv div,
            SenkyoShurui senkyoShurui,
            RString メニューID,
            RString shohonNo,
            ShikibetsuCode shikibetsuCode) {
        div.getCcdShokaiTohyoShikakuJoho().initialize(senkyoShurui, shikibetsuCode);
        ShokaiMeiboJohoHandler.onLoad(div.getShokaiMeiboJoho(), メニューID, shohonNo, shikibetsuCode, senkyoShurui);
        div.getCcdShokaiKaikuFuzuiJoho().setDisplayNoneMode(true);
        ShohonManager manager = ShohonManager.createInstance();
        Shohon shohon = manager.get抄本(new ShohonNo(shohonNo));
        if (SenkyoShurui.toValue(shohon.get選挙種類().getColumnValue()) == SenkyoShurui.海区漁業調整委員会委員選挙) {
            div.getCcdShokaiKaikuFuzuiJoho().setDisplayNoneMode(false);
            div.getCcdShokaiKaikuFuzuiJoho().initialize(shohonNo, shikibetsuCode);
        }
    }

}
