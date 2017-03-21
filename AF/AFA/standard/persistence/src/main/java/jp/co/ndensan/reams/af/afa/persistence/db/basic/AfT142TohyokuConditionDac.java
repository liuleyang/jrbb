/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuCondition;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
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
 * 投票区抽出条件テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0450-011 jihb
 */
public class AfT142TohyokuConditionDac implements IInsertable<AfT142TohyokuConditionEntity>,
        IDeletable<AfT142TohyokuConditionEntity>, IPhysicalDeletable<AfT142TohyokuConditionEntity>,
        ISaveable<AfT142TohyokuConditionEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号に該当する、投票区抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した投票区抽出条件エンティティ
     */
    @Transaction
    public List<AfT142TohyokuConditionEntity> selectListByShohonNo(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT142TohyokuCondition.class).
                where(eq(AfT142TohyokuCondition.shohonNo, shohonNo)).
                toList(AfT142TohyokuConditionEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、投票区抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した投票区抽出条件エンティティ
     */
    @Transaction
    public AfT142TohyokuConditionEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT142TohyokuCondition.class).
                where(eq(AfT142TohyokuCondition.shohonNo, shohonNo)).
                toObject(AfT142TohyokuConditionEntity.class);
    }

    /**
     * すべての投票区抽出条件エンティティリストを取得します。
     *
     * @return 該当した投票区抽出条件エンティティリスト
     */
    @Transaction
    public List<AfT142TohyokuConditionEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT142TohyokuCondition.class).
                order(by(AfT142TohyokuCondition.shohonNo)).
                toList(AfT142TohyokuConditionEntity.class);
    }

    @Override
    @Transaction
    public int insert(AfT142TohyokuConditionEntity entity) {
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
    public int insert(List<AfT142TohyokuConditionEntity> entities) {
        int count = 0;
        for (AfT142TohyokuConditionEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT142TohyokuConditionEntity entity) {
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
    public int delete(List<AfT142TohyokuConditionEntity> entities) {
        int count = 0;
        for (AfT142TohyokuConditionEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int deletePhysical(AfT142TohyokuConditionEntity entity) {
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
    public int deletePhysical(List<AfT142TohyokuConditionEntity> entities) {
        int count = 0;
        for (AfT142TohyokuConditionEntity entity : entities) {
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
    public int save(AfT142TohyokuConditionEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(" 投票区抽出条件エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
