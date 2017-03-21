/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMD1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakushokai.FuzaishaTohyoShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010.AFAGMD1010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010.ShikakuShokaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD1010.ShikakuShokaiHandler;
import jp.co.ndensan.reams.af.afa.service.core.shikakushokai.ShikakuShokaiManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMD1010　資格照会 <br />
 * ShikakuShokaiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
public class ShikakuShokai {

    private final RString 検索結果状態フラグ = new RString("2");
    private final RString 再検索状態フラグ = new RString("3");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ShikakuShokaiDiv
     * @return ResponseData<ShikakuShokaiDiv>
     */
    public ResponseData<ShikakuShokaiDiv> onLoad(ShikakuShokaiDiv div) {
        Boolean ボタン表示フラグ = ViewStateHolder.get(ViewStateKeys.住民検索_資格_ボタン表示フラグ, Boolean.class);
        SennkyoSikakuShurui 選挙種類 = ViewStateHolder.get(ViewStateKeys.住民検索_資格_選挙種類, SennkyoSikakuShurui.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class));
        div.getCcdShikakuShokaiKojinJoho().initialize(識別コード);
        RString メニューID = ResponseHolder.getMenuID();
        ShikakuShokaiHandler handler = getHandler(div);

        ShikakuShokaiManager 資格照会Manager = ShikakuShokaiManager.createInstance();
        handler.初期化処理_表示制御(メニューID, ボタン表示フラグ);

        if (!メニューID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())) {
            List<SenkyoShikakuResult> 最新選挙資格情報 = new ArrayList<>();            
            最新選挙資格情報.add(資格照会Manager.get選挙資格情報(選挙種類, 識別コード).get(0));
            handler.初期化処理_選挙資格情報(選挙種類, 最新選挙資格情報);
        } else {
            List<ZaigaiSenkyoShikakuResult> 在外選挙資格情報 = 資格照会Manager.get在外選挙資格情報(識別コード);
            handler.初期化処理_在外選挙資格情報(選挙種類, 在外選挙資格情報);
        }

        List<FuzaishaTohyoShikakuResult> 不在者投票資格情報 = 資格照会Manager.get不在者投票資格情報(識別コード);
        handler.初期化処理_不在者投票資格情報(不在者投票資格情報);
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「検索結果一覧へ」をクリックするイベントメソッドです。
     *
     * @param mainPanel ShikakuShokaiDiv
     * @return ResponseData<ShikakuShokaiDiv>
     */
    public ResponseData<ShikakuShokaiDiv> onClick_btnSearchResult(ShikakuShokaiDiv mainPanel) {

        ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 検索結果状態フラグ);
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMD1010TransitionEventName.戻る).respond();
    }

    /**
     * 再検索するのイベントメソッドです。
     *
     * @param mainPanel ShikakuShokaiDiv
     * @return ResponseData<ShikakuShokaiDiv>
     */
    public ResponseData<ShikakuShokaiDiv> onClick_btnReSearch(ShikakuShokaiDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.住民検索資格状態変更パラメータ, 再検索状態フラグ);
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMD1010TransitionEventName.再検索).respond();
    }

    private ShikakuShokaiHandler getHandler(ShikakuShokaiDiv div) {
        return new ShikakuShokaiHandler(div);
    }
}
