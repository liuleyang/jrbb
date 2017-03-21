/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者ダイアログ用モデルです。
 *
 * @reamsid_L AF-0080-030 wangm
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HojoshaNyuryokuModel implements Serializable {

    private ShohonNo shohonNo;
    private RString tohyokuCode;
    private ShikibetsuCode shikibetsuCode;
    private Boolean dairiTohyoAri;

    private ShikibetsuCode shikibetsuCode1;
    private RString meisho1;

    private ShikibetsuCode shikibetsuCode2;
    private RString meisho2;

}
