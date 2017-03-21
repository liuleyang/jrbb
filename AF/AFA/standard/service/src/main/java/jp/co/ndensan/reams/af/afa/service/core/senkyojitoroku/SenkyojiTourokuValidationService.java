/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のチェッククラスです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiTourokuValidationService {

    private final SenkyojiTourokuRepositoryValidator repositoryValidator;

    /**
     * コンストラクタです。
     */
    SenkyojiTourokuValidationService() {
        this.repositoryValidator = InstanceProvider.create(SenkyojiTourokuRepositoryValidator.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param repositoryValidator SenkyojiTourokuRepositoryValidator
     */
    SenkyojiTourokuValidationService(SenkyojiTourokuRepositoryValidator repositoryValidator) {
        this.repositoryValidator = repositoryValidator;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyojiTourokuValidationService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyojiTourokuValidationService}のインスタンス
     */
    public static SenkyojiTourokuValidationService createInstance() {
        return InstanceProvider.create(SenkyojiTourokuValidationService.class);
    }

    /**
     * バリデーション結果を返します。<br/> {@link SenkyojiTourokuRepositoryValidator}を利用します。
     *
     * @param 抄本番号 RString
     * @return バリデーション結果
     */
    @Transaction
    public boolean validate入場券発行済(RString 抄本番号) {
        return repositoryValidator.validate入場券発行済(抄本番号);
    }

    /**
     * バリデーション結果を返します。<br/> {@link SenkyojiTourokuRepositoryValidator}を利用します。
     *
     * @param 投票日 RDate
     * @return バリデーション結果
     */
    @Transaction
    public boolean validate同じ抄本(RString 投票日) {
        return repositoryValidator.validate同じ抄本(投票日);
    }

    /**
     * バリデーション結果を返します。<br/> {@link SenkyojiTourokuRepositoryValidator}を利用します。
     *
     * @param 基準日From FlexibleDate
     * @param 基準日To RString
     * @return バリデーション結果
     */
    @Transaction
    public boolean validate定時登録実行有無(FlexibleDate 基準日From, FlexibleDate 基準日To) {
        return repositoryValidator.validate定時登録実行有無(基準日From, 基準日To);
    }

}
