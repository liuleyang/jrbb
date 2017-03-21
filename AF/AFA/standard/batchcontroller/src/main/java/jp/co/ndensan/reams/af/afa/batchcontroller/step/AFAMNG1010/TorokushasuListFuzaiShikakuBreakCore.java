/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG103.TorokushasuListParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG103.TorokushasuListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG103.TorokushasuListKokuminSource;
import jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku.AFAPRG103FuzaiShikakuEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票資格者名簿のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListFuzaiShikakuBreakCore {

    private final AFABTG101SelectProcessParameter parameter;
    private final RString 帳票出力順;

    private static final RString 帳票タイトル_郵便投票 = new RString("登録者数リスト（郵便投票）");
    private static final RString 帳票タイトル_洋上投票 = new RString("登録者数リスト（洋上投票）");
    private static final RString 帳票タイトル_南極投票 = new RString("登録者数リスト（南極投票）");

    private TorokushasuListParameter.TorokushasuListParameterBuilder paramBuilder;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTB101SelectProcessParameter
     */
    public TorokushasuListFuzaiShikakuBreakCore(AFABTG101SelectProcessParameter parameter) {

        paramBuilder = null;
        this.parameter = parameter;

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.登録者数リスト不在者投票資格者分.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
    }

    /**
     * usualProcess
     *
     * @param current current
     * @param reportSourceWriter ReportSourceWriter
     */
    public void usualProcess(AFAPRG103FuzaiShikakuEntity current, ReportSourceWriter<TorokushasuListKokuminSource> reportSourceWriter) {

        if (paramBuilder == null) {
            if (TohyoShikakuShurui.投票資格種類_郵便.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParameter.TorokushasuListParameterBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_郵便投票,
                        parameter.get選挙種類());
            } else if (TohyoShikakuShurui.投票資格種類_船員.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParameter.TorokushasuListParameterBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_洋上投票,
                        parameter.get選挙種類());
            } else if (TohyoShikakuShurui.投票資格種類_南極.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParameter.TorokushasuListParameterBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_南極投票,
                        parameter.get選挙種類());
            } else {
                return;
            }
        }

        List<TorokushasuListParameter> params = paramBuilder.addData(current.toAFAPRG103Entity());

        for (TorokushasuListParameter param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @param reportSourceWriter ReportSourceWriter<TorokushasuListKokuminSource>
     */
    public void keyBreakProcess(AFAPRG103FuzaiShikakuEntity before,
            AFAPRG103FuzaiShikakuEntity current,
            ReportSourceWriter<TorokushasuListKokuminSource> reportSourceWriter) {
        if (!current.getTohyoshikakuShurui().equals(before.getTohyoshikakuShurui())) {
            List<TorokushasuListParameter> params = paramBuilder.lastSum();

            for (TorokushasuListParameter param : params) {

                TorokushasuListReport report = new TorokushasuListReport(param);
                report.writeBy(reportSourceWriter);
            }
            paramBuilder = null;
        }
    }

    /**
     * createLastProcess
     *
     * @param reportSourceWriter ReportSourceWriter<TorokushasuListKokuminSource>
     */
    public void createLastProcess(ReportSourceWriter<TorokushasuListKokuminSource> reportSourceWriter) {
        if (paramBuilder != null) {
            List<TorokushasuListParameter> params = paramBuilder.lastSum();

            for (TorokushasuListParameter param : params) {

                TorokushasuListReport report = new TorokushasuListReport(param);
                report.writeBy(reportSourceWriter);
            }
        }
    }
}
