package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.YubinShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.YubinShikakuHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YubinShikaku のクラスファイル
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class YubinShikaku extends Panel {

    /**
     * 資格区分のonLoadのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onLoad(YubinShikakuDiv div) {
        getHandler(div).load(new ShikibetsuCode(div.getTxtHdnShikibetsuCode()), div.getTxtHdnSenkyoShurui());
        return ResponseData.of(div).respond();
    }

    /**
     * 資格区分のonChangeのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onChange_radShikakuKubun(YubinShikakuDiv div) {
        getHandler(div).onChange_radShikakuKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 交付日のonBlurのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onBlur_txtKofuYMD(YubinShikakuDiv div) {
        getHandler(div).onBlur_txtKofuYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 「直接入力する」ボタンのonClickのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onClick_btnDirectInput(YubinShikakuDiv div) {
        getHandler(div).onClick_btnDirectInput();
        return ResponseData.of(div).respond();
    }

    /**
     * 「クリアする」ボタンのonClickのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onClick_btnClear(YubinShikakuDiv div) {
        getHandler(div).onClick_btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「生年月日」onBlurのイベントメソッドです。
     *
     * @param div YubinShikakuDiv
     * @return ResponseData
     */
    public ResponseData<YubinShikakuDiv> onBlur_txtDairiSeinengappiYMD(YubinShikakuDiv div) {
        getHandler(div).set年齢();
        return ResponseData.of(div).respond();
    }

    private YubinShikakuHandler getHandler(YubinShikakuDiv div) {
        return new YubinShikakuHandler(div);
    }
}
