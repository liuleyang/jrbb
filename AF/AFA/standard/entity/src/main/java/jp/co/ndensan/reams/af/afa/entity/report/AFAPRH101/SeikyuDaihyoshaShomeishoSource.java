package jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 請求代表者証明書ソース（自動生成）です。
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "ListDaihyoshaMei_1", length = 40, order = 2)
    public RString ListDaihyoshaMei_1;
    @ReportItem(name = "sentence", order = 3)
    public RString sentence;
    @ReportItem(name = "hakkoYmd", length = 20, order = 4)
    public RString hakkoYmd;
    @ReportItem(name = "shichosonMei", length = 20, order = 5)
    public RString shichosonMei;
    @ReportItem(name = "iinchoMei", order = 6)
    public RString iinchoMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
