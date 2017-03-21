/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA107.KikaTaishoshaListParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA107.KikaTaishoshaListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA107.KikaTaishoshaListSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帰化対象者リストのクラスです。
 *
 * @reamsid_L AF-0010-041 xiaoj
 */
public class KikaTaishoshaListReportProcess extends BatchKeyBreakBase<SenkyoMeiboShohonEntity> {

    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private static final RString 出力区分_空白行 = new RString("空白行");
    private static final RString SORT_ORDER = new RString("order by");
    private static final RString 帳票固定ID = new RString("AFAPRA107");
    private static final RString SORT_AFTER = new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"");
    private static final RString SORT_SEPARATOR = new RString(" , ");
    private static final RString 基準日_固定 = new RString("（基準日:");
    private static final RString MIGI = new RString(")");

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;
    private ShikakuHantei 資格判定クラス;
    private SenkyoMeiboShohonEntity beforeEntity;
    private Decimal 男性の計;
    private Decimal 女性の計;
    private ShikibetsuCode 識別コード;
    private RString 作成条件;
    private RString 投票区;
    private boolean 作成条件設定フラグ;
    @BatchWriter
    private BatchReportWriter<KikaTaishoshaListSource> batchReportWriter;
    private ReportSourceWriter<KikaTaishoshaListSource> reportSourceWriter;

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
        RString sort = parameter.getSort();
        if (RString.isNullOrEmpty(sort)) {
            sort = SORT_ORDER.concat(RString.HALF_SPACE).concat(SORT_AFTER);
        } else {
            sort = sort.concat(SORT_SEPARATOR).concat(SORT_AFTER);
        }
        parameter.setSort(sort);
        mybatisparameter = parameter.toBatchMybatisParameter();
        pageCount = new OutputParameter<>();
        資格判定クラス = new ShikakuHantei();
        男性の計 = Decimal.ZERO;
        女性の計 = Decimal.ZERO;
        作成条件設定フラグ = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectKikaTaishoshaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.帰化対象者リスト.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(SenkyoMeiboShohonEntity current) {
        if (資格判定クラス.is帰化対象者(current.getAtenaPSMEntity(), parameter.getNenreiKigenbi())) {
            return;
        }
        ShikibetsuCode shikibetsucode = current.getAtenaPSMEntity().getShikibetsuCode();
        if (shikibetsucode != null && shikibetsucode.equals(識別コード)) {
            if (作成条件設定フラグ && beforeEntity != null) {
                set作成条件(current);
            }
            return;
        }
        識別コード = shikibetsucode;
        if (作成条件設定フラグ) {
            set作成条件(current);
        }
        if (beforeEntity != null) {
            作成条件設定フラグ = false;
        }
        set集計行(current);
        投票区が変(current);
    }

    private void set作成条件(SenkyoMeiboShohonEntity entity) {
        Code senkyoShurui = entity.getShohonEntity().getSenkyoShurui();
        FlexibleDate kijunYMD = entity.getSenkyoEntity().getKijunYMD();
        if (beforeEntity != null && senkyoShurui != null && kijunYMD != null) {
            if (!kijunYMD.isBefore(beforeEntity.getSenkyoEntity().getKijunYMD())) {
                作成条件 = get作成条件_選挙種類(senkyoShurui.value(), kijunYMD);
            }
        } else if (senkyoShurui != null && kijunYMD != null) {
            作成条件 = get作成条件_選挙種類(senkyoShurui.value(), kijunYMD);
        }
    }

    private RString get作成条件_選挙種類(RString 選挙種類, FlexibleDate 基準日) {
        return (選挙種類 == null ? RString.EMPTY : get選挙種類(選挙種類)).concat(基準日_固定)
                .concat(基準日.wareki().toDateString()).concat(MIGI);
    }

    private RString get選挙種類(RString 選挙種類) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙種類.getCodeShubetsu(), new Code(選挙種類));
    }

    @Override
    protected void keyBreakProcess(SenkyoMeiboShohonEntity current) {
    }

    @Override
    protected void afterExecute() {
        if (男性の計 != Decimal.ZERO || 女性の計 != Decimal.ZERO) {
            TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
            帳票共通ヘッダー.set帳票ID(帳票固定ID);
            帳票共通ヘッダー.set作成条件(作成条件);
            KikaTaishoshaListParameter 空白行 = new KikaTaishoshaListParameter();
            空白行.set出力区分(出力区分_空白行);
            空白行.set帳票共通ヘッダー(帳票共通ヘッダー);
            空白行.set選挙人資格の情報(beforeEntity);
            KikaTaishoshaListReport report = new KikaTaishoshaListReport(空白行, parameter.getKikaKikan().get(0), parameter.getKikaKikan().get(1));
            report.writeBy(reportSourceWriter);
            KikaTaishoshaListParameter 集計行 = new KikaTaishoshaListParameter();
            集計行.set出力区分(出力区分_集計行);
            集計行.set帳票共通ヘッダー(帳票共通ヘッダー);
            集計行.set選挙人資格の情報(beforeEntity);
            RStringBuilder 集計 = new RStringBuilder();
            集計.append("** 帰化対象者 **［男").append(DecimalFormatter.toコンマ区切りRString(男性の計, 0))
                    .append("人］［女").append(DecimalFormatter.toRString(女性の計, 0)).append("人］" + "［計")
                    .append(DecimalFormatter.toコンマ区切りRString(男性の計.add(女性の計), 0)).append("人］");
            集計行.set集計(集計.toRString());
            report = new KikaTaishoshaListReport(集計行, parameter.getKikaKikan().get(0), parameter.getKikaKikan().get(1));
            report.writeBy(reportSourceWriter);
            pageCount.setValue(batchReportWriter.getPageCount());
        } else {
            pageCount.setValue(0);
        }
    }

    private void 投票区が変(SenkyoMeiboShohonEntity current) {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(帳票固定ID);
        帳票共通ヘッダー.set作成条件(作成条件);
        if (beforeEntity != null && !current.getSenkyoninMeiboEntity().getTohyokuCode().equals(投票区)) {
            KikaTaishoshaListParameter 空白行 = new KikaTaishoshaListParameter();
            空白行.set出力区分(出力区分_空白行);
            空白行.set帳票共通ヘッダー(帳票共通ヘッダー);
            空白行.set選挙人資格の情報(current);
            KikaTaishoshaListReport report = new KikaTaishoshaListReport(空白行, parameter.getKikaKikan().get(0), parameter.getKikaKikan().get(1));
            report.writeBy(reportSourceWriter);
        }
        投票区 = current.getSenkyoninMeiboEntity().getTohyokuCode();
        KikaTaishoshaListParameter データ行 = new KikaTaishoshaListParameter();
        データ行.set出力区分(出力区分_データ);
        データ行.set帳票共通ヘッダー(帳票共通ヘッダー);
        データ行.set選挙人資格の情報(current);
        KikaTaishoshaListReport report = new KikaTaishoshaListReport(データ行, parameter.getKikaKikan().get(0), parameter.getKikaKikan().get(1));
        report.writeBy(reportSourceWriter);
        beforeEntity = current;
    }

    private void set集計行(SenkyoMeiboShohonEntity entity) {
        RString 性別 = entity.getAtenaPSMEntity().getSeibetsuCode();
        if (FEMALE.getCode().equals(性別)) {
            女性の計 = 女性の計.add(1);
        } else if (MALE.getCode().equals(性別)) {
            男性の計 = 男性の計.add(1);
        }
    }

}
