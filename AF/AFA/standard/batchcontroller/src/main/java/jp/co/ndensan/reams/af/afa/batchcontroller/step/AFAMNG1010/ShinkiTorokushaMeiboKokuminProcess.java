/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboKokuminReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran.SyukeiJyouhou;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboKokuminSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 補正登録者名簿のバッチ処理クラスです。
 *
 * @reamsid_L AF-0360-051 zhoujie3
 */
public class ShinkiTorokushaMeiboKokuminProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private RString 帳票ID;
    private SyukeiJyouhou syukeiJyouhou;
    private FlexibleDate 基準日;
    private static final RString 補正登録者名簿_タイトル = new RString("補正登録者名簿");

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinkiTorokushaMeiboKokuminSource.ReportSourceFields.subTitle.name())));
    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboKokuminSource> btchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboKokuminSource> reportSouceWriter;
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
        基準日 = FlexibleDate.getNowDate();
        帳票ID = ReportIdKeys.AFAPRA105_補正登録者名簿.value();
        IdouSenkyoninIchiran idouSenkyoninIchiran = new IdouSenkyoninIchiran();
        syukeiJyouhou = idouSenkyoninIchiran.get集計情報(帳票ID, RString.EMPTY);
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        pageCount = new OutputParameter<>();
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        mybatisParameter.set基準日(parameter.get基準日().plusDay(2));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectHoseiTorokushaMeiboKokumin"),
                mybatisParameter);
    }

    @Override
    protected void createWriter() {

        btchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).
                addBreak(new BreakerCatalog<ShinkiTorokushaMeiboKokuminSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSouceWriter = new ReportSourceWriter<>(btchReportWriter);
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {
        if (hasBreak(getBefore(), entity)) {
            空白行出力();
            合計行出力();
        }
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity entity) {
        if (entity != null) {

            entity.set出力区分_合計行(Boolean.FALSE);
            entity.set出力区分_空白行(Boolean.FALSE);
            if (getBefore() != null && !getBefore().getSenkyoninMeiboEntity()
                    .getTohyokuCode().equals(entity.getSenkyoninMeiboEntity().getTohyokuCode())
                    && !hasBreak(getBefore(), entity)) {
                空白行出力();
            }
            entity.set帳票ID(帳票ID);
            entity.setタイトル(補正登録者名簿_タイトル);
            Code 登録事由コード = entity.getSenkyoShikakuEntity().getTorokuJiyuCode();
            entity.setサブタイトル(CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体,
                    AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu(), 登録事由コード, 基準日));
            SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
            senkyoninTohyoJokyoEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
            syukeiJyouhou.add(ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()));
            ShinkiTorokushaMeiboKokuminReport report = new ShinkiTorokushaMeiboKokuminReport(entity, 帳票共通ヘッダー);
            report.writeBy(reportSouceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            空白行出力();
            合計行出力();
        }
        pageCount.setValue(btchReportWriter.getPageCount());
    }

    private boolean hasBreak(TorokushaMeiboEntity before, TorokushaMeiboEntity current) {
        return !NullHandler.getNullToRString(before.getSenkyoShikakuEntity().getTorokuJiyuCode())
                .equals(NullHandler.getNullToRString(current.getSenkyoShikakuEntity().getTorokuJiyuCode()));
    }

    private void 空白行出力() {
        TorokushaMeiboEntity before = getBefore();
        before.set出力区分_空白行(Boolean.TRUE);
        ShinkiTorokushaMeiboKokuminReport report = new ShinkiTorokushaMeiboKokuminReport(before, 帳票共通ヘッダー);
        report.writeBy(reportSouceWriter);
    }

    private void 合計行出力() {
        TorokushaMeiboEntity before = getBefore();
        before.set出力区分_合計行(Boolean.TRUE);
        Code torokuJiyuCode = before.getSenkyoShikakuEntity().getTorokuJiyuCode();
        if (torokuJiyuCode != null) {
            before.set合計(syukeiJyouhou.toRString(torokuJiyuCode.getColumnValue()));
            ShinkiTorokushaMeiboKokuminReport report = new ShinkiTorokushaMeiboKokuminReport(before, 帳票共通ヘッダー);
            report.writeBy(reportSouceWriter);
            syukeiJyouhou.resetCount();

        }
    }

}
