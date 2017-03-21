/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 投票状況情報を格納するEntityクラスです。
 */
public class TohyoJokyoJohoEntity implements Serializable {

    private SenkyoJohoEntity senkyoJohoEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT201TohyoJokyoEntity tohyoJokyoEntity;
    private UaFt200FindShikibetsuTaishoEntity atenaPSMEntity;

    /**
     * コンストラクタです。
     *
     * @param tohyoJokyoEntity 投票状況Entity
     */
    public TohyoJokyoJohoEntity(AfT201TohyoJokyoEntity tohyoJokyoEntity) {
        this.tohyoJokyoEntity = tohyoJokyoEntity;
    }

    /**
     * コンストラクタです。
     *
     * @param shohonNo 抄本番号
     * @param shikibetsuCode 識別コード
     * @param senkyoNo 選挙番号
     */
    public TohyoJokyoJohoEntity(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo senkyoNo) {
        set主キーTohyoJokyoEntity(shohonNo, shikibetsuCode, senkyoNo);
        set主キーKijitsuzenTojitsuEntity(shohonNo, shikibetsuCode, senkyoNo);
        set主キーFuzaishaTohyoEntity(shohonNo, shikibetsuCode, senkyoNo);
    }

    private void set主キーTohyoJokyoEntity(
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo senkyoNo) {
        tohyoJokyoEntity.setShohonNo(shohonNo);
        tohyoJokyoEntity.setShikibetsuCode(shikibetsuCode);
        tohyoJokyoEntity.setSenkyoNo(senkyoNo);
    }

    private void set主キーKijitsuzenTojitsuEntity(
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo senkyoNo) {

    }

    private void set主キーFuzaishaTohyoEntity(
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo senkyoNo) {

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
     * 投票状況Entityを返します。
     *
     * @return 投票状況Entity
     */
    public AfT201TohyoJokyoEntity getTohyoJokyoEntity() {
        return tohyoJokyoEntity;
    }

    /**
     * 投票状況Entityを設定します。
     *
     * @param tohyoJokyoEntity 投票状況Entity
     */
    public void setTohyoJokyoEntity(AfT201TohyoJokyoEntity tohyoJokyoEntity) {
        this.tohyoJokyoEntity = tohyoJokyoEntity;
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
     * 投票状況情報エンティティとしての状態を返します。<br />
     *
     * 親テーブルの状態がDB登録対象(Added、Modified、Deleted)の場合、その値を返します。<br />
     * 親テーブルの状態が変更無し(Unchanged)の場合、子テーブルのいずれかの状態がDB登録対象の場合、Modifiedを返します。<br />
     * 子テーブルのいずれも変更無しの場合、Unchangedを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {

        if (getTohyoJokyoEntity().getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return getTohyoJokyoEntity().getState();
    }

    private boolean isChildChanged() {
        boolean isChanged = false;
        return isChanged;
    }
}
