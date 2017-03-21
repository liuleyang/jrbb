/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB100.NijuTorokuChosaShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 二重登録調査票（照会）を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの二重登録調査票（照会）Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0030-033 liss
 */
public final class NijuTorokuChosaShokaiListReport extends Report<NijuTorokuChosaShokaiSource> {

    private final NijuTorokuChosaShokaiParameter target;

    /**
     * コンストラクタです。
     *
     * @param target {@link List<NijuTorokuChosaShokaiParameter>}
     */
    public NijuTorokuChosaShokaiListReport(NijuTorokuChosaShokaiParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NijuTorokuChosaShokaiSource> writer) {

        INijuTorokuChosaShokaiListEditor editor = new NijuTorokuChosaShokaiListEditor(target);
        INijuTorokuChosaShokaiListBuilder builder = new NijuTorokuChosaShokaiListBuilder(editor);
        writer.writeLine(builder);

    }

}
