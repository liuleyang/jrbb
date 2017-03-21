/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;

/**
 * 選挙RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SenkyoEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 選挙Entityを返します。
     *
     * @return 選挙Entity -- SETTER -- 選挙Entityを設定します。
     *
     * @param 選挙Entity 選挙Entity
     */
    private AfT111SenkyoEntity 選挙Entity;
    /**
     * -- GETTER -- 投票状況EntityListを返します。
     *
     * @return 投票状況EntityList -- SETTER -- 投票状況EntityListを設定します。
     *
     * @param 投票状況EntityList 投票状況EntityList
     */
    private List<AfT201TohyoJokyoEntity> 投票状況Entity;

    /**
     * コンストラクタです。
     */
    public SenkyoEntity() {
        選挙Entity = new AfT111SenkyoEntity();
        投票状況Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * SenkyoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.選挙Entity.initializeMd5();
        for (AfT201TohyoJokyoEntity entity : this.投票状況Entity) {
            entity.initializeMd5();
        }
    }
}
