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
 * 交付方法、受理方法を表す列挙型です。
 *
 * @author N1823 有澤 礼恵
 */
public enum KofuJuriHoho implements IRStringConvertable {

    /**
     * 直接<br />
     * 交付受理方法コード：1<br />
     */
    直接("1"),
    /**
     * 郵便<br />
     * 交付受理方法コード：2<br />
     */
    郵便("2");
    private final RString code;

    private KofuJuriHoho(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する交付・受理方法を返します。
     *
     * @param code コード
     * @return 交付・受理方法
     */
    public static KofuJuriHoho toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (KofuJuriHoho item : KofuJuriHoho.values()) {
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
