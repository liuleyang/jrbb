/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE101.SenseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * {@link SenseishoSource}を編集します。
 *
 * @reamsid_L AF-0070-020 liss
 */
public class SenseishoReport extends Report<SenseishoSource> {

    private final SenseishoParam target;

    /**
     * コンストラクタです。
     *
     * @param target {@link SenseishoParam}
     */
    protected SenseishoReport(SenseishoParam target) {
        this.target = target;
    }

    /**
     * {@link SenseishoParam}から、{@link SenseishoReport}型のインスタンスを生成し、返します。
     *
     * @param target {@link SenseishoParam}
     * @return {@link SenseishoReport}型のインスタンス
     */
    public static SenseishoReport createForm(@NonNull SenseishoParam target) {
        return new SenseishoReport(target);
    }

    @Override
    protected void writeBy(ReportSourceWriter<SenseishoSource> writer) {
        ISenseishoEditor senseishoEditor = new SenseishoEditor(target);
        ISenseishoBuilder senseishoBuilder = new SenseishoBuilder(senseishoEditor);
        writer.writeLine(senseishoBuilder);
    }
}
