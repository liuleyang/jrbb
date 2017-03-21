/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE503;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllProperty extends ReportPropertyBase<TohyoshaListSenkyoAllSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE503_投票者一覧表.value());

    /**
     * インスタンスを生成します。
     */
    public TohyoshaListSenkyoAllProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
