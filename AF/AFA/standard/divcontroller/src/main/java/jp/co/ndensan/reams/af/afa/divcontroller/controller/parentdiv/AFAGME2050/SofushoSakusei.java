/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.af.afa.definition.batchprm.shisetsusofusho.AFABTE205BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.AFAGME2050TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.SofushoSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050.SofushoSakuseiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 施設送付書発行コントローラです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public class SofushoSakusei {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");
    private static final RString 発行番号_送付書 = new RString("送付書");
    private static final int 発行番号_番号の長 = 10;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SofushoSakuseiDiv
     * @return ResponseData<SofushoSakuseiDiv>
     */
    public ResponseData<SofushoSakuseiDiv> onLoad(SofushoSakuseiDiv div) {
        if (!getHandler(div).initialize() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(AFAGME2050TransitionEventName.メニューへ戻る).respond();
        }
        div.getSofushoSakuseiJoken().getCcdHakkoBango().initialize(発行番号_送付書);
        div.getSofushoSakuseiJoken().getTxtHakkoYMD().setValue(RDate.getNowDate());
        div.getSofushoSakuseiJoken().getCcdShisetsuCode().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストが選択変更されたときのイベントメソッドです。
     *
     * @param div SofushoSakuseiDiv
     * @return ResponseData<SofushoSakuseiDiv>
     */
    public ResponseData<SofushoSakuseiDiv> onChange_ddlShohon(SofushoSakuseiDiv div) {
        div.getCcdSofushoShohonSenkyoList().initialSetting();
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SofushoSakuseiDiv
     * @return ResponseData<SofushoSakuseiDiv>
     */
    public ResponseData<SofushoSakuseiDiv> onClick_checkbox(SofushoSakuseiDiv div) {
        div.getCcdSofushoShohonSenkyoList().changeflag();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを起動して帳票を作成する。
     *
     * @param div SofushoSakuseiDiv
     * @return ResponseData<SofushoSakuseiDiv>
     */
    public ResponseData<SofushoSakuseiDiv> onBeforeOpenDialog_BatchCheck(SofushoSakuseiDiv div) {
        return getHandler(div).check入力内容();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div SofushoSakuseiDiv
     * @return ResponseData<AFABTE205BatchParameter>
     */
    public ResponseData<AFABTE205BatchParameter> onClick_setBatchParameter(SofushoSakuseiDiv div) {
        AFABTE205BatchParameter param = new AFABTE205BatchParameter();
        RString 抄本番号 = div.getCcdSofushoShohonSenkyoList().getCcdShohonNameList().getSelectedShohonNo();
        if (!RString.isNullOrEmpty(抄本番号)) {
            param.set抄本番号(抄本番号);
        } else {
            param.set抄本番号(new RString("0"));
        }
        param.set無投票選挙も出力する(div.getCcdSofushoShohonSenkyoList().無投票選挙check());
        RString 発行番号_第 = div.getSofushoSakuseiJoken().getCcdHakkoBango().get発行番号_第();
        if (発行番号_第 == null) {
            発行番号_第 = RString.EMPTY;
        }
        RString 発行番号_番号 = div.getSofushoSakuseiJoken().getCcdHakkoBango().get発行番号_番号();
        if (発行番号_番号 == null) {
            発行番号_番号 = RString.EMPTY.padLeft(RString.HALF_SPACE, 発行番号_番号の長);
        } else {
            発行番号_番号 = 発行番号_番号.padLeft(RString.HALF_SPACE, 発行番号_番号の長);
        }
        RString 発行番号_号 = div.getSofushoSakuseiJoken().getCcdHakkoBango().get発行番号_号();
        if (発行番号_号 == null) {
            発行番号_号 = RString.EMPTY;
        }
        param.set発行番号(発行番号_第.concat(発行番号_番号).concat(発行番号_号));
        RDate 発行日 = div.getSofushoSakuseiJoken().getTxtHakkoYMD().getValue();
        if (発行日 == null) {
            param.set発行日(FlexibleDate.EMPTY);
        } else {
            param.set発行日(new FlexibleDate(発行日.toDateString()));
        }

        param.set施設コード開始(div.getSofushoSakuseiJoken().getCcdShisetsuCode().get施設コードFROM());
        param.set施設コード終了(div.getSofushoSakuseiJoken().getCcdShisetsuCode().get施設コードTO());

        RDate 交付日開始 = div.getSofushoSakuseiJoken().getTxtKofuYMD().getFromValue();
        if (交付日開始 == null) {
            param.set交付日開始(FlexibleDate.EMPTY);
        } else {
            param.set交付日開始(new FlexibleDate(交付日開始.toDateString()));
        }
        RDate 交付日終了 = div.getSofushoSakuseiJoken().getTxtKofuYMD().getToValue();
        if (交付日終了 == null) {
            param.set交付日終了(FlexibleDate.EMPTY);
        } else {
            param.set交付日終了(new FlexibleDate(交付日終了.toDateString()));
        }
        return ResponseData.of(param).respond();
    }

    private SofushoSakuseiHandler getHandler(SofushoSakuseiDiv div) {
        return new SofushoSakuseiHandler(div);
    }
}
