/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 投票区Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class TohyokuInfoEntity implements IDbAccessable, Serializable {

    private AfT502TohyojoEntity 投票所Entity;
    private TohyokuEntity 投票区Entity;
}
