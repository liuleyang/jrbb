/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoshaListSenkyoAllParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.TohyoshaListSenkyoFuzaihsaBreakEditor;
import jp.co.ndensan.reams.af.afa.business.core.nippo.TohyoshaListSenkyoResult;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE503.TohyoshaListSenkyoAllReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui.定時登録;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import jp.co.ndensan.reams.af.afa.service.core.nippo.NippoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoku.TohyokuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 投票者一覧不在者表帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyoshaListSenkyoFuzaihsaReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select投票者一覧不在者表");
    private List<RString> pageBreakKeys;

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private List<RString> 選挙略称List;
    private boolean flag;
    @BatchWriter
    private BatchReportWriter<TohyoshaListSenkyoAllSource> batchReportWriter;
    private ReportSourceWriter<TohyoshaListSenkyoAllSource> reportSourceWriter;
    private TohyoshaListSenkyoFuzaihsaBreakEditor editor;
    private NippoManager nippoManager;
    private TohyokuManager tohyokuManager;
    private ShohonManager shohonManager;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString("key1"));
        pageBreakKeys.add(new RString("key2"));
        選挙略称List = new ArrayList<>();
        flag = true;
    }

    @Override
    protected void beforeExecute() {
        editor = new TohyoshaListSenkyoFuzaihsaBreakEditor(parameter);
        nippoManager = NippoManager.createInstance();
        tohyokuManager = TohyokuManager.createInstance();
        shohonManager = ShohonManager.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        if (null == pageBreakKeys || pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE503_投票者一覧表_不在者.value()).
                    create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE503_投票者一覧表_不在者.value()).
                    addBreak(new BreakerCatalog<TohyoshaListSenkyoAllSource>().simplePageBreaker(pageBreakKeys)).
                    create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        }
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        if (flag) {
            set選挙略称List();
            flag = false;
        }
        mybatisparameter.set選挙番号(current.get選挙Entity().getSenkyoNo());
        TohyoshaListSenkyoResult result = nippoManager.get投票者一覧選挙不在者表セット(mybatisparameter);
        current.get投票状況Entity().setJuriYMD(result.get受理年月日());
        current.get投票状況Entity().setKofuYMD(result.get交付年月日());
        current.get投票状況Entity().setShisetsuCode(result.get施設コード());
        current.get投票状況Entity().setTohyoJiyuCode(result.get投票事由コード());
        RString 投票区名 = tohyokuManager
                .get投票区名(current.get抄本Entity().getSenkyoShurui(), current.get選挙人名簿Entity().getTohyokuCode());
        editor.usualProcess(current, 投票区名, 選挙略称List, result.get施設名称());

    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current
    ) {
        TohyoshaListSenkyoAllParam printTohyokuCode = editor.keyBreakProcessByTohyokuCode(getBefore(), current);
        TohyoshaListSenkyoAllReport report = new TohyoshaListSenkyoAllReport(printTohyokuCode, create帳票共通ヘッダー());
        report.writeBy(reportSourceWriter);

    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        TohyoshaListSenkyoAllParam print = editor.createLastProcess();
        if (null == print) {
            return;
        }
        TohyoshaListSenkyoAllReport report = new TohyoshaListSenkyoAllReport(print, create帳票共通ヘッダー());
        report.writeBy(reportSourceWriter);

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 作成日時 = getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        TeijiCommonJohoItem 帳票共通_期日前投票 = new TeijiCommonJohoItem(association.get市町村名(), association.getLasdecCode_().value(), 作成日時);
        帳票共通_期日前投票.set選挙名称(定時登録.toRString());
        帳票共通_期日前投票.set都道府県区分(new RString(association.get市町村区分().value().toString()));
        return 帳票共通_期日前投票;
    }

    private void set選挙略称List() {
        Shohon shohon = shohonManager.get抄本(parameter.get抄本番号());
        if (shohon != null) {
            List<Senkyo> senkyoList = shohon.getSenkyoList();
            for (Senkyo senkyo : senkyoList) {
                選挙略称List.add(senkyo.get選挙略称());
            }
        }
    }
}
