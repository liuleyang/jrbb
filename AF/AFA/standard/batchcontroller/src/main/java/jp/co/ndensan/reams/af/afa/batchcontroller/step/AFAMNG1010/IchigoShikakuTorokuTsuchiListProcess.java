/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG112.IchigoShikakuTorokuTsuchiListParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG112.IchigoShikakuTorokuTsuchiListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.IchigoShikakuTorokuTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.IchigoShikakuTorokuTsuchiListSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
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
 * 1号資格登録通知一覧表のクラスです。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListProcess extends BatchProcessBase<IchigoShikakuTorokuTsuchiListEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;

    private Association 地方公共団体;
    private int page;
    private int senkyoCount;
    private ZenkokuJushoItem 全国住所;
    private boolean 選挙名称設定フラグ;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private RString 選挙名称;
    private RString 集計;
    private int 男性の計;
    private int 女性の計;
    private boolean 登録年月日検索基準_登録届出年月日;
    private boolean 登録年月日検索基準_登録異動年月日;
    private boolean 出力区分_空白行;
    private boolean 出力区分_集計行;
    private static final RString 帳票固定ID = new RString("AFAPRG112");
    private static final RString 選挙名称_他 = new RString("　他");
    private IchigoShikakuTorokuTsuchiListEntity before;
    private IchigoShikakuTorokuTsuchiListParameter beforeparam;

    @BatchWriter
    private BatchReportWriter<IchigoShikakuTorokuTsuchiListSource> batchReportWriter;
    private ReportSourceWriter<IchigoShikakuTorokuTsuchiListSource> reportSourceWriter;

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
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        mybatisparameter.set基準日(parameter.get基準日());

        全国住所 = null;
        集計 = null;
        選挙名称設定フラグ = true;
        出力区分_空白行 = false;
        出力区分_集計行 = false;
        選挙名称 = RString.EMPTY;
        page = 1;
        男性の計 = 0;
        女性の計 = 0;
        senkyoCount = 1;
        pageCount = new OutputParameter<>();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();

        登録年月日検索基準_登録届出年月日 = AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(ConfigKeysAFA.登録年月日検索基準);
        登録年月日検索基準_登録異動年月日 = AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(ConfigKeysAFA.登録年月日検索基準);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.ichigoShikakuTorokuTsuchiList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRG112_1号資格登録通知一覧表.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void process(IchigoShikakuTorokuTsuchiListEntity entity) {

        set集計行(entity);
        senkyoCount = entity.getSenkyoCount();
        RString senkyoName = entity.getSenkyoEntity().getSenkyoName();
        if (選挙名称設定フラグ) {
            if (entity.getSenkyoCount() > 1 && senkyoName != null) {
                選挙名称 = senkyoName.concat(選挙名称_他);
                senkyoName = 選挙名称;
            }
            選挙名称 = senkyoName == null ? RString.EMPTY : senkyoName.concat(entity.getHasOtherSenkyo() ? 選挙名称_他 : RString.EMPTY);
        }
        帳票共通ヘッダー.set帳票ID(帳票固定ID);
        帳票共通ヘッダー.set選挙名称(選挙名称);

        IchigoShikakuTorokuTsuchiListParameter param = new IchigoShikakuTorokuTsuchiListParameter(entity,
                new RString(page),
                地方公共団体, 全国住所, 登録年月日検索基準_登録届出年月日, 登録年月日検索基準_登録異動年月日,
                集計, senkyoCount, 出力区分_空白行, 出力区分_集計行);

        IchigoShikakuTorokuTsuchiListReport report = new IchigoShikakuTorokuTsuchiListReport(param, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);

        before = entity;
        beforeparam = param;

    }

    @Override
    protected void afterExecute() {
        if (before != null) {
            beforeparam.set出力区分_空白行(true);
            IchigoShikakuTorokuTsuchiListReport report = new IchigoShikakuTorokuTsuchiListReport(beforeparam, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
            beforeparam.set出力区分_集計行(true);
            RStringBuilder 集計 = new RStringBuilder();
            集計.append("＊1号資格登録対象者 ＊［男　").append(DecimalFormatter.toコンマ区切りRString(new Decimal(男性の計), 0))
                    .append("人］［女　").append(DecimalFormatter.toコンマ区切りRString(new Decimal(女性の計), 0)).append("人］" + "［計　")
                    .append(DecimalFormatter.toコンマ区切りRString(new Decimal(男性の計 + 女性の計), 0)).append("人］");
            beforeparam.set集計(集計.toRString());
            report = new IchigoShikakuTorokuTsuchiListReport(beforeparam, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private void set集計行(IchigoShikakuTorokuTsuchiListEntity entity) {
        RString 性別 = entity.getShikibetsuTaishoEntity().getSeibetsuCode();
        if (FEMALE.getCode().equals(性別)) {
            女性の計++;
        } else if (MALE.getCode().equals(性別)) {
            男性の計++;
        }
    }
}
