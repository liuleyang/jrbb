/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020.ZaigaiHenkoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 証明書記載事項変更のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public final class ZaigaiHenkoValidationHandler {

    private final ZaigaiHenkoDiv div;

    private ZaigaiHenkoValidationHandler(ZaigaiHenkoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiHenkoDiv
     * @return ZaigaiHenkoValidationHandler
     */
    public static ZaigaiHenkoValidationHandler of(ZaigaiHenkoDiv div) {
        return new ZaigaiHenkoValidationHandler(div);
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public Message validate() {
        IValidationMessages messages = new _ZaigaiHenkoValidator(div).validate();
        if (null == messages || 0 == messages.getSize()) {
            return null;
        }
        RStringBuilder builder = new RStringBuilder();
        for (IValidationMessage message : messages.getList()) {
            builder.append(message.getMessage().evaluate());
        }
        return AfWarningMessages.処理の続行確認.getMessage().replace(builder.toString());
    }
}
