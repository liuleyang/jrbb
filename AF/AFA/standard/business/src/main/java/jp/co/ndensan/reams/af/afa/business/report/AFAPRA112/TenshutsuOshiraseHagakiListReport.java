/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiListParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-030 jihb
 */
public final class TenshutsuOshiraseHagakiListReport extends Report<NijuTorokuTsuchishoListSource> {

    private final TenshutsuOshiraseHagakiListParam target;

    /**
     * コンストラクタです。
     *
     * @param target {@link NijuTorokuTsuchishoListParamter}
     */
    public TenshutsuOshiraseHagakiListReport(TenshutsuOshiraseHagakiListParam target) {
        this.target = target;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<NijuTorokuTsuchishoListSource> writer) {
        ITenshutsuOshiraseHagakiListEditor editor = new TenshutsuOshiraseHagakiListEditor(target);
        ITenshutsuOshiraseHagakiListBuilder builder = new TenshutsuOshiraseHagakiListBuilder(editor);
        writer.writeLine(builder);
    }
}
