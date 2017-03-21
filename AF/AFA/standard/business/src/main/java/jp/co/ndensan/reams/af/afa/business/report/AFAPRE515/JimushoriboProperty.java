/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE515;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿のプロパティクラスです。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboProperty extends ReportPropertyBase<JimushoriboSource> {

    private static final ReportId ID = new ReportId("AFAPRE515_Jimushoribo");

    /**
     * インスタンスを生成します。
     */
    public JimushoriboProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
