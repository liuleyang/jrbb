/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 失権者名簿のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class ShikkenshaMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private AFABTB101SelectProcessParameter parameter;

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboSource> reportSourceWriter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder builder;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;
    private static final int 転入前全国住所コード上5桁 = 5;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.失権者名簿.value());
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectShikkenshaMeiboList"),
                parameter.toSenkyojiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.失権者名簿.value())
                .addBreak(new BreakerCatalog<ShinkiTorokushaMeiboSource>().simplePageBreaker(CommonConstant.PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity current) {
        if (getBefore() != null
                && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode().equals(current.getSenkyoninMeiboEntity().getTohyokuCode())
                && !hasBreak(getBefore(), current)) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);
        }
        ShinkiTorokushaMeiboParam param = builder.addData(current, get失権事由コード(current), false);
        ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {
        if (hasBreak(getBefore(), entity)) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), get失権事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
    }

    private Boolean hasBreak(TorokushaMeiboEntity before, TorokushaMeiboEntity current) {
        return !get失権事由コード(before).equals(get失権事由コード(current));
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), get失権事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.失権者名簿.value(), get失権事由コード(getBefore()),
                RString.EMPTY, Boolean.TRUE);
    }

    private RString get失権事由コード(TorokushaMeiboEntity entity) {
        return set失権事由コードByCase1(entity);
    }

    private RString set失権事由コードByCase1(TorokushaMeiboEntity entity) {
        if (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.抹消者.value())
                && (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode()).equals(JiyuCode.転出4カ月.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode()).equals(JiyuCode.職権消除.getKey()))
                && (NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotai.転出者.コード())
                || NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotai.消除者.コード()))) {
            return JiyuCode._4ヶ月経過.getKey();
        }
        return this.set失権事由コードByCase2(entity);
    }

    private RString set失権事由コードByCase2(TorokushaMeiboEntity entity) {
        if (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).
                equals(JiyuCode.公職選挙法第11条1項2号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項3号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項4号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項5号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条2項該当.getKey()))) {
            return JiyuCode.公民権停止.getKey();
        }
        return set失権事由コードByCase3(entity);
    }

    private RString set失権事由コードByCase3(TorokushaMeiboEntity entity) {
        if (null == this.get地方公共団体コード() || this.get地方公共団体コード().isEmpty()) {
            return set失権事由コードByCase4(entity);
        }
        if (NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getZenkokuJushoCode()).isEmpty()) {
            return set失権事由コードByCase4(entity);
        }
        if (NullHandler.getNullToRString(entity.getSenkyoLevel()).equals(SennkyoLevel.都道府県.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).equals(JiyuCode.転出.getKey())
                && !NullHandler.getNullToRString(this.get地方公共団体コード()).substring(0, 2)
                .equals(NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getZenkokuJushoCode()).substring(0, 2))
                || (NullHandler.getNullToRString(entity.getSenkyoLevel()).equals(
                        SennkyoLevel.市区町村.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).equals(JiyuCode.転出.getKey())
                && !NullHandler.getNullToRString(this.get地方公共団体コード()).substring(0, 転入前全国住所コード上5桁)
                .equals(NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getZenkokuJushoCode()).substring(0, 転入前全国住所コード上5桁)))) {
            return JiyuCode.失権.getKey();
        }
        return set失権事由コードByCase4(entity);
    }

    private RString set失権事由コードByCase4(TorokushaMeiboEntity entity) {
        if (NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotai.住民.コード())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.抹消者.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode()).equals(JiyuCode.転出4カ月.getKey())) {
            return JiyuCode.再転入_失権.getKey();
        }
        return RString.EMPTY;
    }

    private LasdecCode get地方公共団体コード() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (null != association) {
            return association.get地方公共団体コード();
        }
        return null;
    }
}
