package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 本籍地住所、国外転出前最終住所、国内転入住所の国内での住所情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT123ZaigaiSenkyoninJusho implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 申請番号
     */
    shinseiNo(10, 0),
    /**
     * 住所種類区分
     * <br/>1：本籍地住所　 2：国外転出前最終住所　 3：国内転入先住所 4：海外住所 5：海外送付先住所
     */
    jushoShuruiKubun(2147483647, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 全国住所コード
     */
    zenkokuJushoCode(2147483647, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 番地
     */
    banchi(2147483647, 0),
    /**
     * 方書コード
     */
    katagakiCode(2147483647, 0),
    /**
     * 方書
     */
    katagaki(2147483647, 0),
    /**
     * 同居家族氏名
     * <br/>申請時の情報。複数人数の記入可。送付先の場合は、送付先宛名
     */
    dokyoKazokuShimei(120, 0),
    /**
     * 電話番号
     */
    tel(30, 0),
    /**
     * FAX番号
     */
    fax(30, 0),
    /**
     * メールアドレス
     */
    mail(2147483647, 0),
    /**
     * 国外転出年月日
     * <br/>住所種類＝2の時
     */
    kokugaiTenshutsuYMD(2147483647, 0),
    /**
     * 国内転入年月日
     * <br/>住所種類＝3の時
     */
    kokunaiTennyuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT123ZaigaiSenkyoninJusho(int maxLength, int scale) {
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
