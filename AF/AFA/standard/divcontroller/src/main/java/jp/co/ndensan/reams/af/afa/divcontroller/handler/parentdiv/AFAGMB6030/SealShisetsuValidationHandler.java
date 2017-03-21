/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB6030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 施設宛名シールのチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public final class SealShisetsuValidationHandler implements IValidatable {

    private final SealShisetsuDiv div;

    /**
     * 実行するチェック
     *
     * @return
     */
    private SealShisetsuValidationHandler(SealShisetsuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static SealShisetsuValidationHandler of(SealShisetsuDiv div) {
        return new SealShisetsuValidationHandler(div);
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = new SealShisetsuValidator(div).validate();
        if (null == messages || 0 == messages.getSize()) {
            return null;
        }
        RStringBuilder builder = new RStringBuilder();
        for (IValidationMessage message : messages.getList()) {
            builder.append(message.getMessage().evaluate());
        }
//        AfErrorMessages.未入力エラー.getMessage().replace(builder.toString());

        return messages;
    }
}
