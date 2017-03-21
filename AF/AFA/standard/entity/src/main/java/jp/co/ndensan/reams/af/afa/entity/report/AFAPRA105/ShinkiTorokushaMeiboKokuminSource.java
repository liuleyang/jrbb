package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105;

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
 * 補正登録者名簿ソース（自動生成）です。
 *
 * @reamsid_L AF-0360-051 guancy
 */
public class ShinkiTorokushaMeiboKokuminSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 10, order = 1)
    public RString title;
    @ReportItem(name = "subTitle", length = 10, order = 2)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 4)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "meisaiTitleDate1", length = 5, order = 6)
    public RString meisaiTitleDate1;
    @ReportItem(name = "meisaiTitleDate2", length = 5, order = 7)
    public RString meisaiTitleDate2;
    @ReportItem(name = "meisaiTitleDate3", length = 5, order = 8)
    public RString meisaiTitleDate3;
    @ReportItem(name = "chikuCodeMei", length = 6, order = 9)
    public RString chikuCodeMei;
    @ReportItem(name = "jushoMei", length = 10, order = 10)
    public RString jushoMei;
    @ReportItem(name = "chikuMei", length = 5, order = 11)
    public RString chikuMei;
    @ReportItem(name = "meisaiTitleDate4", length = 5, order = 12)
    public RString meisaiTitleDate4;
    @ReportItem(name = "listMeisai1_1", length = 4, order = 13)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 11, order = 14)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 15, order = 15)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 39, order = 16)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai1_5", length = 12, order = 17)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai1_6", length = 1, order = 18)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai1_7", length = 10, order = 19)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai1_8", length = 10, order = 20)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai1_9", length = 10, order = 21)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai1_10", length = 10, order = 22)
    public RString listMeisai1_10;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 23)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 9, order = 24)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 15, order = 25)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 39, order = 26)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai2_5", length = 14, order = 27)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai2_6", length = 10, order = 28)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai2_7", length = 10, order = 29)
    public RString listMeisai2_7;
    @ReportItem(name = "listMeisai2_8", length = 10, order = 30)
    public RString listMeisai2_8;
    @ReportItem(name = "selHani", length = 80, order = 31)
    public RString selHani;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;

    /**
     * ReportSourceFields enum 型です。
     */
    public enum ReportSourceFields {

        subTitle;
    }
   // </editor-fold>
}
