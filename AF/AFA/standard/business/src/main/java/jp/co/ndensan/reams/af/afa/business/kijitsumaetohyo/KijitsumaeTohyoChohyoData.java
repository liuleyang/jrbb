/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;

/**
 * 期日前投票の帳票出力用データクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoChohyoData implements Serializable {

    private final SenkyoninTohyoJokyoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link SenkyoninTohyoJokyoEntity}より{@link KijitsumaeTohyoChohyoData}を生成します。
     *
     * @param entity DBより取得した{@link SenkyoninTohyoJokyoEntity}
     */
    public KijitsumaeTohyoChohyoData(SenkyoninTohyoJokyoEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 補助者識別コードを返します。
     *
     * @return 補助者識別コード ShikibetsuCode
     */
    public SenkyoninTohyoJokyoEntity getEntity() {
        return this.entity;
    }

}
