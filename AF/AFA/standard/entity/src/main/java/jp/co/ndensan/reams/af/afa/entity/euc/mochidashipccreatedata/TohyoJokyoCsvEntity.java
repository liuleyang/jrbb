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
 * ファイル出力（投票状況ファイル）
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyoJokyoCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;

    @CsvField(order = 2, name = "選挙番号")
    private RString 選挙番号;

    @CsvField(order = 3, name = "グループコード")
    private RString グループコード;

    @CsvField(order = 4, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 5, name = "冊")
    private RString 冊;

    @CsvField(order = 6, name = "頁")
    private RString 頁;

    @CsvField(order = 7, name = "行")
    private RString 行;

    @CsvField(order = 8, name = "住民コード")
    private RString 住民コード;

    @CsvField(order = 9, name = "請求年月日")
    private RString 請求年月日;

    @CsvField(order = 10, name = "請求方法")
    private RString 請求方法;

    @CsvField(order = 11, name = "請求事由")
    private RString 請求事由;

    @CsvField(order = 12, name = "交付表示")
    private RString 交付表示;

    @CsvField(order = 13, name = "交付年月日")
    private RString 交付年月日;

    @CsvField(order = 14, name = "交付時刻")
    private RString 交付時刻;

    @CsvField(order = 15, name = "交付区分")
    private RString 交付区分;

    @CsvField(order = 16, name = "交付受付番号")
    private RString 交付受付番号;

    @CsvField(order = 17, name = "交付方法")
    private RString 交付方法;

    @CsvField(order = 18, name = "交付施設コード")
    private RString 交付施設コード;

    @CsvField(order = 19, name = "点字")
    private RString 点字;

    @CsvField(order = 20, name = "証明書の有無")
    private RString 証明書の有無;

    @CsvField(order = 21, name = "受理表示")
    private RString 受理表示;

    @CsvField(order = 22, name = "受理年月日")
    private RString 受理年月日;

    @CsvField(order = 23, name = "受理時刻")
    private RString 受理時刻;

    @CsvField(order = 24, name = "受理方法")
    private RString 受理方法;

    @CsvField(order = 25, name = "受理施設（投票場所）")
    private RString 受理施設_投票場所;

    @CsvField(order = 26, name = "返還年月日")
    private RString 返還年月日;

    @CsvField(order = 27, name = "返還時刻")
    private RString 返還時刻;

    @CsvField(order = 28, name = "代理投票区分")
    private RString 代理投票区分;

    @CsvField(order = 29, name = "補助者1")
    private RString 補助者1;

    @CsvField(order = 30, name = "補助者2")
    private RString 補助者2;

    @CsvField(order = 31, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 32, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 33, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 34, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 35, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 36, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 37, name = "更新ユーザ")
    private RString 更新ユーザ;

}
