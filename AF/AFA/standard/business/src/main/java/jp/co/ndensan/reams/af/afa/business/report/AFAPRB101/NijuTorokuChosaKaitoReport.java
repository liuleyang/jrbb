/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101.NijuTorokuChosaKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 二重登録調査票（回答）を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの二重登録調査票（回答）Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0030-034 liss
 */
public class NijuTorokuChosaKaitoReport extends Report<NijuTorokuChosaKaitoSource> {

    private final NijuTorokuChosaKaitoParameter target;

    /**
     * コンストラクタです。
     *
     * @param target {@link NijuTorokuChosaKaitoParameter}
     */
    public NijuTorokuChosaKaitoReport(NijuTorokuChosaKaitoParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NijuTorokuChosaKaitoSource> writer) {

        INijuTorokuChosaKaitoEditor editor = new NijuTorokuChosaKaitoEditor(target);
        INijuTorokuChosaKaitoBuilder builder = new NijuTorokuChosaKaitoBuilder(editor);
        writer.writeLine(builder);

    }

}
