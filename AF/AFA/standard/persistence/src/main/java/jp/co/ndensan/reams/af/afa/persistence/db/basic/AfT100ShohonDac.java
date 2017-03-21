/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100Shohon;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 抄本テーブルへのデータアクセスを提供する実装クラスです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class AfT100ShohonDac implements IInsertOrUpdatable<AfT100ShohonEntity>,
        IDeletable<AfT100ShohonEntity>, IPhysicalDeletable<AfT100ShohonEntity>, ISaveable<AfT100ShohonEntity> {

    @InjectSession
    private SqlSession session;

    private static final int 境界番号 = 10000;

    /**
     * 指定された抄本番号に該当する、抄本エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した抄本エンティティ
     */
    @Transaction
    public AfT100ShohonEntity select(ShohonNo shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(eq(AfT100Shohon.shohonNo, shohonNo)).
                toObject(AfT100ShohonEntity.class);
    }

    /**
     * 指定された抄本番号に該当する、抄本エンティティを取得します。
     *
     * @param shohonNo 抄本番号
     * @return 該当した抄本エンティティ
     */
    @Transaction
    public AfT100ShohonEntity selectBy抄本番号List(List<ShohonNo> shohonNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(in(AfT100Shohon.shohonNo, shohonNo)).
                toObject(AfT100ShohonEntity.class);
    }

    /**
     * 指定された選挙種類に該当する、抄本エンティティリストを取得します。<br />
     * For本番用
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> select(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(and(eq(AfT100Shohon.senkyoShurui, senkyoShurui),
                                lt(AfT100Shohon.shohonNo, 境界番号))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * 指定された基準日以降の投票日に該当する、抄本エンティティを取得します。<br />
     * 全件取得したい場合は、基準日にRDate.Minを指定します。<br />
     * 定時登録は含みません。<br />
     * For本番用
     *
     * @param kijunYmd 基準日
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> select(FlexibleDate kijunYmd) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(and(leq(kijunYmd, AfT100Shohon.tohyoYMD),
                                not(eq(AfT100Shohon.senkyoShurui, SenkyoShurui.定時登録.getCode())),
                                lt(AfT100Shohon.shohonNo, 境界番号))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * 指定された基準日以降の投票日に該当する、抄本エンティティを取得します。<br />
     * 全件取得したい場合は、基準日にRDate.Minを指定します。<br />
     * 定時登録は含みません。<br />
     * For本番用
     *
     * @param isシミュレーション Boolean
     * @param is投票受付メニュー Boolean
     * @param has選挙種類 Boolean
     * @param chkKakoShohon Boolean
     * @param isChecked Boolean
     * @param kijunYmd FlexibleDate
     * @param senkyoShurui RString
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> select(Boolean isシミュレーション, Boolean is投票受付メニュー, Boolean has選挙種類, Boolean chkKakoShohon,
            Boolean isChecked, FlexibleDate kijunYmd, RString senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(
                        and(
                                (chkKakoShohon ? lt(AfT100Shohon.tohyoYMD, kijunYmd)
                                : (isChecked ? eq(AfT100Shohon.tohyoYMD, AfT100Shohon.tohyoYMD) : leq(kijunYmd, AfT100Shohon.tohyoYMD))),
                                (has選挙種類 ? eq(AfT100Shohon.senkyoShurui, senkyoShurui) : eq(AfT100Shohon.tohyoYMD, AfT100Shohon.tohyoYMD)),
                                (is投票受付メニュー ? not(eq(AfT100Shohon.senkyoShurui, new RString("0")))
                                : eq(AfT100Shohon.tohyoYMD, AfT100Shohon.tohyoYMD)),
                                (isシミュレーション ? leq(境界番号, AfT100Shohon.shohonNo) : lt(AfT100Shohon.shohonNo, 境界番号)))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * 指定された基準日以降の投票日に該当する、抄本エンティティを取得します。<br />
     * 全件取得したい場合は、基準日にRDate.Minを指定します。<br />
     * 定時登録は含みません。<br />
     * For本番用
     *
     * @param isシミュレーション Boolean
     * @param has選挙種類 Boolean
     * @param is投票受付メニュー Boolean
     * @param is全件 Boolean
     * @param kijunYmd FlexibleDate
     * @param senkyoShurui RString
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> select(Boolean isシミュレーション, Boolean is投票受付メニュー, Boolean has選挙種類,
            FlexibleDate kijunYmd, RString senkyoShurui, Boolean is全件) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(
                        and((isシミュレーション ? leq(境界番号, AfT100Shohon.shohonNo) : lt(AfT100Shohon.shohonNo, 境界番号)),
                                (has選挙種類 ? eq(AfT100Shohon.senkyoShurui, senkyoShurui) : eq(AfT100Shohon.tohyoYMD, AfT100Shohon.tohyoYMD)),
                                (is投票受付メニュー ? not(eq(AfT100Shohon.senkyoShurui, new RString("0"))) : eq(AfT100Shohon.tohyoYMD,
                                        AfT100Shohon.tohyoYMD)),
                                (is全件 ? eq(AfT100Shohon.tohyoYMD, AfT100Shohon.tohyoYMD) : leq(kijunYmd, AfT100Shohon.tohyoYMD)))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * 抄本エンティティ全件を取得します。<br />
     * 基本的に、テストクラスで使用するだけの想定。
     *
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * システム日付以上の投票日全件を取得します。<br />
     *
     * @return 該当した投票日リスト
     */
    @Transaction
    public List<AfT100ShohonEntity> selectシステム日付以上の投票日() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                selectSpecific(AfT100Shohon.tohyoYMD)
                .table(AfT100Shohon.class)
                .where(leq(FlexibleDate.getNowDate(), AfT100Shohon.tohyoYMD))
                .groupBy(AfT100Shohon.tohyoYMD)
                .order(by(AfT100Shohon.tohyoYMD))
                .toList(AfT100ShohonEntity.class);
    }

    /**
     * 抄本エンティティ全件を取得します。<br />
     * 基本的に、テストクラスで使用するだけの想定。
     *
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> selectFor選挙登録有無チェック() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(and(leq(FlexibleDate.getNowDate(), AfT100Shohon.tohyoYMD),
                                eq(AfT100Shohon.senkyoShurui, SenkyoShurui.国政選挙_地方選挙.getCode()))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

//<editor-fold defaultstate="collapsed" desc="SelectForSimulation">
    /**
     * 指定された選挙種類に該当する、抄本エンティティリストを取得します。<br />
     * Forシミュレーション用
     *
     * @param senkyoShurui 選挙種類
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> selectForSimulation(Code senkyoShurui) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(and(eq(AfT100Shohon.senkyoShurui, senkyoShurui),
                                leq(境界番号, AfT100Shohon.shohonNo))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }

    /**
     * 指定された基準日以降の投票日に該当する、抄本エンティティを取得します。<br />
     * 全件取得したい場合は、基準日にRDate.Minを指定します。<br />
     * 定時登録は含みません。<br />
     * Forシミュレーション用
     *
     * @param kijunYmd 基準日
     * @return 該当した抄本エンティティリスト
     */
    @Transaction
    public List<AfT100ShohonEntity> selectForSimulation(FlexibleDate kijunYmd) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(AfT100Shohon.class).
                where(and(leq(kijunYmd, AfT100Shohon.tohyoYMD),
                                not(eq(AfT100Shohon.senkyoShurui, SenkyoShurui.定時登録.getCode())),
                                leq(境界番号, AfT100Shohon.shohonNo))).
                order(by(AfT100Shohon.tohyoYMD, Order.DESC), by(AfT100Shohon.senkyoShurui), by(AfT100Shohon.shohonNo)).
                toList(AfT100ShohonEntity.class);
    }
//</editor-fold>

    @Override
    @Transaction
    public int insertOrUpdate(AfT100ShohonEntity entity) {
        return exists(entity) ? update(entity) : insert(entity);
    }

    @Override
    @Transaction
    public int delete(AfT100ShohonEntity entity) {
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
    public int delete(List<AfT100ShohonEntity> entities) {
        int count = 0;
        for (AfT100ShohonEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    private int insert(AfT100ShohonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    private int update(AfT100ShohonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    private boolean exists(AfT100ShohonEntity entity) {
        return (select(entity.getShohonNo()) != null);
    }

    @Override
    @Transaction
    public int deletePhysical(AfT100ShohonEntity entity) {
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
    public int deletePhysical(List<AfT100ShohonEntity> entities) {
        int count = 0;
        for (AfT100ShohonEntity entity : entities) {
            count += deletePhysical(entity);
        }
        return count;
    }

    /**
     * AfT100ShohonEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT100ShohonEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
