/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 署名簿登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public final class SeikyuShomeiboTorokuValidationHandler {

    private final SeikyuShomeiboTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SeikyuShomeiboTorokuDiv
     */
    public SeikyuShomeiboTorokuValidationHandler(SeikyuShomeiboTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiHenkoDiv
     * @return SeikyuShomeiboTorokuValidationHandler
     */
    public static SeikyuShomeiboTorokuValidationHandler of(SeikyuShomeiboTorokuDiv div) {
        return new SeikyuShomeiboTorokuValidationHandler(div);
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new SeikyuShomeiboTorokuValidator(div).validate();
        validResult.add(createDictionary().check(message));
        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SeikyuShomeiboTorokuValidationMessage.署名状況に無効を選択した無効事由未入力エラー, div.getDgSeikyuShomeiboShomeishaIchiran())
                .build();
    }
}
