/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiTohyokuConditionDBEditor {

    private final AfT142TohyokuConditionEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiTohyokuConditionDBEditor(AfT142TohyokuConditionEntity entity) {
        this.entity = entity;
    }

    /**
     * 投票区抽出条件データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param 住民種別条件 RString
     * @return AfT100ShohonEntity
     */
    public AfT142TohyokuConditionEntity edit投票区抽出条件データの編集(ShohonNo shohonNo,
            RString 住民種別条件) {
        entity.setShohonNo(shohonNo);
        entity.setTohyokuCode(住民種別条件);

        return entity;
    }

}
