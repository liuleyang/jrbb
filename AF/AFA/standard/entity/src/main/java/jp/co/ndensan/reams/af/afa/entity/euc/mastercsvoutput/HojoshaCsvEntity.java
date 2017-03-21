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
 * ファイル出力（選挙ファイル）
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HojoshaCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;

    @CsvField(order = 2, name = "抄本名")
    private RString 抄本名;

    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;

    @CsvField(order = 4, name = "補助者氏名")
    private RString 補助者氏名;

    @CsvField(order = 5, name = "投票所コード")
    private RString 投票所コード;

    @CsvField(order = 6, name = "投票所名称")
    private RString 投票所名称;

}
