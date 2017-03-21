package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 二重登録通知書明細の項目定義
 *
 */
public class NijuTorokuTsuchishoMeisaiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "listShimei2_1", length = 12, order = 1)
    public RString listShimei2_1;
    @ReportItem(name = "listJusho2_1", length = 20, order = 2)
    public RString listJusho2_1;
    @ReportItem(name = "listShimei1_1", length = 12, order = 3)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 20, order = 4)
    public RString listJusho1_1;
    @ReportItem(name = "listYmd_1", length = 10, order = 5)
    public RString listYmd_1;
    @ReportItem(name = "listYmd_2", length = 1, order = 6)
    public RString listYmd_2;
    @ReportItem(name = "listYmd_3", length = 10, order = 7)
    public RString listYmd_3;
    @ReportItem(name = "listShimei3_1", length = 12, order = 8)
    public RString listShimei3_1;
    @ReportItem(name = "listJusho3_1", length = 20, order = 9)
    public RString listJusho3_1;
    @ReportItem(name = "hakkoYmd", length = 11, order = 10)
    public RString hakkoYmd;
    @ReportItem(name = "tennyuMotoShichosonMei", length = 39, order = 11)
    public RString tennyuMotoShichosonMei;
    @ReportItem(name = "senkyoMeisho", length = 26, order = 12)
    public RString senkyoMeisho;
    @ReportItem(name = "tennyuMotoPageCount", length = 6, order = 13)
    public RString tennyuMotoPageCount;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
