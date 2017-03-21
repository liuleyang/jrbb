/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503Senkyoku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
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
 * 選挙区テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT503SenkyokuDac implements IInsertOrUpdatable<AfT503SenkyokuEntity>,
        IDeletable<AfT503SenkyokuEntity>, IPhysicalDeletable<AfT503SenkyokuEntity>,
        ISaveable<AfT503SenkyokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された選挙種類、選挙区に該当する、選挙区エンティティを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param senkyokuCode 選挙区コード
     * @return 該当した選挙区エンティティ
     */
    @Transaction
    public AfT503SenkyokuEntity select(Code senkyoShurui, RString senkyokuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT503Senkyoku.class).
                where(and(eq(AfT503Senkyoku.senkyoShurui, senkyoShurui),
                                eq(AfT503Senkyoku.senkyokuCode, senkyokuCode))).
                toObject(AfT503SenkyokuEntity.class);
    }

    /**
     * 指定された選挙種類に該当する、選挙区エンティティリストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した選挙区エンティティリスト
     */
    @Transaction
    public List<AfT503SenkyokuEntity> select(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT503Senkyoku.class).
                where(eq(AfT503Senkyoku.senkyoShurui, senkyoShurui)).
                order(by(AfT503Senkyoku.senkyokuCode)).
                toList(AfT503SenkyokuEntity.class);
    }

    /**
     * 選挙区エンティティリストを取得します。
     *
     * @return 該当した選挙区エンティティリスト
     */
    @Transaction
    public List<AfT503SenkyokuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT503Senkyoku.class).
                order(by(AfT503Senkyoku.senkyoShurui), by(AfT503Senkyoku.senkyokuCode)).
                toList(AfT503SenkyokuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT503SenkyokuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT503SenkyokuEntity> entities) {
        int count = 0;
        for (AfT503SenkyokuEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT503SenkyokuEntity entity) {
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
    public int delete(List<AfT503SenkyokuEntity> entities) {
        int count = 0;
        for (AfT503SenkyokuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT503SenkyokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT503SenkyokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT503SenkyokuEntity entity) {
        return (select(entity.getSenkyoShurui(), entity.getSenkyokuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT503SenkyokuEntity entity) {
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
    public int deletePhysical(List<AfT503SenkyokuEntity> entities) {
        int count = 0;
        for (AfT503SenkyokuEntity entity : entities) {
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
    public int save(AfT503SenkyokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
