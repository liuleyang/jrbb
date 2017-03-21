/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.mastercsvoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ファイル出力（コード管理ファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AfConfigCsvEntity {

    @CsvField(order = 1, name = "スキーマ名")
    private RString スキーマ名;

    @CsvField(order = 2, name = "サブ業務コード")
    private RString サブ業務コード;

    @CsvField(order = 3, name = "コンフィグ名")
    private RString コンフィグ名;

    @CsvField(order = 4, name = "値")
    private RString 値;

    @CsvField(order = 5, name = "説明")
    private RString 説明;

    @CsvField(order = 6, name = "データ型")
    private RString データ型;

    @CsvField(order = 7, name = "更新可否")
    private RString 更新可否;

}
