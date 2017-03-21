package jp.co.ndensan.reams.af.afa.business.report.AFAPRE213;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealGroupSource;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
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
 * 宛名シール12面
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12Editor implements IAtenaSeal12Editor {

    private static final RString 全角スペース = new RString("　");
    private static final RString 半角スペース = new RString(" ");
    private static final RString 施設宛名シール_21面 = new RString("AFAGME6030");
    private static final int 長さ_住所_上段 = getItemLength(new RString("jushoa1"));
    private static final int 長さ_住所_中段 = getItemLength(new RString("jushob1"));
    private static final int 長さ_住所_下段 = getItemLength(new RString("jushoc1"));
    private static final int 長さ_小_住所_1段目 = getItemLength(new RString("jushola1"));
    private static final int 長さ_小_住所_2段目 = getItemLength(new RString("jusholb1"));
    private static final int 長さ_小_住所_3段目 = getItemLength(new RString("jusholc1"));
    private static final int 長さ_小_住所_4段目 = getItemLength(new RString("jushold1"));
    private static final int 長さ_宛名_上段 = getItemLength(new RString("atenaa1"));
    private static final int 長さ_宛名_下段 = getItemLength(new RString("atenab1"));
    private static final int 長さ_小宛名_上段 = getItemLength(new RString("atenala1"));
    private static final int 長さ_小宛名_下段 = getItemLength(new RString("atenalb1"));
    private static final RString 連結標識 = new RString("-");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 様 = new RString("　様");
    private static final RString 作成 = new RString("作成");
    private final AtenaSeal12Param data;

    /**
     * コンストラクタです。
     *
     * @param data {@link AtenaSeal12Param}
     */
    public AtenaSeal12Editor(AtenaSeal12Param data) {
        this.data = data;
    }

    /**
     * 宛名シール12面エディットメソッド
     *
     * @param source 宛名シール12面
     * @return 宛名シール12面
     */
    @Override
    public AtenaSeal12Source edit(AtenaSeal12Source source) {
        source.pageCount = data.get頁番号();
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
        edit市町村コード(source);
        edit市町村名(source);
        edit作成日時(source);
        return source;
    }

    private void editTwo(AtenaSeal12Source source) {
        if (null != data.getParam2()) {
            AtenaSealGroupSource groupSource2 = edit総合編集(source, data.getParam2());
            source.jushoList2 = groupSource2.getJushoList();
            source.meishoList2 = groupSource2.getMeishoList();
            if (!groupSource2.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode2 = new RString(groupSource2.getShikibetsuCode().toString());
                source.shikibetsuCode_2 = new RString(groupSource2.getShikibetsuCode().toString());
            }
            source.yubinno2 = groupSource2.getYubinno();
            source.jushoa2 = groupSource2.getJushoa();
            source.jushob2 = groupSource2.getJushob();
            source.jushoc2 = groupSource2.getJushoc();
            source.jushola2 = groupSource2.getJushola();
            source.jusholb2 = groupSource2.getJusholb();
            source.jusholc2 = groupSource2.getJusholc();
            source.jushold2 = groupSource2.getJushold();
            source.atenaa2 = groupSource2.getAtenaa();
            source.atenab2 = groupSource2.getAtenab();
            source.atenala2 = groupSource2.getAtenala();
            source.atenalb2 = groupSource2.getAtenalb();
            source.koumokua2 = groupSource2.getKoumokua();
            source.koumokub2 = groupSource2.getKoumokub();
            source.koumokuc2 = groupSource2.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード2 = groupSource2.getShikibetsuCode();
                source.個人番号使用2 = KojinNo.EMPTY;
                source.法人番号使用2 = HojinNo.EMPTY;
            }
            source.barcodeBarcode2 = groupSource2.getBarcodeBarcode();
        }
    }

    private void editFirst(AtenaSeal12Source source) {
        if (null != data.getParam1()) {
            AtenaSealGroupSource groupSource1 = edit総合編集(source, data.getParam1());
            source.jushoList1 = groupSource1.getJushoList();
            source.meishoList1 = groupSource1.getMeishoList();
            if (!groupSource1.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode1 = new RString(groupSource1.getShikibetsuCode().toString());
                source.shikibetsuCode_1 = new RString(groupSource1.getShikibetsuCode().toString());
            }
            source.yubinno1 = groupSource1.getYubinno();
            source.jushoa1 = groupSource1.getJushoa();
            source.jushob1 = groupSource1.getJushob();
            source.jushoc1 = groupSource1.getJushoc();
            source.jushola1 = groupSource1.getJushola();
            source.jusholb1 = groupSource1.getJusholb();
            source.jusholc1 = groupSource1.getJusholc();
            source.jushold1 = groupSource1.getJushold();
            source.atenaa1 = groupSource1.getAtenaa();
            source.atenab1 = groupSource1.getAtenab();
            source.atenala1 = groupSource1.getAtenala();
            source.atenalb1 = groupSource1.getAtenalb();
            source.koumokua1 = groupSource1.getKoumokua();
            source.koumokub1 = groupSource1.getKoumokub();
            source.koumokuc1 = groupSource1.getKoumokuc();
            source.barcodeBarcode1 = groupSource1.getBarcodeBarcode();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード1 = groupSource1.getShikibetsuCode();
                source.個人番号使用1 = KojinNo.EMPTY;
                source.法人番号使用1 = HojinNo.EMPTY;
            }
        }

    }

    private void editThree(AtenaSeal12Source source) {
        if (null != data.getParam3()) {
            AtenaSealGroupSource groupSource3 = edit総合編集(source, data.getParam3());
            source.jushoList3 = groupSource3.getJushoList();
            source.meishoList3 = groupSource3.getMeishoList();
            if (!groupSource3.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode3 = new RString(groupSource3.getShikibetsuCode().toString());
                source.shikibetsuCode_3 = new RString(groupSource3.getShikibetsuCode().toString());
            }
            source.yubinno3 = groupSource3.getYubinno();
            source.jushoa3 = groupSource3.getJushoa();
            source.jushob3 = groupSource3.getJushob();
            source.jushoc3 = groupSource3.getJushoc();
            source.jushola3 = groupSource3.getJushola();
            source.jusholb3 = groupSource3.getJusholb();
            source.jusholc3 = groupSource3.getJusholc();
            source.jushold3 = groupSource3.getJushold();
            source.atenaa3 = groupSource3.getAtenaa();
            source.atenab3 = groupSource3.getAtenab();
            source.atenala3 = groupSource3.getAtenala();
            source.atenalb3 = groupSource3.getAtenalb();
            source.koumokua3 = groupSource3.getKoumokua();
            source.koumokub3 = groupSource3.getKoumokub();
            source.koumokuc3 = groupSource3.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード3 = groupSource3.getShikibetsuCode();
                source.個人番号使用3 = KojinNo.EMPTY;
                source.法人番号使用3 = HojinNo.EMPTY;
            }
            source.barcodeBarcode3 = groupSource3.getBarcodeBarcode();
        }
    }

    private void editFour(AtenaSeal12Source source) {
        if (null != data.getParam4()) {
            AtenaSealGroupSource groupSource4 = edit総合編集(source, data.getParam4());
            source.jushoList4 = groupSource4.getJushoList();
            source.meishoList4 = groupSource4.getMeishoList();
            if (!groupSource4.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode4 = new RString(groupSource4.getShikibetsuCode().toString());
                source.shikibetsuCode_4 = new RString(groupSource4.getShikibetsuCode().toString());
            }
            source.yubinno4 = groupSource4.getYubinno();
            source.jushoa4 = groupSource4.getJushoa();
            source.jushob4 = groupSource4.getJushob();
            source.jushoc4 = groupSource4.getJushoc();
            source.jushola4 = groupSource4.getJushola();
            source.jusholb4 = groupSource4.getJusholb();
            source.jusholc4 = groupSource4.getJusholc();
            source.jushold4 = groupSource4.getJushold();
            source.atenaa4 = groupSource4.getAtenaa();
            source.atenab4 = groupSource4.getAtenab();
            source.atenala4 = groupSource4.getAtenala();
            source.atenalb4 = groupSource4.getAtenalb();
            source.koumokua4 = groupSource4.getKoumokua();
            source.koumokub4 = groupSource4.getKoumokub();
            source.koumokuc4 = groupSource4.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード4 = groupSource4.getShikibetsuCode();
                source.個人番号使用4 = KojinNo.EMPTY;
                source.法人番号使用4 = HojinNo.EMPTY;
            }
            source.barcodeBarcode4 = groupSource4.getBarcodeBarcode();
        }
    }

    private void editFive(AtenaSeal12Source source) {
        if (null != data.getParam5()) {
            AtenaSealGroupSource groupSource5 = edit総合編集(source, data.getParam5());
            source.jushoList5 = groupSource5.getJushoList();
            source.meishoList5 = groupSource5.getMeishoList();
            if (!groupSource5.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode5 = new RString(groupSource5.getShikibetsuCode().toString());
                source.shikibetsuCode_5 = new RString(groupSource5.getShikibetsuCode().toString());
            }
            source.yubinno5 = groupSource5.getYubinno();
            source.jushoa5 = groupSource5.getJushoa();
            source.jushob5 = groupSource5.getJushob();
            source.jushoc5 = groupSource5.getJushoc();
            source.jushola5 = groupSource5.getJushola();
            source.jusholb5 = groupSource5.getJusholb();
            source.jusholc5 = groupSource5.getJusholc();
            source.jushold5 = groupSource5.getJushold();
            source.atenaa5 = groupSource5.getAtenaa();
            source.atenab5 = groupSource5.getAtenab();
            source.atenala5 = groupSource5.getAtenala();
            source.atenalb5 = groupSource5.getAtenalb();
            source.koumokua5 = groupSource5.getKoumokua();
            source.koumokub5 = groupSource5.getKoumokub();
            source.koumokuc5 = groupSource5.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード5 = groupSource5.getShikibetsuCode();
                source.個人番号使用5 = KojinNo.EMPTY;
                source.法人番号使用5 = HojinNo.EMPTY;
            }
            source.barcodeBarcode5 = groupSource5.getBarcodeBarcode();
        }
    }

    private void editSix(AtenaSeal12Source source) {
        if (null != data.getParam6()) {
            AtenaSealGroupSource groupSource6 = edit総合編集(source, data.getParam6());
            source.jushoList6 = groupSource6.getJushoList();
            source.meishoList6 = groupSource6.getMeishoList();
            if (!groupSource6.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode6 = new RString(groupSource6.getShikibetsuCode().toString());
                source.shikibetsuCode_6 = new RString(groupSource6.getShikibetsuCode().toString());
            }
            source.yubinno6 = groupSource6.getYubinno();
            source.jushoa6 = groupSource6.getJushoa();
            source.jushob6 = groupSource6.getJushob();
            source.jushoc6 = groupSource6.getJushoc();
            source.jushola6 = groupSource6.getJushola();
            source.jusholb6 = groupSource6.getJusholb();
            source.jusholc6 = groupSource6.getJusholc();
            source.jushold6 = groupSource6.getJushold();
            source.atenaa6 = groupSource6.getAtenaa();
            source.atenab6 = groupSource6.getAtenab();
            source.atenala6 = groupSource6.getAtenala();
            source.atenalb6 = groupSource6.getAtenalb();
            source.koumokua6 = groupSource6.getKoumokua();
            source.koumokub6 = groupSource6.getKoumokub();
            source.koumokuc6 = groupSource6.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード6 = groupSource6.getShikibetsuCode();
                source.個人番号使用6 = KojinNo.EMPTY;
                source.法人番号使用6 = HojinNo.EMPTY;
            }
            source.barcodeBarcode6 = groupSource6.getBarcodeBarcode();
        }
    }

    private void editSeven(AtenaSeal12Source source) {
        if (null != data.getParam7()) {
            AtenaSealGroupSource groupSource7 = edit総合編集(source, data.getParam7());
            source.jushoList7 = groupSource7.getJushoList();
            source.meishoList7 = groupSource7.getMeishoList();
            if (!groupSource7.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode7 = new RString(groupSource7.getShikibetsuCode().toString());
                source.shikibetsuCode_7 = new RString(groupSource7.getShikibetsuCode().toString());
            }
            source.yubinno7 = groupSource7.getYubinno();
            source.jushoa7 = groupSource7.getJushoa();
            source.jushob7 = groupSource7.getJushob();
            source.jushoc7 = groupSource7.getJushoc();
            source.jushola7 = groupSource7.getJushola();
            source.jusholb7 = groupSource7.getJusholb();
            source.jusholc7 = groupSource7.getJusholc();
            source.jushold7 = groupSource7.getJushold();
            source.atenaa7 = groupSource7.getAtenaa();
            source.atenab7 = groupSource7.getAtenab();
            source.atenala7 = groupSource7.getAtenala();
            source.atenalb7 = groupSource7.getAtenalb();
            source.koumokua7 = groupSource7.getKoumokua();
            source.koumokub7 = groupSource7.getKoumokub();
            source.koumokuc7 = groupSource7.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード7 = groupSource7.getShikibetsuCode();
                source.個人番号使用7 = KojinNo.EMPTY;
                source.法人番号使用7 = HojinNo.EMPTY;
            }
            source.barcodeBarcode7 = groupSource7.getBarcodeBarcode();
        }
    }

    private void editEight(AtenaSeal12Source source) {
        if (null != data.getParam8()) {
            AtenaSealGroupSource groupSource8 = edit総合編集(source, data.getParam8());
            source.jushoList8 = groupSource8.getJushoList();
            source.meishoList8 = groupSource8.getMeishoList();
            if (!groupSource8.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode8 = new RString(groupSource8.getShikibetsuCode().toString());
                source.shikibetsuCode_8 = new RString(groupSource8.getShikibetsuCode().toString());
            }
            source.yubinno8 = groupSource8.getYubinno();
            source.jushoa8 = groupSource8.getJushoa();
            source.jushob8 = groupSource8.getJushob();
            source.jushoc8 = groupSource8.getJushoc();
            source.jushola8 = groupSource8.getJushola();
            source.jusholb8 = groupSource8.getJusholb();
            source.jusholc8 = groupSource8.getJusholc();
            source.jushold8 = groupSource8.getJushold();
            source.atenaa8 = groupSource8.getAtenaa();
            source.atenab8 = groupSource8.getAtenab();
            source.atenala8 = groupSource8.getAtenala();
            source.atenalb8 = groupSource8.getAtenalb();
            source.koumokua8 = groupSource8.getKoumokua();
            source.koumokub8 = groupSource8.getKoumokub();
            source.koumokuc8 = groupSource8.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード8 = groupSource8.getShikibetsuCode();
                source.個人番号使用8 = KojinNo.EMPTY;
                source.法人番号使用8 = HojinNo.EMPTY;
            }
            source.barcodeBarcode8 = groupSource8.getBarcodeBarcode();
        }
    }

    private void editNine(AtenaSeal12Source source) {
        if (null != data.getParam9()) {
            AtenaSealGroupSource groupSource9 = edit総合編集(source, data.getParam9());
            source.jushoList9 = groupSource9.getJushoList();
            source.meishoList9 = groupSource9.getMeishoList();
            if (!groupSource9.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode9 = new RString(groupSource9.getShikibetsuCode().toString());
                source.shikibetsuCode_9 = new RString(groupSource9.getShikibetsuCode().toString());
            }
            source.yubinno9 = groupSource9.getYubinno();
            source.jushoa9 = groupSource9.getJushoa();
            source.jushob9 = groupSource9.getJushob();
            source.jushoc9 = groupSource9.getJushoc();
            source.jushola9 = groupSource9.getJushola();
            source.jusholb9 = groupSource9.getJusholb();
            source.jusholc9 = groupSource9.getJusholc();
            source.jushold9 = groupSource9.getJushold();
            source.atenaa9 = groupSource9.getAtenaa();
            source.atenab9 = groupSource9.getAtenab();
            source.atenala9 = groupSource9.getAtenala();
            source.atenalb9 = groupSource9.getAtenalb();
            source.koumokua9 = groupSource9.getKoumokua();
            source.koumokub9 = groupSource9.getKoumokub();
            source.koumokuc9 = groupSource9.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード9 = groupSource9.getShikibetsuCode();
                source.個人番号使用9 = KojinNo.EMPTY;
                source.法人番号使用9 = HojinNo.EMPTY;
            }
            source.barcodeBarcode9 = groupSource9.getBarcodeBarcode();
        }
    }

    private void editTen(AtenaSeal12Source source) {
        if (null != data.getParam10()) {
            AtenaSealGroupSource groupSource10 = edit総合編集(source, data.getParam10());
            source.jushoList10 = groupSource10.getJushoList();
            source.meishoList10 = groupSource10.getMeishoList();
            if (!groupSource10.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode10 = new RString(groupSource10.getShikibetsuCode().toString());
                source.shikibetsuCode_10 = new RString(groupSource10.getShikibetsuCode().toString());
            }
            source.yubinno10 = groupSource10.getYubinno();
            source.jushoa10 = groupSource10.getJushoa();
            source.jushob10 = groupSource10.getJushob();
            source.jushoc10 = groupSource10.getJushoc();
            source.jushola10 = groupSource10.getJushola();
            source.jusholb10 = groupSource10.getJusholb();
            source.jusholc10 = groupSource10.getJusholc();
            source.jushold10 = groupSource10.getJushold();
            source.atenaa10 = groupSource10.getAtenaa();
            source.atenab10 = groupSource10.getAtenab();
            source.atenala10 = groupSource10.getAtenala();
            source.atenalb10 = groupSource10.getAtenalb();
            source.koumokua10 = groupSource10.getKoumokua();
            source.koumokub10 = groupSource10.getKoumokub();
            source.koumokuc10 = groupSource10.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード10 = groupSource10.getShikibetsuCode();
                source.個人番号使用10 = KojinNo.EMPTY;
                source.法人番号使用10 = HojinNo.EMPTY;
            }
            source.barcodeBarcode10 = groupSource10.getBarcodeBarcode();
        }
    }

    private void editEleven(AtenaSeal12Source source) {
        if (null != data.getParam11()) {
            AtenaSealGroupSource groupSource11 = edit総合編集(source, data.getParam11());
            source.jushoList11 = groupSource11.getJushoList();
            source.meishoList11 = groupSource11.getMeishoList();
            if (!groupSource11.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode11 = new RString(groupSource11.getShikibetsuCode().toString());
                source.shikibetsuCode_11 = new RString(groupSource11.getShikibetsuCode().toString());
            }
            source.yubinno11 = groupSource11.getYubinno();
            source.jushoa11 = groupSource11.getJushoa();
            source.jushob11 = groupSource11.getJushob();
            source.jushoc11 = groupSource11.getJushoc();
            source.jushola11 = groupSource11.getJushola();
            source.jusholb11 = groupSource11.getJusholb();
            source.jusholc11 = groupSource11.getJusholc();
            source.jushold11 = groupSource11.getJushold();
            source.atenaa11 = groupSource11.getAtenaa();
            source.atenab11 = groupSource11.getAtenab();
            source.atenala11 = groupSource11.getAtenala();
            source.atenalb11 = groupSource11.getAtenalb();
            source.koumokua11 = groupSource11.getKoumokua();
            source.koumokub11 = groupSource11.getKoumokub();
            source.koumokuc11 = groupSource11.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード11 = groupSource11.getShikibetsuCode();
                source.個人番号使用11 = KojinNo.EMPTY;
                source.法人番号使用11 = HojinNo.EMPTY;
            }
            source.barcodeBarcode11 = groupSource11.getBarcodeBarcode();
        }
    }

    private void editTwelve(AtenaSeal12Source source) {
        if (null != data.getParam12()) {
            AtenaSealGroupSource groupSource12 = edit総合編集(source, data.getParam12());
            source.jushoList12 = groupSource12.getJushoList();
            source.meishoList12 = groupSource12.getMeishoList();
            if (!groupSource12.getShikibetsuCode().isEmpty()) {
                source.shikibetsuCode12 = new RString(groupSource12.getShikibetsuCode().toString());
                source.shikibetsuCode_12 = new RString(groupSource12.getShikibetsuCode().toString());
            }
            source.yubinno12 = groupSource12.getYubinno();
            source.jushoa12 = groupSource12.getJushoa();
            source.jushob12 = groupSource12.getJushob();
            source.jushoc12 = groupSource12.getJushoc();
            source.jushola12 = groupSource12.getJushola();
            source.jusholb12 = groupSource12.getJusholb();
            source.jusholc12 = groupSource12.getJusholc();
            source.jushold12 = groupSource12.getJushold();
            source.atenaa12 = groupSource12.getAtenaa();
            source.atenab12 = groupSource12.getAtenab();
            source.atenala12 = groupSource12.getAtenala();
            source.atenalb12 = groupSource12.getAtenalb();
            source.koumokua12 = groupSource12.getKoumokua();
            source.koumokub12 = groupSource12.getKoumokub();
            source.koumokuc12 = groupSource12.getKoumokuc();
            if (!data.get画面ID().equals(施設宛名シール_21面)) {
                source.識別コード12 = groupSource12.getShikibetsuCode();
                source.個人番号使用12 = KojinNo.EMPTY;
                source.法人番号使用12 = HojinNo.EMPTY;
            }
            source.barcodeBarcode12 = groupSource12.getBarcodeBarcode();
        }
    }

    private AtenaSealGroupSource edit総合編集(AtenaSeal12Source source, AtenaSealPartParam param) {
        AtenaSealGroupSource groupSource = new AtenaSealGroupSource();
        edit帳票タイトルと郵便番号と選挙名称(source, param, groupSource);
        edit住所処理(param, groupSource, source);
        edit宛名印字処理(param, groupSource, source);
        edit隅の項目印字処理(param, groupSource);
        editアクセスログ出力(param, groupSource);
        editカスタマーバーコード(param, groupSource);
        return groupSource;
    }

    private void editカスタマーバーコード(AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != param) {
            groupSource.setBarcodeBarcode(param.getCustomBarCode());
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void edit帳票タイトルと郵便番号と選挙名称(AtenaSeal12Source source, AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != param) {
            YubinNo 郵便番号 = YubinNo.EMPTY;
            YubinNo 郵番号 = YubinNo.EMPTY;
            YubinNo 住登内郵便番号 = YubinNo.EMPTY;
            if (null != param.get施設情報()) {
                郵便番号 = param.get施設情報().getYubinNo();
            }
            if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                郵番号 = param.get投票資格情報().getAtenaPSMEntity().getYubinNo();
                住登内郵便番号 = param.get投票資格情報().getAtenaPSMEntity().getJutonaiYubinNo();
            }
            switch (data.get画面ID().toString()) {
                case "AFAGMB2010":
                    source.title = new RString("入場券発行（一括）");
                    break;
                case "AFAGMA1010":
                    source.title = new RString("定時登録");
                    break;
                case "AFAGMA1030":
                    source.title = new RString("定時帳票再発行");
                    break;
                case "AFAGMB1010":
                    source.title = new RString("選挙時登録");
                    break;
                case "AFAGMB1040":
                    source.title = new RString("選挙時登録帳票再発行");
                    break;
                case "AFAGMG1010":
                    source.title = new RString("国民投票時登録");
                    break;
                case "AFAGMG1060":
                    source.title = new RString("国民投票帳票再発行");
                    break;
                case "AFAGMK1030":
                    source.title = new RString("海区漁業調整委員会委員選挙時登録");
                    break;
                case "AFAGMK1040":
                    source.title = new RString("海区漁業調整委員会委員選挙人名簿最新化");
                    break;
                case "AFAGME6030":
                    groupSource.setYubinno(null == 郵便番号
                            ? RString.EMPTY : 郵便番号.getColumnValue());
                    source.title = new RString("施設宛名シール（12面）");
                    break;
                case "AFAGME6020":
                    groupSource.setYubinno(null == 郵番号
                            ? RString.EMPTY : 郵番号.getColumnValue());
                    source.senkyoMei = changeNullToEmpty(param.get投票資格情報().getSenkyoEntity().getSenkyoName());
                    source.title = new RString("転出者宛名シール（12面）");
                    break;
                case "AFAGME6010":
                    source.title = new RString("選挙人宛名シール（12面）");
                    groupSource.setYubinno(null == 住登内郵便番号
                            ? RString.EMPTY : 住登内郵便番号.getColumnValue());
                    break;
                default:
            }
        }
    }

    private RString edit追加編集(AtenaSealPartParam param, RString value) {
        RString resultValue = RString.EMPTY;
        RString 住所の前に市町村名を付加 = RString.EMPTY;
        RString additionalValue1 = RString.EMPTY;
        RString additionalValue2 = RString.EMPTY;
        if (null != param.get画面情報()) {
            住所の前に市町村名を付加 = param.get画面情報().get住所の前に市町村名を付加();
        }
        if (null != data.get地方公共団体情報()) {
            additionalValue1 = data.get地方公共団体情報().get都道府県名().concat(data.get地方公共団体情報().get市町村名());
            additionalValue2 = data.get地方公共団体情報().get市町村名();
        }
        if (TWO.equals(住所の前に市町村名を付加)) {
            resultValue = additionalValue1.concat(value);
        } else if (ONE.equals(住所の前に市町村名を付加)) {
            resultValue = additionalValue2.concat(value);
        } else if (ZERO.equals(住所の前に市町村名を付加)) {
            resultValue = value;
        }

        return resultValue;
    }

    private void edit住所処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (null != param) {
            RString jutonaiKatagakiValue = RString.EMPTY;
            RString suJushoValue = RString.EMPTY;
            RString 住所ID = RString.EMPTY;
            RString value11 = RString.EMPTY;
            RString value21 = RString.EMPTY;
            RString value31 = RString.EMPTY;
            RString value41 = RString.EMPTY;
            RString value42 = RString.EMPTY;
            RString value51 = RString.EMPTY;
            RString value53 = RString.EMPTY;
            RString value61 = RString.EMPTY;
            RString talValue = RString.EMPTY;
            if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                AtenaBanchi jutonaiBanchi = param.get投票資格情報().getAtenaPSMEntity().getJutonaiBanchi();
                RString jutonaiBanchiValue = null == jutonaiBanchi ? RString.EMPTY : jutonaiBanchi.getColumnValue();
                Katagaki jutonaiKatagaki = param.get投票資格情報().getAtenaPSMEntity().getJutonaiKatagaki();
                jutonaiKatagakiValue = null == jutonaiKatagaki ? RString.EMPTY : jutonaiKatagaki.getColumnValue();
                value11 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                        .concat(jutonaiBanchiValue);
                value21 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho()).concat(左括弧)
                        .concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName())).concat(右括弧)
                        .concat(jutonaiBanchiValue);
                value31 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                        .concat(jutonaiBanchiValue)
                        .concat(左括弧).concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()))
                        .concat(右括弧);
                value41 = 左括弧.concat(changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()))
                        .concat(右括弧);
                value42 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                        .concat(jutonaiBanchiValue);
                value51 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho())
                        .concat(jutonaiBanchiValue);
                value53 = 全角スペース.concat(全角スペース).concat(全角スペース)
                        .concat(左括弧).concat(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName()).concat(右括弧);
                value61 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName())
                        .concat(jutonaiBanchiValue);
                AtenaJusho 投票住所 = param.get投票資格情報().getAtenaPSMEntity().getJusho();
                AtenaBanchi 投票番地 = param.get投票資格情報().getAtenaPSMEntity().getBanchi();
                Katagaki 投票方書 = param.get投票資格情報().getAtenaPSMEntity().getKatagaki();
                talValue = null == 投票住所 ? RString.EMPTY : 投票住所.getColumnValue().concat(null == 投票番地
                        ? RString.EMPTY : 投票番地.getColumnValue()).concat(全角スペース).concat(null == 投票方書
                                ? RString.EMPTY : 投票方書.getColumnValue());
            }
            if (null != param.get施設情報()) {
                AtenaJusho 施設住所 = param.get施設情報().getJusho();
                suJushoValue = null == 施設住所
                        ? RString.EMPTY : 施設住所.getColumnValue();
            }
            if (null != param.get画面情報()) {
                住所ID = null == param.get画面情報().get住所コード() ? RString.EMPTY : param.get画面情報().get住所コード();
            }
            edit住所印字処理(param, groupSource, jutonaiKatagakiValue, suJushoValue,
                    住所ID, value11, value21, value31, value41,
                    value42, value51, value53, value61, talValue, source);
        }
    }

    private void edit住所印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource, RString jutonaiKatagakiValue,
            RString suJushoValue, RString 住所ID, RString value11, RString value21, RString value31, RString value41,
            RString value42, RString value51, RString value53, RString value61, RString talValue, AtenaSeal12Source source) {
        switch (data.get画面ID().toString()) {
            case "AFAGMB2010":
            case "AFAGMA1010":
            case "AFAGMA1030":
            case "AFAGMB1010":
            case "AFAGMB1040":
            case "AFAGMG1010":
            case "AFAGMG1060":
            case "AFAGMK1030":
            case "AFAGMK1040":
                RString fristValue = value11;
                RString twoValue = jutonaiKatagakiValue;
                edit選挙人宛名シールの住所処理1(fristValue, twoValue, groupSource, source);
                break;
            case "AFAGME6030":
                edit転出者と施設宛名シール住所処理(suJushoValue, groupSource, source);
                break;
            case "AFAGME6010":
                switch (住所ID.toString()) {
                    case "1":
                        RString value12 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理1(edit追加編集(param, value11), value12, groupSource, source);
                        break;
                    case "2":
                        RString value22 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理1(edit追加編集(param, value21), value22, groupSource, source);
                        break;
                    case "3":
                        RString value32 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理1(edit追加編集(param, value31), value32, groupSource, source);
                        break;
                    case "4":
                        RString value43 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理2(edit追加編集(param, value41), value42, value43, groupSource, source);
                        break;
                    case "5":
                        RString value52 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理2(edit追加編集(param, value51), value52, value53, groupSource, source);
                        break;
                    case "6":
                        RString value62 = jutonaiKatagakiValue;
                        edit選挙人宛名シールの住所処理1(edit追加編集(param, value61), value62, groupSource, source);
                        break;
                    default:
                }
                break;
            case "AFAGME6020":
                edit転出者と施設宛名シール住所処理(talValue, groupSource, source);
                break;
            default:
        }
    }

    private void edit転出者と施設宛名シール住所処理(RString value, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value.length() > (長さ_住所_上段 + 長さ_住所_中段 + 長さ_住所_下段)) {
            if (value.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
                groupSource.setJushola(value.substring(0, 長さ_小_住所_1段目));
                groupSource.setJusholb(value.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
                groupSource.setJusholc(value.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目), (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
                groupSource.setJushold(value.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目),
                        (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)));
                source.jushoList = value;
                groupSource.setJushoList(value);
            } else {
                if (value.length() <= 長さ_小_住所_1段目) {
                    groupSource.setJushola(value);
                    groupSource.setJusholb(RString.EMPTY);
                    groupSource.setJusholc(RString.EMPTY);
                    groupSource.setJushold(RString.EMPTY);
                } else if (value.length() <= (長さ_小_住所_1段目 + 長さ_小_住所_2段目)) {
                    groupSource.setJushola(value.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value.substring(長さ_小_住所_1段目));
                    groupSource.setJusholc(RString.EMPTY);
                    groupSource.setJushold(RString.EMPTY);
                } else if (value.length() <= (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)) {
                    groupSource.setJushola(value.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value.substring(長さ_小_住所_1段目, 長さ_小_住所_1段目 + 長さ_小_住所_2段目));
                    groupSource.setJusholc(value.substring(長さ_小_住所_1段目 + 長さ_小_住所_2段目));
                    groupSource.setJushold(RString.EMPTY);
                } else {
                    groupSource.setJushola(value.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
                    groupSource.setJusholc(value.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目), (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
                    groupSource.setJushold(value.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
                }
            }
        } else {
            if (value.length() <= 長さ_住所_上段) {
                groupSource.setJushoa(value);
                groupSource.setJushob(RString.EMPTY);
                groupSource.setJushoc(RString.EMPTY);
            } else if (value.length() <= (長さ_住所_上段 + 長さ_住所_中段)) {
                groupSource.setJushoa(value.substring(0, 長さ_住所_上段));
                groupSource.setJushob(value.substring(長さ_住所_上段));
                groupSource.setJushoc(RString.EMPTY);
            } else {
                groupSource.setJushoa(value.substring(0, 長さ_住所_上段));
                groupSource.setJushob(value.substring(長さ_住所_上段, (長さ_住所_上段 + 長さ_住所_中段)));
                groupSource.setJushoc(value.substring((長さ_住所_上段 + 長さ_住所_中段)));
            }
        }
    }

    private void edit宛名印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (null != param) {
            RString 本人敬称 = RString.EMPTY;
            RString 世帯主敬称 = RString.EMPTY;
            RString 宛名ID = RString.EMPTY;
            RString 名称 = RString.EMPTY;
            RString 施設宛名 = RString.EMPTY;
            RString 施設名称 = RString.EMPTY;
            RString value21 = RString.EMPTY;
            RString value31 = RString.EMPTY;
            if (null != param.get画面情報()) {
                本人敬称 = changeNullToEmpty(ZERO.equals(param.get画面情報().get本人敬称コード())
                        ? RString.EMPTY : param.get画面情報().get本人敬称());
                世帯主敬称 = changeNullToEmpty(ZERO.equals(param.get画面情報().get世帯主敬称コード())
                        ? RString.EMPTY : param.get画面情報().get世帯主敬称());
                宛名ID = changeNullToEmpty(null == param.get画面情報().get宛名コード()
                        ? RString.EMPTY : param.get画面情報().get宛名コード());
            }
            if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
                AtenaMeisho meisho = param.get投票資格情報().getAtenaPSMEntity().getMeisho();
                名称 = null == meisho ? RString.EMPTY : meisho.getColumnValue();
                AtenaKanaMeisho カナ名称 = param.get投票資格情報().getAtenaPSMEntity().getKanaMeisho();
                value21 = null == カナ名称 ? RString.EMPTY : カナ名称.getColumnValue();
                AtenaMeisho 世帯主名 = param.get投票資格情報().getAtenaPSMEntity().getSetainushiMei();
                value31 = null == 世帯主名 ? RString.EMPTY : 世帯主名.getColumnValue().concat(世帯主敬称);
            }
            if (null != param.get施設情報()) {
                AtenaMeisho shisetsuatena = param.get施設情報().getShisetsuAtena();
                施設宛名 = null == shisetsuatena ? RString.EMPTY : shisetsuatena.getColumnValue();
                施設名称 = param.get施設情報().getShisetsuName();
            }
            edit印字処理(groupSource, 本人敬称, 世帯主敬称, 宛名ID, 名称, 施設宛名, 施設名称, value21, value31, source);
        }
    }

    private void edit印字処理(AtenaSealGroupSource groupSource, RString 本人敬称, RString 世帯主敬称,
            RString 宛名ID, RString 名称, RString 施設宛名, RString 施設名称, RString value21, RString value31, AtenaSeal12Source source) {
        switch (data.get画面ID().toString()) {
            case "AFAGME6030":
                switch (宛名ID.toString()) {
                    case "1":
                        RString total_shisetsuValue = changeNullToEmpty(施設名称)
                                .concat(本人敬称);
                        edit宛名編集(total_shisetsuValue, groupSource, source);
                        break;
                    case "2":
                        RString total_shisetsuAtenaValue = 施設宛名.concat(本人敬称);
                        edit宛名編集(total_shisetsuAtenaValue, groupSource, source);
                        break;
                    case "3":
                        RString totalvalue1 = changeNullToEmpty(施設名称)
                                .concat(世帯主敬称);
                        RString totalvalue2 = 施設宛名.concat(本人敬称);
                        edit宛名編集2(totalvalue1, totalvalue2, groupSource);
                        break;
                    default:
                }
                break;
            case "AFAGME6020":
                RString totalAtenaValue = 名称.concat(本人敬称);
                edit転出者宛名シール宛名処理(totalAtenaValue, groupSource, source);
                break;
            case "AFAGME6010":
                switch (宛名ID.toString()) {
                    case "1":
                        RString value = 名称.concat(本人敬称);
                        edit宛名編集(value, groupSource, source);
                        break;
                    case "2":
                        RString value22 = 名称.concat(本人敬称);
                        edit宛名編集2(value21, value22, groupSource);
                        break;
                    case "3":
                        RString value32 = 名称.concat(本人敬称);
                        edit宛名編集2(value31, value32, groupSource);
                        break;
                    default:
                }
                break;
            case "AFAGMB2010":
            case "AFAGMA1010":
            case "AFAGMA1030":
            case "AFAGMB1010":
            case "AFAGMB1040":
            case "AFAGMG1010":
            case "AFAGMG1060":
            case "AFAGMK1030":
            case "AFAGMK1040":
                RString comprehensiveValue = 名称.concat(様);
                edit宛名編集(comprehensiveValue, groupSource, source);
                break;
            default:
        }

    }

    private void edit宛名編集(RString value, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value.length() > (長さ_小宛名_上段 + 長さ_小宛名_下段)) {
            groupSource.setAtenala(value.substring(0, 長さ_小宛名_上段));
            groupSource.setAtenalb(value.substring(長さ_小宛名_上段, (長さ_小宛名_上段 + 長さ_小宛名_下段)));
            source.meishoList = value;
            groupSource.setMeishoList(value);
        } else {
            if (value.length() > (長さ_宛名_上段 + 長さ_宛名_下段)) {
                if (value.length() <= 長さ_小宛名_上段) {
                    groupSource.setAtenalb(RString.EMPTY);
                    groupSource.setAtenala(value);
                } else {
                    groupSource.setAtenala(value.substring(0, 長さ_小宛名_上段));
                    groupSource.setAtenalb(value.substring(長さ_小宛名_上段));
                }
            } else {
                if (value.length() <= 長さ_宛名_下段) {
                    groupSource.setAtenaa(RString.EMPTY);
                    groupSource.setAtenab(value);
                } else if (value.length() <= 長さ_宛名_上段) {
                    groupSource.setAtenaa(value);
                    groupSource.setAtenab(RString.EMPTY);
                } else {
                    groupSource.setAtenaa(value.substring(0, 長さ_宛名_上段));
                    groupSource.setAtenab(value.substring(長さ_宛名_上段));
                }
            }
        }
    }

    private void edit宛名編集2(RString value1, RString value2, AtenaSealGroupSource groupSource) {
        if (value1.length() > 長さ_小宛名_上段 || value2.length() > 長さ_小宛名_下段) {
            if (is文字切れ(長さ_小宛名_下段, value2)) {
                groupSource.setAtenalb(value2.substring(0, 長さ_小宛名_下段));
                groupSource.setMeishoList(value2);
            } else {
                groupSource.setAtenalb(value2);
            }
            if (is文字切れ(長さ_小宛名_上段, value1)) {
                groupSource.setAtenala(value1.substring(0, 長さ_小宛名_上段));
                groupSource.setMeishoList(value1);
            } else {
                groupSource.setAtenala(value1);
            }
        } else if (value1.length() > 長さ_宛名_上段 || value2.length() > 長さ_宛名_下段) {
            groupSource.setAtenala(value1);
            groupSource.setAtenalb(value2);
        } else {
            groupSource.setAtenab(value2);
            groupSource.setAtenaa(value1);
        }
    }

    private void edit隅の項目印字処理(AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != param && null != param.get画面情報()) {
            switch (data.get画面ID().toString()) {
                case "AFAGME6020":
                    groupSource.setKoumokua(edit転出者宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_左下隅_コード())));
                    groupSource.setKoumokub(edit転出者宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_右下隅_コード())));
                    groupSource.setKoumokuc(edit転出者宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_右上隅_コード())));
                    break;
                case "AFAGME6010":
                    groupSource.setKoumokua(edit選挙人宛名シール隅の項目処理(param, param.get画面情報()
                            .get四隅項目_左下隅_コード()));
                    groupSource.setKoumokub(edit選挙人宛名シール隅の項目処理(param, param.get画面情報()
                            .get四隅項目_右下隅_コード()));
                    groupSource.setKoumokuc(edit選挙人宛名シール隅の項目処理(param, param.get画面情報()
                            .get四隅項目_右上隅_コード()));
                    break;
                case "AFAGME6030":
                    groupSource.setKoumokua(edit施設宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_左下隅_コード())));
                    groupSource.setKoumokub(edit施設宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_右下隅_コード())));
                    groupSource.setKoumokuc(edit施設宛名シール隅の項目処理(param, changeNullToEmpty(param.get画面情報()
                            .get四隅項目_右上隅_コード())));
                    break;
                case "AFAGMB2010":
                case "AFAGMA1010":
                case "AFAGMA1030":
                case "AFAGMB1010":
                case "AFAGMB1040":
                case "AFAGMG1010":
                case "AFAGMG1060":
                case "AFAGMK1030":
                case "AFAGMK1040":
                    groupSource.setKoumokua(RString.EMPTY);
                    groupSource.setKoumokub(RString.EMPTY);
                    groupSource.setKoumokuc(RString.EMPTY);
                    break;
                default:
            }
        }
    }

    private RString edit選挙人宛名シール隅の項目処理(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        if (コード.toString().compareTo("00") >= 0) {
            if (コード.toString().compareTo("08") <= 0) {
                edit選挙人隅の項目処理1(param, コード);
            } else if (コード.toString().compareTo("16") <= 0) {
                edit選挙人隅の項目処理2(param, コード);
            }
        }
        return returnValue;
    }

    private RString edit選挙人隅の項目処理1(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        ChoikiCode 住登内町域コード = ChoikiCode.EMPTY;
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        GyoseikuCode 行政区コード = GyoseikuCode.EMPTY;
        SetaiCode 世帯コード = SetaiCode.EMPTY;
        ChikuCode 地区コード２ = ChikuCode.EMPTY;
        ChikuCode 地区コード１ = ChikuCode.EMPTY;
        ChikuCode 地区コード３ = ChikuCode.EMPTY;
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            住登内町域コード = param.get投票資格情報().getAtenaPSMEntity().getJutonaiChoikiCode();
            識別コード = param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode();
            行政区コード = param.get投票資格情報().getAtenaPSMEntity().getGyoseikuCode();
            世帯コード = param.get投票資格情報().getAtenaPSMEntity().getSetaiCode();
            地区コード２ = param.get投票資格情報().getAtenaPSMEntity().getChikuCode2();
            地区コード１ = param.get投票資格情報().getAtenaPSMEntity().getChikuCode1();
            地区コード３ = param.get投票資格情報().getAtenaPSMEntity().getChikuCode3();
        }
        switch (コード.toString()) {
            case "03":
                returnValue = null == 住登内町域コード
                        ? RString.EMPTY : 住登内町域コード.getColumnValue();
                break;
            case "01":
                returnValue = null == 識別コード
                        ? RString.EMPTY : 識別コード.getColumnValue();
                break;
            case "04":
                returnValue = null == 行政区コード
                        ? RString.EMPTY : 行政区コード.getColumnValue();
                break;
            case "02":
                returnValue = null == 世帯コード
                        ? RString.EMPTY : 世帯コード.getColumnValue();
                break;
            case "06":
                returnValue = null == 地区コード２
                        ? RString.EMPTY : 地区コード２.getColumnValue();
                break;
            case "05":
                returnValue = null == 地区コード１
                        ? RString.EMPTY : 地区コード１.getColumnValue();
                break;
            case "07":
                returnValue = null == 地区コード３
                        ? RString.EMPTY : 地区コード３.getColumnValue();
                break;
            case "08":
                returnValue = param.get通し番号();
                break;
            case "00":
                break;
            default:
        }
        return returnValue;
    }

    private RString edit選挙人隅の項目処理2(AtenaSealPartParam param, RString コード) {
        RString retuValue = RString.EMPTY;

        RString retuValue1 = RString.EMPTY;
        RString retuValue2 = RString.EMPTY;
        RString retuValue3 = RString.EMPTY;
        RString retuValue4 = RString.EMPTY;
        RString retuValue5 = RString.EMPTY;
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            retuValue1 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getGyoseikuName());
            retuValue2 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getJutonaiJusho());
            retuValue3 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName2());
            retuValue4 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName1());
            retuValue5 = changeNullToEmpty(param.get投票資格情報().getAtenaPSMEntity().getChikuName3());
        }
        switch (コード.toString()) {
            case "10":
                retuValue = retuValue1;
                break;
            case "09":
                retuValue = retuValue2;
                break;
            case "12":
                retuValue = retuValue3;
                break;
            case "11":
                retuValue = retuValue4;
                break;
            case "13":
                retuValue = retuValue5;
                break;
            case "15":
                TohyokuCode 投票区コード = param.get投票資格情報().getAtenaPSMEntity().getTohyokuCode();
                retuValue = null == 投票区コード
                        ? RString.EMPTY : 投票区コード.getColumnValue();
                break;
            case "14":
                retuValue = RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case "16":
                retuValue = edit隅編集(param);
                break;
            default:
        }
        return retuValue;
    }

    private RString edit隅編集(AtenaSealPartParam param) {
        RString returnValue = RString.EMPTY;
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            TohyokuCode 投票区コード = param.get投票資格情報().getAtenaPSMEntity().getTohyokuCode();
            returnValue = null == 投票区コード ? RString.EMPTY : 投票区コード.getColumnValue();
        }
        if (null != param.get投票資格情報().getSenkyoninMeiboEntity()) {
            returnValue = returnValue.concat(連結標識).concat(changeNullToEmpty(new RString(param.get投票資格情報()
                    .getSenkyoninMeiboEntity().getPage())))
                    .concat(連結標識).concat(changeNullToEmpty(new RString(param.get投票資格情報()
                                            .getSenkyoninMeiboEntity().getGyo())));

        }
        return returnValue;
    }

    private RString edit転出者宛名シール隅の項目処理(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        if (null != param.get投票資格情報()
                && null != param.get投票資格情報().getAtenaPSMEntity()) {
            識別コード = param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode();
        }
        switch (コード.toString()) {
            case "08":
                returnValue = changeNullToEmpty(param.get通し番号());
                break;
            case "00":
                break;
            case "16":
                returnValue = edit隅編集(param);
                break;
            case "14":
                returnValue = RDate.getNowDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                break;
            case "01":
                returnValue = null == 識別コード
                        ? RString.EMPTY : 識別コード.getColumnValue();
                break;
            default:
        }
        return returnValue;
    }

    private void edit選挙人宛名シールの住所処理1(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value1.length() > (長さ_住所_上段 + 長さ_住所_中段) || value2.length() > (長さ_住所_中段 + 長さ_住所_下段)) {
            edit項目小_住所の編集1(value1, value2, groupSource, source);
        } else {
            if (value1.length() > 長さ_住所_上段) {
                if (value2.length() > 長さ_住所_中段) {
                    edit項目小_住所の編集1(value1, value2, groupSource, source);
                } else {
                    groupSource.setJushoc(value2);
                    groupSource.setJushoa(value1.substring(0, 長さ_住所_上段));
                    groupSource.setJushob(value1.substring(長さ_住所_上段));
                }
            } else {
                if (value2.length() > 長さ_住所_中段) {
                    groupSource.setJushob(value2.substring(0, 長さ_住所_中段));
                    groupSource.setJushoc(value2.substring(長さ_住所_中段));
                } else {
                    groupSource.setJushoc(RString.EMPTY);
                    groupSource.setJushob(value2);
                }
                groupSource.setJushoa(value1);
            }
        }
    }

    private RString edit施設宛名シール隅の項目処理(AtenaSealPartParam param, RString コード) {
        RString returnValue = RString.EMPTY;
        if (null != param.get施設情報()) {
            switch (コード.toString()) {
                case "04":
                    returnValue = RDate.getNowDate().wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE)
                            .fillType(FillType.BLANK).toDateString();
                    break;
                case "02":
                    TelNo 電話番号 = param.get施設情報().getTelNo();
                    returnValue = (new RString("TEL")).concat(半角スペース)
                            .concat(null == 電話番号
                                    ? RString.EMPTY : 電話番号.getColumnValue());
                    break;
                case "01":
                    returnValue = changeNullToEmpty(param.get施設情報().getShisetsuCode());
                    break;
                case "03":
                    TelNo fAX番号 = param.get施設情報().getFaxNo();
                    returnValue = (new RString("FAX")).concat(半角スペース)
                            .concat(null == fAX番号
                                    ? RString.EMPTY : fAX番号.getColumnValue());
                    break;
                case "00":
                    break;
                default:
            }
        }
        return returnValue;
    }

    private void edit項目小_住所の編集1(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value1.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)
                || value2.length() > (長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            edit住所の編集が5行以上(value1, value2, groupSource, source);
        } else {
            if (value1.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目)) {
                if (value2.length() > (長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else if (value2.length() > 長さ_小_住所_4段目) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else {
                    groupSource.setJushold(value2);
                    groupSource.setJushola(value1.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value1.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
                    groupSource.setJusholc(value1.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
                }
            } else if (value1.length() > 長さ_小_住所_1段目) {
                if (value2.length() > (長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
                    edit住所の編集が5行以上(value1, value2, groupSource, source);
                } else if (value2.length() > 長さ_小_住所_4段目) {
                    groupSource.setJusholc(value2.substring(0, 長さ_小_住所_3段目));
                    groupSource.setJushold(value2.substring(長さ_小_住所_3段目));
                    groupSource.setJushola(value1.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value1.substring(長さ_小_住所_1段目));
                } else {
                    groupSource.setJushold(RString.EMPTY);
                    groupSource.setJusholc(value2);
                    groupSource.setJushola(value1.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholb(value1.substring(長さ_小_住所_1段目));
                }
            } else {
                if (value2.length() > (長さ_小_住所_2段目 + 長さ_小_住所_3段目)) {
                    groupSource.setJusholb(value2.substring(0, 長さ_小_住所_2段目));
                    groupSource.setJusholc(value2.substring(長さ_小_住所_2段目, (長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
                    groupSource.setJushold(value2.substring((長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
                } else if (value2.length() > 長さ_小_住所_2段目) {
                    groupSource.setJushold(RString.EMPTY);
                    groupSource.setJusholb(value2.substring(0, 長さ_小_住所_2段目));
                    groupSource.setJusholc(value2.substring(長さ_小_住所_2段目));
                } else {
                    groupSource.setJusholb(value2);
                    groupSource.setJushold(RString.EMPTY);
                    groupSource.setJusholc(RString.EMPTY);
                }
                groupSource.setJushola(value1);
            }
        }
    }

    private void edit選挙人宛名シールの住所処理2(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value1.length() > 長さ_住所_上段 || value2.length() > 長さ_住所_中段 || value3.length() > 長さ_住所_下段) {
            edit項目小_住所の編集2(value1, value2, value3, groupSource, source);
        } else {
            groupSource.setJushob(value2);
            groupSource.setJushoc(value3);
            groupSource.setJushoa(value1);
        }
    }

    private void edit小住所の編集が5行以上(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        RString totalValue = value1.concat(全角スペース).concat(value2).concat(全角スペース).concat(value3);
        if (totalValue.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            groupSource.setJushola(
                    totalValue.substring(0, 長さ_小_住所_1段目));
            groupSource.setJusholc(
                    totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目),
                            (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
            groupSource.setJushold(
                    totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目),
                            (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)));
            groupSource.setJusholb(
                    totalValue.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
            source.jushoList = totalValue;
            groupSource.setJushoList(totalValue);
        } else if (totalValue.length() <= (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            groupSource.setJusholb(
                    totalValue.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
            groupSource.setJusholc(
                    totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目),
                            (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
            groupSource.setJushold(
                    totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
            groupSource.setJushola(
                    totalValue.substring(0, 長さ_小_住所_1段目));
        }
    }

    private void editアクセスログ出力(AtenaSealPartParam param, AtenaSealGroupSource groupSource) {
        if (null != param.get投票資格情報() && null != param.get投票資格情報().getAtenaPSMEntity()) {
            groupSource.setShikibetsuCode(param.get投票資格情報().getAtenaPSMEntity().getShikibetsuCode());
        } else {
            groupSource.setShikibetsuCode(ShikibetsuCode.EMPTY);
        }
    }

    private void edit作成日時(AtenaSeal12Source source) {
        source.sakuseiYmdTime = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(全角スペース)
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分)).concat(作成);
    }

    private void edit項目小_住所の編集2(RString value1, RString value2, RString value3, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value1.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目) || value2.length() > (長さ_小_住所_2段目 + 長さ_小_住所_3段目)
                || value3.length() > (長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
        } else {
            if (value1.length() > 長さ_小_住所_1段目) {
                if (value2.length() > 長さ_小_住所_3段目
                        || value3.length() > 長さ_小_住所_4段目) {
                    edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
                } else {
                    groupSource.setJushola(value1.substring(0, 長さ_小_住所_1段目));
                    groupSource.setJusholc(value2);
                    groupSource.setJushold(value3);
                    groupSource.setJusholb(value1.substring(長さ_小_住所_1段目));
                }
            } else {
                if (value2.length() > 長さ_小_住所_2段目) {
                    if (value3.length() > 長さ_小_住所_4段目) {
                        edit小住所の編集が5行以上(value1, value2, value3, groupSource, source);
                    } else {
                        groupSource.setJusholb(value2.substring(0, 長さ_小_住所_2段目));
                        groupSource.setJusholc(value2.substring(長さ_小_住所_2段目));
                        groupSource.setJushola(value1);
                        groupSource.setJushold(value3);
                    }
                } else {
                    if (value3.length() > 長さ_小_住所_3段目) {
                        groupSource.setJusholc(value3.substring(0, 長さ_小_住所_3段目));
                        groupSource.setJushold(value3.substring(長さ_小_住所_3段目));
                    } else {
                        groupSource.setJushold(RString.EMPTY);
                        groupSource.setJusholc(value3);
                    }
                    groupSource.setJushola(value1);
                    groupSource.setJusholb(value2);
                }
            }
        }
    }

    private void edit市町村コード(AtenaSeal12Source source) {
        if (null != data.get地方公共団体情報() && null != data.get地方公共団体情報().get地方公共団体コード()) {
            source.shichosonCode = data.get地方公共団体情報().get地方公共団体コード().getColumnValue();
        }
    }

    private void edit住所の編集が5行以上(RString value1, RString value2, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        RString totalValue = value1.concat(全角スペース).concat(value2);
        if (totalValue.length() <= (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            groupSource.setJushola(totalValue.substring(0, 長さ_小_住所_1段目));
            groupSource.setJusholb(totalValue.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
            groupSource.setJusholc(totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目),
                    (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
            groupSource.setJushold(totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
        } else if (totalValue.length() > (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)) {
            groupSource.setJushola(totalValue.substring(0, 長さ_小_住所_1段目));
            groupSource.setJusholb(totalValue.substring(長さ_小_住所_1段目, (長さ_小_住所_1段目 + 長さ_小_住所_2段目)));
            groupSource.setJusholc(totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目),
                    (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目)));
            groupSource.setJushold(totalValue.substring((長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目),
                    (長さ_小_住所_1段目 + 長さ_小_住所_2段目 + 長さ_小_住所_3段目 + 長さ_小_住所_4段目)));
            source.jushoList = totalValue;
            groupSource.setJushoList(totalValue);
        }
    }

    private void edit市町村名(AtenaSeal12Source source) {
        if (null != data.get地方公共団体情報()) {
            source.shichosonMei = data.get地方公共団体情報().get市町村名();
        }
    }

    private void edit転出者宛名シール宛名処理(RString value, AtenaSealGroupSource groupSource, AtenaSeal12Source source) {
        if (value.length() > (長さ_宛名_上段 + 長さ_宛名_下段)) {
            if (value.length() > (長さ_小宛名_上段 + 長さ_小宛名_下段)) {
                groupSource.setAtenala(value.substring(0, 長さ_小宛名_上段));
                groupSource.setAtenalb(value.substring(長さ_小宛名_上段, (長さ_小宛名_上段 + 長さ_小宛名_下段)));
                source.meishoList = value;
                groupSource.setMeishoList(value);
            } else {
                if (value.length() <= 長さ_小宛名_上段) {
                    groupSource.setAtenalb(RString.EMPTY);
                    groupSource.setAtenala(value);
                } else {
                    groupSource.setAtenala(value.substring(0, 長さ_小宛名_上段));
                    groupSource.setAtenalb(value.substring(長さ_小宛名_上段));
                }
            }
        } else {
            if (value.length() <= 長さ_宛名_上段) {
                groupSource.setAtenab(RString.EMPTY);
                groupSource.setAtenaa(value);
            } else {
                groupSource.setAtenaa(value.substring(0, 長さ_宛名_上段));
                groupSource.setAtenab(value.substring(長さ_宛名_上段));
            }
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

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(AtenaSeal12Source.class, itemName);
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
