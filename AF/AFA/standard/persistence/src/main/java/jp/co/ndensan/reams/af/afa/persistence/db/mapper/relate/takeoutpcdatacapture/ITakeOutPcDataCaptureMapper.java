/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.takeoutpcdatacapture;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.AfT252Entity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.TakeOutPcDataCaptureEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 端末用データのマッパーインタフェースです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public interface ITakeOutPcDataCaptureMapper {

    /**
     * 投票日に合致する端末用データを取得します。
     *
     * @param kijunDate FlexibleDate
     * @return AfT252Entity{@code list}
     */
    List<AfT252Entity> select投票日(@Param("kijunDate") FlexibleDate kijunDate);

    /**
     * 投票日に合致する端末用データを取得します。
     *
     * @param 投票日 FlexibleDate
     * @return TakeOutPcDataCaptureEntity{@code list}
     */
    List<TakeOutPcDataCaptureEntity> select端末用データBy投票日(FlexibleDate 投票日);

    /**
     * 投票日に合致する端末用データを取得します。
     *
     * @param shohonNoList ShohonNo
     * @return TakeOutPcDataCaptureEntity{@code list}
     */
    List<AfT252Entity> select持出端末引継データ(@Param("shohonNoList") List<ShohonNo> shohonNoList);
}
