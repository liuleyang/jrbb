package jp.co.ndensan.reams.af.afa.entity.report.AFAPRC201;

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
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "shuruiTitle", length = 3, order = 2)
    public RString shuruiTitle;
    @ReportItem(name = "jusho", order = 3)
    public RString jusho;
    @ReportItem(name = "shimei", order = 4)
    public RString shimei;
    @ReportItem(name = "yukoKikanStart", length = 11, order = 5)
    public RString yukoKikanStart;
    @ReportItem(name = "yukoKikanEnd", length = 11, order = 6)
    public RString yukoKikanEnd;
    @ReportItem(name = "sentence", order = 7)
    public RString sentence;
    @ReportItem(name = "hakkoYmd", length = 20, order = 8)
    public RString hakkoYmd;
    @ReportItem(name = "shichosonMei", length = 20, order = 9)
    public RString shichosonMei;
    @ReportItem(name = "iinchoMei", order = 10)
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
     * 郵便等投票証明書エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        title,
        shuruiTitle,
        jusho,
        shimei,
        yukoKikanStart,
        yukoKikanEnd,
        sentence,
        hakkoYmd,
        shichosonMei,
        iinchoMei;
    }
// </editor-fold>
}
