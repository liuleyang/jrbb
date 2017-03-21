/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMC1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.AFAGMC1000StateName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.AFAGMC1000TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.IdoSearchJuminShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.dgIdoSearchKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000.SearchJuminErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1000.IdoSearchJuminShikakuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1000.IdoSearchJuminShikakuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.idosearchjuminshikaku.IdoSearchJuminShikakuManager;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGMC1000　住民検索（資格） <br />
 * IdoSearchJuminShikakuDivに対応するコントローラです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public class IdoSearchJuminShikaku {

    private final RString 検索結果状態フラグ = new RString("2");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel IdoSearchJuminShikakuDiv
     * @return ResponseData<IdoSearchJuminShikakuDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onLoad(IdoSearchJuminShikakuDiv mainPanel) {
        ViewStateHolder.put(ViewStateKeys.メニューID, ResponseHolder.getMenuID());
        RString menuID = ResponseHolder.getMenuID();
        mainPanel.getCcdSenkyoShurui().initialize();
        if (getHandler(mainPanel).isメニューID選挙種類(menuID)) {
            SenkyoShurui 選挙種類 = mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui();
            getHandler(mainPanel).set初期表示(選挙種類);
        } else if (getHandler(mainPanel).isメニューID選挙資格種類(menuID)) {
            if (mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui().equals(SennkyoSikakuShurui.通常選挙)
                    || mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui().equals(SennkyoSikakuShurui.在外投票)) {
                SenkyoShurui 選挙種類 = SenkyoShurui.定時登録;
                getHandler(mainPanel).set初期表示(選挙種類);
            } else {
                SenkyoShurui 選挙種類 = SenkyoShurui.toValue(mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui().value());
                getHandler(mainPanel).set初期表示(選挙種類);
            }
        }
        if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_名称.configKeyValue())) {
            return ResponseData.of(mainPanel).focusId(mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho().getControlIdOfAtenaMeisho()).respond();
        } else if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_生年月日.configKeyValue())) {
            return ResponseData.of(mainPanel).focusId(mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho().getControlIdOfSeinengappi()).respond();
        } else if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_投票区コード.configKeyValue())) {
            return ResponseData.of(mainPanel).focusId(mainPanel.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().getCcdTohyokuCode().getTxtTohyokuCode().getSelectControlID()).respond();
        }
        return ResponseData.of(mainPanel).focusId(mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho().getControlIdOfAtenaMeisho()).respond();
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel IdoSearchJuminShikakuDiv
     * @return ResponseData<IdoSearchJuminShikakuDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onActive(IdoSearchJuminShikakuDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();

        if (menuID.equals(AFAMenuId.AFAMNC1010_選挙人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMND1010_定時登録選挙時登録.menuId())
                || menuID.equals(AFAMenuId.AFAMND1020_国民投票.menuId())
                || menuID.equals(AFAMenuId.AFAMNG1030_投票人資格異動.menuId())
                || menuID.equals(AFAMenuId.AFAMND1030_在外選挙.menuId())
                || menuID.equals(AFAMenuId.AFAMND1040_海区漁業調整委員会委員選挙.menuId())) {
            RString 状態フラグ = ViewStateHolder.get(ViewStateKeys.住民検索資格状態変更パラメータ, RString.class
            );
            if (null != 状態フラグ
                    && 状態フラグ.equals(検索結果状態フラグ)) {
                return getResponseData(mainPanel);
            }
        }
        return onLoad(mainPanel);

    }

    /**
     * 表示するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel IdoSearchJuminShikakuDiv
     * @return ResponseData<IdoSearchJuminShikakuDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onClick_btnkHyoji(IdoSearchJuminShikakuDiv mainPanel) {
        RString shikibetsuCode = mainPanel.getIdoSearchJoken().getCcdIdoSearchSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();
        RString menuID = ResponseHolder.getMenuID();
        ((AtenaFinderDiv) mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtShikibetsuCodeSub().setDomain(new ShikibetsuCode(shikibetsuCode));
        List<IdoSearchJumin> rslts = IdoSearchJuminShikakuManager.createInstance().get検索結果一覧(getHandler(mainPanel).create検索用パラメータ(
                menuID, mainPanel.getHdnSenkyoShuruiCode()));
        ((AtenaFinderDiv) mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtShikibetsuCodeSub().clearDomain();

        if (getHandler(mainPanel).isメニューID選挙資格種類(menuID)) {
            SennkyoSikakuShurui 選挙資格種類 = mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui();
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_選挙種類, 選挙資格種類);
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_識別コード, shikibetsuCode);
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_ボタン表示フラグ, true);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1000TransitionEventName.決定).respond();
        } else if (getHandler(mainPanel).isメニューID選挙種類(menuID)
                && null != rslts && !rslts.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, shikibetsuCode);
            ViewStateHolder.put(ViewStateKeys.住民検索_申請番号, new RString(String.valueOf(rslts.get(0).get申請番号())));
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_ボタン表示フラグ, true);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1000TransitionEventName.決定).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 検索するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel IdoSearchJuminShikakuDiv
     * @return ResponseData<IdoSearchJuminShikakuDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onClick_btnSearch(IdoSearchJuminShikakuDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();
        if (getHandler(mainPanel).isメニューID選挙種類(menuID)) {
            SenkyoShurui 選挙種類 = mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui();
            mainPanel.setHdnSenkyoShuruiCode(選挙種類.getCode());
        } else if (getHandler(mainPanel).isメニューID選挙資格種類(menuID)) {
            SennkyoSikakuShurui 選挙資格種類 = mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui();
            mainPanel.setHdnSenkyoShuruiCode(選挙資格種類.value());
        }
        ValidationMessageControlPairs validCheck = mainPanel.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().日期大小関係チェック();
        if (validCheck.iterator().hasNext()) {
            return ResponseData.of(mainPanel).addValidationMessages(validCheck).respond();
        }
        RString 上限値 = BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_上限値, SubGyomuCode.AFA選挙本体);
        RString 下限値 = new RString("0");
        if (mainPanel.getIdoSearchJoken().getTxtMaxKensu().getValue().compareTo(new Decimal(上限値.toString())) > 0) {
            RString replace = 上限値.concat("以下");
            Message errorMsg = UrErrorMessages.項目に対する制約.getMessage().replace("最大表示件数", replace.toString());
            validCheck.add(new ValidationMessageControlPair(new SearchJuminErrorMessages(errorMsg), mainPanel.getIdoSearchJoken().getTxtMaxKensu()));
            return ResponseData.of(mainPanel).addValidationMessages(validCheck).respond();
        }
        if (mainPanel.getIdoSearchJoken().getTxtMaxKensu().getValue().compareTo(new Decimal(下限値.toString())) <= 0) {
            RString replace = 下限値.concat("以上");
            Message errorMsg = UrErrorMessages.項目に対する制約.getMessage().replace("最大表示件数", replace.toString());
            validCheck.add(new ValidationMessageControlPair(new SearchJuminErrorMessages(errorMsg), mainPanel.getIdoSearchJoken().getTxtMaxKensu()));
            return ResponseData.of(mainPanel).addValidationMessages(validCheck).respond();
        }
        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(mainPanel).validate検索条件();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        List<IdoSearchJumin> rslts = IdoSearchJuminShikakuManager.createInstance().get検索結果一覧(getHandler(mainPanel).create検索用パラメータ(
                menuID, mainPanel.getHdnSenkyoShuruiCode()));
        宛名情報の存在チェック(rslts);
        if (rslts.size() == 1) {
            選挙資格の存在チェック(rslts, mainPanel, menuID);
            ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
            manager.save(new ScopeCode(ScopeCodeType.個人.getCode()), rslts.get(0).get識別コード(), rslts.get(0).get氏名());
            if (getHandler(mainPanel).isメニューID選挙種類(menuID)) {
                ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, rslts.get(0).get識別コード());
                ViewStateHolder.put(ViewStateKeys.住民検索_申請番号, new RString(String.valueOf(rslts.get(0).get申請番号())));
            } else if (getHandler(mainPanel).isメニューID選挙資格種類(menuID)) {
                SennkyoSikakuShurui 選挙資格種類 = mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui();
                ViewStateHolder.put(ViewStateKeys.住民検索_資格_選挙種類, 選挙資格種類);
                ViewStateHolder.put(ViewStateKeys.住民検索_資格_識別コード, rslts.get(0).get識別コード());
            }
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_ボタン表示フラグ, true);
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1000TransitionEventName.決定).respond();

        } else {
            getHandler(mainPanel).change画面To検索結果状態();
            List<dgIdoSearchKekkaList_Row> rowList = new ArrayList<>();
            List<RString> 投票資格リスト = mainPanel.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get投票資格リスト();
            int i = 0;
            for (IdoSearchJumin result : rslts) {
                if (i < mainPanel.getIdoSearchJoken().getTxtMaxKensu().getValue().intValue()) {
                    dgIdoSearchKekkaList_Row row = new dgIdoSearchKekkaList_Row();
                    rowList.add(getHandler(mainPanel).set検索結果To一覧(result, row,
                            mainPanel.getHdnSenkyoShuruiCode(), 投票資格リスト));
                    i++;
                }
            }
            int listSize = rslts.size();
            mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().setDataSource(rowList);
            mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getGridSetting().setLimitRowCount(
                    mainPanel.getIdoSearchJoken().getTxtMaxKensu().getValue().intValue());
            mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getGridSetting().setSelectedRowCount(listSize);
        }
        return ResponseData.of(mainPanel).setState(AFAGMC1000StateName.検索結果状態);
    }

    private void 選挙資格の存在チェック(List<IdoSearchJumin> rslts, IdoSearchJuminShikakuDiv mainPanel, RString menuID) throws ApplicationException {
//        if (rslts.get(0).get選挙資格() == null || rslts.get(0).get選挙資格().isEmpty()) {
//            if (getHandler(mainPanel).isメニューID選挙資格ない時に画面遷移あり(menuID)) {
//                //処理なし
//            } else if (getHandler(mainPanel).isメニューID選挙資格ない時に画面遷移なし(menuID)) {
        if (rslts.get(0).get選挙資格() == null || rslts.get(0).get選挙資格().isEmpty()
                && !getHandler(mainPanel).isメニューID選挙資格ない時に画面遷移あり(menuID)
                && getHandler(mainPanel).isメニューID選挙資格ない時に画面遷移なし(menuID)) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        } else {
            throw new ApplicationException(UrErrorMessages.不正.getMessage());
//            }
//            }
        }
    }

    private void 宛名情報の存在チェック(List<IdoSearchJumin> rslts) throws ApplicationException {
        if (rslts == null || rslts.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        }
    }

    /**
     * 条件をクリアするボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel IdoSearchJuminShikakuDiv
     * @return ResponseData<IdoSearchJuminShikakuDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onClick_btnClear(IdoSearchJuminShikakuDiv mainPanel) {

        mainPanel.getIdoSearchJoken().getCcdIdoSearchJukiJoho().clear();
        getHandler(mainPanel).set宛名共通検索条件表示制御();
        mainPanel.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().clearData();

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 再検索するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchJuminDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onClick_btnResearch(IdoSearchJuminShikakuDiv mainPanel) {
        getHandler(mainPanel).clear検索結果一覧データグリッド();
        getHandler(mainPanel).change画面To再検索状態();
        return ResponseData.of(mainPanel).setState(AFAGMC1000StateName.再検索状態);
    }

    /**
     * 検索結果グリッドから対象データを選択した時のイベントメソッドです。
     *
     * @param mainPanel SearchJuminDiv
     * @return ResponseData<SearchKekkaListDiv>
     */
    public ResponseData<IdoSearchJuminShikakuDiv> onSelect_dgIdoSearchKekkaList(IdoSearchJuminShikakuDiv mainPanel) {
        RString menuID = ResponseHolder.getMenuID();
        ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
        dgIdoSearchKekkaList_Row row = mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getClickedItem();
        manager.save(new ScopeCode(ScopeCodeType.個人.getCode()), row.getTxtShikibetsuCode(), row.getTxtShimei());
        if (getHandler(mainPanel).isメニューID選挙種類(menuID)) {
            ViewStateHolder.put(ViewStateKeys.住民検索_識別コード, mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getClickedItem().getTxtShikibetsuCode());
            ViewStateHolder.put(ViewStateKeys.住民検索_申請番号, mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getClickedItem().getTxtShinseiNo());
        } else if (getHandler(mainPanel).isメニューID選挙資格種類(menuID)) {
            SennkyoSikakuShurui 選挙資格種類 = mainPanel.getCcdSenkyoShurui().getSelectedSennkyoSikakuShurui();
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_選挙種類, 選挙資格種類);
            ViewStateHolder.put(ViewStateKeys.住民検索_資格_識別コード, mainPanel.getIdoSearchKekkaList().getDgIdoSearchKekkaList().getClickedItem().getTxtShikibetsuCode());
        }
        ViewStateHolder.put(ViewStateKeys.住民検索_資格_ボタン表示フラグ, false);
        return ResponseData.of(mainPanel).forwardWithEventName(AFAGMC1000TransitionEventName.決定).respond();
    }

    private ResponseData<IdoSearchJuminShikakuDiv> getResponseData(IdoSearchJuminShikakuDiv mainPanel) {
        return ResponseData.of(mainPanel).respond();
    }

    private IdoSearchJuminShikakuHandler getHandler(IdoSearchJuminShikakuDiv mainPanel) {
        return new IdoSearchJuminShikakuHandler(mainPanel);
    }

    private IdoSearchJuminShikakuValidationHandler getValidationHandler(IdoSearchJuminShikakuDiv div) {
        return new IdoSearchJuminShikakuValidationHandler(div);
    }

}
