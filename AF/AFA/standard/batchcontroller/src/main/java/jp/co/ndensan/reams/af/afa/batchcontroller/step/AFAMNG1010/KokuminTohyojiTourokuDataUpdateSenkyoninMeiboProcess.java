/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TorokuJiyuCodeKokumin;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateSenkyoninMeiboEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国民投票時登録データ更新(選挙人名簿)のクラスです。
 *
 * @reamsid_L AF-0360-020 qiuxy
 */
public class KokuminTohyojiTourokuDataUpdateSenkyoninMeiboProcess extends BatchProcessBase<TeijiTourokuDataUpdateSenkyoninMeiboEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private ShikakuHantei shikakuhantei;

    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectSenkyoNinTouhyouJyohouTempTableList");
    private static final long 履歴番号1 = 1;
    private static final int シミュレーション = 10000;
    private int 抄本ページ行数;
    private AfT112SenkyoninMeiboEntity last選挙人名簿情報;
    private AfT112SenkyoninMeiboEntity last選挙人名簿情報研修用;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> aft112Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> aft113Writer;

    @Override
    protected void initialize() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey key = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(key, key);
        shikakuhantei = new ShikakuHantei();
        抄本ページ行数 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_国民_ページ行数, RDate.getNowDate(), SubGyomuCode.AFA選挙本体).toString());
        last選挙人名簿情報 = null;
        last選挙人名簿情報研修用 = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新データ抽出, mybatisParameter);
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
            last選挙人名簿情報 = insertSenkyoninMeiboEntity(entity, parameter.get抄本番号(), 識別コード, last選挙人名簿情報);
            last選挙人名簿情報研修用 = insertSenkyoninMeiboEntity(entity, parameter.get研修用発番抄本番号(), 識別コード, last選挙人名簿情報研修用);
        }

    }

    private AfT112SenkyoninMeiboEntity insertSenkyoninMeiboEntity(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity,
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            AfT112SenkyoninMeiboEntity last選挙人名簿情報) {
        if (抄本番号 == null) {
            return last選挙人名簿情報;
        }
        boolean is1号資格者 = is1号資格者(entity);
        boolean is2号資格者 = is2号資格者(entity);

        AfT113SenkyoShikakuEntity 選挙資格情報 = entity.getSenkyoShikakuEntity();
        BigSerial seq = new BigSerial(履歴番号1);

        AfT112SenkyoninMeiboEntity 選挙人名簿情報 = new AfT112SenkyoninMeiboEntity();
        選挙人名簿情報.setShohonNo(抄本番号);
        選挙人名簿情報.setSeq(seq);
        選挙人名簿情報.setGroupCode(entity.getGroupCode());
        選挙人名簿情報.setTohyokuCode(getNullToRString(entity.getTohyokuCodeAdd()));
        選挙人名簿情報.setShikibetsuCode(識別コード);
        選挙人名簿情報.setSatsu(entity.getSatsu());
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
        if (抄本番号.getColumnValue() < シミュレーション) {
            insertSenkyoShikakuEntity(entity, 選挙資格情報, 識別コード, is1号資格者, is2号資格者);
        }
        return 選挙人名簿情報;
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 73 LINES
    private void insertSenkyoShikakuEntity(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity,
            AfT113SenkyoShikakuEntity 選挙資格情報,
            ShikibetsuCode 識別コード,
            boolean is1号資格者,
            boolean is2号資格者) {
        if (!is1号資格者 && !is2号資格者) {
            return;
        }
        SenkyoninTohyoJokyoEntity 選挙人資格情報 = new SenkyoninTohyoJokyoEntity();
        選挙人資格情報.setAtenaPSMEntity(entity.getAtenaPSMEntity());
        選挙人資格情報.setSenkyoninMeiboEntity(entity.getSenkyoninMeiboEntity());
        選挙人資格情報.setSenkyoShikakuEntity(entity.getSenkyoShikakuEntity());

        long 履歴番号 = ShoriShubetsu.新規登録.getShoriShubetsu().equals(parameter.get処理種別()) ? 履歴番号1
                : (選挙資格情報 == null ? 履歴番号1 : 選挙資格情報.getSeq().getValue() + 履歴番号1);
        RString 選挙資格区分;
        Code 登録事由コード;
        FlexibleDate 抹消年月日 = FlexibleDate.EMPTY;
        Code 抹消事由コード = Code.EMPTY;
        if (is1号資格者) {
            選挙資格区分 = SennkyoSikakuKubun.有権者_1号資格.value();
            登録事由コード = TorokuJiyuCodeKokumin.一号資格者.getCode();
        } else if (is2号資格者) {
            選挙資格区分 = SennkyoSikakuKubun.有権者_2号資格.value();
            登録事由コード = TorokuJiyuCodeKokumin.二号資格者.getCode();
        } else {
            return;
        }

        AfT113SenkyoShikakuEntity 選挙資格情報New = new AfT113SenkyoShikakuEntity();
        選挙資格情報New.setSenkyoShurui(new Code(SenkyoShurui.憲法改正国民投票.getCode()));
        選挙資格情報New.setShikibetsuCode(識別コード);
        選挙資格情報New.setSeq(new BigSerial(履歴番号));
        選挙資格情報New.setShikakuKubun(new Code(選挙資格区分));
        選挙資格情報New.setTohyokuCode(entity.getTohyokuCodeAdd());
        選挙資格情報New.setMeiboTorokuYMD(parameter.get名簿登録日());
        選挙資格情報New.setTorokuJiyuCode(登録事由コード);
        選挙資格情報New.setTorokuTeishiYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setTorokuTeishiJiyuCode(Code.EMPTY);
        選挙資格情報New.setHyojiYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setHyojiJiyuCode(Code.EMPTY);
        選挙資格情報New.setHyojiShojoYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setMasshoYMD(抹消年月日);
        選挙資格情報New.setMasshoJiyuCode(抹消事由コード);
        選挙資格情報New.setKeikiShuryoYMD(FlexibleDate.EMPTY);
        選挙資格情報New.setNikeimochiFlag(false);
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

    private boolean is1号資格者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is1号資格者(entity.getAtenaPSMEntity(), parameter.get基準日(), parameter.get年齢到達日());
    }

    private boolean is2号資格者(TeijiTourokuDataUpdateSenkyoninMeiboEntity entity) {
        return shikakuhantei.is2号資格者(entity.getAtenaPSMEntity(), parameter.get基準日(), parameter.get年齢到達日());
    }

}
