package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE519;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 送致書帳票出力ののソース（自動生成）です。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class SochishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kaiPage", length = 5, order = 1)
    public RString kaiPage;
    @ReportItem(name = "sakuseiYmd", length = 11, order = 2)
    public RString sakuseiYmd;
    @ReportItem(name = "kanrishaMei1", length = 15, order = 3)
    public RString kanrishaMei1;
    @ReportItem(name = "kanrishaMei2", length = 19, order = 4)
    public RString kanrishaMei2;
    @ReportItem(name = "tohyokuCode", length = 4, order = 5)
    public RString tohyokuCode;
    @ReportItem(name = "honbun1", length = 42, order = 6)
    public RString honbun1;
    @ReportItem(name = "honbun2", length = 42, order = 7)
    public RString honbun2;
    @ReportItem(name = "torokuSuMan", length = 9, order = 8)
    public RString torokuSuMan;
    @ReportItem(name = "yukenshaSuMan", length = 9, order = 9)
    public RString yukenshaSuMan;
    @ReportItem(name = "fuzaishaSuMan", length = 9, order = 10)
    public RString fuzaishaSuMan;
    @ReportItem(name = "torokuSuWoman", length = 9, order = 11)
    public RString torokuSuWoman;
    @ReportItem(name = "yukenshaSuWoman", length = 9, order = 12)
    public RString yukenshaSuWoman;
    @ReportItem(name = "fuzaishaSuWoman", length = 9, order = 13)
    public RString fuzaishaSuWoman;
    @ReportItem(name = "torokuSuKei", length = 9, order = 14)
    public RString torokuSuKei;
    @ReportItem(name = "yukenshaSuKei", length = 9, order = 15)
    public RString yukenshaSuKei;
    @ReportItem(name = "fuzaishaSuKei", length = 9, order = 16)
    public RString fuzaishaSuKei;
    @ReportItem(name = "tohyoYoshiSu", length = 9, order = 17)
    public RString tohyoYoshiSu;
    @ReportItem(name = "tenjiTohyoSu", length = 9, order = 18)
    public RString tenjiTohyoSu;
    @ReportItem(name = "kariTohyoSu", length = 9, order = 19)
    public RString kariTohyoSu;
    @ReportItem(name = "senkyoNo", length = 9, order = 100)
    public RString senkyoNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFileds {

        /**
         * tohyokuCode
         */
        tohyokuCode,
        /**
         * senkyoNo
         */
        senkyoNo;
    }
}
