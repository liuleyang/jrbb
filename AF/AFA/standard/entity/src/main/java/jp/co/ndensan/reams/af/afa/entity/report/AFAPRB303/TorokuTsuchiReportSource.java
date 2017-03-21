package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303;

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
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 10, order = 1)
    public RString yubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 2)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 16, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "tsuchiSaki", length = 20, order = 4)
    public RString tsuchiSaki;
    @ReportItem(name = "tsuchiSakiL", length = 26, order = 5)
    public RString tsuchiSakiL;
    @ReportItem(name = "tsuchiMoto2", length = 26, order = 6)
    public RString tsuchiMoto2;
    @ReportItem(name = "tsuchiMoto1", length = 11, order = 7)
    public RString tsuchiMoto1;
    @ReportItem(name = "iinchoMei1", length = 16, order = 8)
    public RString iinchoMei1;
    @ReportItem(name = "iinchoMei2", length = 12, order = 9)
    public RString iinchoMei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 10)
    public RString koinShoryaku;
    @ReportItem(name = "title", length = 18, order = 11)
    public RString title;
    @ReportItem(name = "honbun1", length = 80, order = 12)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 80, order = 13)
    public RString honbun2;
    @ReportItem(name = "shimei1", length = 30, order = 14)
    public RString shimei1;
    @ReportItem(name = "shimei2", length = 30, order = 15)
    public RString shimei2;
    @ReportItem(name = "komokuTitleShimei", length = 5, order = 16)
    public RString komokuTitleShimei;
    @ReportItem(name = "shimei", length = 25, order = 17)
    public RString shimei;
    @ReportItem(name = "shimei3", length = 30, order = 18)
    public RString shimei3;
    @ReportItem(name = "shimei4", length = 30, order = 19)
    public RString shimei4;
    @ReportItem(name = "seinengappi", length = 16, order = 20)
    public RString seinengappi;
    @ReportItem(name = "seibetsuM", length = 1, order = 21)
    public RString seibetsuM;
    @ReportItem(name = "seibetsuF", length = 1, order = 22)
    public RString seibetsuF;
    @ReportItem(name = "seibetsu", length = 1, order = 23)
    public RString seibetsu;
    @ReportItem(name = "komokuTitleYmd", length = 5, order = 24)
    public RString komokuTitleYmd;
    @ReportItem(name = "torokuYmd", length = 16, order = 25)
    public RString torokuYmd;
    @ReportItem(name = "honseki1", length = 25, order = 26)
    public RString honseki1;
    @ReportItem(name = "honseki2", length = 25, order = 27)
    public RString honseki2;
    @ReportItem(name = "honseki3", length = 25, order = 28)
    public RString honseki3;
    @ReportItem(name = "honseki4", length = 25, order = 29)
    public RString honseki4;
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
     * 登録した旨の通知エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        yubinNo,
        hakkoDaino,
        hakkoYmd,
        tsuchiSaki,
        tsuchiSakiL,
        tsuchiMoto2,
        tsuchiMoto1,
        iinchoMei1,
        iinchoMei2,
        koinShoryaku,
        title,
        honbun1,
        honbun2,
        shimei1,
        shimei2,
        komokuTitleShimei,
        shimei,
        shimei3,
        shimei4,
        seinengappi,
        seibetsuM,
        seibetsuF,
        seibetsu,
        komokuTitleYmd,
        torokuYmd,
        honseki1,
        honseki2,
        honseki3,
        honseki4;
    }
// </editor-fold>
}
