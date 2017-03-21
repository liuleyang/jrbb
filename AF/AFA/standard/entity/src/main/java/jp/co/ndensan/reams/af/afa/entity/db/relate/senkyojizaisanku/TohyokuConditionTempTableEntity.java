/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 投票区抽出条件の一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0600-020 chenh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyokuConditionTempTableEntity extends DbTableEntityBase<TohyokuConditionTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShohonNo shohonNo;
    @TempTableColumnOrder(2)
    private RString tohyokuCode;

}
