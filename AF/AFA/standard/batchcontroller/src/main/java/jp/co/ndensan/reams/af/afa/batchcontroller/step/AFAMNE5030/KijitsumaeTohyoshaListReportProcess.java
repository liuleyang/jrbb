/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.KijitsumaeTohyoshaListBreakEditor;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.KijitsumaeTohyoshaListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 期日前投票者一覧表帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class KijitsumaeTohyoshaListReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select期日前投票者一覧表リスト");
    private static final RString SORT_BEFORE = new RString("master.\"afT111Senkyo_senkyoNo\"");
    private List<RString> pageBreakKeys;

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    @BatchWriter
    private BatchReportWriter<KijitsumaeTohyoshaListReportSource> batchReportWriter;
    private ReportSourceWriter<KijitsumaeTohyoshaListReportSource> reportSourceWriter;
    private KijitsumaeTohyoshaListBreakEditor editor;
    private ShisetsuManager shisetsuManager;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString("key1"));
        pageBreakKeys.add(new RString("key2"));
        pageBreakKeys.add(new RString("key3"));
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        mybatisparameter.addSortBefore(SORT_BEFORE);
    }

    @Override
    protected void beforeExecute() {
        editor = new KijitsumaeTohyoshaListBreakEditor(parameter);
        shisetsuManager = ShisetsuManager.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        if (null == pageBreakKeys || pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE502_期日前投票者一覧表.value()).
                    create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE502_期日前投票者一覧表.value()).
                    addBreak(new BreakerCatalog<KijitsumaeTohyoshaListReportSource>().simplePageBreaker(pageBreakKeys)).
                    create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        Shisetsu 施設種別 = shisetsuManager.get施設By施設コード(current.get投票状況Entity().getShisetsuCode());
        editor.usualProcess(current, 施設種別);
    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current) {
        KijitsumaeTohyoshaListParam printTohyokuCode = editor.keyBreakProcessByTohyokuCode(getBefore(), current);
        KijitsumaeTohyoshaListReport report = new KijitsumaeTohyoshaListReport(printTohyokuCode, create帳票共通ヘッダー(current));
        report.writeBy(reportSourceWriter);
        editor.clear合計エリア１(getBefore(), current);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        KijitsumaeTohyoshaListParam print = editor.createLastProcess();
        if (null == print) {
            return;
        }
        KijitsumaeTohyoshaListReport report = new KijitsumaeTohyoshaListReport(print, create帳票共通ヘッダー());
        report.writeBy(reportSourceWriter);

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPSMPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }

}
