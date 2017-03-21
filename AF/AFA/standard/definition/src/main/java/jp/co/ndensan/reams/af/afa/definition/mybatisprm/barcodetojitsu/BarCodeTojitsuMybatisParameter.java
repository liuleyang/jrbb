/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.barcodetojitsu;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;

/**
 * AFAGME4020_バーコード一括当日投票入力のパラメータクラスです。
 *
 * @reamsid_L AF-0115-010 xul
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class BarCodeTojitsuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final Code senkyoSyurui;
    private final ShikibetsuCode shikibetsuCode;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoSyurui Code
     */
    public BarCodeTojitsuMybatisParameter(IShikibetsuTaishoPSMSearchKey key,
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, Code senkyoSyurui) {
        super(key);
        this.shohonNo = shohonNo;
        this.shikibetsuCode = shikibetsuCode;
        this.senkyoSyurui = senkyoSyurui;
    }
}
