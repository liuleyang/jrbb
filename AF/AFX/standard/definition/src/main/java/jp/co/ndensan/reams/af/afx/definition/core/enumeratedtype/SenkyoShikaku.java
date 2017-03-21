/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 選挙資格のenumクラスです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 */
public enum SenkyoShikaku implements IRStringConvertable {

    /**
     * なし<br />
     * コード：0<br />
     * 個別事項表示用名称：無<br />
     */
    なし("0", "無"),
    /**
     * 有権者<br />
     * コード：1<br />
     * 個別事項表示用名称：有<br />
     */
    有権者("1", "有"),
    /**
     * 表示者<br />
     * コード：2<br />
     * 個別事項表示用名称：有<br />
     */
    表示者("2", "有"),
    /**
     * 抹消者<br />
     * コード：3<br />
     * 個別事項表示用名称：無<br />
     */
    抹消者("3", "無"),
    /**
     * 公民権停止者<br />
     * コード：3<br />
     * 個別事項表示用名称：無<br />
     */
    公民権停止者("4", "無");
    private final RString コード;
    private final RString 個別事項表示用名称;

    private SenkyoShikaku(String code, String 個別事項表示用名称) {
        this.コード = new RString(code);
        this.個別事項表示用名称 = new RString(個別事項表示用名称);
    }

    /**
     * 指定された選挙資格コードの名称を返します。
     *
     * @param code 選挙資格コード
     * @return 選挙資格
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない選挙資格コードの場合
     */
    public static SenkyoShikaku toValue(RString code) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格コード"));

        for (SenkyoShikaku item : SenkyoShikaku.values()) {
            if (item.コード.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する選挙資格").evaluate());
    }

    /**
     * 選挙資格コードを返します。
     *
     * @return 選挙資格コード
     */
    public RString getコード() {
        return コード;
    }

    /**
     * 個別事項表示用の名称を返します。
     *
     * @return 選挙資格コード
     */
    public RString get個別事項表示用名称() {
        return 個別事項表示用名称;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
