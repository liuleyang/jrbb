/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住所条件選択
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoJokenSelectValidator implements IValidatable {

    private final JushoJokenSelectDiv div;

    /**
     * コンストラクタ
     *
     * @param div 郵便等投票資格登録のDiv
     */
    public JushoJokenSelectValidator(JushoJokenSelectDiv div) {
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
                ifNot(JushoJokenSelectSpec.グリッド未選択).
                thenAdd(getMessages()).
                messages()
        );
        return messages;
    }

    private JushoJokenSelectValidationMessage getMessages() {
        if (RString.isNullOrEmpty(div.getRadioButtonName())) {
            return JushoJokenSelectValidationMessage.エラーなし;
        } else if ("投票区".equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.投票区未選択;
        } else if ("行政区".equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.行政区未選択;
        } else if ("住所".equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.住所未選択;
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１,
                SubGyomuCode.URZ業務共通_共通系).toString().equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.地区1未選択;
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２,
                SubGyomuCode.URZ業務共通_共通系).toString().equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.地区2未選択;
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３,
                SubGyomuCode.URZ業務共通_共通系).toString().equals(div.getRadioButtonName().toString()) && isUnChecked()) {
            return JushoJokenSelectValidationMessage.地区3未選択;
        }
        return JushoJokenSelectValidationMessage.エラーなし;
    }

    private boolean isUnChecked() {
        return null == div.getDgJushoJokenList().getSelectedItems() || div.getDgJushoJokenList().getSelectedItems().isEmpty();
    }
}
