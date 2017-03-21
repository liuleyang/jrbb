/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE202;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202.LabelSealSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * {@link LabelSealSource}を編集します。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealReport extends Report<LabelSealSource> {

    private final List<LabelSealParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<LabelSealParam>
     */
    protected LabelSealReport(List<LabelSealParam> targets) {
        this.targets = targets;
    }

    /**
     * {@link LabelSealParam}から、{@link LabelSealReport}型のインスタンスを生成し、返します。
     *
     * @param targets List<LabelSealParam>
     * @return {@link LabelSealReport}型のインスタンス
     */
    public static LabelSealReport createForm(@NonNull List<LabelSealParam> targets) {
        return new LabelSealReport(targets);
    }

    @Override
    protected void writeBy(ReportSourceWriter<LabelSealSource> writer) {
        for (LabelSealParam target : targets) {

            ILabelSealEditor senseishoEditor = new LabelSealEditor(target);
            ILabelSealBuilder senseishoBuilder = new LabelSealBuilder(senseishoEditor);
            writer.writeLine(senseishoBuilder);
        }
    }
}
