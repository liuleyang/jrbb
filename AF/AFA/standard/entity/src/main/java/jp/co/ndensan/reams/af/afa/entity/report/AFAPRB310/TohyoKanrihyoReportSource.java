package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310;

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
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonCode", length = 6, order = 1)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 2)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 3)
    public RString sakuseiYmdTime;
    @ReportItem(name = "listKofuNo_1", length = 20, order = 4)
    public RString listKofuNo_1;
    @ReportItem(name = "listKanaShimei_1", length = 22, order = 5)
    public RString listKanaShimei_1;
    @ReportItem(name = "listShimei1_1", length = 11, order = 6)
    public RString listShimei1_1;
    @ReportItem(name = "listSeibetsu_1", length = 1, order = 7)
    public RString listSeibetsu_1;
    @ReportItem(name = "listKeiyuRyojiKan1_1", length = 10, order = 8)
    public RString listKeiyuRyojiKan1_1;
    @ReportItem(name = "listKeiyuRyojiKan2_1", length = 10, order = 9)
    public RString listKeiyuRyojiKan2_1;
    @ReportItem(name = "listShikaku_1", length = 3, order = 10)
    public RString listShikaku_1;
    @ReportItem(name = "listSeinengappi_1", length = 10, order = 11)
    public RString listSeinengappi_1;
    @ReportItem(name = "listTorokuYmd_1", length = 10, order = 12)
    public RString listTorokuYmd_1;
    @ReportItem(name = "sakuseiJoken", length = 80, order = 13)
    public RString sakuseiJoken;
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

    /**
     * 記載事項変更通知（領事官）エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        shichosonCode,
        shichosonMei,
        sakuseiYmdTime,
        listKofuNo_1,
        listKanaShimei_1,
        listShimei1_1,
        listSeibetsu_1,
        listKeiyuRyojiKan1_1,
        listKeiyuRyojiKan2_1,
        listShikaku_1,
        listSeinengappi_1,
        listTorokuYmd_1,
        sakuseiJoken;
    }
// </editor-fold>
}
