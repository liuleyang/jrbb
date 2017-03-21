/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNB2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2020.NyujokenKobetsuDetailReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.AFABTB202BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.SenkyoninIrain;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.nyujokenikkatsu.AFABTB202SelectProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 入場券発行（個別のバッチ処理クラスです。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class AFABTB202_NyujokenKobetsuFlow extends BatchFlowBase<AFABTB202BatchParameter> {

    private AFABTB202SelectProcessParameter selectProcessParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】 ");
    private static final RString 出力条件_入場券名1 = new RString("【入場券名1】 ");
    private static final RString 出力条件_入場券名2 = new RString("【入場券名2】 ");
    private static final RString 出力条件_入場券名3 = new RString("【入場券名3】 ");
    private static final RString 出力条件_選挙人 = new RString("【選挙人】 ");
    private static final RString 出力条件_印刷タイプ = new RString("【印刷タイプ】 ");
    private static final RString 出力条件_世帯印字人数 = new RString("【世帯印字人数】 ");
    private static final RString 出力条件_対象者を個々に作成する = new RString("【対象者を個々に作成する】 ");
    private static final RString 出力条件_抽出対象世帯人数 = new RString("【対象者の世帯で作成する】 ");
    private static final RString 出力内容_連絡符号１ = new RString("、");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString 出力内容_有り = new RString("する");
    private static final RString 出力内容_無し = new RString("しない");
    private static final String 投票所入場券_個票3つ折り_出力 = "投票所入場券_個票3つ折り";
    private static final String 投票所入場券_はがき4つ切り_出力 = "投票所入場券_はがき4つ切り";
    private static final String 投票所入場券_シーラー_出力 = "投票所入場券_シーラー";
    private static final String 投票所入場券_ポステックス_出力 = "投票所入場券_ポステックス_出力";

    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private static final RString ページコント = new RString("pageCount");
    private Association association;

    @Override
    protected void prepareConfigData() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        selectProcessParameter = getParameter().toAFABTB202SelectProcessParameter();
    }

    @Override
    protected void defineFlow() {
        投票所入場券個票出力();
        バッチ出力条件リスト出力();
    }

    @Step(投票所入場券_個票3つ折り_出力)
    IBatchFlowCommand get投票所入場券_個票3つ折り_出力() {
        return simpleBatch(NyujokenKobetsuDetailReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票所入場券_はがき4つ切り_出力)
    IBatchFlowCommand get投票所入場券_はがき4つ切り_出力() {
        return simpleBatch(NyujokenKobetsuDetailReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票所入場券_シーラー_出力)
    IBatchFlowCommand get投票所入場券_シーラー_出力() {
        return simpleBatch(NyujokenKobetsuDetailReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票所入場券_ポステックス_出力)
    IBatchFlowCommand get投票所入場券_ポステックス_出力() {
        return simpleBatch(NyujokenKobetsuDetailReportProcess.class).arguments(selectProcessParameter).define();
    }

    private void 投票所入場券個票出力() {
        RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        投票所入場券個票_3つ折り_出力(入場券_印刷タイプ);
        投票所入場券個票_はがき4つ切り(入場券_印刷タイプ);
        投票所入場券個票_シーラー(入場券_印刷タイプ);
        投票所入場券個票_ポステックス(入場券_印刷タイプ);
    }

    private void 投票所入場券個票_3つ折り_出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value();
            selectProcessParameter.setSort(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(投票所入場券_個票3つ折り_出力);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票所入場券_個票3つ折り_出力, ページコント),
                    ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り));
        }
    }

    private void 投票所入場券個票_はがき4つ切り(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value();
            selectProcessParameter.setSort(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(投票所入場券_はがき4つ切り_出力);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票所入場券_はがき4つ切り_出力, ページコント),
                    ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り));
        }
    }

    private void 投票所入場券個票_シーラー(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value();
            selectProcessParameter.setSort(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(投票所入場券_シーラー_出力);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票所入場券_シーラー_出力, ページコント),
                    ReportIdKeys.AFAPRB203_投票所入場券_シーラー));
        }
    }

    private void 投票所入場券個票_ポステックス(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value();
            selectProcessParameter.setSort(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(投票所入場券_ポステックス_出力);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票所入場券_ポステックス_出力, ページコント),
                    ReportIdKeys.AFAPRB204_投票所入場券_ポステックス));
        }
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数, ReportIdKeys reportId) {
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件 = get出力条件リスト();
        return new ReportOutputJokenhyoItem(reportId.value(), 地方公共団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, CSV出力有無_有り, csvファイル名, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_抄本番号.concat(getParameter().get抄本番号()));
        出力条件リスト.add(出力条件_入場券名1.concat(getParameter().get入場券名1()));
        出力条件リスト.add(出力条件_入場券名2.concat(getParameter().get入場券名2()));
        出力条件リスト.add(出力条件_入場券名3.concat(getParameter().get入場券名3()));
        RString 識別コードリスト = RString.EMPTY;
        for (SenkyoninIrain 選挙人一覧 : getParameter().get選挙人一覧リスト()) {
            識別コードリスト = 識別コードリスト.concat(選挙人一覧.get識別コード().getColumnValue()).concat(出力内容_連絡符号１);
        }
        if (識別コードリスト.isEmpty()) {
            出力条件リスト.add(出力条件_選挙人);
        } else {
            出力条件リスト.add(出力条件_選挙人.concat(識別コードリスト.substring(0, 識別コードリスト.length() - 1)));
        }
        出力条件リスト.add(出力条件_印刷タイプ.concat(get印刷タイプに対応する名称(getParameter().get印刷タイプ())));
        出力条件リスト.add(出力条件_世帯印字人数.concat(doZZZ_ZZ9編集(getParameter().get世帯印字人数())));
        出力条件リスト.add(出力条件_対象者を個々に作成する.concat(getParameter().get対象者を個々に作成する有無() ? 出力内容_有り : 出力内容_無し));
        出力条件リスト.add(出力条件_抽出対象世帯人数.concat(getParameter().get対象者の世帯で作成する有無() ? 出力内容_有り : 出力内容_無し));

        return 出力条件リスト;
    }

    private RString get印刷タイプに対応する名称(RString insakuType) {
        if (RString.isNullOrEmpty(insakuType)) {
            return RString.EMPTY;
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getValue();
        }
        return RString.EMPTY;
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

    }

    private void バッチ出力条件リスト出力() {
        for (ReportOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private List<RString> get改頁項目ID(RString 帳票ID) {
        List<RString> 改頁項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is改頁項目()) {
                    改頁項目IDリスト.add(setSortItem.get項目ID());
                }
            }
            return 改頁項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
