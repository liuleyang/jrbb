package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA101;

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
 * 永久選挙人名簿ソース（自動生成）です。
 */
public class EikyuMeiboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hyojiRiyu1", length = 14, order = 1)
    public RString hyojiRiyu1;
    @ReportItem(name = "hyojiRiyu2", length = 20, order = 2)
    public RString hyojiRiyu2;
    @ReportItem(name = "jusho1", length = 20, order = 3)
    public RString jusho1;
    @ReportItem(name = "hyojiYmd", length = 11, order = 4)
    public RString hyojiYmd;
    @ReportItem(name = "jusho2", length = 20, order = 5)
    public RString jusho2;
    @ReportItem(name = "jusho3", length = 20, order = 6)
    public RString jusho3;
    @ReportItem(name = "masshoRiyu1", length = 14, order = 7)
    public RString masshoRiyu1;
    @ReportItem(name = "masshoRiyu2", length = 20, order = 8)
    public RString masshoRiyu2;
    @ReportItem(name = "masshoYmd", length = 11, order = 9)
    public RString masshoYmd;
    @ReportItem(name = "shimeiKana1", length = 40, order = 10)
    public RString shimeiKana1;
    @ReportItem(name = "shimeiKana2", length = 60, order = 11)
    public RString shimeiKana2;
    @ReportItem(name = "zenJusho3", length = 17, order = 12)
    public RString zenJusho3;
    @ReportItem(name = "shimei2", length = 20, order = 13)
    public RString shimei2;
    @ReportItem(name = "zenJusho1", length = 17, order = 14)
    public RString zenJusho1;
    @ReportItem(name = "zenJusho4", length = 17, order = 15)
    public RString zenJusho4;
    @ReportItem(name = "shimei1", length = 16, order = 16)
    public RString shimei1;
    @ReportItem(name = "zenJusho2", length = 17, order = 17)
    public RString zenJusho2;
    @ReportItem(name = "shimei3", length = 20, order = 18)
    public RString shimei3;
    @ReportItem(name = "zenJusho5", length = 17, order = 19)
    public RString zenJusho5;
    @ReportItem(name = "sakiJusho3", length = 17, order = 20)
    public RString sakiJusho3;
    @ReportItem(name = "sakiJusho1", length = 17, order = 21)
    public RString sakiJusho1;
    @ReportItem(name = "sakiJusho4", length = 17, order = 22)
    public RString sakiJusho4;
    @ReportItem(name = "seinengappi", length = 11, order = 23)
    public RString seinengappi;
    @ReportItem(name = "seibetsu", length = 1, order = 24)
    public RString seibetsu;
    @ReportItem(name = "sakiJusho2", length = 17, order = 25)
    public RString sakiJusho2;
    @ReportItem(name = "sakiJusho5", length = 17, order = 26)
    public RString sakiJusho5;
    @ReportItem(name = "tennyuTodokeYmd", length = 11, order = 27)
    public RString tennyuTodokeYmd;
    @ReportItem(name = "tohyokuCode", length = 4, order = 28)
    public RString tohyokuCode;
    @ReportItem(name = "torokuYmd", length = 11, order = 29)
    public RString torokuYmd;
    @ReportItem(name = "chikuMei2", length = 15, order = 30)
    public RString chikuMei2;
    @ReportItem(name = "chikuMeisho", length = 5, order = 31)
    public RString chikuMeisho;
    @ReportItem(name = "chikuMei1", length = 15, order = 32)
    public RString chikuMei1;
    @ReportItem(name = "chikuMei3", length = 15, order = 33)
    public RString chikuMei3;
    @ReportItem(name = "zokugara2", length = 10, order = 34)
    public RString zokugara2;
    @ReportItem(name = "setainushiMei2", length = 15, order = 35)
    public RString setainushiMei2;
    @ReportItem(name = "setainushiMei1", length = 12, order = 36)
    public RString setainushiMei1;
    @ReportItem(name = "zokugara1", length = 10, order = 37)
    public RString zokugara1;
    @ReportItem(name = "zokugara3", length = 10, order = 38)
    public RString zokugara3;
    @ReportItem(name = "setainushiMei3", length = 15, order = 39)
    public RString setainushiMei3;
    @ReportItem(name = "jushoCode", length = 11, order = 40)
    public RString jushoCode;
    @ReportItem(name = "codeMei1", length = 5, order = 41)
    public RString codeMei1;
    @ReportItem(name = "code1", length = 15, order = 42)
    public RString code1;
    @ReportItem(name = "gyoseikuCode", length = 9, order = 43)
    public RString gyoseikuCode;
    @ReportItem(name = "codeMei2", length = 5, order = 44)
    public RString codeMei2;
    @ReportItem(name = "code2", length = 15, order = 45)
    public RString code2;
    @ReportItem(name = "shichosonCode", length = 6, order = 46)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 47)
    public RString shichosonMei;
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
