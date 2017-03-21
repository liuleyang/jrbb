/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2Condition;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
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
 * 地区2条件テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0450-011 jihb
 */
public class AfT146Chiku2ConditionDac implements IInsertable<AfT146Chiku2ConditionEntity>,
        IDeletable<AfT146Chiku2ConditionEntity>, IPhysicalDeletable<AfT146Chiku2ConditionEntity>,
        ISaveable<AfT146Chiku2ConditionEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号に該当する、地区2抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した地区2抽出条件エンティティ
     */
    @Transaction
    public List<AfT146Chiku2ConditionEntity> selectListByShohonNo(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT146Chiku2Condition.class).
                where(eq(AfT146Chiku2Condition.shohonNo, shohonNo)).
                toList(AfT146Chiku2ConditionEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、地区2抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した地区2抽出条件エンティティ
     */
    @Transaction
    public AfT146Chiku2ConditionEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT146Chiku2Condition.class).
                where(eq(AfT146Chiku2Condition.shohonNo, shohonNo)).
                toObject(AfT146Chiku2ConditionEntity.class);
    }

    /**
     * すべての地区2抽出条件エンティティリストを取得します。
     *
     * @return 該当した地区2抽出条件エンティティリスト
     */
    @Transaction
    public List<AfT146Chiku2ConditionEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT146Chiku2Condition.class).
                order(by(AfT146Chiku2Condition.shohonNo)).
                toList(AfT146Chiku2ConditionEntity.class);
    }

    @Override
    @Transaction
    public int insert(AfT146Chiku2ConditionEntity entity) {
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
    public int insert(List<AfT146Chiku2ConditionEntity> entities) {
        int count = 0;
        for (AfT146Chiku2ConditionEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT146Chiku2ConditionEntity entity) {
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
    public int delete(List<AfT146Chiku2ConditionEntity> entities) {
        int count = 0;
        for (AfT146Chiku2ConditionEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int deletePhysical(AfT146Chiku2ConditionEntity entity) {
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
    public int deletePhysical(List<AfT146Chiku2ConditionEntity> entities) {
        int count = 0;
        for (AfT146Chiku2ConditionEntity entity : entities) {
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
    public int save(AfT146Chiku2ConditionEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区2条件エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
