package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * ラベルシール（専用ラベル）ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealSource implements IReportSource {

    @ReportItem(name = "title1", length = 12, order = 1)
    public RString title1;
    @ReportItem(name = "naiyo1", length = 20, order = 2)
    public RString naiyo1;
    @ReportItem(name = "shoNaiyo1", length = 42, order = 3)
    public RString shoNaiyo1;
    @ReportItem(name = "title2", length = 12, order = 4)
    public RString title2;
    @ReportItem(name = "naiyo2", length = 20, order = 5)
    public RString naiyo2;
    @ReportItem(name = "shoNaiyo2", length = 42, order = 6)
    public RString shoNaiyo2;
    @ReportItem(name = "shoNaiyo3", length = 42, order = 7)
    public RString shoNaiyo3;
    @ReportItem(name = "title3", length = 12, order = 8)
    public RString title3;
    @ReportItem(name = "naiyo3", length = 20, order = 9)
    public RString naiyo3;
    @ReportItem(name = "shoNaiyo4", length = 42, order = 10)
    public RString shoNaiyo4;
    @ReportItem(name = "shoNaiyo5", length = 42, order = 11)
    public RString shoNaiyo5;
    @ReportItem(name = "title4", length = 12, order = 12)
    public RString title4;
    @ReportItem(name = "naiyo4", length = 20, order = 13)
    public RString naiyo4;
    @ReportItem(name = "title5", length = 12, order = 14)
    public RString title5;
    @ReportItem(name = "naiyo5", length = 20, order = 15)
    public RString naiyo5;
    @ReportItem(name = "barcodeBarcode", order = 16)
    public RString barcodeBarcode;
    @ReportItem(name = "code", length = 20, order = 17)
    public RString code;
    @ReportItem(name = "kanaMeisho", order = 99)
    public RString kanaMeisho;
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
// </editor-fold>
}
