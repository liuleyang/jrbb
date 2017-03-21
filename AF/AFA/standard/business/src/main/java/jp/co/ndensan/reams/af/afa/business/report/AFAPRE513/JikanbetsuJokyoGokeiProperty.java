/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のプロパティクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiProperty extends ReportPropertyBase<JikanbetsuJokyoGokeiSource> {

    private static final ReportId ID = new ReportId("AFAPRE513_JikanbetsuJokyoGokei");

    /**
     * インスタンスを生成します。
     */
    public JikanbetsuJokyoGokeiProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
