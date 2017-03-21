package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 直接請求の内容、期限日等を保持するテーブルの項目定義クラスです。
 */
public enum AfT401ChokusetsuSeikyu implements IColumnDefinition {
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
     * 直接請求番号
     */
    seikyuNo(5, 0),
    /**
     * 請求年月日
     */
    seikyuYMD(2147483647, 0),
    /**
     * 請求名
     */
    seikyuMei(20, 0),
    /**
     * 請求内容
     */
    seikyuNaiyo(2147483647, 0),
    /**
     * 交付年月日
     */
    kofuYMD(2147483647, 0),
    /**
     * 提出期限年月日
     */
    teishutsuKigenYMD(2147483647, 0),
    /**
     * 交付組織コード
     */
    kofuSoshikiCode(2147483647, 0),
    /**
     * 署名簿登録済フラグ
     * <br/>署名簿の入力がすべて済んだらTrueにする。
     */
    torokuZumiFlag(1, 0),
    /**
     * 抄本番号
     * <br/>チェックの基準とする抄本番号を設定する
     */
    shohonNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT401ChokusetsuSeikyu(int maxLength, int scale) {
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
