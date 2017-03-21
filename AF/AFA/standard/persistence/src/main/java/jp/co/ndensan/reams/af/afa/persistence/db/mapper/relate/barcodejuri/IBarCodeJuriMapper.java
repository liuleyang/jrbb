/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.barcodejuri;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.barcodejuri.BarCodeJuriMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodejuri.BarCodeJuriEntity;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理用マッパのインタフェースです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public interface IBarCodeJuriMapper {

    /**
     * バーコード受理一覧を取得します。
     *
     * @param searchJoken BarCodeJuriMapperParameter
     * @return バーコード受理一覧 List<BarCodeJuriEntity>
     */
    List<BarCodeJuriEntity> selectBarCodeJuriIchiran(BarCodeJuriMapperParameter searchJoken);
}
