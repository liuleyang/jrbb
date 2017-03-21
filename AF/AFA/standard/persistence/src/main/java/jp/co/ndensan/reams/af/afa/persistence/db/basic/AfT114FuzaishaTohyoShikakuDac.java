/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAppendType;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不在者投票資格のデータアクセスクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class AfT114FuzaishaTohyoShikakuDac implements ISaveable<AfT114FuzaishaTohyoShikakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで不在者投票資格を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 投票資格種類 TohyoShikakuShurui
     * @param 履歴番号 Seq
     * @return AfT114FuzaishaTohyoShikakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT114FuzaishaTohyoShikakuEntity selectByKey(
            ShikibetsuCode 識別コード,
            Code 投票資格種類,
            BigSerial 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(投票資格種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT114FuzaishaTohyoShikaku.class).
                where(and(
                                eq(AfT114FuzaishaTohyoShikaku.shikibetsuCode, 識別コード),
                                eq(AfT114FuzaishaTohyoShikaku.tohyoShikakuShurui, 投票資格種類),
                                eq(AfT114FuzaishaTohyoShikaku.seq, 履歴番号))).
                toObject(AfT114FuzaishaTohyoShikakuEntity.class);
    }

    /**
     * 直近の履歴のの抹消日を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 投票資格種類 TohyoShikakuShurui
     * @return AfT114FuzaishaTohyoShikakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT114FuzaishaTohyoShikakuEntity> select直近履歴(
            ShikibetsuCode 識別コード,
            Code 投票資格種類) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(投票資格種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT114FuzaishaTohyoShikaku.class).
                where(and(
                                eq(AfT114FuzaishaTohyoShikaku.shikibetsuCode, 識別コード),
                                eq(AfT114FuzaishaTohyoShikaku.tohyoShikakuShurui, 投票資格種類),
                                not(eq(AfT114FuzaishaTohyoShikaku.shikakuMasshoYMD, "")))).
                order(new OrderBy(AfT114FuzaishaTohyoShikaku.seq, Order.DESC, NullsOrder.FIRST)).
                toList(AfT114FuzaishaTohyoShikakuEntity.class);
    }

    /**
     * 不在者投票資格の投票資格種類を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return AfT114FuzaishaTohyoShikakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT114FuzaishaTohyoShikakuEntity> select不在者投票資格(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT114FuzaishaTohyoShikaku.class).
                where(
                        eq(AfT114FuzaishaTohyoShikaku.shikibetsuCode, 識別コード)).
                toList(AfT114FuzaishaTohyoShikakuEntity.class);
    }

    /**
     * 不在者投票資格を全件返します。
     *
     * @return AfT114FuzaishaTohyoShikakuEntityの{@code list}
     */
    @Transaction
    public List<AfT114FuzaishaTohyoShikakuEntity> selectAll() {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT114FuzaishaTohyoShikaku.class).
                toList(AfT114FuzaishaTohyoShikakuEntity.class);
    }

    /**
     * AfT114FuzaishaTohyoShikakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT114FuzaishaTohyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格エンティティ"));
        return DbAccessors.saveBy(new DbAccessorForAppendType(session), entity);
    }

    /**
     * AfT114FuzaishaTohyoShikakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save不在者投票(AfT114FuzaishaTohyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
