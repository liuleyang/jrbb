/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.meiboshokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.meiboshokai.MeiboShokaiSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.meiboshokai.MeiboShokaiMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meiboshokai.MeiboShokaiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meiboshokai.IMeiboShokaiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 名簿照会用ファインダークラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public class MeiboShokaiFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    MeiboShokaiFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static MeiboShokaiFinder createInstance() {
        return InstanceProvider.create(MeiboShokaiFinder.class);
    }

    /**
     * 投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @return 投票状況一覧検索結果 SearchResult<MeiboShokaiSearchResult>
     */
    @Transaction
    public SearchResult<MeiboShokaiSearchResult> get投票状況一覧(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {

        MeiboShokaiMapperParameter 名簿照会検索条件 = new MeiboShokaiMapperParameter(抄本番号, 識別コード);
        IMeiboShokaiMapper mapper = mapperProvider.create(IMeiboShokaiMapper.class);
        List<MeiboShokaiEntity> entitys = mapper.selectTohyoJokyoIchiran(名簿照会検索条件);
        if (entitys.isEmpty()) {
            return SearchResult.of(Collections.<MeiboShokaiSearchResult>emptyList(), 0, false);
        }

        List<MeiboShokaiSearchResult> searchResult = new ArrayList<>();
        for (MeiboShokaiEntity entity : entitys) {
            searchResult.add(new MeiboShokaiSearchResult(entity));
        }

        return SearchResult.of(searchResult, 0, false);
    }
}
