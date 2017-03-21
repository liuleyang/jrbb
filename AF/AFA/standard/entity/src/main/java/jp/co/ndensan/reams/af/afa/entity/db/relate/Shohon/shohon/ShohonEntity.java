/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.shohon.shohon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;

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
    private List<AfT111SenkyoEntity> 選挙Entity;

    /**
     * コンストラクタです。
     */
    public ShohonEntity() {
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new ArrayList<>();

    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShohonEntityが持つ{@link 選挙Entity}と{@link AfT111SenkyoEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.抄本Entity.initializeMd5();
        for (AfT111SenkyoEntity entity : this.選挙Entity) {
            entity.initializeMd5();
        }

    }

//    public Object getShohonEntity() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
