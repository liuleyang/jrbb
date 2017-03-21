/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE101;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE101.SenseishoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * Senseishoのプロパティクラスです。
 *
 * @reamsid_L AF-0070-020 liss
 */
public class SenseishoProperty extends ReportPropertyBase<SenseishoSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.宣誓書.value());

    /**
     * インスタンスを生成します。
     */
    public SenseishoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
