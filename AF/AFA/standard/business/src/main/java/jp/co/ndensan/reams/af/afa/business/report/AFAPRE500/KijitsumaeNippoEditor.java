package jp.co.ndensan.reams.af.afa.business.report.AFAPRE500;

import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeNippoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoEditor implements IKijitsumaeNippoEditor {

    private static final RString 作成条件 = new RString("指定なし");
    private static final RString 記号 = new RString("～");
    private static final RString 作成条件_施設コード = new RString("施設コード：");
    private static final RString 作成条件_投票日 = new RString("投票日：");

    private final KijitsumaeNippoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link KijitsumaeNippoParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public KijitsumaeNippoEditor(KijitsumaeNippoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 期日前投票日報エディットメソッド
     *
     * @param source 期日前投票日報
     * @return 期日前投票日報
     */
    @Override
    public KijitsumaeNippoReportSource edit(KijitsumaeNippoReportSource source) {
        editヘッダ(source);
        edit施設名称(source);
        edit投票日(source);
        edit投票数_男(source);
        edit投票数_女(source);
        edit投票数_計(source);
        edit内数_点字用紙_男(source);
        edit内数_点字用紙_女(source);
        edit内数_点字用紙_計(source);
        edit内数_代理投票_男(source);
        edit内数_代理投票_女(source);
        edit内数_代理投票_計(source);
        edit作成条件(source);
        edit改ページ(source);
        return source;
    }

    private void editヘッダ(KijitsumaeNippoReportSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.senkyoMei = 帳票共通ヘッダー.get選挙名称();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void edit施設名称(KijitsumaeNippoReportSource source) {
        source.shisetsuMei = data.get施設名称();
    }

    private void edit投票日(KijitsumaeNippoReportSource source) {
        source.listMeisai_1 = data.get投票日();
    }

    private void edit投票数_男(KijitsumaeNippoReportSource source) {
        source.listMeisai_2 = data.get投票数_男();
    }

    private void edit投票数_女(KijitsumaeNippoReportSource source) {
        source.listMeisai_3 = data.get投票数_女();
    }

    private void edit投票数_計(KijitsumaeNippoReportSource source) {
        source.listMeisai_4 = data.get投票数_計();
    }

    private void edit内数_点字用紙_男(KijitsumaeNippoReportSource source) {
        source.listMeisaiTenji_1 = data.get内数_点字用紙_男();
    }

    private void edit内数_点字用紙_女(KijitsumaeNippoReportSource source) {
        source.listMeisaiTenji_2 = data.get内数_点字用紙_女();
    }

    private void edit内数_点字用紙_計(KijitsumaeNippoReportSource source) {
        source.listMeisaiTenji_3 = data.get内数_点字用紙_計();
    }

    private void edit内数_代理投票_男(KijitsumaeNippoReportSource source) {
        source.listMeisaiDairi_1 = data.get内数_代理投票_男();
    }

    private void edit内数_代理投票_女(KijitsumaeNippoReportSource source) {
        source.listMeisaiDairi_2 = data.get内数_代理投票_女();
    }

    private void edit内数_代理投票_計(KijitsumaeNippoReportSource source) {
        source.listMeisaiDairi_3 = data.get内数_代理投票_計();
    }

    private void edit作成条件(KijitsumaeNippoReportSource source) {
        if (null != data.get画面入力項目().get施設コード開始() && !data.get画面入力項目().get施設コード開始().isEmpty()) {
            source.sakuseiJoken1 = 作成条件_施設コード.concat(data.get画面入力項目().get施設コード開始()).concat(記号).concat(data.get画面入力項目().get施設コード終了());
        } else {
            source.sakuseiJoken1 = 作成条件_施設コード.concat(作成条件);
        }

        if (null != data.get画面入力項目().get投票日開始()) {
            RString 投票開始日 = data.get画面入力項目().get投票日開始().wareki()
                    .eraType(EraType.ALPHABET)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD)
                    .fillType(FillType.BLANK)
                    .toDateString();
            RString 投票終了日 = data.get画面入力項目().get投票日終了().wareki()
                    .eraType(EraType.ALPHABET)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD)
                    .fillType(FillType.BLANK)
                    .toDateString();
            source.sakuseiJoken2 = 作成条件_投票日.concat(投票開始日).concat(記号).concat(投票終了日);
        } else {
            source.sakuseiJoken2 = 作成条件_投票日.concat(作成条件);
        }
    }

    private void edit改ページ(KijitsumaeNippoReportSource source) {
        source.senkyoNo = data.get投票状況情報().get選挙番号();
        source.shisetsuCode = data.get投票状況情報().get施設コード();
    }
}
