/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibochoseifilesakuse;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ChoseiFileMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private ShohonNo 抄本番号;

    /**
     *
     * @param 抄本番号 ShohonNo
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public ChoseiFileMybatisParameter(
            ShohonNo 抄本番号, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抄本番号 = 抄本番号;
    }

}
