/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;

/**
 * 抄本RelateEntityクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
@lombok.Getter
@lombok.Setter
public class TakeOutPcDataCaptureEntity implements Cloneable, Serializable {

    private AfT100ShohonEntity 抄本Entity;

    private List<AfT111SenkyoEntity> 選挙Entity;

    private AfT252MochidashiPcJotaiKanriEntity 持出端末状態管理選挙Entity;

    /**
     * コンストラクタです。
     */
    public TakeOutPcDataCaptureEntity() {
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new ArrayList<>();
        持出端末状態管理選挙Entity = new AfT252MochidashiPcJotaiKanriEntity();
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
