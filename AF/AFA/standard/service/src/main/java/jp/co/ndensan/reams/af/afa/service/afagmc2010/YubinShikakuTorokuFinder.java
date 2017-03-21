/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.afagmc2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.business.reprintteiji.ShohonSenkyoSearchResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT114FuzaishaTohyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.yubinshikakutoroku.IyubinshikakutorokuMapper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 郵便等投票資格登録のファインダーです。
 *
 * @reamsid_L AF-0020-010 liuj2
 */
public class YubinShikakuTorokuFinder {

    private final AfT114FuzaishaTohyoShikakuDac 不在者投票資格Dac;
    private final AfaMapperProvider mapperProvider;

    YubinShikakuTorokuFinder() {
        this.不在者投票資格Dac = InstanceProvider.create(AfT114FuzaishaTohyoShikakuDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static YubinShikakuTorokuFinder createInstance() {
        return InstanceProvider.create(YubinShikakuTorokuFinder.class);
    }

    /**
     * 抄本選を取得します。
     *
     * @param 登録日 FlexibleDate
     * @return 抄本選挙一覧検索結果 SearchResult<ShohonSenkyoSearchResult>
     */
    @Transaction
    public ShohonSenkyoSearchResult get抄本(FlexibleDate 登録日) {

        IyubinshikakutorokuMapper mapper = mapperProvider.create(IyubinshikakutorokuMapper.class);
        ShohonSenkyoEntity shohonSenkyo = mapper.getShohonSenkyo(登録日);
        if (null == shohonSenkyo) {
            return null;
        }
        return new ShohonSenkyoSearchResult(shohonSenkyo);
    }

    /**
     * 抄本選を取得します。
     *
     * @return 抄本選挙一覧検索結果 SearchResult<ShohonSenkyoSearchResult>
     */
    @Transaction
    public ShohonSenkyoSearchResult get最新抄本() {

        IyubinshikakutorokuMapper mapper = mapperProvider.create(IyubinshikakutorokuMapper.class);
        ShohonSenkyoEntity shohonSenkyo = mapper.getSaisinShohonSenkyo();
        if (null == shohonSenkyo) {
            return null;
        }
        return new ShohonSenkyoSearchResult(shohonSenkyo);
    }

    /**
     * 直近履歴を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 投票資格種類 Code
     * @return 不在者投票資格
     */
    public FuzaishaShikakuResult select直近履歴(ShikibetsuCode 識別コード, Code 投票資格種類) {
        List<AfT114FuzaishaTohyoShikakuEntity> list = 不在者投票資格Dac.select直近履歴(識別コード, 投票資格種類);
        if (list != null && !list.isEmpty()) {
            return new FuzaishaShikakuResult(list.get(0));
        }
        return null;
    }
}
