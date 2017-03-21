/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jushojokenselect;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区抽出条件情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class TohyokuConditionResult {

    private final AfT142TohyokuConditionEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT142TohyokuConditionEntity}より{@link TohyokuConditionResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT142TohyokuConditionEntity}
     */
    public TohyokuConditionResult(AfT142TohyokuConditionEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区抽出条件"));
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return this.entity.getShohonNo();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.entity.getTohyokuCode();
    }

}
