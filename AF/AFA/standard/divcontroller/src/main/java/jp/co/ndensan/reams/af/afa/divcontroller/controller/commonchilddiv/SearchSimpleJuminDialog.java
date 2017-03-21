/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.juminkensaku.JuminKensaku;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SearchSimpleJuminDialogEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.SearchSimpleJuminDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.SearchSimpleJuminDialogHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.SearchSimpleJuminValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog.dgSearchSimpleKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.juminkensaku.JuminKensakuManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminJotaiStatus;
import jp.co.ndensan.reams.ua.uax.business.core.atenafinder.AtenaFinderJuminShubetsuStatus;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.StatusOfCheckBox;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住民検索簡易版ダイアログに対応するコントローラです。
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminDialog {

//    private static final RString 投票資格_郵便 = new RString("郵便");
//    private static final RString 投票資格_船員 = new RString("船員");
//    private static final RString 投票資格_南極 = new RString("南極");
//    private static final int INT_3 = 3;
    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onLoad(SearchSimpleJuminDialogDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        ViewState.setメニューID(menuID);

        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleKekkaList().getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        if (model != null) {
            if (model.get選挙種類() != null) {
                div.setTxtHdnSenkyoShurui(model.get選挙種類().toRString());
            }
            if (model.get抄本番号() != null) {
                div.setTxtHdnShohonNo(new RString(model.get抄本番号().toString()));
            }
        }
        SenkyoShurui 渡された選挙種類 = null;
        if (div.getTxtHdnSenkyoShurui().toString() != null) {
            渡された選挙種類 = SenkyoShurui.valueOf(div.getTxtHdnSenkyoShurui().toString());
        }

        ShohonNo 抄本番号 = new ShohonNo(div.getTxtHdnShohonNo());

        div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().getDataSource().clear();
        div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getDataSource().clear();
//        IShikibetsuTaishoGyomuHanteiKey key = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
//        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().load(key);
        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().load(AtenaHelper.createSearchKeyForAtenaFinder());

        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setJuminShubetsuDefault(
                new AtenaFinderJuminShubetsuStatus(StatusOfCheckBox.選択, StatusOfCheckBox.未選択,
                        StatusOfCheckBox.未選択, StatusOfCheckBox.未選択));

        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setJuminJotaiDefault(new AtenaFinderJuminJotaiStatus(
                StatusOfCheckBox.選択, StatusOfCheckBox.未選択, StatusOfCheckBox.選択, StatusOfCheckBox.未選択, StatusOfCheckBox.未選択));

        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setRadNihonjinKubun(SearchSimpleJuminDialogEnum.含む.getValue());
        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setRadGaikokujinKubun(SearchSimpleJuminDialogEnum.含まない.getValue());
        //todo ShohonNameList_抄本名共有子DIV
        if (menuID.equals(AFAMenuId.AFAMNH1020_署名簿登録.menuId())) {
            div.getSearchSimpleJoken().getCcdShohonNameList().initialize(渡された選挙種類, true);
        } else {
            div.getSearchSimpleJoken().getCcdShohonNameList().initialize(渡された選挙種類);
        }
        div.getSearchSimpleJoken().getCcdTohyokuCode().initialize(渡された選挙種類, true);

        div.getSearchSimpleJoken().getCcdShohonNameList().selectedShohon(new RString(抄本番号.toString()));
        SearchSimpleJuminDialogHandler.of(div).set選挙資格と投票資格(渡された選挙種類, menuID);
        div.getSearchSimpleJoken().setCanOpenAndClose(true);
        div.getSearchSimpleJoken().setIsOpen(true);
        div.getSearchSimpleKekkaList().setCanOpenAndClose(true);
        div.getSearchSimpleKekkaList().setDisplayNone(true);

        int 最大件数の初期値 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, SubGyomuCode.AFA選挙本体).toString());
        div.getSearchSimpleJoken().getTxtMaxDisplayCount().setValue(new Decimal(最大件数の初期値));
        div.getSearchSimpleJoken().getCcdSearchSimpleSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.個人.getCode()));
        div.getSearchSimpleJoken().getCcdSearchSimpleSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();

        return ResponseData.of(div).focusId(SearchSimpleJuminDialogHandler.of(div).getFocusID()).respond();
    }

    /**
     * 検索するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onClick_btnSearch(SearchSimpleJuminDialogDiv div) {
        SenkyoShurui 渡された選挙種類 = SenkyoShurui.valueOf(div.getTxtHdnSenkyoShurui().toString());
        ShohonNo 抄本番号 = new ShohonNo(div.getTxtHdnShohonNo());
        Decimal 最大表示件数 = new Decimal(Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_上限値, SubGyomuCode.AFA選挙本体).toString()));
        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(div).validate検索();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        div.setTxtHdnMaxCount(new RString(最大表示件数.toString()));

//        RString 投票区コード = div.getSearchSimpleJoken().getCcdTohyokuCode().get投票区コード();
//        div.getSearchSimpleJoken().getCcdTohyokuCode().get投票区コード();
//        if (!投票区コード.isEmpty() && !投票区コード.isNull()) {
//            投票区コード = new RString((Integer.valueOf(投票区コード.toString())).toString());
//        }
//        RString 投票区コード = div.getSearchSimpleJoken().getCcdTohyokuCode().getTxtTohyokuCode().getValue();
        ShohonManager shohonManager = ShohonManager.createInstance();
        Shohon 抄本選挙情報 = shohonManager.get抄本(抄本番号);
//        FlexibleDate 投票年月日 = 抄本選挙情報.get投票年月日();
        List<Senkyo> senkyo = 抄本選挙情報.getSenkyoList();
        FlexibleDate max名簿基準年月日 = FlexibleDate.MAX;
        if (!senkyo.isEmpty()) {
            Collections.sort(senkyo, new Comparator<Senkyo>() {
                @Override
                public int compare(Senkyo o1, Senkyo o2) {
                    return o1.get名簿基準年月日().compareTo(o2.get名簿基準年月日());
                }
            });
            max名簿基準年月日 = senkyo.get(senkyo.size() - 1).get名簿基準年月日();

        }
//        //ShikibetsuCode 識別コード = ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getAtenaFinderShosai().getTxtShikibetsuCode().getDomain();
//        ShikibetsuCode 識別コード = ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtShikibetsuCodeSub().getDomain();
//        SearchSimpleJuminFinder finder = SearchSimpleJuminFinder.createInstance();
//        SearchSimpleJuminParameter parameter = SearchSimpleJuminDialogHandler.of(div).set画面パラメータ(渡された選挙種類, 抄本番号, 投票区コード, 投票年月日, 識別コード);
//        List<SearchSimpleJuminResult> 選挙人情報List = finder.get選挙人情報(parameter);
//
//        List<ShikibetsuCode> 識別コードリスト = new ArrayList();
//        for (SearchSimpleJuminResult 選挙人 : 選挙人情報List) {
//            識別コードリスト.add(選挙人.get選挙人情報().getAfT112SenkyoninMeibo().getShikibetsuCode());
//        }
//        div.setTxtHdnMaxKijunYMD(new RString(max名簿基準年月日.toString()));
//
//        IShikibetsuTaishoSearchKey searchKey = div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()
//                .makeShikibetsuTaishoSearchKeyBuilder().set識別コードリスト(識別コードリスト)
//                .set基準日(max名簿基準年月日).build();
//
//        List<FindShikibetsuTaishoResult> 宛名PSM = finder.get住民情報(searchKey);
//        Map<ShikibetsuCode, FindShikibetsuTaishoResult> map選挙資格 = new HashMap();
//        if (宛名PSM != null && !宛名PSM.isEmpty()) {
//            for (FindShikibetsuTaishoResult findShikibetsuTaishoResult : 宛名PSM) {
//                map選挙資格.put(findShikibetsuTaishoResult.get宛名PSM().getShikibetsuCode(), findShikibetsuTaishoResult);
//            }
//        }
//
//        Map<ShikibetsuCode, FindShikibetsuTaishos> map投票資格 = is投票資格(div, finder, parameter);
//
        List<JuminKensaku> rslts = JuminKensakuManager.createInstance().get検索結果一覧(
                SearchSimpleJuminDialogHandler.of(div).create検索用パラメータ(max名簿基準年月日));
//2回起動することになり、遅い        int 総件数 = JuminKensakuManager.createInstance().get総件数(SearchSimpleJuminDialogHandler.of(div).create検索用パラメータ(max名簿基準年月日));
        if (rslts == null || rslts.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        }

        List<dgSearchSimpleKekkaList_Row> rowList = new ArrayList<>();
        List<RString> 投票資格リスト = div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().getSelectedValues();
        int i = 0;
        for (JuminKensaku result : rslts) {
            if (i < div.getSearchSimpleJoken().getTxtMaxDisplayCount().getValue().intValue()) {
                dgSearchSimpleKekkaList_Row row = new dgSearchSimpleKekkaList_Row();
                rowList.add(SearchSimpleJuminDialogHandler.of(div).set検索結果To一覧(result, row, 渡された選挙種類, 投票資格リスト, max名簿基準年月日));
                i++;
            }
        }

//        List<dgSearchSimpleKekkaList_Row> rowList = 画面のチェックの設定(div, 選挙人情報List, map選挙資格, map投票資格, 宛名PSM, 渡された選挙種類);
//
//        div.setTxtHdnNumber(new RString(Integer.toString(rowList.size())));
//        List<dgSearchSimpleKekkaList_Row> list = new ArrayList<>();
//        if (div.getSearchSimpleJoken().getTxtMaxDisplayCount().getValue() != null) {
//            int count = div.getSearchSimpleJoken().getTxtMaxDisplayCount().getValue().intValue();
//            for (int i = 0; i < (count > rowList.size() ? rowList.size() : count); i++) {
//                list.add(rowList.get(i));
//            }
//            div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().setDataSource(list);
//        } else {
        div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().setDataSource(rowList);
//        }
        div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setLimitRowCount(div.getSearchSimpleJoken().getTxtMaxDisplayCount().getValue().intValue());
//        div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setSelectedRowCount(Integer.parseInt(div.getTxtHdnNumber().toString()));
        div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getGridSetting().setSelectedRowCount(rslts.size());
////        SearchSimpleJuminModel simplemodel = new SearchSimpleJuminModel();
//        controlErrorPairs = getValidationHandler(div).validate対象者が存在しない();
//        if (controlErrorPairs.existsError()) {
//            //return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
//            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
//        }
        if (div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getDataSource().size() == 1) {
            List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().
                    getDgSearchSimpleKekkaList().getDataSource();
            SearchSimpleJuminModel simplemodel = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);
            if (simplemodel.get抄本番号() == null) {
                simplemodel.set抄本番号(抄本番号);
            }
            div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(simplemodel));
            return ResponseData.of(div).dialogOKClose();
        }
        if (div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getDataSource().size() > 1) {
//            List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().
//                    getDgSearchSimpleKekkaList().getSelectedItems();
//            simplemodel = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);
            SearchSimpleJuminDialogHandler.of(div).set一覧表示の状態(ResponseHolder.getMenuID());
        }

//        div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(simplemodel));
        return ResponseData.of(div).respond();
    }

//    private List<dgSearchSimpleKekkaList_Row> 画面のチェックの設定(SearchSimpleJuminDialogDiv div, List<SearchSimpleJuminResult> 選挙人情報List,
//            Map<ShikibetsuCode, FindShikibetsuTaishoResult> map選挙資格, Map<ShikibetsuCode, FindShikibetsuTaishos> map投票資格, List<FindShikibetsuTaishoResult> 宛名PSM, SenkyoShurui 渡された選挙種類) {
//        List<dgSearchSimpleKekkaList_Row> rowList = new ArrayList<>();
//        List<KeyValueDataSource> 投票資格dataSource = div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedItems();
//        List<KeyValueDataSource> 選挙資格dataSource = div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().getSelectedItems();
//
//        if ((投票資格dataSource.isEmpty() || 投票資格dataSource.size() == INT_3) && !選挙資格dataSource.isEmpty()) {
//            rowList = SearchSimpleJuminDialogHandler.of(div).is投票資格なしと選挙資格ある(div, 選挙人情報List, map選挙資格, map投票資格, 渡された選挙種類);
//            return rowList;
//        }
//        if ((投票資格dataSource.isEmpty() || 投票資格dataSource.size() == INT_3) && 選挙資格dataSource.isEmpty()) {
//            rowList = SearchSimpleJuminDialogHandler.of(div).is選挙資格なしと投票資格なし(div, 選挙人情報List, 宛名PSM, map投票資格, 渡された選挙種類);
//            return rowList;
//        }
//        if (!投票資格dataSource.isEmpty() && !選挙資格dataSource.isEmpty() && 投票資格dataSource.size() < INT_3) {
//            rowList = SearchSimpleJuminDialogHandler.of(div).is投票資格あると選挙資格ある(div, 選挙人情報List, map選挙資格, map投票資格, 渡された選挙種類);
//            return rowList;
//        }
//        if (!投票資格dataSource.isEmpty() && 選挙資格dataSource.isEmpty() && 投票資格dataSource.size() < INT_3) {
//            rowList = SearchSimpleJuminDialogHandler.of(div).is選挙資格なしと投票資格ある(div, 選挙人情報List, 宛名PSM, map投票資格, 渡された選挙種類);
//            return rowList;
//        }
//
//        return rowList;
//
//    }
//
//    private Map is投票資格(SearchSimpleJuminDialogDiv div, SearchSimpleJuminFinder finder, SearchSimpleJuminParameter parameter) {
//        Map map = new HashMap();
//        FindShikibetsuTaishos findShikibetsuTaishos = null;
//        List<KeyValueDataSource> dataSource = div.getSearchSimpleJoken().getChkSearchTohyoShikaku().getSelectedItems();
//
//        if (dataSource.isEmpty() || dataSource.size() == INT_3) {
//            List<FuzaishaShikakuResult> 不在者投票資格リスト = finder.get不在者投票資格();
//            if (!不在者投票資格リスト.isEmpty()) {
//                SearchSimpleJuminDialogHandler.of(div).set条件なし投票資格(不在者投票資格リスト, map, findShikibetsuTaishos);
//            }
//        }
//
//        if (dataSource.size() < INT_3) {
//            for (KeyValueDataSource keyValueDataSource : dataSource) {
//                List<Code> tohyoShikakuShuruiList = new ArrayList<>();
//                tohyoShikakuShuruiList.add(new Code(keyValueDataSource.getKey()));
//                parameter.setTohyoShikakuShuruiList(tohyoShikakuShuruiList);
//                if (keyValueDataSource.getValue().equals(投票資格_郵便) || keyValueDataSource.getValue().equals(投票資格_船員)
//                        || keyValueDataSource.getValue().equals(投票資格_南極)) {
//                    List<SearchSimpleJuminResult> 投票資格の不在者投票資格List = finder.get投票資格の不在者投票資格(parameter);
//                    SearchSimpleJuminDialogHandler.of(div).set投票資格(投票資格の不在者投票資格List, map, findShikibetsuTaishos);
//                }
//            }
//        }
//
//        return map;
//    }
//
    /**
     * 選択するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> closeOK(SearchSimpleJuminDialogDiv div) {

        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(div).validate対象者を選択();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getSelectedItems();
        SearchSimpleJuminModel model = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);

        div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(model));

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 再検索するボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onClick_btnReSearch(SearchSimpleJuminDialogDiv mainPanel) {

        return onLoad(mainPanel);
    }

    /**
     * 検索条件指定パネルの「条件をクリア」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onClick_btnClear(SearchSimpleJuminDialogDiv div) {
        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().clear();
        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setJuminShubetsuDefault(
                new AtenaFinderJuminShubetsuStatus(StatusOfCheckBox.選択, StatusOfCheckBox.未選択,
                        StatusOfCheckBox.未選択, StatusOfCheckBox.未選択));

        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setJuminJotaiDefault(new AtenaFinderJuminJotaiStatus(
                StatusOfCheckBox.選択, StatusOfCheckBox.未選択, StatusOfCheckBox.選択, StatusOfCheckBox.未選択, StatusOfCheckBox.未選択));

        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setRadNihonjinKubun(SearchSimpleJuminDialogEnum.含む.getValue());
        div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho().setRadGaikokujinKubun(SearchSimpleJuminDialogEnum.含まない.getValue());

        div.getSearchSimpleJoken().getCcdTohyokuCode().clear();
        List<RString> keys = new ArrayList<>();
        div.getSearchSimpleJoken().getChkSearchSenkyoShikaku().setSelectedItemsByKey(keys);
        div.getSearchSimpleJoken().getChkSearchTohyoShikaku().setSelectedItemsByKey(keys);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件指定パネルの「条件をクリア」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onClick_CloseCancel(SearchSimpleJuminDialogDiv div) {
        List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getSelectedItems();
        SearchSimpleJuminModel modelデータ = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);
        div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(modelデータ));
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * グリッド内の「選択」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onSelect_dgSearchKekkaList(SearchSimpleJuminDialogDiv div) {
        ShohonNo 抄本番号 = new ShohonNo(div.getTxtHdnShohonNo());
        SearchSimpleJuminModel modelデータ;
        List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getSelectedItems();
        modelデータ = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);
        if (modelデータ.get抄本番号() == null) {
            modelデータ.set抄本番号(抄本番号);
        }
        div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(modelデータ));

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * グリッド内の明細行ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onSelectByDbClick_dgSearchKekkaList(SearchSimpleJuminDialogDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        if (AFAMenuId.AFAMNE1010_期日前投票.menuId().equals(menuID) || AFAMenuId.AFAMNC2010_郵便等投票資格登録.menuId().equals(menuID)) {
            List<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList = div.getSearchSimpleKekkaList().getDgSearchSimpleKekkaList().getSelectedItems();
            SearchSimpleJuminModel modelデータ = SearchSimpleJuminDialogHandler.of(div).set画面データの値(dgSearchSimpleKekkaList);
            div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(modelデータ));
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 表示するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleJuminDialogDiv>
     */
    public ResponseData<SearchSimpleJuminDialogDiv> onClick_btnkHyoji(SearchSimpleJuminDialogDiv div) {
        RString shikibetsuCode = div.getSearchSimpleJoken().getCcdSearchSimpleSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();
        SearchSimpleJuminModel modelデータ = new SearchSimpleJuminModel();
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        識別コードリスト.add(new ShikibetsuCode(shikibetsuCode));
        modelデータ.set識別コードリスト(識別コードリスト);
        ShohonNo 抄本番号 = new ShohonNo(div.getTxtHdnShohonNo());
        modelデータ.set抄本番号(抄本番号);
        div.getSearchSimpleKekkaList().setSearchSimpleJuminModel(DataPassingConverter.serialize(modelデータ));
        return ResponseData.of(div).dialogOKClose();
    }

    private SearchSimpleJuminValidationHandler getValidationHandler(SearchSimpleJuminDialogDiv div) {
        return new SearchSimpleJuminValidationHandler(div);
    }

}
