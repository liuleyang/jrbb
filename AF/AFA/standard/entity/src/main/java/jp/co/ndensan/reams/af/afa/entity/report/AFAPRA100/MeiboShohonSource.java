package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 選挙人名簿抄本Itemクラスです。
 *
 */
public class MeiboShohonSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "pagecnt", length = 5, order = 1)
    public RString pagecnt;
    @ReportItem(name = "title", length = 15, order = 2)
    public RString title;
    @ReportItem(name = "tohyokuMei", length = 30, order = 3)
    public RString tohyokuMei;
    @ReportItem(name = "tohyokuCode", length = 4, order = 4)
    public RString tohyokuCode;
    @ReportItem(name = "jushoMeisho", length = 8, order = 5)
    public RString jushoMeisho;
    @ReportItem(name = "jushoCode", length = 11, order = 6)
    public RString jushoCode;
    @ReportItem(name = "jusho", length = 40, order = 7)
    public RString jusho;
    @ReportItem(name = "totalPage", length = 4, order = 8)
    public RString totalPage;
    @ReportItem(name = "page", length = 5, order = 9)
    public RString page;
    @ReportItem(name = "listJusho1_1", length = 36, order = 10)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho1M_1", length = 36, order = 11)
    public RString listJusho1M_1;
    @ReportItem(name = "listJusho2_1", length = 36, order = 12)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho2M_1", length = 36, order = 13)
    public RString listJusho2M_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 14)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappiM_1", length = 10, order = 15)
    public RString listSeinengappiM_1;
    @ReportItem(name = "listFuzaishaShikaku_1", length = 2, order = 16)
    public RString listFuzaishaShikaku_1;
    @ReportItem(name = "listFuzaishaShikakuM_1", length = 2, order = 17)
    public RString listFuzaishaShikakuM_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 18)
    public RString listSeibetsu_1;
    @ReportItem(name = "listSeibetsuM_1", length = 1, order = 19)
    public RString listSeibetsuM_1;
    @ReportItem(name = "listSetainushi_1", length = 1, order = 20)
    public RString listSetainushi_1;
    @ReportItem(name = "listSetainushiM_1", length = 1, order = 21)
    public RString listSetainushiM_1;
    @ReportItem(name = "listShimei_1", length = 11, order = 22)
    public RString listShimei_1;
    @ReportItem(name = "listShimeiKana_1", length = 24, order = 23)
    public RString listShimeiKana_1;
    @ReportItem(name = "listShimeiKanaM_1", length = 24, order = 24)
    public RString listShimeiKanaM_1;
    @ReportItem(name = "listShimeiM_1", length = 11, order = 25)
    public RString listShimeiM_1;
    @ReportItem(name = "listHyoji1_1", length = 32, order = 26)
    public RString listHyoji1_1;
    @ReportItem(name = "listHyoji2_1", length = 32, order = 27)
    public RString listHyoji2_1;
    @ReportItem(name = "listHyoji3_1", length = 32, order = 28)
    public RString listHyoji3_1;
    @ReportItem(name = "listUketsuke1_1", length = 12, order = 29)
    public RString listUketsuke1_1;
    @ReportItem(name = "listUketsuke2_1", length = 12, order = 30)
    public RString listUketsuke2_1;
    @ReportItem(name = "pageKeiWoman", length = 2, order = 31)
    public RString pageKeiWoman;
    @ReportItem(name = "pageKeiKei", length = 2, order = 32)
    public RString pageKeiKei;
    @ReportItem(name = "senkanMei", length = 52, order = 33)
    public RString senkanMei;
    @ReportItem(name = "pageKeiMan", length = 2, order = 34)
    public RString pageKeiMan;
    @ReportItem(name = "kei1Man", length = 7, order = 35)
    public RString kei1Man;
    @ReportItem(name = "kei1Woman", length = 7, order = 36)
    public RString kei1Woman;
    @ReportItem(name = "kei1Kei", length = 7, order = 37)
    public RString kei1Kei;
    @ReportItem(name = "kei1Title", length = 30, order = 38)
    public RString kei1Title;
    @ReportItem(name = "senkyoMei2", length = 14, order = 39)
    public RString senkyoMei2;
    @ReportItem(name = "senkyoMei3", length = 14, order = 40)
    public RString senkyoMei3;
    @ReportItem(name = "kei2Title", length = 30, order = 41)
    public RString kei2Title;
    @ReportItem(name = "kei2Man", length = 7, order = 42)
    public RString kei2Man;
    @ReportItem(name = "kei2Woman", length = 7, order = 43)
    public RString kei2Woman;
    @ReportItem(name = "kei2Kei", length = 7, order = 44)
    public RString kei2Kei;
    @ReportItem(name = "senkyoMei1", length = 14, order = 45)
    public RString senkyoMei1;
    @ReportItem(name = "senkyoMei4", length = 14, order = 46)
    public RString senkyoMei4;
    @ReportItem(name = "senkyoMei5", length = 14, order = 47)
    public RString senkyoMei5;
    @ReportItem(name = "senkyoMei6", length = 14, order = 48)
    public RString senkyoMei6;
    @ReportItem(name = "kei3Title", length = 30, order = 49)
    public RString kei3Title;
    @ReportItem(name = "kei3Man", length = 7, order = 50)
    public RString kei3Man;
    @ReportItem(name = "kei3Woman", length = 7, order = 51)
    public RString kei3Woman;
    @ReportItem(name = "kei3Kei", length = 7, order = 52)
    public RString kei3Kei;
    @ReportItem(name = "senkyoMei7", length = 14, order = 53)
    public RString senkyoMei7;
    @ReportItem(name = "senkyoMei8", length = 14, order = 54)
    public RString senkyoMei8;
    @ReportItem(name = "senkyoMei9", length = 14, order = 55)
    public RString senkyoMei9;
    @ReportItem(name = "kei4Title", length = 30, order = 56)
    public RString kei4Title;
    @ReportItem(name = "kei4Man", length = 7, order = 57)
    public RString kei4Man;
    @ReportItem(name = "kei4Woman", length = 7, order = 58)
    public RString kei4Woman;
    @ReportItem(name = "kei4Kei", length = 7, order = 59)
    public RString kei4Kei;
    @ReportItem(name = "listJusho3_1", length = 36, order = 60)
    public RString listJusho3_1;
    @ReportItem(name = "listJusho3M_1", length = 36, order = 61)
    public RString listJusho3M_1;
    @ReportItem(name = "listJusho4_1", length = 36, order = 62)
    public RString listJusho4_1;
    @ReportItem(name = "listJusho4M_1", length = 36, order = 63)
    public RString listJusho4M_1;
    @ReportItem(name = "listJusho5_1", length = 36, order = 64)
    public RString listJusho5_1;
    @ReportItem(name = "listJusho5M_1", length = 36, order = 65)
    public RString listJusho5M_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportItem(name = "shikibetsuCode", order = 66)
    @ReportPerson(id = "X")
    public RString shikibetsuCode;
    @ReportItem(name = "realPage", order = 67)
    public RString realPage;
    @ReportItem(name = "listJusho", length = 108, order = 68)
    public RString listJusho;

    /**
     * ReportSourceFiledsのEnum
     */
    public static enum ReportSourceFields {

        realPage;
    }
// </editor-fold>
}
