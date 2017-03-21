/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE517;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書のプロパティクラスです。
 *
 * @reamsid_L AF-0280-034 wangm
 */
public class FuzaishaTohyoYoshiChoshoProperty extends ReportPropertyBase<FuzaishaTohyoYoshiChoshoSource> {

    private static final ReportId ID = new ReportId("AFAPRE517_FuzaishaTohyoYoshiChosho");

    /**
     * インスタンスを生成します。
     */
    public FuzaishaTohyoYoshiChoshoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
