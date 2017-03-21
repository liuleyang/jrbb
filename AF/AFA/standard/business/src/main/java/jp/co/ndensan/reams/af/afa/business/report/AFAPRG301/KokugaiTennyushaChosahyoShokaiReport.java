/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG301;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 国外転入者調査票（照会）のReportクラスです。
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
public class KokugaiTennyushaChosahyoShokaiReport extends Report<KokugaiTennyushaChosahyoShokaiSource> {

    private final KokugaiTennyushaChosahyoShokaiParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 未登録者抹消通知のパラメータ
     */
    public KokugaiTennyushaChosahyoShokaiReport(KokugaiTennyushaChosahyoShokaiParameter target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KokugaiTennyushaChosahyoShokaiSource> writer) {
        writer.writeLine(new KokugaiTennyushaChosahyoShokaiBuilder(new KokugaiTennyushaChosahyoShokaiEditor(target)));
    }

}
