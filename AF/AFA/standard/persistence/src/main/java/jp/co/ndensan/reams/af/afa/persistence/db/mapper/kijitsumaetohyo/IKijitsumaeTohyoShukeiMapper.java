/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kijitsumaetohyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo.KijitsumaeTohyoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoShukeiEntity;

/**
 * 画面設計_AFAGME1010_期日前投票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public interface IKijitsumaeTohyoShukeiMapper {

    /**
     * 期日前投票情報の集計を取得します。
     *
     * @param param KijitsumaeTohyoMybatisParameter
     * @return 期日前投票情報の集計 List<KijitsumaeTohyoShukeiEntity>
     */
    List<KijitsumaeTohyoShukeiEntity> selectKijitsumaeTohyoShukei(KijitsumaeTohyoMybatisParameter param);

    /**
     * 帳票作成用データを取得します。
     *
     * @param param KijitsumaeTohyoMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectChohyoData(KijitsumaeTohyoMybatisParameter param);
}
