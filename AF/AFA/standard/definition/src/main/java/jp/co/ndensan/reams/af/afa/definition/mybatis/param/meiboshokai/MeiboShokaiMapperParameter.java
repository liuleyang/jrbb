/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.meiboshokai;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 名簿照会用パラメータクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class MeiboShokaiMapperParameter implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final ShikibetsuCode shikibetsuCode;

    /**
     * 検索用のパラメータを生成します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     */
    public MeiboShokaiMapperParameter(
            ShohonNo shohonNo,
            ShikibetsuCode shikibetsuCode) {
        this.shohonNo = shohonNo;
        this.shikibetsuCode = shikibetsuCode;
    }
}
