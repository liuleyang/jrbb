/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030.NankyokuShikakuTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 南極投票資格登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0220-010 guyq
 */
public class NankyokuShikakuTorokuValidationHandler {

    private final NankyokuShikakuTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NankyokuShikakuTorokuDiv
     */
    public NankyokuShikakuTorokuValidationHandler(NankyokuShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 郵便等投票資格登録のDiv
     * @return 郵便等投票資格登録のハンドラ
     */
    public static NankyokuShikakuTorokuValidationHandler of(NankyokuShikakuTorokuDiv div) {
        return new NankyokuShikakuTorokuValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateエラーチェックです南極() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new _NankyokuShikakuTorokuErrorValidator(div).validate();
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
                .add(NankyokuShikakuTorokuValidationMessage.登録日必須, div.getCcdNankyokuShikakuJoho().get不在者資格情報().getTxtShikakuTorokuYMD())
                .add(NankyokuShikakuTorokuValidationMessage.交付日必須, div.getCcdNankyokuShikakuJoho().get不在者資格情報().getTxtKofuYMD())
                .add(NankyokuShikakuTorokuValidationMessage.有効期限日必須, div.getCcdNankyokuShikakuJoho().get不在者資格情報().getTxtManryoYMD())
                .add(NankyokuShikakuTorokuValidationMessage.抹消日必須, div.getCcdNankyokuShikakuJoho().get不在者資格情報().getTxtMasshoYMD())
                .add(NankyokuShikakuTorokuValidationMessage.事由を選択です, div.getCcdNankyokuShikakuJoho().get不在者資格情報().getCcdMasshoJiyu().getDdlJiyuNameList())
                .build();
    }
}
