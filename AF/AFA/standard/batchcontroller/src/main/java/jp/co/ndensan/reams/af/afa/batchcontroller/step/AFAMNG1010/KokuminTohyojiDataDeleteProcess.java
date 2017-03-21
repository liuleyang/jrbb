/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.SenkyojiTourokuDataDeleteEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票時登録データ削除のクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
public class KokuminTohyojiDataDeleteProcess extends BatchProcessBase<SenkyojiTourokuDataDeleteEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private TeijiTourokuDataDeleteMybatisParameter mybatisparameter;
    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectKokuminTohyojiDataDeleteTrgt");
    private static final int 投票状態 = 1;
    private static final int 選挙人名簿 = 2;
    private static final int 選挙 = 3;
    private static final int 在外選挙人名簿 = 4;

    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> aft111Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> aft112Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT201TohyoJokyoEntity> aft201Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT121ZaigaiSenkyoninMeiboEntity> aft121Writer;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toTeijiTourokuDataDeleteMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新データ抽出, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        aft111Writer = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
        aft112Writer = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
        aft201Writer = new BatchPermanentTableWriter<>(AfT201TohyoJokyoEntity.class);
        aft121Writer = new BatchPermanentTableWriter<>(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    @Override
    protected void process(SenkyojiTourokuDataDeleteEntity entity) {

        switch (entity.getType()) {
            case 投票状態:
                aft201Writer.delete(entity.getTohyoJokyoEntity());
                break;
            case 選挙人名簿:
                aft112Writer.delete(entity.getSenkyoninMeiboEntity());
                break;
            case 選挙:
                aft111Writer.delete(entity.getSenkyoEntity());
                break;
            case 在外選挙人名簿:
                aft121Writer.delete(entity.getZaigaiSenkyoninMeiboEntity());
                break;
            default:
        }

    }

    @Override
    protected void afterExecute() {

    }

}
