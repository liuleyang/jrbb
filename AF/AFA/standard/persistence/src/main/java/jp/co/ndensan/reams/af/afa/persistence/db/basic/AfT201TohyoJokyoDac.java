/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.juriTime;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.juriYMD;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.reamsClientId;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.senkyoNo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.shikibetsuCode;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.shohonNo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyo.tohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票状況のデータアクセスクラスです。
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class AfT201TohyoJokyoDac implements ISaveable<AfT201TohyoJokyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @param 選挙番号 SenkyoNo
     * @return AfT201TohyoJokyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT201TohyoJokyoEntity selectByKey(
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            SenkyoNo 選挙番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(senkyoNo, 選挙番号))).
                toObject(AfT201TohyoJokyoEntity.class);
    }

    /**
     * 主キーで投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT201TohyoJokyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT201TohyoJokyoEntity> selectByShohonNo(
            ShohonNo 抄本番号) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                where(eq(shohonNo, 抄本番号)).
                toList(AfT201TohyoJokyoEntity.class);
    }

    /**
     * 投票状況を全件返します。
     *
     * @return AfT201TohyoJokyoEntityの{@code list}
     */
    @Transaction
    public List<AfT201TohyoJokyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                toList(AfT201TohyoJokyoEntity.class);
    }

    /**
     * AfT201TohyoJokyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT201TohyoJokyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定選挙番号、選挙番号AfT201TohyoJokyoEntityを削除します。
     *
     * @param entity AfT201TohyoJokyoEntity
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(AfT201TohyoJokyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 抄本番号、選挙番号によって、投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 List<SenkyoNo>
     * @return 投票状況リスト
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT201TohyoJokyoEntity> selectByShohonSenkyoNo(ShohonNo 抄本番号, List<SenkyoNo> 選挙番号)
            throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                in(senkyoNo, 選挙番号))).
                toList(AfT201TohyoJokyoEntity.class);
    }

    /**
     * 端末IDで投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 端末ID RString
     * @param 投票状況 RString
     *
     * @return AfT201TohyoJokyoEntityの{@code list}
     */
    @Transaction
    public List<AfT201TohyoJokyoEntity> selectByClientId(ShohonNo 抄本番号, RString 端末ID, RString 投票状況) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                eq(tohyoJokyo, 投票状況),
                                eq(reamsClientId, 端末ID))).
                order(by(juriYMD, Order.DESC), by(juriTime, Order.DESC)).
                toList(AfT201TohyoJokyoEntity.class);
    }

    /**
     * 抄本番号によって、投票状況を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 投票状況リスト
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT201TohyoJokyoEntity> selectByShohon(ShohonNo 抄本番号)
            throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT201TohyoJokyo.class).
                where(
                        eq(shohonNo, 抄本番号)).
                toList(AfT201TohyoJokyoEntity.class);
    }
}
