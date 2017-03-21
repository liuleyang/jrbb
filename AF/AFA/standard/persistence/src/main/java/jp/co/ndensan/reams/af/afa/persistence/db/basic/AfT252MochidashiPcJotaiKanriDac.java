/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanri;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 持出端末状態管理テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class AfT252MochidashiPcJotaiKanriDac implements IInsertOrUpdatable<AfT252MochidashiPcJotaiKanriEntity>,
        IDeletable<AfT252MochidashiPcJotaiKanriEntity>, IPhysicalDeletable<AfT252MochidashiPcJotaiKanriEntity>,
        ISaveable<AfT252MochidashiPcJotaiKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された選挙種類、投票区コード、端末IDに該当する、持出端末状態管理エンティティを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 投票区コード RString
     * @return 該当した持出端末状態管理エンティティ
     */
    @Transaction
    public AfT252MochidashiPcJotaiKanriEntity select(ShohonNo 抄本番号, RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT252MochidashiPcJotaiKanri.class).
                where(and(
                                eq(AfT252MochidashiPcJotaiKanri.shohonNo, 抄本番号),
                                eq(AfT252MochidashiPcJotaiKanri.tohyokuCode, 投票区コード)
                        )).
                toObject(AfT252MochidashiPcJotaiKanriEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、持出端末状態管理エンティティを取得します。
     *
     * @param shohonNo ShohonNo
     * @return 該当した持出端末状態管理エンティティ
     */
    @Transaction
    public List<AfT252MochidashiPcJotaiKanriEntity> selectBy抄本番号List(List<ShohonNo> shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT252MochidashiPcJotaiKanri.class).
                where(in(AfT252MochidashiPcJotaiKanri.shohonNo, shohonNo)).
                order(by(AfT252MochidashiPcJotaiKanri.tohyokuCode), by(AfT252MochidashiPcJotaiKanri.shohonNo)).
                toList(AfT252MochidashiPcJotaiKanriEntity.class);
    }

    /**
     * すべての持出端末状態管理エンティティリストを取得します。
     *
     * @return 該当した持出端末状態管理エンティティリスト
     */
    @Transaction
    public List<AfT252MochidashiPcJotaiKanriEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT252MochidashiPcJotaiKanri.class).
                toList(AfT252MochidashiPcJotaiKanriEntity.class);
    }

    @Override
    @Transaction
    public int delete(AfT252MochidashiPcJotaiKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT252MochidashiPcJotaiKanriEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int delete(List<AfT252MochidashiPcJotaiKanriEntity> entities) {
        int count = 0;
        for (AfT252MochidashiPcJotaiKanriEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT252MochidashiPcJotaiKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT252MochidashiPcJotaiKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT252MochidashiPcJotaiKanriEntity entity) {
        return (select(entity.getShohonNo(), entity.getTohyokuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT252MochidashiPcJotaiKanriEntity entity) {
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
    public int deletePhysical(List<AfT252MochidashiPcJotaiKanriEntity> entities) {
        int count = 0;
        for (AfT252MochidashiPcJotaiKanriEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT252MochidashiPcJotaiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT252MochidashiPcJotaiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("持出端末状態管理エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
