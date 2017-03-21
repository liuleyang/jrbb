/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tachiaishosakusei;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 立会人引継書のマッパーインタフェースです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public interface ITachiaishoSakuseiMapper {

    /**
     * 抄本番号をキー検索で選挙名情報取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return List<AfT111SenkyoEntity>
     */
    List<AfT111SenkyoEntity> select選挙名By抄本番号(@Param("shohonNo") ShohonNo 抄本番号);

}
