/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙時登録の参数取得のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuParamSelectProcess extends BatchProcessBase<AfT111SenkyoEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;

    private static final RString 参数取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectLastKijunYMD");

    @Override
    protected void initialize() {

        parameter.set前回基準日(FlexibleDate.EMPTY);
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
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
