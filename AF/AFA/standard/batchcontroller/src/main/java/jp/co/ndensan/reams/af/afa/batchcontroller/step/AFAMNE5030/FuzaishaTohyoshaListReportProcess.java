/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.FuzaishaTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.FuzaishaTohyoshaListBreakEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE502.FuzaishaTohyoshaListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
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
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * 不在者投票者一覧表帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class FuzaishaTohyoshaListReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select不在者投票者一覧表リスト");
    private List<RString> pageBreakKeys;

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private RString senkyoShurui;

    @BatchWriter
    private BatchReportWriter<KijitsumaeTohyoshaListReportSource> batchReportWriter;
    private ReportSourceWriter<KijitsumaeTohyoshaListReportSource> reportSourceWriter;
    private FuzaishaTohyoshaListBreakEditor editor;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString("key1"));
        pageBreakKeys.add(new RString("key2"));
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        senkyoShurui = null;
    }

    @Override
    protected void beforeExecute() {
        editor = new FuzaishaTohyoshaListBreakEditor(parameter);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        if (null == pageBreakKeys || pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE502_不在者投票者一覧表.value()).
                    create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE502_不在者投票者一覧表.value()).
                    addBreak(new BreakerCatalog<KijitsumaeTohyoshaListReportSource>().simplePageBreaker(pageBreakKeys)).
                    create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        senkyoShurui = current.get抄本Entity().getSenkyoShurui().value();
        RString 施設名称 = get施設名称(current);
        RString 施設種別コード = get施設種別コード(current);
        RString 施設種別名称 = get施設種別名称(current);
        RString 施設種別略称 = get施設種別略称(current);
        RString 投票区名 = get投票区名(current);
        editor.usualProcess(current, 施設名称, 施設種別コード, 施設種別名称, 施設種別略称, 投票区名);
    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current) {
        FuzaishaTohyoshaListParam printTohyokuCode = editor.keyBreakProcessByTohyokuCode(getBefore(), current);
        FuzaishaTohyoshaListReport report = new FuzaishaTohyoshaListReport(printTohyokuCode, create帳票共通ヘッダー(current));
        report.writeBy(reportSourceWriter);

    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        FuzaishaTohyoshaListParam print = editor.createLastProcess();
        if (null == print) {
            return;
        }
        FuzaishaTohyoshaListReport report = new FuzaishaTohyoshaListReport(print, create帳票共通ヘッダー());
        report.writeBy(reportSourceWriter);

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPSMPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }

    private RString get施設名称(NippoPSMPrintEntity entity) {
        AfT507ShisetsuEntity 施設Entity = entity.get施設Entity();
        return 施設Entity == null ? RString.EMPTY : 施設Entity.getShisetsuName();
    }

    private RString get施設種別コード(NippoPSMPrintEntity entity) {
        AfT507ShisetsuEntity 施設Entity = entity.get施設Entity();
        return 施設Entity == null ? RString.EMPTY : 施設Entity.getShisetsuShubetsu().value();
    }

    private RString get施設種別名称(NippoPSMPrintEntity entity) {
        AfT507ShisetsuEntity 施設Entity = entity.get施設Entity();
        return 施設Entity == null ? RString.EMPTY : CodeMasterNoOption.getCodeMeisho(
                SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設Entity.getShisetsuShubetsu(), FlexibleDate.getNowDate());
    }

    private RString get施設種別略称(NippoPSMPrintEntity entity) {
        AfT507ShisetsuEntity 施設Entity = entity.get施設Entity();
        return 施設Entity == null ? RString.EMPTY : CodeMasterNoOption.getCodeRyakusho(
                SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設Entity.getShisetsuShubetsu(), FlexibleDate.getNowDate());
    }

    private RString get投票区名(NippoPSMPrintEntity entity) {
        if ((SenkyoShurui.定時登録.getCode().equals(senkyoShurui) || SenkyoShurui.国政選挙_地方選挙.getCode().equals(senkyoShurui))) {
            UrT0159TohyokuEntity ur投票区 = entity.getUrV0159();
            return ur投票区 == null ? RString.EMPTY : ur投票区.getName();
        } else {
            AfT501TohyokuEntity af投票区 = entity.getAfT501();
            return af投票区 == null ? RString.EMPTY : af投票区.getTohyokuName();
        }
    }
}
