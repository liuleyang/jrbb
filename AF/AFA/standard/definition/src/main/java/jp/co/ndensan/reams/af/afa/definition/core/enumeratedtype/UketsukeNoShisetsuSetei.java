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
 * 受付番号_施設設定を表す列挙型です。
 *
 * @reamsid_L AF-0070-021 liss
 */
public enum UketsukeNoShisetsuSetei implements IRStringConvertable {

    /**
     * 施設種別毎連番：1<br />
     */
    施設種別毎連番("1"),
    /**
     * 施設コード毎連番：2<br />
     */
    施設コード毎連番("2"),
    /**
     * 施設管理なし：0<br />
     */
    施設管理なし("0");

    private final RString code;

    private UketsukeNoShisetsuSetei(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定されたコードに該当する交付・受理方法を返します。
     *
     * @param code コード
     * @return 交付・受理方法
     */
    public static UketsukeNoShisetsuSetei toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (UketsukeNoShisetsuSetei item : UketsukeNoShisetsuSetei.values()) {
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
