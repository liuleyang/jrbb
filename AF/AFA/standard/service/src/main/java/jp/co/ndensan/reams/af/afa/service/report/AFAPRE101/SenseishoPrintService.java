/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE101.SenseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * AFAPRE101_Senseisho_宣誓書作成を発行します。
 *
 * @reamsid_L AF-0070-020 liss
 */
public class SenseishoPrintService {

    /**
     * AFAPRE101_Senseisho_宣誓書作成を発行します。
     *
     * @param targets SenseishoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<SenseishoParam> targets) {
        SenseishoProperty property = new SenseishoProperty();
        return new Printer<SenseishoSource>().spool(property, toReports(targets));
    }

    private static List<SenseishoReport> toReports(List<SenseishoParam> targets) {
        List<SenseishoReport> list = new ArrayList<>();

        for (SenseishoParam trgt : targets) {
            list.add(SenseishoReport.createForm(trgt));
        }
        return list;
    }
}
