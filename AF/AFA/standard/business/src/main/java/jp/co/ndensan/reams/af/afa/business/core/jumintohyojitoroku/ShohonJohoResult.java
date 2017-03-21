/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyojitoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyojitoroku.ShohonJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-010 jihb
 */
public class ShohonJohoResult {

    private final ShohonJohoEntity 抄本情報Entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShohonJohoEntity} より{@link ShohonJohoResult}を生成します。
     *
     * @param 抄本情報Entity DBより取得した{@link ShohonJohoEntity}
     */
    public ShohonJohoResult(ShohonJohoEntity 抄本情報Entity) {
        this.抄本情報Entity = requireNonNull(抄本情報Entity,
                UrSystemErrorMessages.値がnull.getReplacedMessage("抄本情報"));
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return this.抄本情報Entity.get抄本Entity().getShohonName();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return this.抄本情報Entity.get抄本Entity().getTohyoYMD();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return this.抄本情報Entity.get選挙Entity().getTohyoUketsukeYMD();
    }

    /**
     * 転出期限年月日を返します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return this.抄本情報Entity.get選挙Entity().getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を返します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return this.抄本情報Entity.get選挙Entity().getTennyuKigenYMD();
    }

    /**
     * 年齢計算基準年月日を返します。
     *
     * @return 年齢計算基準年月日
     */
    public FlexibleDate get年齢計算基準年月日() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getNenreiKeisanKijunYMD();
    }

    /**
     * 年齢計算基準年月日を返します。
     *
     * @return 年齢計算基準年月日
     */
    public Integer get年齢() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getNenrei();
    }

    /**
     * 誕生日含フラグを返します。
     *
     * @return 誕生日含フラグ
     */
    public Boolean get誕生日含フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getBirthdayFukumuFlag();
    }

    /**
     * 居住年数を返します。
     *
     * @return 居住年数
     */
    public Integer get居住年数() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getKyojuNensu();
    }

    /**
     * 住定開始年月日を返します。
     *
     * @return 住定開始年月日
     */
    public FlexibleDate get住定開始年月日() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getJuteiFirstYMD();
    }

    /**
     * 住定終了年月日を返します。
     *
     * @return 住定終了年月日
     */
    public FlexibleDate get住定終了年月日() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getJuteiLastYMD();
    }

    /**
     * 日本人フラグを返します。
     *
     * @return 日本人フラグ
     */
    public Boolean get日本人フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getJapaneseFlag();
    }

    /**
     * 外国人フラグを返します。
     *
     * @return 外国人フラグ
     */
    public Boolean get外国人フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getForeignerFlag();
    }

    /**
     * 住民フラグを返します。
     *
     * @return 住民フラグ
     */
    public Boolean get住民フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getJuminFlag();
    }

    /**
     * 転出者フラグを返します。
     *
     * @return 転出者フラグ
     */
    public Boolean get転出者フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getTenshutsushaFlag();
    }

    /**
     * 転入者フラグを返します。
     *
     * @return 転入者フラグ
     */
    public Boolean get転入者フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getTennyushaFlag();
    }

    /**
     * 公民権停止者含フラグを返します。
     *
     * @return 公民権停止者含フラグ
     */
    public Boolean get公民権停止者含フラグ() {
        return this.抄本情報Entity.get財産区抽出条件Entity().getTeishishaFukumuFlag();
    }

}
