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
 * 施設種別を表す列挙型です。
 *
 * @author N1823 有澤 礼恵
 */
public enum ShisetsuShubetsu implements IRStringConvertable {

    /**
     * 一般（本庁）<br />
     * 施設種別コード：01
     */
    一般_本庁("01"),
    /**
     * 一般（支所）<br />
     * 施設種別コード：02
     */
    一般_支所("02"),
    /**
     * 病院<br />
     * 施設種別コード：03
     */
    病院("03"),
    /**
     * 施設<br />
     * 施設種別コード：04
     */
    施設("04"),
    /**
     * 郵便<br />
     * 施設種別コード：05
     */
    郵便("05"),
    /**
     * 他市町村<br />
     * 施設種別コード：06
     */
    住民投票("06"),
    /**
     * 他施設<br />
     * 施設種別コード：07
     */
    他施設("07"),
    /**
     * 船舶<br />
     * 施設種別コード：08
     */
    船舶("08"),
    /**
     * 刑事施設等<br />
     * 施設種別コード：09
     */
    刑事施設等("09"),
    /**
     * 少年院等<br />
     * 施設種別コード：10
     */
    少年院等("10"),
    /**
     * 特定国外派遣組織<br />
     * 施設種別コード：11
     */
    特定国外派遣組織("11"),
    /**
     * 南極地域調査組織<br />
     * 施設種別コード：12
     */
    南極地域調査組織("12");
    private final RString code;

    private ShisetsuShubetsu(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する施設種別を返します。
     *
     * @param code コード
     * @return 施設種別
     */
    public static ShisetsuShubetsu toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (ShisetsuShubetsu item : ShisetsuShubetsu.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.該当データなし.toString());
    }

    /**
     * 施設種別コードを返します。
     *
     * @return 施設種別コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

}
