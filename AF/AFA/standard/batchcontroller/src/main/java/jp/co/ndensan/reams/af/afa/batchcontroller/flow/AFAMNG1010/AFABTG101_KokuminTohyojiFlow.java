/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNG1010;

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
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiBatchShutsuryokuJokenhyoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiDataDeleteProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiDataDeleteShohonProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiTourokuDataUpdateSenkyoninMeiboProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010.KokuminTohyojiTourokuDataUpdateZaigaiProcess;
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
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.definition.batchprm.kokuminTohyoji.AFABTG101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国民投票時登録のバッチ処理クラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
public class AFABTG101_KokuminTohyojiFlow extends BatchFlowBase<AFABTG101BatchParameter> {

    private static final String 国民投票時登録データ検索 = "国民投票時登録データ検索";
    private static final String 国民投票時登録データ削除 = "国民投票時登録データ削除";
    private static final String 国民投票時登録削除_抄本 = "国民投票時登録削除_抄本";
    private static final String 国民投票時登録更新_選挙人名簿 = "国民投票時登録データ更新(選挙人名簿)";
    private static final String 国民投票時登録更新_在外 = "国民投票時登録データ更新(在外)";
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
    private static final String バッチ出力条件表 = "バッチ出力条件表";

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
    private AFABTG101BatchPrintProcessParameter printProcessParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private boolean is12面;

    @Override

    protected void prepareConfigData() {

        this.is12面 = AFAConfigKeysValue.宛名シール_面数_12面.isEqual(ConfigKeysAFA.宛名シール_面数);
        selectProcessParameter = getParameter().toAFABTG101SelectProcessParameter();
        printProcessParameter = getParameter().toAFABTG101BatchPrintProcessParameter();
    }

    @Override
    protected void defineFlow() {
        executeStep(国民投票時登録データ検索);
        executeStep(国民投票時登録データ削除);
        executeStep(国民投票時登録削除_抄本);
        executeStep(国民投票時登録更新_選挙人名簿);
        executeStep(国民投票時登録更新_在外);

        投票人名簿抄本出力();
        投票人名簿登録者数リスト();
        一号資格登録通知();
        二号資格調査票();
        二号資格候補者一覧表();
        補正登録者名簿();
        抹消者名簿();
        訂正者名簿();
        未登録者抹消通知();
        国内転入者調査票();
        国外転入者調査票();
        在外投票人名簿抄本();
        在外投票資格者名簿();
        在外投票管理表出力();
        executeStep(バッチ出力条件表);
    }

    private void 国外転入者調査票() {
        if (getParameter().is国外転入者調査票出力有無()) {
            executeStep(国外転入者調査票回答出力);
            printProcessParameter.set国外転入者調査票回答出力数(getResult(Integer.class,
                    new RString(国外転入者調査票回答出力), KokugaiTennyushaChosahyoKaitoProcess.PAGE_COUNT));
            executeStep(国外転入者調査票照会出力);
            printProcessParameter.set国外転入者調査票照会出力数(getResult(Integer.class,
                    new RString(国外転入者調査票照会出力), KokugaiTennyushaChosahyoShokaiProcess.PAGE_COUNT));

            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is送付先宛名シール出力有無_国外転入者調査票()) {
                if (is12面) {
                    executeStep(宛名シール国外転入者調査票12面);
                    printProcessParameter.set国外転入者調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール国外転入者調査票12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(宛名シール国外転入者調査票21面);
                    printProcessParameter.set国外転入者調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール国外転入者調査票21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }
            if (getParameter().is国外転入者調査一覧表出力有無()) {
                executeStep(国外転入者調査一覧表出力);
                printProcessParameter.set国外転入者調査一覧表出力数(getResult(Integer.class,
                        new RString(国外転入者調査一覧表出力), KokugaiTennyushaChosahyoListProcess.PAGE_COUNT));
            }
        }
    }

    private void 国内転入者調査票() {
        if (getParameter().is国内転入者調査票出力有無()) {
            executeStep(国内転入者調査票照会出力);
            printProcessParameter.set国内転入者調査票照会出力数(getResult(Integer.class,
                    new RString(国内転入者調査票照会出力), KokunaiTennyushaChosahyoShokaiProcess.PAGE_COUNT));
            executeStep(国内転入者調査票回答出力);
            printProcessParameter.set国内転入者調査票回答出力数(getResult(Integer.class,
                    new RString(国内転入者調査票回答出力), KokunaiTennyushaChosahyoKaitoProcess.PAGE_COUNT));
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is送付先宛名シール出力有無_国内転入者調査票()) {
                if (is12面) {
                    executeStep(宛名シール国内転入者調査票12面);
                    printProcessParameter.set国内転入者調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール国内転入者調査票12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(宛名シール国内転入者調査票21面);
                    printProcessParameter.set国内転入者調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール国内転入者調査票21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }

            if (getParameter().is国内転入者調査一覧表出力有無()) {
                executeStep(国内転入者調査一覧表出力);
                printProcessParameter.set国内転入者調査一覧表出力数(getResult(Integer.class,
                        new RString(国内転入者調査一覧表出力), KokunaiTennyushaChosahyoListProcess.PAGE_COUNT));
            }
        }
    }

    private void 在外投票資格者名簿() {
        // TODO #98178関連修正未対応（定時、選挙時、国民投票登録のバッチ）
    }

    private void 在外投票人名簿抄本() {
        if (getParameter().is在外投票人名簿抄本出力有無()) {
            executeStep(在外投票人名簿抄本出力);
            printProcessParameter.set在外投票人名簿抄本出力数(getResult(Integer.class,
                    new RString(在外投票人名簿抄本出力), MeiboShohonZaigaiReportProcess.PAGE_COUNT));
        }
    }

    private void 抹消者名簿() {
        if (getParameter().is抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.AFAPRA105_抹消者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(抹消者名簿出力);
            printProcessParameter.set抹消者名簿出力数(getResult(Integer.class,
                    new RString(抹消者名簿出力), MasshoshaMeiboKokuminProcess.PAGE_COUNT));
            if (getParameter().is縦覧用も作成する出力有無_抹消者()) {
                executeStep(抹消者名簿縦覧出力);
                printProcessParameter.set抹消者名簿縦覧用出力数(getResult(Integer.class,
                        new RString(抹消者名簿縦覧出力), MasshoshaMeiboJuranKokuminProcess.PAGE_COUNT));
            }
        }
    }

    private void 二号資格候補者一覧表() {
        if (getParameter().is二号資格候補者一覧表出力有無()) {
            executeStep(二号資格候補者一覧表出力);
            printProcessParameter.set二号資格候補者一覧表出力数(getResult(Integer.class,
                    new RString(二号資格候補者一覧表出力), NigoShikakuKohoshaListProcess.PAGE_COUNT));

        }
    }

    private void 二号資格調査票() {
        if (getParameter().is二号資格調査票出力有無()) {
            executeStep(二号資格調査票照会出力);
            printProcessParameter.set二号資格調査票照会出力数(getResult(Integer.class,
                    new RString(二号資格調査票照会出力), NigoShikakuChosahyoShokaiProcess.PAGE_COUNT));
            executeStep(二号資格調査票回答出力);
            printProcessParameter.set二号資格調査票回答出力数(getResult(Integer.class,
                    new RString(二号資格調査票回答出力), NigoShikakuChosahyoKaitoProcess.PAGE_COUNT));
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is送付先宛名シール出力有無_2号資格()) {
                if (is12面) {
                    executeStep(宛名シール2号資格調査票12面);
                    printProcessParameter.set二号資格調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール2号資格調査票12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(宛名シール2号資格調査票21面);
                    printProcessParameter.set二号資格調査票送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール2号資格調査票21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }
            if (getParameter().is二号資格調査一覧表出力有無()) {
                executeStep(二号資格調査一覧表出力);
                printProcessParameter.set二号資格調査一覧表出力数(getResult(Integer.class,
                        new RString(二号資格調査一覧表出力), NigoShikakuChosahyoListProcess.PAGE_COUNT));
            }
        }

    }

    private void 一号資格登録通知() {
        if (getParameter().is一号資格登録通知出力有無()) {
            executeStep(一号資格登録通知出力);
            printProcessParameter.set一号資格登録通知出力数(getResult(Integer.class,
                    new RString(一号資格登録通知出力), IchigoShikakuTorokuTsuchiReportProcess.PAGE_COUNT));
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is送付先宛名シール出力有無_1号資格()) {
                if (is12面) {
                    executeStep(宛名シール1号資格登録通知12面);
                    printProcessParameter.set一号資格登録通知送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール1号資格登録通知12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(宛名シール1号資格登録通知21面);
                    printProcessParameter.set一号資格登録通知送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール1号資格登録通知21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }
            if (getParameter().is一号資格登録通知一覧表出力有無()) {
                executeStep(一号資格登録通知一覧表出力);
                printProcessParameter.set一号資格登録通知一覧表出力数(getResult(Integer.class,
                        new RString(一号資格登録通知一覧表出力), IchigoShikakuTorokuTsuchiListProcess.PAGE_COUNT));
            }

        }
    }

    private void 投票人名簿登録者数リスト() {
        if (getParameter().is投票人名簿登録者数リスト出力有無()) {
            帳票ID = ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(投票人名簿登録者数リスト一時テーブル作成);
            executeStep(投票人名簿登録者数リスト出力);
            printProcessParameter.set投票人名簿登録者数リスト出力数(getResult(Integer.class,
                    new RString(投票人名簿登録者数リスト出力), TorokushasuListReportProcess.PAGE_COUNT));
            if (getParameter().is不在者投票資格者分出力有無()) {
                帳票ID = ReportIdKeys.登録者数リスト不在者投票資格者分.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(登録者数リスト不在者分一時テーブル作成);
                executeStep(登録者数リスト不在者分帳票出力);
                printProcessParameter.set不在者投票資格者分出力数(getResult(Integer.class,
                        new RString(登録者数リスト不在者分帳票出力), TorokushasuListFuzaiShikakuReportProcess.PAGE_COUNT));
            }
            if (getParameter().is不在資格対象者名簿出力有無()) {
                帳票ID = ReportIdKeys.不在資格対象者名簿.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(不在資格対象者名簿帳票出力);
                printProcessParameter.set不在資格対象者名簿出力数(getResult(Integer.class,
                        new RString(不在資格対象者名簿帳票出力), FuzaiShikakushaMeiboReportprocess.PAGE_COUNT));
            }
        }
    }

    private void 訂正者名簿() {
        if (getParameter().is訂正者名簿出力有無()) {
            帳票ID = ReportIdKeys.AFAPRA108_訂正者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(訂正者名簿出力);
            printProcessParameter.set訂正者名簿出力数(getResult(Integer.class,
                    new RString(訂正者名簿出力), TeiseishaMeiboKokuminProcess.PAGE_COUNT));
        }
    }

    private void 補正登録者名簿() {
        if (getParameter().is補正登録者名簿出力有無()) {
            帳票ID = ReportIdKeys.AFAPRA105_補正登録者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(補正登録者名簿出力);
            printProcessParameter.set補正登録者名簿出力数(getResult(Integer.class,
                    new RString(補正登録者名簿出力), ShinkiTorokushaMeiboKokuminProcess.PAGE_COUNT));
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is補正登録者宛名シール出力有無()) {
                if (is12面) {
                    executeStep(補正登録者宛名シール12面);
                    printProcessParameter.set補正登録者送付先宛名シール出力数(getResult(Integer.class,
                            new RString(補正登録者宛名シール12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(補正登録者宛名シール21面);
                    printProcessParameter.set補正登録者送付先宛名シール出力数(getResult(Integer.class,
                            new RString(補正登録者宛名シール21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }
            if (getParameter().is縦覧用も作成する出力有無()) {
                帳票ID = ReportIdKeys.AFAPRA106_補正登録者名簿縦覧.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(補正登録者名簿縦覧出力);
                printProcessParameter.set補正登録者名簿縦覧用出力数(getResult(Integer.class,
                        new RString(補正登録者名簿縦覧出力), ShinkiTorokushaMeiboJuranKokuminProcess.PAGE_COUNT));

            }

        }
    }

    private void 未登録者抹消通知() {
        if (getParameter().is未登録者抹消通知出力有無()) {
            executeStep(未登録者抹消通知出力);
            printProcessParameter.set未登録者抹消通知出力数(getResult(Integer.class,
                    new RString(未登録者抹消通知出力), MitorokushaMasshoTsuchiProcess.PAGE_COUNT));
            //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 50 LINES
            if (getParameter().is送付先宛名シール出力有無_未登録者抹消()) {
                if (is12面) {
                    executeStep(宛名シール未登録者抹消通知12面);
                    printProcessParameter.set未登録者抹消通知送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール未登録者抹消通知12面), KokugaiTennyushaChosahyoAtenaSeal12Process.PAGE_COUNT));
                } else {
                    executeStep(宛名シール未登録者抹消通知21面);
                    printProcessParameter.set未登録者抹消通知送付先宛名シール出力数(getResult(Integer.class,
                            new RString(宛名シール未登録者抹消通知21面), KokugaiTennyushaChosahyoAtenaSeal21Process.PAGE_COUNT));
                }
            }
            if (getParameter().is未登録者抹消通知一覧出力有無()) {
                executeStep(未登録者抹消通知一覧表出力);
                printProcessParameter.set未登録者抹消通知一覧出力数(getResult(Integer.class,
                        new RString(未登録者抹消通知一覧表出力), MitorokushaMasshoTsuchiListProcess.PAGE_COUNT));
            }
        }
    }

    private void 投票人名簿抄本出力() {
        if (getParameter().is投票人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.投票人名簿抄本.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(投票人名簿抄本帳票出力);
            printProcessParameter.set投票人名簿抄本出力数(getResult(Integer.class,
                    new RString(投票人名簿抄本帳票出力), TohyoninMeiboShohonReportProcess.PAGE_COUNT));
            printProcessParameter.set投票人名簿抄本縦覧出力数(getResult(Integer.class,
                    new RString(投票人名簿抄本帳票出力), TohyoninMeiboShohonReportProcess.PAGE_COUNT_JURAN));

        }
    }

    private void 在外投票管理表出力() {
        // TODO #98178関連修正未対応（定時、選挙時、国民投票登録のバッチ）
    }

    @Step(国民投票時登録データ検索)
    IBatchFlowCommand getKokuminTohyojiDataSelect() {
        FlexibleDate 検索条件_年齢 = getParameter().get年齢到達日().minusYear(Integer.valueOf(
                BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_国民投票, SubGyomuCode.AFA選挙本体).toString()));
        selectProcessParameter.setAgeForselect(検索条件_年齢);
        return loopBatch(KokuminTohyojiDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(国民投票時登録データ削除)
    IBatchFlowCommand getKokuminTohyojiDataDelete() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(国民投票時登録データ検索), KokuminTohyojiDataSelectProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(KokuminTohyojiDataDeleteProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(国民投票時登録削除_抄本)
    IBatchFlowCommand getKokuminTohyojiDataShohonDelete() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(国民投票時登録データ検索), KokuminTohyojiDataSelectProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(KokuminTohyojiDataDeleteShohonProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(国民投票時登録更新_選挙人名簿)
    IBatchFlowCommand getKokuminTohyojiDataUpdateSenkyoninMeibo() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(国民投票時登録データ検索), KokuminTohyojiDataSelectProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(KokuminTohyojiTourokuDataUpdateSenkyoninMeiboProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(国民投票時登録更新_在外)
    IBatchFlowCommand getKokuminTohyojiDataUpdateZaigai() {
        帳票ID = ReportIdKeys.AFAPRB300_在外投票人名簿抄本.value();
        selectProcessParameter.setSort(get在外ソート順(帳票ID));
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(国民投票時登録データ検索), KokuminTohyojiDataSelectProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(KokuminTohyojiTourokuDataUpdateZaigaiProcess.class).arguments(selectProcessParameter).define();
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

    @Step(二号資格調査一覧表出力)
    IBatchFlowCommand createNiGoShikakuTorokuTsuchiListProcess() {
        return loopBatch(NigoShikakuChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(未登録者抹消通知一覧表出力)
    IBatchFlowCommand createMitorokushaMasshoTsuchiListProcess() {
        return loopBatch(MitorokushaMasshoTsuchiListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(未登録者抹消通知出力)
    IBatchFlowCommand createMitorokushaMasshoTsuchiProcess() {
        return loopBatch(MitorokushaMasshoTsuchiProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国外転入者調査一覧表出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoListProcess() {
        return loopBatch(KokugaiTennyushaChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国内転入者調査一覧表出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoListProcess() {
        return loopBatch(KokunaiTennyushaChosahyoListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国外転入者調査票照会出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoShokaiProcess() {
        return loopBatch(KokugaiTennyushaChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国内転入者調査票照会出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoShokaiProcess() {
        return loopBatch(KokunaiTennyushaChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(補正登録者名簿出力)
    IBatchFlowCommand createShinkiTorokushaMeiboKokuminProcess() {
        return loopBatch(ShinkiTorokushaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(訂正者名簿出力)
    IBatchFlowCommand createTeiseishaMeiboKokuminProcess() {
        return loopBatch(TeiseishaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(投票人名簿登録者数リスト一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト一時テーブル() {
        return loopBatch(TorokushasuListDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票人名簿抄本帳票出力)
    IBatchFlowCommand get投票人名簿抄本帳票出力() {
        return loopBatch(TohyoninMeiboShohonReportProcess.class).arguments(selectProcessParameter).define();
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

    @Step(一号資格登録通知出力)
    IBatchFlowCommand createIchigoShikakuTorokuTsuchiReportProcess() {
        return loopBatch(IchigoShikakuTorokuTsuchiReportProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(一号資格登録通知一覧表出力)
    IBatchFlowCommand createIchigoShikakuTorokuTsuchiListProcess() {
        return loopBatch(IchigoShikakuTorokuTsuchiListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(二号資格調査票照会出力)
    IBatchFlowCommand createNigoShikakuChosahyoShokaiProcess() {
        return loopBatch(NigoShikakuChosahyoShokaiProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(二号資格調査票回答出力)
    IBatchFlowCommand createNigoShikakuChosahyoKaitoProcess() {
        return loopBatch(NigoShikakuChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();

    }

    @Step(二号資格候補者一覧表出力)
    IBatchFlowCommand createNigoShikakuKohoshaListProcess() {
        return loopBatch(NigoShikakuKohoshaListProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国内転入者調査票回答出力)
    IBatchFlowCommand createKokunaiTennyushaChosahyoKaitoProcess() {
        return loopBatch(KokunaiTennyushaChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(国外転入者調査票回答出力)
    IBatchFlowCommand createKokugaiTennyushaChosahyoKaitoProcess() {
        return loopBatch(KokugaiTennyushaChosahyoKaitoProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(補正登録者名簿縦覧出力)
    IBatchFlowCommand createShinkiTorokushaMeiboJuranKokuminProcess() {
        return loopBatch(ShinkiTorokushaMeiboJuranKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(抹消者名簿出力)
    IBatchFlowCommand createMasshoshaMeiboKokuminProcess() {
        return loopBatch(MasshoshaMeiboKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(抹消者名簿縦覧出力)
    IBatchFlowCommand createMasshoshaMeiboJuranKokuminProcess() {
        return loopBatch(MasshoshaMeiboJuranKokuminProcess.class).arguments(
                selectProcessParameter).define();
    }

    @Step(在外投票人名簿抄本出力)
    IBatchFlowCommand createMeiboShohonZaigaiProcess() {
        AFABTB101SelectProcessParameter parameter = getAFABTB101SelectProcessParameter();
        parameter.setSort(get在外ソート順WithMaster(ReportIdKeys.AFAPRB300_在外投票人名簿抄本.value()));
        return loopBatch(MeiboShohonZaigaiReportProcess.class).arguments(getAFABTB101SelectProcessParameter()).define();
    }

    @Step(在外投票資格者名簿出力)
    IBatchFlowCommand createZaigaiShikakushaMeiboProcess() {
        // TODO
        return null;
    }

    @Step(在外投票管理表帳票出力)
    IBatchFlowCommand createTohyoKanrihyoProcess() {
        // TODO
        return null;
    }

    @Step(不在資格対象者名簿帳票出力)
    IBatchFlowCommand get不在資格対象者名簿帳票出力() {
        AFABTB101SelectProcessParameter parameter = getAFABTB101SelectProcessParameter();
        parameter.setSort(getソート順WithMaster(ReportIdKeys.不在資格対象者名簿.value()));
        return loopBatch(FuzaiShikakushaMeiboReportprocess.class)
                .arguments(parameter).define();
    }

    @Step(バッチ出力条件表)
    IBatchFlowCommand getバッチ出力条件表() {
        printProcessParameter.set抄本番号(getResult(ShohonNo.class,
                new RString(国民投票時登録削除_抄本), KokuminTohyojiDataDeleteShohonProcess.SHOHON_NO));
        printProcessParameter.setジョブ番号(this.getJobId());
        return simpleBatch(KokuminTohyojiBatchShutsuryokuJokenhyoProcess.class).arguments(printProcessParameter).define();
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

    @Step(宛名シール1号資格登録通知12面)
    IBatchFlowCommand get宛名シール1号資格登録通知12面() {
        return loopBatch(IchigoShikakuTorokuTsuchiAtenaSeal12Process.class).arguments(
                selectProcessParameter).define();
    }

    @Step(宛名シール1号資格登録通知21面)
    IBatchFlowCommand get宛名シール1号資格登録通知21面() {
        return loopBatch(IchigoShikakuTorokuTsuchiAtenaSeal21Process.class).arguments(
                selectProcessParameter).define();
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

    private AFABTB101SelectProcessParameter getAFABTB101SelectProcessParameter() {
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(selectProcessParameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey key = build.build();
        build.setデータ取得区分(DataShutokuKubun.全履歴);
        IShikibetsuTaishoPSMSearchKey keyForAll = build.build();
        return selectProcessParameter.toAFABTB101SelectProcessParameter(key, keyForAll);
    }
}
