/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shikakujoho;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格情報共有子DIVクラスです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoResult implements Serializable {

    private final AfT113SenkyoShikakuEntity afT113SenkyoShikaku;

    /**
     * コンストラクタです。
     */
    public ShikakuJohoResult() {
        afT113SenkyoShikaku = new AfT113SenkyoShikakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param afT113SenkyoShikaku AfT113SenkyoShikakuEntity
     */
    public ShikakuJohoResult(AfT113SenkyoShikakuEntity afT113SenkyoShikaku) {
        this.afT113SenkyoShikaku = afT113SenkyoShikaku;
    }

    /**
     * AfT113SenkyoShikakuEntityを返します。
     *
     * @return AfT113SenkyoShikakuEntity
     */
    public AfT113SenkyoShikakuEntity getAfT113SenkyoShikaku() {
        return afT113SenkyoShikaku;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return afT113SenkyoShikaku.getSenkyoShurui();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return afT113SenkyoShikaku.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return afT113SenkyoShikaku.getSeq();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return afT113SenkyoShikaku.getShikakuKubun();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return afT113SenkyoShikaku.getTohyokuCode();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return afT113SenkyoShikaku.getMeiboTorokuYMD();
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード
     */
    public Code get登録事由コード() {
        return afT113SenkyoShikaku.getTorokuJiyuCode();
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日
     */
    public FlexibleDate get登録停止年月日() {
        return afT113SenkyoShikaku.getTorokuTeishiYMD();
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード
     */
    public Code get登録停止事由コード() {
        return afT113SenkyoShikaku.getTorokuTeishiJiyuCode();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return afT113SenkyoShikaku.getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        return afT113SenkyoShikaku.getHyojiJiyuCode();
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日
     */
    public FlexibleDate get表示消除年月日() {
        return afT113SenkyoShikaku.getHyojiShojoYMD();
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日
     */
    public FlexibleDate get表示消除予定年月日() {
        return afT113SenkyoShikaku.getHyojiShojoYoteiYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return afT113SenkyoShikaku.getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        return afT113SenkyoShikaku.getMasshoJiyuCode();
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日
     */
    public FlexibleDate get刑期終了年月日() {
        return afT113SenkyoShikaku.getKeikiShuryoYMD();
    }

    /**
     * 2刑持ちフラグを返します。
     *
     * @return 2刑持ちフラグ
     */
    public boolean is2刑持ちフラグ() {
        return afT113SenkyoShikaku.getNikeimochiFlag();
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 Code
     */
    public void set選挙種類(Code 選挙種類) {
        this.afT113SenkyoShikaku.setSenkyoShurui(選挙種類);
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.afT113SenkyoShikaku.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 選挙資格区分を設定します。
     *
     * @param shikakuKubun 選挙資格区分
     */
    public void set選挙資格区分(Code shikakuKubun) {
        this.afT113SenkyoShikaku.setShikakuKubun(shikakuKubun);
    }

    /**
     * 投票区コードを設定します。
     *
     * @param tohyokuCode 投票区コード
     */
    public void set投票区コード(RString tohyokuCode) {
        this.afT113SenkyoShikaku.setTohyokuCode(tohyokuCode);
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param meiboTorokuYMD 名簿登録年月日
     */
    public void set名簿登録年月日(FlexibleDate meiboTorokuYMD) {
        this.afT113SenkyoShikaku.setMeiboTorokuYMD(meiboTorokuYMD);
    }

    /**
     * 登録事由コードを設定します。
     *
     * @param 登録事由コード Code
     */
    public void set登録事由コード(Code 登録事由コード) {
        this.afT113SenkyoShikaku.setTorokuJiyuCode(登録事由コード);
    }

    /**
     * 登録停止年月日を設定します。
     *
     * @param 登録停止年月日 FlexibleDate
     */
    public void set登録停止年月日(FlexibleDate 登録停止年月日) {
        this.afT113SenkyoShikaku.setTorokuTeishiYMD(登録停止年月日);
    }

    /**
     * 登録停止事由コードを設定します。
     *
     * @param 登録停止事由コード Code
     */
    public void set登録停止事由コード(Code 登録停止事由コード) {
        this.afT113SenkyoShikaku.setTorokuTeishiJiyuCode(登録停止事由コード);
    }

    /**
     * 表示年月日を設定します。
     *
     * @param hyojiYMD 表示年月日
     */
    public void set表示年月日(FlexibleDate hyojiYMD) {
        this.afT113SenkyoShikaku.setHyojiYMD(hyojiYMD);
    }

    /**
     * 表示事由コードを設定します。
     *
     * @param hyojiJiyuCode 表示事由コード
     */
    public void set表示事由コード(Code hyojiJiyuCode) {
        this.afT113SenkyoShikaku.setHyojiJiyuCode(hyojiJiyuCode);
    }

    /**
     * 表示消除年月日を設定します。
     *
     * @param 表示消除年月日 FlexibleDate
     */
    public void set表示消除年月日(FlexibleDate 表示消除年月日) {
        this.afT113SenkyoShikaku.setHyojiShojoYMD(表示消除年月日);
    }

    /**
     * 表示消除予定年月日を設定します。
     *
     * @param 表示消除予定年月日 FlexibleDate
     */
    public void set表示消除予定年月日(FlexibleDate 表示消除予定年月日) {
        this.afT113SenkyoShikaku.setHyojiShojoYoteiYMD(表示消除予定年月日);
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param masshoYMD 抹消年月日
     */
    public void set抹消年月日(FlexibleDate masshoYMD) {
        this.afT113SenkyoShikaku.setMasshoYMD(masshoYMD);
    }

    /**
     * 抹消事由コードを設定します。
     *
     * @param masshoJiyuCode 抹消事由コード
     */
    public void set抹消事由コード(Code masshoJiyuCode) {
        this.afT113SenkyoShikaku.setMasshoJiyuCode(masshoJiyuCode);
    }

    /**
     * 刑期終了年月日を設定します。
     *
     * @param keikiShuryoYMD FlexibleDate
     */
    public void set刑期終了年月日(FlexibleDate keikiShuryoYMD) {
        this.afT113SenkyoShikaku.setKeikiShuryoYMD(keikiShuryoYMD);
    }

    /**
     * 刑持ちフラグ2を設定します。
     *
     * @param 刑持ちフラグ2 boolean
     */
    public void set2刑持ちフラグ(boolean 刑持ちフラグ2) {
        this.afT113SenkyoShikaku.setNikeimochiFlag(刑持ちフラグ2);
    }

    /**
     * データ登録年月日を設定します。
     *
     * @param データ登録年月日 FlexibleDate
     */
    public void setデータ登録年月日(FlexibleDate データ登録年月日) {
        this.afT113SenkyoShikaku.setDataTorokuYMD(データ登録年月日);
    }
}
