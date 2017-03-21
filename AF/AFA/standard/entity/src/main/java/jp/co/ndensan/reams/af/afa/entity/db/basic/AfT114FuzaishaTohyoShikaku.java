package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 郵便、洋上、南極の各種資格を持つ選挙人情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT114FuzaishaTohyoShikaku implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 投票資格種類
     * <br/>1：郵便投票資格、2：洋上投票資格、3：南極投票資格
     */
    tohyoShikakuShurui(2147483647, 0),
    /**
     * 履歴番号
     */
    seq(19, 0),
    /**
     * 交付年月日
     * <br/>各投票資格証明書を交付した日
     */
    kofuYMD(2147483647, 0),
    /**
     * 交付番号
     * <br/>郵便投票資格のみ
     */
    kofuNo(20, 0),
    /**
     * 資格登録年月日
     */
    shikakuTorokuYMD(2147483647, 0),
    /**
     * 資格満了年月日
     * <br/>郵便投票：交付日＋7年 洋上投票：交付日＋7年 南極投票：南極調査機関の満了の日まで
     */
    shikakuManryoYMD(2147483647, 0),
    /**
     * 資格抹消年月日
     */
    shikakuMasshoYMD(2147483647, 0),
    /**
     * 資格抹消事由コード
     */
    shikakuMasshoJiyuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT114FuzaishaTohyoShikaku(int maxLength, int scale) {
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
