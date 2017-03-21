/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectShohonNoMybatisParameter implements IMyBatisParameter {

    private List<ShohonNo> 抄本番号List;
    private ShikibetsuCode 識別コード;
    private boolean tohyokuHenkoMasshoFlag;

    /**
     *
     * @param 抄本番号List List<ShohonNo>
     */
    public SelectShohonNoMybatisParameter(List<ShohonNo> 抄本番号List) {
        this.抄本番号List = 抄本番号List;
    }

    /**
     *
     * @param 抄本番号List List<ShohonNo>
     * @param 識別コード ShikibetsuCode
     * @param 投票区変更抹消フラグ boolean
     */
    public SelectShohonNoMybatisParameter(List<ShohonNo> 抄本番号List, ShikibetsuCode 識別コード, boolean 投票区変更抹消フラグ) {
        this.抄本番号List = 抄本番号List;
        this.識別コード = 識別コード;
        this.tohyokuHenkoMasshoFlag = 投票区変更抹消フラグ;
    }
}
