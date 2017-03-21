/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * JotaiHenkoDialogとMutohyoNyuryoku間連携用モデルです。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JotaiHenkoModel implements Serializable {

    private ShohonNo shohonNo;
    private ShikibetsuCode shikibetsuCode;
    private AtenaMeisho meisho;
    private SetaiCode setaiCode;
    private RString groupCode;
    private RString tohyokuCode;
    private RString satsu;
    private Decimal page;
    private Decimal gyo;
}
