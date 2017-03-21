/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.kijitsumaetohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo.ShikakuhanteiMybatisParameter;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.kijitsumaetohyo.IShikakuhanteiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_AFABZA101_ShikakuHantei_資格判定のデータ取得用クラスです。
 *
 * @reamsid_L AF-0070-030 liss
 */
public class KijitsumaeTohyoShikakuHanteiFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KijitsumaeTohyoShikakuHanteiFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static KijitsumaeTohyoShikakuHanteiFinder createInstance() {
        return InstanceProvider.create(KijitsumaeTohyoShikakuHanteiFinder.class);
    }

    /**
     * 最新の転出日と転入日を返します。
     *
     * @param 識別コード 識別コード
     * @return List<FlexibleDate> 転出日と転入日のList
     */
    @Transaction
    public List<FlexibleDate> get転出転入日(ShikibetsuCode 識別コード) {
        List<FlexibleDate> 転出転入日 = new ArrayList<>();
        IShikakuhanteiMapper mapper = mapperProvider.create(IShikakuhanteiMapper.class);
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        ShikakuhanteiMybatisParameter parameter = new ShikakuhanteiMybatisParameter(消除年月日検索基準, FlexibleDate.MAX,
                識別コード, 0, searchKey);
        FlexibleDate 転出年月日 = mapper.selectNewTenshutsuYmd(parameter);
        if (転出年月日 != null) {
            転出転入日.add(転出年月日);
            parameter = new ShikakuhanteiMybatisParameter(消除年月日検索基準, 転出年月日,
                    識別コード, 0, searchKey);
            int rirekiNo = mapper.selectNewTenshutsuYmdSeq(parameter);
            parameter = new ShikakuhanteiMybatisParameter(登録年月日検索基準, 転出年月日,
                    識別コード, rirekiNo, searchKey);
            FlexibleDate 転入年月日 = mapper.selectNewTennyuYmd(parameter);
            転出転入日.add(転入年月日);
        } else {
            転出転入日.add(FlexibleDate.EMPTY);
            転出転入日.add(FlexibleDate.EMPTY);
        }
        return 転出転入日;
    }
}
