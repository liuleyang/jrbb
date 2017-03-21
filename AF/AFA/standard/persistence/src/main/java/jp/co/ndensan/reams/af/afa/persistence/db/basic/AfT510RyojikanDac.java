/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510Ryojikan;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
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
 * 領事官テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT510RyojikanDac implements IInsertOrUpdatable<AfT510RyojikanEntity>,
        IDeletable<AfT510RyojikanEntity>, IPhysicalDeletable<AfT510RyojikanEntity>,
        ISaveable<AfT510RyojikanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された領事官コードに該当する、領事官エンティティを取得します。
     *
     * @param ryojikanCode 領事官コード
     * @return 該当した領事官エンティティ
     */
    @Transaction
    public AfT510RyojikanEntity select(RString ryojikanCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT510Ryojikan.class).
                where(eq(AfT510Ryojikan.ryojikanCode, ryojikanCode)).
                toObject(AfT510RyojikanEntity.class);
    }

    /**
     * すべての領事官エンティティリストを取得します。
     *
     * @return 該当した領事官エンティティリスト
     */
    @Transaction
    public List<AfT510RyojikanEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT510Ryojikan.class).
                order(by(AfT510Ryojikan.ryojikanCode)).
                toList(AfT510RyojikanEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT510RyojikanEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT510RyojikanEntity> entities) {
        int count = 0;
        for (AfT510RyojikanEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT510RyojikanEntity entity) {
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
    public int delete(List<AfT510RyojikanEntity> entities) {
        int count = 0;
        for (AfT510RyojikanEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT510RyojikanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT510RyojikanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT510RyojikanEntity entity) {
        return (select(entity.getRyojikanCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT510RyojikanEntity entity) {
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
    public int deletePhysical(List<AfT510RyojikanEntity> entities) {
        int count = 0;
        for (AfT510RyojikanEntity entity : entities) {
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
    public int save(AfT510RyojikanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("領事官エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
