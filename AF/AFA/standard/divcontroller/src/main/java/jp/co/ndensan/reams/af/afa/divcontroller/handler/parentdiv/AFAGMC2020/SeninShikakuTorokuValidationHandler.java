/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.SeninShikakuTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 洋上投票資格登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0210-010 liuj2
 */
public class SeninShikakuTorokuValidationHandler {

    private final SeninShikakuTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SeninShikakuTorokuDiv
     */
    public SeninShikakuTorokuValidationHandler(SeninShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 郵便等投票資格登録のDiv
     * @return 郵便等投票資格登録のハンドラ
     */
    public static SeninShikakuTorokuValidationHandler of(SeninShikakuTorokuDiv div) {
        return new SeninShikakuTorokuValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new _SeninShikakuTorokuErrorValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 郵便等投票資格登録の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SeninShikakuTorokuValidationMessage.登録日必須, div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtShikakuTorokuYMD())
                .add(SeninShikakuTorokuValidationMessage.交付日必須, div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtKofuYMD())
                .add(SeninShikakuTorokuValidationMessage.有効期限日必須, div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtManryoYMD())
                .add(SeninShikakuTorokuValidationMessage.抹消日必須, div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtMasshoYMD())
                .add(SeninShikakuTorokuValidationMessage.事由を選択です, div.getCcdSeninShikakuJoho().get不在者資格情報().getCcdMasshoJiyu().getDdlJiyuNameList())
                .build();
    }
}
