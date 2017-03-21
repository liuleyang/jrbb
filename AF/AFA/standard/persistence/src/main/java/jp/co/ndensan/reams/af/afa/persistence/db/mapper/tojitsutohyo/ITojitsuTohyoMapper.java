/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.tojitsutohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tojitsutohyo.TojitsuTohyoParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.ShohonSearchEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.TojitsuTohyoShukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 画面設計_AFAGME3010_当日投票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public interface ITojitsuTohyoMapper {

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param param TojitsuTohyoParameter
     * @return 当日投票情報の集計 TojitsuTohyoShukeiEntity
     */
    TojitsuTohyoShukeiEntity selectTojitsuTohyoShukei1行と2行(TojitsuTohyoParameter param);

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param param TojitsuTohyoParameter
     * @return 当日投票情報の集計 List<TojitsuTohyoShukeiEntity>
     */
    List<SenkyoninTohyoJokyoEntity> select選挙人情報(TojitsuTohyoParameter param);

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param param TojitsuTohyoParameter
     * @return 当日投票情報の集計 TojitsuTohyoShukeiEntity
     */
    TojitsuTohyoShukeiEntity selectTojitsuTohyoShukei(TojitsuTohyoParameter param);

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param param TojitsuTohyoParameter
     * @return 当日投票情報の集計 List<TojitsuTohyoShukeiEntity>
     */
    List<TojitsuTohyoShukeiEntity> selectTojitsuTohyoShukeiPSM(TojitsuTohyoParameter param);

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param shohonNo ShohonNo
     * @param senkyoNo SenkyoNo
     * @return ShohonEntity
     */
    ShohonSearchEntity selectShohon(@Param("shohonNo") ShohonNo shohonNo, @Param("senkyoNo") SenkyoNo senkyoNo);

    /**
     * 当日投票情報の集計を取得します。
     *
     * @param tohyokuCode RString
     * @param senkyoShurui RString
     * @return ShohonEntity
     */
    TojitsuTohyoShukeiEntity selectAfT502Tohyojo(@Param("tohyokuCode") RString tohyokuCode, @Param("senkyoShurui") RString senkyoShurui);

    /**
     * 帳票作成用データを取得します。
     *
     * @param param KijitsumaeTohyoMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectChohyoData(TojitsuTohyoParameter param);
}
