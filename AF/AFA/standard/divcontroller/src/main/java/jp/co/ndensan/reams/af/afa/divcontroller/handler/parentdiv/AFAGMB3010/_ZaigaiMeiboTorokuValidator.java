/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 在外選挙人名簿登録のValidator
 *
 * @reamsid_L AF-0320-010 lis
 */
public class _ZaigaiMeiboTorokuValidator implements IValidatable {

    private final ZaigaiMeiboTorokuDiv div;

    _ZaigaiMeiboTorokuValidator(ZaigaiMeiboTorokuDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ZaigaiMeiboTorokuSpec.在住情報の住定日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在住情報の住定日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.在住情報の住定日関連のチェック_転出日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在住情報の住定日関連のチェック_転出日以降).
                ifNot(ZaigaiMeiboTorokuSpec.本人情報の最終住所エリアの転出日関連のチェック).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.本人情報の最終住所エリアの転出日関連のチェック).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の申請日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の申請日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の申請日関連のチェック_住定日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の申請日関連のチェック_住定日以降).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の申請取下げ日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の申請取下げ日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の申請取下げ日関連のチェック_申請日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の申請取下げ日関連のチェック_申請日以降).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の登録日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の登録日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の登録日関連のチェック_申請日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の登録日関連のチェック_申請日以降).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の登録日関連のチェック_規定年齢到達日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の登録日関連のチェック_規定年齢到達日).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の登録日関連のチェック_転入3か月経過).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の登録日関連のチェック_転入3か月経過).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の選挙人証交付日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の選挙人証交付日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の選挙人証交付日関連のチェック_登録日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の選挙人証交付日関連のチェック_登録日以降).
                ifNot(ZaigaiMeiboTorokuSpec.申請情報の選挙人証交付日関連のチェック_交付履歴).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請情報の選挙人証交付日関連のチェック_交付履歴).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の表示日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の表示日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の表示日関連のチェック_登録日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の表示日関連のチェック_登録日以降).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の国内転入日関連のチェック_表示事由).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の国内転入日関連のチェック_表示事由).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の国内転入日関連のチェック_抹消事由).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の国内転入日関連のチェック_抹消事由).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の修正日関連のチェック_未来日).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の修正日関連のチェック_未来日).
                ifNot(ZaigaiMeiboTorokuSpec.在外選挙人名簿情報の修正日関連のチェック_登録日以降).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.在外選挙人名簿情報の修正日関連のチェック_登録日以降).
                ifNot(ZaigaiMeiboTorokuSpec.申請取下げ日取下げ事由のチェック_申請取下げ日未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請取下げ日取下げ事由のチェック_申請取下げ日未入力).
                ifNot(ZaigaiMeiboTorokuSpec.申請取下げ日取下げ事由のチェック_取下げ事由未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.申請取下げ日取下げ事由のチェック_取下げ事由未入力).
                ifNot(ZaigaiMeiboTorokuSpec.却下日却下事由のチェック_却下日未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.却下日却下事由のチェック_却下日未入力).
                ifNot(ZaigaiMeiboTorokuSpec.却下日却下事由のチェック_却下事由未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.却下日却下事由のチェック_却下事由未入力).
                ifNot(ZaigaiMeiboTorokuSpec.表示日表示事由のチェック_表示日未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.表示日表示事由のチェック_表示日未入力).
                ifNot(ZaigaiMeiboTorokuSpec.表示日表示事由のチェック_表示事由未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.表示日表示事由のチェック_表示事由未入力).
                ifNot(ZaigaiMeiboTorokuSpec.抹消日抹消事由のチェック_抹消日未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.抹消日抹消事由のチェック_抹消日未入力).
                ifNot(ZaigaiMeiboTorokuSpec.抹消日抹消事由のチェック_抹消事由未入力).
                thenAdd(ZaigaiMeiboTorokuValidationMessage.抹消日抹消事由のチェック_抹消事由未入力).
                messages());
        return messages;
    }

}
