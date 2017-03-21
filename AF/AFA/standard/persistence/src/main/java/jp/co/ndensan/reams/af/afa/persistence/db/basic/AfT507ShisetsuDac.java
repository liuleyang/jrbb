/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507Shisetsu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 施設テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT507ShisetsuDac implements IInsertOrUpdatable<AfT507ShisetsuEntity>,
        IDeletable<AfT507ShisetsuEntity>, IPhysicalDeletable<AfT507ShisetsuEntity>,
        ISaveable<AfT507ShisetsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された施設コードに該当する、施設エンティティを取得します。
     *
     * @param shisetsuCode 施設コード
     * @return 該当した施設エンティティ
     */
    @Transaction
    public AfT507ShisetsuEntity select(RString shisetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT507Shisetsu.class).
                where(eq(AfT507Shisetsu.shisetsuCode, shisetsuCode)).
                toObject(AfT507ShisetsuEntity.class);
    }

    /**
     * すべての施設エンティティリストを取得します。
     *
     * @return 該当した施設エンティティリスト
     */
    @Transaction
    public List<AfT507ShisetsuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT507Shisetsu.class).
                order(by(AfT507Shisetsu.shisetsuCode)).
                toList(AfT507ShisetsuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT507ShisetsuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT507ShisetsuEntity> entities) {
        int count = 0;
        for (AfT507ShisetsuEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT507ShisetsuEntity entity) {
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
    public int delete(List<AfT507ShisetsuEntity> entities) {
        int count = 0;
        for (AfT507ShisetsuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT507ShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT507ShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT507ShisetsuEntity entity) {
        return (select(entity.getShisetsuCode()) != null);
    }

    /**
     * 引数の施設コードがマスタに存在するか判定します。
     *
     * @param shisetsuCode 施設コード
     * @return 存在する場合はtrueを返します。
     */
    @Transaction
    public boolean exists(RString shisetsuCode) {
        return getMatchRowCount(shisetsuCode) != 0;
    }

    private int getMatchRowCount(RString shisetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT507Shisetsu.class).
                where(eq(AfT507Shisetsu.shisetsuCode, shisetsuCode)).
                getCount();
    }

    @Override
    @Transaction
    public int deletePhysical(AfT507ShisetsuEntity entity) {
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
    public int deletePhysical(List<AfT507ShisetsuEntity> entities) {
        int count = 0;
        for (AfT507ShisetsuEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT507ShisetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT507ShisetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("施設エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定された施設種別コードリストに該当する、抄本エンティティを取得します。<br />
     *
     * @param 施設種別コードリスト 施設種別コードリスト
     * @return 該当した施設エンティティリスト
     */
    @Transaction
    public List<AfT507ShisetsuEntity> selectBy施設種別コードリスト(RString... 施設種別コードリスト) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT507Shisetsu.class).
                where(in(AfT507Shisetsu.shisetsuShubetsu, 施設種別コードリスト)).
                order(by(AfT507Shisetsu.shisetsuShubetsu), by(AfT507Shisetsu.shisetsuCode)).
                toList(AfT507ShisetsuEntity.class);
    }

}
