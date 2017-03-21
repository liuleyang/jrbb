package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoReportSource implements IReportSource {

    @ReportItem(name = "pagecnt", length = 5, order = 1)
    public RString pagecnt;
    @ReportItem(name = "subTitle", length = 8, order = 2)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 4)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 5)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 6)
    public RString sakuseiYmdTime;
    @ReportItem(name = "labelRightYmd", length = 15, order = 7)
    public RString labelRightYmd;
    @ReportItem(name = "labelLeftYmd", length = 12, order = 8)
    public RString labelLeftYmd;
    @ReportItem(name = "labelLeft2", length = 4, order = 9)
    public RString labelLeft2;
    @ReportItem(name = "labelLeft3", length = 4, order = 10)
    public RString labelLeft3;
    @ReportItem(name = "labelLeft5", length = 4, order = 11)
    public RString labelLeft5;
    @ReportItem(name = "labelLeft6", length = 4, order = 12)
    public RString labelLeft6;
    @ReportItem(name = "labelRight1", length = 4, order = 13)
    public RString labelRight1;
    @ReportItem(name = "labelRight2", length = 4, order = 14)
    public RString labelRight2;
    @ReportItem(name = "labelRight3", length = 4, order = 15)
    public RString labelRight3;
    @ReportItem(name = "labelRight4", length = 4, order = 16)
    public RString labelRight4;
    @ReportItem(name = "labelRight5", length = 4, order = 17)
    public RString labelRight5;
    @ReportItem(name = "labelRight6", length = 4, order = 18)
    public RString labelRight6;
    @ReportItem(name = "labelLeft1", length = 4, order = 19)
    public RString labelLeft1;
    @ReportItem(name = "labelLeft4", length = 4, order = 20)
    public RString labelLeft4;
    @ReportItem(name = "labelLeft7", length = 4, order = 21)
    public RString labelLeft7;
    @ReportItem(name = "labelRight7", length = 4, order = 22)
    public RString labelRight7;
    @ReportItem(name = "sakuseiJoken1", length = 50, order = 23)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 50, order = 24)
    public RString sakuseiJoken2;
    @ReportItem(name = "listMan_1", length = 5, order = 25)
    public RString listMan_1;
    @ReportItem(name = "listMan_2", length = 5, order = 26)
    public RString listMan_2;
    @ReportItem(name = "listMan_3", length = 5, order = 27)
    public RString listMan_3;
    @ReportItem(name = "listMan_4", length = 5, order = 28)
    public RString listMan_4;
    @ReportItem(name = "listMan_5", length = 5, order = 29)
    public RString listMan_5;
    @ReportItem(name = "listMan_6", length = 5, order = 30)
    public RString listMan_6;
    @ReportItem(name = "listMan_7", length = 5, order = 31)
    public RString listMan_7;
    @ReportItem(name = "listMan_8", length = 5, order = 32)
    public RString listMan_8;
    @ReportItem(name = "listMan_9", length = 5, order = 33)
    public RString listMan_9;
    @ReportItem(name = "listMan_10", length = 5, order = 34)
    public RString listMan_10;
    @ReportItem(name = "listMan_11", length = 7, order = 35)
    public RString listMan_11;
    @ReportItem(name = "listMan_12", length = 7, order = 36)
    public RString listMan_12;
    @ReportItem(name = "listMan_13", length = 7, order = 37)
    public RString listMan_13;
    @ReportItem(name = "listMan_14", length = 7, order = 38)
    public RString listMan_14;
    @ReportItem(name = "listMan_15", length = 7, order = 39)
    public RString listMan_15;
    @ReportItem(name = "listMan_16", length = 7, order = 40)
    public RString listMan_16;
    @ReportItem(name = "listMan_17", length = 7, order = 41)
    public RString listMan_17;
    @ReportItem(name = "listMan_18", length = 7, order = 42)
    public RString listMan_18;
    @ReportItem(name = "listMan_19", length = 7, order = 43)
    public RString listMan_19;
    @ReportItem(name = "listMan_20", length = 7, order = 44)
    public RString listMan_20;
    @ReportItem(name = "listTohyoku_1", length = 4, order = 45)
    public RString listTohyoku_1;
    @ReportItem(name = "listWoman_1", length = 5, order = 46)
    public RString listWoman_1;
    @ReportItem(name = "listWoman_2", length = 5, order = 47)
    public RString listWoman_2;
    @ReportItem(name = "listWoman_3", length = 5, order = 48)
    public RString listWoman_3;
    @ReportItem(name = "listWoman_4", length = 5, order = 49)
    public RString listWoman_4;
    @ReportItem(name = "listWoman_5", length = 5, order = 50)
    public RString listWoman_5;
    @ReportItem(name = "listWoman_6", length = 5, order = 51)
    public RString listWoman_6;
    @ReportItem(name = "listWoman_7", length = 5, order = 52)
    public RString listWoman_7;
    @ReportItem(name = "listWoman_8", length = 5, order = 53)
    public RString listWoman_8;
    @ReportItem(name = "listWoman_9", length = 5, order = 54)
    public RString listWoman_9;
    @ReportItem(name = "listWoman_10", length = 5, order = 55)
    public RString listWoman_10;
    @ReportItem(name = "listWoman_11", length = 7, order = 56)
    public RString listWoman_11;
    @ReportItem(name = "listWoman_12", length = 7, order = 57)
    public RString listWoman_12;
    @ReportItem(name = "listWoman_13", length = 7, order = 58)
    public RString listWoman_13;
    @ReportItem(name = "listWoman_14", length = 7, order = 59)
    public RString listWoman_14;
    @ReportItem(name = "listWoman_15", length = 7, order = 60)
    public RString listWoman_15;
    @ReportItem(name = "listWoman_16", length = 7, order = 61)
    public RString listWoman_16;
    @ReportItem(name = "listWoman_17", length = 7, order = 62)
    public RString listWoman_17;
    @ReportItem(name = "listWoman_18", length = 7, order = 63)
    public RString listWoman_18;
    @ReportItem(name = "listWoman_19", length = 7, order = 64)
    public RString listWoman_19;
    @ReportItem(name = "listWoman_20", length = 7, order = 65)
    public RString listWoman_20;
    @ReportItem(name = "listKei_1", length = 5, order = 66)
    public RString listKei_1;
    @ReportItem(name = "listKei_2", length = 5, order = 67)
    public RString listKei_2;
    @ReportItem(name = "listKei_3", length = 5, order = 68)
    public RString listKei_3;
    @ReportItem(name = "listKei_4", length = 5, order = 69)
    public RString listKei_4;
    @ReportItem(name = "listKei_5", length = 5, order = 70)
    public RString listKei_5;
    @ReportItem(name = "listKei_6", length = 5, order = 71)
    public RString listKei_6;
    @ReportItem(name = "listKei_7", length = 5, order = 72)
    public RString listKei_7;
    @ReportItem(name = "listKei_8", length = 5, order = 73)
    public RString listKei_8;
    @ReportItem(name = "listKei_9", length = 5, order = 74)
    public RString listKei_9;
    @ReportItem(name = "listKei_10", length = 5, order = 75)
    public RString listKei_10;
    @ReportItem(name = "listKei_11", length = 7, order = 76)
    public RString listKei_11;
    @ReportItem(name = "listKei_12", length = 7, order = 77)
    public RString listKei_12;
    @ReportItem(name = "listKei_13", length = 7, order = 78)
    public RString listKei_13;
    @ReportItem(name = "listKei_14", length = 7, order = 79)
    public RString listKei_14;
    @ReportItem(name = "listKei_15", length = 7, order = 80)
    public RString listKei_15;
    @ReportItem(name = "listKei_16", length = 7, order = 81)
    public RString listKei_16;
    @ReportItem(name = "listKei_17", length = 7, order = 82)
    public RString listKei_17;
    @ReportItem(name = "listKei_18", length = 7, order = 83)
    public RString listKei_18;
    @ReportItem(name = "listKei_19", length = 7, order = 84)
    public RString listKei_19;
    @ReportItem(name = "listKei_20", length = 7, order = 85)
    public RString listKei_20;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", length = 2, order = 86)
    public RString senkyoNo;

    /**
     * 集計整理表エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        pagecnt,
        subTitle,
        shichosonCode,
        shichosonMei,
        senkyoMei,
        sakuseiYmdTime,
        labelRightYmd,
        labelLeftYmd,
        labelLeft2,
        labelLeft3,
        labelLeft5,
        labelLeft6,
        labelRight1,
        labelRight2,
        labelRight3,
        labelRight4,
        labelRight5,
        labelRight6,
        labelLeft1,
        labelLeft4,
        labelLeft7,
        labelRight7,
        sakuseiJoken1,
        sakuseiJoken2,
        listMan_1,
        listMan_2,
        listMan_3,
        listMan_4,
        listMan_5,
        listMan_6,
        listMan_7,
        listMan_8,
        listMan_9,
        listMan_10,
        listMan_11,
        listMan_12,
        listMan_13,
        listMan_14,
        listMan_15,
        listMan_16,
        listMan_17,
        listMan_18,
        listMan_19,
        listMan_20,
        listTohyoku_1,
        listWoman_1,
        listWoman_2,
        listWoman_3,
        listWoman_4,
        listWoman_5,
        listWoman_6,
        listWoman_7,
        listWoman_8,
        listWoman_9,
        listWoman_10,
        listWoman_11,
        listWoman_12,
        listWoman_13,
        listWoman_14,
        listWoman_15,
        listWoman_16,
        listWoman_17,
        listWoman_18,
        listWoman_19,
        listWoman_20,
        listKei_1,
        listKei_2,
        listKei_3,
        listKei_4,
        listKei_5,
        listKei_6,
        listKei_7,
        listKei_8,
        listKei_9,
        listKei_10,
        listKei_11,
        listKei_12,
        listKei_13,
        listKei_14,
        listKei_15,
        listKei_16,
        listKei_17,
        listKei_18,
        listKei_19,
        listKei_20,
        senkyoNo;
    }
// </editor-fold>
}
