/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.SenkyojiZaisankuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.TohyokuConditionTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 財産区議会議員選挙時登録バッチ処理クラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuInsertProcess extends BatchKeyBreakBase<SenkyojiZaisankuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyojizaisanku.ISenkyojiZaisankuMapper.select宛名識別対象情報");
    private AFABTL101SelectProcessParameter parameter;
    private AFABTL101SelectProcessMyBatisParameter mybatisParameter;
    private int itemCount;
    private int 投票区コード_連番;
    private RString ページ行数;
    private RString 処理種別;
    private ShohonNo 抄本番号_採番;
    private List<ShohonNo> 抄本番号List;
    private FlexibleDate 検索条件_年齢;
    private AfT100ShohonEntity 抄本情報;
    private AfT111SenkyoEntity 選挙情報;
    private AfT113SenkyoShikakuEntity 選挙資格情報;
    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private AfT141ZaisankuJuminTohyoConditionEntity 住民投票選挙人抽出条件情報;
    private AfT144JushoConditionEntity 住所抽出条件情報;
    private TohyokuConditionTempTableEntity 投票区抽出条件情報;
    private OutputParameter<RString> outTempTableName;
    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = SenkyojiZaisankuRStringEnum.一時テーブル名.getKey();
    }
    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> tableWriterShohon;
    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> tableWriterSenkyo;
    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;
    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> tableWriterSenkyoShikaku;
    @BatchWriter
    private BatchPermanentTableWriter<AfT141ZaisankuJuminTohyoConditionEntity> tableWriterZaisankuJumin;
    @BatchWriter
    private BatchPermanentTableWriter<AfT144JushoConditionEntity> tableWriterJushoCondition;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_署名簿_ページ行数, SubGyomuCode.AFA選挙本体);
        mybatisParameter = parameter.toAFABTL101SelectProcessMyBatisParameter();
        RString 選挙資格到達年齢 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体);
        検索条件_年齢 = parameter.get年齢期限日().minusYear(
                Integer.valueOf(選挙資格到達年齢.isNullOrEmpty() ? SenkyojiZaisankuRStringEnum.ZERO.getKey().toString() : 選挙資格到達年齢.toString()));
        mybatisParameter = parameter.toAFABTL101SelectProcessMyBatisParameter();
        mybatisParameter.set年齢期限日(検索条件_年齢);
        処理種別 = parameter.get処理種別();
        抄本番号List = new ArrayList<>();
        抄本情報 = new AfT100ShohonEntity();
        選挙情報 = new AfT111SenkyoEntity();
        選挙人名簿情報 = new AfT112SenkyoninMeiboEntity();
        選挙資格情報 = new AfT113SenkyoShikakuEntity();
        住民投票選挙人抽出条件情報 = new AfT141ZaisankuJuminTohyoConditionEntity();
        住所抽出条件情報 = new AfT144JushoConditionEntity();
        投票区抽出条件情報 = new TohyokuConditionTempTableEntity();
        itemCount = 0;
        投票区コード_連番 = 0;
        抄本番号_採番 = get抄本番号();
        outTempTableName = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterShohon = new BatchPermanentTableWriter<>(AfT100ShohonEntity.class);
        tableWriterSenkyo = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
        tableWriterSenkyoninMeibo = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
        tableWriterSenkyoShikaku = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);
        tableWriterZaisankuJumin = new BatchPermanentTableWriter<>(AfT141ZaisankuJuminTohyoConditionEntity.class);
        tableWriterJushoCondition = new BatchPermanentTableWriter<>(AfT144JushoConditionEntity.class);
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(
                SenkyojiZaisankuRStringEnum.TOHYOKUCONDITION_TEMP_TABLE_NAME.getKey(), TohyokuConditionTempTableEntity.class);
    }

    @Override
    protected void usualProcess(SenkyojiZaisankuEntity entity) {
        財産区議会議員選挙時登録対象データ登録(entity);
    }

    @Override
    protected void keyBreakProcess(SenkyojiZaisankuEntity entity) {
        if (hasBreakBy投票区(getBefore(), entity)) {
            投票区コード_連番 = 1;
        } else {
            投票区コード_連番++;
        }
    }

    private Boolean hasBreakBy投票区(SenkyojiZaisankuEntity 宛名識別対象情報before,
            SenkyojiZaisankuEntity 宛名識別対象情報current) {
        RString before投票区コード = RString.EMPTY;
        RString current投票区コード = RString.EMPTY;
        if (宛名識別対象情報before.get宛名PSM情報() != null
                && 宛名識別対象情報before.get宛名PSM情報().getTohyokuCode() != null) {
            before投票区コード = RString.EMPTY;
        }
        if (宛名識別対象情報current.get宛名PSM情報() != null
                && 宛名識別対象情報current.get宛名PSM情報().getTohyokuCode() != null) {
            TohyokuCode 投票区コード = 宛名識別対象情報current.get宛名PSM情報().getTohyokuCode();
            current投票区コード = 投票区コード != null ? 投票区コード.value() : RString.EMPTY;
        }
        if (!before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void 財産区議会議員選挙時登録対象データ登録(SenkyojiZaisankuEntity 宛名識別対象情報) {
        itemCount++;
        if (itemCount == 1) {
            tableWriterShohon.insert(edit抄本情報(抄本番号_採番));
            tableWriterSenkyo.insert(edit選挙情報(抄本番号_採番));
        }
        tableWriterSenkyoninMeibo.insert(edit選挙人名簿情報(抄本番号_採番, 宛名識別対象情報));
        tableWriterSenkyoShikaku.insert(edit選挙資格情報(宛名識別対象情報));
        if (itemCount == 1) {
            tableWriterZaisankuJumin.insert(edit住民投票選挙人抽出条件情報(抄本番号_採番));
            if (parameter.get詳細指定選択レコードリスト() != null
                    && !parameter.get詳細指定選択レコードリスト().isEmpty()) {
                for (RString 町域コード : parameter.get詳細指定選択レコードリスト()) {
                    tableWriterJushoCondition.insert(edit住所抽出条件情報(抄本番号_採番, 町域コード));
                }
            }
            if (parameter.get対象者住所条件選択レコードリスト() != null
                    && !parameter.get対象者住所条件選択レコードリスト().isEmpty()) {
                for (RString 投票区コード : parameter.get対象者住所条件選択レコードリスト()) {
                    tempDbWriter.insert(edit投票区抽出条件情報(抄本番号_採番, 投票区コード));
                }
            }
        }

    }

    @Override
    protected void afterExecute() {
        抄本番号List.add(抄本番号_採番);
        parameter.set抄本番号List(抄本番号List);
        outTempTableName.setValue(SenkyojiZaisankuRStringEnum.TOHYOKUCONDITION_TEMP_TABLE_NAME.getKey());
    }

    private AfT100ShohonEntity edit抄本情報(ShohonNo 抄本番号) {
        抄本情報 = new AfT100ShohonEntity();
        抄本情報.setShohonNo(抄本番号);
        抄本情報.setSenkyoShurui(new Code(SenkyoShurui.財産区議会議員選挙.getCode()));
        抄本情報.setShohonName(parameter.get抄本名());
        抄本情報.setTohyoYMD(parameter.get投票日());
        抄本情報.setKiteiNenreiTotatsuYMD(parameter.get年齢期限日());
        抄本情報.setShoriYMD(FlexibleDate.getNowDate());
        return 抄本情報;
    }

    private AfT111SenkyoEntity edit選挙情報(ShohonNo 抄本番号) {
        選挙情報 = new AfT111SenkyoEntity();
        選挙情報.setShohonNo(抄本番号);
        選挙情報.setSenkyoNo(new SenkyoNo(SenkyojiZaisankuRStringEnum.選挙番号_1.getKey()));
        選挙情報.setSenkyoLevel(new Code(SennkyoLevel.その他.value()));
        選挙情報.setSenkyoName(parameter.get抄本名());
        選挙情報.setSenkyoRyakusho(SenkyoShurui.財産区議会議員選挙.getName());
        選挙情報.setSenkyoMark(SenkyojiZaisankuRStringEnum.選挙マーク_財産区.getKey());
        選挙情報.setKijunYMD(parameter.get基準日().plusDay(1));
        選挙情報.setMeiboTorokuYMD(parameter.get基準日());
        選挙情報.setKokujiYMD(parameter.get基準日());
        選挙情報.setTenshutsuKigenYMD(parameter.get転出期限日());
        選挙情報.setTennyuKigenYMD(parameter.get転入期限日());
        選挙情報.setTohyoUketsukeYMD(parameter.get投票日());
        選挙情報.setMutohyoSenkyoFlag(Boolean.FALSE);
        return 選挙情報;
    }

    private ShohonNo get抄本番号() {
        if (SenkyojiZaisankuRStringEnum.処理種別_新規処理.getKey().equals(処理種別)) {
            CountedItem countedItem = Saiban.get(SubGyomuCode.AFA選挙本体, SenkyojiZaisankuRStringEnum.汎用キー.getKey());
            return new ShohonNo(new RString(Long.toString(countedItem.next())));
        } else {
            return new ShohonNo(parameter.get抄本番号());
        }
    }

    private AfT112SenkyoninMeiboEntity edit選挙人名簿情報(ShohonNo shohonNo,
            SenkyojiZaisankuEntity 宛名識別対象情報) {
        選挙人名簿情報 = new AfT112SenkyoninMeiboEntity();
        選挙人名簿情報.setShohonNo(shohonNo);
        選挙人名簿情報.setGroupCode(RString.EMPTY);
        選挙人名簿情報.setSatsu(RString.EMPTY);
        int 行 = 0;
        int ページ = 0;
        if (宛名識別対象情報.get選挙人名簿情報() != null) {
            行 = 宛名識別対象情報.get選挙人名簿情報().getGyo();
            ページ = 宛名識別対象情報.get選挙人名簿情報().getPage();
        }

        if (行 + 投票区コード_連番 > Integer.valueOf(ページ行数.toString())) {
            選挙人名簿情報.setPage(ページ + 1);
            選挙人名簿情報.setGyo(1);
            投票区コード_連番 = 1;
        } else {
            選挙人名簿情報.setPage(ページ);
            選挙人名簿情報.setGyo(行 + 1);
        }
        選挙人名簿情報.setSeq(new BigSerial(1));
        if (宛名識別対象情報.get宛名PSM情報() != null) {
            TohyokuCode 投票区コード = 宛名識別対象情報.get宛名PSM情報().getTohyokuCode();
            ShikibetsuCode 識別コード = 宛名識別対象情報.get宛名PSM情報().getShikibetsuCode();
            選挙人名簿情報.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            選挙人名簿情報.setTohyokuCode(投票区コード != null ? 投票区コード.getColumnValue() : RString.EMPTY);
        }
        選挙人名簿情報.setTohyokuHenkoMasshoFlag(Boolean.FALSE);
        選挙人名簿情報.setRenban(itemCount);
        選挙人名簿情報.setEdaban(0);
        return 選挙人名簿情報;
    }

    private AfT113SenkyoShikakuEntity edit選挙資格情報(SenkyojiZaisankuEntity 宛名識別対象情報) {
        選挙資格情報 = new AfT113SenkyoShikakuEntity();
        選挙資格情報.setSenkyoShurui(new Code(SennkyoSikakuShurui.財産区議会議員選挙.value()));
        選挙資格情報.setSeq(new BigSerial(1));
        選挙資格情報.setShikakuKubun(new Code(SennkyoSikakuKubun.有権者.value()));
        if (宛名識別対象情報.get宛名PSM情報() != null) {
            TohyokuCode 投票区コード = 宛名識別対象情報.get宛名PSM情報().getTohyokuCode();
            ShikibetsuCode 識別コード = 宛名識別対象情報.get宛名PSM情報().getShikibetsuCode();
            選挙資格情報.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            選挙資格情報.setTohyokuCode(投票区コード != null ? 投票区コード.getColumnValue() : RString.EMPTY);
        }
        選挙資格情報.setMeiboTorokuYMD(parameter.get登録日());
        選挙資格情報.setTorokuJiyuCode(new Code(SenkyojiZaisankuRStringEnum.登録事由コード_その他.getKey()));
        選挙資格情報.setTorokuTeishiYMD(FlexibleDate.EMPTY);
        選挙資格情報.setTorokuTeishiJiyuCode(Code.EMPTY);
        選挙資格情報.setHyojiYMD(FlexibleDate.EMPTY);
        選挙資格情報.setHyojiJiyuCode(Code.EMPTY);
        選挙資格情報.setHyojiShojoYMD(FlexibleDate.EMPTY);
        選挙資格情報.setHyojiShojoYoteiYMD(FlexibleDate.EMPTY);
        選挙資格情報.setMasshoYMD(FlexibleDate.EMPTY);
        選挙資格情報.setMasshoJiyuCode(Code.EMPTY);
        選挙資格情報.setKeikiShuryoYMD(FlexibleDate.EMPTY);
        選挙資格情報.setNikeimochiFlag(Boolean.FALSE);
        選挙資格情報.setDataTorokuYMD(FlexibleDate.getNowDate());
        return 選挙資格情報;
    }

    private AfT141ZaisankuJuminTohyoConditionEntity edit住民投票選挙人抽出条件情報(ShohonNo 抄本番号) {
        住民投票選挙人抽出条件情報 = new AfT141ZaisankuJuminTohyoConditionEntity();
        住民投票選挙人抽出条件情報.setShohonNo(抄本番号);
        住民投票選挙人抽出条件情報.setNenreiKeisanKijunYMD(parameter.get年齢期限日());
        住民投票選挙人抽出条件情報.setNenrei(0);
        住民投票選挙人抽出条件情報.setBirthdayFukumuFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setKyojuNensu(parameter.get財産区内居住年数());
        住民投票選挙人抽出条件情報.setJuteiFirstYMD(FlexibleDate.EMPTY);
        住民投票選挙人抽出条件情報.setJuteiLastYMD(FlexibleDate.EMPTY);
        住民投票選挙人抽出条件情報.setJapaneseFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setForeignerFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setJuminFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setTenshutsushaFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setTennyushaFlag(Boolean.FALSE);
        住民投票選挙人抽出条件情報.setTeishishaFukumuFlag(Boolean.FALSE);
        return 住民投票選挙人抽出条件情報;
    }

    private AfT144JushoConditionEntity edit住所抽出条件情報(ShohonNo shohonNo,
            RString 町域コード) {
        住所抽出条件情報 = new AfT144JushoConditionEntity();
        住所抽出条件情報.setShohonNo(shohonNo);
        住所抽出条件情報.setChoikiCode(new ChoikiCode(町域コード));
        return 住所抽出条件情報;
    }

    private TohyokuConditionTempTableEntity edit投票区抽出条件情報(ShohonNo 抄本番号,
            RString 投票区コード) {
        投票区抽出条件情報 = new TohyokuConditionTempTableEntity();
        投票区抽出条件情報.setShohonNo(抄本番号);
        投票区抽出条件情報.setTohyokuCode(投票区コード);
        return 投票区抽出条件情報;
    }
}
