/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFABTK101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.CreateMeiboTableProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.InsertShikibetsuCodeNoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.InsertShikibetsuCodeYesProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboInsertDbProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboKaikuSenkyoDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboKaikuSenkyoFuzuiDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboSenkyoDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboSenkyoninMeiboDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboShohonDelProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.MeiboShohonKaikuReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.ReadFileInsertProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.SelectShohonNoProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.ShinseishoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101.TorokushasuReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.SenkyojiZaisankuReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibosakuseikaiku.AFABTK101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class AFABTK101_MeiboSakuseiKaikuFlow extends BatchFlowBase<AFABTK101BatchParameter> {

    private AFABTK101SelectProcessParameter selectParameter;

    private static final RString 出力条件_作成方法 = new RString("【作成方法】");
    private static final RString 出力条件_抄本名 = new RString("【抄本名】 ");
    private static final RString 出力条件_基準日 = new RString("【基準日】");
    private static final RString 出力条件_名簿確定日 = new RString("【名簿確定日】 ");
    private static final RString 出力条件_年齢到達日 = new RString("【年齢到達日】 ");
    private static final RString 出力条件_選挙人名簿抄本 = new RString("【選挙人名簿抄本】 ");
    private static final RString 出力条件_登録者数リスト = new RString("【登録者数リスト】 ");
    private static final RString 出力条件_時点日 = new RString("【時点日】 ");

    private static final String 準備データ作成一時テーブル = "準備データ作成一時テーブル";
    private static final String 選挙人名簿抄本作成STR = "選挙人名簿抄本作成";
    private static final String 登録者数リスト作成STR = "登録者数リスト作成";
    private static final String 申請書チェックリスト_出力STR = "申請書チェックリスト_出力";
    private static final String 抄本番号の取得STR = "抄本番号の取得";
    private static final String 一時表の作る_出力STR = "一時表の作る_出力";
    private static final String 一時表の作る_識別コードあるSTR = "一時表の作る_識別コードある";
    private static final String 一時表の作る_識別コードないSTR = "一時表の作る_識別コードない";
    private static final String 抄本データの削除STR = "抄本データの削除";
    private static final String 選挙データの削除STR = "選挙データの削除";
    private static final String 選挙人名簿データの削除STR = "選挙人名簿データの削除";
    private static final String 海区名簿更新日データの削除STR = "海区名簿更新日データの削除";
    private static final String 海区付随情報データの削除STR = "海区付随情報データの削除";
    private static final String 海区選挙人データDB追加STR = "海区選挙人データDB追加";

    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;

    private static final RString ページコント = new RString("pageCount");
    private Association association;
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;

    private List<ShohonNo> 抄本番号List;

    @Override
    protected void prepareConfigData() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        抄本番号List = new ArrayList<>();

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(getParameter().get基準日());
        shikibetsuTaishoPSMSearchKey = build.build();
        selectParameter = getParameter().toAFABTK101SelectProcessParameter(shikibetsuTaishoPSMSearchKey);

    }

    @Override
    protected void defineFlow() {
        executeStep(準備データ作成一時テーブル);
        抄本番号の取得();
        海区付随情報データの削除();
        海区名簿更新日データの削除();
        選挙人名簿データの削除();
        選挙データの削除();
        抄本データの削除();
        海区選挙人データDB追加();
        一時表の作る_出力();
        一時表の作る_識別コードある();
        一時表の作る_識別コードない();
        申請書チェックリスト_出力();
        選挙人名簿抄本作成();
        登録者数リスト作成();
        バッチ出力条件リスト出力();

    }

    @Step(準備データ作成一時テーブル)
    IBatchFlowCommand executCreateMeiboTable() {
        return loopBatch(CreateMeiboTableProcess.class).arguments(selectParameter).define();
    }

    @Step(抄本番号の取得STR)
    IBatchFlowCommand executSelectShohonNo() {
        return loopBatch(SelectShohonNoProcess.class).arguments(selectParameter).define();
    }

    @Step(海区付随情報データの削除STR)
    IBatchFlowCommand executMeiboKaikuSenkyoFuzuiDel() {
        return loopBatch(MeiboKaikuSenkyoFuzuiDelProcess.class).arguments(selectParameter).define();
    }

    @Step(海区名簿更新日データの削除STR)
    IBatchFlowCommand executMeiboKaikuSenkyoDel() {
        return loopBatch(MeiboKaikuSenkyoDelProcess.class).arguments(selectParameter).define();
    }

    @Step(選挙人名簿データの削除STR)
    IBatchFlowCommand executMeiboSenkyoninMeiboDel() {
        return loopBatch(MeiboSenkyoninMeiboDelProcess.class).arguments(selectParameter).define();
    }

    @Step(選挙データの削除STR)
    IBatchFlowCommand executMeiboSenkyoDel() {
        return loopBatch(MeiboSenkyoDelProcess.class).arguments(selectParameter).define();
    }

    @Step(抄本データの削除STR)
    IBatchFlowCommand executMeiboShohonDel() {
        return loopBatch(MeiboShohonDelProcess.class).arguments(selectParameter).define();
    }

    @Step(海区選挙人データDB追加STR)
    IBatchFlowCommand executMeiboInsertDb() {
        selectParameter.setTable(getResult(RString.class,
                new RString(準備データ作成一時テーブル), CreateMeiboTableProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(MeiboInsertDbProcess.class).arguments(selectParameter).define();
    }

    @Step(選挙人名簿抄本作成STR)
    IBatchFlowCommand executMeiboShohonKaikuReport() {
        return loopBatch(MeiboShohonKaikuReportProcess.class).arguments(selectParameter).define();
    }

    @Step(登録者数リスト作成STR)
    IBatchFlowCommand executTorokushasuReport() {
        return loopBatch(TorokushasuReportProcess.class).arguments(selectParameter).define();

    }

    @Step(一時表の作る_出力STR)
    IBatchFlowCommand executReadFileInsert() {
        return loopBatch(ReadFileInsertProcess.class).arguments(selectParameter).define();

    }

    @Step(一時表の作る_識別コードあるSTR)
    IBatchFlowCommand executInsertShikibetsuCodeYesData() {
        selectParameter.setTable(getResult(RString.class,
                new RString(一時表の作る_出力STR), ReadFileInsertProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(InsertShikibetsuCodeYesProcess.class).arguments(selectParameter).define();

    }

    @Step(一時表の作る_識別コードないSTR)
    IBatchFlowCommand executInsertShikibetsuCodeNoData() {
        selectParameter.setTable(getResult(RString.class,
                new RString(一時表の作る_出力STR), ReadFileInsertProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(InsertShikibetsuCodeNoProcess.class).arguments(selectParameter).define();

    }

    @Step(申請書チェックリスト_出力STR)
    IBatchFlowCommand executShinseishoReport() {
        return loopBatch(ShinseishoReportProcess.class).arguments(selectParameter).define();

    }

    private void バッチ出力条件リスト出力() {
        for (ReportOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private void 抄本番号の取得() {
        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(抄本番号の取得STR);
        }
    }

    private void 抄本データの削除() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(抄本データの削除STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())) {
            List<ShohonNo> 抄本_抄本番号List = new ArrayList<>();
            抄本_抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(抄本_抄本番号List);
            executeStep(抄本データの削除STR);
        }
    }

    private void 選挙データの削除() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(選挙データの削除STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())) {
            List<ShohonNo> 選挙_抄本番号List = new ArrayList<>();
            選挙_抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(選挙_抄本番号List);
            executeStep(選挙データの削除STR);
        }
    }

    private void 選挙人名簿データの削除() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(選挙人名簿データの削除STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())) {
            List<ShohonNo> 選挙人名簿_抄本番号List = new ArrayList<>();
            選挙人名簿_抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(選挙人名簿_抄本番号List);
            executeStep(選挙人名簿データの削除STR);
        }
    }

    private void 海区名簿更新日データの削除() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(海区名簿更新日データの削除STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())) {
            List<ShohonNo> 海区名簿_抄本番号List = new ArrayList<>();
            海区名簿_抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(海区名簿_抄本番号List);
            executeStep(海区名簿更新日データの削除STR);
        }
    }

    private void 海区付随情報データの削除() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())) {
            executeStep(海区付随情報データの削除STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())) {
            List<ShohonNo> 海区付随_抄本番号List = new ArrayList<>();
            海区付随_抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(海区付随_抄本番号List);
            executeStep(海区付随情報データの削除STR);
        }
    }

    private void 海区選挙人データDB追加() {
        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.前年度の選挙人名簿から作成.getKey())) {
            executeStep(海区選挙人データDB追加STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.前年度の選挙人名簿から作成.getKey())) {
            抄本番号List.add(new ShohonNo(getParameter().get抄本番号()));
            selectParameter.set抄本番号List(抄本番号List);
            executeStep(海区選挙人データDB追加STR);
        }
    }

    private void 登録者数リスト作成() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().is登録者数リスト出力有無()) {
            帳票ID = ReportIdKeys.AFAPRA103_登録者数リスト海区選挙.value();
            selectParameter.set出力順(getソート順(帳票ID).substring(KaikuNumberEdit.固定数_9.getKey()));
            executeStep(登録者数リスト作成STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 登録者数リスト作成STR, ページコント),
                    ReportIdKeys.AFAPRA103_登録者数リスト海区選挙));
        }
    }

    private void 選挙人名簿抄本作成() {
        if (selectParameter.get抄本番号List() != null && !selectParameter.get抄本番号List().isEmpty()
                && getParameter().is選挙人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value();
            selectParameter.set出力順(getソート順(帳票ID));
            selectParameter.set集計項目IDリスト(get集計項目ID(帳票ID));
            executeStep(選挙人名簿抄本作成STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 選挙人名簿抄本作成STR, ページコント),
                    ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本));
        }

    }

    private void 一時表の作る_出力() {

        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_出力STR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_出力STR);
        }
    }

    private void 一時表の作る_識別コードある() {

        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_識別コードあるSTR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_識別コードあるSTR);
        }
    }

    private void 一時表の作る_識別コードない() {

        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_識別コードないSTR);
        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            executeStep(一時表の作る_識別コードないSTR);
        }
    }

    private void 申請書チェックリスト_出力() {
        if (getParameter().get処理種別().equals(MeiboKaikuEdited.新規処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            帳票ID = ReportIdKeys.AFAPRK101_申請書チェックリスト.value();
            selectParameter.set出力順(getソート順(帳票ID));
            selectParameter.setTable(getResult(RString.class,
                    new RString(一時表の作る_識別コードあるSTR), InsertShikibetsuCodeYesProcess.OUT_TEMP_TABLE_NAME));

            executeStep(申請書チェックリスト_出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 申請書チェックリスト_出力STR, ページコント),
                    ReportIdKeys.AFAPRK101_申請書チェックリスト));

        } else if (getParameter().get処理種別().equals(MeiboKaikuEdited.再処理.getKey())
                && getParameter().get作成方法().equals(MeiboKaikuEdited.ファイルを指定して作成する.getKey())) {
            帳票ID = ReportIdKeys.AFAPRK101_申請書チェックリスト.value();
            selectParameter.set出力順(getソート順(帳票ID));
            selectParameter.setTable(getResult(RString.class,
                    new RString(一時表の作る_識別コードあるSTR), InsertShikibetsuCodeYesProcess.OUT_TEMP_TABLE_NAME));

            executeStep(申請書チェックリスト_出力STR);

            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 申請書チェックリスト_出力STR, ページコント),
                    ReportIdKeys.AFAPRK101_申請書チェックリスト));
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
                帳票名, ページ数, OutputKeys.CSV出力有無_有り.getValue(), csvファイル名, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_作成方法.concat(getParameter().get作成方法()));
        if (getParameter().get抄本番号() != null) {
            出力条件リスト.add(出力条件_抄本名.concat(getParameter().get抄本番号().toString()).concat(OutputKeys.出力内容_連絡符号１.getValue())
                    .concat(getParameter().get抄本名()));
        } else {
            出力条件リスト.add(出力条件_抄本名.concat(RString.EMPTY).concat(OutputKeys.出力内容_連絡符号１.getValue())
                    .concat(getParameter().get抄本名()));
        }

        出力条件リスト.add(出力条件_基準日.concat(getParameter().get基準日().toString()));

        出力条件リスト.add(出力条件_名簿確定日.concat(getParameter().get名簿確定日().toString()));
        出力条件リスト.add(出力条件_年齢到達日.concat(getParameter().get年齢到達日().toString()));
        if (getParameter().is選挙人名簿抄本出力有無()) {
            出力条件リスト.add(出力条件_選挙人名簿抄本.concat(OutputKeys.出力内容_出力.getValue()));
        } else {
            出力条件リスト.add(出力条件_選挙人名簿抄本.concat(OutputKeys.出力内容_出力しない.getValue()));
        }

        if (getParameter().is登録者数リスト出力有無()) {
            出力条件リスト.add(出力条件_登録者数リスト.concat(OutputKeys.出力内容_出力.getValue()));
        } else {
            出力条件リスト.add(出力条件_登録者数リスト.concat(OutputKeys.出力内容_出力しない.getValue()));
        }
        if (!getParameter().get時点日().isEmpty()) {
            出力条件リスト.add(出力条件_時点日.concat(getParameter().get時点日().toString()));
        } else {
            出力条件リスト.add(出力条件_時点日.concat(getParameter().get基準日().toString()));
        }

        return 出力条件リスト;

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

}
