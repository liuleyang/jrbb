/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103;

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
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
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
 * 海区漁業調整委員会委員選挙時登録<br>
 * 利用して準備データがinsertする。
 *
 *
 * @reamsid_L AF-0470-030 jihb
 */
public class KaikuInsertDbProcess extends BatchProcessBase<SenkyojiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select宛名識別対象");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

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
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        抄本番号List.add(processParameter.get抄本番号());
        mybatisParameter.set抄本番号List(抄本番号List);
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        if (processParameter.get基準日().getMonthValue() > 0 && processParameter.get基準日().getMonthValue() <= KaikuNumberEdit.固定数_3.getKey()) {
            mybatisParameter.set年度(new RYear(processParameter.get基準日().minusYear(2).getYear().toDateString()));
        } else if (processParameter.get基準日().getMonthValue() >= KaikuNumberEdit.固定数_4.getKey()
                && processParameter.get基準日().getMonthValue() <= KaikuNumberEdit.固定数_12.getKey()) {
            mybatisParameter.set年度(new RYear(processParameter.get基準日().minusYear(1).getYear().toDateString()));
        }
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
    protected void process(SenkyojiKaikuEntity entity) {

        if (count != 1) {
            count = 1;
            抄本番号 = get抄本番号();
            tableWriterShohon.insert(new ShohonDBEditor(抄本Entity).edit登録の抄本データ(抄本番号, processParameter, 処理種別, entity));
            tableWriterSenkyo.insert(new MeiboSenkyoDBEditor(選挙Entity).edit登録の選挙データ(抄本番号, processParameter, 処理種別, entity));
            tableWriterKaikuSenkyo.insert(new MeiboKaikuSenkyoDBEditor(海区名簿Entity).edit登録の海区名簿更新日データ(抄本番号, processParameter,
                    処理種別, entity));
        }

        頁 = 投票区コードの判定(entity, before投票区コード);

        tableWriterSenkyoShikaku.insert(new MeiboSenkyoShikakuDBEditor(選挙資格Entity).edit登録の選挙資格データ(抄本番号, processParameter, 処理種別, entity));
        tableWriterKaikuSenkyoFuzui.insert(new KaikuSenkyoFuzuiDBEditor(海区付随Entity).edit登録の海区付随情報(抄本番号, processParameter,
                処理種別, entity));

        tableWriterSenkyoninMeibo.insert(new SakuseiKaikuMeiboDBEditor(在外選挙人名簿Entity).edit登録の選挙人名簿(抄本番号, processParameter,
                処理種別, entity, 頁));

        before投票区コード = entity.getSenkyoninMeiboEntity().getTohyokuCode();

        抄本番号List.add(抄本番号);

    }

    private int 投票区コードの判定(SenkyojiKaikuEntity entity, RString before投票区コード) {
        RString 投票区コード = RString.EMPTY;
        if (entity.getSenkyoninMeiboEntity() != null) {
            投票区コード = entity.getSenkyoninMeiboEntity().getTohyokuCode() != null
                    ? entity.getSenkyoninMeiboEntity().getTohyokuCode() : RString.EMPTY;
        }
        if (before投票区コード != null && !before投票区コード.equals(投票区コード)) {
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
