/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * AF投票区Entity
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
public class TohyokuAFInfoEntity implements IDbAccessable, Serializable {

    private AfT501TohyokuEntity 投票区Entity;
    private AfT502TohyojoEntity 投票所Entity;
    private AfT503SenkyokuEntity 選挙区Entity;
}
