package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB100;

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
 * 二重登録調査票（照会）ソース（自動生成）です。
 *
 * @reamsid_L AF-0030-033 liss
 */
public class NijuTorokuChosaShokaiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tenshutsuSakiYubinNo", length = 10, order = 1)
    public RString tenshutsuSakiYubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 2)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 11, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "tenshutsuSakiShichosonMei2", length = 26, order = 4)
    public RString tenshutsuSakiShichosonMei2;
    @ReportItem(name = "tenshutsuSakiShichosonMei1", length = 13, order = 5)
    public RString tenshutsuSakiShichosonMei1;
    @ReportItem(name = "tenshutsuMotoShichosonMei1", length = 26, order = 6)
    public RString tenshutsuMotoShichosonMei1;
    @ReportItem(name = "tenshutsuMotoShichosonMei2", length = 11, order = 7)
    public RString tenshutsuMotoShichosonMei2;
    @ReportItem(name = "barcodeCustombarcode", order = 8)
    public RString barcodeCustombarcode;
    @ReportItem(name = "iinchoMei1", length = 16, order = 9)
    public RString iinchoMei1;
    @ReportItem(name = "iinchoMei2", length = 12, order = 10)
    public RString iinchoMei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 11)
    public RString koinShoryaku;
    @ReportItem(name = "todokedeKaishiYmd", length = 11, order = 12)
    public RString todokedeKaishiYmd;
    @ReportItem(name = "koteibun01", length = 48, order = 13)
    public RString koteibun01;
    @ReportItem(name = "todokedeShuryoYmd", length = 11, order = 14)
    public RString todokedeShuryoYmd;
    @ReportItem(name = "koteibun02", length = 48, order = 15)
    public RString koteibun02;
    @ReportItem(name = "koteibun03", length = 48, order = 16)
    public RString koteibun03;
    @ReportItem(name = "koteibun04", length = 48, order = 17)
    public RString koteibun04;
    @ReportItem(name = "tohyoYmd", length = 13, order = 18)
    public RString tohyoYmd;
    @ReportItem(name = "senkyoMeisho", length = 45, order = 19)
    public RString senkyoMeisho;
    @ReportItem(name = "listShimei1_1", length = 12, order = 20)
    public RString listShimei1_1;
    @ReportItem(name = "listJusho1_1", length = 20, order = 21)
    public RString listJusho1_1;
    @ReportItem(name = "listShimei_1", length = 12, order = 22)
    public RString listShimei_1;
    @ReportItem(name = "listYmd_1", length = 10, order = 23)
    public RString listYmd_1;
    @ReportItem(name = "listYmd_2", length = 1, order = 24)
    public RString listYmd_2;
    @ReportItem(name = "listYmd_3", length = 10, order = 25)
    public RString listYmd_3;
    @ReportItem(name = "listJusho_1", length = 20, order = 26)
    public RString listJusho_1;
    @ReportItem(name = "listShimei2_1", length = 12, order = 27)
    public RString listShimei2_1;
    @ReportItem(name = "listJusho2_1", length = 20, order = 28)
    public RString listJusho2_1;
    @ReportItem(name = "tennyuMotoPageCount", length = 6, order = 29)
    public RString tennyuMotoPageCount;
    @ReportItem(name = "koteibunD1", length = 48, order = 30)
    public RString koteibunD1;
    @ReportItem(name = "koteibunD2", length = 48, order = 31)
    public RString koteibunD2;
    @ReportItem(name = "tenshutsuSakiShichosonMei", length = 39, order = 90)
    public RString tenshutsuSakiShichosonMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">

    @ReportItem(name = "shiMei", length = 24, order = 98)
    public RString shiMei;
    @ReportItem(name = "juSho", length = 40, order = 99)
    public RString juSho;
    @ReportItem(name = "shikibetsuCode", order = 101)
    public RString shikibetsuCode;
    @ReportItem(name = "layout", order = 102)
    public RString layout;
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
