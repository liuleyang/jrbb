/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.takeoutpcdatacreate;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacreate.TakeOutPcDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 端末用データのマッパーインタフェースです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public interface ITakeOutPcDataCreateMapper {

    /**
     * 投票日に合致する端末用データを取得します。
     *
     * @param 投票日 ShohonNo
     * @return TakeOutPcDataEntity{@code list}
     */
    List<TakeOutPcDataEntity> select端末用データBy投票日(FlexibleDate 投票日);
}
