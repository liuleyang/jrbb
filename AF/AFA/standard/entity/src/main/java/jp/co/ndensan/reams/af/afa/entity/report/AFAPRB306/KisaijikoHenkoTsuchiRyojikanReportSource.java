package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306;

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
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoDaino", length = 42, order = 1)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 16, order = 2)
    public RString hakkoYmd;
    @ReportItem(name = "tsuchiSakiS", length = 20, order = 3)
    public RString tsuchiSakiS;
    @ReportItem(name = "tsuchiSakiL", length = 24, order = 4)
    public RString tsuchiSakiL;
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
    @ReportItem(name = "title", length = 26, order = 10)
    public RString title;
    @ReportItem(name = "honbun1", length = 80, order = 11)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 80, order = 12)
    public RString honbun2;
    @ReportItem(name = "honbun3", length = 80, order = 13)
    public RString honbun3;
    @ReportItem(name = "shimei1", length = 17, order = 14)
    public RString shimei1;
    @ReportItem(name = "shimei", length = 17, order = 15)
    public RString shimei;
    @ReportItem(name = "shimei2", length = 17, order = 16)
    public RString shimei2;
    @ReportItem(name = "seinengappi", length = 16, order = 17)
    public RString seinengappi;
    @ReportItem(name = "seibetsuM", length = 1, order = 18)
    public RString seibetsuM;
    @ReportItem(name = "seibetsuF", length = 1, order = 19)
    public RString seibetsuF;
    @ReportItem(name = "torokuYmd", length = 16, order = 20)
    public RString torokuYmd;
    @ReportItem(name = "senkyoShurui", length = 2, order = 21)
    public RString senkyoShurui;
    @ReportItem(name = "masshoYmd", length = 16, order = 22)
    public RString masshoYmd;
    @ReportItem(name = "masshoRiyu1", length = 1, order = 23)
    public RString masshoRiyu1;
    @ReportItem(name = "masshoRiyu2", length = 1, order = 24)
    public RString masshoRiyu2;
    @ReportItem(name = "masshoRiyu3", length = 1, order = 25)
    public RString masshoRiyu3;
    @ReportItem(name = "masshoRiyu4", length = 1, order = 26)
    public RString masshoRiyu4;
    @ReportItem(name = "shuseiYmd", length = 16, order = 27)
    public RString shuseiYmd;
    @ReportItem(name = "shuseiRiyu1", length = 1, order = 28)
    public RString shuseiRiyu1;
    @ReportItem(name = "shuseiMaeShimei1", length = 17, order = 29)
    public RString shuseiMaeShimei1;
    @ReportItem(name = "shuseiRiyu2", length = 1, order = 30)
    public RString shuseiRiyu2;
    @ReportItem(name = "shuseiMaeShimei", length = 17, order = 31)
    public RString shuseiMaeShimei;
    @ReportItem(name = "shuseiMaeShimei2", length = 17, order = 32)
    public RString shuseiMaeShimei2;
    @ReportItem(name = "shuseiRiyu3", length = 1, order = 33)
    public RString shuseiRiyu3;
    @ReportItem(name = "shuseiRiyu4", length = 1, order = 34)
    public RString shuseiRiyu4;
    @ReportItem(name = "shuseiRiyu5", length = 1, order = 35)
    public RString shuseiRiyu5;
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
     * 記載事項変更通知（領事官）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        hakkoDaino,
        hakkoYmd,
        tsuchiSakiS,
        tsuchiSakiL,
        tsuchiMoto2,
        tsuchiMoto1,
        iinchoMei1,
        iinchoMei2,
        koinShoryaku,
        title,
        honbun1,
        honbun2,
        honbun3,
        shimei1,
        shimei,
        shimei2,
        seinengappi,
        seibetsuM,
        seibetsuF,
        torokuYmd,
        senkyoShurui,
        masshoYmd,
        masshoRiyu1,
        masshoRiyu2,
        masshoRiyu3,
        masshoRiyu4,
        shuseiYmd,
        shuseiRiyu1,
        shuseiMaeShimei1,
        shuseiRiyu2,
        shuseiMaeShimei,
        shuseiMaeShimei2,
        shuseiRiyu3,
        shuseiRiyu4,
        shuseiRiyu5;
    }
// </editor-fold>
}
