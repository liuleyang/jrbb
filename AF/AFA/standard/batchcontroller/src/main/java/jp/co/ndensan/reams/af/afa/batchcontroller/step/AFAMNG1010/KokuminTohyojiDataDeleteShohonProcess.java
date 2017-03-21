/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
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

/**
 * 国民投票時登録データ削除のクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
public class KokuminTohyojiDataDeleteShohonProcess extends BatchProcessBase<AfT100ShohonEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private TeijiTourokuDataDeleteMybatisParameter mybatisparameter;
    private static final RString 更新データ抽出 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectKokuminTohyojiDataDeleteTrgtShohon");
    private static final RString 新規作成 = new RString("1");

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

        aft100Writer.delete(entity);
        研修用発番抄本番号 = entity.getSimulationShohonNo();

    }

    @Override
    protected void afterExecute() {

        updateDataTables();

    }

    private void updateDataTables() {

        ShohonNo 発番抄本番号 = parameter.get抄本番号();
        if (新規作成.equals(parameter.get処理種別())) {
            発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体, new RString("抄本番号")).nextString());
            研修用発番抄本番号 = null;
            研修用発番抄本番号 = new ShohonNo(Saiban.get(SubGyomuCode.AFA選挙本体,
                    new RString("抄本番号シミュレーション")).nextString());
            parameter.set研修用発番抄本番号(研修用発番抄本番号);
            insertData(研修用発番抄本番号, 研修用発番抄本番号);
        }
        parameter.set抄本番号(発番抄本番号);
        shohonNo.setValue(発番抄本番号);

        insertData(発番抄本番号, 研修用発番抄本番号);

    }

    private void insertData(ShohonNo 発番抄本番号, ShohonNo 研修用発番抄本番号) {
        AfT100ShohonEntity 抄本情報 = new AfT100ShohonEntity();
        抄本情報.setShohonNo(発番抄本番号);
        抄本情報.setSenkyoShurui(new Code(SenkyoShurui.憲法改正国民投票.getCode()));
        抄本情報.setShohonName(parameter.get抄本名());
        抄本情報.setTohyoYMD(parameter.get投票日());
        抄本情報.setKiteiNenreiTotatsuYMD(parameter.get年齢到達日());
        抄本情報.setShoriYMD(FlexibleDate.getNowDate());
        抄本情報.setNyujokenReportIndex(Decimal.ZERO);
        if (研修用発番抄本番号 != null) {
            抄本情報.setSimulationShohonNo(研修用発番抄本番号);
        }
        aft100Writer.insert(抄本情報);

        for (AFABTB101Senkyoichiran 選挙一覧 : parameter.get選挙一覧リスト()) {
            AfT111SenkyoEntity 選挙情報 = new AfT111SenkyoEntity();
            選挙情報.setShohonNo(発番抄本番号);
            選挙情報.setSenkyoNo(選挙一覧.getSenkyoNo());
            選挙情報.setSenkyoLevel(new Code(SennkyoLevel.その他.value()));
            選挙情報.setSenkyoName(選挙一覧.getSenkyoName());
            選挙情報.setSenkyoRyakusho(選挙一覧.getSenkyoRyakusho());
            選挙情報.setSenkyoMark(RString.EMPTY);
            選挙情報.setKokujiYMD(FlexibleDate.EMPTY);
            選挙情報.setKijunYMD(parameter.get基準日());
            選挙情報.setMeiboTorokuYMD(parameter.get名簿登録日());
            選挙情報.setTenshutsuKigenYMD(parameter.get特定期間開始日());
            選挙情報.setTennyuKigenYMD(parameter.get特定期限日());
            選挙情報.setTohyoUketsukeYMD(parameter.get受付開始日());
            選挙情報.setMutohyoSenkyoFlag(false);
            aft111Writer.insert(選挙情報);
        }

    }
}
