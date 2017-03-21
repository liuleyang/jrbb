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
 * ファイル出力（選挙区ファイル）
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KumiaiCsvEntity {

    @CsvField(order = 1, name = "組合コード")
    private RString 組合コード;

    @CsvField(order = 2, name = "組合名称")
    private RString 組合名称;

    @CsvField(order = 3, name = "カナ組合名称")
    private RString カナ組合名称;

    @CsvField(order = 4, name = "検索用カナ組合名称")
    private RString 検索用カナ組合名称;

    @CsvField(order = 5, name = "組合の住所等")
    private RString 組合の住所等;
}
