/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;

/**
 * 不在者投票資格RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class FuzaishaTohyoShikakuEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 不在者投票資格Entityを返します。
     *
     * @return 不在者投票資格Entity -- SETTER -- 不在者投票資格Entityを設定します。
     *
     * @param 不在者投票資格Entity 不在者投票資格Entity
     */
    private AfT114FuzaishaTohyoShikakuEntity 不在者投票資格Entity;
    /**
     * -- GETTER -- 郵便投票資格付随情報EntityListを返します。
     *
     * @return 郵便投票資格付随情報EntityList -- SETTER -- 郵便投票資格付随情報EntityListを設定します。
     *
     * @param 郵便投票資格付随情報EntityList 郵便投票資格付随情報EntityList
     */
    private List<AfT115FuzaishaTohyoShikakuYubinEntity> 郵便投票資格付随情報Entity;

    /**
     * コンストラクタです。
     */
    public FuzaishaTohyoShikakuEntity() {
        不在者投票資格Entity = new AfT114FuzaishaTohyoShikakuEntity();
        郵便投票資格付随情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * FuzaishaTohyoShikakuEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.不在者投票資格Entity.initializeMd5();
        for (AfT115FuzaishaTohyoShikakuYubinEntity entity : this.郵便投票資格付随情報Entity) {
            entity.initializeMd5();
        }
    }
}
