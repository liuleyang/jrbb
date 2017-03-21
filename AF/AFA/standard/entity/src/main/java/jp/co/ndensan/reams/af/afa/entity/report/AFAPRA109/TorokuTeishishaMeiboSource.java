package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 登録停止者名簿Itemクラスです。
 *
 */
public class TorokuTeishishaMeiboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonMei", length = 12, order = 1)
    public RString shichosonMei;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 3)
    public RString sakuseiYmdTime;
    @ReportItem(name = "chikuCodeMei", length = 6, order = 4)
    public RString chikuCodeMei;
    @ReportItem(name = "chikuMei", length = 5, order = 5)
    public RString chikuMei;
    @ReportItem(name = "listMeisai1_1", length = 4, order = 6)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 15, order = 7)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 36, order = 8)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 11, order = 9)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai1_5", length = 40, order = 10)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai1_6", length = 10, order = 11)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai1_7", length = 17, order = 12)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 13)
    public RString listMeisai2_1;
    @ReportPerson(id = "X")
    @ReportItem(name = "listMeisai2_2", length = 15, order = 14)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 11, order = 15)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 9, order = 16)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai2_5", length = 15, order = 17)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai2_6", length = 10, order = 18)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai2_7", length = 16, order = 19)
    public RString listMeisai2_7;
    @ReportItem(name = "listMeisai2_8", length = 1, order = 20)
    public RString listMeisai2_8;
    @ReportItem(name = "listMeisai2_9", length = 10, order = 21)
    public RString listMeisai2_9;
    @ReportItem(name = "listMeisai2_10", length = 17, order = 22)
    public RString listMeisai2_10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
