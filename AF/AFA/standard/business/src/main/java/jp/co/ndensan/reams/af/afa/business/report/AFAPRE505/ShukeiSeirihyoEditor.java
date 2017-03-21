package jp.co.ndensan.reams.af.afa.business.report.AFAPRE505;

import jp.co.ndensan.reams.af.afa.business.core.ShukeiSeirihyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoEditor implements IShukeiSeirihyoEditor {

    private static final RString サブタイトル = new RString("（不在者投票分）");
    private static final RString 分 = new RString("分");
    private static final RString 現在累計 = new RString("現在累計");
    private static final RString 期日前計 = new RString("期日前計");
    private static final RString 不在者計 = new RString("不在者計");
    private static final RString 他市町村 = new RString("他市町村");
    private static final RString 病院施設 = new RString("病院施設");
    private static final RString 郵便投票 = new RString("郵便投票");
    private static final RString 船舶 = new RString("船舶");
    private static final RString 刑事施設 = new RString("刑事施設");
    private static final RString 少年院 = new RString("少年院");
    private static final RString 特定国外 = new RString("特定国外");
    private static final RString 指定なし = new RString("指定なし");
    private static final RString 作成条件１_書式 = new RString("投票区コード：");
    private static final RString 記号 = new RString("～");
    private final boolean 不在者投票フラグ;
    private final ShukeiSeirihyoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link ShukeiSeirihyoParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShukeiSeirihyoEditor(ShukeiSeirihyoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.不在者投票フラグ = data.is不在者投票フラグ();
    }

    /**
     * 不在者投票日報エディットメソッド
     *
     * @param source 不在者投票日報
     * @return 不在者投票日報
     */
    @Override
    public ShukeiSeirihyoReportSource edit(ShukeiSeirihyoReportSource source) {
        editヘッダ(source);
        editサブタイトル(source);
        edit選挙番号(source);
        edit受理_累計日付(source);
        edit見出し左_右(source);
        edit投票区(source);
        edit本庁(source);
        edit支所(source);
        edit項目１to５(source);
        edit項目６と７(source);
        edit合計(source);
        edit累計_本庁(source);
        edit累計_支所(source);
        edit累計_項目１to５(source);
        edit累計_項目６と７(source);
        edit累計_合計(source);
        edit作成条件(source);
        return source;
    }

    private void editヘッダ(ShukeiSeirihyoReportSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.senkyoMei = 帳票共通ヘッダー.get選挙名称();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.pagecnt = data.getページ();
    }

    private void editサブタイトル(ShukeiSeirihyoReportSource source) {
        if (不在者投票フラグ) {
            source.subTitle = サブタイトル;
        } else {
            source.subTitle = RString.EMPTY;
        }
    }

    private void edit選挙番号(ShukeiSeirihyoReportSource source) {
        source.senkyoNo = data.get選挙番号();
    }

    private void edit受理_累計日付(ShukeiSeirihyoReportSource source) {
        RString 受理_累計日付 = data.get画面入力項目().get受理日().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
        source.labelLeftYmd = 受理_累計日付.concat(分);
        source.labelRightYmd = 受理_累計日付.concat(現在累計);
    }

    private void edit見出し左_右(ShukeiSeirihyoReportSource source) {
        if (不在者投票フラグ) {
            source.labelLeft1 = 他市町村;
            source.labelLeft2 = 病院施設;
            source.labelLeft3 = 郵便投票;
            source.labelLeft4 = 船舶;
            source.labelLeft5 = 刑事施設;
            source.labelLeft6 = 少年院;
            source.labelLeft7 = 特定国外;
            source.labelRight1 = 他市町村;
            source.labelRight2 = 病院施設;
            source.labelRight3 = 郵便投票;
            source.labelRight4 = 船舶;
            source.labelRight5 = 刑事施設;
            source.labelRight6 = 少年院;
            source.labelRight7 = 特定国外;
        } else {
            source.labelLeft1 = RString.EMPTY;
            source.labelLeft2 = RString.EMPTY;
            source.labelLeft3 = RString.EMPTY;
            source.labelLeft4 = RString.EMPTY;
            source.labelLeft5 = RString.EMPTY;
            source.labelLeft6 = 期日前計;
            source.labelLeft7 = 不在者計;
            source.labelRight1 = RString.EMPTY;
            source.labelRight2 = RString.EMPTY;
            source.labelRight3 = RString.EMPTY;
            source.labelRight4 = RString.EMPTY;
            source.labelRight5 = RString.EMPTY;
            source.labelRight6 = 期日前計;
            source.labelRight7 = 不在者計;
        }
    }

    private void edit投票区(ShukeiSeirihyoReportSource source) {
        source.listTohyoku_1 = data.get投票区();
    }

    private void edit本庁(ShukeiSeirihyoReportSource source) {
        source.listMan_1 = data.get本庁_男();
        source.listWoman_1 = data.get本庁_女();
        source.listKei_1 = data.get本庁_計();
    }

    private void edit支所(ShukeiSeirihyoReportSource source) {
        source.listMan_2 = data.get支所_男();
        source.listWoman_2 = data.get支所_女();
        source.listKei_2 = data.get支所_計();
    }

    private void edit項目１to５(ShukeiSeirihyoReportSource source) {
        if (不在者投票フラグ) {
            source.listMan_3 = data.get項目１_男();
            source.listMan_4 = data.get項目２_男();
            source.listMan_5 = data.get項目３_男();
            source.listMan_6 = data.get項目４_男();
            source.listMan_7 = data.get項目５_男();
            source.listWoman_3 = data.get項目１_女();
            source.listWoman_4 = data.get項目２_女();
            source.listWoman_5 = data.get項目３_女();
            source.listWoman_6 = data.get項目４_女();
            source.listWoman_7 = data.get項目５_女();
            source.listKei_3 = data.get項目１_計();
            source.listKei_4 = data.get項目２_計();
            source.listKei_5 = data.get項目３_計();
            source.listKei_6 = data.get項目４_計();
            source.listKei_7 = data.get項目５_計();
        } else {
            source.listMan_3 = RString.EMPTY;
            source.listMan_4 = RString.EMPTY;
            source.listMan_5 = RString.EMPTY;
            source.listMan_6 = RString.EMPTY;
            source.listMan_7 = RString.EMPTY;
            source.listWoman_3 = RString.EMPTY;
            source.listWoman_4 = RString.EMPTY;
            source.listWoman_5 = RString.EMPTY;
            source.listWoman_6 = RString.EMPTY;
            source.listWoman_7 = RString.EMPTY;
            source.listKei_3 = RString.EMPTY;
            source.listKei_4 = RString.EMPTY;
            source.listKei_5 = RString.EMPTY;
            source.listKei_6 = RString.EMPTY;
            source.listKei_7 = RString.EMPTY;
        }
    }

    private void edit項目６と７(ShukeiSeirihyoReportSource source) {
        source.listMan_8 = data.get項目６_男();
        source.listMan_9 = data.get項目７_男();
        source.listWoman_8 = data.get項目６_女();
        source.listWoman_9 = data.get項目７_女();
        source.listKei_8 = data.get項目６_計();
        source.listKei_9 = data.get項目７_計();
    }

    private void edit合計(ShukeiSeirihyoReportSource source) {
        source.listMan_10 = data.get合計_男();
        source.listWoman_10 = data.get合計_女();
        source.listKei_10 = data.get合計_計();
    }

    private void edit累計_本庁(ShukeiSeirihyoReportSource source) {
        source.listMan_11 = data.get累計_本庁_男();
        source.listWoman_11 = data.get累計_本庁_女();
        source.listKei_11 = data.get累計_本庁_計();
    }

    private void edit累計_支所(ShukeiSeirihyoReportSource source) {
        source.listMan_12 = data.get累計_支所_男();
        source.listWoman_12 = data.get累計_支所_女();
        source.listKei_12 = data.get累計_支所_計();
    }

    private void edit累計_項目１to５(ShukeiSeirihyoReportSource source) {
        if (不在者投票フラグ) {
            source.listMan_13 = data.get累計_項目１_男();
            source.listMan_14 = data.get累計_項目２_男();
            source.listMan_15 = data.get累計_項目３_男();
            source.listMan_16 = data.get累計_項目４_男();
            source.listMan_17 = data.get累計_項目５_男();
            source.listWoman_13 = data.get累計_項目１_女();
            source.listWoman_14 = data.get累計_項目２_女();
            source.listWoman_15 = data.get累計_項目３_女();
            source.listWoman_16 = data.get累計_項目４_女();
            source.listWoman_17 = data.get累計_項目５_女();
            source.listKei_13 = data.get累計_項目１_計();
            source.listKei_14 = data.get累計_項目２_計();
            source.listKei_15 = data.get累計_項目３_計();
            source.listKei_16 = data.get累計_項目４_計();
            source.listKei_17 = data.get累計_項目５_計();
        } else {
            source.listMan_13 = RString.EMPTY;
            source.listMan_14 = RString.EMPTY;
            source.listMan_15 = RString.EMPTY;
            source.listMan_16 = RString.EMPTY;
            source.listMan_17 = RString.EMPTY;
            source.listWoman_13 = RString.EMPTY;
            source.listWoman_14 = RString.EMPTY;
            source.listWoman_15 = RString.EMPTY;
            source.listWoman_16 = RString.EMPTY;
            source.listWoman_17 = RString.EMPTY;
            source.listKei_13 = RString.EMPTY;
            source.listKei_14 = RString.EMPTY;
            source.listKei_15 = RString.EMPTY;
            source.listKei_16 = RString.EMPTY;
            source.listKei_17 = RString.EMPTY;
        }
    }

    private void edit累計_項目６と７(ShukeiSeirihyoReportSource source) {
        source.listMan_18 = data.get累計_項目６_男();
        source.listMan_19 = data.get累計_項目７_男();
        source.listWoman_18 = data.get累計_項目６_女();
        source.listWoman_19 = data.get累計_項目７_女();
        source.listKei_18 = data.get累計_項目６_計();
        source.listKei_19 = data.get累計_項目７_計();
    }

    private void edit累計_合計(ShukeiSeirihyoReportSource source) {
        source.listMan_20 = data.get累計_合計_男();
        source.listWoman_20 = data.get累計_合計_女();
        source.listKei_20 = data.get累計_合計_計();
    }

    private void edit作成条件(ShukeiSeirihyoReportSource source) {
        RString 投票区コード開始 = data.get画面入力項目().get投票区コード開始();
        RString 投票区コード終了 = data.get画面入力項目().get投票区コード終了();
        if (null != 投票区コード開始 && !投票区コード開始.isEmpty()
                && null != 投票区コード終了 && !投票区コード終了.isEmpty()) {
            source.sakuseiJoken1 = 作成条件１_書式
                    .concat(投票区コード開始)
                    .concat(記号)
                    .concat(data.get画面入力項目().get投票区コード終了());
        } else {
            source.sakuseiJoken1 = 指定なし;
        }
        source.sakuseiJoken2 = RString.EMPTY;
    }
}
