package jp.co.ndensan.reams.af.afa.business.report.AFAPRC203;

import jp.co.ndensan.reams.af.afa.business.core.NankyokuSenkyoninShomeishoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC203.NankyokuSenkyoninShomeishoReportSource;
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
 * 南極選挙人証
 *
 * @reamsid_L AF-0220-020 lis2
 */
public class NankyokuSenkyoninShomeishoEditor implements INankyokuSenkyoninShomeishoEditor {

    private static final RString タイトル = new RString("南極選挙人証");
    private static final RString 選挙人 = new RString("選挙人");
    private static final RString 全角スペース = new RString("　");
    private static final RString 明細タイトル１ = new RString("令第53条の規定による投票用紙の交付");
    private static final RString 明細タイトル2 = new RString("令第59条の8の規定による投票送信用紙の交付");

    private final NankyokuSenkyoninShomeishoParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NankyokuSenkyoninShomeishoParam}
     */
    public NankyokuSenkyoninShomeishoEditor(NankyokuSenkyoninShomeishoParam data) {
        this.data = data;
    }

    /**
     * 郵便等投票証明書エディットメソッド
     *
     * @param source 郵便等投票証明書
     * @return 郵便等投票証明書
     */
    @Override
    public NankyokuSenkyoninShomeishoReportSource edit(NankyokuSenkyoninShomeishoReportSource source) {
        editタイトル(source);
        edit種類タイトル(source);
        edit住所(source);
        edit氏名(source);
        edit有効期間(source);
        edit発行時点(source);
        edit市町村名(source);
        edit委員長名(source);
        edit明細タイトル(source);
        edit満了年月日(source);
        editログ出力(source);
        return source;
    }

    private void editタイトル(NankyokuSenkyoninShomeishoReportSource source) {
        source.title = タイトル;
    }

    private void edit種類タイトル(NankyokuSenkyoninShomeishoReportSource source) {
        source.shuruiTitle = 選挙人;
    }

    private void edit住所(NankyokuSenkyoninShomeishoReportSource source) {
        RString 住登内住所 = data.get宛名PSM().getJutonaiJusho();
        AtenaBanchi 住登内番地 = data.get宛名PSM().getJutonaiBanchi();
        Katagaki 住登内方書 = data.get宛名PSM().getJutonaiKatagaki();
        if (data.get宛名PSM() != null && 住登内住所 != null) {
            source.jusho = changeNullToEmpty(住登内住所).concat(住登内番地 == null ? RString.EMPTY : 住登内番地.getColumnValue())
                    .concat(全角スペース).concat(住登内方書 == null ? RString.EMPTY : 住登内方書.getColumnValue());
        }
    }

    private void edit氏名(NankyokuSenkyoninShomeishoReportSource source) {
        AtenaMeisho atenaMeisho = data.get宛名PSM().getMeisho();
        if (atenaMeisho != null) {
            source.shimei = atenaMeisho.getColumnValue();
        }
    }

    private void edit有効期間(NankyokuSenkyoninShomeishoReportSource source) {
        if (data.get交付年月日() != null) {
            source.yukoKikanStart = data.get交付年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit発行時点(NankyokuSenkyoninShomeishoReportSource source) {
        source.hakkoYmd = RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private void edit市町村名(NankyokuSenkyoninShomeishoReportSource source) {
        if (data.get地方公共団体() != null) {
            source.shichosonMei = data.get地方公共団体().get都道府県名().concat(data.get地方公共団体().get市町村名());
        }
    }

    private void edit委員長名(NankyokuSenkyoninShomeishoReportSource source) {
        source.iinchoMei = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
    }

    private void edit明細タイトル(NankyokuSenkyoninShomeishoReportSource source) {
        source.meisaiTitle1 = 明細タイトル１;
        source.meisaiTitle2 = 明細タイトル2;
    }

    private void edit満了年月日(NankyokuSenkyoninShomeishoReportSource source) {
        if (data.get資格満了年月日() != null) {
            source.manryoYmd = data.get資格満了年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        }
    }

    private void editログ出力(NankyokuSenkyoninShomeishoReportSource source) {
        source.識別コード = data.get宛名PSM().getShikibetsuCode();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
