/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishoCheckListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuTorokuMeiboJoho;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.KaikuSenkyoFuzuiDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboKaikuSenkyoDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboSenkyoDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboSenkyoShikakuDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.SakuseiKaikuMeiboDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.ShohonDBEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK101.ShinseishoCheckListKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectTempTableMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.af.afa.service.meibosakuseikaiku.MeiboSakuseiKaikuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 申請書チェックリストを出力する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class ShinseishoReportProcess extends BatchKeyBreakBase<MeiboTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select申請書リスト");

    private AFABTK101SelectProcessParameter processParameter;

    private SelectTempTableMybatisParameter mybatisParameter;

    private RString エラー事由１;
    private RString エラー事由２;
    private RString エラー事由３;
    private RString エラー事由４;
    private RString エラー事由５;
    private RString エラー事由６;
    private RString エラー事由７;

    private static final RString キー不一致 = new RString("キー不一致");
    private static final RString 規定年齢未満 = new RString("規定年齢未満");
    private static final RString 死亡者_3 = new RString("死亡者");
    private static final RString 消除者_4 = new RString("消除者");
    private static final RString 識別コード重複 = new RString("識別コード重複");
    private static final RString 漁業日数不足 = new RString("漁業日数不足");
    private static final RString 投票区なし = new RString("投票区なし");

    private RString 処理種別;

    private int 頁;

    private ShisetsuTorokuMeiboJoho 海区選挙人名簿;
    private RString 選挙資格到達年齢_海区選挙;

    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT133KaikuSenkyoFuzuiEntity 海区付随情報Entity;

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT131KaikuSenkyoEntity 海区名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;

    private RString ページ行数;

    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private int 連番;

    private int count;

    private ShohonNo 抄本番号;

    private List<ShohonNo> 抄本番号List;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    private MeiboSakuseiKaikuFinder finder;

    private List<AfT501TohyokuEntity> tohyokuList = new ArrayList<AfT501TohyokuEntity>();

    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> tableWriterShohon;

    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> tableWriterSenkyo;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;

    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> tableWriterSenkyoShikaku;

    @BatchWriter
    private BatchPermanentTableWriter<AfT133KaikuSenkyoFuzuiEntity> tableWriterKaikuSenkyoFuzui;

    @BatchWriter
    private BatchPermanentTableWriter<AfT131KaikuSenkyoEntity> tableWriterKaikuSenkyo;

    @BatchWriter
    private BatchReportWriter<ShinseishoCheckListKaikuSource> 申請書チェックリストWriter;
    private ReportSourceWriter<ShinseishoCheckListKaikuSource> 申請書チェックリストSourceWriter;

    @Override
    protected void initialize() {

        エラー事由１ = RString.EMPTY;
        エラー事由２ = RString.EMPTY;
        エラー事由３ = RString.EMPTY;
        エラー事由４ = RString.EMPTY;
        エラー事由５ = RString.EMPTY;
        エラー事由６ = RString.EMPTY;
        エラー事由７ = RString.EMPTY;
        選挙資格到達年齢_海区選挙 = BusinessConfig.get(
                ConfigKeysAFA.選挙資格到達年齢_海区選挙, SubGyomuCode.AFA選挙本体);
        mybatisParameter = processParameter.toSelectTempTableMybatisParameter();
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        処理種別 = processParameter.get処理種別();

        ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);

        海区選挙人名簿 = new ShisetsuTorokuMeiboJoho();

        選挙人名簿Entity = new AfT112SenkyoninMeiboEntity();
        海区付随情報Entity = new AfT133KaikuSenkyoFuzuiEntity();
        頁 = 0;
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票タイトル(ReportIdKeys.AFAPRK101_申請書チェックリスト.getReportName());

        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new AfT111SenkyoEntity();
        海区名簿Entity = new AfT131KaikuSenkyoEntity();
        選挙資格Entity = new AfT113SenkyoShikakuEntity();

        pageCount = new OutputParameter<>();
        連番 = 1;

        抄本番号List = new ArrayList<>();

        finder = MeiboSakuseiKaikuFinder.createInstance();
        tohyokuList = finder.get投票区データ();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterShohon = new BatchPermanentTableWriter<>(AfT100ShohonEntity.class);
        tableWriterSenkyo = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
        tableWriterKaikuSenkyo = new BatchPermanentTableWriter<>(AfT131KaikuSenkyoEntity.class);
        tableWriterSenkyoShikaku = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);
        tableWriterSenkyoninMeibo = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
        tableWriterKaikuSenkyoFuzui = new BatchPermanentTableWriter<>(AfT133KaikuSenkyoFuzuiEntity.class);

        申請書チェックリストWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRK101_申請書チェックリスト.value()).create();
        申請書チェックリストSourceWriter = new ReportSourceWriter<>(申請書チェックリストWriter);
    }

    @Override
    protected void usualProcess(MeiboTempTableEntity entity) {
        エラー事由1edit(entity);
        エラー事由2edit(entity);
        エラー事由3edit(entity);
        エラー事由4edit(entity);
        エラー事由6edit(entity);
        エラー事由7edit(entity);
        get帳票出力(entity);
    }

    @Override
    protected void keyBreakProcess(MeiboTempTableEntity t) {
        if (!hasBreakBy識別コード(getBefore(), t)) {
            エラー事由５ = 識別コード重複;
        } else {
            エラー事由５ = RString.EMPTY;
        }
    }

    @Override
    protected void afterExecute() {
        processParameter.set抄本番号List(抄本番号List);
        pageCount.setValue(申請書チェックリストSourceWriter.pageCount().value());
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void get帳票出力(MeiboTempTableEntity entity) {
        List<RString> errorList = new ArrayList();
        if (!エラー事由１.isEmpty()) {
            errorList.add(エラー事由１);
        }
        if (!エラー事由２.isEmpty()) {
            errorList.add(エラー事由２);
        }
        if (!エラー事由３.isEmpty()) {
            errorList.add(エラー事由３);
        }
        if (!エラー事由４.isEmpty()) {
            errorList.add(エラー事由４);
        }
        if (!エラー事由５.isEmpty()) {
            errorList.add(エラー事由５);
        }
        if (!エラー事由６.isEmpty()) {
            errorList.add(エラー事由６);
        }
        if (!エラー事由７.isEmpty()) {
            errorList.add(エラー事由７);
        }

        if (errorList.size() >= 1) {
            海区選挙人名簿.setエラー事由1(errorList.get(0));
        }
        if (errorList.size() >= 2) {
            海区選挙人名簿.setエラー事由2(errorList.get(1));
        }
        if (errorList.size() >= KaikuNumberEdit.リスト数3.getKey()) {
            海区選挙人名簿.setエラー事由3(errorList.get(2));
        }

        if (!errorList.isEmpty()) {
            set帳票のデータ(entity);
            ShinseishoCheckListKaikuParam param = new ShinseishoCheckListKaikuParam(海区選挙人名簿);
            ShinseishoCheckListKaikuReport report = new ShinseishoCheckListKaikuReport(param, 帳票共通ヘッダー);
            report.writeBy(申請書チェックリストSourceWriter);
        }

        if (エラー事由１.isEmpty() && エラー事由２.isEmpty() && エラー事由３.isEmpty()
                && エラー事由４.isEmpty() && エラー事由５.isEmpty() && エラー事由６.isEmpty() && エラー事由７.isEmpty()) {
            帳票出力Byエラー事由1_6_AllEmpty(entity);
        }
    }

    private void 帳票出力Byエラー事由1_6_AllEmpty(MeiboTempTableEntity entity) {

        if (!getCodeToRString(entity.getAfT113Entity().getShikakuKubun()).isEmpty() && getCodeToRString(entity.getAfT113Entity().getShikakuKubun())
                .equals(SennkyoSikakuKubun.有権者.value()) && getCodeToRString(entity.getAfT113Entity().getShikakuKubun())
                .equals(SennkyoSikakuKubun.表示者.value()) && getCodeToRString(entity.getAfT113Entity().getShikakuKubun())
                .equals(SennkyoSikakuKubun.公民権停止.value())) {
            if (count != 1) {
                count = 1;
                抄本番号 = get抄本番号();
                抄本番号List.add(抄本番号);
                tableWriterShohon.insert(new ShohonDBEditor(抄本Entity).edit入力ファイルの抄本データ(抄本番号, processParameter, 処理種別));
                tableWriterSenkyo.insert(new MeiboSenkyoDBEditor(選挙Entity).edit入力ファイルの選挙データ(抄本番号, processParameter, 処理種別, entity));
                tableWriterKaikuSenkyo.insert(new MeiboKaikuSenkyoDBEditor(海区名簿Entity).edit入力ファイルの海区名簿更新日データ(抄本番号, processParameter, 処理種別));
            }

            頁++;

            if (頁 > Integer.valueOf(ページ行数.toString())) {
                頁 = 1;
                tableWriterSenkyoninMeibo.insert(new SakuseiKaikuMeiboDBEditor(選挙人名簿Entity).edit入力ファイルの選挙人名簿(entity, 抄本番号, 頁, 連番));
            } else {
                tableWriterSenkyoninMeibo.insert(new SakuseiKaikuMeiboDBEditor(選挙人名簿Entity).edit入力ファイルの選挙人名簿(entity, 抄本番号, 頁, 連番));
            }

            tableWriterSenkyoShikaku.insert(new MeiboSenkyoShikakuDBEditor(選挙資格Entity).edit入力ファイルの選挙資格データ(抄本番号, processParameter, 処理種別, entity));
            tableWriterKaikuSenkyoFuzui.insert(new KaikuSenkyoFuzuiDBEditor(海区付随情報Entity).edit海区付随情報(entity, 抄本番号));
        }

    }

    private Boolean hasBreakBy識別コード(MeiboTempTableEntity before, MeiboTempTableEntity current) {
        RString before識別コード;
        RString current識別コード;

        if (before == null) {
            before識別コード = RString.EMPTY;
        } else if (before.get識別コード() == null) {
            before識別コード = RString.EMPTY;
        } else {
            ShikibetsuCode 識別コード = before.get識別コード();
            before識別コード = 識別コード != null ? 識別コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current識別コード = RString.EMPTY;
        } else {
            ShikibetsuCode 識別コード = current.get識別コード();
            current識別コード = 識別コード != null ? 識別コード.value() : RString.EMPTY;
        }
        if (!before識別コード.equals(current識別コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private ShisetsuTorokuMeiboJoho set帳票のデータ(MeiboTempTableEntity entity) {
        if (!エラー事由１.isEmpty()) {
            海区選挙人名簿.set全国住所コード(RString.EMPTY);
            海区選挙人名簿.set世帯コード(RString.EMPTY);
            海区選挙人名簿.set住所(RString.EMPTY);
            海区選挙人名簿.set番地(RString.EMPTY);
            海区選挙人名簿.set方書(RString.EMPTY);
            海区選挙人名簿.set氏名(RString.EMPTY);
            海区選挙人名簿.set性別(RString.EMPTY);
            海区選挙人名簿.set生年月日(null);
            海区選挙人名簿.set消除異動年月日(null);
        } else {

            if (entity.get住所() != null) {
                海区選挙人名簿.set住所(entity.get住所().value());
            }

            if (entity.get氏名() != null) {
                海区選挙人名簿.set氏名(entity.get氏名().value());
            }

            if (entity.getUaFt200Entity() != null) {

                ZenkokuJushoCode 全国住所コード = entity.getUaFt200Entity().getZenkokuJushoCode();
                海区選挙人名簿.set全国住所コード(全国住所コード != null ? 全国住所コード.value() : RString.EMPTY);
                SetaiCode 世帯コード = entity.getUaFt200Entity().getSetaiCode();
                海区選挙人名簿.set世帯コード(世帯コード != null ? 世帯コード.value() : RString.EMPTY);

                Katagaki 方書 = entity.getUaFt200Entity().getKatagaki();
                海区選挙人名簿.set方書(方書 != null ? 方書.value() : RString.EMPTY);
                AtenaBanchi 番地 = entity.getUaFt200Entity().getBanchi();
                海区選挙人名簿.set番地(番地 != null ? 番地.value() : RString.EMPTY);

                FlexibleDate 消除異動年月日 = entity.getUaFt200Entity().getShojoIdoYMD();
                set海区選挙人名簿の消除異動年月日(消除異動年月日);

            }
            海区選挙人名簿.set性別(entity.get性別());
            if (entity.get生年月日() != null) {
                海区選挙人名簿.set生年月日(new RDate(entity.get生年月日().toString()));
            }

        }
        海区選挙人名簿.set名簿基準年月日(new RDate(processParameter.get基準日().toString()));
        海区選挙人名簿.set選挙種類(SenkyoShurui.海区漁業調整委員会委員選挙.toRString());
        海区選挙人名簿.set投票区コード(entity.get投票区コード());
        海区選挙人名簿.set識別コード(entity.get識別コード());
        海区選挙人名簿.set漁業日数_漁業従事者(new RString(String.valueOf(entity.get漁業日数漁業従事者())));
        海区選挙人名簿.set漁業日数_漁業者(new RString(String.valueOf(entity.get漁業日数漁業者())));
        return 海区選挙人名簿;

    }

    private void set海区選挙人名簿の消除異動年月日(FlexibleDate 消除異動年月日) {
        if (消除異動年月日 != null && !消除異動年月日.isEmpty()) {
            海区選挙人名簿.set消除異動年月日(new RDate(消除異動年月日.toString()));
        }
    }

    private ShohonNo get抄本番号() {
        ShohonNo 抄本番号_採番;
        if (処理種別.equals(MeiboKaikuEdited.新規処理.getKey())) {
            CountedItem countedItem = Saiban.get(SubGyomuCode.AFA選挙本体, OutputKeys.汎用キー.getValue());
            抄本番号_採番 = new ShohonNo(new RString(Long.toString(countedItem.next())));
        } else {
            抄本番号_採番 = processParameter.get抄本番号();
        }
        return 抄本番号_採番;
    }

    private void エラー事由1edit(MeiboTempTableEntity entity) {
        if (entity.getUaFt200Entity() != null) {
            ShikibetsuCode 識別コード = entity.getUaFt200Entity().getShikibetsuCode();
            if (識別コード == null || 識別コード.isEmpty()) {
                エラー事由１ = キー不一致;
            }
        }
    }

    private void エラー事由2edit(MeiboTempTableEntity entity) {
        FlexibleDate 生年月日 = null;
        if (entity.getUaFt200Entity() != null) {
            生年月日 = entity.getUaFt200Entity().getSeinengappiYMD();
        }
        FlexibleDate 日付 = FlexibleDate.getNowDate();
        int 宛名識別対象の年齢 = 0;
        if (生年月日 != null) {
            宛名識別対象の年齢 = Integer.valueOf(日付.minusYear(生年月日.getYearValue()).toString().substring(0, KaikuNumberEdit.年月の桁数.getKey()));
        }

        int 選挙資格到達年齢 = Integer.parseInt(選挙資格到達年齢_海区選挙.toString());

        if (宛名識別対象の年齢 < 選挙資格到達年齢) {
            エラー事由２ = 規定年齢未満;
        }

    }

    private void エラー事由3edit(MeiboTempTableEntity entity) {

        RString 住民状態コード = null;
        if (entity.getUaFt200Entity() != null) {
            住民状態コード = entity.getUaFt200Entity().getJuminJotaiCode();
        }

        if (住民状態コード != null && 住民状態コード.equals(OutputKeys.死亡者.getValue())) {
            エラー事由３ = 死亡者_3;
        }

    }

    private void エラー事由4edit(MeiboTempTableEntity entity) {
        RString 住民状態コード = null;
        if (entity.getUaFt200Entity() != null) {
            住民状態コード = entity.getUaFt200Entity().getJuminJotaiCode();
        }

        if (住民状態コード != null && 住民状態コード.equals(OutputKeys.消除者.getValue())) {
            エラー事由４ = 消除者_4;
        }
    }

    private void エラー事由6edit(MeiboTempTableEntity entity) {
        int 漁業日数漁業従事者 = 0;
        int 漁業日数漁業者 = 0;
        if (entity != null) {
            漁業日数漁業従事者 = entity.get漁業日数漁業従事者();
            漁業日数漁業者 = entity.get漁業日数漁業者();
        }

        int 漁業日数sum = 漁業日数漁業従事者 + 漁業日数漁業者;

        if (漁業日数sum < KaikuNumberEdit.漁業日数.getKey()) {
            エラー事由６ = 漁業日数不足;
        }
    }

    private void エラー事由7edit(MeiboTempTableEntity entity) {
        boolean 投票区 = false;
        if (!tohyokuList.isEmpty()) {
            for (AfT501TohyokuEntity afT501Tohyoku : tohyokuList) {
                if (afT501Tohyoku.getTohyokuCode().equals(entity.get投票区コード())) {
                    投票区 = true;
                }
            }
        }

        if (!投票区) {
            エラー事由７ = 投票区なし;
        }

    }

    private RString getCodeToRString(Code code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

}
