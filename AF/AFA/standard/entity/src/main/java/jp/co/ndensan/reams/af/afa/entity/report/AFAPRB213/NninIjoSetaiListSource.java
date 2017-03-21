package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * n人以上世帯一覧表のReportSourceです。
 *
 * @reamsid_L AF-0160-030 lis2
 */
public class NninIjoSetaiListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiNichiji", length = 30, order = 4)
    public RString sakuseiNichiji;
    @ReportItem(name = "listMeisai_1", length = 4, order = 5)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 11, order = 6)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 20, order = 7)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 12, order = 8)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 12, order = 9)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 3, order = 10)
    public RString listMeisai_6;
    @ReportItem(name = "taishoKikan", length = 80, order = 11)
    public RString taishoKikan;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * n人以上世帯一覧表エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        title,
        shichosonCode,
        shichosonMei,
        sakuseiNichiji,
        listMeisai_1,
        listMeisai_2,
        listMeisai_3,
        listMeisai_4,
        listMeisai_5,
        listMeisai_6,
        taishoKikan;
    }
// </editor-fold>
}
