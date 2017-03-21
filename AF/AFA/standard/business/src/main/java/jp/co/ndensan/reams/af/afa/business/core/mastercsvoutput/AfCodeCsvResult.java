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
 * ファイル出力（コード管理ファイル）。
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AfCodeCsvResult {

    @CsvField(order = 1, name = "スキーマ名")
    private RString スキーマ名;

    @CsvField(order = 2, name = "サブ業務コード")
    private RString サブ業務コード;

    @CsvField(order = 3, name = "コード種別")
    private RString コード種別;

    @CsvField(order = 4, name = "コード種別名称")
    private RString コード種別名称;

    @CsvField(order = 5, name = "有効桁数")
    private RString 有効桁数;

    @CsvField(order = 6, name = "コード追加可否")
    private RString コード追加可否;

    @CsvField(order = 7, name = "コード種別説明")
    private RString コード種別説明;

    @CsvField(order = 8, name = "オプション1名称")
    private RString オプション1名称;

    @CsvField(order = 9, name = "オプション2名称")
    private RString オプション2名称;

    @CsvField(order = 10, name = "オプション3名称")
    private RString オプション3名称;

    @CsvField(order = 11, name = "コード")
    private RString コード;

    @CsvField(order = 12, name = "コード名称")
    private RString コード名称;

    @CsvField(order = 13, name = "コード略称")
    private RString コード略称;

    @CsvField(order = 14, name = "更新可否")
    private RString 更新可否;

    @CsvField(order = 15, name = "表示順")
    private RString 表示順;

    @CsvField(order = 16, name = "オプション1")
    private RString オプション1;

    @CsvField(order = 17, name = "オプション2")
    private RString オプション2;

    @CsvField(order = 18, name = "オプション3")
    private RString オプション3;

    @CsvField(order = 19, name = "有効開始年月日")
    private RString 有効開始年月日;

    @CsvField(order = 20, name = "有効終了年月日")
    private RString 有効終了年月日;

}
