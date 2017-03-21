/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.hojoshanyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者入力共有子divを特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HojoshaNyuryokuMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final RString tohyokuCode;

    /**
     * 検索用のパラメータを生成します。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param tohyokuCode RString
     */
    public HojoshaNyuryokuMapperParameter(
            ShohonNo shohonNo,
            RString tohyokuCode,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.shohonNo = shohonNo;
        this.tohyokuCode = tohyokuCode;
    }
}
