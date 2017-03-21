/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME4020;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodetojitsu.BarCodeTojitsuResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.AFAGME4020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.BarCodeTojitsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.dgBarCodeTojitsuTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020.BarCodeTojitsuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020.BarCodeTojitsuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.barcodetojitsu.BarCodeTojitsuManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * バーコード一括当日投票入力のクラス
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsu {

    private static final RString 処理可能な = new RString("処理可能な");
    private final RString 保存する = new RString("btnUpdate");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<YubinShikakuTorokuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onLoad(BarCodeTojitsuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME4020TransitionEventName.メニューへ戻る).respond();
        }
        ViewState.setメニューID(ResponseHolder.getMenuID());
        if (isシミュレーション()) {
            div.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode().initialize(jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo.期日前, true);
        } else {
            div.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode().initialize(jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo.期日前, false);
        }
        div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
        div.getDgBarCodeTojitsuTaishosha().getDataSource().clear();

        div.getCcdShohonNameList().initialize();
        RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
        int shohonListSize = div.getCcdShohonNameList().getShohonListSize();
        if (shohonListSize > 0
                && shohon過去 != null) {
            div.getCcdShohonNameList().selectedShohon(shohon過去);
        } else {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.toString())).respond();
        }
        List<ShikibetsuCode> 識別コードList = ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class);
        if (null != 識別コードList && !識別コードList.isEmpty()) {
            ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class).clear();
        }
        BarCodeTojitsuHandler handler = getHandler(div);
        handler.setDatasource_選挙(div.getCcdShohonNameList().getSelectedShohonNo());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
        return ResponseData.of(div).focusId(div.getCcdNyujokenBarCode().getSelectControlIdForBarCode()).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onChange_ddlShohon(BarCodeTojitsuDiv div) {
        BarCodeTojitsuHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()
                && div.getDgBarCodeTojitsuTaishosha().getDataSource().size() > 0) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().getSelectedShohonNo());
            return ResponseData.of(div).focusId(div.getCcdNyujokenBarCode().getSelectControlIdForBarCode()).respond();
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            handler.clearThisPanel();
        }
        div.getCcdShohonNameList().changeDdlShohon();
        div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().getSelectedShohonNo());
        List<ShikibetsuCode> 識別コードList = ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class);
        if (null != 識別コードList && !識別コードList.isEmpty()) {
            ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class).clear();
        }
        handler.setDatasource_選挙(div.getCcdShohonNameList().getSelectedShohonNo());
        return ResponseData.of(div).focusId(div.getCcdNyujokenBarCode().getSelectControlIdForBarCode()).respond();
    }

    /**
     * 入場券バーコード読み込み時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onBlur_txtBarCode(BarCodeTojitsuDiv div) {
        BarCodeTojitsuHandler handler = getHandler(div);
        IBarCodeNyuryokuDiv barCode = div.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode();
        if (!ResponseHolder.isReRequest() && !barCode.getBarCode().isNullOrEmpty()) {
            ShikibetsuCode 識別コード = barCode.getShikibetsuCodeJuri();
            ShohonNo 抄本番号 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
            Code 選挙種類 = null == div.getCcdShohonNameList().getSelectedSenkyoShurui()
                    ? null : new Code(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode());
            ValidationMessageControlPairs controlPairs = barCode.validateバーコード();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            controlPairs = getValidationHandler(div).validate入場券();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            controlPairs = getValidationHandler(div).validateバーコード重複();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            List<BarCodeTojitsuResult> 選挙人名簿データ = BarCodeTojitsuManager.createInstance()
                    .getTohyoChohyoData(選挙種類, 抄本番号, 識別コード);
            ViewState.set選挙人名簿データ(選挙人名簿データ);
            controlPairs = getValidationHandler(div).validate件数();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            div.setHdnShikakuKubun(handler.get投票資格(選挙人名簿データ));
            controlPairs = getValidationHandler(div).validate投票資格();
            if (controlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
            AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
            List<ShikibetsuCode> 識別コードlist = new ArrayList<>();
            List<ShikibetsuCode> 識別コードListold = ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class);
            if (null != 識別コードListold && !識別コードListold.isEmpty()) {
                識別コードlist = 識別コードListold;
            }
            識別コードlist.add(識別コード);
            ViewStateHolder.put(ViewStateKeys.識別コードlist, (Serializable) 識別コードlist);
            handler.set投票対象者一覧(選挙人名簿データ);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
            div.getCcdNyujokenBarCode().getTxtBarCode().clearValue();
        }
        return getResponseData(div);
    }

    /**
     * 全チェックボックスを選択時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onChange_chkAll(BarCodeTojitsuDiv div) {
        BarCodeTojitsuHandler handler = getHandler(div);
        Boolean is全 = div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkAll().isAllSelected();
        if (is全) {
            handler.チェックボックスon();
        } else {
            handler.チェックボックスoff();
        }
        return getResponseData(div);
    }

    /**
     * 保存するボタンクリック時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onClick_btnUpdate(BarCodeTojitsuDiv div) {
        List<ShikibetsuCode> 識別コードlist = (ArrayList<ShikibetsuCode>) ViewStateHolder.get(ViewStateKeys.識別コードlist, ArrayList.class);
        BarCodeTojitsuHandler handler = getHandler(div);
        List<dgBarCodeTojitsuTaishosha_Row> rowList = div.getDgBarCodeTojitsuTaishosha().getDataSource();
        ShohonNo 抄本番号 = new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        BarCodeTojitsuManager barCodeTojitsuManager = BarCodeTojitsuManager.createInstance();
        List<TohyoJokyoBuilder> builderList = new ArrayList<>();
        for (dgBarCodeTojitsuTaishosha_Row row : rowList) {
            ShikibetsuCode row識別コード = new ShikibetsuCode(row.getHdnShikibetsuCode());
            List<SenkyoNo> row選挙番号list = handler.get選択された選挙番号(row);
            if (null != row選挙番号list
                    && !row選挙番号list.isEmpty()) {
                for (int i = 0; i < row選挙番号list.size(); i++) {
                    TohyoJokyo 元投票状況 = new TohyoJokyo(抄本番号, row識別コード, row選挙番号list.get(i));
                    TohyoJokyoBuilder builder = getHandler(div).edit投票状況(元投票状況);
                    builderList.add(builder);
                }
            }
        }
        boolean 処理結果 = barCodeTojitsuManager.saveData投票(builderList);
//        if (!処理結果) {
//            getHandler(div).setDisableMode();
//            return ResponseData.of(div).addMessage(UrErrorMessages.排他_他ユーザが更新済み.getMessage()).respond();
//        }
        List<PersonalData> personalDataList = new ArrayList<>();
        for (ShikibetsuCode 更新対象 : 識別コードlist) {
            personalDataList.add(PersonalData.of(更新対象));
        }
        AccessLogger.log(AccessLogType.更新, personalDataList);
        KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
        画面引数.set抄本番号(抄本番号);
        Shohon 抄本 = ShohonManager.createInstance().get抄本(抄本番号);
        画面引数.set抄本名(null == 抄本.get抄本名()
                ? RString.EMPTY : 抄本.get抄本名());
        画面引数.setメニューID(AFAMenuId.AFAMNE4020_バーコード一括当日投票入力.menuId());
        画面引数.set処理結果(処理結果);
        画面引数.set投票区コード(RString.EMPTY);
        画面引数.set冊(RString.EMPTY);
        画面引数.set氏名(RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.完了確認, 画面引数);
        return ResponseData.of(div).forwardWithEventName(AFAGME4020TransitionEventName.処理終了).respond();
    }

    /**
     * グリッド内の削除ボタンクリック時のイベントメソッドです。
     *
     * @param div BarCodeTojitsuDiv
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> onClick_dgBarCodeTojitsuTaishosha_btnDelete(BarCodeTojitsuDiv div) {

        div.getDgBarCodeTojitsuTaishosha().getDataSource().remove(div.getDgBarCodeTojitsuTaishosha().getClickedRowId());
        return getResponseData(div);
    }

    private static BarCodeTojitsuHandler getHandler(BarCodeTojitsuDiv div) {
        return new BarCodeTojitsuHandler(div);
    }

    private static BarCodeTojitsuValidationHandler getValidationHandler(BarCodeTojitsuDiv div) {
        return new BarCodeTojitsuValidationHandler(div);
    }

    private ResponseData<BarCodeTojitsuDiv> getResponseData(BarCodeTojitsuDiv div) {
        return ResponseData.of(div).respond();
    }

    private boolean isシミュレーション() {
        RString menuId = ResponseHolder.getMenuID();
        return AFAMenuId.AFAMNA2010_定時登録.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4020_選挙情報修正.menuId().equals(menuId)
                || AFAMenuId.AFAMNB4030_入場券発行個別.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7010_期日前投票.menuId().equals(menuId)
                || AFAMenuId.AFAMNE7020_当日投票.menuId().equals(menuId);
    }
}
