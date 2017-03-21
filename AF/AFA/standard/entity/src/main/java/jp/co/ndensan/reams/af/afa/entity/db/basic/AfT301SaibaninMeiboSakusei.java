package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 名簿調整プログラムに渡すデータを作成するのに使用した抄本番号と、作成したデータの保存先等を年度別に保持する。
また、名簿調整プログラムで生成された裁判員候補者予定者名簿の情報を取り込んだかどうかの情報も保持する。テーブルの項目定義クラスです。
 */
public enum AfT301SaibaninMeiboSakusei implements IColumnDefinition {
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
     * 年度
     */
    nendo(2147483647, 0),
    /**
     * 抄本番号
     * <br/>基にした抄本番号
     */
    shohonNo(10, 0),
    /**
     * 有権者情報保存先
     * <br/>作成した裁判員候補者名簿の保存先
     */
    hozonSaki(50, 0),
    /**
     * 有権者情報ファイル名
     * <br/>作成した裁判員候補者名簿のファイル名
     */
    fileName(50, 0),
    /**
     * 予定者名簿取込済フラグ
     * <br/>抽選結果の裁判員候補者予定者名簿を取込みしたらTrue
     */
    meiboTorikomiZumiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private AfT301SaibaninMeiboSakusei(int maxLength, int scale) {
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
