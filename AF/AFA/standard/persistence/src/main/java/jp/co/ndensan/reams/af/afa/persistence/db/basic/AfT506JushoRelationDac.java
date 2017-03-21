/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT506JushoRelation;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT506JushoRelationEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所番地対応のデータアクセスクラスです。
 *
 * @author n1823 有澤 礼恵
 */
public class AfT506JushoRelationDac implements IInsertOrUpdatable<AfT506JushoRelationEntity>,
        IDeletable<AfT506JushoRelationEntity>, IPhysicalDeletable<AfT506JushoRelationEntity>,
        ISaveable<AfT506JushoRelationEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された主キーで住所番地対応を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param choikiCode 町域コード
     * @param banchiCode1 番地コード１
     * @param banchiCode2 番地コード２
     * @param banchiCode3 番地コード３
     * @param banchiCode4 番地コード４
     * @return AfT506JushoRelationEntity 該当した住所番地対応エンティティ
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT506JushoRelationEntity select(Code senkyoShurui, ChoikiCode choikiCode,
            BanchiCode banchiCode1, BanchiCode banchiCode2, BanchiCode banchiCode3, BanchiCode banchiCode4) throws NullPointerException {
        requireNonNull(senkyoShurui, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(choikiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("町域コード"));
        requireNonNull(banchiCode1, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード１"));
        requireNonNull(banchiCode2, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード２"));
        requireNonNull(banchiCode3, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード３"));
        requireNonNull(banchiCode4, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード４"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT506JushoRelation.class).
                where(and(
                                eq(AfT506JushoRelation.senkyoShurui, senkyoShurui),
                                eq(AfT506JushoRelation.choikiCode, choikiCode),
                                eq(AfT506JushoRelation.kaishiBanchi1BanchiCode, banchiCode1),
                                eq(AfT506JushoRelation.kaishiBanchi2BanchiCode, banchiCode2),
                                eq(AfT506JushoRelation.kaishiBanchi3BanchiCode, banchiCode3),
                                eq(AfT506JushoRelation.kaishiBanchi4BanchiCode, banchiCode4))).
                toObject(AfT506JushoRelationEntity.class);
    }

    /**
     * 指定された選挙種類で住所番地対応を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return List<AfT506JushoRelationEntity> 該当した住所番地対応エンティティリスト
     */
    @Transaction
    public List<AfT506JushoRelationEntity> select(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT506JushoRelation.class).
                where(eq(AfT506JushoRelation.senkyoShurui, senkyoShurui)).
                order(by(AfT506JushoRelation.choikiCode),
                        by(AfT506JushoRelation.kaishiBanchi1BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi2BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi3BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi4BanchiCode)).
                toList(AfT506JushoRelationEntity.class);
    }

    /**
     * 住所番地対応を取得します。
     *
     * @return List<AfT506JushoRelationEntity> 該当した住所番地対応エンティティリスト
     */
    @Transaction
    public List<AfT506JushoRelationEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT506JushoRelation.class).
                order(by(AfT506JushoRelation.senkyoShurui),
                        by(AfT506JushoRelation.choikiCode),
                        by(AfT506JushoRelation.kaishiBanchi1BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi2BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi3BanchiCode),
                        by(AfT506JushoRelation.kaishiBanchi4BanchiCode)).
                toList(AfT506JushoRelationEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT506JushoRelationEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT506JushoRelationEntity> entities) {
        int count = 0;
        for (AfT506JushoRelationEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Transaction
    @Override
    public int delete(AfT506JushoRelationEntity entity) {
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
    public int delete(List<AfT506JushoRelationEntity> entities) {
        int count = 0;
        for (AfT506JushoRelationEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT506JushoRelationEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT506JushoRelationEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT506JushoRelationEntity entity) {
        return (select(entity.getSenkyoShurui(),
                entity.getChoikiCode(),
                entity.getKaishiBanchi1BanchiCode(),
                entity.getKaishiBanchi2BanchiCode(),
                entity.getKaishiBanchi3BanchiCode(),
                entity.getKaishiBanchi4BanchiCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT506JushoRelationEntity entity) {
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
    public int deletePhysical(List<AfT506JushoRelationEntity> entities) {
        int count = 0;
        for (AfT506JushoRelationEntity entity : entities) {
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
    public int save(AfT506JushoRelationEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住所番地エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
