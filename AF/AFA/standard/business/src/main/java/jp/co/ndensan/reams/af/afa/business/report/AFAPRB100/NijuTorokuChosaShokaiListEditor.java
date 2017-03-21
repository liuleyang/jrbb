/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB100.NijuTorokuChosaShokaiSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link NijuTorokuChosaShokaiSource}を編集します。
 *
 * @reamsid_L AF-0030-033 liss
 */
public class NijuTorokuChosaShokaiListEditor implements INijuTorokuChosaShokaiListEditor {

    private static final RString 印字 = new RString("1");
    private static final RString 郵便標識 = new RString("〒");
    private static final RString 執行文字 = new RString("執行");
    private static final RString 委員長 = new RString("委員長　");
    private static final RString 他 = new RString("　他");
    private static final RString 第_選号外 = new RString("選　号　外");

    private final NijuTorokuChosaShokaiParameter item;
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link NijuTorokuChosaShokaiParameter}
     */
    public NijuTorokuChosaShokaiListEditor(NijuTorokuChosaShokaiParameter item) {
        this.item = item;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(item.getEntity().getShikibetsuTaishoEntity());
    }

    @Override
    public NijuTorokuChosaShokaiSource edit(NijuTorokuChosaShokaiSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(NijuTorokuChosaShokaiSource source) {
        if (new RString("1").equals(item.getPage())) {
            source.tenshutsuSakiYubinNo = get転出先郵便番号();
            set転出先市町村名(source);
            source.barcodeCustombarcode = getカスタマーバーコード();
            source.hakkoDaino = get発行第番号();
            set市町村名(source);
            set委員長名(source);
            source.koinShoryaku = get公印省略();
            source.todokedeKaishiYmd = get開始年月日();
            source.todokedeShuryoYmd = get終了年月日();
            source.koteibun01 = get固定文１();
            source.koteibun02 = get固定文２();
            source.koteibun03 = get固定文３();
            source.koteibun04 = get固定文４();

        } else {
            source.tenshutsuSakiShichosonMei = get転出先市町村名();

        }
        source.hakkoYmd = get発行日();
        source.tohyoYmd = get投票年月日().concat(執行文字);
        source.senkyoMeisho = get選挙名称();
    }

    private void set明細(NijuTorokuChosaShokaiSource source) {
        set氏名(source);
        source.listYmd_1 = get生年月日();
        source.listYmd_2 = get性別();
        source.listYmd_3 = get転出年月日();
        set住所(source);
        source.tennyuMotoPageCount = item.getPage();
        source.shikibetsuCode = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode().value();
        source.layout = item.getLayoutIndex();
        source.allPage = item.getAllPage();
    }

    private void setフッタ(NijuTorokuChosaShokaiSource source) {
        if (new RString("1").equals(item.getPage())) {
            source.koteibunD1 = get固定文フッタ1();
            source.koteibunD2 = get固定文フッタ2();
        }
    }

    private void editログの出力(NijuTorokuChosaShokaiSource source) {
        source.識別コード1 = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get転出先郵便番号() {
        if (印字.equals(BusinessConfig.get(ConfigKeysAFA.二重登録_印字有無_カスタマーバーコード, SubGyomuCode.AFA選挙本体))) {
            return 郵便標識.concat(item.get転出先郵便番号());
        }
        return RString.EMPTY;
    }

    private RString get転出先市町村名() {
        return item.get転出先市町村名();

    }

    private void set転出先市町村名(NijuTorokuChosaShokaiSource source) {
        RString 転出先市町村名 = item.get転出先市町村名();
        int 転出先市町村名1最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("tenshutsuSakiShichosonMei1"));
        int 転出先市町村名2最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("tenshutsuSakiShichosonMei2"));
        if (転出先市町村名.length() <= 転出先市町村名1最大文字数) {
            source.tenshutsuSakiShichosonMei1 = 転出先市町村名;
            source.tenshutsuSakiShichosonMei2 = RString.EMPTY;
        } else if (転出先市町村名.length() <= 転出先市町村名1最大文字数 + 転出先市町村名2最大文字数) {
            source.tenshutsuSakiShichosonMei2 = 転出先市町村名;
            source.tenshutsuSakiShichosonMei1 = RString.EMPTY;
        } else {
            source.tenshutsuSakiShichosonMei2 = 転出先市町村名.substring(0, 転出先市町村名2最大文字数 + 転出先市町村名2最大文字数);
            source.tenshutsuSakiShichosonMei1 = 転出先市町村名.substring(転出先市町村名2最大文字数 + 転出先市町村名2最大文字数);
        }
    }

    private RString getカスタマーバーコード() {
        if (BusinessConfig.get(ConfigKeysAFA.二重登録_印字有無_カスタマーバーコード,
                SubGyomuCode.AFA選挙本体).equals(new RString("1"))) {
            CustomerBarCode barcode = new CustomerBarCode();
            CustomerBarCodeResult result = barcode
                    .convertCustomerBarCode(宛名識別対象.to個人().get住所().get郵便番号().getYubinNo(),
                            宛名識別対象.to個人().get住所().get住所());
            return result.getCustomerBarCode();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get発行第番号() {
        if (第_選号外.equals(BusinessConfig.get(ConfigKeysAFA.二重登録調査_発行番号_第, SubGyomuCode.AFA選挙本体))) {
            return 第_選号外;
        }
        RString 号 = item.get発行番号_号();
        RString 番号 = item.get発行番号_番号();
        RString 第 = item.get発行番号_第();
        return 第.concat(番号).concat(号);
    }

    private RString get発行日() {
        return RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void set市町村名(NijuTorokuChosaShokaiSource source) {
        Association association = item.get導入団体();
        if (null == association) {
            source.tenshutsuMotoShichosonMei1 = RString.EMPTY;
            source.tenshutsuMotoShichosonMei2 = RString.EMPTY;
        } else {
            int 市町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("tenshutsuMotoShichosonMei1"));
            int 市町村名2最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("tenshutsuMotoShichosonMei2"));
            RString 市町村名 = association.get都道府県名().concat(association.get市町村名());
            List<RString> 名称List = this.set名区分(市町村名, 市町村名1最大文字数, 市町村名2最大文字数);
            source.tenshutsuMotoShichosonMei1 = 名称List.get(0);
            source.tenshutsuMotoShichosonMei2 = 名称List.get(1);
        }
    }

    private List<RString> set名区分(RString 名称, int 名称1最大文字数, int 名称2最大文字数) {
        List<RString> 名称List = new ArrayList<>();
        RString 名称1, 名称2;
        if (名称.length() <= 名称1最大文字数) {
            名称1 = 名称;
            名称2 = RString.EMPTY;
        } else if (名称.length() <= 名称2最大文字数) {
            名称1 = RString.EMPTY;
            名称2 = 名称;
        } else {
            名称1 = 名称.substring(名称2最大文字数);
            名称2 = 名称.substring(0, 名称2最大文字数);
        }
        名称List.add(名称1);
        名称List.add(名称2);
        return 名称List;
    }

    private void set委員長名(NijuTorokuChosaShokaiSource source) {
        RString 委員長名 = 委員長.concat(BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体));
        int 委員長名1最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("iinchoMei1"));
        if (委員長名.length() <= 委員長名1最大文字数) {
            source.iinchoMei1 = 委員長名;
            source.iinchoMei2 = RString.EMPTY;
        } else {
            source.iinchoMei1 = 委員長名.substring(0, 委員長名1最大文字数);
            source.iinchoMei2 = 委員長名.substring(委員長名1最大文字数, 委員長名.length());
        }
    }

    private RString get公印省略() {
        return BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
    }

    private RString get開始年月日() {
        return item.get転出期間_開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString get終了年月日() {
        return item.get転出期間_終了日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

    }

    private RString get固定文１() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０１.getCode()));
    }

    private RString get固定文２() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０２.getCode()));

    }

    private RString get固定文３() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０３.getCode()));

    }

    private RString get固定文４() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０４.getCode()));

    }

    private RString get投票年月日() {
        if (item.getEntity().getShohonEntity().getTohyoYMD() != null) {
            return NullHandler.getNullToFlexibleDate(item.getEntity().getShohonEntity().getTohyoYMD()).wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get選挙名称() {
        RString 選挙名称 = NullHandler.getNullToRString(item.getEntity().getSenkyoEntity().getSenkyoName());
        if (item.getEntity().getSenkyoAmount() == 1) {
            return 選挙名称;
        } else if (item.getEntity().getSenkyoAmount() > 1) {
            return 選挙名称.concat(他);
        }
        return RString.EMPTY;
    }

    private void set氏名(NijuTorokuChosaShokaiSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("listShimei_1"));
        RString 名称 = 宛名識別対象.to個人().get名称().getName().value();
        source.shiMei = 名称;
        if (名称.length() <= 名称最大文字数) {
            source.listShimei1_1 = RString.EMPTY;
            source.listShimei_1 = 名称;
            source.listShimei2_1 = RString.EMPTY;

        } else if (名称.length() > 名称最大文字数 && 名称.length() <= 名称最大文字数 * 2) {
            source.listShimei1_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei_1 = RString.EMPTY;
            source.listShimei2_1 = 名称.substring(名称最大文字数);
        } else {
            source.listShimei1_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei_1 = RString.EMPTY;
            source.listShimei2_1 = 名称.substring(名称最大文字数, 名称最大文字数 * 2);
        }
    }

    private RString get生年月日() {
        if (宛名識別対象.to個人().get住民種別().getCode().equals(new RString("2"))
                || 宛名識別対象.to個人().get住民種別().getCode().equals(new RString("4"))) {
            return 宛名識別対象.to個人().get生年月日()
                    .toFlexibleDate().seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else {
            return 宛名識別対象.to個人().get生年月日()
                    .toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get性別() {
        return 宛名識別対象.to個人().get性別().getCommonName();
    }

    private RString get転出年月日() {
        return 宛名識別対象.to個人().get消除異動年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private void set住所(NijuTorokuChosaShokaiSource source) {
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        rsb.append(宛名識別対象.to個人().get転出確定().get住所());
        rsb.append(宛名識別対象.to個人().get転出確定().get番地().getBanchi().value());
        rsb.append(RString.FULL_SPACE);
        rsb.append(宛名識別対象.to個人().get転出確定().get方書().value());
        RString 住所 = rsb.toRString();
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaShokaiSource.class, new RString("listJusho_1"));
        source.juSho = 住所;
        if (住所.length() <= 住所最大文字数) {
            source.listJusho1_1 = RString.EMPTY;
            source.listJusho_1 = 住所;
            source.listJusho2_1 = RString.EMPTY;
        } else if (住所.length() <= 住所最大文字数 * 2) {
            source.listJusho1_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho_1 = RString.EMPTY;
            source.listJusho2_1 = 住所.substring(住所最大文字数);
        } else {
            source.listJusho1_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho_1 = RString.EMPTY;
            source.listJusho2_1 = 住所.substring(住所最大文字数, 住所最大文字数 * 2);
        }
    }

    private RString get固定文フッタ1() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_１１.getCode()));
    }

    private RString get固定文フッタ2() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_１２.getCode()));
    }
}
