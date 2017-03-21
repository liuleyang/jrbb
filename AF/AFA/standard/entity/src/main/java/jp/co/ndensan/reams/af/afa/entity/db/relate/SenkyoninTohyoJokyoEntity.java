/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人資格の情報を格納するEntityクラスです。
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class SenkyoninTohyoJokyoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString breakPage;
    private SenkyoJohoEntity senkyoJohoEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private AfT114FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity;
    private AfT115FuzaishaTohyoShikakuYubinEntity fuzaishaTohyoShikakuYubinEntity;
    private List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList;
    private UaFt200FindShikibetsuTaishoEntity atenaPSMEntity;
    private AfT121ZaigaiSenkyoninMeiboEntity zaigaiSenkyoninMeiboEntity;
    private AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity;
    private AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity;
    private AfT123ZaigaiSenkyoninJushoEntity zaigaiSenkyoninJushoEntity;
    private List<AfT505SenkyokuTanmatsuKanriEntity> senkyokuTanmatsuKanriEntityList;
    private int aft505Count;
    private int afT111Count;

    /**
     * 改頁を返します。
     *
     * @return 改頁
     */
    public RString getBreakPage() {
        return breakPage;
    }

    /**
     * 改頁を設定します。
     *
     * @param breakPage 改頁
     */
    public void setBreakPage(RString breakPage) {
        this.breakPage = breakPage;
    }

    /**
     * 選挙情報Entityを返します。
     *
     * @return 選挙情報Entity
     */
    public SenkyoJohoEntity getSenkyoJohoEntity() {
        return senkyoJohoEntity;
    }

    /**
     * 選挙情報Entityを設定します。
     *
     * @param senkyoJohoEntity 選挙情報Entity
     */
    public void setSenkyoJohoEntity(SenkyoJohoEntity senkyoJohoEntity) {
        this.senkyoJohoEntity = senkyoJohoEntity;
    }

    /**
     * 選挙Entityを返します。
     *
     * @return 選挙Entity
     */
    public AfT111SenkyoEntity getSenkyoEntity() {
        return senkyoEntity;
    }

    /**
     * 選挙Entityを設定します。
     *
     * @param senkyoEntity 選挙Entity
     */
    public void setSenkyoEntity(AfT111SenkyoEntity senkyoEntity) {
        this.senkyoEntity = senkyoEntity;
    }

    /**
     * 選挙人名簿Entityを返します。
     *
     * @return 選挙人名簿Entity
     */
    public AfT112SenkyoninMeiboEntity getSenkyoninMeiboEntity() {
        return senkyoninMeiboEntity;
    }

    /**
     * 選挙人名簿Entityを設定します。
     *
     * @param senkyoninMeiboEntity 選挙人名簿Entity
     */
    public void setSenkyoninMeiboEntity(AfT112SenkyoninMeiboEntity senkyoninMeiboEntity) {
        this.senkyoninMeiboEntity = senkyoninMeiboEntity;
    }

    /**
     * 選挙資格Entityを返します。
     *
     * @return 選挙資格Entity
     */
    public AfT113SenkyoShikakuEntity getSenkyoShikakuEntity() {
        return senkyoShikakuEntity;
    }

    /**
     * 選挙資格Entityを設定します。
     *
     * @param senkyoShikakuEntity 選挙資格Entity
     */
    public void setSenkyoShikakuEntity(AfT113SenkyoShikakuEntity senkyoShikakuEntity) {
        this.senkyoShikakuEntity = senkyoShikakuEntity;
    }

    /**
     * 不在者投票資格Entityを返します。
     *
     * @return 不在者投票資格Entity
     */
    public AfT114FuzaishaTohyoShikakuEntity getFuzaishaTohyoShikakuEntity() {
        return fuzaishaTohyoShikakuEntity;
    }

    /**
     * 不在者投票資格Entityを設定します。
     *
     * @param fuzaishaTohyoShikakuEntity 不在者投票資格Entity
     */
    public void setFuzaishaTohyoShikakuEntity(AfT114FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity) {
        this.fuzaishaTohyoShikakuEntity = fuzaishaTohyoShikakuEntity;
    }

    /**
     * 不在者投票資格郵便Entityを返します。
     *
     * @return 不在者投票資格郵便Entity
     */
    public AfT115FuzaishaTohyoShikakuYubinEntity getFuzaishaTohyoShikakuYubinEntity() {
        return fuzaishaTohyoShikakuYubinEntity;
    }

    /**
     * 不在者投票資格郵便Entityを設定します。
     *
     * @param fuzaishaTohyoShikakuYubinEntity 不在者投票資格郵便Entity
     */
    public void setFuzaishaTohyoShikakuYubinEntity(AfT115FuzaishaTohyoShikakuYubinEntity fuzaishaTohyoShikakuYubinEntity) {
        this.fuzaishaTohyoShikakuYubinEntity = fuzaishaTohyoShikakuYubinEntity;
    }

    /**
     * 宛名PSMを返します。
     *
     */
    public void setAtenaPSMEntity() {
        atenaPSMEntity = new UaFt200FindShikibetsuTaishoEntity();
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UaFt200FindShikibetsuTaishoEntity getAtenaPSMEntity() {
        return atenaPSMEntity;
    }

    /**
     * 宛名PSMを設定します。
     *
     * @param atenaPSMEntity 宛名PSM
     */
    public void setAtenaPSMEntity(UaFt200FindShikibetsuTaishoEntity atenaPSMEntity) {
        this.atenaPSMEntity = atenaPSMEntity;
    }

    /**
     * 投票状況Entitを返します。
     *
     * @return 投票状況EntityList
     */
    public List<AfT201TohyoJokyoEntity> getTohyoJokyoEntityList() {
        return tohyoJokyoEntityList;
    }

    /**
     * 投票状況Entityを設定します。
     *
     * @param tohyoJokyoEntityList 投票状況EntityList
     */
    public void setTohyoJokyoEntityList(List<AfT201TohyoJokyoEntity> tohyoJokyoEntityList) {
        this.tohyoJokyoEntityList = tohyoJokyoEntityList;
    }

    /**
     * 在外選挙人名簿Entityを返します。
     *
     * @return 在外選挙人名簿Entity
     */
    public AfT121ZaigaiSenkyoninMeiboEntity getZaigaiSenkyoninMeiboEntity() {
        return zaigaiSenkyoninMeiboEntity;
    }

    /**
     * 在外選挙人名簿Entityを設定します。
     *
     * @param zaigaiSenkyoninMeiboEntity 在外選挙人名簿Entity
     */
    public void setZaigaiSenkyoninMeiboEntity(AfT121ZaigaiSenkyoninMeiboEntity zaigaiSenkyoninMeiboEntity) {
        this.zaigaiSenkyoninMeiboEntity = zaigaiSenkyoninMeiboEntity;
    }

    /**
     * 在外選挙資格Entityを返します。
     *
     * @return 在外選挙資格Entity
     */
    public AfT122ZaigaiSenkyoShikakuEntity getZaigaiSenkyoShikakuEntity() {
        return zaigaiSenkyoShikakuEntity;
    }

    /**
     * 在外選挙資格Entityを設定します。
     *
     * @param zaigaiSenkyoShikakuEntity 在外選挙資格Entity
     */
    public void setZaigaiSenkyoShikakuEntity(AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity) {
        this.zaigaiSenkyoShikakuEntity = zaigaiSenkyoShikakuEntity;
    }

    /**
     * 在外選挙人申請Entityを返します。
     *
     * @return 在外選挙人申請Entity
     */
    public AfT124ZaigaiSenkyoninShinseiEntity getZaigaiSenkyoninShinseiEntity() {
        return zaigaiSenkyoninShinseiEntity;
    }

    /**
     * 在外選挙人申請Entityを設定します。
     *
     * @param zaigaiSenkyoninShinseiEntity 在外選挙人申請Entity
     */
    public void setZaigaiSenkyoninShinseiEntity(AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity) {
        this.zaigaiSenkyoninShinseiEntity = zaigaiSenkyoninShinseiEntity;
    }

    /**
     * 在外選挙人住所Entityを返します。
     *
     * @return 在外選挙人住所Entity
     */
    public AfT123ZaigaiSenkyoninJushoEntity getZaigaiSenkyoninJushoEntity() {
        return zaigaiSenkyoninJushoEntity;
    }

    /**
     * 在外選挙人住所Entityを設定します。
     *
     * @param zaigaiSenkyoninJushoEntity 在外選挙人住所Entity
     */
    public void setZaigaiSenkyoninJushoEntity(AfT123ZaigaiSenkyoninJushoEntity zaigaiSenkyoninJushoEntity) {
        this.zaigaiSenkyoninJushoEntity = zaigaiSenkyoninJushoEntity;
    }

    /**
     * 選挙区端末管理Entitを返します。
     *
     * @return 選挙区端末管理EntityList
     */
    public List<AfT505SenkyokuTanmatsuKanriEntity> getSenkyokuTanmatsuKanriEntityList() {
        return senkyokuTanmatsuKanriEntityList;
    }

    /**
     * 選挙区端末管理Entityを設定します。
     *
     * @param senkyokuTanmatsuKanriEntityList 選挙区端末管理EntityList
     */
    public void setSenkyokuTanmatsuKanriEntityList(List<AfT505SenkyokuTanmatsuKanriEntity> senkyokuTanmatsuKanriEntityList) {
        this.senkyokuTanmatsuKanriEntityList = senkyokuTanmatsuKanriEntityList;
    }

    /**
     * 選挙区端末管理Countを返します。
     *
     * @return 選挙区端末管理Count
     */
    public int getAft505Count() {
        return aft505Count;
    }

    /**
     * 選挙区端末管理Countを設定します。
     *
     * @param aft505Count 選挙区端末管理Count
     */
    public void setAft505Count(int aft505Count) {
        this.aft505Count = aft505Count;
    }

    /**
     * 選挙Countを返します。
     *
     * @return 選挙Count
     */
    public int getAfT111Count() {
        return afT111Count;
    }

    /**
     * 選挙Countを設定します。
     *
     * @param afT111Count 選挙Count
     */
    public void setAfT111Count(int afT111Count) {
        this.afT111Count = afT111Count;
    }

    /**
     * 選挙を追加します。
     *
     * @param senkyoEntity AfT111SenkyoEntity
     */
    public void addSenkyo(AfT111SenkyoEntity senkyoEntity) {
        this.getSenkyoJohoEntity().getSenkyoEntity().add(senkyoEntity);
    }

    /**
     * 選挙を追加します。
     *
     * @param senkyoEntity AfT111SenkyoEntity
     * @param tohyoJokyoEntity AfT201TohyoJokyoEntity
     */
    public void addSenkyo(AfT111SenkyoEntity senkyoEntity, AfT201TohyoJokyoEntity tohyoJokyoEntity) {
        this.getSenkyoJohoEntity().getSenkyoEntity().add(senkyoEntity);
        this.getTohyoJokyoEntityList().add(tohyoJokyoEntity);
    }
}
