package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 農業、海区名簿の確定、最新化等の日付情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT131KaikuSenkyo implements IColumnDefinition {
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
     * 年度
     */
    nendo(2147483647, 0),
    /**
     * 名簿作成年月日
     * <br/>名簿を最初に作成した日
     */
    sakuseiYMD(2147483647, 0),
    /**
     * 名簿確定年月日
     * <br/>名簿を確定した日
     */
    kakuteiYMD(2147483647, 0),
    /**
     * 名簿最新化年月日
     * <br/>最新化処理を行った日
     */
    saishinkaYMD(2147483647, 0),
    /**
     * 選挙時登録フラグ
     * <br/>True:選挙時登録からの登録の場合 False：選挙人名簿作成（登載申請書等）からの登録の場合
     */
    senkyojiTorokuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private AfT131KaikuSenkyo(int maxLength, int scale) {
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
