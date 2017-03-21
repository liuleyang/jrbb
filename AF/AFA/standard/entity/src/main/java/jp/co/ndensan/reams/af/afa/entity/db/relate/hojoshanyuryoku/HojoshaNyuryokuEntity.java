/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshanyuryoku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者入力共有子div用エンティティクラスです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
@lombok.Getter
@lombok.Setter
public class HojoshaNyuryokuEntity implements Cloneable, Serializable {

    private ShikibetsuCode shikibetsuCode;

    private AtenaMeisho meisho;

    private RString tohyojoName;
}
