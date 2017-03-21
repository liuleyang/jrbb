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
 * ファイル出力（抄本ファイル）
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SenkyokuCsvResult {

    @CsvField(order = 1, name = "選挙種類")
    private RString 選挙種類;

    @CsvField(order = 2, name = "選挙種類名")
    private RString 選挙種類名;

    @CsvField(order = 3, name = "選挙区コード")
    private RString 選挙区コード;

    @CsvField(order = 4, name = "選挙区名")
    private RString 選挙区名;
}
