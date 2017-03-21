/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jushojokenselect;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;

/**
 * 行政区抽出条件情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class GyoseikuConditionResult {

    private final AfT143GyoseikuConditionEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT143GyoseikuConditionEntity}より{@link GyoseikuConditionResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT143GyoseikuConditionEntity}
     */
    public GyoseikuConditionResult(AfT143GyoseikuConditionEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("行政区抽出条件"));
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
     * 行政区コードを返します。
     *
     * @return 行政区コード
     */
    public GyoseikuCode get行政区コード() {
        return this.entity.getGyoseikuCode();
    }

}
