package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 財産区議会議員選挙人名簿や、住民投票人名簿を作成するための選挙人抽出条件を保持するテーブルの項目定義クラスです。
 */
public enum AfT141ZaisankuJuminTohyoCondition implements IColumnDefinition {
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
     * 年齢計算基準年月日
     * <br/>『年齢計算基準年月日』時点で『年齢』以上の人を対象とする。
     */
    nenreiKeisanKijunYMD(2147483647, 0),
    /**
     * 年齢
     */
    nenrei(5, 0),
    /**
     * 誕生日含フラグ
     * <br/>『年齢計算基準日＋1日』の誕生日の人を含む。
     */
    birthdayFukumuFlag(1, 0),
    /**
     * 居住年数
     * <br/>財産区選挙時に入力
     */
    kyojuNensu(5, 0),
    /**
     * 住定開始年月日
     * <br/>住民投票時に入力
     */
    juteiFirstYMD(2147483647, 0),
    /**
     * 住定終了年月日
     * <br/>住民投票時に入力
     */
    juteiLastYMD(2147483647, 0),
    /**
     * 日本人フラグ
     */
    japaneseFlag(1, 0),
    /**
     * 外国人フラグ
     */
    foreignerFlag(1, 0),
    /**
     * 住民フラグ
     */
    juminFlag(1, 0),
    /**
     * 転出者フラグ
     */
    tenshutsushaFlag(1, 0),
    /**
     * 転入者フラグ
     */
    tennyushaFlag(1, 0),
    /**
     * 公民権停止者含フラグ
     * <br/>true：公民権停止者を含める
     */
    teishishaFukumuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private AfT141ZaisankuJuminTohyoCondition(int maxLength, int scale) {
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
