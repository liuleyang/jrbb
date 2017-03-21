/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.nippo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票者一覧選挙
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyoshaListSenkyoResult {

    private NippoPSMPrintEntity entity;

    /**
     * コンストラクタです。
     */
    public TohyoshaListSenkyoResult() {
        entity = new NippoPSMPrintEntity();
        entity.set投票状況Entity(new AfT201TohyoJokyoEntity());
    }

    /**
     * コンストラクタです。
     *
     * @param entity NippoPSMPrintEntity
     */
    public TohyoshaListSenkyoResult(NippoPSMPrintEntity entity) {
        this.entity = entity;
    }

    /**
     * NippoPSMPrintEntityを返します。
     *
     * @return NippoPSMPrintEntity
     */
    public NippoPSMPrintEntity getEntity() {
        return entity;
    }

    /**
     * NippoPSMPrintEntityを設定します。
     *
     * @param entity NippoPSMPrintEntity
     */
    public void setEntity(NippoPSMPrintEntity entity) {
        this.entity = entity;
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日 FlexibleDate
     */
    public FlexibleDate get交付年月日() {
        return this.entity.get投票状況Entity().getKofuYMD();
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日 FlexibleDate
     */
    public FlexibleDate get受理年月日() {
        return this.entity.get投票状況Entity().getJuriYMD();
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード Code
     */
    public Code get投票事由コード() {
        return this.entity.get投票状況Entity().getTohyoJiyuCode();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return this.entity.get投票状況Entity().getShisetsuCode();
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称 RString
     */
    public RString get施設名称() {
        AfT507ShisetsuEntity 施設Entity = entity.get施設Entity();
        return 施設Entity == null ? RString.EMPTY : 施設Entity.getShisetsuName();
    }

}
