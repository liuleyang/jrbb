package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214;

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
 * 入場券テストデータ抽出一覧表のReportSourceです。
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListSource implements IReportSource {
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
    @ReportItem(name = "meiboBangoMei", length = 6, order = 6)
    public RString meiboBangoMei;
    @ReportItem(name = "listMeisai1_1", length = 10, order = 7)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 17, order = 8)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 20, order = 9)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 50, order = 10)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai2_1", length = 10, order = 11)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 17, order = 12)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 20, order = 13)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 50, order = 14)
    public RString listMeisai2_4;
    @ReportItem(name = "selHani", length = 80, order = 15)
    public RString selHani;
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
    @ReportItem(name = "pageCount", order = 16)
    public Integer pageCount;
// </editor-fold>
}
