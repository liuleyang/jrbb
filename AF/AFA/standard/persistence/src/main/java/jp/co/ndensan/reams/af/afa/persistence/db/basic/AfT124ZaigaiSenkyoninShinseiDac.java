/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinsei;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
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
 * 在外選挙人申請情報テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0320-010 lis
 */
public class AfT124ZaigaiSenkyoninShinseiDac
        implements IInsertOrUpdatable<AfT124ZaigaiSenkyoninShinseiEntity>,
        IDeletable<AfT124ZaigaiSenkyoninShinseiEntity>, IPhysicalDeletable<AfT124ZaigaiSenkyoninShinseiEntity>,
        ISaveable<AfT124ZaigaiSenkyoninShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された申請番号に該当する、在外選挙人申請情報エンティティを取得します。
     *
     * @param shinseiNo 申請番号
     * @return 該当した在外選挙人申請情報エンティティ
     */
    @Transaction
    public AfT124ZaigaiSenkyoninShinseiEntity select(int shinseiNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT124ZaigaiSenkyoninShinsei.class).
                where(eq(AfT124ZaigaiSenkyoninShinsei.shinseiNo, shinseiNo)).
                toObject(AfT124ZaigaiSenkyoninShinseiEntity.class);
    }

    /**
     * 指定された識別コードに該当する、在外選挙人申請情報エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 該当した在外選挙人申請情報エンティティリスト
     */
    @Transaction
    public List<AfT124ZaigaiSenkyoninShinseiEntity> select(ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT124ZaigaiSenkyoninShinsei.class).
                where(eq(AfT124ZaigaiSenkyoninShinsei.shikibetsuCode, shikibetsuCode)).
                order(by(AfT124ZaigaiSenkyoninShinsei.shinseiNo)).
                toList(AfT124ZaigaiSenkyoninShinseiEntity.class);
    }

    /**
     * 在外選挙人申請情報エンティティを取得します。
     *
     * @return 該当した在外選挙人申請情報エンティティリスト
     */
    @Transaction
    public List<AfT124ZaigaiSenkyoninShinseiEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT124ZaigaiSenkyoninShinsei.class).
                order(by(AfT124ZaigaiSenkyoninShinsei.shikibetsuCode), by(AfT124ZaigaiSenkyoninShinsei.shinseiNo)).
                toList(AfT124ZaigaiSenkyoninShinseiEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT124ZaigaiSenkyoninShinseiEntity> entities) {
        int count = 0;
        for (AfT124ZaigaiSenkyoninShinseiEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT124ZaigaiSenkyoninShinseiEntity entity) {
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
    public int delete(List<AfT124ZaigaiSenkyoninShinseiEntity> entities) {
        int count = 0;
        for (AfT124ZaigaiSenkyoninShinseiEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        return (select(entity.getShinseiNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT124ZaigaiSenkyoninShinseiEntity entity) {
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
    public int deletePhysical(List<AfT124ZaigaiSenkyoninShinseiEntity> entities) {
        int count = 0;
        for (AfT124ZaigaiSenkyoninShinseiEntity entity : entities) {
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
    public int save(AfT124ZaigaiSenkyoninShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙人申請情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定された申請番号に該当する、在外選挙人申請情報エンティティを取得します。
     *
     * @param shinseiNo 申請番号
     * @param shikibetsuCode 識別コード
     * @return 該当した在外選挙人申請情報エンティティ
     */
    @Transaction
    public AfT124ZaigaiSenkyoninShinseiEntity selectByShinseiNoShikibetsuCode(int shinseiNo, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT124ZaigaiSenkyoninShinsei.class).
                where(and(eq(AfT124ZaigaiSenkyoninShinsei.shinseiNo, shinseiNo),
                                eq(AfT124ZaigaiSenkyoninShinsei.shikibetsuCode, shikibetsuCode))).
                toObject(AfT124ZaigaiSenkyoninShinseiEntity.class);
    }
}
