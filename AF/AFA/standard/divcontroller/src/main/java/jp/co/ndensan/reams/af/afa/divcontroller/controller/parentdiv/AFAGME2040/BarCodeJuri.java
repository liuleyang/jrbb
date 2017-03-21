/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME2040;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodejuri.BarCodeJuriSearchResult;
import jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku.HojoshaNyuryokuModel;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.AFAGME2040TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.dgBarCodeJuriTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040.BarCodeJuriErrorMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040.BarCodeJuriHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040.BarCodeJuriValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.barcodejuri.BarCodeJuriFinder;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理 <br />
 * BarCodeJuriDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuri {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString 氏名 = new RString("氏名：");
    private static final RString 受付番号 = new RString("受付番号：");
    private static final RString 理由付き = new RString("投票状況が");
    private static final RString 未交付 = new RString("未交付");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onLoad(BarCodeJuriDiv div) {
        ViewState.setメニューID(AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuId());
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME2040TransitionEventName.メニューへ戻る).respond();
        }
        if (!getHandler(div).is正常に初期化する()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }

        return ResponseData.of(div).focusId(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getSelectControlIdForBarCode()).respond();
    }

    /**
     * 受理用バーコード読み込み時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onBlur_txtBarCode(BarCodeJuriDiv div) {
        if (RString.isNullOrEmpty(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getBarCode())) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validateバーコード桁数と一致性();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        controlPairs = getValidationHandler(div).validateバーコード重複();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        ShohonNo shohonNo = new ShohonNo(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getShohonNo());
        ShikibetsuCode shikibetsuCode = div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getShikibetsuCodeJuri();
        SenkyoNo senkyoNo = new SenkyoNo(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getSenkyoNo());
        Code senkyoShurui = new Code(div.getBarCodeJuriNyuryoku().getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
        BarCodeJuriFinder finder = BarCodeJuriFinder.createInstance();
        List<BarCodeJuriSearchResult> results = finder.getバーコード受理一覧(shohonNo, shikibetsuCode, senkyoNo, senkyoShurui).records();

        ViewState.set投票状況データ(results);

        controlPairs = getValidationHandler(div).validate選挙();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        controlPairs = getValidationHandler(div).validate件数();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        controlPairs = getValidationHandler(div).validate投票資格();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        if (results != null && !results.isEmpty()) {
            for (BarCodeJuriSearchResult result : results) {
                if (!result.get投票状況().equals(new Code(TohyoJokyo.交付.getCode()))) {
                    RString 名称 = Code.EMPTY.equals(result.get投票状況()) ? 未交付 : CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票状況.getCodeShubetsu(), result.get投票状況());
                    RString replace = 理由付き.concat(名称);
                    Message errorMsg = AfErrorMessages.投票受付不可_理由付き.getMessage().replace(replace.toString());
                    controlPairs.add(new ValidationMessageControlPair(new BarCodeJuriErrorMessage(errorMsg), div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode()));
                    return ResponseData.of(div).addValidationMessages(controlPairs).respond();
                }
            }
            getHandler(div).setData(results);
            div.getBarCodeJuriNyuryoku().getCcdShohonNameList().setDisabled(true);
        } else {
            Message errorMsg = AfErrorMessages.投票受付不可_理由付き.getMessage().replace(理由付き.concat(未交付).toString());
            controlPairs.add(new ValidationMessageControlPair(new BarCodeJuriErrorMessage(errorMsg), div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode()));
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAccept"), false);
        AccessLogger.log(AccessLogType.照会, PersonalData.of(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getShikibetsuCodeJuri()));
        div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode().clearValue();
        return ResponseData.of(div).focusId(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getSelectControlIdForBarCode()).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onChange_ccdShohonNameList(BarCodeJuriDiv div) {
        BarCodeJuriNyuryokuDiv barCodeJuriNyuryokuパネル = div.getBarCodeJuriNyuryoku();
        barCodeJuriNyuryokuパネル.getDgBarCodeJuriTaishosha().getDataSource().clear();
        barCodeJuriNyuryokuパネル.getCcdShohonNameList().changeDdlShohon();
        return ResponseData.of(div).respond();
    }

    /**
     * グリッド内の削除ボタンクリック時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onClick_dgBarCodeJuriTaishosha_btnDelete(BarCodeJuriDiv div) {
        DataGrid<dgBarCodeJuriTaishosha_Row> dataGrid = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            dataGrid.getDataSource().remove(dataGrid.getClickedRowId());
            if (dataGrid.getDataSource().isEmpty()) {
                div.getBarCodeJuriNyuryoku().getCcdShohonNameList().setDisabled(false);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAccept"), true);
            }
        }
        return ResponseData.of(div).respond();

    }

    /**
     * グリッド内の代理入力ダイアログ表示する前のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onBeforeOpenDialog_btnDairiNyuryoku(BarCodeJuriDiv div) {
        dgBarCodeJuriTaishosha_Row clickedRow = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha().getClickedItem();
        HojoshaNyuryokuModel model = new HojoshaNyuryokuModel();
        model.setShohonNo(new ShohonNo(clickedRow.getTxtShohonNo()));
        model.setTohyokuCode(clickedRow.getTxtTohyokuCode());
        model.setShikibetsuCode(new ShikibetsuCode(clickedRow.getTxtShikibetsuCode()));
        model.setDairiTohyoAri(clickedRow.getChkDairiTohyo());
        model.setShikibetsuCode1(new ShikibetsuCode(clickedRow.getTxtHojoshaShikibetsuCode1()));
        model.setShikibetsuCode2(new ShikibetsuCode(clickedRow.getTxtHojoshaShikibetsuCode2()));
        model.setMeisho1(clickedRow.getTxtHojoshaShimei1());
        model.setMeisho2(clickedRow.getTxtHojoshaShimei2());
        div.setHojoshaNyuryokuModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * グリッド内の代理入力ダイアログ、確定クローズ時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onOkClose_btnDairiNyuryoku(BarCodeJuriDiv div) {
        BarCodeJuriNyuryokuDiv barCodeJuriNyuryokuパネル = div.getBarCodeJuriNyuryoku();
        dgBarCodeJuriTaishosha_Row selectedRow = barCodeJuriNyuryokuパネル.getDgBarCodeJuriTaishosha().getClickedItem();
        HojoshaNyuryokuModel model = DataPassingConverter.deserialize(div.getHojoshaNyuryokuModel(), HojoshaNyuryokuModel.class);
        List<dgBarCodeJuriTaishosha_Row> rowList = barCodeJuriNyuryokuパネル.getDgBarCodeJuriTaishosha().getDataSource();
        for (dgBarCodeJuriTaishosha_Row row : rowList) {
            if (row.equals(selectedRow)) {
                row.setTxtHojoshaShimei1(model.getMeisho1());
                row.setTxtHojoshaShimei2(model.getMeisho2());
                row.setTxtHojoshaShikibetsuCode1(model.getShikibetsuCode1().getColumnValue());
                row.setTxtHojoshaShikibetsuCode2(model.getShikibetsuCode2().getColumnValue());
                row.setChkDairiTohyo(model.getDairiTohyoAri());
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「受理する」をクリックする時のイベントメソッドです。
     *
     * @param div BarCodeJuriDiv
     * @return ResponseData<BarCodeJuriDiv>
     */
    public ResponseData<BarCodeJuriDiv> onClick_btnAccept(BarCodeJuriDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate受理日();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        List<dgBarCodeJuriTaishosha_Row> rowList = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha().getDataSource();
        RDate 受理日 = div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD().getValue();
        for (dgBarCodeJuriTaishosha_Row row : rowList) {
            RDate 投票受付開始年月日 = row.getTxtTohyoUketsukeYMD().getValue();
            RDate 交付年月日 = row.getTxtKofuYMD().getValue();
            if (投票受付開始年月日 != null && 受理日 != null && 受理日.isBefore(投票受付開始年月日)) {
                RString replace = 氏名.concat(row.getTxtShimei()).concat(受付番号).concat(row.getTxtUketsukeNo());
                Message errorMsg = AfErrorMessages.交付日確認.getMessage().replace("受理日", "受付開始日", replace.toString());
                controlPairs.add(new ValidationMessageControlPair(new BarCodeJuriErrorMessage(errorMsg), div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD()));
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            if (交付年月日 != null && 受理日 != null && 受理日.isBefore(交付年月日)) {
                RString replace = 氏名.concat(row.getTxtShimei()).concat(受付番号).concat(row.getTxtUketsukeNo());
                Message errorMsg = AfErrorMessages.交付日確認.getMessage().replace("受理日", "交付日", replace.toString());
                controlPairs.add(new ValidationMessageControlPair(new BarCodeJuriErrorMessage(errorMsg), div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD()));
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean 結果 = getHandler(div).updateData(rowList);
            ShohonNo 抄本番号 = new ShohonNo(div.getBarCodeJuriNyuryoku().getCcdShohonNameList().getSelectedShohonNo());
            KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
            画面引数.setメニューID(AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuId());
            画面引数.set処理結果(結果);
            画面引数.set冊(RString.EMPTY);
            画面引数.set頁(Integer.MIN_VALUE);
            画面引数.set行(Integer.MIN_VALUE);
            画面引数.set氏名(RString.EMPTY);
            画面引数.set抄本番号(抄本番号);
            画面引数.set抄本名(ShohonManager.createInstance().get抄本(抄本番号).get抄本名());
            ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数);

            return ResponseData.of(div).forwardWithEventName(AFAGME2040TransitionEventName.受理).respond();
        }
        return ResponseData.of(div).respond();
    }

    private BarCodeJuriHandler getHandler(BarCodeJuriDiv div) {
        return new BarCodeJuriHandler(div);
    }

    private BarCodeJuriValidationHandler getValidationHandler(BarCodeJuriDiv div) {
        return new BarCodeJuriValidationHandler(div);
    }
}
