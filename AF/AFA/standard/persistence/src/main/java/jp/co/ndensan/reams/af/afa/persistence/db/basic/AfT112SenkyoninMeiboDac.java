/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.persistence.IInsertableForAddType;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * 選挙人名簿のデータアクセスクラスの実装クラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class AfT112SenkyoninMeiboDac implements IInsertableForAddType<AfT112SenkyoninMeiboEntity>,
        IPhysicalDeletable<AfT112SenkyoninMeiboEntity>, ISaveable<AfT112SenkyoninMeiboEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString メッセージ_抄本番号 = new RString("抄本番号");

    /**
     * 主キーで選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param グループコード グループコード
     * @param 投票区コード 投票区コード
     * @param 冊 冊
     * @param 頁 頁
     * @param 行 行
     * @return AfT112SenkyoninMeiboEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT112SenkyoninMeiboEntity select(
            ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));
        requireNonNull(グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("グループコード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(冊, UrSystemErrorMessages.値がnull.getReplacedMessage("冊"));
        requireNonNull(頁, UrSystemErrorMessages.値がnull.getReplacedMessage("頁"));
        requireNonNull(行, UrSystemErrorMessages.値がnull.getReplacedMessage("行"));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                eq(AfT112SenkyoninMeibo.groupCode, グループコード),
                                eq(AfT112SenkyoninMeibo.tohyokuCode, 投票区コード),
                                eq(AfT112SenkyoninMeibo.satsu, 冊),
                                eq(AfT112SenkyoninMeibo.page, 頁),
                                eq(AfT112SenkyoninMeibo.gyo, 行))).
                toObject(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 次のページがあるかどうかを取得します。
     *
     * @param 抄本番号 抄本番号
     * @param グループコード グループコード
     * @param 投票区コード 投票区コード
     * @param 冊 冊
     * @param 頁 Decimal
     * @return 検索結果 List<AfT112SenkyoninMeiboEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> selectNextPage(
            ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            Decimal 頁
    ) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(頁, UrSystemErrorMessages.値がnull.getReplacedMessage("頁"));
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        Decimal 次ページ = new Decimal(頁.intValue() + 1);
        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                (グループコード != null ? eq(AfT112SenkyoninMeibo.groupCode, グループコード)
                                : eq(AfT112SenkyoninMeibo.groupCode, AfT112SenkyoninMeibo.groupCode)),
                                eq(AfT112SenkyoninMeibo.tohyokuCode, 投票区コード),
                                (冊 != null ? eq(AfT112SenkyoninMeibo.satsu, 冊) : eq(AfT112SenkyoninMeibo.satsu, AfT112SenkyoninMeibo.satsu)),
                                eq(AfT112SenkyoninMeibo.page, 次ページ))).
                order(new OrderBy(AfT112SenkyoninMeibo.page, Order.DESC, NullsOrder.LAST)).
                toList(AfT112SenkyoninMeiboEntity.class);

    }

    /**
     * 指定した抄本番号の選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @return List<AfT112SenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> select(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号)).
                toList(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 選択した抄本内のMAX連番を取得します。
     *
     * @param 抄本番号 抄本番号
     * @return 選択した抄本内のMAX連番 int
     */
    @Transaction
    public int selectMaxRenbanWithShohonNo(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号)).
                order(new OrderBy(AfT112SenkyoninMeibo.renban, Order.DESC, NullsOrder.LAST)).
                toList(AfT112SenkyoninMeiboEntity.class).
                get(0).getRenban();
    }

    /**
     * 指定した抄本番号、識別コードの選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @return AfT112SenkyoninMeiboEntity
     */
    @Transaction
    public AfT112SenkyoninMeiboEntity select(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                eq(AfT112SenkyoninMeibo.shikibetsuCode, 識別コード))).
                toObject(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 指定した抄本番号、識別コードの選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param massh massh
     * @return AfT112SenkyoninMeiboEntity
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> selectWithOrder(ShohonNo 抄本番号, ShikibetsuCode 識別コード, boolean massh) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);
        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                eq(AfT112SenkyoninMeibo.tohyokuHenkoMasshoFlag, massh),
                                eq(AfT112SenkyoninMeibo.shikibetsuCode, 識別コード)
                        )).
                order(new OrderBy(AfT112SenkyoninMeibo.seq, Order.DESC, NullsOrder.FIRST)).
                toList(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 指定した抄本番号、投票区コード、識別コードの選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param massh massh
     * @param 投票区コード 投票区コード
     * @return AfT112SenkyoninMeiboEntity
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> selectByTohyokuCodeWithOrder(ShohonNo 抄本番号, ShikibetsuCode 識別コード, boolean massh,
            RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                eq(AfT112SenkyoninMeibo.shikibetsuCode, 識別コード),
                                eq(AfT112SenkyoninMeibo.tohyokuHenkoMasshoFlag, massh),
                                eq(AfT112SenkyoninMeibo.tohyokuCode, 投票区コード))).
                order(new OrderBy(AfT112SenkyoninMeibo.seq, Order.DESC, NullsOrder.FIRST)).
                toList(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 指定した抄本番号、投票区コード、識別コードの選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param massh massh
     * @param 投票区コード 投票区コード
     * @param seq seq
     * @return AfT112SenkyoninMeiboEntity
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> selectByTohyokuCodeWithSEQ(ShohonNo 抄本番号, ShikibetsuCode 識別コード, boolean massh,
            RString 投票区コード, BigSerial seq) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                where(and(
                                eq(AfT112SenkyoninMeibo.shohonNo, 抄本番号),
                                eq(AfT112SenkyoninMeibo.shikibetsuCode, 識別コード),
                                eq(AfT112SenkyoninMeibo.tohyokuHenkoMasshoFlag, massh),
                                eq(AfT112SenkyoninMeibo.tohyokuCode, 投票区コード),
                                eq(AfT112SenkyoninMeibo.seq, seq))).
                toList(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 選挙人名簿を取得します。
     *
     * @return List<AfT112SenkyoninMeiboEntity>
     */
    @Transaction
    public List<AfT112SenkyoninMeiboEntity> select() {
        DbAccessorForAppendType accessor = new DbAccessorForAppendType(session);

        return accessor.select().
                table(AfT112SenkyoninMeibo.class).
                order(by(AfT112SenkyoninMeibo.shohonNo), by(AfT112SenkyoninMeibo.shikibetsuCode)).
                toList(AfT112SenkyoninMeiboEntity.class);
    }

    /**
     * 選挙人名簿をDBに登録します。
     *
     * @param entity 選挙人名簿エンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int insert(AfT112SenkyoninMeiboEntity entity) {
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
    public int insert(List<AfT112SenkyoninMeiboEntity> entities) {
        int count = 0;
        for (AfT112SenkyoninMeiboEntity entity : entities) {
            insert(entity);
            count++;
        }
        return count;
    }

    /**
     * 選挙人名簿の削除データをDBに登録します。
     *
     * @param entity 選挙人名簿エンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int insertDenialRow(AfT112SenkyoninMeiboEntity entity) {
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
    public int insertDenialRow(List<AfT112SenkyoninMeiboEntity> entities) {
        int count = 0;
        for (AfT112SenkyoninMeiboEntity entity : entities) {
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
    public int deletePhysical(AfT112SenkyoninMeiboEntity entity) {
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
    public int deletePhysical(List<AfT112SenkyoninMeiboEntity> entities) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        int count = 0;
        for (AfT112SenkyoninMeiboEntity entity : entities) {
            count += accessor.deletePhysical(entity).execute();
        }
        return count;
    }

    /**
     * AfT112SenkyoninMeiboEntityを保存します
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT112SenkyoninMeiboEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿エンティティ"));
        return DbAccessors.saveBy(new DbAccessorForAppendType(session), entity);
    }
}
