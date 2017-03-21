/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 集計用情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class TohyorokuMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public TohyorokuMapperParameter(
            ShohonNo 抄本番号,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.抄本番号 = 抄本番号;
    }
}
