package jp.co.ndensan.reams.af.afa.business.report.AFAPRC202;

import jp.co.ndensan.reams.af.afa.business.core.SenkyoninMeiboTorokuShomeishoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙人名簿登録証明書
 *
 * @reamsid_L AF-0210-030 lis2
 */
public class SenkyoninMeiboTorokuShomeishoEditor implements ISenkyoninMeiboTorokuShomeishoEditor {

    private static final RString タイトル = new RString("選挙人名簿登録証明書");
    private static final RString 選挙人 = new RString("選挙人");
    private static final RString 全角スペース = new RString("　");
    private static final RString 明細タイトル１ = new RString("令第53条又は第54条の規定による投票用紙の交付");
    private static final RString 明細タイトル2 = new RString("令第59条の6の規定による投票送信用紙の交付");

    private final SenkyoninMeiboTorokuShomeishoParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link SenkyoninMeiboTorokuShomeishoParam}
     */
    public SenkyoninMeiboTorokuShomeishoEditor(SenkyoninMeiboTorokuShomeishoParam data) {
        this.data = data;
    }

    /**
     * 選挙人名簿登録証明書エディットメソッド
     *
     * @param source 選挙人名簿登録証明書
     * @return 選挙人名簿登録証明書
     */
    @Override
    public SenkyoninMeiboTorokuShomeishoReportSource edit(SenkyoninMeiboTorokuShomeishoReportSource source) {
        editタイトル(source);
        edit種類タイトル(source);
        edit住所(source);
        edit氏名(source);
        edit有効期間(source);
        edit発行時点(source);
        edit市町村名(source);
        edit委員長名(source);
        edit明細タイトル(source);
        editログ出力(source);
        return source;
    }

    private void editタイトル(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.title = タイトル;
    }

    private void edit種類タイトル(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.shuruiTitle = 選挙人;
    }

    private void edit住所(SenkyoninMeiboTorokuShomeishoReportSource source) {
        RString 住登内住所 = data.get宛名PSM().getJutonaiJusho();
        Katagaki 住登内方書 = data.get宛名PSM().getJutonaiKatagaki();
        AtenaBanchi 住登内番地 = data.get宛名PSM().getJutonaiBanchi();
        if (data.get宛名PSM() != null && 住登内住所 != null) {
            source.jusho = changeNullToEmpty(住登内住所).concat(住登内番地 == null ? RString.EMPTY : 住登内番地.getColumnValue())
                    .concat(全角スペース).concat(住登内方書 == null ? RString.EMPTY : 住登内方書.getColumnValue());
        }
    }

    private void edit氏名(SenkyoninMeiboTorokuShomeishoReportSource source) {
        AtenaMeisho 氏名 = data.get宛名PSM().getMeisho();
        if (氏名 != null) {
            source.shimei = 氏名.value();
        }
    }

    private void edit有効期間(SenkyoninMeiboTorokuShomeishoReportSource source) {
        if (data.get交付年月日() != null) {
            source.yukoKikanStart = data.get交付年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit発行時点(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.hakkoYmd = RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private void edit市町村名(SenkyoninMeiboTorokuShomeishoReportSource source) {
        if (data.get地方公共団体() != null) {
            source.shichosonMei = data.get地方公共団体().get都道府県名().concat(data.get地方公共団体().get市町村名());
        }
    }

    private void edit委員長名(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.iinchoMei = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
    }

    private void edit明細タイトル(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.meisaiTitle1 = 明細タイトル１;
        source.meisaiTitle2 = 明細タイトル2;
    }

    private void editログ出力(SenkyoninMeiboTorokuShomeishoReportSource source) {
        source.識別コード = data.get宛名PSM().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
