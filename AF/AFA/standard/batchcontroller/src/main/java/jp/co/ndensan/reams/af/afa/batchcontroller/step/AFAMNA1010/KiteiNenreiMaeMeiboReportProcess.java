/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 規定年齢前名簿のクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class KiteiNenreiMaeMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboSource> reportSourceWriter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder builder;

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
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.規定年齢前名簿.value());
        mybatisparameter = parameter.toBatchMybatisParameter();
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        FlexibleDate nenreiKigenbi = mybatisparameter.getNenreiKigenbi();
        RString 選挙資格到達年齢 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体);
        nenreiKigenbi = nenreiKigenbi.minusYear(Integer.valueOf(選挙資格到達年齢.toString()));
        mybatisparameter.editNenreiKigenbi(nenreiKigenbi);
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectKiteiNenreiMaeMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.規定年齢前名簿.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity current) {
        if (null != getBefore() && null != current.getSenkyoninMeiboEntity() && null != getBefore().getSenkyoninMeiboEntity()
                && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode().equals(current.getSenkyoninMeiboEntity().getTohyokuCode())) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);
        }
        ShinkiTorokushaMeiboParam param = builder.addData(current, RString.EMPTY, false);
        ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {

    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), RString.EMPTY, true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.規定年齢前名簿.value(), RString.EMPTY,
                RString.EMPTY, Boolean.TRUE);
    }
}
