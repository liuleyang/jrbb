/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.NninIjoSetaiListParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.SetaiichiranhyouJouhou;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB213.NninIjoSetaiListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201SoufusakiJouhouEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）のN人以上世帯一覧表のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuNninIjoSetaiListReportProcess extends BatchProcessBase<AFABTB201SoufusakiJouhouEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private INyujokenIkkatsuMapper mapper;
    private AfaMapperProvider mapperProvider;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectNninIjoSetaiListTempTable");
    @BatchWriter
    private BatchReportWriter<NninIjoSetaiListSource> batchReportWriter;
    private ReportSourceWriter<NninIjoSetaiListSource> reportSourceWriter;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    private NyujoukenGamenModel 選挙共通情報;
    
    @Override
    protected void initialize() {
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable1(parameter.getTable());
        mybatisParameter.setTable(parameter.getSoufusakiJouhoutable());
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日entity = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日entity != null) {
            parameter.set前回基準日(前回基準日entity.get前回基準日());
        } else {
            parameter.set前回基準日(FlexibleDate.EMPTY);
        }
        pageCount = new OutputParameter<>();
        選挙共通情報 = get選挙共通情報();
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
    protected void process(AFABTB201SoufusakiJouhouEntity entity) {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());
        NninIjoSetaiListParam nninIjoSetaiListParam = new NninIjoSetaiListParam(選挙共通情報, edit明細情報(entity));
        NninIjoSetaiListReport report = new NninIjoSetaiListReport(nninIjoSetaiListParam, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private SetaiichiranhyouJouhou edit明細情報(AFABTB201SoufusakiJouhouEntity entity) {
        SetaiichiranhyouJouhou 明細情報 = new SetaiichiranhyouJouhou();
        明細情報.set投票区コード(entity.getTohyokuCode());
        明細情報.set名簿番号_行(new RString(entity.getGyo()));
        明細情報.set名簿番号_頁(new RString(entity.getPage()));
        明細情報.set住登内住所(entity.getJusho());
        明細情報.set住登内方書(entity.getKatagaki());
        明細情報.set住登内番地(entity.getBanchi());
        明細情報.set行政区名(entity.getGyoseikuName());
        明細情報.set世帯コード(entity.getSetaiCode());
        明細情報.set世帯主名(entity.getSetaiName());
        明細情報.set世帯員数(entity.getSetaiSuji().intValue());
        明細情報.set抽出対象世帯人数(Integer.parseInt(parameter.get抽出対象世帯人数().toString()));
        return 明細情報;
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param selectProcessParameter AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報() {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        nyujoukenGamenModel.set基準日(new RDate(parameter.get前回基準日().toString()));
        FlexibleDate 投票日 = parameter.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(投票日.toString()));
        return nyujoukenGamenModel;
    }
}
