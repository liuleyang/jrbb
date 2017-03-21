package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 期日前投票録ソース（自動生成）です。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //１枚のフォームファイルの一ページソース
    @ReportItem(name = "title", length = 29, order = 1)
    public RString title;
    @ReportItem(name = "shikkoYmd", length = 11, order = 2)
    public RString shikkoYmd;
    @ReportItem(name = "tohyoYmd", length = 11, order = 3)
    public RString tohyoYmd;
    @ReportItem(name = "secchJjokyo", length = 31, order = 4)
    public RString secchJjokyo;
    @ReportItem(name = "tohyoBasho", length = 31, order = 5)
    public RString tohyoBasho;
    @ReportItem(name = "tohyoKikan", length = 31, order = 6)
    public RString tohyoKikan;
    @ReportItem(name = "toha1", length = 6, order = 7)
    public RString toha1;
    @ReportItem(name = "shimei1", length = 15, order = 8)
    public RString shimei1;
    @ReportItem(name = "senninYmd1", length = 10, order = 9)
    public RString senninYmd1;
    @ReportItem(name = "tachiaiJikan1", length = 12, order = 10)
    public RString tachiaiJikan1;
    @ReportItem(name = "sankaiJikoku1", length = 5, order = 11)
    public RString sankaiJikoku1;
    @ReportItem(name = "jishokuJikoku1", length = 5, order = 12)
    public RString jishokuJikoku1;
    @ReportItem(name = "jishokuRiyu1", length = 6, order = 13)
    public RString jishokuRiyu1;
    @ReportItem(name = "toha2", length = 6, order = 14)
    public RString toha2;
    @ReportItem(name = "shimei2", length = 15, order = 15)
    public RString shimei2;
    @ReportItem(name = "senninYmd2", length = 10, order = 16)
    public RString senninYmd2;
    @ReportItem(name = "tachiaiJikan2", length = 12, order = 17)
    public RString tachiaiJikan2;
    @ReportItem(name = "sankaiJikoku2", length = 5, order = 18)
    public RString sankaiJikoku2;
    @ReportItem(name = "jishokuJikoku2", length = 5, order = 19)
    public RString jishokuJikoku2;
    @ReportItem(name = "jishokuRiyu2", length = 6, order = 20)
    public RString jishokuRiyu2;
    @ReportItem(name = "toha3", length = 6, order = 21)
    public RString toha3;
    @ReportItem(name = "shimei3", length = 15, order = 22)
    public RString shimei3;
    @ReportItem(name = "senninYmd3", length = 10, order = 23)
    public RString senninYmd3;
    @ReportItem(name = "tachiaiJikan3", length = 12, order = 24)
    public RString tachiaiJikan3;
    @ReportItem(name = "sankaiJikoku3", length = 5, order = 25)
    public RString sankaiJikoku3;
    @ReportItem(name = "jishokuJikoku3", length = 5, order = 26)
    public RString jishokuJikoku3;
    @ReportItem(name = "jishokuRiyu3", length = 6, order = 27)
    public RString jishokuRiyu3;
    @ReportItem(name = "toha4", length = 6, order = 28)
    public RString toha4;
    @ReportItem(name = "shimei4", length = 15, order = 29)
    public RString shimei4;
    @ReportItem(name = "senninYmd4", length = 10, order = 30)
    public RString senninYmd4;
    @ReportItem(name = "tachiaiJikan4", length = 12, order = 31)
    public RString tachiaiJikan4;
    @ReportItem(name = "sankaiJikoku4", length = 5, order = 32)
    public RString sankaiJikoku4;
    @ReportItem(name = "jishokuJikoku4", length = 5, order = 33)
    public RString jishokuJikoku4;
    @ReportItem(name = "jishokuRiyu4", length = 6, order = 34)
    public RString jishokuRiyu4;
    @ReportItem(name = "toha5", length = 6, order = 35)
    public RString toha5;
    @ReportItem(name = "shimei5", length = 15, order = 36)
    public RString shimei5;
    @ReportItem(name = "senninYmd5", length = 10, order = 37)
    public RString senninYmd5;
    @ReportItem(name = "tachiaiJikan5", length = 12, order = 38)
    public RString tachiaiJikan5;
    @ReportItem(name = "sankaiJikoku5", length = 5, order = 39)
    public RString sankaiJikoku5;
    @ReportItem(name = "jishokuJikoku5", length = 5, order = 40)
    public RString jishokuJikoku5;
    @ReportItem(name = "jishokuRiyu5", length = 6, order = 41)
    public RString jishokuRiyu5;
    @ReportItem(name = "tToha1", length = 6, order = 42)
    public RString tToha1;
    @ReportItem(name = "tShimei1", length = 15, order = 43)
    public RString tShimei1;
    @ReportItem(name = "tSankaiJikoku1", length = 5, order = 44)
    public RString tSankaiJikoku1;
    @ReportItem(name = "tToha2", length = 6, order = 45)
    public RString tToha2;
    @ReportItem(name = "tShimei2", length = 15, order = 46)
    public RString tShimei2;
    @ReportItem(name = "tSankaiJikoku2", length = 5, order = 47)
    public RString tSankaiJikoku2;
    @ReportItem(name = "tToha3", length = 6, order = 48)
    public RString tToha3;
    @ReportItem(name = "tShimei3", length = 15, order = 49)
    public RString tShimei3;
    @ReportItem(name = "tSankaiJikoku3", length = 5, order = 50)
    public RString tSankaiJikoku3;
    @ReportItem(name = "tohyoJikokuStart", length = 8, order = 51)
    public RString tohyoJikokuStart;
    @ReportItem(name = "tohyoJikokuEnd", length = 8, order = 52)
    public RString tohyoJikokuEnd;
    @ReportItem(name = "tohyoshaMan", length = 9, order = 53)
    public RString tohyoshaMan;
    @ReportItem(name = "kariTohyoshaSuMan", length = 9, order = 54)
    public RString kariTohyoshaSuMan;
    @ReportItem(name = "tohyoshaWoman", length = 9, order = 55)
    public RString tohyoshaWoman;
    @ReportItem(name = "kariTohyoshaSuWoman", length = 9, order = 56)
    public RString kariTohyoshaSuWoman;
    @ReportItem(name = "tohyoshaKei", length = 9, order = 57)
    public RString tohyoshaKei;
    @ReportItem(name = "kariTohyoshaSuKei", length = 9, order = 58)
    public RString kariTohyoshaSuKei;
    @ReportItem(name = "saiKofusha1", length = 15, order = 59)
    public RString saiKofusha1;
    @ReportItem(name = "saiKofuJiyu1", length = 20, order = 60)
    public RString saiKofuJiyu1;
    @ReportItem(name = "saiKofusha2", length = 15, order = 61)
    public RString saiKofusha2;
    @ReportItem(name = "saiKofuJiyu2", length = 20, order = 62)
    public RString saiKofuJiyu2;
    @ReportItem(name = "ketteiTohyosha1", length = 10, order = 63)
    public RString ketteiTohyosha1;
    @ReportItem(name = "ketteiTohyosha2", length = 10, order = 64)
    public RString ketteiTohyosha2;
    @ReportItem(name = "ketteiTohyosha3", length = 10, order = 65)
    public RString ketteiTohyosha3;
    @ReportItem(name = "ketteiTohyosha4", length = 10, order = 66)
    public RString ketteiTohyosha4;
    @ReportItem(name = "ketteiTohyosha5", length = 10, order = 67)
    public RString ketteiTohyosha5;
    @ReportItem(name = "ketteiTohyosha6", length = 10, order = 68)
    public RString ketteiTohyosha6;
    @ReportItem(name = "ketteiTohyosha7", length = 10, order = 69)
    public RString ketteiTohyosha7;
    @ReportItem(name = "ketteiTohyosha8", length = 10, order = 70)
    public RString ketteiTohyosha8;
    @ReportItem(name = "henkansha1", length = 10, order = 71)
    public RString henkansha1;
    @ReportItem(name = "henkansha2", length = 10, order = 72)
    public RString henkansha2;
    @ReportItem(name = "henkansha3", length = 10, order = 73)
    public RString henkansha3;
    @ReportItem(name = "henkansha4", length = 10, order = 74)
    public RString henkansha4;
    @ReportItem(name = "henkansha5", length = 10, order = 75)
    public RString henkansha5;
    @ReportItem(name = "henkansha6", length = 10, order = 76)
    public RString henkansha6;
    @ReportItem(name = "henkansha7", length = 10, order = 77)
    public RString henkansha7;
    @ReportItem(name = "henkansha8", length = 10, order = 78)
    public RString henkansha8;
    @ReportItem(name = "tenji", length = 9, order = 79)
    public RString tenji;
    @ReportItem(name = "shuruiTitle", length = 3, order = 80)
    public RString shuruiTitle;
    @ReportItem(name = "listDairitohyo_1", length = 13, order = 81)
    public RString listDairitohyo_1;
    @ReportItem(name = "listDairitohyo_2", length = 13, order = 82)
    public RString listDairitohyo_2;
    @ReportItem(name = "listDairitohyo_3", length = 13, order = 83)
    public RString listDairitohyo_3;
    @ReportItem(name = "besshiUmu", length = 5, order = 84)
    public RString besshiUmu;
    @ReportItem(name = "dairiTohyoshaSu", length = 9, order = 85)
    public RString dairiTohyoshaSu;
    @ReportItem(name = "kyohiShimei1", length = 10, order = 86)
    public RString kyohiShimei1;
    @ReportItem(name = "kyohiJiyu1", length = 15, order = 87)
    public RString kyohiJiyu1;
    @ReportItem(name = "kariUmu1", length = 1, order = 88)
    public RString kariUmu1;
    @ReportItem(name = "kyohiShimei2", length = 10, order = 89)
    public RString kyohiShimei2;
    @ReportItem(name = "kyohiJiyu2", length = 15, order = 90)
    public RString kyohiJiyu2;
    @ReportItem(name = "kariUmu2", length = 1, order = 91)
    public RString kariUmu2;
    @ReportItem(name = "hoNo1", length = 2, order = 92)
    public RString hoNo1;
    @ReportItem(name = "kyohiShimei3", length = 10, order = 93)
    public RString kyohiShimei3;
    @ReportItem(name = "kyohiJiyu3", length = 15, order = 94)
    public RString kyohiJiyu3;
    @ReportItem(name = "kariUmu3", length = 1, order = 95)
    public RString kariUmu3;
    @ReportItem(name = "dKyohiShimei1", length = 10, order = 96)
    public RString dKyohiShimei1;
    @ReportItem(name = "dKyohiJiyu1", length = 15, order = 97)
    public RString dKyohiJiyu1;
    @ReportItem(name = "dKariUmu1", length = 1, order = 98)
    public RString dKariUmu1;
    @ReportItem(name = "dKyohiShimei2", length = 10, order = 99)
    public RString dKyohiShimei2;
    @ReportItem(name = "dKyohiJiyu2", length = 15, order = 100)
    public RString dKyohiJiyu2;
    @ReportItem(name = "dDariUmu2", length = 1, order = 101)
    public RString dDariUmu2;
    @ReportItem(name = "hoNo2", length = 2, order = 102)
    public RString hoNo2;
    @ReportItem(name = "dKyohiShimei3", length = 10, order = 103)
    public RString dKyohiShimei3;
    @ReportItem(name = "dKyohiJiyu3", length = 15, order = 104)
    public RString dKyohiJiyu3;
    @ReportItem(name = "dKariUmu3", length = 1, order = 105)
    public RString dKariUmu3;
    @ReportItem(name = "jimu1", length = 3, order = 106)
    public RString jimu1;
    @ReportItem(name = "jimuSosu", length = 5, order = 107)
    public RString jimuSosu;
    @ReportItem(name = "jimu2", length = 3, order = 108)
    public RString jimu2;
    @ReportItem(name = "jimu3", length = 3, order = 109)
    public RString jimu3;
    @ReportItem(name = "choseiYmd", length = 13, order = 110)
    public RString choseiYmd;

    //１枚のフォームファイルの二ページソース
    @ReportItem(name = "subTitle", length = 33, order = 201)
    public RString subTitle;
    @ReportItem(name = "tohyoShuruiTitle", length = 3, order = 202)
    public RString tohyoShuruiTitle;
    @ReportItem(name = "listNo_1", length = 2, order = 203)
    public RString listNo_1;
    @ReportItem(name = "listDairiTohyo_1", length = 15, order = 204)
    public RString listDairiTohyo_1;
    @ReportItem(name = "listDairiTohyo_2", length = 15, order = 205)
    public RString listDairiTohyo_2;
    @ReportItem(name = "listDairiTohyo_3", length = 15, order = 206)
    public RString listDairiTohyo_3;

    //3枚のフォームファイルの一ページソース
    @ReportItem(name = "secchiJokyo", length = 31, order = 301)
    public RString secchiJokyo;
    @ReportItem(name = "shimei1Jo", length = 10, order = 302)
    public RString shimei1Jo;
    @ReportItem(name = "senninYmd1Jo", length = 5, order = 303)
    public RString senninYmd1Jo;
    @ReportItem(name = "tachiaiJikan1Jo", length = 8, order = 304)
    public RString tachiaiJikan1Jo;
    @ReportItem(name = "shimei1Ge", length = 10, order = 305)
    public RString shimei1Ge;
    @ReportItem(name = "senninYmd1Ge", length = 6, order = 306)
    public RString senninYmd1Ge;
    @ReportItem(name = "tachiaiJikan1Ge", length = 10, order = 307)
    public RString tachiaiJikan1Ge;
    @ReportItem(name = "shimei2Jo", length = 10, order = 308)
    public RString shimei2Jo;
    @ReportItem(name = "senninYmd2Jo", length = 5, order = 309)
    public RString senninYmd2Jo;
    @ReportItem(name = "tachiaiJikan2Jo", length = 8, order = 310)
    public RString tachiaiJikan2Jo;
    @ReportItem(name = "shimei2Ge", length = 10, order = 311)
    public RString shimei2Ge;
    @ReportItem(name = "senninYmd2Ge", length = 6, order = 312)
    public RString senninYmd2Ge;
    @ReportItem(name = "tachiaiJikan2Ge", length = 10, order = 313)
    public RString tachiaiJikan2Ge;
    @ReportItem(name = "shimei3Jo", length = 10, order = 314)
    public RString shimei3Jo;
    @ReportItem(name = "senninYmd3Jo", length = 5, order = 315)
    public RString senninYmd3Jo;
    @ReportItem(name = "tachiaiJikan3Jo", length = 8, order = 316)
    public RString tachiaiJikan3Jo;
    @ReportItem(name = "shimei3Ge", length = 10, order = 317)
    public RString shimei3Ge;
    @ReportItem(name = "senninYmd3Ge", length = 6, order = 318)
    public RString senninYmd3Ge;
    @ReportItem(name = "tachiaiJikan3Ge", length = 10, order = 319)
    public RString tachiaiJikan3Ge;
    @ReportItem(name = "shimei4Jo", length = 10, order = 320)
    public RString shimei4Jo;
    @ReportItem(name = "senninYmd4Jo", length = 5, order = 321)
    public RString senninYmd4Jo;
    @ReportItem(name = "tachiaiJikan4Jo", length = 8, order = 322)
    public RString tachiaiJikan4Jo;
    @ReportItem(name = "shimei4Ge", length = 10, order = 323)
    public RString shimei4Ge;
    @ReportItem(name = "senninYmd4Ge", length = 6, order = 324)
    public RString senninYmd4Ge;
    @ReportItem(name = "tachiaiJikan4Ge", length = 10, order = 325)
    public RString tachiaiJikan4Ge;
    @ReportItem(name = "shimei5Jo", length = 10, order = 326)
    public RString shimei5Jo;
    @ReportItem(name = "senninYmd5Jo", length = 5, order = 327)
    public RString senninYmd5Jo;
    @ReportItem(name = "tachiaiJikan5Jo", length = 8, order = 328)
    public RString tachiaiJikan5Jo;
    @ReportItem(name = "shimei5Ge", length = 10, order = 329)
    public RString shimei5Ge;
    @ReportItem(name = "senninYmd5Ge", length = 6, order = 330)
    public RString senninYmd5Ge;
    @ReportItem(name = "tachiaiJikan5Ge", length = 10, order = 331)
    public RString tachiaiJikan5Ge;
    @ReportItem(name = "tShimei1Jo", length = 10, order = 332)
    public RString tShimei1Jo;
    @ReportItem(name = "tShimei1Ge", length = 10, order = 333)
    public RString tShimei1Ge;
    @ReportItem(name = "tShimei2Jo", length = 10, order = 334)
    public RString tShimei2Jo;
    @ReportItem(name = "tShimei2Ge", length = 10, order = 335)
    public RString tShimei2Ge;
    @ReportItem(name = "tShimei3Jo", length = 10, order = 336)
    public RString tShimei3Jo;
    @ReportItem(name = "tShimei3Ge", length = 10, order = 337)
    public RString tShimei3Ge;
    @ReportItem(name = "kariTohyoshaMan", length = 9, order = 338)
    public RString kariTohyoshaMan;
    @ReportItem(name = "kariTohyoshaWoman", length = 9, order = 339)
    public RString kariTohyoshaWoman;
    @ReportItem(name = "kariTohyoshaKei", length = 9, order = 340)
    public RString kariTohyoshaKei;

    //3枚のフォームファイルの二ページソース
    @ReportItem(name = "pageNo", length = 3, order = 400)
    public RString pageNo;
    @ReportItem(name = "listDairitohyoJo_1", length = 10, order = 401)
    public RString listDairitohyoJo_1;
    @ReportItem(name = "listDairitohyoJo_2", length = 10, order = 402)
    public RString listDairitohyoJo_2;
    @ReportItem(name = "listDairitohyoJo_3", length = 10, order = 403)
    public RString listDairitohyoJo_3;
    @ReportItem(name = "listDairitohyoGe_1", length = 10, order = 404)
    public RString listDairitohyoGe_1;
    @ReportItem(name = "listDairitohyoGe_2", length = 10, order = 405)
    public RString listDairitohyoGe_2;
    @ReportItem(name = "listDairitohyoGe_3", length = 10, order = 406)
    public RString listDairitohyoGe_3;

    //3枚のフォームファイルの三ページソース
    @ReportItem(name = "kyohiJiyu1Jo", length = 10, order = 501)
    public RString kyohiJiyu1Jo;
    @ReportItem(name = "kyohiJiyu1Ge", length = 10, order = 502)
    public RString kyohiJiyu1Ge;
    @ReportItem(name = "kyohiJiyu2Jo", length = 10, order = 503)
    public RString kyohiJiyu2Jo;
    @ReportItem(name = "houNo1", length = 2, order = 504)
    public RString houNo1;
    @ReportItem(name = "kyohiJiyu2Ge", length = 10, order = 505)
    public RString kyohiJiyu2Ge;
    @ReportItem(name = "kyohiJiyu3Jo", length = 10, order = 506)
    public RString kyohiJiyu3Jo;
    @ReportItem(name = "kyohiJiyu3Ge", length = 10, order = 507)
    public RString kyohiJiyu3Ge;
    @ReportItem(name = "dShimei1Jo", length = 10, order = 508)
    public RString dShimei1Jo;
    @ReportItem(name = "dKyohiJiyu1Jo", length = 10, order = 509)
    public RString dKyohiJiyu1Jo;
    @ReportItem(name = "dShimei1Ge", length = 10, order = 520)
    public RString dShimei1Ge;
    @ReportItem(name = "dKyohiJiyu1Ge", length = 10, order = 521)
    public RString dKyohiJiyu1Ge;
    @ReportItem(name = "dShimei2Jo", length = 10, order = 522)
    public RString dShimei2Jo;
    @ReportItem(name = "dKyohiJiyu2Jo", length = 10, order = 523)
    public RString dKyohiJiyu2Jo;
    @ReportItem(name = "houNo2", length = 2, order = 524)
    public RString houNo2;
    @ReportItem(name = "dKariUmu2", length = 1, order = 525)
    public RString dKariUmu2;
    @ReportItem(name = "dShimei2Ge", length = 10, order = 526)
    public RString dShimei2Ge;
    @ReportItem(name = "dKyohiJiyu2Ge", length = 10, order = 527)
    public RString dKyohiJiyu2Ge;
    @ReportItem(name = "dShimei3Jo", length = 10, order = 528)
    public RString dShimei3Jo;
    @ReportItem(name = "dKyohiJiyu3Jo", length = 10, order = 529)
    public RString dKyohiJiyu3Jo;
    @ReportItem(name = "dShimei3Ge", length = 10, order = 530)
    public RString dShimei3Ge;
    @ReportItem(name = "dKyohiJiyu3Ge", length = 10, order = 531)
    public RString dKyohiJiyu3Ge;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportItem(name = "layout", order = 999) //このソースファイルの中で最後になりそうなorderを振った。ソースファイルになった時に他の項目に紛れず見やすい。
    public Layouts layout;                    //型は独自に作成したenumにしている。

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS; //ブレイク処理クラスを作成する際に必要になる。(ブレイク処理クラスの実装時に作れば問題ない。)

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }

    /**
     * フォームグループ
     */
    public enum Layouts {

        AFAPRE506_KijitsumaeTohyoroku1mai1(1),
        AFAPRE506_KijitsumaeTohyoroku1mai2(2),
        AFAPRE506_KijitsumaeTohyoroku3mai1(1),
        AFAPRE506_KijitsumaeTohyoroku3mai2(2),
        AFAPRE506_KijitsumaeTohyoroku3mai3(3);
        private final int formGroupIndex;

        private Layouts(int formGroupIndex) {
            this.formGroupIndex = formGroupIndex;
        }

        /**
         * フォームグループインデックスを返します。
         *
         * @return フォームグループインデックス
         */
        public int index() {
            return this.formGroupIndex;
        }
    }
}
