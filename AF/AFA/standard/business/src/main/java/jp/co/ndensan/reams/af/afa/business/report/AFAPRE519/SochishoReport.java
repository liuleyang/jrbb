/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE519;

import jp.co.ndensan.reams.af.afa.business.core.SochishoParam;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE519.SochishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 送致書帳票Reportクラスです。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class SochishoReport extends Report<SochishoReportSource> {

    private final ZenjitsuPrintEntity entity;
    private final SochishoParam param;

    /**
     * コンストラクタです。
     *
     * @param entity 送致書帳票対象クラス
     * @param param SochishoParam
     */
    public SochishoReport(ZenjitsuPrintEntity entity, SochishoParam param) {
        this.entity = entity;
        this.param = param;
    }

    @Override
    public void writeBy(ReportSourceWriter<SochishoReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new SochishoBuilder(new SochishoEditor(entity, param)));
    }
}
