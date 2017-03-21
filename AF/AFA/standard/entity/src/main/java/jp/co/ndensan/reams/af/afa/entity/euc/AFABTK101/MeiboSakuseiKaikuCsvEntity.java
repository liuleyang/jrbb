/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.afabtk101;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。
 *
 * @reamsid_L AF-0460-020 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MeiboSakuseiKaikuCsvEntity {

    @CsvField(order = 1, length = 15, name = "識別コード")
    private RString 識別コード;

    @CsvField(order = 2, length = 4, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 3, length = 7, name = "郵便番号")
    private RString 郵便番号;

    @CsvField(order = 4, length = 50, name = "住所")
    private RString 住所;

    @CsvField(order = 5, length = 120, name = "氏名")
    private RString 氏名;

    @CsvField(order = 6, length = 120, name = "カナ氏名")
    private RString カナ氏名;

    @CsvField(order = 7, length = 8, name = "生年月日")
    private RString 生年月日;

    @CsvField(order = 8, length = 1, name = "性別")
    private RString 性別;

    @CsvField(order = 9, length = 10, name = "漁業者番号")
    private RString 漁業者番号;

    @CsvField(order = 10, length = 7, name = "組合コード")
    private RString 組合コード;

    @CsvField(order = 11, length = 2, name = "漁業日数漁業者")
    private int 漁業日数漁業者;

    @CsvField(order = 12, length = 2, name = "漁業日数漁業従事者")
    private int 漁業日数漁業従事者;

    @CsvField(order = 13, length = 2, name = "漁業種類")
    private RString 漁業種類;

    @CsvField(order = 14, length = 2, name = "使用漁船種別")
    private RString 使用漁船種別;

    @CsvField(order = 15, length = 20, name = "船名")
    private RString 船名;

    @CsvField(order = 16, length = 12, name = "登録番号")
    private RString 登録番号;

}
