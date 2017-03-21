/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.barcodejuri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodejuri.BarCodeJuriSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.barcodejuri.BarCodeJuriMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.barcodejuri.BarCodeJuriEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.barcodejuri.IBarCodeJuriMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のファインダークラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuriFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    BarCodeJuriFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static BarCodeJuriFinder createInstance() {
        return InstanceProvider.create(BarCodeJuriFinder.class);
    }

    /**
     * バーコード受理一覧を取得します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNo SenkyoNo
     * @param senkyoShurui Code
     * @return バーコード受理一覧 SearchResult<BarCodeJuriSearchResult>
     */
    @Transaction
    public SearchResult<BarCodeJuriSearchResult> getバーコード受理一覧(ShohonNo shohonNo,
            ShikibetsuCode shikibetsuCode,
            SenkyoNo senkyoNo,
            Code senkyoShurui) {
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義)
                .set識別コード(shikibetsuCode).build();
        BarCodeJuriMapperParameter バーコード検索条件 = new BarCodeJuriMapperParameter(shohonNo, shikibetsuCode, senkyoNo, senkyoShurui, searchKey);
        IBarCodeJuriMapper mapper = mapperProvider.create(IBarCodeJuriMapper.class);
        List<BarCodeJuriEntity> entitys = mapper.selectBarCodeJuriIchiran(バーコード検索条件);
        if (entitys.isEmpty()) {
            return SearchResult.of(Collections.<BarCodeJuriSearchResult>emptyList(), 0, false);
        }

        List<BarCodeJuriSearchResult> searchResult = new ArrayList<>();
        for (BarCodeJuriEntity entity : entitys) {
            searchResult.add(new BarCodeJuriSearchResult(entity));
        }

        return SearchResult.of(searchResult, 0, false);
    }
}
