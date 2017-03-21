/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE213;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE213.AtenaSeal12Porperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE213.AtenaSeal12Report;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 宛名シール12面
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12PrintService {

    /**
     * 宛名シール12面
     *
     * @param atenaSeal12List List<AtenaSeal12Param>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<AtenaSeal12Param> atenaSeal12List) {
        try (ReportManager reportManager = new ReportManager()) {
            AtenaSeal12Porperty porperty = new AtenaSeal12Porperty();
            try (ReportAssembler<AtenaSeal12Source> assembler = ChouhyouCommon.createAssembler(porperty, reportManager)) {
                ReportSourceWriter<AtenaSeal12Source> reportSourceWriter = new ReportSourceWriter(assembler);
                for (AtenaSeal12Report report : toReports(atenaSeal12List)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }

    }

    private static List<AtenaSeal12Report> toReports(List<AtenaSeal12Param> targets) {
        List<AtenaSeal12Report> list = new ArrayList<>();
        for (AtenaSeal12Param target : targets) {
            list.add(new AtenaSeal12Report(target));
        }
        return list;
    }
}
