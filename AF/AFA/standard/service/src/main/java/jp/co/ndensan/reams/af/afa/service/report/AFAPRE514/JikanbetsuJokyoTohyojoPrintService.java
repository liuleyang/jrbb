/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE514;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE514.JikanbetsuJokyoTohyojoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE514.JikanbetsuJokyoTohyojoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE514_時間別投票状況表　投票所別作成を発行します。
 *
 * @reamsid_L AF-0280-031 wangm
 */
public class JikanbetsuJokyoTohyojoPrintService {

    /**
     * 帳票_AFAPRE514_時間別投票状況表　投票所別作成を発行します。
     *
     * @param targets JikanbetsuJokyoTohyojoParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<JikanbetsuJokyoTohyojoParam> targets) {
        JikanbetsuJokyoTohyojoProperty property = new JikanbetsuJokyoTohyojoProperty();
        return new Printer<JikanbetsuJokyoTohyojoSource>().spool(property, toReports(targets));
    }

    private static List<JikanbetsuJokyoTohyojoReport> toReports(List<JikanbetsuJokyoTohyojoParam> targets) {
        List<JikanbetsuJokyoTohyojoReport> list = new ArrayList<>();

        for (JikanbetsuJokyoTohyojoParam trgt : targets) {
            list.add(new JikanbetsuJokyoTohyojoReport(trgt));
        }
        return list;
    }

}
