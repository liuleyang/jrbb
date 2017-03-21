/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG302;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 国内転入者調査票（回答）の項目定義
 *
 * @reamsid_L AF-0360-067 b_caiyf
 */
public class KokunaiTennyushaChosahyoKaitoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 10, order = 1)
    public RString yubinNo;
    @ReportItem(name = "gengo", length = 2, order = 2)
    public RString gengo;
    @ReportItem(name = "tennyuSaki2", length = 26, order = 3)
    public RString tennyuSaki2;
    @ReportItem(name = "tennyuSaki1", length = 13, order = 4)
    public RString tennyuSaki1;
    @ReportItem(name = "tennyuMae2", length = 26, order = 5)
    public RString tennyuMae2;
    @ReportItem(name = "tennyuMae1", length = 11, order = 6)
    public RString tennyuMae1;
    @ReportItem(name = "barcodeCustombarcode", order = 7)
    public RString barcodeCustombarcode;
    @ReportItem(name = "hakkoYmd", length = 11, order = 8)
    public RString hakkoYmd;
    @ReportItem(name = "hakkoNo", length = 20, order = 9)
    public RString hakkoNo;
    @ReportItem(name = "aiteCityKubun", length = 2, order = 10)
    public RString aiteCityKubun;
    @ReportItem(name = "listShimei1_1", length = 16, order = 11)
    public RString listShimei1_1;
    @ReportItem(name = "listSeinengappi_1", length = 12, order = 12)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 13)
    public RString listSeibetsu_1;
    @ReportItem(name = "listShimei2_1", length = 16, order = 14)
    public RString listShimei2_1;
    @ReportItem(name = "koteibunD1", length = 48, order = 15)
    public RString koteibunD1;
    @ReportItem(name = "koteibunD2", length = 48, order = 16)
    public RString koteibunD2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "tennyuZanTop5", order = 17) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    @ReportItem(name = "shimei", length = 32, order = 18)
    public RString shimei;
    @ReportItem(name = "shikibetsuCode", order = 19)
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
