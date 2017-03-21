/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG302;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG302.KokunaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 国内転入者調査票（回答）のReportクラスです。
 *
 * @reamsid_L AF-0360-067 b_caiyf
 */
public class KokunaiTennyushaChosahyoKaitoReport extends Report<KokunaiTennyushaChosahyoKaitoSource> {

    private final KokunaiTennyushaChosahyoKaitoParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 国内転入者調査票（回答）のパラメータ
     */
    public KokunaiTennyushaChosahyoKaitoReport(KokunaiTennyushaChosahyoKaitoParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KokunaiTennyushaChosahyoKaitoSource> writer) {
        writer.writeLine(new KokunaiTennyushaChosahyoKaitoBuilder(new KokunaiTennyushaChosahyoKaitoEditor(target)));
    }

}
