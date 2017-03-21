/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE517;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE517_不在者投票用紙等の調書作成を発行します。
 *
 * @reamsid_L AF-0280-034 wangm
 */
public class FuzaishaTohyoYoshiChoshoPrintService {

    /**
     * 帳票_AFAPRE517_不在者投票用紙等の調書作成を発行します。
     *
     * @param targets FuzaishaTohyoYoshiChoshoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<FuzaishaTohyoYoshiChoshoParam> targets) {
        FuzaishaTohyoYoshiChoshoProperty property = new FuzaishaTohyoYoshiChoshoProperty();
        return new Printer<FuzaishaTohyoYoshiChoshoSource>().spool(property, toReports(targets));
    }

    private static List<FuzaishaTohyoYoshiChoshoReport> toReports(List<FuzaishaTohyoYoshiChoshoParam> targets) {
        List<FuzaishaTohyoYoshiChoshoReport> list = new ArrayList<>();

        for (FuzaishaTohyoYoshiChoshoParam trgt : targets) {
            list.add(new FuzaishaTohyoYoshiChoshoReport(trgt));
        }
        return list;
    }

}
