/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 農業・海区名簿更新日テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT131KaikuSenkyoDac
        implements IInsertOrUpdatable<AfT131KaikuSenkyoEntity>, IDeletable<AfT131KaikuSenkyoEntity>,
        IPhysicalDeletable<AfT131KaikuSenkyoEntity>, ISaveable<AfT131KaikuSenkyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号に該当する、農業・海区名簿更新日エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した農業・海区名簿更新日エンティティ
     */
    @Transaction
    public AfT131KaikuSenkyoEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT131KaikuSenkyo.class).
                where(eq(AfT131KaikuSenkyo.shohonNo, shohonNo)).
                toObject(AfT131KaikuSenkyoEntity.class);
    }

    /**
     * 指定された年度に該当する、農業・海区名簿更新日エンティティリストを取得します。
     *
     * @param nendo 年度
     * @return 該当した農業・海区名簿更新日エンティティリスト
     */
    @Transaction
    public List<AfT131KaikuSenkyoEntity> select(RYear nendo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT131KaikuSenkyo.class).
                where(eq(AfT131KaikuSenkyo.nendo, nendo)).
                toList(AfT131KaikuSenkyoEntity.class);
    }

    /**
     * 農業・海区名簿更新日エンティティを取得します。
     *
     * @return 該当した農業・海区名簿更新日エンティティ
     */
    @Transaction
    public List<AfT131KaikuSenkyoEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT131KaikuSenkyo.class).
                order(by(AfT131KaikuSenkyo.shohonNo)).
                toList(AfT131KaikuSenkyoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT131KaikuSenkyoEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT131KaikuSenkyoEntity entity) {
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
    public int delete(List<AfT131KaikuSenkyoEntity> entities) {
        int count = 0;
        for (AfT131KaikuSenkyoEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT131KaikuSenkyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT131KaikuSenkyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT131KaikuSenkyoEntity entity) {
        return (select(entity.getShohonNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT131KaikuSenkyoEntity entity) {
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
    public int deletePhysical(List<AfT131KaikuSenkyoEntity> entities) {
        int count = 0;
        for (AfT131KaikuSenkyoEntity entity : entities) {
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
    public int save(AfT131KaikuSenkyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("農業・海区名簿更新日エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
