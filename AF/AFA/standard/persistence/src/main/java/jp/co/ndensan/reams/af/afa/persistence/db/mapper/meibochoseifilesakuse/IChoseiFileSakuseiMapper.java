/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibochoseifilesakuse;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibochoseifilesakuse.ChoseiFileMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibochoseifilesakuse.MeiboChoseiFileSakuseiEntity;

/**
 * 名簿調製用連携ファイル作成クラスです。
 *
 * @reamsid_L AF-0300-020 lis
 */
public interface IChoseiFileSakuseiMapper {

    /**
     * 有権者情報を作成する。
     *
     * @param parameter ChoseiFileMybatisParameter
     * @return MeiboChoseiFileSakuseiEntity List<MeiboChoseiFileSakuseiEntity>
     */
    List<MeiboChoseiFileSakuseiEntity> select有権者情報(ChoseiFileMybatisParameter parameter);
}
