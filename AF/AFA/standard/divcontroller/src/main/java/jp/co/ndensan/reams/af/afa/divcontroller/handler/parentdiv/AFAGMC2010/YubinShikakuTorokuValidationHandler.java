/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.YubinShikakuTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 郵便等投票資格登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class YubinShikakuTorokuValidationHandler {

    private final YubinShikakuTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YubinShikakuTorokuDiv
     */
    public YubinShikakuTorokuValidationHandler(YubinShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 郵便等投票資格登録のDiv
     * @return 郵便等投票資格登録のハンドラ
     */
    public static YubinShikakuTorokuValidationHandler of(YubinShikakuTorokuDiv div) {
        return new YubinShikakuTorokuValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new _YubinShikakuTorokuErrorValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 登録日のチェック
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs validate登録日() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _YubinShikakuTorokuErrorValidator validator = new _YubinShikakuTorokuErrorValidator(div);
        validateResult.add(create登録日ErrorDictionary().check(validator.validate登録日()));
        return validateResult;
    }

    private ValidationDictionary create登録日ErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(YubinShikakuTorokuValidationMessage.登録日未入力, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtShikakuTorokuYMD()).
                build();
    }

    /**
     * 郵便等投票資格登録の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(YubinShikakuTorokuValidationMessage.資格条件を選択です, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().get郵便等投票資格情報().getRadShikakuKubun())
                .add(YubinShikakuTorokuValidationMessage.登録日必須, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtShikakuTorokuYMD())
                .add(YubinShikakuTorokuValidationMessage.交付日必須, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtKofuYMD())
                .add(YubinShikakuTorokuValidationMessage.満了日必須, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtManryoYMD())
                .add(YubinShikakuTorokuValidationMessage.抹消日必須, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtMasshoYMD())
                .add(YubinShikakuTorokuValidationMessage.事由を選択です, div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getCcdMasshoJiyu().getDdlJiyuNameList())
                .build();
    }
}
