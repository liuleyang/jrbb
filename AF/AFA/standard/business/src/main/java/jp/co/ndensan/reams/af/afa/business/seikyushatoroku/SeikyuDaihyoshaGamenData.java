/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushatoroku;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 請求代表者一覧の画面データクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyuDaihyoshaGamenData {

    private int 直接請求番号;
    private ShikibetsuCode 請求代表者識別コード;
    private EntityDataState 更新状態;

    /**
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return 直接請求番号;
    }

    /**
     * 直接請求番号のsetメソッドです。
     *
     * @param 直接請求番号 int
     */
    public void setSeikyuNo(int 直接請求番号) {
        this.直接請求番号 = 直接請求番号;
    }

    /**
     * 請求代表者識別コードのgetメソッドです。
     *
     * @return 請求代表者識別コード
     */
    public ShikibetsuCode getSeikyuShikibetsuCode() {
        return 請求代表者識別コード;
    }

    /**
     * 請求代表者識別コードのsetメソッドです。
     *
     * @param 請求代表者識別コード ShikibetsuCode
     */
    public void setSeikyuShikibetsuCode(ShikibetsuCode 請求代表者識別コード) {
        this.請求代表者識別コード = 請求代表者識別コード;
    }

    /**
     * DB状態メソッドです。
     *
     * @return 更新状態
     */
    public EntityDataState getState() {
        return 更新状態;
    }

    /**
     * DB状態メソッドです。
     *
     * @param 更新状態 EntityDataState
     */
    public void setState(EntityDataState 更新状態) {
        this.更新状態 = 更新状態;
    }
}
