/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.hojoshamaintenance;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HojoshaMaintenanceMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private ShohonNo 抄本番号;
    private ShikibetsuCode 識別コード;
    private IShikibetsuTaishoPSMSearchKey key;

    /**
     * コンストラクタ作成します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     */
    public HojoshaMaintenanceMybatisParameter(IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号) {
        super(key);
        this.抄本番号 = 抄本番号;
    }

    /**
     * コンストラクタ作成します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 識別コード ShikibetsuCode
     */
    public HojoshaMaintenanceMybatisParameter(IShikibetsuTaishoPSMSearchKey key, ShikibetsuCode 識別コード) {
        super(key);
        this.識別コード = 識別コード;
    }
}
