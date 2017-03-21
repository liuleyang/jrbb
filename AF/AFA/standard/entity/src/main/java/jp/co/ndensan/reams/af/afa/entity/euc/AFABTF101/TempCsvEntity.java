/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.afabtf101;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 名簿調製用連携ファイル作成する。
 *
 * @reamsid_L AF-0300-020 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempCsvEntity {

    @CsvField(order = 1, name = "個人識別ID")
    private RString 個人識別ID;
    @CsvField(order = 2, name = "氏名")
    private RString 氏名;
    @CsvField(order = 3, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 4, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 5, name = "住所")
    private RString 住所;
    @CsvField(order = 6, name = "本籍")
    private RString 本籍;

}
