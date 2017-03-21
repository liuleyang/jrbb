/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD2010;

import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.zaigaisenkyoninmeibo.ZaigaiSenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.ShokaiMeiboJohoDiv;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.zaigaisenkyoninmeibo.ZaigaiSenkyoninMeiboManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 照会名簿情報パネルのハンドラーです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public final class ShokaiMeiboJohoHandler {

    private ShokaiMeiboJohoHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ShokaiMeiboJohoDiv
     * @param メニューID RString
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoShurui SenkyoShurui
     */
    public static void onLoad(ShokaiMeiboJohoDiv div,
            RString メニューID,
            RString shohonNo,
            ShikibetsuCode shikibetsuCode,
            SenkyoShurui senkyoShurui) {
        div.getTxtGroupCode().setDisabled(true);
        div.getTxtGroupCode().setDisplayNone(AFAConfigKeysValue.抄本_グループコード_未使用.isEqual(ConfigKeysAFA.抄本_グループコード));
        div.getCcdTohyokuCodeMeibo().initialize(senkyoShurui, true);
        div.getCcdTohyokuCodeMeibo().setDisabled(true);
        if (メニューID.equals(AFAMenuId.AFAMND2040_在外選挙.menuId())) {
            div.getTxtKokugaiBunruiCode().setDisabled(true);
            setData_Is在外(div, shohonNo, shikibetsuCode);
        } else {
            div.getTxtKokugaiBunruiCode().setDisplayNone(true);
            setData_Not在外(div, shohonNo, shikibetsuCode);
        }
        div.getCcdMeiboBango().initialize();
        div.getCcdMeiboBango().setDisabled(true);
    }

    private static void setData_Is在外(ShokaiMeiboJohoDiv div, RString shohonNo, ShikibetsuCode shikibetsuCode) {
        ZaigaiSenkyoninMeiboManager manager = ZaigaiSenkyoninMeiboManager.createInstance();
        ZaigaiSenkyoninMeibo zaigaiSenkyoninMeibo = manager.get在外選挙人名簿(new ShohonNo(shohonNo), shikibetsuCode);
        if (zaigaiSenkyoninMeibo != null) {
            div.getTxtGroupCode().setValue(zaigaiSenkyoninMeibo.getグループコード());
            div.getCcdTohyokuCodeMeibo().initialize(zaigaiSenkyoninMeibo.get投票区コード());
            div.getTxtKokugaiBunruiCode().setValue(zaigaiSenkyoninMeibo.get国外分類コード());
            div.getCcdMeiboBango().initialize(zaigaiSenkyoninMeibo.get冊(),
                    new Decimal(zaigaiSenkyoninMeibo.get頁()),
                    new Decimal(zaigaiSenkyoninMeibo.get行()));
        }
    }

    private static void setData_Not在外(ShokaiMeiboJohoDiv div, RString shohonNo, ShikibetsuCode shikibetsuCode) {
        SenkyoninMeiboManager manager = SenkyoninMeiboManager.createInstance();
        SenkyoninMeibo senkyoninMeibo = manager.getSenkyoninMeiboList(new ShohonNo(shohonNo), shikibetsuCode);
        if (senkyoninMeibo != null) {
            div.getTxtGroupCode().setValue(senkyoninMeibo.getグループコード());
            div.getCcdTohyokuCodeMeibo().initialize(senkyoninMeibo.get投票区コード());
            div.getCcdMeiboBango().initialize(senkyoninMeibo.get冊(),
                    new Decimal(senkyoninMeibo.get頁()),
                    new Decimal(senkyoninMeibo.get行()));
        }
    }
}
