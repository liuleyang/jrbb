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
 * 固定文コードを表す列挙型です。
 *
 */
public enum KoteibunCode implements IRStringConvertable {

    /**
     * 固定文コード：1<br />
     */
    固定文コード_０１("01"),
    /**
     * 固定文コード：2<br />
     */
    固定文コード_０２("02"),
    /**
     * 固定文コード：3<br />
     */
    固定文コード_０３("03"),
    /**
     * 固定文コード：4<br />
     */
    固定文コード_０４("04"),
    /**
     * 固定文コード：5<br />
     */
    固定文コード_０５("05"),
    /**
     * 固定文コード：6<br />
     */
    固定文コード_０６("06"),
    /**
     * 固定文コード：7<br />
     */
    固定文コード_０７("07"),
    /**
     * 固定文コード：8<br />
     */
    固定文コード_０８("08"),
    /**
     * 固定文コード：9<br />
     */
    固定文コード_０９("09"),
    /**
     * 固定文コード：10<br />
     */
    固定文コード_１０("10"),
    /**
     * 固定文コード：11<br />
     */
    固定文コード_１１("11"),
    /**
     * 固定文コード：12<br />
     */
    固定文コード_１２("12");
    private final RString code;

    private KoteibunCode(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する交付・受理方法を返します。
     *
     * @param code コード
     * @return 交付・受理方法
     */
    public static KoteibunCode toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (KoteibunCode item : KoteibunCode.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.該当データなし.toString());
    }

    /**
     * 交付受理方法コードを返します。
     *
     * @return 交付受理方法コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
