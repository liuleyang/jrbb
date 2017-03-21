/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3010;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010.ZaigaiMeiboTorokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 在外選挙人名簿登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0320-010 lis
 */
public final class ZaigaiMeiboTorokuValidationHandler {

    private final ZaigaiMeiboTorokuDiv div;

    private ZaigaiMeiboTorokuValidationHandler(ZaigaiMeiboTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static ZaigaiMeiboTorokuValidationHandler of(ZaigaiMeiboTorokuDiv div) {
        return new ZaigaiMeiboTorokuValidationHandler(div);
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public Message validate() {
        IValidationMessages messages = new _ZaigaiMeiboTorokuValidator(div).validate();
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
