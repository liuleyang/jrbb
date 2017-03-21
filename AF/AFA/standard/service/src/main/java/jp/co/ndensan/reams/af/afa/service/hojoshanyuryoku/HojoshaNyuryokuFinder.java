/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.hojoshanyuryoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku.HojoshaNyuryokuSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.hojoshanyuryoku.HojoshaNyuryokuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshanyuryoku.HojoshaNyuryokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.hojoshanyuryoku.IHojoshaNyuryokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 補助者入力共有子div用ファインダークラスです。
 *
 * @reamsid_L AF-0080-030 qiuxy
 */
public class HojoshaNyuryokuFinder {

    private final AfaMapperProvider mapperProvider;

    HojoshaNyuryokuFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static HojoshaNyuryokuFinder createInstance() {
        return InstanceProvider.create(HojoshaNyuryokuFinder.class);
    }

    /**
     * 補助者一覧を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 投票区コード RString
     * @return 補助者一覧検索結果 SearchResult<HojoshaNyuryokuSearchResult>
     */
    @Transaction
    public SearchResult<HojoshaNyuryokuSearchResult> get補助者一覧(ShohonNo 抄本番号, RString 投票区コード) {

        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義).build();
        HojoshaNyuryokuMapperParameter 補助者入力検索条件 = new HojoshaNyuryokuMapperParameter(抄本番号, 投票区コード, searchKey);
        IHojoshaNyuryokuMapper mapper = mapperProvider.create(IHojoshaNyuryokuMapper.class);
        List<HojoshaNyuryokuEntity> hojoshaNyuryokuList = mapper.selectHojoshaNyuryokuList(補助者入力検索条件);
        if (hojoshaNyuryokuList.isEmpty()) {
            return SearchResult.of(Collections.<HojoshaNyuryokuSearchResult>emptyList(), 0, false);
        }

        List<HojoshaNyuryokuSearchResult> searchResult = new ArrayList<>();
        for (HojoshaNyuryokuEntity hojoshaNyuryoku : hojoshaNyuryokuList) {
            searchResult.add(new HojoshaNyuryokuSearchResult(hojoshaNyuryoku));
        }

        return SearchResult.of(searchResult, 0, false);
    }
}
