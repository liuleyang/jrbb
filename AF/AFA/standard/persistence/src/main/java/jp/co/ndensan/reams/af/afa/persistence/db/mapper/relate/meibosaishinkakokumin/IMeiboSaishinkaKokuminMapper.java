/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meibosaishinkakokumin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosaishinkakokumin.AFABTG105SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosaishinkakokumin.MeiboSaishinkaKokuminEntity;

/**
 * 投票人名簿最新化のマッパーインタフェースです。
 *
 * @reamsid_L AF-0390-030 jihb
 */
public interface IMeiboSaishinkaKokuminMapper {

    /**
     * 投票人名簿最新化データ情報を取得する。
     *
     * @param parameter AFABTG105SelectProcessMyBatisParameter
     * @return 投票人名簿最新化データ情報 List<MeiboSaishinkaKokuminEntity>
     */
    List<MeiboSaishinkaKokuminEntity> select投票人名簿最新化データ情報(AFABTG105SelectProcessMyBatisParameter parameter);

    /**
     * 投票人名簿のインサート処理します。
     *
     * @param entity AfT112SenkyoninMeiboEntity
     * @return 登録件数
     */
    int insertSenkyoninMeibo(AfT112SenkyoninMeiboEntity entity);
}
