/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.shikakushokai;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;

/**
 * 不在者投票資格FuzaishaTohyoShikakuEntityクラスです。
 *
 * @reamsid_L AF-0190-010 guancy
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
     * -- GETTER -- 郵便投票資格付随情報Entityを返します。
     *
     * @return 郵便投票資格付随情報Entity -- SETTER -- 郵便投票資格付随情報Entityを設定します。
     *
     * @param 郵便投票資格付随情報Entity 郵便投票資格付随情報Entity
     */
    private AfT115FuzaishaTohyoShikakuYubinEntity 郵便投票資格付随情報Entity;

    /**
     * コンストラクタです。
     */
    public FuzaishaTohyoShikakuEntity() {
        不在者投票資格Entity = new AfT114FuzaishaTohyoShikakuEntity();
        郵便投票資格付随情報Entity = new AfT115FuzaishaTohyoShikakuYubinEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * FuzaishaTohyoShikakuEntityが持つ{@link 不在者投票資格Entity}と{@link 郵便投票資格付随情報Entity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.不在者投票資格Entity.initializeMd5();
        this.郵便投票資格付随情報Entity.initializeMd5();

    }
}
