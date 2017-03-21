package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE518;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 不在者投票管理者別の調書帳票出力ののソース（自動生成）です。
 *
 * @reamsid_L AF-0280-035 lit
 */
public class FuzaishaKanribetsuChoshoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "pagecnt", length = 5, order = 1)
    public RString pagecnt;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "listMeisai_1", length = 4, order = 6)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 9, order = 7)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 9, order = 8)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 9, order = 9)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 9, order = 10)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 9, order = 11)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 9, order = 12)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 9, order = 13)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 10, order = 14)
    public RString listMeisai_9;
    @ReportItem(name = "sakuseiJoken1", length = 50, order = 15)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 50, order = 16)
    public RString sakuseiJoken2;

    @ReportItem(name = "senkyoNo", length = 9, order = 100)
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
         * senkyoNo
         */
        senkyoNo;
    }
}
