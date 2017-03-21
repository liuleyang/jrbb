/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShinseiJotai;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 在外作成帳票共有子DIVに対するコントローラです。
 *
 * @reamsid_L AF-0320-012 zhanggs
 */
public class ZaigaiSakuseiChohyoHandler {

    private final ZaigaiSakuseiChohyoDiv div;
    private static final RString 在外_登録照会文書 = new RString("在外_登録照会文書");
    private static final RString 在外_非登録通知本人 = new RString("在外_非登録通知本人");
    private static final RString 在外_非登録通知領事官 = new RString("在外_非登録通知領事官");
    private static final RString 在外_登録通知 = new RString("在外_登録通知");
    private static final RString 在外_変更通知本人 = new RString("在外_変更通知本人");
    private static final RString 在外_変更通知領事官 = new RString("在外_変更通知領事官");
    private static final RString 在外_再交付通知 = new RString("在外_再交付通知");
    private static final RString 在外_抹消通知本籍地 = new RString("在外_抹消通知本籍地");
    private static final RString 在外_抹消通知領事官 = new RString("在外_抹消通知領事官");

    /**
     * コンストラクタです。
     *
     * @param div 在外作成帳票共有子DIV
     */
    public ZaigaiSakuseiChohyoHandler(ZaigaiSakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param shinseiJotai RString
     */
    public void initialize(RString... shinseiJotai) {
        初期化処理_非表示();
        初期化処理_表示内容();
        RString menuID = ResponseHolder.getMenuID();
        if (menuID.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())) {
            div.getZaigaiSakuseiChohyoMasshoHonsekichi().setDisplayNone(Boolean.FALSE);
            div.getZaigaiSakuseiChohyoMasshoRyojikan().setDisplayNone(Boolean.FALSE);
        }
        if (menuID.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())) {
            div.getZaigaiSakuseiChohyoSaiKofu().setDisplayNone(Boolean.FALSE);
        }
        if (menuID.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())) {
            div.getZaigaiSakuseiChohyoHenkoHonnin().setDisplayNone(Boolean.FALSE);
            div.getZaigaiSakuseiChohyoHenkoRyojikan().setDisplayNone(Boolean.FALSE);

        }
        if (menuID.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId()) || menuID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())) {
            if (null == shinseiJotai || 0 == shinseiJotai.length || RString.isNullOrEmpty(shinseiJotai[0])) {
                return;
            }
            if (ShinseiJotai.申請.getKey().equals(shinseiJotai[0])) {
                div.getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().setDisplayNone(Boolean.FALSE);
            }
            if (ShinseiJotai.申請却下.getKey().equals(shinseiJotai[0])) {
                div.getZaigaiSakuseiChohyoTorikeshiHonnin().setDisplayNone(Boolean.FALSE);
                div.getZaigaiSakuseiChohyoTorikeshiRyojikan().setDisplayNone(Boolean.FALSE);
            }
            if (ShinseiJotai.証明書交付.getKey().equals(shinseiJotai[0])) {
                div.getZaigaiSakuseiChohyoToroku().setDisplayNone(Boolean.FALSE);
            }
        }
    }

    private void 初期化処理_表示内容() {
        div.getZaigaiSakuseiChohyoMasshoHonsekichi().setIsPublish(false);
        div.getZaigaiSakuseiChohyoMasshoHonsekichi().getCcdPrintNaiyoMasshoHonsekichi().initialize(在外_抹消通知本籍地);
        div.getZaigaiSakuseiChohyoMasshoRyojikan().setIsPublish(false);
        div.getZaigaiSakuseiChohyoMasshoRyojikan().getCcdPrintNaiyoMasshoRyojikan().initialize(在外_抹消通知領事官);
        div.getZaigaiSakuseiChohyoSaiKofu().setIsPublish(false);
        div.getZaigaiSakuseiChohyoSaiKofu().getCcdPrintNaiyoSaiKofuTsuchi().initialize(在外_再交付通知);
        div.getZaigaiSakuseiChohyoHenkoHonnin().setIsPublish(false);
        div.getZaigaiSakuseiChohyoHenkoHonnin().getCcdPrintNaiyoHenkoHonnin().initialize(在外_変更通知本人);
        div.getZaigaiSakuseiChohyoHenkoRyojikan().setIsPublish(false);
        div.getZaigaiSakuseiChohyoHenkoRyojikan().getCcdPrintNaiyoHenkoRyojikan().initialize(在外_変更通知領事官);
        div.getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().setIsPublish(false);
        div.getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().getCcdPrintNaiyoHonsekichiShokaiKaitoTsuchi().initialize(在外_登録照会文書);
        div.getZaigaiSakuseiChohyoTorikeshiHonnin().setIsPublish(false);
        div.getZaigaiSakuseiChohyoTorikeshiHonnin().getCcdPrintNaiyoTorikeshiHonnin().initialize(在外_非登録通知本人);
        div.getZaigaiSakuseiChohyoTorikeshiRyojikan().setIsPublish(false);
        div.getZaigaiSakuseiChohyoTorikeshiRyojikan().getCcdPrintNaiyoTorikeshiRyojikan().initialize(在外_非登録通知領事官);
        div.getZaigaiSakuseiChohyoToroku().setIsPublish(false);
        div.getZaigaiSakuseiChohyoToroku().getCcdPrintNaiyoTorokuTsuchi().initialize(在外_登録通知);
    }

    private void 初期化処理_非表示() {
        div.getZaigaiSakuseiChohyoTorikeshiRyojikan().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoTorikeshiHonnin().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoHenkoHonnin().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoHenkoRyojikan().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoSaiKofu().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoToroku().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoMasshoHonsekichi().setDisplayNone(Boolean.TRUE);
        div.getZaigaiSakuseiChohyoMasshoRyojikan().setDisplayNone(Boolean.TRUE);
    }
}
