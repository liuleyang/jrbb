/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG303;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KoteibunCode;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG302.KokunaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG303.KokugaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 国外転入者調査票（回答）のEditorクラスです。
 *
 * @reamsid_L AF-0360-068 b_caiyf
 */
public class KokugaiTennyushaChosahyoKaitoEditor implements IKokugaiTennyushaChosahyoKaitoEditor {

    private final KokugaiTennyushaChosahyoKaitoParameter target;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
    private final IShikibetsuTaisho 宛名識別対象;
    private final RString 選号外 = new RString("選　号　外");

    /**
     * コンストラクタです。
     *
     * @param target KokugaiTennyushaChosahyoShokaiParameter
     */
    public KokugaiTennyushaChosahyoKaitoEditor(KokugaiTennyushaChosahyoKaitoParameter target) {
        this.target = target;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getShikibetsuTaishoEntity());
    }

    @Override
    public KokugaiTennyushaChosahyoKaitoSource edit(KokugaiTennyushaChosahyoKaitoSource source) {
        setヘッダ(source);
        set明細タイトル(source);
        set明細(source);
        setフッタ(source);
        editログの出力(source);
        return source;
    }

    private void setヘッダ(KokugaiTennyushaChosahyoKaitoSource source) {
        source.yubinNo = get転入元郵便番号();
        set転入先市区町村名(source);
        source.gengo = get元号();
        set転入前市区町村名(source);
        source.barcodeCustombarcode = getカスタマーバーコード();
        source.hakkoYmd = get発行年月日();
        source.hakkoNo = get発行第番号();

    }

    private void set明細タイトル(KokugaiTennyushaChosahyoKaitoSource source) {
        source.aiteCityKubun = get転入先市区町村区分名称();

    }

    private void set明細(KokugaiTennyushaChosahyoKaitoSource source) {
        set氏名(source);
        source.listSeinengappi_1 = get生年月日();
        source.listSeibetsu_1 = 宛名識別対象.to個人().get性別().getCommonName();
        source.listTenshutsuYmd_1 = RString.EMPTY;
        source.listLastJusho1_1 = RString.EMPTY;
        source.listLastJusho2_1 = RString.EMPTY;
        source.listLastJusho3_1 = RString.EMPTY;
        source.tennyuZanTop5 = target.get本籍全国住所コードの上5桁(target.get選挙人資格の情報());

    }

    private void setフッタ(KokugaiTennyushaChosahyoKaitoSource source) {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        RString 固定文D1 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_回答.getCodeShubetsu(),
                new Code(KoteibunCode.固定文コード_１１.getCode()), nowDate);
        RString 固定文D2 = CodeMaster.getCodeMeisho(AFACodeShubetsu.固定文_国外転入者調査票_回答.getCodeShubetsu(),
                new Code(KoteibunCode.固定文コード_１２.getCode()), nowDate);
        source.koteibunD1 = 固定文D1;
        source.koteibunD2 = 固定文D2;
    }

    private RString get転入元郵便番号() {
        RString format = new RString("〒");
        if (AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード)
                && null != target.get他市町村送付先()) {
            return format.concat(target.get他市町村送付先().get郵便番号().getEditedYubinNo());
        }
        return RString.EMPTY;
    }

    private void set転入先市区町村名(KokugaiTennyushaChosahyoKaitoSource source) {
        RString 都道府県名 = RString.EMPTY;
        RString 市区町村名 = RString.EMPTY;
        if (target.get導入団体() != null) {
            if (target.get導入団体().get都道府県名() != null) {
                都道府県名 = target.get導入団体().get都道府県名();
            }
            if (target.get導入団体().get市町村名() != null) {
                市区町村名 = target.get導入団体().get市町村名();
            }
        }
        RString 文字列 = 都道府県名.concat(市区町村名);
        int 転入先市区町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(KokunaiTennyushaChosahyoKaitoSource.class, new RString("tennyuSaki1"));
        List<RString> list = idouSenkyoninIchiran.文字列分割(文字列, 転入先市区町村名1最大文字数);
        if (list.get(1).isEmpty()) {

            source.tennyuSaki1 = list.get(0);
            source.tennyuSaki2 = list.get(1);
        } else {

            source.tennyuSaki1 = list.get(1);
            source.tennyuSaki2 = list.get(0);
        }
    }

    private RString get元号() {
        RDate システム日付 = RDate.getNowDate();
        RString 発行年 = システム日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getYear();
        return 発行年.substring(0, 2);
    }

    private void set転入前市区町村名(KokugaiTennyushaChosahyoKaitoSource source) {
        RString 都道府県名 = RString.EMPTY;
        RString 市区町村名 = RString.EMPTY;
        if (target.get全国住所都道府県名() != null) {
            都道府県名 = target.get全国住所都道府県名();
        }
        if (target.get全国住所市区町村名() != null) {
            市区町村名 = target.get全国住所市区町村名();
        }
        RString 文字列 = 都道府県名.concat(市区町村名);
        int 転入元市区町村名1最大文字数 = ReportDataInfoLoader.getMaxLength(KokunaiTennyushaChosahyoKaitoSource.class, new RString("tennyuMae1"));
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

    private RString get発行年月日() {
        if (target.get発行日() != null) {
            return target.get発行日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        } else {
            return RString.EMPTY;
        }

    }

    private RString get発行第番号() {
        RString 第 = RString.isNullOrEmpty(target.get発行番号_第()) ? RString.EMPTY : target.get発行番号_第();
        RString 番号 = RString.isNullOrEmpty(target.get発行番号_番号()) ? RString.EMPTY : target.get発行番号_番号();
        RString 号 = RString.isNullOrEmpty(target.get発行番号_号()) ? RString.EMPTY : target.get発行番号_号();
        RString 発行第番号 = 第.concat(番号).concat(号);
        return (RString.isNullOrEmpty(発行第番号) || RString.isNullOrEmpty(発行第番号.trim())) ? 選号外 : 発行第番号;
    }

    private RString get転入先市区町村区分名称() {
        //地方公共団体管理クラス利用ガイドを使用して都道府県名と市区町村名を取得する
        Association association = target.get導入団体();
        RString 市町村名 = association == null ? RString.EMPTY : association.get市町村名();
        //取得した市区町村名の右側１文字分をセットする
        return RString.isNullOrEmpty(市町村名) ? RString.EMPTY : 市町村名.substring(市町村名.length() - 1, 市町村名.length());

    }

    private void set氏名(KokugaiTennyushaChosahyoKaitoSource source) {
        int 名称最大文字数 = ReportDataInfoLoader.getMaxLength(KokunaiTennyushaChosahyoKaitoSource.class, new RString("listShimei1_1"));
        RString 名称 = 宛名識別対象.to個人().get名称().getName().value();
        source.shimei = 名称;
        List<RString> list = idouSenkyoninIchiran.文字列分割(名称, 名称最大文字数);
        if (list.get(1).isEmpty()) {
            //文字列2が空白
            source.listShimei1_1 = list.get(0);
            source.listShimei2_1 = list.get(1);
        } else {
            //ビジネスで取得した文字列2が空白ではない場合
            source.listShimei1_1 = list.get(1);
            source.listShimei2_1 = list.get(0);
        }

    }

    private RString get生年月日() {
        RString 住民種別コード = 宛名識別対象.to個人().get住民種別().getCode();
        FlexibleDate 生年月日 = 宛名識別対象.to個人().get生年月日().toFlexibleDate();
        return idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
    }

    private void editログの出力(KokugaiTennyushaChosahyoKaitoSource source) {
        source.識別コード1 = target.get選挙人資格の情報().getShikibetsuTaishoEntity().getShikibetsuCode();
        source.shikibetsuCode = source.識別コード1 == null ? RString.EMPTY : source.識別コード1.value();
    }

}
