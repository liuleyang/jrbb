/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyojohoshuseivalidation;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.senkyojohoshusei.SenkyoJohoShuseiValidationMessage;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙修正のリポジトリバリデータです。
 *
 */
public class SenkyoJohoShuseiRepositoryValidator {

    /**
     * コンストラクタです。
     */
    SenkyoJohoShuseiRepositoryValidator() {
    }

    @Transaction
    IValidationMessages validate選挙レベル基準日(ShohonNo 抄本番号, Code 選挙レベル, FlexibleDate 基準日) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (!is重複選挙レベルと基準日(抄本番号, 選挙レベル, 基準日)) {
            messages.add(SenkyoJohoShuseiValidationMessage.選挙レベル基準日確認);
        }
        return messages;
    }

    private boolean is重複選挙レベルと基準日(ShohonNo 抄本番号, Code 選挙レベル, FlexibleDate 基準日) {
        SenkyoManager manager = SenkyoManager.createInstance();
        Boolean 選挙フラグ = Boolean.FALSE;
        List<Senkyo> 選挙 = manager.get選挙By抄本番号と選挙レベルと基準日(抄本番号, 選挙レベル, 基準日);
        if (選挙 != null && !選挙.isEmpty()) {
            選挙フラグ = Boolean.TRUE;
        }
        return 選挙フラグ;
    }
}
