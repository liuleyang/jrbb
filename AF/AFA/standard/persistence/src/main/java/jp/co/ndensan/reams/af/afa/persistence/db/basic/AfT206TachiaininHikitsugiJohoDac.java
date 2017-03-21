/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJoho;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.IDeletable;
import jp.co.ndensan.reams.af.afa.persistence.IInsertOrUpdatable;
import jp.co.ndensan.reams.af.afa.persistence.IPhysicalDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 立会人引継テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public class AfT206TachiaininHikitsugiJohoDac implements IInsertOrUpdatable<AfT206TachiaininHikitsugiJohoEntity>,
        IDeletable<AfT206TachiaininHikitsugiJohoEntity>, IPhysicalDeletable<AfT206TachiaininHikitsugiJohoEntity>,
        ISaveable<AfT206TachiaininHikitsugiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定されたプライマリーキーに該当する、立会人引継エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @param komokuShurui 項目種類
     * @param tachiaininRenban 立会人連番
     * @param renban 連番
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public AfT206TachiaininHikitsugiJohoEntity select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, RString tohyokuCode, Code komokuShurui, int tachiaininRenban, int renban) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                eq(AfT206TachiaininHikitsugiJoho.tohyokuCode, tohyokuCode),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                eq(AfT206TachiaininHikitsugiJoho.tachiaininRenban, tachiaininRenban),
                                eq(AfT206TachiaininHikitsugiJoho.renban, renban))).
                toObject(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された抄本番号、報告年月日に該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param hokokuYMD 報告年月日
     * @return 該当した立会人引継エンティティリスト
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, FlexibleDate hokokuYMD) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD))).
                order(by(AfT206TachiaininHikitsugiJoho.senkyoNo),
                        by(AfT206TachiaininHikitsugiJoho.shisetsuCode),
                        by(AfT206TachiaininHikitsugiJoho.tohyokuCode),
                        by(AfT206TachiaininHikitsugiJoho.komokuShurui),
                        by(AfT206TachiaininHikitsugiJoho.tachiaininRenban),
                        by(AfT206TachiaininHikitsugiJoho.renban)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 立会人引継エンティティリストを取得します。
     *
     * @return 該当した立会人引継エンティティリスト
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                order(by(AfT206TachiaininHikitsugiJoho.shohonNo),
                        by(AfT206TachiaininHikitsugiJoho.senkyoNo),
                        by(AfT206TachiaininHikitsugiJoho.hokokuYMD),
                        by(AfT206TachiaininHikitsugiJoho.shisetsuCode),
                        by(AfT206TachiaininHikitsugiJoho.tohyokuCode),
                        by(AfT206TachiaininHikitsugiJoho.komokuShurui),
                        by(AfT206TachiaininHikitsugiJoho.tachiaininRenban),
                        by(AfT206TachiaininHikitsugiJoho.renban)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    @Override
    @Transaction
    public int insertOrUpdate(AfT206TachiaininHikitsugiJohoEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT206TachiaininHikitsugiJohoEntity entity) {
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
    public int delete(List<AfT206TachiaininHikitsugiJohoEntity> entities) {
        int count = 0;
        for (AfT206TachiaininHikitsugiJohoEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT206TachiaininHikitsugiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT206TachiaininHikitsugiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT206TachiaininHikitsugiJohoEntity entity) {
        return (select(entity.getShohonNo(), entity.getSenkyoNo(), entity.getHokokuYMD(), entity.getShisetsuCode(),
                entity.getTohyokuCode(), entity.getKomokuShurui(), entity.getTachiaininRenban(), entity.getRenban()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT206TachiaininHikitsugiJohoEntity entity) {
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
    public int deletePhysical(List<AfT206TachiaininHikitsugiJohoEntity> entities) {
        int count = 0;
        for (AfT206TachiaininHikitsugiJohoEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、項目種類に該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param komokuShurui 項目種類
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui))).
                order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、項目種類に該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui))).
                order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、施設コード、項目種類、立会人連番に該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param shisetsuCode 施設コード
     * @param komokuShurui 項目種類
     * @param tachiaininRenban 立会人連番
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            RString shisetsuCode, Code komokuShurui, RString tachiaininRenban) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        if (null == tachiaininRenban || tachiaininRenban.isEmpty()) {
            return accessor.
                    select().
                    table(AfT206TachiaininHikitsugiJoho.class).
                    where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                    eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                    eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                    eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                    eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui))).
                    order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                    toList(AfT206TachiaininHikitsugiJohoEntity.class);
        } else {
            return accessor.
                    select().
                    table(AfT206TachiaininHikitsugiJoho.class).
                    where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                    eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                    eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                    eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                    eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                    eq(AfT206TachiaininHikitsugiJoho.tachiaininRenban,
                                            Integer.valueOf(tachiaininRenban.toString())))).
                    order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                    toList(AfT206TachiaininHikitsugiJohoEntity.class);
        }

    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、項目種類、立会人連番に該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @param tachiaininRenban 立会人連番
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui, RString tachiaininRenban) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        if (null == tachiaininRenban || tachiaininRenban.isEmpty()) {
            return accessor.
                    select().
                    table(AfT206TachiaininHikitsugiJoho.class).
                    where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                    eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                    eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                    eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui))).
                    order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                    toList(AfT206TachiaininHikitsugiJohoEntity.class);
        } else {
            return accessor.
                    select().
                    table(AfT206TachiaininHikitsugiJoho.class).
                    where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                    eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                    eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                    eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                    eq(AfT206TachiaininHikitsugiJoho.tachiaininRenban,
                                            Integer.valueOf(tachiaininRenban.toString())))).
                    order(by(AfT206TachiaininHikitsugiJoho.shimei)).
                    toList(AfT206TachiaininHikitsugiJohoEntity.class);
        }
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、項目種類、施設コード、投票区コードに該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @param shisetsuCode 施設コード
     * @param tohyokuCode 投票区コード
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui, RString shisetsuCode, RString tohyokuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                eq(AfT206TachiaininHikitsugiJoho.tohyokuCode, tohyokuCode))).
                order(by(AfT206TachiaininHikitsugiJoho.renban)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、項目種類、施設コードに該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @param shisetsuCode 施設コード
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select投票立会人情報(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui, RString shisetsuCode) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode))).
                order(by(AfT206TachiaininHikitsugiJoho.renban)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された抄本番号、選挙番号、報告年月日、項目種類、施設コードに該当する、立会人引継エンティティリストを取得します。
     *
     * @param shohonNo 抄本番号
     * @param senkyoNo 選挙番号
     * @param hokokuYMD 報告年月日
     * @param komokuShurui 項目種類
     * @param shisetsuCode 施設コード
     * @param tachiaininRenban 立会人連番
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public List<AfT206TachiaininHikitsugiJohoEntity> select投票用紙再交付者情報(ShohonNo shohonNo, SenkyoNo senkyoNo, FlexibleDate hokokuYMD,
            Code komokuShurui, RString shisetsuCode, int tachiaininRenban) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT206TachiaininHikitsugiJoho.class).
                where(and(eq(AfT206TachiaininHikitsugiJoho.shohonNo, shohonNo),
                                eq(AfT206TachiaininHikitsugiJoho.senkyoNo, senkyoNo),
                                eq(AfT206TachiaininHikitsugiJoho.hokokuYMD, hokokuYMD),
                                eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui),
                                eq(AfT206TachiaininHikitsugiJoho.shisetsuCode, shisetsuCode),
                                eq(AfT206TachiaininHikitsugiJoho.tachiaininRenban, tachiaininRenban))).
                order(by(AfT206TachiaininHikitsugiJoho.renban),
                        by(AfT206TachiaininHikitsugiJoho.shimei)).
                toList(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された投票録項目種類に該当する、MAX連番を取得します。
     *
     * @param komokuShurui 項目種類
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public AfT206TachiaininHikitsugiJohoEntity selectMAX立会人連番(Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                selectSpecific(max(AfT206TachiaininHikitsugiJoho.tachiaininRenban)).
                table(AfT206TachiaininHikitsugiJoho.class).
                where(eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui)).
                toObject(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * 指定された投票録項目種類に該当する、MAX連番を取得します。
     *
     * @param komokuShurui 項目種類
     * @return 該当した立会人引継エンティティ
     */
    @Transaction
    public AfT206TachiaininHikitsugiJohoEntity selectMAX連番(Code komokuShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                selectSpecific(max(AfT206TachiaininHikitsugiJoho.renban)).
                table(AfT206TachiaininHikitsugiJoho.class).
                where(eq(AfT206TachiaininHikitsugiJoho.komokuShurui, komokuShurui)).
                toObject(AfT206TachiaininHikitsugiJohoEntity.class);
    }

    /**
     * エンティティを登録します。
     *
     * @param entity 対象のエンティティ
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT206TachiaininHikitsugiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人引継エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
