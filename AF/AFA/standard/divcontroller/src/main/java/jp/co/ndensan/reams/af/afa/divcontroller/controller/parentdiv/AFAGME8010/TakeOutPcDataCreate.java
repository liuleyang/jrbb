/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME8010;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.AFABTE801BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.AFAGME8010TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.TakeOutPcDataCreateDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.dgShohonSenkyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010.TakeOutPcDataCreateHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010.TakeOutPcDataCreateValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.takeoutpcdatacreate.TakeOutPcDataCreateManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGME8010　持出端末用データ作成 <br />
 * TakeOutPcDataCreateDivに対応するコントローラです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataCreate extends HttpServlet {

    private static final RString 画面起動チェック_処理可能な = MochidashiPcCreateDataEnum.処理可能な.getRString();

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TakeOutPcDataCreateDiv
     * @return ResponseData<TakeOutPcDataCreateDiv>
     */
    public ResponseData<TakeOutPcDataCreateDiv> onLoad(TakeOutPcDataCreateDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME8010TransitionEventName.メニューへ戻る).respond();
        }
        ViewState.setメニューID(ResponseHolder.getMenuID());
        getHandler(div).画面設定_投票日ドロップダウン(get端末用Manager().getシステム日付以上の投票日());
        getHandler(div).画面設定_一覧グリッド(get端末用Manager().get端末用データ(new FlexibleDate(div.getDdlTohyoYmd().getSelectedKey())));
        if (!ResponseHolder.isReRequest() && div.getDgShohonSenkyo().getDataSource().isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                    .replace(画面起動チェック_処理可能な.toString())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * USB当日受付システムボタンクリック時のイベントメソッドです。
     *
     * @param div TakeOutPcDataCreateDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_usbSystemDownLoad(TakeOutPcDataCreateDiv div, IDownLoadServletResponse response) {

        ServletContext servletContext = getServletContext();
        return SharedFileDirectAccessDownload.download(new RString(
                servletContext.getRealPath("/WEB-INF/usbApplication/usbVoteSystem.zip")), response);
    }

    /**
     * 投票日ロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div TakeOutPcDataCreateDiv
     * @return ResponseData<TakeOutPcDataCreateDiv>
     */
    public ResponseData<TakeOutPcDataCreateDiv> onChange_ddlTohyoYmd(TakeOutPcDataCreateDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME8010TransitionEventName.メニューへ戻る).respond();
        }
        getHandler(div).画面設定_一覧グリッド(get端末用Manager().get端末用データ(new FlexibleDate(div.getDdlTohyoYmd().getSelectedKey())));
        if (!ResponseHolder.isReRequest() && div.getDgShohonSenkyo().getDataSource().isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                    .replace(画面起動チェック_処理可能な.toString())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時のチェックです。
     *
     * @param div TakeOutPcDataCreateDiv
     * @return ResponseData<TakeOutPcDataCreateDiv>
     */
    public ResponseData<TakeOutPcDataCreateDiv> onClick_batchCheck(TakeOutPcDataCreateDiv div) {
        List<dgShohonSenkyo_Row> rows = div.getDgShohonSenkyo().getDataSource();
        List<ShohonNo> shohonNos = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            shohonNos.add(new ShohonNo(rows.get(i).getTxtShohonNo()));
        }
        div.setDataCreatFlg(get端末用Manager().get受渡データ作成有無(shohonNos));
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時の実行です。
     *
     * @param div TakeOutPcDataCreateDiv
     * @return ResponseData<TakeOutPcDataCreateDiv>
     */
    public ResponseData<AFABTE801BatchParameter> onClick_batchExecute(TakeOutPcDataCreateDiv div) {
        AFABTE801BatchParameter parameter = new AFABTE801BatchParameter();
        parameter.set投票日(new FlexibleDate(div.getDdlTohyoYmd().getSelectedKey()));
        return ResponseData.of(parameter).respond();
    }

    private TakeOutPcDataCreateHandler getHandler(TakeOutPcDataCreateDiv div) {
        return new TakeOutPcDataCreateHandler(div);
    }

    private TakeOutPcDataCreateManager get端末用Manager() {
        return TakeOutPcDataCreateManager.createInstance();
    }

    private TakeOutPcDataCreateValidationHandler getValidatorHandler(TakeOutPcDataCreateDiv div) {
        return TakeOutPcDataCreateValidationHandler.of(div);
    }

}
