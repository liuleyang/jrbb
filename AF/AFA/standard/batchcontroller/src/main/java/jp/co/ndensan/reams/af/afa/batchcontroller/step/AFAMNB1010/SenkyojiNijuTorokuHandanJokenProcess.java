/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二重登録系の帳票作成条件のクラスです。
 *
 * @reamsid_L AF-0030-034 qiuxy
 */
public class SenkyojiNijuTorokuHandanJokenProcess extends SimpleBatchProcessBase {

    private IAFABTB101Mapper handanJokenMapper;
    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    /**
     * OutputParameter用キー isShutsuryoku
     */
    public static final RString IS_SHUTSURYOKU;

    static {
        IS_SHUTSURYOKU = new RString("isShutsuryoku");
    }

    OutputParameter<Boolean> isShutsuryoku;

    @Override
    protected void beforeExecute() {
        isShutsuryoku = new OutputParameter<>();
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        handanJokenMapper = getMapper(IAFABTB101Mapper.class);
    }

    @Override
    protected void process() {
        List<AfT111SenkyoEntity> entityList = handanJokenMapper.selectSenkyojiNijuTorokuHandanJoken(mybatisparameter);
        isShutsuryoku.setValue(entityList != null && !entityList.isEmpty());
    }
}
