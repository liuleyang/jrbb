package jp.co.ndensan.reams.af.afa.business.report.AFAPRE214;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealGroupSource;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21Editor implements IAtenaSeal21Editor {

    private static final RString 全角スペース = new RString("　");
    private static final RString 半角スペース = new RString(" ");
    private static final RString 選挙人宛名シール_21面 = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_21面 = new RString("AFAGME6020");
    private static final RString 施設宛名シール_21面 = new RString("AFAGME6030");
    private static final RString 入場券発行_一括 = new RString("AFAGMB2010");
    private static final RString 定時登録 = new RString("AFAGMA1010");
    private static final RString 定時帳票再発行 = new RString("AFAGMA1030");
    private static final RString 選挙時登録 = new RString("AFAGMB1010");
    private static final RString 選挙時登録帳票再発行 = new RString("AFAGMB1040");
    private static final RString 国民投票時登録 = new RString("AFAGMG1010");
    private static final RString 国民投票帳票再発行 = new RString("AFAGMG1060");
    private static final RString 海区漁業調整委員会委員選挙時登録 = new RString("AFAGMK1030");
    private static final RString 海区漁業調整委員会委員選挙人名簿最新化 = new RString("AFAGMK1040");
    private static final int 長さ_21面_住所_上段 = getItemLength(new RString("jushoA1"));
    private static final int 長さ_21面_住所_中段 = getItemLength(new RString("jushoB1"));
    private static final int 長さ_21面_住所_下段 = getItemLength(new RString("jushoC1"));
    private static final int 長さ_21面_小住所1 = getItemLength(new RString("jushoLa1"));
    private static final int 長さ_21面_小住所2 = getItemLength(new RString("jushoLb1"));
    private static final int 長さ_21面_小住所3 = getItemLength(new RString("jushoLc1"));
    private static final int 長さ_21面_小住所4 = getItemLength(new RString("jushoLd1"));
    private static final int 長さ_21面_宛名上段 = getItemLength(new RString("atenaA1"));
    private static final int 長さ_21面_宛名下段 = getItemLength(new RString("atenaB1"));
    private static final int 長さ_21面_小宛名上段 = getItemLength(new RString("atenaLa1"));
    private static final int 長さ_21面_小宛名下段 = getItemLength(new RString("atenaLb1"));
    private static final RString 連結標識_21面 = new RString("-");
    private static final RString 左括弧_21面 = new RString("(");
    private static final RString 右括弧_21面 = new RString(")");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 様_21面 = new RString("　様");
    private static final RString 作成_21面 = new RString("作成");
    private final AtenaSeal21Param data;

    /**
     * コンストラクタです。
     *
     * @param data {@link AtenaSeal21Param}
     */
    public AtenaSeal21Editor(AtenaSeal21Param data) {
        this.data = data;
    }

    /**
     * 宛名シール21面エディットメソッド
     *
     * @param source 宛名シール21面
     * @return 宛名シール21面
     */
    @Override
    public AtenaSeal21Source edit(AtenaSeal21Source source) {
        source.pageCount = data.get頁番号();
        edit市町村コード(source);
        edit市町村名(source);
        edit作成日時(source);
        editカスタマバーコード(source);
        editFirst(source);
        editTwo(source);
        editThree(source);
        editFour(source);
        editFive(source);
        editSix(source);
        editSeven(source);
        editEight(source);
        editNine(source);
        editTen(source);
        editEleven(source);
        editTwelve(source);
        editThirteen(source);
        editFourteen(source);
        editFiveteen(source);
        editSixteen(source);
        editSeventeen(source);
        editEighteen(source);
        editNineteen(source);
        editTwenty(source);
        editTwenty_one(source);
        return source;
    }

    private void editカスタマバーコード(AtenaSeal21Source source) {
        source.barcodeBarcode1 = RString.EMPTY;
        source.barcodeBarcode2 = RString.EMPTY;
        source.barcodeBarcode3 = RString.EMPTY;
        source.barcodeBarcode4 = RString.EMPTY;
        source.barcodeBarcode5 = RString.EMPTY;
        source.barcodeBarcode6 = RString.EMPTY;
        source.barcodeBarcode7 = RString.EMPTY;
        source.barcodeBarcode8 = RString.EMPTY;
        source.barcodeBarcode9 = RString.EMPTY;
        source.barcodeBarcode10 = RString.EMPTY;
        source.barcodeBarcode11 = RString.EMPTY;
        source.barcodeBarcode12 = RString.EMPTY;
        source.barcodeBarcode13 = RString.EMPTY;
        source.barcodeBarcode14 = RString.EMPTY;
        source.barcodeBarcode15 = RString.EMPTY;
        source.barcodeBarcode16 = RString.EMPTY;
        source.barcodeBarcode17 = RString.EMPTY;
        source.barcodeBarcode18 = RString.EMPTY;
        source.barcodeBarcode19 = RString.EMPTY;
        source.barcodeBarcode20 = RString.EMPTY;
        source.barcodeBarcode21 = RString.EMPTY;
    }

    private void editTwo(AtenaSeal21Source source) {
        if (null != data.getParam2()) {
            AtenaSealGroupSource groupSource2 = edit総合編集_21面(source, data.getParam2());
            source.jushoList2 = groupSource2.getJushoList();
            source.meishoList2 = groupSource2.getMeishoList();
            if (!groupSource2.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode2 = new RString(groupSource2.getShikibetsuCode().toString());
                source.shikibetsuCode_2 = new RString(groupSource2.getShikibetsuCode().toString());
            }
            source.yubinNo2 = groupSource2.getYubinno();
            source.jushoA2 = groupSource2.getJushoa();
            source.jushoB2 = groupSource2.getJushob();
            source.jushoC2 = groupSource2.getJushoc();
            source.jushoLa2 = groupSource2.getJushola();
            source.jushoLb2 = groupSource2.getJusholb();
            source.jushoLc2 = groupSource2.getJusholc();
            source.jushoLd2 = groupSource2.getJushold();
            source.atenaA2 = groupSource2.getAtenaa();
            source.atenaB2 = groupSource2.getAtenab();
            source.atenaLa2 = groupSource2.getAtenala();
            source.atenaLb2 = groupSource2.getAtenalb();
            source.komokuA2 = groupSource2.getKoumokua();
            source.komokuB2 = groupSource2.getKoumokub();
            source.komokuC2 = groupSource2.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.法人番号使用2 = HojinNo.EMPTY;
                source.個人番号使用2 = KojinNo.EMPTY;
                source.識別コード2 = groupSource2.getShikibetsuCode();
            }
        }
    }

    private void editFirst(AtenaSeal21Source source) {
        if (null != data.getParam1()) {
            AtenaSealGroupSource groupSource1 = edit総合編集_21面(source, data.getParam1());
            source.jushoList1 = groupSource1.getJushoList();
            source.meishoList1 = groupSource1.getMeishoList();
            if (!groupSource1.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_1 = new RString(groupSource1.getShikibetsuCode().toString());
                source.shikibetsuCode1 = new RString(groupSource1.getShikibetsuCode().toString());
            }
            source.yubinNo1 = groupSource1.getYubinno();
            source.jushoA1 = groupSource1.getJushoa();
            source.jushoB1 = groupSource1.getJushob();
            source.jushoC1 = groupSource1.getJushoc();
            source.jushoLa1 = groupSource1.getJushola();
            source.jushoLb1 = groupSource1.getJusholb();
            source.jushoLc1 = groupSource1.getJusholc();
            source.jushoLd1 = groupSource1.getJushold();
            source.atenaA1 = groupSource1.getAtenaa();
            source.atenaB1 = groupSource1.getAtenab();
            source.atenaLa1 = groupSource1.getAtenala();
            source.atenaLb1 = groupSource1.getAtenalb();
            source.komokuA1 = groupSource1.getKoumokua();
            source.komokuB1 = groupSource1.getKoumokub();
            source.komokuC1 = groupSource1.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.法人番号使用1 = HojinNo.EMPTY;
                source.個人番号使用1 = KojinNo.EMPTY;
                source.識別コード1 = groupSource1.getShikibetsuCode();
            }
        }
    }

    private void editThree(AtenaSeal21Source source) {
        if (null != data.getParam3()) {
            AtenaSealGroupSource groupSource3 = edit総合編集_21面(source, data.getParam3());
            source.jushoList3 = groupSource3.getJushoList();
            source.meishoList3 = groupSource3.getMeishoList();
            if (!groupSource3.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode3 = new RString(groupSource3.getShikibetsuCode().toString());
                source.shikibetsuCode_3 = new RString(groupSource3.getShikibetsuCode().toString());
            }
            source.yubinNo3 = groupSource3.getYubinno();
            source.jushoA3 = groupSource3.getJushoa();
            source.jushoB3 = groupSource3.getJushob();
            source.jushoC3 = groupSource3.getJushoc();
            source.jushoLa3 = groupSource3.getJushola();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード3 = groupSource3.getShikibetsuCode();
                source.個人番号使用3 = KojinNo.EMPTY;
                source.法人番号使用3 = HojinNo.EMPTY;
            }
            source.jushoLb3 = groupSource3.getJusholb();
            source.jushoLc3 = groupSource3.getJusholc();
            source.jushoLd3 = groupSource3.getJushold();
            source.atenaA3 = groupSource3.getAtenaa();
            source.atenaB3 = groupSource3.getAtenab();
            source.atenaLa3 = groupSource3.getAtenala();
            source.atenaLb3 = groupSource3.getAtenalb();
            source.komokuA3 = groupSource3.getKoumokua();
            source.komokuB3 = groupSource3.getKoumokub();
            source.komokuC3 = groupSource3.getKoumokuc();
        }
    }

    private void editFour(AtenaSeal21Source source) {
        if (null != data.getParam4()) {
            AtenaSealGroupSource groupSource4 = edit総合編集_21面(source, data.getParam4());
            source.jushoList4 = groupSource4.getJushoList();
            source.meishoList4 = groupSource4.getMeishoList();
            if (!groupSource4.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_4 = new RString(groupSource4.getShikibetsuCode().toString());
                source.shikibetsuCode4 = new RString(groupSource4.getShikibetsuCode().toString());
            }
            source.yubinNo4 = groupSource4.getYubinno();
            source.jushoA4 = groupSource4.getJushoa();
            source.jushoB4 = groupSource4.getJushob();
            source.jushoC4 = groupSource4.getJushoc();
            source.jushoLa4 = groupSource4.getJushola();
            source.jushoLb4 = groupSource4.getJusholb();
            source.jushoLc4 = groupSource4.getJusholc();
            source.jushoLd4 = groupSource4.getJushold();
            source.atenaA4 = groupSource4.getAtenaa();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード4 = groupSource4.getShikibetsuCode();
                source.個人番号使用4 = KojinNo.EMPTY;
                source.法人番号使用4 = HojinNo.EMPTY;
            }
            source.atenaB4 = groupSource4.getAtenab();
            source.atenaLa4 = groupSource4.getAtenala();
            source.atenaLb4 = groupSource4.getAtenalb();
            source.komokuA4 = groupSource4.getKoumokua();
            source.komokuB4 = groupSource4.getKoumokub();
            source.komokuC4 = groupSource4.getKoumokuc();
        }
    }

    private void editFive(AtenaSeal21Source source) {
        if (null != data.getParam5()) {
            AtenaSealGroupSource groupSource5 = edit総合編集_21面(source, data.getParam5());
            source.jushoList5 = groupSource5.getJushoList();
            source.meishoList5 = groupSource5.getMeishoList();
            if (!groupSource5.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_5 = new RString(groupSource5.getShikibetsuCode().toString());
                source.shikibetsuCode5 = new RString(groupSource5.getShikibetsuCode().toString());
            }
            source.yubinNo5 = groupSource5.getYubinno();
            source.jushoA5 = groupSource5.getJushoa();
            source.jushoB5 = groupSource5.getJushob();
            source.jushoC5 = groupSource5.getJushoc();
            source.jushoLa5 = groupSource5.getJushola();
            source.jushoLb5 = groupSource5.getJusholb();
            source.jushoLc5 = groupSource5.getJusholc();
            source.jushoLd5 = groupSource5.getJushold();
            source.atenaA5 = groupSource5.getAtenaa();
            source.atenaB5 = groupSource5.getAtenab();
            source.atenaLa5 = groupSource5.getAtenala();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード5 = groupSource5.getShikibetsuCode();
                source.個人番号使用5 = KojinNo.EMPTY;
                source.法人番号使用5 = HojinNo.EMPTY;
            }
            source.atenaLb5 = groupSource5.getAtenalb();
            source.komokuA5 = groupSource5.getKoumokua();
            source.komokuB5 = groupSource5.getKoumokub();
            source.komokuC5 = groupSource5.getKoumokuc();
        }
    }

    private void editSix(AtenaSeal21Source source) {
        if (null != data.getParam6()) {
            AtenaSealGroupSource groupSource6 = edit総合編集_21面(source, data.getParam6());
            source.jushoList6 = groupSource6.getJushoList();
            source.meishoList6 = groupSource6.getMeishoList();
            if (!groupSource6.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_6 = new RString(groupSource6.getShikibetsuCode().toString());
                source.shikibetsuCode6 = new RString(groupSource6.getShikibetsuCode().toString());
            }
            source.yubinNo6 = groupSource6.getYubinno();
            source.jushoA6 = groupSource6.getJushoa();
            source.jushoB6 = groupSource6.getJushob();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード6 = groupSource6.getShikibetsuCode();
                source.個人番号使用6 = KojinNo.EMPTY;
                source.法人番号使用6 = HojinNo.EMPTY;
            }
            source.jushoC6 = groupSource6.getJushoc();
            source.jushoLa6 = groupSource6.getJushola();
            source.jushoLb6 = groupSource6.getJusholb();
            source.jushoLc6 = groupSource6.getJusholc();
            source.jushoLd6 = groupSource6.getJushold();
            source.atenaA6 = groupSource6.getAtenaa();
            source.atenaB6 = groupSource6.getAtenab();
            source.atenaLa6 = groupSource6.getAtenala();
            source.atenaLb6 = groupSource6.getAtenalb();
            source.komokuA6 = groupSource6.getKoumokua();
            source.komokuB6 = groupSource6.getKoumokub();
            source.komokuC6 = groupSource6.getKoumokuc();
        }
    }

    private void editSeven(AtenaSeal21Source source) {
        if (null != data.getParam7()) {
            AtenaSealGroupSource groupSource7 = edit総合編集_21面(source, data.getParam7());
            source.jushoList7 = groupSource7.getJushoList();
            source.meishoList7 = groupSource7.getMeishoList();
            if (!groupSource7.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_7 = new RString(groupSource7.getShikibetsuCode().toString());
                source.shikibetsuCode7 = new RString(groupSource7.getShikibetsuCode().toString());
            }
            source.yubinNo7 = groupSource7.getYubinno();
            source.jushoA7 = groupSource7.getJushoa();
            source.jushoB7 = groupSource7.getJushob();
            source.jushoC7 = groupSource7.getJushoc();
            source.jushoLa7 = groupSource7.getJushola();
            source.jushoLb7 = groupSource7.getJusholb();
            source.jushoLc7 = groupSource7.getJusholc();
            source.jushoLd7 = groupSource7.getJushold();
            source.atenaA7 = groupSource7.getAtenaa();
            source.atenaB7 = groupSource7.getAtenab();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード7 = groupSource7.getShikibetsuCode();
                source.個人番号使用7 = KojinNo.EMPTY;
                source.法人番号使用7 = HojinNo.EMPTY;
            }
            source.atenaLa7 = groupSource7.getAtenala();
            source.atenaLb7 = groupSource7.getAtenalb();
            source.komokuA7 = groupSource7.getKoumokua();
            source.komokuB7 = groupSource7.getKoumokub();
            source.komokuC7 = groupSource7.getKoumokuc();
        }
    }

    private void editEight(AtenaSeal21Source source) {
        if (null != data.getParam8()) {
            AtenaSealGroupSource groupSource8 = edit総合編集_21面(source, data.getParam8());
            source.jushoList8 = groupSource8.getJushoList();
            source.meishoList8 = groupSource8.getMeishoList();
            if (!groupSource8.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_8 = new RString(groupSource8.getShikibetsuCode().toString());
                source.shikibetsuCode8 = new RString(groupSource8.getShikibetsuCode().toString());
            }
            source.yubinNo8 = groupSource8.getYubinno();
            source.jushoA8 = groupSource8.getJushoa();
            source.jushoB8 = groupSource8.getJushob();
            source.jushoC8 = groupSource8.getJushoc();
            source.jushoLa8 = groupSource8.getJushola();
            source.jushoLb8 = groupSource8.getJusholb();
            source.jushoLc8 = groupSource8.getJusholc();
            source.jushoLd8 = groupSource8.getJushold();
            source.atenaA8 = groupSource8.getAtenaa();
            source.atenaB8 = groupSource8.getAtenab();
            source.atenaLa8 = groupSource8.getAtenala();
            source.atenaLb8 = groupSource8.getAtenalb();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード8 = groupSource8.getShikibetsuCode();
                source.個人番号使用8 = KojinNo.EMPTY;
                source.法人番号使用8 = HojinNo.EMPTY;
            }
            source.komokuA8 = groupSource8.getKoumokua();
            source.komokuB8 = groupSource8.getKoumokub();
            source.komokuC8 = groupSource8.getKoumokuc();
        }
    }

    private void editNine(AtenaSeal21Source source) {
        if (null != data.getParam9()) {
            AtenaSealGroupSource groupSource9 = edit総合編集_21面(source, data.getParam9());
            source.jushoList9 = groupSource9.getJushoList();
            source.meishoList9 = groupSource9.getMeishoList();
            if (!groupSource9.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_9 = new RString(groupSource9.getShikibetsuCode().toString());
                source.shikibetsuCode9 = new RString(groupSource9.getShikibetsuCode().toString());
            }
            source.yubinNo9 = groupSource9.getYubinno();
            source.jushoA9 = groupSource9.getJushoa();
            source.jushoB9 = groupSource9.getJushob();
            source.jushoC9 = groupSource9.getJushoc();
            source.jushoLa9 = groupSource9.getJushola();
            source.jushoLb9 = groupSource9.getJusholb();
            source.jushoLc9 = groupSource9.getJusholc();
            source.jushoLd9 = groupSource9.getJushold();
            source.atenaA9 = groupSource9.getAtenaa();
            source.atenaB9 = groupSource9.getAtenab();
            source.atenaLa9 = groupSource9.getAtenala();
            source.atenaLb9 = groupSource9.getAtenalb();
            source.komokuA9 = groupSource9.getKoumokua();
            source.komokuB9 = groupSource9.getKoumokub();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード9 = groupSource9.getShikibetsuCode();
                source.個人番号使用9 = KojinNo.EMPTY;
                source.法人番号使用9 = HojinNo.EMPTY;
            }
            source.komokuC9 = groupSource9.getKoumokuc();
        }
    }

    private void editTen(AtenaSeal21Source source) {
        if (null != data.getParam10()) {
            AtenaSealGroupSource groupSource10 = edit総合編集_21面(source, data.getParam10());
            source.jushoList10 = groupSource10.getJushoList();
            source.meishoList10 = groupSource10.getMeishoList();
            if (!groupSource10.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_10 = new RString(groupSource10.getShikibetsuCode().toString());
                source.shikibetsuCode10 = new RString(groupSource10.getShikibetsuCode().toString());
            }
            source.yubinNo10 = groupSource10.getYubinno();
            source.jushoA10 = groupSource10.getJushoa();
            source.jushoB10 = groupSource10.getJushob();
            source.jushoC10 = groupSource10.getJushoc();
            source.jushoLa10 = groupSource10.getJushola();
            source.jushoLb10 = groupSource10.getJusholb();
            source.jushoLc10 = groupSource10.getJusholc();
            source.jushoLd10 = groupSource10.getJushold();
            source.atenaA10 = groupSource10.getAtenaa();
            source.atenaB10 = groupSource10.getAtenab();
            source.atenaLa10 = groupSource10.getAtenala();
            source.atenaLb10 = groupSource10.getAtenalb();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード10 = groupSource10.getShikibetsuCode();
                source.個人番号使用10 = KojinNo.EMPTY;
                source.法人番号使用10 = HojinNo.EMPTY;
            }
            source.komokuA10 = groupSource10.getKoumokua();
            source.komokuB10 = groupSource10.getKoumokub();
            source.komokuC10 = groupSource10.getKoumokuc();
        }
    }

    private void editEleven(AtenaSeal21Source source) {
        if (null != data.getParam11()) {
            AtenaSealGroupSource groupSource11 = edit総合編集_21面(source, data.getParam11());
            source.jushoList11 = groupSource11.getJushoList();
            source.meishoList11 = groupSource11.getMeishoList();
            if (!groupSource11.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_11 = new RString(groupSource11.getShikibetsuCode().toString());
                source.shikibetsuCode11 = new RString(groupSource11.getShikibetsuCode().toString());
            }
            source.yubinNo11 = groupSource11.getYubinno();
            source.jushoA11 = groupSource11.getJushoa();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード11 = groupSource11.getShikibetsuCode();
                source.個人番号使用11 = KojinNo.EMPTY;
                source.法人番号使用11 = HojinNo.EMPTY;
            }
            source.jushoB11 = groupSource11.getJushob();
            source.jushoC11 = groupSource11.getJushoc();
            source.jushoLa11 = groupSource11.getJushola();
            source.jushoLb11 = groupSource11.getJusholb();
            source.jushoLc11 = groupSource11.getJusholc();
            source.jushoLd11 = groupSource11.getJushold();
            source.atenaA11 = groupSource11.getAtenaa();
            source.atenaB11 = groupSource11.getAtenab();
            source.atenaLa11 = groupSource11.getAtenala();
            source.atenaLb11 = groupSource11.getAtenalb();
            source.komokuA11 = groupSource11.getKoumokua();
            source.komokuB11 = groupSource11.getKoumokub();
            source.komokuC11 = groupSource11.getKoumokuc();
        }
    }

    private void editTwelve(AtenaSeal21Source source) {
        if (null != data.getParam12()) {
            AtenaSealGroupSource groupSource12 = edit総合編集_21面(source, data.getParam12());
            source.jushoList12 = groupSource12.getJushoList();
            source.meishoList12 = groupSource12.getMeishoList();
            if (!groupSource12.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_12 = new RString(groupSource12.getShikibetsuCode().toString());
                source.shikibetsuCode12 = new RString(groupSource12.getShikibetsuCode().toString());
            }
            source.yubinNo12 = groupSource12.getYubinno();
            source.jushoA12 = groupSource12.getJushoa();
            source.jushoB12 = groupSource12.getJushob();
            source.jushoC12 = groupSource12.getJushoc();
            source.jushoLa12 = groupSource12.getJushola();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード12 = groupSource12.getShikibetsuCode();
                source.個人番号使用12 = KojinNo.EMPTY;
                source.法人番号使用12 = HojinNo.EMPTY;
            }
            source.jushoLb12 = groupSource12.getJusholb();
            source.jushoLc12 = groupSource12.getJusholc();
            source.jushoLd12 = groupSource12.getJushold();
            source.atenaA12 = groupSource12.getAtenaa();
            source.atenaB12 = groupSource12.getAtenab();
            source.atenaLa12 = groupSource12.getAtenala();
            source.atenaLb12 = groupSource12.getAtenalb();
            source.komokuA12 = groupSource12.getKoumokua();
            source.komokuB12 = groupSource12.getKoumokub();
            source.komokuC12 = groupSource12.getKoumokuc();
        }
    }

    private void editThirteen(AtenaSeal21Source source) {
        if (null != data.getParam13()) {
            AtenaSealGroupSource groupSource13 = edit総合編集_21面(source, data.getParam13());
            source.jushoList13 = groupSource13.getJushoList();
            source.meishoList13 = groupSource13.getMeishoList();
            if (!groupSource13.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_13 = new RString(groupSource13.getShikibetsuCode().toString());
                source.shikibetsuCode13 = new RString(groupSource13.getShikibetsuCode().toString());
            }
            source.yubinNo13 = groupSource13.getYubinno();
            source.jushoA13 = groupSource13.getJushoa();
            source.jushoB13 = groupSource13.getJushob();
            source.jushoC13 = groupSource13.getJushoc();
            source.jushoLa13 = groupSource13.getJushola();
            source.jushoLb13 = groupSource13.getJusholb();
            source.jushoLc13 = groupSource13.getJusholc();
            source.jushoLd13 = groupSource13.getJushold();
            source.atenaA13 = groupSource13.getAtenaa();
            source.atenaB13 = groupSource13.getAtenab();
            source.atenaLa13 = groupSource13.getAtenala();
            source.atenaLb13 = groupSource13.getAtenalb();
            source.komokuA13 = groupSource13.getKoumokua();
            source.komokuB13 = groupSource13.getKoumokub();
            source.komokuC13 = groupSource13.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード13 = groupSource13.getShikibetsuCode();
                source.個人番号使用13 = KojinNo.EMPTY;
                source.法人番号使用13 = HojinNo.EMPTY;
            }
        }
    }

    private void editFourteen(AtenaSeal21Source source) {
        if (null != data.getParam14()) {
            AtenaSealGroupSource groupSource14 = edit総合編集_21面(source, data.getParam14());
            source.jushoList14 = groupSource14.getJushoList();
            source.meishoList14 = groupSource14.getMeishoList();
            if (!groupSource14.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_14 = new RString(groupSource14.getShikibetsuCode().toString());
                source.shikibetsuCode14 = new RString(groupSource14.getShikibetsuCode().toString());
            }
            source.yubinNo14 = groupSource14.getYubinno();
            source.jushoA14 = groupSource14.getJushoa();
            source.jushoB14 = groupSource14.getJushob();
            source.jushoC14 = groupSource14.getJushoc();
            source.jushoLa14 = groupSource14.getJushola();
            source.jushoLb14 = groupSource14.getJusholb();
            source.jushoLc14 = groupSource14.getJusholc();
            source.jushoLd14 = groupSource14.getJushold();
            source.atenaA14 = groupSource14.getAtenaa();
            source.atenaB14 = groupSource14.getAtenab();
            source.atenaLa14 = groupSource14.getAtenala();
            source.atenaLb14 = groupSource14.getAtenalb();
            source.komokuA14 = groupSource14.getKoumokua();
            source.komokuB14 = groupSource14.getKoumokub();
            source.komokuC14 = groupSource14.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード14 = groupSource14.getShikibetsuCode();
                source.個人番号使用14 = KojinNo.EMPTY;
                source.法人番号使用14 = HojinNo.EMPTY;
            }
        }
    }

    private void editFiveteen(AtenaSeal21Source source) {
        if (null != data.getParam15()) {
            AtenaSealGroupSource groupSource15 = edit総合編集_21面(source, data.getParam15());
            source.jushoList15 = groupSource15.getJushoList();
            source.meishoList15 = groupSource15.getMeishoList();
            if (!groupSource15.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_15 = new RString(groupSource15.getShikibetsuCode().toString());
                source.shikibetsuCode15 = new RString(groupSource15.getShikibetsuCode().toString());
            }
            source.yubinNo15 = groupSource15.getYubinno();
            source.jushoA15 = groupSource15.getJushoa();
            source.jushoB15 = groupSource15.getJushob();
            source.jushoC15 = groupSource15.getJushoc();
            source.jushoLa15 = groupSource15.getJushola();
            source.jushoLb15 = groupSource15.getJusholb();
            source.jushoLc15 = groupSource15.getJusholc();
            source.jushoLd15 = groupSource15.getJushold();
            source.atenaA15 = groupSource15.getAtenaa();
            source.atenaB15 = groupSource15.getAtenab();
            source.atenaLa15 = groupSource15.getAtenala();
            source.atenaLb15 = groupSource15.getAtenalb();
            source.komokuA15 = groupSource15.getKoumokua();
            source.komokuB15 = groupSource15.getKoumokub();
            source.komokuC15 = groupSource15.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード15 = groupSource15.getShikibetsuCode();
                source.個人番号使用15 = KojinNo.EMPTY;
                source.法人番号使用15 = HojinNo.EMPTY;
            }
        }
    }

    private void editSixteen(AtenaSeal21Source source) {
        if (null != data.getParam16()) {
            AtenaSealGroupSource groupSource16 = edit総合編集_21面(source, data.getParam16());
            source.jushoList16 = groupSource16.getJushoList();
            source.meishoList16 = groupSource16.getMeishoList();
            if (!groupSource16.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_16 = new RString(groupSource16.getShikibetsuCode().toString());
                source.shikibetsuCode16 = new RString(groupSource16.getShikibetsuCode().toString());
            }
            source.yubinNo16 = groupSource16.getYubinno();
            source.jushoA16 = groupSource16.getJushoa();
            source.jushoB16 = groupSource16.getJushob();
            source.jushoC16 = groupSource16.getJushoc();
            source.jushoLa16 = groupSource16.getJushola();
            source.jushoLb16 = groupSource16.getJusholb();
            source.jushoLc16 = groupSource16.getJusholc();
            source.jushoLd16 = groupSource16.getJushold();
            source.atenaA16 = groupSource16.getAtenaa();
            source.atenaB16 = groupSource16.getAtenab();
            source.atenaLa16 = groupSource16.getAtenala();
            source.atenaLb16 = groupSource16.getAtenalb();
            source.komokuA16 = groupSource16.getKoumokua();
            source.komokuB16 = groupSource16.getKoumokub();
            source.komokuC16 = groupSource16.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード16 = groupSource16.getShikibetsuCode();
                source.個人番号使用16 = KojinNo.EMPTY;
                source.法人番号使用16 = HojinNo.EMPTY;
            }
        }
    }

    private void editSeventeen(AtenaSeal21Source source) {
        if (null != data.getParam17()) {
            AtenaSealGroupSource groupSource17 = edit総合編集_21面(source, data.getParam17());
            source.jushoList17 = groupSource17.getJushoList();
            source.meishoList17 = groupSource17.getMeishoList();
            if (!groupSource17.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_17 = new RString(groupSource17.getShikibetsuCode().toString());
                source.shikibetsuCode17 = new RString(groupSource17.getShikibetsuCode().toString());
            }
            source.yubinNo17 = groupSource17.getYubinno();
            source.jushoA17 = groupSource17.getJushoa();
            source.jushoB17 = groupSource17.getJushob();
            source.jushoC17 = groupSource17.getJushoc();
            source.jushoLa17 = groupSource17.getJushola();
            source.jushoLb17 = groupSource17.getJusholb();
            source.jushoLc17 = groupSource17.getJusholc();
            source.jushoLd17 = groupSource17.getJushold();
            source.atenaA17 = groupSource17.getAtenaa();
            source.atenaB17 = groupSource17.getAtenab();
            source.atenaLa17 = groupSource17.getAtenala();
            source.atenaLb17 = groupSource17.getAtenalb();
            source.komokuA17 = groupSource17.getKoumokua();
            source.komokuB17 = groupSource17.getKoumokub();
            source.komokuC17 = groupSource17.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード17 = groupSource17.getShikibetsuCode();
                source.個人番号使用17 = KojinNo.EMPTY;
                source.法人番号使用17 = HojinNo.EMPTY;
            }
        }
    }

    private void editEighteen(AtenaSeal21Source source) {
        if (null != data.getParam18()) {
            AtenaSealGroupSource groupSource18 = edit総合編集_21面(source, data.getParam18());
            source.jushoList18 = groupSource18.getJushoList();
            source.meishoList18 = groupSource18.getMeishoList();
            if (!groupSource18.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_18 = new RString(groupSource18.getShikibetsuCode().toString());
                source.shikibetsuCode18 = new RString(groupSource18.getShikibetsuCode().toString());
            }
            source.yubinNo18 = groupSource18.getYubinno();
            source.jushoA18 = groupSource18.getJushoa();
            source.jushoB18 = groupSource18.getJushob();
            source.jushoC18 = groupSource18.getJushoc();
            source.jushoLa18 = groupSource18.getJushola();
            source.jushoLb18 = groupSource18.getJusholb();
            source.jushoLc18 = groupSource18.getJusholc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード18 = groupSource18.getShikibetsuCode();
                source.個人番号使用18 = KojinNo.EMPTY;
                source.法人番号使用18 = HojinNo.EMPTY;
            }
            source.jushoLd18 = groupSource18.getJushold();
            source.atenaA18 = groupSource18.getAtenaa();
            source.atenaB18 = groupSource18.getAtenab();
            source.atenaLa18 = groupSource18.getAtenala();
            source.atenaLb18 = groupSource18.getAtenalb();
            source.komokuA18 = groupSource18.getKoumokua();
            source.komokuB18 = groupSource18.getKoumokub();
            source.komokuC18 = groupSource18.getKoumokuc();
        }
    }

    private void editNineteen(AtenaSeal21Source source) {
        if (null != data.getParam19()) {
            AtenaSealGroupSource groupSource19 = edit総合編集_21面(source, data.getParam19());
            source.jushoList19 = groupSource19.getJushoList();
            source.meishoList19 = groupSource19.getMeishoList();
            if (!groupSource19.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode19 = new RString(groupSource19.getShikibetsuCode().toString());
                source.shikibetsuCode_19 = new RString(groupSource19.getShikibetsuCode().toString());
            }
            source.yubinNo19 = groupSource19.getYubinno();
            source.jushoA19 = groupSource19.getJushoa();
            source.jushoB19 = groupSource19.getJushob();
            source.jushoC19 = groupSource19.getJushoc();
            source.jushoLa19 = groupSource19.getJushola();
            source.jushoLb19 = groupSource19.getJusholb();
            source.jushoLc19 = groupSource19.getJusholc();
            source.jushoLd19 = groupSource19.getJushold();
            source.atenaA19 = groupSource19.getAtenaa();
            source.atenaB19 = groupSource19.getAtenab();
            source.atenaLa19 = groupSource19.getAtenala();
            source.atenaLb19 = groupSource19.getAtenalb();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード19 = groupSource19.getShikibetsuCode();
                source.個人番号使用19 = KojinNo.EMPTY;
                source.法人番号使用19 = HojinNo.EMPTY;
            }
            source.komokuA19 = groupSource19.getKoumokua();
            source.komokuB19 = groupSource19.getKoumokub();
            source.komokuC19 = groupSource19.getKoumokuc();
        }
    }

    private void editTwenty(AtenaSeal21Source source) {
        if (null != data.getParam20()) {
            AtenaSealGroupSource groupSource20 = edit総合編集_21面(source, data.getParam20());
            source.jushoList20 = groupSource20.getJushoList();
            source.meishoList20 = groupSource20.getMeishoList();
            if (!groupSource20.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_20 = new RString(groupSource20.getShikibetsuCode().toString());
                source.shikibetsuCode20 = new RString(groupSource20.getShikibetsuCode().toString());
            }
            source.yubinNo20 = groupSource20.getYubinno();
            source.jushoA20 = groupSource20.getJushoa();
            source.jushoB20 = groupSource20.getJushob();
            source.jushoC20 = groupSource20.getJushoc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード20 = groupSource20.getShikibetsuCode();
                source.個人番号使用20 = KojinNo.EMPTY;
                source.法人番号使用20 = HojinNo.EMPTY;
            }
            source.jushoLa20 = groupSource20.getJushola();
            source.jushoLb20 = groupSource20.getJusholb();
            source.jushoLc20 = groupSource20.getJusholc();
            source.jushoLd20 = groupSource20.getJushold();
            source.atenaA20 = groupSource20.getAtenaa();
            source.atenaB20 = groupSource20.getAtenab();
            source.atenaLa20 = groupSource20.getAtenala();
            source.atenaLb20 = groupSource20.getAtenalb();
            source.komokuA20 = groupSource20.getKoumokua();
            source.komokuB20 = groupSource20.getKoumokub();
            source.komokuC20 = groupSource20.getKoumokuc();
        }
    }

    private void editTwenty_one(AtenaSeal21Source source) {
        if (null != data.getParam21()) {
            AtenaSealGroupSource groupSource21 = edit総合編集_21面(source, data.getParam21());
            source.jushoList21 = groupSource21.getJushoList();
            source.meishoList21 = groupSource21.getMeishoList();
            if (!groupSource21.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode_21 = new RString(groupSource21.getShikibetsuCode().toString());
                source.shikibetsuCode21 = new RString(groupSource21.getShikibetsuCode().toString());
            }
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード21 = groupSource21.getShikibetsuCode();
                source.個人番号使用21 = KojinNo.EMPTY;
                source.法人番号使用21 = HojinNo.EMPTY;
            }
            source.yubinNo21 = groupSource21.getYubinno();
            source.jushoA21 = groupSource21.getJushoa();
            source.jushoB21 = groupSource21.getJushob();
            source.jushoC21 = groupSource21.getJushoc();
            source.jushoLa21 = groupSource21.getJushola();
            source.jushoLb21 = groupSource21.getJusholb();
            source.jushoLc21 = groupSource21.getJusholc();
            source.jushoLd21 = groupSource21.getJushold();
            source.atenaA21 = groupSource21.getAtenaa();
            source.atenaB21 = groupSource21.getAtenab();
            source.atenaLa21 = groupSource21.getAtenala();
            source.atenaLb21 = groupSource21.getAtenalb();
            source.komokuA21 = groupSource21.getKoumokua();
            source.komokuB21 = groupSource21.getKoumokub();
            source.komokuC21 = groupSource21.getKoumokuc();
        }
    }

    private void edit作成日時(AtenaSeal21Source source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分)).concat(作成_21面);
    }

    private void edit市町村コード(AtenaSeal21Source source) {
        if (null != data.get地方公共団体情報() && null != data.get地方公共団体情報().get地方公共団体コード()) {
            source.shichosonCode = data.get地方公共団体情報().get地方公共団体コード().getColumnValue();
        }
    }

    private void edit市町村名(AtenaSeal21Source source) {
        if (null != data.get地方公共団体情報()) {
            source.shichosonMei = data.get地方公共団体情報().get市町村名();
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void edit帳票タイトルと郵便番号と選挙名称(AtenaSeal21Source source, AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (data.get画面ID().equals(選挙人宛名シール_21面)) {
            source.title = new RString("選挙人宛名シール（21面）");
            if (null != param && null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                YubinNo jutonaiYubinNo = param.get投票資格情報().getAtenaPSMEntity().getJutonaiYubinNo();
                groupSource.setYubinno(null == jutonaiYubinNo ? RString.EMPTY : jutonaiYubinNo.getColumnValue());
            }
        } else if (data.get画面ID().equals(転出者宛名シール_21面)) {
            source.title = new RString("転出者宛名シール（21面）");
            if (null != param && null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                YubinNo yubinNo = param.get投票資格情報().getAtenaPSMEntity().getYubinNo();
                groupSource.setYubinno(null == yubinNo ? RString.EMPTY : yubinNo.getColumnValue());
            }
            if (null != param && null != param.get投票資格情報() && null != param.get投票資格情報().getSenkyoEntity()) {
                source.senkyoMei = changeNullToEmpty(param.get投票資格情報().getSenkyoEntity().getSenkyoName());
            }
        } else if (data.get画面ID().equals(施設宛名シール_21面)) {
            source.title = new RString("施設宛名シール（21面）");
            if (null != param && null != param.get施設情報()) {
                YubinNo yubinNoo = param.get施設情報().getYubinNo();
                groupSource.setYubinno(null == yubinNoo ? RString.EMPTY : yubinNoo.getColumnValue());
            }
        } else if (data.get画面ID().equals(入場券発行_一括)) {
            source.title = new RString("入場券発行（一括）");
        } else if (data.get画面ID().equals(定時登録)) {
            source.title = new RString("定時登録");
        } else if (data.get画面ID().equals(定時帳票再発行)) {
            source.title = new RString("定時帳票再発行");
        } else if (data.get画面ID().equals(選挙時登録)) {
            source.title = new RString("選挙時登録");
        } else if (data.get画面ID().equals(選挙時登録帳票再発行)) {
            source.title = new RString("選挙時登録帳票再発行");
        } else if (data.get画面ID().equals(国民投票時登録)) {
            source.title = new RString("国民投票時登録");
        } else if (data.get画面ID().equals(国民投票帳票再発行)) {
            source.title = new RString("国民投票帳票再発行");
        } else if (data.get画面ID().equals(海区漁業調整委員会委員選挙時登録)) {
            source.title = new RString("海区漁業調整委員会委員選挙時登録");
        } else if (data.get画面ID().equals(海区漁業調整委員会委員選挙人名簿最新化)) {
            source.title = new RString("海区漁業調整委員会委員選挙人名簿最新化");
        }
    }

    private void edit画面編集(AtenaSeal21Source source, AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != data.get画面ID()) {
            edit帳票タイトルと郵便番号と選挙名称(source, param, groupSource);
            edit住所印字処理(param, groupSource, source);
            edit宛名印字処理(param, groupSource, source);
            edit隅の項目印字処理(param, groupSource);
            editアクセスログ出力(param, groupSource);
        }
    }

    private AtenaSealGroupSource edit総合編集_21面(AtenaSeal21Source source, AtenaSealPartParam param) {
        AtenaSealGroupSource groupSource = new AtenaSealGroupSource();
        edit画面編集(source, param, groupSource);
        return groupSource;
    }

    private RString edit追加編集_21面(AtenaSealPartParam param, RString value) {
        RString resultValue = RString.EMPTY;
        if (null != param && null != param.get画面情報()) {
            if (param.get画面情報().get住所の前に市町村名を付加().equals(ZERO)) {
                resultValue = value;
            } else if (param.get画面情報().get住所の前に市町村名を付加().equals(ONE)) {
                RString additionalValue = data.get地方公共団体情報().get市町村名();
                resultValue = additionalValue.concat(value);
            } else if (param.get画面情報().get住所の前に市町村名を付加().equals(TWO)) {
                RString additionalValue = data.get地方公共団体情報().get都道府県名().concat(data.get地方公共団体情報().get市町村名());
                resultValue = additionalValue.concat(value);
            }
        }

        return resultValue;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void edit住所印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (data.get画面ID().equals(選挙人宛名シール_21面) && null != param.get画面情報()) {
            RString 住所ID = null == param.get画面情報().get住所コード()
                    ? RString.EMPTY : param.get画面情報().get住所コード();
            if (param.get投票資格情報() != null && param.get投票資格情報().getAtenaPSMEntity() != null) {
                Katagaki jutonaiKatagaki = param.get投票資格情報().getAtenaPSMEntity().getJutonaiKatagaki();
                AtenaBanchi jutonaiBanchi = param.get投票資格情報().getAtenaPSMEntity().getJutonaiBanchi();
                RString jutonaiKatagakiValue = null == jutonaiKatagaki ? RString.EMPTY : jutonaiKatagaki.getColumnValue();
                RString jutonaiBanchiValue = null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue();
                switch (住所ID.toString()) {
                    case "1":
                        RString value11 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                                .concat(jutonaiBanchiValue);
                        RString value12 = jutonaiKatagakiValue;
                        edit選挙人の住所処理1(edit追加編集_21面(param, value11), value12, groupSource, source);
                        break;
                    case "2":
                        RString value21 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                                .concat(左括弧_21面)
                                .concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()))
                                .concat(右括弧_21面)
                                .concat(jutonaiBanchiValue);
                        RString value22 = jutonaiKatagakiValue;
                        edit選挙人の住所処理1(edit追加編集_21面(param, value21), value22, groupSource, source);
                        break;
                    case "3":
                        RString value31 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                                .concat(jutonaiBanchiValue)
                                .concat(左括弧_21面)
                                .concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()))
                                .concat(右括弧_21面);
                        RString value32 = jutonaiKatagakiValue;
                        edit選挙人の住所処理1(edit追加編集_21面(param, value31), value32, groupSource, source);
                        break;
                    case "4":
                        RString value41 = 左括弧_21面
                                .concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()))
                                .concat(右括弧_21面);
                        RString value42 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                                .concat(jutonaiBanchiValue);
                        RString value43 = jutonaiKatagakiValue;
                        edit選挙人の住所処理2(edit追加編集_21面(param, value41), value42, value43, groupSource, source);
                        break;
                    case "5":
                        RString value51 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                                .concat(jutonaiBanchiValue);
                        RString value52 = jutonaiKatagakiValue;
                        RString value53 = 全角スペース.concat(全角スペース).concat(全角スペース)
                                .concat(左括弧_21面)
                                .concat(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName())
                                .concat(右括弧_21面);
                        edit選挙人の住所処理2(edit追加編集_21面(param, value51), value52, value53, groupSource, source);
                        break;
                    case "6":
                        RString value61 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName())
                                .concat(jutonaiBanchiValue);
                        RString value62 = jutonaiKatagakiValue;
                        edit選挙人の住所処理1(edit追加編集_21面(param, value61), value62, groupSource, source);
                        break;
                    default:
                }
            }
        } else if (data.get画面ID().equals(施設宛名シール_21面) && param != null && null != param.get施設情報()) {
            AtenaJusho jushoo = param.get施設情報().getJusho();
            RString suJushoValue = null == jushoo ? RString.EMPTY : jushoo.getColumnValue();
            edit転出者と施設の住所処理(suJushoValue, groupSource, source);
        } else if (data.get画面ID().equals(転出者宛名シール_21面) && param != null
                && param.get投票資格情報() != null && param.get投票資格情報().getAtenaPSMEntity() != null) {
            AtenaJusho jusho = param.get投票資格情報().getAtenaPSMEntity().getJusho();
            AtenaBanchi banchi = param.get投票資格情報().getAtenaPSMEntity().getBanchi();
            Katagaki katagaki = param.get投票資格情報().getAtenaPSMEntity().getKatagaki();
            RString totalValue = null == jusho ? RString.EMPTY : jusho.getColumnValue()
                    .concat(null == banchi ? RString.EMPTY : banchi.getColumnValue())
                    .concat(全角スペース).concat(null == katagaki ? RString.EMPTY : katagaki.getColumnValue());
            edit転出者と施設の住所処理(totalValue, groupSource, source);
        } else if ((data.get画面ID().equals(海区漁業調整委員会委員選挙時登録)
                || data.get画面ID().equals(選挙時登録帳票再発行) || data.get画面ID().equals(国民投票時登録)
                || data.get画面ID().equals(入場券発行_一括) || data.get画面ID().equals(定時登録)
                || data.get画面ID().equals(定時帳票再発行) || data.get画面ID().equals(選挙時登録)
                || data.get画面ID().equals(国民投票帳票再発行) || data.get画面ID().equals(海区漁業調整委員会委員選挙人名簿最新化))
                && null != param && param.get投票資格情報() != null && param.get投票資格情報().getAtenaPSMEntity() != null) {
            Katagaki jutonaiKatagaki = param.get投票資格情報().getAtenaPSMEntity().getJutonaiKatagaki();
            AtenaBanchi jutonaiBanchii = param.get投票資格情報().getAtenaPSMEntity().getJutonaiBanchi();
            RString jutonaiKatagakiValue = null == jutonaiKatagaki ? RString.EMPTY : jutonaiKatagaki.getColumnValue();
            RString jutonaiBanchiValue = null == jutonaiBanchii ? RString.EMPTY : jutonaiBanchii.getColumnValue();
            RString comprehensiveValue1 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                    .concat(jutonaiBanchiValue);
            RString comprehensiveValue2 = jutonaiKatagakiValue;
            edit選挙人の住所処理1(comprehensiveValue1, comprehensiveValue2, groupSource, source);
        }
    }

    private void edit転出者と施設の住所処理(RString value, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value.length() > (長さ_21面_住所_上段 + 長さ_21面_住所_中段 + 長さ_21面_住所_下段)) {
            if (value.length() > (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)) {
                groupSource.setJushola(value.substring(0, 長さ_21面_小住所1));
                groupSource.setJusholb(value.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
                groupSource.setJusholc(value.substring((長さ_21面_小住所1 + 長さ_21面_小住所2), (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
                groupSource.setJushold(value.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3),
                        (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)));
                source.jushoList = value;
                groupSource.setJushoList(value);
            } else {
                if (value.length() <= 長さ_21面_小住所1) {
                    groupSource.setJushola(value);
                    groupSource.setJusholb(RString.EMPTY);
                    groupSource.setJusholc(RString.EMPTY);
                    groupSource.setJushold(RString.EMPTY);
                } else if (value.length() <= (長さ_21面_小住所1 + 長さ_21面_小住所2)) {
                    groupSource.setJushola(value.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value.substring(長さ_21面_小住所1));
                    groupSource.setJusholc(RString.EMPTY);
                    groupSource.setJushold(RString.EMPTY);
                } else if (value.length() <= (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)) {
                    groupSource.setJushola(value.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value.substring(長さ_21面_小住所1, 長さ_21面_小住所1 + 長さ_21面_小住所2));
                    groupSource.setJusholc(value.substring(長さ_21面_小住所1 + 長さ_21面_小住所2));
                    groupSource.setJushold(RString.EMPTY);
                } else {
                    groupSource.setJushola(value.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
                    groupSource.setJusholc(value.substring((長さ_21面_小住所1 + 長さ_21面_小住所2), (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
                    groupSource.setJushold(value.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
                }
            }
        } else {
            if (value.length() <= 長さ_21面_住所_上段) {
                groupSource.setJushoa(value);
                groupSource.setJushob(RString.EMPTY);
                groupSource.setJushoc(RString.EMPTY);
            } else if (value.length() <= (長さ_21面_住所_上段 + 長さ_21面_住所_中段)) {
                groupSource.setJushoa(value.substring(0, 長さ_21面_住所_上段));
                groupSource.setJushob(value.substring(長さ_21面_住所_上段));
                groupSource.setJushoc(RString.EMPTY);
            } else {
                groupSource.setJushoa(value.substring(0, 長さ_21面_住所_上段));
                groupSource.setJushob(value.substring(長さ_21面_住所_上段, (長さ_21面_住所_上段 + 長さ_21面_住所_中段)));
                groupSource.setJushoc(value.substring((長さ_21面_住所_上段 + 長さ_21面_住所_中段)));
            }
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void edit宛名印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        RString 宛名シール21面_本人敬称 = RString.EMPTY;
        RString 宛名シール21面_世帯主敬称 = RString.EMPTY;
        RString 宛名シール21面_宛名ID = RString.EMPTY;
        if (param != null && param.get画面情報() != null) {
            宛名シール21面_本人敬称 = changeNullToEmpty(ZERO.equals(param.get画面情報().get本人敬称コード()) ? RString.EMPTY : param.get画面情報().get本人敬称());
            宛名シール21面_世帯主敬称 = changeNullToEmpty(ZERO.equals(param.get画面情報().get世帯主敬称コード()) ? RString.EMPTY : param.get画面情報().get世帯主敬称());
            宛名シール21面_宛名ID = changeNullToEmpty(null == param.get画面情報().get宛名コード() ? RString.EMPTY : param.get画面情報().get宛名コード());
        }
        if (data.get画面ID().equals(選挙人宛名シール_21面) && param != null && param.get画面情報() != null) {
            if (param.get投票資格情報() != null && param.get投票資格情報().getAtenaPSMEntity() != null) {
                AtenaMeisho meisho = param.get投票資格情報().getAtenaPSMEntity().getMeisho();
                RString meishoValue = null == meisho ? RString.EMPTY : meisho.getColumnValue();
                switch (宛名シール21面_宛名ID.toString()) {
                    case "1":
                        RString value = meishoValue.concat(宛名シール21面_本人敬称);
                        edit宛名編集(value, groupSource, source);
                        break;
                    case "2":
                        AtenaKanaMeisho kanaMeisho = param.get投票資格情報().getAtenaPSMEntity().getKanaMeisho();
                        RString value21 = null == kanaMeisho ? RString.EMPTY : kanaMeisho.getColumnValue();
                        RString value22 = meishoValue.concat(宛名シール21面_本人敬称);
                        edit宛名編集2(value21, value22, groupSource);
                        break;
                    case "3":
                        AtenaMeisho setainushiMei = param.get投票資格情報().getAtenaPSMEntity().getSetainushiMei();
                        RString value31 = null == setainushiMei ? RString.EMPTY : setainushiMei.getColumnValue()
                                .concat(宛名シール21面_世帯主敬称);
                        RString value32 = meishoValue.concat(宛名シール21面_本人敬称);
                        edit宛名編集2(value31, value32, groupSource);
                        break;
                    default:
                }
            }
        } else if (data.get画面ID().equals(転出者宛名シール_21面) && param != null && param.get画面情報() != null) {
            if (param.get投票資格情報() != null && param.get投票資格情報().getAtenaPSMEntity() != null) {
                AtenaMeisho meisho = param.get投票資格情報().getAtenaPSMEntity().getMeisho();
                RString meishoValue = null == meisho ? RString.EMPTY : meisho.getColumnValue();
                RString totalAtenaValue = meishoValue.concat(宛名シール21面_本人敬称);
                edit転出者の宛名処理(totalAtenaValue, groupSource, source);
            }
        } else if (data.get画面ID().equals(施設宛名シール_21面) && param != null && param.get画面情報() != null && param.get施設情報() != null) {
            AtenaMeisho shisetsuAtena = param.get施設情報().getShisetsuAtena();
            RString shisetsuAtenaValue = null == shisetsuAtena ? RString.EMPTY : shisetsuAtena.getColumnValue();
            switch (宛名シール21面_宛名ID.toString()) {
                case "1":
                    RString total_shisetsuValue = changeNullToEmpty(param.get施設情報().getShisetsuName()).concat(宛名シール21面_本人敬称);
                    edit宛名編集(total_shisetsuValue, groupSource, source);
                    break;
                case "2":
                    RString total_shisetsuAtenaValue = shisetsuAtenaValue.concat(宛名シール21面_本人敬称);
                    edit宛名編集(total_shisetsuAtenaValue, groupSource, source);
                    break;
                case "3":
                    RString totalvalue1 = changeNullToEmpty(param.get施設情報().getShisetsuName()).concat(宛名シール21面_世帯主敬称);
                    RString totalvalue2 = shisetsuAtenaValue.concat(宛名シール21面_本人敬称);
                    edit宛名編集2(totalvalue1, totalvalue2, groupSource);
                    break;
                default:
            }
        } else if ((data.get画面ID().equals(国民投票帳票再発行)
                || data.get画面ID().equals(定時帳票再発行) || data.get画面ID().equals(選挙時登録)
                || data.get画面ID().equals(入場券発行_一括) || data.get画面ID().equals(定時登録)
                || data.get画面ID().equals(選挙時登録帳票再発行) || data.get画面ID().equals(国民投票時登録)
                || data.get画面ID().equals(海区漁業調整委員会委員選挙時登録) || data.get画面ID().equals(海区漁業調整委員会委員選挙人名簿最新化))
                && null != param && null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            AtenaMeisho meisho = param.get投票資格情報().getAtenaPSMEntity().getMeisho();
            RString meishoValue = null == meisho ? RString.EMPTY : meisho.getColumnValue();
            RString comprehensiveValue = meishoValue.concat(様_21面);
            edit宛名編集(comprehensiveValue, groupSource, source);
        }
    }

    private void edit宛名編集2(RString value1, RString value2, AtenaSealGroupSource groupSource) {
        if (value1.length() > 長さ_21面_小宛名上段 || value2.length() > 長さ_21面_小宛名下段) {
            if (is文字切れ(長さ_21面_小宛名上段, value1)) {
                groupSource.setAtenala(value1.substring(0, 長さ_21面_小宛名上段));
                groupSource.setMeishoList(value1);
            } else {
                groupSource.setAtenala(value1);
            }
            if (is文字切れ(長さ_21面_小宛名下段, value2)) {
                groupSource.setAtenalb(value2.substring(0, 長さ_21面_小宛名下段));
                groupSource.setMeishoList(value2);
            } else {
                groupSource.setAtenalb(value2);
            }
        } else if (value1.length() > 長さ_21面_宛名上段 || value2.length() > 長さ_21面_宛名下段) {
            groupSource.setAtenala(value1);
            groupSource.setAtenalb(value2);
        } else {
            groupSource.setAtenaa(value1);
            groupSource.setAtenab(value2);
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

    private void edit宛名編集(RString value, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value.length() > (長さ_21面_小宛名上段 + 長さ_21面_小宛名下段)) {
            groupSource.setAtenala(value.substring(0, 長さ_21面_小宛名上段));
            groupSource.setAtenalb(value.substring(長さ_21面_小宛名上段, (長さ_21面_小宛名上段 + 長さ_21面_小宛名下段)));
            source.meishoList = value;
            groupSource.setMeishoList(value);
        } else {
            if (value.length() > (長さ_21面_宛名上段 + 長さ_21面_宛名下段)) {
                if (value.length() <= 長さ_21面_小宛名上段) {
                    groupSource.setAtenala(value);
                    groupSource.setAtenalb(RString.EMPTY);
                } else {
                    groupSource.setAtenala(value.substring(0, 長さ_21面_小宛名上段));
                    groupSource.setAtenalb(value.substring(長さ_21面_小宛名上段));
                }
            } else {
                if (value.length() <= 長さ_21面_宛名下段) {
                    groupSource.setAtenab(value);
                    groupSource.setAtenaa(RString.EMPTY);
                } else if (value.length() <= 長さ_21面_宛名上段) {
                    groupSource.setAtenab(RString.EMPTY);
                    groupSource.setAtenaa(value);
                } else {
                    groupSource.setAtenaa(value.substring(0, 長さ_21面_宛名上段));
                    groupSource.setAtenab(value.substring(長さ_21面_宛名上段));
                }
            }
        }
    }

    private void edit転出者の宛名処理(RString value, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value.length() > (長さ_21面_宛名上段 + 長さ_21面_宛名下段)) {
            if (value.length() > (長さ_21面_小宛名上段 + 長さ_21面_小宛名下段)) {
                groupSource.setAtenala(value.substring(0, 長さ_21面_小宛名上段));
                groupSource.setAtenalb(value.substring(長さ_21面_小宛名上段, (長さ_21面_小宛名上段 + 長さ_21面_小宛名下段)));
                source.meishoList = value;
                groupSource.setMeishoList(value);
            } else {
                if (value.length() <= 長さ_21面_小宛名上段) {
                    groupSource.setAtenala(value);
                    groupSource.setAtenalb(RString.EMPTY);
                } else {
                    groupSource.setAtenala(value.substring(0, 長さ_21面_小宛名上段));
                    groupSource.setAtenalb(value.substring(長さ_21面_小宛名上段));
                }
            }
        } else {
            if (value.length() <= 長さ_21面_宛名上段) {
                groupSource.setAtenaa(value);
                groupSource.setAtenab(RString.EMPTY);
            } else {
                groupSource.setAtenaa(value.substring(0, 長さ_21面_宛名上段));
                groupSource.setAtenab(value.substring(長さ_21面_宛名上段));
            }
        }
    }

    private void edit隅の項目印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (data.get画面ID().equals(選挙人宛名シール_21面) && null != param && null != param.get画面情報()) {
            groupSource.setKoumokua(edit選挙人隅の項目処理(param, param.get画面情報().get四隅項目_左下隅_コード()));
            groupSource.setKoumokub(edit選挙人隅の項目処理(param, param.get画面情報().get四隅項目_右下隅_コード()));
            groupSource.setKoumokuc(edit選挙人隅の項目処理(param, param.get画面情報().get四隅項目_右上隅_コード()));
        } else if (data.get画面ID().equals(転出者宛名シール_21面) && null != param && null != param.get画面情報()) {
            groupSource.setKoumokua(edit転出者隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_左下隅_コード())));
            groupSource.setKoumokub(edit転出者隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_右下隅_コード())));
            groupSource.setKoumokuc(edit転出者隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_右上隅_コード())));
        } else if (data.get画面ID().equals(施設宛名シール_21面) && null != param && null != param.get画面情報()) {
            groupSource.setKoumokua(edit施設隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_左下隅_コード())));
            groupSource.setKoumokub(edit施設隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_右下隅_コード())));
            groupSource.setKoumokuc(edit施設隅の項目処理(param, changeNullToEmpty(param.get画面情報().get四隅項目_右上隅_コード())));
        } else if (data.get画面ID().equals(海区漁業調整委員会委員選挙人名簿最新化)
                || data.get画面ID().equals(入場券発行_一括) || data.get画面ID().equals(選挙時登録)
                || data.get画面ID().equals(定時帳票再発行) || data.get画面ID().equals(定時登録)
                || data.get画面ID().equals(選挙時登録帳票再発行) || data.get画面ID().equals(国民投票時登録)
                || data.get画面ID().equals(国民投票帳票再発行) || data.get画面ID().equals(海区漁業調整委員会委員選挙時登録)) {
            groupSource.setKoumokua(RString.EMPTY);
            groupSource.setKoumokub(RString.EMPTY);
            groupSource.setKoumokuc(RString.EMPTY);
        }
    }

    private void edit小_住所の編集1(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value1.length() > (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)
                || value2.length() > (長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)) {
            edit住所の編集が5行以上(value1, value2, groupSource, source);
        } else {
            if (value1.length() > (長さ_21面_小住所1 + 長さ_21面_小住所2)) {
                if (value2.length() > (長さ_21面_小住所3 + 長さ_21面_小住所4)) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else if (value2.length() > 長さ_21面_小住所4) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else {
                    groupSource.setJushola(value1.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value1.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
                    groupSource.setJusholc(value1.substring((長さ_21面_小住所1 + 長さ_21面_小住所2)));
                    groupSource.setJushold(value2);
                }
            } else if (value1.length() > 長さ_21面_小住所1) {
                if (value2.length() > (長さ_21面_小住所3 + 長さ_21面_小住所4)) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else if (value2.length() > 長さ_21面_小住所4) {
                    groupSource.setJushola(value1.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value1.substring(長さ_21面_小住所1));
                    groupSource.setJusholc(value2.substring(0, 長さ_21面_小住所3));
                    groupSource.setJushold(value2.substring(長さ_21面_小住所3));
                } else {
                    groupSource.setJushola(value1.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value1.substring(長さ_21面_小住所1));
                    groupSource.setJusholc(value2);
                    groupSource.setJushold(RString.EMPTY);
                }
            } else {
                groupSource.setJushola(value1);
                if (value2.length() > (長さ_21面_小住所2 + 長さ_21面_小住所3)) {
                    groupSource.setJusholb(value2.substring(0, 長さ_21面_小住所2));
                    groupSource.setJusholc(value2.substring(長さ_21面_小住所2, (長さ_21面_小住所2 + 長さ_21面_小住所3)));
                    groupSource.setJushold(value2.substring((長さ_21面_小住所2 + 長さ_21面_小住所3)));
                } else if (value2.length() > 長さ_21面_小住所2) {
                    groupSource.setJusholb(value2.substring(0, 長さ_21面_小住所2));
                    groupSource.setJusholc(value2.substring(長さ_21面_小住所2));
                    groupSource.setJushold(RString.EMPTY);
                } else {
                    groupSource.setJusholb(value2);
                    groupSource.setJusholc(RString.EMPTY);
                    groupSource.setJushold(RString.EMPTY);
                }
            }
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private RString edit選挙人隅の項目処理(AtenaSealPartParam param, RString number) {
        RString backValue = RString.EMPTY;
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            switch (number.toString()) {
                case "00":
                    break;
                case "01":
                    ShikibetsuCode shikibetsuCode = param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode();
                    backValue = null == shikibetsuCode ? RString.EMPTY : shikibetsuCode.getColumnValue();
                    break;
                case "02":
                    SetaiCode setaiCode = param.get投票資格情報().getAtenaPSMEntity().getSetaiCode();
                    backValue = null == setaiCode ? RString.EMPTY : setaiCode.getColumnValue();
                    break;
                case "03":
                    ChoikiCode jutonaiChoikiCode = param.get投票資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
                    backValue = null == jutonaiChoikiCode ? RString.EMPTY : jutonaiChoikiCode.getColumnValue();
                    break;
                case "04":
                    GyoseikuCode gyoseikuCode = param.get投票資格情報().getAtenaPSMEntity().getGyoseikuCode();
                    backValue = null == gyoseikuCode ? RString.EMPTY : gyoseikuCode.getColumnValue();
                    break;
                case "05":
                    ChikuCode chikuCode1 = param.get投票資格情報().getAtenaPSMEntity().getChikuCode1();
                    backValue = null == chikuCode1 ? RString.EMPTY : chikuCode1.getColumnValue();
                    break;
                case "06":
                    ChikuCode chikuCode2 = param.get投票資格情報().getAtenaPSMEntity().getChikuCode2();
                    backValue = null == chikuCode2 ? RString.EMPTY : chikuCode2.getColumnValue();
                    break;
                case "07":
                    ChikuCode chikuCode3 = param.get投票資格情報().getAtenaPSMEntity().getChikuCode3();
                    backValue = null == chikuCode3 ? RString.EMPTY : chikuCode3.getColumnValue();
                    break;
                case "08":
                    backValue = changeNullToEmpty(param.get通し番号());
                    break;
                case "09":
                    backValue = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho());
                    break;
                case "12":
                    backValue = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName2());
                    break;
                case "10":
                    backValue = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName());
                    break;
                case "11":
                    backValue = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName1());
                    break;
                case "13":
                    backValue = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName3());
                    break;
                case "15":
                    TohyokuCode tohyokuCode15 = param.get投票資格情報().getAtenaPSMEntity().getTohyokuCode();
                    backValue = null == tohyokuCode15 ? RString.EMPTY : tohyokuCode15.getColumnValue();
                    break;
                case "14":
                    backValue = RDate.getNowDate().wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE)
                            .fillType(FillType.BLANK).toDateString();
                    break;
                case "16":
                    TohyokuCode tohyokuCode16 = param.get投票資格情報().getAtenaPSMEntity().getTohyokuCode();
                    if (null != param.get投票資格情報().getSenkyoninMeiboEntity()) {
                        backValue = null == tohyokuCode16 ? RString.EMPTY : tohyokuCode16.getColumnValue()
                                .concat(連結標識_21面).concat(changeNullToEmpty(new RString(param.get投票資格情報()
                                                        .getSenkyoninMeiboEntity().getPage())))
                                .concat(連結標識_21面).concat(changeNullToEmpty(new RString(param.get投票資格情報()
                                                        .getSenkyoninMeiboEntity().getGyo())));
                    }
                    break;
                default:
            }
        }
        return backValue;
    }

    private RString edit転出者隅の項目処理(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        switch (コード.toString()) {
            case "00":
                break;
            case "01":
                if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                    ShikibetsuCode shikibetsuCode = param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode();
                    returnValue = null == shikibetsuCode ? RString.EMPTY : shikibetsuCode.getColumnValue();
                }
                break;
            case "14":
                returnValue = RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case "08":
                returnValue = changeNullToEmpty(param.get通し番号());
                break;
            case "16":
                if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()
                        && null != param.get投票資格情報().getSenkyoninMeiboEntity()) {
                    TohyokuCode tohyokuCode = param.get投票資格情報().getAtenaPSMEntity().getTohyokuCode();
                    returnValue = null == tohyokuCode ? RString.EMPTY : tohyokuCode.getColumnValue()
                            .concat(連結標識_21面).concat(changeNullToEmpty(new RString(param.get投票資格情報().getSenkyoninMeiboEntity().getPage())))
                            .concat(連結標識_21面).concat(changeNullToEmpty(new RString(param.get投票資格情報().getSenkyoninMeiboEntity().getGyo())));
                }
                break;
            default:
        }
        return returnValue;
    }

    private RString edit施設隅の項目処理(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        if (null != param.get施設情報()) {
            switch (コード.toString()) {
                case "00":
                    break;
                case "01":
                    returnValue = changeNullToEmpty(param.get施設情報().getShisetsuCode());
                    break;
                case "02":
                    TelNo telNo = param.get施設情報().getTelNo();
                    returnValue = (new RString("TEL")).concat(半角スペース).concat(null == telNo ? RString.EMPTY : telNo.getColumnValue());
                    break;
                case "03":
                    TelNo faxNo = param.get施設情報().getFaxNo();
                    returnValue = (new RString("FAX")).concat(半角スペース).concat(null == faxNo ? RString.EMPTY : faxNo.getColumnValue());
                    break;
                case "04":
                    returnValue = RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                    break;
                default:
            }
        }
        return returnValue;

    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(AtenaSeal21Source.class, itemName);
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private void edit選挙人の住所処理1(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value1.length() > (長さ_21面_住所_上段 + 長さ_21面_住所_中段) || value2.length() > (長さ_21面_住所_中段 + 長さ_21面_住所_下段)) {
            edit小_住所の編集1(value1, value2, groupSource, source);
        } else {
            if (value1.length() > 長さ_21面_住所_上段) {
                if (value2.length() > 長さ_21面_住所_中段) {
                    edit小_住所の編集1(value1, value2, groupSource, source);
                } else {
                    groupSource.setJushoa(value1.substring(0, 長さ_21面_住所_上段));
                    groupSource.setJushob(value1.substring(長さ_21面_住所_上段));
                    groupSource.setJushoc(value2);
                }
            } else {
                groupSource.setJushoa(value1);
                if (value2.length() > 長さ_21面_住所_中段) {
                    groupSource.setJushob(value2.substring(0, 長さ_21面_住所_中段));
                    groupSource.setJushoc(value2.substring(長さ_21面_住所_中段));
                } else {
                    groupSource.setJushob(value2);
                    groupSource.setJushoc(RString.EMPTY);
                }
            }
        }
    }

    private void edit住所の編集が5行以上(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        RString totalValue = value1.concat(全角スペース).concat(value2);
        if (totalValue.length() > (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)) {
            source.jushoList = totalValue;
            groupSource.setJushoList(totalValue);
            groupSource.setJushold(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)));
            groupSource.setJushola(totalValue.substring(0, 長さ_21面_小住所1));
            groupSource.setJusholc(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
            groupSource.setJusholb(totalValue.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
        } else {
            groupSource.setJushola(totalValue.substring(0, 長さ_21面_小住所1));
            groupSource.setJushold(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
            groupSource.setJusholc(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
            groupSource.setJusholb(totalValue.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
        }
    }

    private void edit選挙人の住所処理2(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value1.length() > 長さ_21面_住所_上段 || value2.length() > 長さ_21面_住所_中段 || value3.length() > 長さ_21面_住所_下段) {
            edit小_住所の編集2(value1, value2, value3, groupSource, source);
        } else {
            groupSource.setJushoa(value1);
            groupSource.setJushob(value2);
            groupSource.setJushoc(value3);
        }
    }

    private void edit小_住所の編集2(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        if (value1.length() > (長さ_21面_小住所1 + 長さ_21面_小住所2)
                || value2.length() > (長さ_21面_小住所2 + 長さ_21面_小住所3)
                || value3.length() > (長さ_21面_小住所3 + 長さ_21面_小住所4)) {
            edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
        } else {
            if (value1.length() > 長さ_21面_小住所1) {
                if (value2.length() > 長さ_21面_小住所3 || value3.length() > 長さ_21面_小住所4) {
                    edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
                } else {
                    groupSource.setJushola(value1.substring(0, 長さ_21面_小住所1));
                    groupSource.setJusholb(value1.substring(長さ_21面_小住所1));
                    groupSource.setJusholc(value2);
                    groupSource.setJushold(value3);
                }
            } else {
                if (value2.length() > 長さ_21面_小住所2) {
                    if (value3.length() > 長さ_21面_小住所4) {
                        edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
                    } else {
                        groupSource.setJushola(value1);
                        groupSource.setJusholb(value2.substring(0, 長さ_21面_小住所2));
                        groupSource.setJusholc(value2.substring(長さ_21面_小住所2));
                        groupSource.setJushold(value3);
                    }
                } else {
                    groupSource.setJushola(value1);
                    groupSource.setJusholb(value2);
                    if (value3.length() > 長さ_21面_小住所3) {
                        groupSource.setJusholc(value3.substring(0, 長さ_21面_小住所3));
                        groupSource.setJushold(value3.substring(長さ_21面_小住所3));
                    } else {
                        groupSource.setJusholc(value3);
                        groupSource.setJushold(RString.EMPTY);
                    }
                }
            }
        }
    }

    private void edit小住所の編集が5行以上(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal21Source source) {
        RString totalValue = value1.concat(全角スペース).concat(value2).concat(全角スペース).concat(value3);
        if (totalValue.length() > 長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4) {
            groupSource.setJushola(totalValue.substring(0, 長さ_21面_小住所1));
            groupSource.setJusholb(totalValue.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
            groupSource.setJusholc(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
            groupSource.setJushold(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3 + 長さ_21面_小住所4)));
            source.jushoList = totalValue;
            groupSource.setJushoList(totalValue);
        } else {
            groupSource.setJushola(totalValue.substring(0, 長さ_21面_小住所1));
            groupSource.setJusholb(totalValue.substring(長さ_21面_小住所1, (長さ_21面_小住所1 + 長さ_21面_小住所2)));
            groupSource.setJusholc(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2),
                    (長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
            groupSource.setJushold(totalValue.substring((長さ_21面_小住所1 + 長さ_21面_小住所2 + 長さ_21面_小住所3)));
        }
    }

    private void editアクセスログ出力(AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            groupSource.setShikibetsuCode(param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode());
        } else {
            groupSource.setShikibetsuCode(ShikibetsuCode.EMPTY);
        }
    }
}
