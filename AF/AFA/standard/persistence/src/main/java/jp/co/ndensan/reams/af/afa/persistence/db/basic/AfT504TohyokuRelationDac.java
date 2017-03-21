/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelation;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票区投票所対応テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT504TohyokuRelationDac implements IInsertOrUpdatable<AfT504TohyokuRelationEntity>,
        IDeletable<AfT504TohyokuRelationEntity>, IPhysicalDeletable<AfT504TohyokuRelationEntity>,
        ISaveable<AfT504TohyokuRelationEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された選挙種類、投票区に該当する、投票区投票所対応エンティティを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param tohyokuCode 投票区コード
     * @return 該当した投票区投票所対応エンティティ
     */
    @Transaction
    public AfT504TohyokuRelationEntity select(Code senkyoShurui, RString tohyokuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT504TohyokuRelation.class).
                where(and(eq(AfT504TohyokuRelation.senkyoShurui, senkyoShurui),
                                eq(AfT504TohyokuRelation.tohyokuCode, tohyokuCode))).
                toObject(AfT504TohyokuRelationEntity.class);
    }

    /**
     * 指定された選挙種類に該当する、投票区投票所対応エンティティリストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した投票区投票所対応エンティティリスト
     */
    @Transaction
    public List<AfT504TohyokuRelationEntity> select(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT504TohyokuRelation.class).
                where(eq(AfT504TohyokuRelation.senkyoShurui, senkyoShurui)).
                order(by(AfT504TohyokuRelation.tohyokuCode)).
                toList(AfT504TohyokuRelationEntity.class);
    }

    /**
     * 投票区投票所対応エンティティリストを取得します。
     *
     * @return 該当した投票区投票所対応エンティティリスト
     */
    @Transaction
    public List<AfT504TohyokuRelationEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT504TohyokuRelation.class).
                order(by(AfT504TohyokuRelation.senkyoShurui), by(AfT504TohyokuRelation.tohyokuCode)).
                toList(AfT504TohyokuRelationEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT504TohyokuRelationEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT504TohyokuRelationEntity> entities) {
        int count = 0;
        for (AfT504TohyokuRelationEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT504TohyokuRelationEntity entity) {
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
    public int delete(List<AfT504TohyokuRelationEntity> entities) {
        int count = 0;
        for (AfT504TohyokuRelationEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT504TohyokuRelationEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT504TohyokuRelationEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT504TohyokuRelationEntity entity) {
        return (select(entity.getSenkyoShurui(), entity.getTohyokuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT504TohyokuRelationEntity entity) {
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
    public int deletePhysical(List<AfT504TohyokuRelationEntity> entities) {
        int count = 0;
        for (AfT504TohyokuRelationEntity entity : entities) {
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
    public int save(AfT504TohyokuRelationEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区投票所対応エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
