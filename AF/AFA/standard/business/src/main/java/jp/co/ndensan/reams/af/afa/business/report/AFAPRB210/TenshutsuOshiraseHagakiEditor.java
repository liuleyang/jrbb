package jp.co.ndensan.reams.af.afa.business.report.AFAPRB210;

import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiEditor implements ITenshutsuOshiraseHagakiEditor {

    private static final int NUMBER_ZERO = 0;
    private static final int 郵便番号_上3桁 = 3;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_FIVE = 5;
    private static final int NUMBER_SEVEN = 7;
    private static final RString 投票所名21 = new RString("tohyojoName21");
    private static final RString 投票所名11 = new RString("tohyojoName11");
    private static final RString 投票所名12 = new RString("tohyojoName12");
    private static final RString 投票所名22 = new RString("tohyojoName22");
    private static final RString 投票所名23 = new RString("tohyojoName23");
    private static final RString 投票所名13 = new RString("tohyojoName13");
    private static final RString 投票所名24 = new RString("tohyojoName24");
    private static final RString 投票所名14 = new RString("tohyojoName14");
    private static final RString 住所11 = new RString("jusho11");
    private static final RString 住所31 = new RString("jusho31");
    private static final RString 住所21 = new RString("jusho21");
    private static final RString 住所51 = new RString("jusho51");
    private static final RString 住所41 = new RString("jusho41");
    private static final RString 住所22 = new RString("jusho22");
    private static final RString 住所12 = new RString("jusho12");
    private static final RString 住所32 = new RString("jusho32");
    private static final RString 住所52 = new RString("jusho52");
    private static final RString 住所42 = new RString("jusho42");
    private static final RString 住所13 = new RString("jusho13");
    private static final RString 住所23 = new RString("jusho23");
    private static final RString 住所43 = new RString("jusho43");
    private static final RString 住所33 = new RString("jusho33");
    private static final RString 住所53 = new RString("jusho53");
    private static final RString 住所24 = new RString("jusho24");
    private static final RString 住所14 = new RString("jusho14");
    private static final RString 住所34 = new RString("jusho34");
    private static final RString 住所44 = new RString("jusho44");
    private static final RString 住所54 = new RString("jusho54");
    private static final RString 転出前住所21 = new RString("oldJusho21");
    private static final RString 転出前住所11 = new RString("oldJusho11");
    private static final RString 転出前住所31 = new RString("oldJusho31");
    private static final RString 転出前住所12 = new RString("oldJusho12");
    private static final RString 転出前住所22 = new RString("oldJusho22");
    private static final RString 転出前住所32 = new RString("oldJusho32");
    private static final RString 転出前住所23 = new RString("oldJusho23");
    private static final RString 転出前住所13 = new RString("oldJusho13");
    private static final RString 転出前住所14 = new RString("oldJusho14");
    private static final RString 転出前住所24 = new RString("oldJusho24");
    private static final RString 転出前住所33 = new RString("oldJusho33");
    private static final RString 転出前住所34 = new RString("oldJusho34");
    private static final RString 名称11 = new RString("name11");
    private static final RString 名称31 = new RString("name31");
    private static final RString 名称21 = new RString("name21");
    private static final RString 名称12 = new RString("name12");
    private static final RString 名称13 = new RString("name13");
    private static final RString 名称22 = new RString("name22");
    private static final RString 名称32 = new RString("name32");
    private static final RString 名称14 = new RString("name14");
    private static final RString 名称23 = new RString("name23");
    private static final RString 名称33 = new RString("name33");
    private static final RString 名称34 = new RString("name34");
    private static final RString 名称24 = new RString("name24");
    private static final RString 空白 = new RString(" ");
    private static final RString 全角スペース = new RString("　");
    private final TenshutsuOshiraseHagakiParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link TenshutsuOshiraseHagakiParam}
     */
    public TenshutsuOshiraseHagakiEditor(TenshutsuOshiraseHagakiParam data) {

        this.data = data;
    }

    /**
     * 投票所入場券（ポステックス）エディットメソッド
     *
     * @param source 投票所入場券（ポステックス）
     * @return 投票所入場券（ポステックス）
     */
    @Override
    public TenshutsuOshiraseHagakiSource edit(TenshutsuOshiraseHagakiSource source) {
        edit郵便番号(source);
        edit投票区コード(source);
        edit頁(source);
        edit行(source);
        edit識別コード(source);
        edit投票開始時刻(source);
        edit投票終了時刻(source);
        edit明細住所(source);
        edit名称(source);
        editカナ名称(source);
        edit性別(source);
        edit地図情報(source);
        edit生年月日(source);
        edit行政区(source);
        edit地区(source);
        edit世帯(source);
        editカスタマーバーコード(source);
        editハガキ明細住所(source);
        edit入場券バーコード(source);
        edit投票所名(source);
        edit整理番号(source);
        editアクセスログ出力(source);
        return source;
    }

    private void edit世帯(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.setaiCode1 = null == data.get明細情報1().get世帯コード() ? RString.EMPTY : data.get明細情報1().get世帯コード().getColumnValue();
            source.setainushiMei1 = null == data.get明細情報1().get世帯主名() ? RString.EMPTY : data.get明細情報1().get世帯主名().getColumnValue();
        }
        if (null != data.get明細情報2()) {
            source.setaiCode2 = null == data.get明細情報2().get世帯コード() ? RString.EMPTY : data.get明細情報2().get世帯コード().getColumnValue();
            source.setainushiMei2 = null == data.get明細情報2().get世帯主名() ? RString.EMPTY : data.get明細情報2().get世帯主名().getColumnValue();
        }
        if (null != data.get明細情報3()) {
            source.setaiCode3 = null == data.get明細情報3().get世帯コード() ? RString.EMPTY : data.get明細情報3().get世帯コード().getColumnValue();
            source.setainushiMei3 = null == data.get明細情報3().get世帯主名() ? RString.EMPTY : data.get明細情報3().get世帯主名().getColumnValue();
        }
        if (null != data.get明細情報4()) {
            source.setaiCode4 = null == data.get明細情報4().get世帯コード() ? RString.EMPTY : data.get明細情報4().get世帯コード().getColumnValue();
            source.setainushiMei4 = null == data.get明細情報4().get世帯主名() ? RString.EMPTY : data.get明細情報4().get世帯主名().getColumnValue();
        }
    }

    private void edit地区(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.chikuCode11 = data.get明細情報1().get地区コード1();
            source.chikuName11 = data.get明細情報1().get地区名1();
            source.chikuCode22 = data.get明細情報1().get地区コード2();
            source.chikuName22 = data.get明細情報1().get地区名2();
            source.chikuCode33 = data.get明細情報1().get地区コード3();
            source.chikuName33 = data.get明細情報1().get地区名3();
        }
        if (null != data.get明細情報2()) {
            source.chikuCode12 = data.get明細情報2().get地区コード1();
            source.chikuName12 = data.get明細情報2().get地区名1();
            source.chikuCode22 = data.get明細情報2().get地区コード2();
            source.chikuName22 = data.get明細情報2().get地区名2();
            source.chikuCode33 = data.get明細情報2().get地区コード3();
            source.chikuName33 = data.get明細情報2().get地区名3();
        }
        if (null != data.get明細情報3()) {
            source.chikuCode13 = data.get明細情報3().get地区コード1();
            source.chikuName13 = data.get明細情報3().get地区名1();
            source.chikuCode23 = data.get明細情報3().get地区コード2();
            source.chikuName23 = data.get明細情報3().get地区名2();
            source.chikuCode33 = data.get明細情報3().get地区コード3();
            source.chikuName33 = data.get明細情報3().get地区名3();
        }
        if (null != data.get明細情報4()) {
            source.chikuCode14 = data.get明細情報4().get地区コード1();
            source.chikuName14 = data.get明細情報4().get地区名1();
            source.chikuCode14 = data.get明細情報4().get地区コード2();
            source.chikuName14 = data.get明細情報4().get地区名2();
            source.chikuCode14 = data.get明細情報4().get地区コード3();
            source.chikuName14 = data.get明細情報4().get地区名3();

        }
    }

    private void edit行政区(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.gyoseikuCode1 = data.get明細情報1().get行政区コード();
            source.gyoseikuMei1 = data.get明細情報1().get行政区名();
        }
        if (null != data.get明細情報4()) {
            source.gyoseikuCode4 = data.get明細情報4().get行政区コード();
            source.gyoseikuMei4 = data.get明細情報4().get行政区名();
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

    private void edit生年月日(TenshutsuOshiraseHagakiSource source) {
        source.seinengappi1 = data.getSeinengappi1();
        source.seinengappi2 = data.getSeinengappi2();
        source.seinengappi3 = data.getSeinengappi3();
        source.seinengappi4 = data.getSeinengappi4();
    }

    private void editカナ名称(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.kanaMeisho1 = data.get明細情報1().getカナ名称();
        }
        if (null != data.get明細情報2()) {
            source.kanaMeisho2 = data.get明細情報2().getカナ名称();
        }
        if (null != data.get明細情報3()) {
            source.kanaMeisho3 = data.get明細情報3().getカナ名称();
        }
        if (null != data.get明細情報4()) {
            source.kanaMeisho4 = data.get明細情報4().getカナ名称();
        }
    }

    private void edit性別(TenshutsuOshiraseHagakiSource source) {
        source.seibetu1 = data.getSeibetu1();
        source.seibetu2 = data.getSeibetu2();
        source.seibetu3 = data.getSeibetu3();
        source.seibetu4 = data.getSeibetu4();
    }

    private void edit郵便番号(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1() && null != data.get明細情報1().get送付先郵便番号()) {
            YubinNo 郵便番号 = data.get明細情報1().get送付先郵便番号();
            source.yubinNo11 = new RString(郵便番号.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号.toString().length() > 郵便番号_上3桁) {
                source.yubinNo21 = new RString(郵便番号.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
        }
        if (null != data.get明細情報2() && null != data.get明細情報2().get送付先郵便番号()) {
            YubinNo 郵便番号 = data.get明細情報2().get送付先郵便番号();
            source.yubinNo12 = new RString(郵便番号.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号.toString().length() > 郵便番号_上3桁) {
                source.yubinNo22 = new RString(郵便番号.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
        }
        if (null != data.get明細情報3() && null != data.get明細情報3().get送付先郵便番号()) {
            YubinNo 郵便番号 = data.get明細情報3().get送付先郵便番号();
            source.yubinNo13 = new RString(郵便番号.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号.toString().length() > 郵便番号_上3桁) {
                source.yubinNo23 = new RString(郵便番号.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
        }
        if (null != data.get明細情報4() && null != data.get明細情報4().get送付先郵便番号()) {
            YubinNo 郵便番号 = data.get明細情報4().get送付先郵便番号();
            source.yubinNo14 = new RString(郵便番号.toString().substring(0, 郵便番号_上3桁));
            if (郵便番号.toString().length() > 郵便番号_上3桁) {
                source.yubinNo24 = new RString(郵便番号.toString().substring(郵便番号_上3桁, NUMBER_SEVEN));
            }
        }
    }

    private void edit地図情報(TenshutsuOshiraseHagakiSource source) {
        source.mapJoho1 = data.getMapJoho1();
        source.mapJoho2 = data.getMapJoho2();
        source.mapJoho3 = data.getMapJoho3();
        source.mapJoho4 = data.getMapJoho4();
    }

    private void edit投票区コード(TenshutsuOshiraseHagakiSource source) {
        RString 投票区コード1 = null == data.get明細情報1() ? RString.EMPTY : data.get明細情報1().get投票区コード();
        RString 投票区コード2 = null == data.get明細情報2() ? RString.EMPTY : data.get明細情報2().get投票区コード();
        RString 投票区コード3 = null == data.get明細情報3() ? RString.EMPTY : data.get明細情報3().get投票区コード();
        RString 投票区コード4 = null == data.get明細情報4() ? RString.EMPTY : data.get明細情報4().get投票区コード();

        source.tohyokuCode1 = 投票区コード1;
        source.tohyokuCode2 = 投票区コード2;
        source.tohyokuCode3 = 投票区コード3;
        source.tohyokuCode4 = 投票区コード4;
    }

    private void edit頁(TenshutsuOshiraseHagakiSource source) {
        RString meiboPage1 = null == data.get明細情報1() ? RString.EMPTY : new RString(data.get明細情報1().get頁());
        RString meiboPage2 = null == data.get明細情報2() ? RString.EMPTY : new RString(data.get明細情報2().get頁());
        RString meiboPage3 = null == data.get明細情報3() ? RString.EMPTY : new RString(data.get明細情報3().get頁());
        RString meiboPage4 = null == data.get明細情報4() ? RString.EMPTY : new RString(data.get明細情報4().get頁());

        source.meiboPage1 = meiboPage1;
        source.meiboPage2 = meiboPage2;
        source.meiboPage3 = meiboPage3;
        source.meiboPage4 = meiboPage4;
    }

    private void edit行(TenshutsuOshiraseHagakiSource source) {
        RString meiboNo1 = null == data.get明細情報1() ? RString.EMPTY : new RString(data.get明細情報1().get行());
        RString meiboNo2 = null == data.get明細情報2() ? RString.EMPTY : new RString(data.get明細情報2().get行());
        RString meiboNo3 = null == data.get明細情報3() ? RString.EMPTY : new RString(data.get明細情報3().get行());
        RString meiboNo4 = null == data.get明細情報4() ? RString.EMPTY : new RString(data.get明細情報4().get行());

        source.meiboNo1 = meiboNo1;
        source.meiboNo2 = meiboNo2;
        source.meiboNo3 = meiboNo3;
        source.meiboNo4 = meiboNo4;
    }

    private void edit識別コード(TenshutsuOshiraseHagakiSource source) {
        ShikibetsuCode 識別コード1 = null == data.get明細情報1() ? ShikibetsuCode.EMPTY : data.get明細情報1().get識別コード();
        ShikibetsuCode 識別コード2 = null == data.get明細情報2() ? ShikibetsuCode.EMPTY : data.get明細情報2().get識別コード();
        ShikibetsuCode 識別コード3 = null == data.get明細情報3() ? ShikibetsuCode.EMPTY : data.get明細情報3().get識別コード();
        ShikibetsuCode 識別コード4 = null == data.get明細情報4() ? ShikibetsuCode.EMPTY : data.get明細情報4().get識別コード();

        source.shikibetsuCode_TenshutsushaHagaki_1 = null == 識別コード1 ? RString.EMPTY : 識別コード1.getColumnValue();
        source.shikibetsuCode_TenshutsushaHagaki_2 = null == 識別コード2 ? RString.EMPTY : 識別コード2.getColumnValue();
        source.shikibetsuCode_TenshutsushaHagaki_3 = null == 識別コード3 ? RString.EMPTY : 識別コード3.getColumnValue();
        source.shikibetsuCode_TenshutsushaHagaki_4 = null == 識別コード4 ? RString.EMPTY : 識別コード4.getColumnValue();

        source.data1 = null == 識別コード1 ? RString.EMPTY : 識別コード1.getColumnValue();
        source.data2 = null == 識別コード2 ? RString.EMPTY : 識別コード2.getColumnValue();
        source.data3 = null == 識別コード3 ? RString.EMPTY : 識別コード3.getColumnValue();
        source.data4 = null == 識別コード4 ? RString.EMPTY : 識別コード4.getColumnValue();

    }

    private void edit投票開始時刻(TenshutsuOshiraseHagakiSource source) {
        RString 転出者はがき_印字有無_開始時間 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_印字有無_開始時間, SubGyomuCode.AFA選挙本体);
        if (転出者はがき_印字有無_開始時間.equals(new RString("1"))) {
            RString tohyoTimeStart2 = RString.EMPTY;
            RString tohyoTimeStart3 = RString.EMPTY;
            RString tohyoTimeStart4 = RString.EMPTY;
            if (null != data.get明細情報1() && null != data.get明細情報1().get投票開始時刻()) {
                RString 投票開始時刻1 = data.get明細情報1().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                RString tohyoTimeStart1 = null == 投票開始時刻1 ? RString.EMPTY : 投票開始時刻1;
                source.tohyoTimeStart1_hh = tohyoTimeStart1.substring(0, NUMBER_TWO);
                source.tohyoTimeStart1_nn = tohyoTimeStart1.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報2() && null != data.get明細情報2().get投票開始時刻()) {
                RString 投票開始時刻2 = data.get明細情報2().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeStart2 = null == 投票開始時刻2 ? RString.EMPTY : 投票開始時刻2;
                source.tohyoTimeStart2_hh = tohyoTimeStart2.substring(0, NUMBER_TWO);
                source.tohyoTimeStart2_nn = tohyoTimeStart2.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報3() && null != data.get明細情報3().get投票開始時刻()) {
                RString 投票開始時刻3 = data.get明細情報3().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeStart3 = null == 投票開始時刻3 ? RString.EMPTY : 投票開始時刻3;
                source.tohyoTimeStart3_hh = tohyoTimeStart3.substring(0, NUMBER_TWO);
                source.tohyoTimeStart3_nn = tohyoTimeStart3.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報4() && null != data.get明細情報4().get投票開始時刻()) {
                RString 投票開始時刻4 = data.get明細情報4().get投票開始時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeStart4 = null == 投票開始時刻4 ? RString.EMPTY : 投票開始時刻4;
                source.tohyoTimeStart4_hh = tohyoTimeStart4.substring(0, NUMBER_TWO);
                source.tohyoTimeStart4_nn = tohyoTimeStart4.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
        }
    }

    private void edit投票終了時刻(TenshutsuOshiraseHagakiSource source) {
        RString 転出者はがき_印字有無_終了時間 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_印字有無_終了時間, SubGyomuCode.AFA選挙本体);
        if (転出者はがき_印字有無_終了時間.equals(new RString("1"))) {
            RString tohyoTimeEnd2 = RString.EMPTY;
            RString tohyoTimeEnd3 = RString.EMPTY;
            RString tohyoTimeEnd4 = RString.EMPTY;
            if (null != data.get明細情報1() && null != data.get明細情報1().get投票終了時刻()) {
                RString 投票終了時刻1 = data.get明細情報1().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                RString tohyoTimeEnd1 = null == 投票終了時刻1 ? RString.EMPTY : 投票終了時刻1;
                source.tohyoTimeEnd1_hh = tohyoTimeEnd1.substring(0, NUMBER_TWO);
                source.tohyoTimeEnd1_nn = tohyoTimeEnd1.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報2() && null != data.get明細情報2().get投票終了時刻()) {
                RString 投票終了時刻2 = data.get明細情報2().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeEnd2 = null == 投票終了時刻2 ? RString.EMPTY : 投票終了時刻2;
                source.tohyoTimeEnd2_hh = tohyoTimeEnd2.substring(0, NUMBER_TWO);
                source.tohyoTimeEnd2_nn = tohyoTimeEnd2.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報3() && null != data.get明細情報3().get投票終了時刻()) {
                RString 投票終了時刻3 = data.get明細情報3().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeEnd3 = null == 投票終了時刻3 ? RString.EMPTY : 投票終了時刻3;
                source.tohyoTimeEnd3_hh = tohyoTimeEnd3.substring(0, NUMBER_TWO);
                source.tohyoTimeEnd3_nn = tohyoTimeEnd3.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
            if (null != data.get明細情報4() && null != data.get明細情報4().get投票終了時刻()) {
                RString 投票終了時刻4 = data.get明細情報4().get投票終了時刻().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
                tohyoTimeEnd4 = null == 投票終了時刻4 ? RString.EMPTY : 投票終了時刻4;
                source.tohyoTimeEnd4_hh = tohyoTimeEnd4.substring(0, NUMBER_TWO);
                source.tohyoTimeEnd4_nn = tohyoTimeEnd4.substring(郵便番号_上3桁, NUMBER_FIVE);
            }
        }
    }

    private void edit明細住所(TenshutsuOshiraseHagakiSource source) {
        if (is文字切れ(getItemLength(住所11), data.getJusho11())) {
            source.jusho11 = data.getJusho11().substring(NUMBER_ZERO, getItemLength(住所11));
        } else {
            source.jusho11 = data.getJusho11();
        }
        if (is文字切れ(getItemLength(住所21), data.getJusho21())) {
            source.jusho21 = data.getJusho21().substring(NUMBER_ZERO, getItemLength(住所21));
        } else {
            source.jusho21 = data.getJusho21();
        }
        if (is文字切れ(getItemLength(住所31), data.getJusho31())) {
            source.jusho31 = data.getJusho31().substring(NUMBER_ZERO, getItemLength(住所31));
        } else {
            source.jusho31 = data.getJusho31();
        }
        if (is文字切れ(getItemLength(住所41), data.getJusho41())) {
            source.jusho41 = data.getJusho41().substring(NUMBER_ZERO, getItemLength(住所41));
        } else {
            source.jusho41 = data.getJusho41();
        }
        if (is文字切れ(getItemLength(住所51), data.getJusho51())) {
            source.jusho51 = data.getJusho51().substring(NUMBER_ZERO, getItemLength(住所51));
        } else {
            source.jusho51 = data.getJusho51();
        }
        if (is文字切れ(getItemLength(住所12), data.getJusho12())) {
            source.jusho12 = data.getJusho12().substring(NUMBER_ZERO, getItemLength(住所12));
        } else {
            source.jusho12 = data.getJusho12();
        }
        if (is文字切れ(getItemLength(住所22), data.getJusho22())) {
            source.jusho22 = data.getJusho22().substring(NUMBER_ZERO, getItemLength(住所22));
        } else {
            source.jusho22 = data.getJusho22();
        }
        if (is文字切れ(getItemLength(住所32), data.getJusho32())) {
            source.jusho32 = data.getJusho32().substring(NUMBER_ZERO, getItemLength(住所32));
        } else {
            source.jusho32 = data.getJusho32();
        }
        if (is文字切れ(getItemLength(住所42), data.getJusho42())) {
            source.jusho42 = data.getJusho42().substring(NUMBER_ZERO, getItemLength(住所42));
        } else {
            source.jusho42 = data.getJusho42();
        }
        if (is文字切れ(getItemLength(住所52), data.getJusho52())) {
            source.jusho52 = data.getJusho52().substring(NUMBER_ZERO, getItemLength(住所52));
        } else {
            source.jusho52 = data.getJusho52();
        }
        住所文字切れ(source);
    }

    private void 住所文字切れ(TenshutsuOshiraseHagakiSource source) {
        if (is文字切れ(getItemLength(住所13), data.getJusho13())) {
            source.jusho13 = data.getJusho13().substring(NUMBER_ZERO, getItemLength(住所13));
        } else {
            source.jusho13 = data.getJusho13();
        }
        if (is文字切れ(getItemLength(住所23), data.getJusho23())) {
            source.jusho23 = data.getJusho23().substring(NUMBER_ZERO, getItemLength(住所23));
        } else {
            source.jusho23 = data.getJusho23();
        }
        if (is文字切れ(getItemLength(住所33), data.getJusho33())) {
            source.jusho33 = data.getJusho33().substring(NUMBER_ZERO, getItemLength(住所33));
        } else {
            source.jusho33 = data.getJusho33();
        }
        if (is文字切れ(getItemLength(住所43), data.getJusho43())) {
            source.jusho43 = data.getJusho43().substring(NUMBER_ZERO, getItemLength(住所43));
        } else {
            source.jusho43 = data.getJusho43();
        }
        if (is文字切れ(getItemLength(住所53), data.getJusho53())) {
            source.jusho53 = data.getJusho53().substring(NUMBER_ZERO, getItemLength(住所53));
        } else {
            source.jusho53 = data.getJusho53();
        }
        if (is文字切れ(getItemLength(住所14), data.getJusho14())) {
            source.jusho14 = data.getJusho14().substring(NUMBER_ZERO, getItemLength(住所14));
        } else {
            source.jusho14 = data.getJusho14();
        }
        if (is文字切れ(getItemLength(住所24), data.getJusho24())) {
            source.jusho24 = data.getJusho24().substring(NUMBER_ZERO, getItemLength(住所24));
        } else {
            source.jusho24 = data.getJusho24();
        }
        if (is文字切れ(getItemLength(住所34), data.getJusho34())) {
            source.jusho34 = data.getJusho34().substring(NUMBER_ZERO, getItemLength(住所34));
        } else {
            source.jusho34 = data.getJusho34();
        }
        if (is文字切れ(getItemLength(住所44), data.getJusho44())) {
            source.jusho44 = data.getJusho44().substring(NUMBER_ZERO, getItemLength(住所44));
        } else {
            source.jusho44 = data.getJusho44();
        }
        if (is文字切れ(getItemLength(住所54), data.getJusho54())) {
            source.jusho54 = data.getJusho54().substring(NUMBER_ZERO, getItemLength(住所54));
        } else {
            source.jusho54 = data.getJusho54();
        }
        if (null != data.get明細情報1()) {
            source.jusho_1 = edit明細情報住所取得(data.get明細情報1().get住登内住所(),
                    data.get明細情報1().get住登内番地(),
                    data.get明細情報1().get行政区名(),
                    data.get明細情報1().get地区名1(),
                    data.get明細情報1().get地区名2(),
                    data.get明細情報1().get地区名3());
        }
        if (null != data.get明細情報2()) {
            source.jusho_2 = edit明細情報住所取得(data.get明細情報2().get住登内住所(),
                    data.get明細情報2().get住登内番地(),
                    data.get明細情報2().get行政区名(),
                    data.get明細情報2().get地区名1(),
                    data.get明細情報2().get地区名2(),
                    data.get明細情報2().get地区名3());
        }
        if (null != data.get明細情報3()) {
            source.jusho_3 = edit明細情報住所取得(data.get明細情報3().get住登内住所(),
                    data.get明細情報3().get住登内番地(),
                    data.get明細情報3().get行政区名(),
                    data.get明細情報3().get地区名1(),
                    data.get明細情報3().get地区名2(),
                    data.get明細情報3().get地区名3());
        }
        if (null != data.get明細情報4()) {
            source.jusho_4 = edit明細情報住所取得(data.get明細情報4().get住登内住所(),
                    data.get明細情報4().get住登内番地(),
                    data.get明細情報4().get行政区名(),
                    data.get明細情報4().get地区名1(),
                    data.get明細情報4().get地区名2(),
                    data.get明細情報4().get地区名3());
        }
    }

    private void edit名称(TenshutsuOshiraseHagakiSource source) {
        if (is文字切れ(getItemLength(名称11), data.getName11())) {
            source.name11 = data.getName11().substring(NUMBER_ZERO, getItemLength(名称11));
        } else {
            source.name11 = data.getName11();
        }
        if (is文字切れ(getItemLength(名称21), data.getName21())) {
            source.name21 = data.getName21().substring(NUMBER_ZERO, getItemLength(名称21));
        } else {
            source.name21 = data.getName21();
        }
        if (is文字切れ(getItemLength(名称31), data.getName31())) {
            source.name31 = data.getName31().substring(NUMBER_ZERO, getItemLength(名称31));
        } else {
            source.name31 = data.getName31();
        }
        if (is文字切れ(getItemLength(名称12), data.getName12())) {
            source.name12 = data.getName12().substring(NUMBER_ZERO, getItemLength(名称12));
        } else {
            source.name12 = data.getName12();
        }
        if (is文字切れ(getItemLength(名称22), data.getName22())) {
            source.name22 = data.getName22().substring(NUMBER_ZERO, getItemLength(名称22));
        } else {
            source.name22 = data.getName22();
        }
        if (is文字切れ(getItemLength(名称32), data.getName32())) {
            source.name32 = data.getName32().substring(NUMBER_ZERO, getItemLength(名称32));
        } else {
            source.name32 = data.getName32();
        }
        if (is文字切れ(getItemLength(名称13), data.getName13())) {
            source.name13 = data.getName13().substring(NUMBER_ZERO, getItemLength(名称13));
        } else {
            source.name13 = data.getName13();
        }
        if (is文字切れ(getItemLength(名称23), data.getName23())) {
            source.name23 = data.getName23().substring(NUMBER_ZERO, getItemLength(名称23));
        } else {
            source.name23 = data.getName23();
        }
        if (is文字切れ(getItemLength(名称33), data.getName33())) {
            source.name33 = data.getName33().substring(NUMBER_ZERO, getItemLength(名称33));
        } else {
            source.name33 = data.getName33();
        }
        if (is文字切れ(getItemLength(名称14), data.getName14())) {
            source.name14 = data.getName14().substring(NUMBER_ZERO, getItemLength(名称14));
        } else {
            source.name14 = data.getName14();
        }
        if (is文字切れ(getItemLength(名称24), data.getName24())) {
            source.name24 = data.getName24().substring(NUMBER_ZERO, getItemLength(名称24));
        } else {
            source.name24 = data.getName24();
        }
        if (is文字切れ(getItemLength(名称34), data.getName34())) {
            source.name34 = data.getName34().substring(NUMBER_ZERO, getItemLength(名称34));
        } else {
            source.name34 = data.getName34();
        }
        if (null != data.get明細情報1()) {
            source.shimei_1 = data.get明細情報1().get名称();
        }
        if (null != data.get明細情報2()) {
            source.shimei_2 = data.get明細情報2().get名称();
        }
        if (null != data.get明細情報3()) {
            source.shimei_3 = data.get明細情報3().get名称();
        }
        if (null != data.get明細情報4()) {
            source.shimei_4 = data.get明細情報4().get名称();
        }

    }

    private void editカスタマーバーコード(TenshutsuOshiraseHagakiSource source) {
        source.barcodeCustombarcode1 = null == data.getBarcodeCustombarcode1() ? RString.EMPTY : data.getBarcodeCustombarcode1();
        source.barcodeCustombarcode2 = null == data.getBarcodeCustombarcode2() ? RString.EMPTY : data.getBarcodeCustombarcode2();
        source.barcodeCustombarcode3 = null == data.getBarcodeCustombarcode3() ? RString.EMPTY : data.getBarcodeCustombarcode3();
        source.barcodeCustombarcode4 = null == data.getBarcodeCustombarcode4() ? RString.EMPTY : data.getBarcodeCustombarcode4();

    }

    private void edit投票所名(TenshutsuOshiraseHagakiSource source) {
        if (is文字切れ(getItemLength(投票所名11), data.getTohyojoName11())) {
            source.tohyojoName11 = data.getTohyojoName11().substring(NUMBER_ZERO, getItemLength(投票所名11));
        } else {
            source.tohyojoName11 = data.getTohyojoName11();
        }
        if (is文字切れ(getItemLength(投票所名21), data.getTohyojoName21())) {
            source.tohyojoName21 = data.getTohyojoName21().substring(NUMBER_ZERO, getItemLength(投票所名21));
        } else {
            source.tohyojoName21 = data.getTohyojoName21();
        }
        if (is文字切れ(getItemLength(投票所名12), data.getTohyojoName12())) {
            source.tohyojoName12 = data.getTohyojoName12().substring(NUMBER_ZERO, getItemLength(投票所名12));
        } else {
            source.tohyojoName12 = data.getTohyojoName12();
        }
        if (is文字切れ(getItemLength(投票所名22), data.getTohyojoName22())) {
            source.tohyojoName22 = data.getTohyojoName22().substring(NUMBER_ZERO, getItemLength(投票所名22));
        } else {
            source.tohyojoName22 = data.getTohyojoName22();
        }
        if (is文字切れ(getItemLength(投票所名13), data.getTohyojoName13())) {
            source.tohyojoName13 = data.getTohyojoName13().substring(NUMBER_ZERO, getItemLength(投票所名13));
        } else {
            source.tohyojoName13 = data.getTohyojoName13();
        }
        if (is文字切れ(getItemLength(投票所名23), data.getTohyojoName23())) {
            source.tohyojoName23 = data.getTohyojoName23().substring(NUMBER_ZERO, getItemLength(投票所名23));
        } else {
            source.tohyojoName23 = data.getTohyojoName23();
        }
        if (is文字切れ(getItemLength(投票所名14), data.getTohyojoName14())) {
            source.tohyojoName14 = data.getTohyojoName14().substring(NUMBER_ZERO, getItemLength(投票所名14));
        } else {
            source.tohyojoName14 = data.getTohyojoName14();
        }
        if (is文字切れ(getItemLength(投票所名24), data.getTohyojoName24())) {
            source.tohyojoName24 = data.getTohyojoName24().substring(NUMBER_ZERO, getItemLength(投票所名24));
        } else {
            source.tohyojoName24 = data.getTohyojoName24();
        }
        if (null != data.get明細情報4()) {
            source.tohyojoMei_4 = data.get明細情報4().get投票所名();
        }
        if (null != data.get明細情報1()) {
            source.tohyojoMei_1 = data.get明細情報1().get投票所名();
        }
        if (null != data.get明細情報3()) {
            source.tohyojoMei_3 = data.get明細情報3().get投票所名();
        }
        if (null != data.get明細情報2()) {
            source.tohyojoMei_2 = data.get明細情報2().get投票所名();
        }
    }

    private void editハガキ明細住所(TenshutsuOshiraseHagakiSource source) {
        if (is文字切れ(getItemLength(転出前住所11), data.getOldJusho11())) {
            source.oldJusho11 = data.getOldJusho11().substring(NUMBER_ZERO, getItemLength(転出前住所11));
        } else {
            source.oldJusho11 = data.getOldJusho11();
        }
        if (is文字切れ(getItemLength(転出前住所21), data.getOldJusho21())) {
            source.oldJusho21 = data.getOldJusho21().substring(NUMBER_ZERO, getItemLength(転出前住所21));
        } else {
            source.oldJusho21 = data.getOldJusho21();
        }
        if (is文字切れ(getItemLength(転出前住所31), data.getOldJusho31())) {
            source.oldJusho31 = data.getOldJusho31().substring(NUMBER_ZERO, getItemLength(転出前住所31));
        } else {
            source.oldJusho31 = data.getOldJusho31();
        }
        if (is文字切れ(getItemLength(転出前住所12), data.getOldJusho12())) {
            source.oldJusho12 = data.getOldJusho12().substring(NUMBER_ZERO, getItemLength(転出前住所12));
        } else {
            source.oldJusho12 = data.getOldJusho12();
        }
        if (is文字切れ(getItemLength(転出前住所22), data.getOldJusho22())) {
            source.oldJusho22 = data.getOldJusho22().substring(NUMBER_ZERO, getItemLength(転出前住所22));
        } else {
            source.oldJusho22 = data.getOldJusho22();
        }
        if (is文字切れ(getItemLength(転出前住所32), data.getOldJusho32())) {
            source.oldJusho32 = data.getOldJusho32().substring(NUMBER_ZERO, getItemLength(転出前住所32));
        } else {
            source.oldJusho32 = data.getOldJusho32();
        }
        if (is文字切れ(getItemLength(転出前住所13), data.getOldJusho13())) {
            source.oldJusho13 = data.getOldJusho13().substring(NUMBER_ZERO, getItemLength(転出前住所13));
        } else {
            source.oldJusho13 = data.getOldJusho13();
        }
        if (is文字切れ(getItemLength(転出前住所23), data.getOldJusho23())) {
            source.oldJusho23 = data.getOldJusho23().substring(NUMBER_ZERO, getItemLength(転出前住所23));
        } else {
            source.oldJusho23 = data.getOldJusho23();
        }
        if (is文字切れ(getItemLength(転出前住所33), data.getOldJusho33())) {
            source.oldJusho33 = data.getOldJusho33().substring(NUMBER_ZERO, getItemLength(転出前住所33));
        } else {
            source.oldJusho33 = data.getOldJusho33();
        }
        if (is文字切れ(getItemLength(転出前住所14), data.getTohyojoName24())) {
            source.oldJusho14 = data.getOldJusho14().substring(NUMBER_ZERO, getItemLength(転出前住所14));
        } else {
            source.oldJusho14 = data.getOldJusho14();
        }
        if (is文字切れ(getItemLength(転出前住所24), data.getOldJusho24())) {
            source.oldJusho24 = data.getOldJusho24().substring(NUMBER_ZERO, getItemLength(転出前住所24));
        } else {
            source.oldJusho24 = data.getOldJusho24();
        }
        if (is文字切れ(getItemLength(転出前住所34), data.getOldJusho34())) {
            source.oldJusho34 = data.getOldJusho34().substring(NUMBER_ZERO, getItemLength(転出前住所34));
        } else {
            source.oldJusho34 = data.getOldJusho34();
        }
        if (null != data.get明細情報1()) {
            source.oldJusho_1 = edit転出前住所(data.get明細情報1().get住登内住所(),
                    data.get明細情報1().get住登内番地(),
                    data.get明細情報1().get住登内方書());
        }
        if (null != data.get明細情報2()) {
            source.oldJusho_2 = edit転出前住所(data.get明細情報2().get住登内住所(),
                    data.get明細情報2().get住登内番地(),
                    data.get明細情報2().get住登内方書());
        }
        if (null != data.get明細情報3()) {
            source.oldJusho_3 = edit転出前住所(data.get明細情報3().get住登内住所(),
                    data.get明細情報3().get住登内番地(),
                    data.get明細情報3().get住登内方書());
        }
        if (null != data.get明細情報4()) {
            source.oldJusho_4 = edit転出前住所(data.get明細情報4().get住登内住所(),
                    data.get明細情報4().get住登内番地(),
                    data.get明細情報4().get住登内方書());
        }
    }

    private RString edit転出前住所(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 方書文字列 = null == 方書 || 方書.isEmpty() ? RString.EMPTY : changeNullToEmpty(方書.value());
        RString 編集用住所 = 住所文字列.concat(番地文字列).replace(空白, RString.EMPTY).concat(全角スペース).concat(方書文字列);
        return 編集用住所;
    }

    private RString edit明細情報住所取得(AtenaJusho 住所, AtenaBanchi 番地, RString 行政区名,
            RString 地区名１, RString 地区名２, RString 地区名３) {
        RString 番地文字列 = null == 番地 || 番地.isEmpty() ? RString.EMPTY : changeNullToEmpty(番地.value());
        RString 住所文字列 = null == 住所 || 住所.isEmpty() ? RString.EMPTY : changeNullToEmpty(住所.value());
        地区名１ = changeNullToEmpty(地区名１);
        地区名３ = changeNullToEmpty(地区名３);
        行政区名 = changeNullToEmpty(行政区名);
        地区名２ = changeNullToEmpty(地区名２);

        RString 編集用住所3 = RString.EMPTY;
        RString 入場券_明細部住所編集 = BusinessConfig.get(ConfigKeysAFA.入場券_明細部住所編集, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 住所文字列.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_住所.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 住所文字列;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 行政区名;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区2.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 地区名２;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区1.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 地区名１;
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_行政区AND番地.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 行政区名.concat(番地文字列).replace(空白, RString.EMPTY);
        }
        if (AFAConfigKeysValue.入場券_明細部住所編集_地区3.configKeyValue().equals(入場券_明細部住所編集)) {
            編集用住所3 = 地区名３;
        }
        return 編集用住所3;
    }

    private void edit入場券バーコード(TenshutsuOshiraseHagakiSource source) {
        RString 入場券バーコード1 = null == data.getBarcodeBarcode1() ? RString.EMPTY : data.getBarcodeBarcode1();
        source.barcodeBarcode1 = 入場券バーコード1;
        RString 入場券バーコード2 = null == data.getBarcodeBarcode2() ? RString.EMPTY : data.getBarcodeBarcode2();
        source.barcodeBarcode2 = 入場券バーコード2;
        RString 入場券バーコード3 = null == data.getBarcodeBarcode3() ? RString.EMPTY : data.getBarcodeBarcode3();
        RString 入場券バーコード4 = null == data.getBarcodeBarcode4() ? RString.EMPTY : data.getBarcodeBarcode4();
        source.barcodeBarcode3 = 入場券バーコード3;
        source.barcodeBarcode4 = 入場券バーコード4;

    }

    private void editアクセスログ出力(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.法人番号使用1 = HojinNo.EMPTY;
            source.識別コード1 = data.get明細情報1().get識別コード();
            source.個人番号使用1 = KojinNo.EMPTY;
        }
        if (null != data.get明細情報4()) {
            source.個人番号使用4 = KojinNo.EMPTY;
            source.識別コード4 = data.get明細情報4().get識別コード();
            source.法人番号使用4 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報2()) {
            source.個人番号使用2 = KojinNo.EMPTY;
            source.識別コード2 = data.get明細情報2().get識別コード();
            source.法人番号使用2 = HojinNo.EMPTY;
        }
        if (null != data.get明細情報3()) {
            source.識別コード3 = data.get明細情報3().get識別コード();
            source.法人番号使用3 = HojinNo.EMPTY;
            source.個人番号使用3 = KojinNo.EMPTY;
        }
    }

    private void edit整理番号(TenshutsuOshiraseHagakiSource source) {
        if (null != data.get明細情報1()) {
            source.seiriNo1 = data.get明細情報1().get整理番号();
        }
        if (null != data.get明細情報2()) {
            source.seiriNo2 = data.get明細情報2().get整理番号();
        }
        if (null != data.get明細情報3()) {
            source.seiriNo3 = data.get明細情報3().get整理番号();
        }
        if (null != data.get明細情報4()) {
            source.seiriNo4 = data.get明細情報4().get整理番号();
        }
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
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TenshutsuOshiraseHagakiSource.class, itemName);
    }
}
