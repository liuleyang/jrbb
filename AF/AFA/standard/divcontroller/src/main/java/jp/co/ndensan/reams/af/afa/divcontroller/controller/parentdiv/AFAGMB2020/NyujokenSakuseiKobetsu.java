/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB2020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.FindShikibetsuTaishoResult;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.AFABTB202BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.AFAGMB2020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.dgNyujokenKobetsuTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuHandler;
import jp.co.ndensan.reams.af.afa.service.core.searchsimplejumin.SearchSimpleJuminFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGMB2020 選挙　入場券作成（個別）<br />
 * NyujokenSakuseiKobetsuDivに対するコントローラです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public class NyujokenSakuseiKobetsu {

    private static final RString 処理可能な = new RString("処理可能な");
    private static final RString 全角スペース = new RString("　");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onLoad(NyujokenSakuseiKobetsuDiv mainPanel) {
        mainPanel.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource().clear();
        RString menuId = ResponseHolder.getMenuID();
        if (!ResponseHolder.isReRequest()) {
            mainPanel.getCcdNyujokenKobetsuShohonSelect().initialize();
            int 抄本Size = mainPanel.getCcdNyujokenKobetsuShohonSelect().getCcdShohonNameList().getShohonListSize();
            if (抄本Size == 0) {
                return ResponseData.of(mainPanel).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
            }
            RString 印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
            RString 世帯印字人数 = BusinessConfig.get(ConfigKeysAFA.入場券_世帯印字人数, SubGyomuCode.AFA選挙本体);
            mainPanel.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtNyujokenType().setValue(
                    AFAInsakuTypeEnum.getAFAInsakuTypeEnumByCode(印刷タイプ).getValue());
            if (!世帯印字人数.isNullOrEmpty()) {
                mainPanel.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType().setValue(new Decimal(世帯印字人数.toString()));
            }

            NyujokenSakuseiKobetsuHandler.of(mainPanel).set画面状態(印刷タイプ);
        } else {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMB2020TransitionEventName.メニューへ戻る).respond();
        }

        RString rootTitle = NyujokenSakuseiKobetsuHandler.of(mainPanel).setTitle(menuId);

        return ResponseData.of(mainPanel).rootTitle(rootTitle).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onChange_ccdShohonNameList(NyujokenSakuseiKobetsuDiv mainPanel) {
        ResponseData<NyujokenSakuseiKobetsuDiv> response = new ResponseData<>();
        mainPanel.getCcdNyujokenKobetsuShohonSelect().initialSetting();
        RString 印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        NyujokenSakuseiKobetsuHandler.of(mainPanel).set画面状態(印刷タイプ);

        response.data = mainPanel;
        return response;
    }

    /**
     * 取消ボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiIkkatsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onClick_dgNyujokenKobetsuTaishosha_btnDelete(NyujokenSakuseiKobetsuDiv div) {
        ResponseData<NyujokenSakuseiKobetsuDiv> response = new ResponseData<>();
        dgNyujokenKobetsuTaishosha_Row row = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getClickedItem();
        div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource().remove(row);
        response.data = div;
        return response;
    }

    /**
     * 選挙人を検索するボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onBeforeOpenDialog_btnSearchSimple(NyujokenSakuseiKobetsuDiv div) {
        ResponseData<NyujokenSakuseiKobetsuDiv> response = new ResponseData<>();
        List<dgNyujokenKobetsuTaishosha_Row> row = div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().
                getDgNyujokenKobetsuTaishosha().getDataSource();
        SearchSimpleJuminModel searchSimpleJuminModel = new SearchSimpleJuminModel();
        searchSimpleJuminModel.set抄本番号(new ShohonNo(div.getCcdNyujokenKobetsuShohonSelect().get抄本番号()));
        searchSimpleJuminModel.set選挙種類(SenkyoShurui.valueOf(div.getCcdNyujokenKobetsuShohonSelect().get選挙種類().toString()));
        div.getNyujokenKobetsuSakuseiTaisho().setSearchSimpleJuminModel(DataPassingConverter.serialize(searchSimpleJuminModel));
        if (!ResponseHolder.isReRequest() && !row.isEmpty()) {
            return ResponseData.of(div).addMessage(AfQuestionMessages.画面クリア.getMessage(ButtonSelectPattern.OKCancel)).respond();
        }

        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().getDataSource().removeAll(row);
        }

        response.data = div;
        return response;
    }

    /**
     * 選挙人を検索するボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onOkClose_btnSearchSimple(NyujokenSakuseiKobetsuDiv div) {
        ResponseData<NyujokenSakuseiKobetsuDiv> response = new ResponseData<>();

        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getNyujokenKobetsuSakuseiTaisho().getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        FlexibleDate 基準年月日 = model.get基準年月日() == null ? FlexibleDate.getNowDate() : model.get基準年月日();
        List<ShikibetsuCode> 識別コードリスト = model.get識別コードリスト();
        List<dgNyujokenKobetsuTaishosha_Row> rowList = new ArrayList<>();
        List<FindShikibetsuTaishoResult> 宛名PSM = new ArrayList<>();
        SearchSimpleJuminFinder finder = SearchSimpleJuminFinder.createInstance();
        if (識別コードリスト != null && !識別コードリスト.isEmpty()) {
            for (ShikibetsuCode 識別コード : 識別コードリスト) {
                List<FindShikibetsuTaishoResult> 宛名 = finder.get宛名PSM(識別コード, 基準年月日);
                if (宛名 != null && !宛名.isEmpty()) {
                    for (FindShikibetsuTaishoResult findShikibetsuTaishoResult : 宛名) {
                        宛名PSM.add(findShikibetsuTaishoResult);
                    }
                }
            }
        }
        if (!宛名PSM.isEmpty()) {
            for (FindShikibetsuTaishoResult findShikibetsuTaishoResult : 宛名PSM) {
                AtenaMeisho atenaMeisho = findShikibetsuTaishoResult.get宛名PSM().getKanjiShimei();
                dgNyujokenKobetsuTaishosha_Row row = new dgNyujokenKobetsuTaishosha_Row();
                row.setTxtShimei(get氏名(atenaMeisho));

                row.setTxtJusho(get住登内住所(findShikibetsuTaishoResult.get宛名PSM().getJutonaiJusho()).concat(get住登内番地(findShikibetsuTaishoResult
                        .get宛名PSM().getJutonaiBanchi())).concat(全角スペース).concat(get住登内方書(findShikibetsuTaishoResult.get宛名PSM().getJutonaiKatagaki())));

                RString 性別コード = findShikibetsuTaishoResult.get宛名PSM().getSeibetsuCode();

                row.setTxtSeibetsu(get性別名称(性別コード));

                row.setTxtSetaiCode(get世帯コード(findShikibetsuTaishoResult.get宛名PSM().getSetaiCode()));

                row.setTxtShikibetsuCode(get識別コード(findShikibetsuTaishoResult.get宛名PSM().getShikibetsuCode()));

                RString 住民種別コード = findShikibetsuTaishoResult.get宛名PSM().getJuminShubetsuCode();

                RString 生年月日 = format生年月日(findShikibetsuTaishoResult.get宛名PSM().getSeinengappiYMD(), 住民種別コード);

                if (!生年月日.isEmpty()) {
                    row.getTxtSeinengappiYMD().setValue(new RDate(生年月日.toString()));
                }

                row.setTxtJuminShubetsu(get住民種別名称(住民種別コード));
                rowList.add(row);
            }
            div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha().setDataSource(rowList);
        }
        List<PersonalData> personalDataList = new ArrayList<>();
        if (識別コードリスト != null && !識別コードリスト.isEmpty()) {
            for (ShikibetsuCode 識別コード : 識別コードリスト) {
                personalDataList.add(PersonalData.of(識別コード));
            }
        }

        AccessLogger.log(AccessLogType.照会, personalDataList);

        response.data = div;
        return response;
    }

    private RString get識別コード(ShikibetsuCode 識別コード) {
        return 識別コード == null ? RString.EMPTY : 識別コード.getColumnValue();
    }

    private RString get世帯コード(SetaiCode 世帯コード) {
        return 世帯コード == null ? RString.EMPTY : 世帯コード.getColumnValue();
    }

    private RString get住民種別名称(RString 住民種別コード) {

        return 住民種別コード == null ? RString.EMPTY : JuminShubetsu.toValue(住民種別コード).toRString();
    }

    private RString get住登内方書(Katagaki katagaki) {
        return katagaki == null ? RString.EMPTY : katagaki.getColumnValue();
    }

    private RString get住登内番地(AtenaBanchi banchi) {
        return banchi == null ? RString.EMPTY : banchi.getColumnValue();
    }

    private RString get住登内住所(RString 住登内住所) {
        return 住登内住所 == null ? RString.EMPTY : 住登内住所;
    }

    private RString get性別名称(RString 性別コード) {

        if (性別コード != null) {
            return null == Gender.toValue(性別コード) ? RString.EMPTY
                    : changeNullToEmpty(Gender.toValue(性別コード).getCommonName());
        }
        return RString.EMPTY;
    }

    private RString format生年月日(FlexibleDate 生年月日, RString 住民種別コード) {
        RString 画面生年月日 = RString.EMPTY;
        if (住民種別コード != null && 生年月日 != null && 住民種別コード.equals(JuminShubetsu.日本人.getCode())) {
            画面生年月日 = 生年月日.wareki().toDateString();
        } else if (住民種別コード != null && 生年月日 != null && 住民種別コード.equals(JuminShubetsu.外国人.getCode())) {
            画面生年月日 = 生年月日.seireki().toDateString();
        } else {
            if (生年月日 != null) {
                画面生年月日 = new RString(生年月日.toString());
            }
        }
        return 画面生年月日;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private RString get氏名(AtenaMeisho atenaMeisho) {
        return atenaMeisho == null ? RString.EMPTY : atenaMeisho.value();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<NyujokenSakuseiKobetsuDiv> onClick_btnBatchCheck(NyujokenSakuseiKobetsuDiv div) {
        return NyujokenSakuseiKobetsuHandler.of(div).check入力内容();
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param div NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiKobetsuDiv>
     */
    public ResponseData<AFABTB202BatchParameter> onClick_setBatchParameter(NyujokenSakuseiKobetsuDiv div) {
        ResponseData<AFABTB202BatchParameter> response = new ResponseData<>();
        RString menuId = ResponseHolder.getMenuID();
        response.data = NyujokenSakuseiKobetsuHandler.of(div).set画面入力内容(menuId);
        return response;
    }

}
