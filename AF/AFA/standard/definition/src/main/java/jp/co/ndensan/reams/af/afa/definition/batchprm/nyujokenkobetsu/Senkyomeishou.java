/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙名称リスト
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class Senkyomeishou {

    private RString 選挙番号;
    private RString 選挙名称;
    private RString 選挙略称;

    /**
     * コンストラクタです。
     */
    public Senkyomeishou() {
    }

    /**
     * コンストラクタです。
     *
     * @param 選挙番号 RString
     * @param 選挙名称 RString
     * @param 選挙略称 RString
     */
    public Senkyomeishou(RString 選挙番号, RString 選挙名称, RString 選挙略称) {
        this.選挙番号 = 選挙番号;
        this.選挙名称 = 選挙名称;
        this.選挙略称 = 選挙略称;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public RString get選挙番号() {
        return 選挙番号;
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return 選挙名称;
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称
     */
    public RString get選挙略称() {
        return 選挙略称;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 選挙名称を設定します。
     *
     * @param 選挙名称 RString
     */
    public void set選挙名称(RString 選挙名称) {
        this.選挙名称 = 選挙名称;
    }

    /**
     * 選挙略称を設定します。
     *
     * @param 選挙略称 RString
     */
    public void set選挙略称(RString 選挙略称) {
        this.選挙略称 = 選挙略称;
    }

}
