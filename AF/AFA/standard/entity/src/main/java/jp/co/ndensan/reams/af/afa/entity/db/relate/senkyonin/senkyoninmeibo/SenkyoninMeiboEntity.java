/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku.SenkyoShikakuEntity;

/**
 * 選挙人名簿RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SenkyoninMeiboEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 選挙人名簿Entityを返します。
     *
     * @return 選挙人名簿Entity -- SETTER -- 選挙人名簿Entityを設定します。
     *
     * @param 選挙人名簿Entity 選挙人名簿Entity
     */
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;

    /**
     * -- GETTER -- 選挙資格EntityListを返します。
     *
     * @return 選挙資格EntityList -- SETTER -- 選挙資格EntityListを設定します。
     *
     * @param 選挙資格EntityList 選挙資格EntityList
     */
    private List<SenkyoShikakuEntity> 選挙資格Entity;

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
    public SenkyoninMeiboEntity() {
        選挙人名簿Entity = new AfT112SenkyoninMeiboEntity();
        選挙資格Entity = new ArrayList<>();
        投票状況Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * SenkyoninMeiboEntityが持つ{@link 選挙資格Entity}と{@link 投票状況Entity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.選挙人名簿Entity.initializeMd5();
        for (SenkyoShikakuEntity entity : this.選挙資格Entity) {
            entity.get選挙資格Entity().initializeMd5();
        }
        for (AfT201TohyoJokyoEntity entity : this.投票状況Entity) {
            entity.initializeMd5();
        }
    }
}
