package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 直接請求に対し、署名した住民の情報を保持。
有効無効情報も保持し、集計に使用する。テーブルの項目定義クラスです。
 */
public enum AfT403Shomeibo implements IColumnDefinition {
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
     * 直接請求番号
     */
    seikyuNo(5, 0),
    /**
     * 冊
     */
    satsu(2, 0),
    /**
     * 頁
     */
    page(10, 0),
    /**
     * 行
     */
    gyo(5, 0),
    /**
     * 審査区分
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     */
    shinsaKubun(2147483647, 0),
    /**
     * 無効事由コード
     */
    mukoJiyuCode(2147483647, 0),
    /**
     * 署名年月日
     * <br/>署名人が記入した日付を入力するため、暦上日とは限らない
     */
    shomeiYMD(2147483647, 0),
    /**
     * 署名者識別コード
     */
    shomeishaShikibetsuCode(2147483647, 0),
    /**
     * 漢字氏名
     */
    kanjiShimei(2147483647, 0),
    /**
     * カナ氏名
     */
    kanaShimei(2147483647, 0),
    /**
     * 検索用カナ氏名
     */
    searchKanaShimei(2147483647, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 代筆者識別コード
     */
    daihitsushaShikibetsuCode(2147483647, 0),
    /**
     * 代筆者漢字氏名
     */
    daihitsushaKanjiShimei(2147483647, 0),
    /**
     * 代筆者生年月日
     */
    daihitsushaSeinengappiYMD(2147483647, 0),
    /**
     * 代筆者性別コード
     */
    daihitsushaSeibetsuCode(1, 0),
    /**
     * 代筆者住所
     */
    daihitsushaJusho(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT403Shomeibo(int maxLength, int scale) {
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
