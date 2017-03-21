/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.reprintsenkyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 選挙時登録再発行のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0060-020 liss
 */
public interface IRePrintSenkyojiMapper {

    /**
     * 抄本情報を取得します。
     *
     * @return 抄本情報 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectShohonList();

    /**
     * 選挙情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 選挙情報 List<AfT111SenkyoEntity>
     */
    List<AfT111SenkyoEntity> selectSenkyoList(@Param("抄本番号") ShohonNo 抄本番号);
}
