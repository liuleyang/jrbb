/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoshikaku.SenkyoShikakuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 当日投票
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuKojinJoho {

    private static final RString 一 = new RString("1");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TojitsuKojinJohoDiv
     */
    public static void initialize(TojitsuKojinJohoDiv div) {
        RString menuId = ResponseHolder.getMenuID();
        if (isシミュレーション(menuId)) {
            div.getCcdTojitsuBarCode().initialize(TohyoJokyo.期日前, true);
        } else {
            div.getCcdTojitsuBarCode().initialize(TohyoJokyo.期日前, false);
        }
        div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(true);
        div.getCcdShohonNameList().initialize();
        div.getCcdMeiboBango().initialize();

        setData(div);

    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div TojitsuKojinJohoDiv
     */
    public static void setData(TojitsuKojinJohoDiv div) {

        clearThisPanel(div);
        div.getCcdShohonNameList().changeDdlShohon();

        if (div.getCcdShohonNameList().getShohonListSize() != 0) {
            div.getCcdTohyokuCode().initialize(div.getCcdShohonNameList().getSelectedSenkyoShurui(), true);
        }
    }

    /**
     * 入場券バーコード読み込み時のチェックメソッドです。
     *
     * @param div TojitsuKojinJohoDiv
     * @return チェックOKの時、trueを返す
     */
    public static Boolean isCheckBarCode(TojitsuKojinJohoDiv div) {
        if (!div.getCcdTojitsuBarCode().getBarCode().isEmpty()) {
            Boolean hasShohonNo = div.getCcdTojitsuBarCode().isMatchShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
            if (!hasShohonNo) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 選挙人検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div TojitsuKojinJohoDiv
     */
    public static void checkShikibetsuCode(TojitsuKojinJohoDiv div) {
        clearThisPanel(div);
    }

    /**
     * 選挙資格情報ボタンをクリック時のイベントメソッドです。
     *
     * @param div TojitsuKojinJohoDiv
     * @return ResponseData<TojitsuKojinJohoDiv>
     */
    public ResponseData<TojitsuKojinJohoDiv> onClick_btnShikakuShosai(TojitsuKojinJohoDiv div) {

        if (!div.getLin1().isDisplayNone()) {
            throw new ApplicationException(AfErrorMessages.工事中メッセージ.getMessage());
        }

        return ResponseData.of(div).respond();
    }

    private static void clearThisPanel(TojitsuKojinJohoDiv div) {
        div.getCcdTojitsuBarCode().clearData();
        div.getCcdMeiboBango().clear();
        div.getCcdTohyokuCode().clear();
        div.getTxtSenkyoShikaku().clearValue();
        div.getCcdMeiboBango().clear();

    }

    /**
     * 読込個人情報を設定します。
     *
     * @param div TojitsuKojinJohoDiv
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public static void set選挙人情報と投票情報(TojitsuKojinJohoDiv div) throws IllegalArgumentException {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTxtHdnShikibetsuCode());

        SenkyoninMeibo senkyoninMeibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(
                new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()), 識別コード);

        if (senkyoninMeibo != null) {
            div.getCcdTohyokuCode().initialize(senkyoninMeibo.get投票区コード());
            div.getCcdMeiboBango().initialize(senkyoninMeibo.get冊(),
                    new Decimal(senkyoninMeibo.get頁()), new Decimal(senkyoninMeibo.get行()));
        } else {
            div.getCcdTohyokuCode().initialize();
            div.getCcdMeiboBango().initialize();
        }
        SenkyoShikaku senkyoShikaku = SenkyoShikakuManager.createInstance().get選挙資格By選挙種類と識別コード(
                new Code(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode()), 識別コード);

        if (senkyoShikaku != null) {
            div.getTxtSenkyoShikaku().setValue(CodeMaster.getCodeMeisho(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), senkyoShikaku.get選挙資格区分()));
        }

        div.getCcdKojinJoho().initialize(識別コード);
        div.setTxtHdnSenkyoninFlag(一);

    }

    private static boolean isシミュレーション(RString menuId) {
        return AFAMenuId.AFAMNE7020_当日投票.menuId().equals(menuId);
    }

}
