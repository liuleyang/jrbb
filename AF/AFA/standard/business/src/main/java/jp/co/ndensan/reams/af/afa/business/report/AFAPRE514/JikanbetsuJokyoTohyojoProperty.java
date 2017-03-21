/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE514;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE514.JikanbetsuJokyoTohyojoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別のプロパティクラスです。
 *
 * @reamsid_L AF-0280-031 wangm
 */
public class JikanbetsuJokyoTohyojoProperty extends ReportPropertyBase<JikanbetsuJokyoTohyojoSource> {

    private static final ReportId ID = new ReportId("AFAPRE514_JikanbetsuJokyoTohyojo");

    /**
     * インスタンスを生成します。
     */
    public JikanbetsuJokyoTohyojoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
