/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;

/**
 * 状態変更クラスです。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JotaiHenkoEntity {

    private ShohonNo shohonNo;
    private SenkyoNo senkyoNo;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT201TohyoJokyoEntity tohyoJokyoEntity;
}
