package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA107;

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
 * 帰化対象者リストソース（自動生成）です。
 */
public class KikaTaishoshaListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kisaiYmdHani", length = 38, order = 1)
    public RString kisaiYmdHani;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "chikuCodeMei", length = 6, order = 5)
    public RString chikuCodeMei;
    @ReportItem(name = "chikuMei", length = 5, order = 6)
    public RString chikuMei;
    @ReportItem(name = "listMeisai1_1", length = 4, order = 7)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 11, order = 8)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 15, order = 9)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 39, order = 10)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai1_5", length = 15, order = 11)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai1_6", length = 1, order = 12)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai1_7", length = 10, order = 13)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai1_8", length = 10, order = 14)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai1_9", length = 10, order = 15)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai1_10", length = 14, order = 16)
    public RString listMeisai1_10;
    @ReportItem(name = "listMeisai1_11", length = 10, order = 17)
    public RString listMeisai1_11;
    @ReportItem(name = "listMeisai2_1", length = 4, order = 18)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 9, order = 19)
    public RString listMeisai2_2;
    @ReportItem(name = "listMeisai2_3", length = 15, order = 20)
    public RString listMeisai2_3;
    @ReportItem(name = "listMeisai2_4", length = 23, order = 21)
    public RString listMeisai2_4;
    @ReportItem(name = "listMeisai2_5", length = 15, order = 22)
    public RString listMeisai2_5;
    @ReportItem(name = "listMeisai2_6", length = 2, order = 23)
    public RString listMeisai2_6;
    @ReportItem(name = "listMeisai2_7", length = 10, order = 24)
    public RString listMeisai2_7;
    @ReportItem(name = "listMeisai2_8", length = 10, order = 25)
    public RString listMeisai2_8;
    @ReportItem(name = "listMeisai2_9", length = 10, order = 26)
    public RString listMeisai2_9;
    @ReportItem(name = "listMeisai2_10", length = 14, order = 27)
    public RString listMeisai2_10;
    @ReportItem(name = "listMeisai2_11", length = 10, order = 28)
    public RString listMeisai2_11;
    @ReportItem(name = "listChiku_1", length = 10, order = 29)
    public RString listChiku_1;
    @ReportItem(name = "selHani", length = 80, order = 30)
    public RString selHani;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>
}
