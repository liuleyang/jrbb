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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo.kijunYMD;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo.mutohyoSenkyoFlag;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo.senkyoLevel;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo.senkyoNo;
import static jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111Senkyo.shohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.min;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙のデータアクセスクラスです。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class AfT111SenkyoDac implements ISaveable<AfT111SenkyoEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString メッセージ_抄本番号 = new RString("抄本番号");

    /**
     * 主キーで選挙を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public AfT111SenkyoEntity selectByKey(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                eq(senkyoNo, 選挙番号))).
                toObject(AfT111SenkyoEntity.class);
    }

    /**
     * 主キーで選挙を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectBy抄本番号(
            ShohonNo 抄本番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(eq(shohonNo, 抄本番号)).order(by(AfT111Senkyo.senkyoNo)).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * 選挙を全件返します。
     *
     * @return AfT111SenkyoEntityの{@code list}
     */
    @Transaction
    public List<AfT111SenkyoEntity> select最新抄本() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT111Senkyo.class).
                order(by(AfT111Senkyo.kijunYMD)).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * 主キーで選挙を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectBy抄本番号List(
            List<ShohonNo> 抄本番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(in(shohonNo, 抄本番号)).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * 転出期限年月日MINを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> select転出期限年月日MIN(
            ShohonNo 抄本番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(eq(shohonNo, 抄本番号)).order(by(AfT111Senkyo.tenshutsuKigenYMD, Order.ASC)).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * 選挙を全件返します。
     *
     * @return AfT111SenkyoEntityの{@code list}
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(AfT111Senkyo.class).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * AfT111SenkyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(AfT111SenkyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * AfT111SenkyoEntityを削除します。delete処理です。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(AfT111SenkyoEntity entity) {
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
    public int delete(List<AfT111SenkyoEntity> entities) {
        int count = 0;
        for (AfT111SenkyoEntity entity : entities) {
            count += delete(entity);
        }
        return count;
    }

    /**
     * 抄本番号、選挙レベルと基準日で選挙を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙レベル Code
     * @param 基準日 RDate
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectBy抄本番号と選挙レベルと基準日(ShohonNo 抄本番号, Code 選挙レベル, FlexibleDate 基準日)
            throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));
        requireNonNull(選挙レベル, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙レベル"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                eq(senkyoLevel, 選挙レベル),
                                eq(kijunYMD, 基準日))).
                toList(AfT111SenkyoEntity.class);

    }

    /**
     * 選挙情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectBy抄本番号と無投票選挙フラグwithOrder(
            ShohonNo 抄本番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(
                        eq(shohonNo, 抄本番号)
                ).
                order(by(AfT111Senkyo.senkyoNo, Order.ASC)).
                toList(AfT111SenkyoEntity.class);
    }

    /**
     * 選挙情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<AfT111SenkyoEntity> selectBy抄本番号withOrder(
            ShohonNo 抄本番号) throws NullPointerException {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_抄本番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(AfT111Senkyo.class).
                where(and(
                                eq(shohonNo, 抄本番号),
                                eq(mutohyoSenkyoFlag, false)
                        )).
                order(by(AfT111Senkyo.senkyoNo, Order.ASC)).
                toList(AfT111SenkyoEntity.class);
    }
    
   /**
     * 取得したMIN(名簿基準年月日）より、行の最小値を取得する。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     */
    @Transaction
    public AfT111SenkyoEntity selectMinKijunYMDByShohonNo(ShohonNo 抄本番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(min(kijunYMD)).
                table(AfT111Senkyo.class).
                where(eq(shohonNo, 抄本番号)).
                toObject(AfT111SenkyoEntity.class);
    }
}
