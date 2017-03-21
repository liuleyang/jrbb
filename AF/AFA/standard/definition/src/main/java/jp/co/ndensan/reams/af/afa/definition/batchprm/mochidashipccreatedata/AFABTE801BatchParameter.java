/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.cautionsha.UaFt400FindeCautionShaMapperParam;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 持出端末用データ作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE801BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_TOUHYOYMD = "投票日";

    private static final String TANMATUID = "端末ID";

    @BatchParameter(key = KEY_TOUHYOYMD, name = "投票日", order = 1)
    private FlexibleDate 投票日;

    @BatchParameter(key = TANMATUID, name = "端末ID", order = 2)
    private RString 端末ID;

    /**
     * ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param keyUaFt400 IShikibetsuTaishoPSMSearchKey
     * @return AFABTE801SelectProcessParameter
     */
    public AFABTE801SelectProcessParameter toProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey, UaFt400FindeCautionShaMapperParam keyUaFt400) {
        return new AFABTE801SelectProcessParameter(searchKey, keyUaFt400, 投票日, 端末ID);
    }

}
