/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNL1010;

import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録バッチ処理クラスです。<br/>
 * 投票区抽出条件のデータを物理削除する。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuTohyokuConditionDelProcess extends BatchProcessBase<AfT142TohyokuConditionEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyojizaisanku.ISenkyojiZaisankuMapper.select投票区抽出条件By抄本番号");

    private AFABTL101SelectProcessParameter parameter;
    private AFABTL101SelectProcessMyBatisParameter mybatisparameter;

    @BatchWriter
    private BatchPermanentTableWriter<AfT142TohyokuConditionEntity> tableWriter;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toAFABTL101SelectProcessMyBatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(AfT142TohyokuConditionEntity.class);
    }

    @Override
    protected void process(AfT142TohyokuConditionEntity 投票区抽出条件Entity) {
        tableWriter.delete(投票区抽出条件Entity);
    }

    @Override
    protected void afterExecute() {

    }

}
