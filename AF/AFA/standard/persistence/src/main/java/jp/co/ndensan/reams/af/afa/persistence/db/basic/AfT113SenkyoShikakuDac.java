/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.IInsertableForAddType;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAppendType;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙資格のデータアクセスクラスの実装クラスです。
 *
 * @author n1823 有澤礼恵
 */
public class AfT113SenkyoShikakuDac implements IInsertableForAddType<AfT113SenkyoShikakuEntity>,
        IPhysicalDeletable<AfT113SenkyoShikakuEntity>, ISaveable<AfT113SenkyoShikakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで選挙資格を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param shikibetsuCode 識別コード
     * @return AfT113SenkyoShikakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT113SenkyoShikakuEntity select(
            Code senkyoShurui,
            ShikibetsuCode shikibetsuCode) throws NullPointerException {
        requireNonNull(senkyoShurui, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT113SenkyoShikaku.class).
                where(and(
                                eq(AfT113SenkyoShikaku.senkyoShurui, senkyoShurui),
                                eq(AfT113SenkyoShikaku.shikibetsuCode, shikibetsuCode))).
                toObject(AfT113SenkyoShikakuEntity.class);
    }

    /**
     * 指定した選挙種類、識別コードの選挙人名簿を取得します。
     *
     * @param 選挙種類 選挙種類
     * @param 識別コード 識別コード
     * @return List<AfT113SenkyoShikakuEntity>
     */
    @Transaction
    public List<AfT113SenkyoShikakuEntity> selectWithOrder(Code 選挙種類, ShikibetsuCode 識別コード) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT113SenkyoShikaku.class).
                where(and(
                                eq(AfT113SenkyoShikaku.senkyoShurui, 選挙種類),
                                eq(AfT113SenkyoShikaku.shikibetsuCode, 識別コード))).
                order(new OrderBy(AfT113SenkyoShikaku.seq, Order.DESC, NullsOrder.FIRST)).
                toList(AfT113SenkyoShikakuEntity.class);
    }

    /**
     * 選挙種類で選挙資格を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return List<AfT113SenkyoShikakuEntity>
     */
    @Transaction
    public List<AfT113SenkyoShikakuEntity> select(Code senkyoShurui) {
        requireNonNull(senkyoShurui, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT113SenkyoShikaku.class).
                where(eq(AfT113SenkyoShikaku.senkyoShurui, senkyoShurui)).
                order(by(AfT113SenkyoShikaku.shikibetsuCode)).
                toList(AfT113SenkyoShikakuEntity.class);
    }

    /**
     * 識別コードで選挙資格を取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return List<AfT113SenkyoShikakuEntity>
     */
    @Transaction
    public List<AfT113SenkyoShikakuEntity> select(ShikibetsuCode shikibetsuCode) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT113SenkyoShikaku.class).
                where(eq(AfT113SenkyoShikaku.shikibetsuCode, shikibetsuCode)).
                order(by(AfT113SenkyoShikaku.senkyoShurui)).
                toList(AfT113SenkyoShikakuEntity.class);
    }

    /**
     * 選挙資格を取得します。
     *
     * @return List<AfT113SenkyoShikakuEntity>
     */
    @Transaction
    public List<AfT113SenkyoShikakuEntity> select() {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT113SenkyoShikaku.class).
                order(by(AfT113SenkyoShikaku.shikibetsuCode), by(AfT113SenkyoShikaku.senkyoShurui)).
                toList(AfT113SenkyoShikakuEntity.class);
    }

    /**
     * 選挙資格をDBに登録します。
     *
     * @param entity 選挙資格エンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int insert(AfT113SenkyoShikakuEntity entity) {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * エンティティの複数件登録を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insert(List<AfT113SenkyoShikakuEntity> entities) {
        int count = 0;
        for (AfT113SenkyoShikakuEntity entity : entities) {
            insert(entity);
            count++;
        }
        return count;
    }

    /**
     * 選挙資格の削除データをDBに登録します。
     *
     * @param entity 選挙資格エンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int insertDenialRow(AfT113SenkyoShikakuEntity entity) {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        return accessor.insertDenialRow(entity).execute();
    }

    /**
     * エンティティの複数件削除を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int insertDenialRow(List<AfT113SenkyoShikakuEntity> entities) {
        int count = 0;
        for (AfT113SenkyoShikakuEntity entity : entities) {
            count += insertDenialRow(entity);
        }
        return count;
    }

    /**
     * エンティティの実削除を行います。
     *
     * @param entity 対象のエンティティ
     * @return 削除件数
     */
    @Transaction
    @Override
    public int deletePhysical(AfT113SenkyoShikakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * エンティティの複数件の実削除を行います。<br />
     * 基本的にテストメソッド用です。
     *
     * @param entities 対象のエンティティリスト
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(List<AfT113SenkyoShikakuEntity> entities) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        int count = 0;
        for (AfT113SenkyoShikakuEntity entity : entities) {
            count += accessor.deletePhysical(entity).execute();
        }
        return count;
    }

    /**
     * AfT113SenkyoShikakuEntityを保存します
     *
     * @param entity entity
     * @return 保存件数
     */
    @Transaction
    @Override
    public int save(AfT113SenkyoShikakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
