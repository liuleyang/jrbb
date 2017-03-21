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
 * ファイル出力（コードファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyokuAFCsvEntity {

    @CsvField(order = 1, name = "選挙種類")
    private RString 選挙種類;

    @CsvField(order = 2, name = "選挙種類名")
    private RString 選挙種類名;

    @CsvField(order = 3, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 4, name = "投票区名")
    private RString 投票区名;

    @CsvField(order = 5, name = "カナ投票区名")
    private RString カナ投票区名;

    @CsvField(order = 6, name = "検索用カナ投票区名")
    private RString 検索用カナ投票区名;

    @CsvField(order = 7, name = "表示順")
    private RString 表示順;

    @CsvField(order = 8, name = "投票所コード")
    private RString 投票所コード;

    @CsvField(order = 9, name = "投票所名")
    private RString 投票所名;

    @CsvField(order = 10, name = "投票所住所")
    private RString 投票所住所;

    @CsvField(order = 11, name = "選挙区コード")
    private RString 選挙区コード;

    @CsvField(order = 12, name = "選挙区名")
    private RString 選挙区名;

}
