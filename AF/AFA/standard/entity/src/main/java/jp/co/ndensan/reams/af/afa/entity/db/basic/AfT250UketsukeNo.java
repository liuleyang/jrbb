package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 不在者投票交付時、期日前投票時、当日投票時の受付番号を採番する。
さまざまな採番方法に対応できるようにする。テーブルの項目定義クラスです。
 */
public enum AfT250UketsukeNo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 抄本番号
     */
    shohonNo(2147483647, 0),
    /**
     * 施設種別
     * <br/>施設コード毎の採番の場合は使用不可。
     */
    shisetsuShubetsu(2147483647, 0),
    /**
     * コード
     * <br/>期日前、不在者の時は施設コード。 当日の時は投票区コード。 施設区分毎の採番の場合は使用不可。
     */
    code(4, 0),
    /**
     * 期日前不在者区分
     * <br/>不在者投票時と期日前投票時で別々に採番する場合に使用する。 0：通番（期日前と不在者の区別をしない） 1：期日前投票 2：不在者投票 3：当日投票
     */
    kijitsuFuzaiKubun(2147483647, 0),
    /**
     * 番号
     */
    currentNumber(19, 0),
    /**
     * MIN番号
     */
    minNumber(19, 0),
    /**
     * MAX番号
     */
    maxNumber(19, 0),
    /**
     * 有効桁数
     */
    effectiveDigit(5, 0);

    private final int maxLength;
    private final int scale;

    private AfT250UketsukeNo(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
