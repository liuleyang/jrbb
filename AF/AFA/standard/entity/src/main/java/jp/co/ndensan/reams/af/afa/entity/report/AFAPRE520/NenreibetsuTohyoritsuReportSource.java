package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 年代別/年齢別投票率集計表帳票出力ののソース（自動生成）です。
 *
 * @reamsid_L AF-0290-035 lit
 */
public class NenreibetsuTohyoritsuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "tohyoYmd", length = 16, order = 2)
    public RString tohyoYmd;
    @ReportItem(name = "pagecnt", length = 5, order = 3)
    public RString pagecnt;
    @ReportItem(name = "shichosonCode", length = 6, order = 4)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 5)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 40, order = 6)
    public RString senkyoMei;
    @ReportItem(name = "tohyokuCode", length = 4, order = 7)
    public RString tohyokuCode;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 8)
    public RString sakuseiYmdTime;
    @ReportItem(name = "listMeisai1_1", length = 10, order = 9)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai2_1", length = 10, order = 10)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai3_1", length = 16, order = 11)
    public RString listMeisai3_1;
    @ReportItem(name = "listMeisai1_2", length = 9, order = 12)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai2_2", length = 9, order = 13)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai3_2", length = 9, order = 14)
    public RString listMeisai3_2;
    @ReportItem(name = "listMeisai1_3", length = 9, order = 15)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai2_3", length = 9, order = 16)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai3_3", length = 9, order = 17)
    public RString listMeisai3_3;
    @ReportItem(name = "listMeisai1_4", length = 11, order = 18)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai2_4", length = 11, order = 19)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai3_4", length = 11, order = 20)
    public RString listMeisai3_4;
    @ReportItem(name = "listMeisai1_5", length = 9, order = 21)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai2_5", length = 9, order = 22)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai3_5", length = 9, order = 23)
    public RString listMeisai3_5;
    @ReportItem(name = "listMeisai1_6", length = 9, order = 24)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai2_6", length = 9, order = 25)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai3_6", length = 9, order = 26)
    public RString listMeisai3_6;
    @ReportItem(name = "listMeisai1_7", length = 11, order = 27)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai2_7", length = 11, order = 28)
    public RString listMeisai2_7;
    @ReportItem(name = "listMeisai3_7", length = 11, order = 29)
    public RString listMeisai3_7;
    @ReportItem(name = "listMeisai1_8", length = 9, order = 30)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai2_8", length = 9, order = 31)
    public RString listMeisai2_8;
    @ReportItem(name = "listMeisai3_8", length = 9, order = 32)
    public RString listMeisai3_8;
    @ReportItem(name = "listMeisai1_9", length = 9, order = 33)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai2_9", length = 9, order = 34)
    public RString listMeisai2_9;
    @ReportItem(name = "listMeisai3_9", length = 9, order = 35)
    public RString listMeisai3_9;
    @ReportItem(name = "listMeisai1_10", length = 11, order = 36)
    public RString listMeisai1_10;
    @ReportItem(name = "listMeisai2_10", length = 11, order = 37)
    public RString listMeisai2_10;
    @ReportItem(name = "listMeisai3_10", length = 11, order = 38)
    public RString listMeisai3_10;
    @ReportItem(name = "listMeisai1_11", length = 6, order = 39)
    public RString listMeisai1_11;
    @ReportItem(name = "listMeisai2_11", length = 6, order = 40)
    public RString listMeisai2_11;
    @ReportItem(name = "listMeisai3_11", length = 6, order = 41)
    public RString listMeisai3_11;
    @ReportItem(name = "listMeisai1_12", length = 6, order = 42)
    public RString listMeisai1_12;
    @ReportItem(name = "listMeisai2_12", length = 6, order = 43)
    public RString listMeisai2_12;
    @ReportItem(name = "listMeisai3_12", length = 6, order = 44)
    public RString listMeisai3_12;
    @ReportItem(name = "listMeisai1_13", length = 6, order = 45)
    public RString listMeisai1_13;
    @ReportItem(name = "listMeisai2_13", length = 6, order = 46)
    public RString listMeisai2_13;
    @ReportItem(name = "listMeisai3_13", length = 6, order = 47)
    public RString listMeisai3_13;

    @ReportItem(name = "senkyoNo", length = 10, order = 100)
    public RString senkyoNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * DataTypeのEnum
     */
    public enum DataType {

        /**
         * 選挙系
         */
        選挙系,
        /**
         * 投票区系
         */
        投票区系,
        /**
         * 行政区系
         */
        行政区系;
    }

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFileds {

        /**
         * tohyokuCode
         */
        tohyokuCode,
        /**
         * senkyoNo
         */
        senkyoNo;
    }
}
