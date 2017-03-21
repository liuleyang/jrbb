/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.cautionsha.UaFt400FindeCautionShaMapperParam;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 日報関連帳票バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE801SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private UaFt400FindeCautionShaMapperParam keyUaFt400;
    private FlexibleDate 受理日;
    private RString 端末ID;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyUaFt400 UaFt400FindeCautionShaMapperParam
     * @param 受理日 FlexibleDate
     * @param 端末ID RString
     */
    public AFABTE801SelectProcessParameter(
            IShikibetsuTaishoPSMSearchKey key,
            UaFt400FindeCautionShaMapperParam keyUaFt400,
            FlexibleDate 受理日,
            RString 端末ID
    ) {
        this.key = key;
        this.keyUaFt400 = keyUaFt400;
        this.受理日 = 受理日;
        this.端末ID = 端末ID;
    }

    /**
     * MochidashiPcCreateDataMybatisParameter
     *
     * @return MochidashiPcCreateDataMybatisParameter
     */
    public MochidashiPcCreateDataMybatisParameter toMybatisParameter() {
        return new MochidashiPcCreateDataMybatisParameter(key, keyUaFt400, 受理日);
    }
}
