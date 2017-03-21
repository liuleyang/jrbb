/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503;

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
 * 投票者一覧表ソース（自動生成）です。
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiJoken1", length = 80, order = 1)
    public RString sakuseiJoken1;
    @ReportItem(name = "gokeiArea1", length = 40, order = 2)
    public RString gokeiArea1;
    @ReportItem(name = "sakuseiJoken2", length = 80, order = 3)
    public RString sakuseiJoken2;
    @ReportItem(name = "gokeiArea2", length = 40, order = 4)
    public RString gokeiArea2;
    @ReportItem(name = "pagecnt", length = 5, order = 5)
    public RString pagecnt;
    @ReportItem(name = "title", length = 13, order = 6)
    public RString title;
    @ReportItem(name = "subTitle", length = 8, order = 7)
    public RString subTitle;
    @ReportItem(name = "shichosonCode", length = 6, order = 8)
    public RString shichosonCode;
    @ReportItem(name = "shichosonMei", length = 12, order = 9)
    public RString shichosonMei;
    @ReportItem(name = "tohyokuCode", length = 4, order = 10)
    public RString tohyokuCode;
    @ReportItem(name = "tohyokuMei", length = 20, order = 11)
    public RString tohyokuMei;
    @ReportItem(name = "sakuseiYmdTime", length = 29, order = 12)
    public RString sakuseiYmdTime;
    @ReportItem(name = "senkyo1", length = 2, order = 13)
    public RString senkyo1;
    @ReportItem(name = "senkyo2", length = 2, order = 14)
    public RString senkyo2;
    @ReportItem(name = "senkyo3", length = 2, order = 15)
    public RString senkyo3;
    @ReportItem(name = "senkyo4", length = 2, order = 16)
    public RString senkyo4;
    @ReportItem(name = "senkyo5", length = 2, order = 17)
    public RString senkyo5;
    @ReportItem(name = "senkyo6", length = 2, order = 18)
    public RString senkyo6;
    @ReportItem(name = "senkyo7", length = 2, order = 19)
    public RString senkyo7;
    @ReportItem(name = "senkyo8", length = 2, order = 20)
    public RString senkyo8;
    @ReportItem(name = "lblDate1", length = 6, order = 21)
    public RString lblDate1;
    @ReportItem(name = "senkyo9", length = 2, order = 22)
    public RString senkyo9;
    @ReportItem(name = "lblDate2", length = 6, order = 23)
    public RString lblDate2;
    @ReportItem(name = "listMeisai1_1", length = 8, order = 24)
    public RString listMeisai1_1;
    @ReportItem(name = "listMeisai1_2", length = 14, order = 25)
    public RString listMeisai1_2;
    @ReportItem(name = "listMeisai1_3", length = 18, order = 26)
    public RString listMeisai1_3;
    @ReportItem(name = "listMeisai1_4", length = 1, order = 27)
    public RString listMeisai1_4;
    @ReportItem(name = "listMeisai1_5", length = 3, order = 28)
    public RString listMeisai1_5;
    @ReportItem(name = "listMeisai1_6", length = 1, order = 29)
    public RString listMeisai1_6;
    @ReportItem(name = "listMeisai1_7", length = 16, order = 30)
    public RString listMeisai1_7;
    @ReportItem(name = "listMeisai1_8", length = 1, order = 31)
    public RString listMeisai1_8;
    @ReportItem(name = "listMeisai1_9", length = 1, order = 32)
    public RString listMeisai1_9;
    @ReportItem(name = "listMeisai1_10", length = 1, order = 33)
    public RString listMeisai1_10;
    @ReportItem(name = "listMeisai1_11", length = 1, order = 34)
    public RString listMeisai1_11;
    @ReportItem(name = "listMeisai1_12", length = 1, order = 35)
    public RString listMeisai1_12;
    @ReportItem(name = "listMeisai1_13", length = 1, order = 36)
    public RString listMeisai1_13;
    @ReportItem(name = "listMeisai1_14", length = 1, order = 37)
    public RString listMeisai1_14;
    @ReportItem(name = "listMeisai1_15", length = 1, order = 38)
    public RString listMeisai1_15;
    @ReportItem(name = "listMeisai1_16", length = 1, order = 39)
    public RString listMeisai1_16;
    @ReportItem(name = "listMeisai1_17", length = 9, order = 40)
    public RString listMeisai1_17;
    @ReportItem(name = "listMeisai1_18", length = 5, order = 41)
    public RString listMeisai1_18;
    @ReportItem(name = "listMeisai2_1", length = 9, order = 42)
    public RString listMeisai2_1;
    @ReportItem(name = "listMeisai2_2", length = 9, order = 43)
    public RString listMeisai2_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportItem(name = "key1", order = 44)
    public RString key1;
    @ReportItem(name = "key2", order = 45)
    public RString key2;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;
}
