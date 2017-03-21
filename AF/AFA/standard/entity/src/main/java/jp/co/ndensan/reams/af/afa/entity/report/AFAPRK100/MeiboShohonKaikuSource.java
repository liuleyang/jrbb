package jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100;

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
 * 海区漁業調整委員会委員選挙人名簿抄本ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "tohyokuMei", length = 30, order = 2)
    public RString tohyokuMei;
    @ReportItem(name = "tohyokuCode", length = 4, order = 3)
    public RString tohyokuCode;
    @ReportItem(name = "jusho", length = 13, order = 4)
    public RString jusho;
    @ReportItem(name = "jushoMeisho", length = 8, order = 5)
    public RString jushoMeisho;
    @ReportItem(name = "jushoCode", length = 11, order = 6)
    public RString jushoCode;
    @ReportItem(name = "totalPage", length = 6, order = 7)
    public RString totalPage;
    @ReportItem(name = "page", length = 6, order = 8)
    public RString page;
    @ReportItem(name = "listListjusho1_1", length = 36, order = 9)
    public RString listListjusho1_1;
    @ReportItem(name = "listListjusho1M_1", length = 36, order = 10)
    public RString listListjusho1M_1;
    @ReportItem(name = "listListjusho2_1", length = 36, order = 11)
    public RString listListjusho2_1;
    @ReportItem(name = "listListjusho2M_1", length = 36, order = 12)
    public RString listListjusho2M_1;
    @ReportItem(name = "listListjusho3_1", length = 36, order = 13)
    public RString listListjusho3_1;
    @ReportItem(name = "listListjusho3M_1", length = 36, order = 14)
    public RString listListjusho3M_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 15)
    public RString listSeinengappi_1;
    @ReportItem(name = "listSeinengappiM_1", length = 10, order = 16)
    public RString listSeinengappiM_1;
    @ReportItem(name = "listSeinengappi_2", length = 1, order = 17)
    public RString listSeinengappi_2;
    @ReportItem(name = "listSeinengappiM_2", length = 1, order = 18)
    public RString listSeinengappiM_2;
    @ReportItem(name = "listSetainushi_1", length = 1, order = 19)
    public RString listSetainushi_1;
    @ReportItem(name = "listSetainushiM_1", length = 1, order = 20)
    public RString listSetainushiM_1;
    @ReportItem(name = "listKanaShimei_1", length = 24, order = 21)
    public RString listKanaShimei_1;
    @ReportItem(name = "listKanaShimeiM_1", length = 24, order = 22)
    public RString listKanaShimeiM_1;
    @ReportItem(name = "listShimei_1", length = 11, order = 23)
    public RString listShimei_1;
    @ReportItem(name = "listShimeiM_1", length = 11, order = 24)
    public RString listShimeiM_1;
    @ReportItem(name = "listKumiaiMei_1", length = 15, order = 25)
    public RString listKumiaiMei_1;
    @ReportItem(name = "listKumiaiMeiM_1", length = 15, order = 26)
    public RString listKumiaiMeiM_1;
    @ReportItem(name = "listTeishiMoji_1", length = 1, order = 27)
    public RString listTeishiMoji_1;
    @ReportItem(name = "listMasshoJiyu_1", length = 10, order = 28)
    public RString listMasshoJiyu_1;
    @ReportItem(name = "senkanMei", length = 26, order = 29)
    public RString senkanMei;
    @ReportItem(name = "selHani1", length = 20, order = 30)
    public RString selHani1;
    @ReportItem(name = "pageKeiMan", length = 2, order = 31)
    public RString pageKeiMan;
    @ReportItem(name = "pageKeiWoman", length = 2, order = 32)
    public RString pageKeiWoman;
    @ReportItem(name = "pageKeiKei", length = 2, order = 33)
    public RString pageKeiKei;
    @ReportItem(name = "selHani2", length = 38, order = 34)
    public RString selHani2;
    @ReportItem(name = "kei1Title", length = 32, order = 35)
    public RString kei1Title;
    @ReportItem(name = "kei1Man", length = 7, order = 36)
    public RString kei1Man;
    @ReportItem(name = "kei1Woman", length = 7, order = 37)
    public RString kei1Woman;
    @ReportItem(name = "kei1Kei", length = 7, order = 38)
    public RString kei1Kei;
    @ReportItem(name = "kei2Title", length = 32, order = 39)
    public RString kei2Title;
    @ReportItem(name = "kei2Man", length = 7, order = 40)
    public RString kei2Man;
    @ReportItem(name = "kei2Woman", length = 7, order = 41)
    public RString kei2Woman;
    @ReportItem(name = "kei2Kei", length = 7, order = 42)
    public RString kei2Kei;
    @ReportItem(name = "kei3Title", length = 32, order = 43)
    public RString kei3Title;
    @ReportItem(name = "kei3Man", length = 7, order = 44)
    public RString kei3Man;
    @ReportItem(name = "kei3Woman", length = 7, order = 45)
    public RString kei3Woman;
    @ReportItem(name = "kei3Kei", length = 7, order = 46)
    public RString kei3Kei;
    @ReportItem(name = "kei4Title", length = 32, order = 47)
    public RString kei4Title;
    @ReportItem(name = "kei4Man", length = 7, order = 48)
    public RString kei4Man;
    @ReportItem(name = "kei4Woman", length = 7, order = 49)
    public RString kei4Woman;
    @ReportItem(name = "kei4Kei", length = 7, order = 50)
    public RString kei4Kei;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportItem(name = "key1", order = 50)
    public RString key1;
    @ReportItem(name = "key2", order = 51)
    public RString key2;
    @ReportItem(name = "key3", order = 52)
    public RString key3;
    @ReportItem(name = "key4", order = 53)
    public RString key4;
    @ReportItem(name = "shikibetsuCode", order = 54)
    public RString shikibetsuCode;
    @ReportItem(name = "listShimei", length = 35, order = 55)
    public RString listShimei;
    @ReportItem(name = "listJusho", length = 108, order = 56)
    public RString listJusho;

    /**
     * 帳票用列挙クラス
     */
    public enum ReportSourceKeyFields {

        key1,
        key2,
        key3,
        key4,
        tohyokuCode,
        totalPage
    }

    /**
     * 海区漁業調整委員会委員選挙人名簿抄本エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        title,
        tohyokuMei,
        tohyokuCode,
        jusho,
        jushoMeisho,
        jushoCode,
        totalPage,
        page,
        listListjusho1_1,
        listListjusho1M_1,
        listListjusho2_1,
        listListjusho2M_1,
        listListjusho3_1,
        listListjusho3M_1,
        listSeinengappi_1,
        listSeinengappiM_1,
        listSeinengappi_2,
        listSeinengappiM_2,
        listSetainushi_1,
        listSetainushiM_1,
        listKanaShimei_1,
        listKanaShimeiM_1,
        listShimei_1,
        listShimeiM_1,
        listKumiaiMei_1,
        listKumiaiMeiM_1,
        listTeishiMoji_1,
        listMasshoJiyu_1,
        senkanMei,
        selHani1,
        pageKeiMan,
        pageKeiWoman,
        pageKeiKei,
        selHani2,
        kei1Title,
        kei1Man,
        kei1Woman,
        kei1Kei,
        kei2Title,
        kei2Man,
        kei2Woman,
        kei2Kei,
        kei3Title,
        kei3Man,
        kei3Woman,
        kei3Kei,
        kei4Title,
        kei4Man,
        kei4Woman,
        kei4Kei;

    }
}
