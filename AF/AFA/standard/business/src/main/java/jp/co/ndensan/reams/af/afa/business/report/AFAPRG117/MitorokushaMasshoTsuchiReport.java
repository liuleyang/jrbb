/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG117;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG117.MitorokushaMasshoTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * AFAPRG117_MitorokushaMasshoTsuchi_未登録者抹消通知のReportクラスです。
 *
 * @reamsid_L AF-0360-064 b_caiyf
 */
public class MitorokushaMasshoTsuchiReport extends Report<MitorokushaMasshoTsuchiSource> {

    private final MitorokushaMasshoTsuchiParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 未登録者抹消通知のパラメータ
     */
    public MitorokushaMasshoTsuchiReport(MitorokushaMasshoTsuchiParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<MitorokushaMasshoTsuchiSource> writer) {

        writer.writeLine(new MitorokushaMasshoTsuchiBuilder(new MitorokushaMasshoTsuchiEditor(target)));
    }
}
