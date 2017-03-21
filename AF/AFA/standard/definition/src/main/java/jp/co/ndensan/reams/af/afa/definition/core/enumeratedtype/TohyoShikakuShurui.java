/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 投票資格種類を表す列挙型です。
 */
public enum TohyoShikakuShurui implements IRStringConvertable {

    /**
     * 投票資格種類_郵便<br />
     * code：1
     */
    投票資格種類_郵便("1", "郵便"),
    /**
     * 投票資格種類_船員<br />
     * code：2
     */
    投票資格種類_船員("2", "船員"),
    /**
     * 投票資格種類_南極<br />
     * code：3
     */
    投票資格種類_南極("3", "南極");

    private final RString code;
    private final RString value;

    private TohyoShikakuShurui(String code, String value) {
        this.code = new RString(code);
        this.value = new RString(value);
    }

    /**
     * 指定された選挙種類codeの選挙種類を返します。
     *
     * @param code 選挙種類code
     * @return 選挙種類
     */
    public static TohyoShikakuShurui toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類コード"));
        for (TohyoShikakuShurui item : TohyoShikakuShurui.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の投票資格種類コード").toString());
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 選挙種類名称を返します。
     *
     * @return 選挙種類名称
     */
    public RString getValue() {
        return this.value;
    }

    @Override
    public RString toRString() {
        return new RString(TohyoShikakuShurui.this.toString());
    }
}
