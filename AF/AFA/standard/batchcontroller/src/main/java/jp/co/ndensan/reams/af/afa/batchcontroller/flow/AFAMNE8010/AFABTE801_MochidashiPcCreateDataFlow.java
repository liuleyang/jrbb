/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE8010;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.CodeBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.CodeKanriBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.KanriInfoBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.SenkyoBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.SenkyokuBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.ShohonBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.TohyoJokyoBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.TohyokuBatchProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8010.TojituTohyorituBatchProcess;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.AFABTE801BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.service.core.mochidashipccreatedata.MochidashiPcCreateDataManager;
import jp.co.ndensan.reams.ua.uax.business.core.cautionsha.builder.UaFt400FindeCautionShaMapperParamBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 持出端末用データ作成バッチ処理クラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class AFABTE801_MochidashiPcCreateDataFlow extends BatchFlowBase<AFABTE801BatchParameter> {

    private static final String 選挙ファイル = "選挙ファイル";
    private static final String 投票状況ファイル = "投票状況ファイル";
    private static final String 当日投票率ファイル = "当日投票率ファイル";
    private static final String 抄本ファイル = "抄本ファイル";
    private static final String 投票区ファイル = "投票区ファイル";
    private static final String 管理情報ファイル = "管理情報ファイル";
    private static final String コード管理ファイル = "コード管理ファイル";
    private static final String コードファイル = "コードファイル";
    private static final String 選挙区ファイル = "選挙区ファイル";
    private static List<RString> 選挙パース;
    private static Map<RString, RString> 投票状況パース;
    private static Map<RString, RString> 当日投票率パース;
    private static Map<RString, RString> 抄本パース;
    private static List<RString> 投票区パース;
    private static List<RString> 管理情報パース;
    private static List<RString> コード管理パース;
    private static List<RString> コードパース;
    private static List<RString> 選挙区パース;

    private ShikibetsuTaishoSearchKeyBuilder key;
    private UaFt400FindeCautionShaMapperParamBuilder keyUaFt400;
    private final MochidashiPcCreateDataManager manger = MochidashiPcCreateDataManager.createInstance();
    private Association association;
    private RString shohons;
    private RString shikibeitsuCode;
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    @Override
    protected void prepareConfigData() {
        key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(getParameter().get投票日());
        keyUaFt400 = new UaFt400FindeCautionShaMapperParamBuilder();
        keyUaFt400.set利用区分(MochidashiPcCreateDataEnum.TWO.getRString());
        keyUaFt400.set抽出区分(MochidashiPcCreateDataEnum.ONE.getRString());
        keyUaFt400.set前回抽出日時(RDateTime.of(new RString(getParameter().get投票日().toString()), MochidashiPcCreateDataEnum.HHMMSS.getRString()));
        keyUaFt400.set今回抽出日時(RDateTime.of(new RString(getParameter().get投票日().toString()), MochidashiPcCreateDataEnum.HHMMSS.getRString()));
        keyUaFt400.set注意種類コード(MochidashiPcCreateDataEnum.注意種類コード.getRString());
        association = AssociationFinderFactory.createInstance().getAssociation();
        shohons = manger.select抄本番号By投票日(getParameter().get投票日());
        shikibeitsuCode = RString.EMPTY;
    }

    @Override
    protected void defineFlow() {
        選挙ファイル出力();
        投票区ファイル出力();
        選挙区ファイル出力();
        抄本ファイル出力();
        投票状況ファイル出力();
        当日投票率ファイル出力();
        管理情報ファイル出力();
        コード管理ファイル出力();
        コードファイル出力();
        shikibeitsuCode = shikibeitsuCode.concat(抄本パース.get(MochidashiPcCreateDataEnum.識別コード.getRString()))
                .concat(投票状況パース.get(MochidashiPcCreateDataEnum.識別コード.getRString()))
                .concat(当日投票率パース.get(MochidashiPcCreateDataEnum.識別コード.getRString()));
        抄本パース.remove(MochidashiPcCreateDataEnum.識別コード.getRString());
        投票状況パース.remove(MochidashiPcCreateDataEnum.識別コード.getRString());
        当日投票率パース.remove(MochidashiPcCreateDataEnum.識別コード.getRString());
        toZIP();
        バッチ出力条件リスト出力();
        持出端末状態管理更新();
    }

    private void 選挙ファイル出力() {
        executeStep(選挙ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.選挙マスタ.getRString()));
        選挙パース = getResult(List.class, new RString(選挙ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 投票区ファイル出力() {
        executeStep(投票区ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.投票区マスタ.getRString()));
        投票区パース = getResult(List.class, new RString(投票区ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 選挙区ファイル出力() {
        executeStep(選挙区ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.選挙区マスタ.getRString()));
        選挙区パース = getResult(List.class, new RString(選挙区ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 抄本ファイル出力() {
        executeStep(抄本ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.抄本名_投票区_抄本.getRString()));
        抄本パース = getResult(Map.class, new RString(抄本ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 投票状況ファイル出力() {
        executeStep(投票状況ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.抄本名_投票区_投票状況.getRString()));
        投票状況パース = getResult(Map.class, new RString(投票状況ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 当日投票率ファイル出力() {
        executeStep(当日投票率ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.抄本名_投票区_当日投票率.getRString()));
        当日投票率パース = getResult(Map.class, new RString(当日投票率ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void 管理情報ファイル出力() {
        executeStep(管理情報ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.管理情報.getRString()));
        管理情報パース = getResult(List.class, new RString(管理情報ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void コード管理ファイル出力() {
        executeStep(コード管理ファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.コード管理マスタ.getRString()));
        コード管理パース = getResult(List.class, new RString(コード管理ファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    private void コードファイル出力() {
        executeStep(コードファイル);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(MochidashiPcCreateDataEnum.コードマスタ.getRString()));
        コードパース = getResult(List.class, new RString(コードファイル), MochidashiPcCreateDataEnum.FILE_PATH.getRString());
    }

    @Step(選挙ファイル)
    IBatchFlowCommand
            get選挙ファイル出力() {
        return loopBatch(SenkyoBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(投票区ファイル)
    IBatchFlowCommand
            get投票区ファイル出力() {
        return loopBatch(TohyokuBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(選挙区ファイル)
    IBatchFlowCommand
            get選挙区ファイル出力() {
        return loopBatch(SenkyokuBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(抄本ファイル)
    IBatchFlowCommand
            get抄本ファイル出力() {
        return loopBatch(ShohonBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), keyUaFt400.build())).define();
    }

    @Step(投票状況ファイル)
    IBatchFlowCommand
            get投票状況ファイル出力() {
        return loopBatch(TohyoJokyoBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(当日投票率ファイル)
    IBatchFlowCommand
            get当日投票率ファイル出力() {
        return loopBatch(TojituTohyorituBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(管理情報ファイル)
    IBatchFlowCommand
            get管理情報ファイル出力() {
        return loopBatch(KanriInfoBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(コード管理ファイル)
    IBatchFlowCommand
            getコード管理ファイル出力() {
        return loopBatch(CodeKanriBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    @Step(コードファイル)
    IBatchFlowCommand
            getコードファイル出力() {
        return loopBatch(CodeBatchProcess.class).arguments(getParameter()
                .toProcessParameter(key.getPSM検索キー(), null)).define();
    }

    private void toZIP() {
        for (Map.Entry<RString, RString> entry : 抄本パース.entrySet()) {
            FileSpoolManager fileSpoolManager = new FileSpoolManager(
                    UzUDE0835SpoolOutputType.EucOther,
                    AFAEucEntityId.抄本名_投票区ZIP.getEucEntityId(),
                    UzUDE0831EucAccesslogFileType.Other);
            RString eucOutputFilePath;
            RString key = entry.getKey();
            List<RString> zipPath = new ArrayList();
            zipPath.addAll(選挙パース);
            zipPath.addAll(投票区パース);
            zipPath.addAll(選挙区パース);
            zipPath.addAll(管理情報パース);
            zipPath.addAll(コード管理パース);
            zipPath.addAll(コードパース);
            zipPath.add(entry.getValue());
            if (投票状況パース.containsKey(key)) {
                zipPath.add(投票状況パース.get(key));
                投票状況パース.remove(key);
            }
            if (当日投票率パース.containsKey(key)) {
                zipPath.add(当日投票率パース.get(key));
                当日投票率パース.remove(key);
            }
            eucOutputFilePath
                    = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), key.concat(".zip"));

            RString[] inputFilePaths = new RString[zipPath.size()];
            ZipUtil.createFromFiles(eucOutputFilePath, zipPath.toArray(inputFilePaths));

            fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, eucOutputFilePath);
        }

        for (Map.Entry<RString, RString> entry : 投票状況パース.entrySet()) {
            FileSpoolManager fileSpoolManager = new FileSpoolManager(
                    UzUDE0835SpoolOutputType.EucOther,
                    AFAEucEntityId.抄本名_投票区ZIP.getEucEntityId(),
                    UzUDE0831EucAccesslogFileType.Other);
            RString eucOutputFilePath;
            RString key = entry.getKey();
            List<RString> zipPath = new ArrayList();
            zipPath.addAll(選挙パース);
            zipPath.addAll(投票区パース);
            zipPath.addAll(選挙区パース);
            zipPath.addAll(管理情報パース);
            zipPath.addAll(コード管理パース);
            zipPath.addAll(コードパース);
            zipPath.add(entry.getValue());
            if (当日投票率パース.containsKey(key)) {
                zipPath.add(当日投票率パース.get(key));
                当日投票率パース.remove(key);
            }
            eucOutputFilePath
                    = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), key.concat(".zip"));
            RString[] inputFilePaths = new RString[zipPath.size()];
            ZipUtil.createFromFiles(eucOutputFilePath, zipPath.toArray(inputFilePaths));

            fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, eucOutputFilePath);
        }

        for (Map.Entry<RString, RString> entry : 当日投票率パース.entrySet()) {
            FileSpoolManager fileSpoolManager = new FileSpoolManager(
                    UzUDE0835SpoolOutputType.EucOther,
                    AFAEucEntityId.抄本名_投票区ZIP.getEucEntityId(),
                    UzUDE0831EucAccesslogFileType.Other);
            RString eucOutputFilePath;
            RString key = entry.getKey();
            List<RString> zipPath = new ArrayList();
            zipPath.addAll(選挙パース);
            zipPath.addAll(投票区パース);
            zipPath.addAll(選挙区パース);
            zipPath.addAll(管理情報パース);
            zipPath.addAll(コード管理パース);
            zipPath.addAll(コードパース);
            zipPath.add(entry.getValue());
            eucOutputFilePath
                    = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), key.concat(".zip"));
            RString[] inputFilePaths = new RString[zipPath.size()];
            ZipUtil.createFromFiles(eucOutputFilePath, zipPath.toArray(inputFilePaths));

            fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, eucOutputFilePath);
        }
    }

    private void バッチ出力条件リスト出力() {
        for (ReportOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private void 持出端末状態管理更新() {
        manger.update持出端末状態管理(getParameter().toProcessParameter(key.getPSM検索キー(), null), shikibeitsuCode);
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(RString csvFlieName) {
        RString 帳票ID = new RString("なし");
        RString 導入団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = MochidashiPcCreateDataEnum.なし.getRString();
        RString ページ数 = MochidashiPcCreateDataEnum.ZERO.getRString();
        RString csv出力有無 = MochidashiPcCreateDataEnum.あり.getRString();
        RString csvファイル名 = csvFlieName;
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(MochidashiPcCreateDataEnum.出力条件_投票日.getRString().concat(getParameter().get投票日().wareki().toDateString()));
        出力条件リスト.add(shohons);
        return new ReportOutputJokenhyoItem(帳票ID, 導入団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, csv出力有無, csvファイル名, 出力条件リスト);
    }

}
