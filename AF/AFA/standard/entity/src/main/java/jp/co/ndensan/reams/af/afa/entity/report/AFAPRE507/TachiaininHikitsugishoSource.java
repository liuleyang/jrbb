package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 投票立会人引継書のReportSourceです。
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tachiaiStartTime", length = 5, order = 1)
    public RString tachiaiStartTime;
    @ReportItem(name = "tachiaiStopTime", length = 5, order = 2)
    public RString tachiaiStopTime;
    @ReportItem(name = "ijoAri", length = 2, order = 3)
    public RString ijoAri;
    @ReportItem(name = "ijoNashi", length = 2, order = 4)
    public RString ijoNashi;
    @ReportItem(name = "ijoNaiyo", order = 5)
    public RString ijoNaiyo;
    @ReportItem(name = "listSaikofusha_1", length = 16, order = 6)
    public RString listSaikofusha_1;
    @ReportItem(name = "listSaikofusha_2", length = 16, order = 7)
    public RString listSaikofusha_2;
    @ReportItem(name = "ninzuSaikofusha", length = 5, order = 8)
    public RString ninzuSaikofusha;
    @ReportItem(name = "listKetteisho_1", length = 16, order = 9)
    public RString listKetteisho_1;
    @ReportItem(name = "listKetteisho_2", length = 16, order = 10)
    public RString listKetteisho_2;
    @ReportItem(name = "ninzuKetteisho", length = 5, order = 11)
    public RString ninzuKetteisho;
    @ReportItem(name = "listHenkanFuzai_1", length = 16, order = 12)
    public RString listHenkanFuzai_1;
    @ReportItem(name = "listHenkanFuzai_2", length = 16, order = 13)
    public RString listHenkanFuzai_2;
    @ReportItem(name = "ninzuHenkanFuzai", length = 5, order = 14)
    public RString ninzuHenkanFuzai;
    @ReportItem(name = "listTenji_1", length = 16, order = 15)
    public RString listTenji_1;
    @ReportItem(name = "listTenji_2", length = 16, order = 16)
    public RString listTenji_2;
    @ReportItem(name = "ninzuTenji", length = 5, order = 17)
    public RString ninzuTenji;
    @ReportItem(name = "listDairi_1", length = 16, order = 18)
    public RString listDairi_1;
    @ReportItem(name = "listDairi_2", length = 16, order = 19)
    public RString listDairi_2;
    @ReportItem(name = "ninzuDairi", length = 5, order = 20)
    public RString ninzuDairi;
    @ReportItem(name = "listKyohi_1", length = 16, order = 21)
    public RString listKyohi_1;
    @ReportItem(name = "listKyohi_2", length = 16, order = 22)
    public RString listKyohi_2;
    @ReportItem(name = "ninzuKyohi", length = 5, order = 23)
    public RString ninzuKyohi;
    @ReportItem(name = "tohyojoMei", length = 20, order = 24)
    public RString tohyojoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 25)
    public RString sakuseiYmdTime;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
