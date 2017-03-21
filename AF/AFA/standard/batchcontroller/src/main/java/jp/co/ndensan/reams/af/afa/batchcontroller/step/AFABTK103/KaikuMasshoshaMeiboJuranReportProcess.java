/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.ReportOutputType;
import jp.co.ndensan.reams.af.afa.business.core.ShinkiTorokushaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK105.ShinkiTorokushaMeiboKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 海区漁業調整委員会委員選挙時登録<br>
 * 抹消者名簿帳票を出力する。
 *
 * @reamsid_L AF-0470-030 jihb
 */
public class KaikuMasshoshaMeiboJuranReportProcess extends BatchKeyBreakBase<SenkyojiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select抹消者名簿帳票データ");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private static final List<RString> 抹消者名簿_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString(ShinkiTorokushaMeiboKaikuSource.ReportSourceFields.key.name()),
                            new RString(ShinkiTorokushaMeiboKaikuSource.ReportSourceFields.subTitle.name())));

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboKaikuSource> 抹消者名簿縦覧Writer;
    private ReportSourceWriter<ShinkiTorokushaMeiboKaikuSource> 抹消者名簿縦覧SourceWriter;

    private ShinkiTorokushaMeiboKaikuParam.ShinkiTorokushaMeiboParamBuilder builder;

    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private RString key;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }

    OutputParameter<Integer> pageCount;

    private List<RString> 改ページキーリストField = new ArrayList<>();

    private int index;

    private RString 取扱注意者の出力方式;

    private FlexibleDate 転出期限日;
    private FlexibleDate 年齢到達期限日;

    @Override
    protected void initialize() {
        転出期限日 = FlexibleDate.EMPTY;
        年齢到達期限日 = FlexibleDate.EMPTY;
        index = 0;
        key = RString.EMPTY;
        改ページキーリストField = processParameter.get改頁項目IDリスト();
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new ShinkiTorokushaMeiboKaikuParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.抹消者名簿海区.value());
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        抹消者名簿縦覧Writer = BatchReportFactory.createBatchReportWriter(ReportIdKeys.抹消者名簿海区.value())
                .addBreak(new BreakerCatalog<ShinkiTorokushaMeiboKaikuSource>().simplePageBreaker(抹消者名簿_BREAK_KEYS)).create();
        抹消者名簿縦覧SourceWriter = new ReportSourceWriter<>(抹消者名簿縦覧Writer);

    }

    @Override
    protected void keyBreakProcess(SenkyojiKaikuEntity entity) {
        if (is改ページ(改ページキーリストField, getBefore(), entity)) {
            index++;
            key = OutputKeys.改ページ.getValue().concat(new RString(index));
        }

        if (hasBreak(getBefore(), entity) && is抹消者(entity) && isRight抹消事由(entity)) {

            ShinkiTorokushaMeiboKaikuReport 空白行 = new ShinkiTorokushaMeiboKaikuReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(抹消者名簿縦覧SourceWriter);

            ShinkiTorokushaMeiboKaikuParam 集計行 = builder.addData(entity, get抹消事由コード(entity), false, key);
            ShinkiTorokushaMeiboKaikuReport 集計行Out = new ShinkiTorokushaMeiboKaikuReport(集計行, 帳票共通ヘッダー);
            集計行Out.writeBy(抹消者名簿縦覧SourceWriter);
        }

    }

    private boolean hasBreak(SenkyojiKaikuEntity before, SenkyojiKaikuEntity current) {
        return !NullHandler.getNullToRString(before.getSenkyoShikakuEntity().getMasshoJiyuCode())
                .equals(NullHandler.getNullToRString(current.getSenkyoShikakuEntity().getMasshoJiyuCode()));
    }

    @Override
    protected void usualProcess(SenkyojiKaikuEntity entity) {
        if (is抹消者(entity) && isRight抹消事由(entity)) {
            if (getBefore() != null && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode()
                    .equals(entity.getSenkyoninMeiboEntity().getTohyokuCode())
                    && !hasBreak(getBefore(), entity)) {
                ShinkiTorokushaMeiboKaikuReport 空白行 = new ShinkiTorokushaMeiboKaikuReport(get空白行(), 帳票共通ヘッダー);
                空白行.writeBy(抹消者名簿縦覧SourceWriter);
            }

            int flag = 取扱い注意者判断(getBefore());
            if (flag == 1) {
                return;
            }

            if (flag == KaikuNumberEdit.固定数_2.getKey()) {
                ShinkiTorokushaMeiboKaikuReport report = new ShinkiTorokushaMeiboKaikuReport(get空白行(), 帳票共通ヘッダー);
                report.writeBy(抹消者名簿縦覧SourceWriter);
            }
            if (flag == KaikuNumberEdit.固定数_3.getKey()) {
                ShinkiTorokushaMeiboKaikuReport report = new ShinkiTorokushaMeiboKaikuReport(get空白行(), 帳票共通ヘッダー);
                report.writeBy(抹消者名簿縦覧SourceWriter);
            }
            if (flag == KaikuNumberEdit.固定数_4.getKey()) {
                ShinkiTorokushaMeiboKaikuParam param = builder.addData(entity, get抹消事由コード(entity), false, key);
                ShinkiTorokushaMeiboKaikuReport report = new ShinkiTorokushaMeiboKaikuReport(param, 帳票共通ヘッダー);
                report.writeBy(抹消者名簿縦覧SourceWriter);
            }

        }

    }

    private int 取扱い注意者判断(SenkyojiKaikuEntity entity) {
        int flag = KaikuNumberEdit.固定数_4.getKey();
        if (entity != null && entity.getFindeCautionShaMapperEntity() != null && entity.getFindeCautionShaMapperEntity().isGaitoKubun()) {
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_1.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を空白.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_2.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク.getValue().equals(取扱注意者の出力方式)) {
                flag = KaikuNumberEdit.固定数_3.getKey();
            }
        } else {
            flag = KaikuNumberEdit.固定数_4.getKey();
        }
        return flag;
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(抹消者名簿縦覧Writer.getPageCount());
    }

    private Boolean isRight抹消事由(SenkyojiKaikuEntity entity) {
        RString 事由コード = NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode());
        return 事由コード.equals(JiyuCode.死亡.getKey()) || 事由コード.equals(JiyuCode.国籍喪失.getKey())
                || 事由コード.equals(JiyuCode.転出4カ月.getKey()) || 事由コード.equals(JiyuCode.誤載.getKey())
                || 事由コード.equals(JiyuCode.職権消除.getKey()) || 事由コード.equals(JiyuCode.居住要件.getKey())
                || 事由コード.equals(JiyuCode.その他_抹消.getKey());
    }

    private Boolean is抹消者(SenkyojiKaikuEntity entity) {

        if (entity.getShohonEntity() != null) {
            年齢到達期限日 = entity.getShohonEntity().getKiteiNenreiTotatsuYMD();
        }

        if (entity.getSenkyoEntity() != null) {
            転出期限日 = entity.getSenkyoEntity().getTenshutsuKigenYMD();
        }
        return new ShikakuHantei().is抹消者(entity.getShikibetsuTaishoEntity(), 転出期限日, 年齢到達期限日);
    }

    private ShinkiTorokushaMeiboKaikuParam get空白行() {
        return new ShinkiTorokushaMeiboKaikuParam(getBefore(), ReportIdKeys.抹消者名簿海区.value(), get抹消事由コード(getBefore()),
                RString.EMPTY, true, key);
    }

    private RString get抹消事由コード(SenkyojiKaikuEntity entity) {
        return NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode());
    }

    private boolean is改ページ(List<RString> 改ページキーリスト,
            SenkyojiKaikuEntity before明細情報,
            SenkyojiKaikuEntity after明細情報) {
        if (改ページキーリスト == null || 改ページキーリスト.isEmpty()) {
            return Boolean.FALSE;
        }

        GyoseikuCode before行政区 = before明細情報.getShikibetsuTaishoEntity().getGyoseikuCode();
        RString 行政区コードBefore = before行政区 != null ? before行政区.value() : RString.EMPTY;
        GyoseikuCode after行政区 = after明細情報.getShikibetsuTaishoEntity().getGyoseikuCode();
        RString 行政区コードAfter = after行政区 != null ? after行政区.value() : RString.EMPTY;
        Boolean is改ページFlag = is改ページ_行政区コード(改ページキーリスト, 行政区コードBefore, 行政区コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        TsuzukigaraCode 続柄Before = before明細情報.getShikibetsuTaishoEntity().getTsuzukigaraCode();
        TsuzukigaraCode 続柄After = after明細情報.getShikibetsuTaishoEntity().getTsuzukigaraCode();
        RString 続柄コードBefore = 続柄Before != null ? 続柄Before.value() : RString.EMPTY;
        RString 続柄コードAfter = 続柄After != null ? 続柄After.value() : RString.EMPTY;
        is改ページFlag = is改ページ_続柄コード(改ページキーリスト, 続柄コードBefore, 続柄コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }
        SetaiCode 世帯コードBefore = before明細情報.getShikibetsuTaishoEntity().getSetaiCode();
        SetaiCode 世帯コードAfter = after明細情報.getShikibetsuTaishoEntity().getSetaiCode();
        is改ページFlag = is改ページ_世帯コード(改ページキーリスト, 世帯コードBefore, 世帯コードAfter);
        if (is改ページFlag) {
            return is改ページFlag;
        }

        return is改ページFlag;
    }

    private boolean is改ページ_続柄コード(List<RString> 改ページキーリスト,
            RString 続柄コードBefore,
            RString 続柄コードAfter) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.続柄.get項目ID())) {
            if (RString.isNullOrEmpty(続柄コードBefore) && RString.isNullOrEmpty(続柄コードAfter)) {
                is改ページFlag = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(続柄コードBefore)
                    && !RString.isNullOrEmpty(続柄コードAfter)
                    && 続柄コードBefore.equals(続柄コードAfter)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_行政区コード(List<RString> 改ページキーリスト,
            RString before行政区コード,
            RString after行政区コード) {
        Boolean is改ページFlag = Boolean.FALSE;

        if (改ページキーリスト.contains(ReportOutputType.行政区コード.get項目ID())) {
            if (RString.isNullOrEmpty(before行政区コード) && RString.isNullOrEmpty(after行政区コード)) {
                is改ページFlag = Boolean.FALSE;
            } else if (!RString.isNullOrEmpty(before行政区コード)
                    && !RString.isNullOrEmpty(after行政区コード)
                    && before行政区コード.equals(after行政区コード)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

    private boolean is改ページ_世帯コード(List<RString> 改ページキーリスト,
            SetaiCode before世帯コード,
            SetaiCode after世帯コード) {
        Boolean is改ページFlag = Boolean.FALSE;
        if (改ページキーリスト.contains(ReportOutputType.世帯コード.get項目ID())) {

            if (before世帯コード == null && after世帯コード == null) {
                is改ページFlag = Boolean.FALSE;
            } else if (before世帯コード != null
                    && after世帯コード != null
                    && before世帯コード.equals(after世帯コード)) {
                is改ページFlag = Boolean.FALSE;
            } else {
                is改ページFlag = Boolean.TRUE;
            }
        }
        return is改ページFlag;
    }

}
