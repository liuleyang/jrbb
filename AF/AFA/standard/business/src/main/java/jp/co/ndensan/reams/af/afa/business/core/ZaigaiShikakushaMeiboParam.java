package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboParam {

    private final ZaigaiSenkyoIdouRuisekiEntity 在外選挙異動累積情報;
    private RString 申請資格;
    private RString 最終住所または本籍地_１;
    private RString 最終住所または本籍地_２;
    private RString 性別;
    private RString 生年月日;
    private RString 申請年月日;
    private RString 登録年月日;
    private RString 表示年月日;
    private RString 抹消年月日;
    private RString 項番;
    private RString 経由領事官等の名称;
    private RString 本籍地;
    private RString 照会日;
    private RString 回答日;
    private RString 通知日;
    private RString 交付日;
    private RString 本籍地登録;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙異動累積情報 ZaigaiSenkyoIdouRuisekiEntity
     */
    public ZaigaiShikakushaMeiboParam(
            ZaigaiSenkyoIdouRuisekiEntity 在外選挙異動累積情報) {
        this.在外選挙異動累積情報 = 在外選挙異動累積情報;
    }

    /**
     * 在外選挙異動累積情報
     *
     * @return 在外選挙異動累積情報 ZaigaiSenkyoIdouRuisekiEntity
     */
    public ZaigaiSenkyoIdouRuisekiEntity get在外選挙異動累積情報() {
        return 在外選挙異動累積情報;
    }

    /**
     * 申請資格を設定します。
     *
     * @param 申請資格 RString
     */
    public void set申請資格(RString 申請資格) {
        this.申請資格 = 申請資格;
    }

    /**
     * 最終住所または本籍地_１を設定します。
     *
     * @param 最終住所または本籍地_１ RString
     */
    public void set最終住所または本籍地_１(RString 最終住所または本籍地_１) {
        this.最終住所または本籍地_１ = 最終住所または本籍地_１;
    }

    /**
     * 最終住所または本籍地_２を設定します。
     *
     * @param 最終住所または本籍地_２ RString
     */
    public void set最終住所または本籍地_２(RString 最終住所または本籍地_２) {
        this.最終住所または本籍地_２ = 最終住所または本籍地_２;
    }

    /**
     * 本籍地登録を設定します。
     *
     * @param 本籍地登録 RString
     */
    public void set本籍地登録(RString 本籍地登録) {
        this.本籍地登録 = 本籍地登録;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 RString
     */
    public void set性別(RString 性別) {
        this.性別 = 性別;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 RString
     */
    public void set生年月日(RString 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 RString
     */
    public void set申請年月日(RString 申請年月日) {
        this.申請年月日 = 申請年月日;
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 RString
     */
    public void set登録年月日(RString 登録年月日) {
        this.登録年月日 = 登録年月日;
    }

    /**
     * 表示年月日を設定します。
     *
     * @param 表示年月日 RString
     */
    public void set表示年月日(RString 表示年月日) {
        this.表示年月日 = 表示年月日;
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param 抹消年月日 RString
     */
    public void set抹消年月日(RString 抹消年月日) {
        this.抹消年月日 = 抹消年月日;
    }

    /**
     * 項番を設定します。
     *
     * @param 項番 RString
     */
    public void set項番(RString 項番) {
        this.項番 = 項番;
    }

    /**
     * 経由領事官等の名称を設定します。
     *
     * @param 経由領事官等の名称 RString
     */
    public void set経由領事官等の名称(RString 経由領事官等の名称) {
        this.経由領事官等の名称 = 経由領事官等の名称;
    }

    /**
     * 本籍地を設定します。
     *
     * @param 本籍地 RString
     */
    public void set本籍地(RString 本籍地) {
        this.本籍地 = 本籍地;
    }

    /**
     * 照会日を設定します。
     *
     * @param 照会日 RString
     */
    public void set照会日(RString 照会日) {
        this.照会日 = 照会日;
    }

    /**
     * 回答日を設定します。
     *
     * @param 回答日 RString
     */
    public void set回答日(RString 回答日) {
        this.回答日 = 回答日;
    }

    /**
     * 通知日を設定します。
     *
     * @param 通知日 RString
     */
    public void set通知日(RString 通知日) {
        this.通知日 = 通知日;
    }

    /**
     * 交付日を設定します。
     *
     * @param 交付日 RString
     */
    public void set交付日(RString 交付日) {
        this.交付日 = 交付日;
    }

    /**
     * 申請資格を返します。
     *
     * @return 申請資格
     */
    public RString get申請資格() {
        return this.申請資格;
    }

    /**
     * 最終住所または本籍地_１を返します。
     *
     * @return 最終住所または本籍地_１
     */
    public RString get最終住所または本籍地_１() {
        return this.最終住所または本籍地_１;
    }

    /**
     * 最終住所または本籍地_２を返します。
     *
     * @return 最終住所または本籍地_２
     */
    public RString get最終住所または本籍地_２() {
        return this.最終住所または本籍地_２;
    }

    /**
     * 本籍地登録を返します。
     *
     * @return 本籍地登録
     */
    public RString get本籍地登録() {
        return this.本籍地登録;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return this.性別;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return this.生年月日;
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public RString get申請年月日() {
        return this.申請年月日;
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public RString get登録年月日() {
        return this.登録年月日;
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public RString get表示年月日() {
        return this.表示年月日;
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public RString get抹消年月日() {
        return this.抹消年月日;
    }

    /**
     * 項番を返します。
     *
     * @return 項番
     */
    public RString get項番() {
        return 項番;
    }

    /**
     * 経由領事官等の名称を返します。
     *
     * @return 経由領事官等の名称
     */
    public RString get経由領事官等の名称() {
        return this.経由領事官等の名称;
    }

    /**
     * 本籍地を返します。
     *
     * @return 本籍地
     */
    public RString get本籍地() {
        return this.本籍地;
    }

    /**
     * 照会日を返します。
     *
     * @return 照会日
     */
    public RString get照会日() {
        return this.照会日;
    }

    /**
     * 回答日を返します。
     *
     * @return 回答日
     */
    public RString get回答日() {
        return this.回答日;
    }

    /**
     * 通知日を返します。
     *
     * @return 通知日
     */
    public RString get通知日() {
        return this.通知日;
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日
     */
    public RString get交付日() {
        return this.交付日;
    }

}
