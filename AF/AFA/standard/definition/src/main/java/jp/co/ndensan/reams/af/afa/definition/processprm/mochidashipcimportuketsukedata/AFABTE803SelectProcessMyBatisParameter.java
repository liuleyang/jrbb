/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 当日受付データ取込バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE803SelectProcessMyBatisParameter implements IMyBatisParameter {

    private FlexibleDate 投票年月日;
    private Code 投票区コード;
    private RString table;
    private RString table1;

    /**
     * コンストラクタです。
     *
     * @param 投票年月日 FlexibleDate
     * @param 投票区コード Code
     *
     */
    public AFABTE803SelectProcessMyBatisParameter(
            FlexibleDate 投票年月日,
            Code 投票区コード) {
        this.投票年月日 = 投票年月日;
        this.投票区コード = 投票区コード;
    }

}
