/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 選挙時登録データ削除のクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class SenkyojiTourokuDataDeleteShohonProcess extends BatchProcessBase<AfT100ShohonEntity> {

    private static final RString 処理モード_シミュレーション = new RString("2");
    private AFABTB101SelectProcessParameter parameter;
    private TeijiTourokuDataDeleteMybatisParameter mybatisparameter;
    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectSenkyojiTourokuDataDeleteTrgtShohon");
    private static final RString 新規作成 = new RString("1");

    private AfaMapperProvider mapperProvider;
    private IAFABTB101Mapper mapper;

    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> aft100Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> aft111Writer;

    private OutputParameter<ShohonNo> shohonNo;
    private ShohonNo 研修用発番抄本番号;
    /**
     * 抄本番号です。
     */
    public static final RString SHOHON_NO;

    static {
        SHOHON_NO = new RString("shohonNo");
    }

    @Override
    protected void beforeExecute() {
        shohonNo = new OutputParameter<>();
    }

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toTeijiTourokuDataDeleteMybatisParameter();
        研修用発番抄本番号 = null;
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IAFABTB101Mapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新データ抽出, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        aft100Writer = new BatchPermanentTableWriter<>(AfT100ShohonEntity.class);
        aft111Writer = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
    }

    @Override
    protected void process(AfT100ShohonEntity entity) {

        研修用発番抄本番号 = entity.getSimulationShohonNo();

    }

    @Override
    protected void afterExecute() {

        mapper.deleteMeibo(mybatisparameter);
        mapper.deleteSenkyo(mybatisparameter);
        mapper.deleteZaigai(mybatisparameter);
        mapper.deleteShohon(mybatisparameter);

        updateDataTables();

    }

    private void updateDataTables() {

        ShohonNo 発番抄本番号 = parameter.getShohonNo();
        if (新規作成.equals(parameter.getShuriShubetu())) {
            if (処理モード_シミュレーション.equals(parameter.get処理モード())) {
                発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体, new RString("抄本番号シミュレーション")).nextString());
            } else {
                発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体, new RString("抄本番号")).nextString());
            }
            研修用発番抄本番号 = null;
            if (parameter.get研修用データも作成有無()) {
                研修用発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体,
                        new RString("抄本番号シミュレーション")).nextString());
                parameter.set研修用発番抄本番号(研修用発番抄本番号);
                insertData(研修用発番抄本番号, 研修用発番抄本番号);
            }
        }
        parameter.setShohonNo(発番抄本番号);
        shohonNo.setValue(発番抄本番号);

        insertData(発番抄本番号, 研修用発番抄本番号);

    }

    private void insertData(ShohonNo 発番抄本番号, ShohonNo 研修用発番抄本番号) {
        AfT100ShohonEntity 抄本情報 = new AfT100ShohonEntity();
        抄本情報.setShohonNo(発番抄本番号);
        抄本情報.setSenkyoShurui(new Code(SenkyoShurui.国政選挙_地方選挙.getCode()));
        抄本情報.setShohonName(parameter.getShohonMei());
        抄本情報.setTohyoYMD(parameter.getTouhyobi());
        抄本情報.setKiteiNenreiTotatsuYMD(parameter.getNenreiKigenbi());
        抄本情報.setShoriYMD(FlexibleDate.getNowDate());
        抄本情報.setNyujokenReportIndex(Decimal.ZERO);
        if (研修用発番抄本番号 != null) {
            抄本情報.setSimulationShohonNo(研修用発番抄本番号);
        }
        aft100Writer.insert(抄本情報);

        for (AFABTB101Senkyoichiran 選挙一覧 : parameter.get選択一覧リスト()) {
            AfT111SenkyoEntity 選挙情報 = new AfT111SenkyoEntity();
            選挙情報.setShohonNo(発番抄本番号);
            選挙情報.setSenkyoNo(選挙一覧.getSenkyoNo());
            選挙情報.setSenkyoLevel(選挙一覧.getSenkyoLevel());
            選挙情報.setSenkyoName(選挙一覧.getSenkyoName());
            選挙情報.setSenkyoRyakusho(選挙一覧.getSenkyoRyakusho());
            選挙情報.setSenkyoMark(選挙一覧.getSenkyoMark());
            選挙情報.setKokujiYMD(選挙一覧.getKokujiYMD());
            選挙情報.setKijunYMD(選挙一覧.getKijunYMD());
            選挙情報.setMeiboTorokuYMD(選挙一覧.getMeiboTorokuYMD());
            選挙情報.setTenshutsuKigenYMD(選挙一覧.getTenshutsuKigenYMD());
            選挙情報.setTennyuKigenYMD(選挙一覧.getTennyuKigenYMD());
            選挙情報.setTohyoUketsukeYMD(選挙一覧.getTohyoUketsukeYMD());
            選挙情報.setMutohyoSenkyoFlag(false);
            aft111Writer.insert(選挙情報);
        }

    }
}
