/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectTempTableMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.TempCsvMeiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class InsertShikibetsuCodeYesProcess extends BatchProcessBase<MeiboTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select識別コードある");

    private AFABTK101SelectProcessParameter processParameter;

    private SelectTempTableMybatisParameter mybatisParameter;

    private OutputParameter<RString> outLoginPersonList;
    private RString 作成方法;

    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outLoginPersonList");
    }

    private static final RString TEMP_TABLE_NAME = new RString("LoginPersonList");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toSelectTempTableMybatisParameter();
        outLoginPersonList = new OutputParameter<>();
        作成方法 = processParameter.get作成方法();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, TempCsvMeiboEntity.class);
    }

    @Override
    protected void process(MeiboTempTableEntity entity) {
        tempDbWriter.insert(create一時テーブル(entity));
    }

    private TempCsvMeiboEntity create一時テーブル(MeiboTempTableEntity entity) {
        TempCsvMeiboEntity csvEntity = new TempCsvMeiboEntity();
        if (MeiboKaikuEdited.ファイルを指定して作成する.getKey().equals(作成方法)) {
            csvEntity.setShikibetsuCode(entity.get識別コード());
            csvEntity.setTohyokuCode(entity.get投票区コード());
            csvEntity.setYubinNo(entity.get郵便番号());
            csvEntity.setJusho(entity.get住所());
            csvEntity.setKanaShimei(entity.getカナ氏名());
            csvEntity.setKanjiShimei(entity.get氏名());
            csvEntity.setSeinengappiYMD(entity.get生年月日());
            csvEntity.setSeibetsuCode(entity.get性別());
            csvEntity.setGyogyoshaNo(entity.get漁業者番号());
            csvEntity.setKumiaiCode(entity.get組合コード());
            csvEntity.setNissuGyogyosha(entity.get漁業日数漁業者());
            csvEntity.setNissuJujisha(entity.get漁業日数漁業従事者());
            csvEntity.setGyogyoShurui(entity.get漁業種類());
            csvEntity.setGyosenShubetsu(entity.get使用漁船種別());
            csvEntity.setSenmei(entity.get船名());
            csvEntity.setTorokuNo(entity.get登録番号());
        }
        return csvEntity;
    }

    @Override
    protected void afterExecute() {
        outLoginPersonList.setValue(TEMP_TABLE_NAME);
    }

}
