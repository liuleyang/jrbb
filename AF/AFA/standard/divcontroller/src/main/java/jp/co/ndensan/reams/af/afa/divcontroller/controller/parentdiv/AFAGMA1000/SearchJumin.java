/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.juminkensaku.JuminKensaku;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.AFAGMA1000StateName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.AFAGMA1000TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchJuminDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.dgSearchKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000.SearchJuminErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000.SearchJuminHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000.SearchJuminValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.juminkensaku.JuminKensakuManager;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGMA1000　住民検索 <br />
 * SearchJuminDivに対応するコントローラです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class SearchJumin {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString 指定する = new RString("指定する");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onLoad(SearchJuminDiv mainPanel) {

        //選挙種類の初期化。
        ViewStateHolder.put(ViewStateKeys.メニューID, ResponseHolder.getMenuID());
        mainPanel.getCcdSenkyoShurui().initialize();

        mainPanel.getCcdShohonNameList().setDisabled(false);

        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.メニューへ戻る).respond();
        }
        if (!getHandler(mainPanel).is抄本名共有子Div正常に初期化する()) {
            return ResponseData.of(mainPanel).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        getHandler(mainPanel).set初期表示();

        getHandler(mainPanel).setDisabled検索結果一覧パネル(true);
        return ResponseData.of(mainPanel).focusId(getHandler(mainPanel).getFocusID()).respond();
    }

    /**
     * 抄本DDL変更時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onChange_ccdShohonNameList(SearchJuminDiv mainPanel) {

        mainPanel.getCcdShohonNameList().changeDdlShohon();
        // 選挙種類を渡す
        getHandler(mainPanel).set初期表示();

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 表示するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> clickHyoji(SearchJuminDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();
        RString shikibetsuCode = mainPanel.getSearchJoken().getCcdSearchSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();
        RString shohonNo = mainPanel.getCcdShohonNameList().getSelectedShohonNo();
        ((AtenaFinderDiv) mainPanel.getSearchJoken().getCcdSearchJukiJoho()).getTxtShikibetsuCodeSub().setDomain(new ShikibetsuCode(shikibetsuCode));
        List<JuminKensaku> rslts = JuminKensakuManager.createInstance().get検索結果一覧(getHandler(mainPanel).create検索用パラメータ());
        ((AtenaFinderDiv) mainPanel.getSearchJoken().getCcdSearchJukiJoho()).getTxtShikibetsuCodeSub().clearDomain();
        ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, shohonNo);
        ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, shikibetsuCode);
        ViewStateHolder.put(ViewStateKeys.is住民検索へ戻る可, false);

        if (getHandler(mainPanel).isメニューID状況1(menuID)) {
            ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui());
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }
        if (getHandler(mainPanel).isメニューID状況2(menuID)) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }
        if (getHandler(mainPanel).isメニューID状況3(menuID) && rslts != null && !rslts.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.住民検索_申請番号, new RString(String.valueOf(rslts.get(0).get申請番号())));
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 受付番号DDL変更時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onChange_ddlUketsukeBnago(SearchJuminDiv mainPanel) {
        SearchTohyoJokyoDiv div = mainPanel.getSearchJoken().getSearchTohyoJokyo();
        if (div.getDdlUketsukeBnago().getSelectedValue().equalsIgnoreCase(指定する)) {
            div.getTxtUketsukeBnago().setReadOnly(false);
        } else {
            div.getTxtUketsukeBnago().setReadOnly(true);
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 検索結果グリッドから対象データを選択した時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchKekkaListDiv>
     */
    public ResponseData<SearchJuminDiv> onSelect_dgSearchKekkaList(SearchJuminDiv mainPanel) {
        ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
        dgSearchKekkaList_Row row = mainPanel.getSearchKekkaList().getDgSearchKekkaList().getClickedItem();
        manager.save(new ScopeCode(ScopeCodeType.識別対象.getCode()), row.getTxtShikibetsuCode(), row.getTxtShimei());
        mainPanel.getSearchJoken().getCcdSearchSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));
        return forwardTo次の画面(mainPanel);
    }

    /**
     * 検索するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onClick_btnSearch(SearchJuminDiv mainPanel) {
        ValidationMessageControlPairs validCheck = getValidationHandler(mainPanel).validate();
        if (validCheck.iterator().hasNext()) {
            return ResponseData.of(mainPanel).addValidationMessages(validCheck).respond();
        }
        RString 上限値 = BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_上限値, SubGyomuCode.AFA選挙本体);
        if (mainPanel.getSearchJoken().getTxtMaxKensu().getValue().compareTo(new Decimal(上限値.toString())) > 0) {
            RString replace = 上限値.concat("以下");
            Message errorMsg = UrErrorMessages.項目に対する制約.getMessage().replace("最大表示件数", replace.toString());
            validCheck.add(new ValidationMessageControlPair(new SearchJuminErrorMessages(errorMsg), mainPanel.getSearchJoken().getTxtMaxKensu()));
            return ResponseData.of(mainPanel).addValidationMessages(validCheck).respond();
        }
        List<JuminKensaku> rslts = JuminKensakuManager.createInstance().get検索結果一覧(getHandler(mainPanel).create検索用パラメータ());
//        int 総件数 = JuminKensakuManager.createInstance().get総件数(getHandler(mainPanel).create検索用パラメータ());
        if (rslts == null || rslts.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        } else if (rslts.size() == 1) {
            ViewStateHolder.put(ViewStateKeys.is住民検索へ戻る可, false);
            ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
            manager.save(new ScopeCode(ScopeCodeType.識別対象.getCode()), rslts.get(0).get識別コード(), rslts.get(0).get氏名());
            mainPanel.getSearchJoken().getCcdSearchSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.識別対象.getCode()));
            RString menuID = ResponseHolder.getMenuID();
            if (getHandler(mainPanel).isメニューID状況1(menuID)) {
                ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui());
                ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
                ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, rslts.get(0).get識別コード());
                return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
            }

            if (getHandler(mainPanel).isメニューID状況2(menuID)) {
                ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
                ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, rslts.get(0).get識別コード());
                return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
            }

            if (getHandler(mainPanel).isメニューID状況3(menuID)) {
                ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
                ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, rslts.get(0).get識別コード());
                ViewStateHolder.put(ViewStateKeys.住民検索_申請番号, new RString(String.valueOf(rslts.get(0).get申請番号())));
                return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
            }

        } else {
            ViewStateHolder.put(ViewStateKeys.is住民検索へ戻る可, true);
            getHandler(mainPanel).change画面To検索結果状態();
            List<dgSearchKekkaList_Row> rowList = new ArrayList<>();
            SenkyoShurui 選挙種類 = mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui();
            List<RString> 投票資格リスト = mainPanel.getSearchJoken().getCcdSearchTohyoShikaku().get投票資格リスト();
            FlexibleDate 基準日 = FlexibleDate.getNowDate();
            int i = 0;
            for (JuminKensaku result : rslts) {
                if (i < mainPanel.getSearchJoken().getTxtMaxKensu().getValue().intValue()) {
                    dgSearchKekkaList_Row row = new dgSearchKekkaList_Row();
                    rowList.add(getHandler(mainPanel).set検索結果To一覧(result, row, 選挙種類, 投票資格リスト, 基準日));
                    i++;
                }
            }
            mainPanel.getSearchKekkaList().getDgSearchKekkaList().setDataSource(rowList);
            mainPanel.getSearchKekkaList().getDgSearchKekkaList().getGridSetting().setLimitRowCount(mainPanel.getSearchJoken().getTxtMaxKensu().getValue().intValue());
//            mainPanel.getSearchKekkaList().getDgSearchKekkaList().getGridSetting().setSelectedRowCount(総件数);
            mainPanel.getSearchKekkaList().getDgSearchKekkaList().getGridSetting().setSelectedRowCount(rslts.size());
        }
        return ResponseData.of(mainPanel).setState(AFAGMA1000StateName.検索結果状態);
    }

    /**
     * 条件をクリアするボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onClick_btnClear(SearchJuminDiv mainPanel) {

        mainPanel.getSearchJoken().getCcdSearchJukiJoho().clear();
        mainPanel.getSearchJoken().getCcdSearchTohyoShikaku().clearData();
        getHandler(mainPanel).clear投票状況検索条件パネル();
        getHandler(mainPanel).set初期表示();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 再検索するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<SearchJuminDiv> onClick_btnResearch(SearchJuminDiv mainPanel) {
        getHandler(mainPanel).clear検索結果一覧データグリッド();
        getHandler(mainPanel).change画面To再検索状態();
        return ResponseData.of(mainPanel).setState(AFAGMA1000StateName.再検索状態);
    }

    private ResponseData<SearchJuminDiv> forwardTo次の画面(SearchJuminDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();

        if (getHandler(mainPanel).isメニューID状況1(menuID)) {
            put選挙種類と抄本番号と識別コード(mainPanel);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }

        if (getHandler(mainPanel).isメニューID状況2(menuID)) {
            put抄本番号と識別コード(mainPanel);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }

        if (getHandler(mainPanel).isメニューID状況3(menuID)) {
            put抄本番号と識別コードと申請番号(mainPanel);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMA1000TransitionEventName.検索).respond();
        }

        return ResponseData.of(mainPanel).respond();
    }

    private void put選挙種類と抄本番号と識別コード(SearchJuminDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui());
        ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
        ViewStateHolder.put(ViewStateKeys.住民検索_識別コード,
                mainPanel.getSearchKekkaList().getDgSearchKekkaList().getClickedItem().getTxtShikibetsuCode());
    }

    private void put抄本番号と識別コード(SearchJuminDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
        ViewStateHolder.put(ViewStateKeys.住民検索_識別コード,
                mainPanel.getSearchKekkaList().getDgSearchKekkaList().getClickedItem().getTxtShikibetsuCode());
    }

    private void put抄本番号と識別コードと申請番号(SearchJuminDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.住民検索_抄本番号, mainPanel.getCcdShohonNameList().getSelectedShohonNo());
        ViewStateHolder.put(ViewStateKeys.住民検索_識別コード,
                mainPanel.getSearchKekkaList().getDgSearchKekkaList().getClickedItem().getTxtShikibetsuCode());
        ViewStateHolder.put(ViewStateKeys.住民検索_申請番号,
                mainPanel.getSearchKekkaList().getDgSearchKekkaList().getClickedItem().getTxtShinseiNo());
    }

    private SearchJuminHandler getHandler(SearchJuminDiv mainPanel) {
        return new SearchJuminHandler(mainPanel);
    }

    private SearchJuminValidationHandler getValidationHandler(SearchJuminDiv mainPanel) {
        return new SearchJuminValidationHandler(mainPanel);
    }
}
