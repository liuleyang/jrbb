/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;

/**
 * 宛名識別対象取得データのマッパクラスのインタフェースです。
 *
 */
public interface IAFAPRA100Mapper {

    /**
     * 3.1選挙人名簿抄本用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoninMeiboShohon(BatchMybatisParameter mybatisparameter);

}
