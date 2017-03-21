/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.takeoutpcdatacreate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacreate.TakeOutPcDataResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacreate.TakeOutPcDataEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT252MochidashiPcJotaiKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.takeoutpcdatacreate.ITakeOutPcDataCreateMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 端末用データの取得
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataCreateManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT100ShohonDac afT100ShohonDac;
    private final AfT252MochidashiPcJotaiKanriDac afT252Dac;

    /**
     * コンストラクタです。
     */
    public TakeOutPcDataCreateManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.afT100ShohonDac = InstanceProvider.create(AfT100ShohonDac.class);
        this.afT252Dac = InstanceProvider.create(AfT252MochidashiPcJotaiKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TakeOutPcDataCreateManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TakeOutPcDataCreateManager}のインスタンス
     */
    public static TakeOutPcDataCreateManager createInstance() {
        return InstanceProvider.create(TakeOutPcDataCreateManager.class);
    }

    /**
     * システム日付以上の投票日を取得します。
     *
     * @return 投票日リスト
     */
    @Transaction
    public List<FlexibleDate> getシステム日付以上の投票日() {
        List<FlexibleDate> 投票日リスト = new ArrayList();
        List<AfT100ShohonEntity> 抄本リスト = afT100ShohonDac.selectシステム日付以上の投票日();
        if (null != 抄本リスト && !抄本リスト.isEmpty()) {
            for (int i = 0; i < 抄本リスト.size(); i++) {
                投票日リスト.add(抄本リスト.get(i).getTohyoYMD());
            }
        }
        return 投票日リスト;
    }

    /**
     * 受渡データ作成有無を取得します。
     *
     * @param shohonNo List<ShohonNo>
     * @return Boolean
     */
    @Transaction
    public RString get受渡データ作成有無(List<ShohonNo> shohonNo) {
        RString flg = MochidashiPcCreateDataEnum.ZERO.getRString();
        List<AfT252MochidashiPcJotaiKanriEntity> 受渡データリスト = afT252Dac.selectBy抄本番号List(shohonNo);
        AfT252MochidashiPcJotaiKanriEntity entity;
        if (null == 受渡データリスト || 受渡データリスト.isEmpty()) {
            return flg;
        }
        for (int i = 0; i < 受渡データリスト.size(); i++) {
            entity = 受渡データリスト.get(i);
            if (MochidashiPcCreateDataEnum.ONE.getCode().equals(entity.getDataCreateKubun())) {
                flg = MochidashiPcCreateDataEnum.ONE.getRString();
            }
        }
        return flg;
    }

    /**
     * 投票日に合致する端末用データを返します。
     *
     * @param 投票日 FlexibleDate
     *
     * @return TakeOutPcDataResult nullが返る可能性があります。
     */
    @Transaction
    public List<TakeOutPcDataResult> get端末用データ(FlexibleDate 投票日) {
        List<TakeOutPcDataResult> 端末用データResult = new ArrayList<>();
        ITakeOutPcDataCreateMapper 端末用データmapper = mapperProvider.create(ITakeOutPcDataCreateMapper.class);
        List<TakeOutPcDataEntity> 端末用データ = 端末用データmapper.select端末用データBy投票日(投票日);
        if (null == 端末用データ || 端末用データ.isEmpty()) {
            return 端末用データResult;
        }
        TakeOutPcDataEntity takeOutPcDataEntity;
        List<RString> 選挙List;
        for (int i = 0; i < 端末用データ.size(); i++) {
            選挙List = new ArrayList<>();
            takeOutPcDataEntity = 端末用データ.get(i);
            for (int j = 0; j < takeOutPcDataEntity.get選挙Entity().size(); j++) {
                選挙List.add(takeOutPcDataEntity.get選挙Entity().get(j).getSenkyoRyakusho());
            }
            端末用データResult.add(new TakeOutPcDataResult(takeOutPcDataEntity, 選挙List));
        }
        return 端末用データResult;
    }

}
