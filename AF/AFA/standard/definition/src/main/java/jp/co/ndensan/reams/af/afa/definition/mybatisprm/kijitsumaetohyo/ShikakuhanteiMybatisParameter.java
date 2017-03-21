/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ビジネス設計_AFABZA101_ShikakuHantei_資格判定のパラメータクラスです。
 *
 * @reamsid_L AF-0070-030 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShikakuhanteiMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RString selectKijun;
    private final FlexibleDate tenshutsuYmd;
    private final ShikibetsuCode shikibetsuCd;
    private final int seq;

    /**
     * コンストラクタです。
     *
     * @param selectKijun RString
     * @param 転出年月日 FlexibleDate
     * @param 識別コード ShikibetsuCode
     * @param seq int
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public ShikakuhanteiMybatisParameter(RString selectKijun, FlexibleDate 転出年月日, ShikibetsuCode 識別コード,
            int seq, IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.selectKijun = selectKijun;
        this.tenshutsuYmd = 転出年月日;
        this.shikibetsuCd = 識別コード;
        this.seq = seq;
    }
}
