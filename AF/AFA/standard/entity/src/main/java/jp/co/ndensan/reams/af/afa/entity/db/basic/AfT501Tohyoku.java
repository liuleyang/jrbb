package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 定時、国政、地方選挙以外の選挙種類別に投票区情報を保持する。
定時、国政、地方選挙は、URの投票区を使用する。テーブルの項目定義クラスです。
 */
public enum AfT501Tohyoku implements IColumnDefinition {
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
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * 投票区名
     * <br/>通常選挙時：UR投票区から取得、修正不可。 その他：自テーブルから取得、修正可能。
     */
    tohyokuName(30, 0),
    /**
     * カナ投票区名
     * <br/>　〃
     */
    kanaTohyokuName(60, 0),
    /**
     * 検索用カナ投票区名
     * <br/>　〃
     */
    searchKanaTohyokuName(60, 0),
    /**
     * 表示順
     * <br/>　〃
     */
    hyojijun(5, 0);

    private final int maxLength;
    private final int scale;

    private AfT501Tohyoku(int maxLength, int scale) {
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
