/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 裁判員名簿作成情報情報を管理するクラスです。
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class SaibaninMeiboSakuseiResult {

    private final AfT301SaibaninMeiboSakuseiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT301SaibaninMeiboSakuseiEntity}より{@link SaibaninMeiboSakuseiResult}を生成します。
     *
     * @param entity DBより取得した{@link AfT301SaibaninMeiboSakuseiEntity}
     */
    public SaibaninMeiboSakuseiResult(AfT301SaibaninMeiboSakuseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("裁判員名簿作成情報"));
    }

    /**
     *
     * @return AfT301SaibaninMeiboSakuseiEntity
     */
    public AfT301SaibaninMeiboSakuseiEntity toEntity() {
        return entity;
    }

    /**
     * 抄本番号を返します。
     *
     * @return ShohonNo
     */
    public ShohonNo get抄本番号() {
        return this.entity.getShohonNo();
    }

    /**
     * 予定者名簿取込済フラグを返します。
     *
     * @return Boolean
     */
    public Boolean get予定者名簿取込済フラグ() {
        return this.entity.getMeiboTorikomiZumiFlag();
    }
}
