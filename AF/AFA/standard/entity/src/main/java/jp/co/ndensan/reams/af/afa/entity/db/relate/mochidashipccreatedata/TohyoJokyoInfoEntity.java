/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 投票状況情報Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class TohyoJokyoInfoEntity implements IDbAccessable, Serializable {

    private AfT111SenkyoEntity 選挙Entity;
    private AfT100ShohonEntity 抄本Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT201TohyoJokyoEntity 投票状況Entity;
    private AfT507ShisetsuEntity 施設Entity;

}
