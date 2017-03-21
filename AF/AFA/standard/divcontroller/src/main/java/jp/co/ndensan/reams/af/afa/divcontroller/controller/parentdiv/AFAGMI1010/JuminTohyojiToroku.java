/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMI1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyojitoroku.ShohonJohoResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.jumintohyoji.AFABTI101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.dgJushoJokenList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010.JuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010.JuminTohyojiTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010.JuminTohyojiTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.jumintohyojitoroku.JuminTohyojiTorokuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMI1010　住民投票時登録 <br />
 * JuminTohyojiTorokuDivに対応するコントローラです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public class JuminTohyojiToroku {

    private static final RString 新規処理 = new RString("1");
    private static final RString 画面起動チェック_処理可能な = new RString("処理可能な");
    private static final RString チェック = new RString("1");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div JuminTohyojiTorokuDiv
     * @return ResponseData<JuminTohyojiTorokuDiv>
     */
    public ResponseData<JuminTohyojiTorokuDiv> onLoad(JuminTohyojiTorokuDiv div) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        initJushoJoken(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 処理モードクリック時のイベントメソッドです。
     *
     * @param div JuminTohyojiTorokuDiv
     * @return ResponseData<JuminTohyojiTorokuDiv>
     */
    public ResponseData<JuminTohyojiTorokuDiv> onClick_radShori(JuminTohyojiTorokuDiv div) {

        JuminTohyojiTorokuHandler handler = getHandler(div);
        if (新規処理.equals(div.getJuminTohyojiJoho().getRadShori().getSelectedKey())) {
            div.getJuminTohyojiJoho().getCcdShohonNameList().setReadOnlyMode(Boolean.TRUE);
            handler.表示制御();
            initJushoJoken(div);
        } else {
            div.getJuminTohyojiJoho().getCcdShohonNameList().setReadOnlyMode(Boolean.FALSE);
            div.getJuminTohyojiJoho().getCcdShohonNameList().initialize(SenkyoShurui.住民投票);
            if (!ResponseHolder.isReRequest() && div.getJuminTohyojiJoho().getCcdShohonNameList().getDdlShohonItem().getDataSource().isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                        .replace(画面起動チェック_処理可能な.toString())).respond();
            } else if (!ResponseHolder.isReRequest()) {
                setInfomation(div);
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getJuminTohyojiJoho().getRadShori().setSelectedKey(新規処理);
                div.getJuminTohyojiJoho().getCcdShohonNameList().setReadOnlyMode(Boolean.TRUE);
                handler.表示制御();
                initJushoJoken(div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div JuminTohyojiTorokuDiv
     * @return ResponseData<JuminTohyojiTorokuDiv>
     */
    public ResponseData<JuminTohyojiTorokuDiv> onChange_ddlShohon(JuminTohyojiTorokuDiv div) {
        div.getJuminTohyojiJoho().getCcdShohonNameList().changeDdlShohon();
        setInfomation(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時のチェックです。
     *
     * @param div JuminTohyojiTorokuDiv
     * @return ResponseData<JuminTohyojiTorokuDiv>
     */
    public ResponseData<JuminTohyojiTorokuDiv> onClick_batchCheck(JuminTohyojiTorokuDiv div) {
        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        controlErrorPairs.add(div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().gridContextCheck());
        if ((!ResponseHolder.isReRequest() || controlErrorPairs.existsError())
                && !new RString("00").equals(div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().getRadJushoJoken().getSelectedKey())) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時の実行です。
     *
     * @param div JuminTohyojiTorokuDiv
     * @return ResponseData<JuminTohyojiTorokuDiv>
     */
    public ResponseData<AFABTI101BatchParameter> onClick_batchExecute(JuminTohyojiTorokuDiv div) {
        AFABTI101BatchParameter parameter = new AFABTI101BatchParameter();
        parameter.set処理種別(div.getJuminTohyojiJoho().getRadShori().getSelectedKey());
        if (null != div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo()
                && !div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo().isNullOrEmpty()) {
            parameter.set抄本番号(div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo());
        }
        parameter.set抄本名(div.getJuminTohyojiJoho().getTxtShohonName().getValue());
        parameter.set投票日(toFlexibleDate(div.getJuminTohyojiJoho().getTxtTohyoYMD().getValue()));
        parameter.set投票開始日(toFlexibleDate(div.getJuminTohyojiJoho().getTxtTohyoKaishiYMD().getValue()));
        parameter.set日本人フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJapanese().getSelectedKeys()));
        parameter.set外国人フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkForeigner().getSelectedKeys()));
        parameter.set住民フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkJumin().getSelectedKeys()));
        parameter.set転出者フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTenshutsusha().getSelectedKeys()));
        parameter.set転入者フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTennyusha().getSelectedKeys()));
        parameter.set転出日(toFlexibleDate(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTenshutsuYMD().getValue()));
        parameter.set転入日(toFlexibleDate(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getTxtTennyuYMD().getValue()));
        parameter.set抽出対象者に公民権停止者の人を含めるフラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu()
                .getChkTeishishaFukumu().getSelectedKeys()));
        parameter.set年齢計算基準日(toFlexibleDate(div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenreiKijunYmd().getValue()));
        parameter.set何歳以上(toRString(div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getTxtNenrei().getValue()));
        parameter.set基準日翌日の誕生日の人を含むフラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiNenreiJokei()
                .getChkNenreiKijun().getSelectedKeys()));
        parameter.set住定期間From(toFlexibleDate(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().getFromValue()));
        parameter.set住定期間To(toFlexibleDate(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtJuteiKikan().getToValue()));
        parameter.set期間中_年以上連続で居住フラグ(toBoolean(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getChkRenzokuKikan().getSelectedKeys()));
        parameter.set期間中_年以上連続で居住(toRString(div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan()
                .getTxtKyojuNensu().getValue()));
        parameter.set住所条件(div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().getRadJushoJoken().getSelectedValue());
        List<dgJushoJokenList_Row> list = div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().getDgJushoJokenList().getSelectedItems();
        List<RString> 住所一覧リスト = new ArrayList<>();
        if (null != list && !list.isEmpty()) {
            for (dgJushoJokenList_Row row : list) {
                住所一覧リスト.add(row.getTxtJushoJokenCode());
            }
        }
        parameter.set住所条件選択コードリスト(住所一覧リスト);
        parameter.set住民投票資格者名簿抄本フラグ(div.getJuminTohyojiSakuseiChohyo().getJuminTohyojiSakuseiChohyoMeiboShohon().isIsPublish());
        return ResponseData.of(parameter).respond();
    }

    private JuminTohyojiTorokuHandler getHandler(JuminTohyojiTorokuDiv div) {
        return new JuminTohyojiTorokuHandler(div);
    }

    private JuminTohyojiTorokuValidationHandler getValidatorHandler(JuminTohyojiTorokuDiv div) {
        return JuminTohyojiTorokuValidationHandler.of(div);
    }

    private void setInfomation(JuminTohyojiTorokuDiv div) {
        JuminTohyojiTorokuHandler handler = getHandler(div);
        if (!RString.isNullOrEmpty(div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo())) {
            JuminTohyojiTorokuManager 抄本情報Manager = JuminTohyojiTorokuManager.createInstance();
            ShohonNo 抄本番号 = new ShohonNo(div.getJuminTohyojiJoho().getCcdShohonNameList().getSelectedShohonNo());
            ShohonJohoResult 抄本情報 = 抄本情報Manager.get抄本情報(抄本番号);
            handler.画面設定_抄本情報(抄本情報);
            div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().
                    initialize(抄本番号, new Code(SenkyoShurui.定時登録.getCode()));
        } else {
            handler.表示制御();
            initJushoJoken(div);
        }
    }

    private void initJushoJoken(JuminTohyojiTorokuDiv div) {
        div.getJuminTohyojiJoken().getCcdJuminTohyojiJushoJoken().
                initialize(new Code(SenkyoShurui.定時登録.getCode()));
    }

    private FlexibleDate toFlexibleDate(RDate date) {
        if (null == date) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.toDateString());
    }

    private boolean toBoolean(List<RString> keys) {
        return null != keys && !keys.isEmpty() && チェック.equals(keys.get(0));
    }

    private RString toRString(Decimal dec) {
        if (null == dec) {
            return RString.EMPTY;
        }
        return new RString(dec.toString());
    }
}
