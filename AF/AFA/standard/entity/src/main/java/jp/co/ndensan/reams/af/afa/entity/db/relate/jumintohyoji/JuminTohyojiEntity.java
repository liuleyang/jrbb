/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyoji;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT145Chiku1ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuminTohyojiEntity {

    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;

    private AfT113SenkyoShikakuEntity afT113Entity;

    private AfT100ShohonEntity afT100Entity;

    private AfT111SenkyoEntity afT111SenkyoEntity;

    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibEntity;

    private AfT141ZaisankuJuminTohyoConditionEntity afT141ZaisankuJumin;

    private AfT142TohyokuConditionEntity afT142TohyokuConditionEntity;

    private AfT143GyoseikuConditionEntity afT143GyoseikuConditionEntity;

    private AfT144JushoConditionEntity afT144JushoConditionEntity;

    private AfT145Chiku1ConditionEntity afT145Chiku1ConditionEntity;

    private AfT146Chiku2ConditionEntity afT146Chiku2ConditionEntity;

    private AfT147Chiku3ConditionEntity afT147Chiku3ConditionEntity;

    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;

}
