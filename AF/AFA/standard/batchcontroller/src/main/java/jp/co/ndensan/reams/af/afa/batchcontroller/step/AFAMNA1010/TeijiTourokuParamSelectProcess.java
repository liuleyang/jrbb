/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定時登録の参数取得のクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public class TeijiTourokuParamSelectProcess extends BatchProcessBase<AfT111SenkyoEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    private static final RString 参数取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectLastKijunYMD");

    @Override
    protected void initialize() {

        parameter.set前回基準日(FlexibleDate.EMPTY);
        mybatisparameter = parameter.toBatchMybatisParameter();
    }

    @Override
    protected void createWriter() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(参数取得, mybatisparameter);
    }

    @Override
    protected void process(AfT111SenkyoEntity entity) {
        parameter.set前回基準日(entity.getKijunYMD());
    }

    @Override
    protected void afterExecute() {
    }

}
