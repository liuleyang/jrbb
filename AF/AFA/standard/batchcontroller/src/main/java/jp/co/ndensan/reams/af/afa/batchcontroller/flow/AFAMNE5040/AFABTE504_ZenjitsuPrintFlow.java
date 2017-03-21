/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE5040;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.CreateYukenshasuListTableProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MeiboShohonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.YukenshasuListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.DairiTohyoShukeihyoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.FuzaishaKanribetsuChoshoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.FuzaishaTohyoChoshoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.FuzaishaTohyoYoshiChoshoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.JikanbetsuGokeiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.JikanbetsuTohyoshoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.JimushoriboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.JurijokyoIchiranhyoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.NendaibetsuJokyoShirabeReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.ShisetsuKofuIchiranhyoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.SochishoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.TohyoShukeiBreakCore;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.TohyoShukeiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040.ZenjitsuReportShutsuryokuJokenhyoProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.definition.batchprm.zenjitsuprint.AFABTE504BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103tempTorokushasuListFuzaiShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA103tempTorokushasuListEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104tempYukenshasuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.DbTableType;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.TableExistActionType;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票日前日関連帳票バッチ処理クラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class AFABTE504_ZenjitsuPrintFlow extends BatchFlowBase<AFABTE504BatchParameter> {

    private RString eucFilePath;

    private static final String 登録者数リストデータを書込み = "登録者数リストデータを書込み";
    private static final String 不在者投票資格者分データを書込み = "不在者投票資格者分データを書込み";
    private static final String 有権者数調べデータを書込み = "有権者数調べデータを書込み";
    private static final String 投票集計表帳票 = "投票集計表帳票";
    private static final String 受理状況一覧表帳票 = "受理状況一覧表帳票";
    private static final String 施設交付一覧表帳票 = "施設交付一覧表帳票";
    private static final String 代理投票集計表帳票_期日前 = "代理投票集計表帳票_期日前";
    private static final String 代理投票集計表帳票_不在者 = "代理投票集計表帳票_不在者";
    private static final String 年代別投票状況調べ帳票 = "年代別投票状況調べ帳票";
    private static final String 時間別投票状況表帳票_合計 = "時間別投票状況表帳票_合計";
    private static final String 時間別投票状況表帳票_投票所別 = "時間別投票状況表帳票_投票所別";
    private static final String 事務処理簿帳票_期日前 = "事務処理簿帳票_期日前";
    private static final String 事務処理簿帳票_不在者 = "事務処理簿帳票_不在者";
    private static final String 不在者投票に関する調書25号様式帳票 = "不在者投票に関する調書25号様式帳票";
    private static final String 不在者投票用紙等の調書帳票 = "不在者投票用紙等の調書帳票";
    private static final String 不在者投票管理者別の調書帳票 = "不在者投票管理者別の調書帳票";
    private static final String 登録者数リスト一時テーブル作成 = "登録者数リスト一時テーブル作成";
    private static final String 登録者数リスト帳票 = "登録者数リスト帳票";
    private static final String 不在者投票資格者分一時テーブル作成 = "不在者投票資格者分一時テーブル作成";
    private static final String 不在者投票資格者分帳票 = "不在者投票資格者分帳票";
    private static final String 有榷者数調べ一時テーブル作成 = "有榷者数調べ一時テーブル作成";
    private static final String 有権者数調べ帳票 = "有権者数調べ帳票";
    private static final String 選挙人名簿抄本帳票 = "選挙人名簿抄本帳票";
    private static final String 送致書帳票 = "送致書帳票出力";
    private static final String バッチ出力条件表 = "バッチ出力条件表";

    private static final RString ページコント = new RString("pageCount");

    private ShikibetsuTaishoSearchKeyBuilder key;
    private AFABTA101SelectProcessParameter selectProcessParameter;
    private AFABTE504BatchPrintProcessParameter batchPrintProcessParameter;
    private Association association;

    @Override
    protected void prepareConfigData() {
        key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        association = AssociationFinderFactory.createInstance().getAssociation();
        batchPrintProcessParameter = getParameter().toAFABTE504BatchPrintProcessParameter();
    }

    @Override
    protected void defineFlow() {
        投票集計表帳票出力();
        受理状況一覧表帳票出力();
        施設交付一覧表帳票出力();
        代理投票集計表帳票出力();
        年代別投票状況調べ帳票出力();
        時間別投票状況表帳票出力();
        事務処理簿帳票出力();
        不在者投票に関する調書25号様式帳票出力();
        不在者投票用紙等の調書帳票出力();
        不在者投票管理者別の調書帳票出力();
        送致書帳票出力();
        登録者数リスト帳票出力();
        有権者数調べ帳票出力();
        選挙人名簿抄本帳票出力();

        executeStep(バッチ出力条件表);
    }

    private void 投票集計表帳票出力() {
        if (getParameter().get投票集計表出力有無()) {
            executeStep(投票集計表帳票);
            batchPrintProcessParameter.set投票集計表出力数(getResult(Integer.class, new RString(投票集計表帳票), ページコント));
        }
    }

    private void 受理状況一覧表帳票出力() {
        if (getParameter().get期日前受理状況一覧表出力有無()) {
            executeStep(受理状況一覧表帳票);
            batchPrintProcessParameter.set受理状況一覧表出力数(getResult(Integer.class, new RString(受理状況一覧表帳票), ページコント));
        }
    }

    private void 施設交付一覧表帳票出力() {
        if (getParameter().get施設交付一覧表出力有無()) {
            executeStep(施設交付一覧表帳票);
            batchPrintProcessParameter.set施設交付一覧表出力数(getResult(Integer.class, new RString(施設交付一覧表帳票), ページコント));
        }
    }

    private void 代理投票集計表帳票出力() {
        if (getParameter().get代理投票集計表出力有無()) {
            if (getParameter().get代理投票集計表期日前投票有無()) {
                executeStep(代理投票集計表帳票_期日前);
                batchPrintProcessParameter.set代理投票集計表_期日前出力数(getResult(Integer.class, new RString(代理投票集計表帳票_期日前), ページコント));
            }
            if (getParameter().get代理投票集計表不在者投票有無()) {
                executeStep(代理投票集計表帳票_不在者);
                batchPrintProcessParameter.set代理投票集計表_不在者出力数(getResult(Integer.class, new RString(代理投票集計表帳票_不在者), ページコント));
            }

        }
    }

    private void 年代別投票状況調べ帳票出力() {
        if (getParameter().get年代別投票状況調べ出力有無()) {
            executeStep(年代別投票状況調べ帳票);
            batchPrintProcessParameter.set年代別投票状況調べ表出力数(getResult(Integer.class, new RString(年代別投票状況調べ帳票), ページコント));
        }
    }

    private void 時間別投票状況表帳票出力() {
        if (getParameter().get時間別投票状況表出力有無()) {
            executeStep(時間別投票状況表帳票_合計);
            batchPrintProcessParameter.set時間別投票状況表合計出力数(getResult(Integer.class, new RString(時間別投票状況表帳票_合計), ページコント));
            executeStep(時間別投票状況表帳票_投票所別);
            batchPrintProcessParameter.set時間別投票状況表投票所別出力数(getResult(Integer.class, new RString(時間別投票状況表帳票_投票所別), ページコント));
        }
    }

    private void 事務処理簿帳票出力() {
        if (getParameter().get事務処理簿出力有無()) {
            if (getParameter().get事務処理簿期日前投票有無()) {
                executeStep(事務処理簿帳票_期日前);
                batchPrintProcessParameter.set事務処理簿_期日前出力数(getResult(Integer.class, new RString(事務処理簿帳票_期日前), ページコント));

            }
            if (getParameter().get事務処理簿不在者投票有無()) {
                executeStep(事務処理簿帳票_不在者);
                batchPrintProcessParameter.set事務処理簿_不在者出力数(getResult(Integer.class, new RString(事務処理簿帳票_不在者), ページコント));
            }
        }
    }

    private void 不在者投票に関する調書25号様式帳票出力() {
        if (getParameter().get不在者投票出力有無()) {
            executeStep(不在者投票に関する調書25号様式帳票);
            batchPrintProcessParameter.set不在者投票に関する調書_25号様式出力数(
                    getResult(Integer.class, new RString(不在者投票に関する調書25号様式帳票), ページコント));
        }
    }

    private void 不在者投票用紙等の調書帳票出力() {
        if (getParameter().get不在者投票用紙調書出力有無()) {
            executeStep(不在者投票用紙等の調書帳票);
            batchPrintProcessParameter.set不在者投票用紙等の調書出力数(getResult(Integer.class, new RString(不在者投票用紙等の調書帳票), ページコント));
        }
    }

    private void 不在者投票管理者別の調書帳票出力() {
        if (getParameter().get不在者投票管理者調書出力有無()) {
            executeStep(不在者投票管理者別の調書帳票);
            batchPrintProcessParameter.set不在者投票管理者別の調書出力数(getResult(Integer.class, new RString(不在者投票管理者別の調書帳票), ページコント));
        }
    }

    private void 送致書帳票出力() {
        if (getParameter().get送致書出力有無()) {
            executeStep(送致書帳票);
            batchPrintProcessParameter.set送致書出力数(getResult(Integer.class, new RString(送致書帳票), ページコント));
        }
    }

    private void 登録者数リスト帳票出力() {
        if (getParameter().get登録者数リスト出力有無()) {
            executeStep(登録者数リスト一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_EUC_FILE_PATH);
            executeStep(登録者数リストデータを書込み);
            executeStep(登録者数リスト帳票);
            batchPrintProcessParameter.set登録者数リスト出力数(getResult(Integer.class, new RString(登録者数リスト帳票), ページコント));
            if (getParameter().get登録者数リスト作成有無()) {
                selectProcessParameter.setSort(getソート順(ReportIdKeys.不在者投票資格者分.value()));
                executeStep(不在者投票資格者分一時テーブル作成);
                eucFilePath = getResult(RString.class, new RString(不在者投票資格者分一時テーブル作成),
                        TorokushasuListFuzaiShikakuDataSelectProcess.OUT_EUC_FILE_PATH);
                executeStep(不在者投票資格者分データを書込み);
                executeStep(不在者投票資格者分帳票);
                batchPrintProcessParameter.set登録者数リスト_不在者投票資格者分出力数(
                        getResult(Integer.class, new RString(不在者投票資格者分帳票), ページコント));
            }
        }
    }

    private void 有権者数調べ帳票出力() {
        if (getParameter().get有権者数調べ出力有無()) {
            executeStep(有榷者数調べ一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(有榷者数調べ一時テーブル作成), CreateYukenshasuListTableProcess.OUT_EUC_FILE_PATH);
            executeStep(有権者数調べデータを書込み);
            executeStep(有権者数調べ帳票);
            batchPrintProcessParameter.set有権者数調べ出力数(
                    getResult(Integer.class, new RString(有権者数調べ帳票), ページコント));
        }
    }

    private void 選挙人名簿抄本帳票出力() {
        if (getParameter().get選挙人名簿抄本出力有無()) {
            executeStep(選挙人名簿抄本帳票);
            batchPrintProcessParameter.set選挙人名簿抄本出力数(
                    getResult(Integer.class, new RString(選挙人名簿抄本帳票), ページコント));
        }
    }

    private RString getOrderBy(RString 帳票ID) {
        RString orderBy = new RString("Order By ");
        if (ReportIdKeys.投票集計表.value().equals(帳票ID)) {
//            orderBy = orderBy.concat(new RString("\"AfT111Senkyo\".\"senkyoNo\",\"AfT112SenkyoninMeibo\".\"tohyokuCode\""));
            orderBy = orderBy.concat(new RString("master.\"afT111Senkyo_senkyoNo\",master.\"afT112SenkyoninMeibo_tohyokuCode\""));
            RString 抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
            if (TohyoShukeiBreakCore.ShohonJushoEditEnum.住所.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
                orderBy = orderBy.concat(",\"ShikibetsuTaisho\".\"jusho\"");
            } else if (TohyoShukeiBreakCore.ShohonJushoEditEnum.行政区.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
                orderBy = orderBy.concat(",\"ShikibetsuTaisho\".\"gyoseikuCode\"");
            } else if (TohyoShukeiBreakCore.ShohonJushoEditEnum.地区コード1.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
                orderBy = orderBy.concat(",\"ShikibetsuTaisho\".\"chikuCode1\"");
            } else if (TohyoShukeiBreakCore.ShohonJushoEditEnum.地区コード2.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
                orderBy = orderBy.concat(",\"ShikibetsuTaisho\".\"chikuCode2\"");
            } else if (TohyoShukeiBreakCore.ShohonJushoEditEnum.地区コード3.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
                orderBy = orderBy.concat(",\"ShikibetsuTaisho\".\"chikuCode3\"");
            }
        } else if (ReportIdKeys.受理状況一覧表.value().equals(帳票ID)) {
//            orderBy = orderBy.concat(new RString("\"AfT112SenkyoninMeibo\".\"tohyokuCode\""));
            orderBy = orderBy.concat(new RString("master.\"afT112SenkyoninMeibo_tohyokuCode\""));
            RString 抄本_冊区分管理 = BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理);
            if (!new RString("0").equals(抄本_冊区分管理)) {
//                orderBy = orderBy.concat(",\"AfT112SenkyoninMeibo\".\"satsu\"");
                orderBy = orderBy.concat(",master.\"afT112SenkyoninMeibo_satsu\"");
            }
//            orderBy = orderBy.concat(",\"AfT112SenkyoninMeibo\".\"page\",\"AfT112SenkyoninMeibo\".\"gyo\"");
            orderBy = orderBy.concat(",master.\"afT112SenkyoninMeibo_page\",master.\"afT112SenkyoninMeibo_gyo\"");
        }
        return orderBy;
    }

    private RString getソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));

        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ReportOutputTypeWithMaster.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    @Step(投票集計表帳票)
    IBatchFlowCommand
            get投票集計表帳票出力() {
        return loopBatch(TohyoShukeiReportProcess.class
        ).arguments(getParameter()
                .to投票集計表ProcessParameter(key.getPSM検索キー(), getOrderBy(ReportIdKeys.投票集計表.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(受理状況一覧表帳票)
    IBatchFlowCommand
            get受理状況一覧表帳票出力() {
        return loopBatch(JurijokyoIchiranhyoReportProcess.class
        ).arguments(getParameter()
                .to受理状況一覧表ProcessParameter(key.getPSM検索キー(), getOrderBy(ReportIdKeys.受理状況一覧表.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(施設交付一覧表帳票)
    IBatchFlowCommand
            get施設交付一覧表帳票出力() {
        return loopBatch(ShisetsuKofuIchiranhyoReportProcess.class
        ).arguments(getParameter()
                .to施設交付一覧表ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.施設交付一覧表.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(代理投票集計表帳票_期日前)
    IBatchFlowCommand
            get代理投票集計表帳票期日前() {
        return loopBatch(DairiTohyoShukeihyoReportProcess.class
        ).arguments(getParameter()
                .to代理投票集計表ProcessParameter(TohyoJokyo.期日前, key.getPSM検索キー(), getソート順(ReportIdKeys.代理投票集計表.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(代理投票集計表帳票_不在者)
    IBatchFlowCommand
            get代理投票集計表帳票不在者() {
        return loopBatch(DairiTohyoShukeihyoReportProcess.class
        ).arguments(getParameter()
                .to代理投票集計表ProcessParameter(TohyoJokyo.受理, key.getPSM検索キー(), getソート順(ReportIdKeys.代理投票集計表.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(年代別投票状況調べ帳票)
    IBatchFlowCommand get年代別投票状況調べ帳票出力() {
        return loopBatch(NendaibetsuJokyoShirabeReportProcess.class
        ).arguments(getParameter()
                .to年代別投票状況調べProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.年代別投票状況調べ.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(時間別投票状況表帳票_合計)
    IBatchFlowCommand
            get時間別投票状況表合計帳票出力() {
        return loopBatch(JikanbetsuGokeiReportProcess.class
        ).arguments(getParameter()
                .to時間別投票状況表合計ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.時間別投票状況表合計.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(時間別投票状況表帳票_投票所別)
    IBatchFlowCommand
            get時間別投票状況表投票所別帳票出力() {
        return loopBatch(JikanbetsuTohyoshoReportProcess.class
        ).arguments(getParameter()
                .to時間別投票状況表投票所別ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.時間別投票状況表投票所別.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(事務処理簿帳票_期日前)
    IBatchFlowCommand
            get事務処理簿帳票期日前出力() {
        return loopBatch(JimushoriboReportProcess.class).arguments(getParameter()
                .to事務処理簿ProcessParameter(Arrays.asList(TohyoJokyo.期日前.getCode()),
                        key.getPSM検索キー(), getソート順(ReportIdKeys.事務処理簿.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(事務処理簿帳票_不在者)
    IBatchFlowCommand
            get事務処理簿帳票不在者出力() {
        return loopBatch(JimushoriboReportProcess.class).arguments(getParameter()
                .to事務処理簿ProcessParameter(Arrays.asList(TohyoJokyo.交付.getCode(), TohyoJokyo.受理.getCode(), TohyoJokyo.返還.getCode()),
                        key.getPSM検索キー(), getソート順(ReportIdKeys.事務処理簿.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(不在者投票に関する調書25号様式帳票)
    IBatchFlowCommand
            get不在者投票に関する調書25号様式帳票出力() {
        return loopBatch(FuzaishaTohyoChoshoReportProcess.class
        ).arguments(getParameter()
                .to不在者投票25号様式ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.不在者投票に関する調書25号様式.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(不在者投票用紙等の調書帳票)
    IBatchFlowCommand
            get不在者投票用紙等の調書帳票出力() {
        return loopBatch(FuzaishaTohyoYoshiChoshoReportProcess.class
        ).arguments(getParameter()
                .to不在者投票用紙調書ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.不在者投票用紙等の調書.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(不在者投票管理者別の調書帳票)
    IBatchFlowCommand
            get不在者投票管理者別の調書帳票出力() {
        return loopBatch(FuzaishaKanribetsuChoshoReportProcess.class
        ).arguments(getParameter()
                .to不在者投票管理者調書ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.不在者投票管理者別の調書.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(送致書帳票)
    IBatchFlowCommand
            get送致書帳票出力() {
        return loopBatch(SochishoReportProcess.class
        ).arguments(getParameter()
                .to送致書ProcessParameter(key.getPSM検索キー(), getソート順(ReportIdKeys.送致書.value()),
                        get地方公共団体コード(), get連番())).define();
    }

    @Step(登録者数リスト一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト一時テーブル() {
        selectProcessParameter = getParameter().to登録者数リストProcessParameter(key.getPSM検索キー());

        return loopBatch(TorokushasuListDataSelectProcess.class
        ).arguments(selectProcessParameter).define();
    }

    @Step(登録者数リストデータを書込み)
    IBatchFlowCommand insert登録者数リスト一時テーブル() {
        return importCsv(eucFilePath, AFAPRA103tempTorokushasuListEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(登録者数リスト帳票)
    IBatchFlowCommand
            get登録者数リスト帳票出力() {
        selectProcessParameter.setTable(AFAPRA103tempTorokushasuListEntity.TEMP_TABLE_NAME);
        return loopBatch(TorokushasuListDataProcess.class
        ).arguments(selectProcessParameter).define();
    }

    @Step(不在者投票資格者分一時テーブル作成)
    IBatchFlowCommand create不在者投票資格者分一時テーブル() {
        return loopBatch(TorokushasuListFuzaiShikakuDataSelectProcess.class).arguments(
                new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(不在者投票資格者分データを書込み)
    IBatchFlowCommand insert不在者投票資格者分一時テーブル() {
        return importCsv(eucFilePath, AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(不在者投票資格者分帳票)
    IBatchFlowCommand get不在者投票資格者分作成有無() {
        selectProcessParameter.setTable(AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME);
        return loopBatch(TorokushasuListFuzaiShikakuReportProcess.class).arguments(
                new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(有榷者数調べ一時テーブル作成)
    IBatchFlowCommand create有権者数調べ一時テーブル() {
        selectProcessParameter = getParameter().to有権者数調べProcessParameter(key.getPSM検索キー());
        return loopBatch(CreateYukenshasuListTableProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者数調べデータを書込み)
    IBatchFlowCommand insert有榷者数調べ一時テーブル() {
        return importCsv(eucFilePath, AFAPRA104tempYukenshasuEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(有権者数調べ帳票)
    IBatchFlowCommand get有権者数調べ帳票出力() {
        selectProcessParameter.setTable(AFAPRA104tempYukenshasuEntity.TEMP_TABLE_NAME);
        return loopBatch(YukenshasuListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿抄本帳票)
    IBatchFlowCommand get選挙人名簿抄本帳票出力() {
        selectProcessParameter = getParameter().to選挙人名簿抄本ProcessParameter(key.getPSM検索キー());
        return loopBatch(MeiboShohonReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(バッチ出力条件表)
    IBatchFlowCommand getバッチ出力条件表() {
        batchPrintProcessParameter.set抄本番号(getParameter().get抄本番号());
        batchPrintProcessParameter.setジョブ番号(this.getJobId());
        return simpleBatch(ZenjitsuReportShutsuryokuJokenhyoProcess.class).arguments(batchPrintProcessParameter).define();
    }

    private RString get地方公共団体コード() {
        return association.get地方公共団体コード().value();
    }

    private int get連番() {
        return association.getLasdecCodeRenban_();
    }

}
