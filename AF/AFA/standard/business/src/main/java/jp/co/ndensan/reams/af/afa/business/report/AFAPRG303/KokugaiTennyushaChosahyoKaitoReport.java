/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG303;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG303.KokugaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 国外転入者調査票（回答）のReportクラスです。
 *
 * @reamsid_L AF-0360-068 b_caiyf
 */
public class KokugaiTennyushaChosahyoKaitoReport extends Report<KokugaiTennyushaChosahyoKaitoSource> {

    private final KokugaiTennyushaChosahyoKaitoParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 国外転入者調査票（回答）のパラメータ
     */
    public KokugaiTennyushaChosahyoKaitoReport(KokugaiTennyushaChosahyoKaitoParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KokugaiTennyushaChosahyoKaitoSource> writer) {
        writer.writeLine(new KokugaiTennyushaChosahyoKaitoBuilder(new KokugaiTennyushaChosahyoKaitoEditor(target)));
    }

}
