/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 各種マスタデータ出力を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0670-010 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class MasterCsvOutputMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public MasterCsvOutputMapperParameter(ShohonNo 抄本番号, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抄本番号 = 抄本番号;
    }

}
