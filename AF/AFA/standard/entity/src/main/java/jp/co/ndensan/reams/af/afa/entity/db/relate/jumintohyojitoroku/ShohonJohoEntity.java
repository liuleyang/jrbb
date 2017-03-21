/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyojitoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;

/**
 * 抄本RelateEntityクラスです。
 *
 * @reamsid_L AF-0450-010 jihb
 */
@lombok.Getter
@lombok.Setter
public class ShohonJohoEntity implements Cloneable, Serializable {

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
     * @param 選挙Entity AfT111SenkyoEntity
     */
    private AfT111SenkyoEntity 選挙Entity;
    /**
     * -- GETTER -- 財産区抽出条件Entityを返します。
     *
     * @return 財産区抽出条件Entity -- SETTER -- 財産区抽出条件Entityを設定します。
     *
     * @param 財産区抽出条件Entity AfT141ZaisankuJuminTohyoConditionEntity
     */
    private AfT141ZaisankuJuminTohyoConditionEntity 財産区抽出条件Entity;

    /**
     * コンストラクタです。
     */
    public ShohonJohoEntity() {
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new AfT111SenkyoEntity();
        財産区抽出条件Entity = new AfT141ZaisankuJuminTohyoConditionEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShohonJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.抄本Entity.initializeMd5();
        this.選挙Entity.initializeMd5();
        this.財産区抽出条件Entity.initializeMd5();
    }
}
