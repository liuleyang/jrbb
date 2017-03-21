/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuEntity;

/**
 * 選挙資格RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SenkyoShikakuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 選挙資格Entityを返します。
     *
     * @return 選挙資格Entity -- SETTER -- 選挙資格Entityを設定します。
     *
     * @param 選挙資格Entity 選挙資格Entity
     */
    private AfT113SenkyoShikakuEntity 選挙資格Entity;
    /**
     * -- GETTER -- 不在者投票資格EntityListを返します。
     *
     * @return 不在者投票資格EntityList -- SETTER -- 不在者投票資格EntityListを設定します。
     *
     * @param 不在者投票資格EntityList 不在者投票資格EntityList
     */
    private List<FuzaishaTohyoShikakuEntity> 不在者投票資格Entity;

    /**
     * コンストラクタです。
     */
    public SenkyoShikakuEntity() {
        選挙資格Entity = new AfT113SenkyoShikakuEntity();
        不在者投票資格Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * SenkyoShikakuEntityが持つ{@link 不在者投票資格Entity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.選挙資格Entity.initializeMd5();
        for (FuzaishaTohyoShikakuEntity entity : this.不在者投票資格Entity) {
            entity.get不在者投票資格Entity().initializeMd5();
        }
    }
}
