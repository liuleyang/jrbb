package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215;

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
 * 宛名シール出力対象者一覧ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "sakuseiJoken", length = 50, order = 6)
    public RString sakuseiJoken;
    @ReportItem(name = "meisaiTitle1", length = 4, order = 7)
    public RString meisaiTitle1;
    @ReportItem(name = "meisaiTitle2", length = 4, order = 8)
    public RString meisaiTitle2;
    @ReportItem(name = "meisaiTitle3", length = 5, order = 9)
    public RString meisaiTitle3;
    @ReportItem(name = "meisaiTitle4", length = 2, order = 10)
    public RString meisaiTitle4;
    @ReportItem(name = "meisaiTitle5", length = 6, order = 11)
    public RString meisaiTitle5;
    @ReportItem(name = "meisaiTitle6", length = 8, order = 12)
    public RString meisaiTitle6;
    @ReportItem(name = "listMeisho1_1", length = 18, order = 13)
    public RString listMeisho1_1;
    @ReportItem(name = "listMeisho1_2", length = 18, order = 14)
    public RString listMeisho1_2;
    @ReportItem(name = "listJusho1_1", length = 10, order = 15)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1_2", length = 28, order = 16)
    public RString listJusho1_2;
    @ReportItem(name = "listMeisai_1", length = 10, order = 17)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 2, order = 18)
    public RString listMeisai_2;
    @ReportItem(name = "listBiko_1", length = 15, order = 19)
    public RString listBiko_1;
    @ReportItem(name = "listBiko_2", length = 14, order = 20)
    public RString listBiko_2;
    @ReportItem(name = "listMeisho2_1", length = 18, order = 21)
    public RString listMeisho2_1;
    @ReportItem(name = "listMeisho2_2", length = 18, order = 22)
    public RString listMeisho2_2;
    @ReportItem(name = "listJusho2_1", length = 34, order = 23)
    public RString listJusho2_1;
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
    @ReportItem(name = "jusho", length = 15, order = 24)
    public RString jusho;
    @ReportItem(name = "gyoseikumei", length = 15, order = 25)
    public RString gyoseikumei;
    @ReportItem(name = "chiku1", length = 15, order = 26)
    public RString chiku1;
    @ReportItem(name = "chiku2", length = 15, order = 27)
    public RString chiku2;
    @ReportItem(name = "chiku3", length = 15, order = 28)
    public RString chiku3;
// </editor-fold>
}
