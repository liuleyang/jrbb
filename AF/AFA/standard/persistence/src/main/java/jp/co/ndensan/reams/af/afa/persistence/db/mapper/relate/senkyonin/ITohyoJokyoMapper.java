/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.tohyojokyo.TohyojokyoDairishaEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoJokyoEntity;

/**
 * 投票状況を管理するクラス。
 */
public interface ITohyoJokyoMapper {

    /**
     * 主キー1に合致する投票状況代理者のリストを取得します。
     *
     * @param 投票状況代理者検索条件 投票状況代理者検索条件
     * @return TohyojokyoDairishaEntity{@code list}
     */
    List<TohyojokyoDairishaEntity> select代理投票者(TohyojokyoMapperParameter 投票状況代理者検索条件);

    /**
     * 主キー1に合致する投票状況拒否者のリストを取得します。
     *
     * @param 投票状況拒否者検索条件 投票状況拒否者検索条件
     * @return TohyojokyoDairishaEntity{@code list}
     */
    List<TohyojokyoDairishaEntity> select投票拒否者(TohyojokyoMapperParameter 投票状況拒否者検索条件);

    /**
     * 主キー1に合致する用紙返還投票者のリストを取得します。
     *
     * @param 用紙返還投票者検索条件 用紙返還投票者検索条件
     * @return TohyojokyoDairishaEntity{@code list}
     */
    List<TohyojokyoDairishaEntity> select用紙返還投票者(TohyojokyoMapperParameter 用紙返還投票者検索条件);

    /**
     * 主キー1に合致する点字により投票者のリストを取得します。
     *
     * @param 点字により投票者検索条件 点字により投票者検索条件
     * @return TohyojokyoDairishaEntity{@code list}
     */
    List<TohyojokyoDairishaEntity> select点字により投票者(TohyojokyoMapperParameter 点字により投票者検索条件);

    /**
     * 投票者数を返します。
     *
     * @param 投票者検索条件 投票者検索条件
     * @return 投票者数
     */
    int select投票者数(TohyojokyoMapperParameter 投票者検索条件);

    /**
     * 点字により投票者を返します。
     *
     * @param 点字により投票者検索条件 点字により投票者検索条件
     * @return 点字により投票者数
     */
    int select点字により投票者数(TohyojokyoMapperParameter 点字により投票者検索条件);

    /**
     * 投票状況情報を返します。
     *
     * @param 投票資格情報検索条件 TohyojokyoMapperParameter
     * @return 投票状況情報
     */
    List<KijitsumaeTohyoJokyoEntity> select投票状況情報(TohyojokyoMapperParameter 投票資格情報検索条件);

    /**
     * 投票資格情報を返します。
     *
     * @param 投票資格情報検索条件 TohyojokyoMapperParameter
     * @return 投票資格情報
     */
    KijitsumaeSenkyoShikakuEntity select投票資格情報(TohyojokyoMapperParameter 投票資格情報検索条件);
}
