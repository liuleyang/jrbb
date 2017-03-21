/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokekkashukeisakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.Order;

/**
 * 投票結果集計表のビジネスクラスです。
 *
 * @reamsid_L AF-0290-030 lit
 */
public class TohyoKekkaShukeihyo {

    private static final int 年齢_100 = 100;
    private static final int 年齢_五用 = 5;
    private static final int 年齢_四用 = 4;

    /**
     * ラベル種類
     */
    public enum LabelShurui {

        /**
         * 年齢
         */
        年齢(new RString("1")),
        /**
         * 年代
         */
        年代(new RString("2"));

        private final RString key;

        LabelShurui(RString key) {
            this.key = key;
        }

        /**
         * keyを返す。
         *
         * @return key
         */
        public RString getKey() {
            return this.key;
        }
    }

    /**
     * 年代種類
     */
    public enum NendaiShurui {

        /**
         * 年代_10代
         */
        年代_10代(20, 1, new RString("10 代"), 10, 19),
        /**
         * 年代_20代
         */
        年代_20代(30, 2, new RString("20 代"), 20, 29),
        /**
         * 年代_30代
         */
        年代_30代(40, 3, new RString("30 代"), 30, 39),
        /**
         * 年代_40代
         */
        年代_40代(50, 4, new RString("40 代"), 40, 49),
        /**
         * 年代_50代
         */
        年代_50代(60, 5, new RString("50 代"), 50, 59),
        /**
         * 年代_60代
         */
        年代_60代(70, 6, new RString("60 代"), 60, 69),
        /**
         * 年代_70代
         */
        年代_70代(80, 7, new RString("70 代"), 70, 79),
        /**
         * 年代_80代
         */
        年代_80代(90, 8, new RString("80 代"), 80, 89),
        /**
         * 年代_90代
         */
        年代_90代(100, 9, new RString("90 代"), 90, 99),
        /**
         * 年代_100以上
         */
        年代_100以上(100, 10, new RString("100以上"), 100, 999);
        private final int 到達年齢;
        private final int order;
        private final RString 表示内容;
        private final int from年齢;
        private final int to年齢;

        private NendaiShurui(int 到達年齢, int order, RString 表示内容, int from年齢, int to年齢) {
            this.到達年齢 = 到達年齢;
            this.order = order;
            this.表示内容 = 表示内容;
            this.from年齢 = from年齢;
            this.to年齢 = to年齢;
        }

        /**
         * 到達年齢を返す。
         *
         * @return 到達年齢 int
         */
        public int get到達年齢() {
            return this.到達年齢;
        }

        /**
         * orderを返す。
         *
         * @return order int
         */
        public int getOrder() {
            return this.order;
        }

        /**
         * 表示内容を返す。
         *
         * @return 表示内容 RString
         */
        public RString get表示内容() {
            return this.表示内容;
        }

        /**
         * from年齢を返す。
         *
         * @return from年齢 int
         */
        public int getFrom年齢() {
            return this.from年齢;
        }

        /**
         * to年齢を返す。
         *
         * @return to年齢 int
         */
        public int getTo年齢() {
            return this.to年齢;
        }
    }

    /**
     * 年齢・年代ラベル取得処理。
     *
     * @param ラベル種類 LabelShurui
     * @param ソート順 Order
     *
     * @return ラベルリスト List<RString>
     */
    public List<RString> get年齢年代ラベル(LabelShurui ラベル種類, Order ソート順) {
        List<RString> ラベルリスト = new ArrayList<>();

        RString 選挙資格到達年齢Str = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢);
        if (null == 選挙資格到達年齢Str || 選挙資格到達年齢Str.isEmpty()) {
            return ラベルリスト;
        }

        int 選挙資格到達年齢 = Integer.valueOf(選挙資格到達年齢Str.toString());

        if (LabelShurui.年代.equals(ラベル種類)) {

            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_10代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_20代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_30代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_40代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_50代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_60代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_70代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_80代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_90代, 選挙資格到達年齢);
            ラベルリスト追加(ラベルリスト, NendaiShurui.年代_100以上, 選挙資格到達年齢);

            if (Order.DESC.equals(ソート順)) {
                Collections.reverse(ラベルリスト);
            }
            ラベルリスト.add(new RString("不正データ"));
            ラベルリスト.add(new RString("** 合計 **"));
        } else if (LabelShurui.年齢.equals(ラベル種類)) {

            到達年齢前にラベルリスト追加(選挙資格到達年齢, ラベルリスト);
            ラベルリスト.add(new RString("100以上計"));

            if (Order.DESC.equals(ソート順)) {
                Collections.reverse(ラベルリスト);
            }
            ラベルリスト.add(new RString("不正データ"));
            ラベルリスト.add(new RString("** 合計 **"));
        }

        return ラベルリスト;
    }

    private void 到達年齢前にラベルリスト追加(int 到達年齢, List<RString> ラベルリスト) {
        for (int i = 到達年齢; i < 年齢_100; i++) {
            ラベルリスト.add(new RString(String.valueOf(i)));
            if (i % 年齢_五用 != 年齢_四用) {
                continue;
            }
            int start = 到達年齢;
            if (i - 年齢_四用 > 到達年齢) {
                start = i - 年齢_四用;
            }
            ラベルリスト.add(new RString(String.valueOf(start))
                    .concat(new RString("～"))
                    .concat(new RString(String.valueOf(i)))
                    .concat(new RString("計")));
        }
    }

    private void ラベルリスト追加(List<RString> target, NendaiShurui 年代種類, int 選挙資格到達年齢) {
        if (選挙資格到達年齢 < 年代種類.get到達年齢()) {
            target.add(年代種類.表示内容);
        }
    }
}
