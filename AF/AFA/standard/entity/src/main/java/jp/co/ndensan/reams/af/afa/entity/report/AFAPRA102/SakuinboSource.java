package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA102;

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
 * 選挙人索引簿ソース（自動生成）です。
 */
public class SakuinboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "headTohyokuCode", length = 14, order = 1)
    public RString headTohyokuCode;
    @ReportItem(name = "headKana", length = 14, order = 2)
    public RString headKana;
    @ReportItem(name = "title", length = 14, order = 3)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 4)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 5)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiNichiji", length = 30, order = 6)
    public RString sakuseiNichiji;
    @ReportItem(name = "listMeisai_1", length = 12, order = 7)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 20, order = 8)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 20, order = 9)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 15, order = 10)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 15, order = 11)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 10, order = 12)
    public RString listMeisai_6;
    @ReportItem(name = "listMeisai_7", length = 10, order = 13)
    public RString listMeisai_7;
    @ReportItem(name = "listMeisai_8", length = 1, order = 14)
    public RString listMeisai_8;
    @ReportItem(name = "listMeisai_9", length = 2, order = 15)
    public RString listMeisai_9;
    @ReportItem(name = "listMeisai_10", length = 3, order = 16)
    public RString listMeisai_10;
    @ReportItem(name = "listMeisai_11", length = 17, order = 17)
    public RString listMeisai_11;
    @ReportItem(name = "taishoKikan", length = 80, order = 18)
    public RString taishoKikan;
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
