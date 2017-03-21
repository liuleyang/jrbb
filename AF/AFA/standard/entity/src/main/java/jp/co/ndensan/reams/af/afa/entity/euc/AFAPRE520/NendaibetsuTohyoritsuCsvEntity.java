/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.euc.afapre520;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（年代別投票率集計表）
 *
 * @reamsid_L AF-0290-035 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendaibetsuTohyoritsuCsvEntity {

    @CsvField(order = 1, name = "抄本番号")
    private RString 抄本番号;
    @CsvField(order = 2, name = "抄本名称")
    private RString 抄本名称;
    @CsvField(order = 3, name = "選挙番号")
    private RString 選挙番号;
    @CsvField(order = 4, name = "選挙名称")
    private RString 選挙名称;
    @CsvField(order = 5, name = "投票区コード")
    private RString 投票区コード;
    @CsvField(order = 6, name = "投票所名")
    private RString 投票所名;
    @CsvField(order = 7, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 8, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 9, name = "年代")
    private RString 年代;
    @CsvField(order = 10, name = "年代別行政区有権者数(男)")
    private RString 有権者男;
    @CsvField(order = 11, name = "年代別行政区有権者数(女)")
    private RString 有権者女;
    @CsvField(order = 12, name = "年代別行政区有権者数(合計)")
    private RString 有権者計;
    @CsvField(order = 13, name = "投票者数(男)")
    private RString 投票者男;
    @CsvField(order = 14, name = "投票者数(女)")
    private RString 投票者女;
    @CsvField(order = 15, name = "投票者数(合計)")
    private RString 投票者計;
    @CsvField(order = 16, name = "投票率(男)")
    private RString 投票率男;
    @CsvField(order = 17, name = "投票率(女)")
    private RString 投票率女;
    @CsvField(order = 18, name = "投票率(合計)")
    private RString 投票率計;
    @CsvField(order = 19, name = "内当日投票者数(男)")
    private RString 当日投票男;
    @CsvField(order = 20, name = "内当日投票者数(女)")
    private RString 当日投票女;
    @CsvField(order = 21, name = "内当日投票者数(合計)")
    private RString 当日投票計;
    @CsvField(order = 22, name = "内期日前投票者数(男)")
    private RString 期日前投票男;
    @CsvField(order = 23, name = "内期日前投票者数(女)")
    private RString 期日前投票女;
    @CsvField(order = 24, name = "内期日前投票者数(合計)")
    private RString 期日前投票計;
    @CsvField(order = 25, name = "内不在者投票者数(男)")
    private RString 不在投票者男;
    @CsvField(order = 26, name = "内不在者投票者数(女)")
    private RString 不在投票者女;
    @CsvField(order = 27, name = "内不在者投票者数(合計)")
    private RString 不在投票者計;
    @CsvField(order = 28, name = "交付のみ数(男)")
    private RString 交付男;
    @CsvField(order = 29, name = "交付のみ数(女)")
    private RString 交付女;
    @CsvField(order = 30, name = "交付のみ数(合計)")
    private RString 交付計;
    @CsvField(order = 31, name = "行政区有権者数(男)")
    private RString 行政区有権者男数;
    @CsvField(order = 32, name = "行政区有権者数(女)")
    private RString 行政区有権者女数;
    @CsvField(order = 33, name = "行政区有権者数(合計)")
    private RString 行政区有権者数;
    @CsvField(order = 34, name = "投票区有権者数(男)")
    private RString 投票区有権者男数;
    @CsvField(order = 35, name = "投票区有権者数(女)")
    private RString 投票区有権者女数;
    @CsvField(order = 36, name = "投票区有権者数(合計)")
    private RString 投票区有権者数;
    @CsvField(order = 37, name = "全有権者数(男)")
    private RString 全有権者男数;
    @CsvField(order = 38, name = "全有権者数(女)")
    private RString 全有権者女数;
    @CsvField(order = 39, name = "全有権者数(合計)")
    private RString 全有権者数;
}
