package jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 投票所入場券印刷枚数表のReportSourceです。
 *
 * @reamsid_L AF-0160-036 lis2
 */
public class NyujokenMaisuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonCode", length = 6, order = 1)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 2)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiNichiji", length = 30, order = 3)
    public RString sakuseiNichiji;
    @ReportItem(name = "shukeiTaniMeisho", length = 20, order = 4)
    public RString shukeiTaniMeisho;
    @ReportItem(name = "listMeisai_1", length = 12, order = 5)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 20, order = 6)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 11, order = 7)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 11, order = 8)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 11, order = 9)
    public RString listMeisai_5;
    @ReportItem(name = "taishoKikan", length = 80, order = 10)
    public RString taishoKikan;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * 投票所入場券印刷枚数表エンティティ枚挙クラス
     */
    public enum ReportSourceFields {

        shichosonCode,
        shichosonMei,
        sakuseiNichiji,
        shukeiTaniMeisho,
        listMeisai_1,
        listMeisai_2,
        listMeisai_3,
        listMeisai_4,
        listMeisai_5,
        taishoKikan;
    }
// </editor-fold>
}
