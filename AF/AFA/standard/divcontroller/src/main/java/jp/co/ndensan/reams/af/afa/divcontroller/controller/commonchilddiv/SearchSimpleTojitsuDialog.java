/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog.SearchSimpleTojitsuDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog.SearchSimpleTojitsuDialogHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog.dgSearchTojitsuKekkaList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000.SearchJuminErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.searchsimpletojitsu.SearchSimpleTojitsuManager;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCode;
import jp.co.ndensan.reams.ur.urz.definition.core.saikinshoririreki.ScopeCodeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.ISaikinShorishaManager;
import jp.co.ndensan.reams.ur.urz.service.core.saikinshoririreki.RecentUsedManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 当日投票住民検索ダイアログに対応するコントローラです。
 *
 * @reamsid_L AF-0260-020 lis
 */
public class SearchSimpleTojitsuDialog {

    private static final RString RST_0 = new RString("0");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onLoad(SearchSimpleTojitsuDialogDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        ViewState.setメニューID(menuID);
        SenkyoShurui 渡された選挙種類 = SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui());
        ShohonNo 抄本番号 = new ShohonNo(div.getTxtHdnShohonNo());
        RString 渡された投票区コード = div.getTxtHdnTohyokuCode();

        div.getSearchTojitsuJoken().getCcdShohon().initialize(渡された選挙種類);
        div.getSearchTojitsuJoken().getCcdTohyokuCode().initialize(渡された投票区コード);
        div.getSearchTojitsuJoken().getCcdTohyokuCode().setDisabled(true);

        div.getSearchTojitsuJoken().getCcdShohon().selectedShohon(new RString(抄本番号.toString()));
        getHandler(div).change画面To初期化状態();

        int 最大件数の初期値 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, SubGyomuCode.AFA選挙本体).toString());
        div.getSearchTojitsuJoken().getTxtMaxDisplayCount().setValue(new Decimal(最大件数の初期値));
        div.getSearchTojitsuJoken().getCcdSearchTojitsuSaikinShoriTaisho().setInitialLoad(new ScopeCode(ScopeCodeType.個人.getCode()));
        div.getSearchTojitsuJoken().getCcdSearchTojitsuSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();
        div.getSearchTojitsuJoken().getTxtSeibetsu().setSelectedKey(RST_0);
        div.getSearchTojitsuJoken().getDdlMeishoKensaku().setSelectedKey(RST_0);
        if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_名称.configKeyValue())) {
            return ResponseData.of(div).focusId(div.getSearchTojitsuJoken().getTxtMeisho().getSelectControlID()).respond();
        } else if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_生年月日.configKeyValue())) {
            return ResponseData.of(div).focusId(div.getSearchTojitsuJoken().getTxtSeinengappi().getSelectControlID()).respond();
        } else if (BusinessConfig.get(ConfigKeysAFA.検索画面_初期カーソル位置, SubGyomuCode.AFA選挙本体).
                equals(AFAConfigKeysValue.検索画面_初期カーソル位置_投票区コード.configKeyValue())) {
            return ResponseData.of(div).focusId(div.getSearchTojitsuJoken().getCcdTohyokuCode().getTxtTohyokuCode().getSelectControlID()).respond();
        }
        return ResponseData.of(div).focusId(div.getSearchTojitsuJoken().getTxtMeisho().getSelectControlID()).respond();
    }

    /**
     * 検索するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onClick_btnSearch(SearchSimpleTojitsuDialogDiv div) {
        ValidationMessageControlPairs validCheck = new ValidationMessageControlPairs();
        RString 上限値 = BusinessConfig
                .get(ConfigKeysAFA.検索_最大表示件数_上限値, SubGyomuCode.AFA選挙本体);
        if (div.getSearchTojitsuJoken().getTxtMaxDisplayCount().getValue().compareTo(new Decimal(上限値.toString())) > 0) {
            RString replace = 上限値.concat("以下");
            Message errorMsg = UrErrorMessages.項目に対する制約.getMessage().replace("最大表示件数", replace.toString());
            validCheck.add(new ValidationMessageControlPair(new SearchJuminErrorMessages(errorMsg), div.getSearchTojitsuJoken().getTxtMaxDisplayCount()));
            return ResponseData.of(div).addValidationMessages(validCheck).respond();
        }

        List<IdoSearchJumin> rslts = SearchSimpleTojitsuManager.createInstance()
                .get検索結果一覧(getHandler(div).create検索用パラメータ());
        if (rslts == null || rslts.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        } else {
            getHandler(div).change画面To検索結果状態();
            List<dgSearchTojitsuKekkaList_Row> rowList = new ArrayList<>();
            int i = 0;
            for (IdoSearchJumin result : rslts) {
                if (i < div.getSearchTojitsuJoken().getTxtMaxDisplayCount().getValue().intValue()) {
                    dgSearchTojitsuKekkaList_Row row = new dgSearchTojitsuKekkaList_Row();
                    rowList.add(getHandler(div).set検索結果To一覧(div.getSearchTojitsuJoken().getCcdShohon().getSelectedSenkyoShurui(), result, row));
                    i++;
                }
            }
            div.getSearchTojitsuKekkaList().getDgSearchTojitsuKekkaList().setDataSource(rowList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onClick_btnReSearch(SearchSimpleTojitsuDialogDiv div) {
        getHandler(div).clear検索結果一覧データグリッド();
        onClick_btnClear(div);
        getHandler(div).change画面To再検索状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件指定パネルの「条件をクリア」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onClick_btnClear(SearchSimpleTojitsuDialogDiv div) {
        div.getSearchTojitsuJoken().getCcdMeiboBango().clear();
        div.getSearchTojitsuJoken().getTxtMeisho().clearValue();
        div.getSearchTojitsuJoken().getDdlMeishoKensaku().setSelectedKey(RST_0);
        div.getSearchTojitsuJoken().getTxtSeinengappi().clearValue();
        div.getSearchTojitsuJoken().getTxtSeibetsu().setSelectedKey(RST_0);
        int 最大件数の初期値 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.検索_最大表示件数_初期値, SubGyomuCode.AFA選挙本体).toString());
        div.getSearchTojitsuJoken().getTxtMaxDisplayCount().setValue(new Decimal(最大件数の初期値));

        return ResponseData.of(div).respond();
    }

    /**
     * グリッド内の「選択」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onSelect_dgSearchKekkaList(SearchSimpleTojitsuDialogDiv div) {
        dgSearchTojitsuKekkaList_Row dgSearchSimpleKekkaList = div.getSearchTojitsuKekkaList().getDgSearchTojitsuKekkaList().getClickedItem();
        ISaikinShorishaManager manager = RecentUsedManagerFactory.createInstance();
        manager.save(new ScopeCode(ScopeCodeType.個人.getCode()), dgSearchSimpleKekkaList.getTxtShikibetsuCode(), dgSearchSimpleKekkaList.getTxtShimei());
        div.setTxtHdnShikibetsuCode(dgSearchSimpleKekkaList.getTxtShikibetsuCode());
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 検索条件指定パネルの「条件をクリア」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleJuminDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onClick_CloseCancel(SearchSimpleTojitsuDialogDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 表示するボタンクリック時のイベントメソッドです。
     *
     * @param div SearchSimpleTojitsuDialogDiv
     * @return ResponseData<SearchSimpleTojitsuDialogDiv>
     */
    public ResponseData<SearchSimpleTojitsuDialogDiv> onClick_btnkHyoji(SearchSimpleTojitsuDialogDiv div) {
        RString shikibetsuCode = div.getSearchTojitsuJoken().getCcdSearchTojitsuSaikinShoriTaisho().getRecentUsed().get最近処理対象コード();
        div.setTxtHdnShikibetsuCode(shikibetsuCode);
        return ResponseData.of(div).dialogOKClose();
    }

    private SearchSimpleTojitsuDialogHandler getHandler(SearchSimpleTojitsuDialogDiv div) {
        return new SearchSimpleTojitsuDialogHandler(div);
    }
}
