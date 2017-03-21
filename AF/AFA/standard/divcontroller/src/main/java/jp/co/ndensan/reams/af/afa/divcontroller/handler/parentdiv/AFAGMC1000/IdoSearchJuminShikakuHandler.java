/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.idosearchjuminshikaku.IdoSearchJuminShikakuParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.ISearchShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.IdoSearchJuminShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.dgIdoSearchKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminJotaiStatus;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminShubetsuStatus;
import jp.co.ndensan.reams.ua.uax.definition.core.KensakuYoShikibetsuCode;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.StatusOfCheckBox;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 住民検索（資格）のHandlerです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public class IdoSearchJuminShikakuHandler {

    private final RString 再検索する = new RString("btnReSearch");
    private final IdoSearchJuminShikakuDiv div;
//    private static final RString 南極 = new RString("南極");
//    private static final RString 郵便 = new RString("郵便");
//    private static final RString 船員 = new RString("船員");
    private static final RString 在外 = new RString("在外");
//    private static final RString 抹消者 = new RString("抹消者");
//    private static final RString 有権者 = new RString("有権者");
//    private static final RString 表示者 = new RString("表示者");
//    private static final RString 二号資格者 = new RString("2号資格者");
//    private static final RString 一号資格者 = new RString("1号資格者");
//    private static final RString 公民権停止者 = new RString("公民権停止者");
    private static final RString 含まないKEY = new RString("含まない");
    private static final int 三 = 3;

    /**
     * 住民検索（資格）のコンストラクタです。
     *
     * @param div SearchJuminDiv
     */
    public IdoSearchJuminShikakuHandler(IdoSearchJuminShikakuDiv div) {
        this.div = div;
    }

    /**
     * 初期化します。
     *
     * @param 選挙種類 SenkyoShurui
     */
    public void set初期表示(SenkyoShurui 選挙種類) {

        div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().load(AtenaHelper.createSearchKeyForAtenaFinder());
        set宛名共通検索条件表示制御();

        div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().initialize(選挙種類);

        div.getIdoSearchJoken().getCcdIdoSearchSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.個人.getCode()));

        RString 初期値 = BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, SubGyomuCode.AFA選挙本体);
        div.getIdoSearchJoken().getTxtMaxKensu().setValue(new Decimal(doZZZ_ZZ9編集(初期値).toString()));
        div.getIdoSearchKekkaList().setDisabled(true);
        div.getIdoSearchKekkaList().setIsOpen(false);
        div.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getDataSource().clear();
        change画面To初期化状態();
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索する, true);
        //ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui());
    }

    /**
     * メニューIDがAFAMNC1010、AFAMNG1030のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況1(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId());
    }

    /**
     * メニューIDがAFAMNC2010のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況2(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId());
    }

    /**
     * メニューIDがAFAMNC2020のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況3(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId());
    }

    /**
     * メニューIDがAFAMNC2030のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況4(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId());
    }

    /**
     * メニューIDがAFAMND1010、AFAMND1020、AFAMND1030、AFAMND1040のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況5(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMND1010_定時登録選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId());
    }

    /**
     * メニューIDがAFAMND1010、AFAMND1020、AFAMND1030、AFAMND1040のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況6(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId());
    }

    /**
     * メニューIDがAFAMND1010、AFAMND1020、AFAMND1030、AFAMND1040のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID選挙種類(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId());
    }

    /**
     * メニューIDがメニューID選挙資格種類のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID選挙資格種類(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1010_定時登録選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId());
    }

    /**
     * 資格データがなくても、画面遷移が必要なメニューIDのとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID選挙資格ない時に画面遷移あり(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2020_洋上投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNC2030_南極投票資格登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId());
    }

    /**
     * 資格データがない場合、画面遷移せずエラーとするメニューIDのとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID選挙資格ない時に画面遷移なし(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMND1010_定時登録選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1070_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1080_選挙人名簿削除.menuId());
    }

    /**
     * 検索用パラメータを生成します。
     *
     * @param menuID RString
     * @param 選挙種類code RString
     * @return IdoSearchJuminShikakuParameter
     */
    public IdoSearchJuminShikakuParameter create検索用パラメータ(RString menuID, RString 選挙種類code) {
        ISearchShikakuDiv 投票資格Div = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku();
        return new IdoSearchJuminShikakuParameter(
                new Code(選挙種類code),
                投票資格Div.get投票区コード(),
                edit選挙資格(),
                edit投票資格(),
                format日付(投票資格Div.get名簿登録日From()),
                format日付(投票資格Div.get名簿登録日To()),
                投票資格Div.get登録事由(),
                format日付(投票資格Div.get登録停止日From()),
                format日付(投票資格Div.get登録停止日To()),
                投票資格Div.get登録停止事由(),
                format日付(投票資格Div.get抹消日From()),
                format日付(投票資格Div.get抹消日To()),
                投票資格Div.get抹消事由(),
                format日付(投票資格Div.get表示日From()),
                format日付(投票資格Div.get表示日To()),
                投票資格Div.get表示事由(),
                format日付(投票資格Div.get消除予定日From()),
                format日付(投票資格Div.get消除予定日To()),
                format日付(投票資格Div.get表示消除日From()),
                format日付(投票資格Div.get表示消除日To()),
                format日付(投票資格Div.get刑期終了日From()),
                format日付(投票資格Div.get刑期終了日To()),
                get生年月日(),
                div.getIdoSearchJoken().getTxtMaxKensu().getValue().multiply(三).intValue(),
                is在外(),
                is国政選挙_地方選挙(div.getCcdSenkyoShurui().getSelectedSenkyoShurui()),
                div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().is2刑持ち(),
                isUsing生年月日(menuID),
                is選挙資格LeftJoin(menuID),
                is選挙情報あり(),
                createSearchKey());
    }

    private IShikibetsuTaishoPSMSearchKey createSearchKey() {
        return div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
    }

    private boolean is選挙情報あり() {
//        AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getIdoSearchJoken().getCcdIdoSearchJukiJoho();
//        return !RString.isNullOrEmpty(宛名検索Div.getTxtAtenaMeisho().getText())
//                || !RString.isNullOrEmpty(宛名検索Div.getTxtSeinenGappi().getText())
//                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode().getDomain().value())
//                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName().getValue())
//                || !宛名検索Div.getTxtShikibetsuCodeSub().getDomain().isEmpty()
//                || !宛名検索Div.getTxtSetaiCodeSub().getDomain().isEmpty();
        ISearchShikakuDiv 資格検索Div = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku();
        return !RString.isNullOrEmpty(資格検索Div.get投票区コード())
                || !資格検索Div.getChkSearchTohyoShikaku().getSelectedKeys().isEmpty()
                || (資格検索Div.get名簿登録日From() != null && !資格検索Div.get名簿登録日From().isEmpty())
                || (資格検索Div.get名簿登録日To() != null && !資格検索Div.get名簿登録日To().isEmpty())
                || !RString.isNullOrEmpty(資格検索Div.get登録事由())
                || (資格検索Div.get登録停止日From() != null && !資格検索Div.get登録停止日From().isEmpty())
                || (資格検索Div.get登録停止日To() != null && !資格検索Div.get登録停止日To().isEmpty())
                || !RString.isNullOrEmpty(資格検索Div.get登録停止事由())
                || (資格検索Div.get抹消日From() != null && !資格検索Div.get抹消日From().isEmpty())
                || (資格検索Div.get抹消日To() != null && !資格検索Div.get抹消日To().isEmpty())
                || !RString.isNullOrEmpty(資格検索Div.get抹消事由())
                || (資格検索Div.get表示日From() != null && !資格検索Div.get表示日From().isEmpty())
                || (資格検索Div.get表示日To() != null && !資格検索Div.get表示日To().isEmpty())
                || !RString.isNullOrEmpty(資格検索Div.get表示事由())
                || (資格検索Div.get消除予定日From() != null && !資格検索Div.get消除予定日From().isEmpty())
                || (資格検索Div.get消除予定日To() != null && !資格検索Div.get消除予定日To().isEmpty())
                || (資格検索Div.get表示消除日From() != null && !資格検索Div.get表示消除日From().isEmpty())
                || (資格検索Div.get表示消除日To() != null && !資格検索Div.get表示消除日To().isEmpty())
                || (資格検索Div.get刑期終了日From() != null && !資格検索Div.get刑期終了日From().isEmpty())
                || (資格検索Div.get刑期終了日To() != null && !資格検索Div.get刑期終了日To().isEmpty())
                || 資格検索Div.is2刑持ち();
    }

    private FlexibleDate format日付(FlexibleDate 日付) {
        return 日付 == null ? FlexibleDate.EMPTY : 日付;
    }

    private boolean is国政選挙_地方選挙(SenkyoShurui 選挙種類) {
        return 選挙種類 == SenkyoShurui.国政選挙_地方選挙;
    }

    /**
     * 選挙資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit選挙資格() {
        List<Code> 選挙資格list = new ArrayList<>();
        RString メニュー_ID = ResponseHolder.getMenuID();

        boolean is国民投票 = メニュー_ID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMND1020_国民投票.menuId());

        List<RString> 選挙資格リスト = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get選挙資格リスト();
        if (!is国民投票) {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.有権者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.表示者.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.表示者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.公民権停止.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.公民権停止.getKey()));
            }
        } else {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_1号資格.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.有権者_1号資格.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_2号資格.getValue())) {
                選挙資格list.add(new Code(SennkyoSikakuKubun.有権者_2号資格.getKey()));
            }
        }
        return 選挙資格list;
    }

    /**
     * 投票資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit投票資格() {
        List<Code> 投票資格s = new ArrayList<>();
        List<RString> 投票資格リスト = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get投票資格リスト();

        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_郵便.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()));
        }
        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_船員.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()));
        }
        if (投票資格リスト.contains(TohyoShikakuShurui.投票資格種類_南極.getValue())) {
            投票資格s.add(new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()));
        }
        return 投票資格s;
    }

    /**
     * 在外の判定メソッドです。
     *
     * @return boolean
     */
    public boolean is在外() {
        List<RString> 投票資格リスト = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get投票資格リスト();
        return 投票資格リスト.contains(在外);
    }

    /**
     * 在外の判定メソッドです。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isUsing生年月日(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId());

    }

    /**
     * 選挙資格の判定メソッドです。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean is選挙資格LeftJoin(RString menuID) {
//        return jyukiCheck(div);
        return isメニューID選挙資格ない時に画面遷移あり(menuID);
    }

//        public boolean is選挙資格LeftJoin(RString menuID) {
//        return menuID.equals(AFAMenuId.AFAMNK1060_選挙人名簿登録.menuId())
//                || menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
//                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId());
//    }
    /**
     * 検索条件の判定メソッドです。
     *
     * @param div IdoSearchJuminShikakuDiv
     * @return boolean
     */
    public boolean jyukiCheck(IdoSearchJuminShikakuDiv div) {
        IShikibetsuTaishoPSMSearchKey psmSearchKey = div.getIdoSearchJoken()
                .getCcdIdoSearchJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
        RString 氏名 = psmSearchKey.get氏名();
        if (氏名 != null && !氏名.isEmpty()) {
            return true;
        }
        FlexibleDate 生年月日 = psmSearchKey.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
            return true;
        }
        AtenaJusho 住所 = psmSearchKey.get町域();
        if (住所 != null && !住所.isEmpty()) {
            return true;
        }

        KensakuYoShikibetsuCode 識別コード = psmSearchKey.get識別コード();
        if (識別コード != null && !識別コード.isEmpty()) {
            return true;
        }
        return !psmSearchKey.get世帯コード().isEmpty() && psmSearchKey.get世帯コード() != null;
    }

    /**
     * 初期化状態になります。
     */
    public void change画面To初期化状態() {
        div.getIdoSearchKekkaList().setDisabled(Boolean.TRUE);
        div.getIdoSearchJoken().setDisabled(Boolean.FALSE);
        setDisabled検索条件指定パネル(Boolean.FALSE);
        div.getIdoSearchKekkaList().setIsOpen(Boolean.FALSE);
    }

    /**
     * 検索結果状態になります。
     */
    public void change画面To検索結果状態() {
        div.getIdoSearchKekkaList().setDisabled(Boolean.FALSE);
        div.getIdoSearchJoken().setDisabled(Boolean.TRUE);
        setDisabled検索条件指定パネル(Boolean.TRUE);
        div.getIdoSearchKekkaList().setIsOpen(Boolean.TRUE);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索する, false);
    }

    /**
     * 再検索状態になります。
     */
    public void change画面To再検索状態() {
        div.getIdoSearchJoken().setDisabled(Boolean.FALSE);
        setDisabled検索条件指定パネル(Boolean.FALSE);
        div.getIdoSearchKekkaList().setIsOpen(Boolean.FALSE);
        div.getIdoSearchKekkaList().setDisabled(Boolean.TRUE);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索する, true);
    }

    private void setDisabled検索条件指定パネル(boolean isDisabled) {
        div.getIdoSearchJoken().setIsOpen(!isDisabled);
        div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().setDisabled(isDisabled);
        div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().setDisabled(isDisabled);
    }

    /**
     * 検索結果一覧データグリッドをクリアします。
     */
    public void clear検索結果一覧データグリッド() {
        div.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getDataSource().clear();
        div.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getFilterList().clear();
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param result JuminKensaku
     * @param row dgSearchKekkaList_Row
     * @param senkyoShurui SenkyoShurui
     * @param 投票資格リスト List<RString>
     * @return dgSearchKekkaList_Row
     */
    public dgIdoSearchKekkaList_Row set検索結果To一覧(IdoSearchJumin result,
            dgIdoSearchKekkaList_Row row,
            RString senkyoShurui,
            List<RString> 投票資格リスト) {
        row.setTxtShimei(result.get氏名());
        row.setTxtKanaShimei(result.getカナ氏名());
        row.setTxtSeinengappiYMD(result.get生年月日());
        row.getTxtSeinengappiYMDseireki().setValue(result.get生年月日西暦());
        row.setTxtSeibetsu(result.get性別名称());
        row.setTxtJusho(result.getフォーマット後住所());
//        row.setTxtJuminShubetsu(result.get住民種別名称());
        row.setTxtJuminShubetsu(result.get住民状態名称());
        row.setTxtShikibetsuCode(result.get識別コード());
        row.setTxtSetaiCode(result.get世帯コード());
        List<Code> 投票資格コードlist = new ArrayList<>();
        if (null != result.get投票資格() && !result.get投票資格().isEmpty()) {
            for (int i = 0; i < result.get投票資格().size(); i++) {
                投票資格コードlist.add(result.get投票資格().get(i).getTohyoShikakuShurui());
            }
            row.setChkYubin(is郵便投票資格(投票資格コードlist, 投票資格リスト));
            row.setChkSenin(is洋上投票資格(投票資格コードlist, 投票資格リスト));
            row.setChkNankyoku(is南極投票資格(投票資格コードlist, 投票資格リスト));
        }
        row.setTxtSenkyoShikaku(edit選挙資格(senkyoShurui, result.get選挙資格(), FlexibleDate.getNowDate()));
        row.setTxtSenkyoShikakuKubun(result.get選挙資格().getColumnValue());
        row.setTxtTohyokuCode(result.get投票区コード());
        row.setTxtMeiboTorokuYMD(result.get名簿登録年月日());
        row.getTxtMeiboTorokuYMDseireki().setValue(result.get名簿登録年月日西暦());
        row.setTxtMeiboTorokuJiyu(edit登録事由(senkyoShurui, result.get登録事由コード(), 投票資格リスト, FlexibleDate.getNowDate()));
        row.setTxtTorokuJiyuCode(result.get登録事由コード().getColumnValue());
        row.setTxtTorokuTeishiYMD(format年月日(result.get登録停止年月日(), 投票資格リスト));
        row.getTxtTorokuTeishiYMDseireki().setValue(result.get登録停止年月日西暦());
        row.setTxtTorokuTeishiJiyu(edit登録停止事由(result.get登録停止事由コード(), 投票資格リスト, result.get登録停止年月日西暦()));
        row.setTxtTorokuTeishiJiyuCode(result.get登録停止事由コード().getColumnValue());
        row.setTxtHyojiYMD(result.get表示年月日());
        row.getTxtHyojiYMDseireki().setValue(result.get表示年月日西暦());
        row.setTxtHyojiJiyu(edit表示事由(senkyoShurui, result.get表示事由コード(), 投票資格リスト, result.get表示年月日西暦()));
        row.setTxtHyojiJiyuCode(result.get表示事由コード().getColumnValue());
        row.setTxtMasshoYMD(result.get抹消年月日());
        row.getTxtMasshoYMDseireki().setValue(result.get抹消年月日西暦());
        row.setTxtMasshoJiyu(edit抹消事由(senkyoShurui, result.get抹消事由コード(), 投票資格リスト, FlexibleDate.getNowDate()));
        row.setTxtMasshoJiyuCode(result.get抹消事由コード().getColumnValue());
        row.setTxtHyojiShojoYMD(format年月日(result.get表示消除年月日(), 投票資格リスト));
        row.getTxtHyojiShojoYMDseireki().setValue(result.get表示消除年月日西暦());
        row.setTxtHyojiShojoYoteiYMD(format年月日(result.get表示消除予定年月日(), 投票資格リスト));
        row.getTxtHyojiShojoYoteiYMDseireki().setValue(result.get表示消除予定年月日西暦());
        row.setTxtKeikiShuryoYMD(format年月日(result.get刑期終了年月日(), 投票資格リスト));
        row.getTxtKeikiShuryoYMDseireki().setValue(result.get刑期終了年月日西暦());
        row.setTxtShinseiNo(edit申請番号(result.get申請番号(), 投票資格リスト));
        if (投票資格リスト.contains(在外)) {
            row.setChkNikeimochi(false);
        } else {
            row.setChkNikeimochi(result.isNikeimochiFlag());
        }
        return row;
    }

    private RString edit選挙資格(RString 選挙種類code, Code 選挙資格区分コード, FlexibleDate 基準日) {
        if (SenkyoShurui.憲法改正国民投票.getCode().equals(選挙種類code)) {
            return getコード名称(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        } else {
            return getコード名称(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        }
    }

    private RString edit表示事由(RString 選挙種類code, Code 表示事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (選挙種類code == SenkyoShurui.憲法改正国民投票.getCode()) {
            return getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), 表示事由コード, 基準日);
        } else {
            if (投票資格リスト.contains(在外)) {
                return getコード名称(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), 表示事由コード, 基準日);
            } else {
                return getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), 表示事由コード, 基準日);
            }
        }
    }

    private RString edit抹消事由(RString 選挙種類code, Code 抹消事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (選挙種類code == SenkyoShurui.憲法改正国民投票.getCode()) {
            return getコード名称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), 抹消事由コード, 基準日);
        } else {
            if (投票資格リスト.contains(在外)) {
                return getコード名称(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), 抹消事由コード, 基準日);
            } else {
                return getコード名称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), 抹消事由コード, 基準日);
            }
        }
    }

    private RString edit申請番号(int 申請番号, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return new RString(String.valueOf(申請番号));
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit登録事由(RString 選挙種類code, Code 登録事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (投票資格リスト.contains(在外)) {
            return RString.EMPTY;
        } else if (選挙種類code == SenkyoShurui.憲法改正国民投票.getCode()) {
            return getコード名称(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu(), 登録事由コード, 基準日);
        } else {
            return getコード名称(AFACodeShubetsu.登録事由コード.getCodeShubetsu(), 登録事由コード, 基準日);
        }
    }

    private RString edit登録停止事由(Code 登録停止事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (投票資格リスト.contains(在外)) {
            return RString.EMPTY;
        }
        return getコード名称(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), 登録停止事由コード, 基準日);
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード, FlexibleDate 基準日) {
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード, 基準日);
    }

    private boolean is郵便投票資格(List<Code> 投票資格種類コード, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return false;
        }
        return 投票資格種類コード.contains(new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()));
    }

    private boolean is洋上投票資格(List<Code> 投票資格種類コード, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return false;
        }
        return 投票資格種類コード.contains(new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()));
    }

    private boolean is南極投票資格(List<Code> 投票資格種類コード, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return false;
        }
        return 投票資格種類コード.contains(new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()));
    }

    private RString format年月日(RString 年月日, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return RString.EMPTY;
        } else if (!年月日.isNullOrEmpty()) {
            return 年月日;
        }
        return RString.EMPTY;
    }

    private FlexibleDate get生年月日() {
        int 選挙資格到達年齢_海区選挙 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_海区選挙, SubGyomuCode.AFA選挙本体).toString());
        return FlexibleDate.getNowDate().minusYear(選挙資格到達年齢_海区選挙);
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }
    }

    /**
     * 宛名共通検索条件表示制御
     *
     */
    public void set宛名共通検索条件表示制御() {
        div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().setRadGaikokujinKubun(含まないKEY);
        div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().setJuminShubetsuDefault(getCheckBoxJuminShubetsuStatus());
        div.getIdoSearchJoken().getCcdIdoSearchJukiJoho().setJuminJotaiDefault(getCheckBoxJuminJotaiStatus());
    }

    private AtenaFinderJuminShubetsuStatus getCheckBoxJuminShubetsuStatus() {
        StatusOfCheckBox jutonaiKojinStatus = StatusOfCheckBox.選択;
        StatusOfCheckBox jutogaiKojinStatus = StatusOfCheckBox.未選択;
        StatusOfCheckBox hojinStatus = StatusOfCheckBox.未選択;
        StatusOfCheckBox kyoyushaStatus = StatusOfCheckBox.未選択;
        return new AtenaFinderJuminShubetsuStatus(jutonaiKojinStatus, jutogaiKojinStatus, hojinStatus, kyoyushaStatus);
    }

    private AtenaFinderJuminJotaiStatus getCheckBoxJuminJotaiStatus() {
        StatusOfCheckBox juminStatus = StatusOfCheckBox.選択;
        StatusOfCheckBox jutogaiStatus = StatusOfCheckBox.未選択;
        StatusOfCheckBox tenshutushaStatus = StatusOfCheckBox.選択;
        StatusOfCheckBox shiboshaStatus = StatusOfCheckBox.未選択;
        StatusOfCheckBox shojoshaStatus = StatusOfCheckBox.未選択;
        return new AtenaFinderJuminJotaiStatus(juminStatus, jutogaiStatus, tenshutushaStatus, shiboshaStatus, shojoshaStatus);
    }
}
