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
 * ファイル出力（当日投票率ファイル）。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TojituTohyorituCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;

    @CsvField(order = 2, name = "選挙番号")
    private RString 選挙番号;

    @CsvField(order = 3, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 4, name = "データ区分")
    private RString データ区分;

    @CsvField(order = 5, name = "開始時刻")
    private RString 開始時刻;

    @CsvField(order = 6, name = "終了時刻")
    private RString 終了時刻;

    @CsvField(order = 7, name = "投票数（男）")
    private RString 投票数_男;

    @CsvField(order = 8, name = "投票数（女）")
    private RString 投票数_女;

    @CsvField(order = 9, name = "投票数（計）")
    private RString 投票数_計;

    @CsvField(order = 10, name = "代理投票者数")
    private RString 代理投票者数;

    @CsvField(order = 11, name = "点字用紙数")
    private RString 点字用紙数;

    @CsvField(order = 12, name = "棄権数")
    private RString 棄権数;

    @CsvField(order = 13, name = "共通投票所_投票数_男")
    private RString 共通投票所_投票数_男;

    @CsvField(order = 14, name = "共通投票所_投票数_女")
    private RString 共通投票所_投票数_女;

    @CsvField(order = 15, name = "共通投票所_投票数_計")
    private RString 共通投票所_投票数_計;

    @CsvField(order = 16, name = "共通投票所_代理投票者数")
    private RString 共通投票所_代理投票者数;

    @CsvField(order = 17, name = "共通投票所_点字用紙数")
    private RString 共通投票所_点字用紙数;

    @CsvField(order = 18, name = "共通投票所_棄権数")
    private RString 共通投票所_棄権数;

    @CsvField(order = 19, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 20, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 21, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 22, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 23, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 24, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 25, name = "更新ユーザ")
    private RString 更新ユーザ;

}
