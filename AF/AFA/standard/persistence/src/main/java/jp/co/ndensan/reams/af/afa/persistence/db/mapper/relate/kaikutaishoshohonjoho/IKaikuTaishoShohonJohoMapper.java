/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.kaikutaishoshohonjoho;

import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikutaishoshohonjoho.KaikuTaishoShohonJohoParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.KaikuTaishoShohonJohoEntity;

/**
 * 海区対象抄本情報共有子Divのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public interface IKaikuTaishoShohonJohoMapper {

    /**
     * 日付情報を取得します。
     *
     * @param param KaikuTaishoShohonJohoParameter
     * @return 日付情報 KaikuTaishoShohonJohoEntity
     */
    KaikuTaishoShohonJohoEntity select日付情報(KaikuTaishoShohonJohoParameter param);

}
