package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-030 jihb
 */
public class TenshutsuOshiraseHagakiListPorperty extends ReportPropertyBase<NijuTorokuTsuchishoListSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRA112_転出者お知らせハガキ作成対象者一覧表.value());

    /**
     * 帳票ID
     */
    public TenshutsuOshiraseHagakiListPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
