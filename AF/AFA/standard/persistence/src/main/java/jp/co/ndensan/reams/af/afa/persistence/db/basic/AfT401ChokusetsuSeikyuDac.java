/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 直接請求テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0140-020 wangh
 */
public class AfT401ChokusetsuSeikyuDac
        implements IInsertOrUpdatable<AfT401ChokusetsuSeikyuEntity>,
        IDeletable<AfT401ChokusetsuSeikyuEntity>, IPhysicalDeletable<AfT401ChokusetsuSeikyuEntity>,
        ISaveable<AfT401ChokusetsuSeikyuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された直接請求番号に該当する、直接請求エンティティを取得します。
     *
     * @param seikyuNo 直接請求番号
     * @return 該当した直接請求エンティティ
     */
    @Transaction
    public AfT401ChokusetsuSeikyuEntity select(int seikyuNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT401ChokusetsuSeikyu.class).
                where(eq(AfT401ChokusetsuSeikyu.seikyuNo, seikyuNo)).
                toObject(AfT401ChokusetsuSeikyuEntity.class);
    }

    /**
     * すべての直接請求エンティティリストを取得します。
     *
     * @return 該当した直接請求エンティティリスト
     */
    @Transaction
    public List<AfT401ChokusetsuSeikyuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT401ChokusetsuSeikyu.class).
                order(by(AfT401ChokusetsuSeikyu.seikyuYMD), by(AfT401ChokusetsuSeikyu.seikyuNo)).
                toList(AfT401ChokusetsuSeikyuEntity.class);
    }

    /**
     * すべての直接請求エンティティリストを取得します。
     *
     * @return 該当した直接請求エンティティリスト
     */
    @Transaction
    public List<AfT401ChokusetsuSeikyuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT401ChokusetsuSeikyu.class).
                order(by(AfT401ChokusetsuSeikyu.seikyuNo, Order.DESC)).
                toList(AfT401ChokusetsuSeikyuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT401ChokusetsuSeikyuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT401ChokusetsuSeikyuEntity entity) {
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
    public int delete(List<AfT401ChokusetsuSeikyuEntity> entities) {
        int count = 0;
        for (AfT401ChokusetsuSeikyuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT401ChokusetsuSeikyuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT401ChokusetsuSeikyuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT401ChokusetsuSeikyuEntity entity) {
        return (select(entity.getSeikyuNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT401ChokusetsuSeikyuEntity entity) {
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
    public int deletePhysical(List<AfT401ChokusetsuSeikyuEntity> entities) {
        int count = 0;
        for (AfT401ChokusetsuSeikyuEntity entity : entities) {
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
    public int save(AfT401ChokusetsuSeikyuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("直接請求エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
