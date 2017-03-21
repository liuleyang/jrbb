/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.SearchSimpleJokenDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 【View】SearchSimpleJuminDiv内の <br />
 * SearchSimpleJokenDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0170-020 qiuxy
 */
public class SearchSimpleJoken {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SearchJokenDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void initialize(SearchSimpleJokenDiv div, SenkyoShurui senkyoShurui) {
        //TODO 住所を非表示にするモードがAtenaFinderにはないので、検索画面は自業務で作成するしかないかと思われます。
        // AtenaFinderの初期化
        div.getCcdSearchSimpleJukiJoho().load(AtenaHelper.createSearchKeyForAtenaFinder());
        //TODO 当日投票からの呼び出しの場合、住所検索項目をすべて非表示にする処理をここに書く。

        if (senkyoShurui == SenkyoShurui.定時登録) {
            div.getCcdTohyokuCode().initialize(SenkyoShurui.国政選挙_地方選挙, true);
        } else {
            div.getCcdTohyokuCode().initialize(senkyoShurui, true);
        }

        // 最近処理者履歴の初期化
        div.getCcdSearchSimpleSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.個人.getCode()));

        setDefaultDisplayMaxCount(div);
    }

    /**
     * 条件をクリアするボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJokenDiv
     * @return ResponseData<SearchSimpleJokenDiv>
     */
    public ResponseData<SearchSimpleJokenDiv> onClick_btnClear(SearchSimpleJokenDiv div) {

        clearThisPanel(div);

        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目をクリアします。
     *
     * @param div 簡易住民検索条件入力Div
     */
    public static void clearThisPanel(SearchSimpleJokenDiv div) {
        div.getCcdSearchSimpleJukiJoho().clear();
        div.getCcdTohyokuCode().clear();
        div.getChkSearchSenkyoShikaku().getSelectedItems().clear();
    }

    private static void setDefaultDisplayMaxCount(SearchSimpleJokenDiv div) {

        div.getTxtMaxDisplayCount()
                .setValue(new Decimal(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, SubGyomuCode.AFA選挙本体).toString()));
        div.getTxtMaxDisplayCount()
                .setMaxValue(new Decimal(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_上限値, SubGyomuCode.AFA選挙本体).toString()));

    }

}
