/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.mochidashipcimportuketsukedata.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当日受付データ取込の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public enum MochidashiPcImportUketsukeDataRStringEnum {

    /**
     * 選挙番号_1。
     */
    選挙番号_1("1"),
    /**
     * 選挙番号_2。
     */
    選挙番号_2("2"),
    /**
     * 選挙番号_3。
     */
    選挙番号_3("3"),
    /**
     * 選挙番号_4。
     */
    選挙番号_4("4"),
    /**
     * 選挙番号_5。
     */
    選挙番号_5("5"),
    /**
     * 選挙番号_6。
     */
    選挙番号_6("6"),
    /**
     * 選挙番号_7。
     */
    選挙番号_7("7"),
    /**
     * 選挙番号_8。
     */
    選挙番号_8("8"),
    /**
     * 選挙番号_9。
     */
    選挙番号_9("9"),
    /**
     * 点字フラグ_0。
     */
    点字フラグ_0("0"),
    /**
     * 点字フラグ_1。
     */
    点字フラグ_1("1"),
    /**
     * 代理投票区分_0。
     */
    代理投票区分_0("0"),
    /**
     * 代理投票区分_1。
     */
    代理投票区分_1("1"),
    /**
     * 証明書出力フラグ_TRUE。
     */
    証明書出力フラグ_TRUE("true"),
    /**
     * 証明書出力フラグ_FALSE。
     */
    証明書出力フラグ_FALSE("false"),
    /**
     * 論理削除行FLG_TRUE。
     */
    論理削除行FLG_TRUE("true"),
    /**
     * 論理削除行FLG_FALSE。
     */
    論理削除行FLG_FALSE("false"),
    /**
     * 出力条件_出力内容。
     */
    出力条件_出力内容("なし"),
    /**
     * 出力条件_出力内容。
     */
    出力条件_出力ページ数("0"),
    /**
     * CSV出力有無_有り。
     */
    CSV出力有無_有り("あり"),
    /**
     * 出力条件_抄本番号。
     */
    出力条件_抄本番号("【抄本番号】"),
    /**
     * 出力条件_投票区。
     */
    出力条件_投票区("【投票区】"),
    /**
     * 出力条件_投票日。
     */
    出力条件_投票日("【投票日】"),
    /**
     * 出力条件_抄本ファイル。
     */
    出力条件_抄本ファイル("【取込抄本ファイル】"),
    /**
     * 出力条件_投票状況ファイル。
     */
    出力条件_投票状況ファイル("【取込投票状況ファイル】"),
    /**
     * 出力内容_連絡符号１。
     */
    出力内容_連絡符号１("、"),
    /**
     * 出力内容_連絡符号１。
     */
    出力内容_連絡符号２("-"),
    /**
     * 出力条件_抄本ファイル。
     */
    抄本ファイル名_START("ANShohon-"),
    /**
     * 出力条件_投票状況ファイル。
     */
    投票状況ファイル_START("ANTohyojokyo-"),
    /**
     * 一時テーブル名。
     */
    一時テーブル名("outTempTableName"),
    /**
     * 抄本一時テーブル名。
     */
    SHOHON_TEMP_TABLE_NAME("AFABTE803TempShohon"),
    /**
     * 投票状況一時テーブル名。
     */
    TOHYOJOKYO_TEMP_TABLE_NAME("AFABTE803TempTohyoJokyo"),
    /**
     * COMMA。
     */
    COMMA(","),
    /**
     * SLASH。
     */
    SLASH("\""),
    /**
     * 連絡符号_CSV。
     */
    連絡符号_CSV(".csv"),
    /**
     * 切れREGEX1。
     */
    切れREGEX1("T"),
    /**
     * 切れREGEX2。
     */
    切れREGEX2("."),
    /**
     * PATTERN。
     */
    PATTERN("[0-9]*");
    private final RString key;

    private MochidashiPcImportUketsukeDataRStringEnum(String key) {
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

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public String getStringKey() {
        return this.key.toString();
    }
}
