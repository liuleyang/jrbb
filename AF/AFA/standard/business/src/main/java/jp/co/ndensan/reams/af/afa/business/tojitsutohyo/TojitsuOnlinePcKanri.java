/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tojitsutohyo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT253TojitsuOnlinePcKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当日投票の帳票出力用データクラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuOnlinePcKanri {

    private final AfT253TojitsuOnlinePcKanriEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public TojitsuOnlinePcKanri(AfT253TojitsuOnlinePcKanriEntity entity) {
        this.entity = entity;

    }

    /**
     * 投票終了時間のgetメソッドです。
     *
     * @return 投票終了時間
     */
    public RString get投票区コード() {
        return entity.getTohyokuCode();
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public AfT253TojitsuOnlinePcKanriEntity getEntity() {
        return entity;
    }
}
