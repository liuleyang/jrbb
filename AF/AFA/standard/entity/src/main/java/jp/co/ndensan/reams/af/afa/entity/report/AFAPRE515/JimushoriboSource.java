package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿のソース（自動生成）です。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 5, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "iinkaiMei", length = 20, order = 4)
    public RString iinkaiMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 5)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 6)
    public RString sakuseiYmdTime;
    @ReportItem(name = "meisaiTitle3", length = 7, order = 7)
    public RString meisaiTitle3;
    @ReportItem(name = "meisaiTitle1", length = 22, order = 8)
    public RString meisaiTitle1;
    @ReportItem(name = "meisaiTitle2", length = 22, order = 9)
    public RString meisaiTitle2;
    @ReportItem(name = "meisaiTitle4", length = 3, order = 10)
    public RString meisaiTitle4;
    @ReportItem(name = "meisaiTitle5", length = 3, order = 11)
    public RString meisaiTitle5;
    @ReportItem(name = "meisaiTitle6", length = 3, order = 12)
    public RString meisaiTitle6;
    @ReportItem(name = "meisaiTitle11", length = 3, order = 13)
    public RString meisaiTitle11;
    @ReportItem(name = "meisaiTitle7", length = 3, order = 14)
    public RString meisaiTitle7;
    @ReportItem(name = "meisaiTitle8", length = 3, order = 15)
    public RString meisaiTitle8;
    @ReportItem(name = "meisaiTitle9", length = 3, order = 16)
    public RString meisaiTitle9;
    @ReportItem(name = "meisaiTitle10", length = 3, order = 17)
    public RString meisaiTitle10;
    @ReportItem(name = "listMeisai1_1", length = 10, order = 18)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 10, order = 19)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 5, order = 20)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 4, order = 21)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai1_5", length = 5, order = 22)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai1_6", length = 5, order = 23)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai1_7", length = 5, order = 24)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai1_8", length = 8, order = 25)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai1_9", length = 8, order = 26)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai2_1", length = 8, order = 27)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 4, order = 28)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 1, order = 29)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 1, order = 30)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai2_5", length = 1, order = 31)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai2_6", length = 1, order = 32)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai3_1", length = 14, order = 33)
    public RString listMeisai3_1;
    @ReportItem(name = "listMeisai3_2", length = 6, order = 34)
    public RString listMeisai3_2;
    @ReportItem(name = "listMeisai3_3", length = 2, order = 35)
    public RString listMeisai3_3;
    @ReportItem(name = "listMeisai3_4", length = 2, order = 36)
    public RString listMeisai3_4;
    @ReportItem(name = "listMeisai3_5", length = 8, order = 37)
    public RString listMeisai3_5;
    @ReportItem(name = "seibetsuKeiMan", length = 6, order = 38)
    public RString seibetsuKeiMan;
    @ReportItem(name = "seibetsuKeiWoman", length = 6, order = 39)
    public RString seibetsuKeiWoman;
    @ReportItem(name = "kei", length = 6, order = 40)
    public RString kei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", length = 6, order = 41)
    public RString senkyoNo;

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFields {

        /**
         * title
         */
        title,
        /**
         * shichosonCode
         */
        shichosonCode,
        /**
         * shichosonMei
         */
        shichosonMei,
        /**
         * iinkaiMei
         */
        iinkaiMei,
        /**
         * senkyoMei
         */
        senkyoMei,
        /**
         * sakuseiYmdTime
         */
        sakuseiYmdTime,
        /**
         * meisaiTitle3
         */
        meisaiTitle3,
        /**
         * meisaiTitle1
         */
        meisaiTitle1,
        /**
         * meisaiTitle2
         */
        meisaiTitle2,
        /**
         * meisaiTitle4
         */
        meisaiTitle4,
        /**
         * meisaiTitle5
         */
        meisaiTitle5,
        /**
         * meisaiTitle6
         */
        meisaiTitle6,
        /**
         * meisaiTitle11
         */
        meisaiTitle11,
        /**
         * meisaiTitle7
         */
        meisaiTitle7,
        /**
         * meisaiTitle8
         */
        meisaiTitle8,
        /**
         * meisaiTitle9
         */
        meisaiTitle9,
        /**
         * meisaiTitle10
         */
        meisaiTitle10,
        /**
         * listMeisai1_1
         */
        listMeisai1_1,
        /**
         * listMeisai1_2
         */
        listMeisai1_2,
        /**
         * listMeisai1_3
         */
        listMeisai1_3,
        /**
         * listMeisai1_4
         */
        listMeisai1_4,
        /**
         * listMeisai1_5
         */
        listMeisai1_5,
        /**
         * listMeisai1_6
         */
        listMeisai1_6,
        /**
         * listMeisai1_7
         */
        listMeisai1_7,
        /**
         * listMeisai1_8
         */
        listMeisai1_8,
        /**
         * listMeisai1_9
         */
        listMeisai1_9,
        /**
         * listMeisai2_1
         */
        listMeisai2_1,
        /**
         * listMeisai2_2
         */
        listMeisai2_2,
        /**
         * listMeisai2_3
         */
        listMeisai2_3,
        /**
         * listMeisai2_4
         */
        listMeisai2_4,
        /**
         * listMeisai2_5
         */
        listMeisai2_5,
        /**
         * listMeisai2_6
         */
        listMeisai2_6,
        /**
         * listMeisai3_1
         */
        listMeisai3_1,
        /**
         * listMeisai3_2
         */
        listMeisai3_2,
        /**
         * listMeisai3_3
         */
        listMeisai3_3,
        /**
         * listMeisai3_4
         */
        listMeisai3_4,
        /**
         * listMeisai3_5
         */
        listMeisai3_5,
        /**
         * seibetsuKeiMan
         */
        seibetsuKeiMan,
        /**
         * seibetsuKeiWoman
         */
        seibetsuKeiWoman,
        /**
         * kei
         */
        kei,
        /**
         * senkyoNo
         */
        senkyoNo;
    }

// </editor-fold>
}
