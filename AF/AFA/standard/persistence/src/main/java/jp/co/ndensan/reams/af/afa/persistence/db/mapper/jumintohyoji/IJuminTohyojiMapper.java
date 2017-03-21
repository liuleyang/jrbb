/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.jumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiDelMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiSelectMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT145Chiku1ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyoji.JuminTohyojiEntity;

/**
 * 住民投票時登録クラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public interface IJuminTohyojiMapper {

    /**
     * 住民投票時登録対象データ取得する。
     *
     * @param parmeter JuminTohyojiMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    List<JuminTohyojiEntity> selectJuminTohyojiList(JuminTohyojiMybatisParameter parmeter);

    /**
     * 住民投票資格者名簿抄本データを取得する。
     *
     * @param parameters JuminTohyojiSelectMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    List<JuminTohyojiEntity> select住民投票資格者名簿抄本データ(JuminTohyojiSelectMybatisParameter parameters);

    /**
     * 住民投票資格者名簿抄本データを取得する。
     *
     * @param parameters JuminTohyojiSelectMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    List<JuminTohyojiEntity> select住民投票資格者名簿抄本縦覧データ(JuminTohyojiSelectMybatisParameter parameters);

    /**
     * 抄本データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    AfT100ShohonEntity select抄本By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙データ AfT111SenkyoEntity
     */
    List<AfT111SenkyoEntity> select選挙By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT112SenkyoninMeiboEntity> select選挙人名簿By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 住民投票選挙人抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 住民投票選挙人抽出条件データ AfT141ZaisankuJuminTohyoConditionEntity
     */
    AfT141ZaisankuJuminTohyoConditionEntity select住民投票選挙人抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 投票区抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 投票区抽出条件データ AfT142TohyokuConditionEntity
     */
    List<AfT142TohyokuConditionEntity> select投票区抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 行政区抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 行政区抽出条件データ AfT143GyoseikuConditionEntity
     */
    List<AfT143GyoseikuConditionEntity> select行政区抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 住所抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 住所抽出条件データ AfT144JushoConditionEntity
     */
    List<AfT144JushoConditionEntity> select住所抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 地区1抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 地区1抽出条件データ AfT145Chiku1ConditionEntity
     */
    List<AfT145Chiku1ConditionEntity> select地区1抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 地区2抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 地区2抽出条件データ AfT144JushoConditionEntity
     */
    List<AfT146Chiku2ConditionEntity> select地区2抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);

    /**
     * 地区3抽出条件データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 地区3抽出条件データ AfT147Chiku3ConditionEntity
     */
    List<AfT147Chiku3ConditionEntity> select地区3抽出条件By抄本番号(JuminTohyojiDelMybatisParameter parameter);
}
