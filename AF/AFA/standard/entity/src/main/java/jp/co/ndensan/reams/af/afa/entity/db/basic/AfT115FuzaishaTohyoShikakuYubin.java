package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 選挙人の郵便投票資格の詳細情報を保持する。テーブルの項目定義クラスです。
 */
public enum AfT115FuzaishaTohyoShikakuYubin implements IColumnDefinition {
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
     * 履歴番号
     */
    seq(19, 0),
    /**
     * 身体障害者手帳有フラグ
     */
    shogaiTechoAriFlag(1, 0),
    /**
     * 戦傷病者手帳有フラグ
     */
    senshoTechoAriFlag(1, 0),
    /**
     * 介護保険被保険者証有フラグ
     */
    kaigoHokenshoAriFlag(1, 0),
    /**
     * 代理記載者入力区分
     * <br/>0：代理記載者入力無し、 1：住基（宛名）検索、 2：直接入力
     */
    dairiInputKubun(2147483647, 0),
    /**
     * 代理記載者識別コード
     * <br/>代理記載者入力区分＝2の場合、検索した結果の識別コードをセット
     */
    dairiShikibetsuCode(2147483647, 0),
    /**
     * 代理記載者漢字氏名
     */
    dairiKanjiShimei(2147483647, 0),
    /**
     * 代理記載者カナ氏名
     */
    dairiKanaShimei(2147483647, 0),
    /**
     * 代理記載者生年月日
     */
    dairiSeinengappiYMD(2147483647, 0),
    /**
     * 代理記載者性別コード
     */
    dairiSeibetsuCode(1, 0),
    /**
     * 代理記載者郵便番号
     */
    dairiYubinNo(2147483647, 0),
    /**
     * 代理記載者住所
     */
    dairiJusho(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private AfT115FuzaishaTohyoShikakuYubin(int maxLength, int scale) {
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
