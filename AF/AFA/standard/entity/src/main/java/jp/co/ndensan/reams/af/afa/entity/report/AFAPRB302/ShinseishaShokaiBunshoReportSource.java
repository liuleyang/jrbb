package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302;

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
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 10, order = 1)
    public RString yubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 2)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 16, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "shokaiSaki", length = 20, order = 4)
    public RString shokaiSaki;
    @ReportItem(name = "shokaiSakiL", length = 26, order = 5)
    public RString shokaiSakiL;
    @ReportItem(name = "shokaiMoto2", length = 26, order = 6)
    public RString shokaiMoto2;
    @ReportItem(name = "shokaiMoto1", length = 11, order = 7)
    public RString shokaiMoto1;
    @ReportItem(name = "iinchoMei1", length = 16, order = 8)
    public RString iinchoMei1;
    @ReportItem(name = "iinchoMei2", length = 12, order = 9)
    public RString iinchoMei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 10)
    public RString koinShoryaku;
    @ReportItem(name = "senkyoShurui", length = 2, order = 11)
    public RString senkyoShurui;
    @ReportItem(name = "cityKubun", length = 1, order = 12)
    public RString cityKubun;
    @ReportItem(name = "shimei3", length = 17, order = 13)
    public RString shimei3;
    @ReportItem(name = "seibetsu", length = 1, order = 14)
    public RString seibetsu;
    @ReportItem(name = "shimei1", length = 17, order = 15)
    public RString shimei1;
    @ReportItem(name = "seinengappi", length = 16, order = 16)
    public RString seinengappi;
    @ReportItem(name = "shimei2", length = 17, order = 17)
    public RString shimei2;
    @ReportItem(name = "sakuseiYmd", length = 16, order = 18)
    public RString sakuseiYmd;
    @ReportItem(name = "honsekiU", length = 30, order = 19)
    public RString honsekiU;
    @ReportItem(name = "honsekiD", length = 30, order = 20)
    public RString honsekiD;
    @ReportItem(name = "honsekiTorokuKubunHon", length = 1, order = 21)
    public RString honsekiTorokuKubunHon;
    @ReportItem(name = "honsekiTorokuKubunEnd", length = 1, order = 22)
    public RString honsekiTorokuKubunEnd;
    @ReportItem(name = "endJusho1", length = 35, order = 23)
    public RString endJusho1;
    @ReportItem(name = "endJusho2", length = 35, order = 24)
    public RString endJusho2;
    @ReportItem(name = "endJusho3", length = 35, order = 25)
    public RString endJusho3;
    @ReportItem(name = "gengo", length = 2, order = 26)
    public RString gengo;
    @ReportItem(name = "kaitoSakiLu", length = 26, order = 27)
    public RString kaitoSakiLu;
    @ReportItem(name = "kaitoSakiLd", length = 26, order = 28)
    public RString kaitoSakiLd;
    @ReportItem(name = "kaitoSakiRd", length = 26, order = 29)
    public RString kaitoSakiRd;
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
     * 申請者の被登録資格の照会文書エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        yubinNo,
        hakkoDaino,
        hakkoYmd,
        shokaiSaki,
        shokaiSakiL,
        shokaiMoto2,
        shokaiMoto1,
        iinchoMei1,
        iinchoMei2,
        koinShoryaku,
        senkyoShurui,
        cityKubun,
        shimei3,
        seibetsu,
        shimei1,
        seinengappi,
        shimei2,
        sakuseiYmd,
        honsekiU,
        honsekiD,
        honsekiTorokuKubunHon,
        honsekiTorokuKubunEnd,
        endJusho1,
        endJusho2,
        endJusho3,
        gengo,
        kaitoSakiLu,
        kaitoSakiLd,
        kaitoSakiRd;
    }
// </editor-fold>
}
