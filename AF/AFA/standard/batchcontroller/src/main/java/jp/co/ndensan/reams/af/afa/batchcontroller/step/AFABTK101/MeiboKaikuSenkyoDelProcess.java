/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectShohonNoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 海区名簿更新日を削除します。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboKaikuSenkyoDelProcess extends BatchProcessBase<AfT131KaikuSenkyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select海区名簿更新日By抄本番号");

    private AFABTK101SelectProcessParameter processParameter;

    private SelectShohonNoMybatisParameter mybatisParameter;

    @BatchWriter
    private BatchPermanentTableWriter<AfT131KaikuSenkyoEntity> tableWriterKaikuSenkyo;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toSelectShohonNoMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterKaikuSenkyo = new BatchPermanentTableWriter<>(AfT131KaikuSenkyoEntity.class);
    }

    @Override
    protected void process(AfT131KaikuSenkyoEntity 海区名簿entity) {
        tableWriterKaikuSenkyo.delete(海区名簿entity);
    }

    @Override
    protected void afterExecute() {

    }

}
