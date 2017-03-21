/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住所条件選択のバリデーションハンドラです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoJokenSelectValidationHandler {

    private final JushoJokenSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JushoJokenSelectDiv
     */
    public JushoJokenSelectValidationHandler(JushoJokenSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 郵便等投票資格登録のDiv
     * @return 郵便等投票資格登録のハンドラ
     */
    public static JushoJokenSelectValidationHandler of(JushoJokenSelectDiv div) {
        return new JushoJokenSelectValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new JushoJokenSelectValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(JushoJokenSelectValidationMessage.投票区未選択, div.getDgJushoJokenList())
                .add(JushoJokenSelectValidationMessage.行政区未選択, div.getDgJushoJokenList())
                .add(JushoJokenSelectValidationMessage.住所未選択, div.getDgJushoJokenList())
                .add(JushoJokenSelectValidationMessage.地区1未選択, div.getDgJushoJokenList())
                .add(JushoJokenSelectValidationMessage.地区2未選択, div.getDgJushoJokenList())
                .add(JushoJokenSelectValidationMessage.地区3未選択, div.getDgJushoJokenList())
                .build();
    }

}
