/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 選挙情報を格納するEntityクラスです。
 */
public class SenkyoJohoEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity shohonEntity;
    private List<AfT111SenkyoEntity> senkyoEntityList;

    /**
     * 抄本Entityを返します。
     *
     * @return 抄本Entity
     */
    public AfT100ShohonEntity getShohonEntity() {
        return shohonEntity;
    }

    /**
     * 抄本Entityを設定します。
     *
     * @param shohonEntity 抄本Entity
     */
    public void setShohonEntity(AfT100ShohonEntity shohonEntity) {
        this.shohonEntity = shohonEntity;
    }

    /**
     * 選挙Entityを返します。
     *
     * @return 選挙EntityList
     */
    public List<AfT111SenkyoEntity> getSenkyoEntity() {
        return senkyoEntityList;
    }

    /**
     * 選挙Entityを設定します。
     *
     * @param senkyoEntityList List<AfT111SenkyoEntity>
     */
    public void setSenkyoEntity(List<AfT111SenkyoEntity> senkyoEntityList) {
        this.senkyoEntityList = senkyoEntityList;
    }

    /**
     * 選挙情報エンティティとしての状態を返します。<br />
     *
     * 親テーブルの状態がDB登録対象(Added、Modified、Deleted)の場合、その値を返します。<br />
     * 親テーブルの状態が変更無し(Unchanged)の場合、子テーブルのいずれかの状態がDB登録対象の場合、Modifiedを返します。<br />
     * 子テーブルのいずれも変更無しの場合、Unchangedを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {

        if (getShohonEntity().getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return getShohonEntity().getState();
    }

    private boolean isChildChanged() {

        if (getSenkyoEntity() == null) {
            return false;
        }
        for (AfT111SenkyoEntity senkyoEntity : getSenkyoEntity()) {
            if (senkyoEntity.getState() != EntityDataState.Unchanged) {
                return true;
            }
        }
        return false;
    }

}
