/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipcimportuketsukedata;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipcimportuketsukedata.MochidashiPcImportUketsukeDataEntity;

/**
 * 当日受付データ取込のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public interface IMochidashiPcImportUketsukeDataMapper {

    /**
     * 当日受付データ取込情報を取得します。
     *
     * @param parameter AFABTE803SelectProcessMyBatisParameter
     * @return List<MochidashiPcImportUketsukeDataEntity>
     */
    List<MochidashiPcImportUketsukeDataEntity> select当日受付データ取込情報(AFABTE803SelectProcessMyBatisParameter parameter);

    /**
     * 持出端末状態管理情報を取得します。
     *
     * @param parameter AFABTE803SelectProcessMyBatisParameter
     * @return List<AfT252MochidashiPcJotaiKanriEntity>
     */
    List<AfT252MochidashiPcJotaiKanriEntity> select持出端末状態管理By投票年月日(AFABTE803SelectProcessMyBatisParameter parameter);
}
