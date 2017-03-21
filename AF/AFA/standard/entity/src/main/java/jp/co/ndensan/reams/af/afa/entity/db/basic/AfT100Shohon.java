package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 定時処理、各種選挙等の1処理につき、1抄本を作成する。 複数選挙を1つにまとめるためのもの。 投票年月日が違う場合は、別抄本とする。テーブルの項目定義クラスです。
 */
public enum AfT100Shohon implements IColumnDefinition {
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
     * <br/>各処理の単位となる。 複数選挙同日投票日などの時、1つにまとめて処理を行うため。
     */
    shohonNo(2147483647, 0),
    /**
     * 選挙種類
     * <br/>異なった選挙種類での複数選挙は登録できない。
     */
    senkyoShurui(2147483647, 0),
    /**
     * 抄本名
     */
    shohonName(40, 0),
    /**
     * 投票年月日
     * <br/>定時登録の場合は、名簿基準年月日と同日
     */
    tohyoYMD(2147483647, 0),
    /**
     * 規定年齢到達年月日
     */
    kiteiNenreiTotatsuYMD(2147483647, 0),
    /**
     * 処理年月日
     * <br/>抄本を作成した日
     */
    shoriYMD(2147483647, 0),
    /**
     * 入場券発行固有番号
     * <br/>入場券一括作成時に取得できる帳票固有連番をセット 入場券が実印刷されているかどうかの確認に使用する
     */
    nyujokenReportIndex(10, 0),
    /**
     * 研修用抄本番号
     * <br/>選挙時登録で必要。同時作成した、研修用データの抄本番号をセットする
     */
    simulationShohonNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT100Shohon(int maxLength, int scale) {
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
