/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT112SenkyoninMeiboDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のチェックロジッククラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoRepositoryValidator {

    private final AfT112SenkyoninMeiboDac dac;

    /**
     * コンストラクタです。
     */
    TojitsuTohyoRepositoryValidator() {
        this.dac = InstanceProvider.create(AfT112SenkyoninMeiboDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT112SenkyoninMeiboDac}
     */
    TojitsuTohyoRepositoryValidator(AfT112SenkyoninMeiboDac dac) {
        this.dac = dac;
    }

    /**
     * 識別コードと抄本番号で、エラーバリデーションを実施します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @return バリデーション結果
     */
    @Transaction
    boolean validate選挙人名簿データ存在(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {
        return dac.select(抄本番号, 識別コード) != null;
    }
}
