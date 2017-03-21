/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 海区対象抄本情報共有子Divのバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public final class KaikuTaishoShohonJohoValidationHandler {

    private final KaikuTaishoShohonJohoDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     */
    public KaikuTaishoShohonJohoValidationHandler(KaikuTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static KaikuTaishoShohonJohoValidationHandler of(KaikuTaishoShohonJohoDiv div) {
        return new KaikuTaishoShohonJohoValidationHandler(div);
    }

    /**
     * 親画面で実行ボタンを押下時のチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KaikuTaishoShohonJohoValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KaikuTaishoShohonJohoValidationMessage.基準日投票日大小チェック)
                .add(KaikuTaishoShohonJohoValidationMessage.基準日受付開始日大小チェック)
                .add(KaikuTaishoShohonJohoValidationMessage.受付開始日投票日大小チェック)
                .build();
    }
}
