/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRI100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminReport extends Report<MeiboShohonJuminSource> {

    private final MeiboShohonJuminParam targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<MeiboShohonJuminParam>
     */
    public MeiboShohonJuminReport(MeiboShohonJuminParam targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<MeiboShohonJuminSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<MeiboShohonJuminSource> reportSourceWriter) {
        MeiboShohonJuminEditor editor = new MeiboShohonJuminEditor(targets);
        IMeiboShohonJuminBuilder builder = new MeiboShohonJuminBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
