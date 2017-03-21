/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ビジネス設計_AFABZA101_ShikakuHantei_資格判定のパラメータクラスです。
 *
 * @reamsid_L AF-0070-031 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class KijitsumaeTohyoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final FlexibleDate kijunDate;
    private final SenkyoNo senkyoNo;
    private final Code senkyoSyurui;
    private final ShikibetsuCode shikibetsuCode;
    private final List<SenkyoNo> senkyoNoLst;
    private final RString tanmatsuID;
    private List<RString> shikibetsuCodeList;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param kijunDate FlexibleDate
     * @param senkyoNo SenkyoNo
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNoLst List<SenkyoNo>
     * @param senkyoSyurui Code
     * @param tanmatsuID RString
     */
    public KijitsumaeTohyoMybatisParameter(IShikibetsuTaishoPSMSearchKey key,
            ShohonNo shohonNo, FlexibleDate kijunDate, SenkyoNo senkyoNo, ShikibetsuCode shikibetsuCode,
            List<SenkyoNo> senkyoNoLst, Code senkyoSyurui, RString tanmatsuID) {
        super(key);
        this.shohonNo = shohonNo;
        this.kijunDate = kijunDate;
        this.senkyoNo = senkyoNo;
        this.shikibetsuCode = shikibetsuCode;
        this.senkyoNoLst = senkyoNoLst;
        this.senkyoSyurui = senkyoSyurui;
        this.tanmatsuID = tanmatsuID;
    }
}
