/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.contexts.HojoshaNyuryokuContext;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.TohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialogModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.FuzaishaTohyoGamen;
import jp.co.ndensan.reams.af.afa.definition.core.FuzaishaTohyoGamen.FuzaishaTohyoJokyoArea;
import jp.co.ndensan.reams.af.afa.definition.core.FuzaishaTohyoGamen.FuzaishaTohyoSearchArea;
import jp.co.ndensan.reams.af.afa.definition.core.FuzaishaTohyoGamen.FuzaishaTohyoSenkyoninArea;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuState;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.UketsukeNoShisetsuSetei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.SenkyoninMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.TohyoJokyoMybatisParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJohoSearchDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJuriJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaKofuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaSeikyuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaSenkyoninSearchDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaSochiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaUketoriJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.dgFuzaishaSenkyoninSearch_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.dgFuzaishaTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo.KijitsumaeTohyoManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.fuzaishatohyo.SenkyoninFinder;
import jp.co.ndensan.reams.af.afa.service.fuzaishatohyo.TohyojokyoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME2010 不在者投票のhandler
 *
 * @reamsid_L AF-0080-010 lit
 */
public class FuzaishaTohyoHandler {

    private final FuzaishaTohyoDiv mainPanel;
    private final FuzaishaJohoSearchDiv fuzaishaJohoSearchPanel;
    private final FuzaishaSenkyoninSearchDiv fuzaishaSenkyoninSearchPanel;
    private final FuzaishaTohyoJokyoDiv fuzaishaTohyoJokyoPanel;
    private static final int 受付番号 = -1;

    private static final RTime DEFAULT時間 = new RTime(new RString("00:00"));

    /**
     * ボタンEnum
     */
    public enum GamenButton {

        /**
         * 選挙人を選択する
         */
        選挙人を選択する(new RString("btnFuzaishaSearch")),
        /**
         * 入場券バーコード
         */
        入場券バーコード(new RString("ccdFuzaishaBarCode")),
        /**
         * 選挙人を検索する
         */
        選挙人を検索する(new RString("btnSearchSimple")),
        /**
         * 投票情報を入力する
         */
        投票情報を入力する(new RString("btnFuzaishaInput")),
        /**
         * 投票を受け付ける
         */
        投票を受け付ける(new RString("btnUpdate")),
        /**
         * 選挙人選択に戻る
         */
        選挙人選択に戻る(new RString("btnReturnSenkyonin")),
        /**
         * 初期表示に戻る
         */
        初期表示に戻る(new RString("btnReturnShoki"));

        private final RString key;

        GamenButton(RString key) {
            this.key = key;
        }

        /**
         * keyを返す。
         *
         * @return Key
         */
        public RString getKey() {
            return this.key;
        }

    }

    /**
     * 状態Enum
     */
    private enum GamenState {

        /**
         * 初期表示
         */
        状態１(new RString("初期表示")),
        /**
         * 選挙人検索
         */
        状態２(new RString("選挙人検索")),
        /**
         * 投票状況入力
         */
        状態３(new RString("投票状況入力"));

        private final RString key;

        GamenState(RString key) {
            this.key = key;
        }

        RString getKey() {
            return this.key;
        }

    }

    /**
     * コンストラクタです。
     *
     * @param mainPanel 不在者投票Div
     */
    public FuzaishaTohyoHandler(FuzaishaTohyoDiv mainPanel) {
        this.mainPanel = mainPanel;
        this.fuzaishaJohoSearchPanel = mainPanel.getFuzaishaJohoSearch();
        this.fuzaishaSenkyoninSearchPanel = mainPanel.getFuzaishaSenkyoninSearch();
        this.fuzaishaTohyoJokyoPanel = mainPanel.getFuzaishaTohyoJokyo();
    }

    /**
     * 画面初期化。
     *
     * @return 抄本があるかどうか
     */
    public boolean initialize() {
        set画面起動状態();
        if (!FuzaishaJohoSearchHandler.initialize(fuzaishaJohoSearchPanel)) {
            return false;
        }
        FuzaishaSenkyoninSearchHandler.clearThisPanel(fuzaishaSenkyoninSearchPanel);
        FuzaishaTohyoJokyoHandler.clearThisPanel(fuzaishaTohyoJokyoPanel);
        setHiddenInput();

        editDisplayMode(GamenState.状態１);
        setGamenData(ViewStateKeys.不在者投票_検索エリア);
        return true;
    }

    /**
     * 条件エリアのデータを設定する。
     */
    public void changeShohonName() {
        fuzaishaJohoSearchPanel.getCcdShohonNameList().changeDdlShohon();
        setHiddenInput();
    }

    /**
     * 「選挙人を選択する」ボタンのイベントメソッドです。
     */
    public void setSenkyoninData() {
        FuzaishaSenkyoninSearchHandler.initialize(fuzaishaSenkyoninSearchPanel);
        FuzaishaSenkyoninSearchHandler.setData(fuzaishaSenkyoninSearchPanel,
                fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo(),
                fuzaishaJohoSearchPanel.getCcdShisetsuCode().get施設コード());
        fuzaishaSenkyoninSearchPanel.setDisplayNone(false);
        fuzaishaSenkyoninSearchPanel.setIsOpen(true);
        editDisplayMode(GamenState.状態２);
        setGamenData(ViewStateKeys.不在者投票_選挙人エリア);
    }

    /**
     * 「選挙人を検索する」ボタン或は「入場券バーコード」ボタンのイベントメソッドです。
     *
     * @param 選挙人リスト List<SenkyoninSearchResult>
     */
    public void addSenkyoninData(List<SenkyoninSearchResult> 選挙人リスト) {
        FuzaishaSenkyoninSearchHandler.addData(
                fuzaishaSenkyoninSearchPanel, 選挙人リスト);
    }

    /**
     * 選挙人リストを取得する。
     *
     * @return 選挙人リスト
     */
    public List<SenkyoninSearchResult> get選挙人リスト() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        SenkyoninMybatisParameter param = new SenkyoninMybatisParameter(
                is受理(), get抄本番号(),
                get識別コードリスト(), RString.EMPTY, key.getPSM検索キー());
        return SenkyoninFinder.createInstance().getSenkyoninListByShikibetsuCode(param);
    }

    /**
     * 選挙情報リストを取得する。
     *
     * @return 選挙情報リスト
     */
    public List<SenkyoninSearchResult> get選挙情報リスト() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        SenkyoninMybatisParameter param = new SenkyoninMybatisParameter(
                is受理(), get抄本番号(),
                get識別コードリスト(), RString.EMPTY, key.getPSM検索キー());
        return SenkyoninFinder.createInstance().getSenkyoJoho(param);
    }

    /**
     * 選挙人gridの「削除」ボタンのイベントメソッドです。
     */
    public void deleteSenkyoninData() {
        FuzaishaSenkyoninSearchHandler.deleteData(fuzaishaSenkyoninSearchPanel);
    }

    /**
     * 「初期表示に戻る」ボタンのイベントメソッドです。
     */
    public void clear() {
        clearTohyouData();
        clearSenkyoninData(true);
        clearoSearchJoho();
        FuzaishaJohoSearchHandler.initialize(fuzaishaJohoSearchPanel);
        editDisplayMode(GamenState.状態１);
    }

    /**
     * 選挙人の初期値変化かどうか
     *
     * @return 選挙人の初期値変化かどうか。
     */
    public boolean isSenkyoninChange() {
        FuzaishaTohyoGamen 画面データ = getGamenData();
        FuzaishaTohyoGamen 保存用データ = ViewState.getData(ViewStateKeys.不在者投票, FuzaishaTohyoGamen.class);
        return !画面データ.isEqual選挙人(保存用データ);
    }

    /**
     * 投票状況の初期値変化かどうか
     *
     * @return 投票状況の初期値変化かどうか。
     */
    public boolean isTohyoJokyoChange() {
        FuzaishaTohyoGamen 画面データ = getGamenData();
        FuzaishaTohyoGamen 保存用データ = ViewState.getData(ViewStateKeys.不在者投票, FuzaishaTohyoGamen.class);
        return !画面データ.isEqual投票状況(保存用データ);
    }

    /**
     * 「選挙人選択に戻る」ボタンのイベントメソッドです。
     */
    public void clearSenkyonin() {
        clearTohyouData();
        clearSenkyoninData(false);
        setSenkyoninData();
        editDisplayMode(GamenState.状態２);
        fuzaishaSenkyoninSearchPanel.setIsOpen(true);
    }

    /**
     * 「投票情報を入力する」ボタンのイベントメソッドです。
     *
     * @param 投票情報リスト List<TohyoJokyoSearchResult>
     */
    public void setTohyouData(List<TohyoJokyoSearchResult> 投票情報リスト) {
        SenkyoShurui 選挙種類 = fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedSenkyoShurui();
        FuzaishaTohyoJokyoHandler.initialize(fuzaishaTohyoJokyoPanel);
        FuzaishaTohyoJokyoHandler.setData(fuzaishaTohyoJokyoPanel, 投票情報リスト, 選挙種類);
        fuzaishaTohyoJokyoPanel.setDisplayNone(false);
        fuzaishaSenkyoninSearchPanel.setIsOpen(false);
        editDisplayMode(GamenState.状態３);
        setGamenData(ViewStateKeys.不在者投票_投票状況エリア);
    }

    /**
     * 投票情報リストを取得する。
     *
     * @return 投票情報リスト
     */
    public List<TohyoJokyoSearchResult> get投票情報リスト() {
        List<dgFuzaishaSenkyoninSearch_Row> taishoshaList = fuzaishaSenkyoninSearchPanel.getDgFuzaishaSenkyoninSearch().getDataSource();
        List<ShikibetsuCode> codeList = new ArrayList<>();
        for (dgFuzaishaSenkyoninSearch_Row row : taishoshaList) {
            codeList.add(new ShikibetsuCode(row.getTxtShikibetsuCode()));
        }
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        TohyoJokyoMybatisParameter param = new TohyoJokyoMybatisParameter(get抄本番号(), codeList, key.getPSM検索キー());
        return TohyojokyoFinder.createInstance().getTohyoJokyoList(param);
    }

    /**
     * 投票状況ラジオボタンを選択時のイベントメソッドです。
     */
    public void changeRadTohyoJokyo() {
        FuzaishaTohyoJokyoHandler.changeRadTohyoJokyo(fuzaishaTohyoJokyoPanel);
        fuzaishaSenkyoninSearchPanel.setIsOpen(false);
    }

    /**
     * 「投票を受け付ける」ボタンのイベントメソッドです。
     *
     * @param 投票状況リスト List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo>
     */
    public void save(List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 投票状況リスト) {
        List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 削除用投票状況リスト = new ArrayList<>();
        List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 更新用投票状況リスト = new ArrayList<>();
        set保存用投票状況リスト(投票状況リスト, 削除用投票状況リスト, 更新用投票状況リスト);

        List<ShikibetsuCode> 更新対象リスト = TohyoJokyoManager.createInstance().deleteUpdate投票状況(削除用投票状況リスト, 更新用投票状況リスト);
        List<PersonalData> personalDataList = new ArrayList<>();
        for (ShikibetsuCode 更新対象 : 更新対象リスト) {
            personalDataList.add(PersonalData.of(更新対象));
        }
        AccessLogger.log(AccessLogType.更新, personalDataList);
    }

    private void clearoSearchJoho() {
        FuzaishaJohoSearchHandler.clearThisPanel(fuzaishaJohoSearchPanel);
    }

    private void clearSenkyoninData(boolean dispFlg) {
        if (!fuzaishaSenkyoninSearchPanel.isDisplayNone()) {
            FuzaishaSenkyoninSearchHandler.clearThisPanel(fuzaishaSenkyoninSearchPanel);
            fuzaishaSenkyoninSearchPanel.setDisplayNone(dispFlg);
        }
    }

    private void clearTohyouData() {
        if (!fuzaishaTohyoJokyoPanel.isDisplayNone()) {
            FuzaishaTohyoJokyoHandler.clearThisPanel(fuzaishaTohyoJokyoPanel);
            fuzaishaTohyoJokyoPanel.setDisplayNone(true);
        }
    }

    private boolean is受理() {
        return ViewState.getメニューID().equals(AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId());
    }

    private ShohonNo get抄本番号() {
        return new ShohonNo(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo());
    }

    private List<RString> get識別コードリスト() {
        List<RString> 識別コードリスト = new ArrayList<>();
        if (!fuzaishaSenkyoninSearchPanel.getTxtHdnShikibetsuCodeList().isEmpty()) {
            識別コードリスト = fuzaishaSenkyoninSearchPanel.getTxtHdnShikibetsuCodeList().split(RString.HALF_SPACE.toString());
        }
        return 識別コードリスト;
    }

    private int get受付番号() {
        if (-1 != 受付番号) {
            return 受付番号 + 1;
        }

        ShohonNo 抄本番号 = new ShohonNo(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo());
        Code 施設種別 = new Code("00");
        RString コード = new RString("0000");
        Code 期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.不在者投票.value());
        RString 受付番号_施設 = BusinessConfig.get(ConfigKeysAFA.受付番号_施設設定, SubGyomuCode.AFA選挙本体);
        RString 施設コード = fuzaishaJohoSearchPanel.getCcdShisetsuCode().get施設コード();

        if (UketsukeNoShisetsuSetei.施設コード毎連番.getCode().equals(受付番号_施設)) {
            コード = 施設コード;
        } else if (UketsukeNoShisetsuSetei.施設種別毎連番.getCode().equals(受付番号_施設)) {
            施設種別 = ShisetsuManager.createInstance().get施設By施設コード(施設コード).get施設種別();
        } else if (UketsukeNoShisetsuSetei.施設管理なし.getCode().equals(受付番号_施設)) {
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.通番.value());
        }

        RString 受付番号2 = KijitsumaeTohyoManager.createInstance().getUketsukeNo(抄本番号, 施設種別, コード, 期日前不在者区分);
        return 受付番号2.isEmpty() ? 1 : Integer.parseInt(受付番号2.toString()) + 1;
    }

    private void setHiddenInput() {
        RString shohonNo = fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo();
        SenkyoShurui senkyoShurui = fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedSenkyoShurui();

        FuzaishaSenkyoninSearchHandler.setHiddenInput(fuzaishaSenkyoninSearchPanel,
                shohonNo, senkyoShurui, fuzaishaTohyoJokyoPanel.getTxtHdnKidoMode());
        FuzaishaTohyoJokyoHandler.setHiddenInput(fuzaishaTohyoJokyoPanel, shohonNo, senkyoShurui);
    }

    private void set画面起動状態() {
        RString menuID = ResponseHolder.getMenuID();
        // TODO. for test
//        menuID = AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId();
        ViewState.setメニューID(menuID);

        if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2010_不在者投票用紙請求.menuId())) {
            fuzaishaTohyoJokyoPanel.setTxtHdnKidoMode(TohyoJokyo.請求.toRString());
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId())) {
            fuzaishaTohyoJokyoPanel.setTxtHdnKidoMode(TohyoJokyo.交付.toRString());
        } else if (menuID.equalsIgnoreCase("受取")) {
            fuzaishaTohyoJokyoPanel.setTxtHdnKidoMode(TohyoJokyo.受取.toRString());
        } else if (menuID.equalsIgnoreCase(AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId())) {
            fuzaishaTohyoJokyoPanel.setTxtHdnKidoMode(TohyoJokyo.受理.toRString());
        } else if (menuID.equalsIgnoreCase("送致")) {
            fuzaishaTohyoJokyoPanel.setTxtHdnKidoMode(TohyoJokyo.送致.toRString());
        }
    }

    private void editDisplayMode(GamenState 状態) {
        if (状態.equals(GamenState.状態１)) {
            fuzaishaJohoSearchPanel.setDisplayNone(false);
            fuzaishaJohoSearchPanel.setDisabled(false);
            fuzaishaSenkyoninSearchPanel.setDisplayNone(true);
            fuzaishaTohyoJokyoPanel.setDisplayNone(true);

            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.投票を受け付ける.getKey(), true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.選挙人選択に戻る.getKey(), true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.初期表示に戻る.getKey(), true);

        } else if (状態.equals(GamenState.状態２)) {
            fuzaishaJohoSearchPanel.setDisplayNone(false);
            fuzaishaJohoSearchPanel.setDisabled(true);
            fuzaishaSenkyoninSearchPanel.setDisplayNone(false);
            fuzaishaSenkyoninSearchPanel.setDisabled(false);
            fuzaishaTohyoJokyoPanel.setDisplayNone(true);

            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.投票を受け付ける.getKey(), true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.選挙人選択に戻る.getKey(), true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.初期表示に戻る.getKey(), false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(GamenButton.初期表示に戻る.getKey(), false);

        } else if (状態.equals(GamenState.状態３)) {
            fuzaishaJohoSearchPanel.setDisplayNone(false);
            fuzaishaJohoSearchPanel.setDisabled(true);
            fuzaishaSenkyoninSearchPanel.setDisplayNone(false);
            fuzaishaSenkyoninSearchPanel.setDisabled(true);
            fuzaishaTohyoJokyoPanel.setDisplayNone(false);
            fuzaishaTohyoJokyoPanel.setDisabled(false);
            fuzaishaTohyoJokyoPanel.getDgFuzaishaTohyoJokyo().getGridSetting().setMultiSelectable(Boolean.TRUE);
            fuzaishaTohyoJokyoPanel.getDgFuzaishaTohyoJokyo().setDisplayNone(Boolean.FALSE);

            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.投票を受け付ける.getKey(), false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.選挙人選択に戻る.getKey(), false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(GamenButton.初期表示に戻る.getKey(), false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(GamenButton.投票を受け付ける.getKey(), false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(GamenButton.選挙人選択に戻る.getKey(), false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(GamenButton.初期表示に戻る.getKey(), false);
        }

        if (状態.equals(GamenState.状態１)) {
            return;
        }

        if (fuzaishaTohyoJokyoPanel.getTxtHdnKidoMode().equals(TohyoJokyo.交付.toRString())) {
            RString 不在者_請求処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);
            if (不在者_請求処理制御.equals(SeikyuState.個別処理する.getKey())) {
                fuzaishaSenkyoninSearchPanel.getCcdFuzaishaBarCode().setDisplayNone(true);
                fuzaishaSenkyoninSearchPanel.getBtnSearchSimple().setDisplayNone(true);
            }
        } else if (fuzaishaTohyoJokyoPanel.getTxtHdnKidoMode().equals(TohyoJokyo.受理.toRString())) {
            fuzaishaSenkyoninSearchPanel.getLblWarningMessageJuri().setDisplayNone(false);
        }
    }

    private jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo
            getTohyoJokyoFromList(List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 投票状況リスト,
                    ShohonNo 抄本番号, SenkyoNo 選挙番号, ShikibetsuCode 識別コード) {
        if (null == 投票状況リスト || 投票状況リスト.isEmpty()
                || null == 抄本番号 || null == 選挙番号 || null == 識別コード) {
            return null;
        }

        for (jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo 投票状況 : 投票状況リスト) {
            if (投票状況.get抄本番号().equals(抄本番号)
                    && 投票状況.get選挙番号().equals(選挙番号)
                    && 投票状況.get識別コード().equals(識別コード)) {
                return 投票状況;
            }
        }

        return null;
    }

    private void set保存用投票状況リスト(
            List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 投票状況リスト,
            List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 削除用投票状況リスト,
            List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> 更新用投票状況リスト) {
        RString 不在者_請求処理制御 = BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体);
        RString kidoMode = fuzaishaTohyoJokyoPanel.getTxtHdnKidoMode();
        TohyoJokyo tohyoJokyo = TohyoJokyo.toValue(fuzaishaTohyoJokyoPanel.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey());
        ShohonNo 抄本番号 = new ShohonNo(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo());

        for (dgFuzaishaTohyoJokyo_Row row : fuzaishaTohyoJokyoPanel.getDgFuzaishaTohyoJokyo().getSelectedItems()) {
            ShikibetsuCode 識別コード = new ShikibetsuCode(row.getTxtShikibetsuCode());
            SenkyoNo 選挙番号 = new SenkyoNo(row.getTxtSenkyoNo());

            jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo 投票状況
                    = getTohyoJokyoFromList(投票状況リスト, 抄本番号, 選挙番号, 識別コード);

            if (tohyoJokyo.equals(TohyoJokyo.取消)
                    && (kidoMode.equals(TohyoJokyo.請求.toRString())
                    || (kidoMode.equals(TohyoJokyo.交付.toRString())
                    && 不在者_請求処理制御.equals(SeikyuState.個別処理しない.getKey()))
                    || (kidoMode.equals(TohyoJokyo.受理.toRString()) && row.getChkSenin()))) {
                削除用投票状況リスト.add(投票状況);
                continue;
            }

            更新用投票状況リスト.add(get更新用投票状況(row, 投票状況.createBuilderForEdit()));
        }
    }

    private jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo get更新用投票状況(
            dgFuzaishaTohyoJokyo_Row row, TohyoJokyoBuilder builder) {
        RString kidoMode = fuzaishaTohyoJokyoPanel.getTxtHdnKidoMode();

        // 更新必要項目のDEFAULT値を設定
        builder.set受取年月日(FlexibleDate.EMPTY);
        builder.set受理年月日(FlexibleDate.EMPTY);
        builder.set受理時刻(DEFAULT時間);
        builder.set受理方法(Code.EMPTY);
        builder.set受理施設種別(Code.EMPTY);
        builder.set棄権年月日(FlexibleDate.EMPTY);
        builder.set返還年月日(FlexibleDate.EMPTY);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        builder.set拒否事由(RString.EMPTY);
        builder.set送致済フラグ(false);
        builder.set期日前不在者区分(new Code(KijitsumaeFuzaishaKubun.不在者投票.value()));
        builder.set更新端末ID(RString.EMPTY);

        if (kidoMode.equals(TohyoJokyo.請求.toRString())) {
            set更新用投票状況請求(builder);
        } else if (kidoMode.equals(TohyoJokyo.交付.toRString())) {
            set更新用投票状況交付(row, builder);
        } else if (kidoMode.equals(TohyoJokyo.受理.toRString())) {
            set更新用投票状況受理(row, builder);
        }
        return builder.build();
    }

    private void set更新用投票状況請求(TohyoJokyoBuilder builder) {
        FuzaishaSeikyuJohoDiv 請求Div = fuzaishaTohyoJokyoPanel.getFuzaishaSeikyuJoho();
        Code 投票事由コード = Code.EMPTY;
        Code 請求方法 = Code.EMPTY;
        FlexibleDate 請求年月日 = FlexibleDate.EMPTY;
        if (!請求Div.isDisplayNone()) {
            投票事由コード = 請求Div.getCcdFuzaishaTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode();
            請求年月日 = new FlexibleDate(請求Div.getTxtSeikyuYMD().getValue().toDateString());
            請求方法 = new Code(請求Div.getRadSeikyusha().getSelectedKey());
        }

        builder.set証明書出力フラグ(false);
        builder.set投票状況(new Code(TohyoJokyo.請求.getCode()));
        builder.set投票事由コード(投票事由コード);
        builder.set請求年月日(請求年月日);
        builder.set請求方法(請求方法);
        builder.set受付番号(0);
        builder.set交付年月日(FlexibleDate.EMPTY);
        builder.set交付時刻(DEFAULT時間);
        builder.set交付方法(Code.EMPTY);
        builder.set施設コード(RString.EMPTY);
        builder.set点字フラグ(false);
        builder.set代理投票有フラグ(false);
    }

    private void set更新用投票状況交付(dgFuzaishaTohyoJokyo_Row row, TohyoJokyoBuilder builder) {
        TohyoJokyo tohyoJokyo = TohyoJokyo.toValue(fuzaishaTohyoJokyoPanel.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey());
        RString 施設コード = mainPanel.getFuzaishaJohoSearch().getCcdShisetsuCode().get施設コード();
        FuzaishaSeikyuJohoDiv 請求Div = fuzaishaTohyoJokyoPanel.getFuzaishaSeikyuJoho();
        FuzaishaKofuJohoDiv 交付Div = fuzaishaTohyoJokyoPanel.getFuzaishaKofuJoho();
        Code 投票事由コード = Code.EMPTY;
        FlexibleDate 請求年月日 = FlexibleDate.EMPTY;
        FlexibleDate 交付年月日 = FlexibleDate.EMPTY;
        Code 請求方法 = Code.EMPTY;
        Code 交付方法 = Code.EMPTY;
        if (!請求Div.isDisplayNone()) {
            投票事由コード = 請求Div.getCcdFuzaishaTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode();
            請求年月日 = new FlexibleDate(請求Div.getTxtSeikyuYMD().getValue().toDateString());
            請求方法 = new Code(請求Div.getRadSeikyusha().getSelectedKey());
        }
        if (!交付Div.isDisplayNone()) {
            交付年月日 = new FlexibleDate(交付Div.getTxtKofuYMD().getValue().toDateString());
            交付方法 = new Code(交付Div.getRadKofuHoho().getSelectedKey());
        }

        builder.set点字フラグ(交付Div.getChkTenjiYoshi().isAllSelected());
        builder.set証明書出力フラグ(交付Div.getChkShomeishoHakko().isAllSelected());
        builder.set代理投票有フラグ(false);
        if (tohyoJokyo.equals(TohyoJokyo.交付)) {
            builder.set投票状況(new Code(TohyoJokyo.交付.getCode()));
            builder.set投票事由コード(投票事由コード);
            builder.set請求年月日(請求年月日);
            builder.set請求方法(請求方法);
            if (!row.getChkTohyojokyo()
                    && BusinessConfig.get(ConfigKeysAFA.不在者_請求処理制御, SubGyomuCode.AFA選挙本体).equals(SeikyuState.個別処理しない.getKey())) {
                builder.set受付番号(get受付番号());
            }
            if (null == row.getTxtKofuYMD() || !row.getTxtKofuYMD().getValue().equals(交付年月日)) {
                builder.set交付年月日(交付年月日);
                builder.set交付時刻(RTime.of(RDate.getNowTime().getHour(), RDate.getNowTime().getSecond()));
            }
            builder.set交付方法(交付方法);
            builder.set施設コード(施設コード);

        } else if (tohyoJokyo.equals(TohyoJokyo.取消)) {
            builder.set投票状況(new Code(TohyoJokyo.請求.getCode()));
            builder.set投票事由コード(投票事由コード);
            builder.set請求年月日(請求年月日);
            builder.set請求方法(請求方法);
            builder.set受付番号(0);
            builder.set交付年月日(FlexibleDate.EMPTY);
            builder.set交付時刻(DEFAULT時間);
            builder.set交付方法(Code.EMPTY);
            builder.set施設コード(RString.EMPTY);
        }

    }

    private void set更新用投票状況受理(dgFuzaishaTohyoJokyo_Row row, TohyoJokyoBuilder builder) {
        TohyoJokyo tohyoJokyo = TohyoJokyo.toValue(fuzaishaTohyoJokyoPanel.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey());
        FuzaishaSeikyuJohoDiv 請求Div = fuzaishaTohyoJokyoPanel.getFuzaishaSeikyuJoho();
        FuzaishaJuriJohoDiv 受理Div = fuzaishaTohyoJokyoPanel.getFuzaishaJuriJoho();
        FuzaishaUketoriJohoDiv 受取Div = fuzaishaTohyoJokyoPanel.getFuzaishaUketoriJoho();
        Code 投票事由コード = Code.EMPTY;
        FlexibleDate 受理年月日 = FlexibleDate.EMPTY;
        FlexibleDate 受取年月日 = FlexibleDate.EMPTY;
        Code 受理方法 = Code.EMPTY;
        if (!請求Div.isDisplayNone()) {
            投票事由コード = 請求Div.getCcdFuzaishaTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode();
        }
        if (!受理Div.isDisplayNone()) {
            受理年月日 = new FlexibleDate(受理Div.getTxtJuriYMD().getValue().toDateString());
            受理方法 = new Code(受理Div.getRadJuriHoho().getSelectedKey());
        }
        if (!受取Div.isDisplayNone() && null != 受取Div.getTxtUketoriYMD().getValue()) {
            受取年月日 = new FlexibleDate(受取Div.getTxtUketoriYMD().getValue().toDateString());
        }

        if (tohyoJokyo.equals(TohyoJokyo.受理)
                || tohyoJokyo.equals(TohyoJokyo.棄権)
                || tohyoJokyo.equals(TohyoJokyo.返還)
                || tohyoJokyo.equals(TohyoJokyo.受付拒否)) {
            builder.set投票状況(new Code(tohyoJokyo.getCode()));
            if (受理Div.getChkKariTohyo().isAllSelected()) {
                builder.set投票状況(new Code(TohyoJokyo.仮投票.getCode()));
            }

            // 洋上投票資格者の時、登録
            if (row.getChkSenin()) {
                builder.set投票事由コード(投票事由コード);
                builder.set受付番号(null);
                builder.set請求年月日(FlexibleDate.EMPTY);
                builder.set請求方法(Code.EMPTY);
                builder.set交付年月日(FlexibleDate.EMPTY);
                builder.set交付時刻(DEFAULT時間);
                builder.set交付方法(Code.EMPTY);
                builder.set施設コード(RString.EMPTY);
                builder.set点字フラグ(false);
                builder.set証明書出力フラグ(false);
            }

            builder.set受取年月日(受取年月日);
            builder.set代理投票有フラグ(false);

            if (tohyoJokyo.equals(TohyoJokyo.受理)
                    || 受理Div.getChkKariTohyo().isAllSelected()) {
                builder.set受理年月日(受理年月日);
                builder.set受理時刻(受理Div.getTxtJuriTime().getValue());
                builder.set受理方法(受理方法);
                builder.set受理施設種別(new Code(row.getChkSenin() ? ShisetsuShubetsu.船舶.getCode() : row.getTxtShubetsuCode()));
            }

            if (tohyoJokyo.equals(TohyoJokyo.受理)) {
                HojoshaNyuryokuContext 補助者 = 受理Div.getCcdFuzaishaDairiTohyo().getHojoshaNyuryokuContext();
                builder.set代理投票有フラグ(補助者.isDairiTohyoAri());
                builder.set補助者識別コード1(補助者.getHojosha1ShikibetsuCode());
                builder.set補助者氏名1(new AtenaMeisho(補助者.getHojosha1Name()));
                builder.set補助者識別コード2(補助者.getHojosha2ShikibetsuCode());
                builder.set補助者氏名2(new AtenaMeisho(補助者.getHojosha2Name()));
            }

            if (tohyoJokyo.equals(TohyoJokyo.棄権)) {
                builder.set棄権年月日(受理年月日);
            } else if (tohyoJokyo.equals(TohyoJokyo.返還)) {
                builder.set返還年月日(受理年月日);
            } else if (tohyoJokyo.equals(TohyoJokyo.受付拒否)) {
                builder.set拒否事由(受理Div.getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
            }

        } else if (tohyoJokyo.equals(TohyoJokyo.取消)) {
            builder.set投票状況(new Code(TohyoJokyo.交付.getCode()));
        }
    }

    /**
     * 不在者投票情報の帳票作成用データを取得します。
     *
     * @return LabelSealSelectDialogModel
     */
    public LabelSealSelectDialogModel get帳票データ() {
        ShohonNo 抄本番号 = new ShohonNo(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo());
        List<RString> 識別コードリスト = new ArrayList<>();
        for (dgFuzaishaTohyoJokyo_Row row : fuzaishaTohyoJokyoPanel.getDgFuzaishaTohyoJokyo().getSelectedItems()) {
            識別コードリスト.add(row.getTxtShikibetsuCode());
        }
        Code senkyoShurui = new Code(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        List<KijitsumaeTohyoChohyoData> 帳票データ
                = KijitsumaeTohyoManager.createInstance().getFuzaishaTohyoChohyoData(senkyoShurui, 抄本番号, 識別コードリスト);

        LabelSealSelectDialogModel model = new LabelSealSelectDialogModel();
        model.setKijitsumaeFuzaishaKubun(KijitsumaeFuzaishaKubun.不在者投票);
        model.setShohonNo(抄本番号);
        model.setShoriTaishoJohoList(帳票データ);
        model.setChkShomeishoHakko(fuzaishaTohyoJokyoPanel.getFuzaishaKofuJoho().getChkShomeishoHakko().isAllSelected());

        return model;
    }

    private void setGamenData(Enum key) {
        FuzaishaTohyoGamen gamenData = new FuzaishaTohyoGamen();
        if (key.equals(ViewStateKeys.不在者投票_検索エリア)) {
            gamenData.set不在者投票検索エリア(get不在者投票検索データ());
        } else if (key.equals(ViewStateKeys.不在者投票_選挙人エリア)) {
            gamenData = ViewState.getData(ViewStateKeys.不在者投票, FuzaishaTohyoGamen.class);
            gamenData.set不在者投票選挙人エリア(get不在者投票選挙人データ());

        } else if (key.equals(ViewStateKeys.不在者投票_投票状況エリア)) {
            gamenData = ViewState.getData(ViewStateKeys.不在者投票, FuzaishaTohyoGamen.class);
            gamenData.set不在者投票状況エリア(get不在者投票状況データ());

        }
        ViewState.setData(ViewStateKeys.不在者投票, gamenData);
    }

    private FuzaishaTohyoSearchArea get不在者投票検索データ() {
        FuzaishaTohyoSearchArea serachArea = new FuzaishaTohyoGamen().createFuzaishaTohyoSearchAreaInstance();
        serachArea.set抄本(fuzaishaJohoSearchPanel.getCcdShohonNameList().getSelectedShohonNo());
        serachArea.set施設コード(fuzaishaJohoSearchPanel.getCcdShisetsuCode().get施設コード());
        return serachArea;
    }

    private FuzaishaTohyoSenkyoninArea get不在者投票選挙人データ() {
        FuzaishaTohyoSenkyoninArea senkyoninArea = new FuzaishaTohyoGamen().createFuzaishaTohyoSenkyoninAreaInstance();
        senkyoninArea.set入場券バーコード(fuzaishaSenkyoninSearchPanel.getCcdFuzaishaBarCode().getBarCode());
        senkyoninArea.set選挙人数(fuzaishaSenkyoninSearchPanel.getDgFuzaishaSenkyoninSearch().getDataSource().size());
        return senkyoninArea;
    }

    private FuzaishaTohyoJokyoArea get不在者投票状況データ() {

        FuzaishaTohyoJokyoArea jokyoArea = new FuzaishaTohyoGamen().createFuzaishaTohyoJokyoAreaInstance();
        FuzaishaSeikyuJohoDiv 請求Div = fuzaishaTohyoJokyoPanel.getFuzaishaSeikyuJoho();
        FuzaishaKofuJohoDiv 交付Div = fuzaishaTohyoJokyoPanel.getFuzaishaKofuJoho();
        FuzaishaUketoriJohoDiv 受取Div = fuzaishaTohyoJokyoPanel.getFuzaishaUketoriJoho();
        FuzaishaJuriJohoDiv 受理Div = fuzaishaTohyoJokyoPanel.getFuzaishaJuriJoho();
        FuzaishaSochiJohoDiv 送致Div = fuzaishaTohyoJokyoPanel.getFuzaishaSochiJoho();

        jokyoArea.set投票状況(fuzaishaTohyoJokyoPanel.getFuzaishaJokyoSelect().getRadFuzaishaTohyoJokyo().getSelectedKey());
        jokyoArea.set選択フラグ(fuzaishaTohyoJokyoPanel.getDgFuzaishaTohyoJokyo().getSelectedItems().size() > 0);

        // 請求情報
        if (!請求Div.isDisplayNone()) {
            jokyoArea.set請求方法(請求Div.getRadSeikyusha().getSelectedKey());
            jokyoArea.set請求日(請求Div.getTxtSeikyuYMD().getValue());
            jokyoArea.set投票事由(請求Div.getCcdFuzaishaTohyoJiyu().getTohyoJiyuCodeContext().getTohyoJiyuCode().getColumnValue());
        }
        // 交付情報
        if (!交付Div.isDisplayNone()) {
            jokyoArea.set交付方法(交付Div.getRadKofuHoho().getSelectedKey());
            jokyoArea.set交付日(交付Div.getTxtKofuYMD().getValue());
            jokyoArea.set点字投票用紙を使用フラグ(交付Div.getChkTenjiYoshi().isAllSelected());
            jokyoArea.set証明書フラグ(交付Div.getChkShomeishoHakko().isAllSelected());
        }
        // 受取情報
        if (!受取Div.isDisplayNone()) {
            jokyoArea.set受取日(受取Div.getTxtUketoriYMD().getValue());
        }
        // 受理情報
        if (!受理Div.isDisplayNone()) {
            jokyoArea.set受理方法(受理Div.getRadJuriHoho().getSelectedKey());
            jokyoArea.set受理日(受理Div.getTxtJuriYMD().getValue());
            jokyoArea.set受理日時(受理Div.getTxtJuriTime().getValue());
            HojoshaNyuryokuContext 補助者Div = 受理Div.getCcdFuzaishaDairiTohyo().getHojoshaNyuryokuContext();
            jokyoArea.set代理投票フラグ(補助者Div.isDairiTohyoAri());
            jokyoArea.set補助者１識別コード(補助者Div.getHojosha1ShikibetsuCode());
            jokyoArea.set補助者２識別コード(補助者Div.getHojosha2ShikibetsuCode());
            jokyoArea.set拒否事由(受理Div.getCcdKyohiJiyuNyuryoku().get投票状況用拒否事由());
            jokyoArea.set仮投票フラグ(受理Div.getChkKariTohyo().isAllSelected());
        }
        // 送致情報
        if (!送致Div.isDisplayNone()) {
            jokyoArea.set送致済フラグ(送致Div.getChkSochiZumi().isAllSelected());
        }

        return jokyoArea;
    }

    private FuzaishaTohyoGamen getGamenData() {
        FuzaishaTohyoGamen gamenData = new FuzaishaTohyoGamen();
        gamenData.set不在者投票検索エリア(get不在者投票検索データ());
        gamenData.set不在者投票選挙人エリア(get不在者投票選挙人データ());
        gamenData.set不在者投票状況エリア(get不在者投票状況データ());
        return gamenData;
    }
}
