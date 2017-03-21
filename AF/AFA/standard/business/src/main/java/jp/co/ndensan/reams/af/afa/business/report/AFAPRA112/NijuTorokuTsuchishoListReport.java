/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 二重登録者通知一覧表を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの二重登録者通知一覧表ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-045 xiaoj
 */
public final class NijuTorokuTsuchishoListReport extends Report<NijuTorokuTsuchishoListSource> {

    private final NijuTorokuTsuchishoListParameter target;

    /**
     * コンストラクタです。
     *
     * @param target {@link NijuTorokuTsuchishoListParameter}
     */
    public NijuTorokuTsuchishoListReport(NijuTorokuTsuchishoListParameter target) {
        this.target = target;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<NijuTorokuTsuchishoListSource> writer) {
        INijuTorokuTsuchishoListEditor editor = new NijuTorokuTsuchishoListEditor(target);
        INijuTorokuTsuchishoListBuilder builder = new NijuTorokuTsuchishoListBuilder(editor);
        writer.writeLine(builder);

    }

}
