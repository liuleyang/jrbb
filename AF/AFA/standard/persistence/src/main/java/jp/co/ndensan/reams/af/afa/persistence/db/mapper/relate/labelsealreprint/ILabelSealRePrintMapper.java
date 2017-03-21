/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.labelsealreprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.labelsealreprint.LabelSealRePrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;

/**
 * ラベルシール再印刷のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public interface ILabelSealRePrintMapper {

    /**
     * 帳票作成用データを取得します。
     *
     * @param param LabelSealRePrintMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectChohyoData(LabelSealRePrintMybatisParameter param);

}
