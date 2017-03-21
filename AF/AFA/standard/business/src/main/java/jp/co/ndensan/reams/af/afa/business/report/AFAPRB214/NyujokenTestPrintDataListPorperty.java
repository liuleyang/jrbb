package jp.co.ndensan.reams.af.afa.business.report.AFAPRB214;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListPorperty extends ReportPropertyBase<NyujokenTestPrintDataListSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB214_入場券テストデータ抽出一覧表.value());

    /**
     * 帳票ID
     */
    public NyujokenTestPrintDataListPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
