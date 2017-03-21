/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.SenkyokuInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.SenkyoninInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.ShohonInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.TohyokuInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 持出端末用データ作成のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public interface IMochidashiPcCreateDataMapper {

    /**
     * 抄本対象を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return List<ShohonInfoEntity>
     */
    List<ShohonInfoEntity> select抄本対象(FlexibleDate 投票日);

    /**
     * 抄本対象を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return List<ShohonInfoEntity>
     */
    List<RString> select抄本番号By投票日(FlexibleDate 投票日);

    /**
     * 投票区情報を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return TohyokuInfoEntity
     */
    TohyokuInfoEntity select投票区情報(FlexibleDate 投票日);

    /**
     * 選挙区情報を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return TohyokuInfoEntity
     */
    SenkyokuInfoEntity select選挙区情報(FlexibleDate 投票日);

    /**
     * 選挙人情報を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return List<SenkyoninInfoEntity>
     */
    List<SenkyoninInfoEntity> select選挙人情報(FlexibleDate 投票日);

    /**
     * 投票状況情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return TohyoJokyoInfoEntity
     */
    AfT201TohyoJokyoEntity select投票状況情報(ShohonNo 抄本番号);

    /**
     * MAX名簿基準年月日を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return RString
     */
    RString selectMAX名簿基準年月日(ShohonNo 抄本番号);

    /**
     * select抄本投票区コード。
     *
     * @param mybatisParam MochidashiPcCreateDataMybatisParameter
     * @return RString
     */
    List<RString> select抄本投票区コード(MochidashiPcCreateDataMybatisParameter mybatisParam);

}
