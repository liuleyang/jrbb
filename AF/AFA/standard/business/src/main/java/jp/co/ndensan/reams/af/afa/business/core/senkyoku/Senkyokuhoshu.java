/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyoku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区を管理するクラスです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class Senkyokuhoshu implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private RString 選挙種類;
    private RString 選挙区コード;
    private RString 選挙名;
    private RString 端末Id;
    private AfT503SenkyokuEntity afT503SenkyokuEntity;

    /**
     * afT503SenkyokuEntityを設定します。
     *
     * @param afT503SenkyokuEntity AfT503SenkyokuEntity
     */
    public void setAfT503SenkyokuEntity(AfT503SenkyokuEntity afT503SenkyokuEntity) {
        this.afT503SenkyokuEntity = afT503SenkyokuEntity;
    }

    /**
     * afT503SenkyokuEntityを返します。
     *
     * @return afT503SenkyokuEntity AfT503SenkyokuEntity
     */
    public AfT503SenkyokuEntity getAfT503SenkyokuEntity() {
        return afT503SenkyokuEntity;
    }

    /**
     * 端末Idを返します。
     *
     * @return 端末Id RString
     */
    public RString get端末Id() {
        return 端末Id;
    }

    /**
     * 端末Idを設定します。
     *
     * @param 端末Id RString
     */
    public void set端末Id(RString 端末Id) {
        this.端末Id = 端末Id;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 RString
     */
    public void set選挙種類(RString 選挙種類) {
        this.選挙種類 = 選挙種類;
    }

    /**
     * 選挙区コードを設定します。
     *
     * @param 選挙区コード RString
     */
    public void set選挙区コード(RString 選挙区コード) {
        this.選挙区コード = 選挙区コード;
    }

    /**
     * 選挙名を設定します。
     *
     * @param 選挙名 RString
     */
    public void set選挙名(RString 選挙名) {
        this.選挙名 = 選挙名;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類 RString
     */
    public RString get選挙種類() {
        return this.選挙種類;
    }

    /**
     * 選挙区コードを返します。
     *
     * @return 選挙区コード RString
     */
    public RString get選挙区コード() {
        return this.選挙区コード;
    }

    /**
     * 選挙名を返します。
     *
     * @return 選挙名 RString
     */
    public RString get選挙名() {
        return this.選挙名;
    }

}
