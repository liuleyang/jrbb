/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505BatchPrintProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票結果集計表バッチ出力条件表のプロセスクラスです。
 *
 * @reamsid_L AF-0290-020 zhanggs
 */
public class AFABTE505BatchShutsuryokuJokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString CSV_出力有無 = new RString("あり");
    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】 ");
    private static final RString 出力条件_行政区毎のEUCデータを作成する = new RString("【行政区毎のEUCデータを作成する】 ");
    private static final RString 出力条件_投票区 = new RString("【投票区】 ");
    private static final RString 出力条件_範囲符号 = new RString("～");
    private static final RString 出力条件_作成有 = new RString("有り");
    private static final RString 出力条件_作成無 = new RString("無し");
    private AFABTE505BatchPrintProcessParameter parameter;
    private Association association;

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        List<RString> 出力条件Base = get出力条件Base();
        List<ReportOutputJokenhyoItem> items = new ArrayList<>();
        if (parameter.get年齢別投票率集計表出力有無()) {
            List<RString> 出力条件 = get出力条件(出力条件Base,
                    parameter.get年齢別EUCデータを作成する有無(),
                    parameter.get投票区年齢別投票率集計表_投票区from(),
                    parameter.get投票区年齢別投票率集計表_投票区to());
            items.add(getItem(出力条件, ReportIdKeys.年齢別投票率集計表, parameter.get年齢別投票率集計表出力数()));
        }
        if (parameter.get年代別投票率集計表出力有無()) {
            List<RString> 出力条件 = get出力条件(出力条件Base,
                    parameter.get年代別EUCデータを作成する有無(),
                    parameter.get投票区年代別投票率集計表_投票区from(),
                    parameter.get投票区年代別投票率集計表_投票区to());
            items.add(getItem(出力条件, ReportIdKeys.年代別投票率集計表, parameter.get年代別投票率集計表出力数()));
        }
        if (parameter.get時間別投票者集計表出力有無()) {
            items.add(getItem(出力条件Base, ReportIdKeys.時間別投票者集計表, parameter.get時間別投票者集計表出力数()));
        }
        ReportOutputJokenhyoFactory.createInstance(items).print();
    }

    private List<RString> get出力条件Base() {
        List<RString> 出力条件Base = new ArrayList();
        出力条件Base.add(出力条件_抄本番号.concat(parameter.get抄本番号().toString()));
        return 出力条件Base;
    }

    private ReportOutputJokenhyoItem getItem(List<RString> 出力条件, ReportIdKeys reportIdKeys, Integer 出力数) {
        return new ReportOutputJokenhyoItem(
                reportIdKeys.value(),
                association.get地方公共団体コード().getColumnValue(),
                association.get市町村名(),
                new RString(parameter.getジョブ番号().toString()),
                reportIdKeys.getReportName(),
                new RString(出力数 == null ? 0 : 出力数),
                CSV_出力有無,
                reportIdKeys.getEucFileName(),
                出力条件);
    }

    private List<RString> get出力条件(
            List<RString> 出力条件Base,
            boolean 行政区毎のEUCデータ作成有無,
            RString tohyokuFrom,
            RString tohyokuTo) {
        List<RString> 出力条件 = new ArrayList<>(出力条件Base);
        出力条件.add(出力条件_行政区毎のEUCデータを作成する.concat(行政区毎のEUCデータ作成有無 ? 出力条件_作成有 : 出力条件_作成無));
        出力条件.add(get投票区範囲(tohyokuFrom, tohyokuTo));
        return 出力条件;
    }

    private RString get投票区範囲(RString tohyokuFrom, RString tohyokuTo) {
        if (RString.isNullOrEmpty(tohyokuFrom) && RString.isNullOrEmpty(tohyokuTo)) {
            return 出力条件_投票区;
        }
        return 出力条件_投票区.concat(NullHandler.getNullToRString(tohyokuFrom)).concat(出力条件_範囲符号).concat(NullHandler.getNullToRString(tohyokuTo));
    }
}
