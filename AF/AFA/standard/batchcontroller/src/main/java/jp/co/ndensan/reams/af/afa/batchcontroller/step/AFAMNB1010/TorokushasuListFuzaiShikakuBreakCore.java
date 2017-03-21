/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103FuzaiShikakuEntity;
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
 * @reamsid_L AF-0030-036 liss
 */
public class TorokushasuListFuzaiShikakuBreakCore {

    private final AFABTB101SelectProcessParameter parameter;
    private final RString 帳票出力順;

    private static final RString 帳票タイトル_郵便投票 = new RString("登録者数リスト（郵便投票）");
    private static final RString 帳票タイトル_洋上投票 = new RString("登録者数リスト（洋上投票）");
    private static final RString 帳票タイトル_南極投票 = new RString("登録者数リスト（南極投票）");

    private TorokushasuListParam.TorokushasuListParamBuilder paramBuilder;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTB101SelectProcessParameter
     */
    public TorokushasuListFuzaiShikakuBreakCore(AFABTB101SelectProcessParameter parameter) {

        paramBuilder = null;
        this.parameter = parameter;

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.不在者投票資格者分.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
    }

    /**
     * usualProcess
     *
     * @param current current
     * @param reportSourceWriter ReportSourceWriter
     */
    public void usualProcess(AFAPRA103FuzaiShikakuEntity current, ReportSourceWriter<TorokushasuListSource> reportSourceWriter) {

        if (paramBuilder == null) {
            if (TohyoShikakuShurui.投票資格種類_郵便.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParam.TorokushasuListParamBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_郵便投票,
                        parameter.getSenkyoShurui());
            } else if (TohyoShikakuShurui.投票資格種類_船員.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParam.TorokushasuListParamBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_洋上投票,
                        parameter.getSenkyoShurui());
            } else if (TohyoShikakuShurui.投票資格種類_南極.getCode().equals(current.getTohyoshikakuShurui().getColumnValue())) {
                paramBuilder = new TorokushasuListParam.TorokushasuListParamBuilder(帳票共通ヘッダー,
                        帳票出力順,
                        帳票タイトル_南極投票,
                        parameter.getSenkyoShurui());
            } else {
                return;
            }
        }

        List<TorokushasuListParam> params = paramBuilder.addData(current.toAFAPRA103Entity());

        for (TorokushasuListParam param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @param reportSourceWriter ReportSourceWriter<TorokushasuListSource>
     */
    public void keyBreakProcess(AFAPRA103FuzaiShikakuEntity before,
            AFAPRA103FuzaiShikakuEntity current,
            ReportSourceWriter<TorokushasuListSource> reportSourceWriter) {
        if (!current.getTohyoshikakuShurui().equals(before.getTohyoshikakuShurui())) {
            List<TorokushasuListParam> params = paramBuilder.lastSum();

            for (TorokushasuListParam param : params) {

                TorokushasuListReport report = new TorokushasuListReport(param);
                report.writeBy(reportSourceWriter);
            }
            paramBuilder = null;
        }
    }

    /**
     * createLastProcess
     *
     * @param reportSourceWriter ReportSourceWriter<TorokushasuListSource>
     */
    public void createLastProcess(ReportSourceWriter<TorokushasuListSource> reportSourceWriter) {
        if (paramBuilder != null) {
            List<TorokushasuListParam> params = paramBuilder.lastSum();

            for (TorokushasuListParam param : params) {

                TorokushasuListReport report = new TorokushasuListReport(param);
                report.writeBy(reportSourceWriter);
            }
        }
    }

}
