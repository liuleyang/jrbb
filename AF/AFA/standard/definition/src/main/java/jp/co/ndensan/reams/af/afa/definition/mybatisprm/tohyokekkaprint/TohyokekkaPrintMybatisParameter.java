/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokekkaprint;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 投票結果集計表帳票バッチパラメータクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class TohyokekkaPrintMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final boolean 無投票選挙出力FLG;
    private final RString 投票区コードFROM;
    private final RString 投票区コードTO;
    private final ShohonNo 抄本番号;
    private final RString order順;

    /**
     * コンストラクタです。
     *
     * @param 無投票選挙出力FLG boolean
     * @param 投票区コードFROM RString
     * @param 投票区コードTO RString
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     * @param order順 RString
     */
    public TohyokekkaPrintMybatisParameter(boolean 無投票選挙出力FLG, RString 投票区コードFROM,
            RString 投票区コードTO, IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号, RString order順) {
        super(key);
        this.無投票選挙出力FLG = 無投票選挙出力FLG;
        this.投票区コードFROM = 投票区コードFROM;
        this.投票区コードTO = 投票区コードTO;
        this.抄本番号 = 抄本番号;
        this.order順 = order順;
    }
}
