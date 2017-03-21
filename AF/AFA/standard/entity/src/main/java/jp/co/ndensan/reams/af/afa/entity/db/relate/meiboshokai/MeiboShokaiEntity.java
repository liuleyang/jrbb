/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meiboshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;

/**
 * 名簿照会用Entityクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
@lombok.Getter
@lombok.Setter
public class MeiboShokaiEntity implements Cloneable, Serializable {

    private AfT111SenkyoEntity senkyo;
    private AfT201TohyoJokyoEntity tohyoJokyo;

}
