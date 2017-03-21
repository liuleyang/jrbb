/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE515;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE515_事務処理簿作成を発行します。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboPrintService {

    /**
     * 帳票_AFAPRE515_事務処理簿作成を発行します。
     *
     * @param targets JimushoriboParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<JimushoriboParam> targets) {
        JimushoriboProperty property = new JimushoriboProperty();
        return new Printer<JimushoriboSource>().spool(property, toReports(targets));
    }

    private static List<JimushoriboReport> toReports(List<JimushoriboParam> targets) {
        List<JimushoriboReport> list = new ArrayList<>();

        for (JimushoriboParam trgt : targets) {
            list.add(new JimushoriboReport(trgt));
        }
        return list;
    }

}
