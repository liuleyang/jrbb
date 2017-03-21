/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 在外選挙人名簿抄本を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの選挙人名簿抄本Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0030-035 liss
 */
public final class MeiboShohonZaigaiReport extends Report<MeiboShohonZaigaiSource> {

    private final MeiboShohonZaigaiParameter target;
    private final RString reportId;

    /**
     * コンストラクタです。
     *
     * @param target MeiboShohonZaigaiParameter
     * @param reportId reportId
     */
    public MeiboShohonZaigaiReport(MeiboShohonZaigaiParameter target, RString reportId) {
        this.target = target;
        this.reportId = reportId;

    }

    @Override
    public void writeBy(ReportSourceWriter<MeiboShohonZaigaiSource> writer) {
        IMeiboShohonZaigaiEditor editor = new MeiboShohonZaigaiEditor(target, reportId);
        IMeiboShohonZaigaiBuilder builder = new MeiboShohonZaigaiBuilder(editor);
        writer.writeLine(builder);
    }
}
