/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokekkaprint.TohyokekkaPrintMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票結果集計表帳票バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE505SelectProcessParameter implements IBatchProcessParameter {

    private boolean 無投票選挙出力FLG;
    private Code 選挙種類;
    private RString 投票区コードFROM;
    private RString 投票区コードTO;
    private ShohonNo 抄本番号;
    private IShikibetsuTaishoPSMSearchKey key;
    private RString order順 = RString.EMPTY;
    private Order order;
    private boolean eucFlg;

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
    public AFABTE505SelectProcessParameter(boolean 無投票選挙出力FLG, RString 投票区コードFROM,
            RString 投票区コードTO, IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号, RString order順) {
        this.無投票選挙出力FLG = 無投票選挙出力FLG;
        this.投票区コードFROM = 投票区コードFROM;
        this.投票区コードTO = 投票区コードTO;
        this.抄本番号 = 抄本番号;
        this.key = key;
        this.order順 = order順;
    }

    /**
     * TohyokekkaPrintMybatisParameter変換のメソッド
     *
     * @return TohyokekkaPrintMybatisParameter
     */
    public TohyokekkaPrintMybatisParameter toTohyokekkaPrintMybatisParameter() {
        return new TohyokekkaPrintMybatisParameter(
                無投票選挙出力FLG, 投票区コードFROM, 投票区コードTO, key, 抄本番号, order順);
    }
}
