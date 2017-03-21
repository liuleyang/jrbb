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

/**
 * 選挙資格種類を表す列挙型です。
 */
public enum SennkyoSikakuShurui {

    /**
     * 通常選挙<br />
     * code：0
     */
    通常選挙("0"),
    /**
     * 憲法改正国民投票<br />
     * code：2
     */
    憲法改正国民投票("2"),
    /**
     * 在外投票<br />
     * code：3
     */
    在外投票("3"),
    /**
     * 海区漁業調整委員会委員選挙<br />
     * code：4
     */
    海区漁業調整委員会委員選挙("4"),
    /**
     * 財産区議会議員選挙<br />
     * code：5
     */
    財産区議会議員選挙("5"),
    /**
     * 住民投票<br />
     * code：6
     */
    住民投票("6");

    private final RString sennkyoSikakuShurui;

    private SennkyoSikakuShurui(String sennkyoSikakuShurui) {
        this.sennkyoSikakuShurui = new RString(sennkyoSikakuShurui);
    }

    /**
     * 選挙資格種類を取得します。
     *
     * @return 選挙資格種類
     */
    public RString value() {
        return this.sennkyoSikakuShurui;
    }

    /**
     * 指定された選挙資格種類codeの選挙資格種類を返します。
     *
     * @param code 選挙資格種類code
     * @return 選挙資格種類
     */
    public static SennkyoSikakuShurui toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類コード"));
        for (SennkyoSikakuShurui item : SennkyoSikakuShurui.values()) {
            if (item.value().equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の選挙種類コード").toString());
    }
}
