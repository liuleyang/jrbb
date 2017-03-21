/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 転入者調査票（照会）の項目定義
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
public class KokugaiTennyushaChosahyoShokaiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 10, order = 1)
    public RString yubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 2)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 11, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "tennyuMae2", length = 26, order = 4)
    public RString tennyuMae2;
    @ReportItem(name = "tennyuMae1", length = 23, order = 5)
    public RString tennyuMae1;
    @ReportItem(name = "tennyuSaki", length = 26, order = 6)
    public RString tennyuSaki;
    @ReportItem(name = "barcodeCustombarcode", order = 7)
    public RString barcodeCustombarcode;
    @ReportItem(name = "koinShoryaku", length = 6, order = 8)
    public RString koinShoryaku;
    @ReportItem(name = "naigaiKubun", length = 2, order = 9)
    public RString naigaiKubun;
    @ReportItem(name = "koteibun01", length = 72, order = 10)
    public RString koteibun01;
    @ReportItem(name = "koteibun02", length = 72, order = 11)
    public RString koteibun02;
    @ReportItem(name = "koteibun03", length = 72, order = 12)
    public RString koteibun03;
    @ReportItem(name = "koteibun04", length = 72, order = 13)
    public RString koteibun04;
    @ReportItem(name = "koteibun05", length = 72, order = 14)
    public RString koteibun05;
    @ReportItem(name = "koteibun06", length = 72, order = 15)
    public RString koteibun06;
    @ReportItem(name = "koteibun07", length = 72, order = 16)
    public RString koteibun07;
    @ReportItem(name = "cityKubun", length = 2, order = 17)
    public RString cityKubun;
    @ReportItem(name = "listShimei1_1", length = 8, order = 18)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 13, order = 19)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1_2", length = 13, order = 20)
    public RString listJusho1_2;
    @ReportItem(name = "listHonseki1_1", length = 11, order = 21)
    public RString listHonseki1_1;
    @ReportItem(name = "listShimei2_1", length = 8, order = 22)
    public RString listShimei2_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 23)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 24)
    public RString listSeinengappi_2;
    @ReportItem(name = "listJusho2_1", length = 13, order = 25)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho2_2", length = 13, order = 26)
    public RString listJusho2_2;
    @ReportItem(name = "listHonseki2_1", length = 11, order = 27)
    public RString listHonseki2_1;
    @ReportItem(name = "listShimei3_1", length = 8, order = 28)
    public RString listShimei3_1;
    @ReportItem(name = "listJusho3_1", length = 13, order = 29)
    public RString listJusho3_1;
    @ReportItem(name = "listJusho3_2", length = 13, order = 30)
    public RString listJusho3_2;
    @ReportItem(name = "listHonseki3_1", length = 11, order = 31)
    public RString listHonseki3_1;
    @ReportItem(name = "koteibunD1", length = 48, order = 32)
    public RString koteibunD1;
    @ReportItem(name = "koteibunD2", length = 48, order = 33)
    public RString koteibunD2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "tennyuZanTop5", order = 34) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    @ReportItem(name = "shikibetsuCode", order = 35)
    public RString shikibetsuCode;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;

    /**
     * 改ページ条件 パラメータ.選挙人資格の情報.本籍全国住所コードの上5桁
     */
    public enum ReportSourceFields {

        tennyuZanTop5
    }
// </editor-fold>
}
