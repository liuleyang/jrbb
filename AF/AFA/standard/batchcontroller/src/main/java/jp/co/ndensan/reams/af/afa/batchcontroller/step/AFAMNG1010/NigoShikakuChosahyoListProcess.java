/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG112.NigoShikakuChosahyoListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.MitorokushaMasshoTsuchiListSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 2号資格調査一覧表のバッチ処理クラスです。
 *
 * @reamsid_L AF-0360-057 fulc
 */
public class NigoShikakuChosahyoListProcess extends BatchProcessBase<MitorokushaMasshoTsuchiListEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    @BatchWriter
    private BatchReportWriter<MitorokushaMasshoTsuchiListSource> btchReportWriter;
    private ReportSourceWriter<MitorokushaMasshoTsuchiListSource> reportSouceWriter;
    private RString 帳票ID;
    private RString 帳票タイトル;
    private int 男性の計;
    private int 女性の計;
    private MitorokushaMasshoTsuchiListEntity before;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    private OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        before = null;
        男性の計 = 0;
        女性の計 = 0;
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        pageCount = new OutputParameter<>();
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, null);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectNigoShikakuChosahyoList"
        ), mybatisParameter);

    }

    @Override
    protected void createWriter() {
        帳票ID = ReportIdKeys.AFAPRG112_2号資格調査一覧表.value();
        帳票タイトル = ReportIdKeys.AFAPRG112_2号資格調査一覧表.getName();
        btchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        reportSouceWriter = new ReportSourceWriter<>(btchReportWriter);

    }

    private void set集計行(MitorokushaMasshoTsuchiListEntity entity) {
        RString 性別 = entity.getShikibetsuTaishoEntity().getSeibetsuCode();
        if (FEMALE.getCode().equals(性別)) {
            女性の計++;
        } else if (MALE.getCode().equals(性別)) {
            男性の計++;
        }
    }

    @Override
    protected void process(MitorokushaMasshoTsuchiListEntity entity) {
        set集計行(entity);
        NigoShikakuChosahyoListReport report = new NigoShikakuChosahyoListReport(entity, 帳票共通ヘッダー, 帳票ID, 帳票タイトル);
        report.writeBy(reportSouceWriter);
        before = entity;
    }

    @Override
    protected void afterExecute() {
        if (before != null) {
            before.set出力区分_空白行(true);
            NigoShikakuChosahyoListReport report = new NigoShikakuChosahyoListReport(before, 帳票共通ヘッダー, 帳票ID, 帳票タイトル);
            report.writeBy(reportSouceWriter);
            before.set出力区分_集計行(true);
            RStringBuilder 集計 = new RStringBuilder();
            集計.append("＊2号資格調査票対象者 ＊［男　").append(DecimalFormatter.toコンマ区切りRString(new Decimal(男性の計), 0))
                    .append("人］［女　").append(DecimalFormatter.toコンマ区切りRString(new Decimal(女性の計), 0)).append("人］" + "［計　")
                    .append(DecimalFormatter.toコンマ区切りRString(new Decimal(男性の計 + 女性の計), 0)).append("人］");
            report = new NigoShikakuChosahyoListReport(before, 帳票共通ヘッダー, 帳票ID, 帳票タイトル);
            before.set集計(集計.toRString());
            report.writeBy(reportSouceWriter);
        }
        pageCount.setValue(btchReportWriter.getPageCount());
    }

}