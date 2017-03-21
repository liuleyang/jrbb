/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010.JuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住民投票時登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public class JuminTohyojiTorokuValidationHandler {

    private final JuminTohyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JuminTohyojiTorokuDiv
     */
    public JuminTohyojiTorokuValidationHandler(JuminTohyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 住民投票時登録のDiv
     * @return 住民投票時登録のハンドラ
     */
    public static JuminTohyojiTorokuValidationHandler of(JuminTohyojiTorokuDiv div) {
        return new JuminTohyojiTorokuValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new JuminTohyojiTorokuValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(JuminTohyojiTorokuValidationMessage.抄本未選択, //TODO
                        div.getJuminTohyojiJoho().getTxtShohonName())
                .add(JuminTohyojiTorokuValidationMessage.転出日未入力,
                        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu().getTxtTenshutsuYMD())
                .add(JuminTohyojiTorokuValidationMessage.転入日未入力,
                        div.getJuminTohyojiJoken().getJuminTohyojiJuminShubetsu().getTxtTennyuYMD())
                .add(JuminTohyojiTorokuValidationMessage.住定期間未入力,
                        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan())
                .add(JuminTohyojiTorokuValidationMessage.居住年数未入力,
                        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtKyojuNensu())
                .add(JuminTohyojiTorokuValidationMessage.住定期間大小関係が不正,
                        div.getJuminTohyojiJoken().getJuminTohyojiJuteiKikan().getTxtJuteiKikan())
                .build();
    }
}
