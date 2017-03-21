/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA104;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA104.YukenshasuShirabeSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録者数リスト作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの登録者数リストソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-038 wangm
 */
public final class YukenshasuListReport extends Report<YukenshasuShirabeSource> {

    private final YukenshasuListParam target;

    /**
     * コンストラクタです。
     *
     * @param target YukenshasuListParam
     */
    public YukenshasuListReport(YukenshasuListParam target) {
        this.target = target;

    }

    @Override
    public void writeBy(ReportSourceWriter<YukenshasuShirabeSource> writer) {
        IYukenshasuListEditor editor = new YukenshasuListEditor(target);
        IYukenshasuListBuilder builder = new YukenshasuListBuilder(editor);
        writer.writeLine(builder);
    }

}
