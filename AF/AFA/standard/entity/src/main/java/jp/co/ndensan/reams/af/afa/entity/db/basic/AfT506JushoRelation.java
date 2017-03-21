package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 選挙種類別に、住所から自動設定される投票区コードの情報を保持する。
通常選挙（定時、国政、地方）は、UR住所番地対応で対応する。テーブルの項目定義クラスです。
 */
public enum AfT506JushoRelation implements IColumnDefinition {
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
     * 選挙種類
     */
    senkyoShurui(2147483647, 0),
    /**
     * 町域コード
     */
    choikiCode(2147483647, 0),
    /**
     * 開始番地1
     */
    kaishiBanchi1BanchiCode(2147483647, 0),
    /**
     * 開始番地2
     */
    kaishiBanchi2BanchiCode(2147483647, 0),
    /**
     * 開始番地3
     */
    kaishiBanchi3BanchiCode(2147483647, 0),
    /**
     * 開始番地4
     */
    kaishiBanchi4BanchiCode(2147483647, 0),
    /**
     * 終了番地1
     */
    shuiryoBanchi1BanchiCode(2147483647, 0),
    /**
     * 終了番地2
     */
    shuiryoBanchi2BanchiCode(2147483647, 0),
    /**
     * 終了番地3
     */
    shuiryoBanchi3BanchiCode(2147483647, 0),
    /**
     * 終了番地4
     */
    shuiryoBanchi4BanchiCode(2147483647, 0),
    /**
     * 投票区コード
     */
    tohyokuCode(4, 0);

    private final int maxLength;
    private final int scale;

    private AfT506JushoRelation(int maxLength, int scale) {
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
