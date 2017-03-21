/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT253TojitsuOnlinePcKanri;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT253TojitsuOnlinePcKanriEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 当日投票端末管理テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class AfT253TojitsuOnlinePcKanriDac implements IInsertOrUpdatable<AfT253TojitsuOnlinePcKanriEntity>,
        IDeletable<AfT253TojitsuOnlinePcKanriEntity>, IPhysicalDeletable<AfT253TojitsuOnlinePcKanriEntity>,
        ISaveable<AfT253TojitsuOnlinePcKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された選挙種類、投票区コード、端末IDに該当する、当日投票端末管理エンティティを取得します。
     *
     * @param 選挙種類 Code
     * @param 投票区コード RString
     * @param 端末ID RString
     * @return 該当した当日投票端末管理エンティティ
     */
    @Transaction
    public AfT253TojitsuOnlinePcKanriEntity select(Code 選挙種類, RString 投票区コード, RString 端末ID) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(端末ID, UrSystemErrorMessages.値がnull.getReplacedMessage("端末ID"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT253TojitsuOnlinePcKanri.class).
                where(and(
                                eq(AfT253TojitsuOnlinePcKanri.senkyoShurui, 選挙種類),
                                eq(AfT253TojitsuOnlinePcKanri.tohyokuCode, 投票区コード),
                                eq(AfT253TojitsuOnlinePcKanri.tanmatsuId, 端末ID))
                ).
                toObject(AfT253TojitsuOnlinePcKanriEntity.class);
    }

    /**
     * 指定された選挙種類、投票区コード、端末IDに該当する、当日投票端末管理エンティティを取得します。
     *
     * @param 選挙種類 Code
     * @param 端末ID RString
     * @return 該当した当日投票端末管理エンティティ
     */
    @Transaction
    public List<AfT253TojitsuOnlinePcKanriEntity> selectTohyokuCode(Code 選挙種類, RString 端末ID) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(端末ID, UrSystemErrorMessages.値がnull.getReplacedMessage("端末ID"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT253TojitsuOnlinePcKanri.class).
                where(and(
                                eq(AfT253TojitsuOnlinePcKanri.senkyoShurui, 選挙種類),
                                eq(AfT253TojitsuOnlinePcKanri.tanmatsuId, 端末ID))
                ).
                toList(AfT253TojitsuOnlinePcKanriEntity.class);
    }

    /**
     * すべての当日投票端末管理エンティティリストを取得します。
     *
     * @return 該当した当日投票端末管理エンティティリスト
     */
    @Transaction
    public List<AfT253TojitsuOnlinePcKanriEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT253TojitsuOnlinePcKanri.class).
                toList(AfT253TojitsuOnlinePcKanriEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT253TojitsuOnlinePcKanriEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT253TojitsuOnlinePcKanriEntity> entities) {
        int count = 0;
        for (AfT253TojitsuOnlinePcKanriEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT253TojitsuOnlinePcKanriEntity entity) {
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
    public int delete(List<AfT253TojitsuOnlinePcKanriEntity> entities) {
        int count = 0;
        for (AfT253TojitsuOnlinePcKanriEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT253TojitsuOnlinePcKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT253TojitsuOnlinePcKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT253TojitsuOnlinePcKanriEntity entity) {
        return (select(entity.getSenkyoShurui(), entity.getTohyokuCode(), entity.getTanmatsuId()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT253TojitsuOnlinePcKanriEntity entity) {
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
    public int deletePhysical(List<AfT253TojitsuOnlinePcKanriEntity> entities) {
        int count = 0;
        for (AfT253TojitsuOnlinePcKanriEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT253TojitsuOnlinePcKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT253TojitsuOnlinePcKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("当日投票端末管理エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
