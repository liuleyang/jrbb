/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.CreateYukenshasuListTableProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.EikyuMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.HyojiShojoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.HyojishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.KikaTaishoshaListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.KyojuMasshoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MasshoshaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MasshoshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MeiboShohonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.MitotatsushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.NijuTorokuTsuchishoCommonReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.NijuTorokuTsuchishoListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SaiTennyushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SakuinboReport50Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.SakuinboReportTouhyo50Process;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.ShinkiTorokushaMeiboJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.ShinkiTorokushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TeiseishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TenshutsushaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokuTeishishaMeiboProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.TorokushasuListDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010.YukenshasuListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.BatchSyuturyokuJyoukenProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.FuzaiShikakushaMeiboReportprocess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.HyojishojoYoteishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MasshoshaYoteishaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MeiboShohonZaigaiJuranReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.MeiboShohonZaigaiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.NijuTorokuChosaKaitoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.NijuTorokuChosaShokaiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.NijuTorokuTyosaListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiNijuTorokuHandanJokenProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiTourokuDataDeleteShohonProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiTourokuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiTourokuDataUpdateSenkyoninMeiboProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiTourokuDataUpdateZaigaiProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.SenkyojiTourokuParamSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.ShikkenshaMeiboReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010.TorokushasuListFuzaiShikakuReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiReportOutputTypeWithMaster;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiTourokuOutputType;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103tempTorokushasuListFuzaiShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙時登録のバッチ処理クラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class AFABTB101_SenkyojiTourokuFlow extends BatchFlowBase<AFABTB101BatchParameter> {

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoSearchKeyAll;
    private AFABTB101SelectProcessParameter selectProcessParameter;
    private AFABTB101BatchPrintProcessParameter batchPrintProcessParameter;

    private FlexibleDate 検索条件_年齢;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private RString eucFilePath;

    private static final String 登録者数リストデータを書込み = "登録者数リストデータを書込み";
    private static final String 不在者投票資格者分データを書込み = "不在者投票資格者分データを書込み";
    private static final String 有権者数調べデータを書込み = "有権者数調べデータを書込み";
    private static final String 選挙時登録参数検索 = "選挙時登録参数検索";
    private static final String 選挙時登録データ検索 = "選挙時登録データ検索";
    private static final String 選挙時登録データを書込み = "選挙時登録データを書込み";
    private static final String 選挙時登録データ削除_抄本 = "選挙時登録データ削除(抄本)";
    private static final String 選挙時登録データ更新_選挙人名簿 = "選挙時登録データ更新(選挙人名簿)";
    private static final String 選挙時登録データ更新_在外 = "選挙時登録データ更新(在外)";
    private static final String 選挙人名簿抄本帳票出力 = "選挙人名簿抄本帳票出力";
    private static final String 永久選挙人名簿帳票出力 = "永久選挙人名簿帳票出力";
    private static final String 選挙人名簿索引簿帳票出力_50音順 = "選挙人名簿索引簿帳票出力_50音順";
    private static final String 選挙人名簿索引簿帳票出力_投票区別50音順 = "選挙人名簿索引簿帳票出力_投票区別50音順";
    private static final String 有榷者数調べ一時テーブル作成 = "有榷者数調べ一時テーブル作成";
    private static final String 登録者数リスト一時テーブル作成 = "登録者数リスト一時テーブル作成";
    private static final String 登録者数リスト帳票出力 = "登録者数リスト帳票出力";
    private static final String 不在資格対象者名簿帳票出力 = "不在資格対象者名簿帳票出力";
    private static final String 有権者数調べ帳票出力 = "有権者数調べ帳票出力";
    private static final String 二重登録通知帳票出力 = "二重登録通知帳票出力";
    private static final String 二重登録通知一覧表帳票出力 = "二重登録通知一覧表帳票出力";
    private static final String 二重登録系の帳票作成条件判断 = "二重登録系の帳票作成条件判断";
    private static final String 登録者名簿帳票出力 = "登録者名簿帳票出力";
    private static final String 縦覧用_登録者帳票出力 = "縦覧用_登録者帳票出力";
    private static final String 帰化対象者名簿帳票出力 = "帰化対象者名簿帳票出力";
    private static final String 抹消者名簿帳票出力 = "抹消者名簿帳票出力";
    private static final String 縦覧用_抹消者帳票出力 = "縦覧用_抹消者帳票出力";
    private static final String 居住要件抹消者名簿帳票出力 = "居住要件抹消者名簿帳票出力";
    private static final String 抹消予定者名簿帳票出力 = "抹消予定者名簿帳票出力";
    private static final String 失榷者名簿帳票出力 = "失榷者名簿帳票出力";
    private static final String 表示者名簿帳票出力 = "表示者名簿帳票出力";
    private static final String 表示消除者名簿帳票出力 = "表示消除者名簿帳票出力";
    private static final String 表示消除予定者名簿帳票出力 = "表示消除予定者名簿帳票出力";
    private static final String 規定年齢未到達者名簿帳票出力 = "規定年齢未到達者名簿帳票出力";
    private static final String 再転入者名簿帳票出力 = "再転入者名簿帳票出力";
    private static final String 訂正者名簿帳票出力 = "訂正者名簿帳票出力";
    private static final String 転出者名簿帳票出力 = "転出者名簿帳票出力";
    private static final String 登録停止者名簿帳票出力 = "登録停止者名簿帳票出力";
    private static final String 在外選挙人名簿抄本帳票出力 = "在外選挙人名簿抄本帳票出力";
    private static final String 縦覧用_在外選挙人名簿抄本帳票出力 = "縦覧用_在外選挙人名簿抄本帳票出力";
    private static final String バッチ出力条件表 = "バッチ出力条件表";

    private static final String 二重登録調査票照会 = "二重登録調査票照会";
    private static final String 二重登録調査票回答 = "二重登録調査票回答";
    private static final String 二重登録調査一覧表 = "二重登録調査一覧表";
    private static final String 不在者投票資格者名簿 = "不在者投票資格者名簿";
    private static final String 不在者投票資格者名簿データ選択 = "不在者投票資格者名簿データ選択";
    private static final int 四月 = 4;

    @Override
    protected void prepareConfigData() {
        検索条件_年齢 = getParameter().get年齢期限日().minusYear(Integer.valueOf(
                BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体).toString()));

        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(最大基準日取得(getParameter().get基準日リスト()));
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        shikibetsuTaishoPSMSearchKey = build.build();
        build.setデータ取得区分(DataShutokuKubun.全履歴);
        shikibetsuTaishoSearchKeyAll = build.build();
        selectProcessParameter = getParameter().toAFABTB101SelectProcessParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoSearchKeyAll,
                RString.EMPTY);

        batchPrintProcessParameter = getParameter().toAFABTB101BatchPrintProcessParameter();
    }

    private FlexibleDate 最大基準日取得(List<FlexibleDate> 基準日リスト) {
        FlexibleDate 最大基準日 = FlexibleDate.MIN;
        for (FlexibleDate 基準日 : 基準日リスト) {
            if (最大基準日.isBefore(基準日)) {
                最大基準日 = 基準日;
            }
        }
        return 最大基準日;
    }

    @Override
    protected void defineFlow() {
        executeStep(選挙時登録参数検索);
        executeStep(選挙時登録データ検索);
        eucFilePath = getResult(RString.class, new RString(選挙時登録データ検索), SenkyojiTourokuDataSelectProcess.OUT_EUC_FILE_PATH);
        executeStep(選挙時登録データを書込み);
        executeStep(選挙時登録データ削除_抄本);
        executeStep(選挙時登録データ更新_選挙人名簿);
        executeStep(選挙時登録データ更新_在外);

        選挙人名簿抄本出力();

        永久選挙人名簿出力();

        選挙人名簿索引簿出力();

        登録者数リスト出力();

        有権者数調べ出力();

        二重登録通知出力();

        二重登録調査票出力();

        登録者名簿出力();

        帰化対象者名簿出力();

        抹消者名簿出力();

        居住要件抹消者名簿出力();

        失榷者名簿出力();

        抹消予定者名簿出力();

        表示者名簿出力();

        表示消除者名簿出力();

        表示消除予定者名簿出力();

        規定年齢未到達者名簿出力();

        再転入者名簿出力();

        訂正者名簿出力();

        転出者名簿出力();

        登録停止者名簿出力();

        在外選挙人名簿抄本出力();

        // TODO 在外投票管理表
        executeStep(バッチ出力条件表);
    }

    @Step(選挙時登録参数検索)
    IBatchFlowCommand getSenkyojiTourokuParamSelect() {
        return loopBatch(SenkyojiTourokuParamSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙時登録データ検索)
    IBatchFlowCommand getSenkyojiTourokuDataSelect() {
        selectProcessParameter.setAgeForselect(検索条件_年齢);
        return loopBatch(SenkyojiTourokuDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙時登録データを書込み)
    IBatchFlowCommand getTeijiTourokuDataSelectInsert() {
        return importCsv(eucFilePath, AFABTA101tempTblEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(選挙時登録データ削除_抄本)
    IBatchFlowCommand getSenkyojiTourokuDataShohonDelete() {
        selectProcessParameter.setTable(AFABTA101tempTblEntity.TEMP_TABLE_NAME);
        return loopBatch(SenkyojiTourokuDataDeleteShohonProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙時登録データ更新_選挙人名簿)
    IBatchFlowCommand getSenkyojiTourokuDataUpdateSenkyoninMeibo() {
        selectProcessParameter.setTable(AFABTA101tempTblEntity.TEMP_TABLE_NAME);
        return loopBatch(SenkyojiTourokuDataUpdateSenkyoninMeiboProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙時登録データ更新_在外)
    IBatchFlowCommand getSenkyojiTourokuDataUpdateZaigai() {
        帳票ID = ReportIdKeys.在外選挙人名簿抄本.value();
        selectProcessParameter.setSort(get在外ソート順(帳票ID));
        selectProcessParameter.setTable(AFABTA101tempTblEntity.TEMP_TABLE_NAME);
        return loopBatch(SenkyojiTourokuDataUpdateZaigaiProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(選挙人名簿抄本帳票出力)
    IBatchFlowCommand get選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(永久選挙人名簿帳票出力)
    IBatchFlowCommand get永久選挙人名簿帳票出力() {
        return loopBatch(EikyuMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(選挙人名簿索引簿帳票出力_50音順)
    IBatchFlowCommand get選挙人名簿索引簿帳票出力_50音順() {
        return loopBatch(SakuinboReport50Process.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(選挙人名簿索引簿帳票出力_投票区別50音順)
    IBatchFlowCommand get選挙人名簿索引簿帳票出力_投票区別50音順() {
        return loopBatch(SakuinboReportTouhyo50Process.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(登録者数リスト一時テーブル作成)
    IBatchFlowCommand creat登録者数リスト一時テーブル() {
        return loopBatch(TorokushasuListDataSelectProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
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
        return loopBatch(TorokushasuListDataProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(不在資格対象者名簿帳票出力)
    IBatchFlowCommand get不在資格対象者名簿帳票出力() {
        return loopBatch(FuzaiShikakushaMeiboReportprocess.class)
                .arguments(getParameter().toAFABTB101SelectProcessParameter(shikibetsuTaishoPSMSearchKey,
                                shikibetsuTaishoSearchKeyAll,
                                getソート順WithMaster(ReportIdKeys.不在資格対象者名簿.value()),
                                get改頁項目ID(ReportIdKeys.不在資格対象者名簿.value()))).define();
    }

    @Step(有榷者数調べ一時テーブル作成)
    IBatchFlowCommand create有権者数調べ一時テーブル() {
        return loopBatch(CreateYukenshasuListTableProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
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
        return loopBatch(YukenshasuListReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(二重登録通知帳票出力)
    IBatchFlowCommand get二重登録通知帳票出力() {
        return loopBatch(NijuTorokuTsuchishoCommonReportProcess.class).arguments(
                new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(二重登録系の帳票作成条件判断)
    IBatchFlowCommand get二重登録系の帳票作成条件() {
        return simpleBatch(SenkyojiNijuTorokuHandanJokenProcess.class).arguments(selectProcessParameter).define();
    }
    //TODO 現段階に帳票を実装しない
    //    @Step(送付先宛名シール帳票出力)
    //    IBatchFlowCommand get送付先宛名シール帳票出力() {
    //        return loopBatch(xxxx.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    //    }

    @Step(二重登録通知一覧表帳票出力)
    IBatchFlowCommand get二重登録通知一覧表帳票出力() {
        return loopBatch(NijuTorokuTsuchishoListReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(登録者名簿帳票出力)
    IBatchFlowCommand get登録者名簿帳票出力() {
        return loopBatch(ShinkiTorokushaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(縦覧用_登録者帳票出力)
    IBatchFlowCommand get縦覧用_登録者帳票出力() {
        return loopBatch(ShinkiTorokushaMeiboJuranReportProcess.class).arguments(
                new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(帰化対象者名簿帳票出力)
    IBatchFlowCommand get帰化対象者名簿帳票出力() {
        return loopBatch(KikaTaishoshaListReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(抹消者名簿帳票出力)
    IBatchFlowCommand get抹消者名簿帳票出力() {
        return loopBatch(MasshoshaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(縦覧用_抹消者帳票出力)
    IBatchFlowCommand get縦覧用_抹消者帳票出力() {
        return loopBatch(MasshoshaMeiboJuranReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(居住要件抹消者名簿帳票出力)
    IBatchFlowCommand get居住要件抹消者名簿帳票出力() {
        return loopBatch(KyojuMasshoshaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(失榷者名簿帳票出力)
    IBatchFlowCommand get失榷者名簿帳票出力() {
        return loopBatch(ShikkenshaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(抹消予定者名簿帳票出力)
    IBatchFlowCommand get抹消予定者名簿帳票出力() {
        return loopBatch(MasshoshaYoteishaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者名簿帳票出力)
    IBatchFlowCommand get表示者名簿帳票出力() {
        return loopBatch(HyojishaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(表示消除者名簿帳票出力)
    IBatchFlowCommand get表示消除者名簿帳票出力() {
        return loopBatch(HyojiShojoshaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(表示消除予定者名簿帳票出力)
    IBatchFlowCommand get表示消除予定者名簿帳票出力() {
        return loopBatch(HyojishojoYoteishaMeiboReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(規定年齢未到達者名簿帳票出力)
    IBatchFlowCommand get規定年齢未到達者名簿帳票出力() {
        return loopBatch(MitotatsushaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(再転入者名簿帳票出力)
    IBatchFlowCommand get再転入者名簿帳票出力() {
        return loopBatch(SaiTennyushaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(訂正者名簿帳票出力)
    IBatchFlowCommand get訂正者名簿帳票出力() {
        return loopBatch(TeiseishaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(転出者名簿帳票出力)
    IBatchFlowCommand get転出者名簿帳票出力() {
        return loopBatch(TenshutsushaMeiboReportProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(登録停止者名簿帳票出力)
    IBatchFlowCommand get登録停止者名簿帳票出力() {
        return loopBatch(TorokuTeishishaMeiboProcess.class).arguments(new AFABTA101SelectProcessParameter(selectProcessParameter)).define();
    }

    @Step(バッチ出力条件表)
    IBatchFlowCommand getバッチ出力条件表() {
        batchPrintProcessParameter.set抄本番号(getResult(ShohonNo.class,
                new RString(選挙時登録データ削除_抄本), SenkyojiTourokuDataDeleteShohonProcess.SHOHON_NO));
        batchPrintProcessParameter.setジョブ番号(this.getJobId());
        return simpleBatch(BatchSyuturyokuJyoukenProcess.class).arguments(batchPrintProcessParameter).define();
    }

    @Step(不在者投票資格者名簿)
    IBatchFlowCommand get不在者投票資格者名簿() {
        selectProcessParameter.setTable(AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME);
        selectProcessParameter.setSenkyoShurui(getResult(SenkyoShurui.class,
                new RString(不在者投票資格者名簿データ選択), TorokushasuListFuzaiShikakuDataSelectProcess.OUT_SENKYO_SHURUI));
        return loopBatch(TorokushasuListFuzaiShikakuReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(二重登録調査票照会)
    IBatchFlowCommand get二重登録調査票照会() {
        return loopBatch(NijuTorokuChosaShokaiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(二重登録調査票回答)
    IBatchFlowCommand get二重登録調査票回答() {
        return loopBatch(NijuTorokuChosaKaitoReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(二重登録調査一覧表)
    IBatchFlowCommand get二重登録調査一覧表() {
        return loopBatch(NijuTorokuTyosaListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(不在者投票資格者名簿データ選択)
    IBatchFlowCommand get不在者投票資格者名簿データ選択() {
        return loopBatch(TorokushasuListFuzaiShikakuDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(不在者投票資格者分データを書込み)
    IBatchFlowCommand insert不在者投票資格者分一時テーブル() {
        return importCsv(eucFilePath, AFAPRA103tempTorokushasuListFuzaiShikakuEntity.TEMP_TABLE_NAME, DbTableType.PERMANENT).
                tableExistActionType(TableExistActionType.APPEND).
                define();
    }

    @Step(在外選挙人名簿抄本帳票出力)
    IBatchFlowCommand get在外選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonZaigaiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(縦覧用_在外選挙人名簿抄本帳票出力)
    IBatchFlowCommand get縦覧用_在外選挙人名簿抄本帳票出力() {
        return loopBatch(MeiboShohonZaigaiJuranReportProcess.class).arguments(selectProcessParameter).define();
    }

    // <editor-fold defaultstate="collapsed" desc="3.1「選挙人名簿抄本」帳票出力（AFAPRA100_MeiboShohon）">　
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
     // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.2「永久選挙人名簿」帳票出力（AFAPRA101_EikyuMeibo）">　
    private void 永久選挙人名簿出力() {
        if (getParameter().get永久選挙人名簿出力有無()) {
            帳票ID = ReportIdKeys.永久選挙人名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(永久選挙人名簿帳票出力);
            batchPrintProcessParameter.set永久選挙人名簿出力数(getResult(Integer.class,
                    new RString(永久選挙人名簿帳票出力), EikyuMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.3「選挙人名簿索引簿」帳票出力（AFAPRA102_Sakuinbo）">　
    private void 選挙人名簿索引簿出力() {

        if (getParameter().get選挙人名簿索引簿出力有無()) {
            帳票ID = ReportIdKeys.選挙人名簿索引簿.value();
            executeStep(選挙人名簿索引簿帳票出力_50音順);
            batchPrintProcessParameter.set選挙人名簿索引簿出力数(getResult(Integer.class,
                    new RString(選挙人名簿索引簿帳票出力_50音順), SakuinboReport50Process.PAGE_COUNT));
            帳票ID = ReportIdKeys.選挙人名簿索引簿_投票区別50音順.value();
            executeStep(選挙人名簿索引簿帳票出力_投票区別50音順);
            batchPrintProcessParameter.set選挙人名簿索引簿投票区別出力数(getResult(Integer.class,
                    new RString(選挙人名簿索引簿帳票出力_投票区別50音順), SakuinboReportTouhyo50Process.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.4「登録者数リスト」帳票出力（AFAPRA103_TorokushasuList）">　
    private void 登録者数リスト出力() {
        if (getParameter().get登録者数リスト出力有無()) {
            executeStep(登録者数リスト一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(登録者数リスト一時テーブル作成), TorokushasuListDataSelectProcess.OUT_EUC_FILE_PATH);
            executeStep(登録者数リストデータを書込み);
            executeStep(登録者数リスト帳票出力);
            batchPrintProcessParameter.set登録者数リスト出力数(getResult(Integer.class,
                    new RString(登録者数リスト帳票出力), TorokushasuListDataProcess.PAGE_COUNT));
            if (getParameter().get不在者投票資格者分作成有無()) {
                帳票ID = ReportIdKeys.不在者投票資格者分.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(不在者投票資格者名簿データ選択);
                eucFilePath = getResult(RString.class, new RString(不在者投票資格者名簿データ選択),
                        TorokushasuListFuzaiShikakuDataSelectProcess.OUT_EUC_FILE_PATH);
                executeStep(不在者投票資格者分データを書込み);
                executeStep(不在者投票資格者名簿);
                batchPrintProcessParameter.set不在者投票資格者分作成出力数(getResult(Integer.class,
                        new RString(不在者投票資格者名簿), TorokushasuListFuzaiShikakuReportProcess.PAGE_COUNT));
            }
            if (getParameter().get不在資格対象者名簿作成有無()) {
                帳票ID = ReportIdKeys.不在資格対象者名簿.value();
                selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
                executeStep(不在資格対象者名簿帳票出力);
                batchPrintProcessParameter.set不在資格対象者名簿作成出力数(getResult(Integer.class,
                        new RString(不在資格対象者名簿帳票出力), FuzaiShikakushaMeiboReportprocess.PAGE_COUNT));
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.5「有権者数調べ」帳票出力（AFAPRA104_YukenshasuList）">
    private void 有権者数調べ出力() {
        if (getParameter().get有榷者数調べ出力有無()) {
            executeStep(有榷者数調べ一時テーブル作成);
            eucFilePath = getResult(RString.class, new RString(有榷者数調べ一時テーブル作成), CreateYukenshasuListTableProcess.OUT_EUC_FILE_PATH);
            executeStep(有権者数調べデータを書込み);
            executeStep(有権者数調べ帳票出力);
            batchPrintProcessParameter.set有榷者数調べ出力数(getResult(Integer.class,
                    new RString(有権者数調べ帳票出力), YukenshasuListReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.6「二重登録通知」帳票出力（AFAPRA111_NijuTorokuTsuchisho）">　　
    private void 二重登録通知出力() {
        //TODO プロセスと文字切れ未実装74345
        if (getParameter().get二重登録通知出力有無()) {
            executeStep(二重登録系の帳票作成条件判断);
            boolean shutsuryokuFlag = getResult(Boolean.class, new RString(二重登録系の帳票作成条件判断),
                    SenkyojiNijuTorokuHandanJokenProcess.IS_SHUTSURYOKU);
            batchPrintProcessParameter.set二重登録系の帳票作成条件判断(shutsuryokuFlag);
            if (!shutsuryokuFlag) {
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
            //AFAPRA112_NijuTorokuTsuchishoList
            if (getParameter().get二重登録通知一覧表作成有無()) {
                batchPrintProcessParameter.set帳票ID(ReportIdKeys.二重登録者通知一覧表.value());
                batchPrintProcessParameter.set帳票名(ReportIdKeys.二重登録者通知一覧表.getName());
                executeStep(二重登録通知一覧表帳票出力);
                batchPrintProcessParameter.set二重登録通知一覧表作成出力数(getResult(Integer.class,
                        new RString(二重登録通知一覧表帳票出力), NijuTorokuTsuchishoListReportProcess.PAGE_COUNT));
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.6「二重登録通知」帳票出力（AFAPRA111_NijuTorokuTsuchisho）">　　
    private void 二重登録調査票出力() {

        if (getParameter().get二重登録調査票有無()) {
            executeStep(二重登録系の帳票作成条件判断);
            boolean shutsuryokuFlag = getResult(Boolean.class, new RString(二重登録系の帳票作成条件判断),
                    SenkyojiNijuTorokuHandanJokenProcess.IS_SHUTSURYOKU);
            batchPrintProcessParameter.set二重登録系の帳票作成条件判断(shutsuryokuFlag);
            if (!shutsuryokuFlag) {
                return;
            }
            帳票ID = ReportIdKeys.二重登録調査票_照会.value();
            selectProcessParameter.setSelectKijun(BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体));
            selectProcessParameter.set発行番号_第(getParameter().get発行番号の第_調査票());
            selectProcessParameter.set発行番号_番号(getParameter().get発行番号の番号_調査票());
            selectProcessParameter.set発行番号_号(getParameter().get発行番号の号_調査票());
            selectProcessParameter.set転出期間_開始日(getParameter().get転出期間_調査票().get(0));
            selectProcessParameter.set転出期間_終了日(getParameter().get転出期間_調査票().get(1));
            executeStep(二重登録調査票照会);
            batchPrintProcessParameter.set二重登録調査票照会出力数(getResult(Integer.class,
                    new RString(二重登録調査票照会), NijuTorokuChosaShokaiReportProcess.PAGE_COUNT));
            帳票ID = ReportIdKeys.二重登録調査票_回答.value();
            executeStep(二重登録調査票回答);
            batchPrintProcessParameter.set二重登録調査票回答出力数(getResult(Integer.class,
                    new RString(二重登録調査票回答), NijuTorokuChosaKaitoReportProcess.PAGE_COUNT));
            // 　TODO 現段階に帳票「AFAPRA214_SofusakiAtenaSeal」を実装しない
//            if (getParameter().get送付先宛名シール作成有無_調査票()) {
//                if (("12").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    batchPrintProcessParameter.set帳票ID(ReportIdKeys.送付先宛名シール作成.value());
//                } else if (("21").equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体).toString())) {
//                    batchPrintProcessParameter.set帳票ID(ReportIdKeys.送付先宛名シール作成_21.value());
//                }
//
//                executeStep(送付先宛名シール帳票出力);
//            }　
            //AFAPRA112_NijuTorokuTsuchishoList
            if (getParameter().get二重調査票一覧表作成有無_調査票()) {
                batchPrintProcessParameter.set帳票ID(ReportIdKeys.二重登録調査一覧表.value());
                batchPrintProcessParameter.set帳票名(ReportIdKeys.二重登録調査一覧表.getName());
                executeStep(二重登録調査一覧表);
                batchPrintProcessParameter.set二重調査票一覧表作成_調査票数(getResult(Integer.class,
                        new RString(二重登録調査一覧表), NijuTorokuTyosaListReportProcess.PAGE_COUNT));
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.7「登録者名簿」帳票出力（AFAPRA105_ShinkiTorokushaMeibo）">　
    private void 登録者名簿出力() {
        if (getParameter().get登録者名簿出力有無()) {
            帳票ID = ReportIdKeys.新規登録者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(登録者名簿帳票出力);
            batchPrintProcessParameter.set登録者名簿出力数(getResult(Integer.class,
                    new RString(登録者名簿帳票出力), ShinkiTorokushaMeiboReportProcess.PAGE_COUNT));

            if (getParameter().get縦覧用作成有無_登録者()) {
                executeStep(縦覧用_登録者帳票出力);
                batchPrintProcessParameter.set登録者名簿縦覧出力数(getResult(Integer.class,
                        new RString(縦覧用_登録者帳票出力), ShinkiTorokushaMeiboJuranReportProcess.PAGE_COUNT));
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.8「帰化対象者名簿」帳票出力（AFAPRA107_KikaTaishoshaList）">　
    private void 帰化対象者名簿出力() {
        if (getParameter().get帰化対象者名簿出力有無()) {
            帳票ID = ReportIdKeys.帰化対象者リスト.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(帰化対象者名簿帳票出力);
            batchPrintProcessParameter.set帰化対象者名簿出力数(getResult(Integer.class,
                    new RString(帰化対象者名簿帳票出力), KikaTaishoshaListReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.9「抹消者名簿」帳票出力（AFAPRA105_MasshoshaMeibo）">　
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.9「抹消者名簿」帳票出力（AFAPRA105_MasshoshaMeibo）">　
    private void 抹消予定者名簿出力() {
        if (getParameter().get抹消予定者名簿出力有無()) {
            帳票ID = ReportIdKeys.抹消予定者名簿.value();
            selectProcessParameter.setSelectKijun(BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体));
            selectProcessParameter.set転出期間_終了日(getParameter().get投票日().minusMonth(四月));
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(抹消予定者名簿帳票出力);
            batchPrintProcessParameter.set抹消予定者名簿出力数(getResult(Integer.class,
                    new RString(抹消予定者名簿帳票出力), MasshoshaYoteishaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.10「失榷者名簿」帳票出力（AFAPRA105_KyojuMasshoshaMeibo）">　
    private void 失榷者名簿出力() {
        if (getParameter().get失権者名簿出力有無()) {
            帳票ID = ReportIdKeys.失権者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(失榷者名簿帳票出力);
            batchPrintProcessParameter.set失権者名簿出力数(getResult(Integer.class,
                    new RString(失榷者名簿帳票出力), ShikkenshaMeiboReportProcess.PAGE_COUNT));
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="3.10「居住要件抹消者名簿」帳票出力（AFAPRA105_KyojuMasshoshaMeibo）">　
    private void 居住要件抹消者名簿出力() {
        if (getParameter().get居住要件抹消者名簿出力有無()) {
            帳票ID = ReportIdKeys.居住要件抹消者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(居住要件抹消者名簿帳票出力);
            batchPrintProcessParameter.set居住要件抹消者名簿出力数(getResult(Integer.class,
                    new RString(居住要件抹消者名簿帳票出力), KyojuMasshoshaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.11「表示者名簿」帳票出力（AFAPRA105_HyojishaMeibo）">　
    private void 表示者名簿出力() {
        if (getParameter().get表示者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(表示者名簿帳票出力);
            batchPrintProcessParameter.set表示者名簿出力数(getResult(Integer.class,
                    new RString(表示者名簿帳票出力), HyojishaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.12「表示消除予定者名簿」帳票出力（AFAPRA105_HyojiShojoshaMeibo）">　
    private void 表示消除予定者名簿出力() {
        if (getParameter().get表示消除予定者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示消除予定者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(表示消除予定者名簿帳票出力);
            batchPrintProcessParameter.set表示消除予定者名簿出力数(getResult(Integer.class,
                    new RString(表示消除予定者名簿帳票出力), HyojishojoYoteishaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.12「表示消除者名簿」帳票出力（AFAPRA105_HyojiShojoshaMeibo）">　
    private void 表示消除者名簿出力() {
        if (getParameter().get表示消除者名簿出力有無()) {
            帳票ID = ReportIdKeys.表示消除者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(表示消除者名簿帳票出力);
            batchPrintProcessParameter.set表示消除者名簿出力数(getResult(Integer.class,
                    new RString(表示消除者名簿帳票出力), HyojiShojoshaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.14「規定年齢未到達者名簿」帳票出力（AFAPRA105_MitotatsushaMeibo）">　
    private void 規定年齢未到達者名簿出力() {
        if (getParameter().get規定年齢未到達者名簿出力有無()) {
            帳票ID = ReportIdKeys.規定年齢未到達者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(規定年齢未到達者名簿帳票出力);
            batchPrintProcessParameter.set規定年齢未到達者名簿出力数(getResult(Integer.class,
                    new RString(規定年齢未到達者名簿帳票出力), MitotatsushaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.15「再転入者名簿」帳票出力（AFAPRA105_SaiTennyushaMeibo）">　
    private void 再転入者名簿出力() {
        if (getParameter().get再転入者名簿出力有無()) {
            帳票ID = ReportIdKeys.再転入者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(再転入者名簿帳票出力);
            batchPrintProcessParameter.set再転入者名簿出力数(getResult(Integer.class,
                    new RString(再転入者名簿帳票出力), SaiTennyushaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.16「訂正者名簿」帳票出力（AFAPRA108_TeiseishaMeibo）">　
    private void 訂正者名簿出力() {
        if (getParameter().get訂正者名簿出力有無()) {
            帳票ID = ReportIdKeys.訂正者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(訂正者名簿帳票出力);
            batchPrintProcessParameter.set訂正者名簿出力数(getResult(Integer.class,
                    new RString(訂正者名簿帳票出力), TeiseishaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.17「転出者名簿」帳票出力（AFAPRA105_TenshutsushaMeibo）">　
    private void 転出者名簿出力() {
        if (getParameter().get転出者名簿出力有無()) {
            帳票ID = ReportIdKeys.転出者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(転出者名簿帳票出力);
            batchPrintProcessParameter.set転出者名簿出力数(getResult(Integer.class,
                    new RString(転出者名簿帳票出力), TenshutsushaMeiboReportProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.18「登録停止者名簿」帳票出力（AFAPRA109_TorokuTeishishaMeibo）">　
    private void 登録停止者名簿出力() {
        if (getParameter().get登録停止者名簿出力有無()) {
            帳票ID = ReportIdKeys.登録停止者名簿.value();
            selectProcessParameter.setSort(getソート順WithMaster(帳票ID));
            executeStep(登録停止者名簿帳票出力);
            batchPrintProcessParameter.set登録停止者名簿出力数(getResult(Integer.class,
                    new RString(登録停止者名簿帳票出力), TorokuTeishishaMeiboProcess.PAGE_COUNT));
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.20「在外選挙人名簿抄本」帳票出力（AFAPRB300_MeiboShohonZaigai）">
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

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="3.21「在外投票資格者名簿」帳票出力（AFAPRB309_ZaigaiShikakushaMeibo）">　
    //private void 在外投票資格者名簿出力() {
    //if (getParameter().get在外投票資格者名簿出力有無()) {
    //executeStep(在外投票資格者名簿帳票出力);
    //}
    //}
    // </editor-fold>
    private RString get在外ソート順(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            return MyBatisOrderByClauseCreator.create(ZaigaiTourokuOutputType.class, 帳票出力順.get(0));
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

    private RString get改頁項目ID(RString 帳票ID) {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {

            return ReportOutputType.getMyBatis項目名(帳票出力順.get(0).get改頁項目ID());
        } else {
            return RString.EMPTY;
        }
    }

}
