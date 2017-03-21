package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.FuzaishaTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 不在者投票者一覧表
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListEditor implements IFuzaishaTohyoshaListEditor {

    private static final RString タイトル = new RString("不在者投票者一覧表");
    private static final RString サブタイトル１ = new RString("（請求のみ）");
    private static final RString サブタイトル２ = new RString("（未着者）");
    private static final RString サブタイトル３ = new RString("（代理投票）");
    private static final RString サブタイトル４ = new RString("（点字投票）");
    private static final RString サブタイトル５ = new RString("（返還）");
    private static final RString サブタイトル６ = new RString("（棄権）");
    private static final RString 投票区分１ = new RString("1");
    private static final RString 投票区分２ = new RString("2");
    private static final RString 投票区分３ = new RString("3");
    private static final RString 投票区分４ = new RString("4");
    private static final RString 投票区分５ = new RString("5");
    private static final RString 投票区分６ = new RString("6");
    private static final RString ラベル区分 = new RString("施設種別");
    private static final RString ラベル日付１ = new RString("交付日付");
    private static final RString ラベル日付２ = new RString("受理日付");
    private static final RString 記号１ = new RString("-");
    private static final RString 記号２ = new RString("～");
    private static final RString 投票状況コード１ = new RString("4");
    private static final RString 投票状況コード２ = new RString("5");
    private static final RString 投票状況コード３ = new RString("8");
    private static final RString 投票状況コード４ = new RString("9");
    private static final RString 全角スペース = new RString("　");
    private static final RString 代 = new RString("代");
    private static final RString 点 = new RString("点");
    private static final RString 作成条件１_前 = new RString("投票区コード：");
    private static final RString 作成条件１_後 = new RString("施設コード：");
    private static final RString 作成条件２書式_１ = new RString("交付日：");
    private static final RString 作成条件２書式_２ = new RString("受理日：");
    private static final RString 作成条件３書式 = new RString("受理時刻：");
    private static final RString 書式_中 = new RString("　　");
    private static final RString 投票区コード = new RString("tohyokuCode");
    private static final RString 受付番号 = new RString("uketsukeNo");
    private static final RString 作成条件 = new RString("指定なし");

    private final FuzaishaTohyoshaListParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link FuzaishaTohyoshaListParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public FuzaishaTohyoshaListEditor(FuzaishaTohyoshaListParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
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
    public KijitsumaeTohyoshaListReportSource edit(KijitsumaeTohyoshaListReportSource source) {
        editヘッダ(source);
        editタイトル(source);
        editサブタイトル(source);
        edit投票区(source);
        editラベル(source);
        edit受付番号(source);
        edit名簿番号(source);
        edit氏名(source);
        edit性別(source);
        edit年齢(source);
        edit事由(source);
        edit施設(source);
        edit日付(source);
        edit方法等(source);
        edit合計エリア１(source);
        edit合計エリア２(source);
        edit作成条件(source);
        edit改ページ(source);
        return source;
    }

    private void editヘッダ(KijitsumaeTohyoshaListReportSource source) {
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.senkyoMei = 帳票共通ヘッダー.get選挙名称();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.page = data.getページ();
    }

    private void editタイトル(KijitsumaeTohyoshaListReportSource source) {
        source.title = タイトル;
    }

    private void editサブタイトル(KijitsumaeTohyoshaListReportSource source) {
        RString サブタイトル = data.get不在者投票者明細().getサブタイトル();
        if (投票区分１.equals(サブタイトル)) {
            source.subTitle = サブタイトル１;
        } else if (投票区分２.equals(サブタイトル)) {
            source.subTitle = サブタイトル２;
        } else if (投票区分３.equals(サブタイトル)) {
            source.subTitle = サブタイトル３;
        } else if (投票区分４.equals(サブタイトル)) {
            source.subTitle = サブタイトル４;
        } else if (投票区分５.equals(サブタイトル)) {
            source.subTitle = サブタイトル５;
        } else if (投票区分６.equals(サブタイトル)) {
            source.subTitle = サブタイトル６;
        } else {
            source.subTitle = RString.EMPTY;
        }
    }

    private void edit投票区(KijitsumaeTohyoshaListReportSource source) {
        source.tohyokuCode = data.get不在者投票者明細().get投票区コード();
        source.tohyokuMei = data.get不在者投票者明細().get投票区名();
    }

    private void editラベル(KijitsumaeTohyoshaListReportSource source) {
        source.meisaiTitleLevelKubun = ラベル区分;
        source.meisaiTitleDate1 = ラベル日付１;
        source.meisaiTitleDate2 = ラベル日付２;
    }

    private void edit受付番号(KijitsumaeTohyoshaListReportSource source) {
        source.listMeisai_1 = data.get不在者投票者明細().get受付番号();
    }

    private void edit名簿番号(KijitsumaeTohyoshaListReportSource source) {
        RString 投票区 = data.get不在者投票者明細().get投票区();
        RString 頁 = data.get不在者投票者明細().get頁();
        RString 行 = data.get不在者投票者明細().get行();
        source.listMeisai_2 = changeNullToEmpty(投票区)
                .concat(記号１).concat(changeNullToEmpty(頁))
                .concat(記号１).concat(changeNullToEmpty(行));
    }

    private void edit氏名(KijitsumaeTohyoshaListReportSource source) {
        source.listMeisai_3 = data.get不在者投票者明細().get名称();
    }

    private void edit性別(KijitsumaeTohyoshaListReportSource source) {
        RString 性別コード = data.get不在者投票者明細().get性別コード();
        if (null != 性別コード && !性別コード.isEmpty()) {
            source.listMeisai_4 = Gender.toValue(data.get不在者投票者明細().get性別コード()).getCommonName();
        } else {
            source.listMeisai_4 = RString.EMPTY;
        }
    }

    private void edit年齢(KijitsumaeTohyoshaListReportSource source) {
        source.listMeisai_5 = get年齢(data.get不在者投票者明細().get生年月日());
    }

    private void edit事由(KijitsumaeTohyoshaListReportSource source) {
        Code 投票事由コード = data.get不在者投票者明細().get投票事由コード();
        source.listMeisai_6 = null == 投票事由コード ? RString.EMPTY : 投票事由コード.getColumnValue();
    }

    private void edit施設(KijitsumaeTohyoshaListReportSource source) {
        source.listMeisai_7 = data.get施設名();
        source.listMeisai_8 = data.get施設種別();
        source.shisetsuShubetsuMeisho = data.get施設種別名称();
        source.shisetsuShubetsuRyakusho = data.get施設種別略称();
    }

    private void edit日付(KijitsumaeTohyoshaListReportSource source) {
        Code 投票状況 = data.get不在者投票者明細().get投票状況コード();
        if (null != 投票状況 && !投票状況.isEmpty() && (投票状況コード１.equals(投票状況.value())
                || 投票状況コード２.equals(投票状況.value())
                || 投票状況コード３.equals(投票状況.value())
                || 投票状況コード４.equals(投票状況.value()))) {
            source.listMeisai_9 = CodeMaster.getCodeMeisho(AFACodeShubetsu.投票状況.getCodeShubetsu(), 投票状況);
            source.listMeisai_10 = CodeMaster.getCodeMeisho(AFACodeShubetsu.投票状況.getCodeShubetsu(), 投票状況);
        } else {
            RString 受理年月日 = RString.EMPTY;
            RString 受理時刻 = RString.EMPTY;
            if (null != data.get不在者投票者明細().get交付年月日()) {
                source.listMeisai_9 = data.get不在者投票者明細().get交付年月日().wareki().toDateString();
            }
            if (null != data.get不在者投票者明細().get受理年月日()) {
                受理年月日 = data.get不在者投票者明細().get受理年月日().wareki().toDateString();
            }
            if (null != data.get不在者投票者明細().get受理時刻()) {
                受理時刻 = data.get不在者投票者明細().get受理時刻().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            }
            if (受理年月日.isEmpty() || 受理時刻.isEmpty()) {
                source.listMeisai_10 = 受理年月日.concat(受理時刻);
            } else {
                source.listMeisai_10 = 受理年月日.concat(全角スペース).concat(受理時刻);
            }
        }
    }

    private void edit方法等(KijitsumaeTohyoshaListReportSource source) {
        if (null != data.get不在者投票者明細().get受理方法() && !data.get不在者投票者明細().get受理方法().isEmpty()) {
            RString 方法名称 = CodeMaster.getCodeMeisho(AFACodeShubetsu.交付_受理方法.getCodeShubetsu(),
                    data.get不在者投票者明細().get受理方法());
            source.listMeisai_11 = get受理方法名称(
                    data.get不在者投票者明細().is代理投票有フラグ(),
                    data.get不在者投票者明細().is点字フラグ(),
                    方法名称);
        } else {
            source.listMeisai_11 = RString.EMPTY;
        }
    }

    private void edit合計エリア１(KijitsumaeTohyoshaListReportSource source) {
        boolean 改頁フラグ = get改頁フラグ(data.get改頁リスト());
        if (改頁フラグ) {
            source.gokeiArea1 = data.get合計エリア１();
        } else {
            source.gokeiArea1 = RString.EMPTY;
        }
    }

    private void edit合計エリア２(KijitsumaeTohyoshaListReportSource source) {
        source.gokeiArea2 = data.get合計エリア2();
    }

    private void edit作成条件(KijitsumaeTohyoshaListReportSource source) {
        RString 作成条件1_1 = 作成条件;
        RString 作成条件1_2 = RString.EMPTY;
        if (null != data.get画面入力項目().get投票区コード開始()
                && !data.get画面入力項目().get投票区コード開始().isEmpty()) {
            作成条件1_1 = 作成条件１_前
                    .concat(data.get画面入力項目().get投票区コード開始())
                    .concat(記号２)
                    .concat(data.get画面入力項目().get投票区コード終了());
        }
        if (null != data.get画面入力項目().get施設コード開始()
                && !data.get画面入力項目().get施設コード開始().isEmpty()) {
            作成条件1_2 = 作成条件１_後
                    .concat(data.get画面入力項目().get施設コード開始())
                    .concat(記号２)
                    .concat(data.get画面入力項目().get施設コード終了());
        }
        if (作成条件1_1.isEmpty() || 作成条件1_2.isEmpty()) {
            source.sakuseiJoken1 = 作成条件1_1.concat(作成条件1_2);
        } else {
            source.sakuseiJoken1 = 作成条件1_1.concat(書式_中).concat(作成条件1_2);
        }

        RString 作成条件2_1 = RString.EMPTY;
        RString 作成条件2_2 = RString.EMPTY;
        if (null != data.get画面入力項目().get交付日開始()) {
            RString 交付日開始 = data.get画面入力項目().get交付日開始().wareki().toDateString();
            RString 交付日終了 = data.get画面入力項目().get交付日終了().wareki().toDateString();
            作成条件2_1 = 作成条件２書式_１
                    .concat(交付日開始)
                    .concat(記号２)
                    .concat(交付日終了);
        }
        if (null != data.get画面入力項目().get受理日開始()) {
            RString 受理日開始 = data.get画面入力項目().get受理日開始().wareki().toDateString();
            RString 受理日終了 = data.get画面入力項目().get受理日終了().wareki().toDateString();
            作成条件2_2 = 作成条件２書式_２
                    .concat(受理日開始)
                    .concat(記号２)
                    .concat(受理日終了);
        }
        if (作成条件2_1.isEmpty() || 作成条件2_2.isEmpty()) {
            source.sakuseiJoken2 = 作成条件2_1.concat(作成条件2_2);
        } else {
            source.sakuseiJoken2 = 作成条件2_1.concat(書式_中).concat(作成条件2_2);
        }

        if (null != data.get画面入力項目().get受理時刻開始()) {
            RString 受理開始時刻 = data.get画面入力項目().get受理時刻開始().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            RString 受理終了時刻 = data.get画面入力項目().get受理時刻終了().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            source.sakuseiJoken3 = 作成条件３書式
                    .concat(受理開始時刻)
                    .concat(記号２)
                    .concat(受理終了時刻);
        }
    }

    private void edit改ページ(KijitsumaeTohyoshaListReportSource source) {
        if (data.get改頁リスト().size() >= 2
                && !RString.isNullOrEmpty(data.get改頁リスト().get(1))) {
            source.key2 = get改ページKey(data.get改頁リスト().get(1));
        }
        if (data.get改頁リスト().size() >= 1
                && !RString.isNullOrEmpty(data.get改頁リスト().get(0))) {
            source.key1 = get改ページKey(data.get改頁リスト().get(0));
        }
    }

    private RString get改ページKey(RString ページキー) {
        if (投票区コード.equals(ページキー)) {
            return data.get不在者投票者明細().get投票区コード();
        } else if (受付番号.equals(ページキー)) {
            return data.get不在者投票者明細().get受付番号();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get年齢(FlexibleDate 生年月日) {
        if (null == 生年月日 || 生年月日.isEmpty() || !生年月日.isValid()) {
            return RString.EMPTY;
        }
        RDate システム日付 = RDate.getNowDate();
        int 年齢 = システム日付.getYearValue() - 生年月日.getYearValue();
        if (システム日付.getMonthValue() < 生年月日.getMonthValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        if (システム日付.getMonthValue() > 生年月日.getMonthValue()) {
            return new RString(Integer.toString(年齢));
        }
        if (システム日付.getDayValue() < 生年月日.getDayValue()) {
            return new RString(Integer.toString(年齢 - 1));
        }
        return new RString(Integer.toString(年齢));
    }

    private boolean get改頁フラグ(List<RString> 改頁リスト) {
        boolean 改頁フラグ = false;
        if (null != 改頁リスト && !改頁リスト.isEmpty()) {
            for (RString 改頁 : 改頁リスト) {
                if (投票区コード.equals(改頁)) {
                    改頁フラグ = true;
                    break;
                }
            }
        }
        return 改頁フラグ;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private RString get受理方法名称(boolean flg1, boolean flg2, RString 受理方法名称) {

        if (flg1) {
            受理方法名称 = 受理方法名称.concat(全角スペース).concat(代);
        }
        if (flg2) {
            if (flg1) {
                受理方法名称 = 受理方法名称.concat(点);
            } else {
                受理方法名称 = 受理方法名称.concat(全角スペース).concat(点);
            }
        }

        return 受理方法名称;
    }
}
