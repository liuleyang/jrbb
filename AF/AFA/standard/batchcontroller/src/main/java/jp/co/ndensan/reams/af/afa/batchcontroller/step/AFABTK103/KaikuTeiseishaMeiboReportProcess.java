/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.TeiseishaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK108.TeiseishaMeiboKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.KaikuTeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 海区漁業調整委員会委員選挙時登録<br>
 * 訂正者名簿帳票を出力する。
 *
 * @reamsid_L AF-0470-030 jihb
 */
public class KaikuTeiseishaMeiboReportProcess extends BatchKeyBreakBase<KaikuTeiseishaMeiboEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.IAFABTK103Mapper.select訂正者名簿データ");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private static final List<RString> 訂正者名簿_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString(ShinkiTorokushaMeiboKaikuSource.ReportSourceFields.subTitle.name())));

    @BatchWriter
    private BatchReportWriter<TeiseishaMeiboKaikuSource> 訂正者名簿Writer;
    private ReportSourceWriter<TeiseishaMeiboKaikuSource> 訂正者名簿SourceWriter;

    private TeiseishaMeiboKaikuParam.TeiseishaMeiboKaikuParamBuilder builder;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    private int index;

    @Override
    protected void initialize() {
        index = 0;
        pageCount = new OutputParameter<>();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new TeiseishaMeiboKaikuParam.TeiseishaMeiboKaikuParamBuilder(帳票共通ヘッダー);
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        mybatisParameter.setIdoJiyuCodeList(get訂正者事由());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        訂正者名簿Writer = BatchReportFactory.createBatchReportWriter(ReportIdKeys.訂正者名簿海区.value(), SubGyomuCode.AFA選挙本体).
                addBreak(new BreakerCatalog<TeiseishaMeiboSource>().simplePageBreaker(訂正者名簿_BREAK_KEYS)).create();
        訂正者名簿SourceWriter = new ReportSourceWriter<>(訂正者名簿Writer);
    }

    @Override
    protected void keyBreakProcess(KaikuTeiseishaMeiboEntity t) {

    }

    @Override
    protected void usualProcess(KaikuTeiseishaMeiboEntity entity) {
        index++;
        List<TeiseishaMeiboKaikuParam> params = builder.addData(entity);

        for (TeiseishaMeiboKaikuParam param : params) {
            TeiseishaMeiboKaikuReport report = new TeiseishaMeiboKaikuReport(param);
            report.writeBy(訂正者名簿SourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (index != 0) {

            TeiseishaMeiboKaikuParam param = builder.lastSum();

            if (param != null) {
                param.set合計行(true);
                param.setEmpty(true);
                TeiseishaMeiboKaikuReport report = new TeiseishaMeiboKaikuReport(param);
                report.writeBy(訂正者名簿SourceWriter);
            }
        }
        pageCount.setValue(訂正者名簿Writer.getPageCount());
    }

    private List<RString> get訂正者事由() {
        List<RString> list = new ArrayList<>();
        list.add(JukiIdoJiyu.転居.get異動事由コード());
        list.add(JukiIdoJiyu.世帯主変更.get異動事由コード());
        list.add(JukiIdoJiyu.世帯分離.get異動事由コード());
        list.add(JukiIdoJiyu.世帯合併.get異動事由コード());
        list.add(JukiIdoJiyu.世帯構成変更.get異動事由コード());
        list.add(JukiIdoJiyu.職権修正.get異動事由コード());
        list.add(JukiIdoJiyu.職権回復.get異動事由コード());
        list.add(JukiIdoJiyu.住民票改製.get異動事由コード());
        list.add(JukiIdoJiyu.表示順変更.get異動事由コード());
        return list;
    }

}
