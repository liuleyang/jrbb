package jp.co.ndensan.reams.af.afa.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 投票の状態を保持する。 定時登録時は作成されない。テーブルの項目定義クラスです。
 */
public enum AfT201TohyoJokyo implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 選挙番号
     */
    senkyoNo(2147483647, 0),
    /**
     * 投票状況
     */
    tohyoJokyo(2147483647, 0),
    /**
     * 投票事由コード
     * <br/>旧　請求事由コード
     */
    tohyoJiyuCode(2147483647, 0),
    /**
     * 請求年月日
     */
    seikyuYMD(2147483647, 0),
    /**
     * 請求方法
     * <br/>'直接・本人　or　直接・代理人　or　郵便 ※期日前で郵便はない
     */
    seikyuHoho(2147483647, 0),
    /**
     * 受付番号
     * <br/>自動採番
     */
    uketsukeNo(10, 0),
    /**
     * 交付年月日
     */
    kofuYMD(2147483647, 0),
    /**
     * 交付時刻
     */
    kofuTime(15, 0),
    /**
     * 交付方法
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     */
    kofuHoho(2147483647, 0),
    /**
     * 施設コード
     * <br/>不在者の時は交付施設コード
     */
    shisetsuCode(4, 0),
    /**
     * 受取年月日
     * <br/>投票用紙が戻ってきた日を入力
     */
    uketoriYMD(2147483647, 0),
    /**
     * 受理年月日
     */
    juriYMD(2147483647, 0),
    /**
     * 受理時刻
     */
    juriTime(15, 0),
    /**
     * 受理方法
     * <br/>直接　or　郵便 （コード：交付_受理方法）
     */
    juriHoho(2147483647, 0),
    /**
     * 受理施設種別
     * <br/>旧・受理施設（投票場所）
     */
    juriShisetsuShubetsu(2147483647, 0),
    /**
     * 棄権年月日
     * <br/>選挙人の意思で棄権を宣言した日。以降、投票できなくなる。
     */
    kikenYMD(2147483647, 0),
    /**
     * 返還年月日
     * <br/>返還時はここに日付をセット。返還しても投票はできる（期日前にはない）
     */
    henkanYMD(2147483647, 0),
    /**
     * 点字フラグ
     */
    tenjiFlag(1, 0),
    /**
     * 代理投票有フラグ
     * <br/>期日前、当日の時のみ
     */
    dairiTohyoAriFlag(1, 0),
    /**
     * 補助者識別コード1
     */
    hojoshaShikibetsuCode1(2147483647, 0),
    /**
     * 補助者氏名1
     */
    hojoshaShimei1(2147483647, 0),
    /**
     * 補助者識別コード2
     */
    hojoshaShikibetsuCode2(2147483647, 0),
    /**
     * 補助者氏名2
     */
    hojoshaShimei2(2147483647, 0),
    /**
     * 拒否事由
     * <br/>拒否事由コードでの選択もできるが、DBセット時は文字列をセットする。
     */
    kyohiJiyu(20, 0),
    /**
     * 証明書出力フラグ
     * <br/>不在者投票の時のみ
     */
    shomeishoPrintFlag(1, 0),
    /**
     * 送致済フラグ
     * <br/>'選管から、各投票所や開票場所へ送致した時にTrueにする
     */
    sochiZumiFlag(1, 0),
    /**
     * 期日前不在者区分
     * <br/>'棄権や拒否がどの投票で入力されたのかを区別するためのもの 1:期日前投票 2:不在者投票 3:当日投票
     */
    kijitsuFuzaiKubun(2147483647, 0),
    /**
     * 更新端末ID
     */
    reamsClientId(40, 0);

    private final int maxLength;
    private final int scale;

    private AfT201TohyoJokyo(int maxLength, int scale) {
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
