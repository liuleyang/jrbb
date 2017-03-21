package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 投票所の情報を保持する。
このテーブルは、投票区や選挙種類にかかわらずに投票所情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT502Tohyojo implements IColumnDefinition {
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
     * 投票所コード
     */
    tohyojoCode(4, 0),
    /**
     * 投票所名称
     */
    tohyojoName(50, 0),
    /**
     * カナ投票所名称
     */
    kanaTohyojoName(100, 0),
    /**
     * 検索用カナ投票所名称
     */
    searchKanaTohyojoName(100, 0),
    /**
     * 投票開始時刻
     */
    tohyoStartTime(15, 0),
    /**
     * 投票終了時刻
     */
    tohyoStopTime(15, 0),
    /**
     * 在外投票可能フラグ
     * <br/>True:在外投票可能な投票所の場合 False：在外投票できない投票所の場合
     */
    zaigaiTohyoKanoFlag(1, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 投票所宛名
     */
    tohyojoAtena(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 地図ファイル名
     */
    mapImage(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT502Tohyojo(int maxLength, int scale) {
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
