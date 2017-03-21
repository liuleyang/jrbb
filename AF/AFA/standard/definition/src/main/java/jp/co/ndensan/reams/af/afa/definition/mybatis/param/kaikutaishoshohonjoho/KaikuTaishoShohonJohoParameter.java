/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikutaishoshohonjoho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * 海区対象抄本情報共有子Divのパラメータクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class KaikuTaishoShohonJohoParameter implements IMyBatisParameter {

    private final ShohonNo 抄本番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     */
    public KaikuTaishoShohonJohoParameter(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }
}
