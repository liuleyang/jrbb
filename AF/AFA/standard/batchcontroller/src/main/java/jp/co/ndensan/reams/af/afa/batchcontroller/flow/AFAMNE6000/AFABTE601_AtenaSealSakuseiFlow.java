/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNE6000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000.AtenaSealSakuseiAtenaSeal12ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000.AtenaSealSakuseiAtenaSeal21ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000.AtenaSealSakuseiAtenaSealListReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.AFABTE6010BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAJushomaeTsuikaEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei.AFABTE601SelectProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 宛名シール作成のバッチ処理クラスです。
 *
 * @reamsid_L AF-0620-020 guanyq
 */
public class AFABTE601_AtenaSealSakuseiFlow extends BatchFlowBase<AFABTE6010BatchParameter> {

    private AFABTE601SelectProcessParameter selectProcessParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private static final RString 出力条件_抄本名 = new RString("【抄本名】 ");
    private static final RString 出力条件_住所条件 = new RString("【住所条件】 ");
    private static final RString 出力条件_対象選挙 = new RString("【対象選挙】 ");
    private static final RString 出力条件_対象期間 = new RString("【対象期間】 ");
    private static final RString 出力条件_施設種別 = new RString("【施設種別】 ");
    private static final RString 出力条件_施設 = new RString("【施設】 ");
    private static final RString 出力条件_四隅項目右上隅 = new RString("【四隅項目（右上隅）】 ");
    private static final RString 出力条件_住所 = new RString("【住所】 ");
    private static final RString 出力条件_宛名 = new RString("【宛名】 ");
    private static final RString 出力条件_世帯主敬称 = new RString("【世帯主敬称】 ");
    private static final RString 出力条件_本人敬称 = new RString("【本人敬称】 ");
    private static final RString 出力条件_四隅項目右下隅 = new RString("【四隅項目（右下隅）】 ");
    private static final RString 出力条件_四隅項目左下隅 = new RString("【四隅項目（左下隅）】 ");
    private static final RString 出力条件_住所の前に市町村名を付加 = new RString("【住所の前に市町村名を付加】 ");
    private static final RString 出力条件_世帯主のみ印刷対象とする有無 = new RString("【世帯主のみ印刷対象とする有無】 ");
    private static final RString 出力条件_開始印字位置番号 = new RString("【開始印字位置番号】 ");
    private static final RString 出力内容_連絡符号2 = new RString("：");
    private static final RString 出力内容_連絡符号3 = new RString("～");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString 出力内容_有り = new RString("あり");
    private static final RString 出力内容_無し = new RString("なし");
    private static final String 宛名シール12面_面数出力 = "宛名シール12面";
    private static final String 宛名シール21面_面数出力 = "宛名シール21面";
    private static final String 宛名シール出力対象者一覧_出力 = "宛名シール出力対象者一覧";
    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");

    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private static final RString ページコント = new RString("pageCount");
    private Association association;

    @Override
    protected void prepareConfigData() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        selectProcessParameter = getParameter().toAFABTE601SelectProcessParameter();
    }

    @Override
    protected void defineFlow() {
        宛名シール作成_出力();
        バッチ出力条件リスト出力();
    }

    @Step(宛名シール12面_面数出力)
    IBatchFlowCommand get宛名シール12面_出力() {
        return loopBatch(AtenaSealSakuseiAtenaSeal12ReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(宛名シール21面_面数出力)
    IBatchFlowCommand get宛名シール21面_出力() {
        return loopBatch(AtenaSealSakuseiAtenaSeal21ReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(宛名シール出力対象者一覧_出力)
    IBatchFlowCommand get宛名シール出力対象者一覧_出力() {
        return loopBatch(AtenaSealSakuseiAtenaSealListReportProcess.class).arguments(selectProcessParameter).define();
    }

    private void 宛名シール作成_出力() {
        RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.宛名シール_面数_12面.configKeyValue().equals(宛名シール_面数)) {
            宛名シール12面_出力();
            施宛名シール出力対象者一覧_出力(ReportIdKeys.AFAPRE213_宛名シール12面.value());
        } else if (AFAConfigKeysValue.宛名シール_面数_21面.configKeyValue().equals(宛名シール_面数)) {
            宛名シール21面_出力();
            施宛名シール出力対象者一覧_出力(ReportIdKeys.AFAPRE214_宛名シール21面.value());
        }
    }

    private void 宛名シール12面_出力() {
        帳票ID = ReportIdKeys.AFAPRE213_宛名シール12面.value();
        selectProcessParameter.setOrder順(getソート順(帳票ID));
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(宛名シール12面_面数出力);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 宛名シール12面_面数出力, ページコント),
                ReportIdKeys.AFAPRE213_宛名シール12面));
    }

    private void 宛名シール21面_出力() {
        帳票ID = ReportIdKeys.AFAPRE214_宛名シール21面.value();
        selectProcessParameter.setOrder順(getソート順(帳票ID));
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(宛名シール21面_面数出力);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 宛名シール21面_面数出力, ページコント),
                ReportIdKeys.AFAPRE214_宛名シール21面));
    }

    private void 施宛名シール出力対象者一覧_出力(RString 帳票) {
        帳票ID = ReportIdKeys.AFAPRE215_宛名シール出力対象者一覧.value();
        selectProcessParameter.setOrder順(getソート順(帳票));
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(宛名シール出力対象者一覧_出力);
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 宛名シール出力対象者一覧_出力, ページコント),
                ReportIdKeys.AFAPRE215_宛名シール出力対象者一覧));
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数, ReportIdKeys reportId) {
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件 = new ArrayList<>();
        RString 起動画面ID = getParameter().get起動画面ID();
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            出力条件 = get選挙人宛名シール出力リスト();
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            出力条件 = get転出者宛名シール出力リスト();
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            出力条件 = get施設宛名シール出力リスト();
        }
        return new ReportOutputJokenhyoItem(reportId.value(), 地方公共団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, CSV出力有無_有り, csvファイル名, 出力条件);
    }

    private List<RString> get選挙人宛名シール出力リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        if (RString.isNullOrEmpty(getParameter().get抄本名())) {
            出力条件リスト.add(出力条件_抄本名);
        } else {
            出力条件リスト.add(出力条件_抄本名.concat(getParameter().get抄本名()));
        }
        if (RString.isNullOrEmpty(getParameter().get住所条件())) {
            出力条件リスト.add(出力条件_住所条件);
        } else {
            出力条件リスト.add(出力条件_住所条件.concat(getParameter().get住所条件()));
        }
        if (RString.isNullOrEmpty(getParameter().get四隅項目_右上隅())) {
            出力条件リスト.add(出力条件_四隅項目右上隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目右上隅.concat(getParameter().get四隅項目_右上隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get住所コード名称())) {
            出力条件リスト.add(出力条件_住所);
        } else {
            出力条件リスト.add(出力条件_住所.concat(getParameter().get住所コード名称()));
        }
        if (RString.isNullOrEmpty(getParameter().get宛名コード名称())) {
            出力条件リスト.add(出力条件_宛名);
        } else {
            出力条件リスト.add(出力条件_宛名.concat(getParameter().get宛名コード名称()));
        }
        if (RString.isNullOrEmpty(getParameter().get住所条件())) {
            出力条件リスト.add(出力条件_世帯主敬称);
        } else {
            出力条件リスト.add(出力条件_世帯主敬称.concat(getParameter().get世帯主敬称()));
        }
        if (RString.isNullOrEmpty(getParameter().get本人敬称())) {
            出力条件リスト.add(出力条件_本人敬称);
        } else {
            出力条件リスト.add(出力条件_本人敬称.concat(getParameter().get本人敬称()));
        }
        if (RString.isNullOrEmpty(getParameter().get四隅項目_右下隅())) {
            出力条件リスト.add(出力条件_四隅項目右下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目右下隅.concat(getParameter().get四隅項目_右下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get四隅項目_左下隅())) {
            出力条件リスト.add(出力条件_四隅項目左下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目左下隅.concat(getParameter().get四隅項目_左下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get住所の前に市町村名を付加())) {
            出力条件リスト.add(出力条件_住所の前に市町村名を付加);
        } else {
            出力条件リスト.add(出力条件_住所の前に市町村名を付加
                    .concat(get住所の前に市町村名を付加(getParameter().get住所の前に市町村名を付加())));
        }
        if (getParameter().get世帯主のみ印刷対象とする有無() == null) {
            出力条件リスト.add(出力条件_世帯主のみ印刷対象とする有無);
        } else {
            出力条件リスト.add(出力条件_世帯主のみ印刷対象とする有無
                    .concat(getParameter().get世帯主のみ印刷対象とする有無() ? 出力内容_有り : 出力内容_無し));
        }
        if (RString.isNullOrEmpty(getParameter().get開始印字位置番号())) {
            出力条件リスト.add(出力条件_開始印字位置番号);
        } else {
            出力条件リスト.add(出力条件_開始印字位置番号.concat(getParameter().get開始印字位置番号()));
        }

        return 出力条件リスト;
    }

    private List<RString> get転出者宛名シール出力リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        if (RString.isNullOrEmpty(getParameter().get抄本名())) {
            出力条件リスト.add(出力条件_抄本名);
        } else {
            出力条件リスト.add(出力条件_抄本名.concat(getParameter().get抄本名()));
        }
        出力条件リスト.add(出力条件_対象選挙
                .concat(getParameter().get対象選挙() == null ? RString.EMPTY : getParameter().get対象選挙())
                .concat(出力内容_連絡符号2)
                .concat(getParameter().get対象選挙名称() == null ? RString.EMPTY : getParameter().get対象選挙名称()));
        出力条件リスト.add(出力条件_対象期間
                .concat(edit日時(getParameter().get対象期間FROM()))
                .concat(出力内容_連絡符号3)
                .concat(edit日時(getParameter().get対象期間TO())));
        if (RString.isNullOrEmpty(getParameter().get四隅項目_右上隅())) {
            出力条件リスト.add(出力条件_四隅項目右上隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目右上隅.concat(getParameter().get四隅項目_右上隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get住所コード名称())) {
            出力条件リスト.add(出力条件_住所);
        } else {
            出力条件リスト.add(出力条件_住所.concat(getParameter().get住所コード名称()));
        }
        if (RString.isNullOrEmpty(getParameter().get宛名コード名称())) {
            出力条件リスト.add(出力条件_宛名);
        } else {
            出力条件リスト.add(出力条件_宛名.concat(getParameter().get宛名コード名称()));
        }
        出力条件リスト.add(出力条件_世帯主敬称.concat(getParameter().get世帯主敬称() == null
                ? RString.EMPTY : getParameter().get世帯主敬称()));
        出力条件リスト.add(出力条件_本人敬称.concat(getParameter().get本人敬称() == null
                ? RString.EMPTY : getParameter().get本人敬称()));
        if (RString.isNullOrEmpty(getParameter().get四隅項目_右下隅())) {
            出力条件リスト.add(出力条件_四隅項目右下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目右下隅.concat(getParameter().get四隅項目_右下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get四隅項目_左下隅())) {
            出力条件リスト.add(出力条件_四隅項目左下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目左下隅.concat(getParameter().get四隅項目_左下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get開始印字位置番号())) {
            出力条件リスト.add(出力条件_開始印字位置番号);
        } else {
            出力条件リスト.add(出力条件_開始印字位置番号.concat(getParameter().get開始印字位置番号()));
        }
        return 出力条件リスト;
    }

    private List<RString> get施設宛名シール出力リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_施設種別.concat(getParameter().get施設種別() == null
                ? RString.EMPTY : getParameter().get施設種別()));
        出力条件リスト.add(出力条件_施設
                .concat(null == getParameter().get施設名称FROM() ? RString.EMPTY : getParameter().get施設名称FROM())
                .concat(出力内容_連絡符号3)
                .concat(null == getParameter().get施設名称TO() ? RString.EMPTY : getParameter().get施設名称TO()));
        出力条件リスト.add(出力条件_四隅項目右上隅.concat(getParameter().get四隅項目_右上隅() == null
                ? RString.EMPTY : getParameter().get四隅項目_右上隅()));
        出力条件リスト.add(出力条件_住所.concat(getParameter().get住所コード名称() == null
                ? RString.EMPTY : getParameter().get住所コード名称()));
        出力条件リスト.add(出力条件_宛名.concat(getParameter().get宛名コード名称() == null
                ? RString.EMPTY : getParameter().get宛名コード名称()));
        出力条件リスト.add(出力条件_世帯主敬称.concat(getParameter().get世帯主敬称() == null
                ? RString.EMPTY : getParameter().get世帯主敬称()));
        出力条件リスト.add(出力条件_本人敬称.concat(getParameter().get本人敬称() == null
                ? RString.EMPTY : getParameter().get本人敬称()));
        if (RString.isNullOrEmpty(getParameter().get四隅項目_右下隅())) {
            出力条件リスト.add(出力条件_四隅項目右下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目右下隅.concat(getParameter().get四隅項目_右下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get四隅項目_左下隅())) {
            出力条件リスト.add(出力条件_四隅項目左下隅);
        } else {
            出力条件リスト.add(出力条件_四隅項目左下隅.concat(getParameter().get四隅項目_左下隅()));
        }
        if (RString.isNullOrEmpty(getParameter().get開始印字位置番号())) {
            出力条件リスト.add(出力条件_開始印字位置番号);
        } else {
            出力条件リスト.add(出力条件_開始印字位置番号.concat(getParameter().get開始印字位置番号()));
        }
        return 出力条件リスト;
    }

    private RString get住所の前に市町村名を付加(RString type) {
        if (AFAJushomaeTsuikaEnum.しない.getKey().equals(type)) {
            return AFAJushomaeTsuikaEnum.しない.getValue();
        } else if (AFAJushomaeTsuikaEnum.する.getKey().equals(type)) {
            return AFAJushomaeTsuikaEnum.する.getValue();
        } else if (AFAJushomaeTsuikaEnum.都道府県名から付加.getKey().equals(type)) {
            return AFAJushomaeTsuikaEnum.都道府県名から付加.getValue();
        }
        return RString.EMPTY;
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

    private RString edit日時(RDate date) {
        if (null == date) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
