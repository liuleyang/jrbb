/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMD2010;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.AFAGMD2010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.ShohonShokaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD2010.ShohonShokaiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD2010.ShokaiShikakuJohoHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMD2010　名簿照会 <br />
 * ShohonShokaiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0230-010 qiuxy
 */
public class ShohonShokai {

    private static final RString 検索結果一覧へ = new RString("btnSearchResult");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel ShohonShokaiDiv
     * @return ResponseData<ShohonShokaiDiv>
     */
    public ResponseData<ShohonShokaiDiv> onLoad(ShohonShokaiDiv mainPanel) {
        RString shohonNo = ViewStateHolder.get(ViewStateKeys.住民検索_抄本番号, RString.class);
        SenkyoShurui senkyoShurui = ViewStateHolder.get(ViewStateKeys.住民検索_選挙種類, SenkyoShurui.class);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(ViewStateHolder.get(ViewStateKeys.住民検索_識別コード, RString.class));
        RString メニューID = ViewState.getメニューID();
        mainPanel.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(false);
        mainPanel.getCcdShohonNameList().initialize(senkyoShurui, Boolean.FALSE);
        if (mainPanel.getCcdShohonNameList().getShohonListSize() == 0) {
            mainPanel.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            mainPanel.getCcdShohonNameList().click_chkKakoShohon();
            mainPanel.getCcdShohonNameList().initialize(senkyoShurui, Boolean.FALSE);
        }
        mainPanel.getCcdShohonNameList().selectedShohon(shohonNo);
        mainPanel.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(true);
        mainPanel.getCcdShokaiKojinJoho().initialize(shikibetsuCode);
        ShokaiShikakuJohoHandler.onLoad(mainPanel.getShokaiShikakuJoho(), senkyoShurui, メニューID, shohonNo, shikibetsuCode);
        if (メニューID.equals(AFAMenuId.AFAMND2040_在外選挙.menuId())) {
            mainPanel.getShokaiTohyoJokyo().setDisplayNone(true);
        } else {
            mainPanel.getShokaiTohyoJokyo().setDisplayNone(false);
            mainPanel.getShokaiTohyoJokyo().getDgShokaiTohyoJokyo().setDisabled(true);
            getHandler(mainPanel).setData(shohonNo, shikibetsuCode, senkyoShurui);
        }
        if (!ViewStateHolder.get(ViewStateKeys.is住民検索へ戻る可, boolean.class)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, true);
        }
        AccessLogger.log(AccessLogType.照会, PersonalData.of(shikibetsuCode));
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * ボタン「検索結果一覧へ」をクリックするイベントメソッドです。
     *
     * @param mainPanel ShohonShokaiDiv
     * @return ResponseData<ShohonShokaiDiv>
     */
    public ResponseData<ShohonShokaiDiv> onClick_btnSearchResult(ShohonShokaiDiv mainPanel) {
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMD2010TransitionEventName.戻る).respond();
    }

    /**
     * ボタン「再検索する」をクリックするイベントメソッドです。
     *
     * @param mainPanel ShohonShokaiDiv
     * @return ResponseData<ShohonShokaiDiv>
     */
    public ResponseData<ShohonShokaiDiv> onClick_btnReSearch(ShohonShokaiDiv mainPanel) {
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMD2010TransitionEventName.再検索).respond();
    }

    private ShohonShokaiHandler getHandler(ShohonShokaiDiv mainPanel) {
        return new ShohonShokaiHandler(mainPanel);
    }
}
