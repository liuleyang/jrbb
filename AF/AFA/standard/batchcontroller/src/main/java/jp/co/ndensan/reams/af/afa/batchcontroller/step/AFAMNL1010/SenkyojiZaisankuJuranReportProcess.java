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
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum.INT_0;
import static jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum.INT_1;
import static jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum.INT_2;
import static jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum.INT_3;
import static jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuIntEnum.INT_4;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import static jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit.帳票最大行;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.SenkyojiZaisankuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
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
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 財産区議会議員選挙時登録の財産区選挙人名簿抄本縦覧のクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuJuranReportProcess extends BatchKeyBreakBase<SenkyojiZaisankuEntity> {

    private int indexCount;
    private int 最大印字行;
    private int itemCount;
    private int page;
    private int totalPage;
    private ShikakuHantei shikakuHantei;
    private RString key1;
    private RString key2;
    private RString key3;
    private RString key4;

    private List<RString> 集計項目キーリスト = new ArrayList<>();

    private RString 縦覧取扱注意者の出力方式;
    private Association 地方公共団体情報;

    private ShohonZaisankuMeiboJoho 財産区選挙人名簿抄本縦覧情報;
    private SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報Before;
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
    private IBatchReportWriterWithCheckList<MeiboShohonZaisankuSource> 財産区選挙人名簿抄本縦覧Writer;
    private ReportSourceWriter<MeiboShohonZaisankuSource> 財産区選挙人名簿抄本縦覧SourceWriter;

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
        key1 = RString.EMPTY;
        key2 = RString.EMPTY;
        key3 = RString.EMPTY;
        key4 = RString.EMPTY;

        最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        最大印字行 = 最大印字行 > 帳票最大行.getKey() ? 帳票最大行.getKey() : 最大印字行;
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

        縦覧取扱注意者の出力方式 = BusinessConfig.get(
                ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, SubGyomuCode.AFA選挙本体);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create財産区選挙人名簿抄本縦覧文字切れ一覧表に出力Writer();
        財産区選挙人名簿抄本縦覧SourceWriter = new ReportSourceWriter<>(財産区選挙人名簿抄本縦覧Writer);
    }

    @Override
    protected void keyBreakProcess(SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        int flag = 縦覧取扱い注意者判断(選挙人名簿抄本縦覧情報);
        if (flag == INT_1.getKey()) {
            return;
        }
        Boolean isKey1Break = Boolean.FALSE;
        Boolean isKey2Break = Boolean.FALSE;
        Boolean isKey3Break = Boolean.FALSE;
        Boolean isKey4Break = Boolean.FALSE;
        if (集計項目キーリスト.size() >= INT_1.getKey()) {
            isKey1Break = is縦覧集計項目キー1Break(INT_0.getKey(), 選挙人名簿抄本縦覧情報);
        }
        if (集計項目キーリスト.size() >= INT_2.getKey()) {
            isKey2Break = is縦覧集計項目キー2Break(INT_1.getKey(), 選挙人名簿抄本縦覧情報);
        }
        if (集計項目キーリスト.size() >= INT_3.getKey()) {
            isKey3Break = is縦覧集計項目キー3Break(INT_2.getKey(), 選挙人名簿抄本縦覧情報);
        }
        if (集計項目キーリスト.size() >= INT_4.getKey()) {
            isKey4Break = is縦覧集計項目キー4Break(INT_3.getKey(), 選挙人名簿抄本縦覧情報);
        }
        itemCount++;
        Boolean is最大印字行Break = Boolean.FALSE;
        if (itemCount == 最大印字行) {
            is最大印字行Break = Boolean.TRUE;
        }
        if ((isKey1Break || isKey2Break || isKey3Break || isKey4Break || is最大印字行Break) && itemCount != 0) {
            totalPage++;
            if (senkyojiZaisankuEditor.hasBreakBy投票区(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報)) {
                page = 1;
            } else {
                page++;
            }
            itemCount = 0;
        }

    }

    @Override
    protected void usualProcess(SenkyojiZaisankuEntity 選挙人名簿抄本情報) {
        int flag = 縦覧取扱い注意者判断(選挙人名簿抄本情報);
        if (flag == INT_1.getKey()) {
            return;
        }
        indexCount++;
        if (indexCount == 1) {
            page = 1;
            totalPage = 1;
        }
        選挙人名簿抄本縦覧情報Before = 選挙人名簿抄本情報;
        財産区選挙人名簿抄本縦覧情報 = set財産区選挙人名簿抄本情報(選挙人名簿抄本情報);
        財産区選挙人名簿抄本縦覧情報.setPage(page);
        財産区選挙人名簿抄本縦覧情報.setTotalPage(new RString(String.valueOf(totalPage)));
        SenkyoninTohyoJokyoEntity 選挙人資格情報 = new SenkyoninTohyoJokyoEntity();
        選挙人資格情報.setAtenaPSMEntity(選挙人名簿抄本情報.get宛名PSM情報());
        財産区選挙人名簿抄本縦覧情報.set帳票フラグ(flag);
        MeiboShohonZaisankuParam param縦覧 = new MeiboShohonZaisankuParam(
                財産区選挙人名簿抄本縦覧情報,
                選挙人資格情報,
                new MeiboShohonJuminJouhouShuukei(),
                地方公共団体情報,
                SenkyojiZaisankuRStringEnum.財産区抄本_縦覧.getKey());
        param縦覧.setIs公民権停止者(shikakuHantei.is公民権停止者(選挙人名簿抄本情報.get宛名PSM情報(),
                選挙人名簿抄本情報.get選挙資格情報(),
                parameter.get年齢期限日(), parameter.get基準日()));
        MeiboShohonZaisankuReport report縦覧 = new MeiboShohonZaisankuReport(param縦覧);
        report縦覧.writeBy(財産区選挙人名簿抄本縦覧SourceWriter);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(財産区選挙人名簿抄本縦覧Writer.getPageCount());
    }

    private int 縦覧取扱い注意者判断(SenkyojiZaisankuEntity 財産区選挙人名簿抄本縦覧情報) {
        int flag = INT_4.getKey();
        UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity = 財産区選挙人名簿抄本縦覧情報.getFindeCautionShaMapperEntity();
        if (findeCautionShaMapperEntity != null && findeCautionShaMapperEntity.isGaitoKubun()) {
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める.getValue().equals(縦覧取扱注意者の出力方式)) {
                flag = INT_1.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行を空白.getValue().equals(縦覧取扱注意者の出力方式)) {
                flag = INT_2.getKey();
            }
            if (ToriatsukaiChuishaShutsurokuHoshikiConfig.行をマスク.getValue().equals(縦覧取扱注意者の出力方式)) {
                flag = INT_3.getKey();
            }
        } else {
            flag = INT_4.getKey();
        }
        return flag;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is縦覧集計項目キー1Break(int index, SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakByグループコード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakBy投票区(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak住所コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak行政区コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード１(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード２(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード３(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }

        if ((集計項目キーリスト.get(index)
                .equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak冊(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is縦覧集計項目キー2Break(int index, SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakByグループコード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakBy投票区(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak住所コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak行政区コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード１(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード２(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード３(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }

        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak冊(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        return Boolean.FALSE;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is縦覧集計項目キー3Break(int index, SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakByグループコード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak住所コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak行政区コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード１(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード２(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード３(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakBy投票区(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }

        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak冊(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private Boolean is縦覧集計項目キー4Break(int index, SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キーグループコード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakByグループコード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー投票区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreakBy投票区(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー住所コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak住所コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー行政区コード.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak行政区コード(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード１.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード１(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {

            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード２.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード２(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー地区コード３.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak地区コード３(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;

        }
        if ((集計項目キーリスト.get(index).equals(SenkyojiZaisankuRStringEnum.集計キー冊.getKey()))
                && (itemCount != 0 && senkyojiZaisankuEditor.hasBreak冊(選挙人名簿抄本縦覧情報Before, 選挙人名簿抄本縦覧情報))) {
            itemCount = 0;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private ShohonZaisankuMeiboJoho set財産区選挙人名簿抄本情報(SenkyojiZaisankuEntity 選挙人名簿抄本縦覧情報) {
        ShohonZaisankuMeiboJoho 名簿抄本縦覧情報 = new ShohonZaisankuMeiboJoho();
        if (選挙人名簿抄本縦覧情報 == null) {
            return 名簿抄本縦覧情報;
        }
        if (選挙人名簿抄本縦覧情報.get宛名PSM情報() != null) {
            Code 抹消事由コード = 選挙人名簿抄本縦覧情報.get選挙資格情報().getMasshoJiyuCode();
            名簿抄本縦覧情報.set抹消事由コード(抹消事由コード == null ? RString.EMPTY : 抹消事由コード.value());
            名簿抄本縦覧情報.set投票区名(選挙人名簿抄本縦覧情報.get宛名PSM情報().getTohyokuName());
            TohyokuCode 投票区コード = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getTohyokuCode();
            if (投票区コード != null) {
                名簿抄本縦覧情報.set投票区コード(投票区コード.value());
            }
            名簿抄本縦覧情報.set性別コード(選挙人名簿抄本縦覧情報.get宛名PSM情報().getSeibetsuCode());
            名簿抄本縦覧情報.set住登内住所(選挙人名簿抄本縦覧情報.get宛名PSM情報().getJutonaiJusho());
            AtenaBanchi 住登内番地 = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getJutonaiBanchi();
            if (住登内番地 != null) {
                名簿抄本縦覧情報.set住登内番地(住登内番地.value());
            }

            Katagaki 住登内方書 = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getJutonaiKatagaki();
            if (住登内方書 != null) {
                名簿抄本縦覧情報.set住登内方書(住登内方書.value());
            }
            FlexibleDate 生年月日 = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getSeinengappiYMD();
            if (生年月日 != null && 生年月日.isValid()) {
                名簿抄本縦覧情報.set生年月日(new RDate(生年月日.toString()));
            }
            AtenaMeisho 名称 = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getMeisho();
            if (名称 != null) {
                名簿抄本縦覧情報.set名称(名称.value());
            }
            ShikibetsuCode 識別コード = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getShikibetsuCode();
            if (識別コード != null) {
                名簿抄本縦覧情報.set識別コード(識別コード.value());
            }

            AtenaKanaMeisho カナ名称 = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getKanaShimei();

            if (カナ名称 != null) {
                名簿抄本縦覧情報.setカナ名称(カナ名称.value());
            }

            ChoikiCode 住所コード = 選挙人名簿抄本縦覧情報.get宛名PSM情報().getJutonaiChoikiCode();
            if (住所コード != null) {
                名簿抄本縦覧情報.set住登内住所(住所コード.value());
            }
        }
        if (選挙人名簿抄本縦覧情報.get抄本情報() != null) {
            名簿抄本縦覧情報.set抄本名(選挙人名簿抄本縦覧情報.get抄本情報().getShohonName());
            FlexibleDate 規定年齢到達年月日 = 選挙人名簿抄本縦覧情報.get抄本情報().getKiteiNenreiTotatsuYMD();
            if (規定年齢到達年月日 != null) {
                名簿抄本縦覧情報.set規定年齢到達年月日(規定年齢到達年月日);
            }
            FlexibleDate 投票日 = 選挙人名簿抄本縦覧情報.get抄本情報().getTohyoYMD();
            if (投票日 != null) {
                名簿抄本縦覧情報.set投票年月日(new RDate(投票日.toString()));
            }
        }

        if (parameter.get基準日() != null) {
            名簿抄本縦覧情報.set名簿基準年月日(new RDate(parameter.get基準日().toString()));
        }

        名簿抄本縦覧情報.setKey1(key1);
        名簿抄本縦覧情報.setKey2(key2);
        名簿抄本縦覧情報.setKey3(key3);
        名簿抄本縦覧情報.setKey4(key4);
        return 名簿抄本縦覧情報;
    }

    private void create財産区選挙人名簿抄本縦覧文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                SenkyojiZaisankuJuranReportProcess.特定項目.class,
                SenkyojiZaisankuJuranReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());
        財産区選挙人名簿抄本縦覧Writer = BatchWriters
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
