/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi;

import java.util.Objects;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 各種マスタデータ出力の列挙型です。
 *
 * @reamsid_L AF-0670-010 lis
 */
public enum SaibaninTorikomiEnum implements IRStringConvertable {

    /**
     * ZERO<br />
     * code：0
     */
    ZERO("0"),
    /**
     * ONE<br />
     * code：1
     */
    ONE("1"),
    /**
     * ONE<br />
     * code：4
     */
    FOUR("4"),
    /**
     * ONE<br />
     * code：12
     */
    TWELVE("12"),
    /**
     * カンマ<br />
     * code：,
     */
    カンマ(","),
    /**
     * カンマ<br />
     * code：*
     */
    星印("*"),
    /**
     * カンマ<br />
     * code：/
     */
    斜線("/"),
    /**
     * RGAF<br />
     * code：rgaf
     */
    RGAF("rgaf");

    private final RString code;

    private SaibaninTorikomiEnum(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定された選挙種類codeの選挙種類を返します。
     *
     * @param code 選挙種類code
     * @return 選挙種類
     */
    public static SaibaninTorikomiEnum toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類コード"));
        for (SaibaninTorikomiEnum item : SaibaninTorikomiEnum.values()) {
            if (item.getRString().equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の選挙種類コード").toString());
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public RString getRString() {
        return code;
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public Integer getInteger() {
        return Integer.valueOf(code.toString());
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号コード
     */
    public SenkyoNo getSenkyoNo() {
        return new SenkyoNo(code);
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号コード
     */
    public Code getCode() {
        return new Code(code);
    }

    @Override
    public RString toRString() {
        return new RString(SaibaninTorikomiEnum.this.toString());
    }

}
