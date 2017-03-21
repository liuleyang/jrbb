package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 在外選挙での選挙資格の状態を保持する。テーブルの項目定義クラスです。
 */
public enum AfT122ZaigaiSenkyoShikaku implements IColumnDefinition {
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
     * 国民投票区分
     * <br/>1：在外選挙資格（国民投票も可能）、 2：在外国民投票資格（申請した国民投票のみ可能）
     */
    kokuminTohyoKubun(2147483647, 0),
    /**
     * 国民投票抄本番号
     */
    kokuminShohonNo(2147483647, 0),
    /**
     * 本籍地登録区分
     * <br/>本籍地登録の区分 0：国内最終住所で登録する、1：本籍地で登録する 平成6年5月1日以降にいずれの市区町村においても住所を有していないとき、本籍地登録とする
     */
    honsekiTorokuKubun(2147483647, 0),
    /**
     * 交付番号
     * <br/>西暦下2桁＋市町村コード5桁＋通し（採番）3桁＋枝番1桁
     */
    kofuNo(20, 0),
    /**
     * 交付年月日
     */
    kofuYMD(2147483647, 0),
    /**
     * 選挙資格区分
     */
    shikakuKubun(2147483647, 0),
    /**
     * 投票区コード
     */
    tohyokuCode(4, 0),
    /**
     * 名簿登録年月日
     */
    meiboTorokuYMD(2147483647, 0),
    /**
     * 表示年月日
     */
    hyojiYMD(2147483647, 0),
    /**
     * 表示事由コード
     */
    hyojiJiyuCode(2147483647, 0),
    /**
     * 抹消年月日
     */
    masshoYMD(2147483647, 0),
    /**
     * 抹消事由コード
     */
    masshoJiyuCode(2147483647, 0),
    /**
     * 修正区分
     * <br/>1：再交付、2：記載事項変更
     */
    shuseiKubun(2147483647, 0),
    /**
     * 修正年月日
     */
    shuseiYMD(2147483647, 0),
    /**
     * 再交付事由コード
     * <br/>再交付事由
     */
    saiKofuJiyuCode(2147483647, 0),
    /**
     * 記載事項変更事由コード
     * <br/>申請内容変更事由コード　を使用する
     */
    henkoJiyuCode(2147483647, 0),
    /**
     * 特記事項
     */
    tokkiJiko(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT122ZaigaiSenkyoShikaku(int maxLength, int scale) {
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
