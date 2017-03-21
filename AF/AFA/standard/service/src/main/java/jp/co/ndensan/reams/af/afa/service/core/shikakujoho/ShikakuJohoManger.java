/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shikakujoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.FindShikibetsuTaishoResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoParameter;
import jp.co.ndensan.reams.af.afa.business.core.shikakujoho.ShikakuJohoResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shikakujoho.ShikakuJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT113SenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT114FuzaishaTohyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.shikakujoho.IShikakuJohoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格情報Mangerクラスです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoManger {

    private final AfaMapperProvider mapperProvider;
    private final AfT114FuzaishaTohyoShikakuDac 不在者投票資格Dac;
    private final UaFt200FindShikibetsuTaishoFunctionDac dac_UaFt200;
    private final AfT113SenkyoShikakuDac afT113SenkyoShikakuDac;

    /**
     * コンストラクタです。
     */
    ShikakuJohoManger() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.不在者投票資格Dac = InstanceProvider.create(AfT114FuzaishaTohyoShikakuDac.class);
        this.dac_UaFt200 = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class);
        this.afT113SenkyoShikakuDac = InstanceProvider.create(AfT113SenkyoShikakuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 不在者投票資格Dac 抄本Dac
     * @param dac_UaFt200 抄本Dac
     * @param afT113SenkyoShikakuDac AfT113SenkyoShikakuDac
     * @param 選挙Manager 選挙Manager
     */
    ShikakuJohoManger(AfaMapperProvider mapperProvider, AfT114FuzaishaTohyoShikakuDac 不在者投票資格Dac,
            UaFt200FindShikibetsuTaishoFunctionDac dac_UaFt200, AfT113SenkyoShikakuDac afT113SenkyoShikakuDac) {
        this.mapperProvider = mapperProvider;
        this.不在者投票資格Dac = 不在者投票資格Dac;
        this.dac_UaFt200 = dac_UaFt200;
        this.afT113SenkyoShikakuDac = afT113SenkyoShikakuDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンス
     */
    public static ShikakuJohoManger createInstance() {
        return InstanceProvider.create(ShikakuJohoManger.class);
    }

    /**
     * 在外選挙資格を返します。
     *
     * @param parameter ShikakuJohoParameter
     * @return ZaigaiSenkyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public ZaigaiSenkyoShikakuResult get在外選挙資格情報(ShikakuJohoParameter parameter) {
        IShikakuJohoMapper mapper = mapperProvider.create(IShikakuJohoMapper.class);
        ShikakuJohoEntity shikakuJohoEntity = toEntity(parameter);

        AfT122ZaigaiSenkyoShikakuEntity relateEntity = mapper.selectZaigaiSenkyoShikaku(shikakuJohoEntity);
        if (relateEntity == null) {
            return null;
        }
        return new ZaigaiSenkyoShikakuResult(relateEntity);
    }

    private ShikakuJohoEntity toEntity(ShikakuJohoParameter parameter) {
        ShikakuJohoEntity shikakuJohoEntity = new ShikakuJohoEntity();
        shikakuJohoEntity.setSenkyoShurui(parameter.getSenkyoShurui());
        shikakuJohoEntity.setShikibetsuCode(parameter.getShikibetsuCode());
        shikakuJohoEntity.setWksenkyoShurui(parameter.getWksenkyoShurui());
        return shikakuJohoEntity;
    }

    /**
     * 選挙資格情報を返します。
     *
     * @param parameter ShikakuJohoParameter
     * @return ZaigaiSenkyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public ShikakuJohoResult get選挙資格情報(ShikakuJohoParameter parameter) {
        IShikakuJohoMapper mapper = mapperProvider.create(IShikakuJohoMapper.class);
        ShikakuJohoEntity shikakuJohoEntity = toEntity(parameter);

        AfT113SenkyoShikakuEntity relateEntity = mapper.selectSenkyoShikaku(shikakuJohoEntity);
        if (relateEntity == null) {
            return null;
        }
        return new ShikakuJohoResult(relateEntity);
    }

    /**
     * 選挙資格情報を返します。
     *
     * @param parameter ShikakuJohoParameter
     * @return ZaigaiSenkyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public List<FuzaishaShikakuResult> get不在者投票資格(ShikakuJohoParameter parameter) {
        ShikakuJohoEntity shikakuJohoEntity = toEntity(parameter);
        List<AfT114FuzaishaTohyoShikakuEntity> entity = 不在者投票資格Dac.select不在者投票資格(shikakuJohoEntity.getShikibetsuCode());

        if (entity.isEmpty()) {
            return null;
        }
        List<FuzaishaShikakuResult> result = new ArrayList<>();
        for (AfT114FuzaishaTohyoShikakuEntity afT114Entity : entity) {
            result.add(new FuzaishaShikakuResult(afT114Entity));
        }
        return result;
    }

    /**
     * 選挙資格情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return ZaigaiSenkyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public FindShikibetsuTaishoResult get宛名識別対象(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.AF選挙, KensakuYusenKubun.未定義));
        key.set識別コード(識別コード);
        IPsmCriteria psmCriteria = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM情報リスト = dac_UaFt200.select(psmCriteria, 1);

        if (宛名PSM情報リスト != null && 宛名PSM情報リスト.isEmpty()) {
            return null;
        }
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = new UaFt200FindShikibetsuTaishoEntity();
        if (null != 宛名PSM情報リスト && !宛名PSM情報リスト.isEmpty()) {
            宛名PSM = 宛名PSM情報リスト.get(0);
        }

        return new FindShikibetsuTaishoResult(宛名PSM);
    }

    /**
     * 選挙資格を更新します。
     *
     * @param shikakuJohoResult ShikakuJohoResult
     * @return 更新状態
     */
    @Transaction
    public Boolean save選挙資格(ShikakuJohoResult shikakuJohoResult) {
        AfT113SenkyoShikakuEntity resultEntity = shikakuJohoResult.getAfT113SenkyoShikaku();
        if (resultEntity == null) {
            return Boolean.FALSE;
        }
        return 1 == afT113SenkyoShikakuDac.save(resultEntity);
    }
}
