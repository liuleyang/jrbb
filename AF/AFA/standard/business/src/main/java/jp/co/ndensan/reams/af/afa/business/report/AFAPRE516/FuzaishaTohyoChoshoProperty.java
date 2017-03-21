/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE516;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）のプロパティクラスです。
 *
 * @reamsid_L AF-0280-033 wangm
 */
public class FuzaishaTohyoChoshoProperty extends ReportPropertyBase<FuzaishaTohyoChoshoSource> {

    private static final ReportId ID = new ReportId("AFAPRE516_FuzaishaTohyoChosho");

    /**
     * インスタンスを生成します。
     */
    public FuzaishaTohyoChoshoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
