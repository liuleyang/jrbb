/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojohoshusei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;

/**
 * 選挙修正のマッパクラスのインタフェースです。
 *
 */
public interface ISenkyoShuseiMapper {

    /**
     * 検索条件により、抄本選挙情報を取得します。
     *
     * @param condition Map<String, Object>
     * @return 抄本選挙情報 List<ShohonSenkyoEntity>
     */
    List<ShohonSenkyoEntity> selectShohonSenkyoListByCondition(Map<String, Object> condition);

    /**
     * 検索条件により、抄本選挙情報を取得します。
     *
     * @param condition Map<String, Object>
     * @return 投票状況合計 int
     */
    int count投票状況By抄本選挙番号(Map<String, Object> condition);
}
