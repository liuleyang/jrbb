package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 在外選挙人申請の状態を保持する。テーブルの項目定義クラスです。
 */
public enum AfT124ZaigaiSenkyoninShinsei implements IColumnDefinition {
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
     * 申請番号
     */
    shinseiNo(10, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 住定年月日
     */
    juteiYMD(2147483647, 0),
    /**
     * 領事官コード
     */
    ryojikanCode(3, 0),
    /**
     * 国籍コード
     */
    kokusekiCode(3, 0),
    /**
     * 申請者氏名
     */
    shinseishaShimei(2147483647, 0),
    /**
     * 申請者カナ氏名
     */
    shinseishaKanaShimei(2147483647, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 申請区分
     * <br/>"1"：申請、"2"；取下、"3"：却下
     */
    shinseiKubun(2147483647, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 申請内容変更年月日
     */
    henkoYMD(2147483647, 0),
    /**
     * 申請内容変更事由コード
     */
    henkoJiyuCode(2147483647, 0),
    /**
     * 申請取下年月日
     * <br/>選挙人本人からの申請取消をした日
     */
    torisageYMD(2147483647, 0),
    /**
     * 申請取下事由コード
     */
    torisageJiyuCode(2147483647, 0),
    /**
     * 却下年月日
     * <br/>選管で、申請を受け付けられない判断をした日
     */
    kyakkaYMD(2147483647, 0),
    /**
     * 却下事由コード
     */
    kyakkaJiyuCode(2147483647, 0),
    /**
     * 本籍地照会年月日
     */
    honsekiShokaiYMD(2147483647, 0),
    /**
     * 本籍地回答年月日
     */
    honsekiKaitoYMD(2147483647, 0),
    /**
     * 本籍地通知年月日
     */
    honsekiTsuchiYMD(2147483647, 0),
    /**
     * tokkiJiko
     */
    tokkiJiko(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT124ZaigaiSenkyoninShinsei(int maxLength, int scale) {
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
