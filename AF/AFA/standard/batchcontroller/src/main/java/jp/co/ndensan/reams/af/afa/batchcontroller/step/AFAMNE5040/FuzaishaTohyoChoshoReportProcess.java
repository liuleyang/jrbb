/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE516.FuzaishaTohyoChoshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE516.FuzaishaTohyoChoshoReport;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票に関する調書（25号様式）帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-033 lit
 */
public class FuzaishaTohyoChoshoReportProcess extends BatchProcessBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");

    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;
    private FuzaishaTohyoChoshoParam.FuzaishaTohyoChoshoParamBuilder builder;
    private Association association;

    private ZenjitsuPrintEntity before = null;

    @BatchWriter
    private BatchReportWriter<FuzaishaTohyoChoshoSource> batchReportWriter;
    private ReportSourceWriter<FuzaishaTohyoChoshoSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();

    }

    @Override
    protected void beforeExecute() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        builder = new FuzaishaTohyoChoshoParam.FuzaishaTohyoChoshoParamBuilder(association.get市町村名(), parameter.is印字有無フラグ());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.不在者投票に関する調書25号様式.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(ZenjitsuPrintEntity entity) {

        if (before != null) {
            List<FuzaishaTohyoChoshoParam> rslt = new ArrayList<>();
            if (isNew選挙番号(before, entity)) {
                rslt.add(builder.投票区合計());
                rslt.add(builder.選挙合計());
            } else if (isNew投票区(before, entity)) {
                rslt.add(builder.投票区合計());
            }
            for (FuzaishaTohyoChoshoParam data : rslt) {
                FuzaishaTohyoChoshoReport report = new FuzaishaTohyoChoshoReport(data);
                report.writeBy(reportSourceWriter);
            }
        }
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名情報Entity());
        if (宛名対象.canBe個人()) {
            IKojin 個人 = 宛名対象.to個人();
            builder.addData(entity.get選挙Entity(),
                    entity.get投票区UrEntity(),
                    entity.get施設Entity(),
                    entity.get投票状況Entity(),
                    個人.get性別());
        }
        before = entity;

    }

    @Override
    protected void afterExecute() {

        List<FuzaishaTohyoChoshoParam> rslt = new ArrayList<>();
        rslt.add(builder.投票区合計());
        rslt.add(builder.選挙合計());
        for (FuzaishaTohyoChoshoParam data : rslt) {
            if (data != null) {
                FuzaishaTohyoChoshoReport report = new FuzaishaTohyoChoshoReport(data);
                report.writeBy(reportSourceWriter);
            }
        }

        pageCount.setValue(batchReportWriter.getPageCount());

    }

    private boolean isNew選挙番号(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));

    }

    private boolean isNew投票区(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        UrT0159TohyokuEntity 投票区前Entity = before.get投票区UrEntity();
        UrT0159TohyokuEntity 投票区現Entity = current.get投票区UrEntity();
        RString 投票区コード前 = 投票区前Entity == null ? RString.EMPTY : 投票区前Entity.getTohyokuCode().value();
        RString 投票区コード現 = 投票区現Entity == null ? RString.EMPTY : 投票区現Entity.getTohyokuCode().value();
        return !投票区コード前.equals(投票区コード現);

    }
}
