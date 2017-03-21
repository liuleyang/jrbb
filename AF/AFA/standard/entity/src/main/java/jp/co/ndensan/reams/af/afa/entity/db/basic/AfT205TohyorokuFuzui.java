package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 投票録情報のうち、複数人数登録できるような項目を保持する。
各項目種類により、入力できる部分が変わる。テーブルの項目定義クラスです。
 */
public enum AfT205TohyorokuFuzui implements IColumnDefinition {
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
     */
    hokokuYMD(2147483647, 0),
    /**
     * 施設コード
     */
    shisetsuCode(4, 0),
    /**
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * 投票録項目種類
     * <br/>投票立会人（選管） 投票立会人（投票管理者） 再交付者 決定書・判決書 用紙返還
     */
    komokuShurui(2147483647, 0),
    /**
     * 連番
     * <br/>各投票録項目種類毎に連番。max値は帳票レイアウトによる。
     */
    renban(5, 0),
    /**
     * 党派
     */
    toha(10, 0),
    /**
     * 氏名
     */
    shimei(2147483647, 0),
    /**
     * 選任年月日
     */
    sennninYMD(2147483647, 0),
    /**
     * 立会時間（開始時刻）
     */
    tachiaiStartTime(15, 0),
    /**
     * 立会時間（終了時刻）
     */
    tachiaiStopTime(15, 0),
    /**
     * 参会時刻
     */
    sankaiTime(15, 0),
    /**
     * 辞職時刻
     */
    jishokuTime(15, 0),
    /**
     * 事由
     * <br/>辞職事由、再交付事由、拒否事由
     */
    jiyu(20, 0);

    private final int maxLength;
    private final int scale;

    private AfT205TohyorokuFuzui(int maxLength, int scale) {
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
