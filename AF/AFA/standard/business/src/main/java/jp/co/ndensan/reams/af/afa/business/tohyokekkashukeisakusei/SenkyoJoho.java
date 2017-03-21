/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokekkashukeisakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙情報です。
 *
 * @reamsid_L AF-0290-011 wangxt2
 */
public class SenkyoJoho implements Serializable {

    private final AfT111SenkyoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT111SenkyoEntity
     */
    public SenkyoJoho(AfT111SenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     */
    public SenkyoJoho() {
        this.entity = new AfT111SenkyoEntity();
    }

    /**
     * senkyoNoのgetメソッドです。
     *
     * @return senkyoNo
     */
    public SenkyoNo getSenkyoNo() {
        return entity.getSenkyoNo();
    }

    /**
     * senkyoNameのgetメソッドです。
     *
     * @return senkyoName
     */
    public RString getSenkyoName() {
        return entity.getSenkyoName();
    }

    /**
     * mutohyoSenkyoFlagのhasメソッドです。
     *
     * @return mutohyoSenkyoFlag
     */
    public boolean hasMutohyoSenkyoFlag() {
        return entity.getMutohyoSenkyoFlag();
    }

}
