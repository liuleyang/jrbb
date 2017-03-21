/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE510;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のプロパティクラスです。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoProperty extends ReportPropertyBase<ShisetsuKofuIchiranhyoSource> {

    private static final ReportId ID = new ReportId("AFAPRE510_ShisetsuKofuIchiranhyo");

    /**
     * インスタンスを生成します。
     */
    public ShisetsuKofuIchiranhyoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
