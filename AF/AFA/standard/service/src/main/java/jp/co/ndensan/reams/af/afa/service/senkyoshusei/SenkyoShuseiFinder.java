/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.senkyoshusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojohoshusei.ISenkyoShuseiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙修正のファインダーです。
 *
 */
public class SenkyoShuseiFinder {

    private final AfaMapperProvider mapperProvider;
    private static final RString 選挙種類 = new RString("senkyoShurui");
    private static final RString 基準日 = new RString("kijunymd");
    private static final RString 検索条件抄本番号 = new RString("shohonNo");
    private static final RString 検索条件選挙番号 = new RString("senkyoNo");

    SenkyoShuseiFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static SenkyoShuseiFinder createInstance() {
        return InstanceProvider.create(SenkyoShuseiFinder.class);
    }

    /**
     * 選挙種類、基準日により、抄本選挙情報を取得します。
     *
     * @param senkyoShurui SenkyoShurui
     * @param kijunymd FlexibleDate
     * @return 抄本選挙一覧検索結果 SearchResult<ShohonSenkyoSearchResult>
     */
    @Transaction
    public SearchResult<ShohonSenkyoSearchResult> get抄本選挙一覧By選挙種類と基準日(SenkyoShurui senkyoShurui,
            FlexibleDate kijunymd) {

        ISenkyoShuseiMapper mapper = mapperProvider.create(ISenkyoShuseiMapper.class);
        Map<String, Object> searchCondition = new HashMap<>();
        searchCondition.put(選挙種類.toString(), senkyoShurui);
        searchCondition.put(基準日.toString(), kijunymd);
        List<ShohonSenkyoEntity> shohonSenkyoList
                = mapper.selectShohonSenkyoListByCondition(searchCondition);
        if (shohonSenkyoList.isEmpty()) {
            return SearchResult.of(Collections.<ShohonSenkyoSearchResult>emptyList(), 0, false);
        }

        List<ShohonSenkyoSearchResult> searchResult = new ArrayList<>();
        for (ShohonSenkyoEntity shohonSenkyo : shohonSenkyoList) {
            searchResult.add(new ShohonSenkyoSearchResult(shohonSenkyo));
        }

        return SearchResult.of(searchResult, 0, false);
    }

    /**
     * 検索条件により、抄本選挙情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 List<SenkyoNo>
     * @return 抄本選挙情報 List<ShohonSenkyoEntity>
     */
    @Transaction
    public int count投票状況By抄本選挙番号(ShohonNo 抄本番号, List<SenkyoNo> 選挙番号) {
        ISenkyoShuseiMapper mapper = mapperProvider.create(ISenkyoShuseiMapper.class);
        Map<String, Object> searchCondition = new HashMap<>();
        searchCondition.put(検索条件抄本番号.toString(), 抄本番号);
        searchCondition.put(検索条件選挙番号.toString(), 選挙番号);
        return mapper.count投票状況By抄本選挙番号(searchCondition);
    }
}
