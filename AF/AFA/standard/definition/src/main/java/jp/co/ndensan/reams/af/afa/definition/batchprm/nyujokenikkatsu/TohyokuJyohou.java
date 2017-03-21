/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区情報
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class TohyokuJyohou {

    private RString 投票区コード;
    private RString 投票区名;

    /**
     * コンストラクタです。
     */
    public TohyokuJyohou() {
    }

    /**
     * コンストラクタです。
     *
     * @param 投票区コード RString
     * @param 投票区名 RString
     *
     */
    public TohyokuJyohou(RString 投票区コード, RString 投票区名) {
        this.投票区コード = 投票区コード;
        this.投票区名 = 投票区名;

    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return 投票区コード;
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return 投票区名;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 投票区名を設定します。
     *
     * @param 投票区名 RString
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
    }

}
