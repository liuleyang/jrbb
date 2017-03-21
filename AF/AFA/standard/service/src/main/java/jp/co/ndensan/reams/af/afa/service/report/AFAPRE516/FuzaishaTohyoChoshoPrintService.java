/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE516;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE516.FuzaishaTohyoChoshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE516.FuzaishaTohyoChoshoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE516.FuzaishaTohyoChoshoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE516_不在者投票に関する調書（25号様式）作成を発行します。
 *
 * @reamsid_L AF-0280-033 wangm
 */
public class FuzaishaTohyoChoshoPrintService {

    /**
     * 帳票_AFAPRE516_不在者投票に関する調書（25号様式）作成を発行します。
     *
     * @param targets FuzaishaTohyoChoshoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<FuzaishaTohyoChoshoParam> targets) {
        FuzaishaTohyoChoshoProperty property = new FuzaishaTohyoChoshoProperty();
        return new Printer<FuzaishaTohyoChoshoSource>().spool(property, toReports(targets));
    }

    private static List<FuzaishaTohyoChoshoReport> toReports(List<FuzaishaTohyoChoshoParam> targets) {
        List<FuzaishaTohyoChoshoReport> list = new ArrayList<>();

        for (FuzaishaTohyoChoshoParam trgt : targets) {
            list.add(new FuzaishaTohyoChoshoReport(trgt));
        }
        return list;
    }

}
