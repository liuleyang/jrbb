/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShoriModel;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper;
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
 * 定時登録データ削除のクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public class TeijiTourokuDataDeleteShohonProcess extends BatchProcessBase<AfT100ShohonEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private TeijiTourokuDataDeleteMybatisParameter mybatisparameter;
    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectTeijiTourokuDataDeleteTrgtShohon");
    private static final RString 新規作成 = new RString("1");
    private static final RString 定時 = new RString("定時");

    private AfaMapperProvider mapperProvider;
    private IAFABTA101Mapper mapper;

    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> aft100Writer;
    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> aft111Writer;

    private OutputParameter<ShohonNo> shohonNo;
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
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IAFABTA101Mapper.class);
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
            if (ShoriModel.通常処理.code().equals(parameter.get処理モード())) {
                発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体, new RString("抄本番号")).nextString());
            } else {
                発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体, new RString("抄本番号シミュレーション")).nextString());
            }
        }
        parameter.setShohonNo(発番抄本番号);
        shohonNo.setValue(発番抄本番号);

        AfT100ShohonEntity 抄本情報 = new AfT100ShohonEntity();
        抄本情報.setShohonNo(発番抄本番号);
        抄本情報.setSenkyoShurui(new Code(SenkyoShurui.定時登録.getCode()));
        抄本情報.setShohonName(parameter.getShohonMei());
        抄本情報.setTohyoYMD(parameter.getTouhyobi());
        抄本情報.setKiteiNenreiTotatsuYMD(parameter.getNenreiKigenbi());
        抄本情報.setShoriYMD(FlexibleDate.getNowDate());
        抄本情報.setNyujokenReportIndex(Decimal.ZERO);
        抄本情報.setSimulationShohonNo(発番抄本番号);
        aft100Writer.insert(抄本情報);

        AfT111SenkyoEntity 選挙情報 = new AfT111SenkyoEntity();
        選挙情報.setShohonNo(発番抄本番号);
        選挙情報.setSenkyoNo(new SenkyoNo(1));
        選挙情報.setSenkyoLevel(new Code(SennkyoLevel.その他.value()));
        選挙情報.setSenkyoName(parameter.getShohonMei());
        選挙情報.setSenkyoRyakusho(SenkyoShurui.定時登録.toRString());
        選挙情報.setSenkyoMark(定時);
        選挙情報.setKokujiYMD(parameter.getKijunbi().plusDay(1));
        選挙情報.setKijunYMD(parameter.getKijunbi());
        選挙情報.setMeiboTorokuYMD(parameter.getTourokubi());
        選挙情報.setTenshutsuKigenYMD(parameter.getTenshutuKigenbi());
        選挙情報.setTennyuKigenYMD(parameter.getTennyuKigenbi());
        選挙情報.setTohyoUketsukeYMD(FlexibleDate.EMPTY);
        選挙情報.setMutohyoSenkyoFlag(false);
        aft111Writer.insert(選挙情報);

    }
}
