package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のソース（自動生成）です。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "headerShisetsuTitle", length = 5, order = 5)
    public RString headerShisetsuTitle;
    @ReportItem(name = "headerShisetsu", length = 15, order = 6)
    public RString headerShisetsu;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 7)
    public RString sakuseiYmdTime;
    @ReportItem(name = "lblTitle6", length = 10, order = 8)
    public RString lblTitle6;
    @ReportItem(name = "lblTitle8", length = 9, order = 9)
    public RString lblTitle8;
    @ReportItem(name = "jikantai1", length = 11, order = 10)
    public RString jikantai1;
    @ReportItem(name = "jikantai2", length = 11, order = 11)
    public RString jikantai2;
    @ReportItem(name = "jikantai3", length = 11, order = 12)
    public RString jikantai3;
    @ReportItem(name = "jikantai4", length = 11, order = 13)
    public RString jikantai4;
    @ReportItem(name = "lblTitle7", length = 12, order = 14)
    public RString lblTitle7;
    @ReportItem(name = "lblTitle9", length = 10, order = 15)
    public RString lblTitle9;
    @ReportItem(name = "lblTitle1", length = 5, order = 16)
    public RString lblTitle1;
    @ReportItem(name = "lblTitle2", length = 5, order = 17)
    public RString lblTitle2;
    @ReportItem(name = "lblTitle3", length = 5, order = 18)
    public RString lblTitle3;
    @ReportItem(name = "lblTitle4", length = 5, order = 19)
    public RString lblTitle4;
    @ReportItem(name = "lblTitle5", length = 5, order = 20)
    public RString lblTitle5;
    @ReportItem(name = "listMeisai_1", length = 6, order = 21)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 7, order = 22)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 7, order = 23)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 7, order = 24)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 7, order = 25)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 7, order = 26)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 7, order = 27)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 7, order = 28)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 7, order = 29)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 7, order = 30)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 7, order = 31)
    public RString listMeisai_11;
    @ReportItem(name = "listMeisai_12", length = 7, order = 32)
    public RString listMeisai_12;
    @ReportItem(name = "listMeisai_13", length = 7, order = 33)
    public RString listMeisai_13;
    @ReportItem(name = "listGokei_1", length = 7, order = 34)
    public RString listGokei_1;
    @ReportItem(name = "listGokei_2", length = 7, order = 35)
    public RString listGokei_2;
    @ReportItem(name = "listGokei_3", length = 7, order = 36)
    public RString listGokei_3;
    @ReportItem(name = "listGokei_4", length = 7, order = 37)
    public RString listGokei_4;
    @ReportItem(name = "listGokei_5", length = 7, order = 38)
    public RString listGokei_5;
    @ReportItem(name = "listGokei_6", length = 7, order = 39)
    public RString listGokei_6;
    @ReportItem(name = "listGokei_7", length = 7, order = 40)
    public RString listGokei_7;
    @ReportItem(name = "listGokei_8", length = 7, order = 41)
    public RString listGokei_8;
    @ReportItem(name = "listGokei_9", length = 7, order = 42)
    public RString listGokei_9;
    @ReportItem(name = "listGokei_10", length = 7, order = 43)
    public RString listGokei_10;
    @ReportItem(name = "listGokei_11", length = 7, order = 44)
    public RString listGokei_11;
    @ReportItem(name = "listGokei_12", length = 7, order = 45)
    public RString listGokei_12;
    @ReportItem(name = "listTohyoRitsu_1", length = 7, order = 46)
    public RString listTohyoRitsu_1;
    @ReportItem(name = "listTohyoRitsu_2", length = 7, order = 47)
    public RString listTohyoRitsu_2;
    @ReportItem(name = "listTohyoRitsu_3", length = 7, order = 48)
    public RString listTohyoRitsu_3;
    @ReportItem(name = "listTohyoRitsu_4", length = 7, order = 49)
    public RString listTohyoRitsu_4;
    @ReportItem(name = "listTohyoNinzu_1", length = 7, order = 50)
    public RString listTohyoNinzu_1;
    @ReportItem(name = "listTohyoNinzu_2", length = 7, order = 51)
    public RString listTohyoNinzu_2;
    @ReportItem(name = "listTohyoNinzu_3", length = 7, order = 52)
    public RString listTohyoNinzu_3;
    @ReportItem(name = "listTohyoNinzu_4", length = 7, order = 53)
    public RString listTohyoNinzu_4;
    @ReportItem(name = "listTohyoNinzu_5", length = 7, order = 54)
    public RString listTohyoNinzu_5;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", order = 55)
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
         * senkyoMei
         */
        senkyoMei,
        /**
         * headerShisetsuTitle
         */
        headerShisetsuTitle,
        /**
         * headerShisetsu
         */
        headerShisetsu,
        /**
         * sakuseiYmdTime
         */
        sakuseiYmdTime,
        /**
         * lblTitle6
         */
        lblTitle6,
        /**
         * lblTitle8
         */
        lblTitle8,
        /**
         * jikantai1
         */
        jikantai1,
        /**
         * jikantai2
         */
        jikantai2,
        /**
         * jikantai3
         */
        jikantai3,
        /**
         * jikantai4
         */
        jikantai4,
        /**
         * lblTitle7
         */
        lblTitle7,
        /**
         * lblTitle9
         */
        lblTitle9,
        /**
         * lblTitle1
         */
        lblTitle1,
        /**
         * lblTitle2
         */
        lblTitle2,
        /**
         * lblTitle3
         */
        lblTitle3,
        /**
         * lblTitle4
         */
        lblTitle4,
        /**
         * lblTitle5
         */
        lblTitle5,
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
        listMeisai_9,
        /**
         * listMeisai_10
         */
        listMeisai_10,
        /**
         * listMeisai_11
         */
        listMeisai_11,
        /**
         * listMeisai_12
         */
        listMeisai_12,
        /**
         * listMeisai_13
         */
        listMeisai_13,
        /**
         * listGokei_1
         */
        listGokei_1,
        /**
         * listGokei_2
         */
        listGokei_2,
        /**
         * listGokei_3
         */
        listGokei_3,
        /**
         * listGokei_4
         */
        listGokei_4,
        /**
         * listGokei_5
         */
        listGokei_5,
        /**
         * listGokei_6
         */
        listGokei_6,
        /**
         * listGokei_7
         */
        listGokei_7,
        /**
         * listGokei_8
         */
        listGokei_8,
        /**
         * listGokei_9
         */
        listGokei_9,
        /**
         * listGokei_10
         */
        listGokei_10,
        /**
         * listGokei_11
         */
        listGokei_11,
        /**
         * listGokei_12
         */
        listGokei_12,
        /**
         * listTohyoRitsu_1
         */
        listTohyoRitsu_1,
        /**
         * listTohyoRitsu_2
         */
        listTohyoRitsu_2,
        /**
         * listTohyoRitsu_3
         */
        listTohyoRitsu_3,
        /**
         * listTohyoRitsu_4
         */
        listTohyoRitsu_4,
        /**
         * listTohyoNinzu_1
         */
        listTohyoNinzu_1,
        /**
         * listTohyoNinzu_2
         */
        listTohyoNinzu_2,
        /**
         * listTohyoNinzu_3
         */
        listTohyoNinzu_3,
        /**
         * listTohyoNinzu_4
         */
        listTohyoNinzu_4,
        /**
         * listTohyoNinzu_5
         */
        listTohyoNinzu_5,
        /**
         * senkyoNo
         */
        senkyoNo;
    }
// </editor-fold>
}
