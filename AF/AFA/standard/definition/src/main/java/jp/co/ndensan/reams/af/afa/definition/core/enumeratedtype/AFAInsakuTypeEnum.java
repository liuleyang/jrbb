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
 * 印刷タイプの説明の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public enum AFAInsakuTypeEnum {

    /**
     * 入場券_印刷タイプ_個票3つ折。
     */
    入場券_印刷タイプ_個票3つ折("0", "個票3つ折"),
    /**
     * 入場券_印刷タイプ_はがき4つ切。
     */
    入場券_印刷タイプ_はがき4つ切("1", "はがき4つ切"),
    /**
     * 入場券_印刷タイプ_シーラー。
     */
    入場券_印刷タイプ_シーラー("2", "シーラー"),
    /**
     * 入場券_印刷タイプ_ポステックス。
     */
    入場券_印刷タイプ_ポステックス("3", "ポステックス");

    private final RString key;
    private final RString value;

    private AFAInsakuTypeEnum(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された印刷タイプcodeの印刷タイプを返します。
     *
     * @param code 印刷タイプcode
     * @return 印刷タイプ
     */
    public static AFAInsakuTypeEnum getAFAInsakuTypeEnumByCode(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("印刷タイプコード"));
        for (AFAInsakuTypeEnum item : AFAInsakuTypeEnum.values()) {
            if (item.getKey().equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の印刷タイプコード").toString());
    }

    /**
     * 指定された印刷タイプ名称の印刷タイプを返します。
     *
     * @param value 印刷タイプvalue
     * @return 印刷タイプ
     */
    public static AFAInsakuTypeEnum getAFAInsakuTypeEnumByValue(RString value) {
        Objects.requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("印刷タイプ名称"));
        for (AFAInsakuTypeEnum item : AFAInsakuTypeEnum.values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の印刷タイプ名称").toString());
    }
}
