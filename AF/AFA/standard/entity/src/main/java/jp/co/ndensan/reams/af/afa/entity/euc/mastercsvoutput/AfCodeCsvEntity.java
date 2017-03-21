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
 * ファイル出力（コード管理ファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AfCodeCsvEntity {

    @CsvField(order = 1, name = "種別")
    private RString 種別;

    @CsvField(order = 2, name = "種別名称")
    private RString 種別名称;

    @CsvField(order = 3, name = "有効桁数")
    private RString 有効桁数;

    @CsvField(order = 4, name = "システム区分")
    private RString システム区分;

    @CsvField(order = 5, name = "カスタマイズ区分")
    private RString カスタマイズ区分;

    @CsvField(order = 6, name = "親種別")
    private RString 親種別;

    @CsvField(order = 7, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 8, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 9, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 10, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 11, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 12, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 13, name = "更新ユーザ")
    private RString 更新ユーザ;

}
