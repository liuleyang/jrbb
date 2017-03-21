/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.tohyokuhenko;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokuhenko.TohyokuHenkoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区変更のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0050-010 wangxt2
 */
public interface ITohyokuHenkoMapper {

    /**
     * 投票区を取得します。
     *
     * @param key ShikibetsuCode
     * @return Tohyoku
     */
    List<RString> getTohyokuCode(TohyokuHenkoMyBatisParameter key);

}
