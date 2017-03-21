/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyojohoshuseivalidation;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙修正のバリデーションサービスです。
 *
 */
public class SenkyoJohoShuseiValidationService {

    private final SenkyoJohoShuseiRepositoryValidator repositoryValidator;

    /**
     * コンストラクタです。
     */
    SenkyoJohoShuseiValidationService() {
        this.repositoryValidator = InstanceProvider.create(SenkyoJohoShuseiRepositoryValidator.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoJohoShuseiValidationService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoJohoShuseiValidationService}のインスタンス
     */
    public static SenkyoJohoShuseiValidationService createInstance() {
        return InstanceProvider.create(SenkyoJohoShuseiValidationService.class);
    }

    /**
     * バリデーション結果を返します。<br/> {@link SenkyoJohoShuseiRepositoryValidator}を利用します。
     *
     * @param 抄本番号 Shohon
     * @param 選挙レベル Code
     * @param 基準日 RDate
     * @return バリデーション結果
     */
    @Transaction
    public IValidationMessages validate(ShohonNo 抄本番号, Code 選挙レベル, FlexibleDate 基準日) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(repositoryValidator.validate選挙レベル基準日(抄本番号, 選挙レベル, 基準日));
        return messages;
    }
}
