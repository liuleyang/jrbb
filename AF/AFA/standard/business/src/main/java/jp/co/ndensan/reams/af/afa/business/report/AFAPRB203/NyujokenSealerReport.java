package jp.co.ndensan.reams.af.afa.business.report.AFAPRB203;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenSealerParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票所入場券（シーラー）
 *
 * @reamsid_L AF-0160-033 xul
 */
public class NyujokenSealerReport extends Report<NyujokenSealerSource> {

    private final NyujokenSealerParam target;

    /**
     * コンストラクタです。
     *
     * @param target NyujokenSealerParam
     */
    public NyujokenSealerReport(NyujokenSealerParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NyujokenSealerSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NyujokenSealerSource> reportSourceWriter) {
        NyujokenSealerEditor editor = new NyujokenSealerEditor(target);
        INyujokenSealerBuilder builder = new NyujokenSealerBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
