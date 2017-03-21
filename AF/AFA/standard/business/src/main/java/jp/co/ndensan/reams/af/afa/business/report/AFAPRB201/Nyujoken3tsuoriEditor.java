package jp.co.ndensan.reams.af.afa.business.report.AFAPRB201;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
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

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriEditor implements INyujoken3tsuoriEditor {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_SIX = 6;
    private static final int NUMBER_FIVE = 5;
    private static final int NUMBER_SEVEN = 7;
    private static final int NUMBER_FOUR = 4;
    private static final int 郵便番号_上3桁 = 3;
    private static final int NUMBER_NINE = 9;
    private static final RString TWO = new RString("2");
    private static final RString ONE = new RString("1");
    private static final RString THREE = new RString("3");
    private static final RString FIVE = new RString("5");
    private static final RString SIX = new RString("6");
    private static final RString FOUR = new RString("4");
    private static final RString EIGHT = new RString("8");
    private static final RString SEVEN = new RString("7");
    private static final RString NINE = new RString("9");
    private static final RString 長さ_世帯主名2 = new RString("setainushiMei2");
    private static final RString 長さ_世帯主名1 = new RString("setainushiMei1");
    private static final RString 長さ_世帯主名3 = new RString("setainushiMei3");
    private static final RString 長さ_名称21 = new RString("shimei21");
    private static final RString 長さ_名称11 = new RString("shimei11");
    private static final RString 長さ_名称12 = new RString("shimei12");
    private static final RString 長さ_名称31 = new RString("shimei31");
    private static final RString 長さ_名称32 = new RString("shimei32");
    private static final RString 長さ_名称22 = new RString("shimei22");
    private static final RString 長さ_名称13 = new RString("shimei13");
    private static final RString 長さ_名称23 = new RString("shimei23");
    private static final RString 長さ_名称33 = new RString("shimei33");
    private static final RString 長さ_カナ名称21 = new RString("shimeiKana21");
    private static final RString 長さ_カナ名称11 = new RString("shimeiKana11");
    private static final RString 長さ_カナ名称22 = new RString("shimeiKana22");
    private static final RString 長さ_カナ名称12 = new RString("shimeiKana12");
    private static final RString 長さ_カナ名称13 = new RString("shimeiKana13");
    private static final RString 長さ_カナ名称23 = new RString("shimeiKana23");
    private static final RString 長さ_投票所名21 = new RString("tohyojoMei21");
    private static final RString 長さ_投票所名11 = new RString("tohyojoMei11");
    private static final RString 長さ_投票所名12 = new RString("tohyojoMei12");
    private static final RString 長さ_投票所名31 = new RString("tohyojoMei31");
    private static final RString 長さ_投票所名32 = new RString("tohyojoMei32");
    private static final RString 長さ_投票所名22 = new RString("tohyojoMei22");
    private static final RString 長さ_投票所名23 = new RString("tohyojoMei23");
    private static final RString 長さ_投票所名13 = new RString("tohyojoMei13");
    private static final RString 長さ_投票所名33 = new RString("tohyojoMei33");

    private final Nyujoken3tsuoriParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link Nyujoken3tsuoriParam}
     */
    public Nyujoken3tsuoriEditor(Nyujoken3tsuoriParam data) {
        this.data = data;
    }

    /**
     * 投票所入場券（個票3つ折り）エディットメソッド
     *
     * @param source 投票所入場券（個票3つ折り）
     * @return 投票所入場券（個票3つ折り）
     */
    @Override
    public Nyujoken3tsuoriSource edit(Nyujoken3tsuoriSource source) {
        edit共通情報(source);
        edit送付先情報(source);
        edit明細情報(source);
        editアクセスログ出力(source);
        return source;
    }

    private void edit共通情報(Nyujoken3tsuoriSource source) {
        edit入場券名称(source);
        edit抄本番号(source);
        edit抄本名(source);
        edit選挙(source);
        edit投票年月日(source);
        edit告示年月日(source);
        edit市町村名(source);
        editサンプル文字(source);
    }

    private void edit送付先情報(Nyujoken3tsuoriSource source) {
        edit整理番号(source);
        edit送付先(source);
        edit送付先郵便(source);
        editカスタマーバーコード(source);
        edit送付先行政区(source);
        edit宛名(source);
        edit送付先地区名(source);
        edit送付先名簿番号(source);
        edit送付先世帯コード(source);
        edit地図情報(source);
        edit世帯主名(source);
    }

    private void edit明細情報(Nyujoken3tsuoriSource source) {
        edit住所(source);
        edit名称(source);
        editカナ名称(source);
        edit世帯(source);
        edit性別(source);
        edit生年月日(source);
        edit投票(source);
        edit識別コード(source);
        edit頁_行(source);
        edit名簿番号(source);
        edit入場券バーコード(source);
        edit行政区(source);
        edit地区(source);
    }

    private void edit送付先世帯コード(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1()) {
            SetaiCode 送付先世帯コード1 = data.get送付先情報1().get送付先世帯コード();
            source.sofusakiSetaiCode1 = null == 送付先世帯コード1 ? RString.EMPTY : 送付先世帯コード1.getColumnValue();
        }
        if (null != data.get送付先情報2()) {
            SetaiCode 送付先世帯コード2 = data.get送付先情報2().get送付先世帯コード();
            source.sofusakiSetaiCode2 = null == 送付先世帯コード2 ? RString.EMPTY : 送付先世帯コード2.getColumnValue();
        }
        if (null != data.get送付先情報3()) {
            SetaiCode 送付先世帯コード3 = data.get送付先情報3().get送付先世帯コード();
            source.sofusakiSetaiCode3 = null == 送付先世帯コード3 ? RString.EMPTY : 送付先世帯コード3.getColumnValue();
        }
    }

    private void edit市町村名(Nyujoken3tsuoriSource source) {
        source.shichosonName = data.get地方公共団体情報().get市町村名();
    }

    private void edit地図情報(Nyujoken3tsuoriSource source) {
        source.mapJoho1 = data.getMapJoho1();
        source.mapJoho2 = data.getMapJoho2();
        source.mapJoho3 = data.getMapJoho3();
    }

    private void edit送付先名簿番号(Nyujoken3tsuoriSource source) {
        source.sofusakiMeiboNo1 = data.getSofusakiMeiboNo1();
        source.sofusakiMeiboNo2 = data.getSofusakiMeiboNo2();
        source.sofusakiMeiboNo3 = data.getSofusakiMeiboNo3();
    }

    private void edit送付先地区名(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1()) {
            source.sofusakiChikuName1 = data.get送付先情報1().get送付先地区名1();
        }
        if (null != data.get送付先情報2()) {
            source.sofusakiChikuName2 = data.get送付先情報2().get送付先地区名1();
        }
        if (null != data.get送付先情報3()) {
            source.sofusakiChikuName3 = data.get送付先情報3().get送付先地区名1();
        }
    }

    private void edit宛名(Nyujoken3tsuoriSource source) {
        source.atena11 = data.getAtena11();
        source.atena21 = data.getAtena21();
        source.atena31 = data.getAtena31();
        source.atena12 = data.getAtena12();
        source.atena22 = data.getAtena22();
        source.atena32 = data.getAtena32();
        source.atena13 = data.getAtena13();
        source.atena23 = data.getAtena23();
        source.atena33 = data.getAtena33();
    }

    private void edit送付先行政区(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1()) {
            GyoseikuCode 送付先行政区コード = data.get送付先情報1().get送付先行政区コード();
            if (null != 送付先行政区コード) {
                source.sofusakiGyoseikuCode1 = 送付先行政区コード.getColumnValue();
            }
        }
        if (null != data.get送付先情報2()) {
            GyoseikuCode 送付先行政区コード = data.get送付先情報2().get送付先行政区コード();
            if (null != 送付先行政区コード) {
                source.sofusakiGyoseikuCode2 = 送付先行政区コード.getColumnValue();
            }
        }
        if (null != data.get送付先情報3()) {
            GyoseikuCode 送付先行政区コード = data.get送付先情報3().get送付先行政区コード();
            if (null != 送付先行政区コード) {
                source.sofusakiGyoseikuCode3 = 送付先行政区コード.getColumnValue();
            }
        }
        source.sofusakiGyoseikuMei11 = data.getSofusakiGyoseikuMei11();
        source.sofusakiGyoseikuMei21 = data.getSofusakiGyoseikuMei21();
        source.sofusakiGyoseikuMei31 = data.getSofusakiGyoseikuMei31();
        source.sofusakiGyoseikuMei12 = data.getSofusakiGyoseikuMei12();
        source.sofusakiGyoseikuMei22 = data.getSofusakiGyoseikuMei22();
        source.sofusakiGyoseikuMei32 = data.getSofusakiGyoseikuMei32();
        source.sofusakiGyoseikuMei13 = data.getSofusakiGyoseikuMei13();
        source.sofusakiGyoseikuMei23 = data.getSofusakiGyoseikuMei23();
        source.sofusakiGyoseikuMei33 = data.getSofusakiGyoseikuMei33();
    }

    private void editカスタマーバーコード(Nyujoken3tsuoriSource source) {
        source.barcodeCustombarcode1 = data.getBarcodeCustombarcode1();
        source.barcodeCustombarcode2 = data.getBarcodeCustombarcode2();
        source.barcodeCustombarcode3 = data.getBarcodeCustombarcode3();
    }

    private void edit送付先郵便(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1() && null != data.get送付先情報1().get送付先郵便番号()) {
            YubinNo 郵便番号17 = data.get送付先情報1().get送付先郵便番号();
            source.yubinNo11 = new RString(郵便番号17.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号17.toString().length() > 郵便番号_上3桁) {
                source.yubinNo21 = new RString(郵便番号17.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
            source.yubinNo1 = 郵便番号17.getColumnValue();
        }
        if (null != data.get送付先情報2() && null != data.get送付先情報2().get送付先郵便番号()) {
            YubinNo 郵便番号28 = data.get送付先情報2().get送付先郵便番号();
            source.yubinNo12 = new RString(郵便番号28.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号28.toString().length() > 郵便番号_上3桁) {
                source.yubinNo22 = new RString(郵便番号28.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
            source.yubinNo2 = 郵便番号28.getColumnValue();
        }
        if (null != data.get送付先情報3() && null != data.get送付先情報3().get送付先郵便番号()) {
            YubinNo 郵便番号3 = data.get送付先情報3().get送付先郵便番号();
            source.yubinNo13 = new RString(郵便番号3.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号3.toString().length() > 郵便番号_上3桁) {
                source.yubinNo23 = new RString(郵便番号3.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
            source.yubinNo3 = 郵便番号3.getColumnValue();
        }
    }

    private void editサンプル文字(Nyujoken3tsuoriSource source) {
        source.txtSample = data.get入場券帳票作成入力情報().getサンプル文字();
    }

    private void edit告示年月日(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get告示年月日()) {
            RString 告示年月日 = data.get入場券帳票作成入力情報().get告示年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.kokujiYMD_gengou = get発行年号(data.get入場券帳票作成入力情報().get告示年月日());
            source.kokujiYMD = 告示年月日;
            source.kokujiYMD_yyyy = 告示年月日.substring(NUMBER_ONE, NUMBER_THREE);
            source.kokujiYMD_dd = 告示年月日.substring(NUMBER_SEVEN, NUMBER_NINE);
            source.kokujiYMD_mm = 告示年月日.substring(NUMBER_FOUR, NUMBER_SIX);
            source.kokujiYMD_youbi = new RString(data.get入場券帳票作成入力情報().get告示年月日().getDayOfWeek().getFullTerm());
        }
    }

    private void edit投票年月日(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get投票年月日()) {
            RString 投票年月日 = data.get入場券帳票作成入力情報().get投票年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.tohyoYMD = 投票年月日;
            source.tohyoYMD_gengou = get発行年号(data.get入場券帳票作成入力情報().get投票年月日());
            source.tohyoYMD_mm = 投票年月日.substring(NUMBER_FOUR, NUMBER_SIX);
            source.tohyoYMD_dd = 投票年月日.substring(NUMBER_SEVEN, NUMBER_NINE);
            source.tohyoYMD_yyyy = 投票年月日.substring(NUMBER_ONE, NUMBER_THREE);
            source.tohyoYMD_youbi = new RString(data.get入場券帳票作成入力情報().get投票年月日().getDayOfWeek().getFullTerm());
        }
    }

    private void edit選挙(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報() && null != data.get入場券帳票作成入力情報().get選挙名称()) {
            List<SenkyomeishouParam> 選挙リスト = data.get入場券帳票作成入力情報().get選挙名称();
            for (SenkyomeishouParam 選挙 : 選挙リスト) {
                if (ONE.equals(選挙.get選挙番号())) {
                    source.senkyoRyakusho1 = 選挙.get選挙略称();
                    source.senkyoMei1 = 選挙.get選挙名称();
                }
                if (THREE.equals(選挙.get選挙番号())) {
                    source.senkyoMei3 = 選挙.get選挙名称();
                    source.senkyoRyakusho3 = 選挙.get選挙略称();
                }
                if (TWO.equals(選挙.get選挙番号())) {
                    source.senkyoRyakusho2 = 選挙.get選挙略称();
                    source.senkyoMei2 = 選挙.get選挙名称();
                }
                if (FOUR.equals(選挙.get選挙番号())) {
                    source.senkyoRyakusho4 = 選挙.get選挙略称();
                    source.senkyoMei4 = 選挙.get選挙名称();
                }
                if (FIVE.equals(選挙.get選挙番号())) {
                    source.senkyoMei5 = 選挙.get選挙名称();
                    source.senkyoRyakusho5 = 選挙.get選挙略称();
                }
                if (SIX.equals(選挙.get選挙番号())) {
                    source.senkyoMei6 = 選挙.get選挙名称();
                    source.senkyoRyakusho6 = 選挙.get選挙略称();
                }
                if (SEVEN.equals(選挙.get選挙番号())) {
                    source.senkyoMei7 = 選挙.get選挙名称();
                    source.senkyoRyakusho7 = 選挙.get選挙略称();
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

    private void edit抄本名(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.shohonNo = data.get入場券帳票作成入力情報().get抄本名();
        }
    }

    private void edit抄本番号(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.shohonNo = data.get入場券帳票作成入力情報().get抄本番号();
        }
    }

    private void edit入場券名称(Nyujoken3tsuoriSource source) {
        if (null != data.get入場券帳票作成入力情報()) {
            source.nyujokenName1 = data.get入場券帳票作成入力情報().get入場券名称1();
            source.nyujokenName2 = data.get入場券帳票作成入力情報().get入場券名称2();
            source.nyujokenName3 = data.get入場券帳票作成入力情報().get入場券名称3();
        }
    }

    private void edit整理番号(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1()) {
            source.seiriNo1 = new RString(data.get送付先情報1().get整理番号());
        }
        if (null != data.get送付先情報3()) {
            source.seiriNo3 = new RString(data.get送付先情報3().get整理番号());
        }
        if (null != data.get送付先情報2()) {
            source.seiriNo2 = new RString(data.get送付先情報2().get整理番号());
        }
    }

    private void edit送付先(Nyujoken3tsuoriSource source) {
        if (null != data.get送付先情報1()) {
            ChoikiCode 送付先全国住所コード1 = data.get送付先情報1().get送付先全国住所コード();
            ChikuCode 送付先地区コード1 = data.get送付先情報1().get送付先地区コード1();
            source.sofusakiJushoCode1 = null == 送付先全国住所コード1 ? RString.EMPTY : 送付先全国住所コード1.getColumnValue();
            source.sofusakiChikuCode1 = null == 送付先地区コード1 ? RString.EMPTY : 送付先地区コード1.getColumnValue();
        }
        if (null != data.get送付先情報2()) {
            ChoikiCode 送付先全国住所コード2 = data.get送付先情報2().get送付先全国住所コード();
            ChikuCode 送付先地区コード2 = data.get送付先情報2().get送付先地区コード1();
            source.sofusakiJushoCode2 = null == 送付先全国住所コード2 ? RString.EMPTY : 送付先全国住所コード2.getColumnValue();
            source.sofusakiChikuCode2 = null == 送付先地区コード2 ? RString.EMPTY : 送付先地区コード2.getColumnValue();
        }
        if (null != data.get送付先情報3()) {
            ChoikiCode 送付先全国住所コード3 = data.get送付先情報3().get送付先全国住所コード();
            ChikuCode 送付先地区コード3 = data.get送付先情報3().get送付先地区コード1();
            source.sofusakiJushoCode3 = null == 送付先全国住所コード3 ? RString.EMPTY : 送付先全国住所コード3.getColumnValue();
            source.sofusakiChikuCode3 = null == 送付先地区コード3 ? RString.EMPTY : 送付先地区コード3.getColumnValue();
        }

        source.sofusakiJusho11 = data.getSofusakiJusho11();
        source.sofusakiJusho21 = data.getSofusakiJusho21();
        source.sofusakiJusho31 = data.getSofusakiJusho31();
        source.sofusakiJusho41 = data.getSofusakiJusho41();
        source.sofusakiJusho51 = data.getSofusakiJusho51();
        source.sofusakiJusho12 = data.getSofusakiJusho12();
        source.sofusakiJusho22 = data.getSofusakiJusho22();
        source.sofusakiJusho32 = data.getSofusakiJusho32();
        source.sofusakiJusho42 = data.getSofusakiJusho42();
        source.sofusakiJusho52 = data.getSofusakiJusho52();
        source.sofusakiJusho13 = data.getSofusakiJusho13();
        source.sofusakiJusho23 = data.getSofusakiJusho23();
        source.sofusakiJusho33 = data.getSofusakiJusho33();
        source.sofusakiJusho43 = data.getSofusakiJusho43();
        source.sofusakiJusho53 = data.getSofusakiJusho53();
    }

    private void edit世帯主名(Nyujoken3tsuoriSource source) {
        if (is文字切れ(getItemLength(長さ_世帯主名1), data.getSetainushiMei1())) {
            source.setainushiMei1 = data.getSetainushiMei1().substring(NUMBER_ZERO, getItemLength(長さ_世帯主名1));
        } else {
            source.setainushiMei1 = data.getSetainushiMei1();
        }
        if (null != data.get送付先情報1()) {
            source.setainushiMei_1 = null == data.get送付先情報1().get世帯主名() ? RString.EMPTY : data.get送付先情報1().get世帯主名().getColumnValue();
        }
        if (is文字切れ(getItemLength(長さ_世帯主名2), data.getSetainushiMei2())) {
            source.setainushiMei2 = data.getSetainushiMei2().substring(NUMBER_ZERO, getItemLength(長さ_世帯主名2));
        } else {
            source.setainushiMei2 = data.getSetainushiMei2();
        }
        if (null != data.get送付先情報2()) {
            source.setainushiMei_2 = null == data.get送付先情報2().get世帯主名() ? RString.EMPTY : data.get送付先情報2().get世帯主名().getColumnValue();
        }
        if (is文字切れ(getItemLength(長さ_世帯主名3), data.getSetainushiMei3())) {
            source.setainushiMei3 = data.getSetainushiMei3().substring(NUMBER_ZERO, getItemLength(長さ_世帯主名3));
        } else {
            source.setainushiMei3 = data.getSetainushiMei3();
        }
        if (null != data.get送付先情報3()) {
            source.setainushiMei_3 = null == data.get送付先情報3().get世帯主名() ? RString.EMPTY : data.get送付先情報3().get世帯主名().getColumnValue();
        }
    }

    private void edit世帯(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            SetaiCode 世帯コード = data.get明細情報1().get世帯コード();
            source.setainushiKubun1 = data.getSetainushiKubun1();
            source.setaiCode1 = null == 世帯コード ? RString.EMPTY : 世帯コード.getColumnValue();
        }
        if (null != data.get明細情報2()) {
            SetaiCode 世帯コード = data.get明細情報2().get世帯コード();
            source.setainushiKubun2 = data.getSetainushiKubun2();
            source.setaiCode2 = null == 世帯コード ? RString.EMPTY : 世帯コード.getColumnValue();
        }
        if (null != data.get明細情報3()) {
            SetaiCode 世帯コード = data.get明細情報3().get世帯コード();
            source.setainushiKubun3 = data.getSetainushiKubun3();
            source.setaiCode3 = null == 世帯コード ? RString.EMPTY : 世帯コード.getColumnValue();
        }
    }

    private void edit名称(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.shimei1 = data.get明細情報1().get名称();
            source.shimei_1 = data.get明細情報1().get名称();
        }
        if (null != data.get明細情報2()) {
            source.shimei_2 = data.get明細情報2().get名称();
            source.shimei2 = data.get明細情報2().get名称();
        }
        if (null != data.get明細情報3()) {
            source.shimei_3 = data.get明細情報3().get名称();
            source.shimei3 = data.get明細情報3().get名称();
        }
        if (is文字切れ(getItemLength(長さ_名称31), data.getShimei31())) {
            source.shimei31 = data.getShimei31().substring(NUMBER_ZERO, getItemLength(長さ_名称31));
        } else {
            source.shimei31 = data.getShimei31();
        }
        if (is文字切れ(getItemLength(長さ_名称11), data.getShimei11())) {
            source.shimei11 = data.getShimei11().substring(NUMBER_ZERO, getItemLength(長さ_名称11));
        } else {
            source.shimei11 = data.getShimei11();
        }
        if (is文字切れ(getItemLength(長さ_名称21), data.getShimei21())) {
            source.shimei21 = data.getShimei21().substring(NUMBER_ZERO, getItemLength(長さ_名称21));
        } else {
            source.shimei21 = data.getShimei21();
        }
        if (is文字切れ(getItemLength(長さ_名称12), data.getShimei12())) {
            source.shimei12 = data.getShimei12().substring(NUMBER_ZERO, getItemLength(長さ_名称12));
        } else {
            source.shimei12 = data.getShimei12();
        }
        if (is文字切れ(getItemLength(長さ_名称32), data.getShimei32())) {
            source.shimei32 = data.getShimei32().substring(NUMBER_ZERO, getItemLength(長さ_名称32));
        } else {
            source.shimei32 = data.getShimei32();
        }
        if (is文字切れ(getItemLength(長さ_名称22), data.getShimei22())) {
            source.shimei22 = data.getShimei22().substring(NUMBER_ZERO, getItemLength(長さ_名称22));
        } else {
            source.shimei22 = data.getShimei22();
        }
        if (is文字切れ(getItemLength(長さ_名称23), data.getShimei23())) {
            source.shimei23 = data.getShimei23().substring(NUMBER_ZERO, getItemLength(長さ_名称23));
        } else {
            source.shimei23 = data.getShimei23();
        }
        if (is文字切れ(getItemLength(長さ_名称13), data.getShimei13())) {
            source.shimei13 = data.getShimei13().substring(NUMBER_ZERO, getItemLength(長さ_名称13));
        } else {
            source.shimei13 = data.getShimei13();
        }
        if (is文字切れ(getItemLength(長さ_名称33), data.getShimei33())) {
            source.shimei33 = data.getShimei33().substring(NUMBER_ZERO, getItemLength(長さ_名称33));
        } else {
            source.shimei33 = data.getShimei33();
        }
    }

    private void editカナ名称(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.shimeiKana1 = data.get明細情報1().getカナ名称();
            source.shimeiKana_1 = data.get明細情報1().getカナ名称();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称11), data.getShimeiKana11())) {
            source.shimeiKana11 = data.getShimeiKana11().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称11));
        } else {
            source.shimeiKana11 = data.getShimeiKana11();
        }
        if (null != data.get明細情報2()) {
            source.shimeiKana_2 = data.get明細情報2().getカナ名称();
            source.shimeiKana2 = data.get明細情報2().getカナ名称();
        }
        if (null != data.get明細情報3()) {
            source.shimeiKana3 = data.get明細情報3().getカナ名称();
            source.shimeiKana_3 = data.get明細情報3().getカナ名称();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称21), data.getShimeiKana21())) {
            source.shimeiKana21 = data.getShimeiKana21().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称21));
        } else {
            source.shimeiKana21 = data.getShimeiKana21();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称22), data.getShimeiKana22())) {
            source.shimeiKana22 = data.getShimeiKana22().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称22));
        } else {
            source.shimeiKana22 = data.getShimeiKana22();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称23), data.getShimeiKana23())) {
            source.shimeiKana23 = data.getShimeiKana23().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称23));
        } else {
            source.shimeiKana23 = data.getShimeiKana23();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称12), data.getShimeiKana12())) {
            source.shimeiKana12 = data.getShimeiKana12().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称12));
        } else {
            source.shimeiKana12 = data.getShimeiKana12();
        }
        if (is文字切れ(getItemLength(長さ_カナ名称13), data.getShimeiKana13())) {
            source.shimeiKana13 = data.getShimeiKana13().substring(NUMBER_ZERO, getItemLength(長さ_カナ名称13));
        } else {
            source.shimeiKana13 = data.getShimeiKana13();
        }
    }

    private void edit生年月日(Nyujoken3tsuoriSource source) {
        source.seinengappi1 = data.getSeinengappi1();
        source.seinengappi2 = data.getSeinengappi2();
        source.seinengappi3 = data.getSeinengappi3();
    }

    private void edit性別(Nyujoken3tsuoriSource source) {
        source.seibetsu1 = data.getSeibetsu1();
        source.seibetsu2 = data.getSeibetsu2();
        source.seibetsu3 = data.getSeibetsu3();
    }

    private void edit投票(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報2()) {
            source.tohyokuCode2 = data.get明細情報2().get投票区コード();
            source.tohyojoMei2 = data.get明細情報2().get投票所名();
            source.tohyojoMei_2 = data.get明細情報2().get投票所名();
            source.tohyojoJusho2 = data.get明細情報2().get投票所＿住所();
            source.tohyokuMei2 = data.get明細情報2().get投票区名();
            if (null != data.get明細情報2().get投票開始時刻()) {
                source.tohyoTimeStart2_nn = data.get明細情報2().get投票開始時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
                source.tohyoTimeStart2_hh = data.get明細情報2().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            }
            if (null != data.get明細情報2().get投票終了時刻()) {
                source.tohyoTimeEnd2_hh = data.get明細情報2().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
                source.tohyoTimeEnd2_nn = data.get明細情報2().get投票終了時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
            }
        }
        if (null != data.get明細情報1()) {
            source.tohyokuCode1 = data.get明細情報1().get投票区コード();
            source.tohyojoMei_1 = data.get明細情報1().get投票所名();
            source.tohyojoMei1 = data.get明細情報1().get投票所名();
            source.tohyojoJusho1 = data.get明細情報1().get投票所＿住所();
            source.tohyokuMei1 = data.get明細情報1().get投票区名();
            if (null != data.get明細情報1().get投票開始時刻()) {
                source.tohyoTimeStart1_nn = data.get明細情報1().get投票開始時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
                source.tohyoTimeStart1_hh = data.get明細情報1().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            }
            if (null != data.get明細情報1().get投票終了時刻()) {
                source.tohyoTimeEnd1_hh = data.get明細情報1().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
                source.tohyoTimeEnd1_nn = data.get明細情報1().get投票終了時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
            }
        }
        if (null != data.get明細情報3()) {
            source.tohyokuCode3 = data.get明細情報3().get投票区コード();
            source.tohyojoMei3 = data.get明細情報3().get投票所名();
            source.tohyojoMei_3 = data.get明細情報3().get投票所名();
            source.tohyojoJusho3 = data.get明細情報3().get投票所＿住所();
            source.tohyokuMei3 = data.get明細情報3().get投票区名();
            if (null != data.get明細情報3().get投票開始時刻()) {
                source.tohyoTimeStart3_nn = data.get明細情報3().get投票開始時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
                source.tohyoTimeStart3_hh = data.get明細情報3().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
            }
            if (null != data.get明細情報3().get投票終了時刻()) {
                source.tohyoTimeEnd3_hh = data.get明細情報3().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(0, NUMBER_TWO);
                source.tohyoTimeEnd3_nn = data.get明細情報3().get投票終了時刻()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分).substring(郵便番号_上3桁, NUMBER_FIVE);
            }
        }
        if (is文字切れ(getItemLength(長さ_投票所名21), data.getTohyojoMei21())) {
            source.tohyojoMei21 = data.getTohyojoMei21().substring(NUMBER_ZERO, getItemLength(長さ_投票所名21));
        } else {
            source.tohyojoMei21 = data.getTohyojoMei21();
        }
        if (is文字切れ(getItemLength(長さ_投票所名31), data.getTohyojoMei31())) {
            source.tohyojoMei31 = data.getTohyojoMei31().substring(NUMBER_ZERO, getItemLength(長さ_投票所名31));
        } else {
            source.tohyojoMei31 = data.getTohyojoMei31();
        }
        if (is文字切れ(getItemLength(長さ_投票所名32), data.getTohyojoMei32())) {
            source.tohyojoMei32 = data.getTohyojoMei32().substring(NUMBER_ZERO, getItemLength(長さ_投票所名32));
        } else {
            source.tohyojoMei32 = data.getTohyojoMei32();
        }
        if (is文字切れ(getItemLength(長さ_投票所名33), data.getTohyojoMei33())) {
            source.tohyojoMei33 = data.getTohyojoMei33().substring(NUMBER_ZERO, getItemLength(長さ_投票所名33));
        } else {
            source.tohyojoMei33 = data.getTohyojoMei33();
        }
        if (is文字切れ(getItemLength(長さ_投票所名23), data.getTohyojoMei23())) {
            source.tohyojoMei23 = data.getTohyojoMei23().substring(NUMBER_ZERO, getItemLength(長さ_投票所名23));
        } else {
            source.tohyojoMei23 = data.getTohyojoMei23();
        }
        if (is文字切れ(getItemLength(長さ_投票所名13), data.getTohyojoMei13())) {
            source.tohyojoMei13 = data.getTohyojoMei13().substring(NUMBER_ZERO, getItemLength(長さ_投票所名13));
        } else {
            source.tohyojoMei13 = data.getTohyojoMei13();
        }
        if (is文字切れ(getItemLength(長さ_投票所名11), data.getTohyojoMei11())) {
            source.tohyojoMei11 = data.getTohyojoMei11().substring(NUMBER_ZERO, getItemLength(長さ_投票所名11));
        } else {
            source.tohyojoMei11 = data.getTohyojoMei11();
        }
        if (is文字切れ(getItemLength(長さ_投票所名12), data.getTohyojoMei12())) {
            source.tohyojoMei12 = data.getTohyojoMei12().substring(NUMBER_ZERO, getItemLength(長さ_投票所名12));
        } else {
            source.tohyojoMei12 = data.getTohyojoMei12();
        }
        if (is文字切れ(getItemLength(長さ_投票所名22), data.getTohyojoMei22())) {
            source.tohyojoMei22 = data.getTohyojoMei22().substring(NUMBER_ZERO, getItemLength(長さ_投票所名22));
        } else {
            source.tohyojoMei22 = data.getTohyojoMei22();
        }
    }

    private void edit識別コード(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報3()) {
            source.shikibetsuCode3 = null == data.get明細情報3().get識別コード() ? RString.EMPTY : data.get明細情報3().get識別コード().getColumnValue();
            source.shikibetsuCode_3tsuori_3 = null == data.get明細情報3().get識別コード() ? RString.EMPTY : data.get明細情報3().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報2()) {
            source.shikibetsuCode2 = null == data.get明細情報2().get識別コード() ? RString.EMPTY : data.get明細情報2().get識別コード().getColumnValue();
            source.shikibetsuCode_3tsuori_2 = null == data.get明細情報2().get識別コード() ? RString.EMPTY : data.get明細情報2().get識別コード().getColumnValue();
        }
        if (null != data.get明細情報1()) {
            source.shikibetsuCode_3tsuori_1 = null == data.get明細情報1().get識別コード() ? RString.EMPTY : data.get明細情報1().get識別コード().getColumnValue();
            source.shikibetsuCode1 = null == data.get明細情報1().get識別コード() ? RString.EMPTY : data.get明細情報1().get識別コード().getColumnValue();
        }
    }

    private void edit頁_行(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.meiboPage1 = new RString(data.get明細情報1().get頁());
            source.meiboGyo1 = new RString(data.get明細情報1().get行());
        }
        if (null != data.get明細情報3()) {
            source.meiboPage3 = new RString(data.get明細情報3().get頁());
            source.meiboGyo3 = new RString(data.get明細情報3().get行());
        }
        if (null != data.get明細情報2()) {
            source.meiboPage2 = new RString(data.get明細情報2().get頁());
            source.meiboGyo2 = new RString(data.get明細情報2().get行());
        }
    }

    private void editアクセスログ出力(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.識別コード1 = data.get明細情報1().get識別コード();
            source.個人番号使用1 = KojinNo.EMPTY;
            source.法人番号使用1 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報2()) {
            source.識別コード2 = data.get明細情報2().get識別コード();
            source.個人番号使用2 = KojinNo.EMPTY;
            source.法人番号使用2 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報3()) {
            source.識別コード3 = data.get明細情報3().get識別コード();
            source.個人番号使用3 = KojinNo.EMPTY;
            source.法人番号使用3 = HojinNo.EMPTY;
        }
    }

    private void edit地区(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.chikuCode11 = data.get明細情報1().get地区コード1();
            source.chikuCode21 = data.get明細情報1().get地区コード2();
            source.chikuCode31 = data.get明細情報1().get地区コード3();
            source.chikuName11 = data.get明細情報1().get地区名1();
            source.chikuName21 = data.get明細情報1().get地区名2();
            source.chikuName31 = data.get明細情報1().get地区名3();
        }
        if (null != data.get明細情報3()) {
            source.chikuCode13 = data.get明細情報3().get地区コード1();
            source.chikuCode23 = data.get明細情報3().get地区コード2();
            source.chikuCode33 = data.get明細情報3().get地区コード3();
            source.chikuName13 = data.get明細情報3().get地区名1();
            source.chikuName23 = data.get明細情報3().get地区名2();
            source.chikuName33 = data.get明細情報3().get地区名3();
        }
        if (null != data.get明細情報2()) {
            source.chikuCode12 = data.get明細情報2().get地区コード1();
            source.chikuCode22 = data.get明細情報2().get地区コード2();
            source.chikuCode32 = data.get明細情報2().get地区コード3();
            source.chikuName12 = data.get明細情報2().get地区名1();
            source.chikuName22 = data.get明細情報2().get地区名2();
            source.chikuName32 = data.get明細情報2().get地区名3();
        }
    }

    private void edit行政区(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.gyoseikuCode1 = data.get明細情報1().get行政区コード();
            source.gyoseikuMei1 = data.get明細情報1().get行政区名();
        }
        if (null != data.get明細情報3()) {
            source.gyoseikuCode3 = data.get明細情報3().get行政区コード();
            source.gyoseikuMei3 = data.get明細情報3().get行政区名();
        }
        if (null != data.get明細情報2()) {
            source.gyoseikuCode2 = data.get明細情報2().get行政区コード();
            source.gyoseikuMei2 = data.get明細情報2().get行政区名();
        }
    }

    private void edit入場券バーコード(Nyujoken3tsuoriSource source) {
        source.barcodeNyujokenBarcode1 = data.getBarcodeNyujokenBarcode1();
        source.barcodeNyujokenBarcode2 = data.getBarcodeNyujokenBarcode2();
        source.barcodeNyujokenBarcode3 = data.getBarcodeNyujokenBarcode3();
    }

    private void edit名簿番号(Nyujoken3tsuoriSource source) {
        source.meiboNo1 = data.getMeiboNo1();
        source.meiboNo2 = data.getMeiboNo2();
        source.meiboNo3 = data.getMeiboNo3();
    }

    private void edit住所(Nyujoken3tsuoriSource source) {
        if (null != data.get明細情報1()) {
            source.jushoCode1 = data.get明細情報1().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報1().get住登内住所();
            if (null != 住登内住所) {
                source.jusho1 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報3()) {
            source.jushoCode3 = data.get明細情報3().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報3().get住登内住所();
            if (null != 住登内住所) {
                source.jusho3 = 住登内住所.getColumnValue();
            }
        }
        if (null != data.get明細情報2()) {
            source.jushoCode2 = data.get明細情報2().get住登内町域コード();
            AtenaJusho 住登内住所 = data.get明細情報2().get住登内住所();
            if (null != 住登内住所) {
                source.jusho2 = 住登内住所.getColumnValue();
            }
        }
        source.jusho11 = data.getJusho11();
        source.jusho21 = data.getJusho21();
        source.jusho12 = data.getJusho12();
        source.jusho22 = data.getJusho22();
        source.jusho13 = data.getJusho13();
        source.jusho23 = data.getJusho23();
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

    private RString get発行年号(RDate 投票年月日4) {
        RString 発行年 = 投票年月日4.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getYear();
        RString 元号 = 発行年.substring(0, 2);
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        rsb.append(元号);
        return rsb.toRString();
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(Nyujoken3tsuoriSource.class, itemName);
    }
}
