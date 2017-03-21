/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.flow.AFAMNB2010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.IkkatsuDaikouprintsoufuhyohenshuProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuAfT100ShohonUpdateProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuAtenaSeal12ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuAtenaSeal21ReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNninIjoSetaiListDataSelectProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNninIjoSetaiListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujoken3tsuoriKibunReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujoken3tsuoriReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenHagakiKibunReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenHagakiReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenMaisuhyoReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenPostexKibunReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenPostexReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenSealerReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuNyujokenSealerkibunReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.NyujokenIkkatsuTestPrintDataListProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.TenshutsuOshiraseHagakiListReportProcess;
import jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010.TenshutsuOshiraseHagakiReportProcess;
import jp.co.ndensan.reams.af.afa.business.core.NninIjoSetaiListReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu.NyujokenIkkatsuEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.AFABTB201BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAInsakuTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 入場券発行（一括）のバッチ処理クラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class AFABTB201_NyujokenIkkatsuFlow extends BatchFlowBase<AFABTB201BatchParameter> {

    private AFABTB201SelectProcessParameter selectProcessParameter;
    private List<IOutputOrder> 帳票出力順;
    private RString 帳票ID;
    private static final RString 出力条件_抄本番号 = new RString("【抄本番号】 ");
    private static final RString 出力条件_入場券名1 = new RString("【入場券名1】 ");
    private static final RString 出力条件_入場券名2 = new RString("【入場券名2】 ");
    private static final RString 出力条件_入場券名3 = new RString("【入場券名3】 ");
    private static final RString 出力条件_出力対象 = new RString("【出力対象】 ");
    private static final RString 出力条件_投票区 = new RString("【投票区】 ");
    private static final RString 出力対象_住民分 = new RString("住民分");
    private static final RString 出力対象_転出者分 = new RString("転出者分");
    private static final RString 出力対象_住民分と転出者分 = new RString("住民分、転出者分");
    private static final RString 出力条件_印刷タイプ = new RString("【印刷タイプ】 ");
    private static final RString 出力条件_世帯印字人数 = new RString("【世帯印字人数】 ");
    private static final RString 出力条件_一世帯で複数枚作成 = new RString("【一世帯で複数枚作成される世帯の一覧表を作成する】 ");
    private static final RString 出力条件_抽出対象世帯人数 = new RString("【抽出対象世帯人数】 ");
    private static final RString 出力条件_転出日 = new RString("【転出日】 ");
    private static final RString 出力条件_二重登録抹消者分 = new RString("【二重登録抹消者分も含める】 ");
    private static final RString 出力条件_宛名シール = new RString("【宛名シールも発行する】 ");
    private static final RString 出力内容_連絡符号１ = new RString("、");
    private static final RString 出力内容_連絡符号2 = new RString("～");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString 出力内容_有り = new RString("有り");
    private static final RString 出力内容_無し = new RString("無し");
    private static final String 有権者_個票3つ折り_出力 = "有権者_個票3つ折り";
    private static final String 有権者_個票3つ折り_文字切れ別出力 = "有権者_個票3つ折り_文字切れ別出力";
    private static final String 表示者_個票3つ折り_出力 = "表示者_個票3つ折り";
    private static final String 表示者_個票3つ折り_文字切れ別出力 = "表示者_個票3つ折り_文字切れ別出力";
    private static final String 有権者_はがき4つ切り_出力 = "有権者_はがき4つ切り_出力";
    private static final String 有権者_はがき4つ切り_文字切れ別出力 = "有権者_はがき4つ切り_文字切れ別出力";
    private static final String 表示者_はがき4つ切り_出力 = "表示者_はがき4つ切り_出力";
    private static final String 表示者_はがき4つ切り_文字切れ別出力 = "表示者_はがき4つ切り_文字切れ別出力";
    private static final String 有権者_シーラー_出力 = "有権者_シーラー_出力";
    private static final String 有権者_シーラー_文字切れ別出力 = "有権者_シーラー_文字切れ別出力";
    private static final String 表示者_シーラー_出力 = "表示者_シーラー_出力";
    private static final String 表示者_シーラー_文字切れ別出力 = "表示者_シーラー_文字切れ別出力";
    private static final String 有権者_ポステックス_出力 = "有権者_投票所入場券_ポステックス_出力";
    private static final String 有権者_ポステックス_文字切れ別出力 = "有権者_投票所入場券_ポステックス_文字切れ別出力";
    private static final String 表示者_ポステックス_出力 = "表示者_投票所入場券_ポステックス_出力";
    private static final String 表示者_ポステックス_文字切れ別出力 = "表示者_投票所入場券_ポステックス_文字切れ別出力";
    private static final String 転出者お知らせハガキ_出力 = "転出者お知らせハガキ_出力";
    private static final String 転出者お知らせハガキ作成対象者一覧表_出力 = "転出者お知らせハガキ作成対象者一覧表_出力";
    private static final String 投票所入場券印刷枚数表_出力 = "投票所入場券印刷枚数表_出力";
    private static final String N人以上世帯一覧表_出力 = "N人以上世帯一覧表_出力";
    private static final String 代行プリント送付票_出力 = "代行プリント送付票_出力";
    private static final String 入場券テストデータ抽出一覧表_出力 = "入場券テストデータ抽出一覧表_出力";
    private static final String 送付先情報データ検索 = "送付先情報データ検索";
    private static final String 世帯一覧表情報_データ検索 = "世帯一覧表情報_データ検索";
    private static final String 帳票固有番号_データ更新 = "帳票固有番号_データ更新";
    private static final RString 有権者分 = new RString("1");
    private static final RString 表示者分 = new RString("2");
    private static final RString 再転入者分 = new RString("3");
    private static final RString TEMP_TABLE_NYUJOKENMAISUHYO = new RString("AFAPRB212_NyujokenMaisuhyo");
    private final List<ReportOutputJokenhyoItem> reportOutputJokenhyoItems = new ArrayList<>();
    private final List<Decimal> nyujokenReportIndexList = new ArrayList<>();
    private final List<RString> 帳票名リスト = new ArrayList<>();
    private final List<Decimal> ページ数リスト = new ArrayList<>();
    private final List<RString> 出力順リスト = new ArrayList<>();
    private final List<RString> 改頁条件リスト = new ArrayList<>();
    private final List<RString> 詳細設定リスト = new ArrayList<>();
    private final List<RString> コピー元パースリスト = new ArrayList<>();
    private static final RString ページコント = new RString("pageCount");
    private static final RString 入場券発行固有連番 = new RString("nyujokenReportIndex");
    private static final RString コピー元パース = new RString("imageFolderPath");
    private static final RString 発行日_START = new RString("発行日　　");
    private static int 投票所入場券出力ページ数;
    private Association association;
    private static final String 宛名シール12面_面数出力 = "宛名シール12面";
    private static final String 宛名シール21面_面数出力 = "宛名シール21面";

    @Override
    protected void prepareConfigData() {
        getParameter().setサンプル文字(RString.EMPTY);
        投票所入場券出力ページ数 = 0;
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        association = associationFinder.getAssociation();
        selectProcessParameter = getParameter().toAFABTB201SelectProcessParameter();
    }

    @Override
    protected void defineFlow() {
        入場券発行_送付先情報データ検索();
        入場券出力();
        入場券発行_投票所入場券印刷枚数表_出力();
        入場券発行_世帯一覧表情報_データ検索();
        入場券発行_N人以上世帯一覧表_出力();
        入場券発行_代行プリント送付票_出力();
        入場券発行_入場券テストデータ抽出一覧表_出力();
        バッチ出力条件リスト出力();
        地図情報のイメージファイルのコピー();
        入場券発行_帳票固有番号データ更新();
    }

    @Step(送付先情報データ検索)
    IBatchFlowCommand get送付先情報_データ検索() {
        return loopBatch(NyujokenIkkatsuDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_個票3つ折り_出力)
    IBatchFlowCommand get有権者_個票3つ折り_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujoken3tsuoriReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_個票3つ折り_文字切れ別出力)
    IBatchFlowCommand get有権者_個票3つ折り_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujoken3tsuoriKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_個票3つ折り_出力)
    IBatchFlowCommand get表示者_個票3つ折り_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujoken3tsuoriReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_個票3つ折り_文字切れ別出力)
    IBatchFlowCommand get表示者_個票3つ折り_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujoken3tsuoriKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_はがき4つ切り_出力)
    IBatchFlowCommand get有権者_はがき4つ切り_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenHagakiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_はがき4つ切り_文字切れ別出力)
    IBatchFlowCommand get有権者_はがき4つ切り_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenHagakiKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_はがき4つ切り_出力)
    IBatchFlowCommand get表示者_はがき4つ切り_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenHagakiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_はがき4つ切り_文字切れ別出力)
    IBatchFlowCommand get表示者_はがき4つ切り_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenHagakiKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_シーラー_出力)
    IBatchFlowCommand get有権者_シーラー_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenSealerReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_シーラー_文字切れ別出力)
    IBatchFlowCommand get有権者_シーラー_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenSealerkibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_シーラー_出力)
    IBatchFlowCommand get表示者_シーラー_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenSealerReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_シーラー_文字切れ別出力)
    IBatchFlowCommand get表示者_シーラー_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenSealerkibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_ポステックス_出力)
    IBatchFlowCommand get有権者_ポステックス_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenPostexReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(有権者_ポステックス_文字切れ別出力)
    IBatchFlowCommand get有権者_ポステックス_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        return loopBatch(NyujokenIkkatsuNyujokenPostexKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_ポステックス_出力)
    IBatchFlowCommand get表示者_ポステックス_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenPostexReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(表示者_ポステックス_文字切れ別出力)
    IBatchFlowCommand get表示者_ポステックス_文字切れ別出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(NyujokenIkkatsuNyujokenPostexKibunReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(転出者お知らせハガキ_出力)
    IBatchFlowCommand get転出者お知らせハガキ_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(TenshutsuOshiraseHagakiReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(転出者お知らせハガキ作成対象者一覧表_出力)
    IBatchFlowCommand get転出者お知らせハガキ作成対象者一覧表_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setGroupKubun(表示者分);
        return loopBatch(TenshutsuOshiraseHagakiListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(宛名シール12面_面数出力)
    IBatchFlowCommand get宛名シール12面_面数出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(再転入者分);
        return loopBatch(NyujokenIkkatsuAtenaSeal12ReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(宛名シール21面_面数出力)
    IBatchFlowCommand get宛名シール21面_面数出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setGroupKubun(再転入者分);
        return loopBatch(NyujokenIkkatsuAtenaSeal21ReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(投票所入場券印刷枚数表_出力)
    IBatchFlowCommand get投票所入場券印刷枚数表_出力() {
        selectProcessParameter.setTable(TEMP_TABLE_NYUJOKENMAISUHYO);
        return loopBatch(NyujokenIkkatsuNyujokenMaisuhyoReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(世帯一覧表情報_データ検索)
    IBatchFlowCommand get世帯一覧表情報_データ検索() {
        return loopBatch(NyujokenIkkatsuNninIjoSetaiListDataSelectProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(N人以上世帯一覧表_出力)
    IBatchFlowCommand getN人以上世帯一覧表_出力() {
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(世帯一覧表情報_データ検索), NyujokenIkkatsuNninIjoSetaiListDataSelectProcess.OUT_TEMP_TABLE_NAME));
        selectProcessParameter.setSoufusakiJouhoutable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.OUT_TEMP_TABLE_NAME));
        return loopBatch(NyujokenIkkatsuNninIjoSetaiListReportProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(代行プリント送付票_出力)
    IBatchFlowCommand get代行プリント送付票_出力() {
        selectProcessParameter.set改頁条件リスト(改頁条件リスト);
        selectProcessParameter.setページ数リスト(ページ数リスト);
        selectProcessParameter.set出力順リスト(出力順リスト);
        selectProcessParameter.set帳票名リスト(帳票名リスト);
        selectProcessParameter.set詳細設定リスト(詳細設定リスト);
        selectProcessParameter.setジョブ番号(new RString(String.valueOf(getJobId())));
        return simpleBatch(IkkatsuDaikouprintsoufuhyohenshuProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(入場券テストデータ抽出一覧表_出力)
    IBatchFlowCommand get入場券テストデータ抽出一覧表_出力() {
        selectProcessParameter.setSetaiCode(getResult(SetaiCode.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.SETAI_CODE));
        selectProcessParameter.setSetaiCodeCount(getResult(Integer.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.SETAI_CODE_COUNT));
        selectProcessParameter.setTable(getResult(RString.class,
                new RString(送付先情報データ検索), NyujokenIkkatsuDataSelectProcess.MEICI_JYOHOU_TABLE_NAME));
        selectProcessParameter.setGroupKubun(有権者分);
        selectProcessParameter.set帳票ID(ReportIdKeys.AFAPRB214_入場券テストデータ抽出一覧表.value());
        return loopBatch(NyujokenIkkatsuTestPrintDataListProcess.class).arguments(selectProcessParameter).define();
    }

    @Step(帳票固有番号_データ更新)
    IBatchFlowCommand get帳票固有番号_データ更新() {
        selectProcessParameter.set入場券発行固有連番リスト(nyujokenReportIndexList);
        return loopBatch(NyujokenIkkatsuAfT100ShohonUpdateProcess.class).arguments(selectProcessParameter).define();
    }

    private void 入場券発行_帳票固有番号データ更新() {
        executeStep(帳票固有番号_データ更新);
    }

    private void 入場券発行_送付先情報データ検索() {
        executeStep(送付先情報データ検索);
    }

    private void 入場券発行_世帯一覧表情報_データ検索() {
        if (getParameter().is抽出対象世帯人数有無()) {
            executeStep(世帯一覧表情報_データ検索);
        }
    }

    private void 入場券出力() {

        入場券有権者分出力();
        入場券表示者分出力();
        RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        get投票所入場券出力帳票の総ページ数(入場券_印刷タイプ);
    }

    private void 入場券有権者分出力() {
        RString 文字切れ入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力しない.configKeyValue().equals(文字切れ入場券出力区分)) {
            投票所入場券個票有権者出力();
        } else if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力する.configKeyValue().equals(文字切れ入場券出力区分)) {
            投票所入場券個票_文字切れ有権者別出力();
        }
    }

    private void 入場券表示者分出力() {
        RString 表示者用入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.入場券_表示者用入場券出力区分_入場券で出力する.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            RString 文字切れ入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_文字切れ入場券出力区分, SubGyomuCode.AFA選挙本体);
            if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力しない.configKeyValue().equals(文字切れ入場券出力区分)) {
                投票所入場券個票表示者出力();
            } else if (AFAConfigKeysValue.入場券_文字切れ入場券出力区分_別出力する.configKeyValue().equals(文字切れ入場券出力区分)) {
                投票所入場券個票_文字切れ表示者別出力();
            }
        } else if (AFAConfigKeysValue.入場券_表示者用入場券出力区分_転出者お知らせはがきで出力する.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            入場券発行_転出者お知らせハガキ_出力();
            入場券発行_転出者お知らせハガキ作成対象者一覧表_出力();
            入場券発行宛名シール出力();
        }
    }

    private void 投票所入場券個票_文字切れ有権者別出力() {
        Boolean 住民分有無 = getParameter().is住民分有無();
        if (住民分有無 != null && 住民分有無) {
            RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
            投票所入場券個票_3つ折り_文字切れ有権者別出力(入場券_印刷タイプ);
            投票所入場券個票_はがき4つ切り_文字切れ有権者別出力(入場券_印刷タイプ);
            投票所入場券個票_シーラー_文字切れ有権者別出力(入場券_印刷タイプ);
            投票所入場券個票_ポステックス_文字切れ有権者別出力(入場券_印刷タイプ);
        }
    }

    private void 投票所入場券個票_文字切れ表示者別出力() {
        RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        投票所入場券個票_3つ折り_文字切れ表示者別出力(入場券_印刷タイプ);
        投票所入場券個票_はがき4つ切り_文字切れ表示者別出力(入場券_印刷タイプ);
        投票所入場券個票_シーラー_文字切れ表示者別出力(入場券_印刷タイプ);
        投票所入場券個票_ポステックス_文字切れ表示者別出力(入場券_印刷タイプ);
    }

    private void 投票所入場券個票有権者出力() {
        Boolean 住民分有無 = getParameter().is住民分有無();
        if (住民分有無 != null && 住民分有無) {
            RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
            投票所入場券個票_3つ折り_有権者出力(入場券_印刷タイプ);
            投票所入場券個票_はがき4つ切り_有権者出力(入場券_印刷タイプ);
            投票所入場券個票_シーラー_有権者出力(入場券_印刷タイプ);
            投票所入場券個票_ポステックス_有権者出力(入場券_印刷タイプ);
        }
    }

    private void 投票所入場券個票表示者出力() {
        RString 入場券_印刷タイプ = BusinessConfig.get(ConfigKeysAFA.入場券_印刷タイプ, SubGyomuCode.AFA選挙本体);
        投票所入場券個票_3つ折り_表示者出力(入場券_印刷タイプ);
        投票所入場券個票_はがき4つ切り_表示者出力(入場券_印刷タイプ);
        投票所入場券個票_シーラー_表示者出力(入場券_印刷タイプ);
        投票所入場券個票_ポステックス_表示者出力(入場券_印刷タイプ);
    }

    private void 入場券発行宛名シール出力() {
        if (getParameter().is宛名シールも発行する有無() != null
                && getParameter().is宛名シールも発行する有無()) {
            RString 宛名シール_面数 = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
            入場券発行_宛名シール12面_出力(宛名シール_面数);
            入場券発行_宛名シール21面_出力(宛名シール_面数);
        }
    }

    private void 投票所入場券個票_3つ折り_有権者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_個票3つ折り_出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_個票3つ折り_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_個票3つ折り_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_個票3つ折り_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_個票3つ折り_出力, ページコント)));
            RString 帳票名_個票3つ折り = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.getReportName();
            帳票名リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_個票3つ折り);
            詳細設定リスト.add(発行日);
            出力順リスト.add(帳票名_個票3つ折り);
            出力順リスト.add(get出力順項目(帳票ID));
        }
    }

    private void 投票所入場券個票_3つ折り_表示者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_個票3つ折り_出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_個票3つ折り_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_個票3つ折り_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_個票3つ折り_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_個票3つ折り_出力, ページコント)));
            RString 帳票名_個票3つ折り = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.getReportName();
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_個票3つ折り);
            詳細設定リスト.add(発行日);
            改頁条件リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            帳票名リスト.add(帳票名_個票3つ折り);
            出力順リスト.add(帳票名_個票3つ折り);
            出力順リスト.add(get出力順項目(帳票ID));
        }
    }

    private void 投票所入場券個票_3つ折り_文字切れ有権者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_個票3つ折り_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_個票3つ折り_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_個票3つ折り_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_個票3つ折り_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_個票3つ折り_文字切れ別出力, ページコント)));
            RString 帳票名_個票3つ折り = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.getReportName();
            出力順リスト.add(帳票名_個票3つ折り);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            帳票名リスト.add(帳票名_個票3つ折り);
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_個票3つ折り);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_3つ折り_文字切れ表示者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_個票3つ折り_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_個票3つ折り_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_個票3つ折り_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_個票3つ折り_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_個票3つ折り_文字切れ別出力, ページコント)));
            RString 帳票名_個票3つ折り = ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.getReportName();
            帳票名リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(帳票名_個票3つ折り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_個票3つ折り);
            詳細設定リスト.add(発行日);
            出力順リスト.add(帳票名_個票3つ折り);
            出力順リスト.add(get出力順項目(帳票ID));
        }
    }

    private void 投票所入場券個票_はがき4つ切り_有権者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_はがき4つ切り_出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_はがき4つ切り_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_はがき4つ切り_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_はがき4つ切り_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_はがき4つ切り_出力, ページコント)));
            RString 帳票名_はがき4つ切り = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.getReportName();
            帳票名リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_はがき4つ切り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_はがき4つ切り);
            詳細設定リスト.add(発行日);

        }
    }

    private void 投票所入場券個票_はがき4つ切り_表示者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_はがき4つ切り_出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_はがき4つ切り_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_はがき4つ切り_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_はがき4つ切り_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_はがき4つ切り_出力, ページコント)));
            RString 帳票名_はがき4つ切り = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.getReportName();
            帳票名リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(get出力順項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_はがき4つ切り);
            詳細設定リスト.add(発行日);
            改頁条件リスト.add(帳票名_はがき4つ切り);
            改頁条件リスト.add(get改頁項目(帳票ID));
        }
    }

    private void 投票所入場券個票_はがき4つ切り_文字切れ有権者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_はがき4つ切り_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_はがき4つ切り_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_はがき4つ切り_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_はがき4つ切り_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_はがき4つ切り_文字切れ別出力, ページコント)));
            RString 帳票名_はがき4つ切り = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.getReportName();
            帳票名リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_はがき4つ切り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_はがき4つ切り);
            詳細設定リスト.add(発行日);

        }
    }

    private void 投票所入場券個票_はがき4つ切り_文字切れ表示者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_はがき4つ切り_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_はがき4つ切り_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_はがき4つ切り_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_はがき4つ切り_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_はがき4つ切り_文字切れ別出力, ページコント)));
            RString 帳票名_はがき4つ切り = ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.getReportName();
            帳票名リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(帳票名_はがき4つ切り);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_はがき4つ切り);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_はがき4つ切り);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_シーラー_有権者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_シーラー_出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_シーラー_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_シーラー_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_シーラー_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_シーラー_出力, ページコント)));
            RString 帳票名_シーラー = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.getReportName();
            帳票名リスト.add(帳票名_シーラー);
            出力順リスト.add(帳票名_シーラー);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_シーラー);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_シーラー);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_シーラー_表示者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_シーラー_出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_シーラー_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_シーラー_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_シーラー_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_シーラー_出力, ページコント)));
            RString 帳票名_シーラー = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.getReportName();
            帳票名リスト.add(帳票名_シーラー);
            出力順リスト.add(帳票名_シーラー);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_シーラー);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_シーラー);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_シーラー_文字切れ有権者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_シーラー_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_シーラー_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_シーラー_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_シーラー_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_シーラー_文字切れ別出力, ページコント)));
            RString 帳票名_シーラー = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.getReportName();
            帳票名リスト.add(帳票名_シーラー);
            出力順リスト.add(帳票名_シーラー);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_シーラー);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_シーラー);
            詳細設定リスト.add(発行日);

        }
    }

    private void 投票所入場券個票_シーラー_文字切れ表示者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_シーラー_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_シーラー_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_シーラー_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_シーラー_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_シーラー_文字切れ別出力, ページコント)));
            RString 帳票名_シーラー = ReportIdKeys.AFAPRB203_投票所入場券_シーラー.getReportName();
            帳票名リスト.add(帳票名_シーラー);
            出力順リスト.add(帳票名_シーラー);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_シーラー);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_シーラー);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_ポステックス_有権者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_ポステックス_出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_ポステックス_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_ポステックス_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_ポステックス_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_ポステックス_出力, ページコント)));
            RString 帳票名_ポステックス = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.getReportName();
            帳票名リスト.add(帳票名_ポステックス);
            出力順リスト.add(帳票名_ポステックス);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_ポステックス);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_ポステックス);
            詳細設定リスト.add(発行日);
        }
    }

    private void 投票所入場券個票_ポステックス_表示者出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_ポステックス_出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_ポステックス_出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_ポステックス_出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_ポステックス_出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_ポステックス_出力, ページコント)));
            RString 帳票名_ポステックス = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.getReportName();

            帳票名リスト.add(帳票名_ポステックス);
            出力順リスト.add(帳票名_ポステックス);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_ポステックス);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_ポステックス);
            詳細設定リスト.add(発行日);

        }
    }

    private void 投票所入場券個票_ポステックス_文字切れ有権者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(有権者_ポステックス_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 有権者_ポステックス_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 有権者_ポステックス_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 有権者_ポステックス_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 有権者_ポステックス_文字切れ別出力, ページコント)));
            RString 帳票名_ポステックス = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.getReportName();

            帳票名リスト.add(帳票名_ポステックス);
            出力順リスト.add(帳票名_ポステックス);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_ポステックス);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_ポステックス);
            詳細設定リスト.add(発行日);

        }
    }

    private void 投票所入場券個票_ポステックス_文字切れ表示者別出力(RString 入場券_印刷タイプ) {
        if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            帳票ID = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(表示者_ポステックス_文字切れ別出力);
            コピー元パースリスト.addAll(getResult(List.class, 表示者_ポステックス_文字切れ別出力, コピー元パース));
            投票所入場券出力ページ数 = 投票所入場券出力ページ数 + getResult(Integer.class, 表示者_ポステックス_文字切れ別出力, ページコント);
            nyujokenReportIndexList.add(getResult(Decimal.class, 表示者_ポステックス_文字切れ別出力, 入場券発行固有連番));
            ページ数リスト.add(new Decimal(getResult(Integer.class, 表示者_ポステックス_文字切れ別出力, ページコント)));
            RString 帳票名_ポステックス = ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.getReportName();

            帳票名リスト.add(帳票名_ポステックス);
            出力順リスト.add(帳票名_ポステックス);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_ポステックス);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_ポステックス);
            詳細設定リスト.add(発行日);
        }
    }

    private void 入場券発行_宛名シール12面_出力(RString 宛名シール_面数) {
        if (AFAConfigKeysValue.宛名シール_面数_12面.configKeyValue().equals(宛名シール_面数)) {
            帳票ID = ReportIdKeys.AFAPRE213_宛名シール12面.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(宛名シール12面_面数出力);
            コピー元パースリスト.addAll(getResult(List.class, 宛名シール12面_面数出力, コピー元パース));
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 宛名シール12面_面数出力, ページコント),
                    ReportIdKeys.AFAPRE213_宛名シール12面));
            nyujokenReportIndexList.add(getResult(Decimal.class, 宛名シール12面_面数出力, 入場券発行固有連番));
            RString 帳票名_宛名シール12面 = ReportIdKeys.AFAPRE213_宛名シール12面.getReportName();
            帳票名リスト.add(帳票名_宛名シール12面);
            ページ数リスト.add(new Decimal(getResult(Integer.class, 宛名シール12面_面数出力, ページコント)));
            出力順リスト.add(帳票名_宛名シール12面);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_宛名シール12面);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_宛名シール12面);
            詳細設定リスト.add(発行日);
        }
    }

    private void 入場券発行_宛名シール21面_出力(RString 宛名シール_面数) {
        if (AFAConfigKeysValue.宛名シール_面数_21面.configKeyValue().equals(宛名シール_面数)) {
            帳票ID = ReportIdKeys.AFAPRE214_宛名シール21面.value();
            selectProcessParameter.setOrder順(getソート順(帳票ID));
            selectProcessParameter.set改頁項目IDリスト(get改頁項目ID(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(宛名シール21面_面数出力);
            コピー元パースリスト.addAll(getResult(List.class, 宛名シール21面_面数出力, コピー元パース));
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, 宛名シール21面_面数出力, ページコント),
                    ReportIdKeys.AFAPRE214_宛名シール21面));
            nyujokenReportIndexList.add(getResult(Decimal.class, 宛名シール21面_面数出力, 入場券発行固有連番));
            RString 帳票名_宛名シール21面 = ReportIdKeys.AFAPRE214_宛名シール21面.getReportName();
            帳票名リスト.add(帳票名_宛名シール21面);
            ページ数リスト.add(new Decimal(getResult(Integer.class, 宛名シール21面_面数出力, ページコント)));
            出力順リスト.add(帳票名_宛名シール21面);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_宛名シール21面);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_宛名シール21面);
            詳細設定リスト.add(発行日);

        }
    }

    private void 入場券発行_転出者お知らせハガキ_出力() {
        帳票ID = ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value();
        selectProcessParameter.setOrder順(getソート順(帳票ID));
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(転出者お知らせハガキ_出力);
        コピー元パースリスト.addAll(getResult(List.class, 転出者お知らせハガキ_出力, コピー元パース));
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 転出者お知らせハガキ_出力, ページコント),
                ReportIdKeys.AFAPRB210_転出者お知らせハガキ));
        nyujokenReportIndexList.add(getResult(Decimal.class, 転出者お知らせハガキ_出力, 入場券発行固有連番));
        RString 帳票名_転出者お知らせハガキ = ReportIdKeys.AFAPRB210_転出者お知らせハガキ.getReportName();
        帳票名リスト.add(帳票名_転出者お知らせハガキ);
        ページ数リスト.add(new Decimal(getResult(Integer.class, 転出者お知らせハガキ_出力, ページコント)));
        出力順リスト.add(帳票名_転出者お知らせハガキ);
        出力順リスト.add(get出力順項目(帳票ID));
        改頁条件リスト.add(帳票名_転出者お知らせハガキ);
        改頁条件リスト.add(get改頁項目(帳票ID));
        RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
        詳細設定リスト.add(帳票名_転出者お知らせハガキ);
        詳細設定リスト.add(発行日);
    }

    private void 入場券発行_転出者お知らせハガキ作成対象者一覧表_出力() {
        帳票ID = ReportIdKeys.AFAPRA112_転出者お知らせハガキ作成対象者一覧表.value();
        selectProcessParameter.setOrder順(
                getソート順(ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value()));
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(転出者お知らせハガキ作成対象者一覧表_出力);
        コピー元パースリスト.addAll(getResult(List.class, 転出者お知らせハガキ作成対象者一覧表_出力, コピー元パース));
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 転出者お知らせハガキ作成対象者一覧表_出力, ページコント),
                ReportIdKeys.AFAPRA112_転出者お知らせハガキ作成対象者一覧表));
        nyujokenReportIndexList.add(getResult(Decimal.class, 転出者お知らせハガキ作成対象者一覧表_出力, 入場券発行固有連番));
        RString 帳票名_作成対象者一覧表 = ReportIdKeys.AFAPRA112_転出者お知らせハガキ作成対象者一覧表.getReportName();
        帳票名リスト.add(帳票名_作成対象者一覧表);
        ページ数リスト.add(new Decimal(getResult(Integer.class, 転出者お知らせハガキ作成対象者一覧表_出力, ページコント)));
        出力順リスト.add(帳票名_作成対象者一覧表);
        出力順リスト.add(get出力順項目(帳票ID));
        改頁条件リスト.add(帳票名_作成対象者一覧表);
        改頁条件リスト.add(get改頁項目(帳票ID));
        RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
        詳細設定リスト.add(帳票名_作成対象者一覧表);
        詳細設定リスト.add(発行日);

    }

    private void 入場券発行_投票所入場券印刷枚数表_出力() {
        帳票ID = ReportIdKeys.AFAPRB212_投票所入場券印刷枚数表.value();
        selectProcessParameter.set帳票ID(帳票ID);
        executeStep(投票所入場券印刷枚数表_出力);
        コピー元パースリスト.addAll(getResult(List.class, 投票所入場券印刷枚数表_出力, コピー元パース));
        reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                getResult(Integer.class, 投票所入場券印刷枚数表_出力, ページコント),
                ReportIdKeys.AFAPRB212_投票所入場券印刷枚数表));
        nyujokenReportIndexList.add(getResult(Decimal.class, 投票所入場券印刷枚数表_出力, 入場券発行固有連番));
        RString 帳票名_印刷枚数表 = ReportIdKeys.AFAPRB212_投票所入場券印刷枚数表.getReportName();
        帳票名リスト.add(帳票名_印刷枚数表);
        ページ数リスト.add(new Decimal(getResult(Integer.class, 投票所入場券印刷枚数表_出力, ページコント)));
        出力順リスト.add(帳票名_印刷枚数表);
        出力順リスト.add(get出力順項目(帳票ID));
        改頁条件リスト.add(帳票名_印刷枚数表);
        改頁条件リスト.add(get改頁項目(帳票ID));
        RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
        詳細設定リスト.add(帳票名_印刷枚数表);
        詳細設定リスト.add(発行日);
    }

    private void 入場券発行_N人以上世帯一覧表_出力() {
        if (getParameter().is抽出対象世帯人数有無()) {
            帳票ID = ReportIdKeys.AFAPRB213_n人以上世帯一覧表.value();
            selectProcessParameter.setOrder順(getソート順固定(帳票ID));
            selectProcessParameter.set帳票ID(帳票ID);
            executeStep(N人以上世帯一覧表_出力);
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    getResult(Integer.class, N人以上世帯一覧表_出力, ページコント),
                    ReportIdKeys.AFAPRB213_n人以上世帯一覧表));
            nyujokenReportIndexList.add(getResult(Decimal.class, N人以上世帯一覧表_出力, 入場券発行固有連番));
            RString 帳票名_n人以上世帯一覧表 = ReportIdKeys.AFAPRB213_n人以上世帯一覧表.getReportName();
            帳票名リスト.add(帳票名_n人以上世帯一覧表);
            ページ数リスト.add(new Decimal(getResult(Integer.class, N人以上世帯一覧表_出力, ページコント)));
            出力順リスト.add(帳票名_n人以上世帯一覧表);
            出力順リスト.add(get出力順項目(帳票ID));
            改頁条件リスト.add(帳票名_n人以上世帯一覧表);
            改頁条件リスト.add(get改頁項目(帳票ID));
            RString 発行日 = 発行日_START.concat(edit日時(RDate.getNowDate()));
            詳細設定リスト.add(帳票名_n人以上世帯一覧表);
            詳細設定リスト.add(発行日);
        }

    }

    private void 入場券発行_代行プリント送付票_出力() {
        executeStep(代行プリント送付票_出力);
        nyujokenReportIndexList.add(getResult(Decimal.class, 代行プリント送付票_出力, 入場券発行固有連番));
    }

    private void 入場券発行_入場券テストデータ抽出一覧表_出力() {
        executeStep(入場券テストデータ抽出一覧表_出力);
        nyujokenReportIndexList.add(getResult(Decimal.class, 入場券テストデータ抽出一覧表_出力, 入場券発行固有連番));
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(int 出力ページ数, ReportIdKeys reportId) {
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(getJobId()));
        RString 帳票名 = reportId.getReportName();
        RString ページ数 = new RString(String.valueOf(出力ページ数));
        RString csvファイル名 = reportId.getEucFileName();
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(出力条件_抄本番号.concat(getParameter().get抄本番号().toString()));
        if (ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.equals(reportId)
                || ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.equals(reportId)
                || ReportIdKeys.AFAPRB203_投票所入場券_シーラー.equals(reportId)
                || ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.equals(reportId)) {
            出力条件 = get入場券出力条件リスト(出力条件);
        } else if (ReportIdKeys.AFAPRB213_n人以上世帯一覧表.equals(reportId)) {
            出力条件 = getN人以上世帯一覧表出力条件リスト(出力条件);
        } else if (ReportIdKeys.AFAPRB210_転出者お知らせハガキ.equals(reportId)) {
            出力条件 = get転出お知らせはがき出力条件リスト(出力条件);
        } else if (ReportIdKeys.AFAPRE213_宛名シール12面.equals(reportId)
                || ReportIdKeys.AFAPRE214_宛名シール21面.equals(reportId)) {
            出力条件 = get宛名シール出力条件リスト(出力条件);
        }
        return new ReportOutputJokenhyoItem(reportId.value(), 地方公共団体コード, 市町村名, ジョブ番号,
                帳票名, ページ数, CSV出力有無_有り, csvファイル名, 出力条件);
    }

    private List<RString> get入場券出力条件リスト(List<RString> 出力条件リスト) {
        出力条件リスト.add(出力条件_入場券名1.concat(getParameter().get入場券名1()));
        出力条件リスト.add(出力条件_入場券名2.concat(getParameter().get入場券名2()));
        出力条件リスト.add(出力条件_入場券名3.concat(getParameter().get入場券名3()));
        RString 出力対象 = RString.EMPTY;
        if (getParameter().is住民分有無() && !getParameter().is転出者分有無()) {
            出力対象 = 出力対象_住民分;
        } else if (!getParameter().is住民分有無() && getParameter().is転出者分有無()) {
            出力対象 = 出力対象_転出者分;
        } else if (getParameter().is住民分有無() && getParameter().is転出者分有無()) {
            出力対象 = 出力対象_住民分と転出者分;
        }
        出力条件リスト.add(出力条件_出力対象.concat(出力対象));
        RString 投票区リスト = RString.EMPTY;
        for (TohyokuJyohou 投票区 : getParameter().get投票区リスト()) {
            投票区リスト = 投票区リスト.concat(投票区.get投票区コード()).concat(出力内容_連絡符号１);
        }
        if (投票区リスト.isEmpty()) {
            出力条件リスト.add(出力条件_投票区);
        } else {
            出力条件リスト.add(出力条件_投票区.concat(投票区リスト.substring(0, 投票区リスト.length() - 1)));
        }
        出力条件リスト.add(出力条件_印刷タイプ.concat(get印刷タイプに対応する名称(getParameter().get印刷タイプ())));
        出力条件リスト.add(出力条件_世帯印字人数.concat(doZZZ_ZZ9編集(getParameter().get世帯印字人数())));

        return 出力条件リスト;
    }

    private List<RString> getN人以上世帯一覧表出力条件リスト(List<RString> 出力条件リスト) {
        出力条件リスト.add(出力条件_一世帯で複数枚作成.concat(getParameter().is抽出対象世帯人数有無() ? 出力内容_有り : 出力内容_無し));
        出力条件リスト.add(出力条件_抽出対象世帯人数.concat(doZZZ_ZZ9編集(getParameter().get抽出対象世帯人数())));
        return 出力条件リスト;
    }

    private List<RString> get転出お知らせはがき出力条件リスト(List<RString> 出力条件リスト) {
        RString 転出日From = edit日時(getParameter().get転出日From());
        RString 転出日To = edit日時(getParameter().get転出日To());
        RString 転出日 = RString.EMPTY;
        if (!RString.isNullOrEmpty(転出日From) || !RString.isNullOrEmpty(転出日To)) {
            転出日 = 転出日From.concat(出力内容_連絡符号2).concat(転出日To);
        }
        出力条件リスト.add(出力条件_転出日.concat(転出日));
        出力条件リスト.add(出力条件_二重登録抹消者分.concat(
                getParameter().is二重登録抹消者分も含める有無() != null
                && getParameter().is二重登録抹消者分も含める有無() ? 出力内容_有り : 出力内容_無し));
        return 出力条件リスト;
    }

    private List<RString> get宛名シール出力条件リスト(List<RString> 出力条件リスト) {
        出力条件リスト.add(出力条件_宛名シール.concat(
                getParameter().is宛名シールも発行する有無() != null && getParameter().is宛名シールも発行する有無()
                ? 出力内容_有り : 出力内容_無し));
        return 出力条件リスト;
    }

    private RString get印刷タイプに対応する名称(RString insakuType) {
        if (RString.isNullOrEmpty(insakuType)) {
            return RString.EMPTY;
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_個票3つ折.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_はがき4つ切.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_シーラー.getValue();
        } else if (AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getKey().equals(insakuType)) {
            return AFAInsakuTypeEnum.入場券_印刷タイプ_ポステックス.getValue();
        }

        return RString.EMPTY;
    }

    private RString doZZZ_ZZ9編集(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        } else {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(value.toString()), 0);
        }

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
            return MyBatisOrderByClauseCreator.create(ShisetsuSofushoReportOutputType.class, 帳票出力順.get(0));
        } else {
            return RString.EMPTY;
        }
    }

    private List<RString> get改頁項目ID(RString 帳票ID) {
        List<RString> 改頁項目IDリスト = new ArrayList<>();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
            for (ISetSortItem setSortItem : 帳票出力順.get(0).get設定項目リスト()) {
                if (setSortItem.is改頁項目()) {
                    改頁項目IDリスト.add(setSortItem.get項目ID());
                }
            }
            return 改頁項目IDリスト;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private RString get出力順項目(RString 帳票ID) {
        RString 改頁項目 = RString.EMPTY;
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (帳票出力順 != null && !帳票出力順.isEmpty()) {
            改頁項目 = 帳票出力順.get(0).getFormated出力順項目();
        }
        return 改頁項目;
    }

    private RString get改頁項目(RString 帳票ID) {
        RString 改頁条件 = RString.EMPTY;
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
        if (帳票出力順 != null && !帳票出力順.isEmpty()) {
            改頁条件 = 帳票出力順.get(0).getFormated改頁項目();
        }
        return 改頁条件;
    }

    private RString edit日時(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString edit日時(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString getソート順固定(RString 帳票ID) {
        RString orderBy = RString.EMPTY;
        if (ReportIdKeys.AFAPRB213_n人以上世帯一覧表.value().equals(帳票ID)) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, new ReportId(帳票ID));
            if (null != 帳票出力順 && !帳票出力順.isEmpty()) {
                return MyBatisOrderByClauseCreator.create(NninIjoSetaiListReportOutputType.class, 帳票出力順.get(0));
            } else {
                return RString.EMPTY;
            }
        }
        return orderBy;
    }

    private void get投票所入場券出力帳票の総ページ数(RString 入場券_印刷タイプ) {
        if (投票所入場券出力ページ数 == 0) {
            return;
        }
        if (AFAConfigKeysValue.入場券_印刷タイプ_個票3つ折.configKeyValue().equals(入場券_印刷タイプ)) {
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    投票所入場券出力ページ数,
                    ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り));
        } else if (AFAConfigKeysValue.入場券_印刷タイプ_はがき4つ切.configKeyValue().equals(入場券_印刷タイプ)) {
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    投票所入場券出力ページ数,
                    ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り));
        } else if (AFAConfigKeysValue.入場券_印刷タイプ_シーラー.configKeyValue().equals(入場券_印刷タイプ)) {
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    投票所入場券出力ページ数,
                    ReportIdKeys.AFAPRB203_投票所入場券_シーラー));
        } else if (AFAConfigKeysValue.入場券_印刷タイプ_ポステックス.configKeyValue().equals(入場券_印刷タイプ)) {
            reportOutputJokenhyoItems.add(getReportOutputJokenhyoItem(
                    投票所入場券出力ページ数,
                    ReportIdKeys.AFAPRB204_投票所入場券_ポステックス));
        }
    }

    private void 地図情報のイメージファイルのコピー() {
        RString 地図印字フラッグ = BusinessConfig.get(ConfigKeysAFA.入場券_地図印字, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.印字有無_印字する.configKeyValue().equals(地図印字フラッグ)) {
            return;
        }
        NyujokenIkkatsuEditor nyujokenIkkatsuEditor = new NyujokenIkkatsuEditor();
        if (!コピー元パースリスト.isEmpty()) {
            for (RString パース : コピー元パースリスト) {
                nyujokenIkkatsuEditor.地図情報のイメージファイルのコピー(パース);
            }
        }
    }
}
