/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SearchShikakuShosai;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SearchShikakuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してSearchShikakuDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0180-011 liuyj
 */
public class SearchShikakuHandler {

    private final SearchShikakuDiv div;

    private static final KeyValueDataSource 有権者 = new KeyValueDataSource(new RString("1"), new RString("有権者"));
    private static final KeyValueDataSource 表示者 = new KeyValueDataSource(new RString("2"), new RString("表示者"));
    private static final KeyValueDataSource 抹消者 = new KeyValueDataSource(new RString("3"), new RString("抹消者"));
    private static final KeyValueDataSource 公民権停止者 = new KeyValueDataSource(new RString("4"), new RString("公民権停止者"));
    private static final KeyValueDataSource 一号資格者 = new KeyValueDataSource(new RString("5"), new RString("1号資格者"));
    private static final KeyValueDataSource 二号資格者 = new KeyValueDataSource(new RString("6"), new RString("2号資格者"));

    private static final KeyValueDataSource 郵便 = new KeyValueDataSource(new RString("1"), new RString("郵便"));
    private static final KeyValueDataSource 船員 = new KeyValueDataSource(new RString("2"), new RString("船員"));
    private static final KeyValueDataSource 南極 = new KeyValueDataSource(new RString("3"), new RString("南極"));
    private static final KeyValueDataSource 在外 = new KeyValueDataSource(new RString("4"), new RString("在外"));

    /**
     * コンストラクタです。
     *
     * @param div 投票資格検索条件Div
     */
    public SearchShikakuHandler(SearchShikakuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        clearThisPanel();
        div.getCcdTohyokuCode().initialize(senkyoShurui, true);
        RString menuId = ResponseHolder.getMenuID();
        init登録事由(menuId);
        init登録停止事由();
        init抹消事由(menuId);
        init表示事由(menuId);
        init選挙資格(menuId);
        init投票資格(menuId);
        init詳細条件(menuId);

    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        clearThisPanel();
        div.getCcdTohyokuCode().initialize();
        RString menuId = ResponseHolder.getMenuID();
        init登録事由(menuId);
        init登録停止事由();
        init抹消事由(menuId);
        init表示事由(menuId);
        init選挙資格(menuId);
        init投票資格(menuId);
        init詳細条件(menuId);
    }

    private void init登録事由(RString menuId) {
        if (isメニューが国民投票(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu());

        } else {
            div.getSearchShikakuShosai().getCcdSearchTorokuJiyu().initialize(AFACodeShubetsu.登録事由コード.getCodeShubetsu());
        }
    }

    private void init登録停止事由() {
        div.getSearchShikakuShosai().getCcdSearchTeishiJiyu().initialize(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu());
    }

    private void init抹消事由(RString menuId) {
        if (isメニューが国民投票(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu());
        } else if (isメニューが在外選挙(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu());
        } else if (isメニューが不在者投票資格(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu());
        } else {
            div.getSearchShikakuShosai().getCcdSearchMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード.getCodeShubetsu());
        }
    }

    private void init表示事由(RString menuId) {
        if (isメニューが在外選挙(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu());
        } else {
            div.getSearchShikakuShosai().getCcdSearchHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード.getCodeShubetsu());
        }
    }

    private void init選挙資格(RString menuId) {
        if (isメニューが国民投票(menuId)) {
            List<KeyValueDataSource> senkyoShikakuList = Arrays.asList(抹消者, 一号資格者, 二号資格者);
            div.getChkSearchSenkyoShikaku().setDataSource(senkyoShikakuList);
        } else {
            List<KeyValueDataSource> senkyoShikakuList = Arrays.asList(有権者, 表示者, 抹消者, 公民権停止者);
            div.getChkSearchSenkyoShikaku().setDataSource(senkyoShikakuList);
        }
    }

    private void init投票資格(RString menuId) {
        if (isメニューが在外選挙(menuId)) {
            List<KeyValueDataSource> tohyoShikakuList = Arrays.asList(在外);
            div.getChkSearchTohyoShikaku().setDataSource(tohyoShikakuList);
            if (menuId.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                    || menuId.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())) {
                div.getChkSearchTohyoShikaku().setDisabled(false);
            } else {
                div.getChkSearchTohyoShikaku().setSelectedItems(tohyoShikakuList);
                div.getChkSearchTohyoShikaku().setDisabled(true);
            }
        } else {
            List<KeyValueDataSource> tohyoShikakuList = Arrays.asList(郵便, 船員, 南極);
            div.getChkSearchTohyoShikaku().setDataSource(tohyoShikakuList);
        }
    }

    private void init詳細条件(RString menuId) {
        if (isメニューが在外選挙(menuId)) {
            div.getSearchShikakuShosai().getCcdSearchTorokuJiyu().setDisplayNoneMode(Boolean.TRUE);
            div.getSearchShikakuShosai().getTxtSearchTeishiYMD().setDisplayNone(Boolean.TRUE);
            div.getSearchShikakuShosai().getCcdSearchTeishiJiyu().setDisplayNoneMode(Boolean.TRUE);
            set事由ない日付DisplayNone(true);
        } else if (isメニューが国民投票(menuId)
                || isメニューが海区漁業(menuId)) {
            div.getSearchShikakuShosai().getTxtSearchTeishiYMD().setDisplayNone(Boolean.TRUE);
            div.getSearchShikakuShosai().getCcdSearchTeishiJiyu().setDisplayNoneMode(Boolean.TRUE);
            div.getSearchShikakuShosai().getTxtSearchHyojiYMD().setDisplayNone(Boolean.TRUE);
            div.getSearchShikakuShosai().getCcdSearchHyojiJiyu().setDisplayNoneMode(Boolean.TRUE);
            set事由ない日付DisplayNone(true);
        } else {
            div.getSearchShikakuShosai().getCcdSearchTorokuJiyu().setDisplayNoneMode(Boolean.FALSE);
            div.getSearchShikakuShosai().getTxtSearchTeishiYMD().setDisplayNone(Boolean.FALSE);
            div.getSearchShikakuShosai().getCcdSearchTeishiJiyu().setDisplayNoneMode(Boolean.FALSE);
            div.getSearchShikakuShosai().getTxtSearchHyojiYMD().setDisplayNone(Boolean.FALSE);
            div.getSearchShikakuShosai().getCcdSearchHyojiJiyu().setDisplayNoneMode(Boolean.FALSE);
            set事由ない日付DisplayNone(false);
        }
    }

    private void set事由ない日付DisplayNone(boolean isDisplayNone) {
        div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().setDisplayNone(isDisplayNone);
        div.getSearchShikakuShosai().getTxtSearchShojoYMD().setDisplayNone(isDisplayNone);
        div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().setDisplayNone(isDisplayNone);
        div.getSearchShikakuShosai().getChk2keiMochi().setDisplayNone(isDisplayNone);
    }

    private boolean isメニューが国民投票(RString menuId) {
        return menuId.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || menuId.equals(AFAMenuId.AFAMNG1040_投票人の投票区変更.menuId())
                || menuId.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuId.equals(AFAMenuId.AFAMND2030_国民投票.menuId());
    }

    private boolean isメニューが在外選挙(RString menuId) {
        return menuId.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                || menuId.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuId.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuId.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuId.equals(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId())
                || menuId.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || menuId.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || menuId.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || menuId.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || menuId.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId())
                || menuId.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())
                || menuId.equals(AFAMenuId.AFAMND2040_在外選挙.menuId());
    }

    private boolean isメニューが海区漁業(RString menuId) {
        return menuId.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId())
                || menuId.equals(AFAMenuId.AFAMND2050_海区漁業調整委員会委員選挙.menuId())
                || menuId.equals(AFAMenuId.AFAMNK1020_選挙人の投票区変更.menuId())
                || menuId.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())
                || menuId.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())
                || menuId.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId());
    }

    private boolean isメニューが不在者投票資格(RString menuId) {
        return menuId.equals(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId())
                || menuId.equals(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId())
                || menuId.equals(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId());
    }

    /**
     * 各項目をクリアします。
     *
     */
    public void clearThisPanel() {
        div.getCcdTohyokuCode().clear();
        div.getChkSearchSenkyoShikaku().getSelectedItems().clear();
        div.getChkSearchTohyoShikaku().getSelectedItems().clear();
        SearchShikakuShosai.clearThisPanel(div.getSearchShikakuShosai());
    }

    /**
     * 投票区コードを取得します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return div.getCcdTohyokuCode().getTxtTohyokuCode().getValue();
    }

    /**
     * 選挙資格リストを取得します。
     *
     * @return 選挙資格リスト
     */
    public List<RString> get選挙資格リスト() {
        return div.getChkSearchSenkyoShikaku().getSelectedValues();
    }

    /**
     * 投票資格リストを取得します。
     *
     * @return 投票資格リスト
     */
    public List<RString> get投票資格リスト() {
        return div.getChkSearchTohyoShikaku().getSelectedValues();
    }

    /**
     * 名簿登録日Fromを取得します。
     *
     * @return 名簿登録日From
     */
    public FlexibleDate get名簿登録日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 名簿登録日Toを取得します。
     *
     * @return 名簿登録日To
     */
    public FlexibleDate get名簿登録日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchTorokuYmd().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 登録停止日Fromを取得します。
     *
     * @return 登録停止日From
     */
    public FlexibleDate get登録停止日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 登録停止日Toを取得します。
     *
     * @return 登録停止日To
     */
    public FlexibleDate get登録停止日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchTeishiYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 抹消日Fromを取得します。
     *
     * @return 抹消日From
     */
    public FlexibleDate get抹消日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 抹消日Toを取得します。
     *
     * @return 抹消日To
     */
    public FlexibleDate get抹消日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchMasshoYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 表示日Fromを取得します。
     *
     * @return 表示日From
     */
    public FlexibleDate get表示日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 表示日Toを取得します。
     *
     * @return 表示日To
     */
    public FlexibleDate get表示日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchHyojiYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 消除予定日Fromを取得します。
     *
     * @return 消除予定日From
     */
    public FlexibleDate get消除予定日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 消除予定日Toを取得します。
     *
     * @return 消除予定日To
     */
    public FlexibleDate get消除予定日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 表示消除日Fromを取得します。
     *
     * @return 表示消除日From
     */
    public FlexibleDate get表示消除日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchShojoYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 表示消除日Toを取得します。
     *
     * @return 表示消除日To
     */
    public FlexibleDate get表示消除日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchShojoYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 刑期終了日Fromを取得します。
     *
     * @return 刑期終了日From
     */
    public FlexibleDate get刑期終了日From() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getFromValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 刑期終了日Toを取得します。
     *
     * @return 刑期終了日To
     */
    public FlexibleDate get刑期終了日To() {
        RDate date = div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD().getToValue();
        return date == null ? null : new FlexibleDate(date.toDateString());
    }

    /**
     * 登録事由を取得します。
     *
     * @return 登録事由
     */
    public RString get登録事由() {
        return ((JiyuNameListDiv) div.getSearchShikakuShosai().getCcdSearchTorokuJiyu()).getDdlJiyuName().getSelectedKey();
    }

    /**
     * 登録停止事由を取得します。
     *
     * @return 登録停止事由
     */
    public RString get登録停止事由() {
        return ((JiyuNameListDiv) div.getSearchShikakuShosai().getCcdSearchTeishiJiyu()).getDdlJiyuName().getSelectedKey();
    }

    /**
     * 抹消事由を取得します。
     *
     * @return 抹消事由
     */
    public RString get抹消事由() {
        return ((JiyuNameListDiv) div.getSearchShikakuShosai().getCcdSearchMasshoJiyu()).getDdlJiyuName().getSelectedKey();
    }

    /**
     * 表示事由を取得します。
     *
     * @return 表示事由
     */
    public RString get表示事由() {
        return ((JiyuNameListDiv) div.getSearchShikakuShosai().getCcdSearchHyojiJiyu()).getDdlJiyuName().getSelectedKey();
    }

    /**
     * 2刑持ちフラグを取得します。
     *
     * @return 2刑持ちフラグ
     */
    public boolean is2刑持ち() {
        return div.getSearchShikakuShosai().getChk2keiMochi().isAllSelected();
    }

    /**
     * 日期の大小関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 日期大小関係チェック() {
        return getSearchShikakuValidationHandler(div).validate();
    }

    private SearchShikakuValidationHandler getSearchShikakuValidationHandler(SearchShikakuDiv div) {
        return new SearchShikakuValidationHandler(div);
    }
}
