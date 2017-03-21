/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票録付随テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT205TohyorokuFuzuiDac implements IInsertOrUpdatable<AfT205TohyorokuFuzuiEntity>,
        IDeletable<AfT205TohyorokuFuzuiEntity>, IPhysicalDeletable<AfT205TohyorokuFuzuiEntity>,
        ISaveable<AfT205TohyorokuFuzuiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定されたプライマリーキーに該当する、投票録付随エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @param komokuShurui 項目種類
     * @param renban 連番
     * @return 該当した投票録付随エンティティ
     */
    @Transaction
    public AfT205TohyorokuFuzuiEntity select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, RString tohyokuCode, Code komokuShurui, int renban) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.shisetsuCode, shisetsuCode),
                                eq(AfT205TohyorokuFuzui.tohyokuCode, tohyokuCode),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui),
                                eq(AfT205TohyorokuFuzui.renban, renban))).
                toObject(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号、報告年月日に該当する、投票録付随エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param hokokuYMD 報告年月日
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> select(ShohonNo shohonNo, FlexibleDate hokokuYMD) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD))).
                order(by(AfT205TohyorokuFuzui.senkyoNo), by(AfT205TohyorokuFuzui.shisetsuCode), by(AfT205TohyorokuFuzui.tohyokuCode),
                        by(AfT205TohyorokuFuzui.komokuShurui), by(AfT205TohyorokuFuzui.renban)).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 投票録付随エンティティリストを取得します。
     *
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                order(by(AfT205TohyorokuFuzui.shohonNo), by(AfT205TohyorokuFuzui.senkyoNo), by(AfT205TohyorokuFuzui.hokokuYMD),
                        by(AfT205TohyorokuFuzui.shisetsuCode), by(AfT205TohyorokuFuzui.tohyokuCode),
                        by(AfT205TohyorokuFuzui.komokuShurui), by(AfT205TohyorokuFuzui.renban)).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT205TohyorokuFuzuiEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT205TohyorokuFuzuiEntity entity) {
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
    public int delete(List<AfT205TohyorokuFuzuiEntity> entities) {
        int count = 0;
        for (AfT205TohyorokuFuzuiEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT205TohyorokuFuzuiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT205TohyorokuFuzuiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT205TohyorokuFuzuiEntity entity) {
        return (select(entity.getShohonNo(), entity.getSenkyoNo(), entity.getHokokuYMD(), entity.getShisetsuCode(),
                entity.getTohyokuCode(), entity.getKomokuShurui(), entity.getRenban()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT205TohyorokuFuzuiEntity entity) {
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
    public int deletePhysical(List<AfT205TohyorokuFuzuiEntity> entities) {
        int count = 0;
        for (AfT205TohyorokuFuzuiEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、投票録項目種類に該当する、投票録付随エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param komokuShurui 項目種類
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> selectByShisetsuCode(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.shisetsuCode, shisetsuCode),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui))).
                order(by(AfT205TohyorokuFuzui.shimei)).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、投票区コード、投票録項目種類に該当する、投票録付随エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param tohyokuCode 投票区コード
     * @param komokuShurui 項目種類
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> selectByTohyokuCode(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString tohyokuCode, Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.tohyokuCode, tohyokuCode),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui))).
                order(by(AfT205TohyorokuFuzui.shimei)).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、投票録項目種類に該当する、投票録付随エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui))).
                order(by(AfT205TohyorokuFuzui.shimei)).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、投票区コード、投票録項目種類に該当する、ソート後、投票録付随エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @param komokuShurui 投票録項目種類
     * @param orderName order項目
     * @param orderAsc order順
     * @return 該当した投票録付随エンティティリスト
     */
    @Transaction
    public List<AfT205TohyorokuFuzuiEntity> selectWithOrderBy(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, RString tohyokuCode, Code komokuShurui, List<AfT205TohyorokuFuzui> orderName, List<Order> orderAsc) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<OrderBy> orderByList = new ArrayList();
        for (int i = 0; i < orderName.size(); i++) {
            orderByList.add(by(orderName.get(i), orderAsc.get(i)));
        }

        return accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.shisetsuCode, shisetsuCode),
                                eq(AfT205TohyorokuFuzui.tohyokuCode, tohyokuCode),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui))).
                //CHECKSTYLE IGNORE IllegalToken FOR NEXT 1 LINES
                order(orderByList.toArray(new OrderBy[orderByList.size()])).
                toList(AfT205TohyorokuFuzuiEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、投票区コード、投票録項目種類に該当する、ソート後、MAX連番を取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @param komokuShurui 投票録項目種類
     * @return MAX連番
     */
    @Transaction
    public int selectMaxRenban(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, RString tohyokuCode, Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<AfT205TohyorokuFuzuiEntity> resultList
                = accessor.
                select().
                table(AfT205TohyorokuFuzui.class).
                where(and(eq(AfT205TohyorokuFuzui.shohonNo, shohonNo),
                                eq(AfT205TohyorokuFuzui.senkyoNo, senkyoNo),
                                eq(AfT205TohyorokuFuzui.hokokuYMD, hokokuYMD),
                                eq(AfT205TohyorokuFuzui.shisetsuCode, shisetsuCode),
                                eq(AfT205TohyorokuFuzui.tohyokuCode, tohyokuCode),
                                eq(AfT205TohyorokuFuzui.komokuShurui, komokuShurui))).
                order(by(AfT205TohyorokuFuzui.renban, Order.DESC)).
                toList(AfT205TohyorokuFuzuiEntity.class);
        return (null == resultList || resultList.isEmpty()) ? 0 : resultList.get(0).getRenban();
    }

    /**
     * AfT205TohyorokuFuzuiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT205TohyorokuFuzuiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録付随エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
