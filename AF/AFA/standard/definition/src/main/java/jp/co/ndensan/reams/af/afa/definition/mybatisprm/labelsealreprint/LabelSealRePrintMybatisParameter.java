/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.labelsealreprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * AFAGME1020 ラベルシール再印刷のパラメータクラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class LabelSealRePrintMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final RString shisetsuCode;
    private ShikibetsuCode shikibetsuCode;
    private List<ShikibetsuCode> shikibetsuCodeList;
    private List<SenkyoNo> senkyoNoLst;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param shohonNo ShohonNo
     * @param shisetsuCode RString
     */
    public LabelSealRePrintMybatisParameter(IShikibetsuTaishoPSMSearchKey key, ShohonNo shohonNo, RString shisetsuCode) {
        super(key);
        this.shohonNo = shohonNo;
        this.shisetsuCode = shisetsuCode;
    }

}
