/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;

/**
 * Ur投票区RelateEntityクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
@lombok.Getter
@lombok.Setter
public class UrTohyokuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 投票区Entityを返します。
     *
     * @return 投票区Entity -- SETTER -- 投票区Entityを設定します。
     *
     * @param UR投票区Entity 投票区Entity
     */
    private UrT0159TohyokuEntity 投票区Entity;

    /**
     * -- GETTER -- 投票所EntityListを返します。
     *
     * @return 投票所EntityList -- SETTER -- 投票所EntityListを設定します。
     *
     * @param 投票所EntityList 投票所EntityList
     */
    private List<AfT502TohyojoEntity> 投票所Entity;

    /**
     * コンストラクタです。
     */
    public UrTohyokuEntity() {
        投票区Entity = new UrT0159TohyokuEntity();
        投票所Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TohyokuEntityが持つ{@link 投票所Entity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.投票区Entity.initializeMd5();
        for (AfT502TohyojoEntity entity : this.投票所Entity) {
            entity.initializeMd5();
        }
    }
}
