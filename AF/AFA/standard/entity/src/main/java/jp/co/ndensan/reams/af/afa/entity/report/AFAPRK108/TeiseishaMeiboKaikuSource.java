package jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108;

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
 * 訂正者名簿ソースクラス（自動生成）です。
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "subTitle", length = 10, order = 1)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "meisaiTitleYmd", length = 5, order = 5)
    public RString meisaiTitleYmd;
    @ReportItem(name = "listTeiseiAfterMeisai1_1", length = 4, order = 6)
    public RString listTeiseiAfterMeisai1_1;
    @ReportItem(name = "listTeiseiAfterMeisai1_2", length = 11, order = 7)
    public RString listTeiseiAfterMeisai1_2;
    @ReportItem(name = "listTeiseiAfterMeisai1_3", length = 15, order = 8)
    public RString listTeiseiAfterMeisai1_3;
    @ReportItem(name = "listTeiseiAfterMeisai1_4", length = 39, order = 9)
    public RString listTeiseiAfterMeisai1_4;
    @ReportItem(name = "listTeiseiAfterMeisai1_5", length = 12, order = 10)
    public RString listTeiseiAfterMeisai1_5;
    @ReportItem(name = "listTeiseiAfterMeisai1_6", length = 1, order = 11)
    public RString listTeiseiAfterMeisai1_6;
    @ReportItem(name = "listTeiseiAfterMeisai1_7", length = 10, order = 12)
    public RString listTeiseiAfterMeisai1_7;
    @ReportItem(name = "listTeiseiAfterMeisai1_8", length = 10, order = 13)
    public RString listTeiseiAfterMeisai1_8;
    @ReportItem(name = "listTeiseiAfterMeisai1_9", length = 10, order = 14)
    public RString listTeiseiAfterMeisai1_9;
    @ReportItem(name = "listTeiseiAfterMeisai1_10", length = 10, order = 15)
    public RString listTeiseiAfterMeisai1_10;
    @ReportItem(name = "chikuCodeMei", length = 6, order = 16)
    public RString chikuCodeMei;
    @ReportItem(name = "chikuMei", length = 5, order = 17)
    public RString chikuMei;
    @ReportItem(name = "listTeiseiAfterMeisai2_1", length = 4, order = 18)
    public RString listTeiseiAfterMeisai2_1;
    @ReportItem(name = "listTeiseiBeforeMeisai1_1", length = 4, order = 19)
    public RString listTeiseiBeforeMeisai1_1;
    @ReportItem(name = "listTeiseiAfterMeisai2_2", length = 9, order = 20)
    public RString listTeiseiAfterMeisai2_2;
    @ReportItem(name = "listTeiseiBeforeMeisai1_2", length = 11, order = 21)
    public RString listTeiseiBeforeMeisai1_2;
    @ReportItem(name = "listTeiseiAfterMeisai2_3", length = 15, order = 22)
    public RString listTeiseiAfterMeisai2_3;
    @ReportItem(name = "listTeiseiBeforeMeisai1_3", length = 15, order = 23)
    public RString listTeiseiBeforeMeisai1_3;
    @ReportItem(name = "listTeiseiAfterMeisai2_4", length = 39, order = 24)
    public RString listTeiseiAfterMeisai2_4;
    @ReportItem(name = "listTeiseiBeforeMeisai1_4", length = 39, order = 25)
    public RString listTeiseiBeforeMeisai1_4;
    @ReportItem(name = "listTeiseiAfterMeisai2_5", length = 14, order = 26)
    public RString listTeiseiAfterMeisai2_5;
    @ReportItem(name = "listTeiseiBeforeMeisai1_5", length = 12, order = 27)
    public RString listTeiseiBeforeMeisai1_5;
    @ReportItem(name = "listTeiseiAfterMeisai2_6", length = 3, order = 28)
    public RString listTeiseiAfterMeisai2_6;
    @ReportItem(name = "listTeiseiBeforeMeisai1_6", length = 1, order = 29)
    public RString listTeiseiBeforeMeisai1_6;
    @ReportItem(name = "listTeiseiAfterMeisai2_7", length = 3, order = 30)
    public RString listTeiseiAfterMeisai2_7;
    @ReportItem(name = "listTeiseiBeforeMeisai1_7", length = 10, order = 31)
    public RString listTeiseiBeforeMeisai1_7;
    @ReportItem(name = "listTeiseiAfterMeisai2_8", length = 10, order = 32)
    public RString listTeiseiAfterMeisai2_8;
    @ReportItem(name = "listTeiseiBeforeMeisai1_8", length = 10, order = 33)
    public RString listTeiseiBeforeMeisai1_8;
    @ReportItem(name = "listTeiseiBeforeMeisai1_9", length = 10, order = 34)
    public RString listTeiseiBeforeMeisai1_9;
    @ReportItem(name = "listTeiseiBeforeMeisai1_10", length = 10, order = 35)
    public RString listTeiseiBeforeMeisai1_10;
    @ReportItem(name = "listTeiseiBeforeMeisai2_1", length = 4, order = 36)
    public RString listTeiseiBeforeMeisai2_1;
    @ReportItem(name = "listTeiseiBeforeMeisai2_2", length = 9, order = 37)
    public RString listTeiseiBeforeMeisai2_2;
    @ReportItem(name = "listTeiseiBeforeMeisai2_3", length = 15, order = 38)
    public RString listTeiseiBeforeMeisai2_3;
    @ReportItem(name = "listTeiseiBeforeMeisai2_4", length = 39, order = 39)
    public RString listTeiseiBeforeMeisai2_4;
    @ReportItem(name = "listTeiseiBeforeMeisai2_5", length = 14, order = 40)
    public RString listTeiseiBeforeMeisai2_5;
    @ReportItem(name = "listTeiseiBeforeMeisai2_6", length = 3, order = 41)
    public RString listTeiseiBeforeMeisai2_6;
    @ReportItem(name = "listTeiseiBeforeMeisai2_7", length = 3, order = 42)
    public RString listTeiseiBeforeMeisai2_7;
    @ReportItem(name = "listTeiseiBeforeMeisai2_8", length = 10, order = 43)
    public RString listTeiseiBeforeMeisai2_8;
    @ReportItem(name = "selHani", length = 80, order = 44)
    public RString selHani;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
// </editor-fold>
}
