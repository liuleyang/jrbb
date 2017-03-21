/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushatoroku;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * AFAGMH1010 請求代表者証明書交付のパラメータクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class SeikyushaTorokuParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private int 直接請求番号;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public SeikyushaTorokuParameter(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }

    /**
     * 直接請求番号を返します。
     *
     * @return 直接請求番号 int
     */
    public int get直接請求番号() {
        return this.直接請求番号;
    }

    /**
     * 直接請求番号を設定します。
     *
     * @param 直接請求番号 int
     */
    public void set直接請求番号(int 直接請求番号) {
        this.直接請求番号 = 直接請求番号;
    }
}
