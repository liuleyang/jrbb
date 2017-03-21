/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.tohyojo;

import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyojo.TohyojoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;

/**
 * 投票所のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public interface ITohyojoMapper {

    /**
     * 投票所情報を取得します。
     *
     * @param param TohyojoMybatisParameter
     * @return 投票所情報 AfT502TohyojoEntity
     */
    AfT502TohyojoEntity selectTohyojo(TohyojoMybatisParameter param);
}
