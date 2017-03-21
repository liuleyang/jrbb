/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509Kumiai;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
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
 * 組合テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT509KumiaiDac implements IInsertOrUpdatable<AfT509KumiaiEntity>,
        IDeletable<AfT509KumiaiEntity>, IPhysicalDeletable<AfT509KumiaiEntity>,
        ISaveable<AfT509KumiaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された組合コードに該当する、組合エンティティを取得します。
     *
     * @param kumiaiCode 組合コード
     * @return 該当した組合エンティティ
     */
    @Transaction
    public AfT509KumiaiEntity select(RString kumiaiCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT509Kumiai.class).
                where(eq(AfT509Kumiai.kumiaiCode, kumiaiCode)).
                toObject(AfT509KumiaiEntity.class);
    }

    /**
     * 組合エンティティリストを取得します。
     *
     * @return 該当した組合エンティティリスト
     */
    @Transaction
    public List<AfT509KumiaiEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT509Kumiai.class).
                order(by(AfT509Kumiai.kumiaiCode)).
                toList(AfT509KumiaiEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT509KumiaiEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT509KumiaiEntity> entities) {
        int count = 0;
        for (AfT509KumiaiEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT509KumiaiEntity entity) {
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
    public int delete(List<AfT509KumiaiEntity> entities) {
        int count = 0;
        for (AfT509KumiaiEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT509KumiaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT509KumiaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT509KumiaiEntity entity) {
        return (select(entity.getKumiaiCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT509KumiaiEntity entity) {
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
    public int deletePhysical(List<AfT509KumiaiEntity> entities) {
        int count = 0;
        for (AfT509KumiaiEntity entity : entities) {
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
    public int save(AfT509KumiaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("組合エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
