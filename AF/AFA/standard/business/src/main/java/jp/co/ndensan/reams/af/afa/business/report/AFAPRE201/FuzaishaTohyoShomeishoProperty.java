/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE201;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201.FuzaishaTohyoShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * Senseishoのプロパティクラスです。
 *
 * @reamsid_L AF-0090-020 lit
 */
public class FuzaishaTohyoShomeishoProperty extends ReportPropertyBase<FuzaishaTohyoShomeishoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.不在者投票証明書_12号様式.value());

    /**
     * インスタンスを生成します。
     */
    public FuzaishaTohyoShomeishoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
