/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 期日前投票録対象投票クラスです
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuCommon {

    /**
     * コンストラクス。
     */
    protected KijitsumaeTohyorokuCommon() {

    }
    /**
     * 日期連絡符号から
     */
    protected static final RString から = new RString("から");
    /**
     * 時間連絡符号～
     */
    protected static final RString 時間連絡符号 = new RString("～");
    /**
     * 仮投票あり
     */
    protected static final RString 仮投票あり = new RString("有");
    /**
     * 仮投票なし
     */
    protected static final RString 仮投票なし = new RString("無");
    /**
     * 別紙に記載
     */
    protected static final RString 別紙に記載 = new RString("別紙に記載");
    /**
     * タイトル_期日前投票所投票録
     */
    protected static final RString タイトル_期日前投票所投票録 = new RString("期日前投票所投票録");
    /**
     * タイトル_当日投票所投票録
     */
    protected static final RString タイトル_当日投票所投票録 = new RString("当日投票所投票録");

    /**
     * タイトル_符号左
     */
    protected static final RString タイトル_符号左 = new RString("（");
    /**
     * タイトル_符号右
     */
    protected static final RString タイトル_符号右 = new RString("）");
    /**
     * タイトル_別紙
     */
    protected static final RString タイトル_別紙 = new RString("別紙");
    /**
     * 投票種類タイトル
     */
    protected static final RString 投票種類タイトル = new RString("期日前");
    /**
     * 氏名_上段表示可能数
     */
    protected static final int 氏名_上段表示可能数 = 10;
    /**
     * 事由_上段表示可能数
     */
    protected static final int 事由_上段表示可能数 = 10;
    /**
     * 代理投票者1枚に表示最大数
     */
    protected static final int 代理投票者_表示可能数 = 5;

    /**
     * 投票者リスト用index
     */
    public enum TohyoshaIndex {

        /**
         * 選任者1
         */
        選任者1(1),
        /**
         * 選任者2
         */
        選任者2(2),
        /**
         * 選任者3
         */
        選任者3(3),
        /**
         * 選任者4
         */
        選任者4(4),
        /**
         * 選任者5
         */
        選任者5(5),
        /**
         * 投票管理者1
         */
        投票管理者1(1),
        /**
         * 投票管理者2
         */
        投票管理者2(2),
        /**
         * 投票管理者3
         */
        投票管理者3(3),
        /**
         * 再交付者1
         */
        再交付者1(1),
        /**
         * 再交付者2
         */
        再交付者2(2),
        /**
         * 決定投票者1
         */
        決定投票者1(1),
        /**
         * 決定投票者2
         */
        決定投票者2(2),
        /**
         * 決定投票者3
         */
        決定投票者3(3),
        /**
         * 決定投票者4
         */
        決定投票者4(4),
        /**
         * 決定投票者5
         */
        決定投票者5(5),
        /**
         * 決定投票者6
         */
        決定投票者6(6),
        /**
         * 決定投票者7
         */
        決定投票者7(7),
        /**
         * 決定投票者8
         */
        決定投票者8(8),
        /**
         * 返還者1
         */
        返還者1(1),
        /**
         * 返還者2
         */
        返還者2(2),
        /**
         * 返還者3
         */
        返還者3(3),
        /**
         * 返還者4
         */
        返還者4(4),
        /**
         * 返還者5
         */
        返還者5(5),
        /**
         * 返還者6
         */
        返還者6(6),
        /**
         * 返還者7
         */
        返還者7(7),
        /**
         * 返還者8
         */
        返還者8(8),
        /**
         * 法1投票拒否者1
         */
        法1投票拒否者1(1),
        /**
         * 法1投票拒否者2
         */
        法1投票拒否者2(2),
        /**
         * 法1投票拒否者3
         */
        法1投票拒否者3(3),
        /**
         * 法2投票拒否者1
         */
        法2投票拒否者1(1),
        /**
         * 法2投票拒否者2
         */
        法2投票拒否者2(2),
        /**
         * 法2投票拒否者3
         */
        法2投票拒否者3(3);

        private final int index;

        TohyoshaIndex(int index) {
            this.index = index;
        }

        /**
         * Indexを返す。
         *
         * @return Index
         */
        public int getIndex() {
            return this.index;
        }

        /**
         * ListIndexを返す。
         *
         * @return ListIndex
         */
        public int getListIndex() {
            return this.index - 1;
        }
    }

    private static final RString 年 = new RString("年");

    /**
     * パターン12の年月日を返す。
     *
     * @param target target
     * @return パターン12の年月日
     */
    protected static RString getKanjiYmd(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }
        return target.wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
    }

    /**
     * コンマ区切り数字を返す。
     *
     * @param target target
     * @return コンマ区切り数字
     */
    protected static RString getFormatNumber(Decimal target) {
        if (null == target) {
            return new RString(Decimal.ZERO.toString());
        }
        return DecimalFormatter.toコンマ区切りRString(target, 0);
    }

    /**
     * パターン143の時分を返す。
     *
     * @param target target
     * @return パターン143の時分
     */
    protected static RString getFormatTimeEn(RTime target) {
        if (null == target) {
            return new RString("     ");
        }
        return target.toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    /**
     * パターン144の時分を返す。
     *
     * @param target target
     * @return パターン144の時分
     */
    protected static RString getFormatTimeKanji(RTime target) {
        if (null == target) {
            return RString.EMPTY;
        }
        return target.toFormattedTimeString(DisplayTimeFormat.HH時mm分);
    }

    /**
     * 字符を截取
     *
     * @param target target
     * @param index index
     * @param endFlg 開始あるいは終了(TRUE:終了位置 | FALSE:開始位置)
     * @return 截取後の字符
     */
    protected static RString getSubString(RString target, int index, boolean endFlg) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }

        if (endFlg) {
            return target.length() <= index ? target : target.substring(0, index);
        } else {
            return target.length() <= index ? RString.EMPTY : target.substring(index);
        }
    }

    /**
     * 年/月日を截取
     *
     * @param target target
     * @param endFlg 年/月日(TRUE:年 | FALSE:月日)
     * @return 截取後の字符
     */
    protected static RString getSubFlexibleDate(FlexibleDate target, boolean endFlg) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }

        RString result = getKanjiYmd(target);

        return endFlg ? result.substring(0, result.indexOf(年) + 1) : result.substring(result.indexOf(年) + 1);
    }

    /**
     * 立会時間の取得（立会時間開始～立会時間終了）
     *
     * @param 立会時間開始 立会時間開始
     * @param 立会時間終了 立会時間終了
     * @return 立会時間 立会時間
     */
    protected static RString getTachiaiJikan(RTime 立会時間開始, RTime 立会時間終了) {
        if (null == 立会時間開始 && null == 立会時間終了) {
            return RString.EMPTY;
        }
        return getFormatTimeEn(立会時間開始).concat(時間連絡符号).concat(getFormatTimeEn(立会時間終了));
    }
}
