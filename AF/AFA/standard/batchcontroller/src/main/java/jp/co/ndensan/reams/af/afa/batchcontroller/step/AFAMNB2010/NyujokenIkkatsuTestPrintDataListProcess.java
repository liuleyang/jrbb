/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenTestPrintDataListParam;
import jp.co.ndensan.reams.af.afa.business.core.TestDateJouhou;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB214.NyujokenTestPrintDataListReport;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券テストデータ抽出一覧表編集するクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuTestPrintDataListProcess extends BatchKeyBreakBase<AFABTB201MeiciJyohouSoufusakiEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private Map<RString, Map<RString, TestDateJouhou>> 投票区テスト情報リスト;
    private TestDateJouhou 氏名最大文字数テスト情報;
    private TestDateJouhou 住所最大文字数テスト情報;
    private TestDateJouhou 世帯主最大文字数テスト情報;
    private TestDateJouhou 世帯員最大文字数テスト情報;
    private AfaMapperProvider mapperProvider;
    private INyujokenIkkatsuMapper mapper;
    private Boolean isFirstData;
    private FlexibleDate 名簿基準年月日;
    private int pageCount;
    private int itemCount;
    private int flag;
    private static final RString 符号ー = new RString("-");
    private static final RString 空白_册 = new RString("00");
    private static final int 空白埋めの２桁 = 2;
    private static final int 空白埋めの４桁 = 4;
    private static final int 空白埋めの６桁 = 6;
    private static final int 最大ページ数 = 15;
    private static final RString 抽出条件_投票区先頭２世帯 = new RString("投票区先頭２世帯");
    private static final RString 抽出条件_氏名最大文字数 = new RString("氏名最大文字数");
    private static final RString 抽出条件_住所最大文字数 = new RString("住所最大文字数");
    private static final RString 抽出条件_世帯主名最大文字数 = new RString("世帯主名最大文字数");
    private static final RString 抽出条件_世帯員最大数 = new RString("世帯員最大数");
    private static final RString 該当項目_世帯員最大数 = new RString("世帯員最大数");
    private static final RString 該当項目_人 = new RString("人");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectJyohouSoufusakiTempTable");
    @BatchWriter
    private BatchReportWriter<NyujokenTestPrintDataListSource> batchReportWriter;
    private ReportSourceWriter<NyujokenTestPrintDataListSource> reportSourceWriter;
    private NyujokenTestPrintDataListParam target;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }

    OutputParameter<Decimal> nyujokenReportIndex;

    @Override
    protected void initialize() {
        isFirstData = Boolean.TRUE;
        pageCount = 0;
        itemCount = 0;
        flag = 0;
        nyujokenReportIndex = new OutputParameter<>();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);

        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setShohonNo(parameter.get抄本番号());
        NyujokenKobetsuJouhou 名簿基準年月日entity = mapper.select選挙の名簿基準年月日(mybatisParameter);
        名簿基準年月日 = FlexibleDate.EMPTY;
        if (名簿基準年月日entity != null) {
            名簿基準年月日 = 名簿基準年月日entity.get名簿基準年月日();
        }
        mybatisParameter.setTable(parameter.getTable());
        mybatisParameter.setGroupKubun(parameter.getGroupKubun());
        mybatisParameter.setSetaiCode(parameter.getSetaiCode());
        mybatisParameter.set出力順(get出力順());
        List<AFABTB201MeiciJyohouSoufusakiEntity> soufusakiJouhouEntityList = mapper.selectSoufusakiJouhouTempTable(mybatisParameter);
        if (soufusakiJouhouEntityList != null && !soufusakiJouhouEntityList.isEmpty()) {
            世帯員最大文字数テスト情報 = get世帯員テストデータの情報(soufusakiJouhouEntityList.get(0));
        }
        投票区テスト情報リスト = new HashMap<>();
        target = new NyujokenTestPrintDataListParam();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntity) {
        flag = 0;
        RString 投票区コードcurrent = soufusakiJouhouEntity.get投票区コード() == null
                ? RString.EMPTY : soufusakiJouhouEntity.get投票区コード();
        RString 投票区コードBefore = getBefore().get投票区コード() == null
                ? RString.EMPTY : soufusakiJouhouEntity.get投票区コード();
        if (投票区コードcurrent.equals(投票区コードBefore)) {
            SetaiCode 世帯コードcurrent = get世帯コードcurrent(soufusakiJouhouEntity.get世帯コード());
            SetaiCode 世帯コードBefore = getBefore().get世帯コード();
            世帯コードBefore = 世帯コードBefore == null ? SetaiCode.EMPTY : 世帯コードBefore;
            if (投票区テスト情報リスト != null && 投票区テスト情報リスト.get(投票区コードcurrent) != null
                    && !世帯コードcurrent.equals(世帯コードBefore)
                    && 投票区テスト情報リスト.get(投票区コードcurrent).size() < 2) {
                flag = 1;
            }
        } else if (!投票区コードcurrent.equals(投票区コードBefore)) {
            flag = 2;
        }

        RString 氏名Current = soufusakiJouhouEntity.get名称() == null
                ? RString.EMPTY : soufusakiJouhouEntity.get名称();
        RString 氏名Before = 氏名最大文字数テスト情報.get氏名() == null
                ? RString.EMPTY : 氏名最大文字数テスト情報.get氏名();
        if (氏名Before.length() < 氏名Current.length()) {
            氏名最大文字数テスト情報 = get氏名テストデータの情報(soufusakiJouhouEntity);
        }
        RString 住所Current = soufusakiJouhouEntity.get住所() == null
                ? RString.EMPTY : soufusakiJouhouEntity.get住所();
        RString 住所Before = 住所最大文字数テスト情報.get該当項目() == null
                ? RString.EMPTY : 住所最大文字数テスト情報.get該当項目();
        if (住所Before.length() < 住所Current.length()) {
            住所最大文字数テスト情報 = get住所テストデータの情報(soufusakiJouhouEntity);
        }
        RString 世帯主名Current = soufusakiJouhouEntity.get世帯主名() == null
                ? RString.EMPTY : soufusakiJouhouEntity.get世帯主名().getColumnValue();
        RString 世帯主名Before = 世帯主最大文字数テスト情報.get該当項目() == null
                ? RString.EMPTY : 世帯主最大文字数テスト情報.get該当項目();
        if (世帯主名Before.length() < 世帯主名Current.length()) {
            世帯主最大文字数テスト情報 = get世帯主テストデータの情報(soufusakiJouhouEntity);
        }
    }

    private SetaiCode get世帯コードcurrent(SetaiCode 世帯コードcurrent) {
        return 世帯コードcurrent == null ? SetaiCode.EMPTY : 世帯コードcurrent;
    }

    @Override
    protected void usualProcess(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntity) {
        if (itemCount == 最大ページ数) {
            pageCount++;
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(get投票区テストデータの情報(soufusakiJouhouEntity));
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            itemCount = 1;
        } else if (isFirstData) {
            pageCount = 1;
            SetaiCode 世帯コードcurrent = soufusakiJouhouEntity.get世帯コード();
            世帯コードcurrent = 世帯コードcurrent == null ? SetaiCode.EMPTY : 世帯コードcurrent;
            Map<RString, TestDateJouhou> dataJouhouMap = new HashMap<>();
            dataJouhouMap.put(世帯コードcurrent.getColumnValue(), get投票区テストデータの情報(soufusakiJouhouEntity));
            投票区テスト情報リスト.put(soufusakiJouhouEntity.get投票区コード(), dataJouhouMap);
            target.setテストデータの情報(get投票区テストデータの情報(soufusakiJouhouEntity));
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            itemCount++;
            氏名最大文字数テスト情報 = get氏名テストデータの情報(soufusakiJouhouEntity);
            住所最大文字数テスト情報 = get住所テストデータの情報(soufusakiJouhouEntity);
            世帯主最大文字数テスト情報 = get世帯主テストデータの情報(soufusakiJouhouEntity);
            isFirstData = Boolean.FALSE;
        } else if (flag == 1) {
            RString 投票区コードcurrent = soufusakiJouhouEntity.get投票区コード() == null
                    ? RString.EMPTY : soufusakiJouhouEntity.get投票区コード();
            SetaiCode 世帯コードcurrent = soufusakiJouhouEntity.get世帯コード();
            世帯コードcurrent = 世帯コードcurrent == null ? SetaiCode.EMPTY : 世帯コードcurrent;
            target.setテストデータの情報(get投票区テストデータの情報(soufusakiJouhouEntity));
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            投票区テスト情報リスト
                    .get(投票区コードcurrent)
                    .put(世帯コードcurrent.getColumnValue(), get投票区テストデータの情報(soufusakiJouhouEntity));
            itemCount++;
            flag = 0;
        } else if (flag == 2) {
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(get投票区テストデータの情報(soufusakiJouhouEntity));
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            SetaiCode 世帯コードcurrent = soufusakiJouhouEntity.get世帯コード();
            世帯コードcurrent = 世帯コードcurrent == null ? SetaiCode.EMPTY : 世帯コードcurrent;
            Map<RString, TestDateJouhou> dataJouhouMap = new HashMap<>();
            dataJouhouMap.put(世帯コードcurrent.getColumnValue(), get投票区テストデータの情報(soufusakiJouhouEntity));
            投票区テスト情報リスト.put(soufusakiJouhouEntity.get投票区コード(), dataJouhouMap);
            itemCount++;
            flag = 0;
        }
    }

    @Override
    protected void afterExecute() {
        if (itemCount == 最大ページ数 && 氏名最大文字数テスト情報 != null) {
            pageCount++;
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(氏名最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            itemCount = 1;
        } else if (氏名最大文字数テスト情報 != null) {
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(氏名最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report1 = new NyujokenTestPrintDataListReport(target);
            report1.writeBy(reportSourceWriter);
            itemCount++;
        }
        if (itemCount == 最大ページ数 && 住所最大文字数テスト情報 != null) {
            pageCount++;
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(住所最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report2 = new NyujokenTestPrintDataListReport(target);
            report2.writeBy(reportSourceWriter);
            itemCount = 1;
        } else if (住所最大文字数テスト情報 != null) {
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(住所最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report2 = new NyujokenTestPrintDataListReport(target);
            report2.writeBy(reportSourceWriter);
            itemCount++;
        }
        if (itemCount == 最大ページ数 && 世帯主最大文字数テスト情報 != null) {
            pageCount++;
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(世帯主最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report3 = new NyujokenTestPrintDataListReport(target);
            report3.writeBy(reportSourceWriter);
            itemCount = 1;
        } else if (世帯主最大文字数テスト情報 != null) {
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(世帯主最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report3 = new NyujokenTestPrintDataListReport(target);
            report3.writeBy(reportSourceWriter);
            itemCount++;
        }
        if (itemCount == 最大ページ数 && 世帯員最大文字数テスト情報 != null) {
            pageCount++;
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(世帯員最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report4 = new NyujokenTestPrintDataListReport(target);
            report4.writeBy(reportSourceWriter);
            itemCount = 1;
        } else if (世帯員最大文字数テスト情報 != null) {
            target = new NyujokenTestPrintDataListParam();
            target.setテストデータの情報(世帯員最大文字数テスト情報);
            target.set頁(pageCount);
            NyujokenTestPrintDataListReport report4 = new NyujokenTestPrintDataListReport(target);
            report4.writeBy(reportSourceWriter);
            itemCount++;
        }
        Decimal 入場券発行固有連番 = batchReportWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番);
    }

    private TestDateJouhou get投票区テストデータの情報(AFABTB201MeiciJyohouSoufusakiEntity meiciJyohouSoufusakiEntity) {
        TestDateJouhou 投票区テストデータ = new TestDateJouhou();
        投票区テストデータ.set抽出条件(抽出条件_投票区先頭２世帯);
        投票区テストデータ.set名簿番号(get名簿番号(meiciJyohouSoufusakiEntity));
        投票区テストデータ.set氏名(meiciJyohouSoufusakiEntity.get名称());
        投票区テストデータ.set該当項目(RString.EMPTY);
        投票区テストデータ.set名簿基準年月日(new RDate(名簿基準年月日.toString()));
        投票区テストデータ.set選挙種類(parameter.get選挙種類());
        FlexibleDate 投票日 = parameter.get投票日() == null ? FlexibleDate.EMPTY : parameter.get投票日();
        投票区テストデータ.set投票年月日(new RDate(投票日.toString()));
        ShikibetsuCode 識別コード = meiciJyohouSoufusakiEntity.get識別コード();
        投票区テストデータ.set識別コード(識別コード == null ? RString.EMPTY : new RString(識別コード.toString()));
        return 投票区テストデータ;
    }

    private TestDateJouhou get世帯員テストデータの情報(AFABTB201MeiciJyohouSoufusakiEntity 世帯員情報) {
        TestDateJouhou 投票区テストデータ = new TestDateJouhou();
        投票区テストデータ.set抽出条件(抽出条件_世帯員最大数);
        投票区テストデータ.set名簿番号(get名簿番号(世帯員情報));
        投票区テストデータ.set氏名(世帯員情報.get名称());
        投票区テストデータ
                .set該当項目(該当項目_世帯員最大数
                        .concat(parameter.getSetaiCodeCount().toString())
                        .concat(該当項目_人));
        投票区テストデータ.set名簿基準年月日(new RDate(名簿基準年月日.toString()));
        投票区テストデータ.set選挙種類(parameter.get選挙種類());
        FlexibleDate 投票日 = parameter.get投票日() == null ? FlexibleDate.EMPTY : parameter.get投票日();
        投票区テストデータ.set投票年月日(new RDate(投票日.toString()));
        ShikibetsuCode 識別コード = 世帯員情報.get識別コード();
        投票区テストデータ.set識別コード(識別コード == null ? RString.EMPTY : new RString(識別コード.toString()));
        return 投票区テストデータ;
    }

    private TestDateJouhou get氏名テストデータの情報(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntity) {
        TestDateJouhou 氏名テストデータ = new TestDateJouhou();
        氏名テストデータ.set抽出条件(抽出条件_氏名最大文字数);
        氏名テストデータ.set名簿番号(get名簿番号(soufusakiJouhouEntity));
        氏名テストデータ.set氏名(soufusakiJouhouEntity.get名称());
        氏名テストデータ.set該当項目(soufusakiJouhouEntity.get名称());
        ShikibetsuCode 識別コード = soufusakiJouhouEntity.get識別コード();
        氏名テストデータ.set識別コード(識別コード == null ? RString.EMPTY : new RString(識別コード.toString()));
        return 氏名テストデータ;
    }

    private TestDateJouhou get住所テストデータの情報(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntity) {
        TestDateJouhou 住所テストデータ = new TestDateJouhou();
        住所テストデータ.set抽出条件(抽出条件_住所最大文字数);
        住所テストデータ.set名簿番号(get名簿番号(soufusakiJouhouEntity));
        住所テストデータ.set氏名(soufusakiJouhouEntity.get名称());
        住所テストデータ.set該当項目(soufusakiJouhouEntity.get住所());
        ShikibetsuCode 識別コード = soufusakiJouhouEntity.get識別コード();
        住所テストデータ.set識別コード(識別コード == null ? RString.EMPTY : new RString(識別コード.toString()));
        return 住所テストデータ;
    }

    private TestDateJouhou get世帯主テストデータの情報(AFABTB201MeiciJyohouSoufusakiEntity soufusakiJouhouEntity) {
        TestDateJouhou 世帯主テストデータ = new TestDateJouhou();
        世帯主テストデータ.set抽出条件(抽出条件_世帯主名最大文字数);
        世帯主テストデータ.set名簿番号(get名簿番号(soufusakiJouhouEntity));
        世帯主テストデータ.set氏名(soufusakiJouhouEntity.get名称());
        AtenaMeisho 世帯主名 = soufusakiJouhouEntity.get世帯主名();
        世帯主テストデータ.set該当項目(世帯主名 == null ? RString.EMPTY : 世帯主名.getColumnValue());
        ShikibetsuCode 識別コード = soufusakiJouhouEntity.get識別コード();
        世帯主テストデータ.set識別コード(識別コード == null ? RString.EMPTY : new RString(識別コード.toString()));
        return 世帯主テストデータ;
    }

    private RString get出力順() {
        RString orderBy = new RString("order by ");
        orderBy = orderBy.concat(new RString("\"SenkyoninMeiciJyohou\".\"tohyokuCode\""));
        RString 抄本_冊区分管理 = BusinessConfig.get(ConfigKeysAFA.抄本_冊区分管理, SubGyomuCode.AFA選挙本体);
        if (!new RString("0").equals(抄本_冊区分管理)) {
            orderBy = orderBy.concat(",\"SenkyoninMeiciJyohou\".\"satsu\"");
        }
        orderBy = orderBy.concat(",\"SenkyoninMeiciJyohou\".\"page\",\"SenkyoninMeiciJyohou\".\"gyo\"");

        return orderBy;
    }

    private RString get名簿番号(AFABTB201MeiciJyohouSoufusakiEntity meiciJyohouSoufusakiEntity) {
        RString 投票区コード = meiciJyohouSoufusakiEntity.get投票区コード();
        投票区コード = 投票区コード == null ? RString.EMPTY.padLeft(空白埋めの４桁) : 投票区コード.padLeft(空白埋めの４桁);
        RString 冊 = RString.isNullOrEmpty(meiciJyohouSoufusakiEntity.get冊())
                ? 空白_册 : meiciJyohouSoufusakiEntity.get冊();
        冊 = 冊.padLeft(空白埋めの２桁);
        RString 頁 = new RString(meiciJyohouSoufusakiEntity.get頁()).padLeft(空白埋めの６桁);
        RString 行 = new RString(meiciJyohouSoufusakiEntity.get行()).padLeft(空白埋めの２桁);
        if (AFAConfigKeysValue.抄本_冊区分管理_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        if (AFAConfigKeysValue.抄本_冊区分管理_性別を冊区分とする.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {
            return 投票区コード.concat(符号ー).concat(冊).concat(符号ー).concat(頁).concat(符号ー).concat(行);
        }
        return RString.EMPTY;
    }
}
