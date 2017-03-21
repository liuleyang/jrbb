package jp.co.ndensan.reams.af.afa.business.report.AFAPRB213;

import jp.co.ndensan.reams.af.afa.business.core.NninIjoSetaiListParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListEditor implements INninIjoSetaiListEditor {

    private static final RString 作成 = new RString("作成");
    private static final RString 入場券_送付先住所編集_11 = new RString("11");
    private static final RString 入場券_送付先住所編集_12 = new RString("12");
    private static final RString 入場券_送付先住所編集_13 = new RString("13");
    private static final RString 空白 = new RString(" ");
    private static final RString 全角スペース = new RString("　");
    private static final RString 基準日 = new RString("（基準日:");
    private static final RString 投票年月日 = new RString("　投票年月日:");
    private static final RString 帳票タイトル = new RString("人以上世帯一覧表");
    private static final RString 右括弧 = new RString(")");
    private static final RString 左括弧 = new RString("(");
    private static final RString 連結標識 = new RString("-");
    private static final int 桁数_頁 = 6;
    private static final int 桁数_行 = 2;

    private final NninIjoSetaiListParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link NninIjoSetaiListParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public NninIjoSetaiListEditor(NninIjoSetaiListParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * n人以上世帯一覧表エディットメソッド
     *
     * @param source n人以上世帯一覧表
     * @return n人以上世帯一覧表
     */
    @Override
    public NninIjoSetaiListSource edit(NninIjoSetaiListSource source) {
        setヘッダ(source);
        edit投票区(source);
        edit名簿番号(source);
        edit住所(source);
        edit世帯コード(source);
        edit世帯主名(source);
        edit世帯員数(source);
        edit作成条件(source);
        return source;
    }

    private void setヘッダ(NninIjoSetaiListSource source) {
        RString 世帯人数 = new RString(data.get世帯一覧表情報().get抽出対象世帯人数());
        source.title = 世帯人数.concat(帳票タイトル);
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        RString 年月日 = FlexibleDate.getNowDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
        RString 時分 = RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        source.sakuseiNichiji = 年月日.concat(時分).concat(作成);
//        source.senkyoMei =
    }

    private void edit投票区(NninIjoSetaiListSource source) {
        source.listMeisai_1 = data.get世帯一覧表情報().get投票区コード();
    }

    private void edit名簿番号(NninIjoSetaiListSource source) {
        if (null != data.get世帯一覧表情報()) {
            source.listMeisai_2 = changeNullToEmpty(data.get世帯一覧表情報().get名簿番号_頁().padLeft(空白, 桁数_頁)).concat(連結標識)
                    .concat(changeNullToEmpty(data.get世帯一覧表情報().get名簿番号_行().padLeft(空白, 桁数_行)));
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private void edit住所(NninIjoSetaiListSource source) {
        RString 入場券_送付先住所編集 = BusinessConfig.get(ConfigKeysAFA.入場券_送付先住所編集, SubGyomuCode.AFA選挙本体);
        RString 編集用送付先住所 = RString.EMPTY;
        if (null != data.get世帯一覧表情報()) {
            RString 住登内住所 = null == data.get世帯一覧表情報().get住登内住所() ? RString.EMPTY : data.get世帯一覧表情報().get住登内住所().getColumnValue();
            RString 住登内番地 = null == data.get世帯一覧表情報().get住登内番地() ? RString.EMPTY : data.get世帯一覧表情報().get住登内番地().getColumnValue();
            RString 住登内方書 = null == data.get世帯一覧表情報().get住登内方書() ? RString.EMPTY : data.get世帯一覧表情報().get住登内方書().getColumnValue();
            RString 行政区名 = null == data.get世帯一覧表情報().get行政区名() ? RString.EMPTY : data.get世帯一覧表情報().get行政区名();
            if (入場券_送付先住所編集_11.equals(入場券_送付先住所編集)) {
                編集用送付先住所 = 住登内住所.replace(空白, RString.EMPTY).replace(全角スペース, RString.EMPTY)
                        .concat(住登内番地.replace(空白, RString.EMPTY)).replace(全角スペース, RString.EMPTY)
                        .concat(全角スペース).concat(住登内方書);
            }
            if (入場券_送付先住所編集_12.equals(入場券_送付先住所編集)) {
                編集用送付先住所 = 行政区名.replace(空白, RString.EMPTY).replace(全角スペース, RString.EMPTY)
                        .concat(住登内番地.replace(空白, RString.EMPTY)).replace(全角スペース, RString.EMPTY)
                        .concat(全角スペース).concat(住登内方書);
            }
            if (入場券_送付先住所編集_13.equals(入場券_送付先住所編集)) {
                編集用送付先住所 = 住登内住所.replace(空白, RString.EMPTY).replace(全角スペース, RString.EMPTY)
                        .concat(左括弧)
                        .concat(行政区名.replace(空白, RString.EMPTY)).replace(全角スペース, RString.EMPTY)
                        .concat(右括弧)
                        .concat(住登内番地.replace(空白, RString.EMPTY)).replace(全角スペース, RString.EMPTY)
                        .concat(全角スペース).concat(住登内方書);
            }
        }
        source.listMeisai_3 = 編集用送付先住所;
    }

    private void edit世帯コード(NninIjoSetaiListSource source) {
        if (null != data.get世帯一覧表情報()) {
            source.listMeisai_4 = null == data.get世帯一覧表情報().get世帯コード() ? RString.EMPTY : data.get世帯一覧表情報().get世帯コード().getColumnValue();
        }
    }

    private void edit世帯主名(NninIjoSetaiListSource source) {
        if (null != data.get世帯一覧表情報()) {
            source.listMeisai_5 = null == data.get世帯一覧表情報().get世帯主名() ? RString.EMPTY : data.get世帯一覧表情報().get世帯主名().getColumnValue();
        }
    }

    private void edit世帯員数(NninIjoSetaiListSource source) {
        if (null != data.get世帯一覧表情報()) {
            RString 世帯員数 = new RString(data.get世帯一覧表情報().get世帯員数());
            source.listMeisai_6 = doZZZ_ZZ9編集(世帯員数);
        }
    }

    private void edit作成条件(NninIjoSetaiListSource source) {
        if (null != data.get世帯一覧表情報()) {
            RString 基準 = null == data.get入場券画面入力情報().get基準日() ? RString.EMPTY : data.get入場券画面入力情報().get基準日().wareki().toDateString();
            RString 年月日 = null == data.get入場券画面入力情報().get投票年月日() ? RString.EMPTY : data.get入場券画面入力情報().get投票年月日().wareki().toDateString();
            source.taishoKikan = 基準日.concat(基準).concat(投票年月日).concat(年月日).concat(右括弧);
        }
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }
    }
}
