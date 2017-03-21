/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.doitsujinbutsuchosa;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.doitsujinbutsuchosa.DoitsujinbutsuChosaParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.doitsujinbutsuchosa.DoitsujinbutsuChosaEntity;

/**
 * 同一人物調査Mapper。
 *
 * @reamsid_L AF-0690-020 wanghj
 */
public interface IDoitsujinbutsuChosaMapper {

    /**
     * バーコード同一人物調査を取得します。
     *
     * @param parameter DoitsujinbutsuChosaParameter
     * @return 同一人物調査一覧 List<DoitsujinbutsuChosaEntity>
     */
    List<DoitsujinbutsuChosaEntity> select同一人物調査(DoitsujinbutsuChosaParameter parameter);
}
