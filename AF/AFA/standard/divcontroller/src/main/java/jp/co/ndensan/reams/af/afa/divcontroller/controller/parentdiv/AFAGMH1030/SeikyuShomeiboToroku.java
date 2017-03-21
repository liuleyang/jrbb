/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMH1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku.SeikyushaTorokuJoho;
import jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog.SearchSimpleJuminModel;
import jp.co.ndensan.reams.af.afa.business.seikyushaselect.SeikyushaSelectGamenData;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.Aft403ShomeiboResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.ShomeiboResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.審査区分_2;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.dgSeikyuShomeiboShomeishaIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.seikyushomeibotoroku.SeikyuShomeiboTorokuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 署名簿登録
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class SeikyuShomeiboToroku {

    /**
     * 初期化イベントです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return SeikyuShomeiboTorokuDiv
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onLoad(SeikyuShomeiboTorokuDiv div) {
        int 直接請求番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.直接請求番号, RString.class).toString());
        div.setTxtHdnSeikyuNo(new RString(直接請求番号));
        RString 請求名 = ViewStateHolder.get(ViewStateKeys.請求名, RString.class);
        div.setTxtHdnShohonNo(ViewStateHolder.get(ViewStateKeys.抄本番号, RString.class));
        div.setTxtHdnSenkyoShurui(ViewStateHolder.get(ViewStateKeys.住民検索_選挙種類, SenkyoShurui.class).getCode());
        List<Aft403ShomeiboResult> 署名者情報 = getManager().get署名者情報(直接請求番号);
        getHandler(div).setタグ出力順();
        getHandler(div).set署名者一覧と請求名(署名者情報, 請求名);
        ViewStateHolder.put(ViewStateKeys.直接請求データ, getManager().get直接請求データ(直接請求番号));
        initial署名を集計(直接請求番号, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 署名状況ドロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return ResponseData<SeikyuShomeiboTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onChange_ddlShomeiJokyo(SeikyuShomeiboTorokuDiv div) {
        dgSeikyuShomeiboShomeishaIchiran_Row row = div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem();
        if (row.getDdlShomeiJokyo().getSelectedKey().equals(審査区分_2.getKey())) {
            div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem().getTxtMukoJiyu().setDisabled(false);
        } else {
            div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem().getTxtMukoJiyu().setSelectedKey(row.getMukoJiyuselectedkey());
            div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem().getTxtMukoJiyu().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 署名件数表（投票区別）タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiKensuTohyoku(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 署名件数表（住所別）タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiKensuJusho(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 無効件数無効事由内訳表（投票区別）タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiMukoTohyoku(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 無効件数無効事由内訳表（住所別）タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiMukoJusho(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 年齢別投票率集計表タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiNenrei(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 年代別投票率集計表タグ選択のイベントです。
     *
     * @param div 返戻帳票照会Div
     * @return ResponseData
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_tplSeikyuShomeiboShukeiNendai(SeikyuShomeiboTorokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「住民を検索する」ボタン押下時のイベントメソッドです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return ResponseData<SeikyuShomeiboTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onBeforeOpenDialog_btnSearchSimple(SeikyuShomeiboTorokuDiv div) {
        SearchSimpleJuminModel searchSimpleJuminModel = new SearchSimpleJuminModel();
        searchSimpleJuminModel.set抄本番号(new ShohonNo(div.getTxtHdnShohonNo()));
        searchSimpleJuminModel.set選挙種類(SenkyoShurui.toValue(div.getTxtHdnSenkyoShurui()));
        div.setSearchSimpleJuminModel(DataPassingConverter.serialize(searchSimpleJuminModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 「住民を検索する」ボタン押下時のイベントメソッドです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return ResponseData<SeikyuShomeiboTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onOkClose_btnSearchSimple1(SeikyuShomeiboTorokuDiv div) {
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        ShohonNo shohonNo = new ShohonNo(div.getTxtHdnShohonNo());
        if (null != model && null != model.get識別コードリスト() && !model.get識別コードリスト().isEmpty()) {
            ShikibetsuCode 識別コード = model.get識別コードリスト().get(0);
            SeikyushaTorokuJoho 署名者情報と代筆者選択情報 = getManager().get署名者情報と代筆者選択情報(shohonNo, 識別コード);
            div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource().add(getHandler(div).createRow_署名者(署名者情報と代筆者選択情報));
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「代筆者選択」ボタン押下時のイベントメソッドです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return ResponseData<SeikyuShomeiboTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onOkClose_btnSearchSimple2(SeikyuShomeiboTorokuDiv div) {
        SearchSimpleJuminModel model = DataPassingConverter.deserialize(div.getSearchSimpleJuminModel(), SearchSimpleJuminModel.class);
        ShohonNo shohonNo = new ShohonNo(div.getTxtHdnShohonNo());
        if (null != model && null != model.get識別コードリスト() && !model.get識別コードリスト().isEmpty()) {
            ShikibetsuCode 識別コード = model.get識別コードリスト().get(0);
            SeikyushaTorokuJoho 署名者情報と代筆者選択情報 = getManager().get署名者情報と代筆者選択情報(shohonNo, 識別コード);
            dgSeikyuShomeiboShomeishaIchiran_Row row = div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem();
            div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource().remove(div.getDgSeikyuShomeiboShomeishaIchiran().getClickedRowId());
            div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource().add(getHandler(div).createRow_代筆者(row, 署名者情報と代筆者選択情報));
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「不明者登録」ボタンのイベントです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return SeikyuShomeiboTorokuDiv
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_btnAddRow(SeikyuShomeiboTorokuDiv div) {
        div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource().add(getHandler(div).createEmptyRow());
        return ResponseData.of(div).respond();
    }

    /**
     * 請求代表者一覧.削除ボタンクリックイベントメソッドです。
     *
     * @param div SeikyushaTorokuDiv
     * @return ResponseData<SeikyushaTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onSelectByDeleteButton(SeikyuShomeiboTorokuDiv div) {
        dgSeikyuShomeiboShomeishaIchiran_Row row = div.getDgSeikyuShomeiboShomeishaIchiran().getClickedItem();
        List<dgSeikyuShomeiboShomeishaIchiran_Row> rows = div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource();
        rows.remove(row);
        div.getDgSeikyuShomeiboShomeishaIchiran().setDataSource(rows);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンのイベントです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     * @return ResponseData<SeikyuShomeiboTorokuDiv>
     */
    public ResponseData<SeikyuShomeiboTorokuDiv> onClick_btnUpdate(SeikyuShomeiboTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlPairs = getValidatorHandler(div).validate();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int 直接請求番号 = Integer.parseInt(div.getTxtHdnSeikyuNo().toString());
            SeikyushaSelectGamenData 直接請求データ = ViewStateHolder.get(ViewStateKeys.直接請求データ, SeikyushaSelectGamenData.class);
            直接請求データ.setTorokuZumiFlag(true);
            直接請求データ.setShohonNo(new ShohonNo(div.getTxtHdnShohonNo()));
            List<dgSeikyuShomeiboShomeishaIchiran_Row> datasource = div.getDgSeikyuShomeiboShomeishaIchiran().getDataSource();
            if (null != datasource && !datasource.isEmpty()) {
                List<ShikibetsuCode> 識別コードlist = new ArrayList<>();
                for (dgSeikyuShomeiboShomeishaIchiran_Row row : datasource) {
                    識別コードlist.add(null == row.getTxtShikibetsuCode()
                            ? ShikibetsuCode.EMPTY : new ShikibetsuCode(row.getTxtShikibetsuCode()));

                }
                out保存アクセスロ(識別コードlist);
                getManager().deleteSAndInsert署名者情報(直接請求番号, getHandler(div).create更新データ(直接請求番号, datasource), 直接請求データ);
            }
            initial署名を集計(直接請求番号, div);
            getHandler(div).ファイル書込み();
        }

        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyuShomeiboTorokuDiv> initial署名を集計(int 直接請求番号, SeikyuShomeiboTorokuDiv div) {
        div.getDgSeikyuShomeiboShukeiKensuJusho().getDataSource().clear();
        div.getDgSeikyuShomeiboShukeiKensuTohyoku().getDataSource().clear();
        div.getDgSeikyuShomeiboShukeiMukoJusho().getDataSource().clear();
        div.getDgSeikyuShomeiboShukeiMukoTohyoku().getDataSource().clear();
        div.getDgSeikyuShomeiboShukeiNenrei().getDataSource().clear();
        div.getDgSeikyuShomeiboShukeiNendai().getDataSource().clear();
        List<ShomeiboResult> 署名件数表_投票区別データ = getManager().get署名件数表_投票区別データ(直接請求番号);
        List<ShomeiboResult> 署名件数表_住所別データ = getManager().get署名件数表_住所別データ(直接請求番号);
        List<ShomeiboResult> 無効件数無効事由内訳表_投票区別データ = getManager().get無効件数無効事由内訳表_投票区別データ(直接請求番号);
        List<ShomeiboResult> 無効件数無効事由内訳表_住所別データ = getManager().get無効件数無効事由内訳表_住所別データ(直接請求番号);
        List<ShomeiboResult> 年齢別年代別データ_不明者 = getManager().get年齢別年代別データ_不明者(直接請求番号);
        List<ShomeiboResult> 年齢別年代別データ = getManager().get年齢別年代別データ(直接請求番号);
        int 署名者名簿データの件数 = getManager().get署名者名簿データ件数(直接請求番号);
        getHandler(div).set署名件数表_投票区別タグ(署名件数表_投票区別データ);
        getHandler(div).set署名件数表_住所別タグ(署名件数表_住所別データ);
        getHandler(div).set無効件数無効事由内訳表_投票区別タグ(無効件数無効事由内訳表_投票区別データ);
        getHandler(div).set無効件数無効事由内訳表_住所別タグ(無効件数無効事由内訳表_住所別データ);
        getHandler(div).set年齢別投票率集計表タグ_不明者(年齢別年代別データ_不明者, 署名者名簿データの件数);
        getHandler(div).set年齢別投票率集計表タグ(年齢別年代別データ, 署名者名簿データの件数);
        getHandler(div).set年代別投票率集計表タグ_不明者(年齢別年代別データ_不明者, 署名者名簿データの件数);
        getHandler(div).set年代別投票率集計表タグ(年齢別年代別データ, 署名者名簿データの件数);
        return ResponseData.of(div).respond();
    }

    private SeikyuShomeiboTorokuHandler getHandler(SeikyuShomeiboTorokuDiv div) {
        return new SeikyuShomeiboTorokuHandler(div);
    }

    private SeikyuShomeiboTorokuManager getManager() {
        return SeikyuShomeiboTorokuManager.createInstance();
    }

    private void out保存アクセスロ(List<ShikibetsuCode> 識別コードList) {
        List<PersonalData> personalDataList = new ArrayList<>();
        for (ShikibetsuCode 更新対象 : 識別コードList) {
            personalDataList.add(PersonalData.of(更新対象));
        }
        AccessLogger.log(AccessLogType.更新, personalDataList);
    }

    private SeikyuShomeiboTorokuValidationHandler getValidatorHandler(SeikyuShomeiboTorokuDiv div) {
        return new SeikyuShomeiboTorokuValidationHandler(div);
    }
}
