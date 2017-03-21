/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.ZaigaiShuseiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 在外選挙人名簿修正のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public final class ZaigaiShuseiValidationHandler {

    private final ZaigaiShuseiDiv div;

    private ZaigaiShuseiValidationHandler(ZaigaiShuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiHenkoDiv
     * @return ZaigaiShuseiValidationHandler
     */
    public static ZaigaiShuseiValidationHandler of(ZaigaiShuseiDiv div) {
        return new ZaigaiShuseiValidationHandler(div);
    }

    /**
     * 「保存する」ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public Message validate() {
        IValidationMessages messages = new _ZaigaiShuseiValidator(div).validate();
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
