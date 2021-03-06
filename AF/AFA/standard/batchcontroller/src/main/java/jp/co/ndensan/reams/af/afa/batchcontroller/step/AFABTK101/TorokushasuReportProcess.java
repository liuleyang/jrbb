/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.GoukeiJouhou;
import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListKaikuParentParam;
import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboShohonKaikuDbMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 登録者数リスト（海区選挙）帳票を出力する。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class TorokushasuReportProcess extends BatchKeyBreakBase<MeiboSakuseiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select登録者数リスト");

    private MeiboShohonKaikuDbMybatisParameter mybatisParameter;

    private AFABTK101SelectProcessParameter processParameter;

    private ShikakuHantei shikakuHantei;

    private static final RString 印字文字_1 = new RString("＊　投票区計　＊");
    private static final RString 印字文字_2 = new RString("＊　合　　計　＊");

    private int 有権者男集計;
    private int 有権者女集計;

    private int 表示者男集計;
    private int 表示者女集計;

    private int 公民権停止者男集計;
    private int 公民権停止者女集計;

    private int 有権者男総集計;
    private int 有権者女総集計;

    private int 表示者男総集計;
    private int 表示者女総集計;

    private int 公民権停止者男総集計;
    private int 公民権停止者女総集計;

    private int 最後有権者男集計;
    private int 最後有権者女集計;

    private int 最後表示者男集計;
    private int 最後表示者女集計;

    private int 最後公民権停止者男集計;
    private int 最後公民権停止者女集計;

    private int page;

    private RString 帳票ID;

    private RString 明細タイトル住所;

    private RString 集計地区名;

    private RString 帳票出力順;

    private GoukeiJouhou 合計情報;

    private GoukeiJouhou 投票区合計情報;

    private static final RString 明細タイトル住所_住所 = new RString("住所");
    private static final RString 明細タイトル住所_行政区 = new RString("行政区");

    @BatchWriter
    private BatchReportWriter<TorokushasuListSource> 海区選挙登録者数リストWriter;
    private ReportSourceWriter<TorokushasuListSource> 海区選挙登録者数リストSourceWriter;

    private static final RString 出力順_住所コード = new RString("住所コード");
    private static final RString 出力順_行政区コード = new RString("行政区コード");
    private static final RString 出力順_地区コード1 = new RString("地区コード１");
    private static final RString 出力順_地区コード2 = new RString("地区コード２");
    private static final RString 出力順_地区コード3 = new RString("地区コード３");

    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private Map<RString, TorokushasuListParam> map総合計;

    private TorokushasuListParam 登録者数リスト情報;

    private TorokushasuListKaikuParentParam 登録者情報;

    private int 合計データ;

    private static final List<RString> 登録者数リスト海区選挙_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString(TorokushasuListSource.ReportSourceFields.sumType.name())));

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
        mybatisParameter = processParameter.toMeiboShohonKaikuDbMybatisParameter();
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        帳票ID = ReportIdKeys.AFAPRA103_登録者数リスト海区選挙.value();
        pageCount = new OutputParameter<>();

        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        shikakuHantei = new ShikakuHantei();
        map総合計 = new HashMap<>();

        page = 1;
        有権者男集計 = 0;
        有権者女集計 = 0;

        表示者男集計 = 0;
        表示者女集計 = 0;

        公民権停止者男集計 = 0;
        公民権停止者女集計 = 0;

        有権者男総集計 = 0;
        有権者女総集計 = 0;

        表示者男総集計 = 0;
        表示者女総集計 = 0;

        公民権停止者男総集計 = 0;
        公民権停止者女総集計 = 0;

        最後有権者男集計 = 0;
        最後有権者女集計 = 0;

        最後表示者男集計 = 0;
        最後表示者女集計 = 0;

        最後公民権停止者男集計 = 0;
        最後公民権停止者女集計 = 0;

        合計データ = 0;

        明細タイトル住所 = RString.EMPTY;
        集計地区名 = RString.EMPTY;

        合計情報 = new GoukeiJouhou();
        投票区合計情報 = new GoukeiJouhou();
        登録者数リスト情報 = new TorokushasuListParam();

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.登録者数リスト.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        海区選挙登録者数リストWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRA103_登録者数リスト海区選挙.value())
                .addBreak(new BreakerCatalog<TorokushasuListSource>().simplePageBreaker(登録者数リスト海区選挙_BREAK_KEYS)).create();

        海区選挙登録者数リストSourceWriter = new ReportSourceWriter<>(海区選挙登録者数リストWriter);
    }

    @Override
    protected void usualProcess(MeiboSakuseiKaikuEntity entity) {
        合計データ++;
        set表示者集計項目(entity);
        set公民権停止者集計項目(entity);
        set有権者集計項目(entity);
        登録者情報 = set登録者情報(entity, 帳票出力順);
        帳票共通ヘッダー = set帳票共通();

    }

    @Override
    protected void keyBreakProcess(MeiboSakuseiKaikuEntity entity) {
        合計情報 = new GoukeiJouhou();
        登録者情報 = set登録者情報(getBefore(), 帳票出力順);
        boolean 集計項目キーbreakFlg = is集計項目キー判定(entity);
        boolean is集計項目投票区コード = is集計項目投票区コード判定(entity, 集計項目キーbreakFlg);

        if (集計項目キーbreakFlg || is集計項目投票区コード) {
            TorokushasuListKaikuParam param = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            TorokushasuListKaikuReport report = new TorokushasuListKaikuReport(param, 帳票共通ヘッダー);
            report.writeBy(海区選挙登録者数リストSourceWriter);
        }

        if (is集計項目投票区コード) {
            登録者情報.set集計地区名(印字文字_1);
            登録者情報.set投票区コード(RString.EMPTY);
            TorokushasuListKaikuParam param = new TorokushasuListKaikuParam(投票区合計情報, 登録者情報);
            TorokushasuListKaikuReport report = new TorokushasuListKaikuReport(param, 帳票共通ヘッダー);
            report.writeBy(海区選挙登録者数リストSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        if (合計データ != 0 && 合計データ > 1) {
            set投票区コードの集計();
            map総合計.put(getBefore().getAfT112SenkyoninMeibEntity().getTohyokuCode(), set登録者数リスト情報(getBefore()));

            set集計項目();
            TorokushasuListKaikuParam param = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            TorokushasuListKaikuReport report = new TorokushasuListKaikuReport(param, 帳票共通ヘッダー);
            report.writeBy(海区選挙登録者数リストSourceWriter);

            set投票区コードの集計();
            登録者情報.set集計地区名(集計地区名);
            登録者情報.set投票区コード(RString.EMPTY);
            TorokushasuListKaikuParam param投票区コード = new TorokushasuListKaikuParam(投票区合計情報, 登録者情報);
            帳票共通ヘッダー = set帳票共通();
            TorokushasuListKaikuReport report投票区コード = new TorokushasuListKaikuReport(param投票区コード, 帳票共通ヘッダー);
            report投票区コード.writeBy(海区選挙登録者数リストSourceWriter);

            set総集計項目();
            登録者情報.set集計地区名(印字文字_2);
            登録者情報.set投票区コード(RString.EMPTY);
            TorokushasuListKaikuParam param合計 = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            帳票共通ヘッダー = set帳票共通();
            TorokushasuListKaikuReport report合計 = new TorokushasuListKaikuReport(param合計, 帳票共通ヘッダー);
            report合計.writeBy(海区選挙登録者数リストSourceWriter);
            登録者情報.set合計タイプ(OutputKeys.登録者_2.getValue());

            if (!map総合計.isEmpty()) {
                for (Map.Entry<RString, TorokushasuListParam> entry : map総合計.entrySet()) {
                    RString 投票区コード = entry.getKey();
                    合計情報.set公民権停止者_女数(entry.getValue().get公民権停止者_女数());
                    合計情報.set公民権停止者_男数(entry.getValue().get公民権停止者_男数());
                    合計情報.set有権者_女数(entry.getValue().get有権者_女数());
                    合計情報.set有権者_男数(entry.getValue().get有権者_男数());
                    合計情報.set表示者_女数(entry.getValue().get表示者_女数());
                    合計情報.set表示者_男数(entry.getValue().get表示者_男数());

                    TorokushasuListKaikuParentParam 登録者情報_old = new TorokushasuListKaikuParentParam();
                    登録者情報_old.set投票区コード(投票区コード);
                    登録者情報_old.set基準日(new RDate(processParameter.get基準日().toString()));
                    登録者情報_old.set明細タイトル住所(OutputKeys.投票区名称.getValue());
                    登録者情報_old.set集計地区名(entry.getValue().get集計地区名());
                    登録者情報_old.set合計タイプ(OutputKeys.登録者_2.getValue());

                    set帳票共通();
                    TorokushasuListKaikuParam param_投票区 = new TorokushasuListKaikuParam(合計情報, 登録者情報_old);
                    TorokushasuListKaikuReport report_投票区 = new TorokushasuListKaikuReport(param_投票区, 帳票共通ヘッダー);
                    report_投票区.writeBy(海区選挙登録者数リストSourceWriter);
                }
            }
            明細タイトル住所 = OutputKeys.投票区名称.getValue();
            登録者情報.set明細タイトル住所(明細タイトル住所);
            登録者情報.set投票区コード(RString.EMPTY);
            登録者情報.set集計地区名(印字文字_2);

            TorokushasuListKaikuParam param_登録者数 = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            TorokushasuListKaikuReport report_登録者数 = new TorokushasuListKaikuReport(param_登録者数, 帳票共通ヘッダー);
            report_登録者数.writeBy(海区選挙登録者数リストSourceWriter);

        } else if (合計データ == 1) {
            set投票区コードの集計();
            map総合計.put(getBefore().getAfT112SenkyoninMeibEntity().getTohyokuCode(), set登録者数リスト情報(getBefore()));

            set総集計項目();
            TorokushasuListKaikuParam param_海区 = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            帳票共通ヘッダー = set帳票共通();
            TorokushasuListKaikuReport report_海区 = new TorokushasuListKaikuReport(param_海区, 帳票共通ヘッダー);
            report_海区.writeBy(海区選挙登録者数リストSourceWriter);

            set投票区コードの集計();
            登録者情報.set集計地区名(集計地区名);
            登録者情報.set投票区コード(RString.EMPTY);
            TorokushasuListKaikuParam param投票区コード = new TorokushasuListKaikuParam(投票区合計情報, 登録者情報);
            帳票共通ヘッダー = set帳票共通();
            TorokushasuListKaikuReport report投票区コード = new TorokushasuListKaikuReport(param投票区コード, 帳票共通ヘッダー);
            report投票区コード.writeBy(海区選挙登録者数リストSourceWriter);

            登録者情報.set集計地区名(印字文字_2);
            登録者情報.set投票区コード(RString.EMPTY);
            TorokushasuListKaikuParam param = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            帳票共通ヘッダー = set帳票共通();
            TorokushasuListKaikuReport report = new TorokushasuListKaikuReport(param, 帳票共通ヘッダー);
            report.writeBy(海区選挙登録者数リストSourceWriter);
            登録者情報.set合計タイプ(OutputKeys.登録者_2.getValue());

            if (!map総合計.isEmpty()) {
                for (Map.Entry<RString, TorokushasuListParam> entry : map総合計.entrySet()) {
                    RString 投票区コード = entry.getKey();
                    TorokushasuListParam torokushasuListParam = entry.getValue();
                    合計情報.set公民権停止者_女数(torokushasuListParam.get公民権停止者_女数());
                    合計情報.set公民権停止者_男数(torokushasuListParam.get公民権停止者_男数());
                    合計情報.set有権者_女数(torokushasuListParam.get有権者_女数());
                    合計情報.set有権者_男数(torokushasuListParam.get有権者_男数());
                    合計情報.set表示者_女数(torokushasuListParam.get表示者_女数());
                    合計情報.set表示者_男数(torokushasuListParam.get表示者_男数());

                    TorokushasuListKaikuParentParam 登録者情報_old = new TorokushasuListKaikuParentParam();
                    登録者情報_old.set投票区コード(投票区コード);
                    登録者情報_old.set基準日(new RDate(processParameter.get基準日().toString()));
                    登録者情報_old.set明細タイトル住所(OutputKeys.投票区名称.getValue());
                    登録者情報_old.set集計地区名(torokushasuListParam.get集計地区名());
                    登録者情報_old.set合計タイプ(OutputKeys.登録者_2.getValue());

                    set帳票共通();
                    TorokushasuListKaikuParam param_投票区 = new TorokushasuListKaikuParam(合計情報, 登録者情報_old);
                    TorokushasuListKaikuReport report_投票区 = new TorokushasuListKaikuReport(param_投票区, 帳票共通ヘッダー);
                    report_投票区.writeBy(海区選挙登録者数リストSourceWriter);
                }
            }

            明細タイトル住所 = OutputKeys.投票区名称.getValue();
            登録者情報.set明細タイトル住所(明細タイトル住所);
            登録者情報.set投票区コード(RString.EMPTY);
            登録者情報.set集計地区名(印字文字_2);

            TorokushasuListKaikuParam param_登録者数 = new TorokushasuListKaikuParam(合計情報, 登録者情報);
            TorokushasuListKaikuReport report_登録者数 = new TorokushasuListKaikuReport(param_登録者数, 帳票共通ヘッダー);
            report_登録者数.writeBy(海区選挙登録者数リストSourceWriter);
        }

        pageCount.setValue(海区選挙登録者数リストSourceWriter.pageCount().value());

    }

    private boolean is集計項目投票区コード判定(MeiboSakuseiKaikuEntity entity, boolean 集計項目キーbreakFlg) {
        if (hasBy投票区コード(getBefore(), entity)) {
            set投票区コードの集計();
            if (!集計項目キーbreakFlg) {
                set集計項目();
                有権者男集計 = 0;
                有権者女集計 = 0;

                表示者男集計 = 0;
                表示者女集計 = 0;

                公民権停止者男集計 = 0;
                公民権停止者女集計 = 0;
            }
            map総合計.put(entity.getAfT112SenkyoninMeibEntity().getTohyokuCode(), set登録者数リスト情報(getBefore()));

            有権者男総集計 = 0;
            有権者女総集計 = 0;

            表示者男総集計 = 0;
            表示者女総集計 = 0;

            公民権停止者男総集計 = 0;
            公民権停止者女総集計 = 0;

            return true;
        }

        return false;

    }

    private boolean is集計項目キー判定(MeiboSakuseiKaikuEntity entity) {
        if (出力順_住所コード.equals(帳票出力順) && hasBy住所コード(getBefore(), entity)) {
            set集計項目();
            有権者男集計 = 0;
            有権者女集計 = 0;

            表示者男集計 = 0;
            表示者女集計 = 0;

            公民権停止者男集計 = 0;
            公民権停止者女集計 = 0;
            return true;
        }
        if (出力順_地区コード1.equals(帳票出力順) && hasBy地区コード１(getBefore(), entity)) {
            set集計項目();
            有権者男集計 = 0;
            有権者女集計 = 0;

            表示者男集計 = 0;
            表示者女集計 = 0;

            公民権停止者男集計 = 0;
            公民権停止者女集計 = 0;
            return true;
        }

        if (出力順_地区コード2.equals(帳票出力順) && hasBy地区コード２(getBefore(), entity)) {
            set集計項目();
            有権者男集計 = 0;
            有権者女集計 = 0;

            表示者男集計 = 0;
            表示者女集計 = 0;

            公民権停止者男集計 = 0;
            公民権停止者女集計 = 0;
            return true;

        }

        if (出力順_地区コード3.equals(帳票出力順) && hasBy地区コード３(getBefore(), entity)) {

            set集計項目();
            有権者男集計 = 0;
            有権者女集計 = 0;

            表示者男集計 = 0;
            表示者女集計 = 0;

            公民権停止者男集計 = 0;
            公民権停止者女集計 = 0;
            return true;
        }

        if (!出力順_住所コード.equals(帳票出力順) && !出力順_地区コード1.equals(帳票出力順)
                && !出力順_地区コード2.equals(帳票出力順) && !出力順_地区コード3.equals(帳票出力順)
                && hasBy行政区(getBefore(), entity)) {
            set集計項目();
            有権者男集計 = 0;
            有権者女集計 = 0;

            表示者男集計 = 0;
            表示者女集計 = 0;

            公民権停止者男集計 = 0;
            公民権停止者女集計 = 0;
            return true;
        }

        return false;
    }

    private boolean hasBy地区コード３(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード３;
        RString current地区コード３;

        if (before == null) {
            before地区コード３ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode3() == null) {
            before地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = before.getUaFt200Entity().getChikuCode1();
            before地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード３ = RString.EMPTY;
        } else {
            ChikuCode 地区コード３ = current.getUaFt200Entity().getChikuCode1();
            current地区コード３ = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }
        if (!before地区コード３.equals(current地区コード３)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    private boolean hasBy地区コード２(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード２;
        RString current地区コード２;

        if (before == null) {
            before地区コード２ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode2() == null) {
            before地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = before.getUaFt200Entity().getChikuCode1();
            before地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード２ = RString.EMPTY;
        } else {
            ChikuCode 地区コード２ = current.getUaFt200Entity().getChikuCode1();
            current地区コード２ = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (!before地区コード２.equals(current地区コード２)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private boolean hasBy地区コード１(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before地区コード１;
        RString current地区コード１;

        if (before == null) {
            before地区コード１ = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChikuCode1() == null) {
            before地区コード１ = RString.EMPTY;
        } else {

            ChikuCode 地区コード１ = before.getUaFt200Entity().getChikuCode1();
            before地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }

        if (current == null) {
            current地区コード１ = RString.EMPTY;
        } else {
            ChikuCode 地区コード１ = current.getUaFt200Entity().getChikuCode1();
            current地区コード１ = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (!before地区コード１.equals(current地区コード１)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private boolean hasBy住所コード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before住所コード;
        RString current住所コード;

        if (before == null) {
            before住所コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getJutonaiChoikiCode() == null) {
            before住所コード = RString.EMPTY;
        } else {
            ChoikiCode 住所コード = current.getUaFt200Entity().getJutonaiChoikiCode();
            before住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current住所コード = RString.EMPTY;
        } else {
            ChoikiCode 住所コード = current.getUaFt200Entity().getJutonaiChoikiCode();
            current住所コード = 住所コード != null ? 住所コード.value() : RString.EMPTY;
        }
        if (!before住所コード.equals(current住所コード)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private boolean hasBy行政区(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before行政区コード;
        RString current行政区コード;

        if (before == null) {
            before行政区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getGyoseikuCode() == null) {
            before行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = current.getUaFt200Entity().getGyoseikuCode();
            before行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = current.getUaFt200Entity().getGyoseikuCode();
            current行政区コード = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (!before行政区コード.equals(current行政区コード)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    private boolean hasBy投票区コード(MeiboSakuseiKaikuEntity before, MeiboSakuseiKaikuEntity current) {
        RString before投票区コード;
        RString current投票区コード;

        if (before == null) {
            before投票区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getAfT112SenkyoninMeibEntity().getTohyokuCode() == null) {
            before投票区コード = RString.EMPTY;
        } else {
            RString 投票区コード = before.getAfT112SenkyoninMeibEntity().getTohyokuCode();
            before投票区コード = 投票区コード != null ? 投票区コード : RString.EMPTY;
        }

        if (current == null) {
            current投票区コード = RString.EMPTY;
        } else {
            RString 投票区コード = current.getAfT112SenkyoninMeibEntity().getTohyokuCode();
            current投票区コード = 投票区コード != null ? 投票区コード : RString.EMPTY;
        }
        if (!before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    private RString set集計地区名(MeiboSakuseiKaikuEntity entity, RString 帳票出力順) {

        if (出力順_住所コード.equals(帳票出力順)) {
            ChoikiCode 住登内町域コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            RString 住登内住所 = entity.getUaFt200Entity().getJutonaiJusho();
            if (住登内町域コード != null) {
                集計地区名 = 住登内町域コード.value().concat(住登内住所);
            }
        } else if (出力順_行政区コード.equals(帳票出力順)) {
            GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
            RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
            if (行政区コード != null) {
                集計地区名 = 行政区コード.value().concat(行政区名);
            }
        } else if (出力順_地区コード1.equals(帳票出力順)) {
            ChikuCode 地区コード1 = entity.getUaFt200Entity().getChikuCode1();
            RString 地区名1 = entity.getUaFt200Entity().getChikuName1();
            if (地区コード1 != null) {
                集計地区名 = 地区コード1.value().concat(地区名1);
            }
        } else if (出力順_地区コード2.equals(帳票出力順)) {
            ChikuCode 地区コード2 = entity.getUaFt200Entity().getChikuCode2();
            RString 地区名2 = entity.getUaFt200Entity().getChikuName2();
            if (地区コード2 != null) {
                集計地区名 = 地区コード2.value().concat(地区名2);
            }
        } else if (出力順_地区コード3.equals(帳票出力順)) {
            ChikuCode 地区コード3 = entity.getUaFt200Entity().getChikuCode3();
            RString 地区名3 = entity.getUaFt200Entity().getChikuName3();
            if (地区コード3 != null) {
                集計地区名 = 地区コード3.value().concat(地区名3);
            }
        } else {
            GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
            RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
            if (行政区コード != null) {
                集計地区名 = 行政区コード.value().concat(行政区名);
            }
        }

        return 集計地区名;
    }

    private RString get明細タイトル住所(RString 帳票出力順) {
        if (出力順_住所コード.equals(帳票出力順)) {
            return 明細タイトル住所_住所;
        } else if (出力順_行政区コード.equals(帳票出力順)) {
            return 明細タイトル住所_行政区;
        } else if (出力順_地区コード1.equals(帳票出力順)) {
            return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
        } else if (出力順_地区コード2.equals(帳票出力順)) {
            return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系);
        } else if (出力順_地区コード3.equals(帳票出力順)) {
            return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系);
        } else {
            return 明細タイトル住所_行政区;
        }
    }

    private void set表示者集計項目(MeiboSakuseiKaikuEntity entity) {
        boolean is表示者 = is表示者(entity);
        RString 性別コード = entity.getUaFt200Entity().getSeibetsuCode();
        if (性別コード != null && is表示者 && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
            表示者男集計++;
            表示者男総集計++;
            最後表示者男集計++;
        }
        if (性別コード != null && is表示者 && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
            表示者女集計++;
            表示者女総集計++;
            最後表示者女集計++;
        }

    }

    private void set公民権停止者集計項目(MeiboSakuseiKaikuEntity entity) {
        boolean is公民権停止者 = is公民権停止者(entity);
        RString 性別コード = entity.getUaFt200Entity().getSeibetsuCode();
        if (性別コード != null && is公民権停止者 && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
            公民権停止者男集計++;
            公民権停止者男総集計++;
            最後公民権停止者男集計++;
        }
        if (性別コード != null && is公民権停止者 && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
            公民権停止者女集計++;
            公民権停止者女総集計++;
            最後公民権停止者女集計++;

        }

    }

    private void set有権者集計項目(MeiboSakuseiKaikuEntity entity) {
        boolean is有権者 = is有権者(entity);
        RString 性別コード = entity.getUaFt200Entity().getSeibetsuCode();
        if (性別コード != null && is有権者 && 性別コード.equals(MeiboKaikuEdited.性別_男.getKey())) {
            有権者男集計++;
            有権者男総集計++;
            最後有権者男集計++;
        }
        if (性別コード != null && is有権者 && 性別コード.equals(MeiboKaikuEdited.性別_女.getKey())) {
            有権者女集計++;
            有権者女総集計++;
            最後有権者女集計++;
        }

    }

    private boolean is有権者(MeiboSakuseiKaikuEntity entity) {
        FlexibleDate 転入期限日 = null;
        if (entity.getAfT111SenkyoEntity() != null) {
            転入期限日 = entity.getAfT111SenkyoEntity().getTennyuKigenYMD();
        }
        FlexibleDate 投票日 = null;
        if (entity.getAfT100Entity() != null) {
            投票日 = entity.getAfT100Entity().getTohyoYMD();
        }
        boolean is有権者 = shikakuHantei.is有権者(entity.getUaFt200Entity(), 転入期限日,
                processParameter.get年齢到達日(), 投票日, SenkyoShurui.海区漁業調整委員会委員選挙);

        return is有権者;

    }

    private boolean is表示者(MeiboSakuseiKaikuEntity entity) {
        FlexibleDate 転出期限日 = null;
        if (entity.getAfT111SenkyoEntity() != null) {
            転出期限日 = entity.getAfT111SenkyoEntity().getTenshutsuKigenYMD();
        }
        FlexibleDate 投票日 = null;
        if (entity.getAfT100Entity() != null) {
            投票日 = entity.getAfT100Entity().getTohyoYMD();
        }
        boolean is表示者 = shikakuHantei.is表示者(entity.getUaFt200Entity(), 転出期限日, processParameter.get年齢到達日(),
                投票日, null, SenkyoShurui.海区漁業調整委員会委員選挙);

        return is表示者;
    }

    private boolean is公民権停止者(MeiboSakuseiKaikuEntity entity) {
        boolean is公民権停止者 = shikakuHantei.is公民権停止者(entity.getUaFt200Entity(), entity.getAfT113Entity(),
                processParameter.get年齢到達日(), processParameter.get時点日());
        return is公民権停止者;
    }

    private void set投票区コードの集計() {
        集計地区名 = 印字文字_1;
        投票区合計情報.set有権者_女数(new Decimal(有権者女総集計));
        投票区合計情報.set有権者_男数(new Decimal(有権者男総集計));
        投票区合計情報.set公民権停止者_男数(new Decimal(公民権停止者男総集計));
        投票区合計情報.set公民権停止者_女数(new Decimal(公民権停止者女総集計));
        投票区合計情報.set表示者_女数(new Decimal(表示者男総集計));
        投票区合計情報.set表示者_男数(new Decimal(表示者女総集計));
    }

    private void set集計項目() {
        合計情報.set有権者_女数(new Decimal(有権者女集計));
        合計情報.set有権者_男数(new Decimal(有権者男集計));
        合計情報.set公民権停止者_男数(new Decimal(公民権停止者男集計));
        合計情報.set公民権停止者_女数(new Decimal(公民権停止者女集計));
        合計情報.set表示者_女数(new Decimal(表示者女集計));
        合計情報.set表示者_男数(new Decimal(表示者男集計));
    }

    private void set総集計項目() {
        合計情報.set有権者_女数(new Decimal(最後有権者女集計));
        合計情報.set有権者_男数(new Decimal(最後有権者男集計));
        合計情報.set公民権停止者_男数(new Decimal(最後公民権停止者男集計));
        合計情報.set公民権停止者_女数(new Decimal(最後公民権停止者女集計));
        合計情報.set表示者_女数(new Decimal(最後表示者女集計));
        合計情報.set表示者_男数(new Decimal(最後表示者男集計));
    }

    private TorokushasuListParam set登録者数リスト情報(MeiboSakuseiKaikuEntity entity) {

        登録者数リスト情報.set有権者_女数(new Decimal(有権者女総集計));
        登録者数リスト情報.set有権者_男数(new Decimal(有権者男総集計));
        登録者数リスト情報.set公民権停止者_男数(new Decimal(公民権停止者男総集計));
        登録者数リスト情報.set公民権停止者_女数(new Decimal(公民権停止者女総集計));
        登録者数リスト情報.set表示者_女数(new Decimal(表示者女総集計));
        登録者数リスト情報.set表示者_男数(new Decimal(表示者男総集計));

        if (entity.getUaFt200Entity() != null) {
            登録者数リスト情報.set投票区コード(entity.getAfT112SenkyoninMeibEntity().getTohyokuCode());
        }
        if (entity.getAfT501TohyokuEntity() != null) {
            登録者数リスト情報.set集計地区名(entity.getAfT501TohyokuEntity().getTohyokuName());
        }

        return 登録者数リスト情報;

    }

    private TeijiCommonJohoItem set帳票共通() {
        帳票共通ヘッダー.set帳票ID(帳票ID);
        帳票共通ヘッダー.set帳票タイトル(ReportIdKeys.AFAPRA103_登録者数リスト海区選挙.getReportName());
        RString 明細タイトル = get明細タイトル住所(帳票出力順);

        帳票共通ヘッダー.set作成条件(new RString("ソート順：投票区コード＞").concat(明細タイトル)
                .concat("　　　改頁：なし"));
        帳票共通ヘッダー.set出力順(帳票出力順);

        return 帳票共通ヘッダー;
    }

    private TorokushasuListKaikuParentParam set登録者情報(MeiboSakuseiKaikuEntity entity, RString 帳票出力順) {
        TorokushasuListKaikuParentParam 海区選挙登録者情報 = new TorokushasuListKaikuParentParam();
        明細タイトル住所 = get明細タイトル住所(帳票出力順);
        海区選挙登録者情報.set明細タイトル住所(明細タイトル住所);
        海区選挙登録者情報.set基準日(new RDate(processParameter.get基準日().toString()));
        海区選挙登録者情報.set合計タイプ(new RString("登録者_1"));
        集計地区名 = set集計地区名(entity, 帳票出力順);
        海区選挙登録者情報.set集計地区名(集計地区名);
        海区選挙登録者情報.set投票区コード(entity.getAfT112SenkyoninMeibEntity().getTohyokuCode());

        return 海区選挙登録者情報;
    }

}
