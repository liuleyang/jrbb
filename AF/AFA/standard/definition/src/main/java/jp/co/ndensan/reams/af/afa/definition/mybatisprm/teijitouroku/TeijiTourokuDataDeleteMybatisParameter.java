/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuDataDeleteMybatisParameter implements IMyBatisParameter {

    private final RString 処理種別;
    private final FlexibleDate 基準日_検索用;
    private final ShohonNo shohonNo;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 基準日_検索用 FlexibleDate
     * @param shohonNo ShohonNo
     */
    public TeijiTourokuDataDeleteMybatisParameter(RString 処理種別, FlexibleDate 基準日_検索用, ShohonNo shohonNo) {
        this.処理種別 = 処理種別;
        this.基準日_検索用 = 基準日_検索用;
        this.shohonNo = shohonNo;
    }

}
