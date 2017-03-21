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
 * ファイル出力（当日投票率ファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuCsvResult {

    @CsvField(order = 1, name = "施設コード")
    private RString 施設コード;

    @CsvField(order = 2, name = "施設種別")
    private RString 施設種別;

    @CsvField(order = 3, name = "施設種別名")
    private RString 施設種別名;

    @CsvField(order = 4, name = "施設名称")
    private RString 施設名称;

    @CsvField(order = 5, name = "カナ施設名称")
    private RString カナ施設名称;

    @CsvField(order = 6, name = "検索用カナ施設名称")
    private RString 検索用カナ施設名称;

    @CsvField(order = 7, name = "郵便番号")
    private RString 郵便番号;

    @CsvField(order = 8, name = "住所")
    private RString 住所;

    @CsvField(order = 9, name = "施設宛名")
    private RString 施設宛名;

    @CsvField(order = 10, name = "電話番号")
    private RString 電話番号;

    @CsvField(order = 11, name = "FAX番号")
    private RString ファクス番号;

}
