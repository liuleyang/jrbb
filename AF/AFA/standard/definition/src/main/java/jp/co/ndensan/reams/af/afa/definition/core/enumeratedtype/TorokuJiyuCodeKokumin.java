/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録事由コード国民を表す列挙型です。
 *
 * @reamsid_L AF-0360-020 qiuxy
 */
public enum TorokuJiyuCodeKokumin {

    /**
     * 一号資格者
     */
    一号資格者("11", "1号資格者"),
    /**
     * 二号資格者
     */
    二号資格者("12", "2号資格者"),
    /**
     * その他
     */
    その他("15", "その他");

    private final RString code;
    private final RString meisho;

    private TorokuJiyuCodeKokumin(String code, String meisho) {
        this.code = new RString(code);
        this.meisho = new RString(meisho);
    }

    /**
     * 登録事由コードを取得します。
     *
     * @return Code
     */
    public Code getCode() {
        return new Code(this.code);
    }

    /**
     * 登録事由コード名称を取得します。
     *
     * @return 登録事由コード名称 RString
     */
    public RString getMeisho() {
        return this.meisho;
    }
}
