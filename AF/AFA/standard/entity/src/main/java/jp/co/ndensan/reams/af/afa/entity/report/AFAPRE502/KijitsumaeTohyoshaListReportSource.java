package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListReportSource implements IReportSource {

    @ReportItem(name = "sakuseiJoken1", length = 50, order = 1)
    public RString sakuseiJoken1;
    @ReportItem(name = "gokeiArea1", length = 40, order = 2)
    public RString gokeiArea1;
    @ReportItem(name = "sakuseiJoken2", length = 50, order = 3)
    public RString sakuseiJoken2;
    @ReportItem(name = "gokeiArea2", length = 40, order = 4)
    public RString gokeiArea2;
    @ReportItem(name = "sakuseiJoken3", length = 50, order = 5)
    public RString sakuseiJoken3;
    @ReportItem(name = "pagecnt", length = 5, order = 6)
    public RString pagecnt;
    @ReportItem(name = "title", length = 9, order = 7)
    public RString title;
    @ReportItem(name = "subTitle", length = 16, order = 8)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 9)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 10)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 11)
    public RString senkyoMei;
    @ReportItem(name = "tohyokuCode", length = 4, order = 12)
    public RString tohyokuCode;
    @ReportItem(name = "tohyokuMei", length = 20, order = 13)
    public RString tohyokuMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 14)
    public RString sakuseiYmdTime;
    @ReportItem(name = "page", length = 5, order = 15)
    public RString page;
    @ReportItem(name = "meisaiTitleLevelKubun", order = 16)
    public RString meisaiTitleLevelKubun;
    @ReportItem(name = "meisaiTitleDate1", length = 4, order = 17)
    public RString meisaiTitleDate1;
    @ReportItem(name = "meisaiTitleDate2", length = 4, order = 18)
    public RString meisaiTitleDate2;
    @ReportItem(name = "listMeisai_1", length = 8, order = 19)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 14, order = 20)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 15, order = 21)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 1, order = 22)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 3, order = 23)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 1, order = 24)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 13, order = 25)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 2, order = 26)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 11, order = 27)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 15, order = 28)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 6, order = 29)
    public RString listMeisai_11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "shisetsuShubetsuMeisho", order = 30)
    public RString shisetsuShubetsuMeisho;
    @ReportItem(name = "shisetsuShubetsuRyakusho", order = 31)
    public RString shisetsuShubetsuRyakusho;
    @ReportItem(name = "key1", order = 32)
    public RString key1;
    @ReportItem(name = "key2", order = 33)
    public RString key2;
    @ReportItem(name = "key3", order = 34)
    public RString key3;

    /**
     * 期日前投票者一覧表エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        sakuseiJoken1,
        gokeiArea1,
        sakuseiJoken2,
        gokeiArea2,
        sakuseiJoken3,
        pagecnt,
        title,
        subTitle,
        shichosonCode,
        shichosonMei,
        senkyoMei,
        tohyokuCode,
        tohyokuMei,
        sakuseiYmdTime,
        page,
        meisaiTitleLevelKubun,
        meisaiTitleDate1,
        meisaiTitleDate2,
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
        shisetsuShubetsuMeisho,
        shisetsuShubetsuRyakusho,
        key1,
        key2,
        key3;
    }
// </editor-fold>
}
