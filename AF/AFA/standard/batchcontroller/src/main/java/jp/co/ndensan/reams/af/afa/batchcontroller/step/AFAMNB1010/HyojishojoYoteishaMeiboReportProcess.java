/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 表示消除予定者名簿のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class HyojishojoYoteishaMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboSource> reportSourceWriter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder builder;
    private ShikakuHantei shikakuHantei;

    private TorokushaMeiboEntity lastEntity;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.表示消除予定者名簿.value());
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        pageCount = new OutputParameter<>();
        lastEntity = null;
        shikakuHantei = new ShikakuHantei();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectHyojishojoYoteishaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.表示消除予定者名簿.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity entity) {
        if (!is表示消除予定者(entity)) {
            return;
        }
        lastEntity = entity;
        if (getBefore() != null
                && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode().equals(entity.getSenkyoninMeiboEntity().getTohyokuCode())) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);
        }
        ShinkiTorokushaMeiboParam param = builder.addData(entity, RString.EMPTY, false);
        ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);

    }

    private Boolean is表示消除予定者(TorokushaMeiboEntity entity) {
        return shikakuHantei.is表示消除予定者(toSenkyoninTohyoJokyoEntity(entity), parameter.getKijunbi(), parameter.getTouhyobi());
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {

    }

    @Override
    protected void afterExecute() {
        if (lastEntity != null) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), RString.EMPTY, true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.表示消除予定者名簿.value(), RString.EMPTY,
                RString.EMPTY, Boolean.TRUE);
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(TorokushaMeiboEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        return targetEntity;
    }

}
