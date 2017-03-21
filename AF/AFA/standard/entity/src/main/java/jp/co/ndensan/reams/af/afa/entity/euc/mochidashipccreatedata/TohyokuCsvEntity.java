/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ファイル出力（投票区ファイル）
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyokuCsvEntity {

    @CsvField(order = 1, name = "選挙種類")
    private RString 選挙種類;

    @CsvField(order = 2, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 3, name = "投票区名称")
    private RString 投票区名称;

    @CsvField(order = 4, name = "投票区名称（カナ）")
    private RString 投票区名称_カナ;

    @CsvField(order = 5, name = "投票区名称（検索カナ）")
    private RString 投票区名称_検索カナ;

    @CsvField(order = 6, name = "投票所名称")
    private RString 投票所名称;

    @CsvField(order = 7, name = "投票所名称（カナ）")
    private RString 投票所名称_カナ;

    @CsvField(order = 8, name = "投票所名称（検索カナ）")
    private RString 投票所名称_検索カナ;

    @CsvField(order = 9, name = "投票開始時刻")
    private RString 投票開始時刻;

    @CsvField(order = 10, name = "投票終了時刻")
    private RString 投票終了時刻;

    @CsvField(order = 11, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 12, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 13, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 14, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 15, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 16, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 17, name = "更新ユーザ")
    private RString 更新ユーザ;

}
