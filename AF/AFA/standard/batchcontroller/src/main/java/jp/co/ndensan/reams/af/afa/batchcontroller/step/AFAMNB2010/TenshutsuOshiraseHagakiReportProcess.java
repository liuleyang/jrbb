/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.NyujokenIkkatsu;
import jp.co.ndensan.reams.af.afa.business.core.MeisaiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.SenkyomeishouParam;
import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB210.TenshutsuOshiraseHagakiReport;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAShokeitanniTypeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuryokuShuryohiEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRB210.TenshutsuOshiraseHagakiPrintEditor;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）の転出者お知らせハガキのクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class TenshutsuOshiraseHagakiReportProcess extends BatchKeyBreakBase<NyujokenKobetsuJouhou> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private AfaMapperProvider mapperProvider;
    private ShikakuHantei shikakuhantei;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private static final int ページ最大件数 = 4;
    private static final int ページ件数_3 = 3;
    private static final RString 整理番号_INDEX_1 = new RString("1");
    private static final RString 整理番号_INDEX_2 = new RString("2");
    private static final RString 整理番号_INDEX_3 = new RString("3");
    private static final RString 整理番号_INDEX_4 = new RString("4");
    private static final RString TEMP_TABLE_NYUJOKENMAISUHYO = new RString("AFAPRB212_NyujokenMaisuhyo");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectSenkyoninMeiciJyohouTempTable");
    @BatchWriter
    private IBatchReportWriterWithCheckList<TenshutsuOshiraseHagakiSource> oshiraseHagakiWCLBatchWriter;
    private ReportSourceWriter<TenshutsuOshiraseHagakiSource> oshiraseHagakiWCLSourceWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter nyujokenMaisuhyoDbWriter;
    /**
     * 地図情報イメージファイル取得。
     *
     */
    public static final RString IMAGE_FOLDER_PATH;

    static {
        IMAGE_FOLDER_PATH = new RString("imageFolderPath");
    }
    private OutputParameter<List<RString>> imageFolderPath;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Decimal> nyujokenReportIndex;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }
    private static Map<RString, Integer> 入場券印刷枚数表_印刷世帯数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_印刷枚数リスト;
    private static Map<RString, Integer> 入場券印刷枚数表_人数リスト;
    private NyujoukenGamenModel 選挙共通情報;
    
    /**
     * 送付先情報_temp取得。
     *
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
    }
    OutputParameter<Integer> pageCount;
    private int itemCount;
    private Map<RString, Set<SetaiCode>> 入場券印刷枚数表_印刷世帯数;
    private RString 入場券印刷枚数表集計単位;
    private int flag;
    private RString 地区の分類１;
    private RString 地区の分類２;
    private RString 地区の分類３;
    private TenshutsuOshiraseHagakiParam param;
    private boolean is改ページ;
    private int ページ内印字枚数;
    private Association 地方公共団体情報;

    @Override
    protected void initialize() {
        is改ページ = Boolean.FALSE;
        shikakuhantei = new ShikakuHantei();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        FlexibleDate 投票日 = parameter.get投票日();
        if (null != 投票日) {
            build.set基準日(投票日);
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        build.set住民種別(住民種別);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        parameter.setKey(shikibetsuTaishoPSMSearchKey);

        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable(parameter.getTable());
        mybatisParameter.setGroupKubun(parameter.getGroupKubun());
        mybatisParameter.set出力順(parameter.getOrder順());
        itemCount = 0;
        pageCount = new OutputParameter<>();
        nyujokenReportIndex = new OutputParameter<>();
        imageFolderPath = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        選挙共通情報 = get選挙共通情報(parameter, 地方公共団体情報);
        param = new TenshutsuOshiraseHagakiParam(
                選挙共通情報,
                null,
                null,
                null, null);
        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity 転出者お知らせハガキ = finder.get抄本情報(parameter.get抄本番号());
        if (転出者お知らせハガキ != null) {
            parameter.set年齢到達期限日(転出者お知らせハガキ.getKiteiNenreiTotatsuYMD());
        } else {
            parameter.set年齢到達期限日(FlexibleDate.EMPTY);
        }
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日 = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日 != null) {
            parameter.set前回基準日(前回基準日.get前回基準日());
        } else {
            parameter.set前回基準日(FlexibleDate.EMPTY);
        }
        NyujokenKobetsuJouhou 選挙 = mapper.select選挙の転入期限日(mybatisParameter);
        if (選挙 != null) {
            parameter.set転入期限日(選挙.get転入期限日());
            parameter.set転出日From(選挙.get転出期限日());
        } else {
            parameter.set転入期限日(FlexibleDate.EMPTY);
            parameter.set転出日From(FlexibleDate.EMPTY);
        }
        入場券印刷枚数表集計単位 = BusinessConfig.get(ConfigKeysAFA.入場券_印刷枚数表_集計単位, SubGyomuCode.AFA選挙本体);
        地区の分類１ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        地区の分類２ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        地区の分類３ = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        入場券印刷枚数表_印刷世帯数 = new HashMap<>();
        入場券印刷枚数表_印刷枚数リスト = new HashMap<>();
        入場券印刷枚数表_人数リスト = new HashMap<>();
        入場券印刷枚数表_印刷世帯数リスト = new HashMap<>();
        RString ページ内印字 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_ページ内印字枚数, SubGyomuCode.AFA選挙本体);
        ページ内印字枚数 = RString.isNullOrEmpty(ページ内印字) ? 0 : Integer.parseInt(ページ内印字.toString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        oshiraseHagakiWCLBatchWriter = NyujokenIkkatsu.mojiCutListOut(parameter.get帳票ID(),
                oshiraseHagakiWCLBatchWriter);
        oshiraseHagakiWCLSourceWriter = new ReportSourceWriter<>(oshiraseHagakiWCLBatchWriter);
        nyujokenMaisuhyoDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NYUJOKENMAISUHYO, AFABTB201NyujokenMaisuhyoEntity.class);
    }

    @Override
    protected void keyBreakProcess(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        get表示者分対象情報(転出者お知らせハガキ);
        if (flag == 2 && itemCount >= ページ内印字枚数) {
            is改ページ = Boolean.TRUE;
        } else if (flag == 2 && itemCount < ページ内印字枚数) {
            is改ページ = Boolean.FALSE;
        }
    }

    @Override
    protected void usualProcess(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        get入場券_印刷枚数表_印刷世帯数(転出者お知らせハガキ);
        get入場券_印刷枚数表_人数(転出者お知らせハガキ);
        get表示者分対象情報(転出者お知らせハガキ);
        if (flag == 2) {
            Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();
            TenshutsuOshiraseHagakiPrintEditor editor = new TenshutsuOshiraseHagakiPrintEditor();
            if (is改ページ) {
                TenshutsuOshiraseHagakiReport report = new TenshutsuOshiraseHagakiReport(param);
                report.writeBy(oshiraseHagakiWCLSourceWriter);
                param = new TenshutsuOshiraseHagakiParam(
                        選挙共通情報,
                        null,
                        null,
                        null, null);
                MeisaiJouhou 明細情報1 = edit明細情報(転出者お知らせハガキ);
                明細情報1.set整理番号(整理番号_INDEX_1);
                param.set明細情報1(edit明細情報(転出者お知らせハガキ));
                get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                param = editor.set明細情報1_転出者お知らせハガキ(param, nyujoken3tsuori);
                itemCount = 1;
            } else {
                if (itemCount == 0) {
                    MeisaiJouhou 明細情報1 = edit明細情報(転出者お知らせハガキ);
                    明細情報1.set整理番号(整理番号_INDEX_1);
                    param.set明細情報1(edit明細情報(転出者お知らせハガキ));
                    param = editor.set明細情報1_転出者お知らせハガキ(param, nyujoken3tsuori);
                    get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                    itemCount++;
                } else if (itemCount == 1) {
                    MeisaiJouhou 明細情報2 = edit明細情報(転出者お知らせハガキ);
                    明細情報2.set整理番号(整理番号_INDEX_2);
                    param.set明細情報2(edit明細情報(転出者お知らせハガキ));
                    param = editor.set明細情報2_転出者お知らせハガキ(param, nyujoken3tsuori);
                    get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                    itemCount++;
                } else if (itemCount == 2) {
                    MeisaiJouhou 明細情報3 = edit明細情報(転出者お知らせハガキ);
                    明細情報3.set整理番号(整理番号_INDEX_3);
                    param.set明細情報3(edit明細情報(転出者お知らせハガキ));
                    param = editor.set明細情報3_転出者お知らせハガキ(param, nyujoken3tsuori);
                    get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                    itemCount++;
                } else if (itemCount == ページ件数_3) {
                    MeisaiJouhou 明細情報4 = edit明細情報(転出者お知らせハガキ);
                    明細情報4.set整理番号(整理番号_INDEX_4);
                    param.set明細情報4(edit明細情報(転出者お知らせハガキ));
                    param = editor.set明細情報4_転出者お知らせハガキ(param, nyujoken3tsuori);
                    get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                    itemCount++;
                } else if (itemCount == ページ最大件数) {
                    TenshutsuOshiraseHagakiReport report = new TenshutsuOshiraseHagakiReport(param);
                    report.writeBy(oshiraseHagakiWCLSourceWriter);
                    param = new TenshutsuOshiraseHagakiParam(
                            選挙共通情報,
                            null,
                            null,
                            null, null);
                    MeisaiJouhou 明細情報1 = edit明細情報(転出者お知らせハガキ);
                    明細情報1.set整理番号(整理番号_INDEX_1);
                    param.set明細情報1(edit明細情報(転出者お知らせハガキ));
                    param = editor.set明細情報1_転出者お知らせハガキ(param, nyujoken3tsuori);
                    get入場券_印刷枚数表_印刷枚数(転出者お知らせハガキ);
                    itemCount = 1;
                }
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (param.get明細情報1() != null) {
            TenshutsuOshiraseHagakiReport report = new TenshutsuOshiraseHagakiReport(param);
            report.writeBy(oshiraseHagakiWCLSourceWriter);
        }
        for (RString key : 入場券印刷枚数表_印刷世帯数.keySet()) {
            入場券印刷枚数表_印刷世帯数リスト.put(key, 入場券印刷枚数表_印刷世帯数.get(key).size());
            AFABTB201NyujokenMaisuhyoEntity 転出者お知らせハガキ情報 = new AFABTB201NyujokenMaisuhyoEntity();
            転出者お知らせハガキ情報.setShuukeiTanni(入場券印刷枚数表集計単位);
            転出者お知らせハガキ情報.setShuukeiCode(key);
            転出者お知らせハガキ情報.setShutsuRyokuTaishou(parameter.getGroupKubun());
            転出者お知らせハガキ情報.setBunjiKireKunbun(Boolean.FALSE);
            転出者お知らせハガキ情報.setShuukeiName(get集計コード名称());
            転出者お知らせハガキ情報.setShuukeiSetaisuSuji(new Decimal(入場券印刷枚数表_印刷世帯数.get(key).size()));
            転出者お知らせハガキ情報.setShuukeiNinSuji(new Decimal(入場券印刷枚数表_人数リスト.get(key)));
            転出者お知らせハガキ情報.setShuukeiMeisuSuji(new Decimal(入場券印刷枚数表_印刷枚数リスト.get(key)));
            nyujokenMaisuhyoDbWriter.insert(転出者お知らせハガキ情報);
        }
        pageCount.setValue(oshiraseHagakiWCLBatchWriter.getPageCount());
        RString コピー元パースチェックリスト = oshiraseHagakiWCLBatchWriter.getImageFolderPath();

        List<RString> イメージファイルパース = new ArrayList<>();

        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            イメージファイルパース.add(コピー元パースチェックリスト);
        }
        imageFolderPath.setValue(イメージファイルパース);
        Decimal 入場券発行固有連番_チェック = oshiraseHagakiWCLBatchWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番_チェック);
    }

    private MeisaiJouhou edit明細情報(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        MeisaiJouhou 明細情報 = new MeisaiJouhou();
        明細情報.set送付先郵便番号(転出者お知らせハガキ.get転出先郵便番号());
        明細情報.set住所(
                転出者お知らせハガキ.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(転出者お知らせハガキ.get住所()));
        明細情報.set住所(転出者お知らせハガキ.get転出先住所());
        明細情報.set番地(転出者お知らせハガキ.get転出先番地());
        明細情報.set方書(転出者お知らせハガキ.get転出先方書());
        明細情報.set投票所名(転出者お知らせハガキ.get投票所名());
        明細情報.set投票区コード(転出者お知らせハガキ.get投票区コード());
        明細情報.set頁(転出者お知らせハガキ.get頁());
        明細情報.set行(転出者お知らせハガキ.get行());
        明細情報.set識別コード(転出者お知らせハガキ.get識別コード());
        明細情報.set投票開始時刻(転出者お知らせハガキ.get投票開始時刻());
        明細情報.set投票終了時刻(転出者お知らせハガキ.get投票終了時刻());
        明細情報.set抄本番号(parameter.get抄本番号());
        明細情報.setカナ名称(転出者お知らせハガキ.getカナ名称());
        明細情報.set性別コード(転出者お知らせハガキ.get性別コード());
        明細情報.set住民種別コード(転出者お知らせハガキ.get住民種別コード());
        明細情報.set生年月日(changeFlexibleDateToRDate(転出者お知らせハガキ.get生年月日()));
        if (転出者お知らせハガキ.get行政区コード() == null) {
            明細情報.set行政区コード(転出者お知らせハガキ.get行政区コード().getColumnValue());
        } else {
            明細情報.set行政区コード(RString.EMPTY);
        }
        明細情報.set行政区名(転出者お知らせハガキ.get行政区名());

        明細情報.set住登内住所(
                転出者お知らせハガキ.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(転出者お知らせハガキ.get住所()));

        明細情報.set住登内番地(転出者お知らせハガキ.get番地());
        if (転出者お知らせハガキ.get地区コード１() == null) {
            明細情報.set地区コード1(転出者お知らせハガキ.get地区コード１().getColumnValue());
        } else {
            明細情報.set地区コード1(RString.EMPTY);
        }
        if (転出者お知らせハガキ.get地区コード２() == null) {
            明細情報.set地区コード2(転出者お知らせハガキ.get地区コード２().getColumnValue());
        } else {
            明細情報.set地区コード2(RString.EMPTY);
        }
        if (転出者お知らせハガキ.get地区コード３() == null) {
            明細情報.set地区コード3(転出者お知らせハガキ.get地区コード３().getColumnValue());
        } else {
            明細情報.set地区コード3(RString.EMPTY);
        }
        明細情報.set地区名1(転出者お知らせハガキ.get地区名１());
        明細情報.set地区名2(転出者お知らせハガキ.get地区名２());
        明細情報.set地区名3(転出者お知らせハガキ.get地区名３());
        明細情報.set世帯コード(転出者お知らせハガキ.get世帯コード() == null ? SetaiCode.EMPTY : 転出者お知らせハガキ.get世帯コード());
        明細情報.set世帯主名(転出者お知らせハガキ.get世帯主名() == null ? AtenaMeisho.EMPTY : 転出者お知らせハガキ.get世帯主名());
        明細情報.set住登内住所(
                転出者お知らせハガキ.get住所() == null ? AtenaJusho.EMPTY : new AtenaJusho(転出者お知らせハガキ.get住所()));
        明細情報.set住登内番地(転出者お知らせハガキ.get番地());
        明細情報.set住登内方書(転出者お知らせハガキ.get方書());
        明細情報.set帳票ID(parameter.get帳票ID());
        return 明細情報;
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param 転出者お知らせハガキ引数 AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報(AFABTB201SelectProcessParameter 転出者お知らせハガキ引数,
            Association 地方公共団体情報) {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        nyujoukenGamenModel.set抄本番号(new RString(転出者お知らせハガキ引数.get抄本番号().getColumnValue()));
        nyujoukenGamenModel.set抄本名(転出者お知らせハガキ引数.get抄本名());
        nyujoukenGamenModel.set入場券名称1(転出者お知らせハガキ引数.get入場券名1());
        nyujoukenGamenModel.set入場券名称2(転出者お知らせハガキ引数.get入場券名2());
        nyujoukenGamenModel.set入場券名称3(転出者お知らせハガキ引数.get入場券名3());
        nyujoukenGamenModel.setサンプル文字(転出者お知らせハガキ引数.getサンプル文字());
        FlexibleDate 投票日 = 転出者お知らせハガキ引数.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(転出者お知らせハガキ引数.get投票日().toString()));
        List<SenkyomeishouParam> 選挙名称リスト = new ArrayList<>();
        if (転出者お知らせハガキ引数.get選挙リスト() != null
                && !転出者お知らせハガキ引数.get選挙リスト().isEmpty()) {
            for (Senkyomeishou senkyomeishou : 転出者お知らせハガキ引数.get選挙リスト()) {
                SenkyomeishouParam senkyomeishouParam = new SenkyomeishouParam();
                senkyomeishouParam.set選挙名称(senkyomeishou.get選挙名称());
                senkyomeishouParam.set選挙略称(senkyomeishou.get選挙略称());
                選挙名称リスト.add(senkyomeishouParam);
            }
            nyujoukenGamenModel.set選挙名称(選挙名称リスト);
        }
        nyujoukenGamenModel.set告示年月日(RDate.MAX);
        nyujoukenGamenModel.set地方公共団体情報(地方公共団体情報);
        return nyujoukenGamenModel;
    }

    private RDate changeFlexibleDateToRDate(FlexibleDate flexibleDate) {
        if (flexibleDate != null && !flexibleDate.isEmpty() && flexibleDate.isValid()) {
            return new RDate(flexibleDate.toString());
        } else {
            return null;
        }
    }

    private void get表示者分対象情報(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        RString 表示者用入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.入場券_表示者用入場券出力区分_出力しない.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            if (is表示者(転出者お知らせハガキ)
                    && 表示者分対象_抽出終了日判定(転出者お知らせハガキ)) {
                flag = 2;
            }
            if (is抹消者(転出者お知らせハガキ)
                    && is二重登録抹消(転出者お知らせハガキ)) {
                flag = 2;
            }
        }
    }

    private boolean is表示者(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        mybatisParameter.set識別コード(転出者お知らせハガキ.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is表示者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日(), parameter.get投票日(), parameter.get前回基準日(),
                SenkyoShurui.toValue(parameter.get選挙種類()));
    }

    private boolean is抹消者(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        mybatisParameter.set識別コード(転出者お知らせハガキ.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is抹消者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日());
    }

    private boolean 表示者分対象_抽出終了日判定(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(転出者お知らせハガキ);
        boolean isBlank = Boolean.TRUE;
        if (!FlexibleDate.EMPTY.equals(parameter.get転出日From())
                && FlexibleDate.EMPTY.equals(parameter.get転出日To())) {
            isBlank = parameter.get転出日From().isBeforeOrEquals(転出日)
                    && !parameter.get転出日To().isBefore(転出日);
        }
        if (ShutsuryokuShuryohiEnum.投票日を含めない.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日().minusDay(1)) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日()) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().minusDay(1).toDateString())) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().toDateString())) && isBlank;
        }
        return Boolean.FALSE;

    }

    private FlexibleDate get転出日(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        FlexibleDate 転出日 = FlexibleDate.EMPTY;
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        if (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = 転出者お知らせハガキ.get消除届出年月日();
        } else if (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = 転出者お知らせハガキ.get消除異動年月日();
        }
        return 転出日;
    }

    private boolean is二重登録抹消(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        AfT113SenkyoShikakuEntity 選挙資格 = finder.get選挙資格情報(parameter.get選挙種類(), 転出者お知らせハガキ.get識別コード());
        if (選挙資格 != null && MasshoJiyuCodeEnum.二重登録抹消.getCode().equals(選挙資格.getMasshoJiyuCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void get入場券_印刷枚数表_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷世帯数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷世帯数(転出者お知らせハガキ);
        }
    }

    private void get投票区コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get投票所コード())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get投票区コード()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get投票区コード(), 同一世帯コード);
        }
    }

    private void get住所コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get町域コード().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get町域コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get行政区コード_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get行政区コード().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get行政区コード().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード1_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get地区コード１().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get地区コード１().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード2_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get地区コード２().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get地区コード２().getColumnValue(), 同一世帯コード);
        }
    }

    private void get地区コード3_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get地区コード３().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get地区コード３().getColumnValue(), 同一世帯コード);
        }
    }

    private void get郵便番号_印刷世帯数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷世帯数.containsKey(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷世帯数.get(転出者お知らせハガキ.get郵便番号().getColumnValue()).add(転出者お知らせハガキ.get世帯コード());
        } else {
            Set<SetaiCode> 同一世帯コード = new HashSet<>();
            同一世帯コード.add(転出者お知らせハガキ.get世帯コード());
            入場券印刷枚数表_印刷世帯数.put(転出者お知らせハガキ.get郵便番号().getColumnValue(), 同一世帯コード);
        }
    }

    private void get入場券_印刷枚数表_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_人数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_人数(転出者お知らせハガキ);
        }
    }

    private void get投票区コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get投票所コード())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get投票区コード(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get投票区コード(), 1);
        }
    }

    private void get住所コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get町域コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_人数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_人数リスト.containsKey(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_人数リスト.get(転出者お知らせハガキ.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_人数リスト.put(転出者お知らせハガキ.get郵便番号().getColumnValue(), 1);
        }
    }

    private void get入場券_印刷枚数表_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_投票区コード.isEqual(入場券印刷枚数表集計単位)) {
            get投票区コード_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_住所コード.isEqual(入場券印刷枚数表集計単位)) {
            get住所コード_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_行政区コード.isEqual(入場券印刷枚数表集計単位)) {
            get行政区コード_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード1_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード2_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            get地区コード3_印刷枚数(転出者お知らせハガキ);
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_郵便番号.isEqual(入場券印刷枚数表集計単位)) {
            get郵便番号_印刷枚数(転出者お知らせハガキ);
        }
    }

    private void get投票区コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (RString.isNullOrEmpty(転出者お知らせハガキ.get投票区コード())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get投票所コード())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get投票区コード(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get投票区コード()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get投票区コード(), 1);
        }
    }

    private void get住所コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get町域コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get町域コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get町域コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get町域コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get町域コード().getColumnValue(), 1);
        }
    }

    private void get行政区コード_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get行政区コード() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get行政区コード().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get行政区コード().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get行政区コード().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get行政区コード().getColumnValue(), 1);
        }
    }

    private void get地区コード1_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード１() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get地区コード１().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード１().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get地区コード１().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード１().getColumnValue(), 1);
        }
    }

    private void get地区コード2_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード２() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get地区コード２().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード２().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get地区コード２().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード２().getColumnValue(), 1);
        }
    }

    private void get地区コード3_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get地区コード３() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get地区コード３().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード３().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get地区コード３().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get地区コード３().getColumnValue(), 1);
        }
    }

    private void get郵便番号_印刷枚数(NyujokenKobetsuJouhou 転出者お知らせハガキ) {
        if (転出者お知らせハガキ.get郵便番号() == null
                || RString.isNullOrEmpty(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            return;
        }
        if (入場券印刷枚数表_印刷枚数リスト.containsKey(転出者お知らせハガキ.get郵便番号().getColumnValue())) {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get郵便番号().getColumnValue(),
                    入場券印刷枚数表_印刷枚数リスト.get(転出者お知らせハガキ.get郵便番号().getColumnValue()) + 1);
        } else {
            入場券印刷枚数表_印刷枚数リスト.put(転出者お知らせハガキ.get郵便番号().getColumnValue(), 1);
        }
    }

    private RString get集計コード名称() {
        RString 集計コード名称 = RString.EMPTY;
        if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_投票区コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_投票区コード.getValue();
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_住所コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_住所コード.getValue();
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_行政区コード.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_行政区コード.getValue();
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード1.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類１;
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード2.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類２;
        } else if (AFAConfigKeysValue.入場券_印刷枚数表_集計単位_地区コード3.isEqual(入場券印刷枚数表集計単位)) {
            集計コード名称 = 地区の分類３;
        } else if (AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_郵便番号.getKey().equals(入場券印刷枚数表集計単位)) {
            集計コード名称 = AFAShokeitanniTypeEnum.入場券_印刷枚数表_集計単位_郵便番号.getValue();
        }
        return 集計コード名称;
    }
}
