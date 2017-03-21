/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE2050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050.ShisetsuSofushoNinsuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050.ShisetsuSofushoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050.ShisetsuSofushoShutsuryokuhyouProcess;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.shisetsusofusho.AFABTE205BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205BatchPrintProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設送付書発行のバッチ処理クラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class AFABTE205_ShisetsuSofushoFlow extends BatchFlowBase<AFABTE205BatchParameter> {

    private AFABTE205BatchPrintProcessParameter batchPrintProcessParameter;
    private static final String 施設送付書発行_総頁数と人数出力 = "施設送付書発行_総頁数と人数出力";
    private static final String 施設送付書発行_出力 = "施設送付書発行出力";
    private static final String 出力条件リスト_出力 = "バッチ出力条件リスト_出力";
    private static final RString ページコント = new RString("pageCount");
    private static final RString 空白内容 = new RString(" ");
    private static final RString 人数リスト = new RString("ninsuList");
    private List<IOutputOrder> 施設送付書帳票出力順;
    private static final RString 連絡符号_ORDERBY = new RString("order by ");
    private static final RString 連絡符号 = new RString(",");
    private static final RString 項目ID_施設コード = new RString("0510");
    private static final RString 項目ID_選挙番号 = new RString("0500");

    @Override
    protected void prepareConfigData() {
        batchPrintProcessParameter = getParameter().toAFABTE205BatchPrintProcessParameter();
    }

    @Override
    protected void defineFlow() {
        executeStep(施設送付書発行_総頁数と人数出力);
        executeStep(施設送付書発行_出力);
        バッチ出力条件リスト_出力();
    }

    @Step(施設送付書発行_総頁数と人数出力)
    IBatchFlowCommand get施設送付書発行_総頁数と人数出力() {
        getParameter().setOrder順(getソート順(ReportIdKeys.AFAPRE205_施設送付書.value()));
        getParameter().set改ページキーリスト(get改頁項目ID(ReportIdKeys.AFAPRE205_施設送付書.value()));
        return loopBatch(ShisetsuSofushoNinsuReportProcess.class).arguments(getParameter()).define();
    }

    @Step(施設送付書発行_出力)
    IBatchFlowCommand get施設送付書発行_出力() {
        getParameter().setOrder順(getソート順(ReportIdKeys.AFAPRE205_施設送付書.value()));
        getParameter().set改ページキーリスト(get改頁項目ID(ReportIdKeys.AFAPRE205_施設送付書.value()));
        getParameter().set人数リスト(getResult(List.class, 施設送付書発行_総頁数と人数出力, 人数リスト));
        return loopBatch(ShisetsuSofushoReportProcess.class).arguments(getParameter()).define();
    }

    @Step(出力条件リスト_出力)
    IBatchFlowCommand getバッチ出力条件リスト_出力() {
        return simpleBatch(ShisetsuSofushoShutsuryokuhyouProcess.class).arguments(batchPrintProcessParameter).define();
    }

    private void バッチ出力条件リスト_出力() {
        batchPrintProcessParameter.setジョブ番号(getJobId());
        int 出力ページ数 = getResult(Integer.class, 施設送付書発行_出力, ページコント);
        batchPrintProcessParameter.set出力ページ数(new RString(出力ページ数));

        executeStep(出力条件リスト_出力);
    }

    private List<RString> get改頁項目ID(RString 帳票ID) {
        List<RString> 改頁項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        施設送付書帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 施設送付書帳票出力順 && !施設送付書帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 施設送付書帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is改頁項目()) {
                    改頁項目IDリスト.add(setSortItem.get項目ID());
                }
            }
            return 改頁項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        施設送付書帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        StringBuilder builder = new StringBuilder();
        builder.append(連絡符号_ORDERBY);
        builder.append(ShisetsuSofushoReportOutputType.getMyBatis項目名(項目ID_施設コード));
        builder.append(連絡符号);
        builder.append(ShisetsuSofushoReportOutputType.getMyBatis項目名(項目ID_選挙番号));
        if (null != 施設送付書帳票出力順 && !施設送付書帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 施設送付書帳票出力順.get(0).get設定項目リスト()) {
                builder.append(連絡符号);
                builder.append(ShisetsuSofushoReportOutputType.getMyBatis項目名(setSortItem.get項目ID()));
                builder.append(空白内容);
                builder.append(setSortItem.get昇降順().getOrder());
            }
        }
        return new RString(builder.toString());
    }

}
