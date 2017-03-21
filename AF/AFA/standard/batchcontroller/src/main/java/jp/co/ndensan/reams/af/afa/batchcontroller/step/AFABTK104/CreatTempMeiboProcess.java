/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.TempSenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区漁業調整委員会委員選挙人名簿最新化する。<br/>
 * 選挙人名簿temp。
 *
 * @reamsid_L AF-0480-020 lis
 */
public class CreatTempMeiboProcess extends BatchProcessBase<AfT112SenkyoninMeiboEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select選挙人名簿By抄本番号");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;
    List<ShohonNo> 抄本番号List = new ArrayList<>();

    private OutputParameter<RString> outTempMeibo;

    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempMeibo");
    }

    private static final RString TEMP_TABLE_NAME = new RString("TempMeibo");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        outTempMeibo = new OutputParameter<>();
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        抄本番号List.add(processParameter.get抄本番号());
        mybatisParameter.set抄本番号List(抄本番号List);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, TempSenkyoninMeiboEntity.class);
    }

    @Override
    protected void process(AfT112SenkyoninMeiboEntity entity) {
        tempDbWriter.insert(create一時テーブル(entity));

    }

    private TempSenkyoninMeiboEntity create一時テーブル(AfT112SenkyoninMeiboEntity entity) {
        TempSenkyoninMeiboEntity tempTable = new TempSenkyoninMeiboEntity();
        tempTable.setShohonNo(entity.getShohonNo());
        tempTable.setGroupCode(entity.getGroupCode());
        tempTable.setGyo(entity.getGyo());
        tempTable.setPage(entity.getPage());
        tempTable.setRenban(entity.getEdaban());
        tempTable.setSatsu(entity.getSatsu());
        tempTable.setSeq(entity.getSeq());
        tempTable.setShikibetsuCode(entity.getShikibetsuCode());
        tempTable.setTohyokuCode(entity.getTohyokuCode());
        tempTable.setTohyokuHenkoMasshoFlag(entity.getTohyokuHenkoMasshoFlag());
        tempTable.setEdaban(entity.getEdaban());

        return tempTable;
    }

    @Override
    protected void afterExecute() {
        outTempMeibo.setValue(TEMP_TABLE_NAME);
    }
}
