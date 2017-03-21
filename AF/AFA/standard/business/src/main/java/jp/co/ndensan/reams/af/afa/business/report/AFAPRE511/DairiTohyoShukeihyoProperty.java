/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE511;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のプロパティクラスです。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoProperty extends ReportPropertyBase<DairiTohyoShukeihyoSource> {

    private static final ReportId ID = new ReportId("AFAPRE511_DairiTohyoShukeihyo");

    /**
     * インスタンスを生成します。
     */
    public DairiTohyoShukeihyoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
