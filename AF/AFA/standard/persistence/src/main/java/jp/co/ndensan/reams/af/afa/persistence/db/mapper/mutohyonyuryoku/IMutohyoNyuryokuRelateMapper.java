/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.mutohyonyuryoku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.JotaiHenkoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.MutohyoNyuryokuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.JotaiHenkoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku.MutohyoNyuryokuEntity;

/**
 * 投票情報クラスです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public interface IMutohyoNyuryokuRelateMapper {

    /**
     * インスタンスを生成します。
     *
     * @param key 検索条件
     * @return 選挙人名簿抄本
     */
    List<MutohyoNyuryokuEntity> getTohyoJokyoJoho(MutohyoNyuryokuMybatisParameter key);

    /**
     * インスタンスを生成します。
     *
     * @param key 状態変更検索条件
     * @return 投票状態情報
     */
    List<JotaiHenkoEntity> getJotaiHenkoJoho(JotaiHenkoMybatisParameter key);

}
