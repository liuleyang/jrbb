/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE512;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べのプロパティクラスです。
 *
 * @reamsid_L AF-0280-029 wangm
 */
public class NendaibetsuJokyoShirabeProperty extends ReportPropertyBase<NendaibetsuJokyoShirabeSource> {

    private static final ReportId ID = new ReportId("AFAPRE512_NendaibetsuJokyoShirabe");

    /**
     * インスタンスを生成します。
     */
    public NendaibetsuJokyoShirabeProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
