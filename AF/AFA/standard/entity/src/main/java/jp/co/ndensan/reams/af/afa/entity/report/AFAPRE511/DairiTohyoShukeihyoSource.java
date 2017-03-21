package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のソース（自動生成）です。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "subTitle", length = 8, order = 1)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "pagecnt", length = 5, order = 4)
    public RString pagecnt;
    @ReportItem(name = "senkyoMei", length = 20, order = 5)
    public RString senkyoMei;
    @ReportItem(name = "titleTaishoKikan", length = 10, order = 6)
    public RString titleTaishoKikan;
    @ReportItem(name = "taishoKikanYmd", length = 36, order = 7)
    public RString taishoKikanYmd;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 8)
    public RString sakuseiYmdTime;
    @ReportItem(name = "tohyoShurui", length = 7, order = 9)
    public RString tohyoShurui;
    @ReportItem(name = "yojoTitleJo", length = 4, order = 10)
    public RString yojoTitleJo;
    @ReportItem(name = "yojoTitleGe", length = 4, order = 11)
    public RString yojoTitleGe;
    @ReportItem(name = "listMeisai_1", length = 41, order = 12)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 7, order = 13)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 7, order = 14)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 9, order = 15)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 7, order = 16)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 7, order = 17)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 7, order = 18)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 7, order = 19)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 7, order = 20)
    public RString listMeisai_9;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFields {

        /**
         * subTitle
         */
        subTitle,
        /**
         * shichosonCode
         */
        shichosonCode,
        /**
         * shichosonMei
         */
        shichosonMei,
        /**
         * pagecnt
         */
        pagecnt,
        /**
         * senkyoMei
         */
        senkyoMei,
        /**
         * titleTaishoKikan
         */
        titleTaishoKikan,
        /**
         * taishoKikanYmd
         */
        taishoKikanYmd,
        /**
         * sakuseiYmdTime
         */
        sakuseiYmdTime,
        /**
         * tohyoShurui
         */
        tohyoShurui,
        /**
         * yojoTitleJo
         */
        yojoTitleJo,
        /**
         * yojoTitleGe
         */
        yojoTitleGe,
        /**
         * listMeisai_1
         */
        listMeisai_1,
        /**
         * listMeisai_2
         */
        listMeisai_2,
        /**
         * listMeisai_3
         */
        listMeisai_3,
        /**
         * listMeisai_4
         */
        listMeisai_4,
        /**
         * listMeisai_5
         */
        listMeisai_5,
        /**
         * listMeisai_6
         */
        listMeisai_6,
        /**
         * listMeisai_7
         */
        listMeisai_7,
        /**
         * listMeisai_8
         */
        listMeisai_8,
        /**
         * listMeisai_9
         */
        listMeisai_9;
    }
}
