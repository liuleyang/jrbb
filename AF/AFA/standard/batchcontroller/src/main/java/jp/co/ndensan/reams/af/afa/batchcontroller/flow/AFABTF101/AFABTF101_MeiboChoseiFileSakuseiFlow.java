/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFABTF101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTF101.MeiboChoseiFileSakuseiProcess;
import jp.co.ndensan.reams.af.afa.definition.batchprm.meibochoseifilesakusei.AFABTF101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.doitsujinbutsuchosa.enumeratedtype.DoitsujinbutsuChosaRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.kaiku.SenkyojiKaikuEdit;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibochoseifilesakuse.AFABTF101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 名簿調製用連携ファイル作成する。
 *
 * @reamsid_L AF-0300-020 lis
 */
public class AFABTF101_MeiboChoseiFileSakuseiFlow extends BatchFlowBase<AFABTF101BatchParameter> {

    private AFABTF101SelectProcessParameter selectParameter;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private final List<EucFileOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();

    private static final String 有権者情報を作成する = "有権者情報を作成する";
    private Association association;

    @Override
    protected void prepareConfigData() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        shikibetsuTaishoPSMSearchKey = build.build();
        selectParameter = getParameter().toAFABTF101SelectProcessParameter(shikibetsuTaishoPSMSearchKey);
        association = AssociationFinderFactory.createInstance().getAssociation();

    }

    @Override
    protected void defineFlow() {
        executeStep(有権者情報を作成する);
        バッチ出力条件リスト出力();
    }

    @Step(有権者情報を作成する)
    IBatchFlowCommand executMeiboChoseiFile() {
        return loopBatch(MeiboChoseiFileSakuseiProcess.class).arguments(selectParameter).define();
    }

    private void バッチ出力条件リスト出力() {
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                new RString(getResult(Long.class, new RString(有権者情報を作成する), DoitsujinbutsuChosaRStringEnum.ページコント.getKey()))));
        for (EucFileOutputJokenhyoItem item : reportOutputJokenhyoItems) {
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    private EucFileOutputJokenhyoItem getReportOutputJokenhyoItem(RString 出力ページ数) {
        //RString 日本語ファイル名 = SenkyojiKaikuEdit.日本語ファイル名;
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString csvファイル名 = getParameter().getファイル名();
        List<RString> 出力条件 = get出力条件リスト();

        return new EucFileOutputJokenhyoItem(csvファイル名, 地方公共団体コード, 市町村名, ジョブ番号,
                csvファイル名, AFAEucEntityId.名簿調製用連携ファイル作成.getFileName(), 出力ページ数, 出力条件);
    }

    private List<RString> get出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_抄本番号.concat(getParameter().get抄本番号()));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_ファイル名.concat(getParameter().getファイル名()));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_抽出対象年齢.concat(new RString(getParameter().get抽出対象年齢()))
                .concat(SenkyojiKaikuEdit.出力条件_歳以上));
        出力条件リスト.add(SenkyojiKaikuEdit.出力条件_年齢計算基準日.concat(getParameter().get年齢計算基準日().wareki().toDateString()));

        return 出力条件リスト;
    }

}
