package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201;

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
 * 不在者投票証明書（12号様式）ソース（自動生成）です。
 *
 * @reamsid_L AF-0090-020 lit
 */
public class FuzaishaTohyoShomeishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kanaShimei", length = 40, order = 1)
    public RString kanaShimei;
    @ReportItem(name = "shimei", length = 30, order = 2)
    public RString shimei;
    @ReportItem(name = "seinengappi", length = 24, order = 3)
    public RString seinengappi;
    @ReportItem(name = "sSenkyoNameA", length = 20, order = 4)
    public RString sSenkyoNameA;
    @ReportItem(name = "senkyoNameA", length = 20, order = 5)
    public RString senkyoNameA;
    @ReportItem(name = "sSenkyoNameF", length = 20, order = 6)
    public RString sSenkyoNameF;
    @ReportItem(name = "sSenkyoNameB", length = 20, order = 7)
    public RString sSenkyoNameB;
    @ReportItem(name = "senkyoNameB", length = 20, order = 8)
    public RString senkyoNameB;
    @ReportItem(name = "sSenkyoNameG", length = 20, order = 9)
    public RString sSenkyoNameG;
    @ReportItem(name = "shikkoYmd", length = 20, order = 10)
    public RString shikkoYmd;
    @ReportItem(name = "sSenkyoNameC", length = 20, order = 11)
    public RString sSenkyoNameC;
    @ReportItem(name = "senkyoNameC", length = 20, order = 12)
    public RString senkyoNameC;
    @ReportItem(name = "sSenkyoNameH", length = 20, order = 13)
    public RString sSenkyoNameH;
    @ReportItem(name = "sSenkyoNameD", length = 20, order = 14)
    public RString sSenkyoNameD;
    @ReportItem(name = "senkyoNameD", length = 20, order = 15)
    public RString senkyoNameD;
    @ReportItem(name = "sSenkyoNameI", length = 20, order = 16)
    public RString sSenkyoNameI;
    @ReportItem(name = "sSenkyoNameE", length = 20, order = 17)
    public RString sSenkyoNameE;
    @ReportItem(name = "senkyoNameE", length = 20, order = 18)
    public RString senkyoNameE;
    @ReportItem(name = "hakkoYmd", length = 20, order = 19)
    public RString hakkoYmd;
    @ReportItem(name = "senkyoKanri", length = 50, order = 20)
    public RString senkyoKanri;
// </editor-fold>
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
