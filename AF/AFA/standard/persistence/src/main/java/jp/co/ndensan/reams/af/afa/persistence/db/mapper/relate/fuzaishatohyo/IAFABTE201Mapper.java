/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.fuzaishatohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.SenkyoninMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.TohyoJokyoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.SenkyoninEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.TohyoJokyoEntity;

/**
 * 不在者投票関連のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public interface IAFABTE201Mapper {

    /**
     * 選挙人情報を取得します。
     *
     * @param 選挙人検索条件 SenkyoninMybatisParameter
     * @return 選挙人情報 List<SenkyoninEntity>
     */
    List<SenkyoninEntity> selectSenkyoninList(SenkyoninMybatisParameter 選挙人検索条件);

    /**
     * 選挙人情報を取得します。
     *
     * @param 選挙人検索条件 SenkyoninMybatisParameter
     * @return 選挙人情報 List<SenkyoninEntity>
     */
    List<SenkyoninEntity> selectSenkyoninListByShikibetsuCode(SenkyoninMybatisParameter 選挙人検索条件);

    /**
     * 選挙情報を取得します。
     *
     * @param 選挙人検索条件 SenkyoninMybatisParameter
     * @return 投票情報 List<SenkyoninEntity>
     */
    List<SenkyoninEntity> selectSenkyoJoho(SenkyoninMybatisParameter 選挙人検索条件);

    /**
     * 投票日前日関連帳票情報を取得します。
     *
     * @param 投票情報検索条件 TohyoJokyoMybatisParameter
     * @return 投票情報 List<TohyoJokyoEntity>
     */
    List<TohyoJokyoEntity> selectTohyoJokyoList(TohyoJokyoMybatisParameter 投票情報検索条件);
}
