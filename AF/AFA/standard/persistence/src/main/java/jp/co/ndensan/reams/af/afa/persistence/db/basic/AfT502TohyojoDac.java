/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502Tohyojo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票所テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT502TohyojoDac implements IInsertOrUpdatable<AfT502TohyojoEntity>,
        IDeletable<AfT502TohyojoEntity>, IPhysicalDeletable<AfT502TohyojoEntity>,
        ISaveable<AfT502TohyojoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された投票所に該当する、投票所エンティティを取得します。
     *
     * @param tohyojoCode 投票所コード
     * @return 該当した投票区エンティティ
     */
    @Transaction
    public AfT502TohyojoEntity select(RString tohyojoCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT502Tohyojo.class).
                where(eq(AfT502Tohyojo.tohyojoCode, tohyojoCode)).
                toObject(AfT502TohyojoEntity.class);
    }

    /**
     * すべての投票所エンティティリストを取得します。
     *
     * @return 該当した投票所エンティティリスト
     */
    @Transaction
    public List<AfT502TohyojoEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT502Tohyojo.class).
                order(by(AfT502Tohyojo.tohyojoCode)).
                toList(AfT502TohyojoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT502TohyojoEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT502TohyojoEntity> entities) {
        int count = 0;
        for (AfT502TohyojoEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT502TohyojoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    /**
     * エンティティの複数件削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int delete(List<AfT502TohyojoEntity> entities) {
        int count = 0;
        for (AfT502TohyojoEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT502TohyojoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT502TohyojoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT502TohyojoEntity entity) {
        return (select(entity.getTohyojoCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT502TohyojoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * エンティティの複数件の実削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(List<AfT502TohyojoEntity> entities) {
        int count = 0;
        for (AfT502TohyojoEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * エンティティを登録します。
     *
     * @param entity 対象のエンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT502TohyojoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(" 投票所エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
