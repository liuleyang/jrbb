package jp.co.ndensan.reams.af.afa.business.report.AFAPRB204;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0160-034 guyq
 */
public class NyujokenPostexEditor implements INyujokenPostexEditor {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_SIX = 6;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FIVE = 5;
    private static final int 郵便番号_上3桁 = 3;
    private static final int NUMBER_SEVEN = 7;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_NINE = 9;
    private static final RString TWO = new RString("2");
    private static final RString ONE = new RString("1");
    private static final RString FOUR = new RString("4");
    private static final RString THREE = new RString("3");
    private static final RString SIX = new RString("6");
    private static final RString FIVE = new RString("5");
    private static final RString SEVEN = new RString("7");
    private static final RString NINE = new RString("9");
    private static final RString EIGHT = new RString("8");
    private static final RString 空白 = new RString(" ");
    private static final RString 長さ_名称21 = new RString("shimei21");
    private static final RString 長さ_名称11 = new RString("shimei11");
    private static final RString 長さ_名称12 = new RString("shimei12");
    private static final RString 長さ_名称31 = new RString("shimei31");
    private static final RString 長さ_名称22 = new RString("shimei22");
    private static final RString 長さ_名称13 = new RString("shimei13");
    private static final RString 長さ_名称32 = new RString("shimei32");
    private static final RString 長さ_名称33 = new RString("shimei33");
    private static final RString 長さ_名称23 = new RString("shimei23");
    private static final RString 長さ_名称14 = new RString("shimei14");
    private static final RString 長さ_名称34 = new RString("shimei34");
    private static final RString 長さ_名称24 = new RString("shimei24");
    private static final RString 長さ_名称15 = new RString("shimei15");
    private static final RString 長さ_名称35 = new RString("shimei35");
    private static final RString 長さ_名称25 = new RString("shimei25");
    private static final RString 長さ_名称16 = new RString("shimei16");
    private static final RString 長さ_名称26 = new RString("shimei26");
    private static final RString 長さ_名称36 = new RString("shimei36");
    private static final RString 長さ_宛名21 = new RString("atena21");
    private static final RString 長さ_宛名11 = new RString("atena11");
    private static final RString 長さ_宛名31 = new RString("atena31");
    private static final RString 長さ_送付先住所11 = new RString("sofusakiJusho1");
    private static final RString 長さ_送付先住所31 = new RString("sofusakiJusho3");
    private static final RString 長さ_送付先住所21 = new RString("sofusakiJusho2");
    private static final RString 長さ_送付先住所51 = new RString("sofusakiJusho5");
    private static final RString 長さ_送付先住所41 = new RString("sofusakiJusho4");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");
    private static final RString 長さ_投票所名24 = new RString("tohyojoMei24");
    private static final RString 長さ_投票所名14 = new RString("tohyojoMei14");
    private static final RString 長さ_投票所名34 = new RString("tohyojoMei34");
    private static final RString 長さ_投票所名15 = new RString("tohyojoMei15");
    private static final RString 長さ_投票所名25 = new RString("tohyojoMei25");
    private static final RString 長さ_投票所名16 = new RString("tohyojoMei16");
    private static final RString 長さ_投票所名35 = new RString("tohyojoMei35");
    private static final RString 長さ_投票所名26 = new RString("tohyojoMei26");
    private static final RString 長さ_投票所名36 = new RString("tohyojoMei36");
    private static final RString 全角スペース = new RString("　");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");

    private final NyujokenPostexParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NyujokenPostexParam}
     */
    public NyujokenPostexEditor(NyujokenPostexParam data) {
        this.data = data;
    }

    /**
     * 投票所入場券（ポステックス）エディットメソッド
     *
     * @param source 投票所入場券（ポステックス）
     * @return 投票所入場券（ポステックス）
     */
    @Override
    public NyujokenPostexSource edit(NyujokenPostexSource source) {
        edit共通情報(source);
        edit送付先情報(source);
        edit明細情報(source);
        editアクセスログ出力(source);

        return source;
    }

    private void edit共通情報(NyujokenPostexSource source) {
        edit入場券名称(source);
        edit抄本番号(source);
        edit抄本名(source);
        edit選挙(source);
        edit投票年月日(source);
        edit告示年月日(source);
        edit市町村名(source);
        editサンプル文字(source);
    }

    private void edit送付先情報(NyujokenPostexSource source) {
        edit整理番号(source);
        edit送付先住所(source);
        edit送付先郵便番号(source);
        editカスタマーバーコード(source);
        edit送付先行政区(source);
        edit送付先行政区名(source);
        edit宛名(source);
        edit送付先地区名(source);
        edit送付先世帯コード(source);
        edit送付先名簿番号(source);
        edit世帯主名(source);
        edit地図情報(source);
    }

    private void edit明細情報(NyujokenPostexSource source) {
        edit住所(source);
        edit名称(source);
        editカナ名称(source);
        edit世帯(source);
        edit投票所の住所(source);
        edit世帯主区分(source);
        edit投票区名(source);
        edit生年月日(source);
        edit性別(source);
        edit投票区コード(source);
        edit投票所名(source);
        edit識別コード(source);
        edit頁_行(source);
        edit投票開始時刻(source);
        edit投票終了時刻(source);
        edit名簿番号(source);
        edit入場券バーコード(source);
        edit行政区(source);
        edit地区(source);
    }

    private void edit投票区名(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.tohyokuMei1 = data.get明細情報1().get投票区名();
        }
        if (null != data.get明細情報2()) {
            source.tohyokuMei2 = data.get明細情報2().get投票区名();
        }
        if (null != data.get明細情報3()) {
            source.tohyokuMei3 = data.get明細情報3().get投票区名();
        }
        if (null != data.get明細情報4()) {
            source.tohyokuMei4 = data.get明細情報4().get投票区名();
        }
        if (null != data.get明細情報5()) {
            source.tohyokuMei5 = data.get明細情報5().get投票区名();
        }
        if (null != data.get明細情報6()) {
            source.tohyokuMei6 = data.get明細情報6().get投票区名();
        }
    }

    private void edit投票所の住所(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.tohyojoJusho1 = data.get明細情報1().get投票所＿住所();
        }
        if (null != data.get明細情報2()) {
            source.tohyojoJusho2 = data.get明細情報2().get投票所＿住所();
        }
        if (null != data.get明細情報3()) {
            source.tohyojoJusho3 = data.get明細情報3().get投票所＿住所();
        }
        if (null != data.get明細情報4()) {
            source.tohyojoJusho4 = data.get明細情報4().get投票所＿住所();
        }
        if (null != data.get明細情報5()) {
            source.tohyojoJusho5 = data.get明細情報5().get投票所＿住所();
        }
        if (null != data.get明細情報6()) {
            source.tohyojoJusho6 = data.get明細情報6().get投票所＿住所();
        }
    }

    private void edit世帯主区分(NyujokenPostexSource source) {
        source.setainushiKubun1 = data.getSetainushiKubun1();
        source.setainushiKubun2 = data.getSetainushiKubun2();
        source.setainushiKubun3 = data.getSetainushiKubun3();
        source.setainushiKubun4 = data.getSetainushiKubun4();
        source.setainushiKubun5 = data.getSetainushiKubun5();
        source.setainushiKubun6 = data.getSetainushiKubun6();
    }

    private void edit世帯主名(NyujokenPostexSource source) {
        source.setainushiMei1 = data.getSetainushiMei1();
    }

    private void edit整理番号(NyujokenPostexSource source) {
        if (null != data.get送付先情報1()) {
            source.seiriNo1 = new RString(data.get送付先情報1().get整理番号());
        }
    }

    private void edit地区(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.chikuName31 = data.get明細情報1().get地区名3();
            source.chikuCode11 = data.get明細情報1().get地区コード1();
            source.chikuCode21 = data.get明細情報1().get地区コード2();
            source.chikuCode31 = data.get明細情報1().get地区コード3();
            source.chikuName11 = data.get明細情報1().get地区名1();
            source.chikuName21 = data.get明細情報1().get地区名2();
        }
        if (null != data.get明細情報3()) {
            source.chikuCode13 = data.get明細情報3().get地区コード1();
            source.chikuCode33 = data.get明細情報3().get地区コード3();
            source.chikuCode23 = data.get明細情報3().get地区コード2();
            source.chikuName23 = data.get明細情報3().get地区名2();
            source.chikuName13 = data.get明細情報3().get地区名1();
            source.chikuName33 = data.get明細情報3().get地区名3();
        }
        if (null != data.get明細情報2()) {
            source.chikuCode12 = data.get明細情報2().get地区コード1();
            source.chikuCode32 = data.get明細情報2().get地区コード3();
            source.chikuCode22 = data.get明細情報2().get地区コード2();
            source.chikuName22 = data.get明細情報2().get地区名2();
            source.chikuName12 = data.get明細情報2().get地区名1();
            source.chikuName32 = data.get明細情報2().get地区名3();
        }
        if (null != data.get明細情報4()) {
            source.chikuCode14 = data.get明細情報4().get地区コード1();
            source.chikuCode24 = data.get明細情報4().get地区コード2();
            source.chikuCode34 = data.get明細情報4().get地区コード3();
            source.chikuName14 = data.get明細情報4().get地区名1();
            source.chikuName24 = data.get明細情報4().get地区名2();
            source.chikuName34 = data.get明細情報4().get地区名3();
        }
        if (null != data.get明細情報5()) {
            source.chikuCode15 = data.get明細情報5().get地区コード1();
            source.chikuCode25 = data.get明細情報5().get地区コード2();
            source.chikuCode35 = data.get明細情報5().get地区コード3();
            source.chikuName15 = data.get明細情報5().get地区名1();
            source.chikuName25 = data.get明細情報5().get地区名2();
            source.chikuName35 = data.get明細情報5().get地区名3();
        }
        if (null != data.get明細情報6()) {
            source.chikuCode16 = data.get明細情報6().get地区コード1();
            source.chikuCode26 = data.get明細情報6().get地区コード2();
            source.chikuCode36 = data.get明細情報6().get地区コード3();
            source.chikuName16 = data.get明細情報6().get地区名1();
            source.chikuName26 = data.get明細情報6().get地区名2();
            source.chikuName36 = data.get明細情報6().get地区名3();
        }
    }

    private void edit送付先郵便番号(NyujokenPostexSource source) {
        if (null != data.get送付先情報1() && null != data.get送付先情報1().get送付先郵便番号()) {
            YubinNo 番号 = data.get送付先情報1().get送付先郵便番号();
            source.yubinNo11 = new RString(番号.toString().substring(0, 郵便番号_上3桁));
            if (番号.toString().length() > 郵便番号_上3桁) {
                source.yubinNo21 = new RString(番号.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
            source.yubinNo1 = 番号.getColumnValue();
        }
    }

    private void edit生年月日(NyujokenPostexSource source) {
        source.seinengappi1 = data.getSeinengappi1();
        source.seinengappi2 = data.getSeinengappi2();
        source.seinengappi3 = data.getSeinengappi3();
        source.seinengappi4 = data.getSeinengappi4();
        source.seinengappi5 = data.getSeinengappi5();
        source.seinengappi6 = data.getSeinengappi6();
    }

    private void edit行政区(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.gyoseikuCode1 = data.get明細情報1().get行政区コード();
            source.gyoseikuMei1 = data.get明細情報1().get行政区名();
        }
        if (null != data.get明細情報6()) {
            source.gyoseikuCode6 = data.get明細情報6().get行政区コード();
            source.gyoseikuMei6 = data.get明細情報6().get行政区名();
        }
        if (null != data.get明細情報2()) {
            source.gyoseikuCode2 = data.get明細情報2().get行政区コード();
            source.gyoseikuMei2 = data.get明細情報2().get行政区名();
        }
        if (null != data.get明細情報5()) {
            source.gyoseikuCode5 = data.get明細情報5().get行政区コード();
            source.gyoseikuMei5 = data.get明細情報5().get行政区名();
        }
        if (null != data.get明細情報4()) {
            source.gyoseikuCode4 = data.get明細情報4().get行政区コード();
            source.gyoseikuMei4 = data.get明細情報4().get行政区名();
        }
        if (null != data.get明細情報3()) {
            source.gyoseikuCode3 = data.get明細情報3().get行政区コード();
            source.gyoseikuMei3 = data.get明細情報3().get行政区名();
        }
    }

    private void editカスタマーバーコード(NyujokenPostexSource source) {
        source.barcodeCustombarcode1 = data.getBarcodeCustombarcode1();
    }

    private void edit名簿番号(NyujokenPostexSource source) {
        source.meiboNo1 = data.getMeiboNo1();
        source.meiboNo2 = data.getMeiboNo2();
        source.meiboNo3 = data.getMeiboNo3();
        source.meiboNo4 = data.getMeiboNo4();
        source.meiboNo5 = data.getMeiboNo5();
        source.meiboNo6 = data.getMeiboNo6();
    }

    private void edit頁_行(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.meiboPage1 = new RString(data.get明細情報1().get頁());
            source.meiboGyo1 = new RString(data.get明細情報1().get行());
        }
        if (null != data.get明細情報2()) {
            source.meiboPage2 = new RString(data.get明細情報2().get頁());
            source.meiboGyo2 = new RString(data.get明細情報2().get行());
        }
        if (null != data.get明細情報6()) {
            source.meiboPage6 = new RString(data.get明細情報6().get頁());
            source.meiboGyo6 = new RString(data.get明細情報6().get行());
        }
        if (null != data.get明細情報3()) {
            source.meiboPage3 = new RString(data.get明細情報3().get頁());
            source.meiboGyo3 = new RString(data.get明細情報3().get行());
        }
        if (null != data.get明細情報4()) {
            source.meiboPage4 = new RString(data.get明細情報4().get頁());
            source.meiboGyo4 = new RString(data.get明細情報4().get行());
        }
        if (null != data.get明細情報5()) {
            source.meiboPage5 = new RString(data.get明細情報5().get頁());
            source.meiboGyo5 = new RString(data.get明細情報5().get行());
        }
    }

    private void editカナ名称(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.shimeiKana1 = data.get明細情報1().getカナ名称();
        }
        if (null != data.get明細情報2()) {
            source.shimeiKana2 = data.get明細情報2().getカナ名称();
        }
        if (null != data.get明細情報3()) {
            source.shimeiKana3 = data.get明細情報3().getカナ名称();
        }
        if (null != data.get明細情報4()) {
            source.shimeiKana4 = data.get明細情報4().getカナ名称();
        }
        if (null != data.get明細情報5()) {
            source.shimeiKana5 = data.get明細情報5().getカナ名称();
        }
        if (null != data.get明細情報6()) {
            source.shimeiKana6 = data.get明細情報6().getカナ名称();
        }
        source.shimeiKana11 = data.getShimeiKana11();
        source.shimeiKana21 = data.getShimeiKana21();
        source.shimeiKana12 = data.getShimeiKana12();
        source.shimeiKana22 = data.getShimeiKana22();
        source.shimeiKana13 = data.getShimeiKana13();
        source.shimeiKana23 = data.getShimeiKana23();
        source.shimeiKana14 = data.getShimeiKana14();
        source.shimeiKana24 = data.getShimeiKana24();
        source.shimeiKana15 = data.getShimeiKana15();
        source.shimeiKana25 = data.getShimeiKana25();
        source.shimeiKana16 = data.getShimeiKana16();
        source.shimeiKana26 = data.getShimeiKana26();
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void edit名称(NyujokenPostexSource source) {
        if (null != data.get明細情報3()) {
            source.shimei_3 = data.get明細情報3().get名称();
            source.shimei3 = data.get明細情報3().get名称();
        }
        if (null != data.get明細情報2()) {
            source.shimei2 = data.get明細情報2().get名称();
            source.shimei_2 = data.get明細情報2().get名称();
        }
        if (null != data.get明細情報4()) {
            source.shimei_4 = data.get明細情報4().get名称();
            source.shimei4 = data.get明細情報4().get名称();
        }
        if (null != data.get明細情報6()) {
            source.shimei_6 = data.get明細情報6().get名称();
            source.shimei6 = data.get明細情報6().get名称();
        }
        if (null != data.get明細情報5()) {
            source.shimei_5 = data.get明細情報5().get名称();
            source.shimei5 = data.get明細情報5().get名称();
        }
        if (null != data.get明細情報1()) {
            source.shimei_1 = data.get明細情報1().get名称();
            source.shimei1 = data.get明細情報1().get名称();
        }

        if (is文字切れ(getItemLength(長さ_名称21), data.getShimei21())) {
            source.shimei21 = data.getShimei21().substring(NUMBER_ZERO, getItemLength(長さ_名称21));
        } else {
            source.shimei21 = data.getShimei21();
        }
        if (is文字切れ(getItemLength(長さ_名称13), data.getShimei13())) {
            source.shimei13 = data.getShimei13().substring(NUMBER_ZERO, getItemLength(長さ_名称13));
        } else {
            source.shimei13 = data.getShimei13();
        }
        if (is文字切れ(getItemLength(長さ_名称11), data.getShimei11())) {
            source.shimei11 = data.getShimei11().substring(NUMBER_ZERO, getItemLength(長さ_名称11));
        } else {
            source.shimei11 = data.getShimei11();
        }
        if (is文字切れ(getItemLength(長さ_名称22), data.getShimei22())) {
            source.shimei22 = data.getShimei22().substring(NUMBER_ZERO, getItemLength(長さ_名称22));
        } else {
            source.shimei22 = data.getShimei22();
        }
        if (is文字切れ(getItemLength(長さ_名称32), data.getShimei32())) {
            source.shimei32 = data.getShimei32().substring(NUMBER_ZERO, getItemLength(長さ_名称32));
        } else {
            source.shimei32 = data.getShimei32();
        }
        if (is文字切れ(getItemLength(長さ_名称33), data.getShimei33())) {
            source.shimei33 = data.getShimei33().substring(NUMBER_ZERO, getItemLength(長さ_名称33));
        } else {
            source.shimei33 = data.getShimei33();
        }
        if (is文字切れ(getItemLength(長さ_名称14), data.getShimei14())) {
            source.shimei14 = data.getShimei14().substring(NUMBER_ZERO, getItemLength(長さ_名称14));
        } else {
            source.shimei14 = data.getShimei14();
        }
        if (is文字切れ(getItemLength(長さ_名称24), data.getShimei24())) {
            source.shimei24 = data.getShimei24().substring(NUMBER_ZERO, getItemLength(長さ_名称24));
        } else {
            source.shimei24 = data.getShimei24();
        }
        if (is文字切れ(getItemLength(長さ_名称15), data.getShimei15())) {
            source.shimei15 = data.getShimei15().substring(NUMBER_ZERO, getItemLength(長さ_名称15));
        } else {
            source.shimei15 = data.getShimei15();
        }
        if (is文字切れ(getItemLength(長さ_名称25), data.getShimei25())) {
            source.shimei25 = data.getShimei25().substring(NUMBER_ZERO, getItemLength(長さ_名称25));
        } else {
            source.shimei25 = data.getShimei25();
        }
        if (is文字切れ(getItemLength(長さ_名称23), data.getShimei23())) {
            source.shimei23 = data.getShimei23().substring(NUMBER_ZERO, getItemLength(長さ_名称23));
        } else {
            source.shimei23 = data.getShimei23();
        }
        if (is文字切れ(getItemLength(長さ_名称35), data.getShimei35())) {
            source.shimei35 = data.getShimei35().substring(NUMBER_ZERO, getItemLength(長さ_名称35));
        } else {
            source.shimei35 = data.getShimei35();
        }
        if (is文字切れ(getItemLength(長さ_名称36), data.getShimei36())) {
            source.shimei36 = data.getShimei36().substring(NUMBER_ZERO, getItemLength(長さ_名称36));
        } else {
            source.shimei36 = data.getShimei36();
        }
        if (is文字切れ(getItemLength(長さ_名称26), data.getShimei26())) {
            source.shimei26 = data.getShimei26().substring(NUMBER_ZERO, getItemLength(長さ_名称26));
        } else {
            source.shimei26 = data.getShimei26();
        }
        if (is文字切れ(getItemLength(長さ_名称16), data.getShimei16())) {
            source.shimei16 = data.getShimei16().substring(NUMBER_ZERO, getItemLength(長さ_名称16));
        } else {
            source.shimei16 = data.getShimei16();
        }
        if (is文字切れ(getItemLength(長さ_名称34), data.getShimei34())) {
            source.shimei34 = data.getShimei34().substring(NUMBER_ZERO, getItemLength(長さ_名称34));
        } else {
            source.shimei34 = data.getShimei34();
        }
        if (is文字切れ(getItemLength(長さ_名称31), data.getShimei31())) {
            source.shimei31 = data.getShimei31().substring(NUMBER_ZERO, getItemLength(長さ_名称31));
        } else {
            source.shimei31 = data.getShimei31();
        }
        if (is文字切れ(getItemLength(長さ_名称12), data.getShimei12())) {
            source.shimei12 = data.getShimei12().substring(NUMBER_ZERO, getItemLength(長さ_名称12));
        } else {
            source.shimei12 = data.getShimei12();
        }
        source.shimei_4 = changeNullToEmpty(data.getShimei14())
                .concat(changeNullToEmpty(data.getShimei24()))
                .concat(changeNullToEmpty(data.getShimei34()));
        source.shimei_6 = changeNullToEmpty(data.getShimei16())
                .concat(changeNullToEmpty(data.getShimei26()))
                .concat(changeNullToEmpty(data.getShimei36()));
        source.shimei_5 = changeNullToEmpty(data.getShimei15())
                .concat(changeNullToEmpty(data.getShimei25()))
                .concat(changeNullToEmpty(data.getShimei35()));

    }

    private void edit送付先世帯コード(NyujokenPostexSource source) {
        if (null != data.get送付先情報1()) {
            SetaiCode 送付先世帯コード1 = data.get送付先情報1().get送付先世帯コード();
            source.sofusakiSetaiCode1 = null == 送付先世帯コード1 ? RString.EMPTY : 送付先世帯コード1.getColumnValue();
        }
    }

    private void edit世帯(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            SetaiCode 世帯コード1 = data.get明細情報1().get世帯コード();
            source.setaiCode1 = null == 世帯コード1 ? RString.EMPTY : 世帯コード1.getColumnValue();
        }
        if (null != data.get明細情報5()) {
            SetaiCode 世帯コード5 = data.get明細情報5().get世帯コード();
            source.setaiCode5 = null == 世帯コード5 ? RString.EMPTY : 世帯コード5.getColumnValue();
        }
        if (null != data.get明細情報2()) {
            SetaiCode 世帯コード2 = data.get明細情報2().get世帯コード();
            source.setaiCode2 = null == 世帯コード2 ? RString.EMPTY : 世帯コード2.getColumnValue();
        }
        if (null != data.get明細情報3()) {
            SetaiCode 世帯コード3 = data.get明細情報3().get世帯コード();
            source.setaiCode3 = null == 世帯コード3 ? RString.EMPTY : 世帯コード3.getColumnValue();
        }
        if (null != data.get明細情報4()) {
            SetaiCode 世帯コード4 = data.get明細情報4().get世帯コード();
            source.setaiCode4 = null == 世帯コード4 ? RString.EMPTY : 世帯コード4.getColumnValue();
        }
        if (null != data.get明細情報6()) {
            SetaiCode 世帯コード6 = data.get明細情報6().get世帯コード();
            source.setaiCode6 = null == 世帯コード6 ? RString.EMPTY : 世帯コード6.getColumnValue();
        }
    }

    private void edit地図情報(NyujokenPostexSource source) {
        source.mapJoho1 = data.getMapJoho1();
    }

    private void edit入場券名称(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.nyujokenName1 = data.get入場券帳票作成入力情報().get入場券名称1();
            source.nyujokenName2 = data.get入場券帳票作成入力情報().get入場券名称2();
            source.nyujokenName3 = data.get入場券帳票作成入力情報().get入場券名称3();
        }
    }

    private void edit送付先地区名(NyujokenPostexSource source) {
        if (null != data.get送付先情報1()) {
            source.sofusakiChikuName1 = data.get送付先情報1().get送付先地区名1();
            ChikuCode 送付先地区コード1 = data.get送付先情報1().get送付先地区コード1();
            source.sofusakiChikuCode1 = null == 送付先地区コード1 ? RString.EMPTY : 送付先地区コード1.getColumnValue();
        }
    }

    private void edit送付先行政区(NyujokenPostexSource source) {
        if (null != data.get送付先情報1()) {
            GyoseikuCode 送付先行政区コード = data.get送付先情報1().get送付先行政区コード();
            ChoikiCode 送付先全国住所コード1 = data.get送付先情報1().get送付先全国住所コード();
            source.sofusakiJushoCode1 = null == 送付先全国住所コード1 ? RString.EMPTY : 送付先全国住所コード1.getColumnValue();
            if (null != 送付先行政区コード) {
                source.sofusakiGyoseikuCode1 = 送付先行政区コード.getColumnValue();
            }
        }

        source.sofusakiGyoseikuMei11 = changeNullToEmpty(data.getSofusakiGyoseikuMei11());
        source.sofusakiGyoseikuMei21 = changeNullToEmpty(data.getSofusakiGyoseikuMei21());
        source.sofusakiGyoseikuMei31 = changeNullToEmpty(data.getSofusakiGyoseikuMei31());
    }

    private void edit送付先行政区名(NyujokenPostexSource source) {
        source.sofusakiGyoseikuMei1 = null == data.getSofusakiGyoseikuMei11() ? RString.EMPTY : data.getSofusakiGyoseikuMei11();
        source.sofusakiGyoseikuMei2 = null == data.getSofusakiGyoseikuMei21() ? RString.EMPTY : data.getSofusakiGyoseikuMei21();
    }

    private void edit投票年月日(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get投票年月日()) {
            RString 投票年月日 = data.get入場券帳票作成入力情報().get投票年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.tohyoYMD = 投票年月日;
            source.tohyoYMD_mm = 投票年月日.substring(NUMBER_FOUR, NUMBER_SIX);
            source.tohyoYMD_dd = 投票年月日.substring(NUMBER_SEVEN, NUMBER_NINE);
            source.tohyoYMD_yyyy = 投票年月日.substring(NUMBER_ONE, NUMBER_THREE);
            source.tohyoYMD_gengou = get発行年号(data.get入場券帳票作成入力情報().get投票年月日());
            source.tohyoYMD_youbi = new RString(data.get入場券帳票作成入力情報().get投票年月日().getDayOfWeek().getFullTerm());
        }
    }

    private void edit市町村名(NyujokenPostexSource source) {
        if (null != data.get地方公共団体情報()) {
            source.shichosonName = data.get地方公共団体情報().get市町村名();
        }
    }

    private RString get発行年号(RDate 投票年月日2) {
        RString 発行年 = 投票年月日2.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getYear();
        RString 元号 = 発行年.substring(0, 2);
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        rsb.append(元号);
        return rsb.toRString();
    }

    private void editサンプル文字(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.txtSample = data.get入場券帳票作成入力情報().getサンプル文字();
        }
    }

    private void edit告示年月日(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get告示年月日()) {
            RString 告示年月日 = data.get入場券帳票作成入力情報().get告示年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.kokujiYMD_mm = 告示年月日.substring(NUMBER_FOUR, NUMBER_SIX);
            source.kokujiYMD_gengou = get発行年号(data.get入場券帳票作成入力情報().get告示年月日());
            source.kokujiYMD = 告示年月日;
            source.kokujiYMD_dd = 告示年月日.substring(NUMBER_SEVEN, NUMBER_NINE);
            source.kokujiYMD_yyyy = 告示年月日.substring(NUMBER_ONE, NUMBER_THREE);
            source.kokujiYMD_youbi = new RString(data.get入場券帳票作成入力情報().get告示年月日().getDayOfWeek().getFullTerm());
        }
    }

    private RString edit送付先住所取得(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書, RString 行政区名) {
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 方書文字列 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : changeNullToEmpty(方書.value());
        行政区名 = changeNullToEmpty(行政区名);
        住所文字列 = 住所文字列.replace(全角スペース, RString.EMPTY);
        住所文字列 = 住所文字列.replace(空白, RString.EMPTY);
        番地文字列 = 番地文字列.replace(空白, RString.EMPTY);
        番地文字列 = 番地文字列.replace(全角スペース, RString.EMPTY);
        行政区名 = 行政区名.replace(全角スペース, RString.EMPTY);
        行政区名 = 行政区名.replace(空白, RString.EMPTY);
        RString 入場券_送付先住所編集 = BusinessConfig.get(ConfigKeysAFA.入場券_送付先住所編集, SubGyomuCode.AFA選挙本体);
        RString 編集用送付先住所 = RString.EMPTY;
        if (AFAConfigKeysValue.入場券_送付先住所編集_住所番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 住所文字列.concat(番地文字列).concat(全角スペース).concat(方書文字列);
        }
        if (AFAConfigKeysValue.入場券_送付先住所編集_住所行政区番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 住所文字列.concat(左括弧).concat(行政区名).concat(右括弧).concat(番地文字列)
                    .concat(全角スペース).concat(方書文字列);
        }
        if (AFAConfigKeysValue.入場券_送付先住所編集_行政区番地方書.configKeyValue().equals(入場券_送付先住所編集)) {
            編集用送付先住所 = 行政区名.concat(番地文字列).concat(全角スペース).concat(方書文字列);
        }
        return 編集用送付先住所;
    }

    private void edit送付先住所(NyujokenPostexSource source) {
        if (null != data.get送付先情報1()) {
            source.sofusakiJusho_1 = edit送付先住所取得(data.get送付先情報1().get送付先住所(), data.get送付先情報1().get送付先番地(),
                    data.get送付先情報1().get送付先方書(), data.get送付先情報1().get送付先行政区名());
        }
        if (is文字切れ(getItemLength(長さ_送付先住所11), data.getSofusakiJusho11())) {
            source.sofusakiJusho1 = data.getSofusakiJusho11().substring(NUMBER_ZERO, getItemLength(長さ_送付先住所11));
        } else {
            source.sofusakiJusho1 = data.getSofusakiJusho11();
        }
        if (is文字切れ(getItemLength(長さ_送付先住所41), data.getSofusakiJusho41())) {
            source.sofusakiJusho4 = data.getSofusakiJusho41().substring(NUMBER_ZERO, getItemLength(長さ_送付先住所41));
        } else {
            source.sofusakiJusho4 = data.getSofusakiJusho41();
        }
        if (is文字切れ(getItemLength(長さ_送付先住所21), data.getSofusakiJusho21())) {
            source.sofusakiJusho2 = data.getSofusakiJusho21().substring(NUMBER_ZERO, getItemLength(長さ_送付先住所21));
        } else {
            source.sofusakiJusho2 = data.getSofusakiJusho21();
        }
        if (is文字切れ(getItemLength(長さ_送付先住所31), data.getSofusakiJusho31())) {
            source.sofusakiJusho3 = data.getSofusakiJusho31().substring(NUMBER_ZERO, getItemLength(長さ_送付先住所31));
        } else {
            source.sofusakiJusho3 = data.getSofusakiJusho31();
        }
        if (is文字切れ(getItemLength(長さ_送付先住所51), data.getSofusakiJusho51())) {
            source.sofusakiJusho5 = data.getSofusakiJusho51().substring(NUMBER_ZERO, getItemLength(長さ_送付先住所51));
        } else {
            source.sofusakiJusho5 = data.getSofusakiJusho51();
        }
    }

    private void edit宛名(NyujokenPostexSource source) {
        if (is文字切れ(getItemLength(長さ_宛名11), data.getAtena11())) {
            source.atena11 = data.getAtena11().substring(NUMBER_ZERO, getItemLength(長さ_宛名11));
        } else {
            source.atena11 = data.getAtena11();
        }
        if (is文字切れ(getItemLength(長さ_宛名31), data.getAtena31())) {
            source.atena31 = data.getAtena31().substring(NUMBER_ZERO, getItemLength(長さ_宛名31));
        } else {
            source.atena31 = data.getAtena31();
        }
        if (is文字切れ(getItemLength(長さ_宛名21), data.getAtena21())) {
            source.atena21 = data.getAtena21().substring(NUMBER_ZERO, getItemLength(長さ_宛名21));
        } else {
            source.atena21 = data.getAtena21();
        }
        if (null != data.get送付先情報1()) {
            source.atena_1 = data.get送付先情報1().get送付先宛名();
        }

    }

    private void edit抄本番号(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.shohonNo = data.get入場券帳票作成入力情報().get抄本番号();
        }
    }

    private void edit送付先名簿番号(NyujokenPostexSource source) {
        source.sofusakiMeiboNo1 = data.getSofusakiMeiboNo1();
    }

    private void edit抄本名(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.shohonName = data.get入場券帳票作成入力情報().get抄本名();
        }
    }

    private void edit選挙(NyujokenPostexSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get選挙名称()) {
            List<SenkyomeishouParam> 選挙リスト = data.get入場券帳票作成入力情報().get選挙名称();
            for (SenkyomeishouParam 選挙 : 選挙リスト) {
                if (FOUR.equals(選挙.get選挙番号())) {
                    source.senkyoMei4 = 選挙.get選挙名称();
                    source.senkyoRyakusho4 = 選挙.get選挙略称();
                }
                if (ONE.equals(選挙.get選挙番号())) {
                    source.senkyoMei1 = 選挙.get選挙名称();
                    source.senkyoRyakusho1 = 選挙.get選挙略称();
                }
                if (TWO.equals(選挙.get選挙番号())) {
                    source.senkyoMei2 = 選挙.get選挙名称();
                    source.senkyoRyakusho2 = 選挙.get選挙略称();
                }
                if (THREE.equals(選挙.get選挙番号())) {
                    source.senkyoMei3 = 選挙.get選挙名称();
                    source.senkyoRyakusho3 = 選挙.get選挙略称();
                }
                if (FIVE.equals(選挙.get選挙番号())) {
                    source.senkyoMei5 = 選挙.get選挙名称();
                    source.senkyoRyakusho5 = 選挙.get選挙略称();
                }
                if (SEVEN.equals(選挙.get選挙番号())) {
                    source.senkyoMei7 = 選挙.get選挙名称();
                    source.senkyoRyakusho7 = 選挙.get選挙略称();
                }
                if (SIX.equals(選挙.get選挙番号())) {
                    source.senkyoMei6 = 選挙.get選挙名称();
                    source.senkyoRyakusho6 = 選挙.get選挙略称();
                }
                if (EIGHT.equals(選挙.get選挙番号())) {
                    source.senkyoMei8 = 選挙.get選挙名称();
                    source.senkyoRyakusho8 = 選挙.get選挙略称();
                }
                if (NINE.equals(選挙.get選挙番号())) {
                    source.senkyoMei9 = 選挙.get選挙名称();
                    source.senkyoRyakusho9 = 選挙.get選挙略称();
                }
            }
        }
    }

    private RString edit明細情報住所取得(AtenaJusho 住所, AtenaBanchi 番地, RString 行政区名,
            RString 地区名１, RString 地区名２, RString 地区名３) {
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        行政区名 = changeNullToEmpty(行政区名);
        地区名３ = changeNullToEmpty(地区名３);
        地区名２ = changeNullToEmpty(地区名２);
        地区名１ = changeNullToEmpty(地区名１);

        RString 編集用住所 = RString.EMPTY;
        RString 入場券_明細部住所編集 = BusinessConfig.get(ConfigKeysAFA.入場券_明細部住所編集, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 住所文字列;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 住所文字列.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 行政区名;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区1.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名１;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区2.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名２;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区3.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 地区名３;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所 = 行政区名.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        return 編集用住所;
    }

    private void edit住所(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.jusho_1 = edit明細情報住所取得(data.get明細情報1().get住登内住所(),
                    data.get明細情報1().get住登内番地(),
                    data.get明細情報1().get行政区名(),
                    data.get明細情報1().get地区名1(),
                    data.get明細情報1().get地区名2(),
                    data.get明細情報1().get地区名3());
            source.jushoCode1 = data.get明細情報1().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報1().get住登内住所();
            if (null != 住登内住所) {
                source.jusho1 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報2()) {
            source.jusho_2 = edit明細情報住所取得(data.get明細情報2().get住登内住所(),
                    data.get明細情報2().get住登内番地(),
                    data.get明細情報2().get行政区名(),
                    data.get明細情報2().get地区名1(),
                    data.get明細情報2().get地区名2(),
                    data.get明細情報2().get地区名3());
            source.jushoCode2 = data.get明細情報2().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報2().get住登内住所();
            if (null != 住登内住所) {
                source.jusho2 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報3()) {
            source.jusho_3 = edit明細情報住所取得(data.get明細情報3().get住登内住所(),
                    data.get明細情報3().get住登内番地(),
                    data.get明細情報3().get行政区名(),
                    data.get明細情報3().get地区名1(),
                    data.get明細情報3().get地区名2(),
                    data.get明細情報3().get地区名3());
            source.jushoCode3 = data.get明細情報3().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報3().get住登内住所();
            if (null != 住登内住所) {
                source.jusho3 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報4()) {
            source.jusho_4 = edit明細情報住所取得(data.get明細情報4().get住登内住所(),
                    data.get明細情報4().get住登内番地(),
                    data.get明細情報4().get行政区名(),
                    data.get明細情報4().get地区名1(),
                    data.get明細情報4().get地区名2(),
                    data.get明細情報4().get地区名3());
            source.jushoCode4 = data.get明細情報4().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報4().get住登内住所();
            if (null != 住登内住所) {
                source.jusho4 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報5()) {
            source.jusho_5 = edit明細情報住所取得(data.get明細情報5().get住登内住所(),
                    data.get明細情報5().get住登内番地(),
                    data.get明細情報5().get行政区名(),
                    data.get明細情報5().get地区名1(),
                    data.get明細情報5().get地区名2(),
                    data.get明細情報5().get地区名3());
            source.jushoCode5 = data.get明細情報5().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報5().get住登内住所();
            if (null != 住登内住所) {
                source.jusho5 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報6()) {
            source.jusho_6 = edit明細情報住所取得(data.get明細情報6().get住登内住所(),
                    data.get明細情報6().get住登内番地(),
                    data.get明細情報6().get行政区名(),
                    data.get明細情報6().get地区名1(),
                    data.get明細情報6().get地区名2(),
                    data.get明細情報6().get地区名3());
            source.jushoCode6 = data.get明細情報6().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報6().get住登内住所();
            if (null != 住登内住所) {
                source.jusho6 = 住登内住所.getColumnValue();
            }
        }

        source.jusho11 = data.getJusho11();
        source.jusho21 = data.getJusho21();
        source.jusho13 = data.getJusho13();
        source.jusho12 = data.getJusho12();
        source.jusho23 = data.getJusho23();
        source.jusho22 = data.getJusho22();
        source.jusho14 = data.getJusho14();
        source.jusho24 = data.getJusho24();
        source.jusho15 = data.getJusho15();
        source.jusho25 = data.getJusho25();
        source.jusho16 = data.getJusho16();
        source.jusho26 = data.getJusho26();
    }

    private void edit性別(NyujokenPostexSource source) {
        RString 性別1 = null == data.getSeibetsu1() ? RString.EMPTY : data.getSeibetsu1();
        RString 性別2 = null == data.getSeibetsu2() ? RString.EMPTY : data.getSeibetsu2();
        RString 性別3 = null == data.getSeibetsu3() ? RString.EMPTY : data.getSeibetsu3();
        RString 性別4 = null == data.getSeibetsu4() ? RString.EMPTY : data.getSeibetsu4();
        RString 性別5 = null == data.getSeibetsu5() ? RString.EMPTY : data.getSeibetsu5();
        RString 性別6 = null == data.getSeibetsu6() ? RString.EMPTY : data.getSeibetsu6();
        source.seibetsu1 = 性別1;
        source.seibetsu2 = 性別2;
        source.seibetsu3 = 性別3;
        source.seibetsu4 = 性別4;
        source.seibetsu5 = 性別5;
        source.seibetsu6 = 性別6;
    }

    private void edit投票区コード(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            RString 投票区コード1 = data.get明細情報1().get投票区コード();
            RString tohyokuCode1 = null == 投票区コード1 ? RString.EMPTY : 投票区コード1;
            source.tohyokuCode1 = tohyokuCode1;
        }
        if (null != data.get明細情報2()) {
            RString 投票区コード2 = data.get明細情報2().get投票区コード();
            RString tohyokuCode2 = null == 投票区コード2 ? RString.EMPTY : 投票区コード2;
            source.tohyokuCode2 = tohyokuCode2;
        }
        if (null != data.get明細情報3()) {
            RString 投票区コード3 = data.get明細情報3().get投票区コード();
            RString tohyokuCode3 = null == 投票区コード3 ? RString.EMPTY : 投票区コード3;
            source.tohyokuCode3 = tohyokuCode3;
        }
        if (null != data.get明細情報6()) {
            RString 投票区コード6 = data.get明細情報6().get投票区コード();
            RString tohyokuCode6 = null == 投票区コード6 ? RString.EMPTY : 投票区コード6;
            source.tohyokuCode6 = tohyokuCode6;
        }
        if (null != data.get明細情報4()) {
            RString 投票区コード4 = data.get明細情報4().get投票区コード();
            RString tohyokuCode4 = null == 投票区コード4 ? RString.EMPTY : 投票区コード4;
            source.tohyokuCode4 = tohyokuCode4;
        }
        if (null != data.get明細情報5()) {
            RString 投票区コード5 = data.get明細情報5().get投票区コード();
            RString tohyokuCode5 = null == 投票区コード5 ? RString.EMPTY : 投票区コード5;
            source.tohyokuCode5 = tohyokuCode5;
        }
    }

    private void edit投票所名(NyujokenPostexSource source) {
        if (is文字切れ(getItemLength(長さ_投票所名21), data.getTohyojoMei21())) {
            source.tohyojoMei21 = data.getTohyojoMei21().substring(NUMBER_ZERO, getItemLength(長さ_投票所名21));
        } else {
            source.tohyojoMei21 = data.getTohyojoMei21();
        }
        if (is文字切れ(getItemLength(長さ_投票所名22), data.getTohyojoMei22())) {
            source.tohyojoMei22 = data.getTohyojoMei22().substring(NUMBER_ZERO, getItemLength(長さ_投票所名22));
        } else {
            source.tohyojoMei22 = data.getTohyojoMei22();
        }
        if (is文字切れ(getItemLength(長さ_投票所名11), data.getTohyojoMei11())) {
            source.tohyojoMei11 = data.getTohyojoMei11().substring(NUMBER_ZERO, getItemLength(長さ_投票所名11));
        } else {
            source.tohyojoMei11 = data.getTohyojoMei11();
        }
        if (is文字切れ(getItemLength(長さ_投票所名32), data.getTohyojoMei32())) {
            source.tohyojoMei32 = data.getTohyojoMei32().substring(NUMBER_ZERO, getItemLength(長さ_投票所名32));
        } else {
            source.tohyojoMei32 = data.getTohyojoMei32();
        }
        if (is文字切れ(getItemLength(長さ_投票所名12), data.getTohyojoMei12())) {
            source.tohyojoMei12 = data.getTohyojoMei12().substring(NUMBER_ZERO, getItemLength(長さ_投票所名12));
        } else {
            source.tohyojoMei12 = data.getTohyojoMei12();
        }
        if (is文字切れ(getItemLength(長さ_投票所名31), data.getTohyojoMei31())) {
            source.tohyojoMei31 = data.getTohyojoMei31().substring(NUMBER_ZERO, getItemLength(長さ_投票所名31));
        } else {
            source.tohyojoMei31 = data.getTohyojoMei31();
        }
        if (null != data.get明細情報1()) {
            source.tohyojoMei_1 = data.get明細情報1().get投票所名();
            source.tohyojoMei1 = data.get明細情報1().get投票所名();
        }
        if (null != data.get明細情報4()) {
            source.tohyojoMei_4 = data.get明細情報4().get投票所名();
            source.tohyojoMei4 = data.get明細情報4().get投票所名();
        }
        if (null != data.get明細情報2()) {
            source.tohyojoMei_2 = data.get明細情報2().get投票所名();
            source.tohyojoMei2 = data.get明細情報2().get投票所名();
        }
        if (null != data.get明細情報5()) {
            source.tohyojoMei_5 = data.get明細情報5().get投票所名();
            source.tohyojoMei5 = data.get明細情報5().get投票所名();
        }
        if (null != data.get明細情報6()) {
            source.tohyojoMei_6 = data.get明細情報6().get投票所名();
            source.tohyojoMei6 = data.get明細情報6().get投票所名();
        }
        if (null != data.get明細情報3()) {
            source.tohyojoMei_3 = data.get明細情報3().get投票所名();
            source.tohyojoMei3 = data.get明細情報3().get投票所名();
        }
        if (is文字切れ(getItemLength(長さ_投票所名33), data.getTohyojoMei33())) {
            source.tohyojoMei33 = data.getTohyojoMei33().substring(NUMBER_ZERO, getItemLength(長さ_投票所名33));
        } else {
            source.tohyojoMei33 = data.getTohyojoMei33();
        }
        if (is文字切れ(getItemLength(長さ_投票所名13), data.getTohyojoMei13())) {
            source.tohyojoMei13 = data.getTohyojoMei13().substring(NUMBER_ZERO, getItemLength(長さ_投票所名13));
        } else {
            source.tohyojoMei13 = data.getTohyojoMei13();
        }
        if (is文字切れ(getItemLength(長さ_投票所名23), data.getTohyojoMei23())) {
            source.tohyojoMei23 = data.getTohyojoMei23().substring(NUMBER_ZERO, getItemLength(長さ_投票所名23));
        } else {
            source.tohyojoMei23 = data.getTohyojoMei23();
        }
        投票所名文字切れ(source);
    }

    private void 投票所名文字切れ(NyujokenPostexSource source) {
        if (is文字切れ(getItemLength(長さ_投票所名24), data.getTohyojoMei24())) {
            source.tohyojoMei24 = data.getTohyojoMei24().substring(NUMBER_ZERO, getItemLength(長さ_投票所名24));
        } else {
            source.tohyojoMei24 = data.getTohyojoMei24();
        }
        if (is文字切れ(getItemLength(長さ_投票所名14), data.getTohyojoMei14())) {
            source.tohyojoMei14 = data.getTohyojoMei14().substring(NUMBER_ZERO, getItemLength(長さ_投票所名14));
        } else {
            source.tohyojoMei14 = data.getTohyojoMei14();
        }
        if (is文字切れ(getItemLength(長さ_投票所名34), data.getTohyojoMei34())) {
            source.tohyojoMei34 = data.getTohyojoMei34().substring(NUMBER_ZERO, getItemLength(長さ_投票所名34));
        } else {
            source.tohyojoMei34 = data.getTohyojoMei34();
        }
        if (is文字切れ(getItemLength(長さ_投票所名15), data.getTohyojoMei15())) {
            source.tohyojoMei15 = data.getTohyojoMei15().substring(NUMBER_ZERO, getItemLength(長さ_投票所名15));
        } else {
            source.tohyojoMei15 = data.getTohyojoMei15();
        }
        if (is文字切れ(getItemLength(長さ_投票所名35), data.getTohyojoMei35())) {
            source.tohyojoMei35 = data.getTohyojoMei35().substring(NUMBER_ZERO, getItemLength(長さ_投票所名35));
        } else {
            source.tohyojoMei35 = data.getTohyojoMei35();
        }
        if (is文字切れ(getItemLength(長さ_投票所名25), data.getTohyojoMei25())) {
            source.tohyojoMei25 = data.getTohyojoMei25().substring(NUMBER_ZERO, getItemLength(長さ_投票所名25));
        } else {
            source.tohyojoMei25 = data.getTohyojoMei25();
        }
        if (is文字切れ(getItemLength(長さ_投票所名16), data.getTohyojoMei16())) {
            source.tohyojoMei16 = data.getTohyojoMei16().substring(NUMBER_ZERO, getItemLength(長さ_投票所名16));
        } else {
            source.tohyojoMei16 = data.getTohyojoMei16();
        }
        if (is文字切れ(getItemLength(長さ_投票所名26), data.getTohyojoMei26())) {
            source.tohyojoMei26 = data.getTohyojoMei26().substring(NUMBER_ZERO, getItemLength(長さ_投票所名26));
        } else {
            source.tohyojoMei26 = data.getTohyojoMei26();
        }
        if (is文字切れ(getItemLength(長さ_投票所名16), data.getTohyojoMei16())) {
            source.tohyojoMei16 = data.getTohyojoMei16().substring(NUMBER_ZERO, getItemLength(長さ_投票所名16));
        } else {
            source.tohyojoMei16 = data.getTohyojoMei16();
        }
        if (is文字切れ(getItemLength(長さ_投票所名36), data.getTohyojoMei36())) {
            source.tohyojoMei36 = data.getTohyojoMei36().substring(NUMBER_ZERO, getItemLength(長さ_投票所名36));
        } else {
            source.tohyojoMei36 = data.getTohyojoMei36();
        }
        if (is文字切れ(getItemLength(長さ_投票所名26), data.getTohyojoMei26())) {
            source.tohyojoMei26 = data.getTohyojoMei26().substring(NUMBER_ZERO, getItemLength(長さ_投票所名26));
        } else {
            source.tohyojoMei26 = data.getTohyojoMei26();
        }
        if (is文字切れ(getItemLength(長さ_投票所名36), data.getTohyojoMei36())) {
            source.tohyojoMei36 = data.getTohyojoMei36().substring(NUMBER_ZERO, getItemLength(長さ_投票所名36));
        } else {
            source.tohyojoMei36 = data.getTohyojoMei36();
        }
    }

    private void edit投票開始時刻(NyujokenPostexSource source) {
        if (null != data.get明細情報1() && null != data.get明細情報1().get投票開始時刻()) {
            source.tohyoTimeStart1_nn = data.get明細情報1().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分)
                    .substring(郵便番号_上3桁, NUMBER_FIVE);
            source.tohyoTimeStart1_hh = data.get明細情報1().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
        }
        if (null != data.get明細情報2() && null != data.get明細情報2().get投票開始時刻()) {
            source.tohyoTimeStart2_hh = data.get明細情報2().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeStart2_nn = data.get明細情報2().get投票開始時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報3() && null != data.get明細情報3().get投票開始時刻()) {
            source.tohyoTimeStart3_nn = data.get明細情報3().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分)
                    .substring(郵便番号_上3桁, NUMBER_FIVE);
            source.tohyoTimeStart3_hh = data.get明細情報3().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
        }
        if (null != data.get明細情報6() && null != data.get明細情報6().get投票開始時刻()) {
            source.tohyoTimeStart6_hh = data.get明細情報6().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeStart6_nn = data.get明細情報6().get投票開始時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報4() && null != data.get明細情報4().get投票開始時刻()) {
            source.tohyoTimeStart4_nn = data.get明細情報4().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分)
                    .substring(郵便番号_上3桁, NUMBER_FIVE);
            source.tohyoTimeStart4_hh = data.get明細情報4().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
        }
        if (null != data.get明細情報5() && null != data.get明細情報5().get投票開始時刻()) {
            source.tohyoTimeStart5_nn = data.get明細情報5().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分)
                    .substring(郵便番号_上3桁, NUMBER_FIVE);
            source.tohyoTimeStart5_hh = data.get明細情報5().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
        }
    }

    private void edit投票終了時刻(NyujokenPostexSource source) {
        if (null != data.get明細情報1() && null != data.get明細情報1().get投票終了時刻()) {
            source.tohyoTimeEnd1_hh = data.get明細情報1().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeEnd1_nn = data.get明細情報1().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報5() && null != data.get明細情報5().get投票終了時刻()) {
            source.tohyoTimeEnd5_hh = data.get明細情報5().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeEnd5_nn = data.get明細情報5().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報2() && null != data.get明細情報2().get投票終了時刻()) {
            source.tohyoTimeEnd2_nn = data.get明細情報2().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分)
                    .substring(郵便番号_上3桁, NUMBER_FIVE);
            source.tohyoTimeEnd2_hh = data.get明細情報2().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
        }
        if (null != data.get明細情報3() && null != data.get明細情報3().get投票終了時刻()) {
            source.tohyoTimeEnd3_hh = data.get明細情報3().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeEnd3_nn = data.get明細情報3().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報4() && null != data.get明細情報4().get投票終了時刻()) {
            source.tohyoTimeEnd4_hh = data.get明細情報4().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeEnd4_nn = data.get明細情報4().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
        if (null != data.get明細情報6() && null != data.get明細情報6().get投票終了時刻()) {
            source.tohyoTimeEnd6_hh = data.get明細情報6().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            source.tohyoTimeEnd6_nn = data.get明細情報6().get投票終了時刻()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
        }
    }

    private void edit入場券バーコード(NyujokenPostexSource source) {
        source.barcodeNyujokenBarcode1 = data.getBarcodeNyujokenBarcode1();
        source.barcodeNyujokenBarcode2 = data.getBarcodeNyujokenBarcode2();
        source.barcodeNyujokenBarcode3 = data.getBarcodeNyujokenBarcode3();
        source.barcodeNyujokenBarcode4 = data.getBarcodeNyujokenBarcode4();
        source.barcodeNyujokenBarcode5 = data.getBarcodeNyujokenBarcode5();
        source.barcodeNyujokenBarcode6 = data.getBarcodeNyujokenBarcode6();
    }

    private void editアクセスログ出力(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.識別コード1 = data.get明細情報1().get識別コード();
            source.個人番号使用1 = KojinNo.EMPTY;
            source.法人番号使用1 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報4()) {
            source.識別コード4 = data.get明細情報4().get識別コード();
            source.個人番号使用4 = KojinNo.EMPTY;
            source.法人番号使用4 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報6()) {
            source.識別コード6 = data.get明細情報6().get識別コード();
            source.個人番号使用6 = KojinNo.EMPTY;
            source.法人番号使用6 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報2()) {
            source.識別コード2 = data.get明細情報2().get識別コード();
            source.個人番号使用2 = KojinNo.EMPTY;
            source.法人番号使用2 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報5()) {
            source.識別コード5 = data.get明細情報5().get識別コード();
            source.個人番号使用5 = KojinNo.EMPTY;
            source.法人番号使用5 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報3()) {
            source.識別コード3 = data.get明細情報3().get識別コード();
            source.個人番号使用3 = KojinNo.EMPTY;
            source.法人番号使用3 = HojinNo.EMPTY;
        }
    }

    private void edit識別コード(NyujokenPostexSource source) {
        if (null != data.get明細情報1()) {
            source.shikibetsuCode1 = null == data.get明細情報1().get識別コード() ? RString.EMPTY : data.get明細情報1().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_1 = null == data.get明細情報1().get識別コード() ? RString.EMPTY : data.get明細情報1().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報2()) {
            source.shikibetsuCode2 = null == data.get明細情報2().get識別コード() ? RString.EMPTY : data.get明細情報2().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_2 = null == data.get明細情報2().get識別コード() ? RString.EMPTY : data.get明細情報2().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報6()) {
            source.shikibetsuCode6 = null == data.get明細情報6().get識別コード() ? RString.EMPTY : data.get明細情報6().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_6 = null == data.get明細情報6().get識別コード() ? RString.EMPTY : data.get明細情報6().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報3()) {
            source.shikibetsuCode3 = null == data.get明細情報3().get識別コード() ? RString.EMPTY : data.get明細情報3().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_3 = null == data.get明細情報3().get識別コード() ? RString.EMPTY : data.get明細情報3().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報4()) {
            source.shikibetsuCode4 = null == data.get明細情報4().get識別コード() ? RString.EMPTY : data.get明細情報4().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_4 = null == data.get明細情報4().get識別コード() ? RString.EMPTY : data.get明細情報4().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報5()) {
            source.shikibetsuCode5 = null == data.get明細情報5().get識別コード() ? RString.EMPTY : data.get明細情報5().get識別コード().getColumnValue();
            source.shikibetsuCode_Postex_5 = null == data.get明細情報5().get識別コード() ? RString.EMPTY : data.get明細情報5().get識別コード().getColumnValue();
        }
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NyujokenPostexSource.class, itemName);
    }

    private Boolean is文字切れ(int 文字最大数, RString 編集文字) {
        if (RString.isNullOrEmpty(編集文字)) {
            return Boolean.FALSE;
        }
        if (編集文字.length() > 文字最大数) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return null == 文字列 ? RString.EMPTY : 文字列;
    }
}
