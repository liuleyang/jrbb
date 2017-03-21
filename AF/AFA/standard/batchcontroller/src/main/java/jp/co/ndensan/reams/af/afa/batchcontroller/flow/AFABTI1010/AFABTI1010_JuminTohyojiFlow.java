/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFABTI1010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminChiku1DelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminChiku2DelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminChiku3DelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminGyoseikuDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminJushoDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminSenkyoDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminSenkyoninMeiboDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminTohyojiDbProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminTohyojiJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminTohyojiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminTohyojiShohonDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminTohyokuDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010.JuminZaisankuDelProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.jumintohyoji.AFABTI101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.jumintohyoji.JuminTohyojiEnum;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住民投票時登録バッチ処理クラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class AFABTI1010_JuminTohyojiFlow extends BatchFlowBase<AFABTI101BatchParameter> {

    private AFABTI101DbProcessParameter dbProcessParameter;
    private AFABTI101SelectProcessParameter selectProcessParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private IShikibetsuTaishoPSMSearchKey sTPSMSearchKey_jumin;

    private static final String 住民投票資格者名簿抄本_出力RST = "住民投票資格者名簿抄本";
    private static final String 住民投票時登録対象の取得RST = "住民投票時登録対象";
    private static final String 抄本データの削除RST = "抄本データの削除";
    private static final String 選挙データの削除RST = "選挙データの削除";
    private static final String 選挙人名簿データの削除RST = "選挙人名簿データの削除";
    private static final String 住民投票選挙人抽出条件データの削除RST = "住民投票選挙人抽出条件データの削除";
    private static final String 投票区抽出条件データの削除RST = "投票区抽出条件データの削除";
    private static final String 行政区抽出条件データの削除RST = "行政区抽出条件データの削除";
    private static final String 住所抽出条件データの削除RST = "住所抽出条件データの削除";
    private static final String 地区1抽出条件データの削除RST = "地区1抽出条件データの削除";
    private static final String 地区2抽出条件データの削除RST = "地区2抽出条件データの削除";
    private static final String 地区3抽出条件データの削除RST = "地区3抽出条件データの削除";
    private static final String 住民投票資格者名簿抄本縦覧_出力RST = "住民投票資格者名簿抄本縦覧_出力";

    private static final RString ページコント = new RString("pageCount");
    private Association association;
    private final List<RString> 住民種別条件リスト = new ArrayList();
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private RString コンフィグ住基連動;

    @Override
    protected void prepareConfigData() {

        帳票ID = ReportIdKeys.AFAPRI100_住民投票時登録.value();
        association = AssociationFinderFactory.createInstance().getAssociation();

        if (getParameter().is日本人フラグ()) {
            住民種別条件リスト.add(JuminShubetsu.日本人.getCode());
            住民種別条件リスト.add(JuminShubetsu.住登外個人_日本人.getCode());
        } else if (getParameter().is外国人フラグ()) {
            住民種別条件リスト.add(JuminShubetsu.外国人.getCode());
            住民種別条件リスト.add(JuminShubetsu.住登外個人_外国人.getCode());
        }

        FlexibleDate 年齢計算基準日 = getParameter().get年齢計算基準日();
        RString 何歳以上 = getParameter().get何歳以上();
        Decimal 年齢条件の年 = null;
        FlexibleDate 年齢条件の生年月日 = null;
        if (年齢計算基準日 != null && 何歳以上 != null) {
            年齢条件の年 = new Decimal(年齢計算基準日.getYearValue()).subtract(new Decimal(何歳以上.toString()));
        }
        if (null != 年齢計算基準日 && 年齢条件の年 != null) {
            年齢条件の生年月日 = new FlexibleDate(new RString(年齢条件の年.toString())
                    .concat(set年齢計算基準日(年齢計算基準日.getMonthValue())).concat(set年齢計算基準日(年齢計算基準日.getDayValue())));
        }

        if (getParameter().is基準日翌日の誕生日の人を含むフラグ() && 年齢条件の生年月日 != null) {
            年齢条件の生年月日 = 年齢条件の生年月日.plusDay(1);
        }

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        shikibetsuTaishoPSMSearchKey = build.build();
        dbProcessParameter = getParameter().toAFABTI101DbProcessParameter(shikibetsuTaishoPSMSearchKey, 住民種別条件リスト, 年齢条件の生年月日);

        コンフィグ住基連動 = BusinessConfig.get(
                ConfigKeysAFA.抄本_住基連動_氏名, SubGyomuCode.AFA選挙本体);

        if (コンフィグ住基連動.equals(JuminTohyojiEnum.RST_0)) {
            ShikibetsuTaishoPSMSearchKeyBuilder build_jumin = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
            build_jumin.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            sTPSMSearchKey_jumin = build.build();
        } else if (コンフィグ住基連動.equals(JuminTohyojiEnum.RST_1)) {
            ShikibetsuTaishoPSMSearchKeyBuilder build_jumin = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
            build_jumin.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            sTPSMSearchKey_jumin = build.build();
        } else if (コンフィグ住基連動.equals(JuminTohyojiEnum.RST_2)) {
            ShikibetsuTaishoPSMSearchKeyBuilder build_jumin = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
            build_jumin.setデータ取得区分(DataShutokuKubun.直近レコード);
            sTPSMSearchKey_jumin = build.build();
        }

        selectProcessParameter = getParameter().toAFABTI101SelectProcessParameter(sTPSMSearchKey_jumin);

    }

    @Override
    protected void defineFlow() {
        executeStep(選挙人名簿データの削除RST);
        executeStep(選挙データの削除RST);
        executeStep(地区3抽出条件データの削除RST);
        executeStep(地区2抽出条件データの削除RST);
        executeStep(地区1抽出条件データの削除RST);
        executeStep(住所抽出条件データの削除RST);
        executeStep(投票区抽出条件データの削除RST);
        executeStep(行政区抽出条件データの削除RST);
        executeStep(住民投票選挙人抽出条件データの削除RST);
        executeStep(抄本データの削除RST);

        住民投票対象の取得();
        住民投票資格者名簿抄本_出力();
        住民投票資格者名簿抄本縦覧_出力();
        バッチ出力条件リスト出力();
    }

    @Step(選挙人名簿データの削除RST)
    IBatchFlowCommand executJuminDelSenkyoninMeiboList() {
        return loopBatch(JuminSenkyoninMeiboDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(抄本データの削除RST)
    IBatchFlowCommand executJuminDelShohon() {
        return loopBatch(JuminTohyojiShohonDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(選挙データの削除RST)
    IBatchFlowCommand executJuminDelSenkyoList() {
        return loopBatch(JuminSenkyoDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(住民投票選挙人抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelZaisanku() {
        return loopBatch(JuminZaisankuDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(投票区抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelTohyokuList() {
        return loopBatch(JuminTohyokuDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(行政区抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelGyoseikuList() {
        return loopBatch(JuminGyoseikuDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(住所抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelJushoList() {
        return loopBatch(JuminJushoDelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(地区1抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelChiku1List() {
        return loopBatch(JuminChiku1DelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(地区2抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelChiku2List() {
        return loopBatch(JuminChiku2DelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(地区3抽出条件データの削除RST)
    IBatchFlowCommand executJuminDelChiku3List() {
        return loopBatch(JuminChiku3DelProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(住民投票時登録対象の取得RST)
    IBatchFlowCommand executJuminTohyojiList() {
        return loopBatch(JuminTohyojiDbProcess.class).arguments(dbProcessParameter).define();
    }

    @Step(住民投票資格者名簿抄本_出力RST)
    IBatchFlowCommand get住民投票名簿抄本_出力() {
        return loopBatch(JuminTohyojiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(住民投票資格者名簿抄本縦覧_出力RST)
    IBatchFlowCommand get住民投票名簿抄本縦覧_出力() {
        return loopBatch(JuminTohyojiJuranReportProcess.class).arguments(selectProcessParameter).define();
    }

    private void 住民投票対象の取得() {
        executeStep(住民投票時登録対象の取得RST);
    }

    private void 住民投票資格者名簿抄本_出力() {
        if (!dbProcessParameter.get抄本番号List().isEmpty()) {
            帳票ID = ReportIdKeys.AFAPRI100_住民投票時登録.value();
            selectProcessParameter.set抄本番号List(dbProcessParameter.get抄本番号List());
            selectProcessParameter.set出力順(getソート順(帳票ID));
            selectProcessParameter.set集計項目IDリスト(get集計項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);

            executeStep(住民投票資格者名簿抄本_出力RST);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 住民投票資格者名簿抄本_出力RST, ページコント),
                    ReportIdKeys.AFAPRI100_住民投票時登録));
        }

    }

    private void 住民投票資格者名簿抄本縦覧_出力() {
        if (!dbProcessParameter.get抄本番号List().isEmpty()) {
            帳票ID = ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.value();
            selectProcessParameter.set抄本番号List(dbProcessParameter.get抄本番号List());
            selectProcessParameter.set出力順(getソート順(帳票ID));
            selectProcessParameter.set集計項目IDリスト(get集計項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);

            executeStep(住民投票資格者名簿抄本縦覧_出力RST);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 住民投票資格者名簿抄本縦覧_出力RST, ページコント),
                    ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧));
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
                帳票名, ページ数, JuminTohyojiEnum.CSV出力有無_有り, csvファイル名, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(JuminTohyojiEnum.出力条件_処理種別.concat(getParameter().get処理種別()));
        if (getParameter().get抄本番号() != null) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_抄本.concat(getParameter().get抄本番号().toString()));
        }

        出力条件リスト.add(JuminTohyojiEnum.出力条件_住民投票名.concat(getParameter().get抄本名()));
        出力条件リスト.add(JuminTohyojiEnum.出力条件_投票日.concat(getParameter().get投票日().toString()));
        出力条件リスト.add(JuminTohyojiEnum.出力条件_投票開始日.concat(getParameter().get投票開始日().toString()));
        出力条件リスト.add(get住民種別());
        出力条件リスト.add(get住民状態());
        if (getParameter().get転出日() != null) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_転出日.concat(getParameter().get転出日().toString())
                    .concat(JuminTohyojiEnum.出力内容_以降));
        }

        if (getParameter().get転入日() != null) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_転入日.concat(getParameter().get転入日().toString())
                    .concat(JuminTohyojiEnum.出力内容_以前));
        }

        if (getParameter().is抽出対象者に公民権停止者の人を含めるフラグ()) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_抽出対象者に公民権停止者の人.concat(JuminTohyojiEnum.出力内容_含む));
        } else {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_抽出対象者に公民権停止者の人.concat(JuminTohyojiEnum.出力内容_含まない));
        }

        出力条件リスト.add(JuminTohyojiEnum.出力条件_年齢計算基準日.concat(getParameter().get年齢計算基準日().toString()));
        出力条件リスト.add(JuminTohyojiEnum.出力条件_何歳以上.concat(getParameter().get何歳以上()));
        if (getParameter().is基準日翌日の誕生日の人を含むフラグ()) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_基準日翌日の誕生日の人.concat(JuminTohyojiEnum.出力内容_含む));
        } else {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_基準日翌日の誕生日の人.concat(JuminTohyojiEnum.出力内容_含まない));
        }

        RString 住定期間From = RString.EMPTY;
        RString 住定期間To = RString.EMPTY;
        if (getParameter().get住定期間From() != null) {
            住定期間From = new RString(getParameter().get住定期間From().toString());
        }
        if (getParameter().get住定期間To() != null) {
            住定期間To = new RString(getParameter().get住定期間To().toString());
        }

        if (!(getParameter().get住定期間From() == null && getParameter().get住定期間To() == null)) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_住定期間.concat(住定期間From).concat(JuminTohyojiEnum.出力内容_連絡符号２)
                    .concat(住定期間To));
        }

        if (getParameter().is期間中_年以上連続で居住フラグ()) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_期間中連続で居住.concat(getParameter().get期間中_年以上連続で居住())
                    .concat(JuminTohyojiEnum.出力内容_年以上));

        } else {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_期間中連続で居住.concat(RString.EMPTY));
        }

        出力条件リスト.add(JuminTohyojiEnum.出力条件_住所条件.concat(getParameter().get住所条件()));
        出力条件リスト.add(JuminTohyojiEnum.出力条件_住所条件選択リスト.concat(住所条件選択コードリスト()));

        if (getParameter().is住民投票資格者名簿抄本フラグ()) {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_住民投票資格者名簿抄本.concat(JuminTohyojiEnum.出力内容_出力));
        } else {
            出力条件リスト.add(JuminTohyojiEnum.出力条件_住民投票資格者名簿抄本.concat(JuminTohyojiEnum.出力内容_出力しない));
        }

        return 出力条件リスト;
    }

    private RString get住民種別() {
        RString 住民種別 = RString.EMPTY;
        if (getParameter().is日本人フラグ()) {
            住民種別 = JuminTohyojiEnum.出力条件_住民種別.concat(JuminTohyojiEnum.住民種別_日本人);
        }
        if (getParameter().is外国人フラグ() && !住民種別.isEmpty()) {
            住民種別 = JuminTohyojiEnum.出力条件_住民種別.concat(JuminTohyojiEnum.住民種別_日本人)
                    .concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民種別_外国人);
        }
        if (getParameter().is外国人フラグ() && 住民種別.isEmpty()) {
            住民種別 = JuminTohyojiEnum.出力条件_住民種別.concat(JuminTohyojiEnum.住民種別_外国人);
        }
        return 住民種別;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private RString get住民状態() {
        RString 住民状態 = RString.EMPTY;

        if (getParameter().is住民フラグ() && getParameter().is転入者フラグ() && getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_住民)
                    .concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民状態_転出者).
                    concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民状態_転入者);
        } else if (!getParameter().is住民フラグ() && getParameter().is転入者フラグ() && getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_転出者)
                    .concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民状態_転入者);
        } else if (getParameter().is住民フラグ() && getParameter().is転入者フラグ() && !getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_住民).
                    concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民状態_転入者);
        } else if (getParameter().is住民フラグ() && !getParameter().is転入者フラグ() && !getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_住民).
                    concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(JuminTohyojiEnum.住民状態_転出者);
        } else if (!getParameter().is住民フラグ() && !getParameter().is転入者フラグ() && getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_転出者);
        } else if (!getParameter().is住民フラグ() && getParameter().is転入者フラグ() && !getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_転入者);
        } else if (getParameter().is住民フラグ() && !getParameter().is転入者フラグ() && !getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_住民);
        } else if (getParameter().is住民フラグ() && !getParameter().is転入者フラグ() && getParameter().is転出者フラグ()) {
            住民状態 = JuminTohyojiEnum.出力条件_住民状態.concat(JuminTohyojiEnum.住民状態_住民).concat(JuminTohyojiEnum.住民状態_転出者);
        }
        return 住民状態;

    }

    private RString 住所条件選択コードリスト() {
        RString 住所条件コード = RString.EMPTY;
        if (getParameter().get住所条件選択コードリスト().size() == 1) {
            住所条件コード = 住所条件コード.concat(getParameter().get住所条件選択コードリスト().get(0));
        } else {
            for (int i = 0; i < getParameter().get住所条件選択コードリスト().size(); i++) {
                住所条件コード = 住所条件コード.concat(JuminTohyojiEnum.出力内容_連絡符号１).concat(getParameter().get住所条件選択コードリスト().get(i));
            }
            住所条件コード = 住所条件コード.substring(1);
        }
        return 住所条件コード;
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

    private List<RString> get集計項目ID(RString 帳票ID) {
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

    private RString set年齢計算基準日(int value) {
        RString 年齢計算;
        if (value < JuminTohyojiEnum.INT_10 && value > 0) {
            年齢計算 = JuminTohyojiEnum.RST_0.concat(new RString(value));
        } else {
            年齢計算 = new RString(value);
        }
        return 年齢計算;
    }

}
