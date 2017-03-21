/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人名簿
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiSenkyoninMeiboResult {

    private AfT121ZaigaiSenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。
     */
    public ZaigaiSenkyoninMeiboResult() {
        entity = new AfT121ZaigaiSenkyoninMeiboEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT121ZaigaiSenkyoninMeiboEntity
     */
    public ZaigaiSenkyoninMeiboResult(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        this.entity = entity;
    }

    /**
     * AfT121ZaigaiSenkyoninMeiboEntityを返します。
     *
     * @return AfT121ZaigaiSenkyoninMeiboEntity
     */
    public AfT121ZaigaiSenkyoninMeiboEntity getEntity() {
        return entity;
    }

    /**
     * AfT121ZaigaiSenkyoninMeiboEntityを設定します。
     *
     * @param entity AfT121ZaigaiSenkyoninMeiboEntity
     */
    public void setEntity(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return this.entity.getShohonNo();
    }

    /**
     * グループコードを返します。
     *
     * @return グループコード
     */
    public RString getグループコード() {
        return this.entity.getGroupCode();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.entity.getTohyokuCode();
    }

    /**
     * 国外分類コードを返します。
     *
     * @return 国外分類コード
     */
    public RString get国外分類コード() {
        return this.entity.getKokugaiBunruiCode();
    }

    /**
     * 冊を返します。
     *
     * @return 冊
     */
    public RString get冊() {
        return this.entity.getSatsu();
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return this.entity.getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return this.entity.getGyo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * 抄本番号を設定します。
     *
     * @param shohonNo 抄本番号
     */
    public void set抄本番号(ShohonNo shohonNo) {
        this.entity.setShohonNo(shohonNo);
    }

    /**
     * グループコードを設定します。
     *
     * @param groupCode グループコード
     */
    public void setグループコード(RString groupCode) {
        this.entity.setGroupCode(groupCode);
    }

    /**
     * 投票区コードを設定します。
     *
     * @param tohyokuCode 投票区コード
     */
    public void set投票区コード(RString tohyokuCode) {
        this.entity.setTohyokuCode(tohyokuCode);
    }

    /**
     * 国外分類コードを設定します。
     *
     * @param kokugaiBunruiCode 国外分類コード
     */
    public void set国外分類コード(RString kokugaiBunruiCode) {
        this.entity.setKokugaiBunruiCode(kokugaiBunruiCode);
    }

    /**
     * 冊を設定します。
     *
     * @param satsu 冊
     */
    public void set冊(RString satsu) {
        this.entity.setSatsu(satsu);
    }

    /**
     * 頁を設定します。
     *
     * @param page 頁
     */
    public void set頁(int page) {
        this.entity.setPage(page);
    }

    /**
     * 行を設定します。
     *
     * @param gyo 行
     */
    public void set行(int gyo) {
        this.entity.setGyo(gyo);
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.entity.setShikibetsuCode(shikibetsuCode);
    }

}
