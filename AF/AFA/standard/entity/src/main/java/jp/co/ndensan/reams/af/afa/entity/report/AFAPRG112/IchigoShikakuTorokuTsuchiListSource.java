package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 1号資格登録通知一覧表帳票出力のソース（自動生成）です。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 25, order = 1)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "senkyoMei", length = 20, order = 4)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 5)
    public RString sakuseiYmdTime;
    @ReportItem(name = "headJushoName", length = 7, order = 6)
    public RString headJushoName;
    @ReportItem(name = "headYmdName", length = 5, order = 7)
    public RString headYmdName;
    @ReportItem(name = "listMeisai_1", length = 18, order = 8)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 10, order = 9)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 1, order = 10)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 43, order = 11)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 10, order = 12)
    public RString listMeisai_5;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportItem(name = "tennyuZanTop5", order = 30) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    
    /**
     * ReportSourceFiledsのEnum
     */
    public enum ReportSourceFileds {

        /**
         * 転入前全国住所コード
         */
        tennyuZanTop5;
    }
}
