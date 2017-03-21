/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.atenasealsakusei.AtenaSealSakuseiMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.atenasealsakusei.AtenaSealSakuseiJyohouEntity;

/**
 * 宛名シール作成のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public interface IAtenaSealSakuseiMapper {

    /**
     * 施設宛名シール情報を取得します。
     *
     * @param param AtenaSealSakuseiMybatisParameter
     * @return 選挙人一覧情報 List<AtenaSealSakuseiJyohouEntity>
     */
    List<AtenaSealSakuseiJyohouEntity> select施設宛名シール情報(AtenaSealSakuseiMybatisParameter param);

    /**
     * 選挙人宛名シール情報を取得します。
     *
     * @param param AtenaSealSakuseiMybatisParameter
     * @return 選挙人一覧情報 List<AtenaSealSakuseiJyohouEntity>
     */
    List<AtenaSealSakuseiJyohouEntity> select選挙人宛名シール情報(AtenaSealSakuseiMybatisParameter param);

    /**
     * 転出者宛名シール情報を取得します。
     *
     * @param param AtenaSealSakuseiMybatisParameter
     * @return 選挙人一覧情報 List<AtenaSealSakuseiJyohouEntity>
     */
    List<AtenaSealSakuseiJyohouEntity> select転出者宛名シール情報(AtenaSealSakuseiMybatisParameter param);

}
