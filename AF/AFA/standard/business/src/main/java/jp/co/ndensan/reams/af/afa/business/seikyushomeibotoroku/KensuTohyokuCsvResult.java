/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * ファイル出力（コードファイル）。
 *
 * @reamsid_L AF-0150-010 wangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KensuTohyokuCsvResult {

    @CsvField(order = 1, name = "投票区")
    private RString 投票区;

    @CsvField(order = 2, name = "投票所名")
    private RString 投票所名;

    @CsvField(order = 3, name = "有権者数（男）")
    private Decimal 有権者数_男;

    @CsvField(order = 4, name = "有権者数（女）")
    private Decimal 有権者数_女;

    @CsvField(order = 5, name = "有権者数（計）")
    private Decimal 有権者数_計;

    @CsvField(order = 6, name = "署名有効数（男）")
    private Decimal 署名有効数_男;

    @CsvField(order = 7, name = "署名有効数（女）")
    private Decimal 署名有効数_女;

    @CsvField(order = 8, name = "署名有効数（計）")
    private Decimal 署名有効数_計;

    @CsvField(order = 9, name = "署名無効数（男）")
    private Decimal 署名無効数_男;

    @CsvField(order = 10, name = "署名無効数（女）")
    private Decimal 署名無効数_女;

    @CsvField(order = 11, name = "署名無効数（計）")
    private Decimal 署名無効数_計;

    @CsvField(order = 12, name = "署名合計（男）")
    private Decimal 署名合計_男;

    @CsvField(order = 13, name = "署名合計（女）")
    private Decimal 署名合計_女;

    @CsvField(order = 14, name = "署名合計（計）")
    private Decimal 署名合計_計;

}
