package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 立会人引継情報を保持する。
投票録作成時（新規登録時）には、この立会人引継情報を集約した情報を初期表示として使用する。テーブルの項目定義クラスです。
 */
public enum AfT206TachiaininHikitsugiJoho implements IColumnDefinition {
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
     * 立会人連番
     * <br/>立会人の党派と氏名をキーとしたいが修正できなくなるので、その代替キー。1からの意味のない連番で構わない。
     */
    tachiaininRenban(5, 0),
    /**
     * 投票録項目種類
     * <br/>投票立会人（選管） 再交付者 決定書・判決書
     */
    komokuShurui(2147483647, 0),
    /**
     * 連番
     * <br/>投票録項目種類別の、対象者氏名別の連番。氏名の修正を考えたときの代替機ー。1からの意味のない連番でかまわない。
     */
    renban(5, 0),
    /**
     * 氏名
     */
    shimei(2147483647, 0),
    /**
     * 党派
     */
    toha(10, 0),
    /**
     * 立会時間（開始時刻）
     */
    tachiaiStartTime(15, 0),
    /**
     * 立会時間（終了時刻）
     */
    tachiaiStopTime(15, 0),
    /**
     * 異常有フラグ
     * <br/>true：異常有り　false：異常なし
     */
    ijoAriFlag(1, 0),
    /**
     * 異常内容
     * <br/>異常有りのとき、その異常内容を保持する
     */
    ijoNaiyo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT206TachiaininHikitsugiJoho(int maxLength, int scale) {
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
