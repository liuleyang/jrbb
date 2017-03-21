/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyokekkaprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokekkaprint.TohyokekkaPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;

/**
 * 投票集計表帳票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public interface IAFABTE505Mapper {

    /**
     * 投票集計表帳票情報を取得します。
     *
     * @param 投票集計表帳票検索条件 TohyokekkaPrintMybatisParameter
     * @return 投票集計表帳票情報 List<TohyokekkaPrintEntity>
     */
    List<TohyokekkaPrintEntity> selectTohyokekkaPrintList(TohyokekkaPrintMybatisParameter 投票集計表帳票検索条件);
}
