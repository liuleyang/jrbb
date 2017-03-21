/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 時間別投票者集計表の集計用対象クラスです。
 *
 * @reamsid_L AF-0290-037 lit
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikanbetsuTohyoshaData {

    private RString 投票区コード = RString.EMPTY;
    private RString 投票所名称 = RString.EMPTY;
    private Map<RString, JikanbetsuLabelData> 投票区時間別Map;

    /**
     * 投票区時間別Mapを追加する。
     *
     * @param 時間帯 RString
     * @param isNull 投票区時間別Mapの初期化がNULLあるいはZERO
     */
    public void put(RString 時間帯, boolean isNull) {
        if (null == 投票区時間別Map) {
            投票区時間別Map = new HashMap<>();
        }
        投票区時間別Map.put(時間帯, new JikanbetsuLabelData(isNull));
    }

    /**
     * 指定したの時間帯の時間帯数をCountする。
     *
     * @param 時間帯 RString
     * @param sexFlg true:男|false:女
     */
    public void countUp(RString 時間帯, boolean sexFlg) {
        if (null == 投票区時間別Map) {
            投票区時間別Map = new HashMap<>();
        }
        if (!投票区時間別Map.containsKey(時間帯)) {
            this.put(時間帯, false);
        }
        投票区時間別Map.get(時間帯).countUp(sexFlg);
    }

    /**
     * 指定したの時間帯の時間帯数をCountする。
     *
     * @param 時間帯 RString
     * @param sexFlg true:男|false:女
     * @param addNum 追加数
     */
    public void countUp(RString 時間帯, boolean sexFlg, Decimal addNum) {
        if (null == addNum) {
            return;
        }
        if (null == 投票区時間別Map) {
            投票区時間別Map = new HashMap<>();
        }
        if (!投票区時間別Map.containsKey(時間帯)) {
            this.put(時間帯, false);
        }
        投票区時間別Map.get(時間帯).countUp(sexFlg, addNum);
    }

    /**
     * 指定したの時間帯の時間帯男数を返す。
     *
     * @param 時間帯 RString
     * @return 時間帯男数 Decimal
     */
    public Decimal get時間帯男数(RString 時間帯) {
        if (null == 投票区時間別Map || !投票区時間別Map.containsKey(時間帯)) {
            return Decimal.ZERO;
        }
        return 投票区時間別Map.get(時間帯).get時間帯男数();
    }

    /**
     * 指定したの時間帯の時間帯女数を返す。
     *
     * @param 時間帯 RString
     * @return 時間帯女数 Decimal
     */
    public Decimal get時間帯女数(RString 時間帯) {
        if (null == 投票区時間別Map || !投票区時間別Map.containsKey(時間帯)) {
            return Decimal.ZERO;
        }
        return 投票区時間別Map.get(時間帯).get時間帯女数();
    }

    /**
     * 指定したの時間帯の時間帯計数を返す。
     *
     * @param 時間帯 RString
     * @return 時間帯計数 Decimal
     */
    public Decimal get時間帯計数(RString 時間帯) {
        if (null == 投票区時間別Map || !投票区時間別Map.containsKey(時間帯)) {
            return Decimal.ZERO;
        }
        return 投票区時間別Map.get(時間帯).get時間帯計数();
    }

    /**
     * 合計ラベルを返す。
     *
     * @return 合計ラベル JikanbetsuLabelData
     */
    public JikanbetsuLabelData get合計ラベル() {
        if (null == 投票区時間別Map) {
            return null;
        }
        JikanbetsuLabelData 合計ラベル = new JikanbetsuLabelData(false);
        for (Map.Entry<RString, JikanbetsuLabelData> entry : 投票区時間別Map.entrySet()) {
            合計ラベル.set時間帯男数(null != entry.getValue().get時間帯男数()
                    ? 合計ラベル.get時間帯男数().add(entry.getValue().get時間帯男数()) : null);
            合計ラベル.set時間帯女数(null != entry.getValue().get時間帯女数()
                    ? 合計ラベル.get時間帯女数().add(entry.getValue().get時間帯女数()) : null);
        }
        return 合計ラベル;
    }

    /**
     * 投票区時間別用クラスです。
     */
    @lombok.Setter
    @lombok.Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    public static final class JikanbetsuLabelData {

        private Decimal 時間帯男数 = Decimal.ZERO;
        private Decimal 時間帯女数 = Decimal.ZERO;

        private JikanbetsuLabelData(boolean isNull) {
            if (isNull) {
                時間帯男数 = null;
                時間帯女数 = null;
            }
        }

        private JikanbetsuLabelData(Decimal 時間帯男数, Decimal 時間帯女数) {
            this.時間帯男数 = 時間帯男数;
            this.時間帯女数 = 時間帯女数;
        }

        /**
         * 時間帯計数を返す。
         *
         * @return 時間帯計数
         */
        public Decimal get時間帯計数() {
            return 時間帯男数.add(時間帯女数);
        }

        /**
         * 時間帯計数をCount。
         *
         * @param sexFlg true:男|false:女
         */
        public void countUp(boolean sexFlg) {
            if (sexFlg) {
                時間帯男数 = 時間帯男数.add(Decimal.ONE);
            } else {
                時間帯女数 = 時間帯女数.add(Decimal.ONE);
            }
        }

        /**
         * 時間帯計数をCount。
         *
         * @param sexFlg true:男|false:女
         * @param addNum 追加数
         */
        public void countUp(boolean sexFlg, Decimal addNum) {
            if (sexFlg) {
                時間帯男数 = 時間帯男数.add(addNum);
            } else {
                時間帯女数 = 時間帯女数.add(addNum);
            }
        }
    }
}
