/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;

/**
 * 投票区投票所情報です
 *
 * @reamsid_L AF-0720-010 liuyj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TohyokuTohyojoForMap implements Serializable {

    private AfT501TohyokuEntity tohyokuEntity;
    private AfT502TohyojoEntity tohyojoEntity;
    private AfT503SenkyokuEntity senkyokuEntity;
    private AfT504TohyokuRelationEntity tohyokuRelationEntity;
}
