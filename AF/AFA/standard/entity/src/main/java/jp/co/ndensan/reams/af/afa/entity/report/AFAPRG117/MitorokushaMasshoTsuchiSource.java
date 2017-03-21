/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG117;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 未登録者抹消通知の項目定義
 *
 * @reamsid_L AF-0360-064 b_caiyf
 */
public class MitorokushaMasshoTsuchiSource implements IReportSource {
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
    @ReportItem(name = "cityKubun", length = 2, order = 9)
    public RString cityKubun;
    @ReportItem(name = "motoCityKubun", length = 2, order = 10)
    public RString motoCityKubun;
    @ReportItem(name = "listShimei1_1", length = 8, order = 11)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 13, order = 12)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1_2", length = 13, order = 13)
    public RString listJusho1_2;
    @ReportItem(name = "listGaitoShibo_1", length = 1, order = 14)
    public RString listGaitoShibo_1;
    @ReportItem(name = "listShimei2_1", length = 8, order = 15)
    public RString listShimei2_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 16)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 17)
    public RString listSeinengappi_2;
    @ReportItem(name = "listJusho2_1", length = 13, order = 18)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho2_2", length = 13, order = 19)
    public RString listJusho2_2;
    @ReportItem(name = "listGaitoSoshitsu_1", length = 1, order = 20)
    public RString listGaitoSoshitsu_1;
    @ReportItem(name = "listShimei3_1", length = 8, order = 21)
    public RString listShimei3_1;
    @ReportItem(name = "listJusho3_1", length = 13, order = 22)
    public RString listJusho3_1;
    @ReportItem(name = "listJusho3_2", length = 13, order = 23)
    public RString listJusho3_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportItem(name = "tennyuZanTop5", order = 24) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    @ReportItem(name = "shikibetsuCode", order = 25)
    public RString shikibetsuCode;
    /**
     * レイアウトブレイク用キーの一覧です。
     */
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;

    /**
     * 改ページ条件 パラメータ.選挙人資格の情報.転入前全国住所コードの上5桁
     */
    public enum ReportSourceFields {

        tennyuZanTop5
    }
// </editor-fold>
}
