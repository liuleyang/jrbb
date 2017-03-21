/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNA1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.BatchSyuturyokuJyoukenProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.CreateYukenshasuListTableProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.EikyuMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.HyojiShojoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.HyojishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.KikaTaishoshaListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.KiteiNenreiMaeMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.KyojuMasshoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MasshoshaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MasshoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MeiboShohonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MitotatsushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.NijuTorokuHandanJokenProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.NijuTorokuTsuchishoCommonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.NijuTorokuTsuchishoListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SaiTennyushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SakuinboReport50Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SakuinboReportTouhyo50Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.ShinkiTorokushaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.ShinkiTorokushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TeijiTourokuParamSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TeiseishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TenshutsushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokuTeishishaMeiboProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.YukenshasuListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.FuzaiShikakushaMeiboReportprocess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MeiboShohonZaigaiJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MeiboShohonZaigaiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintteiji.AFABTA103BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103tempTorokushasuListFuzaiShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA103tempTorokushasuListEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104tempYukenshasuEntity;
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
 * 定時登録再発行バッチ処理クラスです。
 *
 * @reamsid_L AF-0020-020 gaoya
 */
public class AFABTA103_RePrintTeijiFlow extends BatchFlowBase<AFABTA103BatchParameter> {

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoSearchKeyAll;
    private AFABTA101SelectProcessParameter selectProcessParameter;
    private AFABTA101BatchPrintProcessParameter batchPrintProcessParameter;

    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private RString eucFilePath;

    private static final String 定時登録参数検索 = "定時登録参数検索";
    private static final String 選挙人名簿抄本帳票出力 = "選挙人名簿抄本帳票出力";
    private static final String 永久選挙人名簿帳票出力 = "永久選挙人名簿帳票出力";
    private static final String 選挙人名簿索引簿帳票出力_50音順 = "選挙人名簿索引簿帳票出力_50音順";
    private static final String 選挙人名簿索引簿帳票出力_投票区別50音順 = "選挙人名簿索引簿帳票出力_投票区別50音順";
    private static final String 登録者数リスト一時テーブル作成 = "登録者数リスト一時テーブル作成";
    private static final String 登録者数リストデータを書込み = "登録者数リストデータを書込み";
    private static final String 登録者数リスト帳票出力 = "登録者数リスト帳票出力";
    private static final String 不在資格対象者名簿帳票出力 = "不在資格対象者名簿帳票出力";
    private static final String 不在者投票資格者分一時テーブル作成 = "不在者投票資格者分一時テーブル作成";
    private static final String 不在者投票資格者分データを書込み = "不在者投票資格者分データを書込み";
    private static final String 不在者投票資格者分帳票出力 = "不在者投票資格者分帳票出力";
    private static final String 有榷者数調べ一時テーブル作成 = "有榷者数調べ一時テーブル作成";
    private static final String 有権者数調べデータを書込み = "有権者数調べデータを書込み";
    private static final String 有権者数調べ帳票出力 = "有権者数調べ帳票出力";
    private static final String 二重登録通知帳票出力 = "二重登録通知帳票出力";
    // TODO 現段階に帳票実装しない
//    private static final String 送付先宛名シール帳票出力 = "送付先宛名シール帳票出力";
    private static final String 二重登録通知一覧表帳票出力 = "二重登録通知一覧表帳票出力";
    private static final String 二重登録系の帳票作成条件判断 = "二重登録系の帳票作成条件判断";
    private static final String 登録者名簿帳票出力 = "登録者名簿帳票出力";
    private static final String 縦覧用_登録者帳票出力 = "縦覧用_登録者帳票出力";
    // TODO 現段階に帳票実装しない
//    private static final String 新規登録者宛名シール帳票出力 = "新規登録者宛名シール帳票出力";
    private static final String 帰化対象者名簿帳票出力 = "帰化対象者名簿帳票出力";
    private static final String 抹消者名簿帳票出力 = "抹消者名簿帳票出力";
    private static final String 縦覧用_抹消者帳票出力 = "縦覧用_抹消者帳票出力";
    private static final String 居住要件抹消者名簿帳票出力 = "居住要件抹消者名簿帳票出力";
    private static final String 表示者名簿帳票出力 = "表示者名簿帳票出力";
    private static final String 表示消除者名簿帳票出力 = "表示消除者名簿帳票出力";
    private static final String 規定年齢前名簿帳票出力 = "規定年齢前名簿帳票出力";
    // TODO 現段階に帳票実装しない
//    private static final String 規定年齢前宛名シール帳票出力 = "規定年齢前宛名シール帳票出力";
    private static final String 規定年齢未到達者名簿帳票出力 = "規定年齢未到達者名簿帳票出力";
    private static final String 再転入者名簿帳票出力 = "再転入者名簿帳票出力";
    private static final String 訂正者名簿帳票出力 = "訂正者名簿帳票出力";
    private static final String 転出者名簿帳票出力 = "転出者名簿帳票出力";
    private static final String 登録停止者名簿帳票出力 = "登録停止者名簿帳票出力";
    private static final String 在外選挙人名簿抄本帳票出力 = "在外選挙人名簿抄本帳票出力";
//    private static final String 在外投票資格者名簿帳票出力 = "在外投票資格者名簿帳票出力";
    private static final String 縦覧用_在外選挙人名簿抄本帳票出力 = "縦覧用_在外選挙人名簿抄本帳票出力";
    private static final String バッチ出力条件表 = "バッチ出力条件表";

    @Override
    protected void prepareConfigData() {

        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(getParameter().get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        shikibetsuTaishoPSMSearchKey = build.build();
        build.setデータ取得区分(DataShutokuKubun.全履歴);
        shikibetsuTaishoSearchKeyAll = build.build();
        selectProcessParameter = getParameter().toAFABTA101SelectProcessParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoSearchKeyAll);

        batchPrintProcessParameter = getParameter().toAFABTA101BatchPrintProcessParameter();
    }

    @Override
    protected void defineFlow() {

        executeStep(定時登録参数検索);

        選挙人名簿抄本出力();

        永久選挙人名簿出力();

        選挙人名簿索引簿出力();

        登録者数リスト出力();

        有権者数調べ出力();

        二重登録通知出力();

        登録者名簿出力();

        帰化対象者名簿出力();

        抹消者名簿出力();

        居住要件抹消者名簿出力();

        表示者名簿出力();

        表示消除者名簿出力();

        規定年齢前名簿出力();

        規定年齢未到達者名簿出力();

        再転入者名簿出力();

        転出者名簿出力();

        登録停止者名簿出力();

        在外選挙人名簿抄本出力();
        // TODO 現段階に帳票「在外投票資格者名簿出力」を実装しない
        //在外投票資格者名簿出力();

        訂正者名簿出力();
        executeStep(バッチ出力条件表);
    }

    @Step(定時登録参数検索)
    IBatchFlowCommand getTeijiTourokuParamSelect() {
        return loopBatch(TeijiTourokuParamSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿抄本帳票出力)
    IBatchFlowCommand get選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(永久選挙人名簿帳票出力)
    IBatchFlowCommand get永久選挙人名簿帳票出力() {
        return loopBatch(EikyuMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿索引簿帳票出力_50音順)
    IBatchFlowCommand get選挙人名簿索引簿帳票出力_50音順() {
        return loopBatch(SakuinboReport50Process.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿索引簿帳票出力_投票区別50音順)
    IBatchFlowCommand get選挙人名簿索引簿帳票出力_投票区別50音順() {
        return loopBatch(SakuinboReportTouhyo50Process.class).arguments(selectProcessParameter).define();
    }

    @Step(登録者数リスト一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト一時テーブル() {
        return loopBatch(TorokushasuListDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(登録者数リストデータを書込み)
    IBatchFlowCommand insert登録者数リスト一時テーブル() {
        return importCsv(eucFilePath, AFAPRA103tempTorokushasuListEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(登録者数リスト帳票出力)
    IBatchFlowCommand get登録者数リスト帳票出力() {
        selectProcessParameter.setTable(AFAPRA103tempTorokushasuListEntity.TEMP_TABLE_NAME);
        selectProcessParameter.setSenkyoShurui(getResult(SenkyoShurui.class,
                new RString(登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_SENKYO_SHURUI));
        return loopBatch(TorokushasuListDataProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有榷者数調べ一時テーブル作成)
    IBatchFlowCommand create有権者数調べ一時テーブル() {
        return loopBatch(CreateYukenshasuListTableProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者数調べデータを書込み)
    IBatchFlowCommand insert有榷者数調べ一時テーブル() {
        return importCsv(eucFilePath, AFAPRA104tempYukenshasuEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(有権者数調べ帳票出力)
    IBatchFlowCommand get有権者数調べ帳票出力() {
        selectProcessParameter.setTable(AFAPRA104tempYukenshasuEntity.TEMP_TABLE_NAME);
        return loopBatch(YukenshasuListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(二重登録通知帳票出力)
    IBatchFlowCommand get二重登録通知帳票出力() {
        return loopBatch(NijuTorokuTsuchishoCommonReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(二重登録系の帳票作成条件判断)
    IBatchFlowCommand get二重登録系の帳票作成条件() {
        return simpleBatch(NijuTorokuHandanJokenProcess.class).arguments(selectProcessParameter).define();
    }
    // TODO 現段階に帳票実装しない
//    @Step(送付先宛名シール帳票出力)
//    IBatchFlowCommand get送付先宛名シール帳票出力() {
//        return loopBatch(xxxx.class).arguments(selectProcessParameter).define();
//    }

    @Step(二重登録通知一覧表帳票出力)
    IBatchFlowCommand get二重登録通知一覧表帳票出力() {
        return loopBatch(NijuTorokuTsuchishoListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(登録者名簿帳票出力)
    IBatchFlowCommand get登録者名簿帳票出力() {
        return loopBatch(ShinkiTorokushaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(縦覧用_登録者帳票出力)
    IBatchFlowCommand get縦覧用_登録者帳票出力() {
        return loopBatch(ShinkiTorokushaMeiboJuranReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(帰化対象者名簿帳票出力)
    IBatchFlowCommand get帰化対象者名簿帳票出力() {
        return loopBatch(KikaTaishoshaListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(抹消者名簿帳票出力)
    IBatchFlowCommand get抹消者名簿帳票出力() {
        return loopBatch(MasshoshaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(縦覧用_抹消者帳票出力)
    IBatchFlowCommand get縦覧用_抹消者帳票出力() {
        return loopBatch(MasshoshaMeiboJuranReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(居住要件抹消者名簿帳票出力)
    IBatchFlowCommand get居住要件抹消者名簿帳票出力() {
        return loopBatch(KyojuMasshoshaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者名簿帳票出力)
    IBatchFlowCommand get表示者名簿帳票出力() {
        return loopBatch(HyojishaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示消除者名簿帳票出力)
    IBatchFlowCommand get表示消除者名簿帳票出力() {
        return loopBatch(HyojiShojoshaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(規定年齢前名簿帳票出力)
    IBatchFlowCommand get規定年齢前名簿帳票出力() {
        return loopBatch(KiteiNenreiMaeMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    // TODO 現段階に帳票実装しない
//    @Step(規定年齢前宛名シール帳票出力)
//    IBatchFlowCommand get規定年齢前宛名シール帳票出力() {
//        return loopBatch(xxx.class).arguments(selectProcessParameter).define();
//    }
    @Step(規定年齢未到達者名簿帳票出力)
    IBatchFlowCommand get規定年齢未到達者名簿帳票出力() {
        return loopBatch(MitotatsushaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(再転入者名簿帳票出力)
    IBatchFlowCommand get再転入者名簿帳票出力() {
        return loopBatch(SaiTennyushaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(訂正者名簿帳票出力)
    IBatchFlowCommand get訂正者名簿帳票出力() {
        return loopBatch(TeiseishaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(転出者名簿帳票出力)
    IBatchFlowCommand get転出者名簿帳票出力() {
        return loopBatch(TenshutsushaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(登録停止者名簿帳票出力)
    IBatchFlowCommand get登録停止者名簿帳票出力() {
        return loopBatch(TorokuTeishishaMeiboProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(不在資格対象者名簿帳票出力)
    IBatchFlowCommand get不在資格対象者名簿作成有無() {
        return loopBatch(FuzaiShikakushaMeiboReportprocess.class).arguments(new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
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

    @Step(不在者投票資格者分帳票出力)
    IBatchFlowCommand get不在者投票資格者分作成有無() {
        selectProcessParameter.setTable(AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME);
        selectProcessParameter.setSenkyoShurui(getResult(SenkyoShurui.class,
                new RString(不在者投票資格者分一時テーブル作成), TorokushasuListFuzaiShikakuDataSelectProcess.OUT_SENKYO_SHURUI));
        return loopBatch(TorokushasuListFuzaiShikakuReportProcess.class).arguments(
                new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(在外選挙人名簿抄本帳票出力)
    IBatchFlowCommand get在外選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonZaigaiReportProcess.class).arguments(new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(縦覧用_在外選挙人名簿抄本帳票出力)
    IBatchFlowCommand get縦覧用_在外選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonZaigaiJuranReportProcess.class).arguments(new AFABTB101SelectProcessParameter(selectProcessParameter)).define();
    }

    // TODO 現段階に帳票実装しない
//    @Step(在外投票資格者名簿帳票出力)
//    IBatchFlowCommand get在外投票資格者名簿帳票出力() {
//        return loopBatch(xxx.class).arguments(selectProcessParameter).define();
//    }
    @Step(バッチ出力条件表)
    IBatchFlowCommand getバッチ出力条件表() {
        batchPrintProcessParameter.setジョブ番号(this.getJobId());
        return simpleBatch(BatchSyuturyokuJyoukenProcess.class).arguments(batchPrintProcessParameter).define();
    }

    private void 選挙人名簿抄本出力() {
        if (getParameter().get選挙人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.選挙人名簿抄本.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(選挙人名簿抄本帳票出力);
            batchPrintProcessParameter.set選挙人名簿抄本出力数(getResult(Integer.class,
                    new RString(選挙人名簿抄本帳票出力), MeiboShohonReportProcess.PAGE_COUNT));
            batchPrintProcessParameter.set選挙人名簿抄本縦覧出力数(getResult(Integer.class,
                    new RString(選挙人名簿抄本帳票出力), MeiboShohonReportProcess.PAGE_COUNT_JURAN));
        }
    }

    private void 永久選挙人名簿出力() {
        if (getParameter().get永久選挙人名簿出力有無()) {
            帳票ID = ReportIdKeys.永久選挙人名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(永久選挙人名簿帳票出力);
            batchPrintProcessParameter.set永久選挙人名簿出力数(getResult(Integer.class,
                    new RString(永久選挙人名簿帳票出力), EikyuMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 選挙人名簿索引簿出力() {
        if (getParameter().get選挙人名簿索引簿出力有無()) {
            帳票ID = ReportIdKeys.選挙人名簿索引簿.value();
            executeStep(選挙人名簿索引簿帳票出力_50音順);
            batchPrintProcessParameter.set選挙人名簿索引簿出力数(getResult(Integer.class,
                    new RString(選挙人名簿索引簿帳票出力_50音順), SakuinboReport50Process.PAGE_COUNT));

            帳票ID = ReportIdKeys.選挙人名簿索引簿_投票区別50音順.value();
            executeStep(選挙人名簿索引簿帳票出力_投票区別50音順);
            batchPrintProcessParameter.set選挙人名簿索引簿投票区別出力数(getResult(Integer.class,
                    new RString(選挙人名簿索引簿帳票出力_50音順), SakuinboReport50Process.PAGE_COUNT));
        }
    }

    private void 登録者数リスト出力() {
        if (getParameter().get登録者数リスト出力有無()) {
            帳票ID = ReportIdKeys.登録者数リスト.value();
            executeStep(登録者数リスト一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_EUC_FILE_PATH);
            executeStep(登録者数リストデータを書込み);
            executeStep(登録者数リスト帳票出力);
            batchPrintProcessParameter.set登録者数リスト出力数(getResult(Integer.class,
                    new RString(登録者数リスト帳票出力), TorokushasuListDataProcess.PAGE_COUNT));

            if (getParameter().get不在資格対象者名簿作成有無()) {
                帳票ID = ReportIdKeys.不在資格対象者名簿.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(不在資格対象者名簿帳票出力);
                batchPrintProcessParameter.set不在資格対象者名簿作成出力数(getResult(Integer.class,
                        new RString(不在資格対象者名簿帳票出力), FuzaiShikakushaMeiboReportprocess.PAGE_COUNT));
            }

            if (getParameter().get不在者投票資格者分作成有無()) {
                帳票ID = ReportIdKeys.不在者投票資格者分.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(不在者投票資格者分一時テーブル作成);
                eucFilePath = getResult(RString.class, new RString(不在者投票資格者分一時テーブル作成),
                        TorokushasuListFuzaiShikakuDataSelectProcess.OUT_EUC_FILE_PATH);
                executeStep(不在者投票資格者分データを書込み);
                executeStep(不在者投票資格者分帳票出力);
                batchPrintProcessParameter.set不在者投票資格者分作成出力数(getResult(Integer.class,
                        new RString(不在者投票資格者分帳票出力), TorokushasuListFuzaiShikakuReportProcess.PAGE_COUNT));
            }
        }
    }

    private void 有権者数調べ出力() {
        if (getParameter().get有榷者数調べ出力有無()) {
            帳票ID = ReportIdKeys.有権者数調べ.value();
            executeStep(有榷者数調べ一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(有榷者数調べ一時テーブル作成), CreateYukenshasuListTableProcess.OUT_EUC_FILE_PATH);
            executeStep(有権者数調べデータを書込み);
            executeStep(有権者数調べ帳票出力);
            batchPrintProcessParameter.set有榷者数調べ出力数(getResult(Integer.class,
                    new RString(有権者数調べ帳票出力), YukenshasuListReportProcess.PAGE_COUNT));
        }
    }

    private void 二重登録通知出力() {
        if (getParameter().get二重登録通知出力有無()) {
            executeStep(二重登録系の帳票作成条件判断);
            boolean shutsuryokuFlag = getResult(Boolean.class, new RString(二重登録系の帳票作成条件判断),
                    NijuTorokuHandanJokenProcess.IS_SHUTSURYOKU);
            if (!shutsuryokuFlag) {
                batchPrintProcessParameter.set二重登録通知出力数(0);
                return;
            }
            帳票ID = ReportIdKeys.二重登録通知書.value();
            selectProcessParameter.setSelectKijun(BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体));
            selectProcessParameter.set発行番号_第(getParameter().get発行番号の第());
            selectProcessParameter.set発行番号_番号(getParameter().get発行番号の番号());
            selectProcessParameter.set発行番号_号(getParameter().get発行番号の号());
            selectProcessParameter.set転入期間_開始日(getParameter().get転入期間().get(0));
            selectProcessParameter.set転入期間_終了日(getParameter().get転入期間().get(1));
            executeStep(二重登録通知帳票出力);
            batchPrintProcessParameter.set二重登録通知出力数(getResult(Integer.class,
                    new RString(二重登録通知帳票出力), NijuTorokuTsuchishoCommonReportProcess.PAGE_COUNT));

            // 　TODO 現段階に帳票「AFAPRA214_SofusakiAtenaSeal」を実装しない
//            if (getParameter().get送付先宛名シール作成有無()) {
//                if (("12").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    batchPrintProcessParameter.set帳票ID(ReportIdKeys.送付先宛名シール作成.value());
//                } else if (("21").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    batchPrintProcessParameter.set帳票ID(ReportIdKeys.送付先宛名シール作成_21.value());
//                }
//
//                executeStep(送付先宛名シール帳票出力);
//            }
            if (getParameter().get二重登録通知一覧表作成有無()) {
                batchPrintProcessParameter.set帳票ID(ReportIdKeys.二重登録者通知一覧表.value());
                batchPrintProcessParameter.set帳票名(ReportIdKeys.二重登録者通知一覧表.getName());
                executeStep(二重登録通知一覧表帳票出力);
                batchPrintProcessParameter.set二重登録通知一覧表作成出力数(getResult(Integer.class,
                        new RString(二重登録通知一覧表帳票出力), NijuTorokuTsuchishoListReportProcess.PAGE_COUNT));
            }
        }
    }

    private void 登録者名簿出力() {
        if (getParameter().get登録者名簿出力有無()) {
            帳票ID = ReportIdKeys.新規登録者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(登録者名簿帳票出力);
            batchPrintProcessParameter.set登録者名簿出力数(getResult(Integer.class,
                    new RString(登録者名簿帳票出力), ShinkiTorokushaMeiboReportProcess.PAGE_COUNT));

            if (getParameter().get縦覧用作成有無_登録者()) {
                executeStep(縦覧用_登録者帳票出力);
            }
            // TODO 現段階に帳票「AFAPRA214_ShinkiTorokushaAtenaSeal」を実装しない
//            if (getParameter().get新規登録者宛名シール作成有無()) {
//                if (("12").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    帳票ID = ReportIdKeys.新規登録者宛名シール.value();
//                } else if (("21").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    帳票ID = ReportIdKeys.新規登録者宛名シール_21.value();
//                }
//                selectProcessParameter.setSort(getソート順(帳票ID));
//                executeStep(新規登録者宛名シール帳票出力);
        }
    }

    private void 帰化対象者名簿出力() {
        if (getParameter().get帰化対象者名簿出力有無()) {
            帳票ID = ReportIdKeys.帰化対象者リスト.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(帰化対象者名簿帳票出力);
            batchPrintProcessParameter.set帰化対象者名簿出力数(getResult(Integer.class,
                    new RString(帰化対象者名簿帳票出力), KikaTaishoshaListReportProcess.PAGE_COUNT));
        }
    }

    private void 抹消者名簿出力() {
        if (getParameter().get抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.抹消者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(抹消者名簿帳票出力);
            batchPrintProcessParameter.set抹消者名簿出力数(getResult(Integer.class,
                    new RString(抹消者名簿帳票出力), MasshoshaMeiboReportProcess.PAGE_COUNT));

            if (getParameter().get縦覧用作成有無_抹消者()) {
                帳票ID = ReportIdKeys.抹消者名簿縦覧.value();
                executeStep(縦覧用_抹消者帳票出力);
                batchPrintProcessParameter.set抹消者名簿縦覧用出力数(getResult(Integer.class,
                        new RString(縦覧用_抹消者帳票出力), MasshoshaMeiboJuranReportProcess.PAGE_COUNT));
            }
        }
    }

    private void 居住要件抹消者名簿出力() {
        if (getParameter().get居住要件抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.居住要件抹消者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(居住要件抹消者名簿帳票出力);
            batchPrintProcessParameter.set居住要件抹消者名簿出力数(getResult(Integer.class,
                    new RString(居住要件抹消者名簿帳票出力), KyojuMasshoshaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 表示者名簿出力() {
        if (getParameter().get表示者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(表示者名簿帳票出力);
            batchPrintProcessParameter.set表示者名簿出力数(getResult(Integer.class,
                    new RString(表示者名簿帳票出力), HyojishaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 表示消除者名簿出力() {
        if (getParameter().get表示消除者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示消除者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(表示消除者名簿帳票出力);
            batchPrintProcessParameter.set表示消除者名簿出力数(getResult(Integer.class,
                    new RString(表示消除者名簿帳票出力), HyojiShojoshaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 規定年齢前名簿出力() {
        if (getParameter().get規定年齢前名簿出力有無()) {
            帳票ID = ReportIdKeys.規定年齢前名簿.value();
            selectProcessParameter.setSort(getソート順(帳票ID));
            executeStep(規定年齢前名簿帳票出力);
            batchPrintProcessParameter.set規定年齢前名簿出力数(getResult(Integer.class,
                    new RString(規定年齢前名簿帳票出力), KiteiNenreiMaeMeiboReportProcess.PAGE_COUNT));

            // TODO 現段階に帳票「AFAPRE213_KiteiNenreiMaeAtenaSeal」を実装しない
//            if (getParameter().get規定年齢前シール作成有無()) {
//                if (("12").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    帳票ID = ReportIdKeys.規定年齢前シール.value();
//                } else if (("21").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    帳票ID = ReportIdKeys.規定年齢前シール_21.value();
//                }
//                executeStep(規定年齢前宛名シール帳票出力);
        }
    }

    private void 規定年齢未到達者名簿出力() {
        if (getParameter().get規定年齢未到達者名簿出力有無()) {
            帳票ID = ReportIdKeys.規定年齢未到達者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(規定年齢未到達者名簿帳票出力);
            batchPrintProcessParameter.set規定年齢未到達者名簿出力数(getResult(Integer.class,
                    new RString(規定年齢未到達者名簿帳票出力), MitotatsushaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 再転入者名簿出力() {
        if (getParameter().get再転入者名簿出力有無()) {
            帳票ID = ReportIdKeys.再転入者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(再転入者名簿帳票出力);
            batchPrintProcessParameter.set再転入者名簿出力数(getResult(Integer.class,
                    new RString(再転入者名簿帳票出力), SaiTennyushaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 訂正者名簿出力() {
        if (getParameter().get訂正者名簿出力有無()) {
            帳票ID = ReportIdKeys.訂正者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(訂正者名簿帳票出力);
            batchPrintProcessParameter.set訂正者名簿出力数(getResult(Integer.class,
                    new RString(訂正者名簿帳票出力), TeiseishaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 転出者名簿出力() {
        if (getParameter().get転出者名簿出力有無()) {
            帳票ID = ReportIdKeys.転出者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(転出者名簿帳票出力);
            batchPrintProcessParameter.set転出者名簿出力数(getResult(Integer.class,
                    new RString(転出者名簿帳票出力), TenshutsushaMeiboReportProcess.PAGE_COUNT));
        }
    }

    private void 登録停止者名簿出力() {
        if (getParameter().get登録停止者名簿出力有無()) {
            帳票ID = ReportIdKeys.登録停止者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(登録停止者名簿帳票出力);
            batchPrintProcessParameter.set登録停止者名簿出力数(getResult(Integer.class,
                    new RString(登録停止者名簿帳票出力), TorokuTeishishaMeiboProcess.PAGE_COUNT));
        }
    }

    private void 在外選挙人名簿抄本出力() {
        if (getParameter().get在外選挙人名簿抄本出力有無()) {
            帳票ID = ReportIdKeys.在外選挙人名簿抄本.value();
            selectProcessParameter.setSort(get在外ソート順WithMaster(帳票ID));
            executeStep(在外選挙人名簿抄本帳票出力);
            batchPrintProcessParameter.set在外選挙人名簿抄本出力数(getResult(Integer.class,
                    new RString(在外選挙人名簿抄本帳票出力), MeiboShohonZaigaiReportProcess.PAGE_COUNT));

            帳票ID = ReportIdKeys.在外選挙人名簿抄本_縦覧用.value();
            selectProcessParameter.setSort(get在外ソート順WithMaster(帳票ID));
            executeStep(縦覧用_在外選挙人名簿抄本帳票出力);
            batchPrintProcessParameter.set在外選挙人名簿抄本縦覧用出力数(getResult(Integer.class,
                    new RString(縦覧用_在外選挙人名簿抄本帳票出力), MeiboShohonZaigaiJuranReportProcess.PAGE_COUNT));
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

    // <editor-fold defaultstate="collapsed" desc="ソート順の取得">
    private RString getソート順WithMaster(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ReportOutputTypeWithMaster.class, 帳票出力順.get(0));
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
