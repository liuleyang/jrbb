/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1010;

import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.AtenaHelper;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【View】KijitsumaeTohyoDiv内の <br />
 * KijitsumaeKojinJohoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeKojinJoho {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KijitsumaeKojinJohoDiv
     */
    public static void initialize(KijitsumaeKojinJohoDiv div) {
        RString menuId = ResponseHolder.getMenuID();
        if (menuId.equals(AFAMenuId.AFAMNE7010_期日前投票.menuId())) {
            div.getCcdKijitsumaeBarCode().initialize(TohyoJokyo.期日前, true);
        } else {
            div.getCcdKijitsumaeBarCode().initialize(TohyoJokyo.期日前, false);
        }
        div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(true);
        div.getCcdShohonNameList().initialize();
        div.getCcdMeiboBango().initialize();

        setData(div);

    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div KijitsumaeKojinJohoDiv
     */
    public static void setData(KijitsumaeKojinJohoDiv div) {

        clearThisPanel(div);
        div.getCcdShohonNameList().changeDdlShohon();

        // 投票区コードの設定
        if (div.getCcdShohonNameList().getShohonListSize() != 0) {
            div.getCcdTohyokuCode().initialize(div.getCcdShohonNameList().getSelectedSenkyoShurui(), true);
        }
    }

    /**
     * 入場券バーコード読み込み時のチェックメソッドです。
     *
     * @param div KijitsumaeKojinJohoDiv
     * @return チェックOKの時、trueを返す
     */
    public static Boolean isCheckBarCode(KijitsumaeKojinJohoDiv div) {
//本来はonChangeで、文字数をチェックしつつ、必要桁数に達したら個人情報等を読み込む感じか？
        if (!div.getCcdKijitsumaeBarCode().getBarCode().isEmpty()) {
            Boolean chkShohonNo = div.getCcdKijitsumaeBarCode().isMatchShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
            if (!chkShohonNo) {
                // バーコードで読み取った抄本番号と、DDLの抄本番号が不一致の時エラー
//                throw new ApplicationException(AfErrorMessages.入場券確認.getMessage());
                return Boolean.FALSE;
            }

        }
        return Boolean.TRUE;
    }

    /**
     * 選挙人検索ボタン（簡易版）の確定クローズイベントメソッドです。
     *
     * @param div KijitsumaeTohyoDiv
     */
    public static void checkShikibetsuCode(KijitsumaeKojinJohoDiv div) {
        clearThisPanel(div);
    }

    /**
     * 選挙資格情報ボタンをクリック時のイベントメソッドです。
     *
     * @param div KijitsumaeKojinJohoDiv
     * @return ResponseData<KijitsumaeKojinJohoDiv>
     */
    public ResponseData<KijitsumaeKojinJohoDiv> onClick_btnShikakuShosai(KijitsumaeKojinJohoDiv div) {

        if (!div.getLin1().isDisplayNone()) {
            // 当たり前の条件で、とりあえずエラーにしておく。ほんとは、共有子DIVを作って、ダイアログ？補足情報？
            throw new ApplicationException(AfErrorMessages.工事中メッセージ.getMessage());
        }

        return ResponseData.of(div).respond();
    }

    private static void clearThisPanel(KijitsumaeKojinJohoDiv div) {
        div.getCcdKijitsumaeBarCode().clearData();
        div.getCcdMeiboBango().clear();
        div.getCcdTohyokuCode().clear();
        div.getTxtSenkyoShikaku().clearValue();
        div.getCcdMeiboBango().clear();

    }

    /**
     * 読込個人情報を設定します。
     *
     * @param div KijitsumaeKojinJohoDiv
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public static void set読込個人情報(KijitsumaeKojinJohoDiv div) throws IllegalArgumentException {
        // 識別コード取得
        ShikibetsuCode shikibetsuCode;
        shikibetsuCode = new ShikibetsuCode(div.getTxtHdnShikibetsuCode());

        // 個人の選挙関連情報取得
        SenkyoninMeibo meibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(
                new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()), shikibetsuCode);

        if (meibo != null) {
            div.getCcdTohyokuCode().initialize(meibo.get投票区コード());
            div.getCcdMeiboBango().initialize(meibo.get冊(),
                    new Decimal(meibo.get頁()), new Decimal(meibo.get行()));
        } else {
//            div.getCcdTohyokuCode().initialize();
//            div.getCcdMeiboBango().initialize();                   
            RString replaces = new RString("抄本：").concat(div.getCcdShohonNameList().getSelectedShohonName()).concat("　に、識別コード：")
                    .concat(shikibetsuCode.value()).concat("　の住民が存在しません。");
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(replaces.toString()));
        }
//        SenkyoShikaku shikaku = SenkyoShikakuManager.createInstance().get選挙資格By選挙種類と識別コード(
//                new Code(div.getCcdShohonNameList().getSelectedSenkyoShurui().getCode()), shikibetsuCode);
//
//        if (shikaku != null) {
//            div.getTxtSenkyoShikaku().setValue(CodeMaster.getCodeMeisho(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), shikaku.get選挙資格区分()));
//        }
        // 宛名情報取得
        div.getCcdKojinJoho().getCcdKojinJohoUR().load(AtenaHelper.createSearchKeyForAtenaShokaiSimple(shikibetsuCode));
    }

}
