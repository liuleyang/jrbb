/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票録項目種類を表す列挙型です。
 *
 * @author N1823 有澤 礼恵
 */
public enum TohyorokuKomokuShurui implements IRStringConvertable {

    /**
     * 投票立会人（選管）<br />
     * code：1<br />
     */
    投票立会人_選管("1"),
    /**
     * 投票立会人（投票管理者）<br />
     * code：2<br />
     */
    投票立会人_投票管理者("2"),
    /**
     * 再交付者<br />
     * code：3<br />
     */
    再交付者("3"),
    /**
     * 決定書_判決書<br />
     * code：4<br />
     */
    決定書_判決書("4"),
    /**
     * 用紙返還<br />
     * code：5<br />
     */
    用紙返還("5"),
    /**
     * 投票の拒否<br />
     * code：6<br />
     */
    投票の拒否("6"),
    /**
     * 代理投票の拒否<br />
     * code：7<br />
     */
    代理投票の拒否("7");
    private final RString code;

    private TohyorokuKomokuShurui(String cd) {
        code = new RString(cd);
    }

    /**
     * 指定された投票録項目種類codeの投票録項目種類を返します。
     *
     * @param code 投票録項目種類code
     * @return 投票録項目種類
     */
    public static TohyorokuKomokuShurui toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類コード"));
        for (TohyorokuKomokuShurui item : TohyorokuKomokuShurui.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.該当データなし.toString());
    }

    /**
     * 投票録項目種類codeを返します。
     *
     * @return 投票録項目種類code
     */
    public RString getCode() {
        return code;
    }

    @Override
    public RString toRString() {
        return new RString(TohyorokuKomokuShurui.this.toString());
    }

}
