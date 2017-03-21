/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;

/**
 * 投票状況パラメータクラスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class TohyoJokyoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final List<ShikibetsuCode> 識別コードリスト;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コードリスト List<ShikibetsuCode>
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public TohyoJokyoMybatisParameter(ShohonNo 抄本番号,
            List<ShikibetsuCode> 識別コードリスト,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.抄本番号 = 抄本番号;
        this.識別コードリスト = 識別コードリスト;
    }
}
