/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住所条件選択のバリデーションメッセージです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public enum JushoJokenSelectValidationMessage implements IValidationMessage {

    /**
     * エラーなし。
     */
    エラーなし(UrErrorMessages.選択されていない, ""),
    /**
     * 投票区未選択。
     */
    投票区未選択(UrErrorMessages.選択されていない, "投票区"),
    /**
     * 行政区未選択。
     */
    行政区未選択(UrErrorMessages.選択されていない, "行政区"),
    /**
     * 住所未選択。
     */
    住所未選択(UrErrorMessages.選択されていない, "住所"),
    /**
     * 地区1未選択。
     */
    地区1未選択(UrErrorMessages.選択されていない, BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１,
            SubGyomuCode.URZ業務共通_共通系).toString()),
    /**
     * 地区2未選択。
     */
    地区2未選択(UrErrorMessages.選択されていない, BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２,
            SubGyomuCode.URZ業務共通_共通系).toString()),
    /**
     * 地区3未選択。
     */
    地区3未選択(UrErrorMessages.選択されていない, BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３,
            SubGyomuCode.URZ業務共通_共通系).toString());

    private final Message message;

    private JushoJokenSelectValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 郵便等投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
