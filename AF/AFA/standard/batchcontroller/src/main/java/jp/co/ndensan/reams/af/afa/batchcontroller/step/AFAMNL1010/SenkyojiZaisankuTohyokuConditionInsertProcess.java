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
 * 財産区議会議員選挙時登録バッチ処理クラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class SenkyojiZaisankuTohyokuConditionInsertProcess extends BatchProcessBase<AfT142TohyokuConditionEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyojizaisanku.ISenkyojiZaisankuMapper.select投票区抽出条件");
    private AFABTL101SelectProcessMyBatisParameter mybatisParameter;
    private AFABTL101SelectProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter<AfT142TohyokuConditionEntity> tableWriterTohyokuCondition;

    @Override
    protected void initialize() {
        mybatisParameter = parameter.toAFABTL101SelectProcessMyBatisParameter();
        mybatisParameter.setTable(parameter.getTable());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterTohyokuCondition = new BatchPermanentTableWriter<>(AfT142TohyokuConditionEntity.class);
    }

    @Override
    protected void process(AfT142TohyokuConditionEntity entity) {
        tableWriterTohyokuCondition.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }

}
