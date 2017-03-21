package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 送致書の投票使用汚損残余枚数欄に印字するための、投票用紙枚数を選挙、投票区別に管理する。テーブルの項目定義クラスです。
 */
public enum AfT251TohyoYoshiMaisuKanri implements IColumnDefinition {
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
     * 選挙番号
     */
    senkyoNo(2147483647, 0),
    /**
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * 投票用紙枚数
     */
    tohyoYoshiMaisu(10, 0),
    /**
     * 点字投票用紙枚数
     */
    tenjiYoshiMaisu(10, 0),
    /**
     * 仮投票用封筒枚数
     */
    kariFutoMaisu(10, 0);

    private final int maxLength;
    private final int scale;

    private AfT251TohyoYoshiMaisuKanri(int maxLength, int scale) {
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
