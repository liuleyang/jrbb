/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501Tohyoku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票区テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT501TohyokuDac implements IInsertOrUpdatable<AfT501TohyokuEntity>,
        IDeletable<AfT501TohyokuEntity>, IPhysicalDeletable<AfT501TohyokuEntity>,
        ISaveable<AfT501TohyokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された選挙種類、投票区に該当する、投票区エンティティを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param tohyokuCode 投票区コード
     * @return 該当した投票区エンティティ
     */
    @Transaction
    public AfT501TohyokuEntity select(Code senkyoShurui, RString tohyokuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT501Tohyoku.class).
                where(and(eq(AfT501Tohyoku.senkyoShurui, senkyoShurui),
                                eq(AfT501Tohyoku.tohyokuCode, tohyokuCode))).
                toObject(AfT501TohyokuEntity.class);
    }

    /**
     * 指定された選挙種類に該当する、投票区エンティティリストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した投票区エンティティリスト
     */
    @Transaction
    public List<AfT501TohyokuEntity> select(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT501Tohyoku.class).
                where(eq(AfT501Tohyoku.senkyoShurui, senkyoShurui)).
                order(by(AfT501Tohyoku.tohyokuCode)).
                toList(AfT501TohyokuEntity.class);
    }

    /**
     * 指定された選挙種類、投票区範囲に該当する、投票区エンティティリストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param tohyokuFrom RString
     * @param tohyokuTo RString
     * @return 該当した投票区エンティティリスト
     */
    @Transaction
    public List<AfT501TohyokuEntity> select(Code senkyoShurui, RString tohyokuFrom, RString tohyokuTo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<ITrueFalseCriteria> jokenList = new ArrayList<>();
        jokenList.add(eq(AfT501Tohyoku.senkyoShurui, senkyoShurui));
        if (null != tohyokuFrom && !tohyokuFrom.isEmpty()) {
            jokenList.add(leq(tohyokuFrom, AfT501Tohyoku.tohyokuCode));
        }
        if (null != tohyokuTo && !tohyokuTo.isEmpty()) {
            jokenList.add(leq(AfT501Tohyoku.tohyokuCode, tohyokuTo));
        }
        return accessor.
                select().
                table(AfT501Tohyoku.class).
                where(and(jokenList)).
                order(by(AfT501Tohyoku.hyojijun)).
                toList(AfT501TohyokuEntity.class);
    }

    /**
     * 投票区エンティティリストを取得します。
     *
     * @return 該当した投票区エンティティリスト
     */
    @Transaction
    public List<AfT501TohyokuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT501Tohyoku.class).
                order(by(AfT501Tohyoku.senkyoShurui), by(AfT501Tohyoku.tohyokuCode)).
                toList(AfT501TohyokuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT501TohyokuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT501TohyokuEntity> entities) {
        int count = 0;
        for (AfT501TohyokuEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT501TohyokuEntity entity) {
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
    public int delete(List<AfT501TohyokuEntity> entities) {
        int count = 0;
        for (AfT501TohyokuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT501TohyokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT501TohyokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT501TohyokuEntity entity) {
        return (select(entity.getSenkyoShurui(), entity.getTohyokuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT501TohyokuEntity entity) {
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
    public int deletePhysical(List<AfT501TohyokuEntity> entities) {
        int count = 0;
        for (AfT501TohyokuEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT501TohyokuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT501TohyokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
