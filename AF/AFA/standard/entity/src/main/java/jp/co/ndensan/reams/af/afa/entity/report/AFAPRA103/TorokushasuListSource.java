package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 登録者数リストソース（自動生成）です。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public class TorokushasuListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "pagecnt", length = 5, order = 1)
    public RString pagecnt;
    @ReportItem(name = "title", length = 15, order = 2)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 22, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "shichosonMei", length = 13, order = 6)
    public RString shichosonMei;
    @ReportItem(name = "meisaiTitleJusho", length = 5, order = 7)
    public RString meisaiTitleJusho;
    @ReportItem(name = "listMeisai_1", length = 4, order = 8)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 20, order = 9)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 7, order = 10)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 7, order = 11)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 7, order = 12)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 7, order = 13)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 7, order = 14)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 7, order = 15)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 7, order = 16)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 7, order = 17)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 7, order = 18)
    public RString listMeisai_11;
    @ReportItem(name = "listMeisai_12", length = 7, order = 19)
    public RString listMeisai_12;
    @ReportItem(name = "listMeisai_13", length = 7, order = 20)
    public RString listMeisai_13;
    @ReportItem(name = "listMeisai_14", length = 7, order = 21)
    public RString listMeisai_14;
    @ReportItem(name = "sakuseiJoken1", length = 50, order = 22)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 50, order = 23)
    public RString sakuseiJoken2;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", length = 50, order = 24)
    public RString senkyoNo;
    @ReportItem(name = "sumType", length = 50, order = 25)
    public RString sumType;

    /**
     * ReportSourceFiledsのEnum
     */
    public static enum ReportSourceFields {

        title,
        senkyoNo,
        sumType;
    }

// </editor-fold>
}
