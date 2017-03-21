/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.SearchShikakuShosaiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】SearchShikakuDiv内の <br />
 * SearchShikakuShosaiDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0180-011 liuyj
 */
public final class SearchShikakuShosai {

    private static final boolean 空行作成 = Boolean.TRUE;

    private SearchShikakuShosai() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SearchShikakuShosaiDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void initialize(SearchShikakuShosaiDiv div, SenkyoShurui senkyoShurui) {
        clearThisPanel(div);

        set画面表示(senkyoShurui, div);

        set事由(div, senkyoShurui);
    }

    private static void set画面表示(SenkyoShurui senkyoShurui, SearchShikakuShosaiDiv div) {

        if ((senkyoShurui == SenkyoShurui.定時登録) || (senkyoShurui == SenkyoShurui.国政選挙_地方選挙)) {
            set画面表示する(div, Boolean.TRUE);
        } else {
            set画面表示する(div, Boolean.FALSE);
        }
    }

    private static void set画面表示する(SearchShikakuShosaiDiv div, boolean display) {
        div.getTxtSearchTeishiYMD().setDisplayNone(!display);
        div.getCcdSearchTeishiJiyu().setDisplayNoneMode(!display);
        div.getTxtSearchShojoYMD().setDisplayNone(!display);
        div.getTxtSearchShojoYoteiYMD().setDisplayNone(!display);
        div.getTxtSearchKeikiShuryoYMD().setDisplayNone(!display);
    }

    private static void set事由(SearchShikakuShosaiDiv div, SenkyoShurui senkyoShurui) {
        // 各種事由のDDLをセット
        div.getCcdSearchTeishiJiyu().initialize(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), 空行作成);

        if (senkyoShurui == SenkyoShurui.憲法改正国民投票) {
            div.getCcdSearchTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu(), 空行作成);
            div.getCcdSearchHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), 空行作成);
            div.getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), 空行作成);

        } else {
            div.getCcdSearchTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード.getCodeShubetsu(), 空行作成);
            div.getCcdSearchHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), 空行作成);
            div.getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), 空行作成);
        }
    }

    /**
     * 各項目をクリアします。
     *
     * @param div 投票資格検索条件詳細Div
     */
    public static void clearThisPanel(SearchShikakuShosaiDiv div) {
        div.getTxtSearchTorokuYmd().clearFromValue();
        div.getTxtSearchTorokuYmd().clearToValue();
        div.getCcdSearchTorokuJiyu().clear();
        div.getTxtSearchTeishiYMD().clearFromValue();
        div.getTxtSearchTeishiYMD().clearToValue();
        div.getCcdSearchTeishiJiyu().clear();
        div.getTxtSearchMasshoYMD().clearFromValue();
        div.getTxtSearchMasshoYMD().clearToValue();
        div.getCcdSearchMasshoJiyu().clear();
        div.getTxtSearchHyojiYMD().clearFromValue();
        div.getTxtSearchHyojiYMD().clearToValue();
        div.getCcdSearchHyojiJiyu().clear();
        div.getTxtSearchShojoYoteiYMD().clearFromValue();
        div.getTxtSearchShojoYoteiYMD().clearToValue();
        div.getTxtSearchShojoYMD().clearFromValue();
        div.getTxtSearchShojoYMD().clearToValue();
        div.getTxtSearchKeikiShuryoYMD().clearFromValue();
        div.getTxtSearchKeikiShuryoYMD().clearToValue();
        List<RString> keys = new ArrayList<>();
        div.getChk2keiMochi().setSelectedItemsByKey(keys);

        div.setIsOpen(Boolean.FALSE);
    }

}
