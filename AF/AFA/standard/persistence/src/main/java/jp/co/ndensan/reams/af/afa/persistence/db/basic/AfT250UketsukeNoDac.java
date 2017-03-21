/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNoEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 受付番号採番管理テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT250UketsukeNoDac implements IInsertOrUpdatable<AfT250UketsukeNoEntity>,
        IDeletable<AfT250UketsukeNoEntity>, IPhysicalDeletable<AfT250UketsukeNoEntity>,
        ISaveable<AfT250UketsukeNoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定されたキーに該当する、受付番号採番管理エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param shisetsuShubetsu 施設種別
     * @param code 施設コード or 投票区コード
     * @param kijitsuFuzaiKubun 期日前不在者区分
     * @return 該当した受付番号採番管理エンティティ
     */
    @Transaction
    public AfT250UketsukeNoEntity select(ShohonNo shohonNo, Code shisetsuShubetsu,
            RString code, Code kijitsuFuzaiKubun) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT250UketsukeNo.class).
                where(and(eq(AfT250UketsukeNo.shohonNo, shohonNo),
                                eq(AfT250UketsukeNo.shisetsuShubetsu, shisetsuShubetsu),
                                eq(AfT250UketsukeNo.code, code),
                                eq(AfT250UketsukeNo.kijitsuFuzaiKubun, kijitsuFuzaiKubun))).
                toObject(AfT250UketsukeNoEntity.class);
    }

    /**
     * 指定された条件に該当する、受付番号採番管理エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した受付番号採番管理エンティティリスト
     */
    @Transaction
    public List<AfT250UketsukeNoEntity> select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT250UketsukeNo.class).
                where(eq(AfT250UketsukeNo.shohonNo, shohonNo)).
                toList(AfT250UketsukeNoEntity.class);
    }

    /**
     * 受付番号採番管理エンティティリストを取得します。
     *
     * @return 該当した受付番号採番管理エンティティリスト
     */
    @Transaction
    public List<AfT250UketsukeNoEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT250UketsukeNo.class).
                order(by(AfT250UketsukeNo.shohonNo), by(AfT250UketsukeNo.shisetsuShubetsu)).
                toList(AfT250UketsukeNoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT250UketsukeNoEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT250UketsukeNoEntity entity) {
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
    public int delete(List<AfT250UketsukeNoEntity> entities) {
        int count = 0;
        for (AfT250UketsukeNoEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT250UketsukeNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT250UketsukeNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT250UketsukeNoEntity entity) {
        return (select(entity.getShohonNo(), entity.getShisetsuShubetsu(),
                entity.getCode(), entity.getKijitsuFuzaiKubun()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT250UketsukeNoEntity entity) {
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
    public int deletePhysical(List<AfT250UketsukeNoEntity> entities) {
        int count = 0;
        for (AfT250UketsukeNoEntity entity : entities) {
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
    public int save(AfT250UketsukeNoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受付番号採番管理エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
