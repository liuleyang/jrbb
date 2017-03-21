/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminJouhouShuukei;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonZaisankuParam;
import jp.co.ndensan.reams.af.afa.business.core.ShohonZaisankuMeiboJoho;
import jp.co.ndensan.reams.af.afa.business.core.senkyojizaisanku.SenkyojiZaisankuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRL100.MeiboShohonZaisankuReport;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.SenkyojiZaisankuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
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
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 財産区議会議員選挙時登録の財産区選挙人名簿抄本のクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuReportProcess extends BatchKeyBreakBase<SenkyojiZaisankuEntity> {

    private int indexCount;
    private int 最大印字行;
    private int itemCount;
    private int page;
    private int totalPage;
    private ShikakuHantei shikakuHantei;
    private int pageKeiMan;
    private int pageKeiWoman;
    private int pageKeiKei;
    private RString 性別コード;

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

    private List<RString> 集計項目キーリスト = new ArrayList<>();
    private Association 地方公共団体情報;

    private ShohonZaisankuMeiboJoho 財産区選挙人名簿抄本情報;
    private MeiboShohonJuminJouhouShuukei 財産区選挙人名簿抄本情報集計;
    private SenkyojiZaisankuEditor senkyojiZaisankuEditor;

    private AFABTL101SelectProcessParameter parameter;
    private AFABTL101SelectProcessMyBatisParameter mybatisparameter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyojizaisanku.ISenkyojiZaisankuMapper.select財産区選挙人名簿抄本縦覧情報");
    private static final List<RString> 財産区選挙人名簿抄本_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.key1.name()),
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.key2.name()),
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.key3.name()),
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.tohyokuCode.name()),
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.totalPage.name()),
                            new RString(MeiboShohonZaisankuSource.ReportSourceFields.key4.name())));

    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonZaisankuSource> 財産区選挙人名簿抄本Writer;
    private ReportSourceWriter<MeiboShohonZaisankuSource> 財産区選挙人名簿抄本SourceWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = SenkyojiZaisankuRStringEnum.ページコント.getKey();
    }
    OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        page = 1;
        itemCount = 1;
        totalPage = 1;
        indexCount = 0;
        pageKeiMan = 0;
        pageKeiWoman = 0;
        pageKeiKei = 0;

        集計男1 = 0;
        集計女1 = 0;
        総合計1 = 0;
        集計タイトル1 = RString.EMPTY;
        key1 = RString.EMPTY;

        集計男2 = 0;
        集計女2 = 0;
        総合計2 = 0;
        集計タイトル2 = RString.EMPTY;
        key2 = RString.EMPTY;

        集計男3 = 0;
        集計女3 = 0;
        総合計3 = 0;
        集計タイトル3 = RString.EMPTY;
        key3 = RString.EMPTY;

        集計男4 = 0;
        集計女4 = 0;
        総合計4 = 0;
        集計タイトル4 = RString.EMPTY;
        key4 = RString.EMPTY;
        最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        最大印字行 = 最大印字行 > SenkyojiZaisankuIntEnum.帳票最大行.getKey()
                ? SenkyojiZaisankuIntEnum.帳票最大行.getKey() : 最大印字行;
        mybatisparameter = parameter.toAFABTL101SelectProcessMyBatisParameter();
        mybatisparameter.setRiyoKubun(SenkyojiZaisankuRStringEnum.利用区分.getKey());
        mybatisparameter.setChushutsuKubun(SenkyojiZaisankuRStringEnum.抽出区分.getKey());
        FlexibleDate kijunbi = parameter.get基準日();
        RDateTime 基準日 = RDateTime.of(kijunbi.getYearValue(), kijunbi.getMonthValue(), kijunbi.getDayValue(), 01, 01);
        mybatisparameter.setKonkaiChushutsu(基準日);
        mybatisparameter.setZenkaiChushutsu(基準日);
        mybatisparameter.setChuiShuruiCode(SenkyojiZaisankuRStringEnum.注意種類コード.getKey());
        mybatisparameter.setYukoKigenKubun(SenkyojiZaisankuRStringEnum.有効期限.getKey());
        pageCount = new OutputParameter<>();
        集計項目キーリスト = parameter.get集計項目IDリスト();

        shikakuHantei = new ShikakuHantei();
        senkyojiZaisankuEditor = new SenkyojiZaisankuEditor();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create財産区選挙人名簿抄本文字切れ一覧表に出力Writer();
        財産区選挙人名簿抄本SourceWriter = new ReportSourceWriter<>(財産区選挙人名簿抄本Writer);
    }

    @Override
    protected void keyBreakProcess(SenkyojiZaisankuEntity entity) {
        Boolean isKey1Break = Boolean.FALSE;
        Boolean isKey2Break = Boolean.FALSE;
        Boolean isKey3Break = Boolean.FALSE;
        Boolean isKey4Break = Boolean.FALSE;
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_1.getKey()) {
            isKey1Break = is集計項目キー1Break(SenkyojiZaisankuIntEnum.INT_0.getKey(), entity, getBefore());
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_2.getKey()) {
            isKey2Break = is集計項目キー2Break(SenkyojiZaisankuIntEnum.INT_1.getKey(), entity, getBefore());
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_3.getKey()) {
            isKey3Break = is集計項目キー3Break(SenkyojiZaisankuIntEnum.INT_2.getKey(), entity, getBefore());
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_4.getKey()) {
            isKey4Break = is集計項目キー4Break(SenkyojiZaisankuIntEnum.INT_3.getKey(), entity, getBefore());
        }
        itemCount++;
        Boolean is最大印字行Break = Boolean.FALSE;
        if (itemCount == 最大印字行) {
            is最大印字行Break = Boolean.TRUE;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
        }

        if ((isKey1Break || isKey2Break || isKey3Break || isKey4Break || is最大印字行Break) && itemCount != 0) {
            totalPage++;
            if (senkyojiZaisankuEditor.hasBreakBy投票区(getBefore(), entity)) {
                page = 1;
            } else {
                page++;
            }
            itemCount = 0;
        }
    }

    @Override
    protected void usualProcess(SenkyojiZaisankuEntity entity) {
        indexCount++;
        if (indexCount == 1) {
            page = 1;
            totalPage = 1;
        }
        財産区選挙人名簿抄本情報集計 = new MeiboShohonJuminJouhouShuukei();
        setページ計(entity);
        set財産区選挙人名簿抄本情報ページ集計();
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_1.getKey()) {
            set集計項目キー1(SenkyojiZaisankuIntEnum.INT_0.getKey(), entity);
            set財産区選挙人名簿抄本情報集計1();
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_2.getKey()) {
            set集計項目キー2(SenkyojiZaisankuIntEnum.INT_1.getKey(), entity);
            set財産区選挙人名簿抄本情報集計2();
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_3.getKey()) {
            set集計項目キー3(SenkyojiZaisankuIntEnum.INT_2.getKey(), entity);
            set財産区選挙人名簿抄本情報集計3();
        }
        if (集計項目キーリスト.size() >= SenkyojiZaisankuIntEnum.INT_4.getKey()) {
            set集計項目キー4(SenkyojiZaisankuIntEnum.INT_3.getKey(), entity);
            set財産区選挙人名簿抄本情報集計4();
        }
        財産区選挙人名簿抄本情報 = set財産区選挙人名簿抄本情報(entity);
        財産区選挙人名簿抄本情報.setPage(page);
        財産区選挙人名簿抄本情報.setTotalPage(new RString(String.valueOf(totalPage)));
        SenkyoninTohyoJokyoEntity 選挙人資格情報 = new SenkyoninTohyoJokyoEntity();
        選挙人資格情報.setAtenaPSMEntity(entity.get宛名PSM情報());
        MeiboShohonZaisankuParam param = new MeiboShohonZaisankuParam(
                財産区選挙人名簿抄本情報,
                選挙人資格情報,
                財産区選挙人名簿抄本情報集計,
                地方公共団体情報,
                SenkyojiZaisankuRStringEnum.財産区抄本.getKey());
        param.setIs公民権停止者(shikakuHantei.is公民権停止者(entity.get宛名PSM情報(),
                entity.get選挙資格情報(),
                parameter.get年齢期限日(), parameter.get基準日()));
        MeiboShohonZaisankuReport report = new MeiboShohonZaisankuReport(param);
        report.writeBy(財産区選挙人名簿抄本SourceWriter);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(財産区選挙人名簿抄本Writer.getPageCount());
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is集計項目キー1Break(int index,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Current,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Before) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakByグループコード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakBy投票区(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak住所コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;

            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak行政区コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード１(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード２(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード３(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;

        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak冊(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計1();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル1 = RString.EMPTY;
            集計男1 = 0;
            集計女1 = 0;
            総合計1 = 0;
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is集計項目キー2Break(int index,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Current,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Before) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakByグループコード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakBy投票区(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak住所コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak行政区コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {

            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード１(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード２(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード３(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak冊(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計2();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル2 = RString.EMPTY;
            集計男2 = 0;
            集計女2 = 0;
            総合計2 = 0;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is集計項目キー3Break(int index,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Current,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Before) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakByグループコード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak住所コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {

            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak行政区コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード１(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード２(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード３(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakBy投票区(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak冊(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計3();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル3 = RString.EMPTY;
            集計男3 = 0;
            集計女3 = 0;
            総合計3 = 0;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is集計項目キー4Break(int index,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Current,
            SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報Before) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakByグループコード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreakBy投票区(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak住所コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak行政区コード(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {

            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード１(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード２(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak地区コード３(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0
                && senkyojiZaisankuEditor.hasBreak冊(財産区選挙人名簿抄本情報Before, 財産区選挙人名簿抄本情報Current))) {
            set財産区選挙人名簿抄本情報集計4();
            itemCount = 0;
            pageKeiMan = 0;
            pageKeiWoman = 0;
            pageKeiKei = 0;
            集計タイトル4 = RString.EMPTY;
            集計男4 = 0;
            集計女4 = 0;
            総合計4 = 0;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー1(int index, SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            集計タイトル1 = SenkyojiZaisankuRStringEnum.印字文字_合計.getKey();
            get集計キー1(財産区選挙人名簿抄本情報);
            RString グループコード = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getGroupCode();
            key1 = グループコード == null ? RString.EMPTY : グループコード;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー1(財産区選挙人名簿抄本情報);
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getTohyokuCode();
            set集計タイトル1andkey1By投票区コード(投票区コード);
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            集計タイトル1 = SenkyojiZaisankuRStringEnum.印字文字_1.getKey();
            get集計キー1(財産区選挙人名簿抄本情報);
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getJutonaiChoikiCode();
            key1 = 住所コード == null ? RString.EMPTY : 住所コード.value();
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー1(財産区選挙人名簿抄本情報);
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuCode();
            RString 行政区名 = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuName();
            集計タイトル1 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key1 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {

            get集計キー1(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode1();
            RString 地区名１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName1();
            集計タイトル1 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key1 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー1(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode2();
            RString 地区名２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName2();
            集計タイトル1 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key1 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー1(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode3();
            RString 地区名３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName3();
            集計タイトル1 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key1 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }

        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            get集計キー1(財産区選挙人名簿抄本情報);
            RString 冊 = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getSatsu();
            集計タイトル1 = SenkyojiZaisankuRStringEnum.印字文字_冊計.getKey();
            key1 = 冊 != null ? 冊 : RString.EMPTY;
        }
    }

    private void set集計タイトル1andkey1By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル1 = SenkyojiZaisankuRStringEnum.印字文字_3.getKey()
                    .concat(投票区コード.value())
                    .concat(SenkyojiZaisankuRStringEnum.印字文字_4.getKey());
            key1 = 投票区コード.value();
        }
    }

    private void get集計キー1(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (財産区選挙人名簿抄本情報 != null && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            性別コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(Gender.MALE.code())) {
                集計男1++;
            } else if (性別コード != null && 性別コード.equals(Gender.FEMALE.code())) {
                集計女1++;
            }
            総合計1++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー2(int index, SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            集計タイトル2 = SenkyojiZaisankuRStringEnum.印字文字_合計.getKey();
            get集計キー2(財産区選挙人名簿抄本情報);
            RString グループコード = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getGroupCode();
            key2 = グループコード == null ? RString.EMPTY : グループコード;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getTohyokuCode();
            set集計タイトル2andkey2By投票区コード(投票区コード);
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey())) {
            集計タイトル2 = SenkyojiZaisankuRStringEnum.印字文字_1.getKey();
            get集計キー2(財産区選挙人名簿抄本情報);
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getJutonaiChoikiCode();
            if (住所コード != null) {
                key2 = 住所コード.value();
            }

        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuCode();
            RString 行政区名 = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuName();
            集計タイトル2 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key2 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode1();
            RString 地区名１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName1();
            集計タイトル2 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key2 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode2();
            RString 地区名２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName2();
            集計タイトル2 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key2 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;

        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode3();
            RString 地区名３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName3();
            集計タイトル2 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key2 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            get集計キー2(財産区選挙人名簿抄本情報);
            RString 冊 = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getSatsu();
            集計タイトル2 = SenkyojiZaisankuRStringEnum.印字文字_冊計.getKey();
            key2 = 冊 != null ? 冊 : RString.EMPTY;
        }

    }

    private void set集計タイトル2andkey2By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル2 = SenkyojiZaisankuRStringEnum.印字文字_3.getKey()
                    .concat(投票区コード.value())
                    .concat(SenkyojiZaisankuRStringEnum.印字文字_4.getKey());
            key2 = 投票区コード.value();
        }
    }

    private void get集計キー2(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (財産区選挙人名簿抄本情報 != null && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            性別コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(Gender.MALE.code())) {
                集計男2++;
            } else if (財産区選挙人名簿抄本情報.get宛名PSM情報() != null
                    && 性別コード != null
                    && 性別コード.equals(Gender.FEMALE.code())) {
                集計女2++;
            }
            総合計2++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー3(int index, SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            集計タイトル3 = SenkyojiZaisankuRStringEnum.印字文字_合計.getKey();
            get集計キー3(財産区選挙人名簿抄本情報);
            RString グループコード = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getGroupCode();
            key3 = グループコード == null ? RString.EMPTY : グループコード;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getTohyokuCode();
            set集計タイトル3andkey3By投票区コード(投票区コード);
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            集計タイトル3 = SenkyojiZaisankuRStringEnum.印字文字_1.getKey();
            get集計キー3(財産区選挙人名簿抄本情報);
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getJutonaiChoikiCode();
            key3 = 住所コード == null ? RString.EMPTY : 住所コード.value();

        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuCode();
            RString 行政区名 = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuName();
            集計タイトル3 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key3 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode1();
            RString 地区名１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName1();
            集計タイトル3 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key3 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode2();
            RString 地区名２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName2();
            集計タイトル3 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key3 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode3();
            RString 地区名３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName3();
            集計タイトル3 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key3 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }

        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            get集計キー3(財産区選挙人名簿抄本情報);
            RString 冊 = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getSatsu();
            集計タイトル3 = SenkyojiZaisankuRStringEnum.印字文字_冊計.getKey();
            key3 = 冊 != null ? 冊 : RString.EMPTY;
        }
    }

    private void set集計タイトル3andkey3By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル3 = SenkyojiZaisankuRStringEnum.印字文字_3.getKey()
                    .concat(投票区コード.value()).concat(SenkyojiZaisankuRStringEnum.印字文字_4.getKey());
            key3 = 投票区コード.value();
        }
    }

    private void get集計キー3(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (財産区選挙人名簿抄本情報 != null && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            性別コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(Gender.MALE.code())) {
                集計男3++;
            } else if (性別コード != null && 性別コード.equals(Gender.FEMALE.code())) {
                集計女3++;
            }
            総合計3++;
        }
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void set集計項目キー4(int index, SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            集計タイトル4 = SenkyojiZaisankuRStringEnum.印字文字_合計.getKey();
            get集計キー4(財産区選挙人名簿抄本情報);
            RString グループコード = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getGroupCode();
            key4 = グループコード == null ? RString.EMPTY : グループコード;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            集計タイトル4 = SenkyojiZaisankuRStringEnum.印字文字_1.getKey();
            get集計キー4(財産区選挙人名簿抄本情報);
            ChoikiCode 住所コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getJutonaiChoikiCode();
            key4 = 住所コード == null ? RString.EMPTY : 住所コード.value();
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            GyoseikuCode 行政区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuCode();
            RString 行政区名 = 財産区選挙人名簿抄本情報.get宛名PSM情報().getGyoseikuName();
            集計タイトル4 = (行政区名 != null ? 行政区名 : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key4 = 行政区コード != null ? 行政区コード.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode1();
            RString 地区名１ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName1();
            集計タイトル4 = (地区名１ != null ? 地区名１ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key4 = 地区コード１ != null ? 地区コード１.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode2();
            RString 地区名２ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName2();
            集計タイトル4 = (地区名２ != null ? 地区名２ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key4 = 地区コード２ != null ? 地区コード２.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            ChikuCode 地区コード３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuCode3();
            RString 地区名３ = 財産区選挙人名簿抄本情報.get宛名PSM情報().getChikuName3();
            集計タイトル4 = (地区名３ != null ? 地区名３ : RString.EMPTY).concat(SenkyojiZaisankuRStringEnum.印字文字_2.getKey());
            key4 = 地区コード３ != null ? 地区コード３.value() : RString.EMPTY;
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey())
                && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            TohyokuCode 投票区コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getTohyokuCode();
            set集計タイトル4andkey4By投票区コード(投票区コード);
        }
        if (集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey())
                && 財産区選挙人名簿抄本情報.get選挙人名簿情報() != null) {
            get集計キー4(財産区選挙人名簿抄本情報);
            RString 冊 = 財産区選挙人名簿抄本情報.get選挙人名簿情報().getSatsu();
            集計タイトル4 = SenkyojiZaisankuRStringEnum.印字文字_冊計.getKey();
            key4 = 冊 != null ? 冊 : RString.EMPTY;
        }
    }

    private void set集計タイトル4andkey4By投票区コード(TohyokuCode 投票区コード) {
        if (投票区コード != null) {
            集計タイトル4 = SenkyojiZaisankuRStringEnum.印字文字_3.getKey()
                    .concat(投票区コード.value())
                    .concat(SenkyojiZaisankuRStringEnum.印字文字_4.getKey());
            key4 = 投票区コード.value();
        }
    }

    private void get集計キー4(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {

        if (財産区選挙人名簿抄本情報 != null && 財産区選挙人名簿抄本情報.get宛名PSM情報() != null) {
            性別コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getSeibetsuCode();
            if (性別コード != null && 性別コード.equals(Gender.MALE.code())) {
                集計男4++;
            } else if (性別コード != null && 性別コード.equals(Gender.FEMALE.code())) {
                集計女4++;
            }
            総合計4++;
        }
    }

    private void setページ計(SenkyojiZaisankuEntity 財産区選挙人名簿抄本情報) {
        if (財産区選挙人名簿抄本情報.get選挙資格情報() == null) {
            return;
        }
        Code 抹消事由コード = 財産区選挙人名簿抄本情報.get選挙資格情報().getMasshoJiyuCode();
        if ((抹消事由コード == null
                || 抹消事由コード.isEmpty())
                && (!shikakuHantei.is公民権停止者(財産区選挙人名簿抄本情報.get宛名PSM情報(),
                        財産区選挙人名簿抄本情報.get選挙資格情報(),
                        parameter.get年齢期限日(), parameter.get基準日()))) {
            性別コード = 財産区選挙人名簿抄本情報.get宛名PSM情報().getSeibetsuCode();
            if (財産区選挙人名簿抄本情報.get宛名PSM情報() != null
                    && 性別コード != null
                    && 性別コード.equals(Gender.MALE.code())) {
                pageKeiMan++;
            } else if (財産区選挙人名簿抄本情報.get宛名PSM情報() != null
                    && 性別コード != null
                    && 性別コード.equals(Gender.FEMALE.code())) {
                pageKeiWoman++;
            }
            pageKeiKei++;
        }

    }

    private void set財産区選挙人名簿抄本情報ページ集計() {
        財産区選挙人名簿抄本情報集計.setPageKeiKei(new RString(String.valueOf(pageKeiKei)));
        財産区選挙人名簿抄本情報集計.setPageKeiWoman(new RString(String.valueOf(pageKeiWoman)));
        財産区選挙人名簿抄本情報集計.setPageKeiMan(new RString(String.valueOf(pageKeiMan)));
    }

    private void set財産区選挙人名簿抄本情報集計1() {
        財産区選挙人名簿抄本情報集計.setKei1Man(new RString(String.valueOf(集計男1)));
        財産区選挙人名簿抄本情報集計.setKei1Woman(new RString(String.valueOf(集計女1)));
        財産区選挙人名簿抄本情報集計.setKei1Title(new RString(String.valueOf(集計タイトル1)));
        財産区選挙人名簿抄本情報集計.setKei1Kei(new RString(String.valueOf(総合計1)));
    }

    private void set財産区選挙人名簿抄本情報集計2() {
        財産区選挙人名簿抄本情報集計.setKei2Man(new RString(String.valueOf(集計男2)));
        財産区選挙人名簿抄本情報集計.setKei2Woman(new RString(String.valueOf(集計女2)));
        財産区選挙人名簿抄本情報集計.setKei2Title(new RString(String.valueOf(集計タイトル2)));
        財産区選挙人名簿抄本情報集計.setKei2Kei(new RString(String.valueOf(総合計2)));
    }

    private void set財産区選挙人名簿抄本情報集計3() {
        財産区選挙人名簿抄本情報集計.setKei3Man(new RString(String.valueOf(集計男3)));
        財産区選挙人名簿抄本情報集計.setKei3Woman(new RString(String.valueOf(集計女3)));
        財産区選挙人名簿抄本情報集計.setKei3Title(new RString(String.valueOf(集計タイトル3)));
        財産区選挙人名簿抄本情報集計.setKei3Kei(new RString(String.valueOf(総合計3)));
    }

    private void set財産区選挙人名簿抄本情報集計4() {
        財産区選挙人名簿抄本情報集計.setKei4Man(new RString(String.valueOf(集計男4)));
        財産区選挙人名簿抄本情報集計.setKei4Woman(new RString(String.valueOf(集計女4)));
        財産区選挙人名簿抄本情報集計.setKei4Title(new RString(String.valueOf(集計タイトル4)));
        財産区選挙人名簿抄本情報集計.setKei4Kei(new RString(String.valueOf(総合計4)));
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private ShohonZaisankuMeiboJoho set財産区選挙人名簿抄本情報(SenkyojiZaisankuEntity entity) {
        ShohonZaisankuMeiboJoho 名簿抄本情報 = new ShohonZaisankuMeiboJoho();
        if (entity == null) {
            return 名簿抄本情報;
        }
        if (entity.get宛名PSM情報() != null) {
            Code 抹消事由コード = entity.get選挙資格情報().getMasshoJiyuCode();
            名簿抄本情報.set抹消事由コード(抹消事由コード == null ? RString.EMPTY : 抹消事由コード.value());
            名簿抄本情報.set投票区名(entity.get宛名PSM情報().getTohyokuName());
            TohyokuCode 投票区コード = entity.get宛名PSM情報().getTohyokuCode();
            if (投票区コード != null) {
                名簿抄本情報.set投票区コード(投票区コード.value());
            }
            名簿抄本情報.set性別コード(entity.get宛名PSM情報().getSeibetsuCode());
            名簿抄本情報.set住登内住所(entity.get宛名PSM情報().getJutonaiJusho());
            AtenaBanchi 住登内番地 = entity.get宛名PSM情報().getJutonaiBanchi();
            if (住登内番地 != null) {
                名簿抄本情報.set住登内番地(住登内番地.value());
            }

            Katagaki 住登内方書 = entity.get宛名PSM情報().getJutonaiKatagaki();
            if (住登内方書 != null) {
                名簿抄本情報.set住登内方書(住登内方書.value());
            }
            FlexibleDate 生年月日 = entity.get宛名PSM情報().getSeinengappiYMD();
            if (生年月日 != null && 生年月日.isValid()) {
                名簿抄本情報.set生年月日(new RDate(生年月日.toString()));
            }
            AtenaMeisho 名称 = entity.get宛名PSM情報().getMeisho();
            if (名称 != null) {
                名簿抄本情報.set名称(名称.value());
            }
            ShikibetsuCode 識別コード = entity.get宛名PSM情報().getShikibetsuCode();
            if (識別コード != null) {
                名簿抄本情報.set識別コード(識別コード.value());
            }

            AtenaKanaMeisho カナ名称 = entity.get宛名PSM情報().getKanaShimei();

            if (カナ名称 != null) {
                名簿抄本情報.setカナ名称(カナ名称.value());
            }

            ChoikiCode 住所コード = entity.get宛名PSM情報().getJutonaiChoikiCode();
            if (住所コード != null) {
                名簿抄本情報.set住登内住所(住所コード.value());
            }
        }
        if (entity.get抄本情報() != null) {
            名簿抄本情報.set抄本名(entity.get抄本情報().getShohonName());
            FlexibleDate 規定年齢到達年月日 = entity.get抄本情報().getKiteiNenreiTotatsuYMD();
            if (規定年齢到達年月日 != null) {
                名簿抄本情報.set規定年齢到達年月日(規定年齢到達年月日);
            }
            FlexibleDate 投票日 = entity.get抄本情報().getTohyoYMD();
            if (投票日 != null) {
                名簿抄本情報.set投票年月日(new RDate(投票日.toString()));
            }
        }

        if (parameter.get基準日() != null) {
            名簿抄本情報.set名簿基準年月日(new RDate(parameter.get基準日().toString()));
        }

        名簿抄本情報.setKey1(key1);
        名簿抄本情報.setKey2(key2);
        名簿抄本情報.setKey3(key3);
        名簿抄本情報.setKey4(key4);
        return 名簿抄本情報;
    }

    private void create財産区選挙人名簿抄本文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                SenkyojiZaisankuReportProcess.特定項目.class,
                SenkyojiZaisankuReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        財産区選挙人名簿抄本Writer = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonZaisankuSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.value())
                .addBreak(new BreakerCatalog<MeiboShohonZaisankuSource>().simplePageBreaker(財産区選挙人名簿抄本_BREAK_KEYS))
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

        target1("listListjusho", "住所", CheckShubetsu.文字切れ),
        target2("listShimei", "氏名", CheckShubetsu.文字切れ);

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
