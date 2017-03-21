/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK104;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JuminJotaiCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区漁業調整委員会委員選挙人名簿最新化する。<br/>
 * 選挙資格を更新する。
 *
 * @reamsid_L AF-0480-020 lis
 */
public class KaikuSenkyoShikakuUpdateProcess extends BatchProcessBase<SenkyojiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select選挙人名簿の識別コードBy抄本番号");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private int count;

    private List<ShikibetsuCode> 識別コードList;

    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> tableWriterSenkyoShikaku;

    @BatchWriter
    private BatchPermanentTableWriter<AfT112SenkyoninMeiboEntity> tableWriterSenkyoninMeibo;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        mybatisParameter.set抄本番号(processParameter.get抄本番号());
        識別コードList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterSenkyoShikaku = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);
        tableWriterSenkyoninMeibo = new BatchPermanentTableWriter<>(AfT112SenkyoninMeiboEntity.class);
    }

    @Override
    protected void process(SenkyojiKaikuEntity entity) {

        if (entity.getShikibetsuTaishoEntity() != null && entity.getShikibetsuTaishoEntity().getJuminJotaiCode() != null
                && toRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotaiCodeEnum.住民状態コード_消除者.getKey())) {
            entity.getSenkyoShikakuEntity().setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.getSenkyoShikakuEntity().setShikakuKubun(new Code(SennkyoSikakuKubun.抹消者.value()));
            entity.getSenkyoShikakuEntity().setMasshoYMD(processParameter.get最新化時点日());
            entity.getSenkyoShikakuEntity().setMasshoJiyuCode(new Code(MasshoJiyuCodeEnum.死亡抹消.getValue()));
            tableWriterSenkyoShikaku.insert(entity.getSenkyoShikakuEntity());
            識別コードList.add(entity.getSenkyoninMeiboEntity().getShikibetsuCode());
            選挙人名簿の削除(entity);

        } else if (entity.getShikibetsuTaishoEntity() != null && entity.getShikibetsuTaishoEntity().getJuminJotaiCode() != null
                && toRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotaiCodeEnum.住民状態コード_死亡者.getKey())) {
            entity.getSenkyoShikakuEntity().setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.getSenkyoShikakuEntity().setShikakuKubun(new Code(SennkyoSikakuKubun.抹消者.value()));
            entity.getSenkyoShikakuEntity().setMasshoYMD(processParameter.get最新化時点日());
            entity.getSenkyoShikakuEntity().setMasshoJiyuCode(new Code(MasshoJiyuCodeEnum.職権消除4カ月経過抹消.getValue()));
            tableWriterSenkyoShikaku.insert(entity.getSenkyoShikakuEntity());
            識別コードList.add(entity.getSenkyoninMeiboEntity().getShikibetsuCode());
            選挙人名簿の削除(entity);

        } else if (entity.getSubAfT113Entity() != null) {

            entity.getSenkyoShikakuEntity().setSenkyoShurui(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
            entity.getSenkyoShikakuEntity().setShikakuKubun(new Code(SennkyoSikakuKubun.公民権停止.value()));
            entity.getSenkyoShikakuEntity().setMasshoYMD(processParameter.get最新化時点日());
            entity.getSenkyoShikakuEntity().setMasshoJiyuCode(new Code(MasshoJiyuCodeEnum.職権消除4カ月経過抹消.getValue()));
            entity.getSenkyoShikakuEntity().setTorokuTeishiYMD(entity.getSubAfT113Entity().getTorokuTeishiYMD());
            entity.getSenkyoShikakuEntity().setTorokuTeishiJiyuCode(entity.getSubAfT113Entity().getTorokuTeishiJiyuCode());
            entity.getSenkyoShikakuEntity().setHyojiYMD(entity.getSubAfT113Entity().getHyojiYMD());
            entity.getSenkyoShikakuEntity().setHyojiJiyuCode(entity.getSubAfT113Entity().getHyojiJiyuCode());
            entity.getSenkyoShikakuEntity().setNikeimochiFlag(entity.getSubAfT113Entity().getNikeimochiFlag());
            entity.getSenkyoShikakuEntity().setDataTorokuYMD(processParameter.get最新化時点日());
            識別コードList.add(entity.getSenkyoninMeiboEntity().getShikibetsuCode());
            tableWriterSenkyoShikaku.update(entity.getSenkyoShikakuEntity());
            選挙人名簿の削除(entity);
        }
    }

    @Override
    protected void afterExecute() {
        processParameter.set削除count(count);
        processParameter.set識別コードList(識別コードList);
    }

    private void 選挙人名簿の削除(SenkyojiKaikuEntity entity) {
        if (processParameter.is名簿並び替え有無()) {
            tableWriterSenkyoninMeibo.delete(entity.getSenkyoninMeiboEntity());
            count++;
        }
    }

    private RString toRString(RString 住民状態コード) {
        if (住民状態コード == null) {
            return RString.EMPTY;
        }
        return 住民状態コード;
    }

}
