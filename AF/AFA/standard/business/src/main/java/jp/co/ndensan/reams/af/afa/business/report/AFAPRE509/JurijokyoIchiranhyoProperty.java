/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE509;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表のプロパティクラスです。
 *
 * @reamsid_L AF-0280-026 wangm
 */
public class JurijokyoIchiranhyoProperty extends ReportPropertyBase<JurijokyoIchiranhyoSource> {

    private static final ReportId ID = new ReportId("AFAPRE509_JurijokyoIchiranhyo");

    /**
     * インスタンスを生成します。
     */
    public JurijokyoIchiranhyoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
