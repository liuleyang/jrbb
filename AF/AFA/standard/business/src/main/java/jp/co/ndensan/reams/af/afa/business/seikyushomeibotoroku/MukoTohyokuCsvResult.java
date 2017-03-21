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
public class MukoTohyokuCsvResult {

    @CsvField(order = 1, name = "投票区")
    private RString 投票区;

    @CsvField(order = 2, name = "投票所名")
    private RString 投票所名;

    @CsvField(order = 3, name = "名簿未登録")
    private Decimal 名簿未登録;

    @CsvField(order = 4, name = "管外居住")
    private Decimal 管外居住;

    @CsvField(order = 5, name = "署名日未記載")
    private Decimal 署名日未記載;

    @CsvField(order = 6, name = "住所未記載")
    private Decimal 住所未記載;

    @CsvField(order = 7, name = "生年月日未記載")
    private Decimal 生年月日未記載;

    @CsvField(order = 8, name = "無捺印")
    private Decimal 無捺印;

    @CsvField(order = 9, name = "自書と認めず")
    private Decimal 自書と認めず;

    @CsvField(order = 10, name = "同一筆跡代筆")
    private Decimal 同一筆跡代筆;

    @CsvField(order = 11, name = "重複署名")
    private Decimal 重複署名;

    @CsvField(order = 12, name = "何人か未確認")
    private Decimal 何人か未確認;

    @CsvField(order = 13, name = "期間外署名")
    private Decimal 期間外署名;

    @CsvField(order = 14, name = "委任日前")
    private Decimal 委任日前;

    @CsvField(order = 15, name = "無契印")
    private Decimal 無契印;

    @CsvField(order = 16, name = "欄外署名")
    private Decimal 欄外署名;

    @CsvField(order = 17, name = "委任状瑕疵")
    private Decimal 委任状瑕疵;

    @CsvField(order = 18, name = "受任者未登録")
    private Decimal 受任者未登録;

    @CsvField(order = 19, name = "委任届なし")
    private Decimal 委任届なし;

    @CsvField(order = 20, name = "その他")
    private Decimal その他;

}
