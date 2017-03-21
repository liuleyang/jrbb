/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3Condition;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区3条件テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0450-011 jihb
 */
public class AfT147Chiku3ConditionDac implements IInsertable<AfT147Chiku3ConditionEntity>,
        IDeletable<AfT147Chiku3ConditionEntity>, IPhysicalDeletable<AfT147Chiku3ConditionEntity>,
        ISaveable<AfT147Chiku3ConditionEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号に該当する、地区3抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した地区3抽出条件エンティティ
     */
    @Transaction
    public List<AfT147Chiku3ConditionEntity> selectListByShohonNo(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT147Chiku3Condition.class).
                where(eq(AfT147Chiku3Condition.shohonNo, shohonNo)).
                toList(AfT147Chiku3ConditionEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、地区3抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した地区3抽出条件エンティティ
     */
    @Transaction
    public AfT147Chiku3ConditionEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT147Chiku3Condition.class).
                where(eq(AfT147Chiku3Condition.shohonNo, shohonNo)).
                toObject(AfT147Chiku3ConditionEntity.class);
    }

    /**
     * すべての地区3抽出条件エンティティリストを取得します。
     *
     * @return 該当した地区3抽出条件エンティティリスト
     */
    @Transaction
    public List<AfT147Chiku3ConditionEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT147Chiku3Condition.class).
                order(by(AfT147Chiku3Condition.shohonNo)).
                toList(AfT147Chiku3ConditionEntity.class);
    }

    @Override
    @Transaction
    public int insert(AfT147Chiku3ConditionEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * エンティティの複数件登録を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 登録件数
     */
    @Transaction
    public int insert(List<AfT147Chiku3ConditionEntity> entities) {
        int count = 0;
        for (AfT147Chiku3ConditionEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT147Chiku3ConditionEntity entity) {
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
    public int delete(List<AfT147Chiku3ConditionEntity> entities) {
        int count = 0;
        for (AfT147Chiku3ConditionEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int deletePhysical(AfT147Chiku3ConditionEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * エンティティの複数件実削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(List<AfT147Chiku3ConditionEntity> entities) {
        int count = 0;
        for (AfT147Chiku3ConditionEntity entity : entities) {
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
    public int save(AfT147Chiku3ConditionEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区3条件エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
