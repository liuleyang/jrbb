/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG111;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111.IchigoShikakuTorokuTsuchiSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {@link IchigoShikakuTorokuTsuchiSource}を編集します。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
public class IchigoShikakuTorokuTsuchiEditor implements IIchigoShikakuTorokuTsuchiEditor {

    private final IchigoShikakuTorokuTsuchiParameter target;
    private static final RString 選号外 = new RString("選　号　外");
    private static final RString 郵便標識 = new RString("〒");
    private static final RString 固定文標識 = new RString("%1");
    private final IShikibetsuTaisho 宛名識別対象;
    private final IdouSenkyoninIchiran 異動選挙人一覧 = new IdouSenkyoninIchiran();
    private static final int 当住所１最大文字数 = ReportDataInfoLoader.getMaxLength(IchigoShikakuTorokuTsuchiSource.class,
            new RString("listJusho1_1"));
    private static final int 当住所２最大文字数 = ReportDataInfoLoader.getMaxLength(IchigoShikakuTorokuTsuchiSource.class,
            new RString("listJusho1_2"));

    /**
     * テスト用のコンストラクタです。
     *
     * @param target {@link IchigoShikakuTorokuTsuchiParameter}
     */
    public IchigoShikakuTorokuTsuchiEditor(IchigoShikakuTorokuTsuchiParameter target) {
        this.target = target;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getShikibetsuTaishoEntity());
    }

    @Override
    public IchigoShikakuTorokuTsuchiSource edit(IchigoShikakuTorokuTsuchiSource source) {

        source.tennyuZanTop5 = target.get転入前全国住所コード上5桁(target.get選挙人資格の情報());
        source.yubinNo = get転入元郵便番号();
        set転入元市区町村名(source);
        source.hakkoDaino = get発行第番号();
        source.hakkoYmd = formatパターン12(target.get発行日());
        set現市区町村名(source);
        source.koinShoryaku = get公印省略();
        source.barcodeCustombarcode = getカスタマーバーコード();
        source.koteibun01 = get固定文０１();
        source.koteibun02 = get固定文０２();
        source.koteibun03 = get固定文０３();
        source.koteibun04 = get固定文０４();
        source.cityKubun = get現市区町村区分名称();
        set転出元市区町村区分名称(source);
        set氏名(source);
        source.listSeinengappi_1 = get生年月日();
        source.listSeinengappi_2 = get性別();
        set当住所(source);
        set転出元住所(source);
        editログの出力(source);
        return source;
    }

    private void editログの出力(IchigoShikakuTorokuTsuchiSource source) {
        source.識別コード = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getShikibetsuCode();
        source.shikibetsuCode = source.識別コード.value();
    }

    private RString get転入元郵便番号() {
        if (target.is郵便番号印字有無() && null != target.get他市町村送付先()) {
            return 郵便標識.concat(target.get他市町村送付先().get郵便番号().getEditedYubinNo());
        }
        return RString.EMPTY;
    }

    private void set転入元市区町村名(IchigoShikakuTorokuTsuchiSource source) {
        int 転入元市町村名1最大文字数 = ReportDataInfoLoader
                .getMaxLength(IchigoShikakuTorokuTsuchiSource.class, new RString("tennyuMae1"));
        RString 転入元市区町村名 = target.get都道府県名().concat(target.get市区町村名());
        if (!RString.isNullOrEmpty(転入元市区町村名)) {
            List<RString> 名称List = 異動選挙人一覧.文字列分割(転入元市区町村名, 転入元市町村名1最大文字数);
            source.tennyuMae1 = 名称List.get(1);
            source.tennyuMae2 = 名称List.get(0);
        }
    }

    private RString get発行第番号() {
        RString 第 = RString.isNullOrEmpty(target.get発行番号_第()) ? RString.EMPTY : target.get発行番号_第();
        RString 番号 = RString.isNullOrEmpty(target.get発行番号_番号()) ? RString.EMPTY : target.get発行番号_番号();
        RString 号 = RString.isNullOrEmpty(target.get発行番号_号()) ? RString.EMPTY : target.get発行番号_号();
        RString 発行第番号 = 第.concat(番号).concat(号);
        return (RString.isNullOrEmpty(発行第番号) || RString.isNullOrEmpty(発行第番号.trim())) ? 選号外 : 発行第番号;
    }

    private void set現市区町村名(IchigoShikakuTorokuTsuchiSource source) {
        Association association = target.get導入団体();
        if (null == association) {
            source.tennyuSaki = RString.EMPTY;
        } else {
            int 現市区町村名最大文字数 = ReportDataInfoLoader.getMaxLength(IchigoShikakuTorokuTsuchiSource.class, new RString("tennyuSaki"));
            RString 現市区町村名 = association.get都道府県名().concat(association.get市町村名());
            List<RString> 名称List = 異動選挙人一覧.文字列分割(現市区町村名, 現市区町村名最大文字数);
            source.tennyuSaki = 名称List.get(0);
        }
    }

    private RString get公印省略() {
        RDate nowDate = RDate.getNowDate();
        RString 公印省略 = BusinessConfig.get(ConfigKeysAFA.公印省略印字有無, nowDate, SubGyomuCode.AFA選挙本体);
        if (公印省略.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 公印省略;
        }
    }

    private RString getカスタマーバーコード() {
        RDate nowDate = RDate.getNowDate();
        if (BusinessConfig.get(ConfigKeysAFA.国民_印字有無_カスタマーバーコード,
                nowDate, SubGyomuCode.AFA選挙本体).equals(new RString("1"))) {
            CustomerBarCode barcode = new CustomerBarCode();
            CustomerBarCodeResult result = barcode
                    .convertCustomerBarCode(宛名識別対象.to個人().get住所().get郵便番号().getYubinNo(),
                            宛名識別対象.to個人().get住所().get住所());
            return result.getCustomerBarCode();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get固定文０１() {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_1号登録通知.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０１.getCode()), nowDate)
                .replace(固定文標識, get現市区町村区分名称());
    }

    private RString get固定文０２() {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_1号登録通知.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０２.getCode()), nowDate);
    }

    private RString get固定文０３() {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_1号登録通知.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０３.getCode()), nowDate);
    }

    private RString get固定文０４() {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        return CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_1号登録通知.getCodeShubetsu(), new Code(KoteibunCode.固定文コード_０４.getCode()), nowDate)
                .replace(固定文標識, formatパターン12(target.get登録基準日()));
    }

    private RString get現市区町村区分名称() {
        Association association = target.get導入団体();
        if (null == association) {
            return RString.EMPTY;
        } else {
            RString 現市区町村区分名称 = association.get市町村名();
            return 現市区町村区分名称.substring(現市区町村区分名称.length() - 1, 現市区町村区分名称.length());
        }
    }

    private void set転出元市区町村区分名称(IchigoShikakuTorokuTsuchiSource source) {
        RString 転出元市区町村区分名称 = target.get市区町村名();
        if (!RString.isNullOrEmpty(転出元市区町村区分名称)) {
            source.motoCityKubun = 転出元市区町村区分名称.substring(転出元市区町村区分名称.length() - 1, 転出元市区町村区分名称.length());
        }
    }
    
    private void set氏名(IchigoShikakuTorokuTsuchiSource source) {
        int 文字列最大文字数 = ReportDataInfoLoader.getMaxLength(IchigoShikakuTorokuTsuchiSource.class, new RString("listShimei1_1"));
        RString 文字列 = 宛名識別対象.to個人().get名称().getName().value();
        source.shiMei = 文字列;
        List<RString> 名称List = 異動選挙人一覧.文字列分割(文字列, 文字列最大文字数);
        if (!名称List.get(1).isEmpty()) {
            source.listShimei1_1 = 名称List.get(0);
            source.listShimei2_1 = 名称List.get(1);
        } else {
            source.listShimei1_1 = 名称List.get(1);
            source.listShimei2_1 = 名称List.get(0);
        }
            
    }

    private RString get性別() {
        return 宛名識別対象.to個人().get性別().getCommonName();
    }

    private RString get生年月日() {
        FlexibleDate 生年月日 = 宛名識別対象.to個人().get生年月日().toFlexibleDate();
        RString 住民種別コード = 宛名識別対象.get住民種別().getCode();
        return 異動選挙人一覧.get生年月日(住民種別コード, 生年月日);
    }

    private void set当住所(IchigoShikakuTorokuTsuchiSource source) {

        IJusho 住所 = 宛名識別対象.to個人().get住登内住所();
        RStringBuilder 当住所Builder = new RStringBuilder();
        当住所Builder.append(住所.get住所());
        当住所Builder.append(住所.get番地().getBanchi().getColumnValue());
        RString 方書文字列 = 住所.get方書().getColumnValue();
        if (当住所Builder.length() <= 当住所１最大文字数 && 方書文字列.length() <= 当住所１最大文字数) {
            source.listJusho1_1 = 当住所Builder.toRString();
            source.listJusho2_1 = 方書文字列;
        } else {
            当住所Builder.append(RString.FULL_SPACE);
            当住所Builder.append(方書文字列);
            RString trgt = 当住所Builder.toRString();
            source.listJusho1_1 = trgt.substringReturnAsPossible(0, 当住所１最大文字数);
            source.listJusho2_1 = trgt.substringReturnAsPossible(当住所１最大文字数);
        }
    }

    private void set転出元住所(IchigoShikakuTorokuTsuchiSource source) {

        RStringBuilder 住所Builder = new RStringBuilder();

        RString 転入前住所 = 宛名識別対象.to個人().get転入前().get住所();
        RString 転入前番地 = 宛名識別対象.to個人().get転入前().get番地().getBanchi().value();
        RString 転入前方書 = 宛名識別対象.to個人().get転入前().get方書().value();
        住所Builder.append(転入前住所);
        住所Builder.append(転入前番地);

        if (住所Builder.length() <= 当住所２最大文字数 && 転入前方書.length() <= 当住所２最大文字数) {
            source.listJusho1_2 = 住所Builder.toRString();
            source.listJusho2_2 = 転入前方書;
        } else {
            住所Builder.append(RString.FULL_SPACE);
            住所Builder.append(転入前方書);
            RString 住所 = 住所Builder.toRString();
            source.listJusho1_2 = 住所.substringReturnAsPossible(0, 当住所２最大文字数);
            source.listJusho2_2 = 住所.substringReturnAsPossible(当住所２最大文字数);
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

    private RString formatパターン12(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
