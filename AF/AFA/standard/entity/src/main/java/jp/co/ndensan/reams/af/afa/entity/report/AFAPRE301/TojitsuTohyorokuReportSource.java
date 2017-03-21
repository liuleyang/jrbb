package jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 当日投票録ソース（自動生成）です。
 *
 * @reamsid_L AF-0130-021 lit
 */
public class TojitsuTohyorokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //１枚のフォームファイルの一ページソース
    @ReportItem(name = "title", length = 29, order = 1)
    public RString title;
    @ReportItem(name = "shikkoYmd", length = 11, order = 2)
    public RString shikkoYmd;
    @ReportItem(name = "tohyokuCode", length = 4, order = 3)
    public RString tohyokuCode;
    @ReportItem(name = "tohyoBasho", length = 31, order = 4)
    public RString tohyoBasho;
    @ReportItem(name = "henkoYmd", length = 11, order = 5)
    public RString henkoYmd;
    @ReportItem(name = "henkoBasho", length = 10, order = 6)
    public RString henkoBasho;
    @ReportItem(name = "henkoJiyu", length = 10, order = 7)
    public RString henkoJiyu;
    @ReportItem(name = "henkoKokujiYmd", length = 11, order = 8)
    public RString henkoKokujiYmd;
    @ReportItem(name = "toha1", length = 6, order = 9)
    public RString toha1;
    @ReportItem(name = "shimei1", length = 15, order = 10)
    public RString shimei1;
    @ReportItem(name = "senninYmd1", length = 10, order = 11)
    public RString senninYmd1;
    @ReportItem(name = "tachiaiJikan1", length = 12, order = 12)
    public RString tachiaiJikan1;
    @ReportItem(name = "sankaiJikoku1", length = 5, order = 13)
    public RString sankaiJikoku1;
    @ReportItem(name = "jishokuJikoku1", length = 5, order = 14)
    public RString jishokuJikoku1;
    @ReportItem(name = "jishokuRiyu1", length = 6, order = 15)
    public RString jishokuRiyu1;
    @ReportItem(name = "toha2", length = 6, order = 16)
    public RString toha2;
    @ReportItem(name = "shimei2", length = 15, order = 17)
    public RString shimei2;
    @ReportItem(name = "senninYmd2", length = 10, order = 18)
    public RString senninYmd2;
    @ReportItem(name = "tachiaiJikan2", length = 12, order = 19)
    public RString tachiaiJikan2;
    @ReportItem(name = "sankaiJikoku2", length = 5, order = 20)
    public RString sankaiJikoku2;
    @ReportItem(name = "jishokuJikoku2", length = 5, order = 21)
    public RString jishokuJikoku2;
    @ReportItem(name = "jishokuRiyu2", length = 6, order = 22)
    public RString jishokuRiyu2;
    @ReportItem(name = "toha3", length = 6, order = 23)
    public RString toha3;
    @ReportItem(name = "shimei3", length = 15, order = 24)
    public RString shimei3;
    @ReportItem(name = "senninYmd3", length = 10, order = 25)
    public RString senninYmd3;
    @ReportItem(name = "tachiaiJikan3", length = 12, order = 26)
    public RString tachiaiJikan3;
    @ReportItem(name = "sankaiJikoku3", length = 5, order = 27)
    public RString sankaiJikoku3;
    @ReportItem(name = "jishokuJikoku3", length = 5, order = 28)
    public RString jishokuJikoku3;
    @ReportItem(name = "jishokuRiyu3", length = 6, order = 29)
    public RString jishokuRiyu3;
    @ReportItem(name = "toha4", length = 6, order = 30)
    public RString toha4;
    @ReportItem(name = "shimei4", length = 15, order = 31)
    public RString shimei4;
    @ReportItem(name = "senninYmd4", length = 10, order = 32)
    public RString senninYmd4;
    @ReportItem(name = "tachiaiJikan4", length = 12, order = 33)
    public RString tachiaiJikan4;
    @ReportItem(name = "sankaiJikoku4", length = 5, order = 34)
    public RString sankaiJikoku4;
    @ReportItem(name = "jishokuJikoku4", length = 5, order = 35)
    public RString jishokuJikoku4;
    @ReportItem(name = "jishokuRiyu4", length = 6, order = 36)
    public RString jishokuRiyu4;
    @ReportItem(name = "toha5", length = 6, order = 37)
    public RString toha5;
    @ReportItem(name = "shimei5", length = 15, order = 38)
    public RString shimei5;
    @ReportItem(name = "senninYmd5", length = 10, order = 39)
    public RString senninYmd5;
    @ReportItem(name = "tachiaiJikan5", length = 12, order = 40)
    public RString tachiaiJikan5;
    @ReportItem(name = "sankaiJikoku5", length = 5, order = 41)
    public RString sankaiJikoku5;
    @ReportItem(name = "jishokuJikoku5", length = 5, order = 42)
    public RString jishokuJikoku5;
    @ReportItem(name = "jishokuRiyu5", length = 6, order = 43)
    public RString jishokuRiyu5;
    @ReportItem(name = "tToha1", length = 6, order = 44)
    public RString tToha1;
    @ReportItem(name = "tShimei1", length = 15, order = 45)
    public RString tShimei1;
    @ReportItem(name = "tSankaiJikoku1", length = 5, order = 46)
    public RString tSankaiJikoku1;
    @ReportItem(name = "tToha2", length = 6, order = 47)
    public RString tToha2;
    @ReportItem(name = "tShimei2", length = 15, order = 48)
    public RString tShimei2;
    @ReportItem(name = "tSankaiJikoku2", length = 5, order = 49)
    public RString tSankaiJikoku2;
    @ReportItem(name = "tToha3", length = 6, order = 50)
    public RString tToha3;
    @ReportItem(name = "tShimei3", length = 15, order = 51)
    public RString tShimei3;
    @ReportItem(name = "tSankaiJikoku3", length = 5, order = 52)
    public RString tSankaiJikoku3;
    @ReportItem(name = "tohyoJikokuStart", length = 8, order = 53)
    public RString tohyoJikokuStart;
    @ReportItem(name = "tohyoJikokuEnd", length = 8, order = 54)
    public RString tohyoJikokuEnd;
    @ReportItem(name = "meiboTorokushaMan", length = 9, order = 55)
    public RString meiboTorokushaMan;
    @ReportItem(name = "yukenshaMan", length = 9, order = 56)
    public RString yukenshaMan;
    @ReportItem(name = "tohyoshaMan", length = 9, order = 57)
    public RString tohyoshaMan;
    @ReportItem(name = "tohyoshaSosuMan", length = 9, order = 58)
    public RString tohyoshaSosuMan;
    @ReportItem(name = "kariTohyoshaSuMan", length = 9, order = 59)
    public RString kariTohyoshaSuMan;
    @ReportItem(name = "fuzaiTohyoshaSosuMan", length = 9, order = 60)
    public RString fuzaiTohyoshaSosuMan;
    @ReportItem(name = "fujuriMan", length = 9, order = 61)
    public RString fujuriMan;
    @ReportItem(name = "kyohishaMan", length = 9, order = 62)
    public RString kyohishaMan;
    @ReportItem(name = "meiboTorokushaWoman", length = 9, order = 63)
    public RString meiboTorokushaWoman;
    @ReportItem(name = "yukenshaWoman", length = 9, order = 64)
    public RString yukenshaWoman;
    @ReportItem(name = "tohyoshaWoman", length = 9, order = 65)
    public RString tohyoshaWoman;
    @ReportItem(name = "tohyoshaSosuWoman", length = 9, order = 66)
    public RString tohyoshaSosuWoman;
    @ReportItem(name = "kariTohyoshaSuWoman", length = 9, order = 67)
    public RString kariTohyoshaSuWoman;
    @ReportItem(name = "fuzaiTohyoshaSosuWoman", length = 9, order = 68)
    public RString fuzaiTohyoshaSosuWoman;
    @ReportItem(name = "fujuriWoman", length = 9, order = 69)
    public RString fujuriWoman;
    @ReportItem(name = "kyohishaWoman", length = 9, order = 70)
    public RString kyohishaWoman;
    @ReportItem(name = "meiboTorokushaKei", length = 9, order = 71)
    public RString meiboTorokushaKei;
    @ReportItem(name = "yukenshaKei", length = 9, order = 72)
    public RString yukenshaKei;
    @ReportItem(name = "tohyoshaKei", length = 9, order = 73)
    public RString tohyoshaKei;
    @ReportItem(name = "tohyoshaSosuKei", length = 9, order = 74)
    public RString tohyoshaSosuKei;
    @ReportItem(name = "kariTohyoshaSuKei", length = 9, order = 75)
    public RString kariTohyoshaSuKei;
    @ReportItem(name = "fuzaiTohyoshaSosuKei", length = 9, order = 76)
    public RString fuzaiTohyoshaSosuKei;
    @ReportItem(name = "fujuriKei", length = 9, order = 77)
    public RString fujuriKei;
    @ReportItem(name = "kyohishaKei", length = 9, order = 78)
    public RString kyohishaKei;
    @ReportItem(name = "saiKofusha1", length = 15, order = 79)
    public RString saiKofusha1;
    @ReportItem(name = "saiKofuJiyu1", length = 20, order = 80)
    public RString saiKofuJiyu1;
    @ReportItem(name = "saiKofusha2", length = 15, order = 81)
    public RString saiKofusha2;
    @ReportItem(name = "saiKofuJiyu2", length = 20, order = 82)
    public RString saiKofuJiyu2;
    @ReportItem(name = "ketteiTohyosha1", length = 10, order = 83)
    public RString ketteiTohyosha1;
    @ReportItem(name = "ketteiTohyosha2", length = 10, order = 84)
    public RString ketteiTohyosha2;
    @ReportItem(name = "ketteiTohyosha3", length = 10, order = 85)
    public RString ketteiTohyosha3;
    @ReportItem(name = "ketteiTohyosha4", length = 10, order = 86)
    public RString ketteiTohyosha4;
    @ReportItem(name = "ketteiTohyosha5", length = 10, order = 87)
    public RString ketteiTohyosha5;
    @ReportItem(name = "ketteiTohyosha6", length = 10, order = 88)
    public RString ketteiTohyosha6;
    @ReportItem(name = "ketteiTohyosha7", length = 10, order = 89)
    public RString ketteiTohyosha7;
    @ReportItem(name = "ketteiTohyosha8", length = 10, order = 90)
    public RString ketteiTohyosha8;
    @ReportItem(name = "henkansha1", length = 10, order = 91)
    public RString henkansha1;
    @ReportItem(name = "henkansha2", length = 10, order = 92)
    public RString henkansha2;
    @ReportItem(name = "henkansha3", length = 10, order = 93)
    public RString henkansha3;
    @ReportItem(name = "henkansha4", length = 10, order = 94)
    public RString henkansha4;
    @ReportItem(name = "henkansha5", length = 10, order = 95)
    public RString henkansha5;
    @ReportItem(name = "henkansha6", length = 10, order = 96)
    public RString henkansha6;
    @ReportItem(name = "henkansha7", length = 10, order = 97)
    public RString henkansha7;
    @ReportItem(name = "henkansha8", length = 10, order = 98)
    public RString henkansha8;
    @ReportItem(name = "tenji", length = 9, order = 99)
    public RString tenji;
    @ReportItem(name = "shuruiTitle", length = 3, order = 100)
    public RString shuruiTitle;
    @ReportItem(name = "listDairitohyo_1", length = 13, order = 101)
    public RString listDairitohyo_1;
    @ReportItem(name = "listDairitohyo_2", length = 13, order = 102)
    public RString listDairitohyo_2;
    @ReportItem(name = "listDairitohyo_3", length = 13, order = 103)
    public RString listDairitohyo_3;
    @ReportItem(name = "besshiUmu", length = 5, order = 104)
    public RString besshiUmu;
    @ReportItem(name = "dairiTohyoshaSu", length = 9, order = 105)
    public RString dairiTohyoshaSu;
    @ReportItem(name = "fuzaishaTohyoshaJurisu", length = 9, order = 106)
    public RString fuzaishaTohyoshaJurisu;
    @ReportItem(name = "fuzaishaTohyoshaSosu", length = 9, order = 107)
    public RString fuzaishaTohyoshaSosu;
    @ReportItem(name = "fuzaishaTohyoshaFujurisu", length = 9, order = 108)
    public RString fuzaishaTohyoshaFujurisu;
    @ReportItem(name = "fujuriTohyoshaName1", length = 10, order = 109)
    public RString fujuriTohyoshaName1;
    @ReportItem(name = "fujuriTohyoshaName2", length = 10, order = 110)
    public RString fujuriTohyoshaName2;
    @ReportItem(name = "fujuriTohyoshaName3", length = 10, order = 111)
    public RString fujuriTohyoshaName3;
    @ReportItem(name = "fujuriTohyoshaName4", length = 10, order = 112)
    public RString fujuriTohyoshaName4;
    @ReportItem(name = "fujuriTohyoshaName5", length = 10, order = 113)
    public RString fujuriTohyoshaName5;
    @ReportItem(name = "fujuriTohyoshaName6", length = 10, order = 114)
    public RString fujuriTohyoshaName6;
    @ReportItem(name = "hoNo3", length = 2, order = 115)
    public RString hoNo3;
    @ReportItem(name = "dairiKyohiTohyoshaName1", length = 10, order = 116)
    public RString dairiKyohiTohyoshaName1;
    @ReportItem(name = "dairiKyohiTohyoshaName2", length = 10, order = 117)
    public RString dairiKyohiTohyoshaName2;
    @ReportItem(name = "dairiKyohiTohyoshaName3", length = 10, order = 118)
    public RString dairiKyohiTohyoshaName3;
    @ReportItem(name = "dairiKyohiTohyoshaName4", length = 10, order = 119)
    public RString dairiKyohiTohyoshaName4;
    @ReportItem(name = "dairiKyohiTohyoshaName5", length = 10, order = 120)
    public RString dairiKyohiTohyoshaName5;
    @ReportItem(name = "dairiKyohiTohyoshaName6", length = 10, order = 121)
    public RString dairiKyohiTohyoshaName6;
    @ReportItem(name = "kyohiShimei1", length = 10, order = 122)
    public RString kyohiShimei1;
    @ReportItem(name = "kyohiJiyu1", length = 15, order = 123)
    public RString kyohiJiyu1;
    @ReportItem(name = "kariUmu1", length = 1, order = 124)
    public RString kariUmu1;
    @ReportItem(name = "hoNo1", length = 2, order = 125)
    public RString hoNo1;
    @ReportItem(name = "kyohiShimei2", length = 10, order = 126)
    public RString kyohiShimei2;
    @ReportItem(name = "kyohiJiyu2", length = 15, order = 127)
    public RString kyohiJiyu2;
    @ReportItem(name = "kariUmu2", length = 1, order = 128)
    public RString kariUmu2;
    @ReportItem(name = "kyohiShimei3", length = 10, order = 129)
    public RString kyohiShimei3;
    @ReportItem(name = "kyohiJiyu3", length = 15, order = 130)
    public RString kyohiJiyu3;
    @ReportItem(name = "kariUmu3", length = 1, order = 131)
    public RString kariUmu3;
    @ReportItem(name = "dKyohiShimei1", length = 10, order = 132)
    public RString dKyohiShimei1;
    @ReportItem(name = "dKyohiJiyu1", length = 15, order = 133)
    public RString dKyohiJiyu1;
    @ReportItem(name = "dKariUmu1", length = 1, order = 134)
    public RString dKariUmu1;
    @ReportItem(name = "hoNo2", length = 2, order = 135)
    public RString hoNo2;
    @ReportItem(name = "dKyohiShimei2", length = 10, order = 136)
    public RString dKyohiShimei2;
    @ReportItem(name = "dKyohiJiyu2", length = 15, order = 137)
    public RString dKyohiJiyu2;
    @ReportItem(name = "dDariUmu2", length = 1, order = 138)
    public RString dDariUmu2;
    @ReportItem(name = "dKyohiShimei3", length = 10, order = 139)
    public RString dKyohiShimei3;
    @ReportItem(name = "dKyohiJiyu3", length = 15, order = 140)
    public RString dKyohiJiyu3;
    @ReportItem(name = "dKariUmu3", length = 1, order = 141)
    public RString dKariUmu3;
    @ReportItem(name = "jimu1", length = 3, order = 142)
    public RString jimu1;
    @ReportItem(name = "jimuSosu", length = 5, order = 143)
    public RString jimuSosu;
    @ReportItem(name = "jimu2", length = 3, order = 144)
    public RString jimu2;
    @ReportItem(name = "jimu3", length = 3, order = 145)
    public RString jimu3;
    @ReportItem(name = "choseiYmd", length = 13, order = 146)
    public RString choseiYmd;
    @ReportItem(name = "pageNo", length = 3, order = 147)
    public RString pageNo;

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
    @ReportItem(name = "tohyoYmd", length = 11, order = 207)
    public RString tohyoYmd;
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

        AFAPRE301_TojitsuTohyoroku1mai1(1),
        AFAPRE301_TojitsuTohyoroku1mai2(2);
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
