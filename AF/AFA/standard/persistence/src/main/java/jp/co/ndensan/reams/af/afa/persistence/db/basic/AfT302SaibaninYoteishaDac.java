/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteisha;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteishaEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 裁判員候補者予定者名簿テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT302SaibaninYoteishaDac
        implements IInsertable<AfT302SaibaninYoteishaEntity>,
        IDeletable<AfT302SaibaninYoteishaEntity>, IPhysicalDeletable<AfT302SaibaninYoteishaEntity>,
        ISaveable<AfT302SaibaninYoteishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された年度、選管通番、識別コードに該当する、裁判員候補者予定者名簿エンティティを取得します。
     *
     * @param nendo 年度
     * @param senkanRenaban 選管通番
     * @param shikibetsuCode 識別コード
     * @return 該当した裁判員候補者予定者名簿エンティティ
     */
    @Transaction
    public AfT302SaibaninYoteishaEntity select(RYear nendo, int senkanRenaban, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT302SaibaninYoteisha.class).
                where(and(eq(AfT302SaibaninYoteisha.nendo, nendo),
                                eq(AfT302SaibaninYoteisha.senkanRenban, senkanRenaban),
                                eq(AfT302SaibaninYoteisha.shikibetsuCode, shikibetsuCode))).
                toObject(AfT302SaibaninYoteishaEntity.class);
    }

    /**
     * 指定された年度に該当する、裁判員候補者予定者名簿エンティティリストを取得します。
     *
     * @param nendo 年度
     * @return 該当した裁判員候補者予定者名簿エンティティリスト
     */
    @Transaction
    public List<AfT302SaibaninYoteishaEntity> select(RYear nendo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT302SaibaninYoteisha.class).
                where(eq(AfT302SaibaninYoteisha.nendo, nendo)).
                order(by(AfT302SaibaninYoteisha.senkanRenban), by(AfT302SaibaninYoteisha.shikibetsuCode)).
                toList(AfT302SaibaninYoteishaEntity.class);
    }

    /**
     * 裁判員候補者予定者名簿エンティティリストを取得します。
     *
     * @return 該当した裁判員候補者予定者名簿エンティティリスト
     */
    @Transaction
    public List<AfT302SaibaninYoteishaEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT302SaibaninYoteisha.class).
                order(by(AfT302SaibaninYoteisha.nendo), by(AfT302SaibaninYoteisha.senkanRenban), by(AfT302SaibaninYoteisha.shikibetsuCode)).
                toList(AfT302SaibaninYoteishaEntity.class);
    }

    @Override
    @Transaction
    public int insert(AfT302SaibaninYoteishaEntity entity) {
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
    public int insert(List<AfT302SaibaninYoteishaEntity> entities) {
        int count = 0;
        for (AfT302SaibaninYoteishaEntity entity : entities) {
            count += insert(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT302SaibaninYoteishaEntity entity) {
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
    public int delete(List<AfT302SaibaninYoteishaEntity> entities) {
        int count = 0;
        for (AfT302SaibaninYoteishaEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int deletePhysical(AfT302SaibaninYoteishaEntity entity) {
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
    public int deletePhysical(List<AfT302SaibaninYoteishaEntity> entities) {
        int count = 0;
        for (AfT302SaibaninYoteishaEntity entity : entities) {
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
    public int save(AfT302SaibaninYoteishaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("裁判員候補者予定者名簿エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
