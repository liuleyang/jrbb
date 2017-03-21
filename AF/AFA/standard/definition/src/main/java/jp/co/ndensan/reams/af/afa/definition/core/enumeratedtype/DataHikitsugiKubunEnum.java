/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データ引継区分の説明の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public enum DataHikitsugiKubunEnum {

    /**
     * 未。
     */
    データ引継区分_未("0", "未"),
    /**
     * 作成済。
     */
    データ引継区分_作成済("1", "作成済"),
    /**
     * 受渡済。
     */
    データ引継区分_受渡済("2", "受渡済"),
    /**
     * 取込済。
     */
    データ引継区分_取込済("3", "取込済");

    private final RString key;
    private final RString value;

    private DataHikitsugiKubunEnum(String key, String value) {
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
    public Code getKeyCode() {
        return new Code(this.key);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getValue() {
        return this.value;
    }

}
