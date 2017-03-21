/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiGyoseikuConditionDBEditor {

    private final AfT143GyoseikuConditionEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiGyoseikuConditionDBEditor(AfT143GyoseikuConditionEntity entity) {
        this.entity = entity;
    }

    /**
     * 行政区抽出条件データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param 住民種別条件 RString
     * @return AfT100ShohonEntity
     */
    public AfT143GyoseikuConditionEntity edit行政区抽出条件データの編集(ShohonNo shohonNo,
            RString 住民種別条件) {
        entity.setShohonNo(shohonNo);
        entity.setGyoseikuCode(new GyoseikuCode(住民種別条件));
        return entity;
    }

}
