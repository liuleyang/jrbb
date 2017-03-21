/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenMaisuhyoParam;
import jp.co.ndensan.reams.af.afa.business.core.NyujoukenGamenModel;
import jp.co.ndensan.reams.af.afa.business.core.SetaiichiranhyouJouhou;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB212.NyujokenMaisuhyoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）の投票所入場券印刷枚数表のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuNyujokenMaisuhyoReportProcess extends BatchProcessBase<AFABTB201NyujokenMaisuhyoEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private INyujokenIkkatsuMapper mapper;
    private AfaMapperProvider mapperProvider;
    private static final RString INIT_BIGDECIMAL = new RString("0");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectNyujokenMaisuhyoTempTable");
    @BatchWriter
    private BatchReportWriter<NyujokenMaisuhyoSource> batchReportWriter;
    private ReportSourceWriter<NyujokenMaisuhyoSource> reportSourceWriter;
    /**
     * 地図情報イメージファイル取得。
     *
     */
    public static final RString IMAGE_FOLDER_PATH;

    static {
        IMAGE_FOLDER_PATH = new RString("imageFolderPath");
    }
    private OutputParameter<List<RString>> imageFolderPath;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Decimal> nyujokenReportIndex;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }

    OutputParameter<Integer> pageCount;
    private Decimal 印刷世帯数集計;
    private Decimal 印刷枚数集計;
    private Decimal 人数集計;
    private Integer itemCount;
    private NyujoukenGamenModel 選挙共通情報;
    
    @Override
    protected void initialize() {
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable(parameter.getTable());
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日入場券印刷枚数表 = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日入場券印刷枚数表 != null) {
            parameter.set前回基準日(前回基準日入場券印刷枚数表.get前回基準日());
        } else {
            parameter.set前回基準日(FlexibleDate.EMPTY);
        }

        imageFolderPath = new OutputParameter<>();
        nyujokenReportIndex = new OutputParameter<>();
        pageCount = new OutputParameter<>();
        印刷世帯数集計 = Decimal.ZERO;
        印刷枚数集計 = Decimal.ZERO;
        人数集計 = Decimal.ZERO;
        itemCount = 0;
        選挙共通情報 = get選挙共通情報();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(AFABTB201NyujokenMaisuhyoEntity 入場券印刷枚数表) {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());
        NyujokenMaisuhyoParam nyujokenMaisuhyoParam = new NyujokenMaisuhyoParam(選挙共通情報, edit明細情報(入場券印刷枚数表));
        NyujokenMaisuhyoReport report = new NyujokenMaisuhyoReport(nyujokenMaisuhyoParam, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
        itemCount++;
    }

    @Override
    protected void afterExecute() {
        if (itemCount != 0) {
            edit空行();
            edit合計行();
        }
        pageCount.setValue(batchReportWriter.getPageCount());
        RString コピー元パースチェックリスト = batchReportWriter.getImageFolderPath();
        List<RString> イメージファイルパース = new ArrayList<>();

        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            イメージファイルパース.add(コピー元パースチェックリスト);
        }
        imageFolderPath.setValue(イメージファイルパース);
        Decimal 入場券発行固有連番_チェック = batchReportWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番_チェック);
    }

    private SetaiichiranhyouJouhou edit明細情報(AFABTB201NyujokenMaisuhyoEntity 入場券印刷枚数表) {
        SetaiichiranhyouJouhou 明細情報 = new SetaiichiranhyouJouhou();
        if (入場券印刷枚数表.getShuukeiSetaisuSuji() == null) {
            明細情報.set印刷世帯数集計した値(INIT_BIGDECIMAL);
        } else {
            明細情報.set印刷世帯数集計した値(new RString(入場券印刷枚数表.getShuukeiSetaisuSuji().toString()));
            印刷世帯数集計 = 印刷世帯数集計.add(入場券印刷枚数表.getShuukeiSetaisuSuji());
        }
        if (入場券印刷枚数表.getShuukeiNinSuji() == null) {
            明細情報.set人数集計した値(INIT_BIGDECIMAL);
        } else {
            明細情報.set人数集計した値(new RString(入場券印刷枚数表.getShuukeiNinSuji().toString()));
            人数集計 = 人数集計.add(入場券印刷枚数表.getShuukeiNinSuji());
        }
        if (入場券印刷枚数表.getShuukeiMeisuSuji() == null) {
            明細情報.set印刷枚数集計した値(INIT_BIGDECIMAL);
        } else {
            明細情報.set印刷枚数集計した値(new RString(入場券印刷枚数表.getShuukeiMeisuSuji().toString()));
            印刷枚数集計 = 印刷枚数集計.add(入場券印刷枚数表.getShuukeiMeisuSuji());
        }
        明細情報.set集計コード(入場券印刷枚数表.getShuukeiCode());
        明細情報.set集計コード名称(入場券印刷枚数表.getShuukeiName());
        明細情報.set集計単位名称(入場券印刷枚数表.getShuukeiTanni());
        明細情報.set合計Flag(Boolean.FALSE);
        return 明細情報;
    }

    private void edit空行() {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());
        SetaiichiranhyouJouhou setaiichiranhyouJouhou = new SetaiichiranhyouJouhou();
        setaiichiranhyouJouhou.set印刷世帯数集計した値(RString.EMPTY);
        setaiichiranhyouJouhou.set人数集計した値(RString.EMPTY);
        setaiichiranhyouJouhou.set印刷枚数集計した値(RString.EMPTY);
        setaiichiranhyouJouhou.set合計Flag(Boolean.FALSE);
        NyujokenMaisuhyoParam nyujokenMaisuhyoParam = new NyujokenMaisuhyoParam(選挙共通情報, setaiichiranhyouJouhou);
        NyujokenMaisuhyoReport report = new NyujokenMaisuhyoReport(nyujokenMaisuhyoParam, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    private void edit合計行() {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(parameter.get帳票ID());
        SetaiichiranhyouJouhou setaiichiranhyouJouhou = new SetaiichiranhyouJouhou();
        setaiichiranhyouJouhou.set印刷世帯数集計した値(new RString(印刷世帯数集計.toString()));
        setaiichiranhyouJouhou.set人数集計した値(new RString(人数集計.toString()));
        setaiichiranhyouJouhou.set印刷枚数集計した値(new RString(印刷枚数集計.toString()));
        setaiichiranhyouJouhou.set合計Flag(Boolean.TRUE);
        NyujokenMaisuhyoParam nyujokenMaisuhyoParam = new NyujokenMaisuhyoParam(選挙共通情報, setaiichiranhyouJouhou);
        NyujokenMaisuhyoReport report = new NyujokenMaisuhyoReport(nyujokenMaisuhyoParam, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    /**
     * 選挙共通情報を取得する。
     *
     * @param 入場券印刷枚数表引数 AFABTB202SelectProcessParameter
     * @param 地方公共団体情報 Association
     * @return NyujoukenGamenModel
     */
    private NyujoukenGamenModel get選挙共通情報() {
        NyujoukenGamenModel nyujoukenGamenModel = new NyujoukenGamenModel();
        if (parameter.get前回基準日().isValid()) {
            nyujoukenGamenModel.set基準日(
                    new RDate(parameter.get前回基準日().toString()));
        }
        FlexibleDate 投票日 = parameter.get投票日();
        nyujoukenGamenModel.set投票年月日(
                投票日 == null ? null : new RDate(投票日.toString()));
        return nyujoukenGamenModel;
    }
}
