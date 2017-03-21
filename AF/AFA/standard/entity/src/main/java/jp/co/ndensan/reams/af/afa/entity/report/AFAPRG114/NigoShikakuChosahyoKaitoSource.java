/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG114;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 2号資格調査票（回答）（様式2-2）のソース（自動生成）です
 *
 * @reamsid_L AF-0360-062 fulc
 */
public class NigoShikakuChosahyoKaitoSource implements IReportSource {
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
    @ReportItem(name = "cityKubun", length = 2, order = 11)
    public RString cityKubun;
    @ReportItem(name = "listShimei1_1", length = 16, order = 12)
    public RString listShimei1_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 13)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 14)
    public RString listSeinengappi_2;
    @ReportItem(name = "listShimei2_1", length = 16, order = 15)
    public RString listShimei2_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetsuCode;
    @ReportItem(name = "realPage", order = 67)
    public RString realPage;
    @ReportItem(name = "listJusho", length = 108, order = 68)
    public RString listJusho;
    @ReportItem(name = "tennyumaeZenkokuJushoCode", length = 5, order = 16)
    public RString tennyumaeZenkokuJushoCode;
    @ReportItem(name = "shimei", length = 32, order = 17)
    public RString shimei;
    @ReportItem(name = "shikibetsuCode1", order = 18)
    public RString shikibetsuCode1;
// </editor-fold>

    /**
     * ENUMです。
     */
    public enum ReportSourceFields {

        tennyumaeZenkokuJushoCode;
    }

}
