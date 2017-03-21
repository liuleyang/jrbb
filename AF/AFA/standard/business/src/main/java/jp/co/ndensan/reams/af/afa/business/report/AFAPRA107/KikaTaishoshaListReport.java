/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA107;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA107.KikaTaishoshaListSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帰化対象者リストを出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの帰化対象者リストソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-041 xiaoj
 */
public final class KikaTaishoshaListReport extends Report<KikaTaishoshaListSource> {

    private final KikaTaishoshaListParameter target;
    private final FlexibleDate 帰化期間開始日;
    private final FlexibleDate 帰化期間終了日;

    /**
     * コンストラクタです。
     *
     * @param target {@link KikaTaishoshaListParameter}
     * @param 帰化期間開始日 帰化期間開始日
     * @param 帰化期間終了日 帰化期間終了日
     */
    public KikaTaishoshaListReport(KikaTaishoshaListParameter target, FlexibleDate 帰化期間開始日,
            FlexibleDate 帰化期間終了日) {
        this.target = target;
        this.帰化期間終了日 = 帰化期間終了日;
        this.帰化期間開始日 = 帰化期間開始日;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<KikaTaishoshaListSource> writer) {
        IKikaTaishoshaListEditor editor = new KikaTaishoshaListEditor(target, 帰化期間開始日, 帰化期間終了日);
        IKikaTaishoshaListBuilder builder = new KikaTaishoshaListBuilder(editor);
        writer.writeLine(builder);

    }

}
