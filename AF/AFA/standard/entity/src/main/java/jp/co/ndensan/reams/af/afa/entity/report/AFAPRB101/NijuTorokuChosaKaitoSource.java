package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
 * 二重登録調査票（回答）ソース（自動生成）です。
 *
 * @reamsid_L AF-0030-034 liss
 */
public class NijuTorokuChosaKaitoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tenshutsuMotoYubinNo", length = 10, order = 1)
    public RString tenshutsuMotoYubinNo;
    @ReportItem(name = "hakkoNengo", length = 2, order = 2)
    public RString hakkoNengo;
    @ReportItem(name = "tenshutsuMotoShichosonMei2", length = 26, order = 3)
    public RString tenshutsuMotoShichosonMei2;
    @ReportItem(name = "tenshutsuMotoShichosonMei1", length = 13, order = 4)
    public RString tenshutsuMotoShichosonMei1;
    @ReportItem(name = "tenshutsuSakiShichosonMei2", length = 26, order = 5)
    public RString tenshutsuSakiShichosonMei2;
    @ReportItem(name = "tenshutsuSakiShichosonMei1", length = 11, order = 6)
    public RString tenshutsuSakiShichosonMei1;
    @ReportItem(name = "barcodeCustombarcode", order = 7)
    public RString barcodeCustombarcode;
    @ReportItem(name = "koteibun01", length = 48, order = 8)
    public RString koteibun01;
    @ReportItem(name = "listYmd2_1", length = 11, order = 9)
    public RString listYmd2_1;
    @ReportItem(name = "listYmd2_2", length = 11, order = 10)
    public RString listYmd2_2;
    @ReportItem(name = "listNo2_1", length = 15, order = 11)
    public RString listNo2_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 12)
    public RString listSeibetsu_1;
    @ReportItem(name = "listShimei1_1", length = 12, order = 13)
    public RString listShimei1_1;
    @ReportItem(name = "listYmd1_1", length = 11, order = 14)
    public RString listYmd1_1;
    @ReportItem(name = "listYmd1_2", length = 11, order = 15)
    public RString listYmd1_2;
    @ReportItem(name = "listJusho1_1", length = 20, order = 16)
    public RString listJusho1_1;
    @ReportItem(name = "listNo1_1", length = 14, order = 17)
    public RString listNo1_1;
    @ReportItem(name = "listShimei_1", length = 12, order = 18)
    public RString listShimei_1;
    @ReportItem(name = "listJusho_1", length = 20, order = 19)
    public RString listJusho_1;
    @ReportItem(name = "listShimei2_1", length = 12, order = 20)
    public RString listShimei2_1;
    @ReportItem(name = "listJusho2_1", length = 20, order = 21)
    public RString listJusho2_1;
    @ReportItem(name = "tenshutsuMotoPageCount", length = 6, order = 22)
    public RString tenshutsuMotoPageCount;
    @ReportItem(name = "koteibun11", length = 48, order = 23)
    public RString koteibun11;
    @ReportItem(name = "koteibun12", length = 48, order = 24)
    public RString koteibun12;

    @ReportItem(name = "hakkoYmd", length = 11, order = 91)
    public RString hakkoYmd;
    @ReportItem(name = "tenshutsuMotoShichosonMei", length = 39, order = 92)
    public RString tenshutsuMotoShichosonMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportItem(name = "shiMei", length = 24, order = 98)
    public RString shiMei;
    @ReportItem(name = "juSho", length = 40, order = 99)
    public RString juSho;
    @ReportItem(name = "layout", order = 101)
    public RString layout;
    @ReportItem(name = "shikibetsuCode", order = 102)
    public RString shikibetsuCode;
    @ReportItem(name = "allPage", order = 100)
    public RString allPage;
    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>

}
