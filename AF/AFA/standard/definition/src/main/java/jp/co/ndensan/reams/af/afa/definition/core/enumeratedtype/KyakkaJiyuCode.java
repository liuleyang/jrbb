/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 却下事由コードのを表す列挙型です
 *
 * @reamsid_L AF-0320-021 zhanggs
 */
public enum KyakkaJiyuCode {

    /**
     * 却下事由コード 01:本人確認
     */
    本人確認(new RString("本人確認"), new RString("01")),
    /**
     * 却下事由コード 02:同居家族等確認
     */
    同居家族等確認(new RString("同居家族等確認"), new RString("02")),
    /**
     * 却下事由コード 03:登録済
     */
    登録済(new RString("登録済"), new RString("03")),
    /**
     * 却下事由コード 04:年齢要件
     */
    年齢要件(new RString("年齢要件"), new RString("04")),
    /**
     * 却下事由コード 05:国籍
     */
    国籍(new RString("国籍"), new RString("05")),
    /**
     * 却下事由コード 06:公民権停止
     */
    公民権停止(new RString("公民権停止"), new RString("06")),
    /**
     * 却下事由コード 07:居住要件
     */
    居住要件(new RString("居住要件"), new RString("07")),
    /**
     * 却下事由コード 08:申請先誤り
     */
    申請先誤り(new RString("申請先誤り"), new RString("08")),
    /**
     * 却下事由コード 09:その他
     */
    その他(new RString("その他"), new RString("09"));

    private final RString value;
    private final RString key;

    private KyakkaJiyuCode(RString value, RString key) {
        this.value = value;
        this.key = key;
    }

    /**
     * 値を取得<BR>
     * 例: 本人確認(new RString("本人確認"), new RString("01")) =>return 01
     *
     * @return key RString
     */
    public RString getKey() {
        return key;
    }

    /**
     * keyを取得 <BR>
     * 例: 本人確認(new RString("本人確認"), new RString("01")) =>return 本人確認
     *
     * @return value RString
     */
    public RString getValue() {
        return value;
    }
}
