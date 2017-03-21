package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * {@link NijuTorokuTsuchishoReportSource}を編集します。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
public class NijuTorokuTsuchishoMeisaiEditor implements INijuTorokuTsuchishoEditor {

    private final NijuTorokuTsuchishoParameter target;
    private final IShikibetsuTaisho 宛名識別対象;

    /**
     * テスト用のコンストラクタです。
     *
     * @param target {@link NijuTorokuTsuchishoParameter}
     */
    public NijuTorokuTsuchishoMeisaiEditor(NijuTorokuTsuchishoParameter target) {
        this.target = target;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getAtenaPSMEntity());

    }

    @Override
    public NijuTorokuTsuchishoCommonSource edit(NijuTorokuTsuchishoCommonSource source) {

        source.hakkoYmd = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.tennyuMotoShichosonMei = get転入元市町村名();
        source.senkyoMeisho = target.get選挙名称();
        set名称(source);
        source.listYmd_1 = get生年月日();
        source.listYmd_2 = 宛名識別対象.to個人().get性別().getCommonName();
        source.listYmd_3 = 宛名識別対象.to個人().get登録届出年月日()
                .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        set住所(source);
        source.tennyuMotoPageCount = target.getPage();
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

    private RString get転入元市町村名() {
        RString 都道府県名 = target.get選挙人資格の情報().get全国住所都道府県名();
        return 都道府県名.concat(target.get選挙人資格の情報().get全国住所市区町村名());
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
            source.listShimei3_1 = 名称.substring(名称最大文字数, 名称.length());
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
}
