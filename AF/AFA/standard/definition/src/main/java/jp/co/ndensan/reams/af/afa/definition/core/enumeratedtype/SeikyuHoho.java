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
 * 請求方法を表す列挙型です。
 *
 * @author N1823 有澤 礼恵
 */
public enum SeikyuHoho implements IRStringConvertable {

    /**
     * 直接・本人<br />
     * 請求方法コード：1<br />
     */
    直接_本人("1"),
    /**
     * 直接・代理人<br />
     * 請求方法コード：2<br />
     */
    直接_代理人("2"),
    /**
     * 郵便<br />
     * 請求方法コード：3<br />
     */
    郵便("3");
    private final RString code;

    private SeikyuHoho(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する請求方法を返します。
     *
     * @param code コード
     * @return 請求方法
     */
    public static SeikyuHoho toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (SeikyuHoho item : SeikyuHoho.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.該当データなし.toString());
    }

    /**
     * 請求方法コードを返します。
     *
     * @return 請求方法コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

}
