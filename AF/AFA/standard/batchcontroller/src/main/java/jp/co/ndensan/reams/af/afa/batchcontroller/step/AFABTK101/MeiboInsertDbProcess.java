/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.KaikuSenkyoFuzuiDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboKaikuSenkyoDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboSenkyoDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.MeiboSenkyoShikakuDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.SakuseiKaikuMeiboDBEditor;
import jp.co.ndensan.reams.af.afa.business.core.meibosakuseikaiku.ShohonDBEditor;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectTempTableMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成バッチ処理クラスです。<br>
 * 準備データです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public class MeiboInsertDbProcess extends BatchProcessBase<AFABTK101tempTblEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper.select一時テーブル");

    private AFABTK101SelectProcessParameter processParameter;

    private SelectTempTableMybatisParameter mybatisParameter;

    private RString 処理種別;

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT131KaikuSenkyoEntity 海区名簿Entity;
    private AfT133KaikuSenkyoFuzuiEntity 海区付随Entity;
    private AfT112SenkyoninMeiboEntity 在外選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;

    private RString before投票区コード;

    private int 頁;

    private List<ShohonNo> 抄本番号List;

    private ShohonNo 抄本番号;

    private int count;

    @BatchWriter
    private BatchPermanentTableWriter<AfT100ShohonEntity> tableWriterShohon;

    @BatchWriter
    private BatchPermanentTableWriter<AfT111SenkyoEntity> tableWriterSenkyo;

    @BatchWriter
    private BatchPermanentTableWriter<AfT131KaikuSenkyoEntity> tableWriterKaikuSenkyo;

    @BatchWriter
    private BatchPermanentTableWriter<AfT133KaikuSenkyoFuzuiEntity> tableWriterKaikuSenkyoFuzui;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;

    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> tableWriterSenkyoShikaku;

    @Override
    protected void initialize() {
        抄本番号List = new ArrayList<>();
        mybatisParameter = processParameter.toSelectTempTableMybatisParameter();
        抄本番号List.add(processParameter.get抄本番号());
        mybatisParameter.set抄本番号List(抄本番号List);
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        mybatisParameter.set年度(new RYear(processParameter.get基準日().minusYear(1).getYear().toDateString()));
        頁 = 1;
        処理種別 = processParameter.get処理種別();
        before投票区コード = RString.EMPTY;
        抄本Entity = new AfT100ShohonEntity();
        選挙Entity = new AfT111SenkyoEntity();

        海区名簿Entity = new AfT131KaikuSenkyoEntity();
        海区付随Entity = new AfT133KaikuSenkyoFuzuiEntity();
        在外選挙人名簿Entity = new AfT112SenkyoninMeiboEntity();
        選挙資格Entity = new AfT113SenkyoShikakuEntity();

        抄本番号List = new ArrayList<>();
        count = 0;

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterShohon = new BatchPermanentTableWriter<>(AfT100ShohonEntity.class);
        tableWriterSenkyo = new BatchPermanentTableWriter<>(AfT111SenkyoEntity.class);
        tableWriterKaikuSenkyo = new BatchPermanentTableWriter<>(AfT131KaikuSenkyoEntity.class);
        tableWriterKaikuSenkyoFuzui = new BatchPermanentTableWriter<>(AfT133KaikuSenkyoFuzuiEntity.class);
        tableWriterSenkyoninMeibo = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
        tableWriterSenkyoShikaku = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);
    }

    @Override
    protected void process(AFABTK101tempTblEntity entity) {

        if (count != 1) {
            count = 1;
            抄本番号 = get抄本番号();
            tableWriterShohon.insert(new ShohonDBEditor(抄本Entity).edit抄本データ(抄本番号, processParameter, 処理種別));
            tableWriterSenkyo.insert(new MeiboSenkyoDBEditor(選挙Entity).edit選挙データ(抄本番号, processParameter, 処理種別, entity));
            tableWriterKaikuSenkyo.insert(new MeiboKaikuSenkyoDBEditor(海区名簿Entity).edit海区名簿更新日データ(抄本番号, processParameter,
                    処理種別, entity));
        }

        頁 = 投票区コードの判定(entity, before投票区コード);

        tableWriterSenkyoShikaku.insert(new MeiboSenkyoShikakuDBEditor(選挙資格Entity).edit選挙資格データ(抄本番号, processParameter, 処理種別, entity));
        tableWriterKaikuSenkyoFuzui.insert(new KaikuSenkyoFuzuiDBEditor(海区付随Entity).insert海区付随情報(抄本番号, processParameter,
                処理種別, entity));

        tableWriterSenkyoninMeibo.insert(new SakuseiKaikuMeiboDBEditor(在外選挙人名簿Entity).insert選挙人名簿(抄本番号, processParameter,
                処理種別, entity, 頁));

        before投票区コード = entity.getTohyokuCodeAdd();

        抄本番号List.add(抄本番号);
    }

    private int 投票区コードの判定(AFABTK101tempTblEntity entity, RString before投票区コード) {
        RString 投票区コード = entity.getTohyokuCodeAdd();
        if (before投票区コード != null && 投票区コード != null && !before投票区コード.equals(投票区コード)) {
            頁 = 1;
        } else if (before投票区コード != null && before投票区コード.equals(投票区コード)) {
            頁++;
        }
        return 頁;
    }

    private ShohonNo get抄本番号() {
        ShohonNo 抄本番号_採番;
        if (処理種別.equals(MeiboKaikuEdited.新規処理.getKey())) {
            CountedItem countedItem = Saiban.get(SubGyomuCode.AFA選挙本体, OutputKeys.汎用キー.getValue());
            抄本番号_採番 = new ShohonNo(new RString(Long.toString(countedItem.next())));
        } else {
            抄本番号_採番 = processParameter.get抄本番号();
        }
        return 抄本番号_採番;
    }

    @Override
    protected void afterExecute() {
        processParameter.set抄本番号List(抄本番号List);

    }

}
