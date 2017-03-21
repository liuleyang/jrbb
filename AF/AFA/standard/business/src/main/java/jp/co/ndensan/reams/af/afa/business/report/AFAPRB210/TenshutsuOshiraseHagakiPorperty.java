package jp.co.ndensan.reams.af.afa.business.report.AFAPRB210;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiPorperty extends ReportPropertyBase<TenshutsuOshiraseHagakiSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value());

    /**
     * 帳票ID
     */
    public TenshutsuOshiraseHagakiPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
