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
 * ファイル出力（コードファイル）。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CodeCsvEntity {

    @CsvField(order = 1, name = "種別")
    private RString 種別;

    @CsvField(order = 2, name = "コード")
    private RString コード;

    @CsvField(order = 3, name = "名称")
    private RString 名称;

    @CsvField(order = 4, name = "略称")
    private RString 略称;

    @CsvField(order = 5, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 6, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 7, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 8, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 9, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 10, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 11, name = "更新ユーザ")
    private RString 更新ユーザ;

}
