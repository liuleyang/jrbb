package jp.co.ndensan.reams.af.afa.business.report.AFAPRE203;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena12Param;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtenaPartParam;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtenaResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203.LabelSealAtena12Source;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ラベルシール（宛名シール用紙12面）
 *
 * @reamsid_L AF-0620-030 wangh
 */
public class LabelSealAtena12Editor implements ILabelSealAtena12Editor {

    private static final RString 帳票タイトル = new RString("ラベルシール（宛名シール用紙12面）");
    private static final RString 全角スペース = new RString("　");
    private static final int インデックス_印字内容1 = 0;
    private static final int インデックス_印字内容2 = 1;
    private static final int インデックス_印字内容3 = 2;
    private static final int インデックス_印字内容4 = 3;
    private static final int インデックス_印字内容5 = 4;
    private static final RString 宣誓書のシール = new RString("宣誓書貼付用");
    private static final RString 封筒のシール = new RString("封筒貼付用");
    private static final RString 抄本のシール = new RString("抄本貼付用");
    private static final RString 入場券のシール = new RString("入場券貼付用");
    private static final RString 標識_抹消者 = new RString("非");
    private static final RString 標識_表示者 = new RString("表");
    private static final RString 標識_公民権停止者 = new RString("停");
    private static final RString 標識_連結 = new RString("-");
    private static final RString コロン = new RString("：");
    private static final RString 登録番号 = new RString("登録番号　：");
    private static final RString 氏名 = new RString("氏　　名　：");
    private static final int 抄本番号桁数 = 4;
    private static final RString 設定コンフィグ値_00 = new RString("00");
    private static final RString 設定コンフィグ値_01 = new RString("01");
    private static final RString 設定コンフィグ値_02 = new RString("02");
    private static final RString 設定コンフィグ値_03 = new RString("03");
    private static final RString 設定コンフィグ値_04 = new RString("04");
    private static final RString 設定コンフィグ値_05 = new RString("05");
    private static final RString 設定コンフィグ値_06 = new RString("06");
    private static final RString 設定コンフィグ値_07 = new RString("07");
    private static final RString 設定コンフィグ値_08 = new RString("08");
    private static final RString 設定コンフィグ値_09 = new RString("09");
    private static final RString 設定コンフィグ値_10 = new RString("10");
    private static final RString 設定コンフィグ値_11 = new RString("11");
    private static final RString 設定コンフィグ値_12 = new RString("12");
    private static final RString 設定コンフィグ値_13 = new RString("13");
    private static final RString 設定コンフィグ値_14 = new RString("14");
    private static final RString 設定コンフィグ値_15 = new RString("15");
    private static final RString 設定コンフィグ値_16 = new RString("16");
    private static final RString 設定コンフィグ値_17 = new RString("17");
    private static final RString 設定コンフィグ値_18 = new RString("18");
    private static final RString 設定コンフィグ値_19 = new RString("19");
    private static final RString 設定コンフィグ値_20 = new RString("20");
    private static final RString 設定コンフィグ値_21 = new RString("21");
    private static final RString 設定コンフィグ値_22 = new RString("22");
    private static final RString 設定コンフィグ値_23 = new RString("23");
    private static final RString 設定コンフィグ値_24 = new RString("24");
    private static final RString 設定コンフィグ値_25 = new RString("25");
    private static final RString 設定コンフィグ値_26 = new RString("26");
    private static final RString 設定コンフィグ値_27 = new RString("27");
    private static final int 八文字 = 8;
    private static final int 七文字 = 7;
    private static final int 選挙１ = 0;
    private static final int 選挙２ = 1;
    private static final int 選挙３ = 2;
    private static final int 選挙４ = 3;
    private static final int 選挙５ = 4;
    private static final int 選挙６ = 5;
    private static final int 選挙７ = 6;
    private static final int 選挙８ = 7;
    private static final int 選挙９ = 8;
    private static final int 選挙１０ = 9;
    private static final RString バーコード印字有 = new RString("1");

    private final LabelSealAtena12Param data;

    /**
     * コンストラクタです。
     *
     * @param data {@link LabelSealAtena12Param}
     */
    public LabelSealAtena12Editor(LabelSealAtena12Param data) {
        this.data = data;
    }

    /**
     * ラベルシール（宛名シール用紙12面）エディットメソッド
     *
     * @param source ラベルシール（宛名シール用紙12面）
     * @return ラベルシール（宛名シール用紙12面））
     */
    @Override
    public LabelSealAtena12Source edit(LabelSealAtena12Source source) {
        edit帳票タイトル(source);
        edit市町村コード(source);
        edit市町村名(source);
        edit作成日時(source);
        editTwo(source);
        editFour(source);
        editSeven(source);
        editThree(source);
        editFive(source);
        editEight(source);
        editTwelve(source);
        editFirst(source);
        editNine(source);
        editSix(source);
        editEleven(source);
        editTen(source);
        return source;
    }

    private void editTwo(LabelSealAtena12Source source) {
        if (null != data.getParam2()) {
            LabelSealAtenaResult result2 = editラベルシール(data.getParam2());
            source.shoNaiyo12 = result2.getShoNaiyo1();
            source.shoNaiyo22 = result2.getShoNaiyo2();
            source.shoNaiyo32 = result2.getShoNaiyo3();
            source.shoNaiyo42 = result2.getShoNaiyo4();
            source.shoNaiyo52 = result2.getShoNaiyo5();
            source.barcodeBarcode2 = result2.getBarcodeBarcode();
            source.code2 = result2.getCode();
            source.kanaMeisho2 = result2.getKanaMeisho();
            source.shikibetsuCode2 = result2.getShikibetsuCode();
            source.識別コード2 = new ShikibetsuCode(result2.getShikibetsuCode());
            source.個人番号使用2 = KojinNo.EMPTY;
            source.法人番号使用2 = HojinNo.EMPTY;
            source.title12 = result2.getTitle1();
            source.title22 = result2.getTitle2();
            source.title32 = result2.getTitle3();
            source.title42 = result2.getTitle4();
            source.title52 = result2.getTitle5();
            source.naiyo12 = result2.getNaiyo1();
            source.naiyo22 = result2.getNaiyo2();
            source.naiyo32 = result2.getNaiyo3();
            source.naiyo42 = result2.getNaiyo4();
            source.naiyo52 = result2.getNaiyo5();
        }
    }

    private void editFirst(LabelSealAtena12Source source) {
        if (null != data.getParam1()) {
            LabelSealAtenaResult result1 = editラベルシール(data.getParam1());
            source.title31 = result1.getTitle3();
            source.naiyo31 = result1.getNaiyo3();
            source.title41 = result1.getTitle4();
            source.title21 = result1.getTitle2();
            source.title11 = result1.getTitle1();
            source.title51 = result1.getTitle5();
            source.naiyo11 = result1.getNaiyo1();
            source.naiyo41 = result1.getNaiyo4();
            source.naiyo51 = result1.getNaiyo5();
            source.naiyo21 = result1.getNaiyo2();
            source.code1 = result1.getCode();
            source.barcodeBarcode1 = result1.getBarcodeBarcode();
            source.kanaMeisho1 = result1.getKanaMeisho();
            source.shikibetsuCode1 = result1.getShikibetsuCode();
            source.識別コード1 = new ShikibetsuCode(result1.getShikibetsuCode());
            source.個人番号使用1 = KojinNo.EMPTY;
            source.法人番号使用1 = HojinNo.EMPTY;
            source.shoNaiyo11 = result1.getShoNaiyo1();
            source.shoNaiyo21 = result1.getShoNaiyo2();
            source.shoNaiyo31 = result1.getShoNaiyo3();
            source.shoNaiyo41 = result1.getShoNaiyo4();
            source.shoNaiyo51 = result1.getShoNaiyo5();
        }
    }

    private void editFour(LabelSealAtena12Source source) {
        if (null != data.getParam4()) {
            LabelSealAtenaResult result4 = editラベルシール(data.getParam4());
            source.naiyo14 = result4.getNaiyo1();
            source.naiyo24 = result4.getNaiyo2();
            source.naiyo34 = result4.getNaiyo3();
            source.naiyo44 = result4.getNaiyo4();
            source.naiyo54 = result4.getNaiyo5();
            source.title14 = result4.getTitle1();
            source.title24 = result4.getTitle2();
            source.title34 = result4.getTitle3();
            source.title44 = result4.getTitle4();
            source.title54 = result4.getTitle5();
            source.shoNaiyo14 = result4.getShoNaiyo1();
            source.shoNaiyo24 = result4.getShoNaiyo2();
            source.shoNaiyo34 = result4.getShoNaiyo3();
            source.shoNaiyo44 = result4.getShoNaiyo4();
            source.shoNaiyo54 = result4.getShoNaiyo5();
            source.barcodeBarcode4 = result4.getBarcodeBarcode();
            source.code4 = result4.getCode();
            source.kanaMeisho4 = result4.getKanaMeisho();
            source.shikibetsuCode4 = result4.getShikibetsuCode();
            source.識別コード4 = new ShikibetsuCode(result4.getShikibetsuCode());
            source.個人番号使用4 = KojinNo.EMPTY;
            source.法人番号使用4 = HojinNo.EMPTY;
        }
    }

    private void editFive(LabelSealAtena12Source source) {
        if (null != data.getParam5()) {
            LabelSealAtenaResult result5 = editラベルシール(data.getParam5());
            source.title15 = result5.getTitle1();
            source.title25 = result5.getTitle2();
            source.title35 = result5.getTitle3();
            source.title45 = result5.getTitle4();
            source.title55 = result5.getTitle5();
            source.shoNaiyo15 = result5.getShoNaiyo1();
            source.shoNaiyo25 = result5.getShoNaiyo2();
            source.shoNaiyo35 = result5.getShoNaiyo3();
            source.shoNaiyo45 = result5.getShoNaiyo4();
            source.shoNaiyo55 = result5.getShoNaiyo5();
            source.naiyo15 = result5.getNaiyo1();
            source.naiyo25 = result5.getNaiyo2();
            source.naiyo35 = result5.getNaiyo3();
            source.naiyo45 = result5.getNaiyo4();
            source.naiyo55 = result5.getNaiyo5();
            source.barcodeBarcode5 = result5.getBarcodeBarcode();
            source.code5 = result5.getCode();
            source.kanaMeisho5 = result5.getKanaMeisho();
            source.shikibetsuCode5 = result5.getShikibetsuCode();
            source.識別コード5 = new ShikibetsuCode(result5.getShikibetsuCode());
            source.個人番号使用5 = KojinNo.EMPTY;
            source.法人番号使用5 = HojinNo.EMPTY;
        }
    }

    private void editTwelve(LabelSealAtena12Source source) {
        if (null != data.getParam12()) {
            LabelSealAtenaResult result12 = editラベルシール(data.getParam12());
            source.title112 = result12.getTitle1();
            source.title212 = result12.getTitle2();
            source.title312 = result12.getTitle3();
            source.title412 = result12.getTitle4();
            source.title512 = result12.getTitle5();
            source.naiyo112 = result12.getNaiyo1();
            source.naiyo212 = result12.getNaiyo2();
            source.naiyo312 = result12.getNaiyo3();
            source.barcodeBarcode12 = result12.getBarcodeBarcode();
            source.code12 = result12.getCode();
            source.kanaMeisho12 = result12.getKanaMeisho();
            source.shikibetsuCode12 = result12.getShikibetsuCode();
            source.識別コード12 = new ShikibetsuCode(result12.getShikibetsuCode());
            source.個人番号使用12 = KojinNo.EMPTY;
            source.法人番号使用12 = HojinNo.EMPTY;
            source.naiyo412 = result12.getNaiyo4();
            source.naiyo512 = result12.getNaiyo5();
            source.shoNaiyo112 = result12.getShoNaiyo1();
            source.shoNaiyo212 = result12.getShoNaiyo2();
            source.shoNaiyo312 = result12.getShoNaiyo3();
            source.shoNaiyo412 = result12.getShoNaiyo4();
            source.shoNaiyo512 = result12.getShoNaiyo5();
        }
    }

    private void editThree(LabelSealAtena12Source source) {
        if (null != data.getParam3()) {
            LabelSealAtenaResult result3 = editラベルシール(data.getParam3());
            source.title13 = result3.getTitle1();
            source.title23 = result3.getTitle2();
            source.title33 = result3.getTitle3();
            source.naiyo53 = result3.getNaiyo5();
            source.shoNaiyo13 = result3.getShoNaiyo1();
            source.shoNaiyo23 = result3.getShoNaiyo2();
            source.title43 = result3.getTitle4();
            source.title53 = result3.getTitle5();
            source.naiyo13 = result3.getNaiyo1();
            source.naiyo23 = result3.getNaiyo2();
            source.naiyo33 = result3.getNaiyo3();
            source.naiyo43 = result3.getNaiyo4();
            source.shoNaiyo33 = result3.getShoNaiyo3();
            source.shoNaiyo43 = result3.getShoNaiyo4();
            source.shoNaiyo53 = result3.getShoNaiyo5();
            source.barcodeBarcode3 = result3.getBarcodeBarcode();
            source.code3 = result3.getCode();
            source.識別コード3 = new ShikibetsuCode(result3.getShikibetsuCode());
            source.個人番号使用3 = KojinNo.EMPTY;
            source.法人番号使用3 = HojinNo.EMPTY;
            source.kanaMeisho3 = result3.getKanaMeisho();
            source.shikibetsuCode3 = result3.getShikibetsuCode();
        }
    }

    private void editSeven(LabelSealAtena12Source source) {
        if (null != data.getParam7()) {
            LabelSealAtenaResult result7 = editラベルシール(data.getParam7());
            source.title17 = result7.getTitle1();
            source.title47 = result7.getTitle4();
            source.title57 = result7.getTitle5();
            source.naiyo17 = result7.getNaiyo1();
            source.naiyo27 = result7.getNaiyo2();
            source.naiyo37 = result7.getNaiyo3();
            source.naiyo47 = result7.getNaiyo4();
            source.naiyo57 = result7.getNaiyo5();
            source.title27 = result7.getTitle2();
            source.title37 = result7.getTitle3();
            source.shoNaiyo37 = result7.getShoNaiyo3();
            source.shoNaiyo47 = result7.getShoNaiyo4();
            source.shoNaiyo57 = result7.getShoNaiyo5();
            source.barcodeBarcode7 = result7.getBarcodeBarcode();
            source.code7 = result7.getCode();
            source.shoNaiyo17 = result7.getShoNaiyo1();
            source.識別コード7 = new ShikibetsuCode(result7.getShikibetsuCode());
            source.個人番号使用7 = KojinNo.EMPTY;
            source.法人番号使用7 = HojinNo.EMPTY;
            source.shoNaiyo27 = result7.getShoNaiyo2();
            source.kanaMeisho7 = result7.getKanaMeisho();
            source.shikibetsuCode7 = result7.getShikibetsuCode();
        }
    }

    private void editEight(LabelSealAtena12Source source) {
        if (null != data.getParam8()) {
            LabelSealAtenaResult result8 = editラベルシール(data.getParam8());
            source.title18 = result8.getTitle1();
            source.naiyo48 = result8.getNaiyo4();
            source.naiyo58 = result8.getNaiyo5();
            source.barcodeBarcode8 = result8.getBarcodeBarcode();
            source.code8 = result8.getCode();
            source.title28 = result8.getTitle2();
            source.title38 = result8.getTitle3();
            source.title48 = result8.getTitle4();
            source.title58 = result8.getTitle5();
            source.naiyo18 = result8.getNaiyo1();
            source.naiyo28 = result8.getNaiyo2();
            source.識別コード8 = new ShikibetsuCode(result8.getShikibetsuCode());
            source.個人番号使用8 = KojinNo.EMPTY;
            source.法人番号使用8 = HojinNo.EMPTY;
            source.shoNaiyo18 = result8.getShoNaiyo1();
            source.shoNaiyo28 = result8.getShoNaiyo2();
            source.shoNaiyo38 = result8.getShoNaiyo3();
            source.shoNaiyo48 = result8.getShoNaiyo4();
            source.shoNaiyo58 = result8.getShoNaiyo5();
            source.naiyo38 = result8.getNaiyo3();
            source.kanaMeisho8 = result8.getKanaMeisho();
            source.shikibetsuCode8 = result8.getShikibetsuCode();
        }
    }

    private void editSix(LabelSealAtena12Source source) {
        if (null != data.getParam6()) {
            LabelSealAtenaResult result6 = editラベルシール(data.getParam6());
            source.title16 = result6.getTitle1();
            source.title26 = result6.getTitle2();
            source.title56 = result6.getTitle5();
            source.naiyo16 = result6.getNaiyo1();
            source.naiyo26 = result6.getNaiyo2();
            source.kanaMeisho6 = result6.getKanaMeisho();
            source.shikibetsuCode6 = result6.getShikibetsuCode();
            source.naiyo36 = result6.getNaiyo3();
            source.naiyo46 = result6.getNaiyo4();
            source.識別コード6 = new ShikibetsuCode(result6.getShikibetsuCode());
            source.個人番号使用6 = KojinNo.EMPTY;
            source.法人番号使用6 = HojinNo.EMPTY;
            source.title36 = result6.getTitle3();
            source.title46 = result6.getTitle4();
            source.naiyo56 = result6.getNaiyo5();
            source.shoNaiyo16 = result6.getShoNaiyo1();
            source.shoNaiyo56 = result6.getShoNaiyo5();
            source.barcodeBarcode6 = result6.getBarcodeBarcode();
            source.shoNaiyo26 = result6.getShoNaiyo2();
            source.shoNaiyo36 = result6.getShoNaiyo3();
            source.shoNaiyo46 = result6.getShoNaiyo4();
            source.code6 = result6.getCode();
        }
    }

    private void editTen(LabelSealAtena12Source source) {
        if (null != data.getParam10()) {
            LabelSealAtenaResult result10 = editラベルシール(data.getParam10());
            source.title110 = result10.getTitle1();
            source.title210 = result10.getTitle2();
            source.title410 = result10.getTitle4();
            source.naiyo510 = result10.getNaiyo5();
            source.naiyo110 = result10.getNaiyo1();
            source.title310 = result10.getTitle3();
            source.naiyo210 = result10.getNaiyo2();
            source.naiyo410 = result10.getNaiyo4();
            source.title510 = result10.getTitle5();
            source.shoNaiyo110 = result10.getShoNaiyo1();
            source.naiyo310 = result10.getNaiyo3();
            source.code10 = result10.getCode();
            source.kanaMeisho10 = result10.getKanaMeisho();
            source.shoNaiyo510 = result10.getShoNaiyo5();
            source.識別コード10 = new ShikibetsuCode(result10.getShikibetsuCode());
            source.個人番号使用10 = KojinNo.EMPTY;
            source.法人番号使用10 = HojinNo.EMPTY;
            source.shikibetsuCode10 = result10.getShikibetsuCode();
            source.shoNaiyo210 = result10.getShoNaiyo2();
            source.shoNaiyo310 = result10.getShoNaiyo3();
            source.shoNaiyo410 = result10.getShoNaiyo4();
            source.barcodeBarcode10 = result10.getBarcodeBarcode();
        }
    }

    private void editEleven(LabelSealAtena12Source source) {
        if (null != data.getParam11()) {
            LabelSealAtenaResult result11 = editラベルシール(data.getParam11());
            source.識別コード11 = new ShikibetsuCode(result11.getShikibetsuCode());
            source.個人番号使用11 = KojinNo.EMPTY;
            source.法人番号使用11 = HojinNo.EMPTY;
            source.title111 = result11.getTitle1();
            source.title211 = result11.getTitle2();
            source.title411 = result11.getTitle4();
            source.title511 = result11.getTitle5();
            source.shoNaiyo311 = result11.getShoNaiyo3();
            source.shoNaiyo411 = result11.getShoNaiyo4();
            source.naiyo111 = result11.getNaiyo1();
            source.naiyo211 = result11.getNaiyo2();
            source.title311 = result11.getTitle3();
            source.naiyo311 = result11.getNaiyo3();
            source.naiyo511 = result11.getNaiyo5();
            source.shoNaiyo111 = result11.getShoNaiyo1();
            source.shoNaiyo211 = result11.getShoNaiyo2();
            source.shoNaiyo511 = result11.getShoNaiyo5();
            source.naiyo411 = result11.getNaiyo4();
            source.code11 = result11.getCode();
            source.kanaMeisho11 = result11.getKanaMeisho();
            source.barcodeBarcode11 = result11.getBarcodeBarcode();
            source.shikibetsuCode11 = result11.getShikibetsuCode();
        }
    }

    private void editNine(LabelSealAtena12Source source) {
        if (null != data.getParam9()) {
            LabelSealAtenaResult result9 = editラベルシール(data.getParam9());
            source.title59 = result9.getTitle5();
            source.naiyo19 = result9.getNaiyo1();
            source.title19 = result9.getTitle1();
            source.title39 = result9.getTitle3();
            source.title49 = result9.getTitle4();
            source.naiyo29 = result9.getNaiyo2();
            source.naiyo39 = result9.getNaiyo3();
            source.title29 = result9.getTitle2();
            source.shoNaiyo39 = result9.getShoNaiyo3();
            source.naiyo49 = result9.getNaiyo4();
            source.naiyo59 = result9.getNaiyo5();
            source.barcodeBarcode9 = result9.getBarcodeBarcode();
            source.shoNaiyo59 = result9.getShoNaiyo5();
            source.shoNaiyo19 = result9.getShoNaiyo1();
            source.kanaMeisho9 = result9.getKanaMeisho();
            source.code9 = result9.getCode();
            source.shoNaiyo29 = result9.getShoNaiyo2();
            source.shikibetsuCode9 = result9.getShikibetsuCode();
            source.識別コード9 = new ShikibetsuCode(result9.getShikibetsuCode());
            source.個人番号使用9 = KojinNo.EMPTY;
            source.法人番号使用9 = HojinNo.EMPTY;
            source.shoNaiyo49 = result9.getShoNaiyo4();
        }
    }

    private LabelSealAtenaResult editラベルシール(LabelSealAtenaPartParam param) {

        AfT111SenkyoEntity senkyoEntity = null;
        AfT201TohyoJokyoEntity tohyoJokyoEntity = null;
        RString 施設種別コード名称 = RString.EMPTY;
        RString 施設名称 = RString.EMPTY;

        LabelSealAtenaResult result = new LabelSealAtenaResult();
        if (null != param && null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
            List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList = param.get選挙人資格情報().getTohyoJokyoEntityList();
            for (int i = 0; i < tohyoJokyoEntityList.size(); i++) {
                if (tohyoJokyoEntityList.get(i).getSenkyoNo().getColumnValue() == param.get選挙Index()) {
                    tohyoJokyoEntity = tohyoJokyoEntityList.get(i);
                    施設種別コード名称 = param.get施設種別コード名称リスト().get(i);
                    施設名称 = param.get施設名称リスト().get(i);
                    break;
                }
            }
            RString シール種別 = changeNullToEmpty(param.getシール種別());
            for (AfT111SenkyoEntity senkyo : param.get選挙人資格情報().getSenkyoJohoEntity().getSenkyoEntity()) {
                if (senkyo.getSenkyoNo().getColumnValue() == param.get選挙Index()) {
                    senkyoEntity = senkyo;
                    break;
                }
            }
            if (宣誓書のシール.equals(シール種別) || 封筒のシール.equals(シール種別) || 入場券のシール.equals(シール種別)) {
                editタイトルと内容(result, param, シール種別, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
            } else if (抄本のシール.equals(シール種別)) {
                edit抄本貼付用内容(result, param);
            }
            editコード(result, param, シール種別, senkyoEntity);
            AtenaKanaMeisho kanaMeisho = param.get選挙人資格情報().getAtenaPSMEntity().getKanaMeisho();
            result.setKanaMeisho(null == kanaMeisho
                    ? RString.EMPTY : kanaMeisho.getColumnValue());
            ShikibetsuCode shikibetsuCode = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            result.setShikibetsuCode(null == shikibetsuCode
                    ? RString.EMPTY : shikibetsuCode.getColumnValue());
        }
        return result;
    }

    private void edit抄本貼付用内容(LabelSealAtenaResult result, LabelSealAtenaPartParam param) {
        if (null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
            AtenaMeisho meisho = param.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
            if (null != meisho) {
                result.setShoNaiyo1(meisho.getColumnValue());
            }
            int 選挙マーク数 = param.get選挙マークリスト().size();
            switch (選挙マーク数) {
                case 選挙２:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１));
                    break;
                case 選挙１:
                    break;
                case 選挙３:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２));
                    break;
                case 選挙５:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４));
                    break;
                case 選挙４:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    break;
                case 選挙６:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４, 選挙５));
                    break;
                case 選挙７:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４, 選挙５, 選挙６));
                    break;
                case 選挙８:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４, 選挙５, 選挙６));
                    result.setShoNaiyo4(edit小_内容(param.get選挙マークリスト(), 選挙７));
                    break;
                case 選挙９:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４, 選挙５, 選挙６));
                    result.setShoNaiyo4(edit小_内容(param.get選挙マークリスト(), 選挙７, 選挙８));
                    break;
                case 選挙１０:
                    result.setShoNaiyo2(edit小_内容(param.get選挙マークリスト(), 選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(param.get選挙マークリスト(), 選挙４, 選挙５, 選挙６));
                    result.setShoNaiyo4(edit小_内容(param.get選挙マークリスト(), 選挙７, 選挙８, 選挙９));
                    break;
                default:
            }
            result.setShoNaiyo5(RString.EMPTY);
            result.setBarcodeBarcode(RString.EMPTY);
            result.setCode(RString.EMPTY);
        }
    }

    private RString edit小_内容(List<RString> 選挙マークリスト, int index, int... indexs) {
        RString 小_内容 = 選挙マークリスト.get(index);
        for (int i : indexs) {
            小_内容 = 小_内容.concat(RString.HALF_SPACE).concat(選挙マークリスト.get(i));
        }
        return 小_内容;
    }

    private void editコード(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString シール種別, AfT111SenkyoEntity senkyoEntity) {
        RString 印字有無 = RString.EMPTY;
        if (宣誓書のシール.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (封筒のシール.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (入場券のシール.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        }
        if (バーコード印字有.equals(印字有無)) {
            editバーコード編集(result, param, シール種別, senkyoEntity);
        } else {
            result.setBarcodeBarcode(RString.EMPTY);
        }
        result.setCode(result.getBarcodeBarcode());
    }

    private void editタイトルと内容(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString シール種別, AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity, RString 施設種別コード名称, RString 施設名称) {
        RString 印字内容 = RString.EMPTY;
        if (宣誓書のシール.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (封筒のシール.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (入場券のシール.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_印字内容, SubGyomuCode.AFA選挙本体);
        }
        List<RString> 印字内容List = 印字内容.split(",");
        RString コンフィグ値1 = 印字内容List.get(インデックス_印字内容1);
        RString コンフィグ値2 = 印字内容List.get(インデックス_印字内容3);
        RString コンフィグ値3 = 印字内容List.get(インデックス_印字内容2);
        RString コンフィグ値4 = 印字内容List.get(インデックス_印字内容5);
        RString コンフィグ値5 = 印字内容List.get(インデックス_印字内容4);
        result.setNaiyo1(getタイトルByコンフィグ値(param, コンフィグ値1, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容2));
        result.setNaiyo2(getタイトルByコンフィグ値(param, コンフィグ値2, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容2));
        result.setNaiyo3(getタイトルByコンフィグ値(param, コンフィグ値3, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容2));
        result.setNaiyo4(getタイトルByコンフィグ値(param, コンフィグ値4, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容2));
        result.setNaiyo5(getタイトルByコンフィグ値(param, コンフィグ値5, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容2));
        result.setTitle1(getタイトルByコンフィグ値(param, コンフィグ値1, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容1));
        result.setTitle2(getタイトルByコンフィグ値(param, コンフィグ値2, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容1));
        result.setTitle3(getタイトルByコンフィグ値(param, コンフィグ値3, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容1));
        result.setTitle4(getタイトルByコンフィグ値(param, コンフィグ値4, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容1));
        result.setTitle5(getタイトルByコンフィグ値(param, コンフィグ値5, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称).get(インデックス_印字内容1));
        result.setShoNaiyo1(RString.EMPTY);
        result.setShoNaiyo2(RString.EMPTY);
        result.setShoNaiyo3(RString.EMPTY);
        result.setShoNaiyo4(RString.EMPTY);
        result.setShoNaiyo5(RString.EMPTY);
    }

    private void editバーコード編集(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString sealtype, AfT111SenkyoEntity senkyoEntity) {
        if (null != param && null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()
                && null != param.get選挙人資格情報().getSenkyoJohoEntity()
                && null != param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity()) {
            ShikibetsuCode shikibetsuCode = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            RString 識別コード = null == shikibetsuCode ? RString.EMPTY : shikibetsuCode.getColumnValue();
            ShohonNo shohonNo = param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getShohonNo();
            RString 抄本番号 = null == shohonNo ? RString.EMPTY : new RString(shohonNo.getColumnValue());
            if (封筒のシール.equals(sealtype)) {
                result.setBarcodeBarcode(識別コード.concat(抄本番号.padZeroToLeft(抄本番号桁数))
                        .concat(senkyoEntity == null ? RString.EMPTY : new RString(senkyoEntity.getSenkyoNo().getColumnValue())));

            } else {
                result.setBarcodeBarcode(識別コード.concat(抄本番号.padZeroToLeft(抄本番号桁数))
                        .concat(new RString(0)));
            }
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private List<RString> getタイトルByコンフィグ値(LabelSealAtenaPartParam param, RString コンフィグ値, AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity, RString 施設種別コード名称, RString 施設名称) {
        List<RString> 結果リスト = new ArrayList<>();
        Code tohyoJiyuCode = null == tohyoJokyoEntity ? Code.EMPTY : tohyoJokyoEntity.getTohyoJiyuCode();
        AtenaMeisho meisho = param.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
        RString 頁 = changeNullToEmpty(new RString(param.get選挙人資格情報().getSenkyoninMeiboEntity().getPage()));
        RString 名称 = null == meisho ? RString.EMPTY : meisho.getColumnValue();
        RString tohyokuCode = changeNullToEmpty(param.get選挙人資格情報().getSenkyoShikakuEntity().getTohyokuCode());
        RString 投票事由コード = null == tohyoJiyuCode ? RString.EMPTY : tohyoJiyuCode.getKey();
        RString 行 = changeNullToEmpty(new RString(param.get選挙人資格情報().getSenkyoninMeiboEntity().getGyo()));
        RString 性別 = null == param.get選挙人資格情報().getAtenaPSMEntity().getSeibetsuCode()
                ? RString.EMPTY : new SeibetsuCode(param.get選挙人資格情報().getAtenaPSMEntity().getSeibetsuCode()).getColumnValue();
        if (設定コンフィグ値_00.equals(コンフィグ値)) {
            結果リスト.add(RString.EMPTY);
            結果リスト.add(RString.EMPTY);
        } else if (設定コンフィグ値_01.equals(コンフィグ値)) {
            結果リスト.add(new RString("投票区名　："));
            結果リスト.add(tohyokuCode);
        } else if (設定コンフィグ値_02.equals(コンフィグ値)) {
            結果リスト.add(登録番号);
            結果リスト.add(get標識(param).concat(頁).concat(標識_連結).concat(行));
        } else if (設定コンフィグ値_03.equals(コンフィグ値)) {
            結果リスト.add(登録番号);
            結果リスト.add(tohyokuCode.concat(標識_連結).concat(get標識(param))
                    .concat(頁).concat(標識_連結).concat(行));
        } else if (設定コンフィグ値_04.equals(コンフィグ値)) {
            結果リスト.add(new RString("名簿番号　："));
            結果リスト.add(tohyokuCode.concat(標識_連結).concat(頁).concat(標識_連結).concat(行));
        } else if (設定コンフィグ値_05.equals(コンフィグ値)) {
            結果リスト.add(new RString("行政区　　："));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuName()));
        } else if (設定コンフィグ値_06.equals(コンフィグ値)) {
            結果リスト.add(new RString("住所コード："));
            ChoikiCode jutonaiChoikiCode = param.get選挙人資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
            結果リスト.add(null == jutonaiChoikiCode ? RString.EMPTY : jutonaiChoikiCode.getColumnValue());
        } else if (設定コンフィグ値_07.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName1()));
        } else if (設定コンフィグ値_08.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName2()));
        } else if (設定コンフィグ値_09.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName3()));
        } else if (設定コンフィグ値_10.equals(コンフィグ値)) {
            結果リスト.add(new RString("識別コード："));
            if (null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
                ShikibetsuCode shikibetsuCode = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
                結果リスト.add(null == shikibetsuCode ? RString.EMPTY : shikibetsuCode.getColumnValue());
            }
        } else if (設定コンフィグ値_11.equals(コンフィグ値)) {
            結果リスト.add(new RString("世帯コード："));
            if (null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
                SetaiCode setaiCode = param.get選挙人資格情報().getAtenaPSMEntity().getSetaiCode();
                結果リスト.add(null == setaiCode ? RString.EMPTY : setaiCode.getColumnValue());
            }
        } else if (設定コンフィグ値_12.equals(コンフィグ値)) {
            結果リスト.add(new RString("性別　　　："));
            結果リスト.add(性別);
        } else if (設定コンフィグ値_13.equals(コンフィグ値)) {
            結果リスト.add(new RString("生年月日　："));
            FlexibleDate seinengappiYMD = param.get選挙人資格情報().getAtenaPSMEntity().getSeinengappiYMD();
            結果リスト.add(null == seinengappiYMD ? RString.EMPTY : seinengappiYMD.wareki().toDateString());
        } else if (設定コンフィグ値_14.equals(コンフィグ値)) {
            結果リスト.add(new RString("氏　　名　："));
            結果リスト.add(名称);
        } else if (設定コンフィグ値_15.equals(コンフィグ値)) {
            結果リスト.add(new RString("受付番号　："));
            if (null != tohyoJokyoEntity) {
                結果リスト.add(toRString(tohyoJokyoEntity.getUketsukeNo()));
            } else {
                結果リスト.add(RString.EMPTY);
            }

        } else if (設定コンフィグ値_17.equals(コンフィグ値)) {
            結果リスト.add(氏名);
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 七文字).substring(0, 七文字)
                    .concat(RString.HALF_SPACE)
                    .concat(性別)
                    .concat(RString.HALF_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (設定コンフィグ値_16.equals(コンフィグ値)) {
            結果リスト.add(氏名);
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 八文字).substring(0, 八文字)
                    .concat(RString.FULL_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (設定コンフィグ値_18.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙名称　："));
            結果リスト.add(null == senkyoEntity ? RString.EMPTY : senkyoEntity.getSenkyoName());
        } else if (設定コンフィグ値_20.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求年月日："));
            FlexibleDate seikyuYMD = null == tohyoJokyoEntity ? FlexibleDate.EMPTY : tohyoJokyoEntity.getSeikyuYMD();
            結果リスト.add(null == seikyuYMD ? RString.EMPTY : seikyuYMD.wareki().toDateString());
        } else if (設定コンフィグ値_19.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙略称　："));
            結果リスト.add(null == senkyoEntity ? RString.EMPTY : senkyoEntity.getSenkyoRyakusho());
        } else if (設定コンフィグ値_21.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求方法　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getSeikyuHohoMeisho());
        } else if (設定コンフィグ値_27.equals(コンフィグ値)) {
            結果リスト.add(new RString("市区町村名："));
            結果リスト.add(changeNullToEmpty(data.get帳票共通ヘッダー().get市町村名()));
        } else if (設定コンフィグ値_22.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求事由　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getTohyoJiyuCodeRyakusho());
        } else if (設定コンフィグ値_23.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付年月日："));
            FlexibleDate kofuYMD = null == tohyoJokyoEntity ? FlexibleDate.EMPTY : tohyoJokyoEntity.getKofuYMD();
            結果リスト.add(null == kofuYMD ? RString.EMPTY : kofuYMD.wareki().toDateString());
        } else if (設定コンフィグ値_24.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付区分　："));
            結果リスト.add(施設種別コード名称);
        } else if (設定コンフィグ値_25.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付方法　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getKofuHohoMeisho());
        } else if (設定コンフィグ値_26.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付施設　："));
            結果リスト.add(施設名称);
        }
        return 結果リスト;
    }

    private RString get標識(LabelSealAtenaPartParam param) {
        Code 選挙資格区分 = param.get選挙人資格情報().getSenkyoShikakuEntity().getShikakuKubun();
        if (new Code(SennkyoSikakuKubun.抹消者.value()).equals(選挙資格区分)
                || new Code(SennkyoSikakuKubun.資格なし.value()).equals(選挙資格区分)) {
            return 標識_抹消者;
        } else if (new Code(SennkyoSikakuKubun.表示者.value()).equals(選挙資格区分)) {
            return 標識_表示者;
        } else if (new Code(SennkyoSikakuKubun.公民権停止.value()).equals(選挙資格区分)) {
            return 標識_公民権停止者;
        } else {
            return RString.EMPTY;
        }
    }

    private void edit作成日時(LabelSealAtena12Source source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
    }

    private void edit市町村コード(LabelSealAtena12Source source) {
        if (null != data.get地方公共団体情報() && null != data.get地方公共団体情報().getLasdecCode_()) {
            source.shichosonCode = data.get地方公共団体情報().getLasdecCode_().value();
        }
    }

    private void edit市町村名(LabelSealAtena12Source source) {
        if (null != data.get地方公共団体情報()) {
            source.shichosonmMei = data.get地方公共団体情報().get市町村名();
        }
    }

    private void edit帳票タイトル(LabelSealAtena12Source source) {
        source.title = 帳票タイトル;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private RString toRString(Integer no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no);
    }
}
