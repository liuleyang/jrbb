/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public enum SeikyuShomeiboTorokuRStringEnum {

    /**
     * 百分符
     */
    百分符("%"),
    /**
     * FORMATDIVIDE
     */
    FORMATDIVIDE("0.00%"),
    /**
     * CSV_DELIMITER<br />
     * code：,
     */
    CSV_DELIMITER(","),
    /**
     * 0
     */
    零("0"),
    /**
     * 不明。
     */
    不明("不明"),
    /**
     * 署名なし。
     */
    署名なし("署名なし"),
    /**
     * 署名なし。
     */
    有効("有効"),
    /**
     * 署名なし。
     */
    無効("無効"),
    /**
     * 不明者。
     */
    不明者("不明者"),
    /**
     * 0。
     */
    審査区分_0("0"),
    /**
     * 1。
     */
    審査区分_1("1"),
    /**
     * 2。
     */
    審査区分_2("2"),
    /**
     * 01。
     */
    無効事由_01("01"),
    /**
     * 01。
     */
    無効事由_02("02"),
    /**
     *
     * 01。
     */
    無効事由_03("03"),
    /**
     *
     * 01。
     */
    無効事由_04("04"),
    /**
     *
     * 01。
     */
    無効事由_05("05"),
    /**
     *
     * 01。
     */
    無効事由_06("06"),
    /**
     *
     * 07。
     */
    無効事由_07("07"),
    /**
     *
     * 01。
     */
    無効事由_08("08"),
    /**
     *
     * 01。
     */
    無効事由_09("09"),
    /**
     *
     * 01。
     */
    無効事由_10("10"),
    /**
     *
     * 01。
     */
    無効事由_11("11"),
    /**
     *
     * 01。
     */
    無効事由_12("12"),
    /**
     *
     * 01。
     */
    無効事由_13("13"),
    /**
     *
     * 01。
     */
    無効事由_14("14"),
    /**
     *
     * 01。
     */
    無効事由_15("15"),
    /**
     *
     * 01。
     */
    無効事由_16("16"),
    /**
     *
     * 01。
     */
    無効事由_17("17"),
    /**
     *
     * 01。
     */
    無効事由_18("18"),
    /**
     */
    /**
     * 性別コード_男。
     */
    性別コード_男("1"),
    /**
     * 性別コード_女。
     */
    性別コード_女("2"),
    /**
     * 十歳未満。
     */
    十歳未満("10歳未満"),
    /**
     * 十歳未満。
     */
    十代("10代"),
    /**
     * 十歳未満。
     */
    二十代("20代"),
    /**
     * 十歳未満。
     */
    三十代("30代"),
    /**
     * 十歳未満。
     */
    四十代("40代"),
    /**
     * 十歳未満。
     */
    五十代("50代"),
    /**
     * 十歳未満。
     */
    六十代("60代"),
    /**
     * 十歳未満。
     */
    七十代("70代"),
    /**
     * 十歳未満。
     */
    八十代("80代"),
    /**
     * 十歳未満。
     */
    九十代("90代"),
    /**
     * 十歳未満。
     */
    一百以上("100以上"),
    /**
     * フォーマット。
     */
    フォーマット("#,##0.00"),
    /**
     * 横線。
     */
    横線("-");
    private final RString key;

    private SeikyuShomeiboTorokuRStringEnum(String key) {
        this.key = new RString(key);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getKey() {
        return this.key;
    }
}
