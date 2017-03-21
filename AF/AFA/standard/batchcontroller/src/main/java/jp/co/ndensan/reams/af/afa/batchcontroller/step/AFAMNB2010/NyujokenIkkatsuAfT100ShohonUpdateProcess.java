/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * データ更新のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuAfT100ShohonUpdateProcess extends BatchProcessBase<AfT100ShohonEntity> {

    private AFABTB201SelectProcessParameter parameter;
    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectAfT100ShohonTable");
    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> tableWriter;
    private Decimal 入場券発行固有連番temp;

    @Override
    protected void initialize() {
        入場券発行固有連番temp = Decimal.ZERO;
        for (Decimal 入場券発行固有連番 : parameter.get入場券発行固有連番リスト()) {
            if (入場券発行固有連番 != null
                    && 入場券発行固有連番temp.compareTo(入場券発行固有連番) < 0) {
                入場券発行固有連番temp = 入場券発行固有連番;
            }
        }
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(AfT100ShohonEntity.class);

    }

    @Override
    protected void process(AfT100ShohonEntity entity) {
        entity.setNyujokenReportIndex(入場券発行固有連番temp);
        tableWriter.update(entity);

    }
}
