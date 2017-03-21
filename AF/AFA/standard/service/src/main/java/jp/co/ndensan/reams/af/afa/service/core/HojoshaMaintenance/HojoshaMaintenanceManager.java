/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.hojoshamaintenance;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.HojoshaMaintenanceInfo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.hojoshamaintenance.HojoshaMaintenanceMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshamaintenance.HojoshaMaintenanceEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT508HojoshaDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.hojosha.IHojoshaMaintenanceMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 投票補助者保守のDB操作クラスです。
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenanceManager {

    private final AfT508HojoshaDac afT508HojoshaDac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public HojoshaMaintenanceManager() {
        this.afT508HojoshaDac = InstanceProvider.create(AfT508HojoshaDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static HojoshaMaintenanceManager createInstance() {
        return InstanceProvider.create(HojoshaMaintenanceManager.class);
    }

    /**
     * 補助者情報を追加/更新します。
     *
     * @param 抄本番号 RString
     * @param 識別コード RString
     * @param 投票所コード RString
     * @return int
     */
    public int insert補助者(RString 抄本番号, RString 識別コード, RString 投票所コード) {
        AfT508HojoshaEntity afT508HojoshaEntity = new AfT508HojoshaEntity();
        afT508HojoshaEntity.setTohyojoCode(投票所コード);
        afT508HojoshaEntity.setShohonNo(new ShohonNo(抄本番号));
        afT508HojoshaEntity.setShikibetsuCode(new ShikibetsuCode(識別コード));
        afT508HojoshaEntity.setState(EntityDataState.Added);
        return afT508HojoshaDac.save(afT508HojoshaEntity);
    }

    /**
     * 補助者情報を追加/更新します。
     *
     * @param 投票補助者info HojoshaMaintenanceInfo
     * @return int
     */
    public int update補助者(HojoshaMaintenanceInfo 投票補助者info) {
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setState(EntityDataState.Modified);
        return afT508HojoshaDac.save(投票補助者info.getHojoshaMaintenanceEntity().get補助者情報());
    }

    /**
     * 補助者情報を削除します。
     *
     * @param 投票補助者info HojoshaMaintenanceInfo
     * @return int
     */
    public int delete補助者(HojoshaMaintenanceInfo 投票補助者info) {
        投票補助者info.getHojoshaMaintenanceEntity().get補助者情報().setState(EntityDataState.Deleted);
        return afT508HojoshaDac.deletePhysical(投票補助者info.getHojoshaMaintenanceEntity().get補助者情報());
    }

    /**
     * 補助者情報を取得します。
     *
     * @param 抄本番号 RString
     * @param 投票年月日 RDate
     * @return List<HojoshaMaintenanceInfo>
     */
    public List<HojoshaMaintenanceInfo> select補助者(RString 抄本番号, RDate 投票年月日) {
        List<HojoshaMaintenanceInfo> infoLst = new ArrayList();
        IHojoshaMaintenanceMapper mapper = mapperProvider.create(IHojoshaMaintenanceMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        if (null != 投票年月日) {
            build.set基準日(new FlexibleDate(投票年月日.toDateString()));
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        HojoshaMaintenanceMybatisParameter param = new HojoshaMaintenanceMybatisParameter(shikibetsuTaishoPSMSearchKey, new ShohonNo(抄本番号));
        List<HojoshaMaintenanceEntity> entityLst = mapper.select補助者情報By抄本番号(param);

        for (HojoshaMaintenanceEntity entity : entityLst) {
            HojoshaMaintenanceInfo info = new HojoshaMaintenanceInfo();
            info.getHojoshaMaintenanceEntity().set補助者情報(entity.get補助者情報());
            info.getHojoshaMaintenanceEntity().set投票所情報(entity.get投票所情報());
            info.getHojoshaMaintenanceEntity().set宛名PSM情報(entity.get宛名PSM情報());
            infoLst.add(info);
        }
        return infoLst;
    }

    /**
     * 宛名PSMを取得します。
     *
     * @param 識別コード RString
     * @param 投票年月日 RDate
     * @return count int
     */
    public int select宛名PSM(RString 識別コード, RDate 投票年月日) {
        IHojoshaMaintenanceMapper mapper = mapperProvider.create(IHojoshaMaintenanceMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        if (null != 投票年月日) {
            build.set基準日(new FlexibleDate(投票年月日.toDateString()));
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        HojoshaMaintenanceMybatisParameter param = new HojoshaMaintenanceMybatisParameter(shikibetsuTaishoPSMSearchKey, new ShikibetsuCode(識別コード));
        return mapper.select宛名情報By識別コード(param);
    }

    /**
     * 補助者情報を取得します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @return フラグ boolean
     */
    public boolean select補助者(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        boolean フラグ = Boolean.FALSE;
        AfT508HojoshaEntity afT508HojoshaEntity = afT508HojoshaDac.select(shohonNo, shikibetsuCode);
        if (afT508HojoshaEntity != null) {
            フラグ = Boolean.TRUE;
        }
        return フラグ;
    }

}
