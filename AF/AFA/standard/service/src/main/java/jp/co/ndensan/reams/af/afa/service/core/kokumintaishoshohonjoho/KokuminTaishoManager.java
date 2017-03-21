/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kokumintaishoshohonjoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.kokumintaishoshohonjoho.KokuminTaishoResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintaishoshohonjoho.KokuminTaishoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintaishoshohonjoho.IKokuminTaishoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 各種情報の取得する
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KokuminTaishoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    KokuminTaishoManager(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuminTaishoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KokuminTaishoManager}のインスタンス
     */
    public static KokuminTaishoManager createInstance() {
        return InstanceProvider.create(KokuminTaishoManager.class);
    }

    /**
     * 各種情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return 該当した受付番号採番管理エンティティ
     */
    public KokuminTaishoResult get各種情報(ShohonNo 抄本番号) {
        IKokuminTaishoMapper mapper = mapperProvider.create(IKokuminTaishoMapper.class);
        KokuminTaishoEntity entitylist = mapper.select各種情報(抄本番号);
        return new KokuminTaishoResult(entitylist);
    }

    /**
     * 各種情報を取得します。
     *
     * @param 投票年月日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     *
     * @return List<KokuminTaishoResult>
     */
    public List<KokuminTaishoResult> get抄本番号(FlexibleDate 投票年月日, SenkyoShurui 選挙種類) {
        IKokuminTaishoMapper mapper = mapperProvider.create(IKokuminTaishoMapper.class);
        List<KokuminTaishoEntity> entitylist = mapper.select抄本番号(投票年月日, 選挙種類);
        List<KokuminTaishoResult> kokuminTaishoResultList = new ArrayList<>();
        for (KokuminTaishoEntity kokuminTaishoEntity : entitylist) {
            kokuminTaishoResultList.add(new KokuminTaishoResult(kokuminTaishoEntity));
        }
        return kokuminTaishoResultList;
    }

}
