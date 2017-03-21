/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.reprintteiji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.reprintteiji.IShohonSenkyoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 定時登録再発行のファインダーです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public class RePrintTeijiFinder {

    private final AfaMapperProvider mapperProvider;

    RePrintTeijiFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static RePrintTeijiFinder createInstance() {
        return InstanceProvider.create(RePrintTeijiFinder.class);
    }

    /**
     * 抄本選挙一覧を取得します。
     *
     * @return 抄本選挙一覧検索結果 SearchResult<ShohonSenkyoSearchResult>
     */
    @Transaction
    public SearchResult<ShohonSenkyoSearchResult> get抄本選挙一覧() {

        IShohonSenkyoMapper mapper = mapperProvider.create(IShohonSenkyoMapper.class);
        List<ShohonSenkyoEntity> shohonSenkyoList = mapper.selectShohonSenkyoList();
        if (shohonSenkyoList.isEmpty()) {
            return SearchResult.of(Collections.<ShohonSenkyoSearchResult>emptyList(), 0, false);
        }

        List<ShohonSenkyoSearchResult> searchResult = new ArrayList<>();
        for (ShohonSenkyoEntity shohonSenkyo : shohonSenkyoList) {
            searchResult.add(new ShohonSenkyoSearchResult(shohonSenkyo));
        }

        return SearchResult.of(searchResult, 0, false);
    }
}
