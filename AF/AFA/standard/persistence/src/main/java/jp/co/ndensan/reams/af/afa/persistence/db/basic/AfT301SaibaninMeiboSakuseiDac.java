/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakusei;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
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
 * 裁判員名簿作成情報テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT301SaibaninMeiboSakuseiDac
        implements IInsertOrUpdatable<AfT301SaibaninMeiboSakuseiEntity>,
        IDeletable<AfT301SaibaninMeiboSakuseiEntity>, IPhysicalDeletable<AfT301SaibaninMeiboSakuseiEntity>,
        ISaveable<AfT301SaibaninMeiboSakuseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された年度に該当する、裁判員名簿作成情報エンティティを取得します。
     *
     * @param nendo 年度
     * @return 該当した裁判員名簿作成情報エンティティ
     */
    @Transaction
    public AfT301SaibaninMeiboSakuseiEntity select(RYear nendo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT301SaibaninMeiboSakusei.class).
                where(eq(AfT301SaibaninMeiboSakusei.nendo, nendo)).
                toObject(AfT301SaibaninMeiboSakuseiEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、裁判員名簿作成情報エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した裁判員名簿作成情報エンティティリスト
     */
    @Transaction
    public List<AfT301SaibaninMeiboSakuseiEntity> select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT301SaibaninMeiboSakusei.class).
                where(eq(AfT301SaibaninMeiboSakusei.shohonNo, shohonNo)).
                order(by(AfT301SaibaninMeiboSakusei.nendo)).
                toList(AfT301SaibaninMeiboSakuseiEntity.class);
    }

    /**
     * 裁判員名簿作成情報エンティティリストを取得します。
     *
     * @return 該当した裁判員名簿作成情報エンティティリスト
     */
    @Transaction
    public List<AfT301SaibaninMeiboSakuseiEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT301SaibaninMeiboSakusei.class).
                order(by(AfT301SaibaninMeiboSakusei.shohonNo), by(AfT301SaibaninMeiboSakusei.nendo)).
                toList(AfT301SaibaninMeiboSakuseiEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT301SaibaninMeiboSakuseiEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT301SaibaninMeiboSakuseiEntity entity) {
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
    public int delete(List<AfT301SaibaninMeiboSakuseiEntity> entities) {
        int count = 0;
        for (AfT301SaibaninMeiboSakuseiEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT301SaibaninMeiboSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT301SaibaninMeiboSakuseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT301SaibaninMeiboSakuseiEntity entity) {
        return (select(entity.getNendo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT301SaibaninMeiboSakuseiEntity entity) {
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
    public int deletePhysical(List<AfT301SaibaninMeiboSakuseiEntity> entities) {
        int count = 0;
        for (AfT301SaibaninMeiboSakuseiEntity entity : entities) {
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
    public int save(AfT301SaibaninMeiboSakuseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(" 裁判員名簿作成情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
