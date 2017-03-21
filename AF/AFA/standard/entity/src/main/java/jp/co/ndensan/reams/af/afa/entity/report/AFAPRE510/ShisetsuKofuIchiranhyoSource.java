package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のソース（自動生成）です。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonMei", length = 20, order = 1)
    public RString shichosonMei;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString senkyoCode;
    @ReportItem(name = "senkyoMei", length = 20, order = 3)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "pagecnt", length = 5, order = 5)
    public RString pagecnt;
    @ReportItem(name = "listMeisai1_1", length = 4, order = 6)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 7)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai1_2", length = 15, order = 8)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai2_2", length = 15, order = 9)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai1_3", length = 5, order = 10)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai2_3", length = 5, order = 11)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai1_4", length = 10, order = 12)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai2_4", length = 10, order = 13)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai1_5", length = 10, order = 14)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai2_5", length = 10, order = 15)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai1_6", length = 5, order = 16)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai2_6", length = 5, order = 17)
    public RString listMeisai2_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportItem(name = "shichosonCode", length = 15, order = 18)
    public RString shichosonCode;

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFields {

        /**
         * shichosonMei
         */
        shichosonMei,
        /**
         * shichosonCode
         */
        shichosonCode,
        /**
         * senkyoCode
         */
        senkyoCode,
        /**
         * senkyoMei
         */
        senkyoMei,
        /**
         * sakuseiYmdTime
         */
        sakuseiYmdTime,
        /**
         * pagecnt
         */
        pagecnt,
        /**
         * listMeisai1_1
         */
        listMeisai1_1,
        /**
         * listMeisai2_1
         */
        listMeisai2_1,
        /**
         * listMeisai1_2
         */
        listMeisai1_2,
        /**
         * listMeisai2_2
         */
        listMeisai2_2,
        /**
         * listMeisai1_3
         */
        listMeisai1_3,
        /**
         * listMeisai2_3
         */
        listMeisai2_3,
        /**
         * listMeisai1_4
         */
        listMeisai1_4,
        /**
         * listMeisai2_4
         */
        listMeisai2_4,
        /**
         * listMeisai1_5
         */
        listMeisai1_5,
        /**
         * listMeisai2_5
         */
        listMeisai2_5,
        /**
         * listMeisai1_6
         */
        listMeisai1_6,
        /**
         * listMeisai2_6
         */
        listMeisai2_6;
    }

// </editor-fold>
}
