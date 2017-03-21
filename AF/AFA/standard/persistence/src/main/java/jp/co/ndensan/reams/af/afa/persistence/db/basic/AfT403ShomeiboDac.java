/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403Shomeibo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
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
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 署名者名簿テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT403ShomeiboDac implements IInsertOrUpdatable<AfT403ShomeiboEntity>,
        IDeletable<AfT403ShomeiboEntity>, IPhysicalDeletable<AfT403ShomeiboEntity>,
        ISaveable<AfT403ShomeiboEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された直接請求番号、冊、頁、行に該当する、署名者名簿エンティティを取得します。
     *
     * @param seikyuNo 直接請求番号
     * @param satsu 冊
     * @param page 頁
     * @param gyo 行
     * @return 該当した署名者名簿エンティティ
     */
    @Transaction
    public AfT403ShomeiboEntity select(int seikyuNo, RString satsu, int page, int gyo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT403Shomeibo.class).
                where(and(eq(AfT403Shomeibo.seikyuNo, seikyuNo),
                                eq(AfT403Shomeibo.satsu, satsu),
                                eq(AfT403Shomeibo.page, page),
                                eq(AfT403Shomeibo.gyo, gyo))).
                toObject(AfT403ShomeiboEntity.class);
    }

    /**
     * 指定された直接請求番号に該当する、署名者名簿エンティティリストを取得します。
     *
     * @param seikyuNo 請求番号
     * @return 該当した署名者名簿エンティティリスト
     */
    @Transaction
    public List<AfT403ShomeiboEntity> select(int seikyuNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT403Shomeibo.class).
                where(eq(AfT403Shomeibo.seikyuNo, seikyuNo)).
                order(by(AfT403Shomeibo.satsu), by(AfT403Shomeibo.page), by(AfT403Shomeibo.gyo)).
                toList(AfT403ShomeiboEntity.class);
    }

    /**
     * 署名者名簿エンティティリストを取得します。
     *
     * @return 該当した署名者名簿エンティティリスト
     */
    @Transaction
    public List<AfT403ShomeiboEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT403Shomeibo.class).
                order(by(AfT403Shomeibo.seikyuNo), by(AfT403Shomeibo.satsu), by(AfT403Shomeibo.page), by(AfT403Shomeibo.gyo)).
                toList(AfT403ShomeiboEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT403ShomeiboEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 登録件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT403ShomeiboEntity> entities) {
        int count = 0;
        for (AfT403ShomeiboEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT403ShomeiboEntity entity) {
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
    public int delete(List<AfT403ShomeiboEntity> entities) {
        int count = 0;
        for (AfT403ShomeiboEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT403ShomeiboEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT403ShomeiboEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT403ShomeiboEntity entity) {
        return (select(entity.getSeikyuNo(), entity.getSatsu(), entity.getPage(), entity.getGyo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT403ShomeiboEntity entity) {
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
    public int deletePhysical(List<AfT403ShomeiboEntity> entities) {
        int count = 0;
        for (AfT403ShomeiboEntity entity : entities) {
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
    public int save(AfT403ShomeiboEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("署名者名簿エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
