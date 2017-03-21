/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.juminkensaku.JuminKensaku;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.juminkensaku.JuminKensakuMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.ISearchShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchJuminDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.dgSearchKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminJotaiStatus;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminShubetsuStatus;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.StatusOfCheckBox;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * SearchJuminに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class SearchJuminHandler {

    private static final RString 名称フォーカス = new RString("ccdSearchJukiJoho_txtAtenaMeisho_core");
    private static final RString 生年月日フォーカス = new RString("ccdSearchJukiJoho_txtSeinenGappi_core");
    private static final RString 投票区コードフォーカス = new RString("ccdSearchTohyoShikaku_ccdTohyokuCode_txtTohyokuCode_core");
    private static final RString 含まないKEY = new RString("含まない");
    private static final RString 在外 = new RString("在外");
//    private static final RString 有権者 = new RString("有権者");
//    private static final RString 表示者 = new RString("表示者");
//    private static final RString 抹消者 = new RString("抹消者");
//    private static final RString 公民権停止者 = new RString("公民権停止者");
//    private static final RString 一号資格者 = new RString("1号資格者");
//    private static final RString 二号資格者 = new RString("2号資格者");
//    private static final RString 郵便 = new RString("郵便");
//    private static final RString 船員 = new RString("船員");
//    private static final RString 南極 = new RString("南極");
//    private static final RString 請求 = new RString("請求");
//    private static final RString 交付 = new RString("交付");
//    private static final RString 受理 = new RString("受理");
//    private static final RString 返還 = new RString("返還");
//    private static final RString 棄権 = new RString("棄権");
//    private static final RString 期日前 = new RString("期日前");
//    private static final RString 当日 = new RString("当日");
//    private static final RString 受付拒否 = new RString("受付拒否");
//    private static final RString 仮投票 = new RString("仮投票");
    private static final int 空白埋めの２桁 = 2;
    private static final int 空白埋めの３桁 = 3;
    private static final int 空白埋めの６桁 = 6;
    private static final RString 横線 = new RString("-");
    private final SearchJuminDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SearchJuminDiv
     */
    public SearchJuminHandler(SearchJuminDiv div) {
        this.div = div;
    }

    /**
     * 初期フォーカスのメソッドです。
     *
     * @return フォーカス RString
     */
    public RString getFocusID() {
        if (AFAConfigKeysValue.検索画面_初期カーソル位置_生年月日.isEqual(ConfigKeysAFA.検索画面_初期カーソル位置)) {
            return 生年月日フォーカス;
        } else if (AFAConfigKeysValue.検索画面_初期カーソル位置_投票区コード.isEqual(ConfigKeysAFA.検索画面_初期カーソル位置)) {
            return 投票区コードフォーカス;
        } else {
            return 名称フォーカス;
        }
    }

    /**
     * SearchJokenパネルを初期化します。
     */
    public void set初期表示() {
        // 住基情報検索条件の初期化
        div.getSearchJoken().getCcdSearchJukiJoho().load(AtenaHelper.createSearchKeyForAtenaFinder());
        set宛名共通検索条件表示制御();

        //投票資格検索条件指定の初期化
        div.getSearchJoken().getCcdSearchTohyoShikaku().initialize(div.getCcdSenkyoShurui().getSelectedSenkyoShurui());
        clear投票状況検索条件パネル();
        RString 初期値 = BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, RDate.getNowDate(), SubGyomuCode.AFA選挙本体);
        div.getSearchJoken().getTxtMaxKensu().setValue(new Decimal(初期値.toString()));
        // 最近処理者履歴の初期化
        div.getSearchJoken().getCcdSearchSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));

        if (ResponseHolder.getMenuID().equals(AFAMenuId.AFAMND2010_定時登録.menuId())) {
            div.getSearchJoken().getSearchTohyoJokyo().setDisplayNone(true);
        }
    }

    private void set宛名共通検索条件表示制御() {
        IAtenaFinderDiv atenaFinderDiv = div.getSearchJoken().getCcdSearchJukiJoho();
        atenaFinderDiv.setRadGaikokujinKubun(含まないKEY);
        atenaFinderDiv.setJuminShubetsuDefault(getCheckBoxJuminShubetsuStatus());
        atenaFinderDiv.setJuminJotaiDefault(getCheckBoxJuminJotaiStatus());
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
        StatusOfCheckBox tenshutsushaStatus = StatusOfCheckBox.選択;
        StatusOfCheckBox shiboshaStatus = StatusOfCheckBox.未選択;
        StatusOfCheckBox shojoshaStatus = StatusOfCheckBox.未選択;
        return new AtenaFinderJuminJotaiStatus(juminStatus, jutogaiStatus, tenshutsushaStatus, shiboshaStatus, shojoshaStatus);
    }

    /**
     * 抄本照会（メニューIDがAFAMND2010、AFAMND2020、AFAMND2030、AFAMND2040、AFAMND2050）のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況1(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMND2010_定時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND2020_選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND2030_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMND2040_在外選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMND2050_海区漁業調整委員会委員選挙.menuId());
    }

    /**
     * メニューIDがAFAMNA1020、AFAMNB1030、AFAMNK1020、AFAMNG1040のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況2(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNA1020_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB1030_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNK1020_選挙人の投票区変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1040_投票人の投票区変更.menuId());
    }

    /**
     * 在外（メニューIDがAFAMNB3010、AFAMNG3010、AFAMNB3020、AFAMNG3020、AFAMNB3030、AFAMNG3030、AFAMNB3040、AFAMNG3040、AFAMNB3050、AFAMNG3050）のとき、trueを返します。
     *
     * @param menuID RString
     * @return boolean
     */
    public boolean isメニューID状況3(RString menuID) {
        return menuID.equals(AFAMenuId.AFAMNB3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || menuID.equals(AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId())
                || menuID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId());
    }

    /**
     * 選挙種類より、抄本を初期化します。
     *
     * @return boolean
     */
    public boolean is抄本名共有子Div正常に初期化する() {
        div.getCcdShohonNameList().initialize(div.getCcdSenkyoShurui().getSelectedSenkyoShurui(), Boolean.FALSE);
        if (div.getCcdShohonNameList().getShohonListSize() == 0) {
            div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            div.getCcdShohonNameList().click_chkKakoShohon();
            div.getCcdShohonNameList().initialize(div.getCcdSenkyoShurui().getSelectedSenkyoShurui(), Boolean.FALSE);
            if (div.getCcdShohonNameList().getShohonListSize() == 0) {
                return false;
            } else {
                div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().get一番近い過去抄本番号());
                return true;
            }
        } else {
            div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().get一番近い未来抄本番号());
            return true;
        }

    }

    /**
     * 検索結果状態になります。
     */
    public void change画面To検索結果状態() {
        div.getCcdShohonNameList().setDisabled(Boolean.TRUE);
        div.getSearchJoken().setDisabled(Boolean.TRUE);
        setDisabled検索条件指定パネル(true);
        setDisabled検索結果一覧パネル(false);
    }

    /**
     * 再検索状態になります。
     */
    public void change画面To再検索状態() {
        div.getCcdShohonNameList().setDisabled(Boolean.FALSE);
        div.getSearchJoken().setDisabled(Boolean.FALSE);
        setDisabled検索条件指定パネル(false);
        setDisabled検索結果一覧パネル(true);
    }

    private void setDisabled検索条件指定パネル(boolean isDisabled) {
        div.getSearchJoken().getCcdSearchJukiJoho().setDisabled(isDisabled);
        div.getSearchJoken().getCcdSearchTohyoShikaku().setDisabled(isDisabled);
        div.getSearchJoken().getSearchTohyoJokyo().setDisabled(isDisabled);
    }

    /**
     * 検索用パラメータを生成します。
     *
     * @return JuminKensakuMapperParameter
     */
    public JuminKensakuMapperParameter create検索用パラメータ() {
        ISearchShikakuDiv 投票資格Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
        IMeiboBangoDiv 名簿番号Div = div.getSearchJoken().getSearchTohyoJokyo().getCcdMeiboBango();
        SearchTohyoJokyoDiv 投票状況Div = div.getSearchJoken().getSearchTohyoJokyo();
        ShikibetsuCode 識別コード = ((AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho()).getTxtShikibetsuCodeSub().getDomain();

        div.getCcdShohonNameList().changeDdlShohon();
        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        if (RString.isNullOrEmpty(抄本番号)) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        SenkyoShurui 選挙種類 = div.getCcdSenkyoShurui().getSelectedSenkyoShurui();
        return new JuminKensakuMapperParameter(
                div.getCcdShohonNameList().getSelectedShohonNo(),
                new Code(SenkyoShurui.国政選挙_地方選挙.equals(選挙種類) ? SenkyoShurui.定時登録.getCode() : 選挙種類.getCode()),
                投票資格Div.get投票区コード(),
                edit選挙資格リスト(),
                edit投票資格リスト(),
                edit日付(投票資格Div.get名簿登録日From()),
                edit日付(投票資格Div.get名簿登録日To()),
                投票資格Div.get登録事由(),
                edit日付(投票資格Div.get登録停止日From()),
                edit日付(投票資格Div.get登録停止日To()),
                投票資格Div.get登録停止事由(),
                edit日付(投票資格Div.get抹消日From()),
                edit日付(投票資格Div.get抹消日To()),
                投票資格Div.get抹消事由(),
                edit日付(投票資格Div.get表示日From()),
                edit日付(投票資格Div.get表示日To()),
                投票資格Div.get表示事由(),
                edit日付(投票資格Div.get消除予定日From()),
                edit日付(投票資格Div.get消除予定日To()),
                edit日付(投票資格Div.get表示消除日From()),
                edit日付(投票資格Div.get表示消除日To()),
                edit日付(投票資格Div.get刑期終了日From()),
                edit日付(投票資格Div.get刑期終了日To()),
                名簿番号Div.get冊(),
                名簿番号Div.get頁(),
                名簿番号Div.get行(),
                edit投票状況リスト(),
                edit受付日(投票状況Div.getTxtUketsukeYMDRange().getFromValue()),
                edit受付日(投票状況Div.getTxtUketsukeYMDRange().getToValue()),
                投票状況Div.getTxtUketsukeTime().getFromValue(),
                投票状況Div.getTxtUketsukeTime().getToValue(),
                投票状況Div.getTxtUketsukeBnago().getValue(),
                投票状況Div.getCcdShisetsuCode().get施設コード(),
                div.getSearchJoken().getTxtMaxKensu().getValue().intValue(),
                識別コード,
                is在外(),
                div.getSearchJoken().getCcdSearchTohyoShikaku().is2刑持ち(),
                is宛名情報あり(),
                is選挙情報あり(),
                createSearchKey());
    }

    private IShikibetsuTaishoPSMSearchKey createSearchKey() {
        return div.getSearchJoken().getCcdSearchJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
    }

    private boolean is宛名情報あり() {
        AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho();
        return !RString.isNullOrEmpty(宛名検索Div.getTxtAtenaMeisho().getText())
                || !RString.isNullOrEmpty(宛名検索Div.getTxtSeinenGappi().getText())
                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode().getDomain().value())
                || !RString.isNullOrEmpty(((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName().getValue())
                || !宛名検索Div.getTxtShikibetsuCodeSub().getDomain().isEmpty()
                || !宛名検索Div.getTxtSetaiCodeSub().getDomain().isEmpty();
    }

    private boolean is選挙情報あり() {
        ISearchShikakuDiv 資格検索Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
        return !RString.isNullOrEmpty(資格検索Div.get投票区コード())
                || !資格検索Div.getChkSearchTohyoShikaku().getSelectedKeys().isEmpty();
    }

    private FlexibleDate edit日付(FlexibleDate 日付) {
        return 日付 == null ? FlexibleDate.EMPTY : 日付;
    }

    private FlexibleDate edit受付日(RDate 受付日) {
        return 受付日 == null ? FlexibleDate.EMPTY : new FlexibleDate(受付日.toDateString());
    }

    /**
     * 選挙資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit選挙資格リスト() {
        List<Code> 選挙資格s = new ArrayList<>();
        RString メニュー_ID = ResponseHolder.getMenuID();

        boolean is国民投票Or在外国民関連 = メニュー_ID.equals(AFAMenuId.AFAMNG1040_投票人の投票区変更.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG1060_帳票再発行.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG3010_名簿登録.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG3030_証明書再交付.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG3040_名簿抹消.menuId())
                || メニュー_ID.equals(AFAMenuId.AFAMNG3050_投票人名簿修正.menuId());

        List<RString> 選挙資格リスト = div.getSearchJoken().getCcdSearchTohyoShikaku().get選挙資格リスト();
        if (is国民投票Or在外国民関連) {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_1号資格.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者_1号資格.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者_2号資格.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者_2号資格.getKey()));
            }
        } else {
            if (選挙資格リスト.contains(SennkyoSikakuKubun.有権者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.有権者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.表示者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.表示者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.抹消者.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.抹消者.getKey()));
            }
            if (選挙資格リスト.contains(SennkyoSikakuKubun.公民権停止.getValue())) {
                選挙資格s.add(new Code(SennkyoSikakuKubun.公民権停止.getKey()));
            }
        }
        return 選挙資格s;
    }

    /**
     * 投票資格リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit投票資格リスト() {
        List<Code> 投票資格s = new ArrayList<>();
        List<RString> 投票資格リスト = div.getSearchJoken().getCcdSearchTohyoShikaku().get投票資格リスト();

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
     * 投票状況リスト編集のメソッドです。
     *
     * @return List
     */
    public List<Code> edit投票状況リスト() {
        List<Code> 投票状況s = new ArrayList<>();
        List<RString> 投票状況リスト = div.getSearchJoken().getSearchTohyoJokyo().getChkTohyoJokyo().getSelectedValues();

        if (投票状況リスト.contains(TohyoJokyo.請求.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.請求.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.交付.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.交付.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.受理.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.受理.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.返還.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.返還.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.棄権.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.棄権.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.期日前.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.期日前.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.当日.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.当日.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.受付拒否.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.受付拒否.getCode()));
        }
        if (投票状況リスト.contains(TohyoJokyo.仮投票.toRString())) {
            投票状況s.add(new Code(TohyoJokyo.仮投票.getCode()));
        }

        return 投票状況s;
    }

    /**
     * 在外の判定メソッドです。
     *
     * @return boolean
     */
    public boolean is在外() {
        List<RString> 投票資格リスト = div.getSearchJoken().getCcdSearchTohyoShikaku().get投票資格リスト();
        return 投票資格リスト.contains(在外);
    }

    /**
     * 各項目を初期状態にします。
     */
    public void clear投票状況検索条件パネル() {
        SearchTohyoJokyoDiv searchTohyoJokyoDiv = div.getSearchJoken().getSearchTohyoJokyo();
        searchTohyoJokyoDiv.getCcdMeiboBango().clear();
        searchTohyoJokyoDiv.getChkTohyoJokyo().getSelectedItems().clear();
        searchTohyoJokyoDiv.getTxtUketsukeYMDRange().clearFromValue();
        searchTohyoJokyoDiv.getTxtUketsukeYMDRange().clearToValue();
        searchTohyoJokyoDiv.getTxtUketsukeTime().clearFromValue();
        searchTohyoJokyoDiv.getTxtUketsukeTime().clearToValue();
        searchTohyoJokyoDiv.getDdlUketsukeBnago().setSelectedIndex(0);
        searchTohyoJokyoDiv.getTxtUketsukeBnago().clearValue();
        searchTohyoJokyoDiv.getCcdShisetsuCode().clear();
        searchTohyoJokyoDiv.getCcdShisetsuCode().initialize();
    }

    /**
     * 検索結果一覧パネルの活性制御メソッドです。
     *
     * @param isDisabled boolean
     */
    public void setDisabled検索結果一覧パネル(boolean isDisabled) {
        div.getSearchKekkaList().setDisabled(isDisabled);
    }

    /**
     * 検索結果一覧データグリッドをクリアします。
     */
    public void clear検索結果一覧データグリッド() {
        div.getSearchKekkaList().getDgSearchKekkaList().getDataSource().clear();
        div.getSearchKekkaList().getDgSearchKekkaList().getFilterList().clear();
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param result JuminKensaku
     * @param row dgSearchKekkaList_Row
     * @param senkyoShurui SenkyoShurui
     * @param 投票資格リスト List<RString>
     * @param 基準日 FlexibleDate
     * @return dgSearchKekkaList_Row
     */
    public dgSearchKekkaList_Row set検索結果To一覧(JuminKensaku result,
            dgSearchKekkaList_Row row,
            SenkyoShurui senkyoShurui,
            List<RString> 投票資格リスト,
            FlexibleDate 基準日) {
        row.setTxtShimei(result.get氏名());
        row.setTxtKanaShimei(result.getカナ氏名());
        row.setTxtSeinengappiYMD(result.get生年月日());
        row.setTxtSeinengappiYMDSeireki(result.get生年月日西暦());
        row.setTxtSeibetsu(result.get性別名称());
        row.setTxtJusho(result.getフォーマット後住所());
        row.setTxtJuminShubetsu(result.get住民状態名称());
        row.setTxtJuminShubetsuCode(result.get住民状態コード());
        row.setTxtShikibetsuCode(result.get識別コード());
        row.setTxtSenkyoShikaku(edit選挙資格(senkyoShurui, result.get選挙資格(), 基準日));
        row.setTxtSenkyoShikakuCode(result.get選挙資格().value());
        row.setTxtTohyokuCode(result.get投票区コード());
        row.setTxtMeiboBango(format名簿番号(result));
        row.setTxtMeiboTorokuYMD(result.get名簿登録年月日());
        row.setTxtMeiboTorokuYMDSeireki(result.get名簿登録年月日西暦());
        row.setTxtHyojiYMD(result.get表示年月日和暦());
        row.setTxtHyojiYMDSeireki(result.get表示年月日西暦());
        row.setTxtHyojiJiyu(edit表示事由(senkyoShurui, result.get表示事由コード(), 投票資格リスト, result.get表示年月日()));
        row.setTxtHyojiJiyuCode(result.get表示事由コード().value());
        row.setTxtMasshoYMD(result.get抹消年月日和暦());
        row.setTxtMasshoYMDSeireki(result.get抹消年月日西暦());
        row.setTxtMasshoJiyu(edit抹消事由(senkyoShurui, result.get抹消事由コード(), 投票資格リスト, result.get抹消年月日()));
        row.setTxtMasshoJiyuCode(result.get抹消事由コード().value());
        row.setTxtSetaiCode(result.get世帯コード());
        row.setTxtTohyoShikaku(getコード略称(AFACodeShubetsu.投票資格種類.getCodeShubetsu(), result.get投票資格種類コード(), 基準日));
        row.setTxtShinseiNo(edit申請番号(result.get申請番号(), 投票資格リスト));
        return row;
    }

    private RString format名簿番号(JuminKensaku result) {
        RString 冊 = result.get冊().padLeft(空白埋めの３桁);
        RString 頁 = new RStringBuilder().append(result.get頁()).toRString().padLeft(空白埋めの６桁);
        RString 行 = new RStringBuilder().append(result.get行()).toRString().padLeft(空白埋めの２桁);
        if (!AFAConfigKeysValue.抄本_冊区分管理_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 冊.concat(横線).concat(頁).concat(横線).concat(行);
        }
        return 頁.concat(横線).concat(行);
    }

    private RString edit選挙資格(SenkyoShurui 選挙種類, Code 選挙資格区分コード, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        } else {
            return getコード名称(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分コード, 基準日);
        }
    }

    private RString edit表示事由(SenkyoShurui 選挙種類, Code 表示事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), 表示事由コード, 基準日);
        } else {
            if (投票資格リスト.contains(在外)) {
                return getコード名称(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), 表示事由コード, 基準日);
            } else {
                return getコード名称(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), 表示事由コード, 基準日);
            }
        }
    }

    private RString edit抹消事由(SenkyoShurui 選挙種類, Code 抹消事由コード, List<RString> 投票資格リスト, FlexibleDate 基準日) {
        if (選挙種類 == SenkyoShurui.憲法改正国民投票) {
            return getコード名称(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), 抹消事由コード, 基準日);
        } else {
            if (投票資格リスト.contains(在外)) {
                return getコード名称(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), 抹消事由コード, 基準日);
            } else {
                return getコード名称(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), 抹消事由コード, 基準日);
            }
        }
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード, FlexibleDate 基準日) {
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード, 基準日);
    }

    private RString getコード略称(CodeShubetsu コード種別, Code コード, FlexibleDate 基準日) {
        return CodeMasterNoOption.getCodeRyakusho(コード種別, コード, 基準日);
    }

    private RString edit申請番号(int 申請番号, List<RString> 投票資格リスト) {
        if (投票資格リスト.contains(在外)) {
            return new RString(String.valueOf(申請番号));
        } else {
            return RString.EMPTY;
        }
    }
}
