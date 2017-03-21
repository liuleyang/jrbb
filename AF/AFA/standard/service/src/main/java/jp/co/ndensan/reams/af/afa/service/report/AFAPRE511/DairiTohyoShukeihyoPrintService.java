/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE511;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE511_代理投票集計表作成を発行します。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoPrintService {

    /**
     * 帳票_AFAPRE511_代理投票集計表作成を発行します。
     *
     * @param targets DairiTohyoShukeihyoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<DairiTohyoShukeihyoParam> targets) {
        DairiTohyoShukeihyoProperty property = new DairiTohyoShukeihyoProperty();
        return new Printer<DairiTohyoShukeihyoSource>().spool(property, toReports(targets));
    }

    private static List<DairiTohyoShukeihyoReport> toReports(List<DairiTohyoShukeihyoParam> targets) {
        List<DairiTohyoShukeihyoReport> list = new ArrayList<>();

        for (DairiTohyoShukeihyoParam trgt : targets) {
            list.add(new DairiTohyoShukeihyoReport(trgt));
        }
        return list;
    }

}
