/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Mybatisパラメータクラスです。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JotaiHenkoMybatisParameter implements IMyBatisParameter {

    private final ShohonNo shohonNo;
    private final ShikibetsuCode shikibetsuCode;

    /**
     * コンストラクタ作成します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     */
    public JotaiHenkoMybatisParameter(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        this.shohonNo = shohonNo;
        this.shikibetsuCode = shikibetsuCode;
    }
}
