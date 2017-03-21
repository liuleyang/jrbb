/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shohon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo.SenkyoninMeiboEntity;

/**
 * 抄本RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShohonEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 抄本Entityを返します。
     *
     * @return 抄本Entity -- SETTER -- 抄本Entityを設定します。
     *
     * @param 抄本Entity 抄本Entity
     */
    private AfT100ShohonEntity 抄本Entity;

    /**
     * -- GETTER -- 選挙EntityListを返します。
     *
     * @return 選挙EntityList -- SETTER -- 選挙EntityListを設定します。
     *
     * @param 選挙EntityList 選挙EntityList
     */
    private List<SenkyoEntity> 選挙Entity;

    /**
     * -- GETTER -- 選挙人名簿EntityListを返します。
     *
     * @return 選挙人名簿EntityList -- SETTER -- 選挙人名簿EntityListを設定します。
     *
     * @param 選挙人名簿EntityList 選挙人名簿EntityList
     */
    private List<SenkyoninMeiboEntity> 選挙人名簿Entity;

    /**
     * -- GETTER -- 選挙資格EntityListを返します。
     *
     * @return 選挙資格EntityList -- SETTER -- 選挙資格EntityListを設定します。
     *
     * @param 選挙資格EntityList 選挙資格EntityList
     */
    private List<AfT113SenkyoShikakuEntity> 選挙資格Entity;

    /**
     * コンストラクタです。
     */
    public ShohonEntity() {
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new ArrayList<>();
        選挙人名簿Entity = new ArrayList<>();
        選挙資格Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShohonEntityが持つ{@link 選挙Entity}と{@link 選挙人名簿Entity}と<br/> {@link 選挙資格Entity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.抄本Entity.initializeMd5();
        for (SenkyoEntity entity : this.選挙Entity) {
            entity.get選挙Entity().initializeMd5();
        }
        for (SenkyoninMeiboEntity entity : this.選挙人名簿Entity) {
            entity.get選挙人名簿Entity().initializeMd5();
        }
        for (AfT113SenkyoShikakuEntity entity : this.選挙資格Entity) {
            entity.initializeMd5();
        }
    }
}
