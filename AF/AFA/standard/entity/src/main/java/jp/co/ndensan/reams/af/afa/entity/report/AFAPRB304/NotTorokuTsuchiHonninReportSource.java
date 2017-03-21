package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoDaino", length = 42, order = 1)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 16, order = 2)
    public RString hakkoYmd;
    @ReportItem(name = "honninShimei1", length = 20, order = 3)
    public RString honninShimei1;
    @ReportItem(name = "honninShimei2", length = 20, order = 4)
    public RString honninShimei2;
    @ReportItem(name = "tsuchiMoto2", length = 26, order = 5)
    public RString tsuchiMoto2;
    @ReportItem(name = "tsuchiMoto1", length = 11, order = 6)
    public RString tsuchiMoto1;
    @ReportItem(name = "iinchoMei1", length = 16, order = 7)
    public RString iinchoMei1;
    @ReportItem(name = "iinchoMei2", length = 12, order = 8)
    public RString iinchoMei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "senkyoShurui", length = 2, order = 10)
    public RString senkyoShurui;
    @ReportItem(name = "honbun1", length = 80, order = 11)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 80, order = 12)
    public RString honbun2;
    @ReportItem(name = "honbun3", length = 80, order = 13)
    public RString honbun3;
    @ReportItem(name = "shimei1", length = 20, order = 14)
    public RString shimei1;
    @ReportItem(name = "shimei", length = 25, order = 15)
    public RString shimei;
    @ReportItem(name = "shimei2", length = 20, order = 16)
    public RString shimei2;
    @ReportItem(name = "ryojikan1", length = 30, order = 17)
    public RString ryojikan1;
    @ReportItem(name = "ryojikan", length = 25, order = 18)
    public RString ryojikan;
    @ReportItem(name = "ryojikan2", length = 30, order = 19)
    public RString ryojikan2;
    @ReportItem(name = "riyu1", length = 1, order = 20)
    public RString riyu1;
    @ReportItem(name = "riyu2", length = 1, order = 21)
    public RString riyu2;
    @ReportItem(name = "riyu3", length = 1, order = 22)
    public RString riyu3;
    @ReportItem(name = "riyu4", length = 1, order = 23)
    public RString riyu4;
    @ReportItem(name = "kiteiNenrei", length = 2, order = 24)
    public RString kiteiNenrei;
    @ReportItem(name = "riyu5", length = 1, order = 25)
    public RString riyu5;
    @ReportItem(name = "riyu6", length = 1, order = 26)
    public RString riyu6;
    @ReportItem(name = "riyu7", length = 1, order = 27)
    public RString riyu7;
    @ReportItem(name = "riyu8", length = 1, order = 28)
    public RString riyu8;
    @ReportItem(name = "riyu9", length = 1, order = 29)
    public RString riyu9;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * 登録を行わなかった旨の通知（本人）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        hakkoDaino,
        hakkoYmd,
        honninShimei1,
        honninShimei2,
        tsuchiMoto2,
        tsuchiMoto1,
        iinchoMei1,
        iinchoMei2,
        koinShoryaku,
        senkyoShurui,
        honbun1,
        honbun2,
        honbun3,
        shimei1,
        shimei,
        shimei2,
        ryojikan1,
        ryojikan,
        ryojikan2,
        riyu1,
        riyu2,
        riyu3,
        riyu4,
        kiteiNenrei,
        riyu5,
        riyu6,
        riyu7,
        riyu8,
        riyu9;
    }
// </editor-fold>
}
