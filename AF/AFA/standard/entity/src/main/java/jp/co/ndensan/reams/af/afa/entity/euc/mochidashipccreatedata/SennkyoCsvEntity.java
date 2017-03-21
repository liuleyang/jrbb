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
 * ファイル出力（選挙ファイル）
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SennkyoCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;

    @CsvField(order = 2, name = "選挙番号")
    private RString 選挙番号;

    @CsvField(order = 3, name = "選挙レベル")
    private RString 選挙レベル;

    @CsvField(order = 4, name = "選挙名称")
    private RString 選挙名称;

    @CsvField(order = 5, name = "選挙略称")
    private RString 選挙略称;

    @CsvField(order = 6, name = "選挙マーク")
    private RString 選挙マーク;

    @CsvField(order = 7, name = "基準年月日")
    private RString 基準年月日;

    @CsvField(order = 8, name = "告示（公示）年月日")
    private RString 告示_公示_年月日;

    @CsvField(order = 9, name = "投票受付開始年月日")
    private RString 投票受付開始年月日;

    @CsvField(order = 10, name = "投票年月日")
    private RString 投票年月日;

    @CsvField(order = 11, name = "投票有無")
    private RString 投票有無;

    @CsvField(order = 12, name = "抄本取込済フラグ")
    private RString 抄本取込済フラグ;

    @CsvField(order = 13, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 14, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 15, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 16, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 17, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 18, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 19, name = "更新ユーザ")
    private RString 更新ユーザ;

}
