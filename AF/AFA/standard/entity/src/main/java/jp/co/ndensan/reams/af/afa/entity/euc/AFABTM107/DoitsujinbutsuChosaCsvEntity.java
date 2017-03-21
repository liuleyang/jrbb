package jp.co.ndensan.reams.af.afa.entity.euc.afabtm107;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（同一人物調査結果）
 *
 * @reamsid_L AF-0690-020 wanghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DoitsujinbutsuChosaCsvEntity {

    @CsvField(order = 1, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 2, name = "氏名")
    private RString 氏名;
    @CsvField(order = 3, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 4, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 5, name = "性別")
    private RString 性別;
    @CsvField(order = 6, name = "性別名称")
    private RString 性別名称;
    @CsvField(order = 7, name = "全国住所コード")
    private RString 全国住所コード;
    @CsvField(order = 8, name = "住所")
    private RString 住所;
    @CsvField(order = 9, name = "番地")
    private RString 番地;
    @CsvField(order = 10, name = "方書")
    private RString 方書;
    @CsvField(order = 11, name = "番地コード1")
    private RString 番地コード1;
    @CsvField(order = 12, name = "番地コード2")
    private RString 番地コード2;
    @CsvField(order = 13, name = "番地コード3")
    private RString 番地コード3;
    @CsvField(order = 14, name = "番地コード4")
    private RString 番地コード4;
    @CsvField(order = 15, name = "抄本番号")
    private RString 抄本番号;
    @CsvField(order = 16, name = "グループコード")
    private RString グループコード;
    @CsvField(order = 17, name = "選挙人名簿投票区コード")
    private RString 選挙人名簿投票区コード;
    @CsvField(order = 18, name = "冊")
    private RString 冊;
    @CsvField(order = 19, name = "頁")
    private RString 頁;
    @CsvField(order = 20, name = "行")
    private RString 行;
    @CsvField(order = 21, name = "選挙人名簿履歴番号")
    private RString 選挙人名簿履歴番号;
    @CsvField(order = 22, name = "投票区変更抹消フラグ")
    private RString 投票区変更抹消フラグ;
    @CsvField(order = 23, name = "連番")
    private RString 連番;
    @CsvField(order = 24, name = "枝番")
    private RString 枝番;
    @CsvField(order = 25, name = "選挙種類")
    private RString 選挙種類;
    @CsvField(order = 26, name = "選挙種類名称")
    private RString 選挙種類名称;
    @CsvField(order = 27, name = "選挙資格履歴番号")
    private RString 選挙資格履歴番号;
    @CsvField(order = 28, name = "選挙資格区分")
    private RString 選挙資格区分;
    @CsvField(order = 29, name = "選挙資格区分名称")
    private RString 選挙資格区分名称;
    @CsvField(order = 30, name = "選挙資格投票区コード")
    private RString 選挙資格投票区コード;
    @CsvField(order = 31, name = "名簿登録年月日")
    private RString 名簿登録年月日;
    @CsvField(order = 32, name = "登録事由コード")
    private RString 登録事由コード;
    @CsvField(order = 33, name = "登録事由名称")
    private RString 登録事由名称;
    @CsvField(order = 34, name = "登録停止年月日")
    private RString 登録停止年月日;
    @CsvField(order = 35, name = "登録停止事由コード")
    private RString 登録停止事由コード;
    @CsvField(order = 36, name = "登録停止事由名称")
    private RString 登録停止事由名称;
    @CsvField(order = 37, name = "表示年月日")
    private RString 表示年月日;
    @CsvField(order = 38, name = "表示事由コード")
    private RString 表示事由コード;
    @CsvField(order = 39, name = "表示事由名称")
    private RString 表示事由名称;
    @CsvField(order = 40, name = "表示消除年月日")
    private RString 表示消除年月日;
    @CsvField(order = 41, name = "表示消除予定年月日")
    private RString 表示消除予定年月日;
    @CsvField(order = 42, name = "抹消年月日")
    private RString 抹消年月日;
    @CsvField(order = 43, name = "抹消事由コード")
    private RString 抹消事由コード;
    @CsvField(order = 44, name = "抹消事由名称")
    private RString 抹消事由名称;
    @CsvField(order = 45, name = "刑期終了年月日")
    private RString 刑期終了年月日;
    @CsvField(order = 46, name = "刑持ちフラグ")
    private RString 刑持ちフラグ;
    @CsvField(order = 47, name = "投票資格種類")
    private RString 投票資格種類;
    @CsvField(order = 48, name = "投票資格種類名称")
    private RString 投票資格種類名称;
    @CsvField(order = 49, name = "不在者投票資格履歴番号")
    private RString 不在者投票資格履歴番号;
    @CsvField(order = 50, name = "交付年月日")
    private RString 交付年月日;
    @CsvField(order = 51, name = "交付番号")
    private RString 交付番号;
    @CsvField(order = 52, name = "資格登録年月日")
    private RString 資格登録年月日;
    @CsvField(order = 53, name = "資格満了年月日")
    private RString 資格満了年月日;
    @CsvField(order = 54, name = "資格抹消年月日")
    private RString 資格抹消年月日;
    @CsvField(order = 55, name = "資格抹消事由コード")
    private RString 資格抹消事由コード;
    @CsvField(order = 56, name = "資格抹消事由名称")
    private RString 資格抹消事由名称;

}
