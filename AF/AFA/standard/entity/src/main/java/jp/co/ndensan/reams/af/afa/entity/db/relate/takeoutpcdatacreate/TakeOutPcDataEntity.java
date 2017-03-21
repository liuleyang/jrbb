/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacreate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;

/**
 * 抄本RelateEntityクラスです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
@lombok.Getter
@lombok.Setter
public class TakeOutPcDataEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 抄本Entityを返します。
     *
     * @return 抄本Entity -- SETTER -- 抄本Entityを設定します。
     *
     * @param 抄本Entity AfT100ShohonEntity
     */
    private AfT100ShohonEntity 抄本Entity;
    /**
     * -- GETTER -- 選挙Entityを返します。
     *
     * @return 選挙Entity -- SETTER -- 選挙Entityを設定します。
     *
     * @param 選挙Entity List<AfT111SenkyoEntity>
     */
    private List<AfT111SenkyoEntity> 選挙Entity;

    /**
     * コンストラクタです。
     */
    public TakeOutPcDataEntity() {
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TakeOutPcDataEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.抄本Entity.initializeMd5();
    }
}
