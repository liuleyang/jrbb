/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminJouhou;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminJouhouShuukei;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK100.MeiboShohonKaikuPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK100.MeiboShohonKaikuReport;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboShohonKaikuDbMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.af.afa.service.meibosakuseikaiku.MeiboSakuseiKaikuFinder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.ToriatsukaiChuiShoriKubunType;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.cautionsha.IToriatsukaiChuishaControlFinder;
import jp.co.ndensan.reams.ua.uax.service.core.cautionsha.ToriatsukaiChuishaFactory;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 海区漁業調整委員会委員選挙人名簿抄本帳票を出力する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboShohonKaikuReportProcess extends BatchKeyBreakBase<MeiboSakuseiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select選挙人名簿抄本");

    private MeiboShohonKaikuDbMybatisParameter mybatisParameter;

    private AFABTK101SelectProcessParameter processParameter;

    private ShikakuHantei shikakuHantei;

    private MeiboSakuseiKaikuFinder meiboFinder;

    private int itemCout;
    private int page;
    private int totalPage;
    private int pageKeiMan;
    private int pageKeiWoman;
    private int pageKeiKei;

    private RString 集計タイトル1;
    private int 集計男1;
    private int 集計女1;
    private int 総合計1;
    private RString key1;

    private RString 集計タイトル2;
    private int 集計男2;
    private int 集計女2;
    private int 総合計2;
    private RString key2;

    private RString 集計タイトル3;
    private int 集計男3;
    private int 集計女3;
    private int 総合計3;
    private RString key3;

    private RString 集計タイトル4;
    private int 集計男4;
    private int 集計女4;
    private int 総合計4;
    private RString key4;

    private RString 世帯主名称;

    private static final RString 印字文字_1 = new RString("『合計』");
    private static final RString 印字文字_2 = new RString(" 『第』");
    private static final RString 印字文字_3 = new RString("『投票区計』");
    private static final RString 印字文字_4 = new RString("『住所計』");
    private static final RString 印字文字_5 = new RString("『計』");
    private static final RString 印字文字_6 = new RString("『冊計』");

    private static final RString 世帯主 = new RString("世帯主");

    private static final RString 集計キー住所コード = new RString("住所コード");
    private static final RString 集計キー行政区コード = new RString("行政区コード");
    private static final RString 集計キー地区コード１ = new RString("地区コード１");
    private static final RString 集計キー地区コード２ = new RString("地区コード２");
    private static final RString 集計キー地区コード３ = new RString("地区コード３");
    private static final RString 集計キー投票区コード = new RString("投票区コード");
    private static final RString 集計キーグループコード = new RString("グループコード");
    private static final RString 集計キー冊 = new RString("冊");

    private List<RString> 集計項目キーリスト = new ArrayList<>();

    private RString 取扱注意者の出力方式;

    private MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報_new;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象_new;
    private AfT113SenkyoShikakuEntity 選挙資格_new;
    private Association 地方公共団体情報_new;

    private IToriatsukaiChuishaControlFinder finder;

    private RString 性別コード;

    private static final List<RString> 海区漁業選挙人名簿抄本_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.key1.name()),
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.key2.name()),
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.key3.name()),
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.tohyokuCode.name()),
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.totalPage.name()),
                            new RString(MeiboShohonKaikuSource.ReportSourceKeyFields.key4.name())));

    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonKaikuSource> 海区選挙人名簿抄本Writer;
    private ReportSourceWriter<MeiboShohonKaikuSource> 海区選挙人名簿抄本SourceWriter;

    @BatchWriter
    private BatchReportWriter<MeiboShohonKaikuSource> 海区選挙人名簿抄本縦覧Writer;
    private ReportSourceWriter<MeiboShohonKaikuSource> 海区選挙人名簿抄本縦覧SourceWriter;

    List<AfT509KumiaiEntity> afT509KumiaiEntityList = new ArrayList<>();

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }

    OutputParameter<Integer> pageCount;

    private RString 世帯主区分;

    private boolean 世帯主設定フラグ;

    private MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報;
    private MeiboShohonJuminJouhouShuukei 住民投票資格者名簿抄本情報集計;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toMeiboShohonKaikuDbMybatisParameter();
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        shikakuHantei = new ShikakuHantei();
        pageCount = new OutputParameter<>();

        page = 1;
        itemCout = 1;
        totalPage = 1;
        pageKeiMan = 0;
        pageKeiWoman = 0;
        pageKeiKei = 0;
        集計タイトル1 = RString.EMPTY;
        集計男1 = 0;
        集計女1 = 0;
        総合計1 = 0;
        key1 = RString.EMPTY;

        集計タイトル2 = RString.EMPTY;
        集計男2 = 0;
        集計女2 = 0;
        総合計2 = 0;
        key2 = RString.EMPTY;

        集計タイトル3 = RString.EMPTY;
        集計男3 = 0;
        集計女3 = 0;
        総合計3 = 0;
        key3 = RString.EMPTY;

        集計タイトル4 = RString.EMPTY;
        集計男4 = 0;
        集計女4 = 0;
        総合計4 = 0;
        key4 = RString.EMPTY;

        世帯主名称 = RString.EMPTY;

        世帯主設定フラグ = false;

        集計項目キーリスト = processParameter.get集計項目IDリスト();

        finder = ToriatsukaiChuishaFactory.createInstance();

        meiboFinder = MeiboSakuseiKaikuFinder.createInstance();
        afT509KumiaiEntityList = meiboFinder.get組合マスタデータ();

        shikakuHantei = new ShikakuHantei();

        取扱注意者の出力方式 = BusinessConfig.get(
                ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, SubGyomuCode.AFA選挙本体);

        世帯主区分 = BusinessConfig.get(
                ConfigKeysAFA.抄本_印字有無_世帯主区分, SubGyomuCode.AFA選挙本体);

        住民投票資格者名簿抄本情報集計 = new MeiboShohonJuminJouhouShuukei();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        海区選挙人名簿抄本SourceWriter = new ReportSourceWriter<>(海区選挙人名簿抄本Writer);
        海区選挙人名簿抄本縦覧Writer = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value())
                .addBreak(new BreakerCatalog<MeiboShohonJuminSource>().simplePageBreaker(海区漁業選挙人名簿抄本_BREAK_KEYS)).create();
        海区選挙人名簿抄本縦覧SourceWriter = new ReportSourceWriter<>(海区選挙人名簿抄本縦覧Writer);
    }

    @Override
    protected void usualProcess(MeiboSakuseiKaikuEntity entity) {

        setページ計(entity);
        if (世帯主区分.equals(MeiboKaikuEdited.世帯主区分_0.getKey())) {
            世帯主名称 = RString.EMPTY;
        } else if (世帯主区分.equals(MeiboKaikuEdited.世帯主区分_1.getKey())) {
            set世帯主の編集(entity);
        }

        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_1.getKey()) {
            set集計項目キー1(KaikuNumberEdit.固定数_0.getKey(), entity);
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_2.getKey()) {
            set集計項目キー2(KaikuNumberEdit.固定数_1.getKey(), entity);
        }

        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_3.getKey()) {
            set集計項目キー3(KaikuNumberEdit.固定数_2.getKey(), entity);
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_4.getKey()) {
            set集計項目キー4(KaikuNumberEdit.固定数_3.getKey(), entity);
        }

        住民投票資格者名簿抄本情報_new = set住民投票資格者名簿抄本情報(entity);
        宛名識別対象_new = entity.getUaFt200Entity();
        選挙資格_new = entity.getAfT113Entity();
        地方公共団体情報_new = get地方公共団体(entity);

    }

    @Override
    protected void keyBreakProcess(MeiboSakuseiKaikuEntity entity) {

        住民投票資格者名簿抄本情報集計 = new MeiboShohonJuminJouhouShuukei();
        set住民投票資格者名簿抄本情報ページ集計();
        住民投票資格者名簿抄本情報 = set住民投票資格者名簿抄本情報(getBefore());
        住民投票資格者名簿抄本情報.setページ(page);
        住民投票資格者名簿抄本情報.setTotalPage(new RString(String.valueOf(totalPage)));

        boolean isKey1Break = false;
        boolean isKey2Break = false;
        boolean isKey3Break = false;
        boolean isKey4Break = false;
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_1.getKey()) {
            isKey1Break = is集計項目キー1Break(KaikuNumberEdit.固定数_0.getKey(), entity);
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_2.getKey()) {
            isKey2Break = is集計項目キー2Break(KaikuNumberEdit.固定数_1.getKey(), entity);
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_3.getKey()) {
            isKey3Break = is集計項目キー3Break(KaikuNumberEdit.固定数_2.getKey(), entity);
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_4.getKey()) {
            isKey4Break = is集計項目キー4Break(KaikuNumberEdit.固定数_3.getKey(), entity);
        }

        if (hasBreak世帯主コード(getBefore(), entity)) {
            世帯主設定フラグ = false;
        }

        boolean is最大印字行Break = false;

        int 最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        if (itemCout == (最大印字行 > KaikuNumberEdit.帳票最大行.getKey() ? KaikuNumberEdit.帳票最大行.getKey() : 最大印字行)) {
            is最大印字行Break = true;
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
        }
        itemCout++;

        if (isKey1Break || isKey2Break || isKey3Break || isKey4Break || is最大印字行Break) {
            totalPage++;
            if (hasBreakBy投票区(getBefore(), entity)) {
                page = 1;
            } else {
                page++;
            }
        }

        住民投票資格者名簿抄本情報.set世帯主(世帯主名称);
        住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.getReportName());
        MeiboShohonKaikuParam param = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報, 住民投票資格者名簿抄本情報集計,
                getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(),
                get地方公共団体(getBefore()), ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value());

        MeiboShohonKaikuReport report = new MeiboShohonKaikuReport(param);
        report.writeBy(海区選挙人名簿抄本SourceWriter);

        int flag = 取扱い注意者判断(getBefore());
        if (flag == KaikuNumberEdit.固定数_1.getKey()) {
            return;
        }

        if (flag == KaikuNumberEdit.固定数_2.getKey()) {
            住民投票資格者名簿抄本情報.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param空白縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(),
                    get地方公共団体(getBefore()), ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report空白縦覧 = new MeiboShohonKaikuReport(param空白縦覧);
            report空白縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);
        }
        if (flag == KaikuNumberEdit.固定数_3.getKey()) {
            住民投票資格者名簿抄本情報.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(),
                    get地方公共団体(getBefore()), ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report縦覧 = new MeiboShohonKaikuReport(param縦覧);
            report縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);

        }
        if (flag == KaikuNumberEdit.固定数_4.getKey()) {
            住民投票資格者名簿抄本情報.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(),
                    get地方公共団体(getBefore()), ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report縦覧 = new MeiboShohonKaikuReport(param縦覧);
            report縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);
        }

    }

    @Override
    protected void afterExecute() {

        set住民投票資格者名簿抄本情報ページ集計();
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_1.getKey()) {
            set住民投票資格者名簿抄本情報集計1();
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_2.getKey()) {
            set住民投票資格者名簿抄本情報集計2();
        }

        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_3.getKey()) {
            set住民投票資格者名簿抄本情報集計3();
        }
        if (集計項目キーリスト.size() >= KaikuNumberEdit.固定数_4.getKey()) {
            set住民投票資格者名簿抄本情報集計4();
        }

        住民投票資格者名簿抄本情報_new.setページ(page);
        住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.getReportName());
        住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
        住民投票資格者名簿抄本情報_new.set世帯主(世帯主名称);
        MeiboShohonKaikuParam param = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報_new, 住民投票資格者名簿抄本情報集計,
                宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new, ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value());

        MeiboShohonKaikuReport report = new MeiboShohonKaikuReport(param);
        report.writeBy(海区選挙人名簿抄本SourceWriter);

        int flag = 取扱い注意者判断(getBefore());
        if (flag == KaikuNumberEdit.固定数_1.getKey()) {
            return;
        }

        if (flag == KaikuNumberEdit.固定数_2.getKey()) {
            住民投票資格者名簿抄本情報_new.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報_new.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param空白縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new, ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report空白縦覧 = new MeiboShohonKaikuReport(param空白縦覧);
            report空白縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);
        }
        if (flag == KaikuNumberEdit.固定数_3.getKey()) {
            住民投票資格者名簿抄本情報_new.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報_new.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new, ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report縦覧 = new MeiboShohonKaikuReport(param縦覧);
            report縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);

        }
        if (flag == KaikuNumberEdit.固定数_4.getKey()) {
            住民投票資格者名簿抄本情報_new.set世帯主(世帯主名称);
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.getReportName());
            MeiboShohonKaikuParam param縦覧 = new MeiboShohonKaikuParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new, ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧.value());

            MeiboShohonKaikuReport report縦覧 = new MeiboShohonKaikuReport(param縦覧);
            report縦覧.writeBy(海区選挙人名簿抄本縦覧SourceWriter);
        }

        pageCount.setValue(page);
    }

    private int 取扱い注意者判断(MeiboSakuseiKaikuEntity entity) {
        int flag = KaikuNumberEdit.固定数_4.getKey();
        if (finder.get取扱い注意者制御(ToriatsukaiChuiShoriKubunType.閲覧用リスト,
                entity.getUaFt200Entity().getShikibetsuCode(), processParameter.get基準日()).is制御対象()) {
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_1.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を空白.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_2.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_3.getKey();
            }
        } else {
            flag = KaikuNumberEdit.固定数_4.getKey();
        }
        return flag;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private boolean is集計項目キー1Break(int i, MeiboSakuseiKaikuEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;

            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード１)) && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キーグループコード))
                && (itemCout != 0 && hasBreakByグループコード(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー冊))
                && (itemCout != 0 && hasBreakBy冊(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        return false;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private boolean is集計項目キー2Break(int i, MeiboSakuseiKaikuEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キーグループコード))
                && (itemCout != 0 && hasBreakByグループコード(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キー冊))
                && (itemCout != 0 && hasBreakBy冊(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }

        return false;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private boolean is集計項目キー3Break(int i, MeiboSakuseiKaikuEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キーグループコード))
                && (itemCout != 0 && hasBreakByグループコード(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キー冊))
                && (itemCout != 0 && hasBreakBy冊(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }

        return false;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private boolean is集計項目キー4Break(int i, MeiboSakuseiKaikuEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キーグループコード))
                && (itemCout != 0 && hasBreakByグループコード(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i).equals(集計キー冊))
                && (itemCout != 0 && hasBreakBy冊(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }

        return false;
    }

    private Boolean hasBreak住所コード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {

        RString before住所コード;
        RString current住所コード;

        if (before == null) {
            before住所コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getZenkokuJushoCode() == null) {
            before住所コード = RString.EMPTY;
        } else {
            ZenkokuJushoCode 住所コード = before.getUaFt200Entity().getZenkokuJushoCode();
            before住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current住所コード = RString.EMPTY;
        } else {
            ZenkokuJushoCode 住所コード = current.getUaFt200Entity().getZenkokuJushoCode();
            current住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }
        if (!before住所コード.equals(current住所コード)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private Boolean hasBreak行政区コード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before行政区コード;
        RString current行政区コード;

        if (before == null) {
            before行政区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getGyoseikuCode() == null) {
            before行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = before.getUaFt200Entity().getGyoseikuCode();
            before行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = current.getUaFt200Entity().getGyoseikuCode();
            current行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (!before行政区コード.equals(current行政区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean hasBreak地区コード１(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード１;
        RString current地区コード１;

        if (before == null) {
            before地区コード１ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode1() == null) {
            before地区コード１ = RString.EMPTY;
        } else {

            ChikuCode 地区コード１ = before.getUaFt200Entity().getChikuCode1();
            before地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード１ = RString.EMPTY;
        } else {
            ChikuCode 地区コード１ = current.getUaFt200Entity().getChikuCode1();
            current地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (!before地区コード１.equals(current地区コード１)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private Boolean hasBreak地区コード２(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード２;
        RString current地区コード２;

        if (before == null) {
            before地区コード２ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode2() == null) {
            before地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = before.getUaFt200Entity().getChikuCode1();
            before地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = current.getUaFt200Entity().getChikuCode1();
            current地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (!before地区コード２.equals(current地区コード２)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private Boolean hasBreak地区コード３(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード３;
        RString current地区コード３;

        if (before == null) {
            before地区コード３ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode3() == null) {
            before地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = before.getUaFt200Entity().getChikuCode1();
            before地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = current.getUaFt200Entity().getChikuCode1();
            current地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }
        if (!before地区コード３.equals(current地区コード３)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    private Boolean hasBreakBy投票区(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before投票区コード;
        RString current投票区コード;

        if (before == null) {
            before投票区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getAfT112SenkyoninMeibEntity().getTohyokuCode() == null) {
            before投票区コード = RString.EMPTY;
        } else {
            RString 投票区コード = before.getAfT112SenkyoninMeibEntity().getTohyokuCode();
            before投票区コード = 投票区コード != null ? 投票区コード : RString.EMPTY;
        }

        if (current == null) {
            current投票区コード = RString.EMPTY;
        } else {
            RString 投票区コード = current.getAfT112SenkyoninMeibEntity().getTohyokuCode();
            current投票区コード = 投票区コード != null ? 投票区コード : RString.EMPTY;
        }
        if (!before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean hasBreakByグループコード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString beforeグループコード;
        RString currentグループコード;

        if (before == null) {
            beforeグループコード = RString.EMPTY;
        } else if (before.getAfT112SenkyoninMeibEntity() != null && before.getAfT112SenkyoninMeibEntity().getGroupCode() == null) {
            beforeグループコード = RString.EMPTY;
        } else {
            RString グループコード = before.getAfT112SenkyoninMeibEntity().getGroupCode();
            beforeグループコード = グループコード != null ? グループコード : RString.EMPTY;
        }

        if (current == null) {
            currentグループコード = RString.EMPTY;
        } else {
            RString グループコード = null;
            if (null != current.getAfT112SenkyoninMeibEntity()) {
                グループコード = current.getAfT112SenkyoninMeibEntity().getGroupCode();
            }
            currentグループコード = グループコード != null ? グループコード : RString.EMPTY;
        }
        if (!beforeグループコード.equals(currentグループコード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean hasBreakBy冊(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before冊;
        RString current冊;

        if (before == null) {
            before冊 = RString.EMPTY;
        } else if (before.getAfT112SenkyoninMeibEntity() != null && before.getAfT112SenkyoninMeibEntity().getSatsu() == null) {
            before冊 = RString.EMPTY;
        } else {
            RString 冊 = before.getAfT112SenkyoninMeibEntity().getSatsu();
            before冊 = 冊 != null ? 冊 : RString.EMPTY;
        }

        if (current == null) {
            current冊 = RString.EMPTY;
        } else {
            RString 冊 = null;
            if (current.getAfT112SenkyoninMeibEntity() != null) {
                冊 = current.getAfT112SenkyoninMeibEntity().getSatsu();
            }
            current冊 = 冊 != null ? 冊 : RString.EMPTY;
        }
        if (!before冊.equals(current冊)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean hasBreak世帯主コード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {

        RString before世帯主コード;
        RString current世帯主コード;

        if (before == null) {
            before世帯主コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getSetaiCode() == null) {
            before世帯主コード = RString.EMPTY;
        } else {
            SetaiCode 世帯主コード = before.getUaFt200Entity().getSetaiCode();
            before世帯主コード = 世帯主コード != null ? 世帯主コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current世帯主コード = RString.EMPTY;
        } else {
            SetaiCode 世帯主コード = current.getUaFt200Entity().getSetaiCode();
            current世帯主コード = 世帯主コード != null ? 世帯主コード.value() : RString.EMPTY;
        }
        if (!before世帯主コード.equals(current世帯主コード)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private void set世帯主の編集(MeiboSakuseiKaikuEntity entity) {

        RString 住民状態 = entity.getUaFt200Entity().getJuminJotaiCode();
        RString 続柄 = entity.getUaFt200Entity().getTsuzukigara();

        if (住民状態 != null && 住民状態.equals(MeiboKaikuEdited.住民状態_1.getKey())
                && 続柄 != null && 続柄.equals(世帯主)) {
            世帯主名称 = new RString("＊");
        } else if (住民状態 != null && !住民状態.equals(MeiboKaikuEdited.住民状態_1.getKey())
                && 続柄 != null && 続柄.equals(世帯主) && !世帯主設定フラグ) {
            世帯主名称 = new RString("＊");
            世帯主設定フラグ = true;
        } else {
            世帯主名称 = RString.EMPTY;
        }

    }

    private void setページ計(MeiboSakuseiKaikuEntity entity) {

        Code masshoJiyuCode = entity.getAfT113Entity().getMasshoJiyuCode();
        if ((masshoJiyuCode == null
                || masshoJiyuCode.isEmpty())
                && (!shikakuHantei.is公民権停止者(entity.getUaFt200Entity(), entity.getAfT113Entity(),
                        null, FlexibleDate.getNowDate()))) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (entity.getUaFt200Entity() != null && 性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
                pageKeiMan++;
            } else if (entity.getUaFt200Entity() != null && 性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
                pageKeiWoman++;
            }
            pageKeiKei++;
        }

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー1(int i, MeiboSakuseiKaikuEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル1 = 印字文字_4;
            get集計キー1(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key1 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル1 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_5);
                key1 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル1 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_5);
                key1 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル1 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_5);
                key1 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル1 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_5);
                key1 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                RString 投票区コード = entity.getAfT112SenkyoninMeibEntity().getTohyokuCode();
                set集計タイトル1andkey1By投票区コード(投票区コード);
            }
        }

        if (集計項目キーリスト.get(i).equals(集計キーグループコード)) {
            集計タイトル1 = 印字文字_1;
            get集計キー1(entity);

        }
        if (集計項目キーリスト.get(i).equals(集計キー冊)) {
            集計タイトル1 = 印字文字_6;
            get集計キー1(entity);
        }

    }

    private void set集計タイトル1andkey1By投票区コード(RString 投票区コード) {
        if (投票区コード != null) {
            集計タイトル1 = 印字文字_2.concat(投票区コード).concat(印字文字_3);
            key1 = 投票区コード;
        }
    }

    private void get集計キー1(MeiboSakuseiKaikuEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
                集計男1++;
            } else if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
                集計女1++;
            }
            総合計1++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー2(int i, MeiboSakuseiKaikuEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル2 = 印字文字_4;
            get集計キー2(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key2 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル2 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_5);
                key2 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル2 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_5);
                key2 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル2 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_5);
                key2 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル2 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_5);
                key2 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                RString 投票区コード = entity.getAfT112SenkyoninMeibEntity().getTohyokuCode();
                set集計タイトル2andkey1By投票区コード(投票区コード);
            }
        }

        if (集計項目キーリスト.get(i).equals(集計キーグループコード)) {
            集計タイトル2 = 印字文字_1;
            get集計キー2(entity);

        }
        if (集計項目キーリスト.get(i).equals(集計キー冊)) {
            集計タイトル2 = 印字文字_6;
            get集計キー2(entity);
        }

    }

    private void set集計タイトル2andkey1By投票区コード(RString 投票区コード) {
        if (投票区コード != null) {
            集計タイトル2 = 印字文字_2.concat(投票区コード).concat(印字文字_3);
            key2 = 投票区コード;
        }
    }

    private void get集計キー2(MeiboSakuseiKaikuEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
                集計男2++;
            } else if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
                集計女2++;
            }
            総合計2++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー3(int i, MeiboSakuseiKaikuEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル3 = 印字文字_4;
            get集計キー3(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key3 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル3 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_5);
                key3 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル3 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_5);
                key3 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル3 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_5);
                key3 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル3 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_5);
                key3 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                RString 投票区コード = entity.getAfT112SenkyoninMeibEntity().getTohyokuCode();
                set集計タイトル3andkey1By投票区コード(投票区コード);
            }
        }

        if (集計項目キーリスト.get(i).equals(集計キーグループコード)) {
            集計タイトル3 = 印字文字_1;
            get集計キー3(entity);

        }
        if (集計項目キーリスト.get(i).equals(集計キー冊)) {
            集計タイトル3 = 印字文字_6;
            get集計キー3(entity);
        }

    }

    private void set集計タイトル3andkey1By投票区コード(RString 投票区コード) {
        if (投票区コード != null) {
            集計タイトル3 = 印字文字_2.concat(投票区コード).concat(印字文字_3);
            key3 = 投票区コード;
        }
    }

    private void get集計キー3(MeiboSakuseiKaikuEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
                集計男3++;
            } else if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
                集計女3++;
            }
            総合計3++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー4(int i, MeiboSakuseiKaikuEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル4 = 印字文字_4;
            get集計キー4(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key4 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル4 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_5);
                key4 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル4 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_5);
                key4 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル4 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_5);
                key4 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル4 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_5);
                key4 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                RString 投票区コード = entity.getAfT112SenkyoninMeibEntity().getTohyokuCode();
                set集計タイトル4andkey1By投票区コード(投票区コード);
            }
        }

        if (集計項目キーリスト.get(i).equals(集計キーグループコード)) {
            集計タイトル4 = 印字文字_1;
            get集計キー4(entity);

        }
        if (集計項目キーリスト.get(i).equals(集計キー冊)) {
            集計タイトル4 = 印字文字_6;
            get集計キー4(entity);
        }

    }

    private void set集計タイトル4andkey1By投票区コード(RString 投票区コード) {
        if (投票区コード != null) {
            集計タイトル4 = 印字文字_2.concat(投票区コード).concat(印字文字_3);
            key4 = 投票区コード;
        }
    }

    private void get集計キー4(MeiboSakuseiKaikuEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
                集計男4++;
            } else if (性別コード != null && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
                集計女4++;
            }
            総合計4++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private MeiboShohonJuminJouhou set住民投票資格者名簿抄本情報(MeiboSakuseiKaikuEntity entity) {

        MeiboShohonJuminJouhou 名簿抄本情報 = new MeiboShohonJuminJouhou();
        if (entity != null && entity.getUaFt200Entity() != null && entity.getAfT113Entity() != null && entity.getAfT100Entity() != null) {

            名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.getReportName());
            if (entity.getAfT501TohyokuEntity() != null) {
                名簿抄本情報.set投票区名(entity.getAfT501TohyokuEntity().getTohyokuName());
            }

            RString 投票区コード = entity.getAfT112SenkyoninMeibEntity().getTohyokuCode();
            if (投票区コード != null) {
                名簿抄本情報.set投票区コード(投票区コード);
            }

            名簿抄本情報.set住登内住所(entity.getUaFt200Entity().getJutonaiJusho());
            AtenaBanchi 住登内番地 = entity.getUaFt200Entity().getJutonaiBanchi();
            if (住登内番地 != null) {
                名簿抄本情報.set住登内番地(住登内番地.value());
            }

            Katagaki 住登内方書 = entity.getUaFt200Entity().getJutonaiKatagaki();
            if (住登内方書 != null) {
                名簿抄本情報.set住登内方書(住登内方書.value());
            }

            名簿抄本情報.set行政区名(entity.getUaFt200Entity().getGyoseikuName());
            FlexibleDate 生年月日 = entity.getUaFt200Entity().getSeinengappiYMD();
            if (生年月日 != null) {
                名簿抄本情報.set生年月日(new RString(生年月日.toString()));
            }
            名簿抄本情報.set性別コード(entity.getUaFt200Entity().getSeibetsuCode());

            AtenaMeisho 名称 = entity.getUaFt200Entity().getMeisho();
            if (名称 != null) {
                名簿抄本情報.set名称(名称.value());
            }

            AtenaKanaMeisho カナ名称 = entity.getUaFt200Entity().getKanaShimei();

            if (カナ名称 != null) {
                名簿抄本情報.setカナ名称(カナ名称.value());
            }

            Code 抹消事由コード = entity.getAfT113Entity().getMasshoJiyuCode();
            if (抹消事由コード != null) {
                名簿抄本情報.set抹消事由コード(抹消事由コード.value());
            }

            ShikibetsuCode 識別コード = entity.getUaFt200Entity().getShikibetsuCode();
            if (識別コード != null) {
                名簿抄本情報.set識別コード(識別コード.value());
            }

            名簿抄本情報.set抄本名(entity.getAfT100Entity().getShohonName());
            FlexibleDate 投票年月日 = entity.getAfT100Entity().getTohyoYMD();
            if (投票年月日 != null) {
                名簿抄本情報.set投票年月日(new RString(投票年月日.toString()));
            }
            FlexibleDate 規定年齢到達年月日 = entity.getAfT100Entity().getKiteiNenreiTotatsuYMD();
            if (規定年齢到達年月日 != null) {
                名簿抄本情報.set規定年齢到達年月日(規定年齢到達年月日);
            }

            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (住所コード != null) {
                名簿抄本情報.set町域コード(住所コード.value());
            }

            GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
            if (行政区コード != null) {
                名簿抄本情報.set行政区コード(行政区コード.value());
            }
            名簿抄本情報.set行政区コード(entity.getUaFt200Entity().getGyoseikuName());

            ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
            if (地区コード１ != null) {
                名簿抄本情報.set地区コード１(地区コード１.value());
            }
            名簿抄本情報.set地区名１(entity.getUaFt200Entity().getChikuName1());

            ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
            if (地区コード２ != null) {
                名簿抄本情報.set地区コード２(地区コード２.value());
            }
            名簿抄本情報.set地区名２(entity.getUaFt200Entity().getChikuName2());

            ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
            if (地区コード３ != null) {
                名簿抄本情報.set地区コード３(地区コード３.value());
            }
            名簿抄本情報.set地区名３(entity.getUaFt200Entity().getChikuName3());
            名簿抄本情報.set住民種別(entity.getUaFt200Entity().getJuminJotaiCode());

            for (AfT509KumiaiEntity afT509KumiaiEntity : afT509KumiaiEntityList) {
                if (entity.getAfT133KaikuSenkyoFuzui() != null && afT509KumiaiEntity.getKumiaiCode().
                        equals(entity.getAfT133KaikuSenkyoFuzui().getKumiaiCode())) {
                    名簿抄本情報.set組合名称(afT509KumiaiEntity.getKumiaiName());
                }

            }
        }

        名簿抄本情報.setKey1(key1);
        名簿抄本情報.setKey2(key2);
        名簿抄本情報.setKey3(key3);
        名簿抄本情報.setKey4(key4);

        return 名簿抄本情報;
    }

    private Association get地方公共団体(MeiboSakuseiKaikuEntity entity) {
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association;
        LasdecCode 現全国地方公共団体コード = entity.getUaFt200Entity().getGenLasdecCode();
        if (null == 現全国地方公共団体コード || 現全国地方公共団体コード.isEmpty()) {
            association = null;
        } else {
            association = associationFinder.getAssociation(現全国地方公共団体コード);
        }
        return association;

    }

    private void set住民投票資格者名簿抄本情報ページ集計() {
        住民投票資格者名簿抄本情報集計.setPageKeiKei(new RString(String.valueOf(pageKeiKei)));
        住民投票資格者名簿抄本情報集計.setPageKeiWoman(new RString(String.valueOf(pageKeiWoman)));
        住民投票資格者名簿抄本情報集計.setPageKeiMan(new RString(String.valueOf(pageKeiMan)));
    }

    private void set住民投票資格者名簿抄本情報集計1() {
        住民投票資格者名簿抄本情報集計.setKei1Man(new RString(String.valueOf(集計男1)));
        住民投票資格者名簿抄本情報集計.setKei1Woman(new RString(String.valueOf(集計女1)));
        住民投票資格者名簿抄本情報集計.setKei1Title(new RString(String.valueOf(集計タイトル1)));
        住民投票資格者名簿抄本情報集計.setKei1Kei(new RString(String.valueOf(総合計1)));
    }

    private void set住民投票資格者名簿抄本情報集計2() {
        住民投票資格者名簿抄本情報集計.setKei2Man(new RString(String.valueOf(集計男2)));
        住民投票資格者名簿抄本情報集計.setKei2Woman(new RString(String.valueOf(集計女2)));
        住民投票資格者名簿抄本情報集計.setKei2Title(new RString(String.valueOf(集計タイトル2)));
        住民投票資格者名簿抄本情報集計.setKei2Kei(new RString(String.valueOf(総合計2)));
    }

    private void set住民投票資格者名簿抄本情報集計3() {
        住民投票資格者名簿抄本情報集計.setKei3Man(new RString(String.valueOf(集計男3)));
        住民投票資格者名簿抄本情報集計.setKei3Woman(new RString(String.valueOf(集計女3)));
        住民投票資格者名簿抄本情報集計.setKei3Title(new RString(String.valueOf(集計タイトル3)));
        住民投票資格者名簿抄本情報集計.setKei3Kei(new RString(String.valueOf(総合計3)));
    }

    private void set住民投票資格者名簿抄本情報集計4() {
        住民投票資格者名簿抄本情報集計.setKei4Man(new RString(String.valueOf(集計男4)));
        住民投票資格者名簿抄本情報集計.setKei4Woman(new RString(String.valueOf(集計女4)));
        住民投票資格者名簿抄本情報集計.setKei4Title(new RString(String.valueOf(集計タイトル4)));
        住民投票資格者名簿抄本情報集計.setKei4Kei(new RString(String.valueOf(総合計4)));
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                MeiboShohonKaikuReportProcess.特定項目.class,
                MeiboShohonKaikuReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        海区選挙人名簿抄本Writer = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonKaikuSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value())
                .addBreak(new MeiboShohonKaikuPageBreak())
                .build();
    }

    private enum 特定項目 implements ISpecificKey {

        識別コード1("shikibetsuCode_1", "識別コード1"),
        識別コード2("shikibetsuCode_2", "識別コード2"),
        識別コード3("shikibetsuCode_3", "識別コード3"),
        識別コード4("shikibetsuCode_4", "識別コード4"),
        識別コード5("shikibetsuCode_5", "識別コード5"),
        識別コード6("shikibetsuCode_6", "識別コード6"),
        識別コード7("shikibetsuCode_7", "識別コード7"),
        識別コード8("shikibetsuCode_8", "識別コード8"),
        識別コード9("shikibetsuCode_9", "識別コード9"),
        識別コード10("shikibetsuCode_10", "識別コード10"),
        識別コード11("shikibetsuCode_11", "識別コード11"),
        識別コード12("shikibetsuCode_12", "識別コード12");

        private final RString itemName;
        private final RString printName;

        private 特定項目(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目 implements ICheckTarget {

        target1("listShimei", "氏名", CheckShubetsu.文字切れ),
        target2("listJusho", "住所", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

}
