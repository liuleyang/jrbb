package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 登録を行わなかった旨の通知（領事官）
 *
 * @reamsid_L AF-0320-034 lis2
 */
public class NotTorokuTsuchiRyojikanReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoDaino", length = 42, order = 1)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 16, order = 2)
    public RString hakkoYmd;
    @ReportItem(name = "honninShimei1", length = 22, order = 3)
    public RString honninShimei1;
    @ReportItem(name = "tsuchiSaki1", length = 20, order = 4)
    public RString tsuchiSaki1;
    @ReportItem(name = "tsuchiSaki2", length = 24, order = 5)
    public RString tsuchiSaki2;
    @ReportItem(name = "honninShimei2", length = 22, order = 6)
    public RString honninShimei2;
    @ReportItem(name = "tsuchiMoto2", length = 26, order = 7)
    public RString tsuchiMoto2;
    @ReportItem(name = "tsuchiMoto1", length = 11, order = 8)
    public RString tsuchiMoto1;
    @ReportItem(name = "iinchoMei1", length = 16, order = 9)
    public RString iinchoMei1;
    @ReportItem(name = "iinchoMei2", length = 12, order = 10)
    public RString iinchoMei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 11)
    public RString koinShoryaku;
    @ReportItem(name = "title", length = 18, order = 12)
    public RString title;
    @ReportItem(name = "honbun1", length = 40, order = 13)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 40, order = 14)
    public RString honbun2;
    @ReportItem(name = "honbun3", length = 40, order = 15)
    public RString honbun3;
    @ReportItem(name = "honbun4", length = 40, order = 16)
    public RString honbun4;
    @ReportItem(name = "honbun5", length = 40, order = 17)
    public RString honbun5;
    @ReportItem(name = "honbun6", length = 40, order = 18)
    public RString honbun6;
    @ReportItem(name = "renrakusakiIinkaiMei", length = 22, order = 19)
    public RString renrakusakiIinkaiMei;
    @ReportItem(name = "renrakusakiYubinNo", length = 10, order = 20)
    public RString renrakusakiYubinNo;
    @ReportItem(name = "renrakusakiJusho1", length = 16, order = 21)
    public RString renrakusakiJusho1;
    @ReportItem(name = "renrakusakiJusho2", length = 16, order = 22)
    public RString renrakusakiJusho2;
    @ReportItem(name = "renrakusakiTitle1", length = 10, order = 23)
    public RString renrakusakiTitle1;
    @ReportItem(name = "renrakusaki1", length = 32, order = 24)
    public RString renrakusaki1;
    @ReportItem(name = "renrakusakiTitle2", length = 10, order = 25)
    public RString renrakusakiTitle2;
    @ReportItem(name = "renrakusaki2", length = 32, order = 26)
    public RString renrakusaki2;
    @ReportItem(name = "renrakusakiTitle3", length = 10, order = 27)
    public RString renrakusakiTitle3;
    @ReportItem(name = "renrakusaki3", length = 32, order = 28)
    public RString renrakusaki3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * 登録を行わなかった旨の通知（領事官）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        hakkoDaino,
        hakkoYmd,
        honninShimei1,
        tsuchiSaki1,
        tsuchiSaki2,
        honninShimei2,
        tsuchiMoto2,
        tsuchiMoto1,
        iinchoMei1,
        iinchoMei2,
        koinShoryaku,
        title,
        honbun1,
        honbun2,
        honbun3,
        honbun4,
        honbun5,
        honbun6,
        renrakusakiIinkaiMei,
        renrakusakiYubinNo,
        renrakusakiJusho1,
        renrakusakiJusho2,
        renrakusakiTitle1,
        renrakusaki1,
        renrakusakiTitle2,
        renrakusaki2,
        renrakusakiTitle3,
        renrakusaki3;
    }
// </editor-fold>
}
