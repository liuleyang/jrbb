/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.DataHikitsugiKubunEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当日受付データ取込バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0795-020 lis
 */
public class MochidashiPcJotaiKanriUpdateProcess extends BatchProcessBase<AfT252MochidashiPcJotaiKanriEntity> {

    private AFABTE803SelectProcessParameter parameter;
    private AFABTE803SelectProcessMyBatisParameter myBatisParameter;
    private List<ShohonNo> 抄本番号リスト;

    @BatchWriter
    private BatchPermanentTableWriter<AfT252MochidashiPcJotaiKanriEntity> tableWriter;

    @Override
    protected void initialize() {
        myBatisParameter = parameter.toAFABTE803SelectProcessMyBatisParameter();
        抄本番号リスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate."
                + "mochidashipcimportuketsukedata.IMochidashiPcImportUketsukeDataMapper.select持出端末状態管理By投票年月日"), myBatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(AfT252MochidashiPcJotaiKanriEntity.class);
    }

    @Override
    protected void process(AfT252MochidashiPcJotaiKanriEntity entity) {
        entity.setDataImportYMD(YMDHMS.now());
        entity.setDataImportKubun(DataHikitsugiKubunEnum.データ引継区分_取込済.getKeyCode());
        tableWriter.update(entity);
        抄本番号リスト.add(entity.getShohonNo());
    }

    @Override
    protected void afterExecute() {
        parameter.set抄本番号リスト(抄本番号リスト);
    }
}
