/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ファイル出力（管理情報ファイル）。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanriInfoCsvEntity {

    @CsvField(order = 1, name = "スキーマ名")
    private RString スキーマ名;

    @CsvField(order = 2, name = "サブ業務コード")
    private RString サブ業務コード;

    @CsvField(order = 3, name = "コンフィグ名")
    private RString コンフィグ名;

    @CsvField(order = 4, name = "javaタイプ")
    private RString javaタイプ;

    @CsvField(order = 5, name = "変更可能フラグ")
    private RString 変更可能フラグ;

    @CsvField(order = 6, name = "値")
    private RString 値;

    @CsvField(order = 7, name = "説明")
    private RString 説明;

    @CsvField(order = 8, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 9, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 10, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 11, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 12, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 13, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 14, name = "更新ユーザ")
    private RString 更新ユーザ;

}
