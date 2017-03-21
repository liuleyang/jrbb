package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 海区選挙に関する選挙人別の付随情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT133KaikuSenkyoFuzui implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 漁業者番号
     */
    gyogyoshaNo(10, 0),
    /**
     * 組合コード
     * <br/>漁業組合等
     */
    kumiaiCode(7, 0),
    /**
     * 漁業日数（漁業者）
     */
    nissuGyogyosha(5, 0),
    /**
     * 漁業日数（漁業従事者）
     */
    nissuJujisha(5, 0),
    /**
     * 漁業種類
     * <br/>例　1：漁船漁業、2：養殖、3：その他
     */
    gyogyoShurui(2147483647, 0),
    /**
     * 使用漁船種別
     * <br/>例　1：動力船、2：和船、3：その他
     */
    gyosenShubetsu(2147483647, 0),
    /**
     * 船名
     */
    senmei(20, 0),
    /**
     * 登録番号
     */
    torokuNo(20, 0);

    private final int maxLength;
    private final int scale;

    private AfT133KaikuSenkyoFuzui(int maxLength, int scale) {
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
