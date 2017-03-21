package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "shichosonMei", length = 20, order = 2)
    public RString shichosonMei;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "senkyoMei", length = 30, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "pagecnt", length = 5, order = 6)
    public RString pagecnt;
    @ReportItem(name = "meisaiTitleDate", length = 6, order = 7)
    public RString meisaiTitleDate;
    @ReportItem(name = "meisaiTitle", length = 6, order = 8)
    public RString meisaiTitle;
    @ReportItem(name = "listMeisai_1", length = 16, order = 9)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 6, order = 10)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 6, order = 11)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 6, order = 12)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 6, order = 13)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 6, order = 14)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 6, order = 15)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 6, order = 16)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 6, order = 17)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 6, order = 18)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 6, order = 19)
    public RString listMeisai_11;
    @ReportItem(name = "listMeisai_12", length = 6, order = 20)
    public RString listMeisai_12;
    @ReportItem(name = "listMeisai_13", length = 6, order = 21)
    public RString listMeisai_13;
    @ReportItem(name = "sakuseiJoken1", length = 70, order = 22)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 70, order = 23)
    public RString sakuseiJoken2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", order = 24)
    public RString senkyoNo;

    /**
     * 不在者投票日報エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        title,
        shichosonMei,
        shichosonCode,
        senkyoMei,
        sakuseiYmdTime,
        pagecnt,
        meisaiTitleDate,
        meisaiTitle,
        listMeisai_1,
        listMeisai_2,
        listMeisai_3,
        listMeisai_4,
        listMeisai_5,
        listMeisai_6,
        listMeisai_7,
        listMeisai_8,
        listMeisai_9,
        listMeisai_10,
        listMeisai_11,
        listMeisai_12,
        listMeisai_13,
        sakuseiJoken1,
        sakuseiJoken2,
        senkyoNo;
    }
// </editor-fold>
}
