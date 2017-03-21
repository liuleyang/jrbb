/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.yubinshikaku;

import jp.co.ndensan.reams.af.afa.business.yubinshikaku.YubinShikakuResult;
import jp.co.ndensan.reams.af.afa.entity.db.relate.yubinshikaku.YubinShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.yubinshikaku.IYubinShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 郵便等投票資格情報共有子DIVビジネスクラス
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class YubinShikakuFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    YubinShikakuFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    YubinShikakuFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンス
     */
    public static YubinShikakuFinder createInstance() {
        return InstanceProvider.create(YubinShikakuFinder.class);
    }

    /**
     * 郵便等投票資格情報を取得する
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return YubinShikakuResult
     */
    @Transaction
    public YubinShikakuResult get郵便等投票資格情報(ShikibetsuCode shikibetsuCode) {

        IYubinShikakuMapper yubinShikakuMapper = mapperProvider.create(IYubinShikakuMapper.class);
        YubinShikakuEntity 郵便等投票資格情報 = yubinShikakuMapper.select郵便等投票資格情報(shikibetsuCode);
        if (null == 郵便等投票資格情報) {
            return null;
        }
        return new YubinShikakuResult(郵便等投票資格情報);
    }
}
