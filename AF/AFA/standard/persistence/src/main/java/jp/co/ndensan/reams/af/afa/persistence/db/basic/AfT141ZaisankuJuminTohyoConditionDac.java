/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoCondition;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
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
 * 財産区・住民投票選挙人抽出条件テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT141ZaisankuJuminTohyoConditionDac
        implements IInsertOrUpdatable<AfT141ZaisankuJuminTohyoConditionEntity>,
        IDeletable<AfT141ZaisankuJuminTohyoConditionEntity>, IPhysicalDeletable<AfT141ZaisankuJuminTohyoConditionEntity>,
        ISaveable<AfT141ZaisankuJuminTohyoConditionEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号に該当する、財産区・住民投票選挙人抽出条件エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した財産区・住民投票選挙人抽出条件エンティティ
     */
    @Transaction
    public AfT141ZaisankuJuminTohyoConditionEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT141ZaisankuJuminTohyoCondition.class).
                where(eq(AfT141ZaisankuJuminTohyoCondition.shohonNo, shohonNo)).
                toObject(AfT141ZaisankuJuminTohyoConditionEntity.class);
    }

    /**
     * すべての財産区・住民投票選挙人抽出条件エンティティリストを取得します。
     *
     * @return 該当した財産区・住民投票選挙人抽出条件エンティティリスト
     */
    @Transaction
    public List<AfT141ZaisankuJuminTohyoConditionEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT141ZaisankuJuminTohyoCondition.class).
                order(by(AfT141ZaisankuJuminTohyoCondition.shohonNo)).
                toList(AfT141ZaisankuJuminTohyoConditionEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT141ZaisankuJuminTohyoConditionEntity entity) {
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
    public int delete(List<AfT141ZaisankuJuminTohyoConditionEntity> entities) {
        int count = 0;
        for (AfT141ZaisankuJuminTohyoConditionEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        return (select(entity.getShohonNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT141ZaisankuJuminTohyoConditionEntity entity) {
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
    public int deletePhysical(List<AfT141ZaisankuJuminTohyoConditionEntity> entities) {
        int count = 0;
        for (AfT141ZaisankuJuminTohyoConditionEntity entity : entities) {
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
    public int save(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(" 財産区・住民投票選挙人抽出条件エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
