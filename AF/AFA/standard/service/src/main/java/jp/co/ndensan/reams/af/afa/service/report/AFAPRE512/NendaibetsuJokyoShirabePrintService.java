/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE512;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票_AFAPRE512_年代別投票状況調べ作成を発行します。
 *
 * @reamsid_L AF-0280-029 wangm
 */
public class NendaibetsuJokyoShirabePrintService {

    /**
     * 帳票_AFAPRE512_年代別投票状況調べ作成を発行します。
     *
     * @param targets NendaibetsuJokyoShirabeParam
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NendaibetsuJokyoShirabeParam> targets) {
        NendaibetsuJokyoShirabeProperty property = new NendaibetsuJokyoShirabeProperty();
        return new Printer<NendaibetsuJokyoShirabeSource>().spool(property, toReports(targets));
    }

    private static List<NendaibetsuJokyoShirabeReport> toReports(List<NendaibetsuJokyoShirabeParam> targets) {
        List<NendaibetsuJokyoShirabeReport> list = new ArrayList<>();

        for (NendaibetsuJokyoShirabeParam trgt : targets) {
            list.add(new NendaibetsuJokyoShirabeReport(trgt));
        }
        return list;
    }

}
