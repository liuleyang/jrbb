/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.fuzaishashikaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishashikaku.FuzaishaShikakuResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoshikaku.ITohyoShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不在者投票資格情報を管理するクラスです。
 *
 * @reamsid_L AF-0210-020 liuj
 */
public class FuzaishaShikakuManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public FuzaishaShikakuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyokuManager}のインスタンス
     */
    public static FuzaishaShikakuManager createInstance() {
        return InstanceProvider.create(FuzaishaShikakuManager.class);
    }

    /**
     * 選挙種類に合致するリストの投票区FROM～投票区TO範囲のリストを返します。
     *
     * @param 投票資格種類 Code
     * @param 識別コード ShikibetsuCode
     * @return Tohyoku
     */
    @Transaction
    public FuzaishaShikakuResult get不在者投票資格情報(ShikibetsuCode 識別コード, Code 投票資格種類) {
        requireNonNull(投票資格種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        ITohyoShikakuMapper mapper = mapperProvider.create(ITohyoShikakuMapper.class);
        投票資格種類 = null == 投票資格種類 ? Code.EMPTY : 投票資格種類;
        識別コード = null == 識別コード ? ShikibetsuCode.EMPTY : 識別コード;
        AfT114FuzaishaTohyoShikakuEntity entity = mapper.selectFuzaishaTohyoShikaku(識別コード, 投票資格種類);
        if (entity == null) {
            return null;
        }

        return new FuzaishaShikakuResult(entity);
    }

}
