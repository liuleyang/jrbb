/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @reamsid_L AF-0460-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboShohonKaikuDbMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private List<ShohonNo> 抄本番号List;
    private RString 出力順;
    private Code 選挙種類;

    /**
     *
     * @param 抄本番号List 抄本番号List
     * @param 出力順 出力順
     * @param searchKey searchKey
     * @param 選挙種類 Code
     */
    public MeiboShohonKaikuDbMybatisParameter(List<ShohonNo> 抄本番号List, RString 出力順, IShikibetsuTaishoPSMSearchKey searchKey,
            Code 選挙種類) {
        super(searchKey);
        this.抄本番号List = 抄本番号List;
        this.出力順 = 出力順;
        this.選挙種類 = 選挙種類;
    }

}
