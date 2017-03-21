/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE8030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030.ANShohonReadFileInsertProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030.ANTohyoJokyoReadFileInsertProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030.MochidashiPcImportUketsukeDataAccessLogProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030.MochidashiPcJotaiKanriUpdateProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030.TohyoJokyoInsertOrUpdateProcess;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipcimportuketsukedata.AFABTE803BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.NumberEdit;
import jp.co.ndensan.reams.af.afa.definition.core.mochidashipcimportuketsukedata.enumeratedtype.MochidashiPcImportUketsukeDataRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 当日受付データ取込バッチ処理クラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public class AFABTE803_MochidashiPcImportUketsukeDataFlow extends BatchFlowBase<AFABTE803BatchParameter> {

    private static final String 当日受付データ取込抄本ファイル登録 = "当日受付データ取込抄本ファイルデータ登録";
    private static final String 当日受付データ取込投票状況ファイル登録 = "当日受付データ取込投票状況ファイルデータ登録";
    private static final String 当日受付データ取込投票状況登録 = "当日受付データ取込投票状況データ登録";
    private static final String 当日受付データ取込持出端末状態管理更新 = "当日受付データ取込持出端末状態管理データ更新";
    private static final String 当日受付データ取込アクセスログ_出力 = "当日受付データ取込アクセスログ出力";
    private AFABTE803SelectProcessParameter selectProcessParameter;
    private Association association;

    @Override
    protected void prepareConfigData() {
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        association = associationFinder.getAssociation();
        selectProcessParameter = getParameter().toAFABTE803SelectProcessParameter();
    }

    @Override
    protected void defineFlow() {
        executeStep(当日受付データ取込抄本ファイル登録);
        executeStep(当日受付データ取込投票状況ファイル登録);
        executeStep(当日受付データ取込投票状況登録);
        executeStep(当日受付データ取込持出端末状態管理更新);
        executeStep(当日受付データ取込アクセスログ_出力);
        バッチ出力条件リスト出力();
    }

    @Step(当日受付データ取込抄本ファイル登録)
    IBatchFlowCommand execute当日受付データ取込抄本ファイル登録() {
        selectProcessParameter.set抄本ファイル名(edit抄本ファイル名());
        return loopBatch(ANShohonReadFileInsertProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(当日受付データ取込投票状況ファイル登録)
    IBatchFlowCommand execute当日受付データ取込投票状況ファイル登録() {
        selectProcessParameter.set投票状況ファイル名(edit投票状況ファイル名());
        return loopBatch(ANTohyoJokyoReadFileInsertProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(当日受付データ取込投票状況登録)
    IBatchFlowCommand execute当日受付データ取込投票状況登録() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(当日受付データ取込抄本ファイル登録), MochidashiPcImportUketsukeDataRStringEnum.一時テーブル名.getKey()));
        selectProcessParameter.setTable1(getResult(RString.class,
                new RString(当日受付データ取込投票状況ファイル登録), MochidashiPcImportUketsukeDataRStringEnum.一時テーブル名.getKey()));
        return loopBatch(TohyoJokyoInsertOrUpdateProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(当日受付データ取込持出端末状態管理更新)
    IBatchFlowCommand execute当日受付データ取込持出端末状態管理更新() {
        return loopBatch(MochidashiPcJotaiKanriUpdateProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(当日受付データ取込アクセスログ_出力)
    IBatchFlowCommand execute当日受付データ取込アクセスログ出力() {
        return simpleBatch(MochidashiPcImportUketsukeDataAccessLogProcess.class).arguments(selectProcessParameter).define();
    }

    private void バッチ出力条件リスト出力() {
        ReportOutputJokenhyoItem item = getReportOutputJokenhyoItem();
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem() {
        RString 帳票ID = MochidashiPcImportUketsukeDataRStringEnum.出力条件_出力内容.getKey();
        RString 導入団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = MochidashiPcImportUketsukeDataRStringEnum.出力条件_出力内容.getKey();
        RString ページ数 = MochidashiPcImportUketsukeDataRStringEnum.出力条件_出力ページ数.getKey();
        RString csv出力有無 = MochidashiPcImportUketsukeDataRStringEnum.出力条件_出力内容.getKey();
        RString csvファイル名 = MochidashiPcImportUketsukeDataRStringEnum.出力条件_出力内容.getKey();
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_投票日.getKey()
                .concat(edit日時(getParameter().get投票日())));
        出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_投票区.getKey()
                .concat(getParameter().get投票区コード().padZeroToLeft(NumberEdit.固定数_４.getKey())));

        RString 抄本番号リスト = RString.EMPTY;
        if (selectProcessParameter.get抄本番号リスト() != null
                && !selectProcessParameter.get抄本番号リスト().isEmpty()) {
            for (ShohonNo 抄本番号 : selectProcessParameter.get抄本番号リスト()) {
                抄本番号リスト = 抄本番号リスト.concat(抄本番号.toString())
                        .concat(MochidashiPcImportUketsukeDataRStringEnum.出力内容_連絡符号１.getKey());
            }
            if (抄本番号リスト.isEmpty()) {
                出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_抄本番号.getKey());
            } else {
                出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_抄本番号.getKey()
                        .concat(抄本番号リスト.substring(0, 抄本番号リスト.length() - 1)));
            }
        } else {
            出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_抄本番号.getKey());
        }

        if (getParameter().get抄本取込ファイル名() == null
                || !edit抄本ファイル名().equals(getParameter().get抄本取込ファイル名())) {
            出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_抄本ファイル.getKey());
        } else {
            出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_抄本ファイル.getKey()
                    .concat(getParameter().get抄本取込ファイル名()));
        }
        if (getParameter().get投票状況取込ファイル名() == null
                || !edit投票状況ファイル名().equals(getParameter().get投票状況取込ファイル名())) {
            出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_投票状況ファイル.getKey());
        } else {
            出力条件リスト.add(MochidashiPcImportUketsukeDataRStringEnum.出力条件_投票状況ファイル.getKey()
                    .concat(getParameter().get投票状況取込ファイル名()));
        }
        return new ReportOutputJokenhyoItem(帳票ID, 導入団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, csv出力有無, csvファイル名, 出力条件リスト);
    }

    private RString edit日時(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString edit抄本ファイル名() {
        return MochidashiPcImportUketsukeDataRStringEnum.抄本ファイル名_START.getKey()
                .concat(getParameter().get投票日().toString())
                .concat(MochidashiPcImportUketsukeDataRStringEnum.出力内容_連絡符号２.getKey())
                .concat(getParameter().get投票区コード().padZeroToLeft(NumberEdit.固定数_４.getKey()))
                .concat(MochidashiPcImportUketsukeDataRStringEnum.連絡符号_CSV.getKey());
    }

    private RString edit投票状況ファイル名() {
        return MochidashiPcImportUketsukeDataRStringEnum.投票状況ファイル_START.getKey()
                .concat(getParameter().get投票日().toString())
                .concat(MochidashiPcImportUketsukeDataRStringEnum.出力内容_連絡符号２.getKey())
                .concat(getParameter().get投票区コード().padZeroToLeft(NumberEdit.固定数_４.getKey()))
                .concat(MochidashiPcImportUketsukeDataRStringEnum.連絡符号_CSV.getKey());
    }

}
