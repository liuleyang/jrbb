/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 定時登録のValidationHandlerクラス
 *
 */
public class TeijiTorokuValidationHandler {

    private final TeijiTorokuDiv div;

    public TeijiTorokuValidationHandler(TeijiTorokuDiv div) {
        this.div = div;

    }

    public ValidationMessageControlPairs validate必須項目(Boolean is実行, Boolean isError) {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        TeijiTorokuValidator validator = new TeijiTorokuValidator(div, is実行, isError);
        validateResult.add(createDictionary(is実行, isError).check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionary(Boolean is実行, Boolean isError) {
        if (!is実行) {
            return new ValidationDictionaryBuilder().
                    add(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                    add(TeijiTorokuValidationMessage.登録日必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD()).
                    add(TeijiTorokuValidationMessage.転出期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD()).
                    add(TeijiTorokuValidationMessage.転入期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD()).
                    add(TeijiTorokuValidationMessage.年齢期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD()).
                    build();
        } else {
            if (isError) {
                return new ValidationDictionaryBuilder().
                        add(TeijiTorokuValidationMessage.基準日必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                        add(TeijiTorokuValidationMessage.登録日必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD()).
                        add(TeijiTorokuValidationMessage.転出期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD()).
                        add(TeijiTorokuValidationMessage.転入期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD()).
                        add(TeijiTorokuValidationMessage.年齢期限必須項目を入力, div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD()).
                        add(TeijiTorokuValidationMessage.基準日と登録日の関係性チェック, div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD()).
                        add(TeijiTorokuValidationMessage.未来基準日抄本確認, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                        add(TeijiTorokuValidationMessage.定時未実施確認, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                        add(TeijiTorokuValidationMessage.同一基準日抄本確認, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                        add(TeijiTorokuValidationMessage.過去抄本再処理確認, div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD()).
                        build();
            } else {
                return new ValidationDictionaryBuilder().
                        add(TeijiTorokuValidationMessage.年齢期限日と基準日の関係性チェック, div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD()).
                        add(TeijiTorokuValidationMessage.転入期限と基準日の関係性チェック, div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD()).
                        add(TeijiTorokuValidationMessage.転出期限と基準日の関係性チェック, div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD()).
                        add(TeijiTorokuValidationMessage.転出期限と転入期限の関係性チェック, div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD()).
                        build();
            }
        }
    }

}
