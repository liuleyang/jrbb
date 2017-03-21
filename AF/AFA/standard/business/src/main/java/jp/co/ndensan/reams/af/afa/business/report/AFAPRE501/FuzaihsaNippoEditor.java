package jp.co.ndensan.reams.af.afa.business.report.AFAPRE501;

import jp.co.ndensan.reams.af.afa.business.core.FuzaihsaNippoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoEditor implements IFuzaihsaNippoEditor {

    private static final RString 作成条件 = new RString("指定なし");
    private static final RString 記号 = new RString("～");
    private static final RString 交付タイトル = new RString("不在者投票交付日報");
    private static final RString 受理タイトル = new RString("不在者投票受理日報");
    private static final RString 交付日 = new RString("交付日");
    private static final RString 受理日 = new RString("受理日");
    private static final RString 交付数 = new RString("交付数");
    private static final RString 受理数 = new RString("受理数");

    private final FuzaihsaNippoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link FuzaihsaNippoParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public FuzaihsaNippoEditor(FuzaihsaNippoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 不在者投票日報エディットメソッド
     *
     * @param source 不在者投票日報
     * @return 不在者投票日報
     */
    @Override
    public FuzaihsaNippoReportSource edit(FuzaihsaNippoReportSource source) {
        editヘッダ(source);
        editタイトル(source);
        edit日付(source);
        edit本庁数(source);
        edit本庁点字数(source);
        edit施設数(source);
        edit施設点字数(source);
        edit郵便数(source);
        edit郵便点字数(source);
        edit他市町村数(source);
        edit他市町村点字数(source);
        edit支所数(source);
        edit支所点字数(source);
        edit合計数(source);
        edit合計点字数(source);
        edit作成条件(source);
        edit改ページ(source);
        return source;
    }

    private void editヘッダ(FuzaihsaNippoReportSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.senkyoMei = 帳票共通ヘッダー.get選挙名称();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void editタイトル(FuzaihsaNippoReportSource source) {
        if (data.get投票状況情報().is交付_受理フラグ()) {
            source.title = 交付タイトル;
            source.meisaiTitleDate = 交付日;
            source.meisaiTitle = 交付数;
        } else {
            source.title = 受理タイトル;
            source.meisaiTitleDate = 受理日;
            source.meisaiTitle = 受理数;
        }
    }

    private void edit日付(FuzaihsaNippoReportSource source) {
//        FlexibleDate date;
//        if (data.get投票状況情報().is交付_受理フラグ()) {
//            date = data.get投票状況情報().get投票状況().get(0).getKofuYMD();
//        } else {
//            date = data.get投票状況情報().get投票状況().get(0).getJuriYMD();
//        }
        source.listMeisai_1 = data.get投票状況情報().get日付();
//                null == date || date.isEmpty() ? RString.EMPTY : date.wareki().toDateString();
    }

    private void edit本庁数(FuzaihsaNippoReportSource source) {
        source.listMeisai_2 = data.get本庁数();
    }

    private void edit本庁点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_3 = data.get本庁点字数();
    }

    private void edit施設数(FuzaihsaNippoReportSource source) {
        source.listMeisai_4 = data.get施設数();
    }

    private void edit施設点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_5 = data.get施設点字数();
    }

    private void edit郵便数(FuzaihsaNippoReportSource source) {
        source.listMeisai_6 = data.get郵便数();
    }

    private void edit郵便点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_7 = data.get郵便点字数();
    }

    private void edit他市町村数(FuzaihsaNippoReportSource source) {
        source.listMeisai_8 = data.get他市町村数();
    }

    private void edit他市町村点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_9 = data.get他市町村点字数();
    }

    private void edit支所数(FuzaihsaNippoReportSource source) {
        source.listMeisai_10 = data.get支所数();
    }

    private void edit支所点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_11 = data.get支所点字数();
    }

    private void edit合計数(FuzaihsaNippoReportSource source) {
        source.listMeisai_12 = data.get合計数();
    }

    private void edit合計点字数(FuzaihsaNippoReportSource source) {
        source.listMeisai_13 = data.get合計点字数();
    }

    private void edit作成条件(FuzaihsaNippoReportSource source) {
        if (data.get投票状況情報().is交付_受理フラグ()) {
            if (null != data.get画面入力項目().get交付日開始()) {
                RString 交付開始日 = data.get画面入力項目().get交付日開始().wareki()
                        .eraType(EraType.ALPHABET)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD)
                        .fillType(FillType.BLANK)
                        .toDateString();
                RString 交付終了日 = data.get画面入力項目().get交付日終了().wareki()
                        .eraType(EraType.ALPHABET)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD)
                        .fillType(FillType.BLANK)
                        .toDateString();
                source.sakuseiJoken1 = 交付開始日.concat(記号).concat(交付終了日);
            } else {
                source.sakuseiJoken1 = 作成条件;
            }
        } else {
            if (null != data.get画面入力項目().get受理日開始()) {
                RString 受理開始日 = data.get画面入力項目().get受理日開始().wareki()
                        .eraType(EraType.ALPHABET)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD)
                        .fillType(FillType.BLANK)
                        .toDateString();
                RString 受理終了日 = data.get画面入力項目().get受理日終了().wareki()
                        .eraType(EraType.ALPHABET)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD)
                        .fillType(FillType.BLANK)
                        .toDateString();
                source.sakuseiJoken1 = 受理開始日.concat(記号).concat(受理終了日);
            } else {
                source.sakuseiJoken1 = 作成条件;
            }
        }
    }

    private void edit改ページ(FuzaihsaNippoReportSource source) {
        source.senkyoNo = data.get投票状況情報().get選挙番号();
    }
}
