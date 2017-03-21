/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 請求代表者証明書交付のバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public final class SeikyushaTorokuValidationHandler {

    private final SeikyushaTorokuDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     */
    public SeikyushaTorokuValidationHandler(SeikyushaTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static SeikyushaTorokuValidationHandler of(SeikyushaTorokuDiv div) {
        return new SeikyushaTorokuValidationHandler(div);
    }

    /**
     * 「署名簿を作成する」ボタンクリック時のチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SeikyushaTorokuValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {

        List<ViewControl> seikyuKofuList = new ArrayList<>();
        seikyuKofuList.add(div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD());
        seikyuKofuList.add(div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD());
        List<ViewControl> kofuTeishuList = new ArrayList<>();
        kofuTeishuList.add(div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD());
        kofuTeishuList.add(div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD());

        return new ValidationDictionaryBuilder()
                .add(SeikyushaTorokuValidationMessage.請求日交付日大小チェック, seikyuKofuList)
                .add(SeikyushaTorokuValidationMessage.交付日提出期限日大小チェック, kofuTeishuList)
                .add(SeikyushaTorokuValidationMessage.請求代表者選択チェック, div.getDgSeikyushaTorokuDaihyoshaIchiran())
                .build();
    }
}
