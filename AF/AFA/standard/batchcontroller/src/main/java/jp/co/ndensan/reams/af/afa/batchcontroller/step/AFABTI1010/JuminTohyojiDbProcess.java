/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AFACommonConstant;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiChiku1ConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiChiku2ConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiChiku3ConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiGyoseikuConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiJushoConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiSenkyoDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiSenkyoninMeiboDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiShohonDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiTohyokuConditionDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyoji.JuminTohyojiZaisankuJuminDBEditor;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT145Chiku1ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyoji.JuminTohyojiEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 住民投票時登録バッチ処理クラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiDbProcess extends BatchKeyBreakBase<JuminTohyojiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.jumintohyoji.IJuminTohyojiMapper.selectJuminTohyojiList");

    private AFABTI101DbProcessParameter dbProcessParameter;

    private JuminTohyojiMybatisParameter mybatisParameter;
    private RString 処理種別;
    private static final RString 汎用キー = new RString("抄本番号");
    private ShikakuHantei shikakuHantei;
    private int i;
    private int 投票区コード_連番;
    private List<ShohonNo> 抄本番号List;
    private ShohonNo 抄本番号_採番;

    private int count;

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT141ZaisankuJuminTohyoConditionEntity 住民投票選挙人抽出条件Entity;
    private AfT142TohyokuConditionEntity 投票区抽出条件Entity;
    private AfT143GyoseikuConditionEntity 行政区抽出条件Entity;
    private AfT144JushoConditionEntity 住所抽出条件Entity;
    private AfT145Chiku1ConditionEntity 地区1抽出条件Entity;
    private AfT146Chiku2ConditionEntity 地区2抽出条件Entity;
    private AfT147Chiku3ConditionEntity 地区3抽出条件Entity;

    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> tableWriterShohon;
    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> tableWriterSenkyo;
    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;
    @BatchWriter
    private BatchPermanentTableWriter<AfT141ZaisankuJuminTohyoConditionEntity> tableWriterZaisankuJumin;
    @BatchWriter
    private BatchPermanentTableWriter<AfT142TohyokuConditionEntity> tableWriterTohyokuCondition;
    @BatchWriter
    private BatchPermanentTableWriter<AfT143GyoseikuConditionEntity> tableWriterGyoseikuCondition;
    @BatchWriter
    private BatchPermanentTableWriter<AfT144JushoConditionEntity> tableWriterJushoCondition;
    @BatchWriter
    private BatchPermanentTableWriter<AfT145Chiku1ConditionEntity> tableWriterChiku1Condition;
    @BatchWriter
    private BatchPermanentTableWriter<AfT146Chiku2ConditionEntity> tableWriterChiku2Condition;
    @BatchWriter
    private BatchPermanentTableWriter<AfT147Chiku3ConditionEntity> tableWriterChiku3Condition;

    @Override
    protected void initialize() {
        count = 0;

        mybatisParameter = dbProcessParameter.toJuminTohyojiMybatisParameter();

        処理種別 = dbProcessParameter.get処理種別();
        if (dbProcessParameter.is転出者フラグ()) {
            mybatisParameter.set消除事由コード(JukiIdoJiyu.転出.get異動事由コード());
        }

        if (dbProcessParameter.is転入者フラグ()) {
            mybatisParameter.set登録事由コード(JukiIdoJiyu.転入.get異動事由コード());
        }

        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new AfT111SenkyoEntity();

        選挙人名簿Entity = new AfT112SenkyoninMeiboEntity();
        住民投票選挙人抽出条件Entity = new AfT141ZaisankuJuminTohyoConditionEntity();
        投票区抽出条件Entity = new AfT142TohyokuConditionEntity();
        行政区抽出条件Entity = new AfT143GyoseikuConditionEntity();
        住所抽出条件Entity = new AfT144JushoConditionEntity();
        地区1抽出条件Entity = new AfT145Chiku1ConditionEntity();
        地区2抽出条件Entity = new AfT146Chiku2ConditionEntity();
        地区3抽出条件Entity = new AfT147Chiku3ConditionEntity();

        shikakuHantei = new ShikakuHantei();

        i = 0;
        抄本番号List = new ArrayList<>();
        投票区コード_連番 = 1;

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
        tableWriterZaisankuJumin = new BatchPermanentTableWriter<>(AfT141ZaisankuJuminTohyoConditionEntity.class);
        tableWriterTohyokuCondition = new BatchPermanentTableWriter<>(AfT142TohyokuConditionEntity.class);
        tableWriterGyoseikuCondition = new BatchPermanentTableWriter<>(AfT143GyoseikuConditionEntity.class);
        tableWriterJushoCondition = new BatchPermanentTableWriter<>(AfT144JushoConditionEntity.class);
        tableWriterChiku1Condition = new BatchPermanentTableWriter<>(AfT145Chiku1ConditionEntity.class);
        tableWriterChiku2Condition = new BatchPermanentTableWriter<>(AfT146Chiku2ConditionEntity.class);
        tableWriterChiku3Condition = new BatchPermanentTableWriter<>(AfT147Chiku3ConditionEntity.class);

    }

    @Override
    protected void usualProcess(JuminTohyojiEntity entity) {
        insert住民投票時登録対象(entity);
    }

    @Override
    protected void keyBreakProcess(JuminTohyojiEntity entity) {
        if (hasBreakBy投票区(getBefore(), entity)) {
            投票区コード_連番 = 1;
        } else {
            投票区コード_連番++;
        }
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

    private void insert住民投票時登録対象(JuminTohyojiEntity entity) {

        if (dbProcessParameter.is抽出対象者に公民権停止者の人を含めるフラグ()) {
            insertDB(entity);
        } else if (!shikakuHantei.is公民権停止者(entity.getUaFt200Entity(),
                entity.getAfT113Entity(), dbProcessParameter.get年齢条件の生年月日(), FlexibleDate.getNowDate())) {
            insertDB(entity);
        }
    }

    private ShohonNo get抄本番号() {
        if (処理種別.equals(new RString("1"))) {
            CountedItem countedItem = Saiban.get(SubGyomuCode.AFA選挙本体, 汎用キー);
            抄本番号_採番 = new ShohonNo(new RString(Long.toString(countedItem.next())));
        } else {
            抄本番号_採番 = dbProcessParameter.get抄本番号();
        }
        return 抄本番号_採番;
    }

    private void insertDB(JuminTohyojiEntity entity) {
        if (dbProcessParameter.is期間中_年以上連続で居住フラグ()) {
            int 連続居住年数 = 0;
            FlexibleDate 消除異動年月日 = entity.getUaFt200Entity().getShojoIdoYMD();
            FlexibleDate 登録異動年月日 = entity.getUaFt200Entity().getTorokuIdoYMD();
            if (消除異動年月日 != null && !消除異動年月日.isEmpty() && 登録異動年月日 != null && !登録異動年月日.isEmpty()) {
                連続居住年数 = new RDate(消除異動年月日.toString()).minusYear(登録異動年月日.getYearValue())
                        .getYearValue();
            }
            if (Integer.valueOf(dbProcessParameter.get期間中_年以上連続で居住().toString()) <= 連続居住年数) {
                setデータ登録(entity);
            }
        } else {
            setデータ登録(entity);
        }

    }

    private void setデータ登録(JuminTohyojiEntity entity) {

        if (count != 1) {
            count = 1;
            抄本番号_採番 = get抄本番号();
            tableWriterShohon.insert(new JuminTohyojiShohonDBEditor(抄本Entity).edit抄本データの編集(抄本番号_採番, dbProcessParameter));
            tableWriterSenkyo.insert(new JuminTohyojiSenkyoDBEditor(選挙Entity).edit選挙データの編集(抄本番号_採番, dbProcessParameter));
            tableWriterZaisankuJumin.insert(new JuminTohyojiZaisankuJuminDBEditor(住民投票選挙人抽出条件Entity).
                    edit財産区データの編集(抄本番号_採番, dbProcessParameter));

            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.投票区)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterTohyokuCondition.insert(new JuminTohyojiTohyokuConditionDBEditor(投票区抽出条件Entity).
                            edit投票区抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }

            }

            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.行政区)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterGyoseikuCondition.insert(new JuminTohyojiGyoseikuConditionDBEditor(行政区抽出条件Entity).
                            edit行政区抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }
            }

            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.住所)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterJushoCondition.insert(new JuminTohyojiJushoConditionDBEditor(住所抽出条件Entity).
                            edit住所抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }
            }
            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.地区1)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterChiku1Condition.insert(new JuminTohyojiChiku1ConditionDBEditor(地区1抽出条件Entity).
                            edit地区1抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }
            }

            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.地区2)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterChiku2Condition.insert(new JuminTohyojiChiku2ConditionDBEditor(地区2抽出条件Entity).
                            edit地区2抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }
            }
            if (dbProcessParameter.get住所条件().equals(AFACommonConstant.地区3)) {
                for (RString 住所条件選択コード : dbProcessParameter.get住所条件選択コードリスト()) {
                    tableWriterChiku3Condition.insert(new JuminTohyojiChiku3ConditionDBEditor(地区3抽出条件Entity).
                            edit地区3抽出条件データの編集(抄本番号_採番, 住所条件選択コード));
                }
            }
        }

        i++;
        tableWriterSenkyoninMeibo.insert(new JuminTohyojiSenkyoninMeiboDBEditor(選挙人名簿Entity).
                edit選挙人名簿データの編集(抄本番号_採番, dbProcessParameter, entity, i, 投票区コード_連番));

        抄本番号List.add(抄本番号_採番);
    }

    @Override
    protected void afterExecute() {
        dbProcessParameter.set抄本番号List(抄本番号List);
    }
}
