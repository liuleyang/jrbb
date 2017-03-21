/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 裁判員候補者予定者取込(ファイル)
 *
 * @reamsid_L AF-0310-011 guancy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaibaninTorikomiCsvResult {

    @CsvField(order = 1, name = "氏名")
    private RString 氏名;

    @CsvField(order = 2, name = "生年月日")
    private RString 生年月日;

    @CsvField(order = 3, name = "郵便番号")
    private RString 郵便番号;

    @CsvField(order = 4, name = "住所")
    private RString 住所;

    @CsvField(order = 5, name = "本籍")
    private RString 本籍;

    @CsvField(order = 6, name = "識別コード")
    private RString 識別コード;

}
