package jp.co.ndensan.reams.af.afa.business.report.AFAPRB212;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenMaisuhyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoEditor implements INyujokenMaisuhyoEditor {

    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 作成 = new RString("作成");
    private static final RString 投票区値 = new RString("10");
    private static final RString 投票区内容 = new RString("投票区");
    private static final RString 住所値 = new RString("11");
    private static final RString 住所内容 = new RString("住所");
    private static final RString 行政区値 = new RString("12");
    private static final RString 住行政区内容 = new RString("行政区");
    private static final RString 郵便番号値 = new RString("20");
    private static final RString 郵便番号内容 = new RString("郵便番号");
    private static final RString 基準日 = new RString("基準日:");
    private static final RString 投票年月日 = new RString("　投票年月日:");
    private static final RString 合計 = new RString("＊　合　　計　＊");

    private final NyujokenMaisuhyoParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param data {@link NyujokenMaisuhyoParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public NyujokenMaisuhyoEditor(NyujokenMaisuhyoParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 投票所入場券（ポステックス）エディットメソッド
     *
     * @param source 投票所入場券（ポステックス）
     * @return 投票所入場券（ポステックス）
     */
    @Override
    public NyujokenMaisuhyoSource edit(NyujokenMaisuhyoSource source) {
        setヘッダ(source);
        edit集計単位名称(source);
        edit集計(source);
        edit作成条件(source);
        return source;
    }

    private void edit作成条件(NyujokenMaisuhyoSource source) {
        if (null != data.get入場券画面入力情報() && null != data.get入場券画面入力情報().get基準日()
                && null != data.get入場券画面入力情報().get投票年月日()) {
            source.taishoKikan = 左括弧.concat(基準日).concat(data.get入場券画面入力情報().get基準日().wareki().toDateString())
                    .concat(投票年月日).concat(data.get入場券画面入力情報().get投票年月日().wareki().toDateString()).concat(右括弧);
        }
    }

    private void edit集計(NyujokenMaisuhyoSource source) {
        if (null != data.get世帯一覧表情報()) {
            source.listMeisai_1 = data.get世帯一覧表情報().get集計コード();
            source.listMeisai_2 = data.get世帯一覧表情報().get集計コード名称();

            if (data.get世帯一覧表情報().is合計Flag()) {
                source.listMeisai_2 = 合計;
                source.listMeisai_3 = changeNullToEmpty(data.get世帯一覧表情報().get印刷世帯数集計した値());
                source.listMeisai_4 = changeNullToEmpty(data.get世帯一覧表情報().get印刷枚数集計した値());
                source.listMeisai_5 = changeNullToEmpty(data.get世帯一覧表情報().get人数集計した値());
            } else {
                source.listMeisai_3 = data.get世帯一覧表情報().get印刷世帯数集計した値();
                source.listMeisai_4 = data.get世帯一覧表情報().get印刷枚数集計した値();
                source.listMeisai_5 = data.get世帯一覧表情報().get人数集計した値();
            }
        }
    }

    private void setヘッダ(NyujokenMaisuhyoSource source) {
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
    }

    private void edit集計単位名称(NyujokenMaisuhyoSource source) {
        RString 集計単位 = BusinessConfig.get(ConfigKeysAFA.入場券_印刷枚数表_集計単位, SubGyomuCode.AFA選挙本体);
        if (投票区値.equals(集計単位)) {
            source.shukeiTaniMeisho = 投票区内容;
        } else if (住所値.equals(集計単位)) {
            source.shukeiTaniMeisho = 住所内容;
        } else if (行政区値.equals(集計単位)) {
            source.shukeiTaniMeisho = 住行政区内容;
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.AFA選挙本体).equals(集計単位)) {
            source.shukeiTaniMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１);
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.AFA選挙本体).equals(集計単位)) {
            source.shukeiTaniMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
        } else if (BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.AFA選挙本体).equals(集計単位)) {
            source.shukeiTaniMeisho = JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２);
        } else if (郵便番号値.equals(集計単位)) {
            source.shukeiTaniMeisho = 郵便番号内容;
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
