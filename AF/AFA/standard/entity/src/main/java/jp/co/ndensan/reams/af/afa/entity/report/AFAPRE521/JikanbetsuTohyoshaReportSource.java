package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 時間別投票者集計表帳票出力ののソース（自動生成）です。
 *
 * @reamsid_L AF-0290-037 lit
 */
public class JikanbetsuTohyoshaReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "subTitle", length = 3, order = 1)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 16, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 22, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "jikantai1", length = 18, order = 6)
    public RString jikantai1;
    @ReportItem(name = "jikantai2", length = 18, order = 7)
    public RString jikantai2;
    @ReportItem(name = "jikantai3", length = 18, order = 8)
    public RString jikantai3;
    @ReportItem(name = "jikantai4", length = 18, order = 9)
    public RString jikantai4;
    @ReportItem(name = "jikantai5", length = 18, order = 10)
    public RString jikantai5;
    @ReportItem(name = "listMeisai_1", length = 4, order = 11)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 30, order = 12)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 7, order = 13)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 7, order = 14)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 7, order = 15)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 7, order = 16)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 7, order = 17)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 7, order = 18)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 7, order = 19)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 7, order = 20)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 7, order = 21)
    public RString listMeisai_11;
    @ReportItem(name = "listMeisai_12", length = 7, order = 22)
    public RString listMeisai_12;
    @ReportItem(name = "listMeisai_13", length = 7, order = 23)
    public RString listMeisai_13;
    @ReportItem(name = "listMeisai_14", length = 7, order = 24)
    public RString listMeisai_14;
    @ReportItem(name = "listMeisai_15", length = 7, order = 25)
    public RString listMeisai_15;
    @ReportItem(name = "listMeisai_16", length = 7, order = 26)
    public RString listMeisai_16;
    @ReportItem(name = "listMeisai_17", length = 7, order = 27)
    public RString listMeisai_17;

    @ReportItem(name = "senkyoNo", length = 10, order = 100)
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
         * subTitle
         */
        subTitle,
        /**
         * senkyoNo
         */
        senkyoNo;
    }
}
