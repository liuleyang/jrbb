package jp.co.ndensan.reams.af.afa.business.report.AFAPRB302;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302.ShinseishaShokaiBunshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoPorperty extends ReportPropertyBase<ShinseishaShokaiBunshoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB302_申請者の被登録資格の照会文書.value());

    /**
     * 帳票ID
     */
    public ShinseishaShokaiBunshoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
