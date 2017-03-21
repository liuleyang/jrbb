/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.reprintteiji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;

/**
 * 定時登録再発行のマッパクラスのインタフェースです。
 *
 */
public interface IShohonSenkyoMapper {

    /**
     * 抄本選挙情報を取得します。
     *
     * @return 抄本選挙情報 List<ShohonSenkyoEntity>
     */
    List<ShohonSenkyoEntity> selectShohonSenkyoList();
}
