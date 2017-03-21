package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 在外選挙資格の申請時に使用する。申請書提出の宛先となる。
「領事館」ではない。テーブルの項目定義クラスです。
 */
public enum AfT510Ryojikan implements IColumnDefinition {
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
     * 領事官コード
     */
    ryojikanCode(3, 0),
    /**
     * 領事官名称
     */
    ryojikanName(50, 0),
    /**
     * カナ領事官名称
     */
    kanaRyojikanName(100, 0),
    /**
     * 検索用カナ領事官名称
     */
    searchKanaRyojikanName(100, 0),
    /**
     * 表示順
     */
    hyojijun(5, 0);

    private final int maxLength;
    private final int scale;

    private AfT510Ryojikan(int maxLength, int scale) {
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
