/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG114;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG114.NigoShikakuChosahyoKaitoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAPRG114_2goShikakuChosahyoKaito_2号資格調査票（回答）（様式2-2）のEditorクラスです。
 *
 * @reamsid_L AF-0360-062 fulc
 */
public class NigoShikakuChosahyoKaitoEditor implements INigoShikakuChosahyoKaitoEditor {

    private final NigoShikakuChosahyoKaitoParameter para;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final IdouSenkyoninIchiran idouSenkyoninIchiran;
    private static final RString 郵便標識 = new RString("〒");

    private static final int 転入前全国住所コードの上5桁 = 5;

    /**
     * コンストラクタです。
     *
     * @param para NigoShikakuChosahyoKaitoParameter
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NigoShikakuChosahyoKaitoEditor(NigoShikakuChosahyoKaitoParameter para,
            TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.para = para;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.idouSenkyoninIchiran = new IdouSenkyoninIchiran();
    }

    @Override
    public NigoShikakuChosahyoKaitoSource edit(NigoShikakuChosahyoKaitoSource source) {
        set明細タイトル(source);
        setヘッダ(source);
        set明細(source);
        return source;
    }

    private static int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NigoShikakuChosahyoKaitoSource.class, itemName);
    }

    private void setヘッダ(NigoShikakuChosahyoKaitoSource source) {

        source.yubinNo = get転出先郵便番号();

        List<RString> 転入先市区町村名リスト = idouSenkyoninIchiran.文字列分割(para.get転入先市区町村名(), getItemLength(new RString("tennyuSaki1")));

        if (!RString.isNullOrEmpty(転入先市区町村名リスト.get(1))) {
            source.tennyuSaki1 = 転入先市区町村名リスト.get(1);
            source.tennyuSaki2 = 転入先市区町村名リスト.get(0);
        } else {
            source.tennyuSaki1 = 転入先市区町村名リスト.get(0);
            source.tennyuSaki2 = 転入先市区町村名リスト.get(1);
        }
        List<RString> 転入前市区町村名リスト = idouSenkyoninIchiran.文字列分割(para.get転入前市区町村名(), getItemLength(new RString("tennyuMae1")));

        if (!RString.isNullOrEmpty(転入前市区町村名リスト.get(1))) {
            source.tennyuMae1 = 転入前市区町村名リスト.get(1);
            source.tennyuMae2 = 転入前市区町村名リスト.get(0);
        } else {
            source.tennyuMae1 = 転入前市区町村名リスト.get(0);
            source.tennyuMae2 = 転入前市区町村名リスト.get(1);
        }
        source.gengo = 帳票共通ヘッダー.get作成日時().substringReturnAsPossible(0, 2);
        source.barcodeCustombarcode = getカスタマーバーコード();
        source.hakkoYmd = get発行日();
        source.hakkoNo = get発行第番号();

    }

    private RString get転出先郵便番号() {
        if (AFAConfigKeysValue.印字有無_印字する
                .isEqual(BusinessConfig.get(ConfigKeysAFA.国民_印字有無_カスタマーバーコード, RDate.getNowDate(), SubGyomuCode.AFA選挙本体))) {
            return 郵便標識.concat(para.get転入先郵便番号());
        }
        return RString.EMPTY;
    }

    private RString get発行日() {
        if (para.get発行日() != null) {
            return para.get発行日().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString getカスタマーバーコード() {
        IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(para.getEntity().getShikibetsuTaishoEntity());
        if (AFAConfigKeysValue.印字有無_印字する.isEqual(BusinessConfig
                .get(ConfigKeysAFA.国民_印字有無_カスタマーバーコード, RDate.getNowDate(), SubGyomuCode.AFA選挙本体))) {
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
        RString 第 = RString.isNullOrEmpty(para.get発行番号の第()) ? RString.EMPTY : para.get発行番号の第();
        RString 番号 = RString.isNullOrEmpty(para.get発行番号の番号()) ? RString.EMPTY : para.get発行番号の番号();
        RString 号 = RString.isNullOrEmpty(para.get発行番号の号()) ? RString.EMPTY : para.get発行番号の号();
        RString 発行第番号 = 第.concat(番号).concat(号);
        return (RString.isNullOrEmpty(発行第番号) || RString.isNullOrEmpty(発行第番号.trim())) ? new RString("選　号　外") : 発行第番号;

    }

    private void set明細タイトル(NigoShikakuChosahyoKaitoSource source) {
        source.aiteCityKubun = para.get転入先市区町村区分名称();
        source.cityKubun = para.get転入前市区町村名区分名称();
    }

    private void set明細(NigoShikakuChosahyoKaitoSource source) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(para.getEntity().getShikibetsuTaishoEntity());
        RString 氏名 = kojin.get名称().getName().getColumnValue();
        source.shimei = 氏名;
        List<RString> 氏名リスト = idouSenkyoninIchiran.文字列分割(氏名, getItemLength(new RString("listShimei1_1")));
        if (!RString.isNullOrEmpty(氏名リスト.get(1))) {
            source.listShimei1_1 = 氏名リスト.get(1);
            source.listShimei2_1 = 氏名リスト.get(0);
        } else {
            source.listShimei1_1 = 氏名リスト.get(0);
            source.listShimei2_1 = 氏名リスト.get(1);
        }
        RString 住民種別コード = kojin.get住民種別().getCode();
        FlexibleDate 生年月日 = kojin.get生年月日().toFlexibleDate();
        source.listSeinengappi_1 = idouSenkyoninIchiran.get生年月日(住民種別コード, 生年月日);
        source.listSeinengappi_2 = kojin.get性別().getCommonName();
        ZenkokuJushoCode 転入前全国住所コード = para.getEntity().getShikibetsuTaishoEntity().getTennyumaeZenkokuJushoCode();
        if (転入前全国住所コード != null) {
            source.tennyumaeZenkokuJushoCode = 転入前全国住所コード.value().substringReturnAsPossible(0, 転入前全国住所コードの上5桁);
        }
        source.shikibetsuCode = para.getEntity().getShikibetsuTaishoEntity().getShikibetsuCode();
        source.shikibetsuCode1 = source.shikibetsuCode == null ? RString.EMPTY : source.shikibetsuCode.value();
    }

}
