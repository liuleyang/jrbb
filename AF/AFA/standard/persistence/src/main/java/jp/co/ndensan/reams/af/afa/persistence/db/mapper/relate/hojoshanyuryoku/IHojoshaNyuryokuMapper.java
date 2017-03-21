/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.hojoshanyuryoku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.hojoshanyuryoku.HojoshaNyuryokuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshanyuryoku.HojoshaNyuryokuEntity;

/**
 * 補助者入力用マッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
public interface IHojoshaNyuryokuMapper {

    /**
     * 補助者入力情報を取得します。
     *
     * @param 補助者入力検索条件 HojoshaNyuryokuMapperParameter
     * @return 補助者入力情報 List<HojoshaNyuryokuEntity>
     */
    List<HojoshaNyuryokuEntity> selectHojoshaNyuryokuList(HojoshaNyuryokuMapperParameter 補助者入力検索条件);
}
