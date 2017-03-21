/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.zaisankusenkyojitoroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * 財産区議会議員選挙時登録のパラメータクラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@lombok.Setter
public class ZaisankuSenkyojiTorokuParameter implements IMyBatisParameter {

    private final ShohonNo 抄本番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     */
    public ZaisankuSenkyojiTorokuParameter(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }
}
