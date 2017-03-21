package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309;

import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportHojinNo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportKojinNo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 12, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 5)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 14, order = 6)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 15, order = 7)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 32, order = 8)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai2_5", length = 32, order = 9)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai1_1", length = 10, order = 10)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai3_1", length = 14, order = 11)
    public RString listMeisai3_1;
    @ReportItem(name = "listMeisai1_2", length = 30, order = 12)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai3_2", length = 15, order = 13)
    public RString listMeisai3_2;
    @ReportItem(name = "listMeisai1_3", length = 39, order = 14)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai3_3", length = 10, order = 15)
    public RString listMeisai3_3;
    @ReportItem(name = "listMeisai1_4", length = 1, order = 16)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai3_4", length = 10, order = 17)
    public RString listMeisai3_4;
    @ReportItem(name = "listMeisai1_5", length = 10, order = 18)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai3_5", length = 10, order = 19)
    public RString listMeisai3_5;
    @ReportItem(name = "listMeisai1_6", length = 10, order = 20)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai3_6", length = 10, order = 21)
    public RString listMeisai3_6;
    @ReportItem(name = "listMeisai1_7", length = 10, order = 22)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai3_7", length = 10, order = 23)
    public RString listMeisai3_7;
    @ReportItem(name = "listMeisai1_8", length = 10, order = 24)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai3_8", length = 32, order = 25)
    public RString listMeisai3_8;
    @ReportItem(name = "listMeisai1_9", length = 10, order = 26)
    public RString listMeisai1_9;
    @ReportItem(name = "sakuseiJoken", length = 80, order = 27)
    public RString sakuseiJoken;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * 在外投票資格者名簿
     */
    public enum ReportSourceFields {

        title,
        shichosonCode,
        shichosonMei,
        sakuseiYmdTime,
        listMeisai2_1,
        listMeisai2_2,
        listMeisai2_3,
        listMeisai2_4,
        listMeisai2_5,
        listMeisai1_1,
        listMeisai3_1,
        listMeisai1_2,
        listMeisai3_2,
        listMeisai1_3,
        listMeisai3_3,
        listMeisai1_4,
        listMeisai3_4,
        listMeisai1_5,
        listMeisai3_5,
        listMeisai1_6,
        listMeisai3_6,
        listMeisai1_7,
        listMeisai3_7,
        listMeisai1_8,
        listMeisai3_8,
        listMeisai1_9,
        sakuseiJoken;
    }
// </editor-fold>
}
