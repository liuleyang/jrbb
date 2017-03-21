/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE513;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE513_時間別投票状況表　合計作成を発行します。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiPrintService {

    /**
     * 帳票_AFAPRE513_時間別投票状況表　合計作成を発行します。
     *
     * @param targets JikanbetsuJokyoGokeiParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<JikanbetsuJokyoGokeiParam> targets) {
        JikanbetsuJokyoGokeiProperty property = new JikanbetsuJokyoGokeiProperty();
        return new Printer<JikanbetsuJokyoGokeiSource>().spool(property, toReports(targets));
    }

    private static List<JikanbetsuJokyoGokeiReport> toReports(List<JikanbetsuJokyoGokeiParam> targets) {
        List<JikanbetsuJokyoGokeiReport> list = new ArrayList<>();

        for (JikanbetsuJokyoGokeiParam trgt : targets) {
            list.add(new JikanbetsuJokyoGokeiReport(trgt));
        }
        return list;
    }

}
