/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 期日前投票情報の投票状況entityクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KijitsumaeTohyoJokyoEntity {

    private AfT111SenkyoEntity aft111;
    private AfT201TohyoJokyoEntity aft201;
    private AfT507ShisetsuEntity aft507;
}
