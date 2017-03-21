package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonCode", length = 6, order = 1)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 20, order = 2)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 3)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 20, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "pageCnt", length = 5, order = 5)
    public RString pageCnt;
    @ReportItem(name = "shisetsuMei", length = 30, order = 6)
    public RString shisetsuMei;
    @ReportItem(name = "listMeisai_1", length = 16, order = 7)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 6, order = 8)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 6, order = 9)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 6, order = 10)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisaiDairi_1", length = 6, order = 11)
    public RString listMeisaiDairi_1;
    @ReportItem(name = "listMeisaiTenji_1", length = 6, order = 12)
    public RString listMeisaiTenji_1;
    @ReportItem(name = "listMeisaiDairi_2", length = 6, order = 13)
    public RString listMeisaiDairi_2;
    @ReportItem(name = "listMeisaiTenji_2", length = 6, order = 14)
    public RString listMeisaiTenji_2;
    @ReportItem(name = "listMeisaiDairi_3", length = 6, order = 15)
    public RString listMeisaiDairi_3;
    @ReportItem(name = "listMeisaiTenji_3", length = 6, order = 16)
    public RString listMeisaiTenji_3;
    @ReportItem(name = "sakuseiJoken1", length = 70, order = 17)
    public RString sakuseiJoken1;
    @ReportItem(name = "sakuseiJoken2", length = 70, order = 18)
    public RString sakuseiJoken2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "senkyoNo", length = 70, order = 19)
    public RString senkyoNo;
    @ReportItem(name = "shisetsuCode", length = 70, order = 20)
    public RString shisetsuCode;

    /**
     * 期日前投票日報エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        shichosonCode,
        shichosonMei,
        senkyoMei,
        sakuseiYmdTime,
        pageCnt,
        shisetsuMei,
        listMeisai_1,
        listMeisai_2,
        listMeisai_3,
        listMeisai_4,
        listMeisaiDairi_1,
        listMeisaiTenji_1,
        listMeisaiDairi_2,
        listMeisaiTenji_2,
        listMeisaiDairi_3,
        listMeisaiTenji_3,
        sakuseiJoken1,
        sakuseiJoken2,
        senkyoNo,
        shisetsuCode;
    }
// </editor-fold>
}
