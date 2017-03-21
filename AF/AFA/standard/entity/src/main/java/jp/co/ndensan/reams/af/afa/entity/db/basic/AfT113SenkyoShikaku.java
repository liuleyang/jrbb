package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 選挙資格、投票資格の状態を保持する。テーブルの項目定義クラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public enum AfT113SenkyoShikaku implements IColumnDefinition {
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
     * senkyoShurui
     */
    senkyoShurui(2147483647, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * seq
     */
    seq(19, 0),
    /**
     * shikakuKubun
     */
    shikakuKubun(2147483647, 0),
    /**
     * tohyokuCode
     */
    tohyokuCode(4, 0),
    /**
     * 最初に名簿に登録された日
     */
    meiboTorokuYMD(2147483647, 0),
    /**
     * torokuJiyuCode
     */
    torokuJiyuCode(2147483647, 0),
    /**
     * torokuTeishiYMD
     */
    torokuTeishiYMD(2147483647, 0),
    /**
     * torokuTeishiJiyuCode
     */
    torokuTeishiJiyuCode(2147483647, 0),
    /**
     * hyojiYMD
     */
    hyojiYMD(2147483647, 0),
    /**
     * hyojiJiyuCode
     */
    hyojiJiyuCode(2147483647, 0),
    /**
     * 公民権停止者について表示が消える日を設定
     */
    hyojiShojoYMD(2147483647, 0),
    /**
     * hyojiShojoYoteiYMD
     */
    hyojiShojoYoteiYMD(2147483647, 0),
    /**
     * masshoYMD
     */
    masshoYMD(2147483647, 0),
    /**
     * masshoJiyuCode
     */
    masshoJiyuCode(2147483647, 0),
    /**
     * keikiShuryoYMD
     */
    keikiShuryoYMD(2147483647, 0),
    /**
     * True:２刑持ちの場合 False：２刑なしの場合
     */
    nikeimochiFlag(1, 0),
    /**
     * dataTorokuYMD
     */
    dataTorokuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT113SenkyoShikaku(int maxLength, int scale) {
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
