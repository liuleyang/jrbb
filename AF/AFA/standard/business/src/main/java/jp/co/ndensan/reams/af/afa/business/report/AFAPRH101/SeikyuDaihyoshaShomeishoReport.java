/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRH101;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SeikyuDaihyoshaShomeishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101.SeikyuDaihyoshaShomeishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoReport extends Report<SeikyuDaihyoshaShomeishoSource> {

    private final List<SeikyuDaihyoshaShomeishoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets {@link TohyoJiyuChoshoParam}
     */
    public SeikyuDaihyoshaShomeishoReport(List<SeikyuDaihyoshaShomeishoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TohyoJiyuChoshoSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<SeikyuDaihyoshaShomeishoSource> reportSourceWriter) {
        for (SeikyuDaihyoshaShomeishoParam target : this.targets) {
            SeikyuDaihyoshaShomeishoEditor editor = new SeikyuDaihyoshaShomeishoEditor(target);
            SeikyuDaihyoshaShomeishoBuilder builder = new SeikyuDaihyoshaShomeishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
