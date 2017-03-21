/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.TakeOutPcDataCaptureDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 持出端末データ取込。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class TakeOutPcDataCaptureValidator implements IValidatable {

    private final TakeOutPcDataCaptureDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TakeOutPcDataCaptureDiv
     */
    public TakeOutPcDataCaptureValidator(TakeOutPcDataCaptureDiv div) {
        this.div = div;
    }

    /**
     * 共有ファイル化されたファイルが、チェックします。
     *
     * @return エラーメッセージ
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TakeOutPcDataCaptureSpec.取込対象ファイル必須チェック)
                .thenAdd(TakeOutPcDataCaptureValidationMessage.取込対象ファイル必須チェック)
                .ifNot(TakeOutPcDataCaptureSpec.投票日確認)
                .thenAdd(TakeOutPcDataCaptureValidationMessage.投票日確認)
                .ifNot(TakeOutPcDataCaptureSpec.投票区確認)
                .thenAdd(TakeOutPcDataCaptureValidationMessage.投票区確認)
                .ifNot(TakeOutPcDataCaptureSpec.抄本ファイルチェック)
                .thenAdd(TakeOutPcDataCaptureValidationMessage.抄本ファイルチェック)
                .ifNot(TakeOutPcDataCaptureSpec.投票状況ファイルチェック)
                .thenAdd(TakeOutPcDataCaptureValidationMessage.投票状況ファイルチェック)
                .messages());
        return messages;
    }
}
