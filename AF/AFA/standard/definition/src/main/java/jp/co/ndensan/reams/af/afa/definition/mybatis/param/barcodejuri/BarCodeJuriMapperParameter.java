/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.barcodejuri;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class BarCodeJuriMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final ShikibetsuCode shikibetsuCode;
    private final SenkyoNo senkyoNo;
    private final Code senkyoShurui;

    /**
     * 検索用のパラメータを生成します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNo SenkyoNo
     * @param senkyoShurui Code
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public BarCodeJuriMapperParameter(
            ShohonNo shohonNo,
            ShikibetsuCode shikibetsuCode,
            SenkyoNo senkyoNo,
            Code senkyoShurui,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.shohonNo = shohonNo;
        this.shikibetsuCode = shikibetsuCode;
        this.senkyoNo = senkyoNo;
        this.senkyoShurui = senkyoShurui;
    }
}
