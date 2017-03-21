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
 * 選挙種類を表す列挙型です。
 *
 * @reamsid_L AF-0390-030 jihb
 */
public enum SenkyoShurui implements IRStringConvertable {

    /**
     * 定時登録<br />
     * code：0
     */
    定時登録("0", "定時登録"),
    /**
     * 国政選挙・地方選挙<br />
     * code：1
     */
    国政選挙_地方選挙("1", "国・地方"),
    /**
     * 憲法改正国民投票<br />
     * code：2
     */
    憲法改正国民投票("2", "国民投票"),
    /**
     * 農業委員会委員選挙<br />
     * code：3
     */
    農業委員会委員選挙("3", "農業委員"),
    /**
     * 海区漁業調整委員会委員選挙<br />
     * code：4
     */
    海区漁業調整委員会委員選挙("4", "海区委員"),
    /**
     * 財産区議会議員選挙<br />
     * code：5
     */
    財産区議会議員選挙("5", "財産区"),
    /**
     * 住民投票<br />
     * code：6
     */
    住民投票("6", "住民投票");
    private final RString code;
    private final RString ryakusho;

    private SenkyoShurui(String code, String ryakusho) {
        this.code = new RString(code);
        this.ryakusho = new RString(ryakusho);

    }

    /**
     * 指定された選挙種類codeの選挙種類を返します。
     *
     * @param code 選挙種類code
     * @return 選挙種類
     */
    public static SenkyoShurui toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類コード"));
        for (SenkyoShurui item : SenkyoShurui.values()) {
            if (item.getCode().equals(code)) {
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
    public RString getCode() {
        return code;
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public RString getName() {
        return ryakusho;
    }

    @Override
    public RString toRString() {
        return new RString(SenkyoShurui.this.toString());
    }

}
