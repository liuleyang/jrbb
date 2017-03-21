/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA108.TeiseishaMeiboKokuminParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA108.TeiseishaMeiboKokuminReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.TeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訂正者名簿のプロセスクラスです。
 *
 * @reamsid_L AF-0360-053 caijj2
 */
public class TeiseishaMeiboKokuminProcess extends BatchProcessBase<TeiseishaMeiboEntity> {
    
    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;

    private static final RString SORT_BEFORE = new RString("\"idoJiyuCode_tenKyo\" desc,\"before_tohyokuCode\" asc ");

    @BatchWriter
    private BatchReportWriter<TeiseishaMeiboSource> batchReportWriter;
    private ReportSourceWriter<TeiseishaMeiboSource> reportSourceWriter;

    private TeiseishaMeiboKokuminParam.TeiseishaMeiboKokuminParamBuilder builder;

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TeiseishaMeiboSource.ReportSourceFields.subTitle.name())));

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
        pageCount = new OutputParameter<>();

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        build.setデータ取得区分(DataShutokuKubun.全履歴);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoSearchKeyAll = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoSearchKeyAll);
        
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new TeiseishaMeiboKokuminParam.TeiseishaMeiboKokuminParamBuilder(帳票共通ヘッダー);
        mybatisparameter.addSortBefore(SORT_BEFORE);
        mybatisparameter.setIdoJiyuCodeList(get訂正者事由());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFAPRA108Mapper.selectTeiseishaList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.訂正者名簿国民投票時登録.value(), SubGyomuCode.AFA選挙本体).
                addBreak(new BreakerCatalog<TeiseishaMeiboSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(TeiseishaMeiboEntity entity) {

        List<TeiseishaMeiboKokuminParam> params = builder.addData(entity);

        for (TeiseishaMeiboKokuminParam param : params) {

            TeiseishaMeiboKokuminReport report = new TeiseishaMeiboKokuminReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        TeiseishaMeiboKokuminParam param = builder.lastSum();

        if (param != null) {

            TeiseishaMeiboKokuminReport report = new TeiseishaMeiboKokuminReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
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
