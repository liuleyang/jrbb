/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.KyohiJiyuNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.TohyoJiyuCodeDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * TohyoJokyoNyuryokuDiv のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0070-014 liss
 */
public class TohyoJokyoNyuryokuValidationHandler {

    private final TohyoJokyoNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙人投票状況入力Div
     */
    public TohyoJokyoNyuryokuValidationHandler(TohyoJokyoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @param パタン RString
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate(RString パタン) {
        IValidationMessages messages = new TohyoJokyoNyuryokuValidator(div, パタン).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TohyoJokyoNyuryokuValidationMessage.グリッド選択必須, div.getDgTohyoJokyo())
                .add(TohyoJokyoNyuryokuValidationMessage.投票事由コード存在, ((TohyoJiyuCodeDiv) div.getCcdTohyoJiyu()).getTxtTohyoJiyuCode())
                .add(TohyoJokyoNyuryokuValidationMessage.投票日時制約, div.getTxtTohyoYMD())
                .add(TohyoJokyoNyuryokuValidationMessage.拒否事由必須, ((KyohiJiyuNyuryokuDiv) div.getCcdKyohiJiyuNyuryoku()).getDdlKyohiJiyu())
                .build();
    }
}
