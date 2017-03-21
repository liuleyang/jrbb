/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ファイル出力（管理情報ファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RyojikanCsvResult {

    @CsvField(order = 1, name = "領事官コード")
    private RString 領事官コード;

    @CsvField(order = 2, name = "領事官名称")
    private RString 領事官名称;

    @CsvField(order = 3, name = "カナ領事官名称")
    private RString カナ領事官名称;

    @CsvField(order = 4, name = "検索用カナ領事官名称")
    private RString 検索用カナ領事官名称;

    @CsvField(order = 5, name = "表示順")
    private RString 表示順;

}
