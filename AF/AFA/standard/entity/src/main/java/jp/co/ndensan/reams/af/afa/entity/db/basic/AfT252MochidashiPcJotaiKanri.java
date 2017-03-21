package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 当日投票受付の持ち出し端末のデータ状態を保持する。テーブルの項目定義クラスです。
 */
public enum AfT252MochidashiPcJotaiKanri implements IColumnDefinition {
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
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * データ作成区分
     * <br/>データ引継区分（0：未、1：作成済）
     */
    dataCreateKubun(2147483647, 0),
    /**
     * データ作成日時
     */
    dataCreateYMD(2147483647, 0),
    /**
     * AP受渡区分
     * <br/>データ引継区分（0：未、2：受渡済）
     */
    systemSendKubun(2147483647, 0),
    /**
     * AP受渡日時
     */
    systemSendYMD(2147483647, 0),
    /**
     * データ受渡区分
     * <br/>データ引継区分（0：未、2：受渡済
     */
    dataSendKubun(2147483647, 0),
    /**
     * データ受渡日時
     */
    dataSendYMD(2147483647, 0),
    /**
     * データ取込区分
     * <br/>データ引継区分（0：未、3：取込済）
     */
    dataImportKubun(2147483647, 0),
    /**
     * データ取込日時
     */
    dataImportYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT252MochidashiPcJotaiKanri(int maxLength, int scale) {
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
