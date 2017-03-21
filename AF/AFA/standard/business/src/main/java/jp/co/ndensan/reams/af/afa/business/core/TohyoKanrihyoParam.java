package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoParam {

    private final ZaigaiSenkyoIdouRuisekiEntity 在外選挙異動累積情報;
    private RString 性別;
    private RString 経由領事官１;
    private RString 経由領事官２;
    private RString 資格;
    private RString 生年月日;
    private RString 登録年月日;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙異動累積情報 ZaigaiSenkyoIdouRuisekiEntity
     */
    public TohyoKanrihyoParam(
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
     * 性別を設定します。
     *
     * @param 性別 RString
     */
    public void set性別(RString 性別) {
        this.性別 = 性別;
    }

    /**
     * 資格を設定します。
     *
     * @param 資格 RString
     */
    public void set資格(RString 資格) {
        this.資格 = 資格;
    }

    /**
     * 経由領事官１を設定します。
     *
     * @param 経由領事官１ RString
     */
    public void set経由領事官１(RString 経由領事官１) {
        this.経由領事官１ = 経由領事官１;
    }

    /**
     * 経由領事官２を設定します。
     *
     * @param 経由領事官２ RString
     */
    public void set経由領事官２(RString 経由領事官２) {
        this.経由領事官２ = 経由領事官２;
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
     * 登録年月日を設定します。
     *
     * @param 登録年月日 RString
     */
    public void set登録年月日(RString 登録年月日) {
        this.登録年月日 = 登録年月日;
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
     * 資格を返します。
     *
     * @return 資格
     */
    public RString get資格() {
        return this.資格;
    }

    /**
     * 経由領事官１を返します。
     *
     * @return 経由領事官１
     */
    public RString get経由領事官１() {
        return this.経由領事官１;
    }

    /**
     * 経由領事官２を返します。
     *
     * @return 経由領事官２
     */
    public RString get経由領事官２() {
        return this.経由領事官２;
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
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public RString get登録年月日() {
        return this.登録年月日;
    }
}
