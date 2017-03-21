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
 * ファイル出力（投票状況ファイル）
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyojoCsvEntity {

    @CsvField(order = 1, name = "投票所コード")
    private RString 投票所コード;

    @CsvField(order = 2, name = "投票所名称")
    private RString 投票所名称;

    @CsvField(order = 3, name = "カナ投票所名称")
    private RString カナ投票所名称;

    @CsvField(order = 4, name = "検索用カナ投票所名称")
    private RString 検索用カナ投票所名称;

    @CsvField(order = 5, name = "投票開始時刻")
    private RString 投票開始時刻;

    @CsvField(order = 6, name = "投票終了時刻")
    private RString 投票終了時刻;

    @CsvField(order = 7, name = "在外投票可能フラグ")
    private RString 在外投票可能フラグ;

    @CsvField(order = 8, name = "郵便番号")
    private RString 郵便番号;

    @CsvField(order = 9, name = "住所")
    private RString 住所;

    @CsvField(order = 10, name = "投票所宛名")
    private RString 投票所宛名;

    @CsvField(order = 11, name = "電話番号")
    private RString 電話番号;

    @CsvField(order = 12, name = "FAX番号")
    private RString ファクス番号;

    @CsvField(order = 13, name = "地図ファイル名")
    private RString 地図ファイル名;

}
