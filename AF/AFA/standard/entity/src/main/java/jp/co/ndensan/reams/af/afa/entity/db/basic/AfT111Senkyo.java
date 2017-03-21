package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 各選挙の選挙名称や日付を管理する。
1抄本に1件以上の登録をする。テーブルの項目定義クラスです。
 */
public enum AfT111Senkyo implements IColumnDefinition {
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
     * <br/>複数選挙ある場合の連番
     */
    senkyoNo(2147483647, 0),
    /**
     * 選挙レベル
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     */
    senkyoLevel(2147483647, 0),
    /**
     * 選挙名称
     */
    senkyoName(40, 0),
    /**
     * 選挙略称
     */
    senkyoRyakusho(4, 0),
    /**
     * 選挙マーク
     */
    senkyoMark(2, 0),
    /**
     * 名簿基準年月日
     * <br/>定時登録：3、6、9、12月1日 選挙時：告示（公示）年月日の前日 農委：1月1日 海区：9月1日
     */
    kijunYMD(2147483647, 0),
    /**
     * 名簿登録年月日
     * <br/>定時登録：名簿基準年月日の翌日 選挙時：名簿基準年月日 農委：3月31日 海区：12月5日
     */
    meiboTorokuYMD(2147483647, 0),
    /**
     * 告示（公示）年月日
     * <br/>名簿基準年月日の翌日
     */
    kokujiYMD(2147483647, 0),
    /**
     * 転出期限年月日
     * <br/>国民投票の場合は、特定期間開始年月日（基準日の翌日）をセット
     */
    tenshutsuKigenYMD(2147483647, 0),
    /**
     * 転入期限年月日
     * <br/>国民投票の場合は、特定期限年月日（基準日＋14日）をセット
     */
    tennyuKigenYMD(2147483647, 0),
    /**
     * 投票受付開始年月日
     */
    tohyoUketsukeYMD(2147483647, 0),
    /**
     * 無投票選挙フラグ
     * <br/>True：無投票選挙になった False：選挙開催となった
     */
    mutohyoSenkyoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private AfT111Senkyo(int maxLength, int scale) {
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
