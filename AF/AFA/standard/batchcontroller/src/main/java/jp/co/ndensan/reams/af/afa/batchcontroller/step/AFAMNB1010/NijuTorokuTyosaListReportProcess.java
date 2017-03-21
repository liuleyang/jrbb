/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.HashSet;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA112.NijuTorokuTsuchishoListParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA112.NijuTorokuTsuchishoListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 二重登録調査一覧表のクラスです。
 *
 * @reamsid_L AF-0030-032 liss
 */
public class NijuTorokuTyosaListReportProcess extends BatchProcessBase<SenkyoMeiboShohonEntity> {

    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private static final RString 出力区分_空白行 = new RString("空白行");
    private static final RString 帳票固定ID = new RString("AFAPRA112");
    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private Decimal 男性の計;
    private Decimal 女性の計;
    private RString 選挙名称;
    private boolean 選挙名称フラグ;
    private boolean 選挙名称設定フラグ;
    @BatchWriter
    private BatchReportWriter<NijuTorokuTsuchishoListSource> batchReportWriter;
    private ReportSourceWriter<NijuTorokuTsuchishoListSource> reportSourceWriter;
    private HashSet<Code> 選挙レベル;
    private ShikibetsuCode 識別コード;

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
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        pageCount = new OutputParameter<>();
        男性の計 = Decimal.ZERO;
        女性の計 = Decimal.ZERO;
        選挙レベル = new HashSet();
        選挙名称 = RString.EMPTY;
        選挙名称設定フラグ = true;
        選挙名称フラグ = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectNijuTorokuChosaList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.二重登録調査一覧表.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(SenkyoMeiboShohonEntity entity) {
        ShikibetsuCode shikibetsuCode = entity.getAtenaPSMEntity().getShikibetsuCode();
        選挙レベル.add(entity.getSenkyoEntity().getSenkyoLevel());
        Code senkyoLevel = entity.getSenkyoEntity().getSenkyoLevel();
        if (選挙名称フラグ && senkyoLevel != null
                && (SennkyoLevel.国.value().equals(senkyoLevel.value())
                || SennkyoLevel.都道府県.value().equals(senkyoLevel.value()))) {
            選挙名称 = entity.getSenkyoEntity().getSenkyoName();
            選挙名称フラグ = false;
        }
        if (shikibetsuCode == null || shikibetsuCode.equals(識別コード)) {
            return;
        }
        NijuTorokuTsuchishoListParameter paramter = new NijuTorokuTsuchishoListParameter();
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        get選挙名称();
        識別コード = shikibetsuCode;
        帳票共通ヘッダー.set帳票ID(帳票固定ID);
        帳票共通ヘッダー.set選挙名称(選挙名称);
        paramter.set選挙人資格の情報(entity);
        paramter.set帳票共通ヘッダー(帳票共通ヘッダー);
        paramter.set出力区分(出力区分_データ);
        set集計行(entity);
        NijuTorokuTsuchishoListReport report = new NijuTorokuTsuchishoListReport(paramter);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {

        if (男性の計 != Decimal.ZERO || 女性の計 != Decimal.ZERO) {
            NijuTorokuTsuchishoListParameter 空白行 = new NijuTorokuTsuchishoListParameter();
            TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
            帳票共通ヘッダー.set帳票ID(帳票固定ID);
            帳票共通ヘッダー.set選挙名称(選挙名称);
            空白行.set帳票共通ヘッダー(帳票共通ヘッダー);
            空白行.set出力区分(出力区分_空白行);
            NijuTorokuTsuchishoListReport report = new NijuTorokuTsuchishoListReport(空白行);
            report.writeBy(reportSourceWriter);
            NijuTorokuTsuchishoListParameter paramter = new NijuTorokuTsuchishoListParameter();
            paramter.set帳票共通ヘッダー(帳票共通ヘッダー);
            RStringBuilder 集計 = new RStringBuilder();
            集計.append("** 二重登録 **［男").append(DecimalFormatter.toコンマ区切りRString(男性の計, 0))
                    .append("人］［女").append(DecimalFormatter.toコンマ区切りRString(女性の計, 0)).append("人］" + "［計")
                    .append(DecimalFormatter.toコンマ区切りRString(男性の計.add(女性の計), 0)).append("人］");
            paramter.set集計(集計.toRString());
            paramter.set出力区分(出力区分_集計行);
            report = new NijuTorokuTsuchishoListReport(paramter);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private void get選挙名称() {
        if (識別コード == null) {
            return;
        }
        if (選挙名称設定フラグ) {
            if (選挙レベル.contains(new Code(SennkyoLevel.国.value()))
                    && 選挙レベル.contains(new Code(SennkyoLevel.都道府県.value()))) {
                選挙名称 = 選挙名称.concat("　他");
            }
            選挙名称設定フラグ = false;
        }
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
