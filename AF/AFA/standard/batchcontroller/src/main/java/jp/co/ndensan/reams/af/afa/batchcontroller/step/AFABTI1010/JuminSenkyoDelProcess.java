/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTI1010;

import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiDelMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録バッチ処理クラスです。<br/>
 * 選挙のデータを物理削除する。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminSenkyoDelProcess extends BatchProcessBase<AfT111SenkyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.jumintohyoji.IJuminTohyojiMapper.select選挙By抄本番号");

    private AFABTI101DbProcessParameter dbProcessParameter;
    private JuminTohyojiDelMybatisParameter mybatisParameter;

    private RString 処理種別;

    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> tableWriterSenkyo;

    @Override
    protected void initialize() {
        処理種別 = dbProcessParameter.get処理種別();
        mybatisParameter = dbProcessParameter.toJuminTohyojiDelMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterSenkyo = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
    }

    @Override
    protected void process(AfT111SenkyoEntity 選挙Entity) {
        if (処理種別.equals(MeiboKaikuEdited.再処理.getKey())) {
            tableWriterSenkyo.delete(選挙Entity);
        }
    }

    @Override
    protected void afterExecute() {

    }

}
