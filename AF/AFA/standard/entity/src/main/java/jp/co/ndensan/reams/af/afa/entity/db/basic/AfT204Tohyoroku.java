package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 期日前投票録、当日投票録の情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT204Tohyoroku implements IColumnDefinition {
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
     */
    senkyoNo(2147483647, 0),
    /**
     * 報告年月日
     * <br/>期日前投票日や投票日当日をセット。
     */
    hokokuYMD(2147483647, 0),
    /**
     * 施設コード
     * <br/>期日前投票録の時、施設コードをセットする。 当日投票録のとき、ALL0をセットする。
     */
    shisetsuCode(4, 0),
    /**
     * 投票区コード
     * <br/>期日前投票録の時、ALL0をセットする。 当日投票録の時、投票区コードをセットする。
     */
    tohyokuCode(4, 0),
    /**
     * 投票所設置状況
     */
    secchiJokyo(40, 0),
    /**
     * 投票所開設場所
     */
    kaisetsuBasho(40, 0),
    /**
     * 設置期間（開始年月日）
     */
    secchiFirstYMD(2147483647, 0),
    /**
     * 設置期間（終了年月日）
     */
    secchiLastYMD(2147483647, 0),
    /**
     * 開閉時刻（開始）
     */
    kaiheiStartTime(15, 0),
    /**
     * 開閉時刻（終了）
     */
    kaiheiStopTime(15, 0),
    /**
     * 選管書記人数
     */
    shokiNinzu(5, 0),
    /**
     * 職員人数
     */
    shokuinNinzu(5, 0),
    /**
     * sonotaNinzu
     */
    sonotaNinzu(5, 0);

    private final int maxLength;
    private final int scale;

    private AfT204Tohyoroku(int maxLength, int scale) {
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
