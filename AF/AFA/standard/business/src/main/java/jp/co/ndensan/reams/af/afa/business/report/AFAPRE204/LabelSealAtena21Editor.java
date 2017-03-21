package jp.co.ndensan.reams.af.afa.business.report.AFAPRE204;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena21Param;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtenaPartParam;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtenaResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204.LabelSealAtena21Source;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
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
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21Editor implements ILabelSealAtena21Editor {

    private static final RString 帳票タイトル = new RString("ラベルシール（宛名シール用紙21面）");
    private static final int インデックス_印字内容1 = 0;
    private static final int インデックス_印字内容2 = 1;
    private static final int インデックス_印字内容3 = 2;
    private static final int インデックス_印字内容4 = 3;
    private static final int インデックス_印字内容5 = 4;
    private static final RString 全角スペース = new RString("　");
    private static final RString 抄本貼付用 = new RString("抄本貼付用");
    private static final RString シール_封筒貼付用 = new RString("封筒貼付用");
    private static final RString 宣誓書貼付用 = new RString("宣誓書貼付用");
    private static final RString シール_入場券貼付用 = new RString("入場券貼付用");
    private static final RString 抹消者 = new RString("非");
    private static final RString コロン = new RString("：");
    private static final RString 登録番号 = new RString("登録番号　：");
    private static final RString 表示者 = new RString("表");
    private static final RString 公民権停止者 = new RString("停");
    private static final RString 連結標識 = new RString("-");
    private static final RString 氏名 = new RString("氏　　名　：");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final int 抄本番号桁数 = 4;
    private static final int 八文字 = 8;
    private static final int 七文字 = 7;
    private static final int 選挙１ = 0;
    private static final int 選挙２ = 1;
    private static final int 選挙５ = 4;
    private static final int 選挙６ = 5;
    private static final int 選挙３ = 2;
    private static final int 選挙８ = 7;
    private static final int 選挙９ = 8;
    private static final int 選挙４ = 3;
    private static final int 選挙１０ = 9;
    private static final int 選挙７ = 6;
    private static final RString 配置值_00 = new RString("00");
    private static final RString 配置值_01 = new RString("01");
    private static final RString 配置值_04 = new RString("04");
    private static final RString 配置值_05 = new RString("05");
    private static final RString 配置值_02 = new RString("02");
    private static final RString 配置值_07 = new RString("07");
    private static final RString 配置值_06 = new RString("06");
    private static final RString 配置值_08 = new RString("08");
    private static final RString 配置值_03 = new RString("03");
    private static final RString 配置值_11 = new RString("11");
    private static final RString 配置值_09 = new RString("09");
    private static final RString 配置值_16 = new RString("16");
    private static final RString 配置值_10 = new RString("10");
    private static final RString 配置值_12 = new RString("12");
    private static final RString 配置值_15 = new RString("15");
    private static final RString 配置值_13 = new RString("13");
    private static final RString 配置值_17 = new RString("17");
    private static final RString 配置值_14 = new RString("14");
    private static final RString 配置值_18 = new RString("18");
    private static final RString 配置值_21 = new RString("21");
    private static final RString 配置值_19 = new RString("19");
    private static final RString 配置值_20 = new RString("20");
    private static final RString 配置值_22 = new RString("22");
    private static final RString 配置值_23 = new RString("23");
    private static final RString 配置值_24 = new RString("24");
    private static final RString 配置值_25 = new RString("25");
    private static final RString 配置值_27 = new RString("27");
    private static final RString バーコード印字有 = new RString("1");
    private static final RString 配置值_26 = new RString("26");

    private final LabelSealAtena21Param data;

    /**
     * コンストラクタです。
     *
     * @param data {@link LabelSealAtena21Param}
     */
    public LabelSealAtena21Editor(LabelSealAtena21Param data) {
        this.data = data;
    }

    /**
     * ラベルシール（宛名シール用紙21面）エディットメソッド
     *
     * @param source ラベルシール（宛名シール用紙21面）
     * @return ラベルシール（宛名シール用紙21面））
     */
    @Override
    public LabelSealAtena21Source edit(LabelSealAtena21Source source) {
        editUnus(source);
        editDuo(source);
        editTres(source);
        editQuattuor(source);
        editQuinque(source);
        editSex(source);
        editSeptem(source);
        editOcto(source);
        editNovem(source);
        editDecem(source);
        editUndecim(source);
        editDuodecim(source);
        editTresdecim(source);
        editQuattuordecim(source);
        editQuindecim(source);
        editSedecim(source);
        editSeptendecim(source);
        editDuodeviginti(source);
        editUndeviginti(source);
        editViginti(source);
        editViginti_unus(source);
        edit帳票タイトル(source);
        edit市町村コード(source);
        edit市町村名(source);
        edit作成日時(source);
        return source;
    }

    private void editUnus(LabelSealAtena21Source source) {
        if (null != data.getParam1()) {
            LabelSealAtenaResult result1 = editラベルシール(data.getParam1());
            source.title11 = result1.getTitle1();
            source.title21 = result1.getTitle2();
            source.title31 = result1.getTitle3();
            source.title41 = result1.getTitle4();
            source.title51 = result1.getTitle5();
            source.naiyo11 = result1.getNaiyo1();
            source.naiyo21 = result1.getNaiyo2();
            source.naiyo31 = result1.getNaiyo3();
            source.naiyo41 = result1.getNaiyo4();
            source.naiyo51 = result1.getNaiyo5();
            source.shoNaiyo11 = result1.getShoNaiyo1();
            source.shoNaiyo21 = result1.getShoNaiyo2();
            source.shoNaiyo31 = result1.getShoNaiyo3();
            source.shoNaiyo41 = result1.getShoNaiyo4();
            source.shoNaiyo51 = result1.getShoNaiyo5();
            source.barcodeBarcode1 = result1.getBarcodeBarcode();
            source.code1 = result1.getCode();
            source.kanaMeisho1 = result1.getKanaMeisho();
            source.識別コード1 = new ShikibetsuCode(result1.getShikibetsuCode());
            source.個人番号使用1 = KojinNo.EMPTY;
            source.法人番号使用1 = HojinNo.EMPTY;
            source.shikibetsuCode1 = result1.getShikibetsuCode();
        }
    }

    private void editDuo(LabelSealAtena21Source source) {
        if (null != data.getParam2()) {
            LabelSealAtenaResult result2 = editラベルシール(data.getParam2());
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
            source.shoNaiyo12 = result2.getShoNaiyo1();
            source.shoNaiyo22 = result2.getShoNaiyo2();
            source.shoNaiyo32 = result2.getShoNaiyo3();
            source.shoNaiyo42 = result2.getShoNaiyo4();
            source.shoNaiyo52 = result2.getShoNaiyo5();
            source.barcodeBarcode2 = result2.getBarcodeBarcode();
            source.code2 = result2.getCode();
            source.kanaMeisho2 = result2.getKanaMeisho();
            source.shikibetsuCode2 = result2.getShikibetsuCode();
        }
    }

    private void editTres(LabelSealAtena21Source source) {
        if (null != data.getParam3()) {
            LabelSealAtenaResult result3 = editラベルシール(data.getParam3());
            source.title13 = result3.getTitle1();
            source.識別コード3 = new ShikibetsuCode(result3.getShikibetsuCode());
            source.個人番号使用3 = KojinNo.EMPTY;
            source.法人番号使用3 = HojinNo.EMPTY;
            source.title23 = result3.getTitle2();
            source.title33 = result3.getTitle3();
            source.title43 = result3.getTitle4();
            source.title53 = result3.getTitle5();
            source.naiyo13 = result3.getNaiyo1();
            source.naiyo23 = result3.getNaiyo2();
            source.naiyo33 = result3.getNaiyo3();
            source.naiyo43 = result3.getNaiyo4();
            source.naiyo53 = result3.getNaiyo5();
            source.shoNaiyo13 = result3.getShoNaiyo1();
            source.shoNaiyo23 = result3.getShoNaiyo2();
            source.shoNaiyo33 = result3.getShoNaiyo3();
            source.shoNaiyo43 = result3.getShoNaiyo4();
            source.shoNaiyo53 = result3.getShoNaiyo5();
            source.barcodeBarcode3 = result3.getBarcodeBarcode();
            source.code3 = result3.getCode();
            source.kanaMeisho3 = result3.getKanaMeisho();
            source.shikibetsuCode3 = result3.getShikibetsuCode();
        }
    }

    private void editQuattuor(LabelSealAtena21Source source) {
        if (null != data.getParam4()) {
            LabelSealAtenaResult result4 = editラベルシール(data.getParam4());
            source.title14 = result4.getTitle1();
            source.title24 = result4.getTitle2();
            source.識別コード4 = new ShikibetsuCode(result4.getShikibetsuCode());
            source.個人番号使用4 = KojinNo.EMPTY;
            source.法人番号使用4 = HojinNo.EMPTY;
            source.title34 = result4.getTitle3();
            source.title44 = result4.getTitle4();
            source.title54 = result4.getTitle5();
            source.naiyo14 = result4.getNaiyo1();
            source.naiyo24 = result4.getNaiyo2();
            source.naiyo34 = result4.getNaiyo3();
            source.naiyo44 = result4.getNaiyo4();
            source.naiyo54 = result4.getNaiyo5();
            source.shoNaiyo14 = result4.getShoNaiyo1();
            source.shoNaiyo24 = result4.getShoNaiyo2();
            source.shoNaiyo34 = result4.getShoNaiyo3();
            source.shoNaiyo44 = result4.getShoNaiyo4();
            source.shoNaiyo54 = result4.getShoNaiyo5();
            source.barcodeBarcode4 = result4.getBarcodeBarcode();
            source.code4 = result4.getCode();
            source.kanaMeisho4 = result4.getKanaMeisho();
            source.shikibetsuCode4 = result4.getShikibetsuCode();
        }
    }

    private void editQuinque(LabelSealAtena21Source source) {
        if (null != data.getParam5()) {
            LabelSealAtenaResult result5 = editラベルシール(data.getParam5());
            source.title15 = result5.getTitle1();
            source.title25 = result5.getTitle2();
            source.title35 = result5.getTitle3();
            source.識別コード5 = new ShikibetsuCode(result5.getShikibetsuCode());
            source.個人番号使用5 = KojinNo.EMPTY;
            source.法人番号使用5 = HojinNo.EMPTY;
            source.title45 = result5.getTitle4();
            source.title55 = result5.getTitle5();
            source.naiyo15 = result5.getNaiyo1();
            source.naiyo25 = result5.getNaiyo2();
            source.naiyo35 = result5.getNaiyo3();
            source.naiyo45 = result5.getNaiyo4();
            source.naiyo55 = result5.getNaiyo5();
            source.shoNaiyo15 = result5.getShoNaiyo1();
            source.shoNaiyo25 = result5.getShoNaiyo2();
            source.shoNaiyo35 = result5.getShoNaiyo3();
            source.shoNaiyo45 = result5.getShoNaiyo4();
            source.shoNaiyo55 = result5.getShoNaiyo5();
            source.barcodeBarcode5 = result5.getBarcodeBarcode();
            source.code5 = result5.getCode();
            source.kanaMeisho5 = result5.getKanaMeisho();
            source.shikibetsuCode5 = result5.getShikibetsuCode();
        }
    }

    private void editSex(LabelSealAtena21Source source) {
        if (null != data.getParam6()) {
            LabelSealAtenaResult result6 = editラベルシール(data.getParam6());
            source.title16 = result6.getTitle1();
            source.title26 = result6.getTitle2();
            source.title36 = result6.getTitle3();
            source.title46 = result6.getTitle4();
            source.title56 = result6.getTitle5();
            source.識別コード6 = new ShikibetsuCode(result6.getShikibetsuCode());
            source.個人番号使用6 = KojinNo.EMPTY;
            source.法人番号使用6 = HojinNo.EMPTY;
            source.naiyo16 = result6.getNaiyo1();
            source.naiyo26 = result6.getNaiyo2();
            source.naiyo36 = result6.getNaiyo3();
            source.naiyo46 = result6.getNaiyo4();
            source.naiyo56 = result6.getNaiyo5();
            source.shoNaiyo16 = result6.getShoNaiyo1();
            source.shoNaiyo26 = result6.getShoNaiyo2();
            source.shoNaiyo36 = result6.getShoNaiyo3();
            source.shoNaiyo46 = result6.getShoNaiyo4();
            source.shoNaiyo56 = result6.getShoNaiyo5();
            source.barcodeBarcode6 = result6.getBarcodeBarcode();
            source.code6 = result6.getCode();
            source.kanaMeisho6 = result6.getKanaMeisho();
            source.shikibetsuCode6 = result6.getShikibetsuCode();
        }
    }

    private void editSeptem(LabelSealAtena21Source source) {
        if (null != data.getParam7()) {
            LabelSealAtenaResult result7 = editラベルシール(data.getParam7());
            source.title17 = result7.getTitle1();
            source.title27 = result7.getTitle2();
            source.title37 = result7.getTitle3();
            source.title47 = result7.getTitle4();
            source.title57 = result7.getTitle5();
            source.naiyo17 = result7.getNaiyo1();
            source.naiyo27 = result7.getNaiyo2();
            source.識別コード7 = new ShikibetsuCode(result7.getShikibetsuCode());
            source.個人番号使用7 = KojinNo.EMPTY;
            source.法人番号使用7 = HojinNo.EMPTY;
            source.naiyo37 = result7.getNaiyo3();
            source.naiyo47 = result7.getNaiyo4();
            source.naiyo57 = result7.getNaiyo5();
            source.shoNaiyo17 = result7.getShoNaiyo1();
            source.shoNaiyo27 = result7.getShoNaiyo2();
            source.shoNaiyo37 = result7.getShoNaiyo3();
            source.shoNaiyo47 = result7.getShoNaiyo4();
            source.shoNaiyo57 = result7.getShoNaiyo5();
            source.barcodeBarcode7 = result7.getBarcodeBarcode();
            source.code7 = result7.getCode();
            source.kanaMeisho7 = result7.getKanaMeisho();
            source.shikibetsuCode7 = result7.getShikibetsuCode();
        }
    }

    private void editOcto(LabelSealAtena21Source source) {
        if (null != data.getParam8()) {
            LabelSealAtenaResult result8 = editラベルシール(data.getParam8());
            source.title18 = result8.getTitle1();
            source.title28 = result8.getTitle2();
            source.title38 = result8.getTitle3();
            source.title48 = result8.getTitle4();
            source.title58 = result8.getTitle5();
            source.naiyo18 = result8.getNaiyo1();
            source.naiyo28 = result8.getNaiyo2();
            source.naiyo38 = result8.getNaiyo3();
            source.naiyo48 = result8.getNaiyo4();
            source.識別コード8 = new ShikibetsuCode(result8.getShikibetsuCode());
            source.個人番号使用8 = KojinNo.EMPTY;
            source.法人番号使用8 = HojinNo.EMPTY;
            source.naiyo58 = result8.getNaiyo5();
            source.shoNaiyo18 = result8.getShoNaiyo1();
            source.shoNaiyo28 = result8.getShoNaiyo2();
            source.shoNaiyo38 = result8.getShoNaiyo3();
            source.shoNaiyo48 = result8.getShoNaiyo4();
            source.shoNaiyo58 = result8.getShoNaiyo5();
            source.barcodeBarcode8 = result8.getBarcodeBarcode();
            source.code8 = result8.getCode();
            source.kanaMeisho8 = result8.getKanaMeisho();
            source.shikibetsuCode8 = result8.getShikibetsuCode();
        }
    }

    private void editNovem(LabelSealAtena21Source source) {
        if (null != data.getParam9()) {
            LabelSealAtenaResult result9 = editラベルシール(data.getParam9());
            source.title19 = result9.getTitle1();
            source.title29 = result9.getTitle2();
            source.title39 = result9.getTitle3();
            source.title49 = result9.getTitle4();
            source.title59 = result9.getTitle5();
            source.naiyo19 = result9.getNaiyo1();
            source.naiyo29 = result9.getNaiyo2();
            source.naiyo39 = result9.getNaiyo3();
            source.naiyo49 = result9.getNaiyo4();
            source.naiyo59 = result9.getNaiyo5();
            source.識別コード9 = new ShikibetsuCode(result9.getShikibetsuCode());
            source.個人番号使用9 = KojinNo.EMPTY;
            source.法人番号使用9 = HojinNo.EMPTY;
            source.shoNaiyo19 = result9.getShoNaiyo1();
            source.shoNaiyo29 = result9.getShoNaiyo2();
            source.shoNaiyo39 = result9.getShoNaiyo3();
            source.shoNaiyo49 = result9.getShoNaiyo4();
            source.shoNaiyo59 = result9.getShoNaiyo5();
            source.barcodeBarcode9 = result9.getBarcodeBarcode();
            source.code9 = result9.getCode();
            source.kanaMeisho9 = result9.getKanaMeisho();
            source.shikibetsuCode9 = result9.getShikibetsuCode();
        }
    }

    private void editDecem(LabelSealAtena21Source source) {
        if (null != data.getParam10()) {
            LabelSealAtenaResult result10 = editラベルシール(data.getParam10());
            source.title110 = result10.getTitle1();
            source.title210 = result10.getTitle2();
            source.title310 = result10.getTitle3();
            source.title410 = result10.getTitle4();
            source.title510 = result10.getTitle5();
            source.naiyo110 = result10.getNaiyo1();
            source.naiyo210 = result10.getNaiyo2();
            source.naiyo310 = result10.getNaiyo3();
            source.naiyo410 = result10.getNaiyo4();
            source.naiyo510 = result10.getNaiyo5();
            source.shoNaiyo110 = result10.getShoNaiyo1();
            source.識別コード10 = new ShikibetsuCode(result10.getShikibetsuCode());
            source.個人番号使用10 = KojinNo.EMPTY;
            source.法人番号使用10 = HojinNo.EMPTY;
            source.shoNaiyo210 = result10.getShoNaiyo2();
            source.shoNaiyo310 = result10.getShoNaiyo3();
            source.shoNaiyo410 = result10.getShoNaiyo4();
            source.shoNaiyo510 = result10.getShoNaiyo5();
            source.barcodeBarcode10 = result10.getBarcodeBarcode();
            source.code10 = result10.getCode();
            source.kanaMeisho10 = result10.getKanaMeisho();
            source.shikibetsuCode10 = result10.getShikibetsuCode();
        }
    }

    private void editUndecim(LabelSealAtena21Source source) {
        if (null != data.getParam11()) {
            LabelSealAtenaResult result11 = editラベルシール(data.getParam11());
            source.title111 = result11.getTitle1();
            source.title211 = result11.getTitle2();
            source.title311 = result11.getTitle3();
            source.title411 = result11.getTitle4();
            source.title511 = result11.getTitle5();
            source.naiyo111 = result11.getNaiyo1();
            source.naiyo211 = result11.getNaiyo2();
            source.naiyo311 = result11.getNaiyo3();
            source.naiyo411 = result11.getNaiyo4();
            source.naiyo511 = result11.getNaiyo5();
            source.shoNaiyo111 = result11.getShoNaiyo1();
            source.shoNaiyo211 = result11.getShoNaiyo2();
            source.識別コード11 = new ShikibetsuCode(result11.getShikibetsuCode());
            source.個人番号使用11 = KojinNo.EMPTY;
            source.法人番号使用11 = HojinNo.EMPTY;
            source.shoNaiyo311 = result11.getShoNaiyo3();
            source.shoNaiyo411 = result11.getShoNaiyo4();
            source.shoNaiyo511 = result11.getShoNaiyo5();
            source.barcodeBarcode11 = result11.getBarcodeBarcode();
            source.code11 = result11.getCode();
            source.kanaMeisho11 = result11.getKanaMeisho();
            source.shikibetsuCode11 = result11.getShikibetsuCode();
        }
    }

    private void editDuodecim(LabelSealAtena21Source source) {
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
            source.naiyo412 = result12.getNaiyo4();
            source.naiyo512 = result12.getNaiyo5();
            source.shoNaiyo112 = result12.getShoNaiyo1();
            source.shoNaiyo212 = result12.getShoNaiyo2();
            source.shoNaiyo312 = result12.getShoNaiyo3();
            source.識別コード12 = new ShikibetsuCode(result12.getShikibetsuCode());
            source.個人番号使用12 = KojinNo.EMPTY;
            source.法人番号使用12 = HojinNo.EMPTY;
            source.shoNaiyo412 = result12.getShoNaiyo4();
            source.shoNaiyo512 = result12.getShoNaiyo5();
            source.barcodeBarcode12 = result12.getBarcodeBarcode();
            source.code12 = result12.getCode();
            source.kanaMeisho12 = result12.getKanaMeisho();
            source.shikibetsuCode12 = result12.getShikibetsuCode();
        }
    }

    private void editTresdecim(LabelSealAtena21Source source) {
        if (null != data.getParam13()) {
            LabelSealAtenaResult result13 = editラベルシール(data.getParam13());
            source.title113 = result13.getTitle1();
            source.title213 = result13.getTitle2();
            source.title313 = result13.getTitle3();
            source.title413 = result13.getTitle4();
            source.title513 = result13.getTitle5();
            source.naiyo113 = result13.getNaiyo1();
            source.naiyo213 = result13.getNaiyo2();
            source.naiyo313 = result13.getNaiyo3();
            source.naiyo413 = result13.getNaiyo4();
            source.naiyo513 = result13.getNaiyo5();
            source.shoNaiyo113 = result13.getShoNaiyo1();
            source.shoNaiyo213 = result13.getShoNaiyo2();
            source.shoNaiyo313 = result13.getShoNaiyo3();
            source.shoNaiyo413 = result13.getShoNaiyo4();
            source.識別コード13 = new ShikibetsuCode(result13.getShikibetsuCode());
            source.個人番号使用13 = KojinNo.EMPTY;
            source.法人番号使用13 = HojinNo.EMPTY;
            source.shoNaiyo513 = result13.getShoNaiyo5();
            source.barcodeBarcode13 = result13.getBarcodeBarcode();
            source.code13 = result13.getCode();
            source.kanaMeisho13 = result13.getKanaMeisho();
            source.shikibetsuCode13 = result13.getShikibetsuCode();
        }
    }

    private void editQuattuordecim(LabelSealAtena21Source source) {
        if (null != data.getParam14()) {
            LabelSealAtenaResult result14 = editラベルシール(data.getParam14());
            source.title114 = result14.getTitle1();
            source.title214 = result14.getTitle2();
            source.title314 = result14.getTitle3();
            source.title414 = result14.getTitle4();
            source.title514 = result14.getTitle5();
            source.naiyo114 = result14.getNaiyo1();
            source.naiyo214 = result14.getNaiyo2();
            source.naiyo314 = result14.getNaiyo3();
            source.naiyo414 = result14.getNaiyo4();
            source.naiyo514 = result14.getNaiyo5();
            source.shoNaiyo114 = result14.getShoNaiyo1();
            source.shoNaiyo214 = result14.getShoNaiyo2();
            source.shoNaiyo314 = result14.getShoNaiyo3();
            source.shoNaiyo414 = result14.getShoNaiyo4();
            source.shoNaiyo514 = result14.getShoNaiyo5();
            source.barcodeBarcode14 = result14.getBarcodeBarcode();
            source.code14 = result14.getCode();
            source.識別コード14 = new ShikibetsuCode(result14.getShikibetsuCode());
            source.個人番号使用14 = KojinNo.EMPTY;
            source.法人番号使用14 = HojinNo.EMPTY;
            source.kanaMeisho14 = result14.getKanaMeisho();
            source.shikibetsuCode14 = result14.getShikibetsuCode();
        }
    }

    private void editQuindecim(LabelSealAtena21Source source) {
        if (null != data.getParam15()) {
            LabelSealAtenaResult result15 = editラベルシール(data.getParam15());
            source.title115 = result15.getTitle1();
            source.title215 = result15.getTitle2();
            source.title315 = result15.getTitle3();
            source.title415 = result15.getTitle4();
            source.title515 = result15.getTitle5();
            source.naiyo115 = result15.getNaiyo1();
            source.naiyo215 = result15.getNaiyo2();
            source.naiyo315 = result15.getNaiyo3();
            source.naiyo415 = result15.getNaiyo4();
            source.naiyo515 = result15.getNaiyo5();
            source.shoNaiyo115 = result15.getShoNaiyo1();
            source.shoNaiyo215 = result15.getShoNaiyo2();
            source.shoNaiyo315 = result15.getShoNaiyo3();
            source.識別コード15 = new ShikibetsuCode(result15.getShikibetsuCode());
            source.shoNaiyo415 = result15.getShoNaiyo4();
            source.shoNaiyo515 = result15.getShoNaiyo5();
            source.個人番号使用15 = KojinNo.EMPTY;
            source.法人番号使用15 = HojinNo.EMPTY;
            source.barcodeBarcode15 = result15.getBarcodeBarcode();
            source.code15 = result15.getCode();
            source.kanaMeisho15 = result15.getKanaMeisho();
            source.shikibetsuCode15 = result15.getShikibetsuCode();
        }
    }

    private void editSedecim(LabelSealAtena21Source source) {
        if (null != data.getParam16()) {
            LabelSealAtenaResult result16 = editラベルシール(data.getParam16());
            source.title116 = result16.getTitle1();
            source.title216 = result16.getTitle2();
            source.title316 = result16.getTitle3();
            source.title416 = result16.getTitle4();
            source.title516 = result16.getTitle5();
            source.naiyo116 = result16.getNaiyo1();
            source.naiyo216 = result16.getNaiyo2();
            source.naiyo316 = result16.getNaiyo3();
            source.naiyo416 = result16.getNaiyo4();
            source.naiyo516 = result16.getNaiyo5();
            source.shoNaiyo116 = result16.getShoNaiyo1();
            source.shoNaiyo216 = result16.getShoNaiyo2();
            source.shoNaiyo316 = result16.getShoNaiyo3();
            source.shoNaiyo416 = result16.getShoNaiyo4();
            source.個人番号使用16 = KojinNo.EMPTY;
            source.shoNaiyo516 = result16.getShoNaiyo5();
            source.barcodeBarcode16 = result16.getBarcodeBarcode();
            source.code16 = result16.getCode();
            source.kanaMeisho16 = result16.getKanaMeisho();
            source.識別コード16 = new ShikibetsuCode(result16.getShikibetsuCode());
            source.法人番号使用16 = HojinNo.EMPTY;
            source.shikibetsuCode16 = result16.getShikibetsuCode();
        }
    }

    private void editSeptendecim(LabelSealAtena21Source source) {
        if (null != data.getParam17()) {
            LabelSealAtenaResult result17 = editラベルシール(data.getParam17());
            source.title117 = result17.getTitle1();
            source.title217 = result17.getTitle2();
            source.title317 = result17.getTitle3();
            source.title417 = result17.getTitle4();
            source.title517 = result17.getTitle5();
            source.naiyo117 = result17.getNaiyo1();
            source.naiyo217 = result17.getNaiyo2();
            source.naiyo317 = result17.getNaiyo3();
            source.naiyo417 = result17.getNaiyo4();
            source.naiyo517 = result17.getNaiyo5();
            source.shoNaiyo117 = result17.getShoNaiyo1();
            source.shoNaiyo217 = result17.getShoNaiyo2();
            source.shoNaiyo317 = result17.getShoNaiyo3();
            source.個人番号使用17 = KojinNo.EMPTY;
            source.法人番号使用17 = HojinNo.EMPTY;
            source.shoNaiyo417 = result17.getShoNaiyo4();
            source.shoNaiyo517 = result17.getShoNaiyo5();
            source.barcodeBarcode17 = result17.getBarcodeBarcode();
            source.code17 = result17.getCode();
            source.識別コード17 = new ShikibetsuCode(result17.getShikibetsuCode());
            source.kanaMeisho17 = result17.getKanaMeisho();
            source.shikibetsuCode17 = result17.getShikibetsuCode();
        }
    }

    private void editDuodeviginti(LabelSealAtena21Source source) {
        if (null != data.getParam18()) {
            LabelSealAtenaResult result18 = editラベルシール(data.getParam18());
            source.title118 = result18.getTitle1();
            source.title218 = result18.getTitle2();
            source.title318 = result18.getTitle3();
            source.title418 = result18.getTitle4();
            source.title518 = result18.getTitle5();
            source.naiyo118 = result18.getNaiyo1();
            source.法人番号使用18 = HojinNo.EMPTY;
            source.naiyo218 = result18.getNaiyo2();
            source.naiyo318 = result18.getNaiyo3();
            source.naiyo418 = result18.getNaiyo4();
            source.naiyo518 = result18.getNaiyo5();
            source.識別コード18 = new ShikibetsuCode(result18.getShikibetsuCode());
            source.shoNaiyo118 = result18.getShoNaiyo1();
            source.shoNaiyo218 = result18.getShoNaiyo2();
            source.shoNaiyo318 = result18.getShoNaiyo3();
            source.shoNaiyo418 = result18.getShoNaiyo4();
            source.個人番号使用18 = KojinNo.EMPTY;
            source.shoNaiyo518 = result18.getShoNaiyo5();
            source.barcodeBarcode18 = result18.getBarcodeBarcode();
            source.code18 = result18.getCode();
            source.kanaMeisho18 = result18.getKanaMeisho();
            source.shikibetsuCode18 = result18.getShikibetsuCode();
        }
    }

    private void editUndeviginti(LabelSealAtena21Source source) {
        if (null != data.getParam19()) {
            LabelSealAtenaResult result19 = editラベルシール(data.getParam19());
            source.識別コード19 = new ShikibetsuCode(result19.getShikibetsuCode());
            source.title119 = result19.getTitle1();
            source.title219 = result19.getTitle2();
            source.title319 = result19.getTitle3();
            source.title419 = result19.getTitle4();
            source.title519 = result19.getTitle5();
            source.法人番号使用19 = HojinNo.EMPTY;
            source.naiyo119 = result19.getNaiyo1();
            source.naiyo219 = result19.getNaiyo2();
            source.個人番号使用19 = KojinNo.EMPTY;
            source.naiyo319 = result19.getNaiyo3();
            source.naiyo419 = result19.getNaiyo4();
            source.naiyo519 = result19.getNaiyo5();
            source.shoNaiyo119 = result19.getShoNaiyo1();
            source.shoNaiyo219 = result19.getShoNaiyo2();
            source.shoNaiyo319 = result19.getShoNaiyo3();
            source.shoNaiyo419 = result19.getShoNaiyo4();
            source.shoNaiyo519 = result19.getShoNaiyo5();
            source.barcodeBarcode19 = result19.getBarcodeBarcode();
            source.code19 = result19.getCode();
            source.kanaMeisho19 = result19.getKanaMeisho();
            source.shikibetsuCode19 = result19.getShikibetsuCode();
        }
    }

    private void editViginti(LabelSealAtena21Source source) {
        if (null != data.getParam20()) {
            LabelSealAtenaResult result20 = editラベルシール(data.getParam20());
            source.title120 = result20.getTitle1();
            source.title220 = result20.getTitle2();
            source.title320 = result20.getTitle3();
            source.title420 = result20.getTitle4();
            source.title520 = result20.getTitle5();
            source.naiyo120 = result20.getNaiyo1();
            source.naiyo220 = result20.getNaiyo2();
            source.naiyo320 = result20.getNaiyo3();
            source.naiyo420 = result20.getNaiyo4();
            source.naiyo520 = result20.getNaiyo5();
            source.shoNaiyo120 = result20.getShoNaiyo1();
            source.shoNaiyo220 = result20.getShoNaiyo2();
            source.shoNaiyo320 = result20.getShoNaiyo3();
            source.個人番号使用20 = KojinNo.EMPTY;
            source.shoNaiyo420 = result20.getShoNaiyo4();
            source.識別コード20 = new ShikibetsuCode(result20.getShikibetsuCode());
            source.shoNaiyo520 = result20.getShoNaiyo5();
            source.法人番号使用20 = HojinNo.EMPTY;
            source.barcodeBarcode20 = result20.getBarcodeBarcode();
            source.code20 = result20.getCode();
            source.kanaMeisho20 = result20.getKanaMeisho();
            source.shikibetsuCode20 = result20.getShikibetsuCode();
        }
    }

    private void editViginti_unus(LabelSealAtena21Source source) {
        if (null != data.getParam21()) {
            LabelSealAtenaResult result21 = editラベルシール(data.getParam21());
            source.title121 = result21.getTitle1();
            source.title221 = result21.getTitle2();
            source.title321 = result21.getTitle3();
            source.title421 = result21.getTitle4();
            source.title521 = result21.getTitle5();
            source.naiyo121 = result21.getNaiyo1();
            source.naiyo221 = result21.getNaiyo2();
            source.naiyo321 = result21.getNaiyo3();
            source.naiyo421 = result21.getNaiyo4();
            source.naiyo521 = result21.getNaiyo5();
            source.shoNaiyo121 = result21.getShoNaiyo1();
            source.shoNaiyo221 = result21.getShoNaiyo2();
            source.shoNaiyo321 = result21.getShoNaiyo3();
            source.shoNaiyo421 = result21.getShoNaiyo4();
            source.shoNaiyo521 = result21.getShoNaiyo5();
            source.barcodeBarcode21 = result21.getBarcodeBarcode();
            source.code21 = result21.getCode();
            source.kanaMeisho21 = result21.getKanaMeisho();
            source.shikibetsuCode21 = result21.getShikibetsuCode();
            source.識別コード21 = new ShikibetsuCode(result21.getShikibetsuCode());
            source.個人番号使用21 = KojinNo.EMPTY;
            source.法人番号使用21 = HojinNo.EMPTY;
        }
    }

    private LabelSealAtenaResult editラベルシール(LabelSealAtenaPartParam param) {
        LabelSealAtenaResult result = new LabelSealAtenaResult();
        if (null != param
                && null != param.get選挙人資格情報()
                && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
            AtenaKanaMeisho カナ名称 = param.get選挙人資格情報().getAtenaPSMEntity().getKanaMeisho();
            result.setKanaMeisho(null == カナ名称
                    ? RString.EMPTY : カナ名称.getColumnValue());
            ShikibetsuCode 識別コード = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            result.setShikibetsuCode(null == 識別コード
                    ? RString.EMPTY : 識別コード.getColumnValue());
            RString シール種別 = changeNullToEmpty(param.getシール種別());
            AfT111SenkyoEntity senkyoEntity = null;
            AfT201TohyoJokyoEntity tohyoJokyoEntity = null;
            RString 施設種別コード名称 = RString.EMPTY;
            RString 施設名称 = RString.EMPTY;

            for (AfT111SenkyoEntity senkyo : param.get選挙人資格情報().getSenkyoJohoEntity().getSenkyoEntity()) {
                if (senkyo.getSenkyoNo().getColumnValue() == param.get選挙Index()) {
                    senkyoEntity = senkyo;
                    break;
                }
            }
            List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList = param.get選挙人資格情報().getTohyoJokyoEntityList();
            for (int i = 0; i < tohyoJokyoEntityList.size(); i++) {
                if (tohyoJokyoEntityList.get(i).getSenkyoNo().getColumnValue() == param.get選挙Index()) {
                    tohyoJokyoEntity = tohyoJokyoEntityList.get(i);
                    施設種別コード名称 = param.get施設種別コード名称リスト().get(i);
                    施設名称 = param.get施設名称リスト().get(i);
                    break;
                }
            }
            if (宣誓書貼付用.equals(シール種別) || シール_封筒貼付用.equals(シール種別) || シール_入場券貼付用.equals(シール種別)) {
                editタイトルと内容(result, param, シール種別, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
            } else if (抄本貼付用.equals(シール種別)) {
                edit抄本貼付用内容(result, param);
            }
            editコード(result, param, シール種別, senkyoEntity);
        }
        return result;
    }

    private void edit抄本貼付用内容(LabelSealAtenaResult result, LabelSealAtenaPartParam param) {
        result.setShoNaiyo5(RString.EMPTY);
        result.setCode(RString.EMPTY);
        result.setBarcodeBarcode(RString.EMPTY);
        if (null != param && null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
            AtenaMeisho 資格名称 = param.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
            result.setShoNaiyo1(null == 資格名称
                    ? RString.EMPTY : 資格名称.getColumnValue());
            List<RString> 選挙マークリスト = param.get選挙マークリスト();
            int 選挙マーク数 = 選挙マークリスト.size();
            switch (選挙マーク数) {
                case 選挙１:
                    break;
                case 選挙２:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１));
                    break;
                case 選挙３:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２));
                    break;
                case 選挙４:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    break;
                case 選挙５:
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４));
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    break;
                case 選挙６:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４, 選挙５));
                    break;
                case 選挙７:
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４, 選挙５, 選挙６));
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    break;
                case 選挙８:
                    result.setShoNaiyo4(edit小_内容(選挙マークリスト,
                            選挙７));
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４, 選挙５, 選挙６));
                    break;
                case 選挙９:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo4(edit小_内容(選挙マークリスト,
                            選挙７, 選挙８));
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４, 選挙５, 選挙６));
                    break;
                case 選挙１０:
                    result.setShoNaiyo2(edit小_内容(選挙マークリスト,
                            選挙１, 選挙２, 選挙３));
                    result.setShoNaiyo4(edit小_内容(選挙マークリスト,
                            選挙７, 選挙８, 選挙９));
                    result.setShoNaiyo3(edit小_内容(選挙マークリスト,
                            選挙４, 選挙５, 選挙６));
                    break;
                default:
            }
        }
    }

    private void editコード(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString シール種別, AfT111SenkyoEntity senkyoEntity) {
        RString 印字有無 = RString.EMPTY;
        if (宣誓書貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (シール_入場券貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        } else if (シール_封筒貼付用.equals(シール種別)) {
            印字有無 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_バーコード印字有無, SubGyomuCode.AFA選挙本体);
        }
        if (バーコード印字有.equals(印字有無)) {
            editバーコード編集(result, param, シール種別, senkyoEntity);
        } else {
            result.setBarcodeBarcode(RString.EMPTY);
        }
        result.setCode(result.getBarcodeBarcode());
    }

    private RString edit小_内容(List<RString> 選挙マークリスト, int index, int... indexs) {
        RString 小_内容 = 選挙マークリスト.get(index);
        for (int i : indexs) {
            小_内容 = 小_内容.concat(RString.HALF_SPACE)
                    .concat(選挙マークリスト.get(i));
        }
        return 小_内容;
    }

    private void editバーコード編集(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString description, AfT111SenkyoEntity senkyoEntity) {
        if (null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()
                && null != param.get選挙人資格情報().getSenkyoJohoEntity() && null != param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity()) {
            ShikibetsuCode shikibetsuCode = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            RString 識別コード = RString.EMPTY;
            if (null != shikibetsuCode) {
                識別コード = shikibetsuCode.getColumnValue();
            }
            if (シール_封筒貼付用.equals(description)) {
                result.setBarcodeBarcode(識別コード.concat(null == param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getShohonNo()
                        ? RString.EMPTY : new RString(param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity()
                                .getShohonNo().getColumnValue()).padZeroToLeft(抄本番号桁数))
                        .concat(senkyoEntity == null ? RString.EMPTY : new RString(senkyoEntity.getSenkyoNo().getColumnValue())));

            } else {
                result.setBarcodeBarcode(識別コード.concat(null == param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity().getShohonNo()
                        ? RString.EMPTY : new RString(param.get選挙人資格情報().getSenkyoJohoEntity().getShohonEntity()
                                .getShohonNo().getColumnValue()).padZeroToLeft(抄本番号桁数))
                        .concat(new RString(0)));
            }
        }
    }

    private void editタイトルと内容(LabelSealAtenaResult result, LabelSealAtenaPartParam param, RString シール種別, AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity, RString 施設種別コード名称, RString 施設名称) {
        RString 印字内容 = RString.EMPTY;
        if (宣誓書貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (シール_入場券貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_印字内容, SubGyomuCode.AFA選挙本体);
        } else if (シール_封筒貼付用.equals(シール種別)) {
            印字内容 = BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_印字内容, SubGyomuCode.AFA選挙本体);
        }
        result.setShoNaiyo1(RString.EMPTY);
        result.setShoNaiyo2(RString.EMPTY);
        result.setShoNaiyo3(RString.EMPTY);
        result.setShoNaiyo4(RString.EMPTY);
        result.setShoNaiyo5(RString.EMPTY);
        List<RString> 印字内容List = 印字内容.split(",");
        RString コンフィグ値Ⅰ = 印字内容List.get(インデックス_印字内容1);
        RString コンフィグ値Ⅲ = 印字内容List.get(インデックス_印字内容3);
        RString コンフィグ値Ⅱ = 印字内容List.get(インデックス_印字内容2);
        RString コンフィグ値Ⅴ = 印字内容List.get(インデックス_印字内容5);
        RString コンフィグ値Ⅳ = 印字内容List.get(インデックス_印字内容4);
        List<RString> 印字内容Ⅰ = getタイトルByコンフィグ値(param, コンフィグ値Ⅰ, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容Ⅲ = getタイトルByコンフィグ値(param, コンフィグ値Ⅲ, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容Ⅱ = getタイトルByコンフィグ値(param, コンフィグ値Ⅱ, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容Ⅳ = getタイトルByコンフィグ値(param, コンフィグ値Ⅳ, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        List<RString> 印字内容Ⅴ = getタイトルByコンフィグ値(param, コンフィグ値Ⅴ, senkyoEntity, tohyoJokyoEntity, 施設種別コード名称, 施設名称);
        result.setNaiyo1(印字内容Ⅰ.get(インデックス_印字内容2));
        result.setNaiyo4(印字内容Ⅳ.get(インデックス_印字内容2));
        result.setNaiyo2(印字内容Ⅱ.get(インデックス_印字内容2));
        result.setNaiyo5(印字内容Ⅴ.get(インデックス_印字内容2));
        result.setNaiyo3(印字内容Ⅲ.get(インデックス_印字内容2));
        result.setTitle1(印字内容Ⅰ.get(インデックス_印字内容1));
        result.setTitle3(印字内容Ⅲ.get(インデックス_印字内容1));
        result.setTitle2(印字内容Ⅱ.get(インデックス_印字内容1));
        result.setTitle5(印字内容Ⅴ.get(インデックス_印字内容1));
        result.setTitle4(印字内容Ⅳ.get(インデックス_印字内容1));
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private List<RString> getタイトルByコンフィグ値(LabelSealAtenaPartParam param, RString コンフィグ値, AfT111SenkyoEntity senkyoEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity, RString 施設種別コード名称, RString 施設名称) {
        List<RString> 結果リスト = new ArrayList<>();
        RString 頁 = changeNullToEmpty(new RString(param.get選挙人資格情報()
                .getSenkyoninMeiboEntity().getPage()));
        RString 行 = changeNullToEmpty(new RString(param.get選挙人資格情報()
                .getSenkyoninMeiboEntity().getGyo()));
        RString tohyokuCode = changeNullToEmpty(param.get選挙人資格情報()
                .getSenkyoShikakuEntity().getTohyokuCode());
        RString 性別 = null == param.get選挙人資格情報().getAtenaPSMEntity().getSeibetsuCode()
                ? RString.EMPTY : new SeibetsuCode(param.get選挙人資格情報().getAtenaPSMEntity().getSeibetsuCode()).getColumnValue();
        Code 投票事由CD = null == tohyoJokyoEntity ? Code.EMPTY : tohyoJokyoEntity.getTohyoJiyuCode();
        RString 投票事由コード = null == 投票事由CD ? RString.EMPTY : 投票事由CD.getKey();
        AtenaMeisho 選挙人名称 = param.get選挙人資格情報().getAtenaPSMEntity().getMeisho();
        RString 名称 = null == 選挙人名称 ? RString.EMPTY : 選挙人名称.getColumnValue();
        if (配置值_00.equals(コンフィグ値)) {
            結果リスト.add(RString.EMPTY);
            結果リスト.add(RString.EMPTY);
        } else if (配置值_01.equals(コンフィグ値)) {
            結果リスト.add(new RString("投票区名　："));
            結果リスト.add(tohyokuCode);
        } else if (配置值_02.equals(コンフィグ値)) {
            結果リスト.add(登録番号);
            結果リスト.add(get標識(param).concat(頁)
                    .concat(連結標識).concat(行));
        } else if (配置值_03.equals(コンフィグ値)) {
            結果リスト.add(登録番号);
            結果リスト.add(tohyokuCode.concat(連結標識)
                    .concat(get標識(param)).concat(頁)
                    .concat(連結標識).concat(行));
        } else if (配置值_04.equals(コンフィグ値)) {
            結果リスト.add(new RString("名簿番号　："));
            結果リスト.add(tohyokuCode.concat(連結標識).concat(頁)
                    .concat(連結標識).concat(行));
        } else if (配置值_05.equals(コンフィグ値)) {
            結果リスト.add(new RString("行政区　　："));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getGyoseikuName()));
        } else if (配置值_06.equals(コンフィグ値)) {
            結果リスト.add(new RString("住所コード："));
            if (null != param.get選挙人資格情報() && null != param.get選挙人資格情報().getAtenaPSMEntity()) {
                ChoikiCode 住登内町域コード = param.get選挙人資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
                結果リスト.add(null == 住登内町域コード
                        ? RString.EMPTY : 住登内町域コード.getColumnValue());
            }
        } else if (配置值_07.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance()
                    .getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName1()));
        } else if (配置值_08.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance()
                    .getコード名称(ConfigKeysCodeName.コード名称_地区の分類２).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName2()));
        } else if (配置值_09.equals(コンフィグ値)) {
            結果リスト.add(JushoNyuryokuConfigFactory.createInstance()
                    .getコード名称(ConfigKeysCodeName.コード名称_地区の分類３).concat(コロン));
            結果リスト.add(changeNullToEmpty(param.get選挙人資格情報().getAtenaPSMEntity().getChikuName3()));
        } else if (配置值_10.equals(コンフィグ値)) {
            結果リスト.add(new RString("識別コード："));
            ShikibetsuCode 資格識別コード = param.get選挙人資格情報().getAtenaPSMEntity().getShikibetsuCode();
            結果リスト.add(null == 資格識別コード
                    ? RString.EMPTY : 資格識別コード.getColumnValue());
        } else if (配置值_11.equals(コンフィグ値)) {
            結果リスト.add(new RString("世帯コード："));
            SetaiCode 資格世帯コード = param.get選挙人資格情報().getAtenaPSMEntity().getSetaiCode();
            結果リスト.add(null == 資格世帯コード
                    ? RString.EMPTY : 資格世帯コード.getColumnValue());
        } else if (配置值_12.equals(コンフィグ値)) {
            結果リスト.add(new RString("性別　　　："));
            if (FEMALE.getCode().equals(性別)) {
                結果リスト.add(女);
            } else if (MALE.getCode().equals(性別)) {
                結果リスト.add(男);
            }
        } else if (配置值_13.equals(コンフィグ値)) {
            結果リスト.add(new RString("生年月日　："));
            FlexibleDate 生年月日 = param.get選挙人資格情報().getAtenaPSMEntity().getSeinengappiYMD();
            結果リスト.add(null == 生年月日
                    ? RString.EMPTY : 生年月日.wareki().toDateString());
        } else if (配置值_14.equals(コンフィグ値)) {
            結果リスト.add(new RString("氏　　名　："));
            結果リスト.add(名称);
        } else if (配置值_15.equals(コンフィグ値)) {
            結果リスト.add(new RString("受付番号　："));
            if (tohyoJokyoEntity != null) {
                結果リスト.add(toRString(tohyoJokyoEntity.getUketsukeNo()));
            } else {
                結果リスト.add(RString.EMPTY);
            }

        } else if (配置值_16.equals(コンフィグ値)) {
            結果リスト.add(氏名);
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 八文字)
                    .substring(0, 八文字)
                    .concat(RString.FULL_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (配置值_17.equals(コンフィグ値)) {
            結果リスト.add(氏名);
            結果リスト.add(名称.trimEnd().padRight(RString.FULL_SPACE, 七文字)
                    .substring(0, 七文字)
                    .concat(RString.HALF_SPACE)
                    .concat(性別)
                    .concat(RString.HALF_SPACE)
                    .concat(RStringUtil.convert半角to全角(投票事由コード)));
        } else if (配置值_18.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙名称　："));
            結果リスト.add(null == senkyoEntity ? RString.EMPTY : senkyoEntity.getSenkyoName());
        } else if (配置值_19.equals(コンフィグ値)) {
            結果リスト.add(new RString("選挙略称　："));
            結果リスト.add(null == senkyoEntity ? RString.EMPTY : senkyoEntity.getSenkyoRyakusho());
        } else if (配置值_20.equals(コンフィグ値)) {
            FlexibleDate 生年月日 = null == tohyoJokyoEntity ? FlexibleDate.EMPTY : tohyoJokyoEntity.getSeikyuYMD();
            結果リスト.add(new RString("請求年月日："));
            結果リスト.add(null == 生年月日
                    ? RString.EMPTY : 生年月日.wareki().toDateString());
        } else if (配置值_21.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求方法　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getSeikyuHohoMeisho());
        } else if (配置值_22.equals(コンフィグ値)) {
            結果リスト.add(new RString("請求事由　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getTohyoJiyuCodeRyakusho());
        } else if (配置值_23.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付年月日："));
            FlexibleDate 交付年月日 = null == tohyoJokyoEntity ? FlexibleDate.EMPTY : tohyoJokyoEntity.getKofuYMD();
            結果リスト.add(null == 交付年月日
                    ? RString.EMPTY : 交付年月日.wareki().toDateString());
        } else if (配置值_24.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付区分　："));
            結果リスト.add(施設種別コード名称);
        } else if (配置值_25.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付方法　："));
            結果リスト.add(null == tohyoJokyoEntity ? RString.EMPTY : tohyoJokyoEntity.getKofuHohoMeisho());
        } else if (配置值_26.equals(コンフィグ値)) {
            結果リスト.add(new RString("交付施設　："));
            結果リスト.add(施設名称);
        } else if (配置值_27.equals(コンフィグ値)) {
            結果リスト.add(new RString("市区町村名："));
            結果リスト.add(changeNullToEmpty(data.get帳票共通ヘッダー().get市町村名()));
        }

        return 結果リスト;
    }

    private RString get標識(LabelSealAtenaPartParam param) {
        Code 選挙資格区分 = param.get選挙人資格情報().getSenkyoShikakuEntity().getShikakuKubun();
        if (new Code(SennkyoSikakuKubun.抹消者.value()).equals(選挙資格区分)
                || new Code(SennkyoSikakuKubun.資格なし.value()).equals(選挙資格区分)) {
            return 抹消者;
        } else if (new Code(SennkyoSikakuKubun.公民権停止.value()).equals(選挙資格区分)) {
            return 公民権停止者;
        } else if (new Code(SennkyoSikakuKubun.表示者.value()).equals(選挙資格区分)) {
            return 表示者;
        } else {
            return RString.EMPTY;
        }
    }

    private void edit作成日時(LabelSealAtena21Source source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
    }

    private void edit市町村コード(LabelSealAtena21Source source) {
        if (null != data.get地方公共団体情報() && null != data.get地方公共団体情報().getLasdecCode_()) {
            source.shichosonCode = data.get地方公共団体情報().getLasdecCode_().value();
        }
    }

    private void edit市町村名(LabelSealAtena21Source source) {
        if (null != data.get地方公共団体情報()) {
            source.sichosonMei = data.get地方公共団体情報().get市町村名();
        }
    }

    private void edit帳票タイトル(LabelSealAtena21Source source) {
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
