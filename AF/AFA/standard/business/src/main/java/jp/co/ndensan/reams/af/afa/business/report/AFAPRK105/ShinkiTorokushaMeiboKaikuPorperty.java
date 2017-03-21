package jp.co.ndensan.reams.af.afa.business.report.AFAPRK105;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public class ShinkiTorokushaMeiboKaikuPorperty extends ReportPropertyBase<ShinkiTorokushaMeiboKaikuSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.新規登録者名簿海区.value());

    /**
     * 帳票ID
     */
    public ShinkiTorokushaMeiboKaikuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
