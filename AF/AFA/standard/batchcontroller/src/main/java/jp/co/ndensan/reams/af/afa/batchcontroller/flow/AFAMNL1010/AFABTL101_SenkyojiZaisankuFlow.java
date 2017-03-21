/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNL1010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuInsertProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuJuminTohyoConditionDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuJushoConditionDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuSenkyoDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuSenkyoninMeiboDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuShohonDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuShutsuryokuhyouProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuTohyokuConditionDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010.SenkyojiZaisankuTohyokuConditionInsertProcess;
import jp.co.ndensan.reams.af.afa.business.core.SenkyojiZaisankuReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojizaisanku.AFABTL101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録のバッチ処理クラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class AFABTL101_SenkyojiZaisankuFlow extends BatchFlowBase<AFABTL101BatchParameter> {

    private AFABTL101BatchPrintProcessParameter batchPrintProcessParameter;
    private AFABTL101SelectProcessParameter selectProcessParameter;
    private static final String 抄本データ_削除 = "抄本データの削除";
    private static final String 選挙データ_削除 = "選挙データの削除";
    private static final String 選挙人名簿データ_削除 = "選挙人名簿データの削除";
    private static final String 住民投票選挙人抽出条件データ_削除 = "住民投票選挙人抽出条件データの削除";
    private static final String 投票区抽出条件データ_削除 = "投票区抽出条件データの削除";
    private static final String 住所抽出条件データ_削除 = "住所抽出条件データの削除";
    private static final String 財産区議会議員選挙時登録 = "財産区議会議員選挙時登録対象データ登録";
    private static final String 投票区抽出条件登録 = "投票区抽出条件データ登録";
    private static final String 財産区選挙人名簿抄本_出力_STR = "財産区選挙人名簿抄本出力";
    private static final String 財産区選挙人名簿抄本縦覧_出力 = "財産区選挙人名簿抄本縦覧出力";
    private static final String 出力条件リスト_出力 = "バッチ出力条件リスト出力";
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;

    @Override
    protected void prepareConfigData() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        getParameter().setKey(shikibetsuTaishoPSMSearchKey);
        batchPrintProcessParameter = getParameter().toAFABTL101BatchPrintProcessParameter();
        getParameter().setKey(shikibetsuTaishoPSMSearchKey);
        selectProcessParameter = getParameter().toAFABTL101SelectProcessParameter();
    }

    @Override
    protected void defineFlow() {
        RString 処理種別 = getParameter().get処理種別();
        if (SenkyojiZaisankuRStringEnum.処理種別_新規処理.getKey().equals(処理種別)) {
            executeStep(財産区議会議員選挙時登録);
            executeStep(投票区抽出条件登録);
        } else if (SenkyojiZaisankuRStringEnum.処理種別_再処理.getKey().equals(処理種別)) {
            executeStep(選挙人名簿データ_削除);
            executeStep(選挙データ_削除);
            executeStep(住所抽出条件データ_削除);
            executeStep(投票区抽出条件データ_削除);
            executeStep(住民投票選挙人抽出条件データ_削除);
            executeStep(抄本データ_削除);
            executeStep(財産区議会議員選挙時登録);
            executeStep(投票区抽出条件登録);
        }
        財産区選挙人名簿抄本_出力();
        バッチ出力条件リスト_出力();
    }

    @Step(財産区議会議員選挙時登録)
    IBatchFlowCommand execute財産区議会議員選挙時登録() {
        return loopBatch(SenkyojiZaisankuInsertProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票区抽出条件登録)
    IBatchFlowCommand execute投票区抽出条件登録() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(財産区議会議員選挙時登録), SenkyojiZaisankuRStringEnum.一時テーブル名.getKey()));
        return loopBatch(SenkyojiZaisankuTohyokuConditionInsertProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(抄本データ_削除)
    IBatchFlowCommand execute抄本データ削除() {
        return loopBatch(SenkyojiZaisankuShohonDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙データ_削除)
    IBatchFlowCommand execute選挙データ削除() {
        return loopBatch(SenkyojiZaisankuSenkyoDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿データ_削除)
    IBatchFlowCommand execute選挙人名簿データ削除() {
        return loopBatch(SenkyojiZaisankuSenkyoninMeiboDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(住民投票選挙人抽出条件データ_削除)
    IBatchFlowCommand execute住民投票選挙人抽出条件データ削除() {
        return loopBatch(SenkyojiZaisankuJuminTohyoConditionDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票区抽出条件データ_削除)
    IBatchFlowCommand execute投票区抽出条件データ削除() {
        return loopBatch(SenkyojiZaisankuTohyokuConditionDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(住所抽出条件データ_削除)
    IBatchFlowCommand execute住所抽出条件データ削除() {
        return loopBatch(SenkyojiZaisankuJushoConditionDelProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(財産区選挙人名簿抄本_出力_STR)
    IBatchFlowCommand get財産区選挙人名簿抄本出力() {
        return loopBatch(SenkyojiZaisankuReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(財産区選挙人名簿抄本縦覧_出力)
    IBatchFlowCommand get財産区選挙人名簿抄本縦覧出力() {
        return loopBatch(SenkyojiZaisankuJuranReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(出力条件リスト_出力)
    IBatchFlowCommand getバッチ出力条件リスト出力() {
        return simpleBatch(SenkyojiZaisankuShutsuryokuhyouProcess.class).arguments(batchPrintProcessParameter).define();
    }

    private void 財産区選挙人名簿抄本_出力() {
        帳票ID = ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.value();
        selectProcessParameter.set画面ID(帳票ID);
        selectProcessParameter.setOrder順(getソート順(帳票ID));
        selectProcessParameter.set集計項目IDリスト(get集計項目名(帳票ID));
        executeStep(財産区選挙人名簿抄本_出力_STR);
        executeStep(財産区選挙人名簿抄本縦覧_出力);

    }

    private void バッチ出力条件リスト_出力() {
        batchPrintProcessParameter.setジョブ番号(getJobId());
        int 出力ページ数 = getResult(Integer.class, 財産区選挙人名簿抄本_出力_STR, SenkyojiZaisankuRStringEnum.ページコント.getKey());
        batchPrintProcessParameter.set出力ページ数(new RString(出力ページ数));
        executeStep(出力条件リスト_出力);
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(SenkyojiZaisankuReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private List<RString> get集計項目名(RString 帳票ID) {
        List<RString> 集計項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is集計項目()) {
                    集計項目IDリスト.add(setSortItem.get項目名());
                }
            }
            return 集計項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
