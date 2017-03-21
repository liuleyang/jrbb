/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuminTohyojiDelMybatisParameter implements IMyBatisParameter {

    private ShohonNo 抄本番号;

    /**
     *
     * @param 抄本番号 ShohonNo
     */
    public JuminTohyojiDelMybatisParameter(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

}
