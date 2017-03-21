/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyosha;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertable;
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
 * 直接請求代表者テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT402SeikyuDaihyoshaDac
        implements IInsertable<AfT402SeikyuDaihyoshaEntity>,
        IDeletable<AfT402SeikyuDaihyoshaEntity>, IPhysicalDeletable<AfT402SeikyuDaihyoshaEntity>,
        ISaveable<AfT402SeikyuDaihyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された直接請求番号、請求代表者識別コードに該当する、直接請求代表者エンティティを取得します。
     *
     * @param seikyuNo 直接請求番号
     * @param seikyuShikibetsuCode 請求代表者識別コード
     * @return 該当した直接請求代表者エンティティ
     */
    @Transaction
    public AfT402SeikyuDaihyoshaEntity select(int seikyuNo, ShikibetsuCode seikyuShikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT402SeikyuDaihyosha.class).
                where(and(eq(AfT402SeikyuDaihyosha.seikyuNo, seikyuNo),
                                eq(AfT402SeikyuDaihyosha.seikyuShikibetsuCode, seikyuShikibetsuCode))).
                toObject(AfT402SeikyuDaihyoshaEntity.class);
    }

    /**
     * 指定された直接請求番号に該当する、直接請求代表者エンティティリストを取得します。
     *
     * @param seikyuNo 直接請求番号
     * @return 該当した直接請求代表者エンティティリスト
     */
    @Transaction
    public List<AfT402SeikyuDaihyoshaEntity> select(int seikyuNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT402SeikyuDaihyosha.class).
                where(eq(AfT402SeikyuDaihyosha.seikyuNo, seikyuNo)).
                order(by(AfT402SeikyuDaihyosha.seikyuShikibetsuCode)).
                toList(AfT402SeikyuDaihyoshaEntity.class);
    }

    /**
     * 直接請求代表者エンティティリストを取得します。
     *
     * @return 該当した直接請求代表者エンティティリスト
     */
    @Transaction
    public List<AfT402SeikyuDaihyoshaEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT402SeikyuDaihyosha.class).
                order(by(AfT402SeikyuDaihyosha.seikyuNo), by(AfT402SeikyuDaihyosha.seikyuShikibetsuCode)).
                toList(AfT402SeikyuDaihyoshaEntity.class);
    }

    @Override
    @Transaction
    public int insert(AfT402SeikyuDaihyoshaEntity entity) {
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
    public int insert(List<AfT402SeikyuDaihyoshaEntity> entities) {
        int count = 0;
        for (AfT402SeikyuDaihyoshaEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT402SeikyuDaihyoshaEntity entity) {
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
    public int delete(List<AfT402SeikyuDaihyoshaEntity> entities) {
        int count = 0;
        for (AfT402SeikyuDaihyoshaEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int deletePhysical(AfT402SeikyuDaihyoshaEntity entity) {
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
    public int deletePhysical(List<AfT402SeikyuDaihyoshaEntity> entities) {
        int count = 0;
        for (AfT402SeikyuDaihyoshaEntity entity : entities) {
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
    public int save(AfT402SeikyuDaihyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("直接請求代表者エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
