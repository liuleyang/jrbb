/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG113;

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
 * 2号資格調査票（照会）（様式2-1）のソースファイルです。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
public class NigoShikakuChosahyoShokaiSource implements IReportSource {
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
    @ReportItem(name = "koteibun01", length = 72, order = 9)
    public RString koteibun01;
    @ReportItem(name = "koteibun02", length = 72, order = 10)
    public RString koteibun02;
    @ReportItem(name = "koteibun03", length = 72, order = 11)
    public RString koteibun03;
    @ReportItem(name = "koteibun04", length = 72, order = 12)
    public RString koteibun04;
    @ReportItem(name = "koteibun05", length = 72, order = 13)
    public RString koteibun05;
    @ReportItem(name = "koteibun06", length = 72, order = 14)
    public RString koteibun06;
    @ReportItem(name = "koteibun07", length = 72, order = 15)
    public RString koteibun07;
    @ReportItem(name = "cityKubun", length = 2, order = 16)
    public RString cityKubun;
    @ReportItem(name = "motoCityKubun", length = 2, order = 17)
    public RString motoCityKubun;
    @ReportItem(name = "listShimei1_1", length = 8, order = 18)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 13, order = 19)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1_2", length = 13, order = 20)
    public RString listJusho1_2;
    @ReportItem(name = "listShimei2_1", length = 8, order = 21)
    public RString listShimei2_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 22)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 23)
    public RString listSeinengappi_2;
    @ReportItem(name = "listJusho2_1", length = 13, order = 24)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho2_2", length = 13, order = 25)
    public RString listJusho2_2;
    @ReportItem(name = "listYmd_1", length = 10, order = 26)
    public RString listYmd_1;
    @ReportItem(name = "listYmd_2", length = 10, order = 27)
    public RString listYmd_2;
    @ReportItem(name = "listShimei3_1", length = 8, order = 28)
    public RString listShimei3_1;
    @ReportItem(name = "listJusho3_1", length = 13, order = 29)
    public RString listJusho3_1;
    @ReportItem(name = "listJusho3_2", length = 13, order = 30)
    public RString listJusho3_2;
    @ReportItem(name = "koteibunD1", length = 48, order = 31)
    public RString koteibunD1;
    @ReportItem(name = "koteibunD2", length = 48, order = 32)
    public RString koteibunD2;
    @ReportItem(name = "page", length = 5, order = 33)
    public RString page;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportItem(name = "shiMei", length = 24, order = 34)
    public RString shiMei;
    @ReportItem(name = "toJuSho", length = 40, order = 35)
    public RString toJuSho;
    @ReportItem(name = "tenshutsuMotoJusho", length = 40, order = 36)
    public RString tenshutsuMotoJusho;
    @ReportItem(name = "shikibetsuCode", order = 37)
    public RString shikibetsuCode;

    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;

    /**
     * ReportSourceFields enum 型です。
     */
    public enum ReportSourceFields {

        page;
    }
// </editor-fold>
}
