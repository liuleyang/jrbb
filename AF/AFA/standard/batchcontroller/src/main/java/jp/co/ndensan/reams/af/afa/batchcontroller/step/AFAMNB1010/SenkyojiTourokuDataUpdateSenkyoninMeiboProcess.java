/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateSenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙時登録データ更新(選挙人名簿)のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuDataUpdateSenkyoninMeiboProcess extends BatchProcessBase<TeijiTourokuDataUpdateSenkyoninMeiboEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private ShikakuHantei shikakuhantei;

    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectSenkyoNinTouhyouJyohouTempTableList");
    private static final long 履歴番号1 = 1;
    private static final int THREE_MONTH = 3;
    private static final RString 処理モード_シミュレーション = new RString("2");
    private int 抄本ページ行数;
    private AfT112SenkyoninMeiboEntity last選挙人名簿情報;
    private AfT112SenkyoninMeiboEntity last選挙人名簿情報研修用;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> aft112Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> aft113Writer;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        shikakuhantei = new ShikakuHantei();
        抄本ページ行数 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        last選挙人名簿情報 = null;
        last選挙人名簿情報研修用 = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新データ抽出, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        aft112Writer = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
        aft113Writer = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);
    }

    @Override
    protected void process(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {

        ShikibetsuCode 識別コード = entity.getAtenaPSMEntity().getShikibetsuCode();
        if (識別コード != null) {
            last選挙人名簿情報 = insertSenkyoninMeiboEntity(entity, parameter.getShohonNo(), 識別コード, last選挙人名簿情報);
            if (parameter.get研修用データも作成有無()) {
                last選挙人名簿情報研修用 = insertSenkyoninMeiboEntity(entity, parameter.get研修用発番抄本番号(), 識別コード, last選挙人名簿情報研修用);
            }
        }

    }

    private AfT112SenkyoninMeiboEntity insertSenkyoninMeiboEntity(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity,
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            AfT112SenkyoninMeiboEntity last選挙人名簿情報) {
        if (抄本番号 == null) {
            return last選挙人名簿情報;
        }
        boolean is有権者 = is有権者(entity);
        boolean is表示者 = is表示者(entity);
        boolean is公民権停止者 = is公民権停止者(entity);
        boolean is抹消者 = is抹消者(entity);

        if (!is有権者 && !is表示者 && !is公民権停止者 && !is抹消者) {
            return last選挙人名簿情報;
        }

        AfT112SenkyoninMeiboEntity 選挙人名簿情報 = entity.getSenkyoninMeiboEntity();
        AfT113SenkyoShikakuEntity 選挙資格情報 = entity.getSenkyoShikakuEntity();

        if (is抹消者 && 選挙人名簿情報 == null) {
            return last選挙人名簿情報;
        }
        BigSerial seq = 選挙人名簿情報 != null ? new BigSerial(選挙人名簿情報.getSeq().getValue() + 履歴番号1) : new BigSerial(履歴番号1);

        選挙人名簿情報 = new AfT112SenkyoninMeiboEntity();
        選挙人名簿情報.setShohonNo(抄本番号);
        選挙人名簿情報.setSeq(seq);
        選挙人名簿情報.setGroupCode(entity.getGroupCode());
        選挙人名簿情報.setSatsu(entity.getSatsu());
        選挙人名簿情報.setTohyokuCode(getNullToRString(entity.getTohyokuCodeAdd()));
        選挙人名簿情報.setShikibetsuCode(識別コード);
        選挙人名簿情報.setTohyokuHenkoMasshoFlag(false);

        if (last選挙人名簿情報 == null) {
            選挙人名簿情報.setGyo(1);
            選挙人名簿情報.setPage(1);
            選挙人名簿情報.setRenban(1);
        } else if (last選挙人名簿情報.getGroupCode().equals(選挙人名簿情報.getGroupCode())
                && last選挙人名簿情報.getTohyokuCode().equals(選挙人名簿情報.getTohyokuCode())
                && last選挙人名簿情報.getSatsu().equals(選挙人名簿情報.getSatsu())) {
            if (last選挙人名簿情報.getGyo() < 抄本ページ行数) {
                選挙人名簿情報.setGyo(last選挙人名簿情報.getGyo() + 1);
                選挙人名簿情報.setPage(last選挙人名簿情報.getPage());
                選挙人名簿情報.setRenban(last選挙人名簿情報.getRenban());
            } else {
                選挙人名簿情報.setGyo(1);
                選挙人名簿情報.setPage(last選挙人名簿情報.getPage() + 1);
                選挙人名簿情報.setRenban(last選挙人名簿情報.getRenban() + 1);
            }
        } else {
            選挙人名簿情報.setGyo(1);
            選挙人名簿情報.setPage(1);
            選挙人名簿情報.setRenban(last選挙人名簿情報.getRenban() + 1);
        }

        選挙人名簿情報.setEdaban(0);

        aft112Writer.insert(選挙人名簿情報);
        if (!処理モード_シミュレーション.equals(parameter.get処理モード())) {
            insertSenkyoShikakuEntity(entity, 選挙資格情報, 識別コード, is有権者, is表示者, is公民権停止者, is抹消者);
        }
        return 選挙人名簿情報;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 150 LINES
    private void insertSenkyoShikakuEntity(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity,
            AfT113SenkyoShikakuEntity 選挙資格情報,
            ShikibetsuCode 識別コード,
            boolean is有権者,
            boolean is表示者,
            boolean is公民権停止者,
            boolean is抹消者) {

        SenkyoninTohyoJokyoEntity 選挙人資格情報 = new SenkyoninTohyoJokyoEntity();
        選挙人資格情報.setAtenaPSMEntity(entity.getAtenaPSMEntity());
        選挙人資格情報.setSenkyoninMeiboEntity(entity.getSenkyoninMeiboEntity());
        選挙人資格情報.setSenkyoShikakuEntity(entity.getSenkyoShikakuEntity());

        long 履歴番号 = 選挙資格情報 != null ? 選挙資格情報.getSeq().getValue() + 履歴番号1 : 履歴番号1;
        RString 選挙資格区分;
        FlexibleDate 名簿登録年月日;
        Code 登録事由コード = Code.EMPTY;
        FlexibleDate 登録停止年月日 = FlexibleDate.EMPTY;
        Code 登録停止事由コード = Code.EMPTY;
        FlexibleDate 表示年月日 = FlexibleDate.EMPTY;
        Code 表示事由コード = Code.EMPTY;
        FlexibleDate 表示消除年月日 = FlexibleDate.EMPTY;
        FlexibleDate 表示消除予定年月日 = FlexibleDate.EMPTY;
        FlexibleDate 抹消年月日 = FlexibleDate.EMPTY;
        Code 抹消事由コード = Code.EMPTY;
        boolean 刑持ちフラグ2 = false;

        if (is有権者) {
            選挙資格区分 = SennkyoSikakuKubun.有権者.value();
            名簿登録年月日 = 選挙資格情報 == null ? parameter.getTourokubi() : 選挙資格情報.getMeiboTorokuYMD();
            表示消除年月日 = get表示消除年月日(entity);
            登録事由コード = get事由コード(選挙人資格情報, SennkyoSikakuKubun.有権者);
            刑持ちフラグ2 = 選挙資格情報 != null ? 選挙資格情報.getNikeimochiFlag() : false;

        } else if (is表示者) {
            選挙資格区分 = SennkyoSikakuKubun.表示者.value();
            if (選挙資格情報 != null) {
                名簿登録年月日 = 選挙資格情報.getMeiboTorokuYMD();
                登録事由コード = 選挙資格情報.getTorokuJiyuCode();
            } else {
                名簿登録年月日 = parameter.getTourokubi();
                登録事由コード = new Code(JiyuCode.年齢到達.getKey());
            }
            RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
            if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)) {
                表示年月日 = entity.getAtenaPSMEntity().getShojoTodokedeYMD();
            } else if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)) {
                表示年月日 = entity.getAtenaPSMEntity().getShojoIdoYMD();
            }
            刑持ちフラグ2 = 選挙資格情報 != null ? 選挙資格情報.getNikeimochiFlag() : false;
            表示事由コード = get事由コード(選挙人資格情報, SennkyoSikakuKubun.表示者);

        } else if (is公民権停止者) {
            選挙資格区分 = SennkyoSikakuKubun.公民権停止.value();
            if (選挙資格情報 != null) {
                名簿登録年月日 = 選挙資格情報.getMeiboTorokuYMD();
                登録事由コード = 選挙資格情報.getTorokuJiyuCode();
                登録停止年月日 = 選挙資格情報.getTorokuTeishiYMD();
                登録停止事由コード = 選挙資格情報.getTorokuTeishiJiyuCode();
                表示年月日 = 選挙資格情報.getHyojiYMD();
                表示事由コード = 選挙資格情報.getHyojiJiyuCode();
                刑持ちフラグ2 = 選挙資格情報.getNikeimochiFlag();
            } else {
                名簿登録年月日 = parameter.getTourokubi();
            }

        } else if (is抹消者) {
            選挙資格区分 = SennkyoSikakuKubun.抹消者.value();
            if (選挙資格情報 != null) {
                名簿登録年月日 = 選挙資格情報.getMeiboTorokuYMD();
                登録事由コード = 選挙資格情報.getTorokuJiyuCode();
                表示年月日 = 選挙資格情報.getHyojiYMD();
                表示事由コード = 選挙資格情報.getHyojiJiyuCode();
                表示消除年月日 = 選挙資格情報.getHyojiShojoYMD();
                表示消除予定年月日 = 選挙資格情報.getHyojiShojoYoteiYMD();
                抹消年月日 = get抹消年月日(entity);
                抹消事由コード = get事由コード(選挙人資格情報, SennkyoSikakuKubun.抹消者);
                刑持ちフラグ2 = 選挙資格情報.getNikeimochiFlag();
            } else {
                return;
            }

        } else {
            return;
        }

        AfT113SenkyoShikakuEntity 選挙資格情報New = new AfT113SenkyoShikakuEntity();
        選挙資格情報New.setSenkyoShurui(new Code(SenkyoShurui.定時登録.getCode()));
        選挙資格情報New.setShikibetsuCode(識別コード);
        選挙資格情報New.setSeq(new BigSerial(履歴番号));
        選挙資格情報New.setShikakuKubun(new Code(選挙資格区分));
        選挙資格情報New.setTohyokuCode(entity.getTohyokuCodeAdd());
        選挙資格情報New.setMeiboTorokuYMD(名簿登録年月日);
        選挙資格情報New.setTorokuJiyuCode(登録事由コード);
        選挙資格情報New.setTorokuTeishiYMD(登録停止年月日);
        選挙資格情報New.setTorokuTeishiJiyuCode(登録停止事由コード);
        選挙資格情報New.setHyojiYMD(表示年月日);
        選挙資格情報New.setHyojiJiyuCode(表示事由コード);
        選挙資格情報New.setHyojiShojoYMD(表示消除年月日);
        選挙資格情報New.setHyojiShojoYoteiYMD(表示消除予定年月日);
        選挙資格情報New.setMasshoYMD(抹消年月日);
        選挙資格情報New.setMasshoJiyuCode(抹消事由コード);
        選挙資格情報New.setKeikiShuryoYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setNikeimochiFlag(刑持ちフラグ2);
        選挙資格情報New.setDataTorokuYMD(FlexibleDate.getNowDate());

        if (選挙資格情報 == null
                || !(isEquals(選挙資格情報New.getShikakuKubun(), 選挙資格情報.getShikakuKubun())
                && isEquals(選挙資格情報New.getTohyokuCode(), 選挙資格情報.getTohyokuCode())
                && isEquals(選挙資格情報New.getMeiboTorokuYMD(), 選挙資格情報.getMeiboTorokuYMD())
                && isEquals(選挙資格情報New.getTorokuJiyuCode(), 選挙資格情報.getTorokuJiyuCode())
                && isEquals(選挙資格情報New.getTorokuTeishiYMD(), 選挙資格情報.getTorokuTeishiYMD())
                && isEquals(選挙資格情報New.getTorokuTeishiJiyuCode(), 選挙資格情報.getTorokuTeishiJiyuCode())
                && isEquals(選挙資格情報New.getHyojiYMD(), 選挙資格情報.getHyojiYMD())
                && isEquals(選挙資格情報New.getHyojiJiyuCode(), 選挙資格情報.getHyojiJiyuCode())
                && isEquals(選挙資格情報New.getHyojiShojoYMD(), 選挙資格情報.getHyojiShojoYMD())
                && isEquals(選挙資格情報New.getHyojiShojoYoteiYMD(), 選挙資格情報.getHyojiShojoYoteiYMD())
                && isEquals(選挙資格情報New.getMasshoYMD(), 選挙資格情報.getMasshoYMD())
                && isEquals(選挙資格情報New.getMasshoJiyuCode(), 選挙資格情報.getMasshoJiyuCode()))) {
            aft113Writer.insert(選挙資格情報New);
        }
    }

    private boolean isEquals(Code codeNew, Code codeOld) {
        return NullHandler.getNullToRString(codeNew).equals(NullHandler.getNullToRString(codeOld));
    }

    private boolean isEquals(RString stringNew, RString stringOld) {
        return NullHandler.getNullToRString(stringNew).equals(NullHandler.getNullToRString(stringOld));
    }

    private boolean isEquals(FlexibleDate dateNew, FlexibleDate dateOld) {
        return NullHandler.getNullToFlexibleDate(dateNew).equals(NullHandler.getNullToFlexibleDate(dateOld));
    }

    @Override
    protected void afterExecute() {

    }

    private RString getNullToRString(RString value) {
        if (null == value) {
            return RString.EMPTY;
        }
        return value;
    }

    private Code get事由コード(SenkyoninTohyoJokyoEntity entity, SennkyoSikakuKubun 選挙資格区分) {
        RString 事由コード = RString.EMPTY;
        if (SennkyoSikakuKubun.有権者.equals(選挙資格区分)) {
            事由コード = shikakuhantei.get新規登録事由(entity, parameter.getTennyuKigenbi(),
                    parameter.getNenreiKigenbi(), parameter.getTouhyobi(), SenkyoShurui.定時登録);
        } else if (SennkyoSikakuKubun.表示者.equals(選挙資格区分)) {
            事由コード = shikakuhantei.get新規表示事由(entity, parameter.getTenshutuKigenbi(),
                    parameter.getNenreiKigenbi(), parameter.getTouhyobi(), parameter.get前回基準日(), SenkyoShurui.定時登録);
        } else if (SennkyoSikakuKubun.抹消者.equals(選挙資格区分)) {
            事由コード = shikakuhantei.get新規抹消事由(entity, parameter.getTenshutuKigenbi(),
                    parameter.getNenreiKigenbi());
        }
        return null == 事由コード || 事由コード.isEmpty() ? Code.EMPTY : new Code(事由コード);
    }

    private boolean is有権者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is有権者(entity.getAtenaPSMEntity(),
                parameter.getTennyuKigenbi(),
                parameter.getNenreiKigenbi(),
                parameter.getTouhyobi(),
                SenkyoShurui.定時登録,
                entity.getSenkyoShikakuEntity());
    }

    private boolean is表示者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is表示者(entity.getAtenaPSMEntity(),
                parameter.getTenshutuKigenbi(),
                parameter.getNenreiKigenbi(),
                parameter.getTouhyobi(),
                parameter.get前回基準日(),
                SenkyoShurui.定時登録);
    }

    private boolean is公民権停止者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is公民権停止者(entity.getAtenaPSMEntity(),
                entity.getSenkyoShikakuEntity(),
                parameter.getNenreiKigenbi(),
                parameter.getKijunbi());
    }

    private boolean is抹消者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is抹消者(entity.getAtenaPSMEntity(),
                parameter.getTenshutuKigenbi(),
                parameter.getNenreiKigenbi());
    }

    private FlexibleDate get抹消年月日(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)) {
            return entity.getAtenaPSMEntity().getShojoTodokedeYMD();
        } else if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)) {
            return entity.getAtenaPSMEntity().getShojoIdoYMD();
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    private FlexibleDate get表示消除年月日(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        FlexibleDate 表示消除年月日 = FlexibleDate.EMPTY;
        Boolean is表示者 = null != entity.getSenkyoShikakuEntity()
                && null != entity.getSenkyoShikakuEntity().getShikakuKubun()
                && SennkyoSikakuKubun.有権者.value().equals(
                        getCodeToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()));
        if (is表示者) {
            RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
            if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(登録年月日検索基準)) {
                表示消除年月日 = getNullToEmpty(entity.getAtenaPSMEntity().getTorokuTodokedeYMD(), THREE_MONTH);
            } else if (AFAConfigKeysValue.登録年月日検索基準_登録異動年月日.isEqual(登録年月日検索基準)) {
                表示消除年月日 = getNullToEmpty(entity.getAtenaPSMEntity().getTorokuIdoYMD(), THREE_MONTH);
            }
        }
        return 表示消除年月日;
    }

    private RString getCodeToRString(Code code) {
        if (null == code || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    private FlexibleDate getNullToEmpty(FlexibleDate date, int month) {
        if (null == date || date.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return date.plusMonth(month);
    }
}
