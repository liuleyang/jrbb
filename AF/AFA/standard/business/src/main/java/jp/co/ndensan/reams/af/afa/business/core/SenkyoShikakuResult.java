/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格
 *
 * @reamsid_L AF-0190-010 guancy
 */
public class SenkyoShikakuResult {

    private AfT113SenkyoShikakuEntity entity;

    /**
     * コンストラクタです。
     */
    public SenkyoShikakuResult() {
        entity = new AfT113SenkyoShikakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT113SenkyoShikakuEntity
     */
    public SenkyoShikakuResult(AfT113SenkyoShikakuEntity entity) {
        this.entity = entity;
    }

    /**
     * AfT113SenkyoShikakuEntityを返します。
     *
     * @return AfT113SenkyoShikakuEntity
     */
    public AfT113SenkyoShikakuEntity getEntity() {
        return entity;
    }

    /**
     * AfT113SenkyoShikakuEntityを設定します。
     *
     * @param entity AfT113SenkyoShikakuEntity
     */
    public void setEntity(AfT113SenkyoShikakuEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類 Code
     */
    public Code get選挙種類() {
        return this.entity.getSenkyoShurui();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号 BigSerial
     */
    public BigSerial get履歴番号() {
        return this.entity.getSeq();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分 Code
     */
    public Code get選挙資格区分() {
        return this.entity.getShikakuKubun();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード Rstring
     */
    public RString get投票区コード() {
        return this.entity.getTohyokuCode();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日 FlexibleDate
     */
    public FlexibleDate get名簿登録年月日() {
        return this.entity.getMeiboTorokuYMD();
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード Code
     */
    public Code get登録事由コード() {
        return this.entity.getTorokuJiyuCode();
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日 FlexibleDate
     */
    public FlexibleDate get登録停止年月日() {
        return this.entity.getTorokuTeishiYMD();
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード Code
     */
    public Code get登録停止事由コード() {
        return this.entity.getTorokuTeishiJiyuCode();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日 FlexibleDate
     */
    public FlexibleDate get表示年月日() {
        return this.entity.getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード Code
     */
    public Code get表示事由コード() {
        return this.entity.getHyojiJiyuCode();
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日 FlexibleDate
     */
    public FlexibleDate get表示消除年月日() {
        return this.entity.getHyojiShojoYMD();
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日 FlexibleDate
     */
    public FlexibleDate get表示消除予定年月日() {
        return this.entity.getHyojiShojoYoteiYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日 FlexibleDate
     */
    public FlexibleDate get抹消年月日() {
        return this.entity.getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード Code
     */
    public Code get抹消事由コード() {
        return this.entity.getMasshoJiyuCode();
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日 FlexibleDate
     */
    public FlexibleDate get刑期終了年月日() {
        return this.entity.getKeikiShuryoYMD();
    }

    /**
     * 2刑持ちフラグを返します。
     *
     * @return 2刑持ちフラグ boolean
     */
    public boolean is2刑持ちフラグ() {
        return this.entity.getNikeimochiFlag();
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 Code
     */
    public void set選挙種類(Code 選挙種類) {
        this.entity.setSenkyoShurui(選挙種類);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.entity.setShikibetsuCode(識別コード);
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 BigSerial
     */
    public void set履歴番号(BigSerial 履歴番号) {
        this.entity.setSeq(履歴番号);
    }

    /**
     * 選挙資格区分を設定します。
     *
     * @param 選挙資格区分 Code
     */
    public void set選挙資格区分(Code 選挙資格区分) {
        this.entity.setShikakuKubun(選挙資格区分);
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード Rstring
     */
    public void set投票区コード(RString 投票区コード) {
        this.entity.setTohyokuCode(投票区コード);
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 FlexibleDate
     */
    public void set名簿登録年月日(FlexibleDate 名簿登録年月日) {
        this.entity.setMeiboTorokuYMD(名簿登録年月日);
    }

    /**
     * 登録事由コードを設定します。
     *
     * @param 登録事由コード Code
     */
    public void set登録事由コード(Code 登録事由コード) {
        this.entity.setTorokuJiyuCode(登録事由コード);
    }

    /**
     * 登録停止年月日を設定します。
     *
     * @param 登録停止年月日 FlexibleDate
     */
    public void set登録停止年月日(FlexibleDate 登録停止年月日) {
        this.entity.setTorokuTeishiYMD(登録停止年月日);
    }

    /**
     * 登録停止事由コードを設定します。
     *
     * @param 登録停止事由コード Code
     */
    public void set登録停止事由コード(Code 登録停止事由コード) {
        this.entity.setTorokuTeishiJiyuCode(登録停止事由コード);
    }

    /**
     * 表示年月日を設定します。
     *
     * @param 表示年月日 FlexibleDate
     */
    public void set表示年月日(FlexibleDate 表示年月日) {
        this.entity.setHyojiYMD(表示年月日);
    }

    /**
     * 表示事由コードを設定します。
     *
     * @param 表示事由コード Code
     */
    public void set表示事由コード(Code 表示事由コード) {
        this.entity.setHyojiJiyuCode(表示事由コード);
    }

    /**
     * 表示消除年月日を設定します。
     *
     * @param 表示消除年月日 FlexibleDate
     */
    public void set表示消除年月日(FlexibleDate 表示消除年月日) {
        this.entity.setHyojiShojoYMD(表示消除年月日);
    }

    /**
     * 表示消除予定年月日を設定します。
     *
     * @param 表示消除予定年月日 FlexibleDate
     */
    public void set表示消除予定年月日(FlexibleDate 表示消除予定年月日) {
        this.entity.setHyojiShojoYoteiYMD(表示消除予定年月日);
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param 抹消年月日 FlexibleDate
     */
    public void set抹消年月日(FlexibleDate 抹消年月日) {
        this.entity.setMasshoYMD(抹消年月日);
    }

    /**
     * 抹消事由コードを設定します。
     *
     * @param 抹消事由コード Code
     */
    public void set抹消事由コード(Code 抹消事由コード) {
        this.entity.setMasshoJiyuCode(抹消事由コード);
    }

    /**
     * 刑期終了年月日を設定します。
     *
     * @param 刑期終了年月日 FlexibleDate
     */
    public void set刑期終了年月日(FlexibleDate 刑期終了年月日) {
        this.entity.setKeikiShuryoYMD(刑期終了年月日);
    }

    /**
     * 刑持ちフラグ2を設定します。
     *
     * @param 刑持ちフラグ2 boolean
     */
    public void set2刑持ちフラグ(boolean 刑持ちフラグ2) {
        this.entity.setNikeimochiFlag(刑持ちフラグ2);
    }

}
