/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jushojokenselect;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;

/**
 * 地区3抽出条件情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class Chiku3ConditionResult {

    private final AfT147Chiku3ConditionEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT147Chiku3ConditionEntity}より{@link Chiku3ConditionResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT147Chiku3ConditionEntity}
     */
    public Chiku3ConditionResult(AfT147Chiku3ConditionEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区3抽出条件"));
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
     * 地区コード3を返します。
     *
     * @return 地区コード3
     */
    public ChikuCode get地区コード3() {
        return this.entity.getChikuCode3();
    }

}
