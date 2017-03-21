/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE202;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE202.LabelSealParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE202.LabelSealProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE202.LabelSealReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202.LabelSealSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * AFAPRE202_LabelSeal_ラベルシール（専用ラベル）作成を発行します。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealPrintService {

    /**
     * AFAPRE202_LabelSeal_ラベルシール（専用ラベル）作成を発行します。
     *
     * @param targets LabelSealParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<LabelSealParam> targets) {
        LabelSealProperty property = new LabelSealProperty();
        return new Printer<LabelSealSource>().spool(property, toReports(targets));
    }

    private static LabelSealReport toReports(List<LabelSealParam> targets) {

        return LabelSealReport.createForm(targets);
    }
}
