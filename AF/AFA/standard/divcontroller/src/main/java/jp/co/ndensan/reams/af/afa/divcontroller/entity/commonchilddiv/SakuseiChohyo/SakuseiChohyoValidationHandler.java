/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 作成帳票共有子DIVのValidationHandlerクラス
 */
public class SakuseiChohyoValidationHandler {

    private final SakuseiChohyoDiv div;

    public SakuseiChohyoValidationHandler(SakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * 必須項目validate処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate必須項目() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        SakuseiChohyoValidator validator = new SakuseiChohyoValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder().
                add(SakuseiChohyoValidationMessage.二重登録通知_転入期間,
                        div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan()).
                add(SakuseiChohyoValidationMessage.帰化期間, div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan()).
                add(SakuseiChohyoValidationMessage.二重登録調査票_転出期間,
                        div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan()).
                add(SakuseiChohyoValidationMessage.永久選挙人名簿_出力条件,
                        div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange(),
                        div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu()).
                build();
    }
}
