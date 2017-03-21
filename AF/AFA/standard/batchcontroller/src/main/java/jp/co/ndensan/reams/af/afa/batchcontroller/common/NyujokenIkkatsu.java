/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.SofusakiJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 入場券発行
 *
 * @reamsid_L AF-0160-026 lis
 */
public class NyujokenIkkatsu {

    private static final int ZERO = 0;
    private static final RString 有権者分 = new RString("1");
    private static final RString 表示者分 = new RString("2");
    private static final RString 漢字宛名 = new RString("宛名");
    private static final RString 漢字宛名1 = new RString("宛名1");
    private static final RString 漢字宛名2 = new RString("宛名2");
    private static final RString 漢字宛名3 = new RString("宛名3");
    private static final RString 漢字宛名4 = new RString("宛名4");
    private static final RString 漢字住所1 = new RString("住所1");
    private static final RString 漢字住所2 = new RString("住所2");
    private static final RString 漢字住所3 = new RString("住所3");
    private static final RString 漢字住所4 = new RString("住所4");
    private static final RString 漢字住所5 = new RString("住所5");
    private static final RString 漢字住所6 = new RString("住所6");
    private static final RString 漢字住所7 = new RString("住所7");
    private static final RString 漢字住所8 = new RString("住所8");
    private static final RString 漢字転出前住所1 = new RString("転出前住所1");
    private static final RString 漢字転出前住所2 = new RString("転出前住所2");
    private static final RString 漢字転出前住所3 = new RString("転出前住所3");
    private static final RString 漢字転出前住所4 = new RString("転出前住所4");
    private static final RString 漢字名称1 = new RString("名称1");
    private static final RString 漢字名称2 = new RString("名称2");
    private static final RString 漢字名称3 = new RString("名称3");
    private static final RString 漢字名称4 = new RString("名称4");
    private static final RString 漢字名称5 = new RString("名称5");
    private static final RString 漢字名称6 = new RString("名称6");
    private static final RString 漢字名称7 = new RString("名称7");
    private static final RString 漢字名称8 = new RString("名称8");
    private static final RString 漢字投票所名1 = new RString("投票所名1");
    private static final RString 漢字投票所名2 = new RString("投票所名2");
    private static final RString 漢字投票所名3 = new RString("投票所名3");
    private static final RString 漢字投票所名4 = new RString("投票所名4");
    private static final RString 漢字投票所名5 = new RString("投票所名5");
    private static final RString 漢字投票所名6 = new RString("投票所名6");
    private static final RString 漢字投票所名7 = new RString("投票所名7");
    private static final RString 漢字投票所名8 = new RString("投票所名8");
    private static final RString 漢字世帯主名1 = new RString("世帯主名1");
    private static final RString 漢字世帯主名2 = new RString("世帯主名2");
    private static final RString 漢字世帯主名3 = new RString("世帯主名3");
    private static final RString 漢字カナ名称1 = new RString("カナ名称1");
    private static final RString 漢字カナ名称2 = new RString("カナ名称2");
    private static final RString 漢字カナ名称3 = new RString("カナ名称3");
    private static final RString 漢字送付先住所 = new RString("送付先住所");
    private static final RString 漢字送付先住所1 = new RString("送付先住所1");
    private static final RString 漢字送付先住所2 = new RString("送付先住所2");
    private static final RString 漢字送付先住所3 = new RString("送付先住所3");
    private static final RString 漢字送付先住所4 = new RString("送付先住所4");
    private static final RString 世帯主名1 = new RString("setainushiMei_1");
    private static final RString 世帯主名2 = new RString("setainushiMei_2");
    private static final RString 世帯主名3 = new RString("setainushiMei_3");
    private static final RString 住所1 = new RString("jusho_1");
    private static final RString 住所2 = new RString("jusho_2");
    private static final RString 住所3 = new RString("jusho_3");
    private static final RString 住所4 = new RString("jusho_4");
    private static final RString 住所5 = new RString("jusho_5");
    private static final RString 住所6 = new RString("jusho_6");
    private static final RString 住所7 = new RString("jusho_7");
    private static final RString 住所8 = new RString("jusho_8");
    private static final RString 名称1 = new RString("shimei_1");
    private static final RString 名称2 = new RString("shimei_2");
    private static final RString 名称3 = new RString("shimei_3");
    private static final RString 名称4 = new RString("shimei_4");
    private static final RString 名称5 = new RString("shimei_5");
    private static final RString 名称6 = new RString("shimei_6");
    private static final RString 名称7 = new RString("shimei_7");
    private static final RString 名称8 = new RString("shimei_8");
    private static final RString カナ名称1 = new RString("shimeiKana_1");
    private static final RString カナ名称2 = new RString("shimeiKana_2");
    private static final RString カナ名称3 = new RString("shimeiKana_3");
    private static final RString 投票所名1 = new RString("tohyojoMei_1");
    private static final RString 投票所名2 = new RString("tohyojoMei_2");
    private static final RString 投票所名3 = new RString("tohyojoMei_3");
    private static final RString 投票所名4 = new RString("tohyojoMei_4");
    private static final RString 投票所名5 = new RString("tohyojoMei_5");
    private static final RString 投票所名6 = new RString("tohyojoMei_6");
    private static final RString 投票所名7 = new RString("tohyojoMei_7");
    private static final RString 投票所名8 = new RString("tohyojoMei_8");
    private static final RString 宛名1 = new RString("atena_1");
    private static final RString 宛名2 = new RString("atena_2");
    private static final RString 宛名3 = new RString("atena_3");
    private static final RString 宛名4 = new RString("atena_4");
    private static final RString 送付先住所1 = new RString("sofusakiJusho_1");
    private static final RString 送付先住所2 = new RString("sofusakiJusho_2");
    private static final RString 送付先住所3 = new RString("sofusakiJusho_3");
    private static final RString 送付先住所4 = new RString("sofusakiJusho_4");
    private static final RString 転出前住所1 = new RString("oldJusho_1");
    private static final RString 転出前住所2 = new RString("oldJusho_2");
    private static final RString 転出前住所3 = new RString("oldJusho_3");
    private static final RString 転出前住所4 = new RString("oldJusho_4");
    private static final RString 識別コード名称1 = new RString("識別コード1");
    private static final RString 識別コード名称2 = new RString("識別コード2");
    private static final RString 識別コード名称3 = new RString("識別コード3");
    private static final RString 識別コード名称4 = new RString("識別コード4");
    private static final RString 識別コード名称5 = new RString("識別コード5");
    private static final RString 識別コード名称6 = new RString("識別コード6");

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NyujokenIkkatsu() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link AfaMapperProvider}
     */
    public NyujokenIkkatsu(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link Nyujoken3tsuori}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link Nyujoken3tsuori}のインスタンス
     */
    public static NyujokenIkkatsu createInstance() {
        return InstanceProvider.create(NyujokenIkkatsu.class);
    }

    /**
     * 文字切れリスト出力
     *
     * @param 帳票ID RString
     * @param batchReportWriter IBatchReportWriterWithCheckList
     * @return IBatchReportWriterWithCheckList IBatchReportWriterWithCheckList
     */
    public static IBatchReportWriterWithCheckList mojiCutListOut(RString 帳票ID, IBatchReportWriterWithCheckList batchReportWriter) {
        CheckListLineItemSet pairs = null;
        if (ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value().equals(帳票ID)) {
            pairs = CheckListLineItemSet.of(
                    NyujokenIkkatsu.特定項目_個票3つ折り.class,
                    NyujokenIkkatsu.チェック項目_個票3つ折り.class);
        } else if (ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value().equals(帳票ID)) {
            pairs = CheckListLineItemSet.of(
                    NyujokenIkkatsu.特定項目_はがき4つ切り.class,
                    NyujokenIkkatsu.チェック項目_はがき4つ切り.class);
        } else if (ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value().equals(帳票ID)) {
            pairs = CheckListLineItemSet.of(
                    NyujokenIkkatsu.特定項目_シーラー.class,
                    NyujokenIkkatsu.チェック項目_シーラー.class);
        } else if (ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value().equals(帳票ID)) {
            pairs = CheckListLineItemSet.of(
                    NyujokenIkkatsu.特定項目_ポステックス.class,
                    NyujokenIkkatsu.チェック項目_ポステックス.class);
        } else if (ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value().equals(帳票ID)) {
            pairs = CheckListLineItemSet.of(
                    NyujokenIkkatsu.特定項目_転出者お知らせハガキ.class,
                    NyujokenIkkatsu.チェック項目_転出者お知らせハガキ.class);
        }
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        if (ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value().equals(帳票ID)) {
            batchReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(Nyujoken3tsuoriSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value())
                    .build();
        } else if (ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value().equals(帳票ID)) {
            batchReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(NyujokenHagakiSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value())
                    .build();
        } else if (ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value().equals(帳票ID)) {
            batchReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(NyujokenSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value())
                    .build();
        } else if (ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value().equals(帳票ID)) {
            batchReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(NyujokenPostexSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(ReportIdKeys.AFAPRB204_投票所入場券_ポステックス.value())
                    .build();
        } else if (ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value().equals(帳票ID)) {
            batchReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TenshutsuOshiraseHagakiSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(ReportIdKeys.AFAPRB210_転出者お知らせハガキ.value())
                    .build();
        }
        return batchReportWriter;
    }

    /**
     * 選挙人一括情報取得
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙種類 RString
     * @param 出力順 RString
     * @param 投票年月日 FlexibleDate
     * @return List NyujokenKobetsuJouhou
     */
    @Transaction
    public List<NyujokenKobetsuJouhou> getAllSenkyoninJoho(ShohonNo 抄本番号, RString 選挙種類, RString 出力順, FlexibleDate 投票年月日) {
        INyujokenIkkatsuMapper mapper1 = mapperProvider.create(INyujokenIkkatsuMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        if (null != 投票年月日) {
            build.set基準日(投票年月日);
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        LasdecCode 地方公共団体コード = 地方公共団体情報.get地方公共団体コード();
        int 連番 = 地方公共団体情報.get連番();
        FlexibleDate システム日付 = FlexibleDate.getNowDate();

        NyujokenIkkatsuMybatisParameter param
                = new NyujokenIkkatsuMybatisParameter(shikibetsuTaishoPSMSearchKey, 抄本番号, 選挙種類, 出力順, 地方公共団体コード, 連番, システム日付);
        List<NyujokenKobetsuJouhou> jouhouList = mapper1.select選挙人情報リスト(param);
        if (null == jouhouList) {
            return Collections.EMPTY_LIST;
        }
        return jouhouList;
    }

    /**
     * 送付先情報取得
     *
     * @param 選挙人情報リスト NyujokenKobetsuJouhou
     * @param 出力対象 RString
     * @return SofusakiJouhou 送付先情報
     */
    public List<SofusakiJouhou> getSofusakiJoho(List<NyujokenKobetsuJouhou> 選挙人情報リスト, RString 出力対象) {
        List<SofusakiJouhou> sofusakiJouhouList = new ArrayList();
        List<NyujokenKobetsuJouhou> result = new ArrayList();

        SetaiCode 世帯コード = null;
        if (null != 選挙人情報リスト && !選挙人情報リスト.isEmpty()) {
            世帯コード = 選挙人情報リスト.get(ZERO).get世帯コード();
            result.add(選挙人情報リスト.get(ZERO));
            for (NyujokenKobetsuJouhou 選挙人情報 : 選挙人情報リスト) {
                if (世帯コード != null && !世帯コード.equals(選挙人情報.get世帯コード())) {
                    世帯コード = 選挙人情報.get世帯コード();
                    result.add(選挙人情報);
                }
            }
        }

        for (NyujokenKobetsuJouhou entity : result) {
            if (表示者分.equals(出力対象)) {
                SofusakiJouhou jouhou = new SofusakiJouhou();
                jouhou.set送付先郵便番号(entity.get郵便番号());
                jouhou.set送付先行政区コード(entity.get行政区コード());
                jouhou.set送付先全国住所コード(new ChoikiCode(null == entity.get全国住所コード() ? RString.EMPTY : entity.get全国住所コード().getColumnValue()));
                jouhou.set送付先地区コード1(entity.get地区コード１());
                jouhou.set送付先地区名1(entity.get地区名１());
                jouhou.set送付先世帯コード(entity.get世帯コード());
                jouhou.set送付先世帯主名(entity.get世帯主名());
                jouhou.set送付先住所(entity.get転出先住所());
                jouhou.set送付先番地(entity.get転出先番地());
                jouhou.set送付先方書(entity.get転出先方書());
                jouhou.set送付先行政区名(entity.get行政区名());
                jouhou.set送付先宛名(entity.get名称());
                jouhou.set送付先投票区コード(entity.get投票区コード());
                jouhou.set送付先名簿_頁(entity.get頁());
                jouhou.set送付先名簿_行(entity.get行());
                sofusakiJouhouList.add(jouhou);
            }
            if (有権者分.equals(出力対象)) {
                SofusakiJouhou jouhou = new SofusakiJouhou();
                jouhou.set送付先郵便番号(entity.get郵便番号());
                jouhou.set送付先行政区コード(entity.get行政区コード());
                jouhou.set送付先全国住所コード(entity.get町域コード());
                jouhou.set送付先地区コード1(entity.get地区コード１());
                jouhou.set送付先地区名1(entity.get地区名１());
                jouhou.set送付先世帯コード(entity.get世帯コード());
                jouhou.set送付先世帯主名(entity.get世帯主名());
                jouhou.set送付先住所(new AtenaJusho(entity.get住所()));
                jouhou.set送付先番地(entity.get番地());
                jouhou.set送付先方書(entity.get方書());
                jouhou.set送付先行政区名(entity.get行政区名());
                jouhou.set送付先宛名(entity.get名称());
                jouhou.set送付先投票区コード(entity.get投票区コード());
                jouhou.set送付先名簿_頁(entity.get頁());
                jouhou.set送付先名簿_行(entity.get行());
                sofusakiJouhouList.add(jouhou);
            }
        }
        return sofusakiJouhouList;
    }

    /**
     * 選挙人個別情報取得
     *
     * @param 選挙人情報リスト NyujokenKobetsuJouhou
     * @param 選挙人一覧リスト NyujokenKobetsuJouhou
     * @return List NyujokenKobetsuJouhou
     */
    public List<NyujokenKobetsuJouhou> getSenkyoninJoho(List<NyujokenKobetsuJouhou> 選挙人情報リスト, List<NyujokenKobetsuJouhou> 選挙人一覧リスト) {
        List<NyujokenKobetsuJouhou> entity = new ArrayList();
        if (null != 選挙人情報リスト && !選挙人情報リスト.isEmpty() && null != 選挙人一覧リスト && !選挙人一覧リスト.isEmpty()) {
            for (NyujokenKobetsuJouhou 選挙人情報 : 選挙人情報リスト) {
                for (NyujokenKobetsuJouhou 選挙人一覧 : 選挙人一覧リスト) {
                    if (null != 選挙人情報.get識別コード() && null != 選挙人一覧.get識別コード() && 選挙人情報.get識別コード().equals(選挙人一覧.get識別コード())) {
                        entity.add(選挙人情報);
                    }
                }
            }
        }
        return entity;
    }

    /**
     * 世帯情報取得
     *
     * @param 選挙人情報リスト NyujokenKobetsuJouhou
     * @param 世帯コードリスト NyujokenKobetsuJouhou
     * @return List NyujokenKobetsuJouhou
     */
    public List<NyujokenKobetsuJouhou> getSetaiJoho(List<NyujokenKobetsuJouhou> 選挙人情報リスト, List<NyujokenKobetsuJouhou> 世帯コードリスト) {
        List<SetaiCode> 世帯コードリストnew = new ArrayList<>();
        if (世帯コードリスト == null || 世帯コードリスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        if (選挙人情報リスト == null || 選挙人情報リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        for (NyujokenKobetsuJouhou 世帯コード情報 : 世帯コードリスト) {
            if (!世帯コードリストnew.contains(世帯コード情報.get世帯コード())) {
                世帯コードリストnew.add(世帯コード情報.get世帯コード());
            }

        }
        if (世帯コードリストnew.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<NyujokenKobetsuJouhou> nyujokenKobetsuJouhouEntity = new ArrayList<>();
        for (NyujokenKobetsuJouhou 選挙人情報 : 選挙人情報リスト) {
            for (NyujokenKobetsuJouhou 世帯コード : 世帯コードリスト) {
                if (null != 選挙人情報.get世帯コード() && null != 世帯コード.get世帯コード() && 選挙人情報.get世帯コード().equals(世帯コード.get世帯コード())) {
                    nyujokenKobetsuJouhouEntity.add(選挙人情報);
                }
            }
        }
        return nyujokenKobetsuJouhouEntity;
    }

    /**
     * 世帯一覧表情報取得
     *
     * @param 選挙人情報リスト NyujokenKobetsuJouhou
     * @param 送付先情報リスト SofusakiJouhou
     * @param 抽出対象世帯人数 int
     * @return List NyujokenKobetsuJouhou
     */
    public List<SofusakiJouhou> getSetaiListJoho(List<NyujokenKobetsuJouhou> 選挙人情報リスト, List<SofusakiJouhou> 送付先情報リスト, int 抽出対象世帯人数) {

        List<SofusakiJouhou> entity = new ArrayList();
        SetaiCode 世帯コード;
        for (NyujokenKobetsuJouhou 選挙人情報1 : 選挙人情報リスト) {
            int number = 0;
            世帯コード = 選挙人情報1.get世帯コード();
            for (NyujokenKobetsuJouhou 選挙人情報2 : 選挙人情報リスト) {
                if (null != 世帯コード && !世帯コード.isEmpty() && 世帯コード.equals(選挙人情報2.get世帯コード())) {
                    number++;
                }
            }
            if (number >= 抽出対象世帯人数) {
                for (SofusakiJouhou 送付先情報 : 送付先情報リスト) {
                    if (選挙人情報1.get世帯コード().equals(送付先情報.get送付先世帯コード())) {
                        entity.add(送付先情報);
                    }
                }
            }
        }
        if (entity.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return entity;
    }

    private enum 特定項目_個票3つ折り implements ISpecificKey {

        識別コード1("shikibetsuCode_3tsuori_1", 識別コード名称1.toString()),
        識別コード2("shikibetsuCode_3tsuori_2", 識別コード名称2.toString()),
        識別コード3("shikibetsuCode_3tsuori_3", 識別コード名称3.toString());

        private final RString itemName1;
        private final RString printName1;

        private 特定項目_個票3つ折り(String itemName1, String printName1) {
            this.itemName1 = new RString(itemName1);
            this.printName1 = new RString(printName1);
        }

        @Override
        public RString getItemName() {
            return this.itemName1;
        }

        @Override
        public RString getPrintName() {
            return this.printName1;
        }
    }

    private enum 特定項目_はがき4つ切り implements ISpecificKey {

        識別コード1("shikibetsuCode_Hagaki_1", 識別コード名称1.toString()),
        識別コード2("shikibetsuCode_Hagaki_2", 識別コード名称2.toString()),
        識別コード3("shikibetsuCode_Hagaki_3", 識別コード名称3.toString()),
        識別コード4("shikibetsuCode_Hagaki_4", 識別コード名称4.toString());

        private final RString itemName2;
        private final RString printName2;

        private 特定項目_はがき4つ切り(String itemName2, String printName2) {
            this.itemName2 = new RString(itemName2);
            this.printName2 = new RString(printName2);
        }

        @Override
        public RString getItemName() {
            return this.itemName2;
        }

        @Override
        public RString getPrintName() {
            return this.printName2;
        }
    }

    private enum 特定項目_シーラー implements ISpecificKey {

        識別コード1("shikibetsuCode_Sealer_1", 識別コード名称1.toString()),
        識別コード2("shikibetsuCode_Sealer_2", 識別コード名称2.toString()),
        識別コード3("shikibetsuCode_Sealer_3", 識別コード名称3.toString()),
        識別コード4("shikibetsuCode_Sealer_4", 識別コード名称4.toString()),
        識別コード5("shikibetsuCode_Sealer_5", 識別コード名称5.toString()),
        識別コード6("shikibetsuCode_Sealer_6", 識別コード名称6.toString()),
        識別コード7("shikibetsuCode_Sealer_7", "識別コード7"),
        識別コード8("shikibetsuCode_Sealer_8", "識別コード8");

        private final RString itemName3;
        private final RString printName3;

        private 特定項目_シーラー(String itemName3, String printName3) {
            this.itemName3 = new RString(itemName3);
            this.printName3 = new RString(printName3);
        }

        @Override
        public RString getItemName() {
            return this.itemName3;
        }

        @Override
        public RString getPrintName() {
            return this.printName3;
        }
    }

    private enum 特定項目_ポステックス implements ISpecificKey {

        識別コード1("shikibetsuCode_Postex_1", 識別コード名称1.toString()),
        識別コード2("shikibetsuCode_Postex_2", 識別コード名称2.toString()),
        識別コード3("shikibetsuCode_Postex_3", 識別コード名称3.toString()),
        識別コード4("shikibetsuCode_Postex_4", 識別コード名称4.toString()),
        識別コード5("shikibetsuCode_Postex_5", 識別コード名称5.toString()),
        識別コード6("shikibetsuCode_Postex_6", 識別コード名称6.toString());

        private final RString itemName4;
        private final RString printName4;

        private 特定項目_ポステックス(String itemName4, String printName4) {
            this.itemName4 = new RString(itemName4);
            this.printName4 = new RString(printName4);
        }

        @Override
        public RString getItemName() {
            return this.itemName4;
        }

        @Override
        public RString getPrintName() {
            return this.printName4;
        }
    }

    private enum 特定項目_転出者お知らせハガキ implements ISpecificKey {

        識別コード1("shikibetsuCode_TenshutsushaHagaki_1", 識別コード名称1.toString()),
        識別コード2("shikibetsuCode_TenshutsushaHagaki_2", 識別コード名称2.toString()),
        識別コード3("shikibetsuCode_TenshutsushaHagaki_3", 識別コード名称3.toString()),
        識別コード4("shikibetsuCode_TenshutsushaHagaki_4", 識別コード名称4.toString());

        private final RString itemName5;
        private final RString printName5;

        private 特定項目_転出者お知らせハガキ(String itemName5, String printName5) {
            this.itemName5 = new RString(itemName5);
            this.printName5 = new RString(printName5);
        }

        @Override
        public RString getItemName() {
            return this.itemName5;
        }

        @Override
        public RString getPrintName() {
            return this.printName5;
        }
    }

    private enum チェック項目_転出者お知らせハガキ implements ICheckTarget {

        target1(住所1.toString(), 漢字住所1.toString(), CheckShubetsu.文字切れ),
        target2(住所2.toString(), 漢字住所2.toString(), CheckShubetsu.文字切れ),
        target3(住所3.toString(), 漢字住所3.toString(), CheckShubetsu.文字切れ),
        target4(住所4.toString(), 漢字住所4.toString(), CheckShubetsu.文字切れ),
        target5(転出前住所1.toString(), 漢字転出前住所1.toString(), CheckShubetsu.文字切れ),
        target6(転出前住所2.toString(), 漢字転出前住所2.toString(), CheckShubetsu.文字切れ),
        target7(転出前住所3.toString(), 漢字転出前住所3.toString(), CheckShubetsu.文字切れ),
        target8(転出前住所4.toString(), 漢字転出前住所4.toString(), CheckShubetsu.文字切れ),
        target9(名称1.toString(), 漢字名称1.toString(), CheckShubetsu.文字切れ),
        target10(名称2.toString(), 漢字名称2.toString(), CheckShubetsu.文字切れ),
        target11(名称3.toString(), 漢字名称3.toString(), CheckShubetsu.文字切れ),
        target12(名称4.toString(), 漢字名称4.toString(), CheckShubetsu.文字切れ),
        target13(投票所名1.toString(), 漢字投票所名1.toString(), CheckShubetsu.文字切れ),
        target14(投票所名2.toString(), 漢字投票所名2.toString(), CheckShubetsu.文字切れ),
        target15(投票所名3.toString(), 漢字投票所名3.toString(), CheckShubetsu.文字切れ),
        target16(投票所名4.toString(), 漢字投票所名4.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目_転出者お知らせハガキ(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum チェック項目_ポステックス implements ICheckTarget {

        target1(宛名1.toString(), 漢字宛名.toString(), CheckShubetsu.文字切れ),
        target2(住所1.toString(), 漢字住所1.toString(), CheckShubetsu.文字切れ),
        target3(住所2.toString(), 漢字住所2.toString(), CheckShubetsu.文字切れ),
        target4(住所3.toString(), 漢字住所3.toString(), CheckShubetsu.文字切れ),
        target5(住所4.toString(), 漢字住所4.toString(), CheckShubetsu.文字切れ),
        target6(住所5.toString(), 漢字住所5.toString(), CheckShubetsu.文字切れ),
        target7(住所6.toString(), 漢字住所6.toString(), CheckShubetsu.文字切れ),
        target8(送付先住所1.toString(), 漢字送付先住所.toString(), CheckShubetsu.文字切れ),
        target9(名称1.toString(), 漢字名称1.toString(), CheckShubetsu.文字切れ),
        target10(名称2.toString(), 漢字名称2.toString(), CheckShubetsu.文字切れ),
        target11(名称3.toString(), 漢字名称3.toString(), CheckShubetsu.文字切れ),
        target12(名称4.toString(), 漢字名称4.toString(), CheckShubetsu.文字切れ),
        target13(名称5.toString(), 漢字名称5.toString(), CheckShubetsu.文字切れ),
        target14(名称6.toString(), 漢字名称6.toString(), CheckShubetsu.文字切れ),
        target15(投票所名1.toString(), 漢字投票所名1.toString(), CheckShubetsu.文字切れ),
        target16(投票所名2.toString(), 漢字投票所名2.toString(), CheckShubetsu.文字切れ),
        target17(投票所名3.toString(), 漢字投票所名3.toString(), CheckShubetsu.文字切れ),
        target18(投票所名4.toString(), 漢字投票所名4.toString(), CheckShubetsu.文字切れ),
        target19(投票所名5.toString(), 漢字投票所名5.toString(), CheckShubetsu.文字切れ),
        target20(投票所名6.toString(), 漢字投票所名6.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目_ポステックス(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum チェック項目_シーラー implements ICheckTarget {

        target1(宛名1.toString(), 漢字宛名1.toString(), CheckShubetsu.文字切れ),
        target2(宛名2.toString(), 漢字宛名2.toString(), CheckShubetsu.文字切れ),
        target3(住所1.toString(), 漢字住所1.toString(), CheckShubetsu.文字切れ),
        target4(住所2.toString(), 漢字住所2.toString(), CheckShubetsu.文字切れ),
        target5(住所3.toString(), 漢字住所3.toString(), CheckShubetsu.文字切れ),
        target6(住所4.toString(), 漢字住所4.toString(), CheckShubetsu.文字切れ),
        target7(住所5.toString(), 漢字住所5.toString(), CheckShubetsu.文字切れ),
        target8(住所6.toString(), 漢字住所6.toString(), CheckShubetsu.文字切れ),
        target9(住所7.toString(), 漢字住所7.toString(), CheckShubetsu.文字切れ),
        target10(住所8.toString(), 漢字住所8.toString(), CheckShubetsu.文字切れ),
        target11(送付先住所1.toString(), 漢字送付先住所1.toString(), CheckShubetsu.文字切れ),
        target12(送付先住所2.toString(), 漢字送付先住所2.toString(), CheckShubetsu.文字切れ),
        target13(名称1.toString(), 漢字名称1.toString(), CheckShubetsu.文字切れ),
        target14(名称2.toString(), 漢字名称2.toString(), CheckShubetsu.文字切れ),
        target15(名称3.toString(), 漢字名称3.toString(), CheckShubetsu.文字切れ),
        target16(名称4.toString(), 漢字名称4.toString(), CheckShubetsu.文字切れ),
        target17(名称5.toString(), 漢字名称5.toString(), CheckShubetsu.文字切れ),
        target18(名称6.toString(), 漢字名称6.toString(), CheckShubetsu.文字切れ),
        target19(名称7.toString(), 漢字名称7.toString(), CheckShubetsu.文字切れ),
        target20(名称8.toString(), 漢字名称8.toString(), CheckShubetsu.文字切れ),
        target21(投票所名1.toString(), 漢字投票所名1.toString(), CheckShubetsu.文字切れ),
        target22(投票所名2.toString(), 漢字投票所名2.toString(), CheckShubetsu.文字切れ),
        target23(投票所名3.toString(), 漢字投票所名3.toString(), CheckShubetsu.文字切れ),
        target24(投票所名4.toString(), 漢字投票所名4.toString(), CheckShubetsu.文字切れ),
        target25(投票所名5.toString(), 漢字投票所名5.toString(), CheckShubetsu.文字切れ),
        target26(投票所名6.toString(), 漢字投票所名6.toString(), CheckShubetsu.文字切れ),
        target27(投票所名7.toString(), 漢字投票所名7.toString(), CheckShubetsu.文字切れ),
        target28(投票所名8.toString(), 漢字投票所名8.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目_シーラー(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum チェック項目_はがき4つ切り implements ICheckTarget {

        target1(宛名1.toString(), 漢字宛名1.toString(), CheckShubetsu.文字切れ),
        target2(宛名2.toString(), 漢字宛名2.toString(), CheckShubetsu.文字切れ),
        target3(宛名3.toString(), 漢字宛名3.toString(), CheckShubetsu.文字切れ),
        target4(宛名4.toString(), 漢字宛名4.toString(), CheckShubetsu.文字切れ),
        target5(住所1.toString(), 漢字住所1.toString(), CheckShubetsu.文字切れ),
        target6(住所2.toString(), 漢字住所2.toString(), CheckShubetsu.文字切れ),
        target7(住所3.toString(), 漢字住所3.toString(), CheckShubetsu.文字切れ),
        target8(住所4.toString(), 漢字住所4.toString(), CheckShubetsu.文字切れ),
        target9(送付先住所1.toString(), 漢字送付先住所1.toString(), CheckShubetsu.文字切れ),
        target10(送付先住所2.toString(), 漢字送付先住所2.toString(), CheckShubetsu.文字切れ),
        target11(送付先住所3.toString(), 漢字送付先住所3.toString(), CheckShubetsu.文字切れ),
        target12(送付先住所4.toString(), 漢字送付先住所4.toString(), CheckShubetsu.文字切れ),
        target13(名称1.toString(), 漢字名称1.toString(), CheckShubetsu.文字切れ),
        target14(名称2.toString(), 漢字名称2.toString(), CheckShubetsu.文字切れ),
        target15(名称3.toString(), 漢字名称3.toString(), CheckShubetsu.文字切れ),
        target16(名称4.toString(), 漢字名称4.toString(), CheckShubetsu.文字切れ),
        target17(投票所名1.toString(), 漢字投票所名1.toString(), CheckShubetsu.文字切れ),
        target18(投票所名2.toString(), 漢字投票所名2.toString(), CheckShubetsu.文字切れ),
        target19(投票所名3.toString(), 漢字投票所名3.toString(), CheckShubetsu.文字切れ),
        target20(投票所名4.toString(), 漢字投票所名4.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目_はがき4つ切り(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum チェック項目_個票3つ折り implements ICheckTarget {

        target1(世帯主名1.toString(), 漢字世帯主名1.toString(), CheckShubetsu.文字切れ),
        target2(世帯主名2.toString(), 漢字世帯主名2.toString(), CheckShubetsu.文字切れ),
        target3(世帯主名3.toString(), 漢字世帯主名3.toString(), CheckShubetsu.文字切れ),
        target4(住所1.toString(), 漢字住所1.toString(), CheckShubetsu.文字切れ),
        target5(住所2.toString(), 漢字住所2.toString(), CheckShubetsu.文字切れ),
        target6(住所3.toString(), 漢字住所3.toString(), CheckShubetsu.文字切れ),
        target7(名称1.toString(), 漢字名称1.toString(), CheckShubetsu.文字切れ),
        target8(名称2.toString(), 漢字名称2.toString(), CheckShubetsu.文字切れ),
        target9(名称3.toString(), 漢字名称3.toString(), CheckShubetsu.文字切れ),
        target10(カナ名称1.toString(), 漢字カナ名称1.toString(), CheckShubetsu.文字切れ),
        target11(カナ名称2.toString(), 漢字カナ名称2.toString(), CheckShubetsu.文字切れ),
        target12(カナ名称3.toString(), 漢字カナ名称3.toString(), CheckShubetsu.文字切れ),
        target13(投票所名1.toString(), 漢字投票所名1.toString(), CheckShubetsu.文字切れ),
        target14(投票所名2.toString(), 漢字投票所名2.toString(), CheckShubetsu.文字切れ),
        target15(投票所名3.toString(), 漢字投票所名3.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目_個票3つ折り(String itemName, String printName, CheckShubetsu checkShubetsu) {
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
