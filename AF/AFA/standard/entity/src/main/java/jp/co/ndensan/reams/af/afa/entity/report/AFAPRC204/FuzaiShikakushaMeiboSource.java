package jp.co.ndensan.reams.af.afa.entity.report.AFAPRC204;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 不在者投票資格者名簿ソース（自動生成）です。
 *
 * @reamsid_L AF-0030-036 liss
 */
public class FuzaiShikakushaMeiboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 12, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "meisaiTitleJusho", length = 6, order = 5)
    public RString meisaiTitleJusho;
    @ReportItem(name = "meisaiTitleShikakuShorui1", length = 4, order = 6)
    public RString meisaiTitleShikakuShorui1;
    @ReportItem(name = "meisaiTitle", length = 4, order = 7)
    public RString meisaiTitle;
    @ReportItem(name = "meisaiTitleShikakuShorui2", length = 4, order = 8)
    public RString meisaiTitleShikakuShorui2;
    @ReportItem(name = "meisaiTitleDairShikibetsuCode", length = 8, order = 9)
    public RString meisaiTitleDairShikibetsuCode;
    @ReportItem(name = "meisaiTitleDairiShimei", length = 13, order = 10)
    public RString meisaiTitleDairiShimei;
    @ReportItem(name = "meisaiTitleYubinshikaku", length = 2, order = 11)
    public RString meisaiTitleYubinshikaku;
    @ReportItem(name = "meisaiTitleDairiSeinengappi", length = 4, order = 12)
    public RString meisaiTitleDairiSeinengappi;
    @ReportItem(name = "meisaiTitleDairiSeibetsu", length = 2, order = 13)
    public RString meisaiTitleDairiSeibetsu;
    @ReportItem(name = "meisaiTitleDairiShubetsu", length = 2, order = 14)
    public RString meisaiTitleDairiShubetsu;
    @ReportItem(name = "meisaiTitleDairiJusho", length = 13, order = 15)
    public RString meisaiTitleDairiJusho;
    @ReportItem(name = "listMeisai1_1", length = 1, order = 16)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 17)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai3_1", length = 1, order = 18)
    public RString listMeisai3_1;
    @ReportItem(name = "listMeisai1_2", length = 12, order = 19)
    public RString listMeisai1_2;
    @ReportPerson(id = "X")
    @ReportItem(name = "listMeisai2_2", length = 15, order = 20)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai3_2", length = 15, order = 21)
    public RString listMeisai3_2;
    @ReportItem(name = "listMeisai1_3", length = 15, order = 22)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai2_3", length = 15, order = 23)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai3_3", length = 15, order = 24)
    public RString listMeisai3_3;
    @ReportItem(name = "listMeisai1_4", length = 4, order = 25)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai2_4", length = 3, order = 26)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai3_4", length = 3, order = 27)
    public RString listMeisai3_4;
    @ReportItem(name = "listMeisai1_5", length = 8, order = 28)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai2_5", length = 10, order = 29)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai3_5", length = 10, order = 30)
    public RString listMeisai3_5;
    @ReportItem(name = "listMeisai1_6", length = 11, order = 31)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai2_6", length = 1, order = 32)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai3_6", length = 1, order = 33)
    public RString listMeisai3_6;
    @ReportItem(name = "listMeisai1_7", length = 30, order = 34)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai2_7", length = 3, order = 35)
    public RString listMeisai2_7;
    @ReportItem(name = "listMeisai3_7", length = 3, order = 36)
    public RString listMeisai3_7;
    @ReportItem(name = "listMeisai1_8", length = 2, order = 37)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai2_8", length = 30, order = 38)
    public RString listMeisai2_8;
    @ReportItem(name = "listMeisai3_8", length = 30, order = 39)
    public RString listMeisai3_8;
    @ReportItem(name = "listMeisai1_9", length = 10, order = 40)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai2_9", length = 2, order = 41)
    public RString listMeisai2_9;
    @ReportItem(name = "listMeisai3_9", length = 2, order = 42)
    public RString listMeisai3_9;
    @ReportItem(name = "listMeisai1_10", length = 10, order = 43)
    public RString listMeisai1_10;
    @ReportItem(name = "listMeisai2_10", length = 10, order = 44)
    public RString listMeisai2_10;
    @ReportItem(name = "listMeisai3_10", length = 10, order = 45)
    public RString listMeisai3_10;
    @ReportItem(name = "listMeisai2_11", length = 10, order = 46)
    public RString listMeisai2_11;
    @ReportItem(name = "listMeisai3_11", length = 10, order = 47)
    public RString listMeisai3_11;
    @ReportItem(name = "selSenkyoHani", length = 60, order = 48)
    public RString selSenkyoHani;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportItem(name = "pageBreak", length = 60, order = 49)
    public RString pageBreak;
// </editor-fold>
}
