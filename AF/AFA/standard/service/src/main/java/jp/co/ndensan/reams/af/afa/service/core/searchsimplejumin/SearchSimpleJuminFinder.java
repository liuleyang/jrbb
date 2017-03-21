/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.searchsimplejumin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.FindShikibetsuTaishoResult;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住民検索（簡易版）クラスです。
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminFinder {

//    private final AfaMapperProvider mapperProvider;
    private final UaFt200FindShikibetsuTaishoFunctionDac dac_UaFt200;
//    private final AfT114FuzaishaTohyoShikakuDac dac_afT114;

    /**
     * コンストラクタです。
     */
    SearchSimpleJuminFinder() {
//        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        dac_UaFt200 = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class);
//        dac_afT114 = InstanceProvider.create(AfT114FuzaishaTohyoShikakuDac.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static SearchSimpleJuminFinder createInstance() {
        return InstanceProvider.create(SearchSimpleJuminFinder.class);
    }

//    /**
//     * 投票状況を取得します。
//     *
//     * @param parameter SearchSimpleJuminParameter
//     * @return 投票状況一覧検索結果 SearchResult<MeiboShokaiSearchResult>
//     */
//    @Transaction
//    public List<SearchSimpleJuminResult> get選挙人情報(SearchSimpleJuminParameter parameter) {
//
//        ShikakuShuruiParameter shikakuShuruiParameter = new ShikakuShuruiParameter();
//        shikakuShuruiParameter.setSenkyoShurui(parameter.getSenkyoShurui());
//        shikakuShuruiParameter.setTohyokuCode(parameter.getTohyokuCode());
//        shikakuShuruiParameter.setShohonNo(parameter.getShohonNo());
//        shikakuShuruiParameter.setShikakuKubunList(parameter.getShikakuKubunList());
//        shikakuShuruiParameter.set識別コード(parameter.get識別コード());
//        ISearchSimpleJuminMapper mapper = mapperProvider.create(ISearchSimpleJuminMapper.class);
//        List<SearchSimpleJuminEntity> entitys = mapper.select選挙人情報(shikakuShuruiParameter);
//        if (entitys.isEmpty()) {
//            return new ArrayList();
//        }
//        List<SearchSimpleJuminResult> searchResult = new ArrayList<>();
//        for (SearchSimpleJuminEntity entity : entitys) {
//            searchResult.add(new SearchSimpleJuminResult(entity));
//        }
//
//        return searchResult;
//    }
//
//    /**
//     * 投票資格の不在者投票資格を取得します。
//     *
//     * @param parameter SearchSimpleJuminParameter
//     * @return 投票状況一覧検索結果 SearchResult<MeiboShokaiSearchResult>
//     */
//    @Transaction
//    public List<SearchSimpleJuminResult> get投票資格の不在者投票資格(SearchSimpleJuminParameter parameter) {
//
//        ShikakuShuruiParameter shikakuShuruiParameter = new ShikakuShuruiParameter();
//        shikakuShuruiParameter.setTohyoYMD(parameter.getTohyoYMD());
//        shikakuShuruiParameter.setTohyoShikakuShuruiList(parameter.getTohyoShikakuShuruiList());
//        ISearchSimpleJuminMapper mapper = mapperProvider.create(ISearchSimpleJuminMapper.class);
//        List<SearchSimpleJuminEntity> entitys = mapper.select投票資格の不在者投票資格(shikakuShuruiParameter);
//        if (entitys.isEmpty()) {
//            return null;
//        }
//
//        List<SearchSimpleJuminResult> searchResult = new ArrayList<>();
//        for (SearchSimpleJuminEntity entity : entitys) {
//            searchResult.add(new SearchSimpleJuminResult(entity));
//        }
//
//        return searchResult;
//    }
//
//    /**
//     * 投票資格の選挙資格を取得します。
//     *
//     * @param parameter SearchSimpleJuminParameter
//     * @return 投票状況一覧検索結果 SearchResult<MeiboShokaiSearchResult>
//     */
//    @Transaction
//    public List<SearchSimpleJuminResult> get投票資格の選挙資格(SearchSimpleJuminParameter parameter) {
//
//        ShikakuShuruiParameter shikakuShuruiParameter = new ShikakuShuruiParameter();
//        ISearchSimpleJuminMapper mapper = mapperProvider.create(ISearchSimpleJuminMapper.class);
//        shikakuShuruiParameter.setSenkyoShurui(parameter.getSenkyoShurui());
//        List<SearchSimpleJuminEntity> entitys = mapper.select投票資格の選挙資格(shikakuShuruiParameter);
//        if (entitys.isEmpty()) {
//            return null;
//        }
//
//        List<SearchSimpleJuminResult> searchResult = new ArrayList<>();
//        for (SearchSimpleJuminEntity entity : entitys) {
//            searchResult.add(new SearchSimpleJuminResult(entity));
//        }
//
//        return searchResult;
//    }
//
    /**
     * パラメータより、住民情報を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 基準日 FlexibleDate
     * @return 本人情報初期情報
     */
    public List<FindShikibetsuTaishoResult> get宛名PSM(ShikibetsuCode 識別コード, FlexibleDate 基準日) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.set識別コード(識別コード);
        key.set基準日(基準日);
        IPsmCriteria psmCriteria = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM情報リスト = dac_UaFt200.select(psmCriteria);

        if (宛名PSM情報リスト.isEmpty()) {
            return null;
        }
        List<FindShikibetsuTaishoResult> 宛名PSM = new ArrayList<>();
        for (UaFt200FindShikibetsuTaishoEntity uaFt200Entity : 宛名PSM情報リスト) {
            宛名PSM.add(new FindShikibetsuTaishoResult(uaFt200Entity));
        }

        return 宛名PSM;
    }

//    /**
//     * パラメータより、住民情報を取得する。
//     *
//     * @param searchKey IShikibetsuTaishoSearchKey
//     * @return 本人情報初期情報
//     */
//    public List<FindShikibetsuTaishoResult> get住民情報(IShikibetsuTaishoSearchKey searchKey) {
//        IPsmCriteria psmCriteria = ShikibetsuTaishoSearchEntityHolder.getCriteria(searchKey);
//        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM情報リスト = dac_UaFt200.select(psmCriteria);
//        if (宛名PSM情報リスト.isEmpty()) {
//            return null;
//        }
//        List<FindShikibetsuTaishoResult> 宛名PSM = new ArrayList<>();
//        for (UaFt200FindShikibetsuTaishoEntity uaFt200Entity : 宛名PSM情報リスト) {
//            宛名PSM.add(new FindShikibetsuTaishoResult(uaFt200Entity));
//        }
//
//        return 宛名PSM;
//    }
//
//    /**
//     * 不在者投票資格データを取得する。
//     *
//     * @return 本人情報初期情報
//     */
//    public List<FuzaishaShikakuResult> get不在者投票資格() {
//
//        List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格 = dac_afT114.selectAll();
//
//        if (不在者投票資格.isEmpty()) {
//            return null;
//        }
//        List<FuzaishaShikakuResult> 不在者投票資格リスト = new ArrayList<>();
//
//        for (AfT114FuzaishaTohyoShikakuEntity afT114Entity : 不在者投票資格) {
//            不在者投票資格リスト.add(new FuzaishaShikakuResult(afT114Entity));
//        }
//        return 不在者投票資格リスト;
//    }
}
