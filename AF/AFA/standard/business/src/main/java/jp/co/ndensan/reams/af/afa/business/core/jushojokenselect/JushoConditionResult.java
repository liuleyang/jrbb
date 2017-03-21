/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jushojokenselect;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;

/**
 * 住所抽出条件情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoConditionResult {

    private final AfT144JushoConditionEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT144JushoConditionEntity}より{@link JushoConditionResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT144JushoConditionEntity}
     */
    public JushoConditionResult(AfT144JushoConditionEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住所抽出条件"));
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
     * 町域コードを返します。
     *
     * @return 町域コード
     */
    public ChoikiCode get町域コード() {
        return this.entity.getChoikiCode();
    }

}
