package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link NijuTorokuTsuchishoCommonSource}を編集します。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
public class NijuTorokuTsuchishoEditor implements INijuTorokuTsuchishoEditor {

    private final RString 二重登録通知_発行番号_第 = new RString("選　号　外");
    private final RString 印字する = new RString("1");

    private final NijuTorokuTsuchishoParameter target;
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param target {@link NijuTorokuTsuchishoParameter}
     */
    public NijuTorokuTsuchishoEditor(NijuTorokuTsuchishoParameter target) {
        this.target = target;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getAtenaPSMEntity());
    }

    @Override
    public NijuTorokuTsuchishoCommonSource edit(NijuTorokuTsuchishoCommonSource source) {

        source.tennyuMotoYubinNo = get転入元郵便番号();
        set転入元市町村名(source);
        source.hakkoDaino = get発行第番号();
        source.hakkoYmd = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        set市町村名(source);
        set委員長名(source);
        source.koinShoryaku = get公印省略();
        source.todokedeKaishiYmd = target.get転入期間_開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.todokedeShuryoYmd = target.get転入期間_終了日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.shichosonKubunMei = get市町村区分名();
        source.senkyoMeisho = target.get選挙名称();
        set名称(source);
        source.listYmd_1 = get生年月日();
        source.listYmd_2 = 宛名識別対象.to個人().get性別().getCommonName();
        source.listYmd_3 = 宛名識別対象.to個人().get登録届出年月日()
                .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        set住所(source);
        source.tennyuMotoPageCount = target.getPage();
        source.barcodeCustombarcode = getカスタマーバーコード();
        source.tennyuZanTop5 = target.get転入前全国住所コード上5桁(target.get選挙人資格の情報());
        source.shikibetsuCode = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getShikibetsuCode().value();
        source.layout = target.getLayoutIndex();

        editログの出力(source);
        return source;
    }

    private void editログの出力(NijuTorokuTsuchishoCommonSource source) {
        source.識別コード1 = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get転入元郵便番号() {
        if (印字する.equals(BusinessConfig.get(ConfigKeysAFA.二重登録_印字有無_カスタマーバーコード,
                SubGyomuCode.AFA選挙本体)) && null != target.get他市町村送付先()) {
            return target.get他市町村送付先().get郵便番号().getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private void set転入元市町村名(NijuTorokuTsuchishoCommonSource source) {
        int 転入元市町村名1最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("tennyuMotoShichosonMei1"));
        int 転入元市町村名2最大文字数 = ReportDataInfoLoader
                .getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("tennyuMotoShichosonMei2"));
        RString 都道府県名 = target.get選挙人資格の情報().get導入団体都道府県名();
        if (!RString.isNullOrEmpty(都道府県名)) {
            RString 転入元市町村名 = 都道府県名.concat(target.get選挙人資格の情報().get導入団体市区町村名());
            List<RString> 名称List = this.set名区分(転入元市町村名, 転入元市町村名1最大文字数, 転入元市町村名2最大文字数);
            source.tennyuMotoShichosonMei1 = 名称List.get(0);
            source.tennyuMotoShichosonMei2 = 名称List.get(1);
        }
    }

    private RString get発行第番号() {
        RString 号 = target.get発行番号_号();
        RString 番号 = target.get発行番号_番号();
        RString 第 = target.get発行番号_第();
        if (第.equals(二重登録通知_発行番号_第)) {
            return 二重登録通知_発行番号_第;
        } else {
            return 第.concat(番号).concat(号);
        }

    }

    private void set市町村名(NijuTorokuTsuchishoCommonSource source) {
        RString 都道府県名 = target.get選挙人資格の情報().get全国住所都道府県名();
        if (!RString.isNullOrEmpty(都道府県名)) {
            int 市町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("shichosonMei1"));
            int 市町村名2最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("shichosonMei2"));
            RString 市町村名 = 都道府県名.concat(target.get選挙人資格の情報().get全国住所市区町村名());
            List<RString> 名称List = this.set名区分(市町村名, 市町村名1最大文字数, 市町村名2最大文字数);
            source.shichosonMei1 = 名称List.get(0);
            source.shichosonMei2 = 名称List.get(1);
        }
    }

    private void set委員長名(NijuTorokuTsuchishoCommonSource source) {
        RString 委員長名 = new RString("委員長　").concat(BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名,
                SubGyomuCode.AFA選挙本体));
        int 委員長名1最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("iinchomei1"));
        if (委員長名.length() <= 委員長名1最大文字数) {
            source.iinchomei1 = 委員長名;
            source.iinchomei2 = RString.EMPTY;
        } else {
            source.iinchomei1 = 委員長名.substring(0, 委員長名1最大文字数);
            source.iinchomei2 = 委員長名.substring(委員長名1最大文字数, 委員長名.length() - 委員長名1最大文字数);
        }

    }

    private RString get公印省略() {
        RString 公印省略 = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, SubGyomuCode.AFA選挙本体);
        if (公印省略.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 公印省略;
        }
    }

    private RString get市町村区分名() {
        RString 市区町村名 = target.get選挙人資格の情報().get全国住所市区町村名();
        if (RString.isNullOrEmpty(市区町村名)) {
            return RString.EMPTY;
        }
        return new RString("当").concat(市区町村名.substring(市区町村名.length() - 1, 市区町村名.length()));
    }

    private void set名称(NijuTorokuTsuchishoCommonSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("listShimei1_1"));
        RString 名称 = 宛名識別対象.to個人().get名称().getName().value();
        source.shiMei = 名称;
        if (名称.length() <= 名称最大文字数) {
            source.listShimei2_1 = RString.EMPTY;
            source.listShimei1_1 = 名称;
            source.listShimei3_1 = RString.EMPTY;

        } else if (名称.length() > 名称最大文字数 && 名称.length() <= 名称最大文字数 * 2) {
            source.listShimei2_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei1_1 = RString.EMPTY;
            source.listShimei3_1 = 名称.substring(名称最大文字数);
        } else {
            source.listShimei2_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei1_1 = RString.EMPTY;
            source.listShimei3_1 = 名称.substring(名称最大文字数, 名称最大文字数 * 2);
        }
    }

    private RString get生年月日() {
        if (宛名識別対象.to個人().get住民種別().getCode().equals(new RString("2"))) {
            return 宛名識別対象.to個人().get生年月日()
                    .toFlexibleDate().seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        } else {
            return 宛名識別対象.to個人().get生年月日()
                    .toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
    }

    private void set住所(NijuTorokuTsuchishoCommonSource source) {
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(NijuTorokuTsuchishoCommonSource.class, new RString("listJusho1_1"));
        RString 転入前住所 = 宛名識別対象.to個人().get転入前().get住所();
        RString 転入前番地 = 宛名識別対象.to個人().get転入前().get番地().getBanchi().value();
        RString 転入前方書 = 宛名識別対象.to個人().get転入前().get方書().value();
        RString 住所 = 転入前住所.concat(転入前番地).concat(転入前方書);
        source.juSho = 住所;
        if (住所.length() <= 住所最大文字数) {
            source.listJusho2_1 = RString.EMPTY;
            source.listJusho1_1 = 住所;
            source.listJusho3_1 = RString.EMPTY;

        } else if (住所.length() > 住所最大文字数 && 住所.length() <= 住所最大文字数 * 2) {
            source.listJusho2_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho1_1 = RString.EMPTY;
            source.listJusho3_1 = 住所.substring(住所最大文字数);
        } else {
            source.listJusho2_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho1_1 = RString.EMPTY;
            source.listJusho3_1 = 住所.substring(住所最大文字数, 住所最大文字数 * 2);
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

    private List<RString> set名区分(RString 名称, int 名称1最大文字数, int 名称2最大文字数) {
        List<RString> 名称List = new ArrayList<>();
        RString 名称1, 名称2;
        if (名称.length() <= 名称1最大文字数) {
            名称1 = 名称;
            名称2 = RString.EMPTY;
        } else if (名称.length() <= 名称2最大文字数) {
            名称1 = RString.EMPTY;
            名称2 = 名称;
        } else if (名称.length() > 名称2最大文字数 && 名称.length() <= 名称2最大文字数 + 名称1最大文字数) {
            名称1 = 名称.substring(名称2最大文字数);
            名称2 = 名称.substring(0, 名称2最大文字数);
        } else {
            名称1 = 名称.substring(名称2最大文字数, 名称2最大文字数 + 名称1最大文字数);
            名称2 = 名称.substring(0, 名称2最大文字数);
        }
        名称List.add(名称1);
        名称List.add(名称2);
        return 名称List;
    }

}
