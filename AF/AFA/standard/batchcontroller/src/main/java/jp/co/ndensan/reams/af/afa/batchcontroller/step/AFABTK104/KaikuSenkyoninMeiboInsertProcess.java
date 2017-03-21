/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.TempSenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙人名簿最新化する。<br/>
 * 選挙人名簿を更新する。
 *
 * @reamsid_L AF-0480-020 lis
 */
public class KaikuSenkyoninMeiboInsertProcess extends BatchProcessBase<TempSenkyoninMeiboEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.selectTempMeiboBy抄本番号");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private RString before投票区コード;
    private RString 海区ページ行数;

    private int i;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;

    @Override
    protected void initialize() {
        i = 1;
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        海区ページ行数 = BusinessConfig.get(
                ConfigKeysAFA.抄本_海区_ページ行数, SubGyomuCode.AFA選挙本体);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterSenkyoninMeibo = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
    }

    @Override
    protected void process(TempSenkyoninMeiboEntity temp選挙人名簿) {
        if (processParameter.is名簿並び替え有無() && processParameter.get削除count() > 0) {
            AfT112SenkyoninMeiboEntity entity = new AfT112SenkyoninMeiboEntity();
            entity.setEdaban(temp選挙人名簿.getEdaban());
            entity.setGroupCode(temp選挙人名簿.getGroupCode());
            entity.setShohonNo(temp選挙人名簿.getShohonNo());
            entity.setSatsu(temp選挙人名簿.getSatsu());
            entity.setShikibetsuCode(temp選挙人名簿.getShikibetsuCode());
            entity.setSeq(temp選挙人名簿.getSeq());
            entity.setTohyokuCode(temp選挙人名簿.getTohyokuCode());
            entity.setTohyokuHenkoMasshoFlag(temp選挙人名簿.isTohyokuHenkoMasshoFlag());

            if (isBreak(before投票区コード, temp選挙人名簿.getTohyokuCode())) {
                entity.setPage(1);
            } else {
                entity.setPage(temp選挙人名簿.getPage() + 1);
            }

            i++;
            if (i > Integer.valueOf(海区ページ行数.toString())) {
                entity.setGyo(1);
                i = 0;
            } else {
                entity.setGyo(i);
            }
            tableWriterSenkyoninMeibo.insert(entity);
            before投票区コード = temp選挙人名簿.getTohyokuCode();
        }

    }

    private boolean isBreak(RString before投票区コード, RString current投票区コード) {

        if (before投票区コード != null && current投票区コード != null
                && !before投票区コード.equals(current投票区コード)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

}
