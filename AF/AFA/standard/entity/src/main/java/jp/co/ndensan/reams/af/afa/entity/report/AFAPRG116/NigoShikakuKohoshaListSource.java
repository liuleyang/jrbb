/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRG116;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 2号資格候補者一覧表出力のソース（自動生成）です
 *
 * @reamsid_L AF-0360-063 fulc
 */
public class NigoShikakuKohoshaListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonMei", length = 12, order = 1)
    public RString shichosonMei;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "senkyoMei", length = 20, order = 3)
    public RString senkyoMei;
    @ReportItem(name = "sakuseiYmdTime", length = 30, order = 4)
    public RString sakuseiYmdTime;
    @ReportItem(name = "listMeisai_1", length = 5, order = 5)
    public RString listMeisai_1;
    @ReportItem(name = "listMeisai_2", length = 10, order = 6)
    public RString listMeisai_2;
    @ReportItem(name = "listMeisai_3", length = 16, order = 7)
    public RString listMeisai_3;
    @ReportItem(name = "listMeisai_4", length = 10, order = 8)
    public RString listMeisai_4;
    @ReportItem(name = "listMeisai_5", length = 1, order = 9)
    public RString listMeisai_5;
    @ReportItem(name = "listMeisai_6", length = 43, order = 10)
    public RString listMeisai_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "shikibetsuCode", order = 66)
    @ReportPerson(id = "X")
    public RString shikibetsuCode;
    @ReportItem(name = "realPage", order = 67)
    public RString realPage;
    @ReportItem(name = "listJusho", length = 108, order = 68)
    public RString listJusho;
// </editor-fold>
}
