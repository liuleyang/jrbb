/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204Tohyoroku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 期日前・当日投票録テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT204TohyorokuDac implements IInsertOrUpdatable<AfT204TohyorokuEntity>,
        IDeletable<AfT204TohyorokuEntity>, IPhysicalDeletable<AfT204TohyorokuEntity>, ISaveable<AfT204TohyorokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、投票区コードに該当する、期日前・当日投票録エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @return 該当した期日前・当日投票録エンティティ
     */
    @Transaction
    public AfT204TohyorokuEntity select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, RString tohyokuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT204Tohyoroku.class).
                where(and(eq(AfT204Tohyoroku.shohonNo, shohonNo),
                                eq(AfT204Tohyoroku.senkyoNo, senkyoNo),
                                eq(AfT204Tohyoroku.hokokuYMD, hokokuYMD),
                                eq(AfT204Tohyoroku.shisetsuCode, shisetsuCode),
                                eq(AfT204Tohyoroku.tohyokuCode, tohyokuCode))).
                toObject(AfT204TohyorokuEntity.class);
    }

    /**
     * 指定された抄本番号、報告年月日に該当する、期日前・当日投票録エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param hokokuYMD 報告年月日
     * @return 該当した期日前・当日投票録エンティティリスト
     */
    @Transaction
    public List<AfT204TohyorokuEntity> select(ShohonNo shohonNo, FlexibleDate hokokuYMD) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT204Tohyoroku.class).
                where(and(eq(AfT204Tohyoroku.shohonNo, shohonNo),
                                eq(AfT204Tohyoroku.hokokuYMD, hokokuYMD))).
                order(by(AfT204Tohyoroku.senkyoNo), by(AfT204Tohyoroku.shisetsuCode), by(AfT204Tohyoroku.tohyokuCode)).
                toList(AfT204TohyorokuEntity.class);
    }

    /**
     * 期日前・当日投票録エンティティリストを取得します。
     *
     * @return 該当した期日前・当日投票録エンティティリスト
     */
    @Transaction
    public List<AfT204TohyorokuEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT204Tohyoroku.class).
                order(by(AfT204Tohyoroku.shohonNo), by(AfT204Tohyoroku.senkyoNo), by(AfT204Tohyoroku.hokokuYMD),
                        by(AfT204Tohyoroku.shisetsuCode), by(AfT204Tohyoroku.tohyokuCode)).
                toList(AfT204TohyorokuEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT204TohyorokuEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT204TohyorokuEntity entity) {
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
    public int delete(List<AfT204TohyorokuEntity> entities) {
        int count = 0;
        for (AfT204TohyorokuEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT204TohyorokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT204TohyorokuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT204TohyorokuEntity entity) {
        return (select(entity.getShohonNo(), entity.getSenkyoNo(), entity.getHokokuYMD(),
                entity.getShisetsuCode(), entity.getTohyokuCode()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT204TohyorokuEntity entity) {
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
    public int deletePhysical(List<AfT204TohyorokuEntity> entities) {
        int count = 0;
        for (AfT204TohyorokuEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT204TohyorokuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT204TohyorokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
