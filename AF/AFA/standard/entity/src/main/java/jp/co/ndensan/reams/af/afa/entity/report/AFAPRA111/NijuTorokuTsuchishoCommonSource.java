/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
 * 二重登録通知書明細共通の項目定義
 */
public class NijuTorokuTsuchishoCommonSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //NijuTorokuTsuchishoSourceのフォームファイルのソース
    @ReportItem(name = "listShimei1_1", length = 12, order = 1)
    public RString listShimei1_1;
    @ReportItem(name = "listShimei2_1", length = 12, order = 2)
    public RString listShimei2_1;
    @ReportItem(name = "listShimei3_1", length = 12, order = 3)
    public RString listShimei3_1;
    @ReportItem(name = "listYmd_1", length = 10, order = 4)
    public RString listYmd_1;
    @ReportItem(name = "listYmd_2", length = 1, order = 5)
    public RString listYmd_2;
    @ReportItem(name = "listYmd_3", length = 10, order = 6)
    public RString listYmd_3;
    @ReportItem(name = "listJusho1_1", length = 20, order = 7)
    public RString listJusho1_1;
    @ReportItem(name = "listJusho2_1", length = 20, order = 8)
    public RString listJusho2_1;
    @ReportItem(name = "listJusho3_1", length = 20, order = 9)
    public RString listJusho3_1;
    @ReportItem(name = "tennyuMotoYubinNo", length = 10, order = 10)
    public RString tennyuMotoYubinNo;
    @ReportItem(name = "hakkoDaino", length = 42, order = 11)
    public RString hakkoDaino;
    @ReportItem(name = "hakkoYmd", length = 11, order = 12)
    public RString hakkoYmd;
    @ReportItem(name = "tennyuMotoShichosonMei2", length = 26, order = 13)
    public RString tennyuMotoShichosonMei2;
    @ReportItem(name = "tennyuMotoShichosonMei1", length = 13, order = 14)
    public RString tennyuMotoShichosonMei1;
    @ReportItem(name = "shichosonMei2", length = 26, order = 15)
    public RString shichosonMei2;
    @ReportItem(name = "shichosonMei1", length = 11, order = 16)
    public RString shichosonMei1;
    @ReportItem(name = "barcodeCustombarcode", order = 17)
    public RString barcodeCustombarcode;
    @ReportItem(name = "iinchomei1", length = 16, order = 18)
    public RString iinchomei1;
    @ReportItem(name = "iinchomei2", length = 12, order = 19)
    public RString iinchomei2;
    @ReportItem(name = "koinShoryaku", length = 6, order = 20)
    public RString koinShoryaku;
    @ReportItem(name = "todokedeKaishiYmd", length = 11, order = 21)
    public RString todokedeKaishiYmd;
    @ReportItem(name = "todokedeShuryoYmd", length = 11, order = 22)
    public RString todokedeShuryoYmd;
    @ReportItem(name = "shichosonKubunMei", length = 2, order = 23)
    public RString shichosonKubunMei;
    @ReportItem(name = "senkyoMeisho", length = 45, order = 24)
    public RString senkyoMeisho;
    @ReportItem(name = "tennyuMotoPageCount", length = 6, order = 25)
    public RString tennyuMotoPageCount;

    //NijuTorokuTsuchishoMeisaiSourceのフォームファイルのソース
    @ReportItem(name = "tennyuMotoShichosonMei", length = 26, order = 26)
    public RString tennyuMotoShichosonMei;

    @ReportItem(name = "shiMei", length = 24, order = 28) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString shiMei;
    @ReportItem(name = "juSho", length = 40, order = 29) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString juSho;
    @ReportItem(name = "tennyuZanTop5", order = 30) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString tennyuZanTop5;
    @ReportItem(name = "shikibetsuCode", order = 31) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString shikibetsuCode;
    @ReportItem(name = "layout", order = 32) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public RString layout;                    //型は独自に作成したenumにしている。

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS; //ブレイク処理クラスを作成する際に必要になる。(ブレイク処理クラスの実装時に作れば問題ない。)

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }

    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード1;
    @ReportKojinNo(id = "X")
    public KojinNo 個人番号使用;
    @ReportHojinNo(id = "X")
    public HojinNo 法人番号使用;

    public enum ReportSourceFields {

        tennyuZanTop5
    }
}
