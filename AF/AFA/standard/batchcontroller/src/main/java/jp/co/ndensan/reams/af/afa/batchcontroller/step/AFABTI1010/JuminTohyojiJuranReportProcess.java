/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminJouhou;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminJouhouShuukei;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRI100.MeiboShohonJuminPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRI100.MeiboShohonJuminReport;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiSelectMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyoji.JuminTohyojiEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住民投票時登録バッチ処理クラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiJuranReportProcess extends BatchKeyBreakBase<JuminTohyojiEntity> {

    private AFABTI101SelectProcessParameter selectProcessParameter;
    private JuminTohyojiSelectMybatisParameter selectMybatisParameter;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.jumintohyoji.IJuminTohyojiMapper.select住民投票資格者名簿抄本縦覧データ");

    private int itemCout;
    private int page;
    private int totalPage;
    private ShikakuHantei shikakuHantei;
    private int pageKeiMan;
    private int pageKeiWoman;
    private int pageKeiKei;

    private static final int 帳票最大行 = 25;

    private static final RString 性別_男 = new RString("1");
    private static final RString 性別_女 = new RString("2");
    private static final RString 印字文字_1 = new RString("『住所計』");
    private static final RString 印字文字_2 = new RString(" 『計』");
    private static final RString 印字文字_3 = new RString("『第』");
    private static final RString 印字文字_4 = new RString("『投票区計』");

    private RString 性別コード;

    private static final RString 集計キー住所コード = new RString("住所コード");
    private static final RString 集計キー行政区コード = new RString("行政区コード");
    private static final RString 集計キー地区コード１ = new RString("地区コード１");
    private static final RString 集計キー地区コード２ = new RString("地区コード２");
    private static final RString 集計キー地区コード３ = new RString("地区コード３");
    private static final RString 集計キー投票区コード = new RString("投票区コード");

    private MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報;
    private MeiboShohonJuminJouhouShuukei 住民投票資格者名簿抄本情報集計;

    private RString 集計タイトル1;
    private int 集計男1;
    private int 集計女1;
    private int 総合計1;
    private RString key1;

    private RString 集計タイトル2;
    private int 集計男2;
    private int 集計女2;
    private int 総合計2;
    private RString key2;

    private RString 集計タイトル3;
    private int 集計男3;
    private int 集計女3;
    private int 総合計3;
    private RString key3;

    private RString 集計タイトル4;
    private int 集計男4;
    private int 集計女4;
    private int 総合計4;
    private RString key4;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;

    private List<RString> 集計項目キーリスト = new ArrayList<>();

    private RString 取扱注意者の出力方式;
    private RString コンフィグ住基連動;

    private MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報_new;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象_new;
    private AfT113SenkyoShikakuEntity 選挙資格_new;
    private Association 地方公共団体情報_new;

    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonJuminSource> 住民投票資格者名簿抄本縦覧Writer;
    private ReportSourceWriter<MeiboShohonJuminSource> 住民投票資格者名簿抄本縦覧SourceWriter;

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

        selectMybatisParameter = selectProcessParameter.toJuminTohyojiSelectMybatisParameter();
        pageCount = new OutputParameter<>();
        page = 1;
        itemCout = 1;
        totalPage = 1;
        pageKeiMan = 0;
        pageKeiWoman = 0;
        pageKeiKei = 0;
        集計タイトル1 = RString.EMPTY;
        集計男1 = 0;
        集計女1 = 0;
        総合計1 = 0;
        key1 = RString.EMPTY;

        集計タイトル2 = RString.EMPTY;
        集計男2 = 0;
        集計女2 = 0;
        総合計2 = 0;
        key2 = RString.EMPTY;

        集計タイトル3 = RString.EMPTY;
        集計男3 = 0;
        集計女3 = 0;
        総合計3 = 0;
        key3 = RString.EMPTY;

        集計タイトル4 = RString.EMPTY;
        集計男4 = 0;
        集計女4 = 0;
        総合計4 = 0;
        key4 = RString.EMPTY;

        集計項目キーリスト = selectProcessParameter.get集計項目IDリスト();

        shikakuHantei = new ShikakuHantei();

        取扱注意者の出力方式 = BusinessConfig.get(
                ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, SubGyomuCode.AFA選挙本体);

        コンフィグ住基連動 = BusinessConfig.get(
                ConfigKeysAFA.抄本_住基連動_氏名, SubGyomuCode.AFA選挙本体);
        RDateTime 基準日 = RDateTime.of(selectProcessParameter.get年齢計算基準日().getYearValue(),
                selectProcessParameter.get年齢計算基準日().getMonthValue(),
                selectProcessParameter.get年齢計算基準日().getDayValue(), 01, 01);
        selectMybatisParameter.setコンフィグ住基連動(コンフィグ住基連動);
        selectMybatisParameter.set今回日時(基準日);
        selectMybatisParameter.set前回日時(基準日);
        selectMybatisParameter.set利用区分(OutputKeys.利用区分.getValue());
        selectMybatisParameter.set抽出区分(OutputKeys.抽出区分.getValue());
        selectMybatisParameter.set注意種類コード(OutputKeys.注意種類コード.getValue());
        selectMybatisParameter.set有効期限(OutputKeys.有効期限.getValue());

        住民投票資格者名簿抄本情報集計 = new MeiboShohonJuminJouhouShuukei();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, selectMybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        住民投票資格者名簿抄本縦覧SourceWriter = new ReportSourceWriter<>(住民投票資格者名簿抄本縦覧Writer);
    }

    @Override
    protected void usualProcess(JuminTohyojiEntity entity) {

        setページ計(entity);
        if (集計項目キーリスト.size() >= INT_1) {
            set集計項目キー1(INT_0, entity);
        }
        if (集計項目キーリスト.size() >= INT_2) {
            set集計項目キー2(INT_1, entity);
        }

        if (集計項目キーリスト.size() >= INT_3) {
            set集計項目キー3(INT_2, entity);
        }
        if (集計項目キーリスト.size() >= INT_4) {
            set集計項目キー4(INT_3, entity);
        }

        住民投票資格者名簿抄本情報_new = set住民投票資格者名簿抄本情報(entity);
        宛名識別対象_new = entity.getUaFt200Entity();
        選挙資格_new = entity.getAfT113Entity();
        地方公共団体情報_new = get地方公共団体(entity);

    }

    @Override
    protected void keyBreakProcess(JuminTohyojiEntity entity) {

        住民投票資格者名簿抄本情報集計 = new MeiboShohonJuminJouhouShuukei();
        set住民投票資格者名簿抄本情報ページ集計();
        住民投票資格者名簿抄本情報 = set住民投票資格者名簿抄本情報(getBefore());
        住民投票資格者名簿抄本情報.setページ(page);
        住民投票資格者名簿抄本情報.setTotalPage(new RString(String.valueOf(totalPage)));

        boolean isKey1Break = false;
        boolean isKey2Break = false;
        boolean isKey3Break = false;
        boolean isKey4Break = false;
        if (集計項目キーリスト.size() >= INT_1) {
            isKey1Break = is集計項目キー1Break(INT_0, entity);
        }
        if (集計項目キーリスト.size() >= INT_2) {
            isKey2Break = is集計項目キー2Break(INT_1, entity);
        }
        if (集計項目キーリスト.size() >= INT_3) {
            isKey3Break = is集計項目キー3Break(INT_2, entity);
        }
        if (集計項目キーリスト.size() >= INT_4) {
            isKey4Break = is集計項目キー4Break(INT_3, entity);
        }

        boolean is最大印字行Break = false;

        int 最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        if (itemCout == (最大印字行 > 帳票最大行 ? 帳票最大行 : 最大印字行)) {
            is最大印字行Break = true;
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
        }
        itemCout++;

        if (isKey1Break || isKey2Break || isKey3Break || isKey4Break || is最大印字行Break) {
            totalPage++;
            if (hasBreakBy投票区(getBefore(), entity)) {
                page = 1;
            } else {
                page++;
            }
        }

        int flag = 取扱い注意者判断(getBefore());
        if (flag == 1) {
            return;
        }

        if (flag == INT_2) {
            住民投票資格者名簿抄本情報.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            MeiboShohonJuminParam param空白縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(), get地方公共団体(getBefore()));

            MeiboShohonJuminReport report空白縦覧 = new MeiboShohonJuminReport(param空白縦覧);
            report空白縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);
        }
        if (flag == INT_3) {
            住民投票資格者名簿抄本情報.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            MeiboShohonJuminParam param縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(), get地方公共団体(getBefore()));

            MeiboShohonJuminReport report縦覧 = new MeiboShohonJuminReport(param縦覧);
            report縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);

        }
        if (flag == INT_4) {
            住民投票資格者名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            MeiboShohonJuminParam param縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報, new MeiboShohonJuminJouhouShuukei(),
                    getBefore().getUaFt200Entity(), getBefore().getAfT113Entity(), get地方公共団体(getBefore()));

            MeiboShohonJuminReport report縦覧 = new MeiboShohonJuminReport(param縦覧);
            report縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        set住民投票資格者名簿抄本情報ページ集計();
        if (集計項目キーリスト.size() >= INT_1) {
            set住民投票資格者名簿抄本情報集計1();
        }
        if (集計項目キーリスト.size() >= INT_2) {
            set住民投票資格者名簿抄本情報集計2();
        }

        if (集計項目キーリスト.size() >= INT_3) {
            set住民投票資格者名簿抄本情報集計3();
        }
        if (集計項目キーリスト.size() >= INT_4) {
            set住民投票資格者名簿抄本情報集計4();
        }

        int flag = 取扱い注意者判断(getBefore());

        if (flag == INT_2) {
            住民投票資格者名簿抄本情報_new.setページ(page);
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            住民投票資格者名簿抄本情報_new.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            MeiboShohonJuminParam param縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new);
            MeiboShohonJuminReport report縦覧 = new MeiboShohonJuminReport(param縦覧);
            report縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);
        }
        if (flag == INT_3) {
            住民投票資格者名簿抄本情報_new.setページ(page);
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            住民投票資格者名簿抄本情報_new.set帳票フラグ(flag);
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            MeiboShohonJuminParam param縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new);
            MeiboShohonJuminReport report縦覧 = new MeiboShohonJuminReport(param縦覧);
            report縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);
        }

        if (flag == INT_4) {
            住民投票資格者名簿抄本情報_new.setページ(page);
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            住民投票資格者名簿抄本情報_new.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.getReportName());
            住民投票資格者名簿抄本情報_new.setTotalPage((new RString(String.valueOf(totalPage))));
            MeiboShohonJuminParam param縦覧 = new MeiboShohonJuminParam(住民投票資格者名簿抄本情報_new, new MeiboShohonJuminJouhouShuukei(),
                    宛名識別対象_new, 選挙資格_new, 地方公共団体情報_new);
            MeiboShohonJuminReport report縦覧 = new MeiboShohonJuminReport(param縦覧);
            report縦覧.writeBy(住民投票資格者名簿抄本縦覧SourceWriter);
        }

        pageCount.setValue(住民投票資格者名簿抄本縦覧Writer.getPageCount());
    }

    private int 取扱い注意者判断(JuminTohyojiEntity entity) {
        int flag = INT_4;
        UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity = entity.getFindeCautionShaMapperEntity();
        if (findeCautionShaMapperEntity != null && findeCautionShaMapperEntity.isGaitoKubun()) {
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める.getValue().equals(取扱注意者の出力方式)) {
                flag = INT_1;
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を空白.getValue().equals(取扱注意者の出力方式)) {
                flag = INT_2;
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク.getValue().equals(取扱注意者の出力方式)) {
                flag = INT_3;
            }
        } else {
            flag = INT_4;
        }
        return flag;
    }

    private Boolean hasBreak住所コード(JuminTohyojiEntity before, JuminTohyojiEntity current) {

        RString before住所コード;
        RString current住所コード;

        if (before == null) {
            before住所コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getChoikiCode() == null) {
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

    private Boolean hasBreak行政区コード(JuminTohyojiEntity before, JuminTohyojiEntity current) {
        RString before行政区コード;
        RString current行政区コード;

        if (before == null) {
            before行政区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getGyoseikuCode() == null) {
            before行政区コード = RString.EMPTY;
        } else {
            GyoseikuCode 行政区コード = before.getUaFt200Entity().getGyoseikuCode();
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

    private Boolean hasBreak地区コード１(JuminTohyojiEntity before, JuminTohyojiEntity current) {
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

    private Boolean hasBreak地区コード２(JuminTohyojiEntity before, JuminTohyojiEntity current) {
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

    private Boolean hasBreak地区コード３(JuminTohyojiEntity before, JuminTohyojiEntity current) {
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

    private Boolean hasBreakBy投票区(JuminTohyojiEntity before, JuminTohyojiEntity current) {
        RString before投票区コード;
        RString current投票区コード;

        if (before == null) {
            before投票区コード = RString.EMPTY;
        } else if (before.getUaFt200Entity() != null && before.getUaFt200Entity().getTohyokuCode() == null) {
            before投票区コード = RString.EMPTY;
        } else {
            TohyokuCode 投票区コード = before.getUaFt200Entity().getTohyokuCode();
            before投票区コード = 投票区コード != null ? 投票区コード.value() : RString.EMPTY;
        }

        if (current == null) {
            current投票区コード = RString.EMPTY;
        } else {
            TohyokuCode 投票区コード = current.getUaFt200Entity().getTohyokuCode();
            current投票区コード = 投票区コード != null ? 投票区コード.value() : RString.EMPTY;
        }
        if (!before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private boolean is集計項目キー1Break(int i, JuminTohyojiEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;

            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード１)) && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;

        }

        if ((集計項目キーリスト.get(i)
                .equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計1();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return true;
        }

        return false;

    }

    private boolean is集計項目キー2Break(int i, JuminTohyojiEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計2();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return true;

        }

        return false;

    }

    private boolean is集計項目キー3Break(int i, JuminTohyojiEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計3();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return true;

        }

        return false;

    }

    private boolean is集計項目キー4Break(int i, JuminTohyojiEntity entity) {

        if ((集計項目キーリスト.get(i).equals(集計キー住所コード))
                && (itemCout != 0 && hasBreak住所コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;

            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー行政区コード))
                && (itemCout != 0 && hasBreak行政区コード(getBefore(), entity))) {

            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード１))
                && (itemCout != 0 && hasBreak地区コード１(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード２))
                && (itemCout != 0 && hasBreak地区コード２(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー地区コード３))
                && (itemCout != 0 && hasBreak地区コード３(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }
        if ((集計項目キーリスト.get(i).equals(集計キー投票区コード))
                && (itemCout != 0 && hasBreakBy投票区(getBefore(), entity))) {
            set住民投票資格者名簿抄本情報集計4();
            itemCout = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return true;

        }

        return false;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー1(int i, JuminTohyojiEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル1 = 印字文字_1;
            get集計キー1(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key1 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル1 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_2);
                key1 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル1 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_2);
                key1 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル1 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_2);
                key1 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル1 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_2);
                key1 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー1(entity);
            if (entity.getUaFt200Entity() != null) {
                TohyokuCode 投票区コード = entity.getUaFt200Entity().getTohyokuCode();
                set集計タイトル1andkey1By投票区コード(投票区コード);
            }
        }

    }

    private void set集計タイトル1andkey1By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル1 = 印字文字_3.concat(投票区コード.value()).concat(印字文字_4);
            key1 = 投票区コード.value();
        }
    }

    private void get集計キー1(JuminTohyojiEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(性別_男)) {
                集計男1++;
            } else if (性別コード != null && 性別コード.equals(性別_女)) {
                集計女1++;
            }
            総合計1++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー2(int i, JuminTohyojiEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル2 = 印字文字_1;
            get集計キー2(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (住所コード != null) {
                key2 = 住所コード.value();
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル2 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_2);
                key2 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル2 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_2);
                key2 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル2 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_2);
                key2 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル2 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_2);
                key2 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }

        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー2(entity);
            if (entity.getUaFt200Entity() != null) {
                TohyokuCode 投票区コード = entity.getUaFt200Entity().getTohyokuCode();
                set集計タイトル2andkey2By投票区コード(投票区コード);
            }
        }

    }

    private void set集計タイトル2andkey2By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル2 = 印字文字_3.concat(投票区コード.value()).concat(印字文字_4);
            key2 = 投票区コード.value();
        }
    }

    private void get集計キー2(JuminTohyojiEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(性別_男)) {
                集計男2++;
            } else if (entity.getUaFt200Entity() != null && 性別コード != null && 性別コード.equals(性別_女)) {
                集計女2++;
            }
            総合計2++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー3(int i, JuminTohyojiEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル3 = 印字文字_1;
            get集計キー3(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key3 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {
            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル3 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_2);
                key3 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {

            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル3 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_2);
                key3 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {

            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル3 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_2);
                key3 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {

            get集計キー3(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル3 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_2);
                key3 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー3(entity);

            if (entity.getUaFt200Entity() != null) {
                TohyokuCode 投票区コード = entity.getUaFt200Entity().getTohyokuCode();
                set集計タイトル3andkey3By投票区コード(投票区コード);
            }
        }
    }

    private void set集計タイトル3andkey3By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル3 = 印字文字_3.concat(投票区コード.value()).concat(印字文字_4);
            key3 = 投票区コード.value();
        }
    }

    private void get集計キー3(JuminTohyojiEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(性別_男)) {
                集計男3++;
            } else if (性別コード != null && 性別コード.equals(性別_女)) {
                集計女3++;
            }
            総合計3++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー4(int i, JuminTohyojiEntity entity) {

        if (集計項目キーリスト.get(i).equals(集計キー住所コード)) {
            集計タイトル4 = 印字文字_1;
            get集計キー4(entity);
            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (entity.getUaFt200Entity() != null && 住所コード != null) {
                key4 = 住所コード.value();
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー行政区コード)) {

            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
                RString 行政区名 = entity.getUaFt200Entity().getGyoseikuName();
                集計タイトル4 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(印字文字_2);
                key4 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード１)) {

            get集計キー4(entity);

            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
                RString 地区名１ = entity.getUaFt200Entity().getChikuName1();
                集計タイトル4 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(印字文字_2);
                key4 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード２)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
                RString 地区名２ = entity.getUaFt200Entity().getChikuName2();
                集計タイトル4 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(印字文字_2);
                key4 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー地区コード３)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
                RString 地区名３ = entity.getUaFt200Entity().getChikuName3();
                集計タイトル4 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(印字文字_2);
                key4 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
            }
        }
        if (集計項目キーリスト.get(i).equals(集計キー投票区コード)) {
            get集計キー4(entity);
            if (entity.getUaFt200Entity() != null) {
                TohyokuCode 投票区コード = entity.getUaFt200Entity().getTohyokuCode();
                set集計タイトル4andkey4By投票区コード(投票区コード);
            }
        }
    }

    private void set集計タイトル4andkey4By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル4 = 印字文字_3.concat(投票区コード.value()).concat(印字文字_4);
            key4 = 投票区コード.value();
        }
    }

    private void get集計キー4(JuminTohyojiEntity entity) {

        if (entity != null && entity.getUaFt200Entity() != null) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(性別_男)) {
                集計男4++;
            } else if (性別コード != null && 性別コード.equals(性別_女)) {
                集計女4++;
            }
            総合計4++;
        }
    }

    private void setページ計(JuminTohyojiEntity entity) {

        Code masshoJiyuCode = entity.getAfT113Entity().getMasshoJiyuCode();
        if ((masshoJiyuCode == null
                || masshoJiyuCode.isEmpty())
                && (!shikakuHantei.is公民権停止者(entity.getUaFt200Entity(), entity.getAfT113Entity(),
                        selectProcessParameter.get年齢計算基準日(), FlexibleDate.getNowDate()))) {
            性別コード = entity.getUaFt200Entity().getSeibetsuCode();
            if (entity.getUaFt200Entity() != null && 性別コード != null && 性別コード.equals(性別_男)) {
                pageKeiMan++;
            } else if (entity.getUaFt200Entity() != null && 性別コード != null && 性別コード.equals(性別_女)) {
                pageKeiWoman++;
            }
            pageKeiKei++;
        }

    }

    private void set住民投票資格者名簿抄本情報ページ集計() {
        住民投票資格者名簿抄本情報集計.setPageKeiKei(new RString(String.valueOf(pageKeiKei)));
        住民投票資格者名簿抄本情報集計.setPageKeiWoman(new RString(String.valueOf(pageKeiWoman)));
        住民投票資格者名簿抄本情報集計.setPageKeiMan(new RString(String.valueOf(pageKeiMan)));
    }

    private void set住民投票資格者名簿抄本情報集計1() {
        住民投票資格者名簿抄本情報集計.setKei1Man(new RString(String.valueOf(集計男1)));
        住民投票資格者名簿抄本情報集計.setKei1Woman(new RString(String.valueOf(集計女1)));
        住民投票資格者名簿抄本情報集計.setKei1Title(new RString(String.valueOf(集計タイトル1)));
        住民投票資格者名簿抄本情報集計.setKei1Kei(new RString(String.valueOf(総合計1)));
    }

    private void set住民投票資格者名簿抄本情報集計2() {
        住民投票資格者名簿抄本情報集計.setKei2Man(new RString(String.valueOf(集計男2)));
        住民投票資格者名簿抄本情報集計.setKei2Woman(new RString(String.valueOf(集計女2)));
        住民投票資格者名簿抄本情報集計.setKei2Title(new RString(String.valueOf(集計タイトル2)));
        住民投票資格者名簿抄本情報集計.setKei2Kei(new RString(String.valueOf(総合計2)));
    }

    private void set住民投票資格者名簿抄本情報集計3() {
        住民投票資格者名簿抄本情報集計.setKei3Man(new RString(String.valueOf(集計男3)));
        住民投票資格者名簿抄本情報集計.setKei3Woman(new RString(String.valueOf(集計女3)));
        住民投票資格者名簿抄本情報集計.setKei3Title(new RString(String.valueOf(集計タイトル3)));
        住民投票資格者名簿抄本情報集計.setKei3Kei(new RString(String.valueOf(総合計3)));
    }

    private void set住民投票資格者名簿抄本情報集計4() {
        住民投票資格者名簿抄本情報集計.setKei4Man(new RString(String.valueOf(集計男4)));
        住民投票資格者名簿抄本情報集計.setKei4Woman(new RString(String.valueOf(集計女4)));
        住民投票資格者名簿抄本情報集計.setKei4Title(new RString(String.valueOf(集計タイトル4)));
        住民投票資格者名簿抄本情報集計.setKei4Kei(new RString(String.valueOf(総合計4)));
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private MeiboShohonJuminJouhou set住民投票資格者名簿抄本情報(JuminTohyojiEntity entity) {

        MeiboShohonJuminJouhou 名簿抄本情報 = new MeiboShohonJuminJouhou();
        if (entity != null && entity.getUaFt200Entity() != null && entity.getAfT113Entity() != null && entity.getAfT100Entity() != null) {
            Code 抹消事由コード = entity.getAfT113Entity().getMasshoJiyuCode();
            if (抹消事由コード != null) {
                名簿抄本情報.set抹消事由コード(抹消事由コード.value());
            }
            名簿抄本情報.set抄本名(entity.getAfT100Entity().getShohonName());
            FlexibleDate 投票年月日 = entity.getAfT100Entity().getTohyoYMD();
            if (投票年月日 != null) {
                名簿抄本情報.set投票年月日(new RString(投票年月日.toString()));
            }
            FlexibleDate 規定年齢到達年月日 = entity.getAfT100Entity().getKiteiNenreiTotatsuYMD();
            if (規定年齢到達年月日 != null) {
                名簿抄本情報.set規定年齢到達年月日(規定年齢到達年月日);
            }
            名簿抄本情報.set投票区名(entity.getUaFt200Entity().getTohyokuName());

            TohyokuCode 投票区コード = entity.getUaFt200Entity().getTohyokuCode();
            if (投票区コード != null) {
                名簿抄本情報.set投票区コード(投票区コード.value());
            }

            名簿抄本情報.set性別コード(entity.getUaFt200Entity().getSeibetsuCode());
            名簿抄本情報.set帳票タイトル(ReportIdKeys.AFAPRI100_住民投票時登録.getReportName());
            名簿抄本情報.set住登内住所(entity.getUaFt200Entity().getJutonaiJusho());
            AtenaBanchi 住登内番地 = entity.getUaFt200Entity().getJutonaiBanchi();
            if (住登内番地 != null) {
                名簿抄本情報.set住登内番地(住登内番地.value());
            }

            Katagaki 住登内方書 = entity.getUaFt200Entity().getJutonaiKatagaki();
            if (住登内方書 != null) {
                名簿抄本情報.set住登内方書(住登内方書.value());
            }
            FlexibleDate 生年月日 = entity.getUaFt200Entity().getSeinengappiYMD();
            if (生年月日 != null) {
                名簿抄本情報.set生年月日(new RString(生年月日.toString()));
            }
            AtenaMeisho 名称 = entity.getUaFt200Entity().getMeisho();
            if (名称 != null) {
                名簿抄本情報.set名称(名称.value());
            }
            ShikibetsuCode 識別コード = entity.getUaFt200Entity().getShikibetsuCode();
            if (識別コード != null) {
                名簿抄本情報.set識別コード(識別コード.value());
            }

            AtenaKanaMeisho カナ名称 = entity.getUaFt200Entity().getKanaShimei();

            if (カナ名称 != null) {
                名簿抄本情報.setカナ名称(カナ名称.value());
            }

            ChoikiCode 住所コード = entity.getUaFt200Entity().getJutonaiChoikiCode();
            if (住所コード != null) {
                名簿抄本情報.set町域コード(住所コード.value());
            }

            GyoseikuCode 行政区コード = entity.getUaFt200Entity().getGyoseikuCode();
            if (行政区コード != null) {
                名簿抄本情報.set行政区コード(行政区コード.value());
            }
            名簿抄本情報.set行政区コード(entity.getUaFt200Entity().getGyoseikuName());

            ChikuCode 地区コード１ = entity.getUaFt200Entity().getChikuCode1();
            if (地区コード１ != null) {
                名簿抄本情報.set地区コード１(地区コード１.value());
            }
            名簿抄本情報.set地区名１(entity.getUaFt200Entity().getChikuName1());

            ChikuCode 地区コード２ = entity.getUaFt200Entity().getChikuCode2();
            if (地区コード２ != null) {
                名簿抄本情報.set地区コード２(地区コード２.value());
            }
            名簿抄本情報.set地区名２(entity.getUaFt200Entity().getChikuName2());

            ChikuCode 地区コード３ = entity.getUaFt200Entity().getChikuCode3();
            if (地区コード３ != null) {
                名簿抄本情報.set地区コード３(地区コード３.value());
            }
            名簿抄本情報.set地区名３(entity.getUaFt200Entity().getChikuName3());

        }

        名簿抄本情報.setKey1(key1);
        名簿抄本情報.setKey2(key2);
        名簿抄本情報.setKey3(key3);
        名簿抄本情報.setKey4(key4);

        return 名簿抄本情報;
    }

    private Association get地方公共団体(JuminTohyojiEntity entity) {
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association;
        LasdecCode 現全国地方公共団体コード = entity.getUaFt200Entity().getGenLasdecCode();
        if (null == 現全国地方公共団体コード || 現全国地方公共団体コード.isEmpty()) {
            association = null;
        } else {
            association = associationFinder.getAssociation(現全国地方公共団体コード);
        }
        return association;

    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                JuminTohyojiJuranReportProcess.特定項目.class,
                JuminTohyojiJuranReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        住民投票資格者名簿抄本縦覧Writer = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonJuminSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRI100_住民投票資格者名簿抄本_縦覧.value())
                .addBreak(new MeiboShohonJuminPageBreak())
                .build();
    }

    private enum 特定項目 implements ISpecificKey {

        識別コード("shikibetsuCode", "識別コード");

        private final RString itemName;
        private final RString printName;

        private 特定項目(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目 implements ICheckTarget {

        target1("listShimei_1", "氏名", CheckShubetsu.文字切れ),
        target2("listJusho_1", "住所", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

}
