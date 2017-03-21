/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku.TohyorokuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;

/**
 * 投票録を管理するクラス。
 *
 * @reamsid_L AF-0130-010 lit
 */
public interface IAFABTE502Mapper {

    /**
     * 検索キーに合致するのリストを取得します。
     *
     * @param param TohyorokuMapperParameter
     * @return SenkyoninTohyoJokyoEntity{@code list}
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoninTohyoJokyoList(TohyorokuMapperParameter param);
}
