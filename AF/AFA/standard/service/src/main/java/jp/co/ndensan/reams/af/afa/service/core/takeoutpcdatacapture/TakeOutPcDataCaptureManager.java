/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.takeoutpcdatacapture;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.AfT252Result;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.MochidashiPcJotaiKanriResult;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.TakeOutPcDataCaptureResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.AfT252Entity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.TakeOutPcDataCaptureEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT252MochidashiPcJotaiKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.takeoutpcdatacapture.ITakeOutPcDataCaptureMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 持出端末データ取込
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class TakeOutPcDataCaptureManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT252MochidashiPcJotaiKanriDac dac;

    /**
     * コンストラクタです。
     */
    public TakeOutPcDataCaptureManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.dac = InstanceProvider.create(AfT252MochidashiPcJotaiKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TakeOutPcDataCaptureManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TakeOutPcDataCaptureManager}のインスタンス
     */
    public static TakeOutPcDataCaptureManager createInstance() {
        return InstanceProvider.create(TakeOutPcDataCaptureManager.class);
    }

    /**
     * システム日付以上の投票日を取得します。
     *
     * @return 投票日リスト
     */
    @Transaction
    public List<AfT252Result> get投票日() {
        List<AfT252Result> 端末用データResult = new ArrayList<>();
        ITakeOutPcDataCaptureMapper 端末用データmapper = mapperProvider.create(ITakeOutPcDataCaptureMapper.class);
        List<AfT252Entity> entitylist = 端末用データmapper.select投票日(FlexibleDate.getNowDate());
        if (null == entitylist || entitylist.isEmpty()) {
            return null;
        }
        for (AfT252Entity entity : entitylist) {
            端末用データResult.add(new AfT252Result(entity));
        }
        return 端末用データResult;
    }

    /**
     * 投票日に合致する端末用データを返します。
     *
     * @param 投票日 FlexibleDate
     *
     * @return TakeOutPcDataResult nullが返る可能性があります。
     */
    @Transaction
    public List<TakeOutPcDataCaptureResult> get端末用データ(FlexibleDate 投票日) {
        List<TakeOutPcDataCaptureResult> 端末用データResult = new ArrayList<>();
        ITakeOutPcDataCaptureMapper 端末用データmapper = mapperProvider.create(ITakeOutPcDataCaptureMapper.class);
        List<TakeOutPcDataCaptureEntity> 端末用データ = 端末用データmapper.select端末用データBy投票日(投票日);
        if (null == 端末用データ || 端末用データ.isEmpty()) {
            return null;
        }
        for (TakeOutPcDataCaptureEntity entity : 端末用データ) {
            端末用データResult.add(new TakeOutPcDataCaptureResult(entity));
        }
        return 端末用データResult;
    }

    /**
     * 投票日に合致する端末用データを返します。
     *
     * @param shohonNolist List<ShohonNo>
     *
     * @return TakeOutPcDataResult nullが返る可能性があります。
     */
    @Transaction
    public List<MochidashiPcJotaiKanriResult> get取込データ(List<ShohonNo> shohonNolist) {
        List<MochidashiPcJotaiKanriResult> 端末用データResult = new ArrayList<>();
        List<AfT252MochidashiPcJotaiKanriEntity> entitylist = dac.selectBy抄本番号List(shohonNolist);
        if (null == entitylist || entitylist.isEmpty()) {
            return null;
        }
        for (AfT252MochidashiPcJotaiKanriEntity entity : entitylist) {
            端末用データResult.add(new MochidashiPcJotaiKanriResult(entity));
        }
        return 端末用データResult;
    }

}
