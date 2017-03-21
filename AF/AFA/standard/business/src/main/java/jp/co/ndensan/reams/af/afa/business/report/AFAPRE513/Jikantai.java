/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 時間帯のクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class Jikantai {

    private static final RString 時間帯_SPLITOR = new RString("～");
    private static final RString 時間帯_HHMM_SPLITOR = new RString("：");

    private static final int ONE_HOUR = 60;

    private final List<RTime> 集計時間帯リスト;
    private final List<Decimal> 時間帯の時間差リスト;
    private final Decimal 時間帯の時間差合計;
    private final List<RString> 時間帯リスト;

    /**
     * コンストラクタです。
     *
     */
    public Jikantai() {

        RString 集計時間帯 = BusinessConfig.get(ConfigKeysAFA.時間別投票状況表_集計時間帯, SubGyomuCode.AFA選挙本体);
        List<RString> 集計時間帯リストRSting = 集計時間帯.split(",");

        集計時間帯リスト = new ArrayList<>();
        時間帯の時間差リスト = new ArrayList<>();
        時間帯リスト = new ArrayList<>();
        Decimal 時間差合計 = Decimal.ZERO;

        for (RString 集計時間 : 集計時間帯リストRSting) {
            集計時間帯リスト.add(new RTime(集計時間).withSecond(0).withMillisOfSecond(0));
        }
        for (int i = 0; i < 集計時間帯リスト.size() - 1; i++) {
            RTime before = 集計時間帯リスト.get(i);
            RTime after = 集計時間帯リスト.get(i + 1);
            Decimal 時間差 = new Decimal(after.getHour() - before.getHour())
                    .add(new Decimal(after.getMinute() - before.getMinute()).divide(ONE_HOUR));
            時間帯の時間差リスト.add(時間差);
            時間差合計 = 時間差合計.add(時間差);
            // Z9：99　～　Z9：99
            時間帯リスト.add(edit時間帯(集計時間帯リストRSting.get(i), 集計時間帯リストRSting.get(i + 1)));
        }
        時間帯の時間差合計 = 時間差合計;

    }

    private RString edit時間帯(RString before, RString after) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(before.substring(0, 2).trimStart('0'));
        builder.append(時間帯_HHMM_SPLITOR);
        builder.append(before.substring(2));

        builder.append(時間帯_SPLITOR);

        builder.append(after.substring(0, 2).trimStart('0'));
        builder.append(時間帯_HHMM_SPLITOR);
        builder.append(after.substring(2));

        return builder.toRString();
    }

    /**
     * 所属時間帯を取得します。
     *
     * @param target RTime
     * @return index
     */
    public JikantaiType get時間帯Index(RTime target) {
        if (target != null) {
            for (int i = 0; i < 集計時間帯リスト.size() - 1; i++) {
                RTime before = 集計時間帯リスト.get(i);
                RTime after = 集計時間帯リスト.get(i + 1);
                if ((before.equals(target) || before.isBefore(target))
                        && after.isAfter(target)) {
                    return JikantaiType.valueOf(i);
                }
            }
        }
        return null;
    }

    /**
     * 時間帯を取得します。
     *
     * @param type JikantaiType
     * @return RString
     */
    public RString get時間帯(JikantaiType type) {
        return get時間帯(type.getIndex());
    }

    /**
     * 時間帯を取得します。
     *
     * @param i int
     * @return RString
     */
    public RString get時間帯(int i) {
        return 時間帯リスト.get(i);
    }

    /**
     * 時間帯の時間差を取得します。
     *
     * @param type JikantaiType
     * @return Decimal
     */
    public Decimal get時間帯の時間差(JikantaiType type) {
        return get時間帯の時間差(type.getIndex());
    }

    /**
     * 時間帯の時間差を取得します。
     *
     * @param i int
     * @return Decimal
     */
    public Decimal get時間帯の時間差(int i) {
        return 時間帯の時間差リスト.get(i);
    }

    /**
     * 時間帯です。
     */
    public static enum JikantaiType {

        /**
         * 時間帯１
         */
        時間帯１(0),
        /**
         * 時間帯２
         */
        時間帯２(1),
        /**
         * 時間帯３
         */
        時間帯３(2),
        /**
         * 時間帯４
         */
        時間帯４(3);

        private JikantaiType(int index) {
            this.index = index;
        }

        private final int index;

        /**
         * インデックスを取得します。
         *
         * @return インデックス
         */
        public int getIndex() {
            return this.index;
        }

        /**
         * 時間帯を取得します。
         *
         * @param index int
         * @return 時間帯
         */
        public static JikantaiType valueOf(int index) {
            for (JikantaiType jikantaiType : JikantaiType.values()) {
                if (jikantaiType.index == index) {
                    return jikantaiType;
                }
            }
            return null;
        }
    }
}
