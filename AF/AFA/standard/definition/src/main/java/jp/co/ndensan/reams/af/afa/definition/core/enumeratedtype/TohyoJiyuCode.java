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
 * 投票事由を表す列挙形です。
 *
 * @author N1823 有澤 礼恵
 */
public enum TohyoJiyuCode implements IRStringConvertable {

    /**
     * 仕事等による場合<br />
     * 投票事由コード：1<br />
     */
    仕事等("1"),
    /**
     * 旅行等による場合<br />
     * 投票事由コード：2<br />
     */
    旅行等("2"),
    /**
     * 病院・施設入所等による場合<br />
     * 投票事由コード：3<br />
     */
    病院_施設等("3"),
    /**
     * 交通至難等による場合<br />
     * 投票事由コード：4<br />
     */
    交通至難等("4"),
    /**
     * 住所移転による場合<br />
     * 投票事由コード：5<br />
     */
    住所移転("5"),
    /**
     * 身体に重度の障害による場合<br />
     * 投票事由コード：6<br />
     */
    重度の障害("6"),
    /**
     * 特定国外派遣組織に属する場合<br />
     * 投票事由コード：7<br />
     */
    特定国外("7");
    private final RString code;

    private TohyoJiyuCode(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する投票事由を返します。
     *
     * @param code コード
     * @return 投票事由
     */
    public static TohyoJiyuCode toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (TohyoJiyuCode item : TohyoJiyuCode.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.該当データなし.toString());
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

}
