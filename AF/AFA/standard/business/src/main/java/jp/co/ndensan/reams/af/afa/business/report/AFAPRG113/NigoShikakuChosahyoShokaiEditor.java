/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG113;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG113.NigoShikakuChosahyoShokaiSource;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link NigoShikakuChosahyoShokaiSource}を編集します。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
public class NigoShikakuChosahyoShokaiEditor implements INigoShikakuChosahyoShokaiEditor {

    private static final RString 郵便標識 = new RString("〒");
    private static final RString 第_選号外 = new RString("選　号　外");
    private static final RString REPLACE_STR1 = new RString("%1");
    private static final RString REPLACE_STR2 = new RString("%2");
    private final NigoShikakuChosahyoShokaiParameter item;
    private final IdouSenkyoninIchiran 異動選挙人一覧;
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param item {@link NigoShikakuChosahyoShokaiParameter}
     */
    public NigoShikakuChosahyoShokaiEditor(NigoShikakuChosahyoShokaiParameter item) {
        this.item = item;
        this.異動選挙人一覧 = new IdouSenkyoninIchiran();
        this.宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(item.getEntity().getShikibetsuTaishoEntity());
    }

    @Override
    public NigoShikakuChosahyoShokaiSource edit(NigoShikakuChosahyoShokaiSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(NigoShikakuChosahyoShokaiSource source) {
        source.yubinNo = get転出先郵便番号();
        set転入元市町村名(source);
        source.hakkoDaino = get発行第番号();
        source.hakkoYmd = formatパターン12(item.get発行年月日());
        set現市区町村名(source);
        source.koinShoryaku = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, RDate.getNowDate(), SubGyomuCode.AFA選挙本体);
        source.barcodeCustombarcode = getカスタマーバーコード();
        set固定文(source);
    }

    private void set明細(NigoShikakuChosahyoShokaiSource source) {
        source.cityKubun = get現市区町村区分名称();
        source.motoCityKubun = RString.isNullOrEmpty(item.get市区町村名()) ? RString.EMPTY
                : item.get市区町村名().substring(item.get市区町村名().length() - 1);
        set氏名(source);
        source.listSeinengappi_1 = get生年月日();
        source.listSeinengappi_2 = get性別();
        set当住所(source);
        set転出元住所(source);
        source.listYmd_1 = formatパターン12(宛名識別対象.to個人().get登録届出年月日());
        source.listYmd_2 = formatパターン12(宛名識別対象.to個人().get登録異動年月日());
        source.shikibetsuCode = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode().value();
    }

    private void setフッタ(NigoShikakuChosahyoShokaiSource source) {
        source.koteibunD1 = getCodeMaster(new Code(KoteibunCode.固定文コード_１１.getCode()));
        source.koteibunD2 = getCodeMaster(new Code(KoteibunCode.固定文コード_１２.getCode()));
        source.page = new RString(String.valueOf(item.getPage()));
    }

    private void editログの出力(NigoShikakuChosahyoShokaiSource source) {
        source.識別コード1 = item.getEntity().getSenkyoninMeiboEntity().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get転出先郵便番号() {
        if (AFAConfigKeysValue.国民_印字有無_カスタマーバーコード_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード)) {
            return 郵便標識.concat(item.get転入元郵便番号());
        }
        return RString.EMPTY;
    }

    private void set転入元市町村名(NigoShikakuChosahyoShokaiSource source) {
        RString 転入元市町村名 = item.get都道府県名().concat(item.get市区町村名());
        int 転入元市町村名1最大文字数 = ReportDataInfoLoader
                .getMaxLength(NigoShikakuChosahyoShokaiSource.class, new RString("tennyuMae1"));
        List<RString> 文字列List = 異動選挙人一覧.文字列分割(転入元市町村名, 転入元市町村名1最大文字数);
        if (!RString.isNullOrEmpty(文字列List.get(1))) {
            source.tennyuMae1 = 文字列List.get(1);
            source.tennyuMae2 = 文字列List.get(0);
        } else {
            source.tennyuMae1 = 文字列List.get(0);
            source.tennyuMae2 = 文字列List.get(1);
        }
    }

    private RString get発行第番号() {
        RString 第 = RString.isNullOrEmpty(item.get発行番号_第()) ? RString.EMPTY : item.get発行番号_第();
        RString 番号 = RString.isNullOrEmpty(item.get発行番号_番号()) ? RString.EMPTY : item.get発行番号_番号();
        RString 号 = RString.isNullOrEmpty(item.get発行番号_号()) ? RString.EMPTY : item.get発行番号_号();
        RString 発行第番号 = 第.concat(番号).concat(号);
        return (RString.isNullOrEmpty(発行第番号) || RString.isNullOrEmpty(発行第番号.trim())) ? 第_選号外 : 発行第番号;
    }

    private void set現市区町村名(NigoShikakuChosahyoShokaiSource source) {
        Association association = item.get導入団体();
        if (null == association) {
            source.tennyuSaki = RString.EMPTY;
        } else {
            int 最大文字数 = ReportDataInfoLoader.getMaxLength(NigoShikakuChosahyoShokaiSource.class, new RString("tennyuSaki"));
            List<RString> 文字列List = 異動選挙人一覧.文字列分割(association.get都道府県名().concat(association.get市町村名()), 最大文字数);
            source.tennyuSaki = 文字列List.get(0);
        }
    }

    private RString getカスタマーバーコード() {
        if (AFAConfigKeysValue.国民_印字有無_カスタマーバーコード_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード)) {
            CustomerBarCode barcode = new CustomerBarCode();
            CustomerBarCodeResult result = barcode
                    .convertCustomerBarCode(宛名識別対象.to個人().get住所().get郵便番号().getYubinNo(),
                            宛名識別対象.to個人().get住所().get住所());
            return result.getCustomerBarCode();
        } else {
            return RString.EMPTY;
        }
    }

    private void set固定文(NigoShikakuChosahyoShokaiSource source) {
        source.koteibun01 = getCodeMaster(new Code(KoteibunCode.固定文コード_０１.getCode()))
                .replace(REPLACE_STR1, get現市区町村区分名称());
        source.koteibun02 = getCodeMaster(new Code(KoteibunCode.固定文コード_０２.getCode()))
                .replace(REPLACE_STR1, get現市区町村区分名称());
        source.koteibun03 = getCodeMaster(new Code(KoteibunCode.固定文コード_０３.getCode()));
        source.koteibun04 = getCodeMaster(new Code(KoteibunCode.固定文コード_０４.getCode()));
        source.koteibun05 = getCodeMaster(new Code(KoteibunCode.固定文コード_０５.getCode()))
                .replace(REPLACE_STR1, formatパターン12(item.getEntity().getSenkyoEntity().getKijunYMD()))
                .replace(REPLACE_STR2, formatパターン12(item.getEntity().getSenkyoEntity().getTenshutsuKigenYMD()));
        source.koteibun06 = getCodeMaster(new Code(KoteibunCode.固定文コード_０６.getCode()))
                .replace(REPLACE_STR1, formatパターン12(item.getEntity().getSenkyoEntity().getTennyuKigenYMD()));
        source.koteibun07 = getCodeMaster(new Code(KoteibunCode.固定文コード_０７.getCode()));
    }

    private void set氏名(NigoShikakuChosahyoShokaiSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(NigoShikakuChosahyoShokaiSource.class, new RString("listShimei1_1"));
        RString 名称 = 宛名識別対象.to個人().get名称().getName().value();
        source.shiMei = 名称;
        if (名称.length() <= 名称最大文字数) {
            source.listShimei1_1 = RString.EMPTY;
            source.listShimei2_1 = 名称;
            source.listShimei3_1 = RString.EMPTY;

        } else if (名称.length() > 名称最大文字数 && 名称.length() <= 名称最大文字数 * 2) {
            source.listShimei1_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei2_1 = RString.EMPTY;
            source.listShimei3_1 = 名称.substring(名称最大文字数);
        } else {
            source.listShimei1_1 = 名称.substring(0, 名称最大文字数);
            source.listShimei2_1 = 名称.substring(名称最大文字数, 名称最大文字数 * 2);
            source.listShimei3_1 = 名称.substring(名称最大文字数 * 2);
        }
    }

    private void set当住所(NigoShikakuChosahyoShokaiSource source) {
        RString 住所Concat番地 = 宛名識別対象.to個人().get住登内住所().get住所()
                .concat(宛名識別対象.to個人().get住登内住所().get番地().getBanchi().value()).trim();
        RStringBuilder 住所Builder = new RStringBuilder();
        住所Builder.append(住所Concat番地);
        住所Builder.append(RString.FULL_SPACE);
        住所Builder.append(宛名識別対象.to個人().get住登内住所().get方書());
        RString 住所 = 住所Builder.toRString();
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(NigoShikakuChosahyoShokaiSource.class, new RString("listJusho1_1"));
        source.toJuSho = 住所;
        if (住所.length() <= 住所最大文字数) {
            source.listJusho1_1 = RString.EMPTY;
            source.listJusho2_1 = 住所;
            source.listJusho3_1 = RString.EMPTY;
        } else if (住所.length() <= 住所最大文字数 * 2) {
            source.listJusho1_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho2_1 = RString.EMPTY;
            source.listJusho3_1 = 住所.substring(住所最大文字数);
        } else {
            source.listJusho1_1 = 住所.substring(0, 住所最大文字数);
            source.listJusho2_1 = 住所.substring(住所最大文字数, 住所最大文字数 * 2);
            source.listJusho3_1 = 住所.substring(住所最大文字数 * 2);
        }
    }

    private void set転出元住所(NigoShikakuChosahyoShokaiSource source) {
        RString 住所Concat番地 = 宛名識別対象.to個人().get転入前().get住所()
                .concat(宛名識別対象.to個人().get転入前().get番地().getBanchi().value()).trim();
        RStringBuilder 住所Builder = new RStringBuilder();
        住所Builder.append(住所Concat番地);
        住所Builder.append(RString.FULL_SPACE);
        住所Builder.append(宛名識別対象.to個人().get転入前().get方書());
        RString 住所 = 住所Builder.toRString();
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(NigoShikakuChosahyoShokaiSource.class, new RString("listJusho1_2"));
        source.tenshutsuMotoJusho = 住所;
        if (住所.length() <= 住所最大文字数) {
            source.listJusho1_2 = RString.EMPTY;
            source.listJusho2_2 = 住所;
            source.listJusho3_2 = RString.EMPTY;
        } else if (住所.length() <= 住所最大文字数 * 2) {
            source.listJusho1_2 = 住所.substring(0, 住所最大文字数);
            source.listJusho2_2 = RString.EMPTY;
            source.listJusho3_2 = 住所.substring(住所最大文字数);
        } else {
            source.listJusho1_2 = 住所.substring(0, 住所最大文字数);
            source.listJusho2_2 = 住所.substring(住所最大文字数, 住所最大文字数 * 2);
            source.listJusho3_2 = 住所.substring(住所最大文字数 * 2);
        }
    }

    private RString get現市区町村区分名称() {
        Association association = item.get導入団体();
        return (association == null || RString.isNullOrEmpty(association.get市町村名())) ? RString.EMPTY
                : association.get市町村名().substring(association.get市町村名().length() - 1);
    }

    private RString get生年月日() {
        return 異動選挙人一覧.get生年月日(宛名識別対象.to個人().get住民種別().getCode(), 宛名識別対象.to個人().get生年月日().toFlexibleDate());
    }

    private RString get性別() {
        return 宛名識別対象.to個人().get性別().getCommonName();
    }

    private RString getCodeMaster(Code コード) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.固定文_2号資格調査票_照会.getCodeShubetsu(), コード, FlexibleDate.getNowDate());
    }

    private RString formatパターン12(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
