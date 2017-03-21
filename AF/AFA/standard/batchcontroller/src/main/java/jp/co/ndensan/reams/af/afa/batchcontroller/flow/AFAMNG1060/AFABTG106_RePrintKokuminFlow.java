/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNG1060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.FuzaiShikakushaMeiboReportprocess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MeiboShohonZaigaiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.IchigoShikakuTorokuTsuchiAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.IchigoShikakuTorokuTsuchiAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.IchigoShikakuTorokuTsuchiListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.IchigoShikakuTorokuTsuchiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokugaiTennyushaChosahyoAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokugaiTennyushaChosahyoAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokugaiTennyushaChosahyoKaitoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokugaiTennyushaChosahyoListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokugaiTennyushaChosahyoShokaiProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokunaiTennyushaChosahyoAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokunaiTennyushaChosahyoAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokunaiTennyushaChosahyoKaitoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokunaiTennyushaChosahyoListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokunaiTennyushaChosahyoShokaiProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MasshoshaMeiboJuranKokuminProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MasshoshaMeiboKokuminProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MitorokushaMasshoTsuchiAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MitorokushaMasshoTsuchiAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MitorokushaMasshoTsuchiListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.MitorokushaMasshoTsuchiProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuChosahyoAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuChosahyoAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuChosahyoKaitoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuChosahyoListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuChosahyoShokaiProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.NigoShikakuKohoshaListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.ShinkiTorokushaMeiboJuranKokuminProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.ShinkiTorokushaMeiboKokuminAtenaSeal12Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.ShinkiTorokushaMeiboKokuminAtenaSeal21Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.ShinkiTorokushaMeiboKokuminProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TeiseishaMeiboKokuminProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TohyoninMeiboShohonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TorokushasuListDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TorokushasuListFuzaiShikakuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TorokushasuListFuzaiShikakuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.TorokushasuListReportProcess;
import jp.co.ndensan.reams.af.afa.business.KokuminTohyoji;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintkokumin.AFABTG106BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuRyokuJyoukenEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.ReportOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国民投票帳票再発行のバッチ処理クラスです。
 *
 * @reamsid_L AF-0400-020 guancy
 */
public class AFABTG106_RePrintKokuminFlow extends BatchFlowBase<AFABTG106BatchParameter> {

    private static final String 投票人名簿抄本帳票出力 = "投票人名簿抄本帳票出力";
    private static final String 二号資格調査一覧表出力 = "二号資格調査一覧表出力";
    private static final String 未登録者抹消通知一覧表出力 = "未登録者抹消通知一覧表出力";
    private static final String 未登録者抹消通知出力 = "未登録者抹消通知出力";
    private static final String 在外投票管理表帳票出力 = "在外投票管理表帳票出力";
    private static final String 国外転入者調査一覧表出力 = "国外転入者調査一覧表出力";
    private static final String 国内転入者調査一覧表出力 = "国内転入者調査一覧表出力";
    private static final String 国外転入者調査票照会出力 = "国外転入者調査票照会出力";
    private static final String 国内転入者調査票照会出力 = "国内転入者調査票照会出力";
    private static final String 補正登録者名簿出力 = "補正登録者名簿出力";
    private static final String 補正登録者名簿縦覧出力 = "補正登録者名簿縦覧出力";
    private static final String 訂正者名簿出力 = "訂正者名簿出力";
    private static final String 投票人名簿登録者数リスト出力 = "投票人名簿登録者数リスト出力";
    private static final String 投票人名簿登録者数リスト一時テーブル作成 = "投票人名簿登録者数リスト一時テーブル作成";
    private static final String 登録者数リスト不在者分帳票出力 = "登録者数リスト不在者分帳票出力";
    private static final String 登録者数リスト不在者分一時テーブル作成 = "登録者数リスト不在者分一時テーブル作成";
    private static final String 不在資格対象者名簿帳票出力 = "不在資格対象者名簿帳票出力";
    private static final String 一号資格登録通知出力 = "一号資格登録通知出力";
    private static final String 一号資格登録通知一覧表出力 = "一号資格登録通知一覧表出力";
    private static final String 二号資格調査票照会出力 = "二号資格調査票照会出力";
    private static final String 二号資格調査票回答出力 = "二号資格調査票回答出力";
    private static final String 二号資格候補者一覧表出力 = "二号資格候補者一覧表出力";
    private static final String 国内転入者調査票回答出力 = "国内転入者調査票回答出力";
    private static final String 国外転入者調査票回答出力 = "国外転入者調査票回答出力";
    private static final String 抹消者名簿出力 = "抹消者名簿出力";
    private static final String 抹消者名簿縦覧出力 = "抹消者名簿縦覧出力";
    private static final String 在外投票人名簿抄本出力 = "在外投票人名簿抄本出力";
    private static final String 在外投票資格者名簿出力 = "在外投票資格者名簿出力";
    private static final String 宛名シール1号資格登録通知12面 = "宛名シール1号資格登録通知12面";
    private static final String 宛名シール2号資格調査票12面 = "宛名シール2号資格調査票12面";
    private static final String 補正登録者宛名シール12面 = "補正登録者宛名シール12面";
    private static final String 宛名シール未登録者抹消通知12面 = "宛名シール未登録者抹消通知12面";
    private static final String 宛名シール国内転入者調査票12面 = "宛名シール国内転入者調査票12面";
    private static final String 宛名シール国外転入者調査票12面 = "宛名シール国外転入者調査票12面";
    private static final String 宛名シール1号資格登録通知21面 = "宛名シール1号資格登録通知21面";
    private static final String 宛名シール2号資格調査票21面 = "宛名シール2号資格調査票21面";
    private static final String 補正登録者宛名シール21面 = "補正登録者宛名シール21面";
    private static final String 宛名シール未登録者抹消通知21面 = "宛名シール未登録者抹消通知21面";
    private static final String 宛名シール国内転入者調査票21面 = "宛名シール国内転入者調査票21面";
    private static final String 宛名シール国外転入者調査票21面 = "宛名シール国外転入者調査票21面";
    private AFABTG101SelectProcessParameter selectProcessParameter;
    private AFABTB101SelectProcessParameter aFABTB101SelectParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private Association association;
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();
    private Boolean is12面;

    @Override
    protected void prepareConfigData() {
        RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
        is12面 = AFAConfigKeysValue.宛名シール_面数_12面.configKeyValue().equals(宛名シール_面数);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        association = associationFinder.getAssociation();
        if (getParameter().get時点日() == null || getParameter().get時点日().isEmpty()) {
            getParameter().set時点日(getParameter().get基準日());
        }
        if (getParameter().get抹消日() == null
                || getParameter().get抹消日().isEmpty()) {
            KokuminTohyoji kokuminTohyoji = new KokuminTohyoji();
            RDate 日付 = kokuminTohyoji.get帳票条件_日付取得処理(new RDate(getParameter().get投票日().toString()));
            if (日付 != null) {
                getParameter().set抹消日(new FlexibleDate(日付.toDateString()));
            } else {
                getParameter().set抹消日(FlexibleDate.EMPTY);
            }

        }
        selectProcessParameter = getParameter().toAFABTG101SelectProcessParameter();
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build1 = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build1.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build1.set基準日(selectProcessParameter.get基準日());
        build1.set住民種別(住民種別);
        build1.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey key = build1.build();
        build1.setデータ取得区分(DataShutokuKubun.全履歴);
        IShikibetsuTaishoPSMSearchKey keyForAll = build1.build();
        aFABTB101SelectParameter = getParameter().toAFABTB101SelectProcessParameter(key, keyForAll);
    }

    @Override
    protected void defineFlow() {
        投票人名簿抄本出力();
        投票人名簿登録者数リスト();
        不在資格対象者名簿();
        一号資格登録通知();
        一号資格登録通知一覧表();
        一号資格登録通知送付先宛名シール();
        二号資格調査票照会();
        二号資格調査票回答();
        二号資格調査一覧表();
        二号資格調査票送付先宛名シール();
        二号資格候補者一覧表();
        補正登録者名簿();
        補正登録者宛名シール();
        補正登録者名簿縦覧();
        抹消者名簿();
        抹消者名簿縦覧();
        訂正者名簿();
        未登録者抹消通知();
        未登録者抹消通知一覧表();
        未登録者抹消通知送付先宛名シール();
        国内転入者調査票照会();
        国内転入者調査票回答();
        国内転入者調査一覧表();
        国内転入者調査票送付先宛名シール();
        国外転入者調査票照会();
        国外転入者調査票回答();
        国外転入者調査一覧表();
        国外転入者調査票送付先宛名シール();
        在外投票人名簿抄本();
        在外投票資格者名簿();
        在外投票管理表出力();
        バッチ出力条件リスト出力();
    }

    private void 投票人名簿抄本出力() {
        if (getParameter().get投票人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.投票人名簿抄本.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(投票人名簿抄本帳票出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit投票人名簿抄本出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票人名簿抄本帳票出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.投票人名簿抄本));
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票人名簿抄本帳票出力, ShutsuRyokuJyoukenEnum.ページコント縦覧.getValue()), 出力条件,
                    ReportIdKeys.投票人名簿抄本_縦覧));
        }
    }

    @Step(投票人名簿抄本帳票出力)
    IBatchFlowCommand creat投票人名簿抄本出力() {
        return loopBatch(TohyoninMeiboShohonReportProcess.class).arguments(selectProcessParameter).define();
    }

    private void 投票人名簿登録者数リスト() {
        if (getParameter().get投票人名簿登録者数リスト出力有無()) {
            executeStep(投票人名簿登録者数リスト一時テーブル作成);
            executeStep(投票人名簿登録者数リスト出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit投票人名簿登録者数リスト出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 投票人名簿登録者数リスト出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト));
            if (getParameter().get不在者投票資格者分出力有無()) {
                帳票ID = ReportIdKeys.登録者数リスト不在者投票資格者分.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(登録者数リスト不在者分一時テーブル作成);
                executeStep(登録者数リスト不在者分帳票出力);
                出力条件 = new ArrayList<>();
                出力条件 = edit不在者投票資格者名簿出力条件(出力条件);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 投票人名簿登録者数リスト出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.登録者数リスト不在者投票資格者分));
            }

        }
    }

    @Step(投票人名簿登録者数リスト一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト一時テーブル() {
        return loopBatch(TorokushasuListDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票人名簿登録者数リスト出力)
    IBatchFlowCommand get登録者数リスト帳票出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(投票人名簿登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.set選挙種類(getResult(SenkyoShurui.class,
                new RString(投票人名簿登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_SENKYO_SHURUI));
        return loopBatch(TorokushasuListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(登録者数リスト不在者分一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト不在者分一時テーブル() {
        return loopBatch(TorokushasuListFuzaiShikakuDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(登録者数リスト不在者分帳票出力)
    IBatchFlowCommand get登録者数リスト不在者分帳票出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(登録者数リスト不在者分一時テーブル作成), TorokushasuListFuzaiShikakuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.set選挙種類(getResult(SenkyoShurui.class,
                new RString(登録者数リスト不在者分一時テーブル作成), TorokushasuListFuzaiShikakuDataSelectProcess.OUT_SENKYO_SHURUI));
        return loopBatch(TorokushasuListFuzaiShikakuReportProcess.class).arguments(selectProcessParameter)
                .define();
    }

    private void 不在資格対象者名簿() {
        if (getParameter().get投票人名簿登録者数リスト出力有無()
                && getParameter().get不在資格対象者名簿出力有無()) {
            帳票ID = ReportIdKeys.不在資格対象者名簿.value();
            aFABTB101SelectParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(不在資格対象者名簿帳票出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit不在資格対象者名簿出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 不在資格対象者名簿帳票出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.不在資格対象者名簿));
        }
    }

    @Step(不在資格対象者名簿帳票出力)
    IBatchFlowCommand get不在資格対象者名簿帳票出力() {
        return loopBatch(FuzaiShikakushaMeiboReportprocess.class).arguments(aFABTB101SelectParameter).define();
    }

    private void 一号資格登録通知() {
        if (getParameter().get一号資格登録通知出力有無()) {
            executeStep(一号資格登録通知出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit一号資格登録通知出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 一号資格登録通知出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG111_1号資格登録通知_様式1));

        }
    }

    @Step(一号資格登録通知出力)
    IBatchFlowCommand createIchigoShikakuTorokuTsuchiReportProcess() {
        return loopBatch(IchigoShikakuTorokuTsuchiReportProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 一号資格登録通知一覧表() {
        if (getParameter().get一号資格登録通知出力有無()
                && getParameter().get一号資格登録通知一覧表出力有無()) {
            executeStep(一号資格登録通知一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit一号資格登録通知一覧表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 一号資格登録通知一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG112_1号資格登録通知一覧表));
        }
    }

    @Step(一号資格登録通知一覧表出力)
    IBatchFlowCommand createIchigoShikakuTorokuTsuchiListProcess() {
        return loopBatch(IchigoShikakuTorokuTsuchiListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 一号資格登録通知送付先宛名シール() {
        if (getParameter().get一号資格登録通知出力有無()
                && getParameter().get送付先宛名シール出力有無_1号資格()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit送付先宛名シール1号資格登録通知出力条件(出力条件);
            if (is12面) {
                executeStep(宛名シール1号資格登録通知12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール1号資格登録通知12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_宛名シール1号資格登録通知));
            } else {
                executeStep(宛名シール1号資格登録通知21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール1号資格登録通知21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_宛名シール1号資格登録通知));
            }
        }
    }

    @Step(宛名シール1号資格登録通知12面)
    IBatchFlowCommand get宛名シール1号資格登録通知12面() {
        return loopBatch(IchigoShikakuTorokuTsuchiAtenaSeal12Process.class).arguments(selectProcessParameter).define();
    }

    @Step(宛名シール1号資格登録通知21面)
    IBatchFlowCommand get宛名シール1号資格登録通知21面() {
        return loopBatch(IchigoShikakuTorokuTsuchiAtenaSeal21Process.class).arguments(selectProcessParameter).define();
    }

    private void 二号資格調査票照会() {
        if (getParameter().get二号資格調査票出力有無()) {
            executeStep(二号資格調査票照会出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit二号資格調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 二号資格調査票照会出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG113_2号資格調査票_照会));
        }
    }

    @Step(二号資格調査票照会出力)
    IBatchFlowCommand createNigoShikakuChosahyoShokaiProcess() {
        return loopBatch(NigoShikakuChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 二号資格調査票回答() {
        if (getParameter().get二号資格調査票出力有無()) {
            executeStep(二号資格調査票回答出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit二号資格調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 二号資格調査票回答出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG114_2号資格調査票_回答));
        }
    }

    @Step(二号資格調査票回答出力)
    IBatchFlowCommand createNigoShikakuChosahyoKaitoProcess() {
        return loopBatch(NigoShikakuChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();

    }

    private void 二号資格調査一覧表() {
        if (getParameter().get二号資格調査票出力有無()
                && getParameter().get二号資格調査一覧表出力有無()) {
            executeStep(二号資格調査一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit二号資格調査一覧表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 二号資格調査一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG112_2号資格調査一覧表));
        }
    }

    @Step(二号資格調査一覧表出力)
    IBatchFlowCommand createNiGoShikakuTorokuTsuchiListProcess() {
        return loopBatch(NigoShikakuChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 二号資格調査票送付先宛名シール() {
        if (getParameter().get二号資格調査票出力有無()
                && getParameter().get送付先宛名シール出力有無_2号資格()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit送付先宛名シール2号資格調査票出力条件(出力条件);
            if (is12面) {
                executeStep(宛名シール2号資格調査票12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール2号資格調査票12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_宛名シール2号資格調査票));
            } else {
                executeStep(宛名シール2号資格調査票21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール2号資格調査票21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_宛名シール2号資格調査票));
            }

        }
    }

    @Step(宛名シール2号資格調査票12面)
    IBatchFlowCommand get宛名シール2号資格調査票12面() {
        return loopBatch(NigoShikakuChosahyoAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(宛名シール2号資格調査票21面)
    IBatchFlowCommand get宛名シール2号資格調査票21面() {
        return loopBatch(NigoShikakuChosahyoAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
    }

    private void 二号資格候補者一覧表() {
        if (getParameter().get二号資格候補者一覧表出力有無()) {
            executeStep(二号資格候補者一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit二号資格候補者一覧表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 二号資格候補者一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG116_2号資格候補者一覧表));
        }
    }

    @Step(二号資格候補者一覧表出力)
    IBatchFlowCommand createNigoShikakuKohoshaListProcess() {
        return loopBatch(NigoShikakuKohoshaListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 補正登録者名簿() {
        if (getParameter().get補正登録者名簿出力有無()) {
            executeStep(補正登録者名簿出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit補正登録者名簿出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 補正登録者名簿出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRA105_補正登録者名簿));

        }
    }

    @Step(補正登録者名簿出力)
    IBatchFlowCommand createShinkiTorokushaMeiboKokuminProcess() {
        return loopBatch(ShinkiTorokushaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 補正登録者名簿縦覧() {
        if (getParameter().get補正登録者名簿出力有無()
                && getParameter().get縦覧用も作成する出力有無()) {
            executeStep(補正登録者名簿縦覧出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit補正登録者名簿縦覧用出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 補正登録者名簿縦覧出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRA106_補正登録者名簿縦覧));
        }
    }

    @Step(補正登録者名簿縦覧出力)
    IBatchFlowCommand createShinkiTorokushaMeiboJuranKokuminProcess() {
        return loopBatch(ShinkiTorokushaMeiboJuranKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 補正登録者宛名シール() {
        if (getParameter().get補正登録者名簿出力有無()
                && getParameter().get補正登録者宛名シール出力有無()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit補正登録者宛名シール出力条件(出力条件);
            if (is12面) {
                executeStep(補正登録者宛名シール12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 補正登録者宛名シール12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_補正登録者宛名シール));
            } else {
                executeStep(補正登録者宛名シール21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 補正登録者宛名シール21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_補正登録者宛名シール));
            }

        }
    }

    @Step(補正登録者宛名シール12面)
    IBatchFlowCommand get補正登録者宛名シール12面() {
        return loopBatch(ShinkiTorokushaMeiboKokuminAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(補正登録者宛名シール21面)
    IBatchFlowCommand get補正登録者宛名シール21面() {
        return loopBatch(ShinkiTorokushaMeiboKokuminAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
    }

    private void 抹消者名簿() {
        if (getParameter().get抹消者名簿出力有無()) {
            executeStep(抹消者名簿出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit抹消者名簿出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 抹消者名簿出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRA105_抹消者名簿));
        }
    }

    @Step(抹消者名簿出力)
    IBatchFlowCommand createMasshoshaMeiboKokuminProcess() {
        return loopBatch(MasshoshaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 抹消者名簿縦覧() {
        if (getParameter().get抹消者名簿出力有無()
                && getParameter().get縦覧用も作成する出力有無_抹消者()) {
            executeStep(抹消者名簿縦覧出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit抹消者名簿縦覧用出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 抹消者名簿縦覧出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRA106_抹消者名簿縦覧));

        }
    }

    @Step(抹消者名簿縦覧出力)
    IBatchFlowCommand createMasshoshaMeiboJuranKokuminProcess() {
        return loopBatch(MasshoshaMeiboJuranKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 訂正者名簿() {
        if (getParameter().get訂正者名簿出力有無()) {
            executeStep(訂正者名簿出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit訂正者名簿出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 訂正者名簿出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRA108_訂正者名簿));
        }
    }

    @Step(訂正者名簿出力)
    IBatchFlowCommand createTeiseishaMeiboKokuminProcess() {
        return loopBatch(TeiseishaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 未登録者抹消通知() {
        if (getParameter().get未登録者抹消通知出力有無()) {
            executeStep(未登録者抹消通知出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit未登録者抹消通知出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 未登録者抹消通知出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRG117_未登録者抹消通知));
        }
    }

    @Step(未登録者抹消通知出力)
    IBatchFlowCommand createMitorokushaMasshoTsuchiProcess() {
        return loopBatch(MitorokushaMasshoTsuchiProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 未登録者抹消通知一覧表() {
        if (getParameter().get未登録者抹消通知出力有無()
                && getParameter().get未登録者抹消通知一覧出力有無()) {
            executeStep(未登録者抹消通知一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit未登録者抹消通知一覧出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 未登録者抹消通知一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.未登録者抹消通知一覧表));
        }
    }

    @Step(未登録者抹消通知一覧表出力)
    IBatchFlowCommand createMitorokushaMasshoTsuchiListProcess() {
        return loopBatch(MitorokushaMasshoTsuchiListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 未登録者抹消通知送付先宛名シール() {
        if (getParameter().get未登録者抹消通知出力有無()
                && getParameter().get送付先宛名シール出力有無_未登録者抹消()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit送付先宛名シール未登録者抹消通知出力条件(出力条件);
            if (is12面) {
                executeStep(宛名シール未登録者抹消通知12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール未登録者抹消通知12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_宛名シール未登録者抹消通知));
            } else {
                executeStep(宛名シール未登録者抹消通知21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール未登録者抹消通知21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_宛名シール未登録者抹消通知));
            }

        }
    }

    @Step(宛名シール未登録者抹消通知12面)
    IBatchFlowCommand get宛名シール未登録者抹消通知12面() {
        return loopBatch(MitorokushaMasshoTsuchiAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(宛名シール未登録者抹消通知21面)
    IBatchFlowCommand get宛名シール未登録者抹消通知21面() {
        return loopBatch(MitorokushaMasshoTsuchiAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
    }

    private void 国内転入者調査票照会() {
        if (getParameter().get国内転入者調査票出力有無()) {
            executeStep(国内転入者調査票照会出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国内転入者調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国内転入者調査票照会出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国内転入者調査票照会));
        }
    }

    @Step(国内転入者調査票照会出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoShokaiProcess() {
        return loopBatch(KokunaiTennyushaChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国内転入者調査票回答() {
        if (getParameter().get国内転入者調査票出力有無()) {
            executeStep(国内転入者調査票回答出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国内転入者調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国内転入者調査票回答出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国内転入者調査票回答));
        }
    }

    @Step(国内転入者調査票回答出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoKaitoProcess() {
        return loopBatch(KokunaiTennyushaChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国内転入者調査一覧表() {
        if (getParameter().get国内転入者調査票出力有無()
                && getParameter().get国内転入者調査一覧表出力有無()) {
            executeStep(国内転入者調査一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国内転入者調査一覧表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国内転入者調査一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国内転入者調査一覧表));
        }
    }

    @Step(国内転入者調査一覧表出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoListProcess() {
        return loopBatch(KokunaiTennyushaChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国内転入者調査票送付先宛名シール() {
        if (getParameter().get国内転入者調査票出力有無()
                && getParameter().get送付先宛名シール出力有無_国内転入者調査票()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit送付先宛名シール国内転入者調査票出力条件(出力条件);
            if (is12面) {
                executeStep(宛名シール国内転入者調査票12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール国内転入者調査票12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_宛名シール国内転入者調査票));
            } else {
                executeStep(宛名シール国内転入者調査票21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール国内転入者調査票21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_宛名シール国内転入者調査票));
            }
        }
    }

    @Step(宛名シール国内転入者調査票12面)
    IBatchFlowCommand get宛名シール国内転入者調査票12面() {
        return loopBatch(KokunaiTennyushaChosahyoAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(宛名シール国内転入者調査票21面)
    IBatchFlowCommand get宛名シール国内転入者調査票21面() {
        return loopBatch(KokunaiTennyushaChosahyoAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
    }

    private void 国外転入者調査票照会() {
        if (getParameter().get国外転入者調査票出力有無()) {
            executeStep(国外転入者調査票照会出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国外転入者調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国外転入者調査票照会出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国外転入者調査票照会));
        }
    }

    @Step(国外転入者調査票照会出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoShokaiProcess() {
        return loopBatch(KokugaiTennyushaChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国外転入者調査票回答() {
        if (getParameter().get国外転入者調査票出力有無()) {
            executeStep(国外転入者調査票回答出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国外転入者調査票出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国外転入者調査票回答出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国外転入者調査票回答));
        }
    }

    @Step(国外転入者調査票回答出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoKaitoProcess() {
        return loopBatch(KokugaiTennyushaChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国外転入者調査一覧表() {
        if (getParameter().get国外転入者調査票出力有無()
                && getParameter().get国外転入者調査一覧表出力有無()) {
            executeStep(国外転入者調査一覧表出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit国外転入者調査一覧表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 国外転入者調査一覧表出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.国外転入者調査一覧表));
        }
    }

    @Step(国外転入者調査一覧表出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoListProcess() {
        return loopBatch(KokugaiTennyushaChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    private void 国外転入者調査票送付先宛名シール() {
        if (getParameter().get国外転入者調査票出力有無()
                && getParameter().get送付先宛名シール出力有無_国外転入者調査票()) {
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit送付先宛名シール国外転入者調査票出力条件(出力条件);
            if (is12面) {
                executeStep(宛名シール国外転入者調査票12面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール国外転入者調査票12面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE213_宛名シール国外転入者調査票));
            } else {
                executeStep(宛名シール国外転入者調査票21面);
                reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                        getResult(Integer.class, 宛名シール国外転入者調査票21面, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                        ReportIdKeys.AFAPRE214_宛名シール国外転入者調査票));
            }
        }
    }

    @Step(宛名シール国外転入者調査票12面)
    IBatchFlowCommand get宛名シール国外転入者調査票12面() {
        return loopBatch(KokugaiTennyushaChosahyoAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(宛名シール国外転入者調査票21面)
    IBatchFlowCommand get宛名シール国外転入者調査票21面() {
        return loopBatch(KokugaiTennyushaChosahyoAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
    }

    private void 在外投票人名簿抄本() {
        if (getParameter().get在外投票人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.AFAPRB300_在外投票人名簿抄本.value();
            aFABTB101SelectParameter.setSort(get在外ソート順WithMaster(帳票ID));
            executeStep(在外投票人名簿抄本出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit在外投票人名簿抄本出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 在外投票人名簿抄本出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRB300_在外投票人名簿抄本));
        }
    }

    @Step(在外投票人名簿抄本出力)
    IBatchFlowCommand createMeiboShohonZaigaiProcess() {
        return loopBatch(MeiboShohonZaigaiReportProcess.class).arguments(aFABTB101SelectParameter).define();
    }

    private void 在外投票資格者名簿() {
        if (getParameter().get在外投票資格者名簿出力有無()) {
            executeStep(在外投票資格者名簿出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit在外投票資格者名簿出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 在外投票資格者名簿出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRB309_在外投票資格者名簿));

        }
    }

    @Step(在外投票資格者名簿出力)
    IBatchFlowCommand createZaigaiShikakushaMeiboProcess() {
        // TODO
        return null;
    }

    private void 在外投票管理表出力() {
        if (getParameter().get在外投票管理表出力有無()) {
            帳票ID = ReportIdKeys.AFAPRB310_在外選挙投票管理表.value();
            selectProcessParameter.setSort(get在外ソート順(帳票ID));
            executeStep(在外投票管理表帳票出力);
            List<RString> 出力条件 = new ArrayList<>();
            出力条件 = edit在外投票管理表出力条件(出力条件);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 在外投票管理表帳票出力, ShutsuRyokuJyoukenEnum.ページコント.getValue()), 出力条件,
                    ReportIdKeys.AFAPRB310_在外投票管理表));
        }
    }

    @Step(在外投票管理表帳票出力)
    IBatchFlowCommand createTohyoKanrihyoProcess() {
        // TODO
        return null;
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数,
            List<RString> 出力条件,
            ReportIdKeys reportId) {
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件リスト = edit国民投票帳票再発行出力条件();
        出力条件リスト.addAll(出力条件);
        return new ReportOutputJokenhyoItem(reportId.value(), 地方公共団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, ShutsuRyokuJyoukenEnum.CSV出力有無_有り.getValue(), csvファイル名, 出力条件リスト);
    }

    private List<RString> edit国民投票帳票再発行出力条件() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_抄本名.getValue().concat(getParameter().get抄本名()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_投票日.getValue().concat(edit日時(getParameter().get投票日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_基準日.getValue().concat(edit日時(getParameter().get基準日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_名簿登録日.getValue().concat(edit日時(getParameter().get名簿登録日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_年齢期限日.getValue().concat(edit日時(getParameter().get年齢到達日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_特定期間開始日.getValue().concat(edit日時(getParameter().get特定期間開始日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_特定期限日.getValue().concat(edit日時(getParameter().get特定期限日())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_受付開始日.getValue().concat(edit日時(getParameter().get受付開始日())));
        return 出力条件リスト;
    }

    private List<RString> edit投票人名簿抄本出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_投票人名簿抄本.getValue().concat(
                getParameter().get投票人名簿抄本出力有無() != null
                && getParameter().get投票人名簿抄本出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit投票人名簿登録者数リスト出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_投票人名簿登録者数リスト.getValue().concat(
                getParameter().get投票人名簿登録者数リスト出力有無() != null
                && getParameter().get投票人名簿登録者数リスト出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_時点日.getValue().concat(edit日時(getParameter().get特定期限日())));
        return 出力条件リスト;
    }

    private List<RString> edit不在者投票資格者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_不在者投票資格者分も作成する.getValue().concat(
                getParameter().get不在者投票資格者分出力有無() != null
                && getParameter().get不在者投票資格者分出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit不在資格対象者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_不在資格対象者名簿も作成する.getValue().concat(
                getParameter().get不在資格対象者名簿出力有無() != null
                && getParameter().get不在資格対象者名簿出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit一号資格登録通知出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_1号資格登録通知出力有無.getValue().concat(
                getParameter().get一号資格登録通知出力有無() != null
                && getParameter().get一号資格登録通知出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行日.getValue().concat(edit日時(getParameter().get発行日_1号資格登録())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行番号.getValue()
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の第_1号資格()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の番号_1号資格()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の号_1号資格())));
        return 出力条件リスト;
    }

    private List<RString> edit一号資格登録通知一覧表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_1号資格登録通知一覧表.getValue().concat(
                getParameter().get一号資格登録通知一覧表出力有無() != null
                && getParameter().get一号資格登録通知一覧表出力有無() ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit二号資格調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_2号資格調査票出力有無.getValue().concat(
                getParameter().get二号資格調査票出力有無() != null
                && getParameter().get二号資格調査票出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行日.getValue().concat(edit日時(getParameter().get発行日_2号資格())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行番号.getValue()
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の第_2号資格()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の番号_2号資格()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の号_2号資格())));
        return 出力条件リスト;
    }

    private List<RString> edit二号資格調査一覧表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_2号資格調査一覧表.getValue().concat(
                getParameter().get二号資格調査一覧表出力有無() != null
                && getParameter().get二号資格調査一覧表出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit二号資格候補者一覧表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_2号資格候補者一覧表.getValue().concat(
                getParameter().get二号資格候補者一覧表出力有無() != null
                && getParameter().get二号資格候補者一覧表出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit補正登録者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_補正登録者名簿.getValue().concat(
                getParameter().get補正登録者名簿出力有無() != null
                && getParameter().get補正登録者名簿出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit補正登録者名簿縦覧用出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_縦覧用も作成する.getValue().concat(
                getParameter().get縦覧用も作成する出力有無() != null
                && getParameter().get縦覧用も作成する出力有無() ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit抹消者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_抹消者名簿.getValue().concat(
                getParameter().get抹消者名簿出力有無() != null
                && getParameter().get抹消者名簿出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_抹消日.getValue().concat(edit日時(getParameter().get抹消日())));
        return 出力条件リスト;
    }

    private List<RString> edit抹消者名簿縦覧用出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_縦覧用も作成する.getValue().concat(
                getParameter().get縦覧用も作成する出力有無_抹消者() != null
                && getParameter().get縦覧用も作成する出力有無_抹消者()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit訂正者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_訂正者名簿.getValue().concat(
                getParameter().get訂正者名簿出力有無() != null
                && getParameter().get訂正者名簿出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()
        ));
        return 出力条件リスト;
    }

    private List<RString> edit未登録者抹消通知出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_未登録者抹消通知.getValue().concat(
                getParameter().get未登録者抹消通知出力有無() != null
                && getParameter().get未登録者抹消通知出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行日.getValue().concat(edit日時(getParameter().get発行日_未登録者抹消())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行番号.getValue()
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の第_未登録者抹消()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の番号_未登録者抹消()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の号_未登録者抹消())));
        return 出力条件リスト;
    }

    private List<RString> edit未登録者抹消通知一覧出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_未登録者抹消通知一覧.getValue().concat(
                getParameter().get未登録者抹消通知一覧出力有無() != null
                && getParameter().get未登録者抹消通知一覧出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit国内転入者調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_国内転入者調査票.getValue().concat(
                getParameter().get国内転入者調査票出力有無() != null
                && getParameter().get国内転入者調査票出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行日.getValue().concat(edit日時(getParameter().get発行日_国内転入者調査票())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行番号.getValue()
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の第_国内転入者調査票()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の番号_国内転入者調査票()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の号_国内転入者調査票())));
        return 出力条件リスト;
    }

    private List<RString> edit国内転入者調査一覧表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_国内転入者調査一覧表.getValue().concat(
                getParameter().get国内転入者調査一覧表出力有無() != null
                && getParameter().get国内転入者調査一覧表出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit国外転入者調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_国外転入者調査票.getValue().concat(
                getParameter().get国外転入者調査票出力有無() != null
                && getParameter().get国外転入者調査票出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行日.getValue().concat(edit日時(getParameter().get発行日_国外転入者調査票())));
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_発行番号.getValue()
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の第_国外転入者調査票()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の番号_国外転入者調査票()))
                .concat(NullHandler.getNullToRString(getParameter().get発行番号の号_国外転入者調査票())));
        return 出力条件リスト;
    }

    private List<RString> edit国外転入者調査一覧表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_国外転入者調査一覧表.getValue().concat(
                getParameter().get国外転入者調査一覧表出力有無() != null
                && getParameter().get国外転入者調査一覧表出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private RString edit日時(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void バッチ出力条件リスト出力() {
        ReportOutputJokenhyoFactory.createInstance(reportOutputJokenhyoItems).print();
    }

    private RString getソート順WithMaster(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ReportOutputTypeWithMaster.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private List<RString> edit送付先宛名シール1号資格登録通知出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_送付先宛名シールも作成する.getValue().concat(
                getParameter().get送付先宛名シール出力有無_1号資格() != null
                && getParameter().get送付先宛名シール出力有無_1号資格()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit送付先宛名シール2号資格調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_送付先宛名シールも作成する.getValue().concat(
                getParameter().get送付先宛名シール出力有無_2号資格() != null
                && getParameter().get送付先宛名シール出力有無_2号資格()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit補正登録者宛名シール出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_補正登録者宛名シールも作成する.getValue().concat(
                getParameter().get補正登録者宛名シール出力有無() != null
                && getParameter().get補正登録者宛名シール出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit送付先宛名シール未登録者抹消通知出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_送付先宛名シールも作成する.getValue().concat(
                getParameter().get送付先宛名シール出力有無_未登録者抹消() != null
                && getParameter().get送付先宛名シール出力有無_未登録者抹消()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit送付先宛名シール国内転入者調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_送付先宛名シールも作成する.getValue().concat(
                getParameter().get送付先宛名シール出力有無_国内転入者調査票() != null
                && getParameter().get送付先宛名シール出力有無_国内転入者調査票()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit送付先宛名シール国外転入者調査票出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_送付先宛名シールも作成する.getValue().concat(
                getParameter().get送付先宛名シール出力有無_国外転入者調査票() != null
                && getParameter().get送付先宛名シール出力有無_国外転入者調査票()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit在外投票人名簿抄本出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_在外投票人名簿抄本.getValue().concat(
                getParameter().get在外投票人名簿抄本出力有無() != null
                && getParameter().get在外投票人名簿抄本出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit在外投票資格者名簿出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_在外投票資格者名簿.getValue().concat(
                getParameter().get在外投票資格者名簿出力有無() != null
                && getParameter().get在外投票資格者名簿出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private List<RString> edit在外投票管理表出力条件(List<RString> 出力条件リスト) {
        出力条件リスト.add(ShutsuRyokuJyoukenEnum.出力条件_在外投票管理表.getValue().concat(
                getParameter().get在外投票管理表出力有無() != null
                && getParameter().get在外投票管理表出力有無()
                ? ShutsuRyokuJyoukenEnum.出力内容_ON.getValue() : ShutsuRyokuJyoukenEnum.出力内容_OFF.getValue()));
        return 出力条件リスト;
    }

    private RString get在外ソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ZaigaiReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private RString get在外ソート順WithMaster(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ZaigaiReportOutputTypeWithMaster.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }
}
