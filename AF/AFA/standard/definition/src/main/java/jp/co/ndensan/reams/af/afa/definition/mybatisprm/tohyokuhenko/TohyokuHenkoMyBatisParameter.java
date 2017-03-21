/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokuhenko;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 投票区変更のパラメータクラスです。
 *
 * @reamsid_L AF-0050-010 wangxt2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class TohyokuHenkoMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final Code senkyoShurui;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoShurui SenkyoShurui
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public TohyokuHenkoMyBatisParameter(
            ShikibetsuCode shikibetsuCode,
            SenkyoShurui senkyoShurui,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.shikibetsuCode = shikibetsuCode;
        this.senkyoShurui = new Code(senkyoShurui.getCode());
    }

}
