package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301;

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
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kofuNo", length = 20, order = 1)
    public RString kofuNo;
    @ReportItem(name = "title", length = 15, order = 2)
    public RString title;
    @ReportItem(name = "shimei", order = 3)
    public RString shimei;
    @ReportItem(name = "yukoKikanStart1", length = 11, order = 4)
    public RString yukoKikanStart1;
    @ReportItem(name = "seibetsu", length = 1, order = 5)
    public RString seibetsu;
    @ReportItem(name = "yukoKikanEnd", length = 11, order = 6)
    public RString yukoKikanEnd;
    @ReportItem(name = "senkyoMei", length = 50, order = 7)
    public RString senkyoMei;
    @ReportItem(name = "jusho", order = 8)
    public RString jusho;
    @ReportItem(name = "sofusaki", order = 9)
    public RString sofusaki;
    @ReportItem(name = "shuruiTitle", length = 3, order = 10)
    public RString shuruiTitle;
    @ReportItem(name = "hakkoYmd", length = 20, order = 11)
    public RString hakkoYmd;
    @ReportItem(name = "shichosonMei", length = 20, order = 12)
    public RString shichosonMei;
    @ReportItem(name = "iinchoMei", order = 13)
    public RString iinchoMei;
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
     * 在外選挙人証エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        kofuNo,
        title,
        shimei,
        yukoKikanStart1,
        seibetsu,
        yukoKikanEnd,
        senkyoMei,
        jusho,
        sofusaki,
        shuruiTitle,
        hakkoYmd,
        shichosonMei,
        iinchoMei;
    }
// </editor-fold>
}
