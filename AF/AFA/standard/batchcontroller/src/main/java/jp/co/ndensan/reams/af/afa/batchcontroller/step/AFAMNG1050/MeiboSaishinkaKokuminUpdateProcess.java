/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1050;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JuminJotaiCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeZaigai;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosaishinkakokumin.AFABTG105SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosaishinkakokumin.AFABTG105SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosaishinkakokumin.MeiboSaishinkaKokuminEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meibosaishinkakokumin.IMeiboSaishinkaKokuminMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票人名簿最新化バッチ処理クラスです。
 *
 * @reamsid_L AF-0390-030 jihb
 */
public class MeiboSaishinkaKokuminUpdateProcess extends BatchProcessBase<MeiboSaishinkaKokuminEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meibosaishinkakokumin.IMeiboSaishinkaKokuminMapper.select投票人名簿最新化データ情報");
    private AFABTG105SelectProcessParameter parameter;
    private AFABTG105SelectProcessMyBatisParameter mybatisParameter;
    private IMeiboSaishinkaKokuminMapper mapper;
    private AfT113SenkyoShikakuEntity 選挙資格情報;
    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private Boolean 名簿並び替え;
    @BatchWriter
    private BatchPermanentTableWriter<AfT113SenkyoShikakuEntity> tableWriterSenkyoShikaku;

    @Override
    protected void initialize() {
        mybatisParameter = parameter.toAFABTG105SelectProcessMyBatisParameter();
        mybatisParameter.set選挙種類(SenkyoShurui.憲法改正国民投票.getCode());
        選挙人名簿情報 = new AfT112SenkyoninMeiboEntity();
        選挙資格情報 = new AfT113SenkyoShikakuEntity();
        名簿並び替え = parameter.get名簿並び替え();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        mapper = getMapper(IMeiboSaishinkaKokuminMapper.class);
        tableWriterSenkyoShikaku = new BatchPermanentTableWriter<>(AfT113SenkyoShikakuEntity.class);

    }

    @Override
    protected void process(MeiboSaishinkaKokuminEntity 投票人名簿最新化情報) {
        if (名簿並び替え) {
            tableWriterSenkyoShikaku.insert(edit選挙資格情報(投票人名簿最新化情報));
            mapper.insertSenkyoninMeibo(edit選挙人名簿情報(投票人名簿最新化情報));
        } else {
            tableWriterSenkyoShikaku.insert(edit選挙資格情報(投票人名簿最新化情報));
        }

    }

    @Override
    protected void afterExecute() {

    }

    private AfT112SenkyoninMeiboEntity edit選挙人名簿情報(MeiboSaishinkaKokuminEntity 投票人名簿最新化情報) {
        選挙人名簿情報 = 投票人名簿最新化情報.get選挙人名簿情報();
        選挙人名簿情報.setSeq(new BigSerial(投票人名簿最新化情報.get選挙人名簿情報().getSeq().getValue() + 1));
        if (JuminJotaiCodeEnum.住民状態コード_死亡者.getKey()
                .equals(投票人名簿最新化情報.get宛名PSM情報().getJuminJotaiCode())) {
            選挙人名簿情報.setIsDeleted(Boolean.TRUE);
        } else {
            選挙人名簿情報.setIsDeleted(Boolean.FALSE);
        }
        return 選挙人名簿情報;
    }

    private AfT113SenkyoShikakuEntity edit選挙資格情報(MeiboSaishinkaKokuminEntity 投票人名簿最新化情報) {
        選挙資格情報 = 投票人名簿最新化情報.get選挙資格情報();
        選挙資格情報.setSenkyoShurui(new Code(SenkyoShurui.憲法改正国民投票.getCode()));
        if (投票人名簿最新化情報.get宛名PSM情報() != null) {
            ShikibetsuCode 識別コード = 投票人名簿最新化情報.get宛名PSM情報().getShikibetsuCode();
            選挙資格情報.setShikibetsuCode(識別コード == null ? ShikibetsuCode.EMPTY : 識別コード);
        }
        if (投票人名簿最新化情報.get宛名PSM情報() != null
                && JuminJotaiCodeEnum.住民状態コード_死亡者.getKey()
                .equals(投票人名簿最新化情報.get宛名PSM情報().getJuminJotaiCode())) {
            選挙資格情報.setShikakuKubun(new Code(SennkyoSikakuKubun.抹消者.value()));
            FlexibleDate 消除異動年月日 = 投票人名簿最新化情報.get宛名PSM情報().getShojoIdoYMD();
            選挙資格情報.setMasshoYMD(消除異動年月日 == null ? FlexibleDate.EMPTY : 消除異動年月日);
            選挙資格情報.setMasshoJiyuCode(new Code(MasshoJiyuCodeZaigai.死亡抹消.getKey()));
            選挙資格情報.setKeikiShuryoYMD(FlexibleDate.EMPTY);
            選挙資格情報.setNikeimochiFlag(Boolean.FALSE);

        }
        選挙資格情報.setDataTorokuYMD(FlexibleDate.getNowDate());
        return 選挙資格情報;
    }
}
