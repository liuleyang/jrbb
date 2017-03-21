package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 在外選挙人名簿、在外投票人名簿の情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT121ZaigaiSenkyoninMeibo implements IColumnDefinition {
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
     * グループコード
     */
    groupCode(1, 0),
    /**
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * 国外分類コード
     * <br/>領事官コードまたは国籍コードでページを１に戻すとき、それぞれのコードを設定する 上記以外は"000"を設定する
     */
    kokugaiBunruiCode(3, 0),
    /**
     * 冊
     */
    satsu(2, 0),
    /**
     * 頁
     */
    page(10, 0),
    /**
     * 行
     */
    gyo(5, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT121ZaigaiSenkyoninMeibo(int maxLength, int scale) {
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
