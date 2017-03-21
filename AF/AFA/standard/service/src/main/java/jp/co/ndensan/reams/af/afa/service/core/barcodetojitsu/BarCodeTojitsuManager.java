/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.barcodetojitsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodetojitsu.BarCodeTojitsuResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.barcodetojitsu.BarCodeTojitsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodetojitsu.BarCodeTojitsuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.barcodetojitsu.IBarCodeTojitsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * バーコード一括当日投票入力データクラスです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsuManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT201TohyoJokyoDac afT201TohyoJokyoDac;

    /**
     * コンストラクタです。
     */
    public BarCodeTojitsuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        afT201TohyoJokyoDac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
    }

    BarCodeTojitsuManager(AfaMapperProvider mapperProvider, AfT201TohyoJokyoDac afT201TohyoJokyoDac) {
        this.mapperProvider = mapperProvider;
        this.afT201TohyoJokyoDac = afT201TohyoJokyoDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link BarCodeTojitsuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link BarCodeTojitsuManager}のインスタンス
     */
    public static BarCodeTojitsuManager createInstance() {
        return InstanceProvider.create(BarCodeTojitsuManager.class);
    }

    /**
     * 指定されたキーに該当する、期日前投票情報の帳票作成用データを取得します。
     *
     * @param senkyoSyurui 選挙種類
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @return List<TohyoJokyoData>
     */
    @Transaction
    public List<BarCodeTojitsuResult> getTohyoChohyoData(Code senkyoSyurui,
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {

        IBarCodeTojitsuMapper mapper = mapperProvider.create(IBarCodeTojitsuMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        BarCodeTojitsuMybatisParameter param = new BarCodeTojitsuMybatisParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, shikibetsuCode, senkyoSyurui);
        List<BarCodeTojitsuEntity> tohyoEntitylist = mapper.selectTohyoJokyo(param);
        if (tohyoEntitylist.isEmpty()) {
            return null;
        }
        List<BarCodeTojitsuResult> tohyoChohyoData = new ArrayList<>();
        for (BarCodeTojitsuEntity entity : tohyoEntitylist) {
            tohyoChohyoData.add(new BarCodeTojitsuResult(entity));
        }
        return tohyoChohyoData;
    }

    /**
     * 指定されたキーに該当する、投票状況{@link TohyoJokyo}を保存します。
     *
     * @param builderList List<TohyoJokyoBuilder>
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveData投票(List<TohyoJokyoBuilder> builderList) {
        int 更新件数 = 0;
        for (TohyoJokyoBuilder builder : builderList) {
            builder.build().toEntity().setState(EntityDataState.Added);
            afT201TohyoJokyoDac.save(builder.build().toEntity());
            更新件数 = 更新件数 + 1;
        }
        return 更新件数 == builderList.size();
    }

}
