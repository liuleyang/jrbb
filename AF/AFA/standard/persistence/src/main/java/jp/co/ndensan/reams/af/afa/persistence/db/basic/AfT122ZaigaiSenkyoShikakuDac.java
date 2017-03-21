/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikaku;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikaku.shinseiNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 記載事項変更通知
 *
 * @reamsid_L AF-0320-010 lis
 */
public class AfT122ZaigaiSenkyoShikakuDac
        implements IInsertOrUpdatable<AfT122ZaigaiSenkyoShikakuEntity>, IDeletable<AfT122ZaigaiSenkyoShikakuEntity>,
        IPhysicalDeletable<AfT122ZaigaiSenkyoShikakuEntity>, ISaveable<AfT122ZaigaiSenkyoShikakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された識別コード、申請番号に該当する、在外選挙人国内住所情報エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param shinseiNo 申請番号
     * @return 該当した在外選挙資格エンティティ
     */
    @Transaction
    public AfT122ZaigaiSenkyoShikakuEntity select(ShikibetsuCode shikibetsuCode, int shinseiNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT122ZaigaiSenkyoShikaku.class).
                where(and(eq(AfT122ZaigaiSenkyoShikaku.shikibetsuCode, shikibetsuCode),
                                eq(AfT122ZaigaiSenkyoShikaku.shinseiNo, shinseiNo))).
                toObject(AfT122ZaigaiSenkyoShikakuEntity.class);
    }

    /**
     * 指定された識別コードに該当する、在外選挙資格エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 該当した在外選挙資格エンティティリスト
     */
    @Transaction
    public List<AfT122ZaigaiSenkyoShikakuEntity> select(ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT122ZaigaiSenkyoShikaku.class).
                where(eq(AfT122ZaigaiSenkyoShikaku.shikibetsuCode, shikibetsuCode)).
                order(by(AfT122ZaigaiSenkyoShikaku.shinseiNo)).
                toList(AfT122ZaigaiSenkyoShikakuEntity.class);
    }

    /**
     * 在外選挙資格エンティティを取得します。
     *
     * @return 該当した在外選挙資格エンティティリスト
     */
    @Transaction
    public List<AfT122ZaigaiSenkyoShikakuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT122ZaigaiSenkyoShikaku.class).
                order(by(AfT122ZaigaiSenkyoShikaku.shikibetsuCode), by(AfT122ZaigaiSenkyoShikaku.shinseiNo)).
                toList(AfT122ZaigaiSenkyoShikakuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT122ZaigaiSenkyoShikakuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT122ZaigaiSenkyoShikakuEntity> entities) {
        int count = 0;
        for (AfT122ZaigaiSenkyoShikakuEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT122ZaigaiSenkyoShikakuEntity entity) {
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
    public int delete(List<AfT122ZaigaiSenkyoShikakuEntity> entities) {
        int count = 0;
        for (AfT122ZaigaiSenkyoShikakuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT122ZaigaiSenkyoShikakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT122ZaigaiSenkyoShikakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT122ZaigaiSenkyoShikakuEntity entity) {
        return (select(entity.getShikibetsuCode(), entity.getShinseiNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT122ZaigaiSenkyoShikakuEntity entity) {
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
    public int deletePhysical(List<AfT122ZaigaiSenkyoShikakuEntity> entities) {
        int count = 0;
        for (AfT122ZaigaiSenkyoShikakuEntity entity : entities) {
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
    public int save(AfT122ZaigaiSenkyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙資格エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定された識別コードに該当する、在外選挙資格エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 最大申請番号を取得する
     */
    @Transaction
    public AfT122ZaigaiSenkyoShikakuEntity selectMaxShinseiNo(ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(shinseiNo)).
                table(AfT122ZaigaiSenkyoShikaku.class).
                where(eq(AfT122ZaigaiSenkyoShikaku.shikibetsuCode, shikibetsuCode)).
                toObject(AfT122ZaigaiSenkyoShikakuEntity.class);

    }

    /**
     * 指定された識別コードに該当する、在外選挙資格エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param maxNumber 識別コード最大
     * @return 次申請番号を取得する
     */
    @Transaction
    public AfT122ZaigaiSenkyoShikakuEntity selectMaxShinseiNo(ShikibetsuCode shikibetsuCode, int maxNumber) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(shinseiNo)).
                table(AfT122ZaigaiSenkyoShikaku.class).
                where(and(eq(AfT122ZaigaiSenkyoShikaku.shikibetsuCode, shikibetsuCode),
                                lt(AfT122ZaigaiSenkyoShikaku.shinseiNo, maxNumber))).
                toObject(AfT122ZaigaiSenkyoShikakuEntity.class);

    }

    /**
     * 在外選挙資格情報エンティティを登録します。
     *
     *
     * @param entity 対象のエンティティ
     * @return int
     */
    @Transaction
    public int insertZaigaiSenkyoShikaku(AfT122ZaigaiSenkyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙資格エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 在外選挙資格情報エンティティを更新します。
     *
     *
     * @param entity 対象のエンティティ
     * @return int
     */
    @Transaction
    public int updateZaigaiSenkyoShikaku(AfT122ZaigaiSenkyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙資格エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 指定された識別コード、交付年月日に該当する、在外選挙人国内住所情報エンティティを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param kofuYMD FlexibleDate
     * @return 該当した在外選挙資格エンティティリスト
     */
    @Transaction
    public List<AfT122ZaigaiSenkyoShikakuEntity> select(ShikibetsuCode shikibetsuCode, FlexibleDate kofuYMD) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT122ZaigaiSenkyoShikaku.class).
                where(and(eq(AfT122ZaigaiSenkyoShikaku.shikibetsuCode, shikibetsuCode),
                                leq(kofuYMD, AfT122ZaigaiSenkyoShikaku.kofuYMD))).
                toList(AfT122ZaigaiSenkyoShikakuEntity.class);
    }
}
