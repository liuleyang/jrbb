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
 * ファイル出力（抄本ファイル）
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShohonCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;

    @CsvField(order = 2, name = "グループコード")
    private RString グループコード;

    @CsvField(order = 3, name = "選挙区コード")
    private RString 選挙区コード;

    @CsvField(order = 4, name = "投票区コード")
    private RString 投票区コード;

    @CsvField(order = 5, name = "冊")
    private RString 冊;

    @CsvField(order = 6, name = "頁")
    private RString 頁;

    @CsvField(order = 7, name = "行")
    private RString 行;

    @CsvField(order = 8, name = "市町村コード")
    private RString 市町村コード;

    @CsvField(order = 9, name = "郵便番号")
    private RString 郵便番号;

    @CsvField(order = 10, name = "住所コード")
    private RString 住所コード;

    @CsvField(order = 11, name = "住所")
    private RString 住所;

    @CsvField(order = 12, name = "行政区コード")
    private RString 行政区コード;

    @CsvField(order = 13, name = "行政区名")
    private RString 行政区名;

    @CsvField(order = 14, name = "地区コード1")
    private RString 地区コード1;

    @CsvField(order = 15, name = "地区名1")
    private RString 地区名1;

    @CsvField(order = 16, name = "地区コード2")
    private RString 地区コード2;

    @CsvField(order = 17, name = "地区名2")
    private RString 地区名2;

    @CsvField(order = 18, name = "地区コード3")
    private RString 地区コード3;

    @CsvField(order = 19, name = "地区名3")
    private RString 地区名3;

    @CsvField(order = 20, name = "番地コード1")
    private RString 番地コード1;

    @CsvField(order = 21, name = "番地コード2")
    private RString 番地コード2;

    @CsvField(order = 22, name = "番地コード3")
    private RString 番地コード3;

    @CsvField(order = 23, name = "番地")
    private RString 番地;

    @CsvField(order = 24, name = "方書コード")
    private RString 方書コード;

    @CsvField(order = 25, name = "方書")
    private RString 方書;

    @CsvField(order = 26, name = "転入前郵便番号")
    private RString 転入前郵便番号;

    @CsvField(order = 27, name = "転入前全国住所コード")
    private RString 転入前全国住所コード;

    @CsvField(order = 28, name = "転入前住所")
    private RString 転入前住所;

    @CsvField(order = 29, name = "転入前番地")
    private RString 転入前番地;

    @CsvField(order = 30, name = "転入前方書")
    private RString 転入前方書;

    @CsvField(order = 31, name = "転出先郵便番号")
    private RString 転出先郵便番号;

    @CsvField(order = 32, name = "転出先全国住所コード")
    private RString 転出先全国住所コード;

    @CsvField(order = 33, name = "転出先住所")
    private RString 転出先住所;

    @CsvField(order = 34, name = "転出先番地")
    private RString 転出先番地;

    @CsvField(order = 35, name = "転出先方書")
    private RString 転出先方書;

    @CsvField(order = 36, name = "転出先世帯主名")
    private RString 転出先世帯主名;

    @CsvField(order = 37, name = "住民コード")
    private RString 住民コード;

    @CsvField(order = 38, name = "漢字氏名")
    private RString 漢字氏名;

    @CsvField(order = 39, name = "カナ氏名")
    private RString カナ氏名;

    @CsvField(order = 40, name = "検索用カナ姓名")
    private RString 検索用カナ姓名;

    @CsvField(order = 41, name = "検索用カナ姓")
    private RString 検索用カナ姓;

    @CsvField(order = 42, name = "検索用カナ名")
    private RString 検索用カナ名;

    @CsvField(order = 43, name = "漢字通称名")
    private RString 漢字通称名;

    @CsvField(order = 44, name = "カナ通称名")
    private RString カナ通称名;

    @CsvField(order = 45, name = "世帯コード")
    private RString 世帯コード;

    @CsvField(order = 46, name = "世帯主名")
    private RString 世帯主名;

    @CsvField(order = 47, name = "カナ世帯主名")
    private RString カナ世帯主名;

    @CsvField(order = 48, name = "住民種別")
    private RString 住民種別;

    @CsvField(order = 49, name = "生年月日")
    private RString 生年月日;

    @CsvField(order = 50, name = "性別コード")
    private RString 性別コード;

    @CsvField(order = 51, name = "続柄コード")
    private RString 続柄コード;

    @CsvField(order = 52, name = "続柄")
    private RString 続柄;

    @CsvField(order = 53, name = "住基表示順")
    private RString 住基表示順;

    @CsvField(order = 54, name = "住基登録年月日")
    private RString 住基登録年月日;

    @CsvField(order = 55, name = "住基消除年月日")
    private RString 住基消除年月日;

    @CsvField(order = 56, name = "転入届出年月日")
    private RString 転入届出年月日;

    @CsvField(order = 57, name = "転入異動年月日")
    private RString 転入異動年月日;

    @CsvField(order = 58, name = "転入区分")
    private RString 転入区分;

    @CsvField(order = 59, name = "転出届出年月日")
    private RString 転出届出年月日;

    @CsvField(order = 60, name = "転出異動年月日")
    private RString 転出異動年月日;

    @CsvField(order = 61, name = "転出区分")
    private RString 転出区分;

    @CsvField(order = 62, name = "選挙資格区分")
    private RString 選挙資格区分;

    @CsvField(order = 63, name = "選挙登録年月日")
    private RString 選挙登録年月日;

    @CsvField(order = 64, name = "選挙登録理由コード")
    private RString 選挙登録理由コード;

    @CsvField(order = 65, name = "表示年月日")
    private RString 表示年月日;

    @CsvField(order = 66, name = "表示理由コード")
    private RString 表示理由コード;

    @CsvField(order = 67, name = "抹消年月日")
    private RString 抹消年月日;

    @CsvField(order = 68, name = "抹消理由コード")
    private RString 抹消理由コード;

    @CsvField(order = 69, name = "転出表示区分")
    private RString 転出表示区分;

    @CsvField(order = 70, name = "失権区分")
    private RString 失権区分;

    @CsvField(order = 71, name = "居住区分")
    private RString 居住区分;

    @CsvField(order = 72, name = "不在者期日前１")
    private RString 不在者期日前１;

    @CsvField(order = 73, name = "不在者期日前２")
    private RString 不在者期日前２;

    @CsvField(order = 74, name = "不在者期日前３")
    private RString 不在者期日前３;

    @CsvField(order = 75, name = "不在者期日前４")
    private RString 不在者期日前４;

    @CsvField(order = 76, name = "不在者期日前５")
    private RString 不在者期日前５;

    @CsvField(order = 77, name = "不在者期日前６")
    private RString 不在者期日前６;

    @CsvField(order = 78, name = "不在者期日前７")
    private RString 不在者期日前７;

    @CsvField(order = 79, name = "不在者期日前８")
    private RString 不在者期日前８;

    @CsvField(order = 80, name = "不在者期日前９")
    private RString 不在者期日前９;

    @CsvField(order = 81, name = "投票状況１")
    private RString 投票状況１;

    @CsvField(order = 82, name = "投票状況２")
    private RString 投票状況２;

    @CsvField(order = 83, name = "投票状況３")
    private RString 投票状況３;

    @CsvField(order = 84, name = "投票状況４")
    private RString 投票状況４;

    @CsvField(order = 85, name = "投票状況５")
    private RString 投票状況５;

    @CsvField(order = 86, name = "投票状況６")
    private RString 投票状況６;

    @CsvField(order = 87, name = "投票状況７")
    private RString 投票状況７;

    @CsvField(order = 88, name = "投票状況８")
    private RString 投票状況８;

    @CsvField(order = 89, name = "投票状況９")
    private RString 投票状況９;

    @CsvField(order = 90, name = "交付施設コード１")
    private RString 交付施設コード１;

    @CsvField(order = 91, name = "交付施設コード２")
    private RString 交付施設コード２;

    @CsvField(order = 92, name = "交付施設コード３")
    private RString 交付施設コード３;

    @CsvField(order = 93, name = "交付施設コード４")
    private RString 交付施設コード４;

    @CsvField(order = 94, name = "交付施設コード５")
    private RString 交付施設コード５;

    @CsvField(order = 95, name = "交付施設コード６")
    private RString 交付施設コード６;

    @CsvField(order = 96, name = "交付施設コード７")
    private RString 交付施設コード７;

    @CsvField(order = 97, name = "交付施設コード８")
    private RString 交付施設コード８;

    @CsvField(order = 98, name = "交付施設コード９")
    private RString 交付施設コード９;

    @CsvField(order = 99, name = "洋上投票者区分")
    private RString 洋上投票者区分;

    @CsvField(order = 100, name = "耕作面積")
    private RString 耕作面積;

    @CsvField(order = 101, name = "法人名")
    private RString 法人名;

    @CsvField(order = 102, name = "組合コード")
    private RString 組合コード;

    @CsvField(order = 103, name = "組合名")
    private RString 組合名;

    @CsvField(order = 104, name = "代表者区分")
    private RString 代表者区分;

    @CsvField(order = 105, name = "従事日数")
    private RString 従事日数;

    @CsvField(order = 106, name = "端末ID")
    private RString 端末ID;

    @CsvField(order = 107, name = "削除フラグ")
    private RString 削除フラグ;

    @CsvField(order = 108, name = "更新カウンタ")
    private RString 更新カウンタ;

    @CsvField(order = 109, name = "作成日時")
    private RString 作成日時;

    @CsvField(order = 110, name = "作成ユーザ")
    private RString 作成ユーザ;

    @CsvField(order = 111, name = "更新日時")
    private RString 更新日時;

    @CsvField(order = 112, name = "更新ユーザ")
    private RString 更新ユーザ;

}
