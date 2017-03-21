/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME4010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.JotaiHenkoModel;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.AFAGME4010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.MutohyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.MutohyoNyuryokuJokenDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.dgMutohyoData_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4010.MutohyoNyuryokuHandler;
import jp.co.ndensan.reams.af.afa.service.core.mutohyonyuryoku.MutohyoNyuryokuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 無投票入力コントローラです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public class MutohyoNyuryoku {

    private static final RString KEY_1 = new RString("1");
    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString 無投票入力_投票日前 = new RString("無投票入力_投票日前");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onLoad(MutohyoNyuryokuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME4010TransitionEventName.メニューへ戻る).respond();
        }
        if (!getHandler(div).initialize()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストが選択変更されたときのイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onChange_Shohon(MutohyoNyuryokuDiv div) {
        div.getMutohyoNyuryokuJoken().getCcdShohonNameList().changeDdlShohon();
        RString 選挙Label = new MutohyoNyuryokuManager().senkyoLabel(new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()));
        div.getMutohyoDataNyuryoku().getLblSenkyoRyakuName().setText(選挙Label);
        getHandler(div).initializeCode();
        div.getDgMutohyoData().getDataSource().clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択表示のイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnSelect(MutohyoNyuryokuDiv div) {
        RString msgKey = ViewStateHolder.get(ViewStateKeys.無投票入力_選択メッセージ表示キー, RString.class);
        if (!ResponseHolder.isReRequest()
                && !div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedTohyoYMD().isBefore(RDate.getNowDate())) {
            ViewStateHolder.put(ViewStateKeys.無投票入力_選択メッセージ表示キー, 無投票入力_投票日前);
            return ResponseData.of(div).addMessage(AfWarningMessages.無投票入力_投票日前.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if ((RString.isNullOrEmpty(msgKey) || 無投票入力_投票日前.equals(msgKey)) && !getHandler(div).select()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.remove(ViewStateKeys.無投票入力_選択メッセージ表示キー.toString());
        getHandler(div).outAccessLog(AccessLogType.照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧で１～９のチェックイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onChange_checknull(MutohyoNyuryokuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 全てのチェックを付けるイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnCheckON(MutohyoNyuryokuDiv div) {
        int record = div.getDgMutohyoData().getTotalRecords();
        List<RString> key = new ArrayList<>();
        key.add(KEY_1);
        for (int i = 0; i < record; i++) {
            if (!div.getDgMutohyoData().getDataSource().get(i).getChkAll().isDisabled()) {
                div.getDgMutohyoData().getDataSource().get(i).getChkAll().setSelectedItemsByKey(key);
                getHandler(div).changeCheckAll(i);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 全てのチェックをはずすイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnCheckOFF(MutohyoNyuryokuDiv div) {
        int record = div.getDgMutohyoData().getTotalRecords();
        List<RString> key = new ArrayList<>();
        for (int i = 0; i < record; i++) {
            if (!div.getDgMutohyoData().getDataSource().get(i).getChkAll().isDisabled()) {
                div.getDgMutohyoData().getDataSource().get(i).getChkAll().setSelectedItemsByKey(key);
                getHandler(div).changeCheckAll(i);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧で全てチェックイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onChange_checkall(MutohyoNyuryokuDiv div) {
        int index = div.getMutohyoDataNyuryoku().getDgMutohyoData().getClickedRowId();
        getHandler(div).changeCheckAll(index);
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧で全てチェックイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onBeforeOpenDialog_btnJotaiHenko(MutohyoNyuryokuDiv div) {
        dgMutohyoData_Row clickedItem = div.getDgMutohyoData().getClickedItem();
        MutohyoNyuryokuJokenDiv jokenDiv = div.getMutohyoNyuryokuJoken();
        JotaiHenkoModel model = new JotaiHenkoModel();
        model.setShohonNo(new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()));
        model.setShikibetsuCode(new ShikibetsuCode(clickedItem.getTxtShikibetsuCode()));
        model.setMeisho(new AtenaMeisho(clickedItem.getTxtShimei()));
        model.setSetaiCode(new SetaiCode(clickedItem.getTxtSetaiCode()));
        model.setGroupCode(jokenDiv.getCcdKubunCode().getCode().value());
        model.setTohyokuCode(jokenDiv.getCcdTohyoku().get投票区コード());
        model.setSatsu(jokenDiv.getCcdMeiboBango().get冊());
        model.setPage(jokenDiv.getCcdMeiboBango().get頁());
        model.setGyo(new Decimal(clickedItem.getTxtGyo().toString()));
        div.setJotaiHenkoModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧で全てチェックイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onOKClose_btnJotaiHenko(MutohyoNyuryokuDiv div) {
        getHandler(div).select();
        return ResponseData.of(div).respond();
    }

    /**
     * 前ページイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnBeforePage(MutohyoNyuryokuDiv div) {
        int record = div.getDgMutohyoData().getTotalRecords();
        List<dgMutohyoData_Row> rowList = div.getDgMutohyoData().getDataSource();
        if (getHandler(div).is画面変更(rowList) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (int j = 0; j < record; j++) {
                getHandler(div).saveData(j);
            }
        }

        Decimal 頁 = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁();
        int page = (頁 == null ? 1 : div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁().intValue());
        div.getMutohyoNyuryokuJoken().getCcdMeiboBango().initialize(div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get冊(),
                new Decimal(page - 1), div.getMutohyoNyuryokuJoken().
                getCcdMeiboBango().get行());
        if (!getHandler(div).select()) {
            div.getBtnBefore().setDisabled(true);
            div.getBtnAfter().setDisabled(false);
        } else {
            getHandler(div).outAccessLog(AccessLogType.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 次ページイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnAfterPage(MutohyoNyuryokuDiv div) {
        int record = div.getDgMutohyoData().getTotalRecords();
        List<dgMutohyoData_Row> rowList = div.getDgMutohyoData().getDataSource();
        if (getHandler(div).is画面変更(rowList) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (int j = 0; j < record; j++) {
                getHandler(div).saveData(j);
            }
        }
        Decimal 頁 = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁();
        int page = (頁 == null ? 1 : div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁().intValue());
        div.getMutohyoNyuryokuJoken().getCcdMeiboBango().initialize(div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get冊(),
                new Decimal(page + 1), div.getMutohyoNyuryokuJoken().
                getCcdMeiboBango().get行());
        if (!getHandler(div).select()) {
            div.getBtnBefore().setDisabled(false);
            div.getBtnAfter().setDisabled(true);
        } else {
            getHandler(div).outAccessLog(AccessLogType.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存イベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnSave(MutohyoNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<PersonalData> personalDataList = new ArrayList<>();
            int record = div.getDgMutohyoData().getTotalRecords();
            for (int i = 0; i < record; i++) {
                getHandler(div).saveData(i);
                personalDataList.add(PersonalData.of(new ShikibetsuCode(div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode())));
            }
            AccessLogger.log(AccessLogType.更新, personalDataList);
        }
        getHandler(div).select();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るイベントメソッドです。
     *
     * @param div MutohyoNyuryokuDiv
     * @return ResponseData<MutohyoNyuryokuDiv>
     */
    public ResponseData<MutohyoNyuryokuDiv> onClick_btnBack(MutohyoNyuryokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(AFAGME4010TransitionEventName.メニューへ戻る).respond();
    }

    private MutohyoNyuryokuHandler getHandler(MutohyoNyuryokuDiv div) {
        return new MutohyoNyuryokuHandler(div);
    }
}
