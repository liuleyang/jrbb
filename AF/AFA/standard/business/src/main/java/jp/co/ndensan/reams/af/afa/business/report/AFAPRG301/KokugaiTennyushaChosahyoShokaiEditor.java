/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG301;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAPRG301_KokugaiTennyushaChosahyoShokai_国外転入者調査票（照会）のEditorクラスです。
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
public class KokugaiTennyushaChosahyoShokaiEditor implements IKokugaiTennyushaChosahyoShokaiEditor {

    private final KokugaiTennyushaChosahyoShokaiParameter target;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
    private final IShikibetsuTaisho 宛名識別対象;
    private final RString 選号外 = new RString("選　号　外");
    private static final RString REPLACE = new RString("%1");
    private static final int SIZE1 = 1;
    private static final int SIZE2 = 2;
    private static final int SIZE3 = 3;

    /**
     * コンストラクタです。
     *
     * @param target KokugaiTennyushaChosahyoShokaiParameter
     */
    public KokugaiTennyushaChosahyoShokaiEditor(KokugaiTennyushaChosahyoShokaiParameter target) {
        this.target = target;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getShikibetsuTaishoEntity());
    }

    @Override
    public KokugaiTennyushaChosahyoShokaiSource edit(KokugaiTennyushaChosahyoShokaiSource source) {
        setヘッダ(source);
        set明細タイトル(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(KokugaiTennyushaChosahyoShokaiSource source) {
        source.yubinNo = get転入元郵便番号();
        set転入元市区町村名(source);
        source.hakkoDaino = get発行第番号();
        source.hakkoYmd = get発行年月日();
        source.tennyuSaki = get現市区町村名();
        source.koinShoryaku = get公印省略();
        source.barcodeCustombarcode = getカスタマーバーコード();
        source.naigaiKubun = get内外区分();
        set固定文(source);

    }

    private void set明細タイトル(KokugaiTennyushaChosahyoShokaiSource source) {
        source.cityKubun = get現市区町村区分名称();
    }

    private void set明細(KokugaiTennyushaChosahyoShokaiSource source) {
        set氏名(source);
        source.listSeinengappi_1 = get生年月日();
        source.listSeinengappi_2 = 宛名識別対象.to個人().get性別().getCommonName();
        set住所(source);
        set転出元住所(source);
        set本籍住所(source);
        source.tennyuZanTop5 = target.get本籍全国住所コードの上5桁(target.get選挙人資格の情報());
    }

    private void setフッタ(KokugaiTennyushaChosahyoShokaiSource source) {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (ReportIdKeys.国外転入者調査票照会.value().equals(target.get帳票ID())) {
            RString 固定文D1 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_１１.getCode()), nowDate);
            RString 固定文D2 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_１２.getCode()), nowDate);
            source.koteibunD1 = 固定文D1;
            source.koteibunD2 = 固定文D2;
        } else if (ReportIdKeys.国内転入者調査票照会.value().equals(target.get帳票ID())) {
            RString 固定文D1 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_１１.getCode()), nowDate);
            RString 固定文D2 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_１２.getCode()), nowDate);
            source.koteibunD1 = 固定文D1;
            source.koteibunD2 = 固定文D2;
        } else {
            source.koteibunD1 = RString.EMPTY;
            source.koteibunD2 = RString.EMPTY;
        }

    }

    private RString get転入元郵便番号() {
        RString format = new RString("〒");
        if (AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード)
                && null != target.get他市町村送付先()) {
            return format.concat(target.get他市町村送付先().get郵便番号().getEditedYubinNo());
        }
        return RString.EMPTY;
    }

    private void set転入元市区町村名(KokugaiTennyushaChosahyoShokaiSource source) {
        RString 都道府県名 = RString.EMPTY;
        RString 市区町村名 = RString.EMPTY;
        if (target.get全国住所都道府県名() != null) {
            都道府県名 = target.get全国住所都道府県名();
        }
        if (target.get全国住所市区町村名() != null) {
            市区町村名 = target.get全国住所市区町村名();
        }
        RString 文字列 = 都道府県名.concat(市区町村名);
        int 転入元市区町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("tennyuMae1"));
        List<RString> list = idouSenkyoninIchiran.文字列分割(文字列, 転入元市区町村名1最大文字数);
        if (list.get(1).isEmpty()) {
            //文字列2が空白
            //文字列1を転入元市区町村名1にセットする
            //文字列2を転入元市区町村名2にセットする
            source.tennyuMae1 = list.get(0);
            source.tennyuMae2 = list.get(1);
        } else {
            //ビジネスで取得した文字列2が空白ではない場合
            //文字列1を転入元市区町村名2にセットする
            //文字列2を転入元市区町村名1にセットする
            source.tennyuMae1 = list.get(1);
            source.tennyuMae2 = list.get(0);
        }
    }

    private RString get発行第番号() {
        RString 第 = RString.isNullOrEmpty(target.get発行番号_第()) ? RString.EMPTY : target.get発行番号_第();
        RString 番号 = RString.isNullOrEmpty(target.get発行番号_番号()) ? RString.EMPTY : target.get発行番号_番号();
        RString 号 = RString.isNullOrEmpty(target.get発行番号_号()) ? RString.EMPTY : target.get発行番号_号();
        RString 発行第番号 = 第.concat(番号).concat(号);
        return (RString.isNullOrEmpty(発行第番号) || RString.isNullOrEmpty(発行第番号.trim())) ? 選号外 : 発行第番号;
    }

    private RString get発行年月日() {
        if (target.get発行日() != null) {
            return target.get発行日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        } else {
            return RString.EMPTY;
        }

    }

    private RString get登録基準日() {
        if (target.get名簿基準年月日() != null) {
            return target.get名簿基準年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get現市区町村名() {
        Association association = target.get導入団体();
        if (association != null) {
            RString 都道府県名 = association.get都道府県名() == null ? RString.EMPTY : association.get都道府県名();
            RString 市町村名 = association.get市町村名() == null ? RString.EMPTY : association.get市町村名();
            RString 文字列 = 都道府県名.concat(市町村名);
            int 現市区町村名最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("tennyuSaki"));
            List<RString> list = idouSenkyoninIchiran.文字列分割(文字列, 現市区町村名最大文字数);
            //ビジネスで取得した文字列1を現市区町村名にセットする
            return list.get(0);
        } else {
            return RString.EMPTY;
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

    private RString getカスタマーバーコード() {
        if (AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード)) {
            CustomerBarCode barcode = new CustomerBarCode();
            CustomerBarCodeResult result = barcode
                    .convertCustomerBarCode(宛名識別対象.to個人().get住所().get郵便番号().getYubinNo(),
                            宛名識別対象.to個人().get住所().get住所());
            return result.getCustomerBarCode();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get内外区分() {
        if (ReportIdKeys.国外転入者調査票照会.value().equals(target.get帳票ID())) {
            return new RString("国外");
        } else if (ReportIdKeys.国内転入者調査票照会.value().equals(target.get帳票ID())) {
            return new RString("国内");
        } else {
            return RString.EMPTY;
        }
    }

    private void set固定文(KokugaiTennyushaChosahyoShokaiSource source) {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (ReportIdKeys.国外転入者調査票照会.value().equals(target.get帳票ID())) {
            RString 固定文1 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０１.getCode()), nowDate).replace(REPLACE, get現市区町村区分名称());
            RString 固定文2 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０２.getCode()), nowDate);
            RString 固定文3 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０３.getCode()), nowDate).replace(REPLACE, get現市区町村区分名称());
            RString 固定文4 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０４.getCode()), nowDate);
            RString 固定文5 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０５.getCode()), nowDate);
            RString 固定文6 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０６.getCode()), nowDate).replace(REPLACE, get登録基準日());
            RString 固定文7 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０７.getCode()), nowDate);
            source.koteibun01 = 固定文1;
            source.koteibun02 = 固定文2;
            source.koteibun03 = 固定文3;
            source.koteibun04 = 固定文4;
            source.koteibun05 = 固定文5;
            source.koteibun06 = 固定文6;
            source.koteibun07 = 固定文7;
        } else if (ReportIdKeys.国内転入者調査票照会.value().equals(target.get帳票ID())) {
            RString 固定文1 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０１.getCode()), nowDate).replace(REPLACE, get現市区町村区分名称());
            RString 固定文2 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０２.getCode()), nowDate).replace(REPLACE, get現市区町村区分名称());
            RString 固定文3 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０３.getCode()), nowDate);
            RString 固定文4 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０４.getCode()), nowDate);
            RString 固定文5 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０５.getCode()), nowDate);
            RString 固定文6 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０６.getCode()), nowDate).replace(REPLACE, get登録基準日());
            RString 固定文7 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(),
                    new Code(KoteibunCode.固定文コード_０７.getCode()), nowDate);
            source.koteibun01 = 固定文1;
            source.koteibun02 = 固定文2;
            source.koteibun03 = 固定文3;
            source.koteibun04 = 固定文4;
            source.koteibun05 = 固定文5;
            source.koteibun06 = 固定文6;
            source.koteibun07 = 固定文7;
        } else {
            source.koteibun01 = RString.EMPTY;
            source.koteibun02 = RString.EMPTY;
            source.koteibun03 = RString.EMPTY;
            source.koteibun04 = RString.EMPTY;
            source.koteibun05 = RString.EMPTY;
            source.koteibun06 = RString.EMPTY;
            source.koteibun07 = RString.EMPTY;
        }

    }

    private RString get現市区町村区分名称() {
        //地方公共団体管理クラス利用ガイドを使用して都道府県名と市区町村名を取得する
        Association association = target.get導入団体();
        if (association != null) {
            RString 市町村名 = association.get市町村名() == null ? RString.EMPTY : association.get市町村名();
            //取得した市区町村名の右側１文字分をセットする
            if (!市町村名.isEmpty()) {
                return 市町村名.substring(市町村名.length() - 1, 市町村名.length());
            } else {
                return RString.EMPTY;
            }
        } else {
            return RString.EMPTY;
        }

    }

    private void set氏名(KokugaiTennyushaChosahyoShokaiSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("listShimei1_1"));
        RString 名称 = 宛名識別対象.to個人().get名称().getName().value();
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

    private RString get生年月日() {
        RString 住民種別コード = 宛名識別対象.to個人().get住民種別().getCode();
        FlexibleDate 生年月日 = 宛名識別対象.to個人().get生年月日().toFlexibleDate();
        return idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
    }

    private void set住所(KokugaiTennyushaChosahyoShokaiSource source) {
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("listJusho1_1"));
        RString 住登内住所 = 宛名識別対象.to個人().get住登内住所().get住所();
        RString 住登内番地 = 宛名識別対象.to個人().get住登内住所().get番地().getBanchi().value();
        RString 住登内方書 = 宛名識別対象.to個人().get住登内住所().get方書().value();
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(住登内住所).append(住登内番地);
        住所.replace(RString.FULL_SPACE, RString.EMPTY);
        住所.replace(RString.HALF_SPACE, RString.EMPTY);
        住所.append(RString.FULL_SPACE).append(住登内方書);
        source.listJusho1_1 = RString.EMPTY;
        source.listJusho2_1 = RString.EMPTY;
        source.listJusho3_1 = RString.EMPTY;
        List<RString> 住所List = splite(住所.toRString(), 住所最大文字数);
        switch (住所List.size()) {
            case SIZE1:
                source.listJusho2_1 = 住所List.get(0);
                break;
            case SIZE2:
                source.listJusho1_1 = 住所List.get(0);
                source.listJusho3_1 = 住所List.get(1);
                break;
            case SIZE3:
                source.listJusho1_1 = 住所List.get(0);
                source.listJusho2_1 = 住所List.get(1);
                source.listJusho3_1 = 住所List.get(2);
                break;
            default:
        }
    }

    private void set転出元住所(KokugaiTennyushaChosahyoShokaiSource source) {
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("listJusho1_2"));
        RString 転入前住所 = 宛名識別対象.to個人().get転入前().get住所();
        RString 転入前番地 = 宛名識別対象.to個人().get転入前().get番地().getBanchi().value();
        RString 転入前方書 = 宛名識別対象.to個人().get転入前().get方書().value();
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(転入前住所).append(転入前番地);
        住所.replace(RString.HALF_SPACE, RString.EMPTY);
        住所.replace(RString.FULL_SPACE, RString.EMPTY);
        住所.append(RString.FULL_SPACE).append(転入前方書);
        List<RString> 住所List = splite(住所.toRString(), 住所最大文字数);
        source.listJusho1_2 = RString.EMPTY;
        source.listJusho2_2 = RString.EMPTY;
        source.listJusho3_2 = RString.EMPTY;
        switch (住所List.size()) {
            case SIZE1:
                source.listJusho2_2 = 住所List.get(0);
                break;
            case SIZE2:
                source.listJusho1_2 = 住所List.get(0);
                source.listJusho3_2 = 住所List.get(1);
                break;
            case SIZE3:
                source.listJusho1_2 = 住所List.get(0);
                source.listJusho2_2 = 住所List.get(1);
                source.listJusho3_2 = 住所List.get(2);
                break;
            default:
        }
    }

    private void set本籍住所(KokugaiTennyushaChosahyoShokaiSource source) {
        int 住所最大文字数 = ReportDataInfoLoader.getMaxLength(KokugaiTennyushaChosahyoShokaiSource.class, new RString("listHonseki1_1"));
        AtenaJusho 本籍住所 = target.get選挙人資格の情報().getShikibetsuTaishoEntity().getHonsekiJusho();
        AtenaBanchi 本籍番地 = target.get選挙人資格の情報().getShikibetsuTaishoEntity().getHonsekiBanchi();
        RStringBuilder 本籍 = new RStringBuilder();

        if (本籍住所 != null) {
            本籍.append(本籍住所.value());
        }
        if (本籍番地 != null) {
            本籍.append(本籍番地.value());
        }
        本籍.replace(RString.HALF_SPACE, RString.EMPTY);
        本籍.replace(RString.FULL_SPACE, RString.EMPTY);
        List<RString> 本籍List = splite(本籍.toRString(), 住所最大文字数);

        source.listHonseki1_1 = RString.EMPTY;
        source.listHonseki2_1 = RString.EMPTY;
        source.listHonseki3_1 = RString.EMPTY;
        switch (本籍List.size()) {
            case SIZE1:
                source.listHonseki2_1 = 本籍List.get(0);
                break;
            case SIZE2:
                source.listHonseki1_1 = 本籍List.get(0);
                source.listHonseki3_1 = 本籍List.get(1);
                break;
            case SIZE3:
                source.listHonseki1_1 = 本籍List.get(0);
                source.listHonseki2_1 = 本籍List.get(1);
                source.listHonseki3_1 = 本籍List.get(2);
                break;
            default:

        }

    }

    private void editログの出力(KokugaiTennyushaChosahyoShokaiSource source) {
        source.識別コード1 = target.get選挙人資格の情報().getShikibetsuTaishoEntity().getShikibetsuCode();
        source.shikibetsuCode = source.識別コード1 == null ? RString.EMPTY : source.識別コード1.value();
    }

    private List<RString> splite(RString trgt, int length) {
        List<RString> rsltList = new ArrayList();

        for (int i = 0; i < 2; i++) {
            RString rslt = trgt.substringReturnAsPossible(i * length, (i + 1) * length);
            if (RString.isNullOrEmpty(rslt)) {
                return rsltList;
            }
            rsltList.add(rslt);
        }
        RString rslt = trgt.substringReturnAsPossible(2 * length);
        if (!RString.isNullOrEmpty(rslt)) {
            rsltList.add(rslt);
        }

        return rsltList;

    }
}
