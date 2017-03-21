/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeibo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeibo.gyo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeibo.page;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外選挙人名簿のデータアクセスクラスです。
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public class AfT121ZaigaiSenkyoninMeiboDac
        implements IInsertOrUpdatable<AfT121ZaigaiSenkyoninMeiboEntity>, IDeletable<AfT121ZaigaiSenkyoninMeiboEntity>,
        IPhysicalDeletable<AfT121ZaigaiSenkyoninMeiboEntity>, ISaveable<AfT121ZaigaiSenkyoninMeiboEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで在外選挙人名簿を取得します。
     *
     * @param shohonNo ShohonNo
     * @param groupCode GroupCode
     * @param tohyokuCode TohyokuCode
     * @param kokugaiBunruiCode KokugaiBunruiCode
     * @param satsu Satsu
     * @param page Page
     * @param gyo Gyo
     * @return AfT121ZaigaiSenkyoninMeiboEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT121ZaigaiSenkyoninMeiboEntity select(
            ShohonNo shohonNo,
            RString groupCode,
            RString tohyokuCode,
            RString kokugaiBunruiCode,
            RString satsu,
            int page,
            int gyo) throws NullPointerException {
        requireNonNull(shohonNo, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(groupCode, UrSystemErrorMessages.値がnull.getReplacedMessage("グループコード"));
        requireNonNull(tohyokuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(kokugaiBunruiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("国外分類コード"));
        requireNonNull(satsu, UrSystemErrorMessages.値がnull.getReplacedMessage("冊"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(and(
                                eq(AfT121ZaigaiSenkyoninMeibo.shohonNo, shohonNo),
                                eq(AfT121ZaigaiSenkyoninMeibo.groupCode, groupCode),
                                eq(AfT121ZaigaiSenkyoninMeibo.tohyokuCode, tohyokuCode),
                                eq(AfT121ZaigaiSenkyoninMeibo.kokugaiBunruiCode, kokugaiBunruiCode),
                                eq(AfT121ZaigaiSenkyoninMeibo.satsu, satsu),
                                eq(AfT121ZaigaiSenkyoninMeibo.page, page),
                                eq(AfT121ZaigaiSenkyoninMeibo.gyo, gyo))).
                toObject(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 指定された抄本番号に該当する在外選挙人名簿エンティティを返します。
     *
     * @param shohonNo ShohonNo
     * @return List<AfT121ZaigaiSenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT121ZaigaiSenkyoninMeiboEntity> select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(eq(AfT121ZaigaiSenkyoninMeibo.shohonNo, shohonNo)).
                order(by(AfT121ZaigaiSenkyoninMeibo.groupCode),
                        by(AfT121ZaigaiSenkyoninMeibo.tohyokuCode),
                        by(AfT121ZaigaiSenkyoninMeibo.kokugaiBunruiCode),
                        by(AfT121ZaigaiSenkyoninMeibo.satsu),
                        by(AfT121ZaigaiSenkyoninMeibo.page),
                        by(AfT121ZaigaiSenkyoninMeibo.gyo)).
                toList(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @return List<AfT121ZaigaiSenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT121ZaigaiSenkyoninMeiboEntity> selectByShohonNoAndShikibetsuCode(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(and(eq(AfT121ZaigaiSenkyoninMeibo.shohonNo, shohonNo),
                                eq(AfT121ZaigaiSenkyoninMeibo.shikibetsuCode, shikibetsuCode))).
                order(by(AfT121ZaigaiSenkyoninMeibo.groupCode),
                        by(AfT121ZaigaiSenkyoninMeibo.tohyokuCode),
                        by(AfT121ZaigaiSenkyoninMeibo.kokugaiBunruiCode),
                        by(AfT121ZaigaiSenkyoninMeibo.satsu),
                        by(AfT121ZaigaiSenkyoninMeibo.page),
                        by(AfT121ZaigaiSenkyoninMeibo.gyo)).
                toList(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 在外選挙人名簿エンティティを返します。
     *
     * @return List<AfT121ZaigaiSenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT121ZaigaiSenkyoninMeiboEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                order(by(AfT121ZaigaiSenkyoninMeibo.shohonNo),
                        by(AfT121ZaigaiSenkyoninMeibo.shikibetsuCode)).
                toList(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    /**
     * エンティティの複数件登録、更新を行います。
     *
     * @param entities 対象のエンティティリスト
     * @return 処理件数
     */
    @Transaction
    public int insertOrUpdate(List<AfT121ZaigaiSenkyoninMeiboEntity> entities) {
        int count = 0;
        for (AfT121ZaigaiSenkyoninMeiboEntity entity : entities) {
            count += insertOrUpdate(entity);
        }
        return count;
    }

    @Override
    @Transaction
    public int delete(AfT121ZaigaiSenkyoninMeiboEntity entity) {
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
    public int delete(List<AfT121ZaigaiSenkyoninMeiboEntity> entities) {
        int count = 0;
        for (AfT121ZaigaiSenkyoninMeiboEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    @Transaction
    private int insert(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    private int update(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        return (select(entity.getShohonNo(), entity.getGroupCode(), entity.getTohyokuCode(), entity.getKokugaiBunruiCode(),
                entity.getSatsu(), entity.getPage(), entity.getGyo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT121ZaigaiSenkyoninMeiboEntity entity) {
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
    public int deletePhysical(List<AfT121ZaigaiSenkyoninMeiboEntity> entities) {
        int count = 0;
        for (AfT121ZaigaiSenkyoninMeiboEntity entity : entities) {
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
    public int save(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("在外選挙人名簿エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指定された抄本番号、投票区コード、国外分類コードに頁の最大値を取得する。
     *
     * @param shohonNo ShohonNo
     * @param tohyokuCode RString
     * @param kokugaiBunruiCode RString
     * @return AfT121ZaigaiSenkyoninMeiboEntity
     */
    @Transaction
    public AfT121ZaigaiSenkyoninMeiboEntity selectMaxPage(ShohonNo shohonNo, RString tohyokuCode, RString kokugaiBunruiCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(page)).
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(and(eq(AfT121ZaigaiSenkyoninMeibo.shohonNo, shohonNo),
                                eq(AfT121ZaigaiSenkyoninMeibo.tohyokuCode, tohyokuCode),
                                eq(AfT121ZaigaiSenkyoninMeibo.kokugaiBunruiCode, kokugaiBunruiCode))).
                toObject(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 取得したMAX(在外選挙人名簿．頁）より、行の最大値を取得する。
     *
     * @param page int
     * @return AfT121ZaigaiSenkyoninMeiboEntity
     */
    @Transaction
    public AfT121ZaigaiSenkyoninMeiboEntity selectMaxGyo(int page) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(gyo)).
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(eq(AfT121ZaigaiSenkyoninMeibo.page, page)).
                toObject(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @return List<AfT121ZaigaiSenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT121ZaigaiSenkyoninMeiboEntity> selectViewByShohonNoAndShikibetsuCode(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(and(eq(AfT121ZaigaiSenkyoninMeibo.shohonNo, shohonNo),
                                eq(AfT121ZaigaiSenkyoninMeibo.shikibetsuCode, shikibetsuCode))).
                toList(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return List<AfT121ZaigaiSenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT121ZaigaiSenkyoninMeiboEntity> selectViewByShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT121ZaigaiSenkyoninMeibo.class).
                where(eq(AfT121ZaigaiSenkyoninMeibo.shikibetsuCode, shikibetsuCode)).
                order(by(AfT121ZaigaiSenkyoninMeibo.shohonNo, Order.DESC)).
                toList(AfT121ZaigaiSenkyoninMeiboEntity.class);
    }
}
