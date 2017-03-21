package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205;

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
 * 施設送付書ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //ShisetsuSofushoSource
    @ReportItem(name = "hakkoDaino", length = 42, order = 1)
    public RString hakkoDaino;
    @ReportItem(name = "atenaU1", length = 20, order = 2)
    public RString atenaU1;
    @ReportItem(name = "hakkoYmd", length = 11, order = 3)
    public RString hakkoYmd;
    @ReportItem(name = "atenaU2", length = 20, order = 4)
    public RString atenaU2;
    @ReportItem(name = "atenaD1", length = 20, order = 5)
    public RString atenaD1;
    @ReportItem(name = "atenaD2", length = 20, order = 6)
    public RString atenaD2;
    @ReportItem(name = "atenaDR2", length = 3, order = 7)
    public RString atenaDR2;
    @ReportItem(name = "iinkaiMei", length = 19, order = 8)
    public RString iinkaiMei;
    @ReportItem(name = "iinchoMei", length = 16, order = 9)
    public RString iinchoMei;
    @ReportItem(name = "honbun1", length = 35, order = 10)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 35, order = 11)
    public RString honbun2;
    @ReportItem(name = "kofuTitle", length = 8, order = 12)
    public RString kofuTitle;
    @ReportItem(name = "kofuYmdStart", length = 11, order = 13)
    public RString kofuYmdStart;
    @ReportItem(name = "kara", length = 1, order = 14)
    public RString kara;
    @ReportItem(name = "kofuYmdEnd", length = 11, order = 15)
    public RString kofuYmdEnd;
    @ReportItem(name = "page", length = 3, order = 16)
    public RString page;
    @ReportItem(name = "pagecnt", length = 6, order = 17)
    public RString pagecnt;
    @ReportItem(name = "listMeiboNo_1", length = 8, order = 18)
    public RString listMeiboNo_1;
    @ReportItem(name = "listMeiboNo_2", length = 4, order = 19)
    public RString listMeiboNo_2;
    @ReportItem(name = "listMeiboNo_3", length = 14, order = 20)
    public RString listMeiboNo_3;
    @ReportItem(name = "listJusho_1", length = 18, order = 21)
    public RString listJusho_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 22)
    public RString listSeibetsu_1;
    @ReportItem(name = "listShimei_1", length = 18, order = 23)
    public RString listShimei_1;
    @ReportItem(name = "gokei", length = 32, order = 24)
    public RString gokei;
    //ShisetsuSofushoMeisaiSource
    @ReportItem(name = "senkyoMei", length = 20, order = 25)
    public RString senkyoMei;
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
    @ReportItem(name = "koinshoryaku", order = 26)
    public RString koinshoryaku;
    @ReportItem(name = "shisetsuCode", order = 27)
    public RString shisetsuCode;
    @ReportItem(name = "senkyoNo", order = 28)
    public RString senkyoNo;
    @ReportItem(name = "jusho", length = 18, order = 29)
    public RString jusho;
    @ReportItem(name = "shimei", length = 18, order = 30)
    public RString shimei;
    @ReportItem(name = "shikibetsuCode_1", order = 31)
    public RString shikibetsuCode_1;
    @ReportItem(name = "layoutBreakItem", length = 10, order = 230)
    public LayoutBreakItems layoutBreakItem;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS; //ブレイク処理クラスを作成する際に必要になる。(ブレイク処理クラスの実装時に作れば問題ない。)

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layoutBreakItem")));
    }

    /**
     * 施設送付書エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        hakkoDaino,
        atenaU1,
        hakkoYmd,
        atenaU2,
        atenaD1,
        atenaD2,
        atenaDR2,
        iinkaiMei,
        iinchoMei,
        honbun1,
        honbun2,
        kofuTitle,
        kofuYmdStart,
        kara,
        kofuYmdEnd,
        page,
        pagecnt,
        listMeiboNo_1,
        listMeiboNo_2,
        listMeiboNo_3,
        listJusho_1,
        listSeibetsu_1,
        listShimei_1,
        gokei,
        senkyoMei,
        layoutBreakItem,
        shisetsuCode,
        senkyoNo;

    }
}
