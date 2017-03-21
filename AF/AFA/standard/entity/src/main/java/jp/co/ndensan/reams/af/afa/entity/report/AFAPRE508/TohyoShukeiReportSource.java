package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 投票集計表のReportSourceです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class TohyoShukeiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "pagecnt", length = 5, order = 1)
    public RString pagecnt;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "tohyokuMei", length = 8, order = 4)
    public RString tohyokuMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 5)
    public RString senkyoMei;
    @ReportItem(name = "tohyoYmdEnd", length = 11, order = 6)
    public RString tohyoYmdEnd;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 7)
    public RString sakuseiYmdTime;
    @ReportItem(name = "tohyoKikanTitle", length = 4, order = 8)
    public RString tohyoKikanTitle;
    @ReportItem(name = "tohyoYmdStart", length = 11, order = 9)
    public RString tohyoYmdStart;
    @ReportItem(name = "kara", length = 1, order = 10)
    public RString kara;
    @ReportItem(name = "meisaiTitle", length = 8, order = 11)
    public RString meisaiTitle;
    @ReportItem(name = "listMeisai_1", length = 18, order = 12)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 9, order = 13)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 9, order = 14)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 9, order = 15)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 9, order = 16)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 9, order = 17)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 9, order = 18)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 9, order = 19)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 9, order = 20)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 9, order = 21)
    public RString listMeisai_10;
    @ReportItem(name = "sakuseiJoken1", length = 50, order = 22)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 50, order = 23)
    public RString sakuseiJoken2;
    @ReportItem(name = "tohyokuCode", length = 10, order = 100)
    public RString tohyokuCode;
    @ReportItem(name = "senkyoNo", length = 10, order = 101)
    public RString senkyoNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

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

    /**
     * DataTypeのEnum
     */
    public enum DataType {

        /**
         * データ
         */
        データ(1),
        /**
         * 小計
         */
        小計(2),
        /**
         * 合計
         */
        合計(3),
        /**
         * 合計の行
         */
        合計の行(4);

        private final int key;

        private DataType(int key) {
            this.key = key;
        }

        /**
         * DataTypeのkeyの取得
         *
         * @return DataTypeのkey
         */
        public int getKey() {
            return this.key;
        }
    }
}
