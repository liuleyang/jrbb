/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508Hojosha;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 補助者テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT508HojoshaDac implements IInsertOrUpdatable<AfT508HojoshaEntity>,
        IDeletable<AfT508HojoshaEntity>, IPhysicalDeletable<AfT508HojoshaEntity>,
        ISaveable<AfT508HojoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号、識別コードに該当する、補助者エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param shikibetsuCode 識別コード
     * @return 該当した補助者エンティティ
     */
    @Transaction
    public AfT508HojoshaEntity select(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT508Hojosha.class).
                where(and(eq(AfT508Hojosha.shohonNo, shohonNo),
                                eq(AfT508Hojosha.shikibetsuCode, shikibetsuCode))).
                toObject(AfT508HojoshaEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、補助者エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した補助者エンティティリスト
     */
    @Transaction
    public List<AfT508HojoshaEntity> select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT508Hojosha.class).
                where(eq(AfT508Hojosha.shohonNo, shohonNo)).
                order(by(AfT508Hojosha.shikibetsuCode)).
                toList(AfT508HojoshaEntity.class);
    }

    /**
     * 補助者エンティティリストを取得します。
     *
     * @return 該当した補助者エンティティリスト
     */
    @Transaction
    public List<AfT508HojoshaEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT508Hojosha.class).
                order(by(AfT508Hojosha.shohonNo), by(AfT508Hojosha.shikibetsuCode)).
                toList(AfT508HojoshaEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT508HojoshaEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT508HojoshaEntity> entities) {
        int count = 0;
        for (AfT508HojoshaEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT508HojoshaEntity entity) {
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
    public int delete(List<AfT508HojoshaEntity> entities) {
        int count = 0;
        for (AfT508HojoshaEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT508HojoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT508HojoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT508HojoshaEntity entity) {
        return (select(entity.getShohonNo(), entity.getShikibetsuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT508HojoshaEntity entity) {
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
    public int deletePhysical(List<AfT508HojoshaEntity> entities) {
        int count = 0;
        for (AfT508HojoshaEntity entity : entities) {
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
    public int save(AfT508HojoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("補助者エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
