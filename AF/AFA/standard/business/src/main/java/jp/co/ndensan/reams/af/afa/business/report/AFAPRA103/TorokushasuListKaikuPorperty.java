package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListKaikuPorperty extends ReportPropertyBase<TorokushasuListSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.登録者数リスト.value());

    /**
     * 帳票ID
     */
    public TorokushasuListKaikuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
