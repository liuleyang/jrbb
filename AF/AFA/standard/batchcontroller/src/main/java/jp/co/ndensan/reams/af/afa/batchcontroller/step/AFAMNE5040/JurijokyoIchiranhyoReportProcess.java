/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE509.JurijokyoIchiranhyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE509.JurijokyoIchiranhyoReport;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受理状況一覧表帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-026 lit
 */
public class JurijokyoIchiranhyoReportProcess extends BatchProcessBase<ZenjitsuPrintEntity> {

    private static final int 選挙列 = 9;
    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");

    private SenkyoManager senkyoManager;
    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;
    private JurijokyoIchiranhyoParam.JurijokyoIchiranhyoParamBuilder paramBuilder;

    @BatchWriter
    private BatchReportWriter<JurijokyoIchiranhyoSource> batchReportWriter;
    private ReportSourceWriter<JurijokyoIchiranhyoSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        senkyoManager = SenkyoManager.createInstance();

        List<Senkyo> senkyoList = senkyoManager.get選挙By抄本番号(parameter.get抄本番号());
        List<RString> 選挙名称リスト = new ArrayList<>();
        List<SenkyoNo> 選挙番号リスト = parameter.get選挙番号リスト();
        for (SenkyoNo senkyoNo : 選挙番号リスト) {
            RString 選挙名称 = RString.EMPTY;
            for (Senkyo senkyo : senkyoList) {
                if (senkyo.get選挙番号().equals(senkyoNo)) {
                    選挙名称 = senkyo.get選挙名称();
                    break;
                }
            }
            選挙名称リスト.add(選挙名称);
        }
        for (int i = 選挙名称リスト.size(); i <= 選挙列; i++) {
            選挙名称リスト.add(RString.EMPTY);
        }

        ZenjitsuCommonJohoItem 帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        paramBuilder = new JurijokyoIchiranhyoParam.JurijokyoIchiranhyoParamBuilder(帳票共通ヘッダー,
                選挙番号リスト,
                選挙名称リスト,
                parameter.get受理日FROM(),
                parameter.get受理日TO());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.受理状況一覧表.value()).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(ZenjitsuPrintEntity entity) {
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名情報Entity());
        JurijokyoIchiranhyoParam param = paramBuilder.getParam(entity.get選挙Entity(), entity.get投票状況Entity(), entity.get選挙人名簿Entity(), 宛名対象);

        if (null != param) {
            JurijokyoIchiranhyoReport report = new JurijokyoIchiranhyoReport(param);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        JurijokyoIchiranhyoParam param = paramBuilder.getLastParam();
        if (null != param) {
            JurijokyoIchiranhyoReport report = new JurijokyoIchiranhyoReport(param);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
