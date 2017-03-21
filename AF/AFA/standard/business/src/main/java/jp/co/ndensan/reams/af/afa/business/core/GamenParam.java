/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 画面パラメータ
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class GamenParam {

    private ShikibetsuCode 識別コード;

    /**
     * 識別コード
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 識別コード
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

}
