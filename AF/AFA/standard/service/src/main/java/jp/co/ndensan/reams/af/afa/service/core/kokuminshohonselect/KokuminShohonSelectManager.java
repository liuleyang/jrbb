/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kokuminshohonselect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.ShohonSearchEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokuminshohonselect.IKokuminShohonSelectMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 抄本情報の取得
 *
 * @reamsid_L AF-0390-020 jihb
 */
public class KokuminShohonSelectManager {

    private final AfT201TohyoJokyoDac dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KokuminShohonSelectManager() {
        this.dac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    KokuminShohonSelectManager(AfaMapperProvider mapperProvider, AfT201TohyoJokyoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuminShohonSelectManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KokuminShohonSelectManager}のインスタンス
     */
    public static KokuminShohonSelectManager createInstance() {
        return InstanceProvider.create(KokuminShohonSelectManager.class);
    }

    /**
     * 抄本情報を取得します。
     *
     * @return 該当した受付番号採番管理エンティティ
     */
    public List<ShohonSearchResult> get抄本情報() {
        IKokuminShohonSelectMapper mapper = mapperProvider.create(IKokuminShohonSelectMapper.class);
        FlexibleDate kijunDate = FlexibleDate.getNowDate();
        List<ShohonSearchEntity> entitylist = mapper.selectShohon(kijunDate);
        List<ShohonSearchResult> shohonSearchResult = new ArrayList<>();
        for (ShohonSearchEntity entity : entitylist) {
            shohonSearchResult.add(new ShohonSearchResult(entity));
        }
        return shohonSearchResult;
    }

    /**
     * 抄本情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return boolean is投票状況存在
     */
    public boolean is投票状況存在(ShohonNo 抄本番号) {
        List<AfT201TohyoJokyoEntity> entity = dac.selectByShohonNo(抄本番号);
        return null != entity && !entity.isEmpty();
    }
}
