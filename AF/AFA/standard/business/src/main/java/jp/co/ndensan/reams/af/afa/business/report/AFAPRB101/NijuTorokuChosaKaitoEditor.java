/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_使用しない;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_冊区分管理_性別を冊区分とする;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101.NijuTorokuChosaKaitoSource;
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
 * {@link NijuTorokuChosaKaitoSource}を編集します。
 *
 * @reamsid_L AF-0030-034 liss
 */
public class NijuTorokuChosaKaitoEditor implements INijuTorokuChosaKaitoEditor {

    private static final RString 印字 = new RString("1");
    private static final RString 郵便標識 = new RString("〒");
    private static final RString ー = new RString("-");

    private static final int 数字2 = 2;
    private static final int 数字4 = 4;
    private static final int 数字6 = 6;

    private final NijuTorokuChosaKaitoParameter item;
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link NijuTorokuChosaKaitoParameter}
     */
    public NijuTorokuChosaKaitoEditor(NijuTorokuChosaKaitoParameter item) {
        this.item = item;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(item.getEntity().getShikibetsuTaishoEntity());
    }

    @Override
    public NijuTorokuChosaKaitoSource edit(NijuTorokuChosaKaitoSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(NijuTorokuChosaKaitoSource source) {
        if (new RString("1").equals(item.getPage())) {
            source.tenshutsuMotoYubinNo = get転出元郵便番号();
            set転出元市町村名(source);
            source.barcodeCustombarcode = getカスタマーバーコード();
            source.hakkoNengo = get発行年号();
            set市町村名(source);
            source.koteibun01 = get固定文１();

        } else {
            source.tenshutsuMotoShichosonMei = get転出元市町村名();
            source.hakkoYmd = get発行日();
        }
    }

    private void editログの出力(NijuTorokuChosaKaitoSource source) {
        source.識別コード1 = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private void set明細(NijuTorokuChosaKaitoSource source) {
        set氏名(source);
        source.listSeibetsu_1 = get性別();
        source.listYmd1_1 = get生年月日();
        source.listYmd1_2 = get転出年月日();
        source.listYmd2_1 = RString.EMPTY;
        source.listYmd2_2 = RString.EMPTY;
        set住所(source);
        source.listNo1_1 = get名簿番号();
        source.listNo2_1 = item.getEntity().getSenkyoShikakuEntity().getShikibetsuCode().value();
        source.tenshutsuMotoPageCount = item.getPage();
        source.allPage = item.getAllPage();
        source.layout = item.getLayoutIndex();
        source.shikibetsuCode = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode().value();

    }

    private void setフッタ(NijuTorokuChosaKaitoSource source) {
        if (new RString("1").equals(item.getPage())) {
            source.koteibun11 = get固定文フッタ1();
            source.koteibun12 = get固定文フッタ2();
        }
    }

    private RString get転出元郵便番号() {
        if (印字.equals(BusinessConfig.get(ConfigKeysAFA.二重登録_印字有無_カスタマーバーコード, SubGyomuCode.AFA選挙本体))) {
            return 郵便標識.concat(item.get転出先郵便番号());
        }
        return RString.EMPTY;
    }

    private RString get転出元市町村名() {
        Association association = item.get導入団体();
        if (null == association) {
            return RString.EMPTY;
        } else {
            return association.get都道府県名().concat(association.get市町村名());
        }

    }

    private void set転出元市町村名(NijuTorokuChosaKaitoSource source) {
        Association association = item.get導入団体();
        if (null == association) {
            source.tenshutsuMotoShichosonMei1 = RString.EMPTY;
            source.tenshutsuMotoShichosonMei2 = RString.EMPTY;
        } else {
            int 市町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("tenshutsuMotoShichosonMei1"));
            int 市町村名2最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("tenshutsuMotoShichosonMei2"));
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

    private RString get発行年号() {
        RString 発行年 = RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getYear();
        RString 元号 = 発行年.substring(0, 2);
        RString 年 = 発行年.substring(2);
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        rsb.append(元号).append(new RString("（")).append(年).append(new RString("）"));
        return rsb.toRString();
    }

    private RString get発行日() {
        return RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void set市町村名(NijuTorokuChosaKaitoSource source) {
        RString 転出先市町村名 = item.get転出先市町村名();
        int 転出先市町村名1最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("tenshutsuSakiShichosonMei1"));
        int 転出先市町村名2最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("tenshutsuSakiShichosonMei2"));
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

    private RString get固定文１() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_回答.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０１.getCode()));
    }

    private void set氏名(NijuTorokuChosaKaitoSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("listShimei_1"));
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
                    .toFlexibleDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get性別() {
        return 宛名識別対象.to個人().get性別().getCommonName();
    }

    private RString get転出年月日() {
        return 宛名識別対象.to個人().get消除異動年月日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void set住所(NijuTorokuChosaKaitoSource source) {
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        rsb.append(宛名識別対象.to個人().get転出確定().get住所());
        rsb.append(宛名識別対象.to個人().get転出確定().get番地().getBanchi().value());
        rsb.append(RString.FULL_SPACE);
        rsb.append(宛名識別対象.to個人().get転出確定().get方書().value());
        RString 住所 = rsb.toRString();
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuChosaKaitoSource.class, new RString("listJusho_1"));
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
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_回答.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_１１.getCode()));
    }

    private RString get固定文フッタ2() {
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_二重登録調査票_回答.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_１２.getCode()));
    }

    private RString get名簿番号() {
        RString 抄本_冊区分管理 = BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体);
        RString 投票区コード = item.getEntity().getSenkyoninMeiboEntity().getTohyokuCode().padLeft(数字4);
        RString 冊 = item.getEntity().getSenkyoninMeiboEntity().getSatsu().padLeft(数字2);
        RString 頁 = new RStringBuilder().append(item.getEntity().getSenkyoninMeiboEntity().getPage()).toRString().padLeft(数字6);
        RString 行 = new RStringBuilder().append(item.getEntity().getSenkyoninMeiboEntity().getGyo()).toRString().padLeft(数字2);
        RStringBuilder rsb = new RStringBuilder(RString.EMPTY);
        if (抄本_冊区分管理.equals(抄本_冊区分管理_使用しない.getValue())) {
            rsb.append(投票区コード).append(ー).append(頁).append(ー).append(行);
        }
        if (抄本_冊区分管理.equals(抄本_冊区分管理_性別を冊区分とする.getValue())) {
            rsb.append(投票区コード).append(ー).append(冊).append(ー).append(頁).append(ー).append(行);
        }
        return rsb.toRString();
    }

}
