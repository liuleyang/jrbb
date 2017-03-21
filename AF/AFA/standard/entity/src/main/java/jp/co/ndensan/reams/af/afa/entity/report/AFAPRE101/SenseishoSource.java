package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE101;

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
 * 宣誓書ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0070-020 liss
 */
public class SenseishoSource implements IReportSource {

    @ReportItem(name = "title", length = 13, order = 1)
    public RString title;
    @ReportItem(name = "yubinNo", length = 8, order = 2)
    public RString yubinNo;
    @ReportItem(name = "jusho", length = 36, order = 3)
    public RString jusho;
    @ReportItem(name = "kanaShimei", length = 60, order = 4)
    public RString kanaShimei;
    @ReportItem(name = "shimei", length = 30, order = 5)
    public RString shimei;
    @ReportItem(name = "seinengappi", length = 11, order = 6)
    public RString seinengappi;
    @ReportItem(name = "tohyoYmd", length = 11, order = 7)
    public RString tohyoYmd;
    @ReportItem(name = "senkyoName1", length = 20, order = 8)
    public RString senkyoName1;
    @ReportItem(name = "senkyoName2", length = 20, order = 9)
    public RString senkyoName2;
    @ReportItem(name = "senkyoName3", length = 20, order = 10)
    public RString senkyoName3;
    @ReportItem(name = "senkyoName4", length = 20, order = 11)
    public RString senkyoName4;
    @ReportItem(name = "senkyoName5", length = 20, order = 12)
    public RString senkyoName5;
    @ReportItem(name = "senkyoName6", length = 20, order = 13)
    public RString senkyoName6;
    @ReportItem(name = "senkyoName7", length = 20, order = 14)
    public RString senkyoName7;
    @ReportItem(name = "senkyoName8", length = 20, order = 15)
    public RString senkyoName8;
    @ReportItem(name = "senkyoName9", length = 20, order = 16)
    public RString senkyoName9;
    @ReportItem(name = "senseiYmd", length = 20, order = 17)
    public RString senseiYmd;
    @ReportItem(name = "senkyoKanri", length = 50, order = 18)
    public RString senkyoKanri;
    @ReportItem(name = "senkyoShurui", length = 5, order = 19)
    public RString senkyoShurui;
    @ReportItem(name = "jiyu1", length = 2, order = 20)
    public RString jiyu1;
    @ReportItem(name = "jiyu2", length = 2, order = 21)
    public RString jiyu2;
    @ReportItem(name = "jiyu3", length = 2, order = 22)
    public RString jiyu3;
    @ReportItem(name = "jiyu4", length = 2, order = 23)
    public RString jiyu4;
    @ReportItem(name = "jiyu5", length = 2, order = 24)
    public RString jiyu5;
    @ReportItem(name = "tohyokuCode", length = 4, order = 25)
    public RString tohyokuCode;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 26)
    public RString shikibetsuCode;
    @ReportItem(name = "meiboPage", length = 6, order = 27)
    public RString meiboPage;
    @ReportItem(name = "meiboGyo", length = 2, order = 28)
    public RString meiboGyo;
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>
}
