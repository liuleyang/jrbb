/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushomeibotoroku;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * 署名簿登録のパラメータクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SeikyuShomeiboTorokuParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final int seikyuNo;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param seikyuNo int
     */
    public SeikyuShomeiboTorokuParameter(IShikibetsuTaishoPSMSearchKey key,
            int seikyuNo) {
        super(key);
        this.seikyuNo = seikyuNo;
    }
}
