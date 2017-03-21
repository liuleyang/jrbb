/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu;

import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 選挙人一覧情報。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class SenkyoninIrain {

    private ShikibetsuCode 識別コード;

    private SetaiCode 世帯コード;

    /**
     * コンストラクタです。
     */
    public SenkyoninIrain() {
    }

    /**
     * コンストラクタです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 世帯コード SetaiCode
     */
    public SenkyoninIrain(ShikibetsuCode 識別コード, SetaiCode 世帯コード) {
        this.識別コード = 識別コード;
        this.世帯コード = 世帯コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.識別コード;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return this.世帯コード;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード SetaiCode
     */
    public void set世帯コード(SetaiCode 世帯コード) {
        this.世帯コード = 世帯コード;
    }

}
