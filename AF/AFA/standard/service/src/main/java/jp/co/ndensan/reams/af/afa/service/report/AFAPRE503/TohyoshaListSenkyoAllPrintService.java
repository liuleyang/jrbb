/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE503;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoshaListSenkyoAllParam;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE503.TohyoshaListSenkyoAllProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE503.TohyoshaListSenkyoAllReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import static jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon.createAssembler;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllPrintService {

    /**
     * 投票者一覧表作成を発行します。
     *
     * @param tohyoshaListSenkyoAllList List<TohyoshaListSenkyoAllParam>
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TohyoshaListSenkyoAllParam> tohyoshaListSenkyoAllList, TeijiCommonJohoItem 帳票共通ヘッダー) {
        try (ReportManager reportManager = new ReportManager()) {
            TohyoshaListSenkyoAllProperty property = new TohyoshaListSenkyoAllProperty();
            try (ReportAssembler<TohyoshaListSenkyoAllSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<TohyoshaListSenkyoAllSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (TohyoshaListSenkyoAllParam param : tohyoshaListSenkyoAllList) {
                    RString 施設名称 = get施設名称(param.get投票状況Entity().get施設コード());
                    param.set投票場所(施設名称);
                    TohyoshaListSenkyoAllReport report = toReport(param, 帳票共通ヘッダー);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private TohyoshaListSenkyoAllReport toReport(TohyoshaListSenkyoAllParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new TohyoshaListSenkyoAllReport(param, 帳票共通ヘッダー);
    }

    private RString get施設名称(RString 施設コード) {
        Shisetsu 施設 = ShisetsuManager.createInstance().get施設By施設コード(施設コード);
        return 施設 == null ? RString.EMPTY : 施設.get施設名称();
    }

}
