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
 * ファイル出力（投票区ファイル）
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyokuUrCsvEntity {

    @CsvField(order = 1, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 2, name = "地方公共団体コード")
    private RString 地方公共団体コード;

    @CsvField(order = 3, name = "地方公共団体コード連番")
    private RString 地方公共団体コード連番;

    @CsvField(order = 4, name = "有効開始年月日")
    private RString 有効開始年月日;

    @CsvField(order = 5, name = "有効終了年月日")
    private RString 有効終了年月日;

    @CsvField(order = 6, name = "漢字名称")
    private RString 漢字名称;

    @CsvField(order = 7, name = "カナ名称")
    private RString カナ名称;

    @CsvField(order = 8, name = "検索カナ")
    private RString 検索カナ;

    @CsvField(order = 9, name = "表示順")
    private RString 表示順;

    @CsvField(order = 10, name = "投票所コード")
    private RString 投票所コード;

    @CsvField(order = 11, name = "投票所名")
    private RString 投票所名;

    @CsvField(order = 12, name = "投票所住所")
    private RString 投票所住所;

    @CsvField(order = 13, name = "選挙区コード")
    private RString 選挙区コード;

}
