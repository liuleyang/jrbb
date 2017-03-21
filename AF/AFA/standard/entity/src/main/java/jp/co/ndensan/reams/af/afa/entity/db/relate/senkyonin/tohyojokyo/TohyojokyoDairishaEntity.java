/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.tohyojokyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 投票状況代理者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TohyojokyoDairishaEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 投票状況Entityを返します。
     *
     * @return 投票状況Entity -- SETTER -- 投票状況Entityを設定します。
     *
     * @param 投票状況Entity 投票状況Entity
     */
    private AfT201TohyoJokyoEntity 投票状況Entity;

    /**
     * -- GETTER -- 宛名情報Entityを返します。
     *
     * @return 宛名情報Entity -- SETTER -- 宛名情報Entityを設定します。
     *
     * @param 宛名情報Entity 宛名情報Entity
     */
    private UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;

    /**
     * コンストラクタです。
     */
    public TohyojokyoDairishaEntity() {
        投票状況Entity = new AfT201TohyoJokyoEntity();
        宛名情報Entity = new UaFt200FindShikibetsuTaishoEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TohyojokyoDairishaEntityが持つ{@link 投票状況Entity}と{@link 宛名情報Entity}と<br/>のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.投票状況Entity.initializeMd5();
        this.宛名情報Entity.initializeMd5();
    }
}
