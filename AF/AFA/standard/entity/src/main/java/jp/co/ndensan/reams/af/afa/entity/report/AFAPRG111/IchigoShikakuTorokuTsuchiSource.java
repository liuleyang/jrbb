package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 1号資格登録通知（様式1）帳票出力のソース（自動生成）です。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
public class IchigoShikakuTorokuTsuchiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 10, order = 1)
    public RString yubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 2)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 11, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "tennyuMae2", length = 26, order = 4)
    public RString tennyuMae2;
    @ReportItem(name = "tennyuMae1", length = 13, order = 5)
    public RString tennyuMae1;
    @ReportItem(name = "tennyuSaki", length = 26, order = 6)
    public RString tennyuSaki;
    @ReportItem(name = "barcodeCustombarcode", order = 7)
    public RString barcodeCustombarcode;
    @ReportItem(name = "koinShoryaku", length = 6, order = 8)
    public RString koinShoryaku;
    @ReportItem(name = "koteibun01", length = 72, order = 9)
    public RString koteibun01;
    @ReportItem(name = "koteibun02", length = 72, order = 10)
    public RString koteibun02;
    @ReportItem(name = "koteibun03", length = 72, order = 11)
    public RString koteibun03;
    @ReportItem(name = "koteibun04", length = 72, order = 12)
    public RString koteibun04;
    @ReportItem(name = "cityKubun", length = 2, order = 13)
    public RString cityKubun;
    @ReportItem(name = "motoCityKubun", length = 2, order = 14)
    public RString motoCityKubun;
    @ReportItem(name = "listShimei1_1", length = 12, order = 15)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 15, order = 16)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1_2", length = 15, order = 17)
    public RString listJusho1_2;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 18)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 19)
    public RString listSeinengappi_2;
    @ReportItem(name = "listShimei2_1", length = 12, order = 20)
    public RString listShimei2_1;
    @ReportItem(name = "listJusho2_1", length = 15, order = 21)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho2_2", length = 15, order = 22)
    public RString listJusho2_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportItem(name = "tennyuZanTop5", order = 30) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    @ReportItem(name = "shiMei", order = 31) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString shiMei;
    @ReportItem(name = "shikibetsuCode", order = 32) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString shikibetsuCode;

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFields {

        /**
         * 転入前全国住所コード
         */
        tennyuZanTop5;
    }

}
