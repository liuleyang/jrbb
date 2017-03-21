/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二重登録系の帳票作成条件のクラスです。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
public class NijuTorokuHandanJokenProcess extends SimpleBatchProcessBase {

    private IAFABTA101Mapper nijuTorokuHandanJokenMapper;
    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

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
        mybatisparameter = parameter.toBatchMybatisParameter();
        nijuTorokuHandanJokenMapper = getMapper(IAFABTA101Mapper.class);
    }

    @Override
    protected void process() {
        List<AfT111SenkyoEntity> entityList = nijuTorokuHandanJokenMapper.selectNijuTorokuHandanJoken(mybatisparameter);
        isShutsuryoku.setValue(entityList != null && !entityList.isEmpty());
    }

}
